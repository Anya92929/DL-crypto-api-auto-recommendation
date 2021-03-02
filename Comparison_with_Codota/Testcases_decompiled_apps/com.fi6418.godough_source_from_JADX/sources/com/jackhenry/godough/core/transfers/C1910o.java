package com.jackhenry.godough.core.transfers;

import android.content.DialogInterface;
import com.jackhenry.godough.core.model.TransferOption;
import com.jackhenry.godough.core.model.TransferToAccount;

/* renamed from: com.jackhenry.godough.core.transfers.o */
class C1910o implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TransfersFragment f6834a;

    C1910o(TransfersFragment transfersFragment) {
        this.f6834a = transfersFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0 && i < this.f6834a.f6805at.size()) {
            TransferToAccount unused = this.f6834a.f6801ap = (TransferToAccount) this.f6834a.f6805at.get(i);
            if (!this.f6834a.f6801ap.hasTransferOptions()) {
                TransferOption unused2 = this.f6834a.f6802aq = null;
                this.f6834a.m6882a(false);
                this.f6834a.m6914y();
            }
            this.f6834a.m6913x();
            this.f6834a.m6911v();
        }
        dialogInterface.dismiss();
    }
}
