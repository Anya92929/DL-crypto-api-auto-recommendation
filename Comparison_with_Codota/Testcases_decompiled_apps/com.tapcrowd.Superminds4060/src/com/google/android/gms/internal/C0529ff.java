package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0387de;
import com.google.android.gms.internal.C0523fd;
import com.google.android.gms.internal.C0526fe;
import com.google.android.gms.panorama.PanoramaClient;

/* renamed from: com.google.android.gms.internal.ff */
public class C0529ff extends C0387de<C0526fe> {

    /* renamed from: com.google.android.gms.internal.ff$a */
    final class C0530a extends C0387de<C0526fe>.b<PanoramaClient.C0745a> {

        /* renamed from: qV */
        public final ConnectionResult f1320qV;

        /* renamed from: qW */
        public final Intent f1321qW;
        public final int type;

        public C0530a(PanoramaClient.C0745a aVar, ConnectionResult connectionResult, int i, Intent intent) {
            super(aVar);
            this.f1320qV = connectionResult;
            this.type = i;
            this.f1321qW = intent;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4270a(PanoramaClient.C0745a aVar) {
            if (aVar != null) {
                aVar.mo6148a(this.f1320qV, this.type, this.f1321qW);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.ff$b */
    final class C0531b extends C0523fd.C0524a {

        /* renamed from: qY */
        private final PanoramaClient.C0745a f1324qY = null;

        /* renamed from: qZ */
        private final PanoramaClient.OnPanoramaInfoLoadedListener f1325qZ;

        /* renamed from: ra */
        private final Uri f1326ra;

        public C0531b(PanoramaClient.OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, Uri uri) {
            this.f1325qZ = onPanoramaInfoLoadedListener;
            this.f1326ra = uri;
        }

        /* renamed from: a */
        public void mo4782a(int i, Bundle bundle, int i2, Intent intent) {
            if (this.f1326ra != null) {
                C0529ff.this.getContext().revokeUriPermission(this.f1326ra, 1);
            }
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (this.f1324qY != null) {
                C0529ff.this.mo4326a((C0387de<T>.b<?>) new C0530a(this.f1324qY, connectionResult, i2, intent));
            } else {
                C0529ff.this.mo4326a((C0387de<T>.b<?>) new C0532c(this.f1325qZ, connectionResult, intent));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ff$c */
    final class C0532c extends C0387de<C0526fe>.b<PanoramaClient.OnPanoramaInfoLoadedListener> {

        /* renamed from: qV */
        private final ConnectionResult f1327qV;

        /* renamed from: qW */
        private final Intent f1328qW;

        public C0532c(PanoramaClient.OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, ConnectionResult connectionResult, Intent intent) {
            super(onPanoramaInfoLoadedListener);
            this.f1327qV = connectionResult;
            this.f1328qW = intent;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4270a(PanoramaClient.OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener) {
            if (onPanoramaInfoLoadedListener != null) {
                onPanoramaInfoLoadedListener.onPanoramaInfoLoaded(this.f1327qV, this.f1328qW);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    public C0529ff(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, connectionCallbacks, onConnectionFailedListener, (String[]) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4163a(C0402dj djVar, C0387de.C0391d dVar) throws RemoteException {
        djVar.mo4370a(dVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    /* renamed from: a */
    public void mo4789a(C0531b bVar, Uri uri, Bundle bundle, boolean z) {
        mo4331bc();
        if (z) {
            getContext().grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        }
        try {
            ((C0526fe) mo4332bd()).mo4786a(bVar, uri, bundle, z);
        } catch (RemoteException e) {
            bVar.mo4782a(8, (Bundle) null, 0, (Intent) null);
        }
    }

    /* renamed from: a */
    public void mo4790a(PanoramaClient.OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, Uri uri, boolean z) {
        mo4789a(new C0531b(onPanoramaInfoLoadedListener, z ? uri : null), uri, (Bundle) null, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ag */
    public String mo4164ag() {
        return "com.google.android.gms.panorama.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ah */
    public String mo4165ah() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    /* renamed from: am */
    public C0526fe mo4168p(IBinder iBinder) {
        return C0526fe.C0527a.m1561al(iBinder);
    }
}
