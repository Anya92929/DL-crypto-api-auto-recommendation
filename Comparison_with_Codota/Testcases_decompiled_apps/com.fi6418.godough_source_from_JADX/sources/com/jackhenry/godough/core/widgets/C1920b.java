package com.jackhenry.godough.core.widgets;

import android.text.Editable;
import android.text.TextWatcher;
import com.jackhenry.android.p022a.C1364k;

/* renamed from: com.jackhenry.godough.core.widgets.b */
class C1920b implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ DollarAmountEditText f6881a;

    C1920b(DollarAmountEditText dollarAmountEditText) {
        this.f6881a = dollarAmountEditText;
    }

    public void afterTextChanged(Editable editable) {
        String replaceAll = editable.toString().replaceAll("[^0-9]", "");
        if (replaceAll.length() > 0 && Double.parseDouble(replaceAll) == 0.0d) {
            editable.clear();
        } else if (replaceAll.length() > 0) {
            if (replaceAll.length() == 1) {
                replaceAll = "00" + replaceAll;
            }
            String a = C1364k.m5587a(Double.parseDouble(replaceAll.substring(0, replaceAll.length() - 2) + "." + replaceAll.substring(replaceAll.length() - 2)), 2);
            if (!editable.toString().equals(a.replaceAll(",", ""))) {
                editable.replace(0, editable.length(), a);
            }
        }
        if (this.f6881a.f6856a != null) {
            this.f6881a.f6856a.onValueChanged(this.f6881a);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
