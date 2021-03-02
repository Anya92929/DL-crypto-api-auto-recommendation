package org.apache.cordova;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.util.TimeZone;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.LOG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Device extends CordovaPlugin {
    public static final String TAG = "Device";
    public static String cordovaVersion = "2.2.0";
    public static String platform = "Android";
    public static String uuid;
    BroadcastReceiver telephonyReceiver = null;

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        uuid = getUuid();
        initTelephonyReceiver();
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (!action.equals("getDeviceInfo")) {
            return false;
        }
        JSONObject r = new JSONObject();
        r.put("uuid", uuid);
        r.put("version", getOSVersion());
        r.put("platform", platform);
        r.put(DBFavorites.KEY_NAME, getProductName());
        r.put("cordova", cordovaVersion);
        callbackContext.success(r);
        return true;
    }

    public void onDestroy() {
        this.cordova.getActivity().unregisterReceiver(this.telephonyReceiver);
    }

    private void initTelephonyReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        this.telephonyReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (intent != null && intent.getAction().equals("android.intent.action.PHONE_STATE") && intent.hasExtra("state")) {
                    String extraData = intent.getStringExtra("state");
                    if (extraData.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                        LOG.m2221i(Device.TAG, "Telephone RINGING");
                        Device.this.webView.postMessage("telephone", "ringing");
                    } else if (extraData.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                        LOG.m2221i(Device.TAG, "Telephone OFFHOOK");
                        Device.this.webView.postMessage("telephone", "offhook");
                    } else if (extraData.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                        LOG.m2221i(Device.TAG, "Telephone IDLE");
                        Device.this.webView.postMessage("telephone", "idle");
                    }
                }
            }
        };
        this.cordova.getActivity().registerReceiver(this.telephonyReceiver, intentFilter);
    }

    public String getPlatform() {
        return platform;
    }

    public String getUuid() {
        return Settings.Secure.getString(this.cordova.getActivity().getContentResolver(), "android_id");
    }

    public String getCordovaVersion() {
        return cordovaVersion;
    }

    public String getModel() {
        return Build.MODEL;
    }

    public String getProductName() {
        return Build.PRODUCT;
    }

    public String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public String getSDKVersion() {
        return Build.VERSION.SDK;
    }

    public String getTimeZoneID() {
        return TimeZone.getDefault().getID();
    }
}
