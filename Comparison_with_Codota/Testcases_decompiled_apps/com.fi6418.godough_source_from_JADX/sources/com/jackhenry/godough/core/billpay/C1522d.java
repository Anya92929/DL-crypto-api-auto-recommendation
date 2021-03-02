package com.jackhenry.godough.core.billpay;

import android.content.DialogInterface;
import com.jackhenry.godough.core.model.Account;

/* renamed from: com.jackhenry.godough.core.billpay.d */
class C1522d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BillPayFragment f6043a;

    C1522d(BillPayFragment billPayFragment) {
        this.f6043a = billPayFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0 && i < this.f6043a.f6022ar.size()) {
            Account unused = this.f6043a.f6019ao = (Account) this.f6043a.f6022ar.get(i);
            this.f6043a.m6041v();
            this.f6043a.m6044x();
        }
        dialogInterface.dismiss();
    }
}
