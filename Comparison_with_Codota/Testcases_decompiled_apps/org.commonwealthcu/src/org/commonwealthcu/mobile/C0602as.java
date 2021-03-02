package org.commonwealthcu.mobile;

import android.app.ProgressDialog;
import android.content.DialogInterface;

/* renamed from: org.commonwealthcu.mobile.as */
final class C0602as implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private /* synthetic */ C0599ap f770a;

    C0602as(C0599ap apVar) {
        this.f770a = apVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f770a.f747e = ProgressDialog.show(this.f770a.f751i, "", "Processing. Please wait...", true);
        new C0607ax(this.f770a, (byte) 0).execute(new Integer[]{0, 0});
    }
}
