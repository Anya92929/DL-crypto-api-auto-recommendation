package com.jackhenry.godough.core.login;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* renamed from: com.jackhenry.godough.core.login.x */
class C1749x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnrollmentSettingsFragment f6496a;

    C1749x(EnrollmentSettingsFragment enrollmentSettingsFragment) {
        this.f6496a = enrollmentSettingsFragment;
    }

    public void onClick(View view) {
        ((InputMethodManager) this.f6496a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f6496a.f6283f.getWindowToken(), 0);
        ((C1690ch) this.f6496a.getActivity()).cancelTerms(false);
    }
}
