package org.commonwealthcu.mobile;

import android.content.DialogInterface;

/* renamed from: org.commonwealthcu.mobile.h */
final class C0629h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private /* synthetic */ BankingView f847a;

    C0629h(BankingView bankingView) {
        this.f847a = bankingView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f847a.finish();
    }
}
