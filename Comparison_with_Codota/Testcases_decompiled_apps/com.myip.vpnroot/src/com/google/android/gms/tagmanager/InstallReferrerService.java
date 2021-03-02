package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerService extends IntentService {
    CampaignTrackingService apl;
    Context apm;

    public InstallReferrerService() {
        super("InstallReferrerService");
    }

    public InstallReferrerService(String name) {
        super(name);
    }

    /* renamed from: a */
    private void m6710a(Context context, Intent intent) {
        if (this.apl == null) {
            this.apl = new CampaignTrackingService();
        }
        this.apl.processIntent(context, intent);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        Context applicationContext = this.apm != null ? this.apm : getApplicationContext();
        C2014ay.m6791d(applicationContext, stringExtra);
        m6710a(applicationContext, intent);
    }
}
