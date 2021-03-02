package com.jackhenry.godough.core.p2p;

import android.content.DialogInterface;
import com.jackhenry.godough.core.model.Account;

/* renamed from: com.jackhenry.godough.core.p2p.q */
class C1788q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ P2PFragment f6592a;

    C1788q(P2PFragment p2PFragment) {
        this.f6592a = p2PFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0 && i < this.f6592a.f6539ar.size()) {
            Account unused = this.f6592a.f6535an = (Account) this.f6592a.f6539ar.get(i);
            this.f6592a.m6590s();
            this.f6592a.m6595v();
        }
        dialogInterface.dismiss();
    }
}
