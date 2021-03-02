package com.jackhenry.godough.core.rda.registration;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;

public class RDAVelocityFragmentActivity extends AbstractActivity {

    /* renamed from: m */
    private RDAVelocityFragment f6728m;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return this.f6728m;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setShowArrowOnToolbar(true);
        setContentView(C1496ak.rda_registration_activity);
        if (bundle == null) {
            this.f6728m = new RDAVelocityFragment();
            getSupportFragmentManager().beginTransaction().add(C1494ai.layout, this.f6728m, RDATermsAndConditionsFragment.TAG).commit();
        }
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getRda().getText());
        getSupportActionBar().setSubtitle(C1506am.velocity_limits);
    }
}
