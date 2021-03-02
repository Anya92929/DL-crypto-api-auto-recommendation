package com.jackhenry.godough.core.rda.registration;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.rda.registration.w */
class C1872w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RDATermsAndConditionsFragment f6765a;

    C1872w(RDATermsAndConditionsFragment rDATermsAndConditionsFragment) {
        this.f6765a = rDATermsAndConditionsFragment;
    }

    public void onClick(View view) {
        this.f6765a.submitData();
    }
}
