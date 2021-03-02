package com.jackhenry.godough.core.widgets;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.widgets.a */
class C1919a implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ DollarAmountEditText f6880a;

    C1919a(DollarAmountEditText dollarAmountEditText) {
        this.f6880a = dollarAmountEditText;
    }

    public void onFocusChange(View view, boolean z) {
        if (!z && this.f6880a.f6856a != null) {
            this.f6880a.f6856a.onValueChanged(this.f6880a);
        }
    }
}
