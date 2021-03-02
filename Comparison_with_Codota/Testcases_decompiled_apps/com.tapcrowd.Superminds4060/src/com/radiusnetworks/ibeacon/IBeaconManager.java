package com.radiusnetworks.ibeacon;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.radiusnetworks.ibeacon.service.IBeaconService;
import com.radiusnetworks.ibeacon.service.RegionData;
import com.radiusnetworks.ibeacon.service.StartRMData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IBeaconManager {
    public static final long DEFAULT_BACKGROUND_BETWEEN_SCAN_PERIOD = 300000;
    public static final long DEFAULT_BACKGROUND_SCAN_PERIOD = 10000;
    public static final long DEFAULT_FOREGROUND_BETWEEN_SCAN_PERIOD = 0;
    public static final long DEFAULT_FOREGROUND_SCAN_PERIOD = 1100;
    public static boolean LOG_DEBUG = false;
    private static final String TAG = "IBeaconManager";
    protected static IBeaconManager client = null;
    private long backgroundBetweenScanPeriod = DEFAULT_BACKGROUND_BETWEEN_SCAN_PERIOD;
    private long backgroundScanPeriod = DEFAULT_BACKGROUND_SCAN_PERIOD;
    /* access modifiers changed from: private */
    public Map<IBeaconConsumer, ConsumerInfo> consumers = new HashMap();
    private Context context;
    protected RangeNotifier dataRequestNotifier = null;
    private long foregroundBetweenScanPeriod = 0;
    private long foregroundScanPeriod = DEFAULT_FOREGROUND_SCAN_PERIOD;
    private ServiceConnection iBeaconServiceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            if (IBeaconManager.LOG_DEBUG) {
                Log.d(IBeaconManager.TAG, "we have a connection to the service now");
            }
            Messenger unused = IBeaconManager.this.serviceMessenger = new Messenger(service);
            synchronized (IBeaconManager.this.consumers) {
                for (IBeaconConsumer consumer : IBeaconManager.this.consumers.keySet()) {
                    if (!Boolean.valueOf(((ConsumerInfo) IBeaconManager.this.consumers.get(consumer)).isConnected).booleanValue()) {
                        consumer.onIBeaconServiceConnect();
                        ConsumerInfo consumerInfo = (ConsumerInfo) IBeaconManager.this.consumers.get(consumer);
                        consumerInfo.isConnected = true;
                        IBeaconManager.this.consumers.put(consumer, consumerInfo);
                    }
                }
            }
        }

        public void onServiceDisconnected(ComponentName className) {
            Log.e(IBeaconManager.TAG, "onServiceDisconnected");
        }
    };
    protected MonitorNotifier monitorNotifier = null;
    private ArrayList<Region> monitoredRegions = new ArrayList<>();
    protected RangeNotifier rangeNotifier = null;
    private ArrayList<Region> rangedRegions = new ArrayList<>();
    /* access modifiers changed from: private */
    public Messenger serviceMessenger = null;

    public void setForegroundScanPeriod(long p) {
        this.foregroundScanPeriod = p;
    }

    public void setForegroundBetweenScanPeriod(long p) {
        this.foregroundBetweenScanPeriod = p;
    }

    public void setBackgroundScanPeriod(long p) {
        this.backgroundScanPeriod = p;
    }

    public void setBackgroundBetweenScanPeriod(long p) {
        this.backgroundBetweenScanPeriod = p;
    }

    public static IBeaconManager getInstanceForApplication(Context context2) {
        if (client == null) {
            if (LOG_DEBUG) {
                Log.d(TAG, "IBeaconManager instance creation");
            }
            client = new IBeaconManager(context2);
        }
        return client;
    }

    protected IBeaconManager(Context context2) {
        this.context = context2;
    }

    @TargetApi(18)
    public boolean checkAvailability() {
        if (Build.VERSION.SDK_INT < 18) {
            return false;
        }
        if (this.context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return ((BluetoothManager) this.context.getSystemService("bluetooth")).getAdapter().isEnabled();
        }
        throw new BleNotAvailableException("Bluetooth LE not supported by this device");
    }

    public void bind(IBeaconConsumer consumer) {
        if (Build.VERSION.SDK_INT < 18) {
            Log.w(TAG, "Not supported prior to SDK 18.  Method invocation will be ignored");
            return;
        }
        synchronized (this.consumers) {
            if (!this.consumers.keySet().contains(consumer)) {
                if (LOG_DEBUG) {
                    Log.d(TAG, "This consumer is not bound.  binding: " + consumer);
                }
                this.consumers.put(consumer, new ConsumerInfo());
                consumer.bindService(new Intent(consumer.getApplicationContext(), IBeaconService.class), this.iBeaconServiceConnection, 1);
                if (LOG_DEBUG) {
                    Log.d(TAG, "consumer count is now:" + this.consumers.size());
                }
                if (this.serviceMessenger != null) {
                    setBackgroundMode(consumer, false);
                }
            } else if (LOG_DEBUG) {
                Log.d(TAG, "This consumer is already bound");
            }
        }
    }

    public void unBind(IBeaconConsumer consumer) {
        if (Build.VERSION.SDK_INT < 18) {
            Log.w(TAG, "Not supported prior to SDK 18.  Method invocation will be ignored");
            return;
        }
        synchronized (this.consumers) {
            if (this.consumers.keySet().contains(consumer)) {
                Log.d(TAG, "Unbinding");
                consumer.unbindService(this.iBeaconServiceConnection);
                this.consumers.remove(consumer);
            } else {
                if (LOG_DEBUG) {
                    Log.d(TAG, "This consumer is not bound to: " + consumer);
                }
                if (LOG_DEBUG) {
                    Log.d(TAG, "Bound consumers: ");
                }
                for (int i = 0; i < this.consumers.size(); i++) {
                    Log.i(TAG, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.consumers.get(Integer.valueOf(i)));
                }
            }
        }
    }

    public boolean isBound(IBeaconConsumer consumer) {
        boolean z;
        synchronized (this.consumers) {
            z = this.consumers.keySet().contains(consumer) && this.serviceMessenger != null;
        }
        return z;
    }

    public boolean setBackgroundMode(IBeaconConsumer consumer, boolean backgroundMode) {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 18) {
            Log.w(TAG, "Not supported prior to SDK 18.  Method invocation will be ignored");
        } else {
            synchronized (this.consumers) {
                Log.i(TAG, "setBackgroundMode for consumer" + consumer);
                if (this.consumers.keySet().contains(consumer)) {
                    try {
                        ConsumerInfo consumerInfo = this.consumers.get(consumer);
                        consumerInfo.isInBackground = backgroundMode;
                        this.consumers.put(consumer, consumerInfo);
                        updateScanPeriods();
                        z = true;
                    } catch (RemoteException e) {
                        Log.e(TAG, "Failed to set background mode", e);
                    }
                } else if (LOG_DEBUG) {
                    Log.d(TAG, "This consumer is not bound to: " + consumer);
                }
            }
        }
        return z;
    }

    public void setRangeNotifier(RangeNotifier notifier) {
        this.rangeNotifier = notifier;
    }

    public void setMonitorNotifier(MonitorNotifier notifier) {
        this.monitorNotifier = notifier;
    }

    @TargetApi(18)
    public void startRangingBeaconsInRegion(Region region) throws RemoteException {
        if (Build.VERSION.SDK_INT < 18) {
            Log.w(TAG, "Not supported prior to SDK 18.  Method invocation will be ignored");
        } else if (this.serviceMessenger == null) {
            throw new RemoteException("The IBeaconManager is not bound to the service.  Call iBeaconManager.bind(IBeaconConsumer consumer) and wait for a callback to onIBeaconServiceConnect()");
        } else {
            Message msg = Message.obtain((Handler) null, 2, 0, 0);
            msg.obj = new StartRMData(new RegionData(region), callbackPackageName(), getScanPeriod(), getBetweenScanPeriod());
            this.serviceMessenger.send(msg);
            synchronized (this.rangedRegions) {
                this.rangedRegions.add((Region) region.clone());
            }
        }
    }

    @TargetApi(18)
    public void stopRangingBeaconsInRegion(Region region) throws RemoteException {
        if (Build.VERSION.SDK_INT < 18) {
            Log.w(TAG, "Not supported prior to SDK 18.  Method invocation will be ignored");
        } else if (this.serviceMessenger == null) {
            throw new RemoteException("The IBeaconManager is not bound to the service.  Call iBeaconManager.bind(IBeaconConsumer consumer) and wait for a callback to onIBeaconServiceConnect()");
        } else {
            Message msg = Message.obtain((Handler) null, 3, 0, 0);
            msg.obj = new StartRMData(new RegionData(region), callbackPackageName(), getScanPeriod(), getBetweenScanPeriod());
            this.serviceMessenger.send(msg);
            synchronized (this.rangedRegions) {
                Region regionToRemove = null;
                Iterator i$ = this.rangedRegions.iterator();
                while (i$.hasNext()) {
                    Region rangedRegion = i$.next();
                    if (region.getUniqueId().equals(rangedRegion.getProximityUuid())) {
                        regionToRemove = rangedRegion;
                    }
                }
                this.rangedRegions.remove(regionToRemove);
            }
        }
    }

    @TargetApi(18)
    public void startMonitoringBeaconsInRegion(Region region) throws RemoteException {
        if (Build.VERSION.SDK_INT < 18) {
            Log.w(TAG, "Not supported prior to API 18.  Method invocation will be ignored");
        } else if (this.serviceMessenger == null) {
            throw new RemoteException("The IBeaconManager is not bound to the service.  Call iBeaconManager.bind(IBeaconConsumer consumer) and wait for a callback to onIBeaconServiceConnect()");
        } else {
            Message msg = Message.obtain((Handler) null, 4, 0, 0);
            msg.obj = new StartRMData(new RegionData(region), callbackPackageName(), getScanPeriod(), getBetweenScanPeriod());
            this.serviceMessenger.send(msg);
            synchronized (this.monitoredRegions) {
                this.monitoredRegions.add((Region) region.clone());
            }
        }
    }

    @TargetApi(18)
    public void stopMonitoringBeaconsInRegion(Region region) throws RemoteException {
        if (Build.VERSION.SDK_INT < 18) {
            Log.w(TAG, "Not supported prior to API 18.  Method invocation will be ignored");
        } else if (this.serviceMessenger == null) {
            throw new RemoteException("The IBeaconManager is not bound to the service.  Call iBeaconManager.bind(IBeaconConsumer consumer) and wait for a callback to onIBeaconServiceConnect()");
        } else {
            Message msg = Message.obtain((Handler) null, 5, 0, 0);
            msg.obj = new StartRMData(new RegionData(region), callbackPackageName(), getScanPeriod(), getBetweenScanPeriod());
            this.serviceMessenger.send(msg);
            synchronized (this.monitoredRegions) {
                Region regionToRemove = null;
                Iterator i$ = this.monitoredRegions.iterator();
                while (i$.hasNext()) {
                    Region monitoredRegion = i$.next();
                    if (region.getUniqueId().equals(monitoredRegion.getProximityUuid())) {
                        regionToRemove = monitoredRegion;
                    }
                }
                this.monitoredRegions.remove(regionToRemove);
            }
        }
    }

    @TargetApi(18)
    public void updateScanPeriods() throws RemoteException {
        if (Build.VERSION.SDK_INT < 18) {
            Log.w(TAG, "Not supported prior to API 18.  Method invocation will be ignored");
        } else if (this.serviceMessenger == null) {
            throw new RemoteException("The IBeaconManager is not bound to the service.  Call iBeaconManager.bind(IBeaconConsumer consumer) and wait for a callback to onIBeaconServiceConnect()");
        } else {
            Message msg = Message.obtain((Handler) null, 6, 0, 0);
            msg.obj = new StartRMData(getScanPeriod(), getBetweenScanPeriod());
            this.serviceMessenger.send(msg);
        }
    }

    public void setScanPeriods() throws RemoteException {
        updateScanPeriods();
    }

    private String callbackPackageName() {
        String packageName = this.context.getPackageName();
        if (LOG_DEBUG) {
            Log.d(TAG, "callback packageName: " + packageName);
        }
        return packageName;
    }

    public MonitorNotifier getMonitoringNotifier() {
        return this.monitorNotifier;
    }

    public RangeNotifier getRangingNotifier() {
        return this.rangeNotifier;
    }

    public Collection<Region> getMonitoredRegions() {
        ArrayList<Region> clonedMontoredRegions = new ArrayList<>();
        synchronized (this.monitoredRegions) {
            Iterator i$ = this.monitoredRegions.iterator();
            while (i$.hasNext()) {
                clonedMontoredRegions.add((Region) i$.next().clone());
            }
        }
        return clonedMontoredRegions;
    }

    public Collection<Region> getRangedRegions() {
        ArrayList<Region> clonedRangedRegions = new ArrayList<>();
        synchronized (this.rangedRegions) {
            Iterator i$ = this.rangedRegions.iterator();
            while (i$.hasNext()) {
                clonedRangedRegions.add((Region) i$.next().clone());
            }
        }
        return clonedRangedRegions;
    }

    /* access modifiers changed from: protected */
    public void setDataRequestNotifier(RangeNotifier notifier) {
        this.dataRequestNotifier = notifier;
    }

    /* access modifiers changed from: protected */
    public RangeNotifier getDataRequestNotifier() {
        return this.dataRequestNotifier;
    }

    private class ConsumerInfo {
        public boolean isConnected;
        public boolean isInBackground;

        private ConsumerInfo() {
            this.isConnected = false;
            this.isInBackground = false;
        }
    }

    private boolean isInBackground() {
        boolean background = true;
        synchronized (this.consumers) {
            for (IBeaconConsumer consumer : this.consumers.keySet()) {
                if (!this.consumers.get(consumer).isInBackground) {
                    background = false;
                }
            }
        }
        return background;
    }

    private long getScanPeriod() {
        if (isInBackground()) {
            return this.backgroundScanPeriod;
        }
        return this.foregroundScanPeriod;
    }

    private long getBetweenScanPeriod() {
        if (isInBackground()) {
            return this.backgroundBetweenScanPeriod;
        }
        return this.foregroundBetweenScanPeriod;
    }
}
