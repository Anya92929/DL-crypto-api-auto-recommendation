package com.jackhenry.godough.core.p2p;

import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

/* renamed from: com.jackhenry.godough.core.p2p.ae */
class C1765ae implements C1578g {

    /* renamed from: a */
    final /* synthetic */ P2PFragmentActivity f6562a;

    /* renamed from: b */
    final /* synthetic */ C1764ad f6563b;

    C1765ae(C1764ad adVar, P2PFragmentActivity p2PFragmentActivity) {
        this.f6563b = adVar;
        this.f6562a = p2PFragmentActivity;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        switch (cVar.mo9788a()) {
            case -2:
                this.f6562a.gotoLandingPage();
                return;
            default:
                return;
        }
    }
}
