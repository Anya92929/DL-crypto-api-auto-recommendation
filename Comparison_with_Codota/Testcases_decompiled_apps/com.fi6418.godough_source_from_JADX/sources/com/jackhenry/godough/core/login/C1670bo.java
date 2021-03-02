package com.jackhenry.godough.core.login;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.core.model.MFAResponse;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1578g;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.login.bo */
class C1670bo extends C1942x<MFAResponse> {

    /* renamed from: a */
    Fragment f6408a;

    /* renamed from: b */
    final /* synthetic */ MFAActivity f6409b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1670bo(MFAActivity mFAActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6409b = mFAActivity;
        this.f6408a = fragment;
    }

    /* renamed from: a */
    public void mo9588a(MFAResponse mFAResponse) {
        this.f6409b.dismissLoadingDialog();
        if (mFAResponse.isSuccess()) {
            if (this.f6409b.f6296n == 2) {
                this.f6409b.setResult(-1);
                this.f6409b.finish();
            } else if (new C1630ab(this.f6408a).mo9946a(mFAResponse.getRedirect()) == 1) {
                ((AbstractActivity) this.f6408a.getActivity()).showGeneralErrorRedirectDialog(AbstractActivity.DIALOG_WARNING, this.f6409b.getString(C1506am.dg_no_account_msg));
            }
        } else if (mFAResponse.isBlocked()) {
            C1576e eVar = new C1576e(C1577f.ERROR, MFAActivity.DIALOG_MFA_BLOCKED, this.f6409b.getString(C1506am.dg_mfa_blocked_title), mFAResponse.getMessage());
            eVar.mo9791a((C1578g) new C1671bp(this));
            this.f6409b.showDialog(eVar);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1574c(-2, this.f6409b.getString(C1506am.btn_exit)));
            arrayList.add(new C1574c(-1, this.f6409b.getString(C1506am.btn_retry)));
            C1576e eVar2 = new C1576e(C1577f.ERROR, (int) MFAActivity.DIALOG_MFA_RETRY, this.f6409b.getString(C1506am.dg_mfa_failed_title), mFAResponse.getMessage(), (List<C1574c>) arrayList);
            eVar2.mo9791a((C1578g) new C1672bq(this));
            this.f6409b.showDialog(eVar2);
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6409b.dismissLoadingDialog();
        if (super.mo9589a(dVar)) {
            return true;
        }
        mo11216b(dVar);
        return true;
    }
}
