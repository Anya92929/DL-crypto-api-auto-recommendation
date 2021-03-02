package com.appbrain.p032a;

import android.content.DialogInterface;
import com.appbrain.p037f.C1056av;

/* renamed from: com.appbrain.a.ew */
final class C0915ew implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ C1056av f2404a;

    /* renamed from: b */
    final /* synthetic */ String f2405b;

    C0915ew(C1056av avVar, String str) {
        this.f2404a = avVar;
        this.f2405b = str;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        C0912et.f2395d.mo3782a();
        C0912et.m3899a(this.f2404a, this.f2405b);
    }
}
