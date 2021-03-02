package com.jackhenry.godough.core.login;

import android.view.View;
import com.jackhenry.godough.core.model.Carrier;

/* renamed from: com.jackhenry.godough.core.login.v */
class C1747v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnrollmentSettingsFragment f6494a;

    C1747v(EnrollmentSettingsFragment enrollmentSettingsFragment) {
        this.f6494a = enrollmentSettingsFragment;
    }

    public void onClick(View view) {
        String obj = this.f6494a.f6283f.getText().toString();
        boolean isChecked = this.f6494a.f6282e.isChecked();
        ((C1751z) this.f6494a.getActivity()).acceptSettings((Carrier) this.f6494a.f6285h.getTag(), obj, isChecked);
    }
}
