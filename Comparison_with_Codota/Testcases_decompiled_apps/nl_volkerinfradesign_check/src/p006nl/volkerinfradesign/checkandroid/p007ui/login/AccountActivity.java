package p006nl.volkerinfradesign.checkandroid.p007ui.login;

import android.os.Bundle;
import android.support.p004v7.app.AppCompatActivity;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.AccountFragment;
import p006nl.volkerinfradesign.checkandroid.util.ActionBarCompat;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.login.AccountActivity */
public class AccountActivity extends AppCompatActivity implements AccountFragment.AccountFragmentParent {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(getApp().getModel().getCustomTheme().getMainStyle());
        new ActionBarCompat(this).setDisplayHomeAsUpEnabled(true);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(16908290, AccountFragment.newInstance(true)).commit();
        }
    }

    public void onAccountEditingCancelled() {
        finish();
    }

    public void onAccountEditingFinished() {
        finish();
    }

    public App getApp() {
        return (App) getApplication();
    }
}
