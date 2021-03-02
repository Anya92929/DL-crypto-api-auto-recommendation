package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.internal.af */
public final class C0982af extends C1037y<T>.C1038z {

    /* renamed from: e */
    public final IBinder f4684e;

    /* renamed from: f */
    final /* synthetic */ C1037y f4685f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0982af(C1037y yVar, int i, IBinder iBinder, Bundle bundle) {
        super(yVar, i, bundle);
        this.f4685f = yVar;
        this.f4684e = iBinder;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7511a(ConnectionResult connectionResult) {
        if (this.f4685f.f4784s != null) {
            this.f4685f.f4784s.onConnectionFailed(connectionResult);
        }
        this.f4685f.mo7649a(connectionResult);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7512a() {
        try {
            String interfaceDescriptor = this.f4684e.getInterfaceDescriptor();
            if (!this.f4685f.mo7617e().equals(interfaceDescriptor)) {
                Log.e("GmsClient", "service descriptor mismatch: " + this.f4685f.mo7617e() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface a = this.f4685f.mo7614a(this.f4684e);
            if (a == null || !this.f4685f.m4649a(2, 3, a)) {
                return false;
            }
            Bundle a_ = this.f4685f.mo7394a_();
            if (this.f4685f.f4783r != null) {
                this.f4685f.f4783r.onConnected(a_);
            }
            return true;
        } catch (RemoteException e) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
