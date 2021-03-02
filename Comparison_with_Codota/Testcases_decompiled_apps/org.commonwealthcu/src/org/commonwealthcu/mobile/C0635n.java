package org.commonwealthcu.mobile;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* renamed from: org.commonwealthcu.mobile.n */
final class C0635n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private /* synthetic */ JsResult f853a;

    C0635n(C0634m mVar, JsResult jsResult) {
        this.f853a = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f853a.confirm();
    }
}
