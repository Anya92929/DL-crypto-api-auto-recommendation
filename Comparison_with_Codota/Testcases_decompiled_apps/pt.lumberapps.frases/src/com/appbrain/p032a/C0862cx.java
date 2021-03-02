package com.appbrain.p032a;

import android.content.Context;
import cmn.C0708ac;
import com.appbrain.C1138z;
import com.appbrain.p037f.C1042ah;

/* renamed from: com.appbrain.a.cx */
final class C0862cx implements C0708ac {

    /* renamed from: a */
    final /* synthetic */ C0708ac f2285a;

    /* renamed from: b */
    final /* synthetic */ Context f2286b;

    /* renamed from: c */
    final /* synthetic */ C1138z f2287c;

    /* renamed from: d */
    final /* synthetic */ C0861cw f2288d;

    C0862cx(C0861cw cwVar, C0708ac acVar, Context context, C1138z zVar) {
        this.f2288d = cwVar;
        this.f2285a = acVar;
        this.f2286b = context;
        this.f2287c = zVar;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo3385a(Object obj) {
        C1042ah ahVar = (C1042ah) obj;
        if (ahVar == null || ahVar.mo4194g() == 0) {
            this.f2285a.mo3385a((Object) null);
        } else {
            C0861cw.m3779a(this.f2288d, this.f2286b, this.f2287c, this.f2285a, ahVar);
        }
    }
}
