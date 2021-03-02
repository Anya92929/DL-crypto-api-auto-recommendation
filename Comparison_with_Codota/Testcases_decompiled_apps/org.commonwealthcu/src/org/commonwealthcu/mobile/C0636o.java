package org.commonwealthcu.mobile;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* renamed from: org.commonwealthcu.mobile.o */
final class C0636o implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private /* synthetic */ JsResult f854a;

    C0636o(C0634m mVar, JsResult jsResult) {
        this.f854a = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f854a.cancel();
    }
}
