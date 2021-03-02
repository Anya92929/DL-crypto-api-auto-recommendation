package com.jackhenry.godough.core.billpay;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.billpay.m */
class C1531m implements C1593j {

    /* renamed from: a */
    final /* synthetic */ BillPayFragment f6056a;

    C1531m(BillPayFragment billPayFragment) {
        this.f6056a = billPayFragment;
    }

    public void run() {
        new Handler().post(new C1532n(this));
    }
}
