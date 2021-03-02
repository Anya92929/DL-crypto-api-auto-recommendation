package com.jackhenry.godough.core.p2p;

import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.model.P2PPayee;

/* renamed from: com.jackhenry.godough.core.p2p.r */
class C1789r implements C1593j {

    /* renamed from: a */
    final /* synthetic */ P2PPayee f6593a;

    /* renamed from: b */
    final /* synthetic */ P2PFragment f6594b;

    C1789r(P2PFragment p2PFragment, P2PPayee p2PPayee) {
        this.f6594b = p2PFragment;
        this.f6593a = p2PPayee;
    }

    public void run() {
        this.f6594b.m6561a(this.f6593a);
    }
}
