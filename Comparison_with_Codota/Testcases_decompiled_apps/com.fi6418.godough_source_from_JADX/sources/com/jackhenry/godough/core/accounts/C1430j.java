package com.jackhenry.godough.core.accounts;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.model.AccountGroupList;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.accounts.j */
class C1430j extends C1895t<AccountGroupList> {

    /* renamed from: c */
    final /* synthetic */ AccountsFragment f5864c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1430j(AccountsFragment accountsFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f5864c = accountsFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<AccountGroupList> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<AccountGroupList> loader, AccountGroupList accountGroupList) {
        this.f5864c.f5831c.mo9663a();
        this.f5864c.f5831c.mo9665a(accountGroupList);
        this.f5864c.getView().findViewById(C1494ai.progress_bar).setVisibility(8);
    }

    /* renamed from: b */
    public void mo9581b(Loader<AccountGroupList> loader, C1389d dVar) {
        this.f5864c.getView().findViewById(C1494ai.progress_bar).setVisibility(8);
    }

    public Loader<AccountGroupList> onCreateLoader(int i, Bundle bundle) {
        return new C1432l(this.f5864c.getActivity());
    }

    public void onLoaderReset(Loader<AccountGroupList> loader) {
        this.f5864c.f5831c.mo9663a();
    }
}
