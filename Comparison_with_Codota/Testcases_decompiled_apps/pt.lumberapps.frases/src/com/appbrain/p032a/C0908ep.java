package com.appbrain.p032a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.appbrain.p037f.C1056av;

/* renamed from: com.appbrain.a.ep */
final class C0908ep implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1056av f2387a;

    /* renamed from: b */
    final /* synthetic */ Activity f2388b;

    C0908ep(C1056av avVar, Activity activity) {
        this.f2387a = avVar;
        this.f2388b = activity;
    }

    public final void onClick(View view) {
        C0905em.m3883a(this.f2387a, true);
        C0911es.m3894a((Context) this.f2388b, this.f2387a.mo4246p(), this.f2387a.mo4248r());
    }
}
