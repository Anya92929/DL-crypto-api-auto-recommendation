package org.apache.cordova;

import android.os.Build;
import android.util.Log;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactManager extends CordovaPlugin {
    public static final int INVALID_ARGUMENT_ERROR = 1;
    public static final int IO_ERROR = 4;
    private static final String LOG_TAG = "Contact Query";
    public static final int NOT_SUPPORTED_ERROR = 5;
    public static final int PENDING_OPERATION_ERROR = 3;
    public static final int PERMISSION_DENIED_ERROR = 20;
    public static final int TIMEOUT_ERROR = 2;
    public static final int UNKNOWN_ERROR = 0;
    /* access modifiers changed from: private */
    public ContactAccessor contactAccessor;

    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (Build.VERSION.RELEASE.startsWith("1.")) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, 5));
            return true;
        }
        if (this.contactAccessor == null) {
            this.contactAccessor = new ContactAccessorSdk5(this.webView, this.cordova);
        }
        if (action.equals("search")) {
            final JSONArray filter = args.getJSONArray(0);
            final JSONObject options = args.getJSONObject(1);
            this.cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    callbackContext.success(ContactManager.this.contactAccessor.search(filter, options));
                }
            });
            return true;
        } else if (action.equals("save")) {
            final JSONObject contact = args.getJSONObject(0);
            this.cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    JSONObject res = null;
                    String id = ContactManager.this.contactAccessor.save(contact);
                    if (id != null) {
                        try {
                            res = ContactManager.this.contactAccessor.getContactById(id);
                        } catch (JSONException e) {
                            Log.e(ContactManager.LOG_TAG, "JSON fail.", e);
                        }
                    }
                    if (res != null) {
                        callbackContext.success(res);
                    } else {
                        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, 0));
                    }
                }
            });
            return true;
        } else if (!action.equals("remove")) {
            return false;
        } else {
            final String contactId = args.getString(0);
            this.cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    if (ContactManager.this.contactAccessor.remove(contactId)) {
                        callbackContext.success();
                    } else {
                        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, 0));
                    }
                }
            });
            return true;
        }
    }
}
