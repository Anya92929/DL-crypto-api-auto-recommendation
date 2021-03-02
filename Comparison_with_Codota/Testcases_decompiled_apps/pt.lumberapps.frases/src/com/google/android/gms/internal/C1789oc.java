package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: com.google.android.gms.internal.oc */
class C1789oc implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a */
    public final int f5417a;

    /* renamed from: b */
    public final GoogleApiClient f5418b;

    /* renamed from: c */
    public final GoogleApiClient.OnConnectionFailedListener f5419c;

    /* renamed from: d */
    final /* synthetic */ zzpk f5420d;

    public C1789oc(zzpk zzpk, int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f5420d = zzpk;
        this.f5417a = i;
        this.f5418b = googleApiClient;
        this.f5419c = onConnectionFailedListener;
        googleApiClient.registerConnectionFailedListener(this);
    }

    /* renamed from: a */
    public void mo7600a() {
        this.f5418b.unregisterConnectionFailedListener(this);
        this.f5418b.disconnect();
    }

    /* renamed from: a */
    public void mo7601a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("GoogleApiClient #").print(this.f5417a);
        printWriter.println(":");
        this.f5418b.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        String valueOf = String.valueOf(connectionResult);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
        this.f5420d.zzb(connectionResult, this.f5417a);
    }
}
