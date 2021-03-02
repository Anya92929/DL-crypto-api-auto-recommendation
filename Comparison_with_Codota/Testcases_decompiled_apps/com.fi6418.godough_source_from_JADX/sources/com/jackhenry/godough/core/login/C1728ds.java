package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.ds */
class C1728ds implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TermsFragment f6471a;

    C1728ds(TermsFragment termsFragment) {
        this.f6471a = termsFragment;
    }

    public void onClick(View view) {
        ((C1690ch) this.f6471a.getActivity()).cancelTerms(true);
    }
}
