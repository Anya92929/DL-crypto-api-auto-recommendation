package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.internal.nk */
final class C1770nk implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f5393a;

    C1770nk(JsResult jsResult) {
        this.f5393a = jsResult;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5393a.confirm();
    }
}
