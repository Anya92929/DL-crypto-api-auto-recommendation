package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.w */
class C1748w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnrollmentSettingsFragment f6495a;

    C1748w(EnrollmentSettingsFragment enrollmentSettingsFragment) {
        this.f6495a = enrollmentSettingsFragment;
    }

    public void onClick(View view) {
        this.f6495a.m6302a(this.f6495a.f6282e.isChecked());
    }
}
