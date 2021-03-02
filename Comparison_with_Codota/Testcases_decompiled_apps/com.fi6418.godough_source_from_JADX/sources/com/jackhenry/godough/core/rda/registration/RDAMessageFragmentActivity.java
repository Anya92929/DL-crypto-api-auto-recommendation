package com.jackhenry.godough.core.rda.registration;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;

public class RDAMessageFragmentActivity extends AbstractActivity {
    public static final String EXTRA_USER_STATUS_RESPONSE = "EXTRA_USER_STATUS_RESPONSE";

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.licenses);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        setContentView(C1496ak.rda_message_fragment_activity);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getRda().getText());
    }
}
