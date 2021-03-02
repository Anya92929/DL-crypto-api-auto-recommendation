package org.commonwealthcu.mobile;

import java.util.TimerTask;

/* renamed from: org.commonwealthcu.mobile.ag */
final class C0590ag extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C0589af f718a;

    C0590ag(C0589af afVar) {
        this.f718a = afVar;
    }

    public final void run() {
        this.f718a.runOnUiThread(new C0591ah(this));
    }
}
