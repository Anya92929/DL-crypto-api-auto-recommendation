package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.internal.nj */
final class C1769nj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f5392a;

    C1769nj(JsResult jsResult) {
        this.f5392a = jsResult;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5392a.cancel();
    }
}
