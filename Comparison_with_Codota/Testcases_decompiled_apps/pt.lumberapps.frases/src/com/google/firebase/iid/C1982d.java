package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;

/* renamed from: com.google.firebase.iid.d */
class C1982d extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1981c f7519a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1982d(C1981c cVar, Looper looper) {
        super(looper);
        this.f7519a = cVar;
    }

    public void handleMessage(Message message) {
        int zzc = MessengerCompat.zzc(message);
        C1987i.m8156a((Context) this.f7519a);
        this.f7519a.getPackageManager();
        if (zzc == C1987i.f7535c || zzc == C1987i.f7534b) {
            this.f7519a.zzm((Intent) message.obj);
            return;
        }
        int i = C1987i.f7534b;
        Log.w("FirebaseInstanceId", new StringBuilder(77).append("Message from unexpected caller ").append(zzc).append(" mine=").append(i).append(" appid=").append(C1987i.f7535c).toString());
    }
}
