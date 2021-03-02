package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.internal.ni */
final class C1768ni implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f5391a;

    C1768ni(JsResult jsResult) {
        this.f5391a = jsResult;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f5391a.cancel();
    }
}
