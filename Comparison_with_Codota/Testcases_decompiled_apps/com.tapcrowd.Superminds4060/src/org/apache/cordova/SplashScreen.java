package org.apache.cordova;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;

public class SplashScreen extends CordovaPlugin {
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if (action.equals("hide")) {
            this.webView.postMessage("splashscreen", "hide");
        } else if (!action.equals("show")) {
            return false;
        } else {
            this.webView.postMessage("splashscreen", "show");
        }
        callbackContext.success();
        return true;
    }
}
