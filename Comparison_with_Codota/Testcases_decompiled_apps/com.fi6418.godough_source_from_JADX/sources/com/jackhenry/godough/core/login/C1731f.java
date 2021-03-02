package com.jackhenry.godough.core.login;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* renamed from: com.jackhenry.godough.core.login.f */
class C1731f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EmailAddressFragment f6473a;

    C1731f(EmailAddressFragment emailAddressFragment) {
        this.f6473a = emailAddressFragment;
    }

    public void onClick(View view) {
        ((InputMethodManager) this.f6473a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f6473a.f6267a.getWindowToken(), 0);
        this.f6473a.cancelEmailSubmit();
    }
}
