package com.jackhenry.godough.core.wires;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Wire;

public class WiresFragmentActivity extends AbstractActivity implements C1939o {
    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.wires);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2) {
            getSupportFragmentManager().findFragmentByTag(WiresFragment.TAG).onActivityResult(i, i2, intent);
        }
    }

    public void onCountChanged(int i) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.wires_activity);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getWires().getText());
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void onWireClicked(Wire wire) {
        Intent intent = new Intent(GoDoughApp.getApp(), WireDetailFragmentActivity.class);
        intent.putExtra(WireDetailsFragment.EXTRA_WIRE, wire);
        startActivityForResult(intent, 0);
    }
}
