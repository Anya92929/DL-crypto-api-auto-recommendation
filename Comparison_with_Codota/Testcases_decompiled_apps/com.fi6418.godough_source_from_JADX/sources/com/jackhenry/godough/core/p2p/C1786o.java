package com.jackhenry.godough.core.p2p;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.p027b.C1389d;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.p2p.o */
class C1786o extends C1895t<List<Account>> {

    /* renamed from: c */
    final /* synthetic */ P2PFragment f6589c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1786o(P2PFragment p2PFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6589c = p2PFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<List<Account>> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<List<Account>> loader, List<Account> list) {
        List unused = this.f6589c.f6539ar = list;
        this.f6589c.f6541at.decrementAndGet();
        this.f6589c.m6585q();
    }

    /* renamed from: b */
    public void mo9581b(Loader<List<Account>> loader, C1389d dVar) {
        this.f6589c.mo10989m();
    }

    public Loader<List<Account>> onCreateLoader(int i, Bundle bundle) {
        return new C1774c(this.f6589c.getActivity());
    }

    public void onLoaderReset(Loader<List<Account>> loader) {
    }
}
