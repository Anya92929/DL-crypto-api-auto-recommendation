package com.jackhenry.godough.core.p2p;

import android.content.DialogInterface;
import com.jackhenry.godough.core.model.P2PPayee;

/* renamed from: com.jackhenry.godough.core.p2p.aa */
class C1761aa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ P2PFragment f6558a;

    C1761aa(P2PFragment p2PFragment) {
        this.f6558a = p2PFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0 && i < this.f6558a.f6537ap.size() && this.f6558a.f6534am != this.f6558a.f6537ap.get(i)) {
            P2PPayee unused = this.f6558a.f6534am = (P2PPayee) this.f6558a.f6537ap.get(i);
            this.f6558a.m6587r();
            this.f6558a.m6595v();
            this.f6558a.m6561a(this.f6558a.f6534am);
        }
        dialogInterface.dismiss();
    }
}
