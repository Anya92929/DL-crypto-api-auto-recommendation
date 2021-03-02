package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzd;

/* renamed from: com.google.android.gms.common.internal.d */
final class C1365d extends Handler {

    /* renamed from: a */
    final /* synthetic */ zzd f4488a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1365d(zzd zzd, Looper looper) {
        super(looper);
        this.f4488a = zzd;
    }

    /* renamed from: a */
    private void m6058a(Message message) {
        zzd.zze zze = (zzd.zze) message.obj;
        zze.mo6617b();
        zze.unregister();
    }

    /* renamed from: b */
    private boolean m6059b(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 5;
    }

    public void handleMessage(Message message) {
        PendingIntent pendingIntent = null;
        if (this.f4488a.f4524c.get() != message.arg1) {
            if (m6059b(message)) {
                m6058a(message);
            }
        } else if ((message.what == 1 || message.what == 5) && !this.f4488a.isConnecting()) {
            m6058a(message);
        } else if (message.what == 3) {
            if (message.obj instanceof PendingIntent) {
                pendingIntent = (PendingIntent) message.obj;
            }
            ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
            this.f4488a.f4536o.zzh(connectionResult);
            this.f4488a.mo6668a(connectionResult);
        } else if (message.what == 4) {
            this.f4488a.m6087b(4, (IInterface) null);
            if (this.f4488a.f4541t != null) {
                this.f4488a.f4541t.onConnectionSuspended(message.arg2);
            }
            this.f4488a.mo6664a(message.arg2);
            boolean unused = this.f4488a.m6084a(4, 1, (IInterface) null);
        } else if (message.what == 2 && !this.f4488a.isConnected()) {
            m6058a(message);
        } else if (m6059b(message)) {
            ((zzd.zze) message.obj).zzasf();
        } else {
            Log.wtf("GmsClient", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
        }
    }
}
