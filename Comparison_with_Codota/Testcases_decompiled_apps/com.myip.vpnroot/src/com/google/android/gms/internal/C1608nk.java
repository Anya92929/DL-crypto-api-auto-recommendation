package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.C1598nf;

/* renamed from: com.google.android.gms.internal.nk */
public class C1608nk implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {
    private final C1598nf.C1599a akE;
    private boolean akF = true;
    private C1611nn aku = null;

    public C1608nk(C1598nf.C1599a aVar) {
        this.akE = aVar;
    }

    /* renamed from: R */
    public void mo9528R(boolean z) {
        this.akF = z;
    }

    /* renamed from: a */
    public void mo9529a(C1611nn nnVar) {
        this.aku = nnVar;
    }

    public void onConnected(Bundle connectionHint) {
        this.aku.mo9539S(false);
        if (this.akF && this.akE != null) {
            this.akE.mo9503mS();
        }
        this.akF = false;
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.aku.mo9539S(true);
        if (this.akF && this.akE != null) {
            if (result.hasResolution()) {
                this.akE.mo9502b(result.getResolution());
            } else {
                this.akE.mo9504mT();
            }
        }
        this.akF = false;
    }

    public void onDisconnected() {
        this.aku.mo9539S(true);
    }
}
