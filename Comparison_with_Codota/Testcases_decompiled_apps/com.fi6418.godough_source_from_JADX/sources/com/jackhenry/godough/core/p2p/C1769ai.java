package com.jackhenry.godough.core.p2p;

import android.support.p000v4.app.Fragment;
import com.jackhenry.android.p022a.C1348a;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.P2PPaymentDate;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.p2p.ai */
class C1769ai extends C1942x<List<P2PPaymentDate>> {

    /* renamed from: a */
    final /* synthetic */ P2PFragment f6572a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1769ai(P2PFragment p2PFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6572a = p2PFragment;
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public void mo9588a(List<P2PPaymentDate> list) {
        boolean z;
        this.f6572a.mo10989m();
        List unused = this.f6572a.f6542au = list;
        if (this.f6572a.f6542au == null || this.f6572a.f6542au.isEmpty()) {
            ((GodoughTransactionActivity) this.f6572a.getActivity()).onNoData(C1766af.DATE);
        } else {
            if (this.f6572a.f6536ao != null) {
                Iterator it = this.f6572a.f6542au.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (C1348a.m5555a(((P2PPaymentDate) it.next()).getProcessedDate(), this.f6572a.f6536ao.getProcessedDate())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = false;
            if (!z && this.f6572a.f6536ao != null) {
                P2PPaymentDate unused2 = this.f6572a.f6536ao = null;
            } else if (this.f6572a.f6536ao == null) {
                P2PPaymentDate unused3 = this.f6572a.f6536ao = (P2PPaymentDate) this.f6572a.f6542au.get(0);
            }
            this.f6572a.m6592t();
            List unused4 = this.f6572a.f6543av = new ArrayList(this.f6572a.f6542au.size());
            for (P2PPaymentDate processedDate : this.f6572a.f6542au) {
                this.f6572a.f6543av.add(processedDate.getProcessedDate());
            }
        }
        C1760a unused5 = this.f6572a.f6546ay = null;
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        P2PFragmentActivity p2PFragmentActivity = (P2PFragmentActivity) this.f6572a.getActivity();
        if (p2PFragmentActivity == null) {
            return true;
        }
        this.f6572a.mo10989m();
        if (!super.mo9589a(dVar)) {
            p2PFragmentActivity.showDialog(new C1576e(C1577f.ERROR, this.f6572a.getString(C1506am.dg_error_title), dVar.getMessage()));
        }
        C1760a unused = this.f6572a.f6546ay = null;
        return true;
    }
}
