package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzd;

/* renamed from: com.google.android.gms.common.internal.c */
abstract class C1364c extends zzd.zze {

    /* renamed from: a */
    final /* synthetic */ zzd f4486a;
    public final int statusCode;

    /* renamed from: xF */
    public final Bundle f4487xF;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected C1364c(zzd zzd, int i, Bundle bundle) {
        super(true);
        this.f4486a = zzd;
        this.statusCode = i;
        this.f4487xF = bundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6613a(ConnectionResult connectionResult);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6615a(Boolean bool) {
        PendingIntent pendingIntent = null;
        if (bool == null) {
            this.f4486a.m6087b(1, (IInterface) null);
            return;
        }
        switch (this.statusCode) {
            case 0:
                if (!mo6616a()) {
                    this.f4486a.m6087b(1, (IInterface) null);
                    mo6613a(new ConnectionResult(8, (PendingIntent) null));
                    return;
                }
                return;
            case 10:
                this.f4486a.m6087b(1, (IInterface) null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                this.f4486a.m6087b(1, (IInterface) null);
                if (this.f4487xF != null) {
                    pendingIntent = (PendingIntent) this.f4487xF.getParcelable("pendingIntent");
                }
                mo6613a(new ConnectionResult(this.statusCode, pendingIntent));
                return;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo6616a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo6617b() {
    }
}
