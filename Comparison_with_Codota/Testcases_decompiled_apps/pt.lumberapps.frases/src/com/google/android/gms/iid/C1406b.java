package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.iid.zzb;

/* renamed from: com.google.android.gms.iid.b */
final class C1406b extends zzb.zza {

    /* renamed from: a */
    Handler f4813a;

    /* renamed from: b */
    final /* synthetic */ MessengerCompat f4814b;

    C1406b(MessengerCompat messengerCompat, Handler handler) {
        this.f4814b = messengerCompat;
        this.f4813a = handler;
    }

    public void send(Message message) {
        message.arg2 = Binder.getCallingUid();
        this.f4813a.dispatchMessage(message);
    }
}
