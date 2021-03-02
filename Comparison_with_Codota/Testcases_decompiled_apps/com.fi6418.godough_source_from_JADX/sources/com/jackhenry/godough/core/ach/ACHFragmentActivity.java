package com.jackhenry.godough.core.ach;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.ACH;

public class ACHFragmentActivity extends AbstractActivity implements C1486q {
    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.ach);
    }

    public void onACHClicked(ACH ach) {
        Intent intent = new Intent(GoDoughApp.getApp(), ACHDetailFragmentActivity.class);
        intent.putExtra("EXTRA_ACH", ach);
        startActivityForResult(intent, 0);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            getSupportFragmentManager().findFragmentByTag(ACHFragment.TAG).onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.ach_activity);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getAch().getText());
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
