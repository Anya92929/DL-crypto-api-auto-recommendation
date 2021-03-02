package com.jackhenry.godough.core.rda.registration;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.rda.registration.l */
class C1861l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RDARegistrationConfirmInformationFragment f6752a;

    C1861l(RDARegistrationConfirmInformationFragment rDARegistrationConfirmInformationFragment) {
        this.f6752a = rDARegistrationConfirmInformationFragment;
    }

    public void onClick(View view) {
        this.f6752a.f6717e.setLastName(this.f6752a.f6714b.getText().toString());
        this.f6752a.f6717e.setFirstName(this.f6752a.f6713a.getText().toString());
        this.f6752a.f6717e.setEmail(this.f6752a.f6715c.getText().toString());
        ((C1865p) this.f6752a.getActivity()).userInformationEntered(this.f6752a.f6717e);
    }
}
