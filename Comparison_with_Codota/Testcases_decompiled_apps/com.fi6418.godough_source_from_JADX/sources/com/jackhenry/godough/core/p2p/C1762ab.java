package com.jackhenry.godough.core.p2p;

import android.os.Handler;
import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.p2p.ab */
class C1762ab implements C1593j {

    /* renamed from: a */
    final /* synthetic */ P2PFragment f6559a;

    C1762ab(P2PFragment p2PFragment) {
        this.f6559a = p2PFragment;
    }

    public void run() {
        new Handler().post(new C1763ac(this));
    }
}
