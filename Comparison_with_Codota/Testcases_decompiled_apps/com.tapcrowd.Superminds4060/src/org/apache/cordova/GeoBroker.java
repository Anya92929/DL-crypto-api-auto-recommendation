package org.apache.cordova;

import android.location.Location;
import android.location.LocationManager;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.model.OAuthConstants;

public class GeoBroker extends CordovaPlugin {
    private GPSListener gpsListener;
    private LocationManager locationManager;
    private NetworkListener networkListener;

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (this.locationManager == null) {
            this.locationManager = (LocationManager) this.cordova.getActivity().getSystemService("location");
            this.networkListener = new NetworkListener(this.locationManager, this);
            this.gpsListener = new GPSListener(this.locationManager, this);
        }
        if (!this.locationManager.isProviderEnabled("gps") && !this.locationManager.isProviderEnabled("network")) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.NO_RESULT, "Location API is not available for this device."));
        } else if (action.equals("getLocation")) {
            boolean enableHighAccuracy = args.getBoolean(0);
            int maximumAge = args.getInt(1);
            Location last = this.locationManager.getLastKnownLocation(enableHighAccuracy ? "gps" : "network");
            if (last == null || System.currentTimeMillis() - last.getTime() > ((long) maximumAge)) {
                getCurrentLocation(callbackContext, enableHighAccuracy);
            } else {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, returnLocationJSON(last)));
            }
        } else if (action.equals("addWatch")) {
            addWatch(args.getString(0), callbackContext, args.getBoolean(1));
        } else if (!action.equals("clearWatch")) {
            return false;
        } else {
            clearWatch(args.getString(0));
        }
        return true;
    }

    private void clearWatch(String id) {
        this.gpsListener.clearWatch(id);
        this.networkListener.clearWatch(id);
    }

    private void getCurrentLocation(CallbackContext callbackContext, boolean enableHighAccuracy) {
        if (enableHighAccuracy) {
            this.gpsListener.addCallback(callbackContext);
        } else {
            this.networkListener.addCallback(callbackContext);
        }
    }

    private void addWatch(String timerId, CallbackContext callbackContext, boolean enableHighAccuracy) {
        if (enableHighAccuracy) {
            this.gpsListener.addWatch(timerId, callbackContext);
        } else {
            this.networkListener.addWatch(timerId, callbackContext);
        }
    }

    public void onDestroy() {
        if (this.networkListener != null) {
            this.networkListener.destroy();
            this.networkListener = null;
        }
        if (this.gpsListener != null) {
            this.gpsListener.destroy();
            this.gpsListener = null;
        }
    }

    public void onReset() {
        onDestroy();
    }

    public JSONObject returnLocationJSON(Location loc) {
        Float f = null;
        JSONObject o = new JSONObject();
        try {
            o.put("latitude", loc.getLatitude());
            o.put("longitude", loc.getLongitude());
            o.put("altitude", loc.hasAltitude() ? Double.valueOf(loc.getAltitude()) : null);
            o.put("accuracy", (double) loc.getAccuracy());
            if (loc.hasBearing() && loc.hasSpeed()) {
                f = Float.valueOf(loc.getBearing());
            }
            o.put("heading", f);
            o.put("speed", (double) loc.getSpeed());
            o.put("timestamp", loc.getTime());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return o;
    }

    public void win(Location loc, CallbackContext callbackContext) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, returnLocationJSON(loc)));
    }

    public void fail(int code, String msg, CallbackContext callbackContext) {
        PluginResult result;
        JSONObject obj = new JSONObject();
        String backup = null;
        try {
            obj.put(OAuthConstants.CODE, code);
            obj.put("message", msg);
        } catch (JSONException e) {
            obj = null;
            backup = "{'code':" + code + ",'message':'" + msg.replaceAll("'", "'") + "'}";
        }
        if (obj != null) {
            result = new PluginResult(PluginResult.Status.ERROR, obj);
        } else {
            result = new PluginResult(PluginResult.Status.ERROR, backup);
        }
        callbackContext.sendPluginResult(result);
    }

    public boolean isGlobalListener(CordovaLocationListener listener) {
        if (this.gpsListener == null || this.networkListener == null) {
            return false;
        }
        if (this.gpsListener.equals(listener) || this.networkListener.equals(listener)) {
            return true;
        }
        return false;
    }
}
