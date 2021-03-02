package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zzi;
import java.util.Locale;

@zzin
public final class zziv {
    public final int zzcbb;
    public final int zzcbc;
    public final float zzcbd;
    public final int zzcgd;
    public final boolean zzcge;
    public final boolean zzcgf;
    public final String zzcgg;
    public final String zzcgh;
    public final boolean zzcgi;
    public final boolean zzcgj;
    public final boolean zzcgk;
    public final boolean zzcgl;
    public final String zzcgm;
    public final String zzcgn;
    public final int zzcgo;
    public final int zzcgp;
    public final int zzcgq;
    public final int zzcgr;
    public final int zzcgs;
    public final int zzcgt;
    public final double zzcgu;
    public final boolean zzcgv;
    public final boolean zzcgw;
    public final int zzcgx;
    public final String zzcgy;
    public final boolean zzcgz;

    public final class zza {

        /* renamed from: a */
        private int f6476a;

        /* renamed from: b */
        private boolean f6477b;

        /* renamed from: c */
        private boolean f6478c;

        /* renamed from: d */
        private int f6479d;

        /* renamed from: e */
        private int f6480e;

        /* renamed from: f */
        private int f6481f;

        /* renamed from: g */
        private String f6482g;

        /* renamed from: h */
        private int f6483h;

        /* renamed from: i */
        private int f6484i;

        /* renamed from: j */
        private int f6485j;

        /* renamed from: k */
        private boolean f6486k;

        /* renamed from: l */
        private int f6487l;

        /* renamed from: m */
        private double f6488m;

        /* renamed from: n */
        private boolean f6489n;

        /* renamed from: o */
        private String f6490o;

        /* renamed from: p */
        private boolean f6491p;

        /* renamed from: q */
        private boolean f6492q;

        /* renamed from: r */
        private String f6493r;

        /* renamed from: s */
        private boolean f6494s;

        /* renamed from: t */
        private boolean f6495t;

        /* renamed from: u */
        private String f6496u;

        /* renamed from: v */
        private String f6497v;

        /* renamed from: w */
        private float f6498w;

        /* renamed from: x */
        private int f6499x;

        /* renamed from: y */
        private int f6500y;

        /* renamed from: z */
        private boolean f6501z;

        public zza(Context context) {
            DisplayMetrics displayMetrics;
            boolean z = true;
            PackageManager packageManager = context.getPackageManager();
            m7264a(context);
            m7265a(context, packageManager);
            m7266b(context);
            Locale locale = Locale.getDefault();
            this.f6491p = m7262a(packageManager, "geo:0,0?q=donuts") != null;
            this.f6492q = m7262a(packageManager, "http://www.google.com") == null ? false : z;
            this.f6493r = locale.getCountry();
            this.f6494s = zzm.zziw().zztw();
            this.f6495t = zzi.zzcl(context);
            this.f6496u = locale.getLanguage();
            this.f6497v = m7263a(packageManager);
            Resources resources = context.getResources();
            if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                this.f6498w = displayMetrics.density;
                this.f6499x = displayMetrics.widthPixels;
                this.f6500y = displayMetrics.heightPixels;
            }
        }

        public zza(Context context, zziv zziv) {
            PackageManager packageManager = context.getPackageManager();
            m7264a(context);
            m7265a(context, packageManager);
            m7266b(context);
            m7267c(context);
            this.f6491p = zziv.zzcge;
            this.f6492q = zziv.zzcgf;
            this.f6493r = zziv.zzcgh;
            this.f6494s = zziv.zzcgi;
            this.f6495t = zziv.zzcgj;
            this.f6496u = zziv.zzcgm;
            this.f6497v = zziv.zzcgn;
            this.f6498w = zziv.zzcbd;
            this.f6499x = zziv.zzcbb;
            this.f6500y = zziv.zzcbc;
        }

        /* renamed from: a */
        private static ResolveInfo m7262a(PackageManager packageManager, String str) {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        }

        /* renamed from: a */
        private static String m7263a(PackageManager packageManager) {
            ActivityInfo activityInfo;
            ResolveInfo a = m7262a(packageManager, "market://details?id=com.google.android.gms.ads");
            if (a == null || (activityInfo = a.activityInfo) == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                if (packageInfo == null) {
                    return null;
                }
                int i = packageInfo.versionCode;
                String valueOf = String.valueOf(activityInfo.packageName);
                return new StringBuilder(String.valueOf(valueOf).length() + 12).append(i).append(".").append(valueOf).toString();
            } catch (PackageManager.NameNotFoundException e) {
                return null;
            }
        }

        /* renamed from: a */
        private void m7264a(Context context) {
            AudioManager zzak = zzu.zzfq().zzak(context);
            if (zzak != null) {
                try {
                    this.f6476a = zzak.getMode();
                    this.f6477b = zzak.isMusicActive();
                    this.f6478c = zzak.isSpeakerphoneOn();
                    this.f6479d = zzak.getStreamVolume(3);
                    this.f6480e = zzak.getRingerMode();
                    this.f6481f = zzak.getStreamVolume(2);
                    return;
                } catch (Throwable th) {
                    zzu.zzft().zzb(th, true);
                }
            }
            this.f6476a = -2;
            this.f6477b = false;
            this.f6478c = false;
            this.f6479d = 0;
            this.f6480e = 0;
            this.f6481f = 0;
        }

        @TargetApi(16)
        /* renamed from: a */
        private void m7265a(Context context, PackageManager packageManager) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.f6482g = telephonyManager.getNetworkOperator();
            this.f6484i = telephonyManager.getNetworkType();
            this.f6485j = telephonyManager.getPhoneType();
            this.f6483h = -2;
            this.f6486k = false;
            this.f6487l = -1;
            if (zzu.zzfq().zza(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.f6483h = activeNetworkInfo.getType();
                    this.f6487l = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.f6483h = -1;
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f6486k = connectivityManager.isActiveNetworkMetered();
                }
            }
        }

        /* renamed from: b */
        private void m7266b(Context context) {
            boolean z = false;
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                this.f6488m = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
                if (intExtra == 2 || intExtra == 5) {
                    z = true;
                }
                this.f6489n = z;
                return;
            }
            this.f6488m = -1.0d;
            this.f6489n = false;
        }

        /* renamed from: c */
        private void m7267c(Context context) {
            this.f6490o = Build.FINGERPRINT;
            this.f6501z = zzdq.zzo(context);
        }

        public zziv zzrn() {
            return new zziv(this.f6476a, this.f6491p, this.f6492q, this.f6482g, this.f6493r, this.f6494s, this.f6495t, this.f6477b, this.f6478c, this.f6496u, this.f6497v, this.f6479d, this.f6483h, this.f6484i, this.f6485j, this.f6480e, this.f6481f, this.f6498w, this.f6499x, this.f6500y, this.f6488m, this.f6489n, this.f6486k, this.f6487l, this.f6490o, this.f6501z);
        }
    }

    zziv(int i, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, double d, boolean z7, boolean z8, int i10, String str5, boolean z9) {
        this.zzcgd = i;
        this.zzcge = z;
        this.zzcgf = z2;
        this.zzcgg = str;
        this.zzcgh = str2;
        this.zzcgi = z3;
        this.zzcgj = z4;
        this.zzcgk = z5;
        this.zzcgl = z6;
        this.zzcgm = str3;
        this.zzcgn = str4;
        this.zzcgo = i2;
        this.zzcgp = i3;
        this.zzcgq = i4;
        this.zzcgr = i5;
        this.zzcgs = i6;
        this.zzcgt = i7;
        this.zzcbd = f;
        this.zzcbb = i8;
        this.zzcbc = i9;
        this.zzcgu = d;
        this.zzcgv = z7;
        this.zzcgw = z8;
        this.zzcgx = i10;
        this.zzcgy = str5;
        this.zzcgz = z9;
    }
}
