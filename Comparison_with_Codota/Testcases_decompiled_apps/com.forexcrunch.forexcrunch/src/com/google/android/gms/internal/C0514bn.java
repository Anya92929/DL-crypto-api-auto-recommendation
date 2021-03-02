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
import com.google.android.gms.internal.C0508bl;
import com.google.android.gms.internal.C0511bm;
import com.google.android.gms.internal.C0597k;
import com.google.android.gms.panorama.PanoramaClient;

/* renamed from: com.google.android.gms.internal.bn */
public class C0514bn extends C0597k<C0511bm> {

    /* renamed from: com.google.android.gms.internal.bn$a */
    final class C0515a extends C0597k<C0511bm>.b<PanoramaClient.C0745a> {

        /* renamed from: hO */
        public final ConnectionResult f1140hO;

        /* renamed from: hP */
        public final Intent f1141hP;
        public final int type;

        public C0515a(PanoramaClient.C0745a aVar, ConnectionResult connectionResult, int i, Intent intent) {
            super(aVar);
            this.f1140hO = connectionResult;
            this.type = i;
            this.f1141hP = intent;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4646a(PanoramaClient.C0745a aVar) {
            if (aVar != null) {
                aVar.mo6307a(this.f1140hO, this.type, this.f1141hP);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    /* renamed from: com.google.android.gms.internal.bn$b */
    final class C0516b extends C0508bl.C0509a {

        /* renamed from: hR */
        private final PanoramaClient.C0745a f1144hR = null;

        /* renamed from: hS */
        private final PanoramaClient.OnPanoramaInfoLoadedListener f1145hS;

        /* renamed from: hT */
        private final Uri f1146hT;

        public C0516b(PanoramaClient.OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, Uri uri) {
            this.f1145hS = onPanoramaInfoLoadedListener;
            this.f1146hT = uri;
        }

        /* renamed from: a */
        public void mo4834a(int i, Bundle bundle, int i2, Intent intent) {
            if (this.f1146hT != null) {
                C0514bn.this.getContext().revokeUriPermission(this.f1146hT, 1);
            }
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (this.f1144hR != null) {
                C0514bn.this.mo5431a((C0597k<T>.b<?>) new C0515a(this.f1144hR, connectionResult, i2, intent));
            } else {
                C0514bn.this.mo5431a((C0597k<T>.b<?>) new C0517c(this.f1145hS, connectionResult, intent));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bn$c */
    final class C0517c extends C0597k<C0511bm>.b<PanoramaClient.OnPanoramaInfoLoadedListener> {

        /* renamed from: hO */
        private final ConnectionResult f1147hO;

        /* renamed from: hP */
        private final Intent f1148hP;

        public C0517c(PanoramaClient.OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, ConnectionResult connectionResult, Intent intent) {
            super(onPanoramaInfoLoadedListener);
            this.f1147hO = connectionResult;
            this.f1148hP = intent;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4646a(PanoramaClient.OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener) {
            if (onPanoramaInfoLoadedListener != null) {
                onPanoramaInfoLoadedListener.onPanoramaInfoLoaded(this.f1147hO, this.f1148hP);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    public C0514bn(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, connectionCallbacks, onConnectionFailedListener, (String[]) null);
    }

    /* renamed from: X */
    public C0511bm mo4600c(IBinder iBinder) {
        return C0511bm.C0512a.m1367W(iBinder);
    }

    /* renamed from: a */
    public void mo4842a(C0516b bVar, Uri uri, Bundle bundle, boolean z) {
        mo5429B();
        if (z) {
            getContext().grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        }
        try {
            ((C0511bm) mo5430C()).mo4838a(bVar, uri, bundle, z);
        } catch (RemoteException e) {
            bVar.mo4834a(8, (Bundle) null, 0, (Intent) null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4595a(C0612p pVar, C0597k.C0601d dVar) throws RemoteException {
        pVar.mo5470a(dVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    /* renamed from: a */
    public void mo4843a(PanoramaClient.OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, Uri uri, boolean z) {
        mo4842a(new C0516b(onPanoramaInfoLoadedListener, z ? uri : null), uri, (Bundle) null, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo4598b() {
        return "com.google.android.gms.panorama.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo4601c() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }
}
