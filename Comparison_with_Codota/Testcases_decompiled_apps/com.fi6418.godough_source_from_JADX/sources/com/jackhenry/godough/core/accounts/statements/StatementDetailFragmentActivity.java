package com.jackhenry.godough.core.accounts.statements;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.Menu;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;

public class StatementDetailFragmentActivity extends AbstractActivity {
    public static final String EXTRA_STATEMENT_DETAIL = "EXTRA_STATEMENT_DETAIL";
    public static final int LOADER_ID_STATEMENT_ACCOUNTS = 1;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.statement_detail);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        setContentView(C1496ak.statement_detail_activity);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
