package com.jackhenry.godough.core.accounts.statements;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;

public class StatementFragmentActivity extends AbstractActivity {
    public static final int LOADER_ID_STATEMENT_ACCOUNTS = 1;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.statementGroups);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.statements_activity);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle(GoDoughApp.getUserSettings().getUserMenu().getStatements().getText());
    }
}
