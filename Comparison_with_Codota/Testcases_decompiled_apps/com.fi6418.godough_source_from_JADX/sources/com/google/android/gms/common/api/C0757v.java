package com.google.android.gms.common.api;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.api.v */
public class C0757v implements C0724av {

    /* renamed from: a */
    private final C0714al f4532a;

    public C0757v(C0714al alVar) {
        this.f4532a = alVar;
    }

    /* renamed from: a */
    private <A extends C0743h> void m4118a(C0723au<A> auVar) {
        this.f4532a.mo7375a(auVar);
        A a = this.f4532a.mo7371a(auVar.mo7403b());
        if (a.mo7437b() || !this.f4532a.f4450e.containsKey(auVar.mo7403b())) {
            auVar.mo7402a(a);
        } else {
            auVar.mo7404b(new Status(17));
        }
    }

    /* renamed from: a */
    public void mo7364a() {
        while (!this.f4532a.f4447b.isEmpty()) {
            try {
                m4118a(this.f4532a.f4447b.remove());
            } catch (DeadObjectException e) {
                Log.w("GoogleApiClientConnected", "Service died while flushing queue", e);
            }
        }
    }

    /* renamed from: a */
    public void mo7365a(int i) {
        if (i == 1) {
            this.f4532a.mo7390j();
        }
        for (C0723au<?> a : this.f4532a.f4455j) {
            a.mo7400a(new Status(8, "The connection to Google Play services was lost"));
        }
        this.f4532a.mo7373a((ConnectionResult) null);
        this.f4532a.f4446a.mo7518a(i);
        this.f4532a.f4446a.mo7517a();
        if (i == 2) {
            this.f4532a.mo7372a();
        }
    }

    /* renamed from: a */
    public void mo7366a(Bundle bundle) {
    }

    /* renamed from: a */
    public void mo7367a(ConnectionResult connectionResult, C0702a<?> aVar, int i) {
    }

    /* renamed from: b */
    public void mo7368b() {
        this.f4532a.f4450e.clear();
        this.f4532a.mo7385e();
        this.f4532a.mo7373a((ConnectionResult) null);
        this.f4532a.f4446a.mo7517a();
    }

    /* renamed from: c */
    public void mo7369c() {
    }

    /* renamed from: d */
    public String mo7370d() {
        return "CONNECTED";
    }
}
