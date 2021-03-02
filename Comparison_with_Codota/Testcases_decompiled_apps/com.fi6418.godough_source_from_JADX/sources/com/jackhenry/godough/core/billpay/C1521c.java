package com.jackhenry.godough.core.billpay;

import android.content.DialogInterface;
import com.jackhenry.godough.core.model.BillPayPayee;

/* renamed from: com.jackhenry.godough.core.billpay.c */
class C1521c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BillPayFragment f6042a;

    C1521c(BillPayFragment billPayFragment) {
        this.f6042a = billPayFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0 && i < this.f6042a.f6021aq.size() && this.f6042a.f6018an != this.f6042a.f6021aq.get(i)) {
            BillPayPayee unused = this.f6042a.f6018an = (BillPayPayee) this.f6042a.f6021aq.get(i);
            this.f6042a.m6043w();
            this.f6042a.m6044x();
            this.f6042a.m6008a(this.f6042a.f6018an);
        }
        dialogInterface.dismiss();
    }
}
