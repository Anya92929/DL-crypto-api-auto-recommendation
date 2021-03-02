package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.google.firebase.iid.j */
class C1988j extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1987i f7548a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1988j(C1987i iVar, Looper looper) {
        super(looper);
        this.f7548a = iVar;
    }

    public void handleMessage(Message message) {
        this.f7548a.mo9893a(message);
    }
}
