package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.internal.z */
abstract class C1038z extends C1037y<T>.com/google/android/gms/common/internal/ab<Boolean> {

    /* renamed from: a */
    public final int f4786a;

    /* renamed from: b */
    public final Bundle f4787b;

    /* renamed from: c */
    final /* synthetic */ C1037y f4788c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected C1038z(C1037y yVar, int i, Bundle bundle) {
        super(yVar, true);
        this.f4788c = yVar;
        this.f4786a = i;
        this.f4787b = bundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7662a(ConnectionResult connectionResult);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7664a(Boolean bool) {
        PendingIntent pendingIntent = null;
        if (bool == null) {
            this.f4788c.m4653b(1, null);
            return;
        }
        switch (this.f4786a) {
            case 0:
                if (!mo7665a()) {
                    this.f4788c.m4653b(1, null);
                    mo7662a(new ConnectionResult(8, (PendingIntent) null));
                    return;
                }
                return;
            case 10:
                this.f4788c.m4653b(1, null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                this.f4788c.m4653b(1, null);
                if (this.f4787b != null) {
                    pendingIntent = (PendingIntent) this.f4787b.getParcelable("pendingIntent");
                }
                mo7662a(new ConnectionResult(this.f4786a, pendingIntent));
                return;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo7665a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7666b() {
    }
}
