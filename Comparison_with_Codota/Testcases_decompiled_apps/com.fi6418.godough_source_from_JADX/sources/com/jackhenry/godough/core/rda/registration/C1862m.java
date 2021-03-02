package com.jackhenry.godough.core.rda.registration;

import android.view.View;
import com.jackhenry.godough.core.GodoughTransactionActivity;

/* renamed from: com.jackhenry.godough.core.rda.registration.m */
class C1862m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RDARegistrationConfirmInformationFragment f6753a;

    C1862m(RDARegistrationConfirmInformationFragment rDARegistrationConfirmInformationFragment) {
        this.f6753a = rDARegistrationConfirmInformationFragment;
    }

    public void onClick(View view) {
        ((GodoughTransactionActivity) this.f6753a.getActivity()).cancelButtonOnClickHandler();
    }
}
