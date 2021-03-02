package com.jackhenry.godough.core.rda.registration;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.RDAMessage;
import com.jackhenry.godough.core.model.RDARegistrationTermsResponse;

/* renamed from: com.jackhenry.godough.core.rda.registration.ab */
class C1844ab extends C1854e<RDARegistrationTermsResponse> {

    /* renamed from: a */
    final /* synthetic */ RDATermsAndConditionsFragment f6731a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1844ab(RDATermsAndConditionsFragment rDATermsAndConditionsFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6731a = rDATermsAndConditionsFragment;
    }

    /* renamed from: a */
    public void mo9588a(RDARegistrationTermsResponse rDARegistrationTermsResponse) {
        this.f6731a.mo10989m();
        RDARegistrationFragmentActivity rDARegistrationFragmentActivity = (RDARegistrationFragmentActivity) this.f6731a.getActivity();
        if (rDARegistrationFragmentActivity == null) {
            return;
        }
        if (!rDARegistrationTermsResponse.isSuccess()) {
            mo11076a(new RDAMessage(1, rDARegistrationTermsResponse.getMessage()));
        } else if (!rDARegistrationTermsResponse.isShowRegistrationMessage()) {
            mo11075a();
        } else {
            GoDoughApp.getUserSettings().setRdaVerificationStatusResponse(rDARegistrationTermsResponse.getRdaUserStatusResponse());
            rDARegistrationFragmentActivity.buildConfirmation(rDARegistrationTermsResponse.getRdaUserStatusResponse().getVelocity(), rDARegistrationTermsResponse.getMessage(), true);
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }
}
