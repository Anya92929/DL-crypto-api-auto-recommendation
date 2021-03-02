package org.commonwealthcu.mobile;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;

/* renamed from: org.commonwealthcu.mobile.au */
final class C0604au implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private /* synthetic */ C0599ap f772a;

    C0604au(C0599ap apVar) {
        this.f772a = apVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f772a.f747e = ProgressDialog.show(this.f772a.f751i, "", "Processing. Please wait...", true);
        this.f772a.submitDeposit((View) null);
    }
}
