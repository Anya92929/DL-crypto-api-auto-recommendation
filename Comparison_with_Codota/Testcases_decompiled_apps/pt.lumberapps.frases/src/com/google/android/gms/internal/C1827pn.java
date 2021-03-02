package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzqn;

/* renamed from: com.google.android.gms.internal.pn */
final class C1827pn extends Handler {

    /* renamed from: a */
    final /* synthetic */ zzqn f5501a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1827pn(zzqn zzqn, Looper looper) {
        super(looper);
        this.f5501a = zzqn;
    }

    public void handleMessage(Message message) {
        boolean z = true;
        if (message.what != 1) {
            z = false;
        }
        zzab.zzbo(z);
        this.f5501a.mo8994a((zzqn.zzb) message.obj);
    }
}
