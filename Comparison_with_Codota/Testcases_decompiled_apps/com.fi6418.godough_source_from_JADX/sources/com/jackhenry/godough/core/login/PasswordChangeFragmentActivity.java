package com.jackhenry.godough.core.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.KeyEvent;
import android.view.Menu;
import com.jackhenry.godough.core.AbstractNoUserMenuActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.CredentialsChangeSettings;

public class PasswordChangeFragmentActivity extends AbstractNoUserMenuActivity {
    public static final String EXTRA_PASSWORD_CHANGE_SETTINGS = "EXTRA_PASSWORD_CHANGE_SETTINGS";

    /* renamed from: m */
    private PasswordChangeFragment f6351m;

    /* renamed from: n */
    private CredentialsChangeSettings f6352n;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9484c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return this.f6351m;
    }

    public CredentialsChangeSettings getCredentialsChangeSettings() {
        if (this.f6352n == null) {
            this.f6352n = new CredentialsChangeSettings();
        }
        return this.f6352n;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.password_change_activity);
        if (bundle == null) {
            this.f6352n = (CredentialsChangeSettings) getIntent().getSerializableExtra(EXTRA_PASSWORD_CHANGE_SETTINGS);
            this.f6351m = new PasswordChangeFragment();
            getSupportFragmentManager().beginTransaction().add(C1494ai.layout, this.f6351m, PasswordChangeFragment.TAG).commit();
        } else {
            this.f6352n = (CredentialsChangeSettings) bundle.getSerializable(EXTRA_PASSWORD_CHANGE_SETTINGS);
        }
        String string = getString(C1506am.password_change_title, new Object[]{GoDoughApp.getSettings().getShortPasswordLabel()});
        if (this.f6352n.statusContains(2)) {
            string = getString(C1506am.password_change_title, new Object[]{getString(C1506am.id_label)});
        }
        getSupportActionBar().setTitle((CharSequence) string);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        launchLogoutDialog();
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(EXTRA_PASSWORD_CHANGE_SETTINGS, this.f6352n);
        super.onSaveInstanceState(bundle);
    }

    public void setCredentialsChangeSettings(CredentialsChangeSettings credentialsChangeSettings) {
        this.f6352n = credentialsChangeSettings;
    }

    public void showPasswordChangeHelp() {
        Intent intent = new Intent(getApplicationContext(), PasswordChangeHelpFragmentActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(PasswordChangeHelpFragmentActivity.PASSWORD_CHANGE_SETTINGS, this.f6352n);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
