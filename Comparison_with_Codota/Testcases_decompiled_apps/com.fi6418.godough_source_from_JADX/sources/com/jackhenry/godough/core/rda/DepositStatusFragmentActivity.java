package com.jackhenry.godough.core.rda;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.DepositTransaction;

public class DepositStatusFragmentActivity extends AbstractActivity implements C1877t {
    public static final String PARAM_DEPOSIT_TRANSACTION = "depositTransaction";

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.deposit_status);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        setContentView(C1496ak.deposit_status_activity);
        getSupportActionBar().setTitle((CharSequence) getString(C1506am.lbl_deposit_detail));
    }

    public void onViewCheck(DepositTransaction depositTransaction) {
        Intent intent = new Intent(GoDoughApp.getApp(), CheckViewFragmentActivity.class);
        intent.putExtra("depositTransAction", getIntent().getSerializableExtra("depositTransaction"));
        startActivity(intent);
    }
}
