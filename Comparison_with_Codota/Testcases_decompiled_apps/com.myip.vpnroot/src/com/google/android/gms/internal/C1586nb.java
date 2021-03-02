package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C1579mz;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;

/* renamed from: com.google.android.gms.internal.nb */
public class C1586nb implements PanoramaApi {

    /* renamed from: com.google.android.gms.internal.nb$1 */
    class C15871 extends C1594d<PanoramaApi.C1928a> {
        final /* synthetic */ Uri akn;
        final /* synthetic */ Bundle ako;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo9496a(Context context, C1583na naVar) throws RemoteException {
            C1586nb.m5657a(context, naVar, new C1591a(this), this.akn, this.ako);
        }

        /* access modifiers changed from: protected */
        /* renamed from: ay */
        public PanoramaApi.C1928a mo3773c(Status status) {
            return new C1578my(status, (Intent) null, 0);
        }
    }

    /* renamed from: com.google.android.gms.internal.nb$a */
    private static final class C1591a extends C1579mz.C1580a {

        /* renamed from: De */
        private final BaseImplementation.C0270b<PanoramaApi.C1928a> f4299De;

        public C1591a(BaseImplementation.C0270b<PanoramaApi.C1928a> bVar) {
            this.f4299De = bVar;
        }

        /* renamed from: a */
        public void mo9483a(int i, Bundle bundle, int i2, Intent intent) {
            this.f4299De.mo4196b(new C1578my(new Status(i, (String) null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent, i2));
        }
    }

    /* renamed from: com.google.android.gms.internal.nb$b */
    private static abstract class C1592b extends C1594d<PanoramaApi.PanoramaResult> {
        private C1592b() {
        }

        /* synthetic */ C1592b(C15871 r1) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: az */
        public PanoramaApi.PanoramaResult mo3773c(Status status) {
            return new C1596nd(status, (Intent) null);
        }
    }

    /* renamed from: com.google.android.gms.internal.nb$c */
    private static final class C1593c extends C1579mz.C1580a {

        /* renamed from: De */
        private final BaseImplementation.C0270b<PanoramaApi.PanoramaResult> f4300De;

        public C1593c(BaseImplementation.C0270b<PanoramaApi.PanoramaResult> bVar) {
            this.f4300De = bVar;
        }

        /* renamed from: a */
        public void mo9483a(int i, Bundle bundle, int i2, Intent intent) {
            this.f4300De.mo4196b(new C1596nd(new Status(i, (String) null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    /* renamed from: com.google.android.gms.internal.nb$d */
    private static abstract class C1594d<R extends Result> extends BaseImplementation.C0269a<R, C1595nc> {
        protected C1594d() {
            super(Panorama.f4494CU);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo9496a(Context context, C1583na naVar) throws RemoteException;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo3769a(C1595nc ncVar) throws RemoteException {
            mo9496a(ncVar.getContext(), (C1583na) ncVar.mo4435gS());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m5656a(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m5657a(final Context context, C1583na naVar, final C1579mz mzVar, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        try {
            naVar.mo9491a(new C1579mz.C1580a() {
                /* renamed from: a */
                public void mo9483a(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                    C1586nb.m5656a(context, uri);
                    mzVar.mo9483a(i, bundle, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            m5656a(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            m5656a(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.mo4219a(new C1592b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo9496a(Context context, C1583na naVar) throws RemoteException {
                naVar.mo9491a(new C1593c(this), uri, (Bundle) null, false);
            }
        });
    }

    public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.mo4219a(new C1592b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo9496a(Context context, C1583na naVar) throws RemoteException {
                C1586nb.m5657a(context, naVar, new C1593c(this), uri, (Bundle) null);
            }
        });
    }
}
