package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.zzb;
import com.google.android.gms.common.api.internal.zzr;
import com.google.android.gms.common.api.internal.zzv;
import com.google.android.gms.common.internal.zzx;

public final class PendingResults {

    /* renamed from: com.google.android.gms.common.api.PendingResults$a */
    static final class C0683a<R extends Result> extends zzb<R> {

        /* renamed from: a */
        private final R f2644a;

        public C0683a(R r) {
            super(Looper.getMainLooper());
            this.f2644a = r;
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            if (status.getStatusCode() == this.f2644a.getStatus().getStatusCode()) {
                return this.f2644a;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    /* renamed from: com.google.android.gms.common.api.PendingResults$b */
    static final class C0684b<R extends Result> extends zzb<R> {

        /* renamed from: a */
        private final R f2645a;

        public C0684b(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.f2645a = r;
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            return this.f2645a;
        }
    }

    /* renamed from: com.google.android.gms.common.api.PendingResults$c */
    static final class C0685c<R extends Result> extends zzb<R> {
        public C0685c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        zzv zzv = new zzv(Looper.getMainLooper());
        zzv.cancel();
        return zzv;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        zzx.zzb(r, (Object) "Result must not be null");
        zzx.zzb(r.getStatus().getStatusCode() == 16, (Object) "Status code must be CommonStatusCodes.CANCELED");
        C0683a aVar = new C0683a(r);
        aVar.cancel();
        return aVar;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        zzx.zzb(r, (Object) "Result must not be null");
        C0685c cVar = new C0685c((GoogleApiClient) null);
        cVar.zza(r);
        return new zzr(cVar);
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        zzx.zzb(status, (Object) "Result must not be null");
        zzv zzv = new zzv(Looper.getMainLooper());
        zzv.zza(status);
        return zzv;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzx.zzb(r, (Object) "Result must not be null");
        zzx.zzb(!r.getStatus().isSuccess(), (Object) "Status code must not be SUCCESS");
        C0684b bVar = new C0684b(googleApiClient, r);
        bVar.zza(r);
        return bVar;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzx.zzb(status, (Object) "Result must not be null");
        zzv zzv = new zzv(googleApiClient);
        zzv.zza(status);
        return zzv;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzx.zzb(r, (Object) "Result must not be null");
        C0685c cVar = new C0685c(googleApiClient);
        cVar.zza(r);
        return new zzr(cVar);
    }
}
