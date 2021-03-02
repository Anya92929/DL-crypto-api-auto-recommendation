package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.Menu;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.CredentialsChangeSettings;

public class PasswordChangeHelpFragmentActivity extends AbstractActivity {
    public static final String PASSWORD_CHANGE_SETTINGS = "PASSWORD_RESET_DATA";

    /* renamed from: m */
    CredentialsChangeSettings f6353m;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9484c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.disclosures);
    }

    public CredentialsChangeSettings getCredentialsChangeSettings() {
        return this.f6353m;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f6353m = (CredentialsChangeSettings) getIntent().getSerializableExtra(PASSWORD_CHANGE_SETTINGS);
        } else {
            this.f6353m = (CredentialsChangeSettings) bundle.getSerializable(PASSWORD_CHANGE_SETTINGS);
        }
        setShowArrowOnToolbar(true);
        setContentView(C1496ak.password_change_help_activity);
        String string = getString(C1506am.password_change_help_title, new Object[]{GoDoughApp.getSettings().getShortPasswordLabel()});
        if (this.f6353m.statusContains(2)) {
            string = getString(C1506am.password_change_help_title, new Object[]{getString(C1506am.id_label)});
        }
        getSupportActionBar().setTitle((CharSequence) string);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        lockNavDrawer(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(PASSWORD_CHANGE_SETTINGS, this.f6353m);
        super.onSaveInstanceState(bundle);
    }

    public void setCredentialsChangeSettings(CredentialsChangeSettings credentialsChangeSettings) {
        this.f6353m = credentialsChangeSettings;
    }
}
