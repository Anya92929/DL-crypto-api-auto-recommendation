package org.commonwealthcu.mobile;

import java.util.TimerTask;

/* renamed from: org.commonwealthcu.mobile.k */
final class C0632k extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ BankingView f850a;

    C0632k(BankingView bankingView) {
        this.f850a = bankingView;
    }

    public final void run() {
        this.f850a.runOnUiThread(new C0633l(this));
    }
}
