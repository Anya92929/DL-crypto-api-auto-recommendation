package com.jackhenry.godough.core.billpay;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.model.Account;
import com.jackhenry.godough.p027b.C1389d;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.billpay.o */
class C1533o extends C1895t<List<Account>> {

    /* renamed from: c */
    final /* synthetic */ BillPayFragment f6058c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1533o(BillPayFragment billPayFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6058c = billPayFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<List<Account>> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<List<Account>> loader, List<Account> list) {
        List unused = this.f6058c.f6022ar = list;
        this.f6058c.f6025au.decrementAndGet();
        this.f6058c.m6029p();
    }

    /* renamed from: b */
    public void mo9581b(Loader<List<Account>> loader, C1389d dVar) {
        this.f6058c.mo10989m();
    }

    public Loader<List<Account>> onCreateLoader(int i, Bundle bundle) {
        return new C1519a(this.f6058c.getActivity());
    }

    public void onLoaderReset(Loader<List<Account>> loader) {
    }
}
