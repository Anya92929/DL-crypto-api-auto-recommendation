package org.apache.cordova;

import android.location.LocationManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class GPSListener extends CordovaLocationListener {
    public GPSListener(LocationManager locationManager, GeoBroker m) {
        super(locationManager, m, "[Cordova GPSListener]");
    }

    /* access modifiers changed from: protected */
    public void start() {
        if (this.running) {
            return;
        }
        if (this.locationManager.getProvider("gps") != null) {
            this.running = true;
            this.locationManager.requestLocationUpdates("gps", 60000, BitmapDescriptorFactory.HUE_RED, this);
            return;
        }
        fail(CordovaLocationListener.POSITION_UNAVAILABLE, "GPS provider is not available.");
    }
}
