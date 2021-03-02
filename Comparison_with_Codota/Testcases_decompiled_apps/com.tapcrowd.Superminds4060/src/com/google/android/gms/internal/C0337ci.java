package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ci */
public final class C0337ci {
    /* access modifiers changed from: private */

    /* renamed from: gL */
    public static final Object f1006gL = new Object();
    /* access modifiers changed from: private */

    /* renamed from: hJ */
    public static boolean f1007hJ = true;
    /* access modifiers changed from: private */

    /* renamed from: hK */
    public static String f1008hK;

    /* renamed from: hL */
    private static boolean f1009hL = false;

    /* renamed from: com.google.android.gms.internal.ci$a */
    private static final class C0339a extends BroadcastReceiver {
        private C0339a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                boolean unused = C0337ci.f1007hJ = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = C0337ci.f1007hJ = false;
            }
        }
    }

    /* renamed from: a */
    public static String m688a(Readable readable) throws IOException {
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
    private static JSONArray m689a(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m696a(jSONArray, a);
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static JSONArray m690a(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m696a(jSONArray, a);
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static JSONObject m691a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m697a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m692a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m703b(context, str));
    }

    /* renamed from: a */
    public static void m693a(Context context, String str, List<String> list) {
        for (String clVar : list) {
            new C0342cl(context, str, clVar).start();
        }
    }

    /* renamed from: a */
    public static void m694a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m703b(context, str));
        httpURLConnection.setUseCaches(false);
    }

    /* renamed from: a */
    public static void m695a(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            C0340cj.m715a(webView);
        }
    }

    /* renamed from: a */
    private static void m696a(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(m691a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m712l((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m689a((Collection<?>) (Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m690a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    /* renamed from: a */
    private static void m697a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m691a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m712l((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m689a((Collection<?>) (Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m689a((Collection<?>) Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: a */
    public static boolean m698a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    /* renamed from: am */
    public static boolean m699am() {
        return f1007hJ;
    }

    /* renamed from: an */
    public static int m700an() {
        return Build.VERSION.SDK_INT >= 9 ? 6 : 0;
    }

    /* renamed from: ao */
    public static int m701ao() {
        return Build.VERSION.SDK_INT >= 9 ? 7 : 1;
    }

    /* renamed from: b */
    private static String m703b(final Context context, String str) {
        String str2;
        synchronized (f1006gL) {
            if (f1008hK != null) {
                str2 = f1008hK;
            } else {
                if (Build.VERSION.SDK_INT >= 17) {
                    f1008hK = C0341ck.getDefaultUserAgent(context);
                } else if (!C0343cm.m726ar()) {
                    C0343cm.f1013hO.post(new Runnable() {
                        public void run() {
                            synchronized (C0337ci.f1006gL) {
                                String unused = C0337ci.f1008hK = C0337ci.m708j(context);
                                C0337ci.f1006gL.notifyAll();
                            }
                        }
                    });
                    while (f1008hK == null) {
                        try {
                            f1006gL.wait();
                        } catch (InterruptedException e) {
                            str2 = f1008hK;
                        }
                    }
                } else {
                    f1008hK = m708j(context);
                }
                f1008hK += " (Mobile; " + str + ")";
                str2 = f1008hK;
            }
        }
        return str2;
    }

    /* renamed from: b */
    public static void m704b(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            C0340cj.m716b(webView);
        }
    }

    /* renamed from: h */
    public static boolean m705h(Context context) {
        boolean z;
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            C0344cn.m737q("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            C0344cn.m737q(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            C0344cn.m737q(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            C0344cn.m737q(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            C0344cn.m737q(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            C0344cn.m737q(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            C0344cn.m737q(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        C0344cn.m737q(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"smallestScreenSize"}));
        return false;
    }

    /* renamed from: i */
    public static void m707i(Context context) {
        if (!f1009hL) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.getApplicationContext().registerReceiver(new C0339a(), intentFilter);
            f1009hL = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static String m708j(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    /* renamed from: j */
    public static String m709j(String str) {
        return Uri.parse(str).buildUpon().query((String) null).build().toString();
    }

    /* renamed from: l */
    public static JSONObject m712l(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String next : map.keySet()) {
                m697a(jSONObject, next, (Object) map.get(next));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }
}
