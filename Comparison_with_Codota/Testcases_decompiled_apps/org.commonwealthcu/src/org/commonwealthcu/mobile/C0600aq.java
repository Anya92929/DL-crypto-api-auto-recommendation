package org.commonwealthcu.mobile;

import android.content.DialogInterface;

/* renamed from: org.commonwealthcu.mobile.aq */
final class C0600aq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private /* synthetic */ C0599ap f769a;

    C0600aq(C0599ap apVar) {
        this.f769a = apVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f769a.m1295a();
        this.f769a.f752j.getSupportActionBar().selectTab(this.f769a.f752j.getSupportActionBar().getTabAt(1));
        this.f769a.f752j.getSupportActionBar().selectTab(this.f769a.f752j.getSupportActionBar().getTabAt(0));
    }
}
