package com.jackhenry.godough.core.prefmenu;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.prefmenu.model.PreferenceMenuItem;

public class GodoughPreferenceActivity extends AbstractActivity {
    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.dummy);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.godough_preferences_activity);
        getSupportFragmentManager().beginTransaction().add(C1494ai.layout, new C1798a(), PreferenceMenuItem.PreferenceMenuType.LAUNCHPAGE.name()).commit();
        setTitle(GoDoughApp.getUserSettings().getUserMenu().getPreferences().getText());
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }
}
