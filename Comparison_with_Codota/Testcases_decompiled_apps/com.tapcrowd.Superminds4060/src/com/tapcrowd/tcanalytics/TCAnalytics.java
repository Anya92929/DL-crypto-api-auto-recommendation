package com.tapcrowd.tcanalytics;

import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class TCAnalytics {
    /* access modifiers changed from: private */
    public static String activesession = "";
    private static final String baseurl = "http://analytics.tapcrowd.com/1.0/analyticsservice/";
    private static String deviceid = "";
    public static boolean enabled = true;
    public static boolean logLocation = true;

    /* renamed from: ok */
    private static final String f2144ok = "\"ok\"";
    private static int previous = 0;

    public static void initalizeTCAnalytics(Context context) {
        new BulkTimerClass(context).start();
    }

    public static void startSession(Context context, String taptargetbundleid) {
        C1271DB.setTaptargetBundleId(context, taptargetbundleid);
        if (enabled) {
            int now = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
            if (now - previous > 120) {
                activesession = md5("a" + Math.random() + now);
            }
            previous = now;
            forceRequest(context, "sessionStart", "?id=" + URLEncoder.encode(activesession) + "&start=" + URLEncoder.encode(new StringBuilder(String.valueOf(now)).toString()) + "&deviceId=" + URLEncoder.encode(getDeviceId(context)) + "&bundleId=" + URLEncoder.encode(taptargetbundleid) + "&os=android&devicetype=" + URLEncoder.encode(Build.MODEL) + "&osversion=" + URLEncoder.encode(Build.VERSION.RELEASE));
            ContentValues cv = new ContentValues();
            cv.put("sessionid", activesession);
            Log.d("SESSIONID", activesession);
            C1271DB.openDataBase(context);
            C1271DB.update("request", cv, "sessionid == ''");
        }
    }

    public static String getSessionid() {
        return activesession;
    }

    public static void stopSession(Context context) {
        if (enabled) {
            forceRequest(context, "sessionStop", "?id=" + URLEncoder.encode(activesession) + "&time=" + URLEncoder.encode(new StringBuilder(String.valueOf((int) (Calendar.getInstance().getTimeInMillis() / 1000))).toString()));
        }
    }

    public static void log(Context context, String path, String value) {
        String lat;
        String lon;
        if (enabled) {
            int now = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
            LocationManager lm = (LocationManager) context.getSystemService("location");
            List<String> providers = lm.getProviders(true);
            Location l = null;
            if (logLocation) {
                for (int i = providers.size() - 1; i >= 0; i--) {
                    l = lm.getLastKnownLocation(providers.get(i));
                    if (l != null) {
                        break;
                    }
                }
            }
            if (l != null) {
                lat = new StringBuilder(String.valueOf(l.getLatitude())).toString();
                lon = new StringBuilder(String.valueOf(l.getLongitude())).toString();
            } else {
                lat = "0";
                lon = "0";
            }
            log(context, path, value, "", "", "", lat, lon, new StringBuilder(String.valueOf(now)).toString());
        }
    }

    public static void log(Context context, String path, String value, String key) {
        String lat;
        String lon;
        if (enabled) {
            int now = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
            LocationManager lm = (LocationManager) context.getSystemService("location");
            List<String> providers = lm.getProviders(true);
            Location l = null;
            if (logLocation) {
                for (int i = providers.size() - 1; i >= 0; i--) {
                    l = lm.getLastKnownLocation(providers.get(i));
                    if (l != null) {
                        break;
                    }
                }
            }
            if (l != null) {
                lat = new StringBuilder(String.valueOf(l.getLatitude())).toString();
                lon = new StringBuilder(String.valueOf(l.getLongitude())).toString();
            } else {
                lat = "0";
                lon = "0";
            }
            log(context, path, value, key, "", "", lat, lon, new StringBuilder(String.valueOf(now)).toString());
        }
    }

    public static void log(Context context, String path, String val, String key, String calcformula, String calcrefreshrate, String lat, String lon, String time) {
        if (enabled) {
            request(context, "log", "?lid=" + md5("a" + Math.random() + ((int) (Calendar.getInstance().getTimeInMillis() / 1000))) + "&path=" + path + "&key=" + URLEncoder.encode(key) + "&val=" + URLEncoder.encode(val) + "&calcformula=" + URLEncoder.encode(calcformula) + "&calcrefreshrate=" + URLEncoder.encode(calcrefreshrate) + "&lat=" + URLEncoder.encode(lat) + "&lon=" + URLEncoder.encode(lon) + "&time=" + URLEncoder.encode(time), activesession);
        }
    }

    private static String getDeviceId(Context context) {
        if (deviceid.equals("")) {
            deviceid = Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        return deviceid;
    }

    private static void request(Context a, String function, String parameters, String sessionid) {
        try {
            C1271DB.openDataBase(a);
            C1271DB.write(function, parameters, sessionid);
        } catch (Exception e) {
        }
    }

    private static String md5(String in) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5"); // CRYPTOGRAPHIC API CALLSITE 19
            digest.reset();); // CRYPTOGRAPHIC API CALLSITE 21
            digest.update(in.getBytes()); // CRYPTOGRAPHIC API CALLSITE 20
            byte[] a = digest.digest(); // CRYPTOGRAPHIC API CALLSITE 5
            int len = a.length;
            StringBuilder sb = new StringBuilder(len << 1);
            for (int i = 0; i < len; i++) {
                sb.append(Character.forDigit((a[i] & 240) >> 4, 16));
                sb.append(Character.forDigit(a[i] & 15, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "MD5_FAILED";
        }
    }

    private static void forceRequest(Context context, String function, String parameters) {
        try {
            new RequestTask(context).execute(new String[]{function, parameters});
        } catch (Exception e) {
        }
    }

    private static class RequestTask extends AsyncTask<String, Void, Void> {
        Context context;
        private ResponseHandler<String> handler = new BasicResponseHandler();

        public RequestTask(Context context2) {
            this.context = context2;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            String response;
            try {
                String function = params[0];
                String parameters = params[1];
                try {
                    response = (String) new DefaultHttpClient().execute(new HttpGet(TCAnalytics.baseurl + function + parameters), this.handler);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!response.equalsIgnoreCase(TCAnalytics.f2144ok)) {
                    C1271DB.openDataBase(this.context);
                    C1271DB.write(function, parameters, TCAnalytics.activesession);
                }
            } catch (Exception e2) {
            }
            return null;
        }
    }
}
