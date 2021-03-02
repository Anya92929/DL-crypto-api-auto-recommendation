package com.jackhenry.godough.core.p2p;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.P2PPayee;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.p2p.j */
class C1781j extends C1942x<P2PPayee> {

    /* renamed from: a */
    final /* synthetic */ P2PAddPersonFragment f6582a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1781j(P2PAddPersonFragment p2PAddPersonFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6582a = p2PAddPersonFragment;
    }

    /* renamed from: a */
    public void mo9588a(P2PPayee p2PPayee) {
        this.f6582a.mo10989m();
        GodoughTransactionActivity godoughTransactionActivity = (GodoughTransactionActivity) this.f6582a.getActivity();
        if (godoughTransactionActivity != null) {
            if (p2PPayee.getAddPayeeStatus().getWasSuccessful()) {
                P2PPayee unused = this.f6582a.f6517al = p2PPayee;
                ArrayList arrayList = new ArrayList();
                arrayList.add(new C1574c(-1, this.f6582a.getString(C1506am.btn_ok)));
                String nickname = this.f6582a.f6517al.getNickname();
                if (nickname == null || nickname.trim().length() == 0) {
                    nickname = this.f6582a.f6517al.getName();
                }
                godoughTransactionActivity.showConfirmationScreen(C1494ai.layout, new C1576e(C1577f.SUCCESS, 5035, this.f6582a.getString(C1506am.payee_confirmation), (C1579h) new C1782k(this, this.f6582a.getString(C1506am.payee_confirmation_messsage, nickname)), (List<C1574c>) arrayList));
            } else {
                godoughTransactionActivity.showDialog(this.f6582a.getString(C1506am.dg_error_title), p2PPayee.getAddPayeeStatus().getMessage());
            }
            C1771ak unused2 = this.f6582a.f6516ak = null;
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6582a.mo10989m();
        GodoughTransactionActivity godoughTransactionActivity = (GodoughTransactionActivity) this.f6582a.getActivity();
        if (godoughTransactionActivity == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            godoughTransactionActivity.showDialog(new C1576e(C1577f.ERROR, AbstractActivity.DIALOG_P2P_PAY_FAILED, this.f6582a.getString(C1506am.dg_error_title), dVar.getMessage()));
        }
        C1771ak unused = this.f6582a.f6516ak = null;
        return true;
    }
}
