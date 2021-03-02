package org.apache.cordova;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class Echo extends CordovaPlugin {
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        final String result = args.isNull(0) ? null : args.getString(0);
        if ("echo".equals(action)) {
            callbackContext.success(result);
            return true;
        } else if (!"echoAsync".equals(action)) {
            return false;
        } else {
            this.cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    callbackContext.success(result);
                }
            });
            return true;
        }
    }
}
