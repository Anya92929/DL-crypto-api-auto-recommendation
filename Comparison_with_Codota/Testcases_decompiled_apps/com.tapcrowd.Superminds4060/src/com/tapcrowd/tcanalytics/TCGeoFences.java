package com.tapcrowd.tcanalytics;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.util.Log;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.tcanalytics.utils.beacon.BeaconReceiver;
import com.tapcrowd.tcanalytics.utils.beacon.BeaconUtils;
import com.tapcrowd.tcanalytics.utils.geofence.GeoFenceRemoveListener;
import com.tapcrowd.tcanalytics.utils.geofence.GeofenceRemover;
import com.tapcrowd.tcanalytics.utils.geofence.GeofenceRequester;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class TCGeoFences {
    private final String BASE_URL = "http://analytics.tapcrowd.com/1.0/analyticsservice";
    private final String GET_GEOFENCES = "/getGeofencesForBundleWithCoordinates";
    private final int SERVICE_CHECK_INTERVAL = 60000;
    /* access modifiers changed from: private */
    public Context context;
    private GeoFenceRemoveListener removeListener = new GeoFenceRemoveListener() {
        public void onGeofencesRemoved() {
            TCGeoFences.this.saveGeofences();
        }

        public void onGeofencesRemovedFailed() {
            TCGeoFences.this.saveGeofences();
        }
    };
    /* access modifiers changed from: private */
    public String response = null;
    /* access modifiers changed from: private */
    public int statuscode = 0;

    public TCGeoFences(Context context2) {
        this.context = context2;
    }

    public void init() {
        new GeoFenceTask(this, (GeoFenceTask) null).execute(new Void[0]);
    }

    private class GeoFenceTask extends AsyncTask<Void, Void, Void> {
        private GeoFenceTask() {
        }

        /* synthetic */ GeoFenceTask(TCGeoFences tCGeoFences, GeoFenceTask geoFenceTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            List<NameValuePair> postparams = new ArrayList<>();
            postparams.add(new BasicNameValuePair("bundleid", C1271DB.getTapTargetBundleid(TCGeoFences.this.context)));
            postparams.add(new BasicNameValuePair("lon", "0"));
            postparams.add(new BasicNameValuePair("lat", "0"));
            try {
                HttpPost post = new HttpPost("http://analytics.tapcrowd.com/1.0/analyticsservice/getGeofencesForBundleWithCoordinates");
                post.setEntity(new UrlEncodedFormEntity(postparams));
                HttpResponse resp = new DefaultHttpClient().execute(post);
                TCGeoFences.this.statuscode = resp.getStatusLine().getStatusCode();
                TCGeoFences.this.response = EntityUtils.toString(resp.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TCGeoFences.this.statuscode == 200 && TCGeoFences.this.response != null) {
                TCGeoFences.this.removeGeofences();
            }
            Log.d(TCGeoFences.class.toString(), "GEOFENCES: " + TCGeoFences.this.response);
            return null;
        }
    }

    public void removeGeofences() {
        new GeofenceRemover(this.context, this.removeListener).removeGeofencesByIntent(GeofenceRequester.createRequestPendingIntent(this.context));
    }

    /* access modifiers changed from: private */
    public void saveGeofences() {
        C1271DB.openDataBase(this.context);
        Cursor cursor = C1271DB.getQuery("SELECT id FROM geofences");
        List<String> existingFences = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBFavorites.KEY_EVENT_ID);
            do {
                existingFences.add(cursor.getString(idIndex));
            } while (cursor.moveToNext());
        }
        try {
            JSONArray json = new JSONArray(this.response);
            int len = json.length();
            for (int i = 0; i < len; i++) {
                ContentValues cv = new ContentValues();
                JSONObject fence = json.getJSONObject(i);
                String type = fence.getString("geofencetypeid");
                String id = fence.getString(DBFavorites.KEY_EVENT_ID);
                String radius = fence.getString("radius");
                cv.put(DBFavorites.KEY_EVENT_ID, id);
                cv.put("geofencetypeid", type);
                cv.put("radius", radius);
                if (type.equals("1")) {
                    String lat = fence.getString("lat");
                    String lon = fence.getString("lon");
                    cv.put("lat", lat);
                    cv.put("lon", lon);
                }
                if (type.equals("5")) {
                    String uuid = fence.getString("ibeacon_uuid");
                    String major = fence.getString("ibeacon_major");
                    String minor = fence.getString("ibeacon_minor");
                    String ibeacon_radius = fence.getString("ibeacon_radius");
                    cv.put("ibeacon_uuid", uuid);
                    cv.put("ibeacon_major", major);
                    cv.put("ibeacon_minor", minor);
                    cv.put("ibeacon_radius", ibeacon_radius);
                }
                arrayList.add(id);
                if (C1271DB.update("geofences", cv, String.format("id == '%1$s'", new Object[]{id})) == 0) {
                    C1271DB.write("geofences", cv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String id2 : existingFences) {
            if (id2 != null && !arrayList.contains(id2)) {
                C1271DB.remove("geofences", DBFavorites.KEY_EVENT_ID, id2);
            }
        }
        addNewGeofences();
        addNewBeacons();
    }

    public void addNewBeacons() {
        C1271DB.openDataBase(this.context);
        if (C1271DB.getSizeForQuery("SELECT COUNT(*) FROM geofences WHERE geofencetypeid == '5'") > 0 && BeaconUtils.checkAPILevel() && BeaconUtils.isBLEAvailable(this.context)) {
            ((AlarmManager) this.context.getSystemService("alarm")).setRepeating(0, System.currentTimeMillis(), 60000, PendingIntent.getBroadcast(this.context, 1, new Intent(this.context, BeaconReceiver.class), 134217728));
        }
    }

    public void addNewGeofences() {
        C1271DB.openDataBase(this.context);
        int size = C1271DB.getSizeForQuery("SELECT COUNT(*) FROM geofences WHERE geofencetypeid == '1'");
        if (size != 0) {
            if (size <= 100) {
                createGeofences(C1271DB.getQuery("SELECT * FROM geofences WHERE geofencetypeid == '1'"), true);
                return;
            }
            Location location = ((LocationManager) this.context.getSystemService("location")).getLastKnownLocation("network");
            createGeofences(C1271DB.getQuery(String.format("SELECT * FROM geofences WHERE geofencetypeid == '1' ORDER BY (%1$s - (lat+0)) * (%1$s - (lat+0)) + (%2$s - (lon+0)) * (%2$s - (lon+0)) ASC LIMIT 99", new Object[]{String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude())})), true);
        }
    }

    private void createGeofences(Cursor cursor, boolean setBorder) {
        int idIndex = cursor.getColumnIndex(DBFavorites.KEY_EVENT_ID);
        int latIndex = cursor.getColumnIndex("lat");
        int lonIndex = cursor.getColumnIndex("lon");
        int radiusIndex = cursor.getColumnIndex("radius");
        double lat = 0.0d;
        double lon = 0.0d;
        float radius = BitmapDescriptorFactory.HUE_RED;
        ArrayList<Geofence> geofences = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                lat = Double.parseDouble(cursor.getString(latIndex));
                lon = Double.parseDouble(cursor.getString(lonIndex));
                radius = Float.parseFloat(cursor.getString(radiusIndex));
                geofences.add(new Geofence.Builder().setRequestId(cursor.getString(idIndex)).setTransitionTypes(1).setCircularRegion(lat, lon, radius).setExpirationDuration(-1).build());
            } while (cursor.moveToNext());
        }
        if (setBorder) {
            Location location = ((LocationManager) this.context.getSystemService("location")).getLastKnownLocation("network");
            Location farthest = new Location((String) null);
            farthest.setLatitude(lat);
            farthest.setLongitude(lon);
            if (!(location == null || farthest == null)) {
                geofences.add(new Geofence.Builder().setRequestId("border").setTransitionTypes(2).setCircularRegion(location.getLatitude(), location.getLongitude(), Math.abs(location.distanceTo(farthest) - radius)).setExpirationDuration(-1).build());
            }
        }
        new GeofenceRequester(this.context).addGeofences(geofences);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r0 = (android.support.p000v4.app.FragmentActivity) r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean servicesConnected(android.content.Context r7) {
        /*
            r4 = 0
            int r3 = com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(r7)
            if (r3 != 0) goto L_0x0009
            r4 = 1
        L_0x0008:
            return r4
        L_0x0009:
            boolean r5 = r7 instanceof android.support.p000v4.app.FragmentActivity
            if (r5 == 0) goto L_0x0008
            r0 = r7
            android.support.v4.app.FragmentActivity r0 = (android.support.p000v4.app.FragmentActivity) r0
            android.app.Dialog r1 = com.google.android.gms.common.GooglePlayServicesUtil.getErrorDialog(r3, r0, r4)
            if (r1 == 0) goto L_0x0008
            com.tapcrowd.tcanalytics.TCGeoFences$ErrorDialogFragment r2 = new com.tapcrowd.tcanalytics.TCGeoFences$ErrorDialogFragment
            r2.<init>()
            r2.setDialog(r1)
            android.support.v4.app.FragmentManager r5 = r0.getSupportFragmentManager()
            java.lang.String r6 = "Geofence Detection"
            r2.show((android.support.p000v4.app.FragmentManager) r5, (java.lang.String) r6)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapcrowd.tcanalytics.TCGeoFences.servicesConnected(android.content.Context):boolean");
    }

    public static class ErrorDialogFragment extends DialogFragment {
        private Dialog mDialog = null;

        public void setDialog(Dialog dialog) {
            this.mDialog = dialog;
        }

        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return this.mDialog;
        }
    }
}
