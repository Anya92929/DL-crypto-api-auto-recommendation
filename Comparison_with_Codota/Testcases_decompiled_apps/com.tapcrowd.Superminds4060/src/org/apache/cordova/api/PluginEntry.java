package org.apache.cordova.api;

import org.apache.cordova.CordovaWebView;

public class PluginEntry {
    public boolean onload = false;
    public CordovaPlugin plugin = null;
    public String pluginClass = "";
    public String service = "";

    public PluginEntry(String service2, String pluginClass2, boolean onload2) {
        this.service = service2;
        this.pluginClass = pluginClass2;
        this.onload = onload2;
    }

    public CordovaPlugin createPlugin(CordovaWebView webView, CordovaInterface ctx) {
        if (this.plugin != null) {
            return this.plugin;
        }
        try {
            Class c = getClassByName(this.pluginClass);
            if (isCordovaPlugin(c)) {
                this.plugin = (CordovaPlugin) c.newInstance();
                this.plugin.initialize(ctx, webView);
                return this.plugin;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error adding plugin " + this.pluginClass + ".");
        }
        return null;
    }

    private Class getClassByName(String clazz) throws ClassNotFoundException {
        if (clazz != null) {
            return Class.forName(clazz);
        }
        return null;
    }

    private boolean isCordovaPlugin(Class c) {
        if (c != null) {
            return CordovaPlugin.class.isAssignableFrom(c);
        }
        return false;
    }
}
