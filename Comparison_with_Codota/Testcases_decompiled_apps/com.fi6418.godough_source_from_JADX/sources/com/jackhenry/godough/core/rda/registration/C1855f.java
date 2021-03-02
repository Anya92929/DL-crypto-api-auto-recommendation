package com.jackhenry.godough.core.rda.registration;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.rda.registration.f */
class C1855f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RDARegistrationAccountSelectionFragment f6740a;

    C1855f(RDARegistrationAccountSelectionFragment rDARegistrationAccountSelectionFragment) {
        this.f6740a = rDARegistrationAccountSelectionFragment;
    }

    public void onClick(View view) {
        this.f6740a.submitData(this.f6740a.f6712h);
    }
}
