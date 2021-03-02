package org.commonwealthcu.mobile;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* renamed from: org.commonwealthcu.mobile.p */
final class C0637p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private /* synthetic */ JsResult f855a;

    C0637p(C0634m mVar, JsResult jsResult) {
        this.f855a = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f855a.confirm();
    }
}
