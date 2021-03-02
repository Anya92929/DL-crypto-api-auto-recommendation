package com.jackhenry.godough.core.rda;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.DepositAccount;
import com.jackhenry.godough.p027b.C1389d;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.rda.m */
class C1836m extends C1895t<List<DepositAccount>> {

    /* renamed from: c */
    final /* synthetic */ DepositCheckFragment f6694c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1836m(DepositCheckFragment depositCheckFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6694c = depositCheckFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<List<DepositAccount>> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<List<DepositAccount>> loader, List<DepositAccount> list) {
        List unused = this.f6694c.f6623aq = list;
        if (list == null || list.isEmpty()) {
            ((GodoughTransactionActivity) this.f6694c.getActivity()).onNoData((Object) null);
        }
    }

    /* renamed from: b */
    public void mo9581b(Loader<List<DepositAccount>> loader, C1389d dVar) {
    }

    public Loader<List<DepositAccount>> onCreateLoader(int i, Bundle bundle) {
        return new C1812c(this.f6694c.getActivity());
    }
}
