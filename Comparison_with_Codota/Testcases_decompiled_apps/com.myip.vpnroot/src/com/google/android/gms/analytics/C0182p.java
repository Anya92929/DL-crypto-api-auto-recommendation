package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: com.google.android.gms.analytics.p */
class C0182p extends BroadcastReceiver {

    /* renamed from: ya */
    static final String f186ya = C0182p.class.getName();

    /* renamed from: yb */
    private final C0156ae f187yb;

    C0182p(C0156ae aeVar) {
        this.f187yb = aeVar;
    }

    /* renamed from: A */
    public static void m211A(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(f186ya, true);
        context.sendBroadcast(intent);
    }

    public void onReceive(Context ctx, Intent intent) {
        boolean z = false;
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            C0156ae aeVar = this.f187yb;
            if (!booleanExtra) {
                z = true;
            }
            aeVar.mo3617A(z);
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(f186ya)) {
            this.f187yb.mo3619ee();
        }
    }

    /* renamed from: z */
    public void mo3708z(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
        intentFilter2.addCategory(context.getPackageName());
        context.registerReceiver(this, intentFilter2);
    }
}
