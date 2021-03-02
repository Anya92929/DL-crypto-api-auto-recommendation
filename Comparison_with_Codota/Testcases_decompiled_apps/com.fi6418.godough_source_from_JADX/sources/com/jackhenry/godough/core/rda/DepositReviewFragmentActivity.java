package com.jackhenry.godough.core.rda;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.DepositTransaction;
import com.jackhenry.godough.core.rda.registration.AbstractRDAVerifyRegistrationActivity;

public class DepositReviewFragmentActivity extends AbstractRDAVerifyRegistrationActivity implements C1876s {
    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.deposit_review);
    }

    public void initLoadingTasks() {
        DepositReviewFragment depositReviewFragment = (DepositReviewFragment) getSupportFragmentManager().findFragmentById(C1494ai.deposit_review);
        if (depositReviewFragment != null) {
            depositReviewFragment.setupAdapter();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        setContentView(C1496ak.deposit_review_activity);
        getSupportActionBar().setTitle((CharSequence) getString(C1506am.lbl_review_deposits));
    }

    public void onDepositClicked(DepositTransaction depositTransaction) {
        Intent intent = new Intent(GoDoughApp.getApp(), DepositStatusFragmentActivity.class);
        intent.putExtra("depositTransaction", depositTransaction);
        startActivity(intent);
    }
}
