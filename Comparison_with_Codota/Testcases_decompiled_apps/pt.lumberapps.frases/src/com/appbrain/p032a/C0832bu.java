package com.appbrain.p032a;

import android.os.Bundle;
import android.text.TextUtils;
import cmn.C0726au;
import com.appbrain.p033b.C1011o;
import com.appbrain.p037f.C1050ap;
import com.appbrain.p037f.C1052ar;
import com.appbrain.p037f.C1054at;

/* renamed from: com.appbrain.a.bu */
final class C0832bu extends C0726au {

    /* renamed from: c */
    final /* synthetic */ Bundle f2194c;

    /* renamed from: d */
    final /* synthetic */ C0829br f2195d;

    C0832bu(C0829br brVar, Bundle bundle) {
        this.f2195d = brVar;
        this.f2194c = bundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Object mo3411a() {
        C1052ar t = C1050ap.m4645t();
        t.mo4233b(this.f2195d.mo3827h().getResources().getConfiguration().orientation);
        if (this.f2195d.f2191g != null && this.f2195d.f2191g != C1054at.UNKNOWN_SOURCE) {
            t.mo4230a(this.f2195d.f2191g);
        } else if (this.f2195d.f2191g != null) {
            t.mo4230a(this.f2195d.f2191g);
        } else {
            t.mo4230a(C1054at.UNKNOWN_SOURCE);
        }
        int i = this.f2194c.getInt("bt", -1);
        if (i != -1) {
            t.mo4227a(i);
        }
        if (this.f2194c.containsKey("bo")) {
            t.mo4232a(this.f2194c.getBoolean("bo"));
        }
        if (this.f2194c.containsKey("id")) {
            t.mo4234c(this.f2194c.getInt("id"));
        }
        String string = this.f2194c.getString("ca");
        String str = this.f2195d.mo3830k() ? "full" : "frag";
        if (!TextUtils.isEmpty(string)) {
            t.mo4231a(string + "&" + str);
        } else {
            t.mo4231a(str);
        }
        return this.f2195d.f2190f + (this.f2195d.f2190f.contains("?") ? "&" : "?") + C0829br.m3684a(this.f2195d.f2186b.mo3724a((C1011o) t.mo4028d(), "ow"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ void mo3412a(Object obj) {
        this.f2195d.f2188d.loadUrl((String) obj);
    }
}
