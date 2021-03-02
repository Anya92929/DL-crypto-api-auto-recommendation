package org.apache.cordova;

import org.apache.cordova.api.PluginManager;
import org.json.JSONException;

class ExposedJsApi {
    private NativeToJsMessageQueue jsMessageQueue;
    private PluginManager pluginManager;

    public ExposedJsApi(PluginManager pluginManager2, NativeToJsMessageQueue jsMessageQueue2) {
        this.pluginManager = pluginManager2;
        this.jsMessageQueue = jsMessageQueue2;
    }

    public String exec(String service, String action, String callbackId, String arguments) throws JSONException {
        this.jsMessageQueue.setPaused(true);
        try {
            boolean exec = this.pluginManager.exec(service, action, callbackId, arguments);
            return this.jsMessageQueue.popAndEncode();
        } finally {
            this.jsMessageQueue.setPaused(false);
        }
    }

    public void setNativeToJsBridgeMode(int value) {
        this.jsMessageQueue.setBridgeMode(value);
    }

    public String retrieveJsMessages() {
        return this.jsMessageQueue.popAndEncode();
    }
}
