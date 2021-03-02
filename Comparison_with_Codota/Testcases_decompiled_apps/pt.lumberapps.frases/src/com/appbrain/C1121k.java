package com.appbrain;

import android.content.Context;
import com.appbrain.p032a.C0793ai;
import com.appbrain.p032a.C0828bq;
import com.appbrain.p032a.C0884ds;
import com.appbrain.p032a.C0890dy;
import com.appbrain.p032a.C0926fg;
import com.appbrain.p032a.C0932fm;

/* renamed from: com.appbrain.k */
public class C1121k {
    /* renamed from: a */
    public static C1107h m5207a() {
        if (!C0793ai.f2081a) {
            return new C0828bq();
        }
        m5212d();
        return C0884ds.m3834a();
    }

    /* renamed from: a */
    public static void m5208a(Context context) {
        if (C0793ai.f2081a) {
            C0926fg.m3925a().mo3817a(context, true, true);
        }
    }

    /* renamed from: b */
    public static C0983ad m5209b() {
        if (!C0793ai.f2081a) {
            return new C1122l();
        }
        m5212d();
        return C0932fm.m3968a().mo3844c();
    }

    /* renamed from: b */
    public static void m5210b(Context context) {
        if (C0793ai.f2081a) {
            C0926fg.m3925a().mo3817a(context, false, true);
        }
    }

    /* renamed from: c */
    public static C1120j m5211c() {
        m5212d();
        return C0890dy.m3857a();
    }

    /* renamed from: d */
    private static void m5212d() {
        if (C0793ai.f2081a && !C0926fg.m3925a().mo3818b()) {
            throw new IllegalStateException("Please call AppBrain.init(context) in the onCreate of your Activity, or AppBrain.initApp() in the onCreate of your Application or Service or as the first thing in a BroadcastReceiver");
        }
    }
}
