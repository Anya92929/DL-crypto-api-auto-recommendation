package com.jackhenry.godough.core.p2p;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.model.P2PPayee;
import com.jackhenry.godough.p027b.C1389d;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.p2p.n */
class C1785n extends C1895t<List<P2PPayee>> {

    /* renamed from: c */
    final /* synthetic */ P2PFragment f6588c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1785n(P2PFragment p2PFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6588c = p2PFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<List<P2PPayee>> loader, C1389d dVar) {
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<List<P2PPayee>> loader, List<P2PPayee> list) {
        List unused = this.f6588c.f6537ap = list;
        this.f6588c.f6541at.decrementAndGet();
        this.f6588c.m6585q();
    }

    /* renamed from: b */
    public void mo9581b(Loader<List<P2PPayee>> loader, C1389d dVar) {
        this.f6588c.mo10989m();
    }

    public Loader<List<P2PPayee>> onCreateLoader(int i, Bundle bundle) {
        return new C1770aj(this.f6588c.getActivity());
    }

    public void onLoaderReset(Loader<List<P2PPayee>> loader) {
    }
}
