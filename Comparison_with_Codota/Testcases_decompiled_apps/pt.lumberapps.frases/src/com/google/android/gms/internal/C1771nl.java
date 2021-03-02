package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* renamed from: com.google.android.gms.internal.nl */
final class C1771nl implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ JsPromptResult f5394a;

    C1771nl(JsPromptResult jsPromptResult) {
        this.f5394a = jsPromptResult;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f5394a.cancel();
    }
}
