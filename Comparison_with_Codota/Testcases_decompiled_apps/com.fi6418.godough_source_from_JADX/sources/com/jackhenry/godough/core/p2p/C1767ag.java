package com.jackhenry.godough.core.p2p;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.core.model.P2PPayment;
import com.jackhenry.godough.core.model.Redirect;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p027b.C1392g;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.p2p.ag */
class C1767ag extends C1942x<P2PPayment> {

    /* renamed from: a */
    final /* synthetic */ P2PFragment f6569a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1767ag(P2PFragment p2PFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6569a = p2PFragment;
    }

    /* renamed from: a */
    public void mo9588a(P2PPayment p2PPayment) {
        this.f6569a.mo10989m();
        new Bundle();
        P2PFragmentActivity p2PFragmentActivity = (P2PFragmentActivity) this.f6569a.getActivity();
        if (p2PFragmentActivity != null) {
            if (p2PPayment.getP2PPaymentStatus().isWasPersonPaid()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new C1574c(-1, this.f6569a.getString(C1506am.btn_ok)));
                p2PFragmentActivity.showConfirmationScreen(C1494ai.layout, new C1576e(C1577f.SUCCESS, (int) AbstractActivity.DIALOG_P2P_PAY_SUCCESS, this.f6569a.getString(C1506am.title_payment_confirmation), (C1579h) new C1768ah(this, p2PPayment), (List<C1574c>) arrayList));
            } else {
                p2PFragmentActivity.showDialog(new C1576e(C1577f.ERROR, this.f6569a.getString(C1506am.dg_error_title), p2PPayment.getP2PPaymentStatus().getMessage()));
            }
            C1772al unused = this.f6569a.f6530aA = null;
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        P2PFragmentActivity p2PFragmentActivity = (P2PFragmentActivity) this.f6569a.getActivity();
        if (p2PFragmentActivity == null) {
            return true;
        }
        if (!(dVar instanceof C1392g)) {
            this.f6569a.mo10989m();
            if (!super.mo9589a(dVar)) {
                p2PFragmentActivity.showDialog(new C1576e(C1577f.ERROR, this.f6569a.getString(C1506am.dg_error_title), dVar.getMessage()));
            }
        } else if (Redirect.RedirectType.getEnum(dVar.getMessage().toUpperCase()) == Redirect.RedirectType.MFA) {
            p2PFragmentActivity.setResetFields(false);
            this.f6569a.m6601y();
        }
        C1772al unused = this.f6569a.f6530aA = null;
        return true;
    }
}
