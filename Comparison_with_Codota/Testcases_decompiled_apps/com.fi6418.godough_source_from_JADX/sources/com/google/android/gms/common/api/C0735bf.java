package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.content.Loader;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: com.google.android.gms.common.api.bf */
class C0735bf extends Loader<ConnectionResult> implements C0752q, C0753r {

    /* renamed from: a */
    public final C0749n f4501a;

    /* renamed from: b */
    private boolean f4502b;

    /* renamed from: c */
    private ConnectionResult f4503c;

    public C0735bf(Context context, C0749n nVar) {
        super(context);
        this.f4501a = nVar;
    }

    /* renamed from: a */
    private void m4070a(ConnectionResult connectionResult) {
        this.f4503c = connectionResult;
        if (isStarted() && !isAbandoned()) {
            deliverResult(connectionResult);
        }
    }

    /* renamed from: c */
    public boolean mo7427c() {
        return this.f4502b;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.f4501a.mo7379a(str, fileDescriptor, printWriter, strArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo1158e() {
        super.mo1158e();
        this.f4501a.mo7376a((C0752q) this);
        this.f4501a.mo7377a((C0753r) this);
        if (this.f4503c != null) {
            deliverResult(this.f4503c);
        }
        if (!this.f4501a.mo7383c() && !this.f4501a.mo7384d() && !this.f4502b) {
            this.f4501a.mo7372a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo1159f() {
        this.f4501a.mo7380b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo1160g() {
        this.f4503c = null;
        this.f4502b = false;
        this.f4501a.mo7381b((C0752q) this);
        this.f4501a.mo7382b((C0753r) this);
        this.f4501a.mo7380b();
    }

    public void onConnected(Bundle bundle) {
        this.f4502b = false;
        m4070a(ConnectionResult.f4398a);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f4502b = true;
        m4070a(connectionResult);
    }

    public void onConnectionSuspended(int i) {
    }
}
