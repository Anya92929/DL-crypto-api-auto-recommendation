package org.apache.cordova.api;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.api.PluginResult;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

public class PluginManager {
    private static String TAG = "PluginManager";
    private final CordovaWebView app;
    private final CordovaInterface ctx;
    private final HashMap<String, PluginEntry> entries = new HashMap<>();
    private boolean firstRun;
    protected HashMap<String, String> urlMap = new HashMap<>();

    public PluginManager(CordovaWebView app2, CordovaInterface ctx2) {
        this.ctx = ctx2;
        this.app = app2;
        this.firstRun = true;
    }

    public void init() {
        LOG.m2215d(TAG, "init()");
        if (this.firstRun) {
            loadPlugins();
            this.firstRun = false;
        } else {
            onPause(false);
            onDestroy();
            clearPluginObjects();
        }
        startupPlugins();
    }

    public void loadPlugins() {
        int id = this.ctx.getActivity().getResources().getIdentifier("config", "xml", this.ctx.getActivity().getPackageName());
        if (id == 0) {
            id = this.ctx.getActivity().getResources().getIdentifier("plugins", "xml", this.ctx.getActivity().getPackageName());
            LOG.m2221i(TAG, "Using plugins.xml instead of config.xml.  plugins.xml will eventually be deprecated");
        }
        if (id == 0) {
            pluginConfigurationMissing();
            return;
        }
        XmlResourceParser xml = this.ctx.getActivity().getResources().getXml(id);
        int eventType = -1;
        String service = "";
        String pluginClass = "";
        boolean insideFeature = false;
        while (eventType != 1) {
            if (eventType == 2) {
                String strNode = xml.getName();
                if (strNode.equals("plugin")) {
                    service = xml.getAttributeValue((String) null, DBFavorites.KEY_NAME);
                    pluginClass = xml.getAttributeValue((String) null, "value");
                    addService(new PluginEntry(service, pluginClass, "true".equals(xml.getAttributeValue((String) null, "onload"))));
                } else if (strNode.equals("url-filter")) {
                    this.urlMap.put(xml.getAttributeValue((String) null, "value"), service);
                } else if (strNode.equals("feature")) {
                    insideFeature = true;
                    xml.getAttributeValue((String) null, DBFavorites.KEY_NAME);
                } else if (strNode.equals("param") && insideFeature) {
                    String paramType = xml.getAttributeValue((String) null, DBFavorites.KEY_NAME);
                    if (paramType.equals("service")) {
                        service = xml.getAttributeValue((String) null, "value");
                    } else if (paramType.equals("package")) {
                        pluginClass = xml.getAttributeValue((String) null, "value");
                    }
                    if (service.length() > 0 && pluginClass.length() > 0) {
                        addService(new PluginEntry(service, pluginClass, "true".equals(xml.getAttributeValue((String) null, "onload"))));
                        service = "";
                        pluginClass = "";
                    }
                }
            } else if (eventType == 3 && xml.getName().equals("feature")) {
                service = "";
                pluginClass = "";
                insideFeature = false;
            }
            try {
                eventType = xml.next();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void clearPluginObjects() {
        for (PluginEntry entry : this.entries.values()) {
            entry.plugin = null;
        }
    }

    public void startupPlugins() {
        for (PluginEntry entry : this.entries.values()) {
            if (entry.onload) {
                entry.createPlugin(this.app, this.ctx);
            }
        }
    }

    public boolean exec(String service, String action, String callbackId, String rawArgs) {
        CordovaPlugin plugin = getPlugin(service);
        if (plugin == null) {
            this.app.sendPluginResult(new PluginResult(PluginResult.Status.CLASS_NOT_FOUND_EXCEPTION), callbackId);
            return true;
        }
        try {
            CallbackContext callbackContext = new CallbackContext(callbackId, this.app);
            if (plugin.execute(action, rawArgs, callbackContext)) {
                return callbackContext.isFinished();
            }
            this.app.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION), callbackId);
            return true;
        } catch (JSONException e) {
            this.app.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION), callbackId);
            return true;
        }
    }

    @Deprecated
    public boolean exec(String service, String action, String callbackId, String jsonArgs, boolean async) {
        return exec(service, action, callbackId, jsonArgs);
    }

    private CordovaPlugin getPlugin(String service) {
        PluginEntry entry = this.entries.get(service);
        if (entry == null) {
            return null;
        }
        CordovaPlugin plugin = entry.plugin;
        if (plugin == null) {
            return entry.createPlugin(this.app, this.ctx);
        }
        return plugin;
    }

    public void addService(String service, String className) {
        addService(new PluginEntry(service, className, false));
    }

    public void addService(PluginEntry entry) {
        this.entries.put(entry.service, entry);
    }

    public void onPause(boolean multitasking) {
        for (PluginEntry entry : this.entries.values()) {
            if (entry.plugin != null) {
                entry.plugin.onPause(multitasking);
            }
        }
    }

    public void onResume(boolean multitasking) {
        for (PluginEntry entry : this.entries.values()) {
            if (entry.plugin != null) {
                entry.plugin.onResume(multitasking);
            }
        }
    }

    public void onDestroy() {
        for (PluginEntry entry : this.entries.values()) {
            if (entry.plugin != null) {
                entry.plugin.onDestroy();
            }
        }
    }

    public Object postMessage(String id, Object data) {
        Object obj;
        Object obj2 = this.ctx.onMessage(id, data);
        if (obj2 != null) {
            return obj2;
        }
        for (PluginEntry entry : this.entries.values()) {
            if (entry.plugin != null && (obj = entry.plugin.onMessage(id, data)) != null) {
                return obj;
            }
        }
        return null;
    }

    public void onNewIntent(Intent intent) {
        for (PluginEntry entry : this.entries.values()) {
            if (entry.plugin != null) {
                entry.plugin.onNewIntent(intent);
            }
        }
    }

    public boolean onOverrideUrlLoading(String url) {
        for (Map.Entry<String, String> pairs : this.urlMap.entrySet()) {
            if (url.startsWith(pairs.getKey())) {
                return getPlugin(pairs.getValue()).onOverrideUrlLoading(url);
            }
        }
        return false;
    }

    public void onReset() {
        for (PluginEntry pluginEntry : this.entries.values()) {
            CordovaPlugin plugin = pluginEntry.plugin;
            if (plugin != null) {
                plugin.onReset();
            }
        }
    }

    private void pluginConfigurationMissing() {
        LOG.m2218e(TAG, "=====================================================================================");
        LOG.m2218e(TAG, "ERROR: plugin.xml is missing.  Add res/xml/plugins.xml to your project.");
        LOG.m2218e(TAG, "https://git-wip-us.apache.org/repos/asf?p=incubator-cordova-android.git;a=blob;f=framework/res/xml/plugins.xml");
        LOG.m2218e(TAG, "=====================================================================================");
    }
}
