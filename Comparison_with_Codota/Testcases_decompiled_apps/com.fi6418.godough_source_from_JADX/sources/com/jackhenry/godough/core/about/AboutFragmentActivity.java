package com.jackhenry.godough.core.about;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;

public class AboutFragmentActivity extends AbstractActivity {
    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.about);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.about_activity);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getAbout().getText());
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
