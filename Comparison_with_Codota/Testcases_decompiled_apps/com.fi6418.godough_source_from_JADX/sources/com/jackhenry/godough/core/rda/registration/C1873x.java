package com.jackhenry.godough.core.rda.registration;

import android.view.View;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;

/* renamed from: com.jackhenry.godough.core.rda.registration.x */
class C1873x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RDATermsAndConditionsFragment f6766a;

    C1873x(RDATermsAndConditionsFragment rDATermsAndConditionsFragment) {
        this.f6766a = rDATermsAndConditionsFragment;
    }

    public void onClick(View view) {
        RDARegistrationFragmentActivity rDARegistrationFragmentActivity = (RDARegistrationFragmentActivity) this.f6766a.getActivity();
        if (this.f6766a.f6727f.booleanValue()) {
            rDARegistrationFragmentActivity.cancelButtonOnClickHandler(this.f6766a.getString(C1506am.cancel_rda_terms_collect, GoDoughApp.getUserSettings().getUserMenu().getRda().getText()), this.f6766a.getString(C1506am.btn_no), this.f6766a.getString(C1506am.btn_yes));
            return;
        }
        rDARegistrationFragmentActivity.cancelButtonOnClickHandler();
    }
}
