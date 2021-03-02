package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0309bs;

/* renamed from: com.google.android.gms.internal.br */
public final class C0307br {

    /* renamed from: com.google.android.gms.internal.br$a */
    public interface C0308a {
        /* renamed from: a */
        void mo4154a(C0316bw bwVar);
    }

    /* renamed from: a */
    public static C0332cg m626a(Context context, C0313bu buVar, C0308a aVar) {
        return buVar.f912eg.f1017hS ? m627b(context, buVar, aVar) : m628c(context, buVar, aVar);
    }

    /* renamed from: b */
    private static C0332cg m627b(Context context, C0313bu buVar, C0308a aVar) {
        C0344cn.m733m("Fetching ad response from local ad request service.");
        C0309bs.C0310a aVar2 = new C0309bs.C0310a(context, buVar, aVar);
        aVar2.start();
        return aVar2;
    }

    /* renamed from: c */
    private static C0332cg m628c(Context context, C0313bu buVar, C0308a aVar) {
        C0344cn.m733m("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C0309bs.C0311b(context, buVar, aVar);
        }
        C0344cn.m737q("Failed to connect to remote ad request service.");
        return null;
    }
}
