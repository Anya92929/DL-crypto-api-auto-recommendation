package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqu;

public final class PendingResults {
    private PendingResults() {
    }

    public static PendingResult canceledPendingResult() {
        zzqu zzqu = new zzqu(Looper.getMainLooper());
        zzqu.cancel();
        return zzqu;
    }

    public static PendingResult canceledPendingResult(Result result) {
        zzab.zzb((Object) result, (Object) "Result must not be null");
        zzab.zzb(result.getStatus().getStatusCode() == 16, (Object) "Status code must be CommonStatusCodes.CANCELED");
        C1340b bVar = new C1340b(result);
        bVar.cancel();
        return bVar;
    }

    public static OptionalPendingResult immediatePendingResult(Result result) {
        zzab.zzb((Object) result, (Object) "Result must not be null");
        C1342d dVar = new C1342d((GoogleApiClient) null);
        dVar.zzc(result);
        return new zzqq(dVar);
    }

    public static PendingResult immediatePendingResult(Status status) {
        zzab.zzb((Object) status, (Object) "Result must not be null");
        zzqu zzqu = new zzqu(Looper.getMainLooper());
        zzqu.zzc((Result) status);
        return zzqu;
    }

    public static PendingResult zza(Result result, GoogleApiClient googleApiClient) {
        zzab.zzb((Object) result, (Object) "Result must not be null");
        zzab.zzb(!result.getStatus().isSuccess(), (Object) "Status code must not be SUCCESS");
        C1341c cVar = new C1341c(googleApiClient, result);
        cVar.zzc(result);
        return cVar;
    }

    public static PendingResult zza(Status status, GoogleApiClient googleApiClient) {
        zzab.zzb((Object) status, (Object) "Result must not be null");
        zzqu zzqu = new zzqu(googleApiClient);
        zzqu.zzc((Result) status);
        return zzqu;
    }

    public static OptionalPendingResult zzb(Result result, GoogleApiClient googleApiClient) {
        zzab.zzb((Object) result, (Object) "Result must not be null");
        C1342d dVar = new C1342d(googleApiClient);
        dVar.zzc(result);
        return new zzqq(dVar);
    }
}
