package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* renamed from: com.google.android.gms.internal.nm */
final class C1772nm implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsPromptResult f5395a;

    C1772nm(JsPromptResult jsPromptResult) {
        this.f5395a = jsPromptResult;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5395a.cancel();
    }
}
