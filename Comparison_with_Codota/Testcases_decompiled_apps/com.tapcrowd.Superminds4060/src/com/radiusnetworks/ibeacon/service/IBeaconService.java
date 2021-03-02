package com.radiusnetworks.ibeacon.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconManager;
import com.radiusnetworks.ibeacon.Region;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class IBeaconService extends Service {
    public static final int MSG_SET_SCAN_PERIODS = 6;
    public static final int MSG_START_MONITORING = 4;
    public static final int MSG_START_RANGING = 2;
    public static final int MSG_STOP_MONITORING = 5;
    public static final int MSG_STOP_RANGING = 3;
    public static final String TAG = "IBeaconService";
    private long betweenScanPeriod = 0;
    private int bindCount = 0;
    private BluetoothAdapter bluetoothAdapter;
    private Handler handler = new Handler();
    private Date lastIBeaconDetectionTime = new Date();
    private long lastScanEndTime = 0;
    private long lastScanStartTime = 0;
    private Object leScanCallback;
    final Messenger mMessenger = new Messenger(new IncomingHandler(this));
    private Map<Region, MonitorState> monitoredRegionState = new HashMap();
    private long nextScanStartTime = 0;
    private int ongoing_notification_id = 1;
    private Map<Region, RangeState> rangedRegionState = new HashMap();
    private long scanPeriod = IBeaconManager.DEFAULT_FOREGROUND_SCAN_PERIOD;
    private long scanStopTime = 0;
    private boolean scanning;
    private boolean scanningPaused;
    private List<IBeacon> simulatedScanData = null;
    private HashSet<IBeacon> trackedBeacons;

    public class IBeaconBinder extends Binder {
        public IBeaconBinder() {
        }

        public IBeaconService getService() {
            Log.i(IBeaconService.TAG, "getService of IBeaconBinder called");
            return IBeaconService.this;
        }
    }

    static class IncomingHandler extends Handler {
        private final WeakReference<IBeaconService> mService;

        IncomingHandler(IBeaconService service) {
            this.mService = new WeakReference<>(service);
        }

        public void handleMessage(Message msg) {
            IBeaconService service = (IBeaconService) this.mService.get();
            StartRMData startRMData = (StartRMData) msg.obj;
            if (service != null) {
                switch (msg.what) {
                    case 2:
                        Log.i(IBeaconService.TAG, "start ranging received");
                        service.startRangingBeaconsInRegion(startRMData.getRegionData(), new Callback(startRMData.getCallbackPackageName()));
                        service.setScanPeriods(startRMData.getScanPeriod(), startRMData.getBetweenScanPeriod());
                        return;
                    case 3:
                        Log.i(IBeaconService.TAG, "stop ranging received");
                        service.stopRangingBeaconsInRegion(startRMData.getRegionData());
                        service.setScanPeriods(startRMData.getScanPeriod(), startRMData.getBetweenScanPeriod());
                        return;
                    case 4:
                        Log.i(IBeaconService.TAG, "start monitoring received");
                        service.startMonitoringBeaconsInRegion(startRMData.getRegionData(), new Callback(startRMData.getCallbackPackageName()));
                        service.setScanPeriods(startRMData.getScanPeriod(), startRMData.getBetweenScanPeriod());
                        return;
                    case 5:
                        Log.i(IBeaconService.TAG, "stop monitoring received");
                        service.stopMonitoringBeaconsInRegion(startRMData.getRegionData());
                        service.setScanPeriods(startRMData.getScanPeriod(), startRMData.getBetweenScanPeriod());
                        return;
                    case 6:
                        Log.i(IBeaconService.TAG, "set scan intervals received");
                        service.setScanPeriods(startRMData.getScanPeriod(), startRMData.getBetweenScanPeriod());
                        return;
                    default:
                        super.handleMessage(msg);
                        return;
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        Log.i(TAG, "binding");
        this.bindCount++;
        return this.mMessenger.getBinder();
    }

    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "unbinding");
        this.bindCount--;
        return false;
    }

    public void onCreate() {
        Log.i(TAG, "iBeaconService version 0.7.5 is starting up");
        getBluetoothAdapter();
        try {
            this.simulatedScanData = (List) Class.forName("com.radiusnetworks.ibeacon.SimulatedScanData").getField("iBeacons").get((Object) null);
        } catch (ClassNotFoundException e) {
            if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "No com.radiusnetworks.ibeacon.SimulatedScanData class exists.");
            }
        } catch (Exception e2) {
            Log.e(TAG, "Cannot get simulated Scan data.  Make sure your com.radiusnetworks.ibeacon.SimulatedScanData class defines a field with the signature 'public static List<IBeacon> iBeacons'", e2);
        }
    }

    @TargetApi(18)
    public void onDestroy() {
        if (Build.VERSION.SDK_INT < 18) {
            Log.w(TAG, "Not supported prior to API 18.");
            return;
        }
        Log.i(TAG, "onDestory called.  stopping scanning");
        this.handler.removeCallbacksAndMessages((Object) null);
        scanLeDevice(false);
        if (this.bluetoothAdapter != null) {
            this.bluetoothAdapter.stopLeScan((BluetoothAdapter.LeScanCallback) getLeScanCallback());
            this.lastScanEndTime = new Date().getTime();
        }
    }

    private boolean isInBackground() {
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "bound client count:" + this.bindCount);
        }
        return this.bindCount == 0;
    }

    public void startRangingBeaconsInRegion(Region region, Callback callback) {
        synchronized (this.rangedRegionState) {
            if (this.rangedRegionState.containsKey(region)) {
                Log.i(TAG, "Already ranging that region -- will replace existing region.");
                this.rangedRegionState.remove(region);
            }
            this.rangedRegionState.put(region, new RangeState(callback));
        }
        if (!this.scanning) {
            scanLeDevice(true);
        }
    }

    public void stopRangingBeaconsInRegion(Region region) {
        synchronized (this.rangedRegionState) {
            this.rangedRegionState.remove(region);
        }
        if (this.scanning && this.rangedRegionState.size() == 0 && this.monitoredRegionState.size() == 0) {
            scanLeDevice(false);
        }
    }

    public void startMonitoringBeaconsInRegion(Region region, Callback callback) {
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "startMonitoring called");
        }
        synchronized (this.monitoredRegionState) {
            if (this.monitoredRegionState.containsKey(region)) {
                Log.i(TAG, "Already monitoring that region -- will replace existing region monitor.");
                this.monitoredRegionState.remove(region);
            }
            this.monitoredRegionState.put(region, new MonitorState(callback));
        }
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "Currently monitoring " + this.monitoredRegionState.size() + " regions.");
        }
        if (!this.scanning) {
            scanLeDevice(true);
        }
    }

    public void stopMonitoringBeaconsInRegion(Region region) {
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "stopMonitoring called");
        }
        synchronized (this.monitoredRegionState) {
            this.monitoredRegionState.remove(region);
        }
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "Currently monitoring " + this.monitoredRegionState.size() + " regions.");
        }
        if (this.scanning && this.rangedRegionState.size() == 0 && this.monitoredRegionState.size() == 0) {
            scanLeDevice(false);
        }
    }

    public void setScanPeriods(long scanPeriod2, long betweenScanPeriod2) {
        this.scanPeriod = scanPeriod2;
        this.betweenScanPeriod = betweenScanPeriod2;
        long now = new Date().getTime();
        if (this.nextScanStartTime > now) {
            long proposedNextScanStartTime = this.lastScanEndTime + betweenScanPeriod2;
            if (proposedNextScanStartTime < this.nextScanStartTime) {
                this.nextScanStartTime = proposedNextScanStartTime;
                Log.i(TAG, "Adjusted nextScanStartTime to be " + new Date(this.nextScanStartTime));
            }
        }
        if (this.scanStopTime > now) {
            long proposedScanStopTime = this.lastScanStartTime + scanPeriod2;
            if (proposedScanStopTime < this.scanStopTime) {
                this.scanStopTime = proposedScanStopTime;
                Log.i(TAG, "Adjusted scanStopTime to be " + new Date(this.scanStopTime));
            }
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(18)
    public void scanLeDevice(Boolean enable) {
        if (Build.VERSION.SDK_INT < 18) {
            Log.w(TAG, "Not supported prior to API 18.");
            return;
        }
        if (getBluetoothAdapter() == null) {
            Log.e(TAG, "No bluetooth adapter.  iBeaconService cannot scan.");
            if (this.simulatedScanData == null) {
                Log.w(TAG, "exiting");
                return;
            }
            Log.w(TAG, "proceeding with simulated scan data");
        }
        if (enable.booleanValue()) {
            long millisecondsUntilStart = this.nextScanStartTime - new Date().getTime();
            if (millisecondsUntilStart > 0) {
                if (IBeaconManager.LOG_DEBUG) {
                    Log.d(TAG, "Waiting to start next bluetooth scan for another " + millisecondsUntilStart + " milliseconds");
                }
                Handler handler2 = this.handler;
                C08371 r6 = new Runnable() {
                    public void run() {
                        IBeaconService.this.scanLeDevice(true);
                    }
                };
                if (millisecondsUntilStart > 1000) {
                    millisecondsUntilStart = 1000;
                }
                handler2.postDelayed(r6, millisecondsUntilStart);
                return;
            }
            this.trackedBeacons = new HashSet<>();
            if (!this.scanning || this.scanningPaused) {
                this.scanning = true;
                this.scanningPaused = false;
                try {
                    if (getBluetoothAdapter() != null) {
                        if (getBluetoothAdapter().isEnabled()) {
                            getBluetoothAdapter().startLeScan((BluetoothAdapter.LeScanCallback) getLeScanCallback());
                            this.lastScanStartTime = new Date().getTime();
                        } else {
                            Log.w(TAG, "Bluetooth is disabled.  Cannot scan for iBeacons.");
                        }
                    }
                } catch (Exception e) {
                    Log.e("TAG", "Exception starting bluetooth scan.  Perhaps bluetooth is disabled or unavailable?");
                }
            } else if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "We are already scanning");
            }
            this.scanStopTime = new Date().getTime() + this.scanPeriod;
            scheduleScanStop();
            if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "Scan started");
                return;
            }
            return;
        }
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "disabling scan");
        }
        this.scanning = false;
        if (getBluetoothAdapter() != null) {
            getBluetoothAdapter().stopLeScan((BluetoothAdapter.LeScanCallback) getLeScanCallback());
            this.lastScanEndTime = new Date().getTime();
        }
    }

    /* access modifiers changed from: private */
    public void scheduleScanStop() {
        long millisecondsUntilStop = this.scanStopTime - new Date().getTime();
        if (millisecondsUntilStop > 0) {
            if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "Waiting to stop scan for another " + millisecondsUntilStop + " milliseconds");
            }
            Handler handler2 = this.handler;
            C08382 r5 = new Runnable() {
                public void run() {
                    IBeaconService.this.scheduleScanStop();
                }
            };
            if (millisecondsUntilStop > 1000) {
                millisecondsUntilStop = 1000;
            }
            handler2.postDelayed(r5, millisecondsUntilStop);
            return;
        }
        finishScanCycle();
    }

    @TargetApi(18)
    private void finishScanCycle() {
        if (Build.VERSION.SDK_INT < 18) {
            Log.w(TAG, "Not supported prior to API 18.");
            return;
        }
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "Done with scan cycle");
        }
        processExpiredMonitors();
        if (!this.scanning) {
            return;
        }
        if (anyRangingOrMonitoringRegionsActive()) {
            processRangeData();
            if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "Restarting scan.  Unique beacons seen last cycle: " + this.trackedBeacons.size());
            }
            if (getBluetoothAdapter() != null) {
                if (getBluetoothAdapter().isEnabled()) {
                    getBluetoothAdapter().stopLeScan((BluetoothAdapter.LeScanCallback) getLeScanCallback());
                    this.lastScanEndTime = new Date().getTime();
                } else {
                    Log.w(TAG, "Bluetooth is disabled.  Cannot scan for iBeacons.");
                }
            }
            this.scanningPaused = true;
            if (this.simulatedScanData != null) {
                ApplicationInfo applicationInfo = getApplicationInfo();
                int i = applicationInfo.flags & 2;
                applicationInfo.flags = i;
                if (i != 0) {
                    for (IBeacon iBeacon : this.simulatedScanData) {
                        processIBeaconFromScan(iBeacon);
                    }
                } else {
                    Log.w(TAG, "Simulated scan data provided, but ignored because we are not running in debug mode.  Please remove simulated scan data for production.");
                }
            }
            this.nextScanStartTime = new Date().getTime() + this.betweenScanPeriod;
            scanLeDevice(true);
        } else if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "Not starting scan because no monitoring or ranging regions are defined.");
        }
    }

    @TargetApi(18)
    private Object getLeScanCallback() {
        if (this.leScanCallback == null) {
            this.leScanCallback = new BluetoothAdapter.LeScanCallback() {
                public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
                    if (IBeaconManager.LOG_DEBUG) {
                        Log.d(IBeaconService.TAG, "got record");
                    }
                    new ScanProcessor().execute(new ScanData[]{new ScanData(device, rssi, scanRecord)});
                }
            };
        }
        return this.leScanCallback;
    }

    private class ScanData {
        public BluetoothDevice device;
        public int rssi;
        public byte[] scanRecord;

        public ScanData(BluetoothDevice device2, int rssi2, byte[] scanRecord2) {
            this.device = device2;
            this.rssi = rssi2;
            this.scanRecord = scanRecord2;
        }
    }

    private void processRangeData() {
        for (Region region : this.rangedRegionState.keySet()) {
            RangeState rangeState = this.rangedRegionState.get(region);
            if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "Calling ranging callback with " + rangeState.getIBeacons().size() + " iBeacons");
            }
            rangeState.getCallback().call(this, "rangingData", new RangingData((Collection<IBeacon>) rangeState.getIBeacons(), region));
            rangeState.clearIBeacons();
        }
    }

    private void processExpiredMonitors() {
        for (Region region : this.monitoredRegionState.keySet()) {
            MonitorState state = this.monitoredRegionState.get(region);
            if (state.isNewlyOutside()) {
                if (IBeaconManager.LOG_DEBUG) {
                    Log.d(TAG, "found a monitor that expired: " + region);
                }
                state.getCallback().call(this, "monitoringData", new MonitoringData(state.isInside(), region));
            }
        }
    }

    /* access modifiers changed from: private */
    public void processIBeaconFromScan(IBeacon iBeacon) {
        List<Region> matchedRegions;
        List<Region> matchedRegions2;
        this.lastIBeaconDetectionTime = new Date();
        if (this.trackedBeacons.contains(iBeacon)) {
            Log.i(TAG, "iBeacon detected multiple times in scan cycle :" + iBeacon.getProximityUuid() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + iBeacon.getMajor() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + iBeacon.getMinor() + " accuracy: " + iBeacon.getAccuracy() + " proximity: " + iBeacon.getProximity());
        }
        this.trackedBeacons.add(iBeacon);
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "iBeacon detected :" + iBeacon.getProximityUuid() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + iBeacon.getMajor() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + iBeacon.getMinor() + " accuracy: " + iBeacon.getAccuracy() + " proximity: " + iBeacon.getProximity());
        }
        synchronized (this.monitoredRegionState) {
            matchedRegions = matchingRegions(iBeacon, this.monitoredRegionState.keySet());
        }
        for (Region region : matchedRegions) {
            MonitorState state = this.monitoredRegionState.get(region);
            if (state.markInside()) {
                state.getCallback().call(this, "monitoringData", new MonitoringData(state.isInside(), region));
            }
        }
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "looking for ranging region matches for this ibeacon");
        }
        synchronized (this.rangedRegionState) {
            matchedRegions2 = matchingRegions(iBeacon, this.rangedRegionState.keySet());
        }
        for (Region region2 : matchedRegions2) {
            if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "matches ranging region: " + region2);
            }
            this.rangedRegionState.get(region2).addIBeacon(iBeacon);
        }
    }

    private class ScanProcessor extends AsyncTask<ScanData, Void, Void> {
        private ScanProcessor() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(ScanData... params) {
            ScanData scanData = params[0];
            IBeacon iBeacon = IBeacon.fromScanData(scanData.scanRecord, scanData.rssi);
            if (iBeacon == null) {
                return null;
            }
            IBeaconService.this.processIBeaconFromScan(iBeacon);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Void... values) {
        }
    }

    private List<Region> matchingRegions(IBeacon iBeacon, Collection<Region> regions) {
        List<Region> matched = new ArrayList<>();
        for (Region region : regions) {
            if (region.matchesIBeacon(iBeacon)) {
                matched.add(region);
            } else if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "This region does not match: " + region);
            }
        }
        return matched;
    }

    private boolean anyRangingOrMonitoringRegionsActive() {
        return this.rangedRegionState.size() + this.monitoredRegionState.size() > 0;
    }

    @TargetApi(18)
    private BluetoothAdapter getBluetoothAdapter() {
        if (Build.VERSION.SDK_INT < 18) {
            Log.w(TAG, "Not supported prior to API 18.");
            return null;
        }
        if (this.bluetoothAdapter == null) {
            this.bluetoothAdapter = ((BluetoothManager) getApplicationContext().getSystemService("bluetooth")).getAdapter();
        }
        return this.bluetoothAdapter;
    }
}
