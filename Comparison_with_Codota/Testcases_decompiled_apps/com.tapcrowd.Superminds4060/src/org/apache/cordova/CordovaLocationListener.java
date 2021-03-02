package org.apache.cordova;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.cordova.api.CallbackContext;

public class CordovaLocationListener implements LocationListener {
    public static int PERMISSION_DENIED = 1;
    public static int POSITION_UNAVAILABLE = 2;
    public static int TIMEOUT = 3;
    private String TAG = "[Cordova Location Listener]";
    private List<CallbackContext> callbacks = new ArrayList();
    protected LocationManager locationManager;
    private GeoBroker owner;
    protected boolean running = false;
    public HashMap<String, CallbackContext> watches = new HashMap<>();

    public CordovaLocationListener(LocationManager manager, GeoBroker broker, String tag) {
        this.locationManager = manager;
        this.owner = broker;
        this.TAG = tag;
    }

    /* access modifiers changed from: protected */
    public void fail(int code, String message) {
        for (CallbackContext callbackContext : this.callbacks) {
            this.owner.fail(code, message, callbackContext);
        }
        if (this.owner.isGlobalListener(this)) {
            Log.d(this.TAG, "Stopping global listener");
            stop();
        }
        this.callbacks.clear();
        for (CallbackContext fail : this.watches.values()) {
            this.owner.fail(code, message, fail);
        }
    }

    private void win(Location loc) {
        for (CallbackContext callbackContext : this.callbacks) {
            this.owner.win(loc, callbackContext);
        }
        if (this.owner.isGlobalListener(this)) {
            Log.d(this.TAG, "Stopping global listener");
            stop();
        }
        this.callbacks.clear();
        for (CallbackContext win : this.watches.values()) {
            this.owner.win(loc, win);
        }
    }

    public void onProviderDisabled(String provider) {
        Log.d(this.TAG, "Location provider '" + provider + "' disabled.");
        fail(POSITION_UNAVAILABLE, "GPS provider disabled.");
    }

    public void onProviderEnabled(String provider) {
        Log.d(this.TAG, "Location provider " + provider + " has been enabled");
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d(this.TAG, "The status of the provider " + provider + " has changed");
        if (status == 0) {
            Log.d(this.TAG, provider + " is OUT OF SERVICE");
            fail(POSITION_UNAVAILABLE, "Provider " + provider + " is out of service.");
        } else if (status == 1) {
            Log.d(this.TAG, provider + " is TEMPORARILY_UNAVAILABLE");
        } else {
            Log.d(this.TAG, provider + " is AVAILABLE");
        }
    }

    public void onLocationChanged(Location location) {
        Log.d(this.TAG, "The location has been updated!");
        win(location);
    }

    public int size() {
        return this.watches.size() + this.callbacks.size();
    }

    public void addWatch(String timerId, CallbackContext callbackContext) {
        this.watches.put(timerId, callbackContext);
        if (size() == 1) {
            start();
        }
    }

    public void addCallback(CallbackContext callbackContext) {
        this.callbacks.add(callbackContext);
        if (size() == 1) {
            start();
        }
    }

    public void clearWatch(String timerId) {
        if (this.watches.containsKey(timerId)) {
            this.watches.remove(timerId);
        }
        if (size() == 0) {
            stop();
        }
    }

    public void destroy() {
        stop();
    }

    /* access modifiers changed from: protected */
    public void start() {
        if (this.running) {
            return;
        }
        if (this.locationManager.getProvider("network") != null) {
            this.running = true;
            this.locationManager.requestLocationUpdates("network", 60000, 10.0f, this);
            return;
        }
        fail(POSITION_UNAVAILABLE, "Network provider is not available.");
    }

    private void stop() {
        if (this.running) {
            this.locationManager.removeUpdates(this);
            this.running = false;
        }
    }
}
