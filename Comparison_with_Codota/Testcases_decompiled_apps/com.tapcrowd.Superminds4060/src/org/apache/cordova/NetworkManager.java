package org.apache.cordova;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;

public class NetworkManager extends CordovaPlugin {
    public static final String CDMA = "cdma";
    public static final String EDGE = "edge";
    public static final String EHRPD = "ehrpd";
    public static final String GPRS = "gprs";
    public static final String GSM = "gsm";
    public static final String HSDPA = "hsdpa";
    public static final String HSPA = "hspa";
    public static final String HSPA_PLUS = "hspa+";
    public static final String HSUPA = "hsupa";
    private static final String LOG_TAG = "NetworkManager";
    public static final String LTE = "lte";
    public static final String MOBILE = "mobile";
    public static int NOT_REACHABLE = 0;
    public static final String ONEXRTT = "1xrtt";
    public static int REACHABLE_VIA_CARRIER_DATA_NETWORK = 1;
    public static int REACHABLE_VIA_WIFI_NETWORK = 2;
    public static final String TYPE_2G = "2g";
    public static final String TYPE_3G = "3g";
    public static final String TYPE_4G = "4g";
    public static final String TYPE_ETHERNET = "ethernet";
    public static final String TYPE_NONE = "none";
    public static final String TYPE_UNKNOWN = "unknown";
    public static final String TYPE_WIFI = "wifi";
    public static final String UMB = "umb";
    public static final String UMTS = "umts";
    public static final String WIFI = "wifi";
    public static final String WIMAX = "wimax";
    private CallbackContext connectionCallbackContext;
    BroadcastReceiver receiver = null;
    private boolean registered = false;
    ConnectivityManager sockMan;

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.sockMan = (ConnectivityManager) cordova.getActivity().getSystemService("connectivity");
        this.connectionCallbackContext = null;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (this.receiver == null) {
            this.receiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if (NetworkManager.this.webView != null) {
                        NetworkManager.this.updateConnectionInfo((NetworkInfo) intent.getParcelableExtra("networkInfo"));
                    }
                }
            };
            cordova.getActivity().registerReceiver(this.receiver, intentFilter);
            this.registered = true;
        }
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if (!action.equals("getConnectionInfo")) {
            return false;
        }
        this.connectionCallbackContext = callbackContext;
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, getConnectionInfo(this.sockMan.getActiveNetworkInfo()));
        pluginResult.setKeepCallback(true);
        callbackContext.sendPluginResult(pluginResult);
        return true;
    }

    public void onDestroy() {
        if (this.receiver != null && this.registered) {
            try {
                this.cordova.getActivity().unregisterReceiver(this.receiver);
                this.registered = false;
            } catch (Exception e) {
                Log.e(LOG_TAG, "Error unregistering network receiver: " + e.getMessage(), e);
            }
        }
    }

    public void onReset() {
        onDestroy();
    }

    /* access modifiers changed from: private */
    public void updateConnectionInfo(NetworkInfo info) {
        sendUpdate(getConnectionInfo(info));
    }

    private String getConnectionInfo(NetworkInfo info) {
        if (info == null || !info.isConnected()) {
            return TYPE_NONE;
        }
        return getType(info);
    }

    private void sendUpdate(String type) {
        if (this.connectionCallbackContext != null) {
            PluginResult result = new PluginResult(PluginResult.Status.OK, type);
            result.setKeepCallback(true);
            this.connectionCallbackContext.sendPluginResult(result);
        }
        this.webView.postMessage("networkconnection", type);
    }

    private String getType(NetworkInfo info) {
        if (info == null) {
            return TYPE_NONE;
        }
        String type = info.getTypeName();
        if (type.toLowerCase().equals("wifi")) {
            return "wifi";
        }
        if (type.toLowerCase().equals(MOBILE)) {
            String type2 = info.getSubtypeName();
            if (type2.toLowerCase().equals(GSM) || type2.toLowerCase().equals(GPRS) || type2.toLowerCase().equals(EDGE)) {
                return TYPE_2G;
            }
            if (type2.toLowerCase().startsWith(CDMA) || type2.toLowerCase().equals(UMTS) || type2.toLowerCase().equals(ONEXRTT) || type2.toLowerCase().equals(EHRPD) || type2.toLowerCase().equals(HSUPA) || type2.toLowerCase().equals(HSDPA) || type2.toLowerCase().equals(HSPA)) {
                return TYPE_3G;
            }
            if (type2.toLowerCase().equals(LTE) || type2.toLowerCase().equals(UMB) || type2.toLowerCase().equals(HSPA_PLUS)) {
                return TYPE_4G;
            }
        }
        return TYPE_UNKNOWN;
    }
}
