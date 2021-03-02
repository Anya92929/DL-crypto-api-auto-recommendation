package com.appbrain.p032a;

import android.app.Dialog;
import android.content.Context;

/* renamed from: com.appbrain.a.ff */
final class C0925ff extends Dialog {

    /* renamed from: a */
    final /* synthetic */ C0924fe f2420a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0925ff(C0924fe feVar, Context context) {
        super(context, 16973840);
        this.f2420a = feVar;
    }

    public final void onBackPressed() {
        if (!this.f2420a.f2419a.mo3834b()) {
            super.onBackPressed();
        }
    }
}
