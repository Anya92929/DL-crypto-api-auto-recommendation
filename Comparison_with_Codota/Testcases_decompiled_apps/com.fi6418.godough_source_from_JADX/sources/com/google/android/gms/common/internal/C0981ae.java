package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0756u;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.ae */
public class C0981ae implements C0756u {

    /* renamed from: a */
    final /* synthetic */ C1037y f4683a;

    public C0981ae(C1037y yVar) {
        this.f4683a = yVar;
    }

    /* renamed from: a */
    public void mo7358a(ConnectionResult connectionResult) {
        if (connectionResult.mo7323b()) {
            this.f4683a.mo7435a((C0993aq) null, (Set<Scope>) this.f4683a.f4781p);
        } else if (this.f4683a.f4784s != null) {
            this.f4683a.f4784s.onConnectionFailed(connectionResult);
        }
    }

    /* renamed from: b */
    public void mo7359b(ConnectionResult connectionResult) {
        throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
    }
}
