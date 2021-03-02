package com.jackhenry.godough.core.billpay;

import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.model.BillPayment;

/* renamed from: com.jackhenry.godough.core.billpay.g */
class C1525g implements C1593j {

    /* renamed from: a */
    final /* synthetic */ BillPayment f6048a;

    /* renamed from: b */
    final /* synthetic */ BillPayFragment f6049b;

    C1525g(BillPayFragment billPayFragment, BillPayment billPayment) {
        this.f6049b = billPayFragment;
        this.f6048a = billPayment;
    }

    public void run() {
        this.f6049b.submitData(this.f6048a);
    }
}
