package org.commonwealthcu.mobile;

import java.util.TimerTask;

/* renamed from: org.commonwealthcu.mobile.ab */
final class C0585ab extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C0584aa f711a;

    C0585ab(C0584aa aaVar) {
        this.f711a = aaVar;
    }

    public final void run() {
        this.f711a.runOnUiThread(new C0586ac(this));
    }
}
