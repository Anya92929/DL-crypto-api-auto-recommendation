package com.jackhenry.godough.core.billpay;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.core.model.BillPayment;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.billpay.r */
class C1536r extends C1942x<BillPayment> {

    /* renamed from: a */
    final /* synthetic */ BillPayFragment f6063a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1536r(BillPayFragment billPayFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6063a = billPayFragment;
    }

    /* renamed from: a */
    public void mo9588a(BillPayment billPayment) {
        this.f6063a.mo10989m();
        BillPayFragmentActivity billPayFragmentActivity = (BillPayFragmentActivity) this.f6063a.getActivity();
        if (billPayFragmentActivity != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1574c(-1, this.f6063a.getString(C1506am.btn_ok)));
            if (billPayment.getStatus().isWasBillPaid()) {
                billPayFragmentActivity.showConfirmationScreen(C1494ai.layout, new C1576e(C1577f.SUCCESS, (int) BillPayFragment.DIALOG_BILL_PAY_SUCCESS, this.f6063a.getString(C1506am.title_payment_confirmation), (C1579h) new C1537s(this, billPayment), (List<C1574c>) arrayList));
            } else {
                billPayFragmentActivity.showDialog(this.f6063a.getString(C1506am.dg_error_title), billPayment.getStatus().getMessage());
            }
            C1543y unused = this.f6063a.f6028ax = null;
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6063a.mo10989m();
        BillPayFragmentActivity billPayFragmentActivity = (BillPayFragmentActivity) this.f6063a.getActivity();
        if (billPayFragmentActivity == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            billPayFragmentActivity.showDialog(this.f6063a.getString(C1506am.dg_error_title), dVar.getMessage());
        }
        C1543y unused = this.f6063a.f6028ax = null;
        return true;
    }
}
