package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* renamed from: com.google.android.gms.common.internal.q */
final class C1378q extends zzi {

    /* renamed from: a */
    final /* synthetic */ Intent f4496a;

    /* renamed from: b */
    final /* synthetic */ Activity f4497b;

    /* renamed from: c */
    final /* synthetic */ int f4498c;

    C1378q(Intent intent, Activity activity, int i) {
        this.f4496a = intent;
        this.f4497b = activity;
        this.f4498c = i;
    }

    public void zzasr() {
        if (this.f4496a != null) {
            this.f4497b.startActivityForResult(this.f4496a, this.f4498c);
        }
    }
}
