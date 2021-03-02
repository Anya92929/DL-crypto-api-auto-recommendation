package com.jackhenry.godough.core.rda;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Deposit;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.rda.n */
class C1837n extends C1942x<Deposit> {

    /* renamed from: a */
    final /* synthetic */ DepositCheckFragment f6695a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1837n(DepositCheckFragment depositCheckFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6695a = depositCheckFragment;
    }

    /* renamed from: a */
    public void mo9588a(Deposit deposit) {
        this.f6695a.mo10989m();
        DepositCheckFragmentActivity depositCheckFragmentActivity = (DepositCheckFragmentActivity) this.f6695a.getActivity();
        if (depositCheckFragmentActivity != null) {
            new Bundle();
            GoDoughApp app = GoDoughApp.getApp();
            if (deposit.getStatus().getRDAVelocity() != null) {
                GoDoughApp.getUserSettings().getRdaVerificationStatusResponse().setVelocity(deposit.getStatus().getRDAVelocity());
            }
            if (!deposit.getStatus().isWasDepositSuccessful()) {
                depositCheckFragmentActivity.showDialog(this.f6695a.getString(C1506am.dg_error_title), deposit.getStatus().getErrorMessage());
            } else {
                C1808ad.m6711a(app).mo11013a(app.getFilesDir().getAbsolutePath(), app);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new C1574c(-1, this.f6695a.getString(C1506am.btn_deposit_another)));
                depositCheckFragmentActivity.showConfirmationScreen(C1494ai.layout, new C1576e(C1577f.SUCCESS, (int) DepositCheckFragment.DIALOG_DEPOSIT_SUCCESS, this.f6695a.getString(C1506am.title_deposit_confirmation), (C1579h) new C1838o(this, deposit), (List<C1574c>) arrayList), this.f6695a.getString(C1506am.btn_deposit_another), this.f6695a.getString(C1506am.btn_done));
            }
            C1810af unused = this.f6695a.f6625as = null;
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6695a.mo10989m();
        DepositCheckFragmentActivity depositCheckFragmentActivity = (DepositCheckFragmentActivity) this.f6695a.getActivity();
        if (depositCheckFragmentActivity == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            depositCheckFragmentActivity.showDialog(this.f6695a.getString(C1506am.dg_error_title), dVar.getMessage());
        }
        C1810af unused = this.f6695a.f6625as = null;
        return true;
    }
}
