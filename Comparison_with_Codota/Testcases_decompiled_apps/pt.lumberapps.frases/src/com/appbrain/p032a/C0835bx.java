package com.appbrain.p032a;

import android.os.SystemClock;
import cmn.C0749k;

/* renamed from: com.appbrain.a.bx */
final class C0835bx implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2203a;

    /* renamed from: b */
    final /* synthetic */ String f2204b;

    /* renamed from: c */
    final /* synthetic */ String f2205c;

    /* renamed from: d */
    final /* synthetic */ C0800ap f2206d;

    C0835bx(C0800ap apVar, String str, String str2, String str3) {
        this.f2206d = apVar;
        this.f2203a = str;
        this.f2204b = str2;
        this.f2205c = str3;
    }

    public final void run() {
        if (this.f2206d.f2105e == C0841cc.f2215a) {
            int unused = this.f2206d.f2105e = C0841cc.f2216b;
            C0932fm.m3968a().mo3850i();
            for (String str : this.f2203a.split(",")) {
                if (C0749k.m3268a(this.f2206d.f2101a, str)) {
                    this.f2206d.f2104d.mo4322b(str);
                }
            }
            for (String a : this.f2204b.split(",")) {
                this.f2206d.f2104d.mo4320a(a);
            }
            this.f2206d.f2104d.mo4323c(this.f2205c);
            if (this.f2206d.f2103c) {
                long unused2 = this.f2206d.f2106f = SystemClock.elapsedRealtime();
            } else {
                this.f2206d.sendImpression();
            }
        }
    }
}
