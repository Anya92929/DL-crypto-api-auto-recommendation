package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

@C1130ez
/* renamed from: com.google.android.gms.internal.fw */
public final class C1193fw {

    /* renamed from: uS */
    public final int f3642uS;

    /* renamed from: uT */
    public final boolean f3643uT;

    /* renamed from: uU */
    public final boolean f3644uU;

    /* renamed from: uV */
    public final String f3645uV;

    /* renamed from: uW */
    public final String f3646uW;

    /* renamed from: uX */
    public final boolean f3647uX;

    /* renamed from: uY */
    public final boolean f3648uY;

    /* renamed from: uZ */
    public final boolean f3649uZ;

    /* renamed from: va */
    public final String f3650va;

    /* renamed from: vb */
    public final String f3651vb;

    /* renamed from: vc */
    public final int f3652vc;

    /* renamed from: vd */
    public final int f3653vd;

    /* renamed from: ve */
    public final int f3654ve;

    /* renamed from: vf */
    public final int f3655vf;

    /* renamed from: vg */
    public final int f3656vg;

    /* renamed from: vh */
    public final int f3657vh;

    /* renamed from: vi */
    public final float f3658vi;

    /* renamed from: vj */
    public final int f3659vj;

    /* renamed from: vk */
    public final int f3660vk;

    /* renamed from: vl */
    public final double f3661vl;

    /* renamed from: vm */
    public final boolean f3662vm;

    /* renamed from: vn */
    public final boolean f3663vn;

    /* renamed from: vo */
    public final int f3664vo;

    public C1193fw(Context context) {
        boolean z = true;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Locale locale = Locale.getDefault();
        PackageManager packageManager = context.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f3642uS = audioManager.getMode();
        this.f3643uT = m4539a(packageManager, "geo:0,0?q=donuts") != null;
        this.f3644uU = m4539a(packageManager, "http://www.google.com") != null;
        this.f3645uV = telephonyManager.getNetworkOperator();
        this.f3646uW = locale.getCountry();
        this.f3647uX = C1228gr.m4672ds();
        this.f3648uY = audioManager.isMusicActive();
        this.f3649uZ = audioManager.isSpeakerphoneOn();
        this.f3650va = locale.getLanguage();
        this.f3651vb = m4540a(packageManager);
        this.f3652vc = audioManager.getStreamVolume(3);
        this.f3653vd = m4538a(context, connectivityManager, packageManager);
        this.f3654ve = telephonyManager.getNetworkType();
        this.f3655vf = telephonyManager.getPhoneType();
        this.f3656vg = audioManager.getRingerMode();
        this.f3657vh = audioManager.getStreamVolume(2);
        this.f3658vi = displayMetrics.density;
        this.f3659vj = displayMetrics.widthPixels;
        this.f3660vk = displayMetrics.heightPixels;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.f3661vl = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (!(intExtra == 2 || intExtra == 5)) {
                z = false;
            }
            this.f3662vm = z;
        } else {
            this.f3661vl = -1.0d;
            this.f3662vm = false;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3663vn = connectivityManager.isActiveNetworkMetered();
            if (connectivityManager.getActiveNetworkInfo() != null) {
                this.f3664vo = connectivityManager.getActiveNetworkInfo().getDetailedState().ordinal();
            } else {
                this.f3664vo = -1;
            }
        } else {
            this.f3663vn = false;
            this.f3664vo = -1;
        }
    }

    /* renamed from: a */
    private static int m4538a(Context context, ConnectivityManager connectivityManager, PackageManager packageManager) {
        if (!C1213gj.m4625a(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            return -2;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getType();
        }
        return -1;
    }

    /* renamed from: a */
    private static ResolveInfo m4539a(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    /* renamed from: a */
    private static String m4540a(PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo a = m4539a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a == null || (activityInfo = a.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode + "." + activityInfo.packageName;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }
}
