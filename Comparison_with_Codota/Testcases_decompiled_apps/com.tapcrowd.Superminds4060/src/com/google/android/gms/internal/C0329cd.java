package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.cd */
public final class C0329cd {

    /* renamed from: hh */
    public final int f962hh;

    /* renamed from: hi */
    public final boolean f963hi;

    /* renamed from: hj */
    public final boolean f964hj;

    /* renamed from: hk */
    public final String f965hk;

    /* renamed from: hl */
    public final String f966hl;

    /* renamed from: hm */
    public final boolean f967hm;

    /* renamed from: hn */
    public final boolean f968hn;

    /* renamed from: ho */
    public final boolean f969ho;

    /* renamed from: hp */
    public final String f970hp;

    /* renamed from: hq */
    public final String f971hq;

    /* renamed from: hr */
    public final int f972hr;

    /* renamed from: hs */
    public final int f973hs;

    /* renamed from: ht */
    public final int f974ht;

    /* renamed from: hu */
    public final int f975hu;

    /* renamed from: hv */
    public final int f976hv;

    /* renamed from: hw */
    public final int f977hw;

    /* renamed from: hx */
    public final float f978hx;

    /* renamed from: hy */
    public final int f979hy;

    /* renamed from: hz */
    public final int f980hz;

    public C0329cd(Context context) {
        boolean z = true;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Locale locale = Locale.getDefault();
        PackageManager packageManager = context.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.f962hh = audioManager.getMode();
        this.f963hi = m683a(packageManager, "geo:0,0?q=donuts") != null;
        this.f964hj = m683a(packageManager, "http://www.google.com") == null ? false : z;
        this.f965hk = telephonyManager.getNetworkOperator();
        this.f966hl = locale.getCountry();
        this.f967hm = C0343cm.m725aq();
        this.f968hn = audioManager.isMusicActive();
        this.f969ho = audioManager.isSpeakerphoneOn();
        this.f970hp = locale.getLanguage();
        this.f971hq = m684a(packageManager);
        this.f972hr = audioManager.getStreamVolume(3);
        this.f973hs = m682a(context, connectivityManager, packageManager);
        this.f974ht = telephonyManager.getNetworkType();
        this.f975hu = telephonyManager.getPhoneType();
        this.f976hv = audioManager.getRingerMode();
        this.f977hw = audioManager.getStreamVolume(2);
        this.f978hx = displayMetrics.density;
        this.f979hy = displayMetrics.widthPixels;
        this.f980hz = displayMetrics.heightPixels;
    }

    /* renamed from: a */
    private static int m682a(Context context, ConnectivityManager connectivityManager, PackageManager packageManager) {
        if (!C0337ci.m698a(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            return -2;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getType();
        }
        return -1;
    }

    /* renamed from: a */
    private static ResolveInfo m683a(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    /* renamed from: a */
    private static String m684a(PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo a = m683a(packageManager, "market://details?id=com.google.android.gms.ads");
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
