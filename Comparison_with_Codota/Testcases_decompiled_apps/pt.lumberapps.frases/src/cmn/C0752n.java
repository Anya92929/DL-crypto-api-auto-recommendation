package cmn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.p009v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Random;

/* renamed from: cmn.n */
public class C0752n {

    /* renamed from: a */
    private static final String f1835a = C0752n.class.getSimpleName();

    /* renamed from: b */
    private static C0752n f1836b;

    /* renamed from: c */
    private final Context f1837c;

    /* renamed from: d */
    private final String f1838d;

    /* renamed from: e */
    private final String f1839e;

    /* renamed from: f */
    private final C0753o f1840f;

    /* renamed from: g */
    private final int f1841g;

    /* renamed from: h */
    private final String f1842h;

    /* renamed from: i */
    private final String f1843i;

    /* renamed from: j */
    private final String f1844j;

    /* renamed from: k */
    private final C0755q f1845k;

    /* renamed from: l */
    private final C0754p f1846l;

    /* renamed from: m */
    private final String f1847m;

    /* renamed from: n */
    private final int f1848n;

    /* renamed from: o */
    private final String f1849o;

    /* renamed from: p */
    private final C0757s f1850p;

    /* renamed from: q */
    private Bundle f1851q;

    /* renamed from: r */
    private volatile int f1852r;

    /* renamed from: s */
    private volatile int f1853s;

    /* renamed from: t */
    private volatile int f1854t;

    /* renamed from: u */
    private volatile String f1855u;

    /* renamed from: v */
    private long f1856v;

    private C0752n(Context context) {
        this.f1837c = context.getApplicationContext();
        try {
            this.f1851q = this.f1837c.getPackageManager().getApplicationInfo(this.f1837c.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
        } catch (Exception e) {
            this.f1851q = null;
        }
        this.f1849o = m3279b(this.f1837c);
        String packageName = this.f1837c.getPackageName();
        this.f1838d = packageName.startsWith("com.appspot.swisscodemonkeys.") || packageName.startsWith("com.apptornado.") || packageName.startsWith("com.appbrain.") || packageName.startsWith("com.swiss-codemonkeys.") ? packageName.substring(packageName.lastIndexOf(46) + 1) : packageName;
        this.f1855u = this.f1837c.getPackageName();
        this.f1839e = this.f1837c.getResources().getConfiguration().locale.getLanguage();
        this.f1840f = m3280c(this.f1837c);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f1837c);
        int a = m3273a(defaultSharedPreferences, "installed-since");
        if (a == 0) {
            a = (int) (System.currentTimeMillis() / 1000);
            defaultSharedPreferences.edit().putInt("installed-since", a).apply();
        }
        this.f1841g = a;
        String string = Settings.Secure.getString(this.f1837c.getContentResolver(), "android_id");
        this.f1842h = string == null ? "" : string;
        this.f1843i = m3282d(this.f1837c);
        this.f1844j = mo3426a("flavor");
        this.f1845k = m3283e(this.f1837c);
        this.f1846l = m3284f(this.f1837c);
        this.f1847m = m3286u();
        this.f1848n = m3272a(this.f1837c, this.f1837c.getPackageName());
        this.f1850p = C0757s.m3315a(this.f1837c);
        m3285t();
    }

    /* renamed from: a */
    private static int m3272a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable th) {
            th.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return -1;
        }
        return packageInfo.versionCode;
    }

    /* renamed from: a */
    private static int m3273a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, 0);
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: a */
    private static String m3274a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5"); // CRYPTOGRAPHIC API CALLSITE 3
            instance.update(bArr); // CRYPTOGRAPHIC API CALLSITE 5
            return C0756r.m3312b(instance.digest()); // CRYPTOGRAPHIC API CALLSITE 4
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    /* renamed from: a */
    public static synchronized void m3275a() {
        synchronized (C0752n.class) {
            f1836b.f1854t = 118;
        }
    }

    /* renamed from: a */
    public static synchronized void m3276a(Context context) {
        synchronized (C0752n.class) {
            if (f1836b == null) {
                f1836b = new C0752n(context);
            } else if (f1836b.f1856v < SystemClock.elapsedRealtime() - 43200000) {
                f1836b.m3285t();
            }
        }
    }

    /* renamed from: b */
    private static long m3277b(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getLong(str, 0);
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: b */
    public static synchronized C0752n m3278b() {
        C0752n nVar;
        synchronized (C0752n.class) {
            nVar = f1836b;
        }
        return nVar;
    }

    /* renamed from: b */
    private static String m3279b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length == 0) {
                new IllegalStateException("No signatures found");
                return null;
            } else if (packageInfo.signatures.length <= 1) {
                return m3274a(packageInfo.signatures[0].toByteArray());
            } else {
                new IllegalStateException("Unexpected number of signatures: " + packageInfo.signatures.length);
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: c */
    private static C0753o m3280c(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int a = m3273a(defaultSharedPreferences, "scmid");
        long b = m3277b(defaultSharedPreferences, "newscmid");
        if (a == 0 && b == 0) {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string == null || string.equals("9774d56d682e549c") || string.equals("67ef2b122f51423f")) {
                string = "";
            }
            if (string.length() == 0) {
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 16; i++) {
                    sb.append(random.nextInt(16) + 97);
                }
                string = sb.toString();
            }
            a = string.hashCode();
            b = m3281d(string);
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putInt("scmid", a);
            edit.putLong("newscmid", b);
            edit.apply();
        }
        String b2 = C0756r.m3312b(new byte[]{(byte) ((a >> 24) & 255), (byte) ((a >> 16) & 255), (byte) ((a >> 8) & 255), (byte) (a & 255)});
        byte[] bArr = new byte[8];
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2] = (byte) ((int) ((b >> (i2 * 8)) & 255));
        }
        return new C0753o(a, b2, C0756r.m3312b(bArr));
    }

    /* renamed from: d */
    public static long m3281d(String str) {
        long j = 0;
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes()); // CRYPTOGRAPHIC API CALLSITE 2, CRYPTOGRAPHIC API CALLSITE 11
            for (int i = 0; i < 8; i++) {
                j |= (((long) digest[i]) & 255) << (i * 8);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e(f1835a, "MD5 not found!");
            for (int i2 = 0; i2 < str.length(); i2++) {
                j = (j * 7265812761L) + ((long) ((str.charAt(i2) + '{') * 41));
            }
        }
        return j;
    }

    /* renamed from: d */
    private static String m3282d(Context context) {
        try {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName != null ? installerPackageName : "";
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: e */
    private static C0755q m3283e(Context context) {
        String str;
        String str2 = "";
        String str3 = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str2 = telephonyManager.getNetworkCountryIso();
            if (str2 == null) {
                str2 = "";
            }
            str3 = telephonyManager.getSimCountryIso();
            if (str3 == null) {
                str3 = "";
            }
            str = telephonyManager.getSimOperator();
            if (str == null) {
                str = "";
            }
        } catch (Exception e) {
            str = "";
        }
        return new C0755q(str2, str3, str);
    }

    /* renamed from: f */
    private static C0754p m3284f(Context context) {
        int i;
        int i2;
        int i3;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i4 = displayMetrics.densityDpi;
            try {
                i3 = (int) (((float) Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels)) / displayMetrics.density);
                i2 = i4;
            } catch (Exception e) {
                i = i4;
                i2 = i;
                i3 = -1;
                return new C0754p(i2, i3);
            }
        } catch (Exception e2) {
            i = -1;
            i2 = i;
            i3 = -1;
            return new C0754p(i2, i3);
        }
        return new C0754p(i2, i3);
    }

    /* renamed from: t */
    private void m3285t() {
        boolean z;
        this.f1856v = SystemClock.elapsedRealtime();
        this.f1852r = C0705a.m3174a().mo3379b();
        Context context = this.f1837c;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=com.google.android.gm"));
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ResolveInfo next = it.next();
            if ("com.android.vending".equals(next.activityInfo == null ? null : next.activityInfo.packageName)) {
                z = true;
                break;
            }
        }
        this.f1853s = z ? m3272a(this.f1837c, "com.android.vending") : -1;
    }

    /* renamed from: u */
    private static String m3286u() {
        String str;
        String str2 = "";
        Field[] fields = Build.class.getFields();
        int length = fields.length;
        int i = 0;
        while (i < length) {
            Field field = fields[i];
            if (field.getName().equals("MANUFACTURER")) {
                try {
                    str = (String) field.get((Object) null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i++;
                str2 = str;
            }
            str = str2;
            i++;
            str2 = str;
        }
        return str2;
    }

    /* renamed from: a */
    public final String mo3426a(String str) {
        if (this.f1851q == null) {
            return null;
        }
        return this.f1851q.getString(str);
    }

    /* renamed from: b */
    public final boolean mo3427b(String str) {
        if (this.f1851q == null) {
            return false;
        }
        Object obj = this.f1851q.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 1;
        }
        if (obj instanceof String) {
            return "1".equals(obj) || Boolean.parseBoolean((String) obj);
        }
        return false;
    }

    /* renamed from: c */
    public final int mo3428c(String str) {
        if (this.f1851q == null) {
            return 0;
        }
        Object obj = this.f1851q.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            return Color.parseColor((String) obj);
        }
        return 0;
    }

    /* renamed from: c */
    public final String mo3429c() {
        return this.f1855u;
    }

    /* renamed from: d */
    public final int mo3430d() {
        return this.f1841g;
    }

    /* renamed from: e */
    public final String mo3431e() {
        return this.f1843i;
    }

    /* renamed from: f */
    public final int mo3432f() {
        return this.f1848n;
    }

    /* renamed from: g */
    public final String mo3433g() {
        return this.f1840f.f1858b;
    }

    /* renamed from: h */
    public final String mo3434h() {
        return this.f1840f.f1859c;
    }

    /* renamed from: i */
    public final String mo3435i() {
        return this.f1842h;
    }

    /* renamed from: j */
    public final int mo3436j() {
        return this.f1853s;
    }

    /* renamed from: k */
    public final String mo3437k() {
        return this.f1839e;
    }

    /* renamed from: l */
    public final int mo3438l() {
        return this.f1852r;
    }

    /* renamed from: m */
    public final String mo3439m() {
        return this.f1845k.f1862a;
    }

    /* renamed from: n */
    public final String mo3440n() {
        return this.f1845k.f1863b;
    }

    /* renamed from: o */
    public final String mo3441o() {
        return this.f1845k.f1864c;
    }

    /* renamed from: p */
    public final int mo3442p() {
        return this.f1846l.f1860a;
    }

    /* renamed from: q */
    public final int mo3443q() {
        return this.f1846l.f1861b;
    }

    /* renamed from: r */
    public final String mo3444r() {
        return this.f1847m;
    }

    /* renamed from: s */
    public final String mo3445s() {
        return this.f1850p.mo3446a();
    }
}
