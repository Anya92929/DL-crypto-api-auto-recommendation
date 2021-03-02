package com.google.android.gms.internal;

import android.app.Dialog;
import com.google.android.gms.internal.zzqe;

/* renamed from: com.google.android.gms.internal.of */
class C1792of extends zzqe.zza {

    /* renamed from: a */
    final /* synthetic */ Dialog f5422a;

    /* renamed from: b */
    final /* synthetic */ C1791oe f5423b;

    C1792of(C1791oe oeVar, Dialog dialog) {
        this.f5423b = oeVar;
        this.f5422a = dialog;
    }

    public void zzaou() {
        this.f5423b.f5421a.mo8919b();
        if (this.f5422a.isShowing()) {
            this.f5422a.dismiss();
        }
    }
}
