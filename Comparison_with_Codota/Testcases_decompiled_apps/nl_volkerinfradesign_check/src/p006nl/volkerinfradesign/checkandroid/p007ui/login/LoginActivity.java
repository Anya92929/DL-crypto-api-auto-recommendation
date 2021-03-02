package p006nl.volkerinfradesign.checkandroid.p007ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.p001v4.app.FragmentActivity;
import android.view.MenuItem;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.environments.AccountState;
import p006nl.volkerinfradesign.checkandroid.environments.Model;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.AccountFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.CodeFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.EmailFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.main.MainActivity;
import p006nl.volkerinfradesign.checkandroid.util.ActionBarCompat;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.login.LoginActivity */
public class LoginActivity extends FragmentActivity implements Model.AccountStateChangedObserver, AccountFragment.AccountFragmentParent, CodeFragment.CodeFragmentParent, EmailFragment.EmailFragmentParent {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(5);
        new ActionBarCompat(this).setDisplayHomeAsUpEnabled(true);
        AccountState accountState = m6292b().getModel().getAccountState();
        if (bundle == null) {
            if (!AppState.getInstance().getName().equalsIgnoreCase("IsalaDelta")) {
                getSupportFragmentManager().beginTransaction().setCustomAnimations(C1352R.anim.slide_in_right, C1352R.anim.slide_out_left, 17432578, 17432579).replace(16908290, new EmailFragment()).commit();
            }
            if (accountState.isCodeRequested()) {
                m6293c();
            }
            if (!AppState.getInstance().getName().equalsIgnoreCase("IsalaDelta") && accountState.isVerified()) {
                m6294d();
            }
        }
        m6292b().getModel().registerStateChangedObserver(this);
    }

    public void onBackPressed() {
        if (!AppState.getInstance().getName().equalsIgnoreCase("IsalaDelta")) {
            super.onBackPressed();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        m6292b().getModel().unRegisterStateChangedObserver(this);
        super.onDestroy();
    }

    public void onRequestCodeClicked(String str) {
        m6292b().getModel().requestCode(str);
    }

    public boolean showsErrors() {
        return true;
    }

    /* renamed from: b */
    private App m6292b() {
        return (App) getApplication();
    }

    public void onAccountStateChanged(AccountState accountState, Exception exc) {
        setProgressBarIndeterminateVisibility(accountState.isLoading());
        switch (accountState) {
            case CODE_REQUESTED:
                m6293c();
                return;
            case VERIFIED:
                if (AppState.getInstance().getName().equalsIgnoreCase("IsalaDelta")) {
                    onAccountEditingFinished();
                    return;
                } else {
                    m6294d();
                    return;
                }
            default:
                return;
        }
    }

    public void onVerifyCodeClicked(int i) {
        m6292b().getModel().verifyAccountCode(i);
    }

    public void onRestartClicked() {
        onBackPressed();
    }

    /* renamed from: c */
    private void m6293c() {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(C1352R.anim.slide_in_right, C1352R.anim.slide_out_left, 17432578, 17432579).replace(16908290, new CodeFragment()).addToBackStack((String) null).commit();
    }

    /* renamed from: d */
    private void m6294d() {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(C1352R.anim.slide_in_right, C1352R.anim.slide_out_left, 17432578, 17432579).replace(16908290, AccountFragment.newInstance(false)).addToBackStack((String) null).commit();
    }

    public void onAccountEditingCancelled() {
        onBackPressed();
    }

    public void onAccountEditingFinished() {
        if (m6292b().getModel().setSetupFinished()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(335544320);
            setResult(-1, (Intent) null);
            startActivity(intent);
        }
    }
}
