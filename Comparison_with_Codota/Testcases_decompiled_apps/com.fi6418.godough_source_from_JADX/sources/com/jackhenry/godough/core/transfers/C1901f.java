package com.jackhenry.godough.core.transfers;

import android.content.DialogInterface;
import com.jackhenry.godough.core.model.TransferOption;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.transfers.f */
class C1901f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ List f6823a;

    /* renamed from: b */
    final /* synthetic */ TransfersFragment f6824b;

    C1901f(TransfersFragment transfersFragment, List list) {
        this.f6824b = transfersFragment;
        this.f6823a = list;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0 && i < this.f6823a.size()) {
            TransferOption unused = this.f6824b.f6802aq = (TransferOption) this.f6823a.get(i);
            this.f6824b.m6914y();
            this.f6824b.m6911v();
        }
        dialogInterface.dismiss();
    }
}
