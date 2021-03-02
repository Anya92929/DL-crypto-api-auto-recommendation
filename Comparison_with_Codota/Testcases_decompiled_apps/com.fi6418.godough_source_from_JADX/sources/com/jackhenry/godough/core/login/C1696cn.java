package com.jackhenry.godough.core.login;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1943y;
import com.jackhenry.godough.core.model.PasswordChangeResponse;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1578g;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.login.cn */
class C1696cn extends C1943y<PasswordChangeResponse> {

    /* renamed from: a */
    final /* synthetic */ PasswordChangeFragment f6438a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1696cn(PasswordChangeFragment passwordChangeFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6438a = passwordChangeFragment;
    }

    /* renamed from: a */
    public void mo9588a(PasswordChangeResponse passwordChangeResponse) {
        AbstractActivity abstractActivity = (AbstractActivity) this.f6438a.getActivity();
        this.f6438a.mo10989m();
        if (abstractActivity == null) {
            return;
        }
        if (passwordChangeResponse != null) {
            String string = this.f6438a.getString(C1506am.dg_error_title);
            if (passwordChangeResponse.isSuccess()) {
                string = this.f6438a.getString(C1506am.dg_success_title);
            }
            if (passwordChangeResponse.getMessage() == null) {
                passwordChangeResponse.setMessage(this.f6438a.getString(C1506am.dg_unknown_error));
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1574c(-1, this.f6438a.getString(C1506am.btn_ok)));
            C1576e eVar = new C1576e(C1577f.ERROR, (int) PasswordChangeFragment.DIALOG_CREDENTIAL_RESULTS, string, passwordChangeResponse.getMessage(), (List<C1574c>) arrayList);
            eVar.mo9791a((C1578g) new C1697co(this));
            abstractActivity.showDialog(eVar);
            return;
        }
        this.f6438a.reloadSettings();
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        AbstractActivity abstractActivity = (AbstractActivity) this.f6438a.getActivity();
        this.f6438a.mo10989m();
        if (abstractActivity == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            mo11216b(dVar);
        }
        C1718di unused = this.f6438a.f6349h = null;
        return true;
    }
}
