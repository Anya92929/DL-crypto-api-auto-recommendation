package org.apache.cordova.api;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public abstract class Plugin extends CordovaPlugin {
    public LegacyContext ctx;

    public abstract PluginResult execute(String str, JSONArray jSONArray, String str2);

    public boolean isSynch(String action) {
        return false;
    }

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        setContext(cordova);
        setView(webView);
    }

    public void setContext(CordovaInterface ctx2) {
        this.cordova = ctx2;
        this.ctx = new LegacyContext(this.cordova);
    }

    public void setView(CordovaWebView webView) {
        this.webView = webView;
    }

    public boolean execute(final String action, final JSONArray args, CallbackContext callbackContext) throws JSONException {
        final String callbackId = callbackContext.getCallbackId();
        if (!isSynch(action)) {
            this.cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    PluginResult cr;
                    try {
                        cr = Plugin.this.execute(action, args, callbackId);
                    } catch (Throwable e) {
                        cr = new PluginResult(PluginResult.Status.ERROR, e.getMessage());
                    }
                    Plugin.this.sendPluginResult(cr, callbackId);
                }
            });
        } else {
            PluginResult cr = execute(action, args, callbackId);
            if (cr == null) {
                cr = new PluginResult(PluginResult.Status.NO_RESULT);
            }
            callbackContext.sendPluginResult(cr);
        }
        return true;
    }

    public void sendJavascript(String statement) {
        this.webView.sendJavascript(statement);
    }

    public void sendPluginResult(PluginResult pluginResult, String callbackId) {
        this.webView.sendPluginResult(pluginResult, callbackId);
    }

    public void success(PluginResult pluginResult, String callbackId) {
        this.webView.sendPluginResult(pluginResult, callbackId);
    }

    public void success(JSONObject message, String callbackId) {
        this.webView.sendPluginResult(new PluginResult(PluginResult.Status.OK, message), callbackId);
    }

    public void success(String message, String callbackId) {
        this.webView.sendPluginResult(new PluginResult(PluginResult.Status.OK, message), callbackId);
    }

    public void error(PluginResult pluginResult, String callbackId) {
        this.webView.sendPluginResult(pluginResult, callbackId);
    }

    public void error(JSONObject message, String callbackId) {
        this.webView.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, message), callbackId);
    }

    public void error(String message, String callbackId) {
        this.webView.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, message), callbackId);
    }
}
