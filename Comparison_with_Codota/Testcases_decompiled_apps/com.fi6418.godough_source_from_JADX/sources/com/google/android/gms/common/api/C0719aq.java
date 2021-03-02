package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* renamed from: com.google.android.gms.common.api.aq */
final class C0719aq extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0714al f4478a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0719aq(C0714al alVar, Looper looper) {
        super(looper);
        this.f4478a = alVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f4478a.m3993o();
                return;
            case 2:
                this.f4478a.m3992n();
                return;
            case 3:
                ((C0720ar) message.obj).mo7397a(this.f4478a);
                return;
            case 4:
                throw ((RuntimeException) message.obj);
            default:
                Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                return;
        }
    }
}
