package com.jackhenry.godough.core.alerts;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;

public class AlertsFragmentActivity extends AbstractActivity implements C1504g {
    public static final int ALERT_DETAIL = 0;

    /* renamed from: m */
    private int f5979m;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.alerts);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onAlertClicked(int i) {
        Intent intent = new Intent(GoDoughApp.getApp(), AlertDetailActivity.class);
        intent.putExtra("EXTRA_ALERT", i);
        startActivityForResult(intent, 0);
        this.f5979m = i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5979m = -1;
        if (GoDoughApp.getUserSettings() == null) {
            finish();
            return;
        }
        setContentView(C1496ak.alerts_activity);
        getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getAlerts().getText());
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (this.f5979m != -1) {
            AlertsFragment alertsFragment = (AlertsFragment) getSupportFragmentManager().findFragmentById(C1494ai.alerts);
            alertsFragment.f5977a.mo9281a(this.f5979m);
            alertsFragment.f5977a.notifyDataSetChanged();
            this.f5979m = -1;
        }
    }
}
