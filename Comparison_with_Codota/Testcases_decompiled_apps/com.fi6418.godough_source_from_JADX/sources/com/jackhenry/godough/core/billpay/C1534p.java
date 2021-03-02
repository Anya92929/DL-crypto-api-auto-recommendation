package com.jackhenry.godough.core.billpay;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.Loader;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.model.BillPayPayee;
import com.jackhenry.godough.p027b.C1389d;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.billpay.p */
class C1534p extends C1895t<List<BillPayPayee>> {

    /* renamed from: c */
    final /* synthetic */ BillPayFragment f6059c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1534p(BillPayFragment billPayFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6059c = billPayFragment;
    }

    /* renamed from: a */
    public void mo9578a(Loader<List<BillPayPayee>> loader, C1389d dVar) {
        mo11133a(dVar);
        mo9581b(loader, dVar);
    }

    /* renamed from: a */
    public void mo9580a(Loader<List<BillPayPayee>> loader, List<BillPayPayee> list) {
        List unused = this.f6059c.f6021aq = list;
        this.f6059c.f6025au.decrementAndGet();
        this.f6059c.m6029p();
    }

    /* renamed from: b */
    public void mo9581b(Loader<List<BillPayPayee>> loader, C1389d dVar) {
        this.f6059c.mo10989m();
    }

    public Loader<List<BillPayPayee>> onCreateLoader(int i, Bundle bundle) {
        return new C1540v(this.f6059c.getActivity());
    }

    public void onLoaderReset(Loader<List<BillPayPayee>> loader) {
    }
}
