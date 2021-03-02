package com.tapcrowd.tcanalytics.utils.geofence.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapcrowd.tcanalytics.TCGeoFences;

public class GeoFenceResetReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (TCGeoFences.servicesConnected(context)) {
            TCGeoFences fences = new TCGeoFences(context);
            fences.addNewGeofences();
            fences.addNewBeacons();
        }
    }
}
