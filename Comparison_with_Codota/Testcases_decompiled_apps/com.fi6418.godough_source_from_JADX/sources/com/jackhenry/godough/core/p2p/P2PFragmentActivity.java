package com.jackhenry.godough.core.p2p;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.GodoughTransactionActivity;

public class P2PFragmentActivity extends GodoughTransactionActivity {

    /* renamed from: m */
    P2PFragment f6556m;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return this.f6556m;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.p2p_activity);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getP2P().getText());
        getSupportActionBar().setHomeButtonEnabled(true);
        this.f6556m = (P2PFragment) getSupportFragmentManager().findFragmentById(C1494ai.p2p);
        setTransactionFragment(this.f6556m);
    }

    public void resetFields() {
        this.f6556m.payAnother();
    }
}
