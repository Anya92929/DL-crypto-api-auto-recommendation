package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: com.google.android.gms.common.api.bb */
class C0731bb implements C0753r {

    /* renamed from: a */
    public final int f4489a;

    /* renamed from: b */
    public final C0749n f4490b;

    /* renamed from: c */
    public final C0753r f4491c;

    /* renamed from: d */
    final /* synthetic */ C0730ba f4492d;

    public C0731bb(C0730ba baVar, int i, C0749n nVar, C0753r rVar) {
        this.f4492d = baVar;
        this.f4489a = i;
        this.f4490b = nVar;
        this.f4491c = rVar;
        nVar.mo7377a((C0753r) this);
    }

    /* renamed from: a */
    public void mo7418a() {
        this.f4490b.mo7382b((C0753r) this);
        this.f4490b.mo7380b();
    }

    /* renamed from: a */
    public void mo7419a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("GoogleApiClient #").print(this.f4489a);
        printWriter.println(":");
        this.f4490b.mo7379a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f4492d.f4487e.post(new C0732bc(this.f4492d, this.f4489a, connectionResult));
    }
}
