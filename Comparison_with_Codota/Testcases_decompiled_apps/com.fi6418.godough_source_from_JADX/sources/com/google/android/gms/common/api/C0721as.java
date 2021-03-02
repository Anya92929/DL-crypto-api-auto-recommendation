package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.api.as */
class C0721as extends BroadcastReceiver {

    /* renamed from: a */
    private WeakReference<C0714al> f4480a;

    C0721as(C0714al alVar) {
        this.f4480a = new WeakReference<>(alVar);
    }

    public void onReceive(Context context, Intent intent) {
        C0714al alVar;
        Uri data = intent.getData();
        String str = null;
        if (data != null) {
            str = data.getSchemeSpecificPart();
        }
        if (str != null && str.equals("com.google.android.gms") && (alVar = (C0714al) this.f4480a.get()) != null) {
            alVar.m3992n();
        }
    }
}
