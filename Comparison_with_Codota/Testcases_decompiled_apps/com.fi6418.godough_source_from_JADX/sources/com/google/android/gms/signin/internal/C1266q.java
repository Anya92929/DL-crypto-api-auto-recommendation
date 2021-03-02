package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import android.util.Log;

/* renamed from: com.google.android.gms.signin.internal.q */
class C1266q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5297a;

    /* renamed from: b */
    final /* synthetic */ String f5298b;

    /* renamed from: c */
    final /* synthetic */ C1258i f5299c;

    /* renamed from: d */
    final /* synthetic */ C1264o f5300d;

    C1266q(C1264o oVar, String str, String str2, C1258i iVar) {
        this.f5300d = oVar;
        this.f5297a = str;
        this.f5298b = str2;
        this.f5299c = iVar;
    }

    public void run() {
        try {
            this.f5299c.mo9059a(this.f5300d.m5245a().mo7452a(this.f5297a, this.f5298b));
        } catch (RemoteException e) {
            Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", e);
        }
    }
}
