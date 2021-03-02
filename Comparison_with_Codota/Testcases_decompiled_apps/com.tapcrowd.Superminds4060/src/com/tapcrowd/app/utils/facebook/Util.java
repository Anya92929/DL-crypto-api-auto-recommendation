package com.tapcrowd.app.utils.facebook;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.location.LocationStatusCodes;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.apache.cordova.Globalization;
import org.apache.http.entity.mime.MIME;
import org.json.JSONException;
import org.json.JSONObject;

public final class Util {
    private static boolean ENABLE_LOG = false;

    public static String encodePostBody(Bundle parameters, String boundary) {
        if (parameters == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String key : parameters.keySet()) {
            if (parameters.getByteArray(key) == null) {
                sb.append("Content-Disposition: form-data; name=\"" + key + "\"\r\n\r\n" + parameters.getString(key));
                sb.append("\r\n--" + boundary + "\r\n");
            }
        }
        return sb.toString();
    }

    public static String encodeUrl(Bundle parameters) {
        if (parameters == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String key : parameters.keySet()) {
            if (first) {
                first = false;
            } else {
                sb.append("&");
            }
            if (parameters != null) {
                sb.append(String.valueOf(URLEncoder.encode(key)) + "=" + URLEncoder.encode(parameters.getString(key)));
            }
        }
        return sb.toString();
    }

    public static Bundle decodeUrl(String s) {
        Bundle params = new Bundle();
        if (s != null) {
            for (String parameter : s.split("&")) {
                String[] v = parameter.split("=");
                if (v.length > 1) {
                    params.putString(URLDecoder.decode(v[0]), URLDecoder.decode(v[1]));
                }
            }
        }
        return params;
    }

    public static Bundle parseUrl(String url) {
        try {
            URL u = new URL(url.replace("fbconnect", "http"));
            Bundle b = decodeUrl(u.getQuery());
            b.putAll(decodeUrl(u.getRef()));
            return b;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static String openUrl(String url, String method, Bundle params) throws MalformedURLException, IOException {
        if (method.equals("GET")) {
            url = String.valueOf(url) + "?" + encodeUrl(params);
        }
        logd("Facebook-Util", String.valueOf(method) + " URL: " + url);
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestProperty("User-Agent", String.valueOf(System.getProperties().getProperty("http.agent")) + " FacebookAndroidSDK");
        if (!method.equals("GET")) {
            Bundle dataparams = new Bundle();
            for (String key : params.keySet()) {
                if (params.getByteArray(key) != null) {
                    dataparams.putByteArray(key, params.getByteArray(key));
                }
            }
            if (!params.containsKey("method")) {
                params.putString("method", method);
            }
            if (params.containsKey("access_token")) {
                params.putString("access_token", URLDecoder.decode(params.getString("access_token")));
            }
            conn.setRequestMethod("POST");
            conn.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data;boundary=" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.connect();
            OutputStream os = new BufferedOutputStream(conn.getOutputStream());
            os.write(("--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
            os.write(encodePostBody(params, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
            os.write((String.valueOf("\r\n") + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
            if (!dataparams.isEmpty()) {
                for (String key2 : dataparams.keySet()) {
                    os.write(("Content-Disposition: form-data; filename=\"" + key2 + "\"" + "\r\n").getBytes());
                    os.write(("Content-Type: content/unknown" + "\r\n" + "\r\n").getBytes());
                    os.write(dataparams.getByteArray(key2));
                    os.write((String.valueOf("\r\n") + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
                }
            }
            os.flush();
        }
        try {
            return read(conn.getInputStream());
        } catch (FileNotFoundException e) {
            return read(conn.getErrorStream());
        }
    }

    private static String read(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(in), LocationStatusCodes.GEOFENCE_NOT_AVAILABLE);
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            sb.append(line);
        }
        in.close();
        return sb.toString();
    }

    public static void clearCookies(Context context) {
        CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
    }

    public static JSONObject parseJson(String response) throws JSONException, FacebookError {
        if (response.equals("false")) {
            throw new FacebookError("request failed");
        }
        if (response.equals("true")) {
            response = "{value : true}";
        }
        JSONObject json = new JSONObject(response);
        if (json.has(GCMConstants.EXTRA_ERROR)) {
            JSONObject error = json.getJSONObject(GCMConstants.EXTRA_ERROR);
            throw new FacebookError(error.getString("message"), error.getString(Globalization.TYPE), 0);
        } else if (json.has("error_code") && json.has("error_msg")) {
            throw new FacebookError(json.getString("error_msg"), "", Integer.parseInt(json.getString("error_code")));
        } else if (json.has("error_code")) {
            throw new FacebookError("request failed", "", Integer.parseInt(json.getString("error_code")));
        } else if (json.has("error_msg")) {
            throw new FacebookError(json.getString("error_msg"));
        } else if (!json.has("error_reason")) {
            return json;
        } else {
            throw new FacebookError(json.getString("error_reason"));
        }
    }

    public static void showAlert(Context context, String title, String text) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setTitle(title);
        alertBuilder.setMessage(text);
        alertBuilder.create().show();
    }

    public static void logd(String tag, String msg) {
        if (ENABLE_LOG) {
            Log.d(tag, msg);
        }
    }
}
