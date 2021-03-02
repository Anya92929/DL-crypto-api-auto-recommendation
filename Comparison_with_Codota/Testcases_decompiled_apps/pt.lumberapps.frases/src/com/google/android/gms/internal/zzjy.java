package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.client.AdRequestParcel;

@zzin
public class zzjy {

    /* renamed from: a */
    long f6579a = -1;

    /* renamed from: b */
    long f6580b = -1;

    /* renamed from: c */
    int f6581c = -1;

    /* renamed from: d */
    final String f6582d;

    /* renamed from: e */
    int f6583e = 0;

    /* renamed from: f */
    int f6584f = 0;

    /* renamed from: g */
    private final Object f6585g = new Object();

    public zzjy(String str) {
        this.f6582d = str;
    }

    public static boolean zzab(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            zzkd.zzcw("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzkd.zzcw("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            zzkd.zzcx("Fail to fetch AdActivity theme");
            zzkd.zzcw("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public void zzb(AdRequestParcel adRequestParcel, long j) {
        synchronized (this.f6585g) {
            if (this.f6580b == -1) {
                this.f6580b = j;
                this.f6579a = this.f6580b;
            } else {
                this.f6579a = j;
            }
            if (adRequestParcel.extras == null || adRequestParcel.extras.getInt("gw", 2) != 1) {
                this.f6581c++;
            }
        }
    }

    public Bundle zze(Context context, String str) {
        Bundle bundle;
        synchronized (this.f6585g) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f6582d);
            bundle.putLong("basets", this.f6580b);
            bundle.putLong("currts", this.f6579a);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f6581c);
            bundle.putInt("pclick", this.f6583e);
            bundle.putInt("pimp", this.f6584f);
            bundle.putBoolean("support_transparent_background", zzab(context));
        }
        return bundle;
    }

    public void zzry() {
        synchronized (this.f6585g) {
            this.f6584f++;
        }
    }

    public void zzrz() {
        synchronized (this.f6585g) {
            this.f6583e++;
        }
    }

    public long zzsx() {
        return this.f6580b;
    }
}
