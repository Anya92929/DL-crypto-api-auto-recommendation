package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;

/* renamed from: com.google.android.gms.dynamic.b */
class C1389b implements C1395h {

    /* renamed from: a */
    final /* synthetic */ Activity f4760a;

    /* renamed from: b */
    final /* synthetic */ Bundle f4761b;

    /* renamed from: c */
    final /* synthetic */ Bundle f4762c;

    /* renamed from: d */
    final /* synthetic */ zza f4763d;

    C1389b(zza zza, Activity activity, Bundle bundle, Bundle bundle2) {
        this.f4763d = zza;
        this.f4760a = activity;
        this.f4761b = bundle;
        this.f4762c = bundle2;
    }

    /* renamed from: a */
    public int mo6948a() {
        return 0;
    }

    /* renamed from: a */
    public void mo6949a(LifecycleDelegate lifecycleDelegate) {
        this.f4763d.f4777a.onInflate(this.f4760a, this.f4761b, this.f4762c);
    }
}
