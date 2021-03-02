package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.support.p009v4.app.FragmentTransaction;
import android.support.p009v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzdq;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzkh {
    public static final Handler zzclc = new zzke(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Object f6612a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f6613b = true;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f6614c;

    /* renamed from: d */
    private boolean f6615d = false;

    /* renamed from: e */
    private zzfs f6616e;

    /* renamed from: a */
    private Bitmap m7305a(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                zzkd.zzcx("Width or height of view is zero");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            view.layout(0, 0, width, height);
            view.draw(canvas);
            return createBitmap;
        } catch (RuntimeException e) {
            zzkd.zzb("Fail to capture the webview", e);
            return null;
        }
    }

    /* renamed from: a */
    private JSONArray m7308a(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m7310a(jSONArray, a);
        }
        return jSONArray;
    }

    /* renamed from: a */
    private JSONObject m7309a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m7311a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    /* renamed from: a */
    private void m7310a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(m7309a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzam((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m7308a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(mo8670a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    /* renamed from: a */
    private void m7311a(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m7309a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzam((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m7308a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m7308a((Collection) Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: a */
    private boolean m7312a(KeyguardManager keyguardManager) {
        if (keyguardManager == null) {
            return false;
        }
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    /* renamed from: a */
    private boolean m7313a(PowerManager powerManager) {
        return powerManager == null || powerManager.isScreenOn();
    }

    /* renamed from: b */
    private Bitmap m7315b(View view) {
        RuntimeException e;
        Bitmap bitmap;
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            bitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            try {
                view.setDrawingCacheEnabled(isDrawingCacheEnabled);
            } catch (RuntimeException e2) {
                e = e2;
                zzkd.zzb("Fail to capture the web view", e);
                return bitmap;
            }
        } catch (RuntimeException e3) {
            RuntimeException runtimeException = e3;
            bitmap = null;
            e = runtimeException;
            zzkd.zzb("Fail to capture the web view", e);
            return bitmap;
        }
        return bitmap;
    }

    /* renamed from: b */
    private boolean m7316b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }

    public static void zzb(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzkg.zza(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo8668a() {
        StringBuffer stringBuffer = new StringBuffer(NotificationCompat.FLAG_LOCAL_ONLY);
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

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo8669a(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONArray mo8670a(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m7310a(jSONArray, a);
        }
        return jSONArray;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int[] mo8671b() {
        return new int[]{0, 0};
    }

    public void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            zzclc.post(runnable);
        }
    }

    public DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    public String zza(Context context, View view, AdSizeParcel adSizeParcel) {
        if (!((Boolean) zzdc.zzazx.get()).booleanValue()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", adSizeParcel.width);
            jSONObject2.put("height", adSizeParcel.height);
            jSONObject.put("size", jSONObject2);
            jSONObject.put("activity", zzah(context));
            if (!adSizeParcel.zzaus) {
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null) {
                        int i = -1;
                        if (parent instanceof ViewGroup) {
                            i = ((ViewGroup) parent).indexOfChild(view);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", parent.getClass().getName());
                        jSONObject3.put("index_of_child", i);
                        jSONArray.put(jSONObject3);
                    }
                    view = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("parents", jSONArray);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            zzkd.zzd("Fail to get view hierarchy json", e);
            return null;
        }
    }

    public String zza(Context context, zzas zzas, String str) {
        if (zzas == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (zzas.zzd(parse)) {
                parse = zzas.zzb(parse, context);
            }
            return parse.toString();
        } catch (Exception e) {
            return str;
        }
    }

    public String zza(zzlh zzlh, String str) {
        return zza(zzlh.getContext(), zzlh.zzul(), str);
    }

    public String zza(InputStreamReader inputStreamReader) {
        StringBuilder sb = new StringBuilder(FragmentTransaction.TRANSIT_EXIT_MASK);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    public void zza(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public void zza(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void zza(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(zzg(context, str));
    }

    public void zza(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            bundle.putString("device", zzu.zzfq().zztg());
            bundle.putString("eids", TextUtils.join(",", zzdc.zzjx()));
        }
        zzm.zziw().zza(context, str, str2, bundle, z, new C1738mf(this, context, str));
    }

    public void zza(Context context, String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Future future = (Future) new zzkq(context, str, (String) it.next()).zzpy();
        }
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        zza(context, str, z, httpURLConnection, false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", zzg(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public void zza(Context context, List list) {
        if (!(context instanceof Activity) || TextUtils.isEmpty(zzaqa.zzex((Activity) context))) {
            return;
        }
        if (list == null) {
            zzkd.m7303v("Cannot ping urls: empty list.");
        } else if (!zzdq.zzo(context)) {
            zzkd.m7303v("Cannot ping url because custom tabs is not supported");
        } else {
            zzdq zzdq = new zzdq();
            zzdq.zza((zzdq.zza) new C1736md(this, list, zzdq, context));
            zzdq.zze((Activity) context);
        }
    }

    public void zza(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Future future = (Future) new zzkq((String) it.next(), str).zzpy();
        }
    }

    public boolean zza(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public boolean zza(View view, Context context) {
        KeyguardManager keyguardManager = null;
        Context applicationContext = context.getApplicationContext();
        PowerManager powerManager = applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null;
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null && (systemService instanceof KeyguardManager)) {
            keyguardManager = (KeyguardManager) systemService;
        }
        return zza(view, powerManager, keyguardManager);
    }

    public boolean zza(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        return view.getVisibility() == 0 && view.isShown() && m7313a(powerManager) && (zzu.zzfq().zztc() || !m7312a(keyguardManager)) && (!((Boolean) zzdc.zzbaq.get()).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect()));
    }

    public boolean zza(ClassLoader classLoader, Class cls, String str) {
        try {
            return cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean zzac(Context context) {
        boolean z;
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            zzkd.zzcx("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            zzkd.zzcx(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            zzkd.zzcx(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
            zzkd.zzcx(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & NotificationCompat.FLAG_LOCAL_ONLY) == 0) {
            zzkd.zzcx(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            zzkd.zzcx(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            zzkd.zzcx(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        zzkd.zzcx(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"smallestScreenSize"}));
        return false;
    }

    public boolean zzad(Context context) {
        if (this.f6615d) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new C1739mg(this, (C1736md) null), intentFilter);
        this.f6615d = true;
        return true;
    }

    public AlertDialog.Builder zzaf(Context context) {
        return new AlertDialog.Builder(context);
    }

    public zzcu zzag(Context context) {
        return new zzcu(context);
    }

    public String zzah(Context context) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            if (!(runningTasks == null || runningTasks.isEmpty() || (runningTaskInfo = runningTasks.get(0)) == null || runningTaskInfo.topActivity == null)) {
                return runningTaskInfo.topActivity.getClassName();
            }
            return null;
        } catch (Exception e) {
        }
    }

    public boolean zzai(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (Process.myPid() == next.pid) {
                    if (next.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && m7316b(context)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public Bitmap zzaj(Context context) {
        Bitmap bitmap;
        if (!(context instanceof Activity)) {
            return null;
        }
        try {
            if (((Boolean) zzdc.zzbcb.get()).booleanValue()) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    bitmap = m7315b(window.getDecorView().getRootView());
                }
                bitmap = null;
            } else {
                bitmap = m7305a(((Activity) context).getWindow().getDecorView());
            }
        } catch (RuntimeException e) {
            zzkd.zzb("Fail to capture screen shot", e);
        }
        return bitmap;
    }

    public AudioManager zzak(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    public float zzal(Context context) {
        AudioManager zzak = zzak(context);
        if (zzak == null) {
            return 0.0f;
        }
        int streamMaxVolume = zzak.getStreamMaxVolume(3);
        int streamVolume = zzak.getStreamVolume(3);
        if (streamMaxVolume != 0) {
            return ((float) streamVolume) / ((float) streamMaxVolume);
        }
        return 0.0f;
    }

    public int zzam(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    public JSONObject zzam(Map map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m7311a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }

    public boolean zzan(Context context) {
        try {
            context.getClassLoader().loadClass(ClientApi.class.getName());
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        }
    }

    public String zzb(String str, Map map) {
        for (String str2 : map.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str2}), String.format("$1%s$2", new Object[]{Uri.encode((String) map.get(str2))}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
    }

    public void zzb(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void zzb(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void zzb(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) zzdc.zzbau.get()).booleanValue()) {
            zza(context, str, str2, bundle, z);
        }
    }

    public zzfs zzc(Context context, VersionInfoParcel versionInfoParcel) {
        zzfs zzfs;
        synchronized (this.f6612a) {
            if (this.f6616e == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f6616e = new zzfs(context, versionInfoParcel, (String) zzdc.zzaxy.get());
            }
            zzfs = this.f6616e;
        }
        return zzfs;
    }

    public void zzc(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        zza(context, str, (List) arrayList);
    }

    public String zzco(String str) {
        return Uri.parse(str).buildUpon().query((String) null).build().toString();
    }

    public int zzcp(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            zzkd.zzcx(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Could not parse value:").append(valueOf).toString());
            return 0;
        }
    }

    public boolean zzcq(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public float zzey() {
        zzo zzex = zzu.zzgg().zzex();
        if (zzex == null || !zzex.zzez()) {
            return 1.0f;
        }
        return zzex.zzey();
    }

    public Map zzf(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : zzu.zzfs().zzg(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    public boolean zzfa() {
        zzo zzex = zzu.zzgg().zzex();
        if (zzex != null) {
            return zzex.zzfa();
        }
        return false;
    }

    public String zzg(Context context, String str) {
        String str2;
        synchronized (this.f6612a) {
            if (this.f6614c != null) {
                str2 = this.f6614c;
            } else {
                try {
                    this.f6614c = zzu.zzfs().getDefaultUserAgent(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.f6614c)) {
                    if (!zzm.zziw().zztx()) {
                        this.f6614c = null;
                        zzclc.post(new C1737me(this, context));
                        while (this.f6614c == null) {
                            try {
                                this.f6612a.wait();
                            } catch (InterruptedException e2) {
                                this.f6614c = mo8668a();
                                String valueOf = String.valueOf(this.f6614c);
                                zzkd.zzcx(valueOf.length() != 0 ? "Interrupted, use default user agent: ".concat(valueOf) : new String("Interrupted, use default user agent: "));
                            }
                        }
                    } else {
                        try {
                            this.f6614c = mo8669a(context);
                        } catch (Exception e3) {
                            this.f6614c = mo8668a();
                        }
                    }
                }
                String valueOf2 = String.valueOf(this.f6614c);
                this.f6614c = new StringBuilder(String.valueOf(valueOf2).length() + 11 + String.valueOf(str).length()).append(valueOf2).append(" (Mobile; ").append(str).append(")").toString();
                str2 = this.f6614c;
            }
        }
        return str2;
    }

    public int[] zzh(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        if (window == null || (findViewById = window.findViewById(16908290)) == null) {
            return mo8671b();
        }
        return new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    public int[] zzi(Activity activity) {
        int[] zzh = zzh(activity);
        return new int[]{zzm.zziw().zzb((Context) activity, zzh[0]), zzm.zziw().zzb((Context) activity, zzh[1])};
    }

    public int[] zzj(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        if (window == null || (findViewById = window.findViewById(16908290)) == null) {
            return mo8671b();
        }
        return new int[]{findViewById.getTop(), findViewById.getBottom()};
    }

    public Bitmap zzk(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public int[] zzk(Activity activity) {
        int[] zzj = zzj(activity);
        return new int[]{zzm.zziw().zzb((Context) activity, zzj[0]), zzm.zziw().zzb((Context) activity, zzj[1])};
    }

    public int zzn(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    public boolean zztc() {
        return this.f6613b;
    }

    public String zzte() {
        return UUID.randomUUID().toString();
    }

    public String zztf() {
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

    public String zztg() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length()).append(str).append(" ").append(str2).toString();
    }

    public Bundle zzti() {
        Bundle bundle = new Bundle();
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            bundle.putParcelable("debug_memory_info", memoryInfo);
            Runtime runtime = Runtime.getRuntime();
            bundle.putLong("runtime_free_memory", runtime.freeMemory());
            bundle.putLong("runtime_max_memory", runtime.maxMemory());
            bundle.putLong("runtime_total_memory", runtime.totalMemory());
        } catch (Exception e) {
            zzkd.zzd("Unable to gather memory stats", e);
        }
        return bundle;
    }
}
