package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* renamed from: com.google.android.gms.internal.pf */
final class C1819pf extends Handler {

    /* renamed from: a */
    final /* synthetic */ zzqa f5476a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1819pf(zzqa zzqa, Looper looper) {
        super(looper);
        this.f5476a = zzqa;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ((C1818pe) message.obj).mo7632a(this.f5476a);
                return;
            case 2:
                throw ((RuntimeException) message.obj);
            default:
                Log.w("GACStateManager", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                return;
        }
    }
}
