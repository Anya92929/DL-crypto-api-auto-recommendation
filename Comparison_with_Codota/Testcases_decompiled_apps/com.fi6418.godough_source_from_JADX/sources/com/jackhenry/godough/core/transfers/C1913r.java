package com.jackhenry.godough.core.transfers;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.core.model.Transfer;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.transfers.r */
class C1913r extends C1942x<Transfer> {

    /* renamed from: a */
    final /* synthetic */ TransfersFragment f6838a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1913r(TransfersFragment transfersFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6838a = transfersFragment;
    }

    /* renamed from: a */
    public void mo9588a(Transfer transfer) {
        TransfersFragmentActivity transfersFragmentActivity = (TransfersFragmentActivity) this.f6838a.getActivity();
        this.f6838a.mo10989m();
        if (transfersFragmentActivity != null) {
            if (!transfer.getStatus().isSuccessful()) {
                String message = transfer.getStatus().getMessage();
                if (transfer.getStatus().getMessage() == null || transfer.getStatus().getMessage().equals("null") || transfer.getStatus().getMessage().trim().length() == 0) {
                    message = this.f6838a.getResources().getString(C1506am.transfer_failed_no_message_supplied);
                }
                transfersFragmentActivity.showDialog(new C1576e(C1577f.ERROR, this.f6838a.getString(C1506am.dg_error_title), message));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new C1574c(-1, this.f6838a.getString(C1506am.btn_ok)));
                transfersFragmentActivity.showConfirmationScreen(C1494ai.layout, new C1576e(C1577f.SUCCESS, (int) TransfersFragment.DIALOG_TRANSFER_SUCCESS, this.f6838a.getString(C1506am.title_transfer_confirmation), (C1579h) new C1914s(this, transfer), (List<C1574c>) arrayList));
            }
            C1898c unused = this.f6838a.f6809ax = null;
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        TransfersFragmentActivity transfersFragmentActivity = (TransfersFragmentActivity) this.f6838a.getActivity();
        this.f6838a.mo10989m();
        if (transfersFragmentActivity == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            transfersFragmentActivity.showDialog(new C1576e(C1577f.ERROR, this.f6838a.getString(C1506am.dg_error_title), dVar.getMessage()));
        }
        C1898c unused = this.f6838a.f6809ax = null;
        return true;
    }
}
