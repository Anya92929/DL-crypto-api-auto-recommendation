package com.tapcrowd.tcanalytics.utils.geofence;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.LocationClient;
import com.tapcrowd.tcanalytics.C1271DB;
import com.tapcrowd.tcanalytics.TCGeoFences;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class GeoFenceReceiver extends BroadcastReceiver {
    private final String URL = "http://analytics.tapcrowd.com/1.0/analyticsservice/isInGeofence";

    public void onReceive(Context context, Intent intent) {
        if (!LocationClient.hasError(intent)) {
            int transition = LocationClient.getGeofenceTransition(intent);
            if (intent.hasExtra("PACKAGE") && intent.getStringExtra("PACKAGE").equals(C1271DB.getTapTargetBundleid(context))) {
                Log.d(GeoFenceReceiver.class.toString(), "Geofence found");
                if (transition == 1) {
                    notifyServer(context, intent);
                } else if (transition == 2) {
                    new TCGeoFences(context).addNewGeofences();
                }
            }
        }
    }

    private void notifyServer(Context context, Intent intent) {
        new NotifyThead(context, intent).start();
    }

    private class NotifyThead extends Thread {
        private Context context;
        private Intent intent;

        public NotifyThead(Context context2, Intent intent2) {
            this.intent = intent2;
            this.context = context2;
        }

        public void run() {
            LocationManager manager = (LocationManager) this.context.getSystemService("location");
            Location location = manager.getLastKnownLocation("gps");
            if (location == null || location.getTime() < manager.getLastKnownLocation("network").getTime()) {
                location = manager.getLastKnownLocation("network");
            }
            for (Geofence geofence : LocationClient.getTriggeringGeofences(this.intent)) {
                String query = String.format("SELECT timestamp FROM geofences WHERE id == '%1$s'", new Object[]{geofence.getRequestId()});
                C1271DB.openDataBase(this.context);
                String timeStr = C1271DB.getValue(query, "timestamp");
                Long currentTime = Long.valueOf(System.currentTimeMillis() / 1000);
                Long timeStrLong = 0L;
                if (timeStr != null) {
                    timeStrLong = Long.valueOf(Long.parseLong(timeStr));
                }
                if (timeStr == null || currentTime.longValue() - timeStrLong.longValue() > 300) {
                    List<NameValuePair> parameters = new ArrayList<>();
                    parameters.add(new BasicNameValuePair("geofenceid", geofence.getRequestId()));
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
                    ContentValues cv = new ContentValues();
                    cv.put("timestamp", new StringBuilder(String.valueOf(System.currentTimeMillis() / 1000)).toString());
                    C1271DB.update("geofences", cv, String.format("id == '%1$s'", new Object[]{geofence.getRequestId()}));
                }
            }
            super.run();
        }
    }
}
