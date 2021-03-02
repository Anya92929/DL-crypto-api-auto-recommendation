package com.google.android.gms.internal;

import com.google.android.gms.auth.api.signin.internal.zzk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.pb */
class C1815pb implements ResultCallback {

    /* renamed from: a */
    final /* synthetic */ zzqu f5469a;

    /* renamed from: b */
    final /* synthetic */ boolean f5470b;

    /* renamed from: c */
    final /* synthetic */ GoogleApiClient f5471c;

    /* renamed from: d */
    final /* synthetic */ zzpy f5472d;

    C1815pb(zzpy zzpy, zzqu zzqu, boolean z, GoogleApiClient googleApiClient) {
        this.f5472d = zzpy;
        this.f5469a = zzqu;
        this.f5470b = z;
        this.f5471c = googleApiClient;
    }

    /* renamed from: a */
    public void onResult(Status status) {
        zzk.zzbc(this.f5472d.f6850n).zzagl();
        if (status.isSuccess() && this.f5472d.isConnected()) {
            this.f5472d.reconnect();
        }
        this.f5469a.zzc((Result) status);
        if (this.f5470b) {
            this.f5471c.disconnect();
        }
    }
}
