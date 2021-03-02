package com.jackhenry.godough.core.transfers;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1943y;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.TransferToAccount;
import com.jackhenry.godough.p027b.C1389d;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.transfers.q */
class C1912q extends C1943y<List<TransferToAccount>> {

    /* renamed from: a */
    final /* synthetic */ TransfersFragment f6837a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1912q(TransfersFragment transfersFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6837a = transfersFragment;
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public void mo9588a(List<TransferToAccount> list) {
        this.f6837a.mo10989m();
        List unused = this.f6837a.f6805at = list;
        if (list == null || list.isEmpty()) {
            ((GodoughTransactionActivity) this.f6837a.getActivity()).onNoData(TransfersFragment.ACCOUNT_NO_TO_DATA);
        }
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6837a.mo10989m();
        if (super.mo9589a(dVar)) {
            return true;
        }
        mo11216b(dVar);
        return true;
    }
}
