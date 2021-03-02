package com.jackhenry.godough.core.alerts;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;

public class AlertDetailActivity extends AbstractActivity {
    public static final String EXTRA_ALERT = "EXTRA_ALERT";

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.details);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        setContentView(C1496ak.alert_details_activity);
        setResult(getIntent().getIntExtra("EXTRA_ALERT", 0));
    }
}
