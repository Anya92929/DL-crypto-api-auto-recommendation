package org.apache.cordova;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.PluginResult;

public class NativeToJsMessageQueue {
    private static final int DEFAULT_BRIDGE_MODE = 2;
    static final boolean DISABLE_EXEC_CHAINING = false;
    static final boolean ENABLE_LOCATION_CHANGE_EXEC_MODE = false;
    private static final boolean FORCE_ENCODE_USING_EVAL = false;
    private static final String LOG_TAG = "JsMessageQueue";
    private static int MAX_PAYLOAD_SIZE = -1;
    private int activeListenerIndex;
    /* access modifiers changed from: private */
    public final CordovaInterface cordova;
    private boolean paused;
    /* access modifiers changed from: private */
    public final LinkedList<JsMessage> queue = new LinkedList<>();
    private final BridgeMode[] registeredListeners;
    /* access modifiers changed from: private */
    public final CordovaWebView webView;

    private interface BridgeMode {
        void onNativeToJsMessageAvailable();
    }

    public NativeToJsMessageQueue(CordovaWebView webView2, CordovaInterface cordova2) {
        this.cordova = cordova2;
        this.webView = webView2;
        this.registeredListeners = new BridgeMode[4];
        this.registeredListeners[0] = null;
        this.registeredListeners[1] = new LoadUrlBridgeMode();
        this.registeredListeners[2] = new OnlineEventsBridgeMode();
        this.registeredListeners[3] = new PrivateApiBridgeMode();
        reset();
    }

    public void setBridgeMode(int value) {
        if (value < 0 || value >= this.registeredListeners.length) {
            Log.d(LOG_TAG, "Invalid NativeToJsBridgeMode: " + value);
        } else if (value != this.activeListenerIndex) {
            Log.d(LOG_TAG, "Set native->JS mode to " + value);
            synchronized (this) {
                this.activeListenerIndex = value;
                BridgeMode activeListener = this.registeredListeners[value];
                if (!this.paused && !this.queue.isEmpty() && activeListener != null) {
                    activeListener.onNativeToJsMessageAvailable();
                }
            }
        }
    }

    public void reset() {
        synchronized (this) {
            this.queue.clear();
            setBridgeMode(2);
        }
    }

    private int calculatePackedMessageLength(JsMessage message) {
        int messageLen = message.calculateEncodedLength();
        return String.valueOf(messageLen).length() + messageLen + 1;
    }

    private void packMessage(JsMessage message, StringBuilder sb) {
        sb.append(message.calculateEncodedLength()).append(' ');
        message.encodeAsMessage(sb);
    }

    public String popAndEncode() {
        String sb;
        synchronized (this) {
            if (this.queue.isEmpty()) {
                sb = null;
            } else {
                int totalPayloadLen = 0;
                int numMessagesToSend = 0;
                Iterator i$ = this.queue.iterator();
                while (i$.hasNext()) {
                    int messageSize = calculatePackedMessageLength((JsMessage) i$.next());
                    if (numMessagesToSend > 0 && totalPayloadLen + messageSize > MAX_PAYLOAD_SIZE && MAX_PAYLOAD_SIZE > 0) {
                        break;
                    }
                    totalPayloadLen += messageSize;
                    numMessagesToSend++;
                }
                StringBuilder sb2 = new StringBuilder(totalPayloadLen);
                for (int i = 0; i < numMessagesToSend; i++) {
                    packMessage(this.queue.removeFirst(), sb2);
                }
                if (!this.queue.isEmpty()) {
                    sb2.append('*');
                }
                sb = sb2.toString();
            }
        }
        return sb;
    }

    /* access modifiers changed from: private */
    public String popAndEncodeAsJs() {
        boolean willSendAllMessages;
        String sb;
        synchronized (this) {
            if (this.queue.size() == 0) {
                sb = null;
            } else {
                int totalPayloadLen = 0;
                int numMessagesToSend = 0;
                Iterator i$ = this.queue.iterator();
                while (i$.hasNext()) {
                    int messageSize = ((JsMessage) i$.next()).calculateEncodedLength() + 50;
                    if (numMessagesToSend > 0 && totalPayloadLen + messageSize > MAX_PAYLOAD_SIZE && MAX_PAYLOAD_SIZE > 0) {
                        break;
                    }
                    totalPayloadLen += messageSize;
                    numMessagesToSend++;
                }
                if (numMessagesToSend == this.queue.size()) {
                    willSendAllMessages = true;
                } else {
                    willSendAllMessages = false;
                }
                StringBuilder sb2 = new StringBuilder((willSendAllMessages ? 0 : 100) + totalPayloadLen);
                for (int i = 0; i < numMessagesToSend; i++) {
                    JsMessage message = this.queue.removeFirst();
                    if (!willSendAllMessages || i + 1 != numMessagesToSend) {
                        sb2.append("try{");
                        message.encodeAsJsMessage(sb2);
                        sb2.append("}finally{");
                    } else {
                        message.encodeAsJsMessage(sb2);
                    }
                }
                if (!willSendAllMessages) {
                    sb2.append("window.setTimeout(function(){cordova.require('cordova/plugin/android/polling').pollOnce();},0);");
                }
                for (int i2 = willSendAllMessages ? 1 : 0; i2 < numMessagesToSend; i2++) {
                    sb2.append('}');
                }
                sb = sb2.toString();
            }
        }
        return sb;
    }

    public void addJavaScript(String statement) {
        enqueueMessage(new JsMessage(statement));
    }

    public void addPluginResult(PluginResult result, String callbackId) {
        if (callbackId == null) {
            Log.e(LOG_TAG, "Got plugin result with no callbackId", new Throwable());
            return;
        }
        boolean noResult = result.getStatus() == PluginResult.Status.NO_RESULT.ordinal();
        boolean keepCallback = result.getKeepCallback();
        if (!noResult || !keepCallback) {
            enqueueMessage(new JsMessage(result, callbackId));
        }
    }

    private void enqueueMessage(JsMessage message) {
        synchronized (this) {
            this.queue.add(message);
            if (!this.paused && this.registeredListeners[this.activeListenerIndex] != null) {
                this.registeredListeners[this.activeListenerIndex].onNativeToJsMessageAvailable();
            }
        }
    }

    public void setPaused(boolean value) {
        if (this.paused && value) {
            Log.e(LOG_TAG, "nested call to setPaused detected.", new Throwable());
        }
        this.paused = value;
        if (!value) {
            synchronized (this) {
                if (!this.queue.isEmpty() && this.registeredListeners[this.activeListenerIndex] != null) {
                    this.registeredListeners[this.activeListenerIndex].onNativeToJsMessageAvailable();
                }
            }
        }
    }

    public boolean getPaused() {
        return this.paused;
    }

    private class LoadUrlBridgeMode implements BridgeMode {
        final Runnable runnable;

        private LoadUrlBridgeMode() {
            this.runnable = new Runnable() {
                public void run() {
                    String js = NativeToJsMessageQueue.this.popAndEncodeAsJs();
                    if (js != null) {
                        NativeToJsMessageQueue.this.webView.loadUrlNow("javascript:" + js);
                    }
                }
            };
        }

        public void onNativeToJsMessageAvailable() {
            NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.runnable);
        }
    }

    private class OnlineEventsBridgeMode implements BridgeMode {
        boolean online = true;
        final Runnable runnable = new Runnable() {
            public void run() {
                if (!NativeToJsMessageQueue.this.queue.isEmpty()) {
                    OnlineEventsBridgeMode.this.online = !OnlineEventsBridgeMode.this.online;
                    NativeToJsMessageQueue.this.webView.setNetworkAvailable(OnlineEventsBridgeMode.this.online);
                }
            }
        };

        OnlineEventsBridgeMode() {
            NativeToJsMessageQueue.this.webView.setNetworkAvailable(true);
        }

        public void onNativeToJsMessageAvailable() {
            NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.runnable);
        }
    }

    private class PrivateApiBridgeMode implements BridgeMode {
        private static final int EXECUTE_JS = 194;
        boolean initFailed;
        Method sendMessageMethod;
        Object webViewCore;

        private PrivateApiBridgeMode() {
        }

        private void initReflection() {
            Object webViewObject = NativeToJsMessageQueue.this.webView;
            Class webViewClass = WebView.class;
            try {
                Field f = webViewClass.getDeclaredField("mProvider");
                f.setAccessible(true);
                webViewObject = f.get(NativeToJsMessageQueue.this.webView);
                webViewClass = webViewObject.getClass();
            } catch (Throwable th) {
            }
            try {
                Field f2 = webViewClass.getDeclaredField("mWebViewCore");
                f2.setAccessible(true);
                this.webViewCore = f2.get(webViewObject);
                if (this.webViewCore != null) {
                    this.sendMessageMethod = this.webViewCore.getClass().getDeclaredMethod("sendMessage", new Class[]{Message.class});
                    this.sendMessageMethod.setAccessible(true);
                }
            } catch (Throwable e) {
                this.initFailed = true;
                Log.e(NativeToJsMessageQueue.LOG_TAG, "PrivateApiBridgeMode failed to find the expected APIs.", e);
            }
        }

        public void onNativeToJsMessageAvailable() {
            if (this.sendMessageMethod == null && !this.initFailed) {
                initReflection();
            }
            if (this.sendMessageMethod != null) {
                Message execJsMessage = Message.obtain((Handler) null, EXECUTE_JS, NativeToJsMessageQueue.this.popAndEncodeAsJs());
                try {
                    this.sendMessageMethod.invoke(this.webViewCore, new Object[]{execJsMessage});
                } catch (Throwable e) {
                    Log.e(NativeToJsMessageQueue.LOG_TAG, "Reflection message bridge failed.", e);
                }
            }
        }
    }

    private static class JsMessage {
        final String jsPayloadOrCallbackId;
        final PluginResult pluginResult;

        JsMessage(String js) {
            if (js == null) {
                throw new NullPointerException();
            }
            this.jsPayloadOrCallbackId = js;
            this.pluginResult = null;
        }

        JsMessage(PluginResult pluginResult2, String callbackId) {
            if (callbackId == null || pluginResult2 == null) {
                throw new NullPointerException();
            }
            this.jsPayloadOrCallbackId = callbackId;
            this.pluginResult = pluginResult2;
        }

        /* access modifiers changed from: package-private */
        public int calculateEncodedLength() {
            if (this.pluginResult == null) {
                return this.jsPayloadOrCallbackId.length() + 1;
            }
            int ret = String.valueOf(this.pluginResult.getStatus()).length() + 2 + 1 + this.jsPayloadOrCallbackId.length() + 1;
            switch (this.pluginResult.getMessageType()) {
                case 1:
                    return ret + this.pluginResult.getStrMessage().length() + 1;
                case 3:
                    return ret + this.pluginResult.getMessage().length() + 1;
                case 4:
                case 5:
                    return ret + 1;
                default:
                    return ret + this.pluginResult.getMessage().length();
            }
        }

        /* access modifiers changed from: package-private */
        public void encodeAsMessage(StringBuilder sb) {
            boolean noResult;
            boolean resultOk;
            if (this.pluginResult == null) {
                sb.append('J').append(this.jsPayloadOrCallbackId);
                return;
            }
            int status = this.pluginResult.getStatus();
            if (status == PluginResult.Status.NO_RESULT.ordinal()) {
                noResult = true;
            } else {
                noResult = false;
            }
            if (status == PluginResult.Status.OK.ordinal()) {
                resultOk = true;
            } else {
                resultOk = false;
            }
            sb.append((noResult || resultOk) ? 'S' : 'F').append(this.pluginResult.getKeepCallback() ? '1' : '0').append(status).append(' ').append(this.jsPayloadOrCallbackId).append(' ');
            switch (this.pluginResult.getMessageType()) {
                case 1:
                    sb.append('s');
                    sb.append(this.pluginResult.getStrMessage());
                    return;
                case 3:
                    sb.append('n').append(this.pluginResult.getMessage());
                    return;
                case 4:
                    sb.append(this.pluginResult.getMessage().charAt(0));
                    return;
                case 5:
                    sb.append('N');
                    return;
                default:
                    sb.append(this.pluginResult.getMessage());
                    return;
            }
        }

        /* access modifiers changed from: package-private */
        public void encodeAsJsMessage(StringBuilder sb) {
            if (this.pluginResult == null) {
                sb.append(this.jsPayloadOrCallbackId);
                return;
            }
            int status = this.pluginResult.getStatus();
            sb.append("cordova.callbackFromNative('").append(this.jsPayloadOrCallbackId).append("',").append(status == PluginResult.Status.OK.ordinal() || status == PluginResult.Status.NO_RESULT.ordinal()).append(",").append(status).append(",").append(this.pluginResult.getMessage()).append(",").append(this.pluginResult.getKeepCallback()).append(");");
        }
    }
}
