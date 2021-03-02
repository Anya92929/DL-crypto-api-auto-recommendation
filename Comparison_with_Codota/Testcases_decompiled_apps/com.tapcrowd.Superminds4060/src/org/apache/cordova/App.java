package org.apache.cordova;

import java.util.HashMap;
import org.apache.cordova.api.LOG;
import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class App extends Plugin {
    public PluginResult execute(String action, JSONArray args, String callbackId) {
        PluginResult.Status status = PluginResult.Status.OK;
        try {
            if (action.equals("clearCache")) {
                clearCache();
            } else if (action.equals("show")) {
                this.cordova.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        App.this.webView.postMessage("spinner", "stop");
                    }
                });
            } else if (action.equals("loadUrl")) {
                loadUrl(args.getString(0), args.optJSONObject(1));
            } else if (action.equals("cancelLoadUrl")) {
                cancelLoadUrl();
            } else if (action.equals("clearHistory")) {
                clearHistory();
            } else if (action.equals("backHistory")) {
                backHistory();
            } else if (action.equals("overrideButton")) {
                overrideButton(args.getString(0), args.getBoolean(1));
            } else if (action.equals("overrideBackbutton")) {
                overrideBackbutton(args.getBoolean(0));
            } else if (action.equals("exitApp")) {
                exitApp();
            }
            return new PluginResult(status, "");
        } catch (JSONException e) {
            return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
        }
    }

    public void clearCache() {
        this.webView.clearCache(true);
    }

    public void loadUrl(String url, JSONObject props) throws JSONException {
        LOG.m2215d("App", "App.loadUrl(" + url + "," + props + ")");
        int wait = 0;
        boolean openExternal = false;
        boolean clearHistory = false;
        HashMap<String, Object> params = new HashMap<>();
        if (props != null) {
            JSONArray keys = props.names();
            for (int i = 0; i < keys.length(); i++) {
                String key = keys.getString(i);
                if (key.equals("wait")) {
                    wait = props.getInt(key);
                } else if (key.equalsIgnoreCase("openexternal")) {
                    openExternal = props.getBoolean(key);
                } else if (key.equalsIgnoreCase("clearhistory")) {
                    clearHistory = props.getBoolean(key);
                } else {
                    Object value = props.get(key);
                    if (value != null) {
                        if (value.getClass().equals(String.class)) {
                            params.put(key, (String) value);
                        } else if (value.getClass().equals(Boolean.class)) {
                            params.put(key, (Boolean) value);
                        } else if (value.getClass().equals(Integer.class)) {
                            params.put(key, (Integer) value);
                        }
                    }
                }
            }
        }
        if (wait > 0) {
            try {
                synchronized (this) {
                    wait((long) wait);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.webView.showWebPage(url, openExternal, clearHistory, params);
    }

    @Deprecated
    public void cancelLoadUrl() {
        this.cordova.cancelLoadUrl();
    }

    public void clearHistory() {
        this.webView.clearHistory();
    }

    public void backHistory() {
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                App.this.webView.backHistory();
            }
        });
    }

    public void overrideBackbutton(boolean override) {
        LOG.m2221i("App", "WARNING: Back Button Default Behaviour will be overridden.  The backbutton event will be fired!");
        this.webView.bindButton(override);
    }

    public void overrideButton(String button, boolean override) {
        LOG.m2221i("DroidGap", "WARNING: Volume Button Default Behaviour will be overridden.  The volume event will be fired!");
        this.webView.bindButton(button, override);
    }

    public boolean isBackbuttonOverridden() {
        return this.webView.isBackButtonBound();
    }

    public void exitApp() {
        this.webView.postMessage("exit", (Object) null);
    }
}
