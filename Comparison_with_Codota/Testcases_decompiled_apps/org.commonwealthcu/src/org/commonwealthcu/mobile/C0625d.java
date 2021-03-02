package org.commonwealthcu.mobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

/* renamed from: org.commonwealthcu.mobile.d */
final class C0625d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f840a;

    /* renamed from: b */
    final /* synthetic */ C0624c f841b;

    /* renamed from: c */
    private /* synthetic */ String f842c;

    /* renamed from: d */
    private /* synthetic */ String f843d;

    C0625d(C0624c cVar, String str, String str2, String str3) {
        this.f841b = cVar;
        this.f842c = str;
        this.f843d = str2;
        this.f840a = str3;
    }

    public final void onClick(View view) {
        this.f841b.f839a.f692f.cancel();
        String str = "Visit Offer Link";
        String str2 = "Would you like to view this offer?";
        if (this.f842c != null) {
            str = this.f842c;
        }
        if (this.f843d != null) {
            str2 = this.f843d;
        }
        new AlertDialog.Builder(this.f841b.f839a.f690d).setTitle(str).setMessage(str2).setPositiveButton(17039370, new C0626e(this)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
    }
}
