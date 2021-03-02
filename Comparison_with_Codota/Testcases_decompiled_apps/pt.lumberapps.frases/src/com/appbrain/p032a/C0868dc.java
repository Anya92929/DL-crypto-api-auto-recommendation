package com.appbrain.p032a;

import android.content.Context;
import android.webkit.WebView;
import cmn.C0708ac;
import com.appbrain.C1138z;
import com.appbrain.p037f.C1042ah;

/* renamed from: com.appbrain.a.dc */
final class C0868dc implements C0708ac {

    /* renamed from: a */
    final /* synthetic */ C0708ac f2307a;

    /* renamed from: b */
    final /* synthetic */ Context f2308b;

    /* renamed from: c */
    final /* synthetic */ C1138z f2309c;

    /* renamed from: d */
    final /* synthetic */ C0867db f2310d;

    C0868dc(C0867db dbVar, C0708ac acVar, Context context, C1138z zVar) {
        this.f2310d = dbVar;
        this.f2307a = acVar;
        this.f2308b = context;
        this.f2309c = zVar;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo3385a(Object obj) {
        C1042ah ahVar = (C1042ah) obj;
        if (ahVar == null || !ahVar.mo4205n()) {
            this.f2307a.mo3385a((Object) null);
            return;
        }
        C0867db dbVar = this.f2310d;
        Context context = this.f2308b;
        C0708ac acVar = this.f2307a;
        WebView webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new C0800ap(context, false, (C0840cb) null), "applift_sdk");
        webView.loadData(ahVar.mo4206o(), "text/html", "UTF-8");
        acVar.mo3385a(new C0869dd(dbVar, webView, ahVar.mo4199i() + "&html=1"));
    }
}
