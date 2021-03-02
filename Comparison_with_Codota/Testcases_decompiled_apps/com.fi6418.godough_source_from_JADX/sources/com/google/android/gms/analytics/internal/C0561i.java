package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.C0587r;

@Deprecated
/* renamed from: com.google.android.gms.analytics.internal.i */
public class C0561i {

    /* renamed from: a */
    private static volatile C0587r f3867a;

    static {
        m3258a((C0587r) new C0544bd());
    }

    /* renamed from: a */
    public static C0587r m3257a() {
        return f3867a;
    }

    /* renamed from: a */
    public static void m3258a(C0587r rVar) {
        f3867a = rVar;
    }

    /* renamed from: a */
    public static void m3259a(String str) {
        C0562j b = C0562j.m3264b();
        if (b != null) {
            b.mo6876d(str);
        } else if (m3261a(1)) {
            Log.i(C0551bk.f3819c.mo6775a(), str);
        }
        C0587r rVar = f3867a;
        if (rVar != null) {
            rVar.mo6760b(str);
        }
    }

    /* renamed from: a */
    public static void m3260a(String str, Object obj) {
        C0562j b = C0562j.m3264b();
        if (b != null) {
            b.mo6880e(str, obj);
        } else if (m3261a(3)) {
            Log.e(C0551bk.f3819c.mo6775a(), obj != null ? str + ":" + obj : str);
        }
        C0587r rVar = f3867a;
        if (rVar != null) {
            rVar.mo6762d(str);
        }
    }

    /* renamed from: a */
    public static boolean m3261a(int i) {
        return m3257a() != null && m3257a().mo6757a() <= i;
    }

    /* renamed from: b */
    public static void m3262b(String str) {
        C0562j b = C0562j.m3264b();
        if (b != null) {
            b.mo6869b(str);
        } else if (m3261a(0)) {
            Log.v(C0551bk.f3819c.mo6775a(), str);
        }
        C0587r rVar = f3867a;
        if (rVar != null) {
            rVar.mo6759a(str);
        }
    }

    /* renamed from: c */
    public static void m3263c(String str) {
        C0562j b = C0562j.m3264b();
        if (b != null) {
            b.mo6879e(str);
        } else if (m3261a(2)) {
            Log.w(C0551bk.f3819c.mo6775a(), str);
        }
        C0587r rVar = f3867a;
        if (rVar != null) {
            rVar.mo6761c(str);
        }
    }
}
