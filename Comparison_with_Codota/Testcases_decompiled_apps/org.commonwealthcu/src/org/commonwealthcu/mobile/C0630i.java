package org.commonwealthcu.mobile;

import java.util.TimerTask;

/* renamed from: org.commonwealthcu.mobile.i */
final class C0630i extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ BankingView f848a;

    C0630i(BankingView bankingView) {
        this.f848a = bankingView;
    }

    public final void run() {
        this.f848a.runOnUiThread(new C0631j(this));
    }
}
