package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* renamed from: com.google.firebase.iid.a */
class C1979a extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ int f7512a;

    /* renamed from: b */
    final /* synthetic */ FirebaseInstanceIdService f7513b;

    C1979a(FirebaseInstanceIdService firebaseInstanceIdService, int i) {
        this.f7513b = firebaseInstanceIdService;
        this.f7512a = i;
    }

    public void onReceive(Context context, Intent intent) {
        if (FirebaseInstanceIdService.m8133c(context)) {
            if (this.f7513b.f7511f) {
                Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
            }
            this.f7513b.getApplicationContext().unregisterReceiver(this);
            context.sendBroadcast(FirebaseInstanceIdService.m8131c(this.f7512a));
        }
    }
}
