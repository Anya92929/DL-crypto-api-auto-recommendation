package com.jackhenry.godough.core.login;

import android.content.DialogInterface;
import android.support.p000v4.view.ViewCompat;
import com.jackhenry.godough.core.model.Carrier;

/* renamed from: com.jackhenry.godough.core.login.y */
class C1750y implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnrollmentSettingsFragment f6497a;

    C1750y(EnrollmentSettingsFragment enrollmentSettingsFragment) {
        this.f6497a = enrollmentSettingsFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Carrier unused = this.f6497a.f6280c = (Carrier) this.f6497a.f6278ak.getItem(i);
        this.f6497a.f6285h.setText(this.f6497a.f6280c.getName());
        this.f6497a.f6285h.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f6497a.f6285h.setTag(this.f6497a.f6280c);
        dialogInterface.dismiss();
        this.f6497a.m6309o();
    }
}
