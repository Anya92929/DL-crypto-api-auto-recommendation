package com.google.android.gms.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.gj */
public final class C1213gj {
    /* access modifiers changed from: private */

    /* renamed from: uf */
    public static final Object f3750uf = new Object();

    /* renamed from: wm */
    private static final SimpleDateFormat[] f3751wm = {new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"), new SimpleDateFormat("yyyyMMdd")};
    /* access modifiers changed from: private */

    /* renamed from: wn */
    public static boolean f3752wn = true;
    /* access modifiers changed from: private */

    /* renamed from: wo */
    public static String f3753wo;

    /* renamed from: wp */
    private static boolean f3754wp = false;

    /* renamed from: com.google.android.gms.internal.gj$a */
    private static final class C1215a extends BroadcastReceiver {
        private C1215a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                boolean unused = C1213gj.f3752wn = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = C1213gj.f3752wn = false;
            }
        }
    }

    /* renamed from: L */
    public static String m4608L(String str) {
        return Uri.parse(str).buildUpon().query((String) null).build().toString();
    }

    /* renamed from: M */
    public static int m4609M(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C1229gs.m4679W("Could not parse value:" + e);
            return 0;
        }
    }

    /* renamed from: N */
    public static boolean m4610N(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    /* renamed from: O */
    public static long m4611O(String str) {
        long j = -1;
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        SimpleDateFormat[] simpleDateFormatArr = f3751wm;
        int length = simpleDateFormatArr.length;
        while (i < length) {
            SimpleDateFormat simpleDateFormat = simpleDateFormatArr[i];
            try {
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                return simpleDateFormat.parse(str).getTime();
            } catch (ParseException e) {
                i++;
            }
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e2) {
            return j;
        }
    }

    /* renamed from: a */
    public static String m4613a(Readable readable) throws IOException {
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
    private static JSONArray m4614a(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m4623a(jSONArray, a);
        }
        return jSONArray;
    }

    /* renamed from: a */
    static JSONArray m4615a(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m4623a(jSONArray, a);
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static void m4616a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m4628c(context, str));
    }

    /* renamed from: a */
    public static void m4617a(Context context, String str, List<String> list) {
        for (String gqVar : list) {
            new C1227gq(context, str, gqVar).start();
        }
    }

    /* renamed from: a */
    public static void m4618a(Context context, String str, List<String> list, String str2) {
        for (String gqVar : list) {
            new C1227gq(context, str, gqVar, str2).start();
        }
    }

    /* renamed from: a */
    public static void m4619a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        m4621a(context, str, z, httpURLConnection, false);
    }

    /* renamed from: a */
    public static void m4620a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, String str2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", str2);
        httpURLConnection.setUseCaches(false);
    }

    /* renamed from: a */
    public static void m4621a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m4628c(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    /* renamed from: a */
    public static void m4622a(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            C1221gn.m4653a(webView);
        }
    }

    /* renamed from: a */
    private static void m4623a(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(m4630c((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m4642t((Map<String, ?>) (Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m4614a((Collection<?>) (Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m4615a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    /* renamed from: a */
    private static void m4624a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m4630c((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m4642t((Map<String, ?>) (Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m4614a((Collection<?>) (Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m4614a((Collection<?>) Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: a */
    public static boolean m4625a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    /* renamed from: a */
    public static boolean m4626a(ClassLoader classLoader, Class<?> cls, String str) {
        try {
            return cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: b */
    public static void m4627b(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            C1221gn.m4654b(webView);
        }
    }

    /* renamed from: c */
    public static String m4628c(final Context context, String str) {
        String str2;
        synchronized (f3750uf) {
            if (f3753wo != null) {
                str2 = f3753wo;
            } else {
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        f3753wo = C1226gp.getDefaultUserAgent(context);
                        f3753wo += " (Mobile; " + str + ")";
                        str2 = f3753wo;
                    } catch (Exception e) {
                    }
                }
                if (!C1228gr.m4673dt()) {
                    C1228gr.f3776wC.post(new Runnable() {
                        public void run() {
                            synchronized (C1213gj.f3750uf) {
                                String unused = C1213gj.f3753wo = C1213gj.m4640r(context);
                                C1213gj.f3750uf.notifyAll();
                            }
                        }
                    });
                    while (f3753wo == null) {
                        try {
                            f3750uf.wait();
                        } catch (InterruptedException e2) {
                            f3753wo = m4635do();
                            C1229gs.m4679W("Interrupted, use default user agent: " + f3753wo);
                        }
                    }
                } else {
                    try {
                        f3753wo = m4640r(context);
                    } catch (Exception e3) {
                        f3753wo = m4635do();
                    }
                }
                f3753wo += " (Mobile; " + str + ")";
                str2 = f3753wo;
            }
        }
        return str2;
    }

    /* renamed from: c */
    public static Map<String, String> m4629c(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        urlQuerySanitizer.parseUrl(uri.toString());
        for (UrlQuerySanitizer.ParameterValuePair next : urlQuerySanitizer.getParameterList()) {
            hashMap.put(next.mParameter, next.mValue);
        }
        return hashMap;
    }

    /* renamed from: c */
    private static JSONObject m4630c(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m4624a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    /* renamed from: c */
    public static void m4631c(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        m4617a(context, str, (List<String>) arrayList);
    }

    /* renamed from: dl */
    public static boolean m4632dl() {
        return f3752wn;
    }

    /* renamed from: dm */
    public static int m4633dm() {
        return Build.VERSION.SDK_INT >= 9 ? 6 : 0;
    }

    /* renamed from: dn */
    public static int m4634dn() {
        return Build.VERSION.SDK_INT >= 9 ? 7 : 1;
    }

    /* renamed from: do */
    static String m4635do() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(Build.VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    /* renamed from: dp */
    public static String m4636dp() {
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(byteArray);
                instance.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(instance.digest(), 0, bArr, 0, 8);
                bigInteger = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    /* renamed from: p */
    public static boolean m4638p(Context context) {
        boolean z;
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            C1229gs.m4679W("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            C1229gs.m4679W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            C1229gs.m4679W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            C1229gs.m4679W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            C1229gs.m4679W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            C1229gs.m4679W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            C1229gs.m4679W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        C1229gs.m4679W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"smallestScreenSize"}));
        return false;
    }

    /* renamed from: q */
    public static void m4639q(Context context) {
        if (!f3754wp) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.getApplicationContext().registerReceiver(new C1215a(), intentFilter);
            f3754wp = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public static String m4640r(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    /* renamed from: s */
    public static int m4641s(Context context) {
        int i;
        int i2 = 0;
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            i = rect.top;
            i2 = window.findViewById(16908290).getTop() - i;
        } else {
            i = 0;
        }
        return i2 + i;
    }

    /* renamed from: t */
    public static JSONObject m4642t(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String next : map.keySet()) {
                m4624a(jSONObject, next, (Object) map.get(next));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    /* renamed from: t */
    public static int[] m4643t(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = 160.0f / ((float) displayMetrics.densityDpi);
        return new int[]{(int) (((float) displayMetrics.widthPixels) * f), (int) (f * ((float) displayMetrics.heightPixels))};
    }
}
