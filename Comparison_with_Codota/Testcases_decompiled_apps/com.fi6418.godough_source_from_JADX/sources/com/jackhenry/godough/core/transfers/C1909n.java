package com.jackhenry.godough.core.transfers;

import android.content.DialogInterface;
import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.core.model.TransferToAccount;

/* renamed from: com.jackhenry.godough.core.transfers.n */
class C1909n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TransfersFragment f6833a;

    C1909n(TransfersFragment transfersFragment) {
        this.f6833a = transfersFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0 && i < this.f6833a.f6804as.size()) {
            Account unused = this.f6833a.f6800ao = (Account) this.f6833a.f6804as.get(i);
            this.f6833a.f6812d.setText(this.f6833a.f6800ao.getName());
            TransferToAccount unused2 = this.f6833a.f6801ap = null;
            this.f6833a.m6913x();
            this.f6833a.m6878a(this.f6833a.f6800ao);
            this.f6833a.m6911v();
        }
        dialogInterface.dismiss();
    }
}
