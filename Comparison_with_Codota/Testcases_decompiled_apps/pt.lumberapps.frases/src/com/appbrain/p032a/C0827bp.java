package com.appbrain.p032a;

import cmn.C0752n;
import com.appbrain.C1115i;
import java.util.Locale;

/* renamed from: com.appbrain.a.bp */
public final class C0827bp {

    /* renamed from: a */
    private static C0827bp f2181a;

    /* renamed from: b */
    private final boolean f2182b;

    /* renamed from: c */
    private final C1115i f2183c;

    /* renamed from: d */
    private final int f2184d;

    private C0827bp() {
        C0752n b = C0752n.m3278b();
        this.f2182b = b.mo3427b("appbrain.child_directed");
        String a = b.mo3426a("appbrain.border_size");
        this.f2183c = a == null ? null : C1115i.valueOf(a.toUpperCase(Locale.US));
        this.f2184d = b.mo3428c("appbrain.border_color");
    }

    /* renamed from: a */
    public static synchronized void m3672a() {
        synchronized (C0827bp.class) {
            if (f2181a == null) {
                f2181a = new C0827bp();
            }
        }
    }

    /* renamed from: b */
    public static synchronized C0827bp m3673b() {
        C0827bp bpVar;
        synchronized (C0827bp.class) {
            bpVar = f2181a;
        }
        return bpVar;
    }

    /* renamed from: c */
    public final boolean mo3690c() {
        return this.f2182b;
    }

    /* renamed from: d */
    public final C1115i mo3691d() {
        return this.f2183c;
    }

    /* renamed from: e */
    public final int mo3692e() {
        return this.f2184d;
    }
}
