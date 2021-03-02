package com.appbrain.p032a;

import android.content.Context;
import android.webkit.JavascriptInterface;
import cmn.C0725at;

/* renamed from: com.appbrain.a.bi */
final class C0820bi extends C0800ap {

    /* renamed from: a */
    final /* synthetic */ C0809ay f2156a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0820bi(C0809ay ayVar, Context context, boolean z, C0840cb cbVar) {
        super(context, z, cbVar);
        this.f2156a = ayVar;
    }

    @JavascriptInterface
    public final void showOfferWall() {
        C0725at.m3228a((Runnable) new C0821bj(this));
    }
}
