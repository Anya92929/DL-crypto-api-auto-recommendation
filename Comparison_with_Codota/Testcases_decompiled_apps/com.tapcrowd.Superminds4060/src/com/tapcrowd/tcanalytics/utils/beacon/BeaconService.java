package com.tapcrowd.tcanalytics.utils.beacon;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import com.radiusnetworks.ibeacon.IBeaconConsumer;
import com.radiusnetworks.ibeacon.IBeaconManager;
import com.radiusnetworks.ibeacon.MonitorNotifier;
import com.radiusnetworks.ibeacon.Region;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.tcanalytics.C1271DB;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class BeaconService extends Service implements IBeaconConsumer {
    private static final int SCAN_DURATION = 4000;
    private static final String TAG = "AnalyticsBeaconService";
    private static final int TIME_BETWEEN_SCANS = 8000;
    private final String STATE_INSIDE = "synced";
    private final String STATE_OUTSIDE = "outside";
    private List<Beacon> beacons;
    private IBeaconManager iBeaconManager;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)) {
                    case 10:
                        BeaconService.this.stopSelf();
                        return;
                    case 13:
                        BeaconService.this.stopSelf();
                        return;
                    default:
                        return;
                }
            }
        }
    };

    public void onCreate() {
        Log.i(BeaconService.class.toString(), "create service");
        registerReceiver(this.mReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(BeaconService.class.toString(), "startcommand");
        this.iBeaconManager = IBeaconManager.getInstanceForApplication(this);
        this.iBeaconManager.bind(this);
        this.iBeaconManager.setForegroundScanPeriod(4000);
        this.iBeaconManager.setBackgroundScanPeriod(4000);
        this.iBeaconManager.setForegroundBetweenScanPeriod(8000);
        this.iBeaconManager.setBackgroundBetweenScanPeriod(8000);
        return 1;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i(BeaconService.class.toString(), "service done");
        unregisterReceiver(this.mReceiver);
        if (this.iBeaconManager.isBound(this)) {
            this.iBeaconManager.unBind(this);
        }
    }

    public void onIBeaconServiceConnect() {
        this.iBeaconManager.setMonitorNotifier(new MonitorNotifier() {
            public void didEnterRegion(Region region) {
                Log.i(BeaconService.TAG, "I just saw beacon \\" + region.getUniqueId());
                ContentValues cv = new ContentValues();
                cv.put("state", "synced");
                C1271DB.update("geofences", cv, String.format("geofencetypeid == '5' AND id == '%1$s'", new Object[]{region.getUniqueId()}));
                BeaconService.this.notifyServer(BeaconService.this.getApplicationContext(), region.getUniqueId());
            }

            public void didExitRegion(Region region) {
                Log.i(BeaconService.TAG, "I no longer see beacon \\" + region.getUniqueId());
                ContentValues cv = new ContentValues();
                cv.put("state", "outside");
                C1271DB.update("geofences", cv, String.format("geofencetypeid == '5' AND id == '%1$s'", new Object[]{region.getUniqueId()}));
                BeaconService.this.notifyServer(BeaconService.this.getApplicationContext(), region.getUniqueId());
            }

            public void didDetermineStateForRegion(int state, Region region) {
            }
        });
        this.beacons = getBeaconsFromDB();
        try {
            for (Beacon b : this.beacons) {
                this.iBeaconManager.startMonitoringBeaconsInRegion(new Region(b.getId(), b.getUuid(), Integer.valueOf(Integer.parseInt(b.getMajor())), Integer.valueOf(Integer.parseInt(b.getMinor()))));
            }
        } catch (RemoteException e) {
        }
    }

    /* access modifiers changed from: private */
    public void notifyServer(Context context, String beaconId) {
        new NotifyThead(context, beaconId).start();
    }

    private List<Beacon> getBeaconsFromDB() {
        C1271DB.openDataBase(this);
        Cursor cursor = C1271DB.getQuery("SELECT id, ibeacon_radius, ibeacon_uuid, ibeacon_major, ibeacon_minor FROM geofences where geofencetypeid == 5");
        List<Beacon> beacons2 = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                beacons2.add(new Beacon(cursor.getString(cursor.getColumnIndex(DBFavorites.KEY_EVENT_ID)), cursor.getString(cursor.getColumnIndex("ibeacon_uuid")), cursor.getString(cursor.getColumnIndex("ibeacon_major")), cursor.getString(cursor.getColumnIndex("ibeacon_minor")), cursor.getString(cursor.getColumnIndex("ibeacon_radius"))));
            } while (cursor.moveToNext());
        }
        return beacons2;
    }

    private class NotifyThead extends Thread {
        private final String URL = "http://analytics.tapcrowd.com/1.0/analyticsservice/isInGeofence";
        private String beaconId;
        private Context context;

        public NotifyThead(Context context2, String beaconId2) {
            this.context = context2;
            this.beaconId = beaconId2;
        }

        public void run() {
            LocationManager manager = (LocationManager) this.context.getSystemService("location");
            Location location = manager.getLastKnownLocation("gps");
            if (location == null || location.getTime() < manager.getLastKnownLocation("network").getTime()) {
                location = manager.getLastKnownLocation("network");
            }
            String query = String.format("SELECT state FROM geofences WHERE id == '%1$s'", new Object[]{this.beaconId});
            C1271DB.openDataBase(this.context);
            String state = C1271DB.getValue(query, "state");
            if (state != null && state.equals("synced")) {
                List<NameValuePair> parameters = new ArrayList<>();
                parameters.add(new BasicNameValuePair("geofenceid", this.beaconId));
                parameters.add(new BasicNameValuePair("deviceId", Settings.Secure.getString(this.context.getContentResolver(), "android_id")));
                parameters.add(new BasicNameValuePair("bundleId", C1271DB.getTapTargetBundleid(this.context)));
                parameters.add(new BasicNameValuePair("os", "android"));
                parameters.add(new BasicNameValuePair("deviceType", Build.MODEL));
                parameters.add(new BasicNameValuePair("osversion", Build.VERSION.RELEASE));
                parameters.add(new BasicNameValuePair("lat", new StringBuilder(String.valueOf(location.getLatitude())).toString()));
                parameters.add(new BasicNameValuePair("lon", new StringBuilder(String.valueOf(location.getLongitude())).toString()));
                try {
                    new DefaultHttpClient().execute(new HttpGet("http://analytics.tapcrowd.com/1.0/analyticsservice/isInGeofence?" + URLEncodedUtils.format(parameters, "UTF-8")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ContentValues cv = new ContentValues();
            cv.put("state", "synced");
            C1271DB.update("geofences", cv, String.format("id == '%1$s'", new Object[]{this.beaconId}));
            super.run();
        }
    }
}
