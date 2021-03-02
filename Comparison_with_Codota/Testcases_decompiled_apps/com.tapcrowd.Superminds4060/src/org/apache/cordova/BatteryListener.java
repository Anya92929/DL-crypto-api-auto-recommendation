package org.apache.cordova;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BatteryListener extends CordovaPlugin {
    private static final String LOG_TAG = "BatteryManager";
    private CallbackContext batteryCallbackContext = null;
    BroadcastReceiver receiver = null;

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if (action.equals("start")) {
            if (this.batteryCallbackContext != null) {
                callbackContext.error("Battery listener already running.");
                return true;
            }
            this.batteryCallbackContext = callbackContext;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            if (this.receiver == null) {
                this.receiver = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        BatteryListener.this.updateBatteryInfo(intent);
                    }
                };
                this.cordova.getActivity().registerReceiver(this.receiver, intentFilter);
            }
            PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
            return true;
        } else if (!action.equals("stop")) {
            return false;
        } else {
            removeBatteryListener();
            sendUpdate(new JSONObject(), false);
            this.batteryCallbackContext = null;
            callbackContext.success();
            return true;
        }
    }

    public void onDestroy() {
        removeBatteryListener();
    }

    public void onReset() {
        removeBatteryListener();
    }

    private void removeBatteryListener() {
        if (this.receiver != null) {
            try {
                this.cordova.getActivity().unregisterReceiver(this.receiver);
                this.receiver = null;
            } catch (Exception e) {
                Log.e(LOG_TAG, "Error unregistering battery receiver: " + e.getMessage(), e);
            }
        }
    }

    private JSONObject getBatteryInfo(Intent batteryIntent) {
        boolean z = false;
        JSONObject obj = new JSONObject();
        try {
            obj.put("level", batteryIntent.getIntExtra("level", 0));
            if (batteryIntent.getIntExtra("plugged", -1) > 0) {
                z = true;
            }
            obj.put("isPlugged", z);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
        }
        return obj;
    }

    /* access modifiers changed from: private */
    public void updateBatteryInfo(Intent batteryIntent) {
        sendUpdate(getBatteryInfo(batteryIntent), true);
    }

    private void sendUpdate(JSONObject info, boolean keepCallback) {
        if (this.batteryCallbackContext != null) {
            PluginResult result = new PluginResult(PluginResult.Status.OK, info);
            result.setKeepCallback(keepCallback);
            this.batteryCallbackContext.sendPluginResult(result);
        }
    }
}
