package com.flurry.android;

import android.content.Context;
import android.os.Handler;

/* renamed from: com.flurry.android.al */
final class C0098al implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f119a;

    /* renamed from: b */
    final /* synthetic */ Context f120b;

    /* renamed from: c */
    final /* synthetic */ C0114p f121c;

    /* renamed from: d */
    final /* synthetic */ C0120v f122d;

    C0098al(C0120v vVar, String str, Context context, C0114p pVar) {
        this.f122d = vVar;
        this.f119a = str;
        this.f120b = context;
        this.f121c = pVar;
    }

    public final void run() {
        new Handler().post(new C0111m(this, this.f122d.m137d(this.f119a)));
    }
}
