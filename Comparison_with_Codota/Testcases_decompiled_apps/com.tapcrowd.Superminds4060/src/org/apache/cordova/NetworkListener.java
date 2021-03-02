package org.apache.cordova;

import android.location.LocationManager;

public class NetworkListener extends CordovaLocationListener {
    public NetworkListener(LocationManager locationManager, GeoBroker m) {
        super(locationManager, m, "[Cordova NetworkListener]");
    }
}
