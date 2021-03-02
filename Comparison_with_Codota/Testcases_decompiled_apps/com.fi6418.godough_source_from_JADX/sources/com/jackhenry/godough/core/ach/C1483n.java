package com.jackhenry.godough.core.ach;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.model.ACH;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.ach.n */
class C1483n extends C1895t<ACH> {

    /* renamed from: c */
    final /* synthetic */ ACHDetailFragment f5967c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1483n(ACHDetailFragment aCHDetailFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f5967c = aCHDetailFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<ACH> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<ACH> loader, ACH ach) {
        ACH unused = this.f5967c.f5943h = ach;
        this.f5967c.m5937p();
    }

    /* renamed from: b */
    public void mo9581b(Loader<ACH> loader, C1389d dVar) {
        this.f5967c.mo10989m();
    }

    public Loader<ACH> onCreateLoader(int i, Bundle bundle) {
        return new C1484o(this.f5967c.f5943h.getId(), this.f5967c.getActivity());
    }
}
