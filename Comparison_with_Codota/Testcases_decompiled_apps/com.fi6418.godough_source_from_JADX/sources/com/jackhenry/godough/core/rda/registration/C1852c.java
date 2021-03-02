package com.jackhenry.godough.core.rda.registration;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.RDAMessage;
import com.jackhenry.godough.core.model.RDAUserStatusCodes;
import com.jackhenry.godough.core.model.RDAVerificationStatusResponse;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.rda.registration.c */
class C1852c extends C1854e<RDAVerificationStatusResponse> {

    /* renamed from: a */
    final /* synthetic */ AbstractRDAVerifyRegistrationActivity f6738a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1852c(AbstractRDAVerifyRegistrationActivity abstractRDAVerifyRegistrationActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6738a = abstractRDAVerifyRegistrationActivity;
    }

    /* renamed from: a */
    public void mo9588a(RDAVerificationStatusResponse rDAVerificationStatusResponse) {
        this.f6738a.dismissLoadingDialog();
        if (rDAVerificationStatusResponse == null) {
            super.mo9588a(rDAVerificationStatusResponse);
        }
        if (this.f6919c.getActivity() != null) {
            C1871v unused = this.f6738a.f6704m = null;
            if (rDAVerificationStatusResponse.getStatus().equals(RDAUserStatusCodes.USER_ENROLLED_ENABLED)) {
                GoDoughApp.getUserSettings().setRdaVerificationStatusResponse(rDAVerificationStatusResponse);
                this.f6738a.initLoadingTasks();
                return;
            }
            mo11076a(new RDAMessage(1, rDAVerificationStatusResponse.getMessage()));
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6738a.dismissLoadingDialog();
        C1871v unused = this.f6738a.f6704m = null;
        if (super.mo9589a(dVar)) {
            return true;
        }
        this.f6738a.showDialog(this.f6738a.getString(C1506am.dg_error_title), dVar.getMessage());
        return true;
    }
}
