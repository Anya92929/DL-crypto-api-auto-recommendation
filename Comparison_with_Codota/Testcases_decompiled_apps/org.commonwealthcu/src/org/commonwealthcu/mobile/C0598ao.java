package org.commonwealthcu.mobile;

import android.content.DialogInterface;
import android.support.p000v4.app.FragmentTransaction;

/* renamed from: org.commonwealthcu.mobile.ao */
final class C0598ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private /* synthetic */ String f739a;

    /* renamed from: b */
    private /* synthetic */ C0596am f740b;

    C0598ao(C0596am amVar, String str) {
        this.f740b = amVar;
        this.f739a = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FragmentTransaction beginTransaction = this.f740b.getActivity().getSupportFragmentManager().beginTransaction();
        C0620bj bjVar = new C0620bj();
        beginTransaction.add(16908290, bjVar, "Ad_Browser");
        bjVar.mo5547a(this.f739a);
        beginTransaction.commit();
    }
}
