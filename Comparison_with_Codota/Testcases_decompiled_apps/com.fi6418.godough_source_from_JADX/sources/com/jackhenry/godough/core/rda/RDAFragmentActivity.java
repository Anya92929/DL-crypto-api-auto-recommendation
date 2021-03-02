package com.jackhenry.godough.core.rda;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.rda.registration.AbstractRDAVerifyRegistrationActivity;

public class RDAFragmentActivity extends AbstractRDAVerifyRegistrationActivity implements C1807ac {
    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.deposits);
    }

    public void initLoadingTasks() {
        ((RDAFragment) mo9485d()).mo11010l();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.deposit_activity);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getRda().getText());
        getSupportActionBar().setHomeButtonEnabled(true);
        C1808ad.m6711a(this).mo11013a(getFilesDir().getAbsolutePath(), this);
    }

    public void onFragementNavigate(C1806ab abVar) {
        startActivity(abVar == C1806ab.DEPOSIT ? new Intent(GoDoughApp.getApp(), DepositCheckFragmentActivity.class) : new Intent(GoDoughApp.getApp(), DepositReviewFragmentActivity.class));
    }
}
