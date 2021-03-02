package org.apache.cordova;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CompassListener extends CordovaPlugin implements SensorEventListener {
    public static int ERROR_FAILED_TO_START = 3;
    public static int RUNNING = 2;
    public static int STARTING = 1;
    public static int STOPPED = 0;
    public long TIMEOUT = 30000;
    int accuracy;
    private CallbackContext callbackContext;
    float heading = BitmapDescriptorFactory.HUE_RED;
    long lastAccessTime;
    Sensor mSensor;
    private SensorManager sensorManager;
    int status;
    long timeStamp = 0;

    public CompassListener() {
        setStatus(STOPPED);
    }

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.sensorManager = (SensorManager) cordova.getActivity().getSystemService("sensor");
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext2) throws JSONException {
        if (action.equals("start")) {
            start();
            return true;
        } else if (action.equals("stop")) {
            stop();
            return true;
        } else if (action.equals("getStatus")) {
            callbackContext2.sendPluginResult(new PluginResult(PluginResult.Status.OK, getStatus()));
            return true;
        } else if (action.equals("getHeading")) {
            if (this.status != RUNNING) {
                if (start() == ERROR_FAILED_TO_START) {
                    callbackContext2.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, ERROR_FAILED_TO_START));
                    return true;
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        CompassListener.this.timeout();
                    }
                }, 2000);
            }
            callbackContext2.sendPluginResult(new PluginResult(PluginResult.Status.OK, getCompassHeading()));
            return true;
        } else if (action.equals("setTimeout")) {
            setTimeout(args.getLong(0));
            return true;
        } else if (!action.equals("getTimeout")) {
            return false;
        } else {
            callbackContext2.sendPluginResult(new PluginResult(PluginResult.Status.OK, (float) getTimeout()));
            return true;
        }
    }

    public void onDestroy() {
        stop();
    }

    public void onReset() {
        stop();
    }

    public int start() {
        if (this.status == RUNNING || this.status == STARTING) {
            return this.status;
        }
        List<Sensor> list = this.sensorManager.getSensorList(3);
        if (list == null || list.size() <= 0) {
            setStatus(ERROR_FAILED_TO_START);
        } else {
            this.mSensor = list.get(0);
            this.sensorManager.registerListener(this, this.mSensor, 3);
            this.lastAccessTime = System.currentTimeMillis();
            setStatus(STARTING);
        }
        return this.status;
    }

    public void stop() {
        if (this.status != STOPPED) {
            this.sensorManager.unregisterListener(this);
        }
        setStatus(STOPPED);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy2) {
    }

    /* access modifiers changed from: private */
    public void timeout() {
        if (this.status == STARTING) {
            setStatus(ERROR_FAILED_TO_START);
            if (this.callbackContext != null) {
                this.callbackContext.error("Compass listener failed to start.");
            }
        }
    }

    public void onSensorChanged(SensorEvent event) {
        float heading2 = event.values[0];
        this.timeStamp = System.currentTimeMillis();
        this.heading = heading2;
        setStatus(RUNNING);
        if (this.timeStamp - this.lastAccessTime > this.TIMEOUT) {
            stop();
        }
    }

    public int getStatus() {
        return this.status;
    }

    public float getHeading() {
        this.lastAccessTime = System.currentTimeMillis();
        return this.heading;
    }

    public void setTimeout(long timeout) {
        this.TIMEOUT = timeout;
    }

    public long getTimeout() {
        return this.TIMEOUT;
    }

    private void setStatus(int status2) {
        this.status = status2;
    }

    private JSONObject getCompassHeading() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("magneticHeading", (double) getHeading());
        obj.put("trueHeading", (double) getHeading());
        obj.put("headingAccuracy", 0);
        obj.put("timestamp", this.timeStamp);
        return obj;
    }
}
