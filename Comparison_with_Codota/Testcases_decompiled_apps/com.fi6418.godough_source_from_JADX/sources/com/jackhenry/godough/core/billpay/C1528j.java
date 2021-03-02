package com.jackhenry.godough.core.billpay;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.billpay.j */
class C1528j implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ View.OnFocusChangeListener f6052a;

    /* renamed from: b */
    final /* synthetic */ BillPayFragment f6053b;

    C1528j(BillPayFragment billPayFragment, View.OnFocusChangeListener onFocusChangeListener) {
        this.f6053b = billPayFragment;
        this.f6052a = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.f6052a != null) {
            this.f6052a.onFocusChange(view, z);
        }
        this.f6053b.m6025n();
    }
}
