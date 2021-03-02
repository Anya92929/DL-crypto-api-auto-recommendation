package com.google.android.gms.internal;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.lo */
public class C1510lo {

    /* renamed from: Dd */
    private final String f4268Dd;

    /* renamed from: Dh */
    private final C1555md<C1538lw> f4269Dh;

    /* renamed from: IH */
    private final String f4270IH;
    private C1511lp aep = null;
    private final Context mContext;

    private C1510lo(Context context, String str, String str2, C1555md<C1538lw> mdVar) {
        this.mContext = context;
        this.f4268Dd = str;
        this.f4269Dh = mdVar;
        this.f4270IH = str2;
    }

    /* renamed from: a */
    public static C1510lo m5456a(Context context, String str, String str2, C1555md<C1538lw> mdVar) {
        return new C1510lo(context, str, str2, mdVar);
    }
}
