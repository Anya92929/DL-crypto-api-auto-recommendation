package p000;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzmf;
import com.google.android.gms.internal.zzmj;

/* renamed from: hf */
public abstract class C1200hf<R extends Result> extends zza.C2020zza<R, zzmj> {

    /* renamed from: hf$a */
    public static abstract class C1201a extends C1200hf<Status> {
        public C1201a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: a */
        public Status zzc(Status status) {
            return status;
        }
    }

    public C1200hf(GoogleApiClient googleApiClient) {
        super(zzmf.zzUI, googleApiClient);
    }
}
