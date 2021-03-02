package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C1276hu;
import java.util.List;

/* renamed from: com.google.android.gms.internal.hz */
public final class C1286hz implements AppIndexApi, C1276hu {

    /* renamed from: com.google.android.gms.internal.hz$1 */
    class C12871 extends C1292c<C1276hu.C1277a> {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo8791a(C1278hv hvVar) throws RemoteException {
            hvVar.mo8775a(new C1284hx<C1276hu.C1277a>(this) {
                /* renamed from: a */
                public void mo8782a(Status status, ParcelFileDescriptor parcelFileDescriptor) {
                    this.f3888CH.mo4196b(new C1291b(status, parcelFileDescriptor));
                }
            });
        }

        /* renamed from: b */
        public C1276hu.C1277a mo3773c(Status status) {
            return new C1291b(status, (ParcelFileDescriptor) null);
        }
    }

    /* renamed from: com.google.android.gms.internal.hz$a */
    private static abstract class C1290a<T> implements Result {

        /* renamed from: CM */
        private final Status f3893CM;

        /* renamed from: CN */
        protected final T f3894CN;

        public C1290a(Status status, T t) {
            this.f3893CM = status;
            this.f3894CN = t;
        }

        public Status getStatus() {
            return this.f3893CM;
        }
    }

    /* renamed from: com.google.android.gms.internal.hz$b */
    static class C1291b extends C1290a<ParcelFileDescriptor> implements C1276hu.C1277a {
        public C1291b(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            super(status, parcelFileDescriptor);
        }
    }

    /* renamed from: com.google.android.gms.internal.hz$c */
    private static abstract class C1292c<T extends Result> extends BaseImplementation.C0269a<T, C1285hy> {
        public C1292c() {
            super(C1254hd.f3831BN);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo8791a(C1278hv hvVar) throws RemoteException;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo3769a(C1285hy hyVar) throws RemoteException {
            mo8791a(hyVar.mo8789fo());
        }
    }

    /* renamed from: com.google.android.gms.internal.hz$d */
    private static abstract class C1293d<T extends Result> extends C1292c<Status> {
        private C1293d() {
        }

        /* synthetic */ C1293d(C12871 r1) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.hz$e */
    private static final class C1294e extends C1284hx<Status> {
        public C1294e(BaseImplementation.C0270b<Status> bVar) {
            super(bVar);
        }

        /* renamed from: a */
        public void mo8781a(Status status) {
            this.f3888CH.mo4196b(status);
        }
    }

    /* renamed from: a */
    public static Uri m4833a(String str, Uri uri) {
        if (!"android-app".equals(uri.getScheme())) {
            throw new IllegalArgumentException("Uri scheme must be android-app: " + uri);
        } else if (!str.equals(uri.getHost())) {
            throw new IllegalArgumentException("Uri host must match package name: " + uri);
        } else {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.isEmpty() || pathSegments.get(0).isEmpty()) {
                throw new IllegalArgumentException("Uri path must exist: " + uri);
            }
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(pathSegments.get(0));
            if (pathSegments.size() > 1) {
                builder.authority(pathSegments.get(1));
                int i = 2;
                while (true) {
                    int i2 = i;
                    if (i2 >= pathSegments.size()) {
                        break;
                    }
                    builder.appendPath(pathSegments.get(i2));
                    i = i2 + 1;
                }
            }
            builder.encodedQuery(uri.getEncodedQuery());
            builder.encodedFragment(uri.getEncodedFragment());
            return builder.build();
        }
    }

    /* renamed from: a */
    public PendingResult<Status> mo8790a(GoogleApiClient googleApiClient, final C1274hs... hsVarArr) {
        final String packageName = ((C1285hy) googleApiClient.mo4218a(C1254hd.f3831BN)).getContext().getPackageName();
        return googleApiClient.mo4219a(new C1293d<Status>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo8791a(C1278hv hvVar) throws RemoteException {
                hvVar.mo8776a(new C1294e(this), packageName, hsVarArr);
            }
        });
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Intent viewIntent, String title, Uri webUrl, List<AppIndexApi.AppIndexingLink> outLinks) {
        return mo8790a(apiClient, new C1274hs(((C1285hy) apiClient.mo4218a(C1254hd.f3831BN)).getContext().getPackageName(), viewIntent, title, webUrl, (String) null, outLinks));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl, String title, Uri webUrl, List<AppIndexApi.AppIndexingLink> outLinks) {
        return view(apiClient, activity, new Intent("android.intent.action.VIEW", m4833a(((C1285hy) apiClient.mo4218a(C1254hd.f3831BN)).getContext().getPackageName(), appIndexingUrl)), title, webUrl, outLinks);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Intent viewIntent) {
        return mo8790a(apiClient, new C1274hs(C1274hs.m4795a(((C1285hy) apiClient.mo4218a(C1254hd.f3831BN)).getContext().getPackageName(), viewIntent), System.currentTimeMillis(), 3));
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl) {
        return viewEnd(apiClient, activity, new Intent("android.intent.action.VIEW", m4833a(((C1285hy) apiClient.mo4218a(C1254hd.f3831BN)).getContext().getPackageName(), appIndexingUrl)));
    }
}
