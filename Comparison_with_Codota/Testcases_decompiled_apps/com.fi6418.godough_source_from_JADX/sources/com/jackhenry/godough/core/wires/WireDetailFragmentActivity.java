package com.jackhenry.godough.core.wires;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.GodoughTransactionActivity;
import com.jackhenry.godough.core.model.Wire;
import com.jackhenry.godough.core.session.C1886b;

public class WireDetailFragmentActivity extends GodoughTransactionActivity {
    public void actionButtonClickHandler() {
        resetFields();
        finish();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.wire_details);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setShowArrowOnToolbar(true);
        setContentView(C1496ak.wire_detail_activity);
        Wire wire = (Wire) getIntent().getSerializableExtra(WireDetailsFragment.EXTRA_WIRE);
        if (!GoDoughApp.getUserSettings().isHasDualControlWires() || !wire.getStatus().equals(Wire.STATUS_NEED_APPROVAL)) {
            getSupportActionBar().setTitle((CharSequence) getString(C1506am.title_transmit_wire));
        } else {
            getSupportActionBar().setTitle((CharSequence) getString(C1506am.title_approve_wire));
        }
        new C1886b().execute(new Void[0]);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        setTransactionFragment(mo9485d());
    }

    public void resetFields() {
        ((WireDetailsFragment) mo9485d()).resetFields();
    }
}
