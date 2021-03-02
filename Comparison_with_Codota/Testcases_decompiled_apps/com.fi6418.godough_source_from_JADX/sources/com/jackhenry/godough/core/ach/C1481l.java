package com.jackhenry.godough.core.ach;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.core.model.ACHStatus;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.ach.l */
class C1481l extends C1942x<ACHStatus> {

    /* renamed from: a */
    final /* synthetic */ ACHDetailFragment f5964a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1481l(ACHDetailFragment aCHDetailFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f5964a = aCHDetailFragment;
    }

    /* renamed from: a */
    public void mo9588a(ACHStatus aCHStatus) {
        this.f5964a.mo10989m();
        ACHDetailFragmentActivity aCHDetailFragmentActivity = (ACHDetailFragmentActivity) this.f5964a.getActivity();
        if (aCHDetailFragmentActivity != null) {
            if (aCHStatus.isWasBatchInitiated()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new C1574c(-1, this.f5964a.getString(C1506am.btn_ok)));
                this.f5964a.getActivity().setResult(-1, this.f5964a.getActivity().getIntent());
                aCHDetailFragmentActivity.showConfirmationScreen(C1494ai.layout, new C1576e(C1577f.SUCCESS, (int) ACHDetailFragmentActivity.DIALOG_ACH_SUCCESS, this.f5964a.getString(C1506am.title_payment_confirmation), (C1579h) new C1482m(this, aCHStatus.getMessage() + "\r\n" + this.f5964a.getString(C1506am.lbl_confirmation_number) + " " + aCHStatus.getConfirmationNumber()), (List<C1574c>) arrayList));
            } else {
                aCHDetailFragmentActivity.showDialog(this.f5964a.getString(C1506am.title_ach_failed), aCHStatus.getMessage());
            }
            C1488s unused = this.f5964a.f5936aj = null;
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f5964a.mo10989m();
        ACHDetailFragmentActivity aCHDetailFragmentActivity = (ACHDetailFragmentActivity) this.f5964a.getActivity();
        if (aCHDetailFragmentActivity == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            aCHDetailFragmentActivity.showDialog(this.f5964a.getString(C1506am.dg_error_title), dVar.getMessage());
        }
        C1488s unused = this.f5964a.f5936aj = null;
        return true;
    }
}
