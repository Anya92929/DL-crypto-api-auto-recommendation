package org.apache.cordova.api;

import android.util.Log;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;

public class CallbackContext {
    private static final String LOG_TAG = "CordovaPlugin";
    private String callbackId;
    private int changingThreads;
    private boolean finished;
    private CordovaWebView webView;

    public CallbackContext(String callbackId2, CordovaWebView webView2) {
        this.callbackId = callbackId2;
        this.webView = webView2;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public boolean isChangingThreads() {
        return this.changingThreads > 0;
    }

    public String getCallbackId() {
        return this.callbackId;
    }

    public void sendPluginResult(PluginResult pluginResult) {
        synchronized (this) {
            if (this.finished) {
                Log.w(LOG_TAG, "Attempted to send a second callback for ID: " + this.callbackId + "\nResult was: " + pluginResult.getMessage());
                return;
            }
            this.finished = !pluginResult.getKeepCallback();
            this.webView.sendPluginResult(pluginResult, this.callbackId);
        }
    }

    public void success(JSONObject message) {
        sendPluginResult(new PluginResult(PluginResult.Status.OK, message));
    }

    public void success(String message) {
        sendPluginResult(new PluginResult(PluginResult.Status.OK, message));
    }

    public void success(JSONArray message) {
        sendPluginResult(new PluginResult(PluginResult.Status.OK, message));
    }

    public void success() {
        sendPluginResult(new PluginResult(PluginResult.Status.OK));
    }

    public void error(JSONObject message) {
        sendPluginResult(new PluginResult(PluginResult.Status.ERROR, message));
    }

    public void error(String message) {
        sendPluginResult(new PluginResult(PluginResult.Status.ERROR, message));
    }

    public void error(int message) {
        sendPluginResult(new PluginResult(PluginResult.Status.ERROR, message));
    }
}
