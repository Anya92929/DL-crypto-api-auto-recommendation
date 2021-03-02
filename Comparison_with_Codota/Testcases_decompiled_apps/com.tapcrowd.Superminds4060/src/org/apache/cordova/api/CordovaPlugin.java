package org.apache.cordova.api;

import android.content.Intent;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class CordovaPlugin {
    static final /* synthetic */ boolean $assertionsDisabled = (!CordovaPlugin.class.desiredAssertionStatus());
    public CordovaInterface cordova;

    /* renamed from: id */
    public String f2150id;
    public CordovaWebView webView;

    public void initialize(CordovaInterface cordova2, CordovaWebView webView2) {
        if ($assertionsDisabled || this.cordova == null) {
            this.cordova = cordova2;
            this.webView = webView2;
            return;
        }
        throw new AssertionError();
    }

    public boolean execute(String action, String rawArgs, CallbackContext callbackContext) throws JSONException {
        return execute(action, new JSONArray(rawArgs), callbackContext);
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        return false;
    }

    public void onPause(boolean multitasking) {
    }

    public void onResume(boolean multitasking) {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onDestroy() {
    }

    public Object onMessage(String id, Object data) {
        return null;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    }

    public boolean onOverrideUrlLoading(String url) {
        return false;
    }

    public void onReset() {
    }
}
