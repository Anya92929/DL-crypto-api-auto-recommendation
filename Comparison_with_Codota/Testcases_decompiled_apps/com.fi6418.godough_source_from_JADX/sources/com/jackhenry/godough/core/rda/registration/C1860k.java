package com.jackhenry.godough.core.rda.registration;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.model.RDAMessage;
import com.jackhenry.godough.core.model.RDAUserRegistrationResponse;
import com.jackhenry.godough.core.model.RDAUserStatusCodes;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.rda.registration.k */
class C1860k extends C1854e<RDAUserRegistrationResponse> {

    /* renamed from: a */
    final /* synthetic */ RDARegistrationAccountSelectionFragment f6751a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1860k(RDARegistrationAccountSelectionFragment rDARegistrationAccountSelectionFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6751a = rDARegistrationAccountSelectionFragment;
    }

    /* renamed from: a */
    public void mo9588a(RDAUserRegistrationResponse rDAUserRegistrationResponse) {
        boolean z = true;
        this.f6751a.mo10989m();
        RDARegistrationFragmentActivity rDARegistrationFragmentActivity = (RDARegistrationFragmentActivity) this.f6751a.getActivity();
        if (rDARegistrationFragmentActivity == null) {
            return;
        }
        if (rDAUserRegistrationResponse.isSuccess()) {
            if (!rDAUserRegistrationResponse.getStatus().equals(RDAUserStatusCodes.USER_ENROLLED_ENABLED)) {
                z = false;
            }
            rDARegistrationFragmentActivity.buildConfirmation(rDAUserRegistrationResponse.getVelocity(), rDAUserRegistrationResponse.getMessage(), z);
            return;
        }
        mo11076a(new RDAMessage(1, rDAUserRegistrationResponse.getMessage(), this.f6751a.getString(C1506am.rda_enrollment_error_title)));
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6751a.mo10989m();
        RDARegistrationFragmentActivity rDARegistrationFragmentActivity = (RDARegistrationFragmentActivity) this.f6751a.getActivity();
        if (rDARegistrationFragmentActivity == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            rDARegistrationFragmentActivity.showDialog(this.f6751a.getString(C1506am.dg_error_title), dVar.getMessage());
        }
        C1849ag unused = this.f6751a.f6711g = null;
        return true;
    }
}
