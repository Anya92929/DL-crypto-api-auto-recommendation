package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;

@C1130ez
/* renamed from: com.google.android.gms.internal.cf */
public final class C0992cf {

    /* renamed from: com.google.android.gms.internal.cf$a */
    public static final class C0993a implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {

        /* renamed from: mw */
        private final Object f3014mw;

        /* renamed from: pN */
        private final C0994b f3015pN;

        /* renamed from: pO */
        private final C0995cg f3016pO;

        public C0993a(Context context, C0994b bVar) {
            this(context, bVar, false);
        }

        C0993a(Context context, C0994b bVar, boolean z) {
            this.f3014mw = new Object();
            this.f3015pN = bVar;
            this.f3016pO = new C0995cg(context, this, this, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (!z) {
                this.f3016pO.connect();
            }
        }

        public void onConnected(Bundle connectionHint) {
            Bundle bundle;
            Bundle bs = C0952bn.m3999bs();
            synchronized (this.f3014mw) {
                try {
                    C0996ch bC = this.f3016pO.mo8208bC();
                    bundle = bC != null ? bC.mo8210bD() : bs;
                    if (this.f3016pO.isConnected() || this.f3016pO.isConnecting()) {
                        this.f3016pO.disconnect();
                    }
                } catch (IllegalStateException e) {
                    C1229gs.m4683d("Error when get Gservice values", e);
                    if (this.f3016pO.isConnected() || this.f3016pO.isConnecting()) {
                        this.f3016pO.disconnect();
                        bundle = bs;
                    }
                    bundle = bs;
                } catch (RemoteException e2) {
                    C1229gs.m4683d("Error when get Gservice values", e2);
                    if (this.f3016pO.isConnected() || this.f3016pO.isConnecting()) {
                        this.f3016pO.disconnect();
                        bundle = bs;
                    }
                    bundle = bs;
                } catch (Throwable th) {
                    if (this.f3016pO.isConnected() || this.f3016pO.isConnecting()) {
                        this.f3016pO.disconnect();
                    }
                    throw th;
                }
            }
            this.f3015pN.mo8207a(bundle);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.f3015pN.mo8207a(C0952bn.m3999bs());
        }

        public void onDisconnected() {
            C1229gs.m4675S("Disconnected from remote ad request service.");
        }
    }

    /* renamed from: com.google.android.gms.internal.cf$b */
    public interface C0994b {
        /* renamed from: a */
        void mo8207a(Bundle bundle);
    }

    /* renamed from: a */
    public static void m4116a(Context context, C0994b bVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0) {
            bVar.mo8207a(C0952bn.m3999bs());
        } else {
            new C0993a(context, bVar);
        }
    }
}
