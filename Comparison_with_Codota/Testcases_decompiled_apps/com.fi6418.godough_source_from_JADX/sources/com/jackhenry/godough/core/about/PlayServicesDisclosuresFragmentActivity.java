package com.jackhenry.godough.core.about;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;

public class PlayServicesDisclosuresFragmentActivity extends AbstractActivity {
    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.disclosures);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        setContentView(C1496ak.play_services_disclosures_activity);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getApp().getString(C1506am.lbl_google_api_disclosure));
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
