package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;

/* renamed from: com.google.android.gms.common.api.ak */
public class C0713ak implements C0724av {

    /* renamed from: a */
    private final C0714al f4444a;

    public C0713ak(C0714al alVar) {
        this.f4444a = alVar;
    }

    /* renamed from: a */
    public void mo7364a() {
        this.f4444a.mo7386f();
        this.f4444a.f4451f = Collections.emptySet();
    }

    /* renamed from: a */
    public void mo7365a(int i) {
    }

    /* renamed from: a */
    public void mo7366a(Bundle bundle) {
    }

    /* renamed from: a */
    public void mo7367a(ConnectionResult connectionResult, C0702a<?> aVar, int i) {
    }

    /* renamed from: b */
    public void mo7368b() {
        for (C0723au a : this.f4444a.f4447b) {
            a.mo7399a();
        }
        this.f4444a.f4447b.clear();
        this.f4444a.f4450e.clear();
        this.f4444a.mo7385e();
    }

    /* renamed from: c */
    public void mo7369c() {
        this.f4444a.mo7387g();
    }

    /* renamed from: d */
    public String mo7370d() {
        return "DISCONNECTED";
    }
}
