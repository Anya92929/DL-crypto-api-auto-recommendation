package com.appbrain.p032a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.appbrain.p037f.C1056av;

/* renamed from: com.appbrain.a.ed */
final class C0896ed implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1056av f2369a;

    /* renamed from: b */
    final /* synthetic */ Activity f2370b;

    C0896ed(C1056av avVar, Activity activity) {
        this.f2369a = avVar;
        this.f2370b = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0891dz.m3861a(this.f2369a, true);
        C0911es.m3894a((Context) this.f2370b, this.f2369a.mo4246p(), this.f2369a.mo4248r());
    }
}
