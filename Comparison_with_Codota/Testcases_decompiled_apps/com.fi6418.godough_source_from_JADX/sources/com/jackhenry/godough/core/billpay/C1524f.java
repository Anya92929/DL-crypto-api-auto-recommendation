package com.jackhenry.godough.core.billpay;

import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.model.BillPayPayee;

/* renamed from: com.jackhenry.godough.core.billpay.f */
class C1524f implements C1593j {

    /* renamed from: a */
    final /* synthetic */ BillPayPayee f6046a;

    /* renamed from: b */
    final /* synthetic */ BillPayFragment f6047b;

    C1524f(BillPayFragment billPayFragment, BillPayPayee billPayPayee) {
        this.f6047b = billPayFragment;
        this.f6046a = billPayPayee;
    }

    public void run() {
        this.f6047b.m6008a(this.f6046a);
    }
}
