package com.jackhenry.godough.core.p2p;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.P2PPayee;

public class P2PAddPersonFragmentActivity extends GodoughTransactionActivity {
    public static final String EXTRA_PERSON = "EXTRA_PERSON";

    /* renamed from: m */
    P2PAddPersonFragment f6528m;

    public void actionButtonClickHandler() {
        Intent intent = new Intent();
        P2PPayee p2PPayee = this.f6528m.getP2PPayee();
        if (p2PPayee.getNickname().trim().length() == 0) {
            p2PPayee.setNickname(p2PPayee.getName());
        }
        intent.putExtra(EXTRA_PERSON, p2PPayee);
        setResult(-1, intent);
        resetFields();
        finish();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return this.f6528m;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        setContentView(C1496ak.p2p_add_person_activity);
        this.f6528m = (P2PAddPersonFragment) getSupportFragmentManager().findFragmentById(C1494ai.addP2PPayee);
        setTransactionFragment(mo9485d());
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void resetFields() {
        ((P2PAddPersonFragment) mo9485d()).resetData();
    }
}
