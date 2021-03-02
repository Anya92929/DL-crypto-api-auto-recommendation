package com.jackhenry.godough.core.accounts;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Account;

public class AccountsFragmentActivity extends AbstractActivity implements C1431k {
    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.accounts);
    }

    public void onAccountSelected(Account account) {
        Intent intent = new Intent(GoDoughApp.getApp(), AccountTransactionsFragmentActivity.class);
        intent.putExtra("EXTRA_ACCOUNT", account);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.accounts_activity);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getAccounts().getText());
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
