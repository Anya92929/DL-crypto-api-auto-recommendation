package com.jackhenry.godough.core.ach;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.ACHRequest;

public class ACHDetailFragmentActivity extends GodoughTransactionActivity {
    public static final int DIALOG_ACH_FAIL = 5022;
    public static final int DIALOG_ACH_SUCCESS = 5021;
    public static final String EXTRA_ACH = "EXTRA_ACH";
    public static final String EXTRA_ACH_REQ = "EXTRA_ACH_REQ";

    /* renamed from: m */
    private ACHRequest f5945m;

    public void actionButtonClickHandler() {
        setResult(-1);
        finish();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.ach);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (GoDoughApp.getUserSettings() == null) {
            finish();
            return;
        }
        setShowArrowOnToolbar(true);
        setContentView(C1496ak.ach_detail_activity);
        setTransactionFragment(mo9485d());
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getAch().getText());
        setResult(0);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(EXTRA_ACH_REQ, this.f5945m);
    }

    public void resetFields() {
    }
}
