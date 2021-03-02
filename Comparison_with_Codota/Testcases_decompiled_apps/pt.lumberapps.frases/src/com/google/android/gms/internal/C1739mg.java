package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.google.android.gms.internal.mg */
final class C1739mg extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ zzkh f5341a;

    private C1739mg(zzkh zzkh) {
        this.f5341a = zzkh;
    }

    /* synthetic */ C1739mg(zzkh zzkh, C1736md mdVar) {
        this(zzkh);
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            boolean unused = this.f5341a.f6613b = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            boolean unused2 = this.f5341a.f6613b = false;
        }
    }
}
