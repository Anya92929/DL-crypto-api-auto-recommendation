package org.commonwealthcu.mobile;

import android.content.DialogInterface;
import android.support.p000v4.app.FragmentTransaction;

/* renamed from: org.commonwealthcu.mobile.e */
final class C0626e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private /* synthetic */ C0625d f844a;

    C0626e(C0625d dVar) {
        this.f844a = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FragmentTransaction beginTransaction = this.f844a.f841b.f839a.f690d.getSupportFragmentManager().beginTransaction();
        C0620bj bjVar = new C0620bj();
        beginTransaction.add(16908290, bjVar, "Ad_Browser");
        bjVar.mo5547a(this.f844a.f840a);
        beginTransaction.commit();
    }
}
