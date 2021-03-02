package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* renamed from: com.google.android.gms.internal.pc */
final class C1816pc extends Handler {

    /* renamed from: a */
    final /* synthetic */ zzpy f5473a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1816pc(zzpy zzpy, Looper looper) {
        super(looper);
        this.f5473a = zzpy;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f5473a.m7476i();
                return;
            case 2:
                this.f5473a.m7475h();
                return;
            default:
                Log.w("GoogleApiClientImpl", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                return;
        }
    }
}
