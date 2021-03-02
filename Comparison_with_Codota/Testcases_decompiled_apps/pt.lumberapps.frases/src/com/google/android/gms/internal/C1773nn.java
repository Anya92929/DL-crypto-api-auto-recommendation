package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* renamed from: com.google.android.gms.internal.nn */
final class C1773nn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsPromptResult f5396a;

    /* renamed from: b */
    final /* synthetic */ EditText f5397b;

    C1773nn(JsPromptResult jsPromptResult, EditText editText) {
        this.f5396a = jsPromptResult;
        this.f5397b = editText;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5396a.confirm(this.f5397b.getText().toString());
    }
}
