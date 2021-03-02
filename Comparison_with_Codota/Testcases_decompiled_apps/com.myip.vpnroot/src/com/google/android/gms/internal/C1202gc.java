package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;

@C1130ez
/* renamed from: com.google.android.gms.internal.gc */
public class C1202gc {

    /* renamed from: mw */
    private final Object f3728mw = new Object();

    /* renamed from: vL */
    private final String f3729vL;

    /* renamed from: vX */
    private int f3730vX = 0;

    /* renamed from: vY */
    private long f3731vY = -1;

    /* renamed from: vZ */
    private long f3732vZ = -1;

    /* renamed from: wa */
    private int f3733wa = 0;

    /* renamed from: wb */
    private int f3734wb = -1;

    public C1202gc(String str) {
        this.f3729vL = str;
    }

    /* renamed from: m */
    public static boolean m4590m(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            C1229gs.m4677U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            C1229gs.m4677U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            C1229gs.m4679W("Fail to fetch AdActivity theme");
            C1229gs.m4677U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    /* renamed from: b */
    public Bundle mo8575b(Context context, String str) {
        Bundle bundle;
        synchronized (this.f3728mw) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f3729vL);
            bundle.putLong("basets", this.f3732vZ);
            bundle.putLong("currts", this.f3731vY);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f3734wb);
            bundle.putInt("pclick", this.f3730vX);
            bundle.putInt("pimp", this.f3733wa);
            bundle.putBoolean("support_transparent_background", m4590m(context));
        }
        return bundle;
    }

    /* renamed from: b */
    public void mo8576b(C0924av avVar, long j) {
        synchronized (this.f3728mw) {
            if (this.f3732vZ == -1) {
                this.f3732vZ = j;
                this.f3731vY = this.f3732vZ;
            } else {
                this.f3731vY = j;
            }
            if (avVar.extras == null || avVar.extras.getInt("gw", 2) != 1) {
                this.f3734wb++;
            }
        }
    }

    /* renamed from: cP */
    public void mo8577cP() {
        synchronized (this.f3728mw) {
            this.f3733wa++;
        }
    }

    /* renamed from: cQ */
    public void mo8578cQ() {
        synchronized (this.f3728mw) {
            this.f3730vX++;
        }
    }

    /* renamed from: di */
    public long mo8579di() {
        return this.f3732vZ;
    }
}
