package org.apache.cordova;

import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.model.OAuthConstants;
import twitter4j.internal.http.HttpResponseCode;

public class FileTransfer extends CordovaPlugin {
    public static int ABORTED_ERR = 4;
    private static final String BOUNDARY = "+++++";
    public static int CONNECTION_ERR = 3;
    /* access modifiers changed from: private */
    public static final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };
    public static int FILE_NOT_FOUND_ERR = 1;
    public static int INVALID_URL_ERR = 2;
    private static final String LINE_END = "\r\n";
    private static final String LINE_START = "--";
    private static final String LOG_TAG = "FileTransfer";
    private static final int MAX_BUFFER_SIZE = 16384;
    /* access modifiers changed from: private */
    public static HashMap<String, RequestContext> activeRequests = new HashMap<>();
    private static final TrustManager[] trustAllCerts = {new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
    }};

    private static final class RequestContext {
        boolean aborted;
        CallbackContext callbackContext;
        InputStream currentInputStream;
        OutputStream currentOutputStream;
        String source;
        String target;

        RequestContext(String source2, String target2, CallbackContext callbackContext2) {
            this.source = source2;
            this.target = target2;
            this.callbackContext = callbackContext2;
        }

        /* access modifiers changed from: package-private */
        public void sendPluginResult(PluginResult pluginResult) {
            synchronized (this) {
                if (!this.aborted) {
                    this.callbackContext.sendPluginResult(pluginResult);
                }
            }
        }
    }

    private static final class DoneHandlerInputStream extends FilterInputStream {
        private boolean done;

        public DoneHandlerInputStream(InputStream stream) {
            super(stream);
        }

        public int read() throws IOException {
            int result = this.done ? -1 : super.read();
            this.done = result == -1;
            return result;
        }

        public int read(byte[] buffer) throws IOException {
            int result = this.done ? -1 : super.read(buffer);
            this.done = result == -1;
            return result;
        }

        public int read(byte[] bytes, int offset, int count) throws IOException {
            int result = this.done ? -1 : super.read(bytes, offset, count);
            this.done = result == -1;
            return result;
        }
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("upload") || action.equals("download")) {
            String source = args.getString(0);
            String target = args.getString(1);
            if (action.equals("upload")) {
                try {
                    upload(URLDecoder.decode(source, "UTF-8"), target, args, callbackContext);
                    return true;
                } catch (UnsupportedEncodingException e) {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.MALFORMED_URL_EXCEPTION, "UTF-8 error."));
                    return true;
                }
            } else {
                download(source, target, args, callbackContext);
                return true;
            }
        } else if (!action.equals("abort")) {
            return false;
        } else {
            abort(args.getString(0));
            callbackContext.success();
            return true;
        }
    }

    private void upload(String source, String target, JSONArray args, CallbackContext callbackContext) throws JSONException {
        final JSONObject headers;
        Log.d(LOG_TAG, "upload " + source + " to " + target);
        final String fileKey = getArgument(args, 2, "file");
        final String fileName = getArgument(args, 3, "image.jpg");
        final String mimeType = getArgument(args, 4, "image/jpeg");
        final JSONObject params = args.optJSONObject(5) == null ? new JSONObject() : args.optJSONObject(5);
        final boolean trustEveryone = args.optBoolean(6);
        final boolean chunkedMode = args.optBoolean(7) || args.isNull(7);
        if (args.optJSONObject(8) == null) {
            headers = params.optJSONObject("headers");
        } else {
            headers = args.optJSONObject(8);
        }
        final String objectId = args.getString(9);
        Log.d(LOG_TAG, "fileKey: " + fileKey);
        Log.d(LOG_TAG, "fileName: " + fileName);
        Log.d(LOG_TAG, "mimeType: " + mimeType);
        Log.d(LOG_TAG, "params: " + params);
        Log.d(LOG_TAG, "trustEveryone: " + trustEveryone);
        Log.d(LOG_TAG, "chunkedMode: " + chunkedMode);
        Log.d(LOG_TAG, "headers: " + headers);
        Log.d(LOG_TAG, "objectId: " + objectId);
        try {
            final URL url = new URL(target);
            final boolean useHttps = url.getProtocol().toLowerCase().equals("https");
            final RequestContext context = new RequestContext(source, target, callbackContext);
            synchronized (activeRequests) {
                activeRequests.put(objectId, context);
            }
            final String str = target;
            final String str2 = source;
            this.cordova.getThreadPool().execute(new Runnable() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX WARNING: type inference failed for: r42v33, types: [java.net.URLConnection] */
                /* JADX WARNING: type inference failed for: r42v162, types: [java.net.URLConnection] */
                /* JADX WARNING: Code restructure failed: missing block: B:100:0x03f7, code lost:
                    if (r7 != null) goto L_0x03f9;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:105:0x0409, code lost:
                    r19 = (javax.net.ssl.HttpsURLConnection) r7;
                    r19.setHostnameVerifier(r25);
                    r19.setSSLSocketFactory(r26);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:106:0x041b, code lost:
                    r7.disconnect();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
                    r10.write(r13);
                    r10.write(r15);
                    r10.writeBytes(r24);
                    r4 = java.lang.Math.min(r35.available(), 16384);
                    r3 = new byte[r4];
                    r6 = r35.read(r3, 0, r4);
                    r39 = 0;
                    r28 = 0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:117:0x0455, code lost:
                    if (r6 <= 0) goto L_0x0571;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:118:0x0457, code lost:
                    r39 = r39 + ((long) r6);
                    r34.setBytesSent(r39);
                    r10.write(r3, 0, r4);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:119:0x0471, code lost:
                    if (r39 <= (102400 + r28)) goto L_0x04a5;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:120:0x0473, code lost:
                    r28 = r39;
                    android.util.Log.d(org.apache.cordova.FileTransfer.LOG_TAG, "Uploaded " + r39 + " of " + r16 + " bytes");
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:121:0x04a5, code lost:
                    r4 = java.lang.Math.min(r35.available(), 16384);
                    r6 = r35.read(r3, 0, r4);
                    r30.setLoaded(r39);
                    r0 = new org.apache.cordova.api.PluginResult(org.apache.cordova.api.PluginResult.Status.OK, r30.toJSONObject());
                    r0.setKeepCallback(true);
                    r5.sendPluginResult(r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:127:0x04f4, code lost:
                    r11 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
                    r12 = org.apache.cordova.FileTransfer.access$500(org.apache.cordova.FileTransfer.CONNECTION_ERR, r15, r9, r7);
                    android.util.Log.e(org.apache.cordova.FileTransfer.LOG_TAG, r12.toString(), r11);
                    r5.sendPluginResult(new org.apache.cordova.api.PluginResult(org.apache.cordova.api.PluginResult.Status.IO_EXCEPTION, r12));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:131:0x0532, code lost:
                    monitor-enter(org.apache.cordova.FileTransfer.access$600());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
                    org.apache.cordova.FileTransfer.access$600().remove(r17);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:135:0x0545, code lost:
                    if (r7 != null) goto L_0x0547;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:140:0x0557, code lost:
                    r19 = (javax.net.ssl.HttpsURLConnection) r7;
                    r19.setHostnameVerifier(r25);
                    r19.setSSLSocketFactory(r26);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:141:0x0569, code lost:
                    r7.disconnect();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:147:0x0571, code lost:
                    r10.writeBytes("\r\n--+++++--\r\n");
                    r10.flush();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
                    org.apache.cordova.FileTransfer.access$300(r35);
                    org.apache.cordova.FileTransfer.access$300(r10);
                    r5.currentOutputStream = null;
                    r32 = r7.getResponseCode();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:150:0x0590, code lost:
                    r21 = null;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
                    r21 = org.apache.cordova.FileTransfer.access$400(r7);
                    r43 = r5;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:153:0x059d, code lost:
                    monitor-enter(r43);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:157:0x05aa, code lost:
                    if (r5.aborted == false) goto L_0x0601;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:158:0x05ac, code lost:
                    monitor-exit(r43);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
                    r5.currentInputStream = null;
                    org.apache.cordova.FileTransfer.access$300(r21);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:162:0x05be, code lost:
                    r43 = org.apache.cordova.FileTransfer.access$600();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:163:0x05c2, code lost:
                    monitor-enter(r43);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:165:?, code lost:
                    org.apache.cordova.FileTransfer.access$600().remove(r17);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:166:0x05d4, code lost:
                    monitor-exit(r43);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:167:0x05d5, code lost:
                    if (r7 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:169:0x05dd, code lost:
                    if (r7 == false) goto L_0x05f9;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:171:0x05e5, code lost:
                    if (r6 == false) goto L_0x05f9;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:172:0x05e7, code lost:
                    r19 = (javax.net.ssl.HttpsURLConnection) r7;
                    r19.setHostnameVerifier(r25);
                    r19.setSSLSocketFactory(r26);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:173:0x05f9, code lost:
                    r7.disconnect();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:180:?, code lost:
                    r5.currentInputStream = r21;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:181:0x060d, code lost:
                    monitor-exit(r43);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:183:?, code lost:
                    r27 = new java.io.ByteArrayOutputStream();
                    r3 = new byte[1024];
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:184:0x061a, code lost:
                    r6 = r21.read(r3);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:185:0x0620, code lost:
                    if (r6 <= 0) goto L_0x06a0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:186:0x0622, code lost:
                    r27.write(r3, 0, r6);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:187:0x062c, code lost:
                    r42 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:190:?, code lost:
                    r5.currentInputStream = null;
                    org.apache.cordova.FileTransfer.access$300(r21);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:191:0x063e, code lost:
                    throw r42;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:192:0x063f, code lost:
                    r11 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:195:?, code lost:
                    android.util.Log.e(org.apache.cordova.FileTransfer.LOG_TAG, r11.getMessage(), r11);
                    r5.sendPluginResult(new org.apache.cordova.api.PluginResult(org.apache.cordova.api.PluginResult.Status.JSON_EXCEPTION));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:197:0x0661, code lost:
                    monitor-enter(org.apache.cordova.FileTransfer.access$600());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:199:?, code lost:
                    org.apache.cordova.FileTransfer.access$600().remove(r17);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:201:0x0674, code lost:
                    if (r7 != null) goto L_0x0676;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:206:0x0686, code lost:
                    r19 = (javax.net.ssl.HttpsURLConnection) r7;
                    r19.setHostnameVerifier(r25);
                    r19.setSSLSocketFactory(r26);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:207:0x0698, code lost:
                    r7.disconnect();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:213:0x06a0, code lost:
                    r33 = r27.toString("UTF-8");
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:216:?, code lost:
                    r5.currentInputStream = null;
                    org.apache.cordova.FileTransfer.access$300(r21);
                    android.util.Log.d(org.apache.cordova.FileTransfer.LOG_TAG, "got response from server");
                    android.util.Log.d(org.apache.cordova.FileTransfer.LOG_TAG, r33.substring(0, java.lang.Math.min(256, r33.length())));
                    r34.setResponseCode(r32);
                    r34.setResponse(r33);
                    r5.sendPluginResult(new org.apache.cordova.api.PluginResult(org.apache.cordova.api.PluginResult.Status.OK, r34.toJSONObject()));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:217:0x06ff, code lost:
                    r43 = org.apache.cordova.FileTransfer.access$600();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:218:0x0703, code lost:
                    monitor-enter(r43);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:220:?, code lost:
                    org.apache.cordova.FileTransfer.access$600().remove(r17);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:221:0x0715, code lost:
                    monitor-exit(r43);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:222:0x0716, code lost:
                    if (r7 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:224:0x071e, code lost:
                    if (r7 == false) goto L_0x073a;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:226:0x0726, code lost:
                    if (r6 == false) goto L_0x073a;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:227:0x0728, code lost:
                    r19 = (javax.net.ssl.HttpsURLConnection) r7;
                    r19.setHostnameVerifier(r25);
                    r19.setSSLSocketFactory(r26);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:228:0x073a, code lost:
                    r7.disconnect();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:245:0x074b, code lost:
                    r37 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:247:?, code lost:
                    r12 = org.apache.cordova.FileTransfer.access$500(org.apache.cordova.FileTransfer.CONNECTION_ERR, r15, r9, r7);
                    android.util.Log.e(org.apache.cordova.FileTransfer.LOG_TAG, r12.toString(), r37);
                    r5.sendPluginResult(new org.apache.cordova.api.PluginResult(org.apache.cordova.api.PluginResult.Status.IO_EXCEPTION, r12));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:249:0x078b, code lost:
                    monitor-enter(org.apache.cordova.FileTransfer.access$600());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:251:?, code lost:
                    org.apache.cordova.FileTransfer.access$600().remove(r17);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:253:0x079e, code lost:
                    if (r7 != null) goto L_0x07a0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:258:0x07b0, code lost:
                    r19 = (javax.net.ssl.HttpsURLConnection) r7;
                    r19.setHostnameVerifier(r25);
                    r19.setSSLSocketFactory(r26);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:259:0x07c2, code lost:
                    r7.disconnect();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:264:0x07ca, code lost:
                    r42 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:266:0x07cf, code lost:
                    monitor-enter(org.apache.cordova.FileTransfer.access$600());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:268:?, code lost:
                    org.apache.cordova.FileTransfer.access$600().remove(r17);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:270:0x07de, code lost:
                    if (r7 != null) goto L_0x07e0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:275:0x07f0, code lost:
                    r19 = (javax.net.ssl.HttpsURLConnection) r7;
                    r19.setHostnameVerifier(r25);
                    r19.setSSLSocketFactory(r26);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:276:0x0802, code lost:
                    r7.disconnect();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:277:0x0805, code lost:
                    throw r42;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:324:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:325:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:326:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:327:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:328:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:329:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:330:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:331:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:332:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:333:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:334:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:335:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:336:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:337:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
                    org.apache.cordova.FileTransfer.access$300(r35);
                    org.apache.cordova.FileTransfer.access$300(r10);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:75:0x0358, code lost:
                    r43 = org.apache.cordova.FileTransfer.access$600();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:76:0x035c, code lost:
                    monitor-enter(r43);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
                    org.apache.cordova.FileTransfer.access$600().remove(r17);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:79:0x036e, code lost:
                    monitor-exit(r43);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:80:0x036f, code lost:
                    if (r7 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:82:0x0377, code lost:
                    if (r7 == false) goto L_0x0393;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:84:0x037f, code lost:
                    if (r6 == false) goto L_0x0393;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:85:0x0381, code lost:
                    r19 = (javax.net.ssl.HttpsURLConnection) r7;
                    r19.setHostnameVerifier(r25);
                    r19.setSSLSocketFactory(r26);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:86:0x0393, code lost:
                    r7.disconnect();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:92:0x03a6, code lost:
                    r11 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
                    r12 = org.apache.cordova.FileTransfer.access$500(org.apache.cordova.FileTransfer.FILE_NOT_FOUND_ERR, r15, r9, r7);
                    android.util.Log.e(org.apache.cordova.FileTransfer.LOG_TAG, r12.toString(), r11);
                    r5.sendPluginResult(new org.apache.cordova.api.PluginResult(org.apache.cordova.api.PluginResult.Status.IO_EXCEPTION, r12));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:96:0x03e4, code lost:
                    monitor-enter(org.apache.cordova.FileTransfer.access$600());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
                    org.apache.cordova.FileTransfer.access$600().remove(r17);
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Multi-variable type inference failed */
                /* JADX WARNING: Removed duplicated region for block: B:127:0x04f4 A[ExcHandler: IOException (r11v1 'e' java.io.IOException A[CUSTOM_DECLARE]), PHI: r7 r25 r26 
                  PHI: (r7v4 'conn' java.net.HttpURLConnection) = (r7v0 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v0 'conn' java.net.HttpURLConnection) binds: [B:3:0x0014, B:34:0x0138, B:90:0x03a2, B:91:?, B:124:0x04ed, B:148:0x0579, B:149:?, B:189:0x062f, B:215:0x06ac, B:216:?, B:160:0x05af, B:161:?, B:73:0x0352, B:74:?, B:43:0x01de, B:15:0x0090, B:28:0x0101] A[DONT_GENERATE, DONT_INLINE]
                  PHI: (r25v4 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier) = (r25v0 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v0 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier) binds: [B:3:0x0014, B:34:0x0138, B:90:0x03a2, B:91:?, B:124:0x04ed, B:148:0x0579, B:149:?, B:189:0x062f, B:215:0x06ac, B:216:?, B:160:0x05af, B:161:?, B:73:0x0352, B:74:?, B:43:0x01de, B:15:0x0090, B:28:0x0101] A[DONT_GENERATE, DONT_INLINE]
                  PHI: (r26v4 'oldSocketFactory' javax.net.ssl.SSLSocketFactory) = (r26v0 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v0 'oldSocketFactory' javax.net.ssl.SSLSocketFactory) binds: [B:3:0x0014, B:34:0x0138, B:90:0x03a2, B:91:?, B:124:0x04ed, B:148:0x0579, B:149:?, B:189:0x062f, B:215:0x06ac, B:216:?, B:160:0x05af, B:161:?, B:73:0x0352, B:74:?, B:43:0x01de, B:15:0x0090, B:28:0x0101] A[DONT_GENERATE, DONT_INLINE], Splitter:B:3:0x0014] */
                /* JADX WARNING: Removed duplicated region for block: B:245:0x074b A[ExcHandler: Throwable (r37v0 't' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r7 r25 r26 
                  PHI: (r7v2 'conn' java.net.HttpURLConnection) = (r7v0 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v0 'conn' java.net.HttpURLConnection) binds: [B:3:0x0014, B:34:0x0138, B:90:0x03a2, B:91:?, B:124:0x04ed, B:148:0x0579, B:149:?, B:189:0x062f, B:215:0x06ac, B:216:?, B:160:0x05af, B:161:?, B:73:0x0352, B:74:?, B:43:0x01de, B:15:0x0090, B:28:0x0101] A[DONT_GENERATE, DONT_INLINE]
                  PHI: (r25v2 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier) = (r25v0 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v0 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier) binds: [B:3:0x0014, B:34:0x0138, B:90:0x03a2, B:91:?, B:124:0x04ed, B:148:0x0579, B:149:?, B:189:0x062f, B:215:0x06ac, B:216:?, B:160:0x05af, B:161:?, B:73:0x0352, B:74:?, B:43:0x01de, B:15:0x0090, B:28:0x0101] A[DONT_GENERATE, DONT_INLINE]
                  PHI: (r26v2 'oldSocketFactory' javax.net.ssl.SSLSocketFactory) = (r26v0 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v0 'oldSocketFactory' javax.net.ssl.SSLSocketFactory) binds: [B:3:0x0014, B:34:0x0138, B:90:0x03a2, B:91:?, B:124:0x04ed, B:148:0x0579, B:149:?, B:189:0x062f, B:215:0x06ac, B:216:?, B:160:0x05af, B:161:?, B:73:0x0352, B:74:?, B:43:0x01de, B:15:0x0090, B:28:0x0101] A[DONT_GENERATE, DONT_INLINE], Splitter:B:3:0x0014] */
                /* JADX WARNING: Removed duplicated region for block: B:92:0x03a6 A[ExcHandler: FileNotFoundException (r11v2 'e' java.io.FileNotFoundException A[CUSTOM_DECLARE]), PHI: r7 r25 r26 
                  PHI: (r7v5 'conn' java.net.HttpURLConnection) = (r7v0 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v7 'conn' java.net.HttpURLConnection), (r7v0 'conn' java.net.HttpURLConnection) binds: [B:3:0x0014, B:34:0x0138, B:90:0x03a2, B:91:?, B:124:0x04ed, B:148:0x0579, B:149:?, B:189:0x062f, B:215:0x06ac, B:216:?, B:160:0x05af, B:161:?, B:73:0x0352, B:74:?, B:43:0x01de, B:15:0x0090, B:28:0x0101] A[DONT_GENERATE, DONT_INLINE]
                  PHI: (r25v5 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier) = (r25v0 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v6 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier), (r25v0 'oldHostnameVerifier' javax.net.ssl.HostnameVerifier) binds: [B:3:0x0014, B:34:0x0138, B:90:0x03a2, B:91:?, B:124:0x04ed, B:148:0x0579, B:149:?, B:189:0x062f, B:215:0x06ac, B:216:?, B:160:0x05af, B:161:?, B:73:0x0352, B:74:?, B:43:0x01de, B:15:0x0090, B:28:0x0101] A[DONT_GENERATE, DONT_INLINE]
                  PHI: (r26v5 'oldSocketFactory' javax.net.ssl.SSLSocketFactory) = (r26v0 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v6 'oldSocketFactory' javax.net.ssl.SSLSocketFactory), (r26v0 'oldSocketFactory' javax.net.ssl.SSLSocketFactory) binds: [B:3:0x0014, B:34:0x0138, B:90:0x03a2, B:91:?, B:124:0x04ed, B:148:0x0579, B:149:?, B:189:0x062f, B:215:0x06ac, B:216:?, B:160:0x05af, B:161:?, B:73:0x0352, B:74:?, B:43:0x01de, B:15:0x0090, B:28:0x0101] A[DONT_GENERATE, DONT_INLINE], Splitter:B:3:0x0014] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r46 = this;
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5
                        r42 = r0
                        r0 = r42
                        boolean r0 = r0.aborted
                        r42 = r0
                        if (r42 == 0) goto L_0x000f
                    L_0x000e:
                        return
                    L_0x000f:
                        r7 = 0
                        r25 = 0
                        r26 = 0
                        org.apache.cordova.FileUploadResult r34 = new org.apache.cordova.FileUploadResult     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r34.<init>()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        org.apache.cordova.FileProgressResult r30 = new org.apache.cordova.FileProgressResult     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r30.<init>()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r46
                        boolean r0 = r6     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        if (r42 == 0) goto L_0x0122
                        r0 = r46
                        boolean r0 = r7     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        if (r42 != 0) goto L_0x00ff
                        r0 = r46
                        java.net.URL r0 = r8     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        java.net.URLConnection r42 = r42.openConnection()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r42
                        javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r7 = r0
                    L_0x003d:
                        r42 = 1
                        r0 = r42
                        r7.setDoInput(r0)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = 1
                        r0 = r42
                        r7.setDoOutput(r0)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = 0
                        r0 = r42
                        r7.setUseCaches(r0)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r42 = "POST"
                        r0 = r42
                        r7.setRequestMethod(r0)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r42 = "Connection"
                        java.lang.String r43 = "Keep-Alive"
                        r0 = r42
                        r1 = r43
                        r7.setRequestProperty(r0, r1)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r42 = "Content-Type"
                        java.lang.String r43 = "multipart/form-data;boundary=+++++"
                        r0 = r42
                        r1 = r43
                        r7.setRequestProperty(r0, r1)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        android.webkit.CookieManager r42 = android.webkit.CookieManager.getInstance()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r46
                        java.lang.String r0 = r9     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r43 = r0
                        java.lang.String r8 = r42.getCookie(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        if (r8 == 0) goto L_0x0086
                        java.lang.String r42 = "Cookie"
                        r0 = r42
                        r7.setRequestProperty(r0, r8)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                    L_0x0086:
                        r0 = r46
                        org.json.JSONObject r0 = r10     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        if (r42 == 0) goto L_0x0134
                        r0 = r46
                        org.json.JSONObject r0 = r10     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r42 = r0
                        java.util.Iterator r22 = r42.keys()     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                    L_0x0098:
                        boolean r42 = r22.hasNext()     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        if (r42 == 0) goto L_0x0134
                        java.lang.Object r42 = r22.next()     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r17 = r42.toString()     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r0 = r46
                        org.json.JSONObject r0 = r10     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r42 = r0
                        r0 = r42
                        r1 = r17
                        org.json.JSONArray r18 = r0.optJSONArray(r1)     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        if (r18 != 0) goto L_0x00d0
                        org.json.JSONArray r18 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r18.<init>()     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r0 = r46
                        org.json.JSONObject r0 = r10     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r42 = r0
                        r0 = r42
                        r1 = r17
                        java.lang.String r42 = r0.getString(r1)     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r0 = r18
                        r1 = r42
                        r0.put(r1)     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                    L_0x00d0:
                        r42 = 0
                        r0 = r18
                        r1 = r42
                        java.lang.String r42 = r0.getString(r1)     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r0 = r17
                        r1 = r42
                        r7.setRequestProperty(r0, r1)     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r20 = 1
                    L_0x00e3:
                        int r42 = r18.length()     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r0 = r20
                        r1 = r42
                        if (r0 >= r1) goto L_0x0098
                        r0 = r18
                        r1 = r20
                        java.lang.String r42 = r0.getString(r1)     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r0 = r17
                        r1 = r42
                        r7.addRequestProperty(r0, r1)     // Catch:{ JSONException -> 0x0133, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        int r20 = r20 + 1
                        goto L_0x00e3
                    L_0x00ff:
                        r0 = r46
                        java.net.URL r0 = r8     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        java.net.URLConnection r19 = r42.openConnection()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        javax.net.ssl.HttpsURLConnection r19 = (javax.net.ssl.HttpsURLConnection) r19     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        javax.net.ssl.SSLSocketFactory r26 = org.apache.cordova.FileTransfer.trustAllHosts(r19)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        javax.net.ssl.HostnameVerifier r25 = r19.getHostnameVerifier()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        javax.net.ssl.HostnameVerifier r42 = org.apache.cordova.FileTransfer.DO_NOT_VERIFY     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r19
                        r1 = r42
                        r0.setHostnameVerifier(r1)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r7 = r19
                        goto L_0x003d
                    L_0x0122:
                        r0 = r46
                        java.net.URL r0 = r8     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        java.net.URLConnection r42 = r42.openConnection()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r42
                        java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r7 = r0
                        goto L_0x003d
                    L_0x0133:
                        r42 = move-exception
                    L_0x0134:
                        java.lang.String r14 = ""
                        r0 = r46
                        org.json.JSONObject r0 = r11     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r42 = r0
                        java.util.Iterator r22 = r42.keys()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                    L_0x0140:
                        boolean r42 = r22.hasNext()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        if (r42 == 0) goto L_0x01e9
                        java.lang.Object r23 = r22.next()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r42 = java.lang.String.valueOf(r23)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r43 = "headers"
                        boolean r42 = r42.equals(r43)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        if (r42 != 0) goto L_0x0140
                        java.lang.StringBuilder r42 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r42.<init>()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r0 = r42
                        java.lang.StringBuilder r42 = r0.append(r14)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r43 = "--+++++\r\n"
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r14 = r42.toString()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.StringBuilder r42 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r42.<init>()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r0 = r42
                        java.lang.StringBuilder r42 = r0.append(r14)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r43 = "Content-Disposition: form-data; name=\""
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r43 = r23.toString()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r43 = "\";"
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r14 = r42.toString()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.StringBuilder r42 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r42.<init>()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r0 = r42
                        java.lang.StringBuilder r42 = r0.append(r14)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r43 = "\r\n\r\n"
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r14 = r42.toString()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.StringBuilder r42 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r42.<init>()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r0 = r42
                        java.lang.StringBuilder r42 = r0.append(r14)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r0 = r46
                        org.json.JSONObject r0 = r11     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r43 = r0
                        java.lang.String r44 = r23.toString()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r43 = r43.getString(r44)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r14 = r42.toString()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.StringBuilder r42 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r42.<init>()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        r0 = r42
                        java.lang.StringBuilder r42 = r0.append(r14)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r43 = "\r\n"
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        java.lang.String r14 = r42.toString()     // Catch:{ JSONException -> 0x01db, FileNotFoundException -> 0x03a6, IOException -> 0x04f4, Throwable -> 0x074b }
                        goto L_0x0140
                    L_0x01db:
                        r11 = move-exception
                        java.lang.String r42 = "FileTransfer"
                        java.lang.String r43 = r11.getMessage()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r42
                        r1 = r43
                        android.util.Log.e(r0, r1, r11)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                    L_0x01e9:
                        java.lang.StringBuilder r42 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42.<init>()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r42
                        java.lang.StringBuilder r42 = r0.append(r14)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r43 = "--+++++\r\n"
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r14 = r42.toString()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.StringBuilder r42 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42.<init>()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r42
                        java.lang.StringBuilder r42 = r0.append(r14)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r43 = "Content-Disposition: form-data; name=\""
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r46
                        java.lang.String r0 = r12     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r43 = r0
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r43 = "\";"
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r43 = " filename=\""
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r14 = r42.toString()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r42 = "UTF-8"
                        r0 = r42
                        byte[] r13 = r14.getBytes(r0)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.StringBuilder r42 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42.<init>()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r43 = "\"\r\nContent-Type: "
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r46
                        java.lang.String r0 = r13     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r43 = r0
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r43 = "\r\n"
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r43 = "\r\n"
                        java.lang.StringBuilder r42 = r42.append(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r24 = r42.toString()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r38 = "\r\n--+++++--\r\n"
                        r0 = r46
                        java.lang.String r0 = r14     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        java.lang.String r43 = "UTF-8"
                        byte[] r15 = r42.getBytes(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r46
                        org.apache.cordova.FileTransfer r0 = org.apache.cordova.FileTransfer.this     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        r0 = r46
                        java.lang.String r0 = r15     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r43 = r0
                        java.io.InputStream r35 = r42.getPathFromUri(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        int r0 = r13.length     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        int r43 = r24.length()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        int r42 = r42 + r43
                        int r43 = r38.length()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        int r42 = r42 + r43
                        int r0 = r15.length     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r43 = r0
                        int r36 = r42 + r43
                        java.lang.String r42 = "FileTransfer"
                        java.lang.StringBuilder r43 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r43.<init>()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r44 = "String Length: "
                        java.lang.StringBuilder r43 = r43.append(r44)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r43
                        r1 = r36
                        java.lang.StringBuilder r43 = r0.append(r1)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r43 = r43.toString()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        android.util.Log.d(r42, r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r16 = -1
                        r0 = r35
                        boolean r0 = r0 instanceof java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        if (r42 == 0) goto L_0x02d8
                        r0 = r35
                        java.io.FileInputStream r0 = (java.io.FileInputStream) r0     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        java.nio.channels.FileChannel r42 = r42.getChannel()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        long r42 = r42.size()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r42
                        int r0 = (int) r0     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        int r16 = r42 + r36
                        r42 = 1
                        r0 = r30
                        r1 = r42
                        r0.setLengthComputable(r1)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r16
                        long r0 = (long) r0     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        r0 = r30
                        r1 = r42
                        r0.setTotal(r1)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                    L_0x02d8:
                        java.lang.String r42 = "FileTransfer"
                        java.lang.StringBuilder r43 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r43.<init>()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r44 = "Content Length: "
                        java.lang.StringBuilder r43 = r43.append(r44)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r43
                        r1 = r16
                        java.lang.StringBuilder r43 = r0.append(r1)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r43 = r43.toString()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        android.util.Log.d(r42, r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r46
                        boolean r0 = r16     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        if (r42 == 0) goto L_0x0398
                        int r42 = android.os.Build.VERSION.SDK_INT     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r43 = 8
                        r0 = r42
                        r1 = r43
                        if (r0 < r1) goto L_0x030e
                        r0 = r46
                        boolean r0 = r6     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        if (r42 == 0) goto L_0x0398
                    L_0x030e:
                        r41 = 1
                    L_0x0310:
                        if (r41 != 0) goto L_0x031a
                        r42 = -1
                        r0 = r16
                        r1 = r42
                        if (r0 != r1) goto L_0x039c
                    L_0x031a:
                        r41 = 1
                    L_0x031c:
                        if (r41 == 0) goto L_0x03a0
                        r42 = 16384(0x4000, float:2.2959E-41)
                        r0 = r42
                        r7.setChunkedStreamingMode(r0)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r42 = "Transfer-Encoding"
                        java.lang.String r43 = "chunked"
                        r0 = r42
                        r1 = r43
                        r7.setRequestProperty(r0, r1)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                    L_0x0330:
                        r9 = 0
                        java.io.DataOutputStream r10 = new java.io.DataOutputStream     // Catch:{ all -> 0x0809 }
                        java.io.OutputStream r42 = r7.getOutputStream()     // Catch:{ all -> 0x0809 }
                        r0 = r42
                        r10.<init>(r0)     // Catch:{ all -> 0x0809 }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ all -> 0x04eb }
                        r43 = r0
                        monitor-enter(r43)     // Catch:{ all -> 0x04eb }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ all -> 0x056e }
                        r42 = r0
                        r0 = r42
                        boolean r0 = r0.aborted     // Catch:{ all -> 0x056e }
                        r42 = r0
                        if (r42 == 0) goto L_0x0423
                        monitor-exit(r43)     // Catch:{ all -> 0x056e }
                        org.apache.cordova.FileTransfer.safeClose(r35)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        org.apache.cordova.FileTransfer.safeClose(r10)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.util.HashMap r43 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r43)
                        java.util.HashMap r42 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x0420 }
                        r0 = r46
                        java.lang.String r0 = r17     // Catch:{ all -> 0x0420 }
                        r44 = r0
                        r0 = r42
                        r1 = r44
                        r0.remove(r1)     // Catch:{ all -> 0x0420 }
                        monitor-exit(r43)     // Catch:{ all -> 0x0420 }
                        if (r7 == 0) goto L_0x000e
                        r0 = r46
                        boolean r0 = r7
                        r42 = r0
                        if (r42 == 0) goto L_0x0393
                        r0 = r46
                        boolean r0 = r6
                        r42 = r0
                        if (r42 == 0) goto L_0x0393
                        r19 = r7
                        javax.net.ssl.HttpsURLConnection r19 = (javax.net.ssl.HttpsURLConnection) r19
                        r0 = r19
                        r1 = r25
                        r0.setHostnameVerifier(r1)
                        r0 = r19
                        r1 = r26
                        r0.setSSLSocketFactory(r1)
                    L_0x0393:
                        r7.disconnect()
                        goto L_0x000e
                    L_0x0398:
                        r41 = 0
                        goto L_0x0310
                    L_0x039c:
                        r41 = 0
                        goto L_0x031c
                    L_0x03a0:
                        r0 = r16
                        r7.setFixedLengthStreamingMode(r0)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        goto L_0x0330
                    L_0x03a6:
                        r11 = move-exception
                        int r42 = org.apache.cordova.FileTransfer.FILE_NOT_FOUND_ERR     // Catch:{ all -> 0x07ca }
                        r0 = r46
                        java.lang.String r0 = r15     // Catch:{ all -> 0x07ca }
                        r43 = r0
                        r0 = r46
                        java.lang.String r0 = r9     // Catch:{ all -> 0x07ca }
                        r44 = r0
                        r0 = r42
                        r1 = r43
                        r2 = r44
                        org.json.JSONObject r12 = org.apache.cordova.FileTransfer.createFileTransferError((int) r0, (java.lang.String) r1, (java.lang.String) r2, (java.net.HttpURLConnection) r7)     // Catch:{ all -> 0x07ca }
                        java.lang.String r42 = "FileTransfer"
                        java.lang.String r43 = r12.toString()     // Catch:{ all -> 0x07ca }
                        r0 = r42
                        r1 = r43
                        android.util.Log.e(r0, r1, r11)     // Catch:{ all -> 0x07ca }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ all -> 0x07ca }
                        r42 = r0
                        org.apache.cordova.api.PluginResult r43 = new org.apache.cordova.api.PluginResult     // Catch:{ all -> 0x07ca }
                        org.apache.cordova.api.PluginResult$Status r44 = org.apache.cordova.api.PluginResult.Status.IO_EXCEPTION     // Catch:{ all -> 0x07ca }
                        r0 = r43
                        r1 = r44
                        r0.<init>((org.apache.cordova.api.PluginResult.Status) r1, (org.json.JSONObject) r12)     // Catch:{ all -> 0x07ca }
                        r42.sendPluginResult(r43)     // Catch:{ all -> 0x07ca }
                        java.util.HashMap r43 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r43)
                        java.util.HashMap r42 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x0742 }
                        r0 = r46
                        java.lang.String r0 = r17     // Catch:{ all -> 0x0742 }
                        r44 = r0
                        r0 = r42
                        r1 = r44
                        r0.remove(r1)     // Catch:{ all -> 0x0742 }
                        monitor-exit(r43)     // Catch:{ all -> 0x0742 }
                        if (r7 == 0) goto L_0x000e
                        r0 = r46
                        boolean r0 = r7
                        r42 = r0
                        if (r42 == 0) goto L_0x041b
                        r0 = r46
                        boolean r0 = r6
                        r42 = r0
                        if (r42 == 0) goto L_0x041b
                        r19 = r7
                        javax.net.ssl.HttpsURLConnection r19 = (javax.net.ssl.HttpsURLConnection) r19
                        r0 = r19
                        r1 = r25
                        r0.setHostnameVerifier(r1)
                        r0 = r19
                        r1 = r26
                        r0.setSSLSocketFactory(r1)
                    L_0x041b:
                        r7.disconnect()
                        goto L_0x000e
                    L_0x0420:
                        r42 = move-exception
                        monitor-exit(r43)     // Catch:{ all -> 0x0420 }
                        throw r42
                    L_0x0423:
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ all -> 0x056e }
                        r42 = r0
                        r0 = r42
                        r0.currentOutputStream = r10     // Catch:{ all -> 0x056e }
                        monitor-exit(r43)     // Catch:{ all -> 0x056e }
                        r10.write(r13)     // Catch:{ all -> 0x04eb }
                        r10.write(r15)     // Catch:{ all -> 0x04eb }
                        r0 = r24
                        r10.writeBytes(r0)     // Catch:{ all -> 0x04eb }
                        int r5 = r35.available()     // Catch:{ all -> 0x04eb }
                        r42 = 16384(0x4000, float:2.2959E-41)
                        r0 = r42
                        int r4 = java.lang.Math.min(r5, r0)     // Catch:{ all -> 0x04eb }
                        byte[] r3 = new byte[r4]     // Catch:{ all -> 0x04eb }
                        r42 = 0
                        r0 = r35
                        r1 = r42
                        int r6 = r0.read(r3, r1, r4)     // Catch:{ all -> 0x04eb }
                        r39 = 0
                        r28 = 0
                    L_0x0455:
                        if (r6 <= 0) goto L_0x0571
                        long r0 = (long) r6     // Catch:{ all -> 0x04eb }
                        r42 = r0
                        long r39 = r39 + r42
                        r0 = r34
                        r1 = r39
                        r0.setBytesSent(r1)     // Catch:{ all -> 0x04eb }
                        r42 = 0
                        r0 = r42
                        r10.write(r3, r0, r4)     // Catch:{ all -> 0x04eb }
                        r42 = 102400(0x19000, double:5.05923E-319)
                        long r42 = r42 + r28
                        int r42 = (r39 > r42 ? 1 : (r39 == r42 ? 0 : -1))
                        if (r42 <= 0) goto L_0x04a5
                        r28 = r39
                        java.lang.String r42 = "FileTransfer"
                        java.lang.StringBuilder r43 = new java.lang.StringBuilder     // Catch:{ all -> 0x04eb }
                        r43.<init>()     // Catch:{ all -> 0x04eb }
                        java.lang.String r44 = "Uploaded "
                        java.lang.StringBuilder r43 = r43.append(r44)     // Catch:{ all -> 0x04eb }
                        r0 = r43
                        r1 = r39
                        java.lang.StringBuilder r43 = r0.append(r1)     // Catch:{ all -> 0x04eb }
                        java.lang.String r44 = " of "
                        java.lang.StringBuilder r43 = r43.append(r44)     // Catch:{ all -> 0x04eb }
                        r0 = r43
                        r1 = r16
                        java.lang.StringBuilder r43 = r0.append(r1)     // Catch:{ all -> 0x04eb }
                        java.lang.String r44 = " bytes"
                        java.lang.StringBuilder r43 = r43.append(r44)     // Catch:{ all -> 0x04eb }
                        java.lang.String r43 = r43.toString()     // Catch:{ all -> 0x04eb }
                        android.util.Log.d(r42, r43)     // Catch:{ all -> 0x04eb }
                    L_0x04a5:
                        int r5 = r35.available()     // Catch:{ all -> 0x04eb }
                        r42 = 16384(0x4000, float:2.2959E-41)
                        r0 = r42
                        int r4 = java.lang.Math.min(r5, r0)     // Catch:{ all -> 0x04eb }
                        r42 = 0
                        r0 = r35
                        r1 = r42
                        int r6 = r0.read(r3, r1, r4)     // Catch:{ all -> 0x04eb }
                        r0 = r30
                        r1 = r39
                        r0.setLoaded(r1)     // Catch:{ all -> 0x04eb }
                        org.apache.cordova.api.PluginResult r31 = new org.apache.cordova.api.PluginResult     // Catch:{ all -> 0x04eb }
                        org.apache.cordova.api.PluginResult$Status r42 = org.apache.cordova.api.PluginResult.Status.OK     // Catch:{ all -> 0x04eb }
                        org.json.JSONObject r43 = r30.toJSONObject()     // Catch:{ all -> 0x04eb }
                        r0 = r31
                        r1 = r42
                        r2 = r43
                        r0.<init>((org.apache.cordova.api.PluginResult.Status) r1, (org.json.JSONObject) r2)     // Catch:{ all -> 0x04eb }
                        r42 = 1
                        r0 = r31
                        r1 = r42
                        r0.setKeepCallback(r1)     // Catch:{ all -> 0x04eb }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ all -> 0x04eb }
                        r42 = r0
                        r0 = r42
                        r1 = r31
                        r0.sendPluginResult(r1)     // Catch:{ all -> 0x04eb }
                        goto L_0x0455
                    L_0x04eb:
                        r42 = move-exception
                        r9 = r10
                    L_0x04ed:
                        org.apache.cordova.FileTransfer.safeClose(r35)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        org.apache.cordova.FileTransfer.safeClose(r9)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        throw r42     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                    L_0x04f4:
                        r11 = move-exception
                        int r42 = org.apache.cordova.FileTransfer.CONNECTION_ERR     // Catch:{ all -> 0x07ca }
                        r0 = r46
                        java.lang.String r0 = r15     // Catch:{ all -> 0x07ca }
                        r43 = r0
                        r0 = r46
                        java.lang.String r0 = r9     // Catch:{ all -> 0x07ca }
                        r44 = r0
                        r0 = r42
                        r1 = r43
                        r2 = r44
                        org.json.JSONObject r12 = org.apache.cordova.FileTransfer.createFileTransferError((int) r0, (java.lang.String) r1, (java.lang.String) r2, (java.net.HttpURLConnection) r7)     // Catch:{ all -> 0x07ca }
                        java.lang.String r42 = "FileTransfer"
                        java.lang.String r43 = r12.toString()     // Catch:{ all -> 0x07ca }
                        r0 = r42
                        r1 = r43
                        android.util.Log.e(r0, r1, r11)     // Catch:{ all -> 0x07ca }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ all -> 0x07ca }
                        r42 = r0
                        org.apache.cordova.api.PluginResult r43 = new org.apache.cordova.api.PluginResult     // Catch:{ all -> 0x07ca }
                        org.apache.cordova.api.PluginResult$Status r44 = org.apache.cordova.api.PluginResult.Status.IO_EXCEPTION     // Catch:{ all -> 0x07ca }
                        r0 = r43
                        r1 = r44
                        r0.<init>((org.apache.cordova.api.PluginResult.Status) r1, (org.json.JSONObject) r12)     // Catch:{ all -> 0x07ca }
                        r42.sendPluginResult(r43)     // Catch:{ all -> 0x07ca }
                        java.util.HashMap r43 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r43)
                        java.util.HashMap r42 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x0745 }
                        r0 = r46
                        java.lang.String r0 = r17     // Catch:{ all -> 0x0745 }
                        r44 = r0
                        r0 = r42
                        r1 = r44
                        r0.remove(r1)     // Catch:{ all -> 0x0745 }
                        monitor-exit(r43)     // Catch:{ all -> 0x0745 }
                        if (r7 == 0) goto L_0x000e
                        r0 = r46
                        boolean r0 = r7
                        r42 = r0
                        if (r42 == 0) goto L_0x0569
                        r0 = r46
                        boolean r0 = r6
                        r42 = r0
                        if (r42 == 0) goto L_0x0569
                        r19 = r7
                        javax.net.ssl.HttpsURLConnection r19 = (javax.net.ssl.HttpsURLConnection) r19
                        r0 = r19
                        r1 = r25
                        r0.setHostnameVerifier(r1)
                        r0 = r19
                        r1 = r26
                        r0.setSSLSocketFactory(r1)
                    L_0x0569:
                        r7.disconnect()
                        goto L_0x000e
                    L_0x056e:
                        r42 = move-exception
                        monitor-exit(r43)     // Catch:{ all -> 0x056e }
                        throw r42     // Catch:{ all -> 0x04eb }
                    L_0x0571:
                        r0 = r38
                        r10.writeBytes(r0)     // Catch:{ all -> 0x04eb }
                        r10.flush()     // Catch:{ all -> 0x04eb }
                        org.apache.cordova.FileTransfer.safeClose(r35)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        org.apache.cordova.FileTransfer.safeClose(r10)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        r43 = 0
                        r0 = r43
                        r1 = r42
                        r1.currentOutputStream = r0     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        int r32 = r7.getResponseCode()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r21 = 0
                        java.io.InputStream r21 = org.apache.cordova.FileTransfer.getInputStream(r7)     // Catch:{ all -> 0x062c }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ all -> 0x062c }
                        r43 = r0
                        monitor-enter(r43)     // Catch:{ all -> 0x062c }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ all -> 0x069d }
                        r42 = r0
                        r0 = r42
                        boolean r0 = r0.aborted     // Catch:{ all -> 0x069d }
                        r42 = r0
                        if (r42 == 0) goto L_0x0601
                        monitor-exit(r43)     // Catch:{ all -> 0x069d }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        r43 = 0
                        r0 = r43
                        r1 = r42
                        r1.currentInputStream = r0     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        org.apache.cordova.FileTransfer.safeClose(r21)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.util.HashMap r43 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r43)
                        java.util.HashMap r42 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x05fe }
                        r0 = r46
                        java.lang.String r0 = r17     // Catch:{ all -> 0x05fe }
                        r44 = r0
                        r0 = r42
                        r1 = r44
                        r0.remove(r1)     // Catch:{ all -> 0x05fe }
                        monitor-exit(r43)     // Catch:{ all -> 0x05fe }
                        if (r7 == 0) goto L_0x000e
                        r0 = r46
                        boolean r0 = r7
                        r42 = r0
                        if (r42 == 0) goto L_0x05f9
                        r0 = r46
                        boolean r0 = r6
                        r42 = r0
                        if (r42 == 0) goto L_0x05f9
                        r19 = r7
                        javax.net.ssl.HttpsURLConnection r19 = (javax.net.ssl.HttpsURLConnection) r19
                        r0 = r19
                        r1 = r25
                        r0.setHostnameVerifier(r1)
                        r0 = r19
                        r1 = r26
                        r0.setSSLSocketFactory(r1)
                    L_0x05f9:
                        r7.disconnect()
                        goto L_0x000e
                    L_0x05fe:
                        r42 = move-exception
                        monitor-exit(r43)     // Catch:{ all -> 0x05fe }
                        throw r42
                    L_0x0601:
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ all -> 0x069d }
                        r42 = r0
                        r0 = r21
                        r1 = r42
                        r1.currentInputStream = r0     // Catch:{ all -> 0x069d }
                        monitor-exit(r43)     // Catch:{ all -> 0x069d }
                        java.io.ByteArrayOutputStream r27 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x062c }
                        r27.<init>()     // Catch:{ all -> 0x062c }
                        r42 = 1024(0x400, float:1.435E-42)
                        r0 = r42
                        byte[] r3 = new byte[r0]     // Catch:{ all -> 0x062c }
                        r6 = 0
                    L_0x061a:
                        r0 = r21
                        int r6 = r0.read(r3)     // Catch:{ all -> 0x062c }
                        if (r6 <= 0) goto L_0x06a0
                        r42 = 0
                        r0 = r27
                        r1 = r42
                        r0.write(r3, r1, r6)     // Catch:{ all -> 0x062c }
                        goto L_0x061a
                    L_0x062c:
                        r42 = move-exception
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r43 = r0
                        r44 = 0
                        r0 = r44
                        r1 = r43
                        r1.currentInputStream = r0     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        org.apache.cordova.FileTransfer.safeClose(r21)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        throw r42     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                    L_0x063f:
                        r11 = move-exception
                        java.lang.String r42 = "FileTransfer"
                        java.lang.String r43 = r11.getMessage()     // Catch:{ all -> 0x07ca }
                        r0 = r42
                        r1 = r43
                        android.util.Log.e(r0, r1, r11)     // Catch:{ all -> 0x07ca }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ all -> 0x07ca }
                        r42 = r0
                        org.apache.cordova.api.PluginResult r43 = new org.apache.cordova.api.PluginResult     // Catch:{ all -> 0x07ca }
                        org.apache.cordova.api.PluginResult$Status r44 = org.apache.cordova.api.PluginResult.Status.JSON_EXCEPTION     // Catch:{ all -> 0x07ca }
                        r43.<init>(r44)     // Catch:{ all -> 0x07ca }
                        r42.sendPluginResult(r43)     // Catch:{ all -> 0x07ca }
                        java.util.HashMap r43 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r43)
                        java.util.HashMap r42 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x0748 }
                        r0 = r46
                        java.lang.String r0 = r17     // Catch:{ all -> 0x0748 }
                        r44 = r0
                        r0 = r42
                        r1 = r44
                        r0.remove(r1)     // Catch:{ all -> 0x0748 }
                        monitor-exit(r43)     // Catch:{ all -> 0x0748 }
                        if (r7 == 0) goto L_0x000e
                        r0 = r46
                        boolean r0 = r7
                        r42 = r0
                        if (r42 == 0) goto L_0x0698
                        r0 = r46
                        boolean r0 = r6
                        r42 = r0
                        if (r42 == 0) goto L_0x0698
                        r19 = r7
                        javax.net.ssl.HttpsURLConnection r19 = (javax.net.ssl.HttpsURLConnection) r19
                        r0 = r19
                        r1 = r25
                        r0.setHostnameVerifier(r1)
                        r0 = r19
                        r1 = r26
                        r0.setSSLSocketFactory(r1)
                    L_0x0698:
                        r7.disconnect()
                        goto L_0x000e
                    L_0x069d:
                        r42 = move-exception
                        monitor-exit(r43)     // Catch:{ all -> 0x069d }
                        throw r42     // Catch:{ all -> 0x062c }
                    L_0x06a0:
                        java.lang.String r42 = "UTF-8"
                        r0 = r27
                        r1 = r42
                        java.lang.String r33 = r0.toString(r1)     // Catch:{ all -> 0x062c }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        r43 = 0
                        r0 = r43
                        r1 = r42
                        r1.currentInputStream = r0     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        org.apache.cordova.FileTransfer.safeClose(r21)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r42 = "FileTransfer"
                        java.lang.String r43 = "got response from server"
                        android.util.Log.d(r42, r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.lang.String r42 = "FileTransfer"
                        r43 = 0
                        r44 = 256(0x100, float:3.59E-43)
                        int r45 = r33.length()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        int r44 = java.lang.Math.min(r44, r45)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r33
                        r1 = r43
                        r2 = r44
                        java.lang.String r43 = r0.substring(r1, r2)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        android.util.Log.d(r42, r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r34
                        r1 = r32
                        r0.setResponseCode(r1)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r34
                        r1 = r33
                        r0.setResponse(r1)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42 = r0
                        org.apache.cordova.api.PluginResult r43 = new org.apache.cordova.api.PluginResult     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        org.apache.cordova.api.PluginResult$Status r44 = org.apache.cordova.api.PluginResult.Status.OK     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        org.json.JSONObject r45 = r34.toJSONObject()     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r43.<init>((org.apache.cordova.api.PluginResult.Status) r44, (org.json.JSONObject) r45)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        r42.sendPluginResult(r43)     // Catch:{ FileNotFoundException -> 0x03a6, IOException -> 0x04f4, JSONException -> 0x063f, Throwable -> 0x074b }
                        java.util.HashMap r43 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r43)
                        java.util.HashMap r42 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x073f }
                        r0 = r46
                        java.lang.String r0 = r17     // Catch:{ all -> 0x073f }
                        r44 = r0
                        r0 = r42
                        r1 = r44
                        r0.remove(r1)     // Catch:{ all -> 0x073f }
                        monitor-exit(r43)     // Catch:{ all -> 0x073f }
                        if (r7 == 0) goto L_0x000e
                        r0 = r46
                        boolean r0 = r7
                        r42 = r0
                        if (r42 == 0) goto L_0x073a
                        r0 = r46
                        boolean r0 = r6
                        r42 = r0
                        if (r42 == 0) goto L_0x073a
                        r19 = r7
                        javax.net.ssl.HttpsURLConnection r19 = (javax.net.ssl.HttpsURLConnection) r19
                        r0 = r19
                        r1 = r25
                        r0.setHostnameVerifier(r1)
                        r0 = r19
                        r1 = r26
                        r0.setSSLSocketFactory(r1)
                    L_0x073a:
                        r7.disconnect()
                        goto L_0x000e
                    L_0x073f:
                        r42 = move-exception
                        monitor-exit(r43)     // Catch:{ all -> 0x073f }
                        throw r42
                    L_0x0742:
                        r42 = move-exception
                        monitor-exit(r43)     // Catch:{ all -> 0x0742 }
                        throw r42
                    L_0x0745:
                        r42 = move-exception
                        monitor-exit(r43)     // Catch:{ all -> 0x0745 }
                        throw r42
                    L_0x0748:
                        r42 = move-exception
                        monitor-exit(r43)     // Catch:{ all -> 0x0748 }
                        throw r42
                    L_0x074b:
                        r37 = move-exception
                        int r42 = org.apache.cordova.FileTransfer.CONNECTION_ERR     // Catch:{ all -> 0x07ca }
                        r0 = r46
                        java.lang.String r0 = r15     // Catch:{ all -> 0x07ca }
                        r43 = r0
                        r0 = r46
                        java.lang.String r0 = r9     // Catch:{ all -> 0x07ca }
                        r44 = r0
                        r0 = r42
                        r1 = r43
                        r2 = r44
                        org.json.JSONObject r12 = org.apache.cordova.FileTransfer.createFileTransferError((int) r0, (java.lang.String) r1, (java.lang.String) r2, (java.net.HttpURLConnection) r7)     // Catch:{ all -> 0x07ca }
                        java.lang.String r42 = "FileTransfer"
                        java.lang.String r43 = r12.toString()     // Catch:{ all -> 0x07ca }
                        r0 = r42
                        r1 = r43
                        r2 = r37
                        android.util.Log.e(r0, r1, r2)     // Catch:{ all -> 0x07ca }
                        r0 = r46
                        org.apache.cordova.FileTransfer$RequestContext r0 = r5     // Catch:{ all -> 0x07ca }
                        r42 = r0
                        org.apache.cordova.api.PluginResult r43 = new org.apache.cordova.api.PluginResult     // Catch:{ all -> 0x07ca }
                        org.apache.cordova.api.PluginResult$Status r44 = org.apache.cordova.api.PluginResult.Status.IO_EXCEPTION     // Catch:{ all -> 0x07ca }
                        r0 = r43
                        r1 = r44
                        r0.<init>((org.apache.cordova.api.PluginResult.Status) r1, (org.json.JSONObject) r12)     // Catch:{ all -> 0x07ca }
                        r42.sendPluginResult(r43)     // Catch:{ all -> 0x07ca }
                        java.util.HashMap r43 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r43)
                        java.util.HashMap r42 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x07c7 }
                        r0 = r46
                        java.lang.String r0 = r17     // Catch:{ all -> 0x07c7 }
                        r44 = r0
                        r0 = r42
                        r1 = r44
                        r0.remove(r1)     // Catch:{ all -> 0x07c7 }
                        monitor-exit(r43)     // Catch:{ all -> 0x07c7 }
                        if (r7 == 0) goto L_0x000e
                        r0 = r46
                        boolean r0 = r7
                        r42 = r0
                        if (r42 == 0) goto L_0x07c2
                        r0 = r46
                        boolean r0 = r6
                        r42 = r0
                        if (r42 == 0) goto L_0x07c2
                        r19 = r7
                        javax.net.ssl.HttpsURLConnection r19 = (javax.net.ssl.HttpsURLConnection) r19
                        r0 = r19
                        r1 = r25
                        r0.setHostnameVerifier(r1)
                        r0 = r19
                        r1 = r26
                        r0.setSSLSocketFactory(r1)
                    L_0x07c2:
                        r7.disconnect()
                        goto L_0x000e
                    L_0x07c7:
                        r42 = move-exception
                        monitor-exit(r43)     // Catch:{ all -> 0x07c7 }
                        throw r42
                    L_0x07ca:
                        r42 = move-exception
                        java.util.HashMap r43 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r43)
                        java.util.HashMap r44 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x0806 }
                        r0 = r46
                        java.lang.String r0 = r17     // Catch:{ all -> 0x0806 }
                        r45 = r0
                        r44.remove(r45)     // Catch:{ all -> 0x0806 }
                        monitor-exit(r43)     // Catch:{ all -> 0x0806 }
                        if (r7 == 0) goto L_0x0805
                        r0 = r46
                        boolean r0 = r7
                        r43 = r0
                        if (r43 == 0) goto L_0x0802
                        r0 = r46
                        boolean r0 = r6
                        r43 = r0
                        if (r43 == 0) goto L_0x0802
                        r19 = r7
                        javax.net.ssl.HttpsURLConnection r19 = (javax.net.ssl.HttpsURLConnection) r19
                        r0 = r19
                        r1 = r25
                        r0.setHostnameVerifier(r1)
                        r0 = r19
                        r1 = r26
                        r0.setSSLSocketFactory(r1)
                    L_0x0802:
                        r7.disconnect()
                    L_0x0805:
                        throw r42
                    L_0x0806:
                        r42 = move-exception
                        monitor-exit(r43)     // Catch:{ all -> 0x0806 }
                        throw r42
                    L_0x0809:
                        r42 = move-exception
                        goto L_0x04ed
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.FileTransfer.C13101.run():void");
                }
            });
        } catch (MalformedURLException e) {
            JSONObject error = createFileTransferError(INVALID_URL_ERR, source, target, (Integer) 0);
            Log.e(LOG_TAG, error.toString(), e);
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, error));
        }
    }

    /* access modifiers changed from: private */
    public static void safeClose(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static InputStream getInputStream(HttpURLConnection conn) throws IOException {
        if (Build.VERSION.SDK_INT < 11) {
            return new DoneHandlerInputStream(conn.getInputStream());
        }
        return conn.getInputStream();
    }

    /* access modifiers changed from: private */
    public static SSLSocketFactory trustAllHosts(HttpsURLConnection connection) {
        SSLSocketFactory oldFactory = connection.getSSLSocketFactory();
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init((KeyManager[]) null, trustAllCerts, new SecureRandom());
            connection.setSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage(), e);
        }
        return oldFactory;
    }

    /* access modifiers changed from: private */
    public static JSONObject createFileTransferError(int errorCode, String source, String target, HttpURLConnection connection) {
        Integer httpStatus = null;
        if (connection != null) {
            try {
                httpStatus = Integer.valueOf(connection.getResponseCode());
            } catch (IOException e) {
                Log.w(LOG_TAG, "Error getting HTTP status code from connection.", e);
            }
        }
        return createFileTransferError(errorCode, source, target, httpStatus);
    }

    private static JSONObject createFileTransferError(int errorCode, String source, String target, Integer httpStatus) {
        JSONObject error = null;
        try {
            JSONObject error2 = new JSONObject();
            try {
                error2.put(OAuthConstants.CODE, errorCode);
                error2.put("source", source);
                error2.put("target", target);
                if (httpStatus != null) {
                    error2.put("http_status", httpStatus);
                }
                return error2;
            } catch (JSONException e) {
                e = e;
                error = error2;
                Log.e(LOG_TAG, e.getMessage(), e);
                return error;
            }
        } catch (JSONException e2) {
            e = e2;
            Log.e(LOG_TAG, e.getMessage(), e);
            return error;
        }
    }

    private static String getArgument(JSONArray args, int position, String defaultString) {
        String arg = defaultString;
        if (args.length() < position) {
            return arg;
        }
        String arg2 = args.optString(position);
        if (arg2 == null || "null".equals(arg2)) {
            return defaultString;
        }
        return arg2;
    }

    private void download(String source, String target, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d(LOG_TAG, "download " + source + " to " + target);
        final boolean trustEveryone = args.optBoolean(2);
        final String objectId = args.getString(3);
        try {
            final URL url = new URL(source);
            final boolean useHttps = url.getProtocol().toLowerCase().equals("https");
            if (!this.webView.isUrlWhiteListed(source)) {
                Log.w(LOG_TAG, "Source URL is not in white list: '" + source + "'");
                CallbackContext callbackContext2 = callbackContext;
                callbackContext2.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, createFileTransferError(CONNECTION_ERR, source, target, Integer.valueOf(HttpResponseCode.UNAUTHORIZED))));
                return;
            }
            final RequestContext context = new RequestContext(source, target, callbackContext);
            synchronized (activeRequests) {
                activeRequests.put(objectId, context);
            }
            final String str = target;
            final String str2 = source;
            this.cordova.getThreadPool().execute(new Runnable() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: javax.net.ssl.HttpsURLConnection} */
                /* JADX WARNING: type inference failed for: r21v35, types: [java.net.URLConnection] */
                /* JADX WARNING: type inference failed for: r21v71, types: [java.net.URLConnection] */
                /* JADX WARNING: Code restructure failed: missing block: B:208:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:209:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:212:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:213:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
                    r3.currentInputStream = null;
                    org.apache.cordova.FileTransfer.access$300(r13);
                    org.apache.cordova.FileTransfer.access$300(r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e1, code lost:
                    r22 = org.apache.cordova.FileTransfer.access$600();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e5, code lost:
                    monitor-enter(r22);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
                    org.apache.cordova.FileTransfer.access$600().remove(r9);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f7, code lost:
                    monitor-exit(r22);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f8, code lost:
                    if (r5 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:35:0x0100, code lost:
                    if (r6 == false) goto L_0x0113;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:37:0x0108, code lost:
                    if (r5 == false) goto L_0x0113;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:38:0x010a, code lost:
                    r12 = (javax.net.ssl.HttpsURLConnection) r5;
                    r12.setHostnameVerifier(r14);
                    r12.setSSLSocketFactory(r15);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:39:0x0113, code lost:
                    r5.disconnect();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
                    r3 = new byte[16384];
                    r19 = 0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:55:0x0160, code lost:
                    r4 = r13.read(r3);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:56:0x0164, code lost:
                    if (r4 <= 0) goto L_0x022d;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:57:0x0166, code lost:
                    r0.write(r3, 0, r4);
                    r19 = r19 + ((long) r4);
                    r17.setLoaded(r19);
                    r0 = new org.apache.cordova.api.PluginResult(org.apache.cordova.api.PluginResult.Status.OK, r17.toJSONObject());
                    r0.setKeepCallback(true);
                    r3.sendPluginResult(r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
                    r3.currentInputStream = null;
                    org.apache.cordova.FileTransfer.access$300(r13);
                    org.apache.cordova.FileTransfer.access$300(r0);
                    android.util.Log.d(org.apache.cordova.FileTransfer.LOG_TAG, "Saved file: " + r4);
                    r3.sendPluginResult(new org.apache.cordova.api.PluginResult(org.apache.cordova.api.PluginResult.Status.OK, new org.apache.cordova.FileUtils().getEntry(r9)));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:86:0x027c, code lost:
                    r22 = org.apache.cordova.FileTransfer.access$600();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:87:0x0280, code lost:
                    monitor-enter(r22);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
                    org.apache.cordova.FileTransfer.access$600().remove(r9);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:90:0x0292, code lost:
                    monitor-exit(r22);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:91:0x0293, code lost:
                    if (r5 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:93:0x029b, code lost:
                    if (r6 == false) goto L_0x02ae;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:95:0x02a3, code lost:
                    if (r5 == false) goto L_0x02ae;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:96:0x02a5, code lost:
                    r12 = (javax.net.ssl.HttpsURLConnection) r5;
                    r12.setHostnameVerifier(r14);
                    r12.setSSLSocketFactory(r15);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:97:0x02ae, code lost:
                    r5.disconnect();
                 */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r25 = this;
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3
                        r21 = r0
                        r0 = r21
                        boolean r0 = r0.aborted
                        r21 = r0
                        if (r21 == 0) goto L_0x000f
                    L_0x000e:
                        return
                    L_0x000f:
                        r5 = 0
                        r14 = 0
                        r15 = 0
                        r0 = r25
                        org.apache.cordova.FileTransfer r0 = org.apache.cordova.FileTransfer.this     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r21 = r0
                        r0 = r25
                        java.lang.String r0 = r4     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r22 = r0
                        java.io.File r9 = r21.getFileFromPath(r22)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        java.io.File r21 = r9.getParentFile()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r21.mkdirs()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r0 = r25
                        boolean r0 = r5     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r21 = r0
                        if (r21 == 0) goto L_0x0138
                        r0 = r25
                        boolean r0 = r6     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r21 = r0
                        if (r21 != 0) goto L_0x0118
                        r0 = r25
                        java.net.URL r0 = r7     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r21 = r0
                        java.net.URLConnection r21 = r21.openConnection()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r0 = r21
                        javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r5 = r0
                    L_0x0048:
                        java.lang.String r21 = "GET"
                        r0 = r21
                        r5.setRequestMethod(r0)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        android.webkit.CookieManager r21 = android.webkit.CookieManager.getInstance()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r0 = r25
                        java.lang.String r0 = r8     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r22 = r0
                        java.lang.String r6 = r21.getCookie(r22)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        if (r6 == 0) goto L_0x0066
                        java.lang.String r21 = "cookie"
                        r0 = r21
                        r5.setRequestProperty(r0, r6)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                    L_0x0066:
                        r5.connect()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        java.lang.String r21 = "FileTransfer"
                        java.lang.StringBuilder r22 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r22.<init>()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        java.lang.String r23 = "Download file:"
                        java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r0 = r25
                        java.net.URL r0 = r7     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r23 = r0
                        java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        java.lang.String r22 = r22.toString()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        android.util.Log.d(r21, r22)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        org.apache.cordova.FileProgressResult r17 = new org.apache.cordova.FileProgressResult     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r17.<init>()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        java.lang.String r21 = r5.getContentEncoding()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        if (r21 != 0) goto L_0x00ab
                        r21 = 1
                        r0 = r17
                        r1 = r21
                        r0.setLengthComputable(r1)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        int r21 = r5.getContentLength()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r0 = r21
                        long r0 = (long) r0     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r21 = r0
                        r0 = r17
                        r1 = r21
                        r0.setTotal(r1)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                    L_0x00ab:
                        java.io.FileOutputStream r16 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r0 = r16
                        r0.<init>(r9)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r13 = 0
                        java.io.InputStream r13 = org.apache.cordova.FileTransfer.getInputStream(r5)     // Catch:{ all -> 0x01a3 }
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3     // Catch:{ all -> 0x01a3 }
                        r22 = r0
                        monitor-enter(r22)     // Catch:{ all -> 0x01a3 }
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3     // Catch:{ all -> 0x022a }
                        r21 = r0
                        r0 = r21
                        boolean r0 = r0.aborted     // Catch:{ all -> 0x022a }
                        r21 = r0
                        if (r21 == 0) goto L_0x014c
                        monitor-exit(r22)     // Catch:{ all -> 0x022a }
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r21 = r0
                        r22 = 0
                        r0 = r22
                        r1 = r21
                        r1.currentInputStream = r0     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        org.apache.cordova.FileTransfer.safeClose(r13)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        org.apache.cordova.FileTransfer.safeClose(r16)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        java.util.HashMap r22 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r22)
                        java.util.HashMap r21 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x0149 }
                        r0 = r25
                        java.lang.String r0 = r9     // Catch:{ all -> 0x0149 }
                        r23 = r0
                        r0 = r21
                        r1 = r23
                        r0.remove(r1)     // Catch:{ all -> 0x0149 }
                        monitor-exit(r22)     // Catch:{ all -> 0x0149 }
                        if (r5 == 0) goto L_0x000e
                        r0 = r25
                        boolean r0 = r6
                        r21 = r0
                        if (r21 == 0) goto L_0x0113
                        r0 = r25
                        boolean r0 = r5
                        r21 = r0
                        if (r21 == 0) goto L_0x0113
                        r12 = r5
                        javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12
                        r12.setHostnameVerifier(r14)
                        r12.setSSLSocketFactory(r15)
                    L_0x0113:
                        r5.disconnect()
                        goto L_0x000e
                    L_0x0118:
                        r0 = r25
                        java.net.URL r0 = r7     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r21 = r0
                        java.net.URLConnection r12 = r21.openConnection()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        javax.net.ssl.SSLSocketFactory r15 = org.apache.cordova.FileTransfer.trustAllHosts(r12)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        javax.net.ssl.HostnameVerifier r14 = r12.getHostnameVerifier()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        javax.net.ssl.HostnameVerifier r21 = org.apache.cordova.FileTransfer.DO_NOT_VERIFY     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r0 = r21
                        r12.setHostnameVerifier(r0)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r5 = r12
                        goto L_0x0048
                    L_0x0138:
                        r0 = r25
                        java.net.URL r0 = r7     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r21 = r0
                        java.net.URLConnection r21 = r21.openConnection()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r0 = r21
                        java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r5 = r0
                        goto L_0x0048
                    L_0x0149:
                        r21 = move-exception
                        monitor-exit(r22)     // Catch:{ all -> 0x0149 }
                        throw r21
                    L_0x014c:
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3     // Catch:{ all -> 0x022a }
                        r21 = r0
                        r0 = r21
                        r0.currentInputStream = r13     // Catch:{ all -> 0x022a }
                        monitor-exit(r22)     // Catch:{ all -> 0x022a }
                        r21 = 16384(0x4000, float:2.2959E-41)
                        r0 = r21
                        byte[] r3 = new byte[r0]     // Catch:{ all -> 0x01a3 }
                        r4 = 0
                        r19 = 0
                    L_0x0160:
                        int r4 = r13.read(r3)     // Catch:{ all -> 0x01a3 }
                        if (r4 <= 0) goto L_0x022d
                        r21 = 0
                        r0 = r16
                        r1 = r21
                        r0.write(r3, r1, r4)     // Catch:{ all -> 0x01a3 }
                        long r0 = (long) r4     // Catch:{ all -> 0x01a3 }
                        r21 = r0
                        long r19 = r19 + r21
                        r0 = r17
                        r1 = r19
                        r0.setLoaded(r1)     // Catch:{ all -> 0x01a3 }
                        org.apache.cordova.api.PluginResult r18 = new org.apache.cordova.api.PluginResult     // Catch:{ all -> 0x01a3 }
                        org.apache.cordova.api.PluginResult$Status r21 = org.apache.cordova.api.PluginResult.Status.OK     // Catch:{ all -> 0x01a3 }
                        org.json.JSONObject r22 = r17.toJSONObject()     // Catch:{ all -> 0x01a3 }
                        r0 = r18
                        r1 = r21
                        r2 = r22
                        r0.<init>((org.apache.cordova.api.PluginResult.Status) r1, (org.json.JSONObject) r2)     // Catch:{ all -> 0x01a3 }
                        r21 = 1
                        r0 = r18
                        r1 = r21
                        r0.setKeepCallback(r1)     // Catch:{ all -> 0x01a3 }
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3     // Catch:{ all -> 0x01a3 }
                        r21 = r0
                        r0 = r21
                        r1 = r18
                        r0.sendPluginResult(r1)     // Catch:{ all -> 0x01a3 }
                        goto L_0x0160
                    L_0x01a3:
                        r21 = move-exception
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r22 = r0
                        r23 = 0
                        r0 = r23
                        r1 = r22
                        r1.currentInputStream = r0     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        org.apache.cordova.FileTransfer.safeClose(r13)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        org.apache.cordova.FileTransfer.safeClose(r16)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        throw r21     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                    L_0x01b9:
                        r7 = move-exception
                        int r21 = org.apache.cordova.FileTransfer.FILE_NOT_FOUND_ERR     // Catch:{ all -> 0x03f9 }
                        r0 = r25
                        java.lang.String r0 = r8     // Catch:{ all -> 0x03f9 }
                        r22 = r0
                        r0 = r25
                        java.lang.String r0 = r4     // Catch:{ all -> 0x03f9 }
                        r23 = r0
                        r0 = r21
                        r1 = r22
                        r2 = r23
                        org.json.JSONObject r8 = org.apache.cordova.FileTransfer.createFileTransferError((int) r0, (java.lang.String) r1, (java.lang.String) r2, (java.net.HttpURLConnection) r5)     // Catch:{ all -> 0x03f9 }
                        java.lang.String r21 = "FileTransfer"
                        java.lang.String r22 = r8.toString()     // Catch:{ all -> 0x03f9 }
                        r0 = r21
                        r1 = r22
                        android.util.Log.e(r0, r1, r7)     // Catch:{ all -> 0x03f9 }
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3     // Catch:{ all -> 0x03f9 }
                        r21 = r0
                        org.apache.cordova.api.PluginResult r22 = new org.apache.cordova.api.PluginResult     // Catch:{ all -> 0x03f9 }
                        org.apache.cordova.api.PluginResult$Status r23 = org.apache.cordova.api.PluginResult.Status.IO_EXCEPTION     // Catch:{ all -> 0x03f9 }
                        r0 = r22
                        r1 = r23
                        r0.<init>((org.apache.cordova.api.PluginResult.Status) r1, (org.json.JSONObject) r8)     // Catch:{ all -> 0x03f9 }
                        r21.sendPluginResult(r22)     // Catch:{ all -> 0x03f9 }
                        java.util.HashMap r22 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r22)
                        java.util.HashMap r21 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x02b6 }
                        r0 = r25
                        java.lang.String r0 = r9     // Catch:{ all -> 0x02b6 }
                        r23 = r0
                        r0 = r21
                        r1 = r23
                        r0.remove(r1)     // Catch:{ all -> 0x02b6 }
                        monitor-exit(r22)     // Catch:{ all -> 0x02b6 }
                        if (r5 == 0) goto L_0x000e
                        r0 = r25
                        boolean r0 = r6
                        r21 = r0
                        if (r21 == 0) goto L_0x0225
                        r0 = r25
                        boolean r0 = r5
                        r21 = r0
                        if (r21 == 0) goto L_0x0225
                        r12 = r5
                        javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12
                        r12.setHostnameVerifier(r14)
                        r12.setSSLSocketFactory(r15)
                    L_0x0225:
                        r5.disconnect()
                        goto L_0x000e
                    L_0x022a:
                        r21 = move-exception
                        monitor-exit(r22)     // Catch:{ all -> 0x022a }
                        throw r21     // Catch:{ all -> 0x01a3 }
                    L_0x022d:
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r21 = r0
                        r22 = 0
                        r0 = r22
                        r1 = r21
                        r1.currentInputStream = r0     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        org.apache.cordova.FileTransfer.safeClose(r13)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        org.apache.cordova.FileTransfer.safeClose(r16)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        java.lang.String r21 = "FileTransfer"
                        java.lang.StringBuilder r22 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r22.<init>()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        java.lang.String r23 = "Saved file: "
                        java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r0 = r25
                        java.lang.String r0 = r4     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r23 = r0
                        java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        java.lang.String r22 = r22.toString()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        android.util.Log.d(r21, r22)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        org.apache.cordova.FileUtils r11 = new org.apache.cordova.FileUtils     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r11.<init>()     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        org.json.JSONObject r10 = r11.getEntry((java.io.File) r9)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r21 = r0
                        org.apache.cordova.api.PluginResult r22 = new org.apache.cordova.api.PluginResult     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        org.apache.cordova.api.PluginResult$Status r23 = org.apache.cordova.api.PluginResult.Status.OK     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r0 = r22
                        r1 = r23
                        r0.<init>((org.apache.cordova.api.PluginResult.Status) r1, (org.json.JSONObject) r10)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        r21.sendPluginResult(r22)     // Catch:{ FileNotFoundException -> 0x01b9, IOException -> 0x02b9, JSONException -> 0x032d, Throwable -> 0x0385 }
                        java.util.HashMap r22 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r22)
                        java.util.HashMap r21 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x02b3 }
                        r0 = r25
                        java.lang.String r0 = r9     // Catch:{ all -> 0x02b3 }
                        r23 = r0
                        r0 = r21
                        r1 = r23
                        r0.remove(r1)     // Catch:{ all -> 0x02b3 }
                        monitor-exit(r22)     // Catch:{ all -> 0x02b3 }
                        if (r5 == 0) goto L_0x000e
                        r0 = r25
                        boolean r0 = r6
                        r21 = r0
                        if (r21 == 0) goto L_0x02ae
                        r0 = r25
                        boolean r0 = r5
                        r21 = r0
                        if (r21 == 0) goto L_0x02ae
                        r12 = r5
                        javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12
                        r12.setHostnameVerifier(r14)
                        r12.setSSLSocketFactory(r15)
                    L_0x02ae:
                        r5.disconnect()
                        goto L_0x000e
                    L_0x02b3:
                        r21 = move-exception
                        monitor-exit(r22)     // Catch:{ all -> 0x02b3 }
                        throw r21
                    L_0x02b6:
                        r21 = move-exception
                        monitor-exit(r22)     // Catch:{ all -> 0x02b6 }
                        throw r21
                    L_0x02b9:
                        r7 = move-exception
                        int r21 = org.apache.cordova.FileTransfer.CONNECTION_ERR     // Catch:{ all -> 0x03f9 }
                        r0 = r25
                        java.lang.String r0 = r8     // Catch:{ all -> 0x03f9 }
                        r22 = r0
                        r0 = r25
                        java.lang.String r0 = r4     // Catch:{ all -> 0x03f9 }
                        r23 = r0
                        r0 = r21
                        r1 = r22
                        r2 = r23
                        org.json.JSONObject r8 = org.apache.cordova.FileTransfer.createFileTransferError((int) r0, (java.lang.String) r1, (java.lang.String) r2, (java.net.HttpURLConnection) r5)     // Catch:{ all -> 0x03f9 }
                        java.lang.String r21 = "FileTransfer"
                        java.lang.String r22 = r8.toString()     // Catch:{ all -> 0x03f9 }
                        r0 = r21
                        r1 = r22
                        android.util.Log.e(r0, r1, r7)     // Catch:{ all -> 0x03f9 }
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3     // Catch:{ all -> 0x03f9 }
                        r21 = r0
                        org.apache.cordova.api.PluginResult r22 = new org.apache.cordova.api.PluginResult     // Catch:{ all -> 0x03f9 }
                        org.apache.cordova.api.PluginResult$Status r23 = org.apache.cordova.api.PluginResult.Status.IO_EXCEPTION     // Catch:{ all -> 0x03f9 }
                        r0 = r22
                        r1 = r23
                        r0.<init>((org.apache.cordova.api.PluginResult.Status) r1, (org.json.JSONObject) r8)     // Catch:{ all -> 0x03f9 }
                        r21.sendPluginResult(r22)     // Catch:{ all -> 0x03f9 }
                        java.util.HashMap r22 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r22)
                        java.util.HashMap r21 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x032a }
                        r0 = r25
                        java.lang.String r0 = r9     // Catch:{ all -> 0x032a }
                        r23 = r0
                        r0 = r21
                        r1 = r23
                        r0.remove(r1)     // Catch:{ all -> 0x032a }
                        monitor-exit(r22)     // Catch:{ all -> 0x032a }
                        if (r5 == 0) goto L_0x000e
                        r0 = r25
                        boolean r0 = r6
                        r21 = r0
                        if (r21 == 0) goto L_0x0325
                        r0 = r25
                        boolean r0 = r5
                        r21 = r0
                        if (r21 == 0) goto L_0x0325
                        r12 = r5
                        javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12
                        r12.setHostnameVerifier(r14)
                        r12.setSSLSocketFactory(r15)
                    L_0x0325:
                        r5.disconnect()
                        goto L_0x000e
                    L_0x032a:
                        r21 = move-exception
                        monitor-exit(r22)     // Catch:{ all -> 0x032a }
                        throw r21
                    L_0x032d:
                        r7 = move-exception
                        java.lang.String r21 = "FileTransfer"
                        java.lang.String r22 = r7.getMessage()     // Catch:{ all -> 0x03f9 }
                        r0 = r21
                        r1 = r22
                        android.util.Log.e(r0, r1, r7)     // Catch:{ all -> 0x03f9 }
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3     // Catch:{ all -> 0x03f9 }
                        r21 = r0
                        org.apache.cordova.api.PluginResult r22 = new org.apache.cordova.api.PluginResult     // Catch:{ all -> 0x03f9 }
                        org.apache.cordova.api.PluginResult$Status r23 = org.apache.cordova.api.PluginResult.Status.JSON_EXCEPTION     // Catch:{ all -> 0x03f9 }
                        r22.<init>(r23)     // Catch:{ all -> 0x03f9 }
                        r21.sendPluginResult(r22)     // Catch:{ all -> 0x03f9 }
                        java.util.HashMap r22 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r22)
                        java.util.HashMap r21 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x0382 }
                        r0 = r25
                        java.lang.String r0 = r9     // Catch:{ all -> 0x0382 }
                        r23 = r0
                        r0 = r21
                        r1 = r23
                        r0.remove(r1)     // Catch:{ all -> 0x0382 }
                        monitor-exit(r22)     // Catch:{ all -> 0x0382 }
                        if (r5 == 0) goto L_0x000e
                        r0 = r25
                        boolean r0 = r6
                        r21 = r0
                        if (r21 == 0) goto L_0x037d
                        r0 = r25
                        boolean r0 = r5
                        r21 = r0
                        if (r21 == 0) goto L_0x037d
                        r12 = r5
                        javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12
                        r12.setHostnameVerifier(r14)
                        r12.setSSLSocketFactory(r15)
                    L_0x037d:
                        r5.disconnect()
                        goto L_0x000e
                    L_0x0382:
                        r21 = move-exception
                        monitor-exit(r22)     // Catch:{ all -> 0x0382 }
                        throw r21
                    L_0x0385:
                        r7 = move-exception
                        int r21 = org.apache.cordova.FileTransfer.CONNECTION_ERR     // Catch:{ all -> 0x03f9 }
                        r0 = r25
                        java.lang.String r0 = r8     // Catch:{ all -> 0x03f9 }
                        r22 = r0
                        r0 = r25
                        java.lang.String r0 = r4     // Catch:{ all -> 0x03f9 }
                        r23 = r0
                        r0 = r21
                        r1 = r22
                        r2 = r23
                        org.json.JSONObject r8 = org.apache.cordova.FileTransfer.createFileTransferError((int) r0, (java.lang.String) r1, (java.lang.String) r2, (java.net.HttpURLConnection) r5)     // Catch:{ all -> 0x03f9 }
                        java.lang.String r21 = "FileTransfer"
                        java.lang.String r22 = r8.toString()     // Catch:{ all -> 0x03f9 }
                        r0 = r21
                        r1 = r22
                        android.util.Log.e(r0, r1, r7)     // Catch:{ all -> 0x03f9 }
                        r0 = r25
                        org.apache.cordova.FileTransfer$RequestContext r0 = r3     // Catch:{ all -> 0x03f9 }
                        r21 = r0
                        org.apache.cordova.api.PluginResult r22 = new org.apache.cordova.api.PluginResult     // Catch:{ all -> 0x03f9 }
                        org.apache.cordova.api.PluginResult$Status r23 = org.apache.cordova.api.PluginResult.Status.IO_EXCEPTION     // Catch:{ all -> 0x03f9 }
                        r0 = r22
                        r1 = r23
                        r0.<init>((org.apache.cordova.api.PluginResult.Status) r1, (org.json.JSONObject) r8)     // Catch:{ all -> 0x03f9 }
                        r21.sendPluginResult(r22)     // Catch:{ all -> 0x03f9 }
                        java.util.HashMap r22 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r22)
                        java.util.HashMap r21 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x03f6 }
                        r0 = r25
                        java.lang.String r0 = r9     // Catch:{ all -> 0x03f6 }
                        r23 = r0
                        r0 = r21
                        r1 = r23
                        r0.remove(r1)     // Catch:{ all -> 0x03f6 }
                        monitor-exit(r22)     // Catch:{ all -> 0x03f6 }
                        if (r5 == 0) goto L_0x000e
                        r0 = r25
                        boolean r0 = r6
                        r21 = r0
                        if (r21 == 0) goto L_0x03f1
                        r0 = r25
                        boolean r0 = r5
                        r21 = r0
                        if (r21 == 0) goto L_0x03f1
                        r12 = r5
                        javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12
                        r12.setHostnameVerifier(r14)
                        r12.setSSLSocketFactory(r15)
                    L_0x03f1:
                        r5.disconnect()
                        goto L_0x000e
                    L_0x03f6:
                        r21 = move-exception
                        monitor-exit(r22)     // Catch:{ all -> 0x03f6 }
                        throw r21
                    L_0x03f9:
                        r21 = move-exception
                        java.util.HashMap r22 = org.apache.cordova.FileTransfer.activeRequests
                        monitor-enter(r22)
                        java.util.HashMap r23 = org.apache.cordova.FileTransfer.activeRequests     // Catch:{ all -> 0x042c }
                        r0 = r25
                        java.lang.String r0 = r9     // Catch:{ all -> 0x042c }
                        r24 = r0
                        r23.remove(r24)     // Catch:{ all -> 0x042c }
                        monitor-exit(r22)     // Catch:{ all -> 0x042c }
                        if (r5 == 0) goto L_0x042b
                        r0 = r25
                        boolean r0 = r6
                        r22 = r0
                        if (r22 == 0) goto L_0x0428
                        r0 = r25
                        boolean r0 = r5
                        r22 = r0
                        if (r22 == 0) goto L_0x0428
                        r12 = r5
                        javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12
                        r12.setHostnameVerifier(r14)
                        r12.setSSLSocketFactory(r15)
                    L_0x0428:
                        r5.disconnect()
                    L_0x042b:
                        throw r21
                    L_0x042c:
                        r21 = move-exception
                        monitor-exit(r22)     // Catch:{ all -> 0x042c }
                        throw r21
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.FileTransfer.C13134.run():void");
                }
            });
        } catch (MalformedURLException e) {
            JSONObject error = createFileTransferError(INVALID_URL_ERR, source, target, (Integer) 0);
            Log.e(LOG_TAG, error.toString(), e);
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, error));
        }
    }

    /* access modifiers changed from: private */
    public InputStream getPathFromUri(String path) throws FileNotFoundException {
        if (path.startsWith("content:")) {
            return this.cordova.getActivity().getContentResolver().openInputStream(Uri.parse(path));
        } else if (!path.startsWith("file://")) {
            return new FileInputStream(path);
        } else {
            int question = path.indexOf("?");
            if (question == -1) {
                return new FileInputStream(path.substring(7));
            }
            return new FileInputStream(path.substring(7, question));
        }
    }

    /* access modifiers changed from: private */
    public File getFileFromPath(String path) throws FileNotFoundException {
        File file;
        if (path.startsWith("file://")) {
            file = new File(path.substring("file://".length()));
        } else {
            file = new File(path);
        }
        if (file.getParent() != null) {
            return file;
        }
        throw new FileNotFoundException();
    }

    private void abort(String objectId) {
        final RequestContext context;
        synchronized (activeRequests) {
            context = activeRequests.remove(objectId);
        }
        if (context != null) {
            JSONObject error = createFileTransferError(ABORTED_ERR, context.source, context.target, (Integer) -1);
            synchronized (context) {
                context.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, error));
                context.aborted = true;
            }
            this.cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    synchronized (context) {
                        FileTransfer.safeClose(context.currentInputStream);
                        FileTransfer.safeClose(context.currentOutputStream);
                    }
                }
            });
        }
    }
}
