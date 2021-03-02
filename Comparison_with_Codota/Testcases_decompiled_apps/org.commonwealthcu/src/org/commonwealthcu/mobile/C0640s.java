package org.commonwealthcu.mobile;

import android.content.DialogInterface;
import android.content.Intent;

/* renamed from: org.commonwealthcu.mobile.s */
final class C0640s implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private /* synthetic */ BankingView f857a;

    C0640s(BankingView bankingView) {
        this.f857a = bankingView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean unused = this.f857a.f655i = true;
        this.f857a.mo5455c();
        Intent intent = new Intent();
        intent.putExtra("EXIT_MESSAGE", "You have successfully logged off.");
        this.f857a.setResult(-1, intent);
        this.f857a.finish();
    }
}
