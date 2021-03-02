package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.C0755t;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.signin.internal.p */
class C1265p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f5293a;

    /* renamed from: b */
    final /* synthetic */ String f5294b;

    /* renamed from: c */
    final /* synthetic */ C1258i f5295c;

    /* renamed from: d */
    final /* synthetic */ C1264o f5296d;

    C1265p(C1264o oVar, List list, String str, C1258i iVar) {
        this.f5296d = oVar;
        this.f5293a = list;
        this.f5294b = str;
        this.f5295c = iVar;
    }

    public void run() {
        try {
            C0755t a = this.f5296d.m5245a().mo7451a(this.f5294b, (Set<Scope>) Collections.unmodifiableSet(new HashSet(this.f5293a)));
            this.f5295c.mo9056a(new CheckServerAuthResult(a.mo7453a(), a.mo7454b()));
        } catch (RemoteException e) {
            Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", e);
        }
    }
}
