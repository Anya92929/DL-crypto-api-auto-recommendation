package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.p009v4.app.Fragment;

/* renamed from: com.google.android.gms.common.internal.r */
final class C1379r extends zzi {

    /* renamed from: a */
    final /* synthetic */ Intent f4499a;

    /* renamed from: b */
    final /* synthetic */ Fragment f4500b;

    /* renamed from: c */
    final /* synthetic */ int f4501c;

    C1379r(Intent intent, Fragment fragment, int i) {
        this.f4499a = intent;
        this.f4500b = fragment;
        this.f4501c = i;
    }

    public void zzasr() {
        if (this.f4499a != null) {
            this.f4500b.startActivityForResult(this.f4499a, this.f4501c);
        }
    }
}
