package com.jackhenry.godough.core.transfers;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.p027b.C1389d;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.transfers.l */
class C1907l extends C1895t<List<Account>> {

    /* renamed from: c */
    final /* synthetic */ TransfersFragment f6830c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1907l(TransfersFragment transfersFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6830c = transfersFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<List<Account>> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<List<Account>> loader, List<Account> list) {
        List unused = this.f6830c.f6804as = list;
        if (list == null || list.isEmpty()) {
            this.f6830c.mo10989m();
            ((GodoughTransactionActivity) this.f6830c.getActivity()).onNoData(TransfersFragment.ACCOUNT_NO_FROM_DATA);
            return;
        }
        this.f6830c.m6901p();
    }

    /* renamed from: b */
    public void mo9581b(Loader<List<Account>> loader, C1389d dVar) {
        this.f6830c.mo10989m();
    }

    public Loader<List<Account>> onCreateLoader(int i, Bundle bundle) {
        return new C1899d(this.f6830c.getActivity());
    }

    public void onLoaderReset(Loader<List<Account>> loader) {
    }
}
