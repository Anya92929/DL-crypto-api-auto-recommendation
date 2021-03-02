package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.C1162ff;

@C1130ez
/* renamed from: com.google.android.gms.internal.fg */
public abstract class C1164fg extends C1206gg {

    /* renamed from: pQ */
    private final C1168fi f3522pQ;

    /* renamed from: tu */
    private final C1162ff.C1163a f3523tu;

    @C1130ez
    /* renamed from: com.google.android.gms.internal.fg$a */
    public static final class C1165a extends C1164fg {
        private final Context mContext;

        public C1165a(Context context, C1168fi fiVar, C1162ff.C1163a aVar) {
            super(fiVar, aVar);
            this.mContext = context;
        }

        /* renamed from: cD */
        public void mo8491cD() {
        }

        /* renamed from: cE */
        public C1173fm mo8492cE() {
            Bundle bD = C1201gb.m4562bD();
            return C1184fr.m4494a(this.mContext, new C0951bm(bD.getString("gads:sdk_core_location"), bD.getString("gads:sdk_core_experiment_id"), bD.getString("gads:block_autoclicks_experiment_id")), (C0999ci) new C1000cj(), (C1194fx) new C1195fy());
        }
    }

    @C1130ez
    /* renamed from: com.google.android.gms.internal.fg$b */
    public static final class C1166b extends C1164fg implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {

        /* renamed from: mw */
        private final Object f3524mw = new Object();

        /* renamed from: tu */
        private final C1162ff.C1163a f3525tu;

        /* renamed from: tv */
        private final C1167fh f3526tv;

        public C1166b(Context context, C1168fi fiVar, C1162ff.C1163a aVar) {
            super(fiVar, aVar);
            this.f3525tu = aVar;
            this.f3526tv = new C1167fh(context, this, this, fiVar.f3529lD.f3779wF);
            this.f3526tv.connect();
        }

        /* renamed from: cD */
        public void mo8491cD() {
            synchronized (this.f3524mw) {
                if (this.f3526tv.isConnected() || this.f3526tv.isConnecting()) {
                    this.f3526tv.disconnect();
                }
            }
        }

        /* renamed from: cE */
        public C1173fm mo8492cE() {
            C1173fm fmVar;
            synchronized (this.f3524mw) {
                try {
                    fmVar = this.f3526tv.mo8494cF();
                } catch (IllegalStateException e) {
                    fmVar = null;
                }
            }
            return fmVar;
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.f3525tu.mo8468a(new C1171fk(0));
        }

        public void onDisconnected() {
            C1229gs.m4675S("Disconnected from remote ad request service.");
        }
    }

    public C1164fg(C1168fi fiVar, C1162ff.C1163a aVar) {
        this.f3522pQ = fiVar;
        this.f3523tu = aVar;
    }

    /* renamed from: a */
    private static C1171fk m4446a(C1173fm fmVar, C1168fi fiVar) {
        try {
            return fmVar.mo8507b(fiVar);
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not fetch ad response from ad request service.", e);
            return null;
        } catch (NullPointerException e2) {
            C1229gs.m4683d("Could not fetch ad response from ad request service due to an Exception.", e2);
            return null;
        } catch (SecurityException e3) {
            C1229gs.m4683d("Could not fetch ad response from ad request service due to an Exception.", e3);
            return null;
        } catch (Throwable th) {
            C1201gb.m4570e(th);
            return null;
        }
    }

    /* renamed from: cD */
    public abstract void mo8491cD();

    /* renamed from: cE */
    public abstract C1173fm mo8492cE();

    /* JADX INFO: finally extract failed */
    /* renamed from: cp */
    public final void mo8384cp() {
        C1171fk a;
        try {
            C1173fm cE = mo8492cE();
            if (cE == null) {
                a = new C1171fk(0);
            } else {
                a = m4446a(cE, this.f3522pQ);
                if (a == null) {
                    a = new C1171fk(0);
                }
            }
            mo8491cD();
            this.f3523tu.mo8468a(a);
        } catch (Throwable th) {
            mo8491cD();
            throw th;
        }
    }

    public final void onStop() {
        mo8491cD();
    }
}
