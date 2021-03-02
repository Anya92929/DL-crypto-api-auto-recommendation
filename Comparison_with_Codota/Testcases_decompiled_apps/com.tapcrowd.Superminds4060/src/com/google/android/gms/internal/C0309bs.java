package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.C0307br;

/* renamed from: com.google.android.gms.internal.bs */
public abstract class C0309bs extends C0332cg {

    /* renamed from: eI */
    private final C0313bu f905eI;

    /* renamed from: gx */
    private final C0307br.C0308a f906gx;

    /* renamed from: com.google.android.gms.internal.bs$a */
    public static final class C0310a extends C0309bs {
        private final Context mContext;

        public C0310a(Context context, C0313bu buVar, C0307br.C0308a aVar) {
            super(buVar, aVar);
            this.mContext = context;
        }

        /* renamed from: ae */
        public void mo4161ae() {
        }

        /* renamed from: af */
        public C0318by mo4162af() {
            return C0321bz.m655a(this.mContext, new C0225am());
        }
    }

    /* renamed from: com.google.android.gms.internal.bs$b */
    public static final class C0311b extends C0309bs implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {

        /* renamed from: eJ */
        private final Object f907eJ = new Object();

        /* renamed from: gx */
        private final C0307br.C0308a f908gx;

        /* renamed from: gy */
        private final C0312bt f909gy;

        public C0311b(Context context, C0313bu buVar, C0307br.C0308a aVar) {
            super(buVar, aVar);
            this.f908gx = aVar;
            this.f909gy = new C0312bt(context, this, this, buVar.f912eg.f1016hR);
            this.f909gy.connect();
        }

        /* renamed from: ae */
        public void mo4161ae() {
            synchronized (this.f907eJ) {
                if (this.f909gy.isConnected() || this.f909gy.isConnecting()) {
                    this.f909gy.disconnect();
                }
            }
        }

        /* renamed from: af */
        public C0318by mo4162af() {
            C0318by byVar;
            synchronized (this.f907eJ) {
                try {
                    byVar = this.f909gy.mo4166ai();
                } catch (IllegalStateException e) {
                    byVar = null;
                }
            }
            return byVar;
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.f908gx.mo4154a(new C0316bw(0));
        }

        public void onDisconnected() {
            C0344cn.m733m("Disconnected from remote ad request service.");
        }
    }

    public C0309bs(C0313bu buVar, C0307br.C0308a aVar) {
        this.f905eI = buVar;
        this.f906gx = aVar;
    }

    /* renamed from: a */
    private static C0316bw m630a(C0318by byVar, C0313bu buVar) {
        try {
            return byVar.mo4181a(buVar);
        } catch (RemoteException e) {
            C0344cn.m731b("Could not fetch ad response from ad request service.", e);
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: ac */
    public final void mo4155ac() {
        C0316bw a;
        try {
            C0318by af = mo4162af();
            if (af == null) {
                a = new C0316bw(0);
            } else {
                a = m630a(af, this.f905eI);
                if (a == null) {
                    a = new C0316bw(0);
                }
            }
            mo4161ae();
            this.f906gx.mo4154a(a);
        } catch (Throwable th) {
            mo4161ae();
            throw th;
        }
    }

    /* renamed from: ae */
    public abstract void mo4161ae();

    /* renamed from: af */
    public abstract C0318by mo4162af();

    public final void onStop() {
        mo4161ae();
    }
}
