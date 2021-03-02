package com.jackhenry.godough.core.billpay;

import android.support.p000v4.app.Fragment;
import com.jackhenry.android.p022a.C1348a;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.BillPayPaymentDate;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.billpay.t */
class C1538t extends C1942x<List<BillPayPaymentDate>> {

    /* renamed from: a */
    final /* synthetic */ BillPayFragment f6066a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1538t(BillPayFragment billPayFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6066a = billPayFragment;
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public void mo9588a(List<BillPayPaymentDate> list) {
        boolean z;
        this.f6066a.mo10989m();
        List unused = this.f6066a.f6023as = list;
        if (this.f6066a.f6023as == null || this.f6066a.f6023as.isEmpty()) {
            ((GodoughTransactionActivity) this.f6066a.getActivity()).onNoData(C1539u.DATE);
        } else {
            if (this.f6066a.f6020ap != null) {
                Iterator it = this.f6066a.f6023as.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (C1348a.m5555a(((BillPayPaymentDate) it.next()).getProcessedDate(), this.f6066a.f6020ap.getProcessedDate())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = false;
            if (!z && this.f6066a.f6020ap != null) {
                BillPayPaymentDate unused2 = this.f6066a.f6020ap = null;
            } else if (this.f6066a.f6020ap == null) {
                BillPayPaymentDate unused3 = this.f6066a.f6020ap = (BillPayPaymentDate) this.f6066a.f6023as.get(0);
            }
            this.f6066a.m6039u();
            List unused4 = this.f6066a.f6024at = new ArrayList(this.f6066a.f6023as.size());
            for (BillPayPaymentDate processedDate : this.f6066a.f6023as) {
                this.f6066a.f6024at.add(processedDate.getProcessedDate());
            }
        }
        C1541w unused5 = this.f6066a.f6029ay = null;
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        BillPayFragmentActivity billPayFragmentActivity = (BillPayFragmentActivity) this.f6066a.getActivity();
        if (billPayFragmentActivity == null) {
            return true;
        }
        this.f6066a.mo10989m();
        if (!super.mo9589a(dVar)) {
            billPayFragmentActivity.showDialog(new C1576e(C1577f.ERROR, this.f6066a.getString(C1506am.dg_error_title), dVar.getMessage()));
        }
        C1541w unused = this.f6066a.f6029ay = null;
        return true;
    }
}
