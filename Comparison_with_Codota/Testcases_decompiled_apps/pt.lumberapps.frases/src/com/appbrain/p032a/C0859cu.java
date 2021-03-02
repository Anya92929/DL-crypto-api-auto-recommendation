package com.appbrain.p032a;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.appbrain.a.cu */
final class C0859cu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f2277a;

    /* renamed from: b */
    final /* synthetic */ long f2278b;

    /* renamed from: c */
    final /* synthetic */ SharedPreferences f2279c;

    /* renamed from: d */
    final /* synthetic */ C0858ct f2280d;

    C0859cu(C0858ct ctVar, Context context, long j, SharedPreferences sharedPreferences) {
        this.f2280d = ctVar;
        this.f2277a = context;
        this.f2278b = j;
        this.f2279c = sharedPreferences;
    }

    public final void run() {
        try {
            this.f2280d.mo3736c(this.f2277a);
            this.f2280d.m3765a(this.f2278b, 0, 0, this.f2279c);
        } catch (Exception e) {
            e.printStackTrace();
            this.f2280d.m3765a(this.f2279c.getLong(this.f2280d.f2273c, 0), this.f2278b, this.f2279c.getLong(this.f2280d.f2275e, 0) + 1, this.f2279c);
        }
        this.f2280d.f2272b.set(false);
    }
}
