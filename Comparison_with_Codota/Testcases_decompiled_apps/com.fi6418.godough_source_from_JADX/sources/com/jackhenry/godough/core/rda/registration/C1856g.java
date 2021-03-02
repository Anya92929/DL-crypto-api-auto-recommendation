package com.jackhenry.godough.core.rda.registration;

import android.view.View;
import com.jackhenry.godough.core.GodoughTransactionActivity;

/* renamed from: com.jackhenry.godough.core.rda.registration.g */
class C1856g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RDARegistrationAccountSelectionFragment f6741a;

    C1856g(RDARegistrationAccountSelectionFragment rDARegistrationAccountSelectionFragment) {
        this.f6741a = rDARegistrationAccountSelectionFragment;
    }

    public void onClick(View view) {
        ((GodoughTransactionActivity) this.f6741a.getActivity()).cancelButtonOnClickHandler();
    }
}
