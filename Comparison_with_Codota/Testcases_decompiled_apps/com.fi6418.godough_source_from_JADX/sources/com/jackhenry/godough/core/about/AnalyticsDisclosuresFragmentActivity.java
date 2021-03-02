package com.jackhenry.godough.core.about;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;

public class AnalyticsDisclosuresFragmentActivity extends AbstractActivity {
    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.analytics_disclosures);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        setContentView(C1496ak.analytics_disclosures_activity);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getApp().getString(C1506am.lbl_analytics_disclosure));
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
