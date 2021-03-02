package com.jackhenry.godough.core.transfers;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.Transfer;

public class TransfersFragmentActivity extends GodoughTransactionActivity {

    /* renamed from: m */
    private TransfersFragment f6818m;

    /* renamed from: n */
    private Transfer f6819n;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return this.f6818m;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.transfers_activity);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getTransfers().getText());
        getSupportActionBar().setHomeButtonEnabled(true);
        this.f6818m = (TransfersFragment) getSupportFragmentManager().findFragmentById(C1494ai.transfers);
        setTransactionFragment(this.f6818m);
    }

    public void onNoData(Object obj) {
        if (obj.equals(TransfersFragment.ACCOUNT_NO_FROM_DATA)) {
            showDialog(getString(C1506am.dg_error_title), getString(C1506am.transfer_no_from_accounts));
        } else if (obj.equals(TransfersFragment.ACCOUNT_NO_TO_DATA)) {
            showDialog(getString(C1506am.dg_error_title), getString(C1506am.transfer_no_to_accounts));
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("EXTRA_TRANSFER", this.f6819n);
    }

    public void resetFields() {
        this.f6818m.transferAnother();
    }
}
