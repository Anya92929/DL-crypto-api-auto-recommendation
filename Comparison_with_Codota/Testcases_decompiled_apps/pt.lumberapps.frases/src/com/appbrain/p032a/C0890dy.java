package com.appbrain.p032a;

import android.content.Context;
import com.appbrain.C1120j;
import com.appbrain.p037f.C1078f;

/* renamed from: com.appbrain.a.dy */
public final class C0890dy implements C1120j {

    /* renamed from: a */
    private static C0890dy f2360a;

    private C0890dy() {
    }

    /* renamed from: a */
    public static synchronized C0890dy m3857a() {
        C0890dy dyVar;
        synchronized (C0890dy.class) {
            if (f2360a == null) {
                f2360a = new C0890dy();
            }
            dyVar = f2360a;
        }
        return dyVar;
    }

    /* renamed from: a */
    public final void mo3770a(String str, int i) {
        if (C0793ai.f2081a) {
            Context c = C0926fg.m3925a().mo3819c();
            if (C0926fg.m3925a().mo3820d() && C0932fm.m3968a().mo3840a("convoff", 0) == 0) {
                if (str != null && str.length() > 20) {
                    str = str.substring(0, 20);
                }
                C0870de.m3790a(c).mo3744a(C1078f.m4930l().mo4337a(System.currentTimeMillis()).mo4339a(str).mo4336a(i).mo4028d());
            }
        }
    }
}
