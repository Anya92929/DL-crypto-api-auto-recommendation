package org.commonwealthcu.mobile;

import android.content.DialogInterface;

/* renamed from: org.commonwealthcu.mobile.g */
final class C0628g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private /* synthetic */ BankingView f846a;

    C0628g(BankingView bankingView) {
        this.f846a = bankingView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f846a.f647a.reload();
    }
}
