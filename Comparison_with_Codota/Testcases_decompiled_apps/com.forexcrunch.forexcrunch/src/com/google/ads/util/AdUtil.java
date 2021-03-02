package com.google.ads.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.webkit.WebView;
import com.google.ads.AdActivity;
import com.google.ads.AdRequest;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AdUtil {

    /* renamed from: a */
    public static final int f690a = m439a(Build.VERSION.SDK);

    /* renamed from: b */
    private static Boolean f691b = null;

    /* renamed from: c */
    private static String f692c = null;

    /* renamed from: d */
    private static String f693d;

    /* renamed from: e */
    private static String f694e = null;

    /* renamed from: f */
    private static AudioManager f695f;

    /* renamed from: g */
    private static boolean f696g = true;

    /* renamed from: h */
    private static boolean f697h = false;

    /* renamed from: i */
    private static String f698i = null;

    /* renamed from: com.google.ads.util.AdUtil$a */
    public enum C0280a {
        INVALID,
        SPEAKER,
        HEADPHONES,
        VIBRATE,
        EMULATOR,
        OTHER
    }

    /* renamed from: a */
    public static boolean m451a(Intent intent, Context context) {
        return context.getPackageManager().resolveActivity(intent, 65536) != null;
    }

    /* renamed from: a */
    public static String m442a(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        CharBuffer allocate = CharBuffer.allocate(2048);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return sb.toString();
            }
            allocate.flip();
            sb.append(allocate, 0, read);
        }
    }

    /* renamed from: a */
    public static int m439a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C0284b.m490e("The Android SDK version couldn't be parsed to an int: " + Build.VERSION.SDK);
            C0284b.m490e("Defaulting to Android SDK version 3.");
            return 3;
        }
    }

    /* renamed from: a */
    public static String m441a(Context context) {
        String str;
        if (f692c == null) {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string == null || m460c()) {
                str = m456b("emulator");
            } else {
                str = m456b(string);
            }
            if (str == null) {
                return null;
            }
            f692c = str.toUpperCase(Locale.US);
        }
        return f692c;
    }

    /* renamed from: a */
    public static int m436a() {
        if (f690a >= 9) {
            return 6;
        }
        return 0;
    }

    /* renamed from: b */
    public static int m454b() {
        if (f690a >= 9) {
            return 7;
        }
        return 1;
    }

    /* renamed from: a */
    public static int m438a(Context context, DisplayMetrics displayMetrics) {
        if (f690a >= 4) {
            return C0291e.m498a(context, displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    /* renamed from: b */
    public static int m455b(Context context, DisplayMetrics displayMetrics) {
        if (f690a >= 4) {
            return C0291e.m500b(context, displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    /* renamed from: b */
    public static boolean m459b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager.checkPermission("android.permission.INTERNET", packageName) == -1) {
            C0284b.m484b("INTERNET permissions must be enabled in AndroidManifest.xml.");
            return false;
        } else if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", packageName) != -1) {
            return true;
        } else {
            C0284b.m484b("ACCESS_NETWORK_STATE permissions must be enabled in AndroidManifest.xml.");
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m449a(int i, int i2, String str) {
        if ((i & i2) != 0) {
            return true;
        }
        C0284b.m484b("The android:configChanges value of the com.google.ads.AdActivity must include " + str + ".");
        return false;
    }

    /* renamed from: c */
    public static boolean m461c(Context context) {
        if (f691b != null) {
            return f691b.booleanValue();
        }
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(new Intent(context, AdActivity.class), 65536);
        f691b = true;
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            C0284b.m484b("Could not find com.google.ads.AdActivity, please make sure it is registered in AndroidManifest.xml.");
            f691b = false;
        } else {
            if (!m449a(resolveActivity.activityInfo.configChanges, 16, "keyboard")) {
                f691b = false;
            }
            if (!m449a(resolveActivity.activityInfo.configChanges, 32, "keyboardHidden")) {
                f691b = false;
            }
            if (!m449a(resolveActivity.activityInfo.configChanges, 128, "orientation")) {
                f691b = false;
            }
            if (!m449a(resolveActivity.activityInfo.configChanges, 256, "screenLayout")) {
                f691b = false;
            }
            if (!m449a(resolveActivity.activityInfo.configChanges, 512, "uiMode")) {
                f691b = false;
            }
            if (!m449a(resolveActivity.activityInfo.configChanges, 1024, "screenSize")) {
                f691b = false;
            }
            if (!m449a(resolveActivity.activityInfo.configChanges, 2048, "smallestScreenSize")) {
                f691b = false;
            }
        }
        return f691b.booleanValue();
    }

    /* renamed from: c */
    public static boolean m460c() {
        return m453a((C0290d) null);
    }

    /* renamed from: a */
    static boolean m453a(C0290d dVar) {
        if (dVar == null) {
            dVar = C0290d.f724d;
        }
        return dVar.equals(C0290d.f725e) || dVar.equals(C0290d.f726f);
    }

    /* renamed from: a */
    public static boolean m452a(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (ImageDownloader.SCHEME_HTTP.equalsIgnoreCase(scheme) || ImageDownloader.SCHEME_HTTPS.equalsIgnoreCase(scheme)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static String m456b(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5"); // CRYPTOGRAPHIC API CALLSITE 28
            instance.update(str.getBytes(), 0, str.length()); // CRYPTOGRAPHIC API CALLSITE 27
            return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, instance.digest())}); // CRYPTOGRAPHIC API CALLSITE 25
        } catch (NoSuchAlgorithmException e) {
            return str.substring(0, 32);
        }
    }

    /* renamed from: d */
    public static String m462d(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
                return "ed";
            case 1:
                return "wi";
            default:
                return "unknown";
        }
    }

    /* renamed from: e */
    public static String m464e(Context context) {
        if (f693d == null) {
            StringBuilder sb = new StringBuilder();
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=donuts")), 65536);
            if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
                sb.append(AdActivity.TYPE_PARAM);
            }
            List<ResolveInfo> queryIntentActivities2 = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.google")), 65536);
            if (queryIntentActivities2 == null || queryIntentActivities2.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append("a");
            }
            f693d = sb.toString();
        }
        return f693d;
    }

    /* renamed from: a */
    public static boolean m450a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: f */
    public static String m465f(Context context) {
        ActivityInfo activityInfo;
        PackageInfo packageInfo;
        if (f694e != null) {
            return f694e;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ads")), 65536);
            if (resolveActivity == null || (activityInfo = resolveActivity.activityInfo) == null || (packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0)) == null) {
                return null;
            }
            f694e = packageInfo.versionCode + "." + activityInfo.packageName;
            return f694e;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /* renamed from: g */
    public static C0280a m466g(Context context) {
        if (f695f == null) {
            f695f = (AudioManager) context.getSystemService("audio");
        }
        C0280a aVar = C0280a.OTHER;
        int mode = f695f.getMode();
        if (m460c()) {
            return C0280a.EMULATOR;
        }
        if (f695f.isMusicActive() || f695f.isSpeakerphoneOn() || mode == 2 || mode == 1) {
            return C0280a.VIBRATE;
        }
        int ringerMode = f695f.getRingerMode();
        if (ringerMode == 0 || ringerMode == 1) {
            return C0280a.VIBRATE;
        }
        return C0280a.SPEAKER;
    }

    /* renamed from: a */
    public static DisplayMetrics m440a(Activity activity) {
        if (activity.getWindowManager() == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: a */
    public static HashMap<String, Object> m444a(Location location) {
        if (location == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("time", Long.valueOf(location.getTime() * 1000));
        hashMap.put("lat", Long.valueOf((long) (location.getLatitude() * 1.0E7d)));
        hashMap.put("long", Long.valueOf((long) (location.getLongitude() * 1.0E7d)));
        hashMap.put("radius", Long.valueOf((long) (location.getAccuracy() * 1000.0f)));
        return hashMap;
    }

    /* renamed from: b */
    public static HashMap<String, String> m457b(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery != null) {
            for (String str : encodedQuery.split("&")) {
                int indexOf = str.indexOf("=");
                if (indexOf < 0) {
                    hashMap.put(Uri.decode(str), (Object) null);
                } else {
                    hashMap.put(Uri.decode(str.substring(0, indexOf)), Uri.decode(str.substring(indexOf + 1, str.length())));
                }
            }
        }
        return hashMap;
    }

    /* renamed from: d */
    public static boolean m463d() {
        return f696g;
    }

    /* renamed from: a */
    public static void m448a(boolean z) {
        f696g = z;
    }

    /* renamed from: h */
    public static void m467h(Context context) {
        if (!f697h) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new UserActivityReceiver(), intentFilter);
            f697h = true;
        }
    }

    public static class UserActivityReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
                AdUtil.m448a(true);
            } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                AdUtil.m448a(false);
            }
        }
    }

    /* renamed from: i */
    public static String m468i(Context context) {
        if (f698i == null) {
            String userAgentString = new WebView(context).getSettings().getUserAgentString();
            if (userAgentString == null || userAgentString.length() == 0 || userAgentString.equals("Java0")) {
                String property = System.getProperty("os.name", "Linux");
                String str = "Android " + Build.VERSION.RELEASE;
                Locale locale = Locale.getDefault();
                String lowerCase = locale.getLanguage().toLowerCase(Locale.US);
                if (lowerCase.length() == 0) {
                    lowerCase = "en";
                }
                String lowerCase2 = locale.getCountry().toLowerCase(Locale.US);
                if (lowerCase2.length() > 0) {
                    lowerCase = lowerCase + "-" + lowerCase2;
                }
                userAgentString = "Mozilla/5.0 (" + property + "; U; " + str + "; " + lowerCase + "; " + (Build.MODEL + " Build/" + Build.ID) + ") AppleWebKit/0.0 (KHTML, like " + "Gecko) Version/0.0 Mobile Safari/0.0";
            }
            f698i = userAgentString + " (Mobile; " + "afma-sdk-a-v" + AdRequest.VERSION + ")";
        }
        return f698i;
    }

    /* renamed from: a */
    public static void m446a(WebView webView) {
        webView.getSettings().setUserAgentString(m468i(webView.getContext().getApplicationContext()));
    }

    /* renamed from: a */
    public static void m447a(HttpURLConnection httpURLConnection, Context context) {
        httpURLConnection.setRequestProperty("User-Agent", m468i(context));
    }

    /* renamed from: a */
    public static String m443a(Map<String, Object> map) {
        try {
            return m458b(map).toString();
        } catch (JSONException e) {
            C0284b.m489d("JsonException in serialization: ", e);
            return null;
        }
    }

    /* renamed from: b */
    public static JSONObject m458b(Map<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.isEmpty()) {
            return jSONObject;
        }
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Long) || (obj instanceof Float)) {
                jSONObject.put(next, obj);
            } else if (obj instanceof Map) {
                try {
                    jSONObject.put(next, m458b((Map<String, Object>) (Map) obj));
                } catch (ClassCastException e) {
                    C0284b.m489d("Unknown map type in json serialization: ", e);
                }
            } else if (obj instanceof Set) {
                try {
                    jSONObject.put(next, m445a((Set<Object>) (Set) obj));
                } catch (ClassCastException e2) {
                    C0284b.m489d("Unknown map type in json serialization: ", e2);
                }
            } else {
                C0284b.m490e("Unknown value in json serialization: " + obj);
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONArray m445a(Set<Object> set) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (set == null || set.isEmpty()) {
            return jSONArray;
        }
        for (Object next : set) {
            if ((next instanceof String) || (next instanceof Integer) || (next instanceof Double) || (next instanceof Long) || (next instanceof Float)) {
                jSONArray.put(next);
            } else if (next instanceof Map) {
                try {
                    jSONArray.put(m458b((Map<String, Object>) (Map) next));
                } catch (ClassCastException e) {
                    C0284b.m489d("Unknown map type in json serialization: ", e);
                }
            } else if (next instanceof Set) {
                try {
                    jSONArray.put(m445a((Set<Object>) (Set) next));
                } catch (ClassCastException e2) {
                    C0284b.m489d("Unknown map type in json serialization: ", e2);
                }
            } else {
                C0284b.m490e("Unknown value in json serialization: " + next);
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static int m437a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }
}
