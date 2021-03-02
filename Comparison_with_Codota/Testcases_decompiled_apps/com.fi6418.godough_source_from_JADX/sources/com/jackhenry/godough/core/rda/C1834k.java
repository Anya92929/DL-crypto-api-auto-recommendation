package com.jackhenry.godough.core.rda;

import android.content.DialogInterface;
import com.jackhenry.godough.core.model.DepositAccount;

/* renamed from: com.jackhenry.godough.core.rda.k */
class C1834k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DepositCheckFragment f6692a;

    C1834k(DepositCheckFragment depositCheckFragment) {
        this.f6692a = depositCheckFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0 && i < this.f6692a.f6623aq.size()) {
            DepositAccount unused = this.f6692a.f6624ar = (DepositAccount) this.f6692a.f6623aq.get(i);
            this.f6692a.m6690p();
            this.f6692a.updateControls();
        }
        dialogInterface.dismiss();
    }
}
