package com.google.android.gms.analytics.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0637az;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

/* renamed from: com.google.android.gms.analytics.internal.r */
public class C0570r {

    /* renamed from: a */
    private static final char[] f3890a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static double m3324a(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return d;
        }
    }

    /* renamed from: a */
    public static long m3325a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /* renamed from: a */
    public static C0637az m3326a(C0562j jVar, String str) {
        C1009bf.m4528a(jVar);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI("?" + str), "UTF-8");
            HashMap hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            C0637az azVar = new C0637az();
            azVar.mo7048e((String) hashMap.get("utm_content"));
            azVar.mo7044c((String) hashMap.get("utm_medium"));
            azVar.mo7040a((String) hashMap.get("utm_campaign"));
            azVar.mo7042b((String) hashMap.get("utm_source"));
            azVar.mo7046d((String) hashMap.get("utm_term"));
            azVar.mo7050f((String) hashMap.get("utm_id"));
            azVar.mo7052g((String) hashMap.get("anid"));
            azVar.mo7054h((String) hashMap.get("gclid"));
            azVar.mo7056i((String) hashMap.get("dclid"));
            azVar.mo7058j((String) hashMap.get("aclid"));
            return azVar;
        } catch (URISyntaxException e) {
            jVar.mo6877d("No valid campaign data found", e);
            return null;
        }
    }

    /* renamed from: a */
    public static String m3327a(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(language.toLowerCase());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append("-").append(locale.getCountry().toLowerCase());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m3328a(boolean z) {
        return z ? "1" : "0";
    }

    /* renamed from: a */
    public static void m3329a(Map<String, String> map, String str, String str2) {
        if (str2 != null && !map.containsKey(str)) {
            map.put(str, str2);
        }
    }

    /* renamed from: a */
    public static void m3330a(Map<String, String> map, String str, Map<String, String> map2) {
        m3329a(map, str, map2.get(str));
    }

    /* renamed from: a */
    public static void m3331a(Map<String, String> map, String str, boolean z) {
        if (!map.containsKey(str)) {
            map.put(str, z ? "1" : "0");
        }
    }

    /* renamed from: a */
    public static boolean m3332a(double d, String str) {
        return d > 0.0d && d < 100.0d && ((double) (m3338c(str) % 10000)) >= 100.0d * d;
    }

    /* renamed from: a */
    public static boolean m3333a(Context context, Class<? extends Service> cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 4);
            return serviceInfo != null && serviceInfo.enabled;
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    /* renamed from: a */
    public static boolean m3334a(Context context, Class<? extends BroadcastReceiver> cls, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, cls), 2);
            return receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported);
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    /* renamed from: a */
    public static boolean m3335a(String str, boolean z) {
        if (str == null) {
            return z;
        }
        if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("1")) {
            return true;
        }
        if (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase("0")) {
            return false;
        }
        return z;
    }

    /* renamed from: b */
    public static MessageDigest m3336b(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return null;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i = i2 + 1;
            } catch (NoSuchAlgorithmException e) {
            }
        }
    }

    /* renamed from: b */
    public static void m3337b(Map<String, String> map, String str, String str2) {
        if (str2 != null && TextUtils.isEmpty(map.get(str))) {
            map.put(str, str2);
        }
    }

    /* renamed from: c */
    public static int m3338c(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = ((i << 6) & 65535) + charAt + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    /* renamed from: d */
    public static boolean m3339d(String str) {
        return TextUtils.isEmpty(str) || !str.startsWith("http:");
    }
}
