package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.internal.aa */
final class C0977aa extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1037y f4675a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0977aa(C1037y yVar, Looper looper) {
        super(looper);
        this.f4675a = yVar;
    }

    /* renamed from: a */
    private void m4360a(Message message) {
        C0978ab abVar = (C0978ab) message.obj;
        abVar.mo7503b();
        abVar.mo7505d();
    }

    /* renamed from: b */
    private boolean m4361b(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
    }

    public void handleMessage(Message message) {
        if (this.f4675a.f4768b.get() != message.arg1) {
            if (m4361b(message)) {
                m4360a(message);
            }
        } else if ((message.what == 1 || message.what == 5 || message.what == 6) && !this.f4675a.mo7654h()) {
            m4360a(message);
        } else if (message.what == 3) {
            ConnectionResult connectionResult = new ConnectionResult(message.arg2, (PendingIntent) null);
            this.f4675a.f4776k.mo7358a(connectionResult);
            this.f4675a.mo7649a(connectionResult);
        } else if (message.what == 4) {
            this.f4675a.m4653b(4, null);
            if (this.f4675a.f4783r != null) {
                this.f4675a.f4783r.onConnectionSuspended(message.arg2);
            }
            this.f4675a.mo7646a(message.arg2);
            boolean unused = this.f4675a.m4649a(4, 1, null);
        } else if (message.what == 2 && !this.f4675a.mo7437b()) {
            m4360a(message);
        } else if (m4361b(message)) {
            ((C0978ab) message.obj).mo7504c();
        } else {
            Log.wtf("GmsClient", "Don't know how to handle this message.");
        }
    }
}
