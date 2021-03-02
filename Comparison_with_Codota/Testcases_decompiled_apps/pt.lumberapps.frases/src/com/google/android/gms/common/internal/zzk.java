package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzl;
import java.util.Set;

public abstract class zzk extends zzd implements Api.zze, zzl.zza {

    /* renamed from: a */
    private final zzg f4585a;

    /* renamed from: d */
    private final Set f4586d;

    /* renamed from: e */
    private final Account f4587e;

    protected zzk(Context context, Looper looper, int i, zzg zzg, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzm.zzce(context), GoogleApiAvailability.getInstance(), i, zzg, (GoogleApiClient.ConnectionCallbacks) zzab.zzy(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) zzab.zzy(onConnectionFailedListener));
    }

    protected zzk(Context context, Looper looper, zzm zzm, GoogleApiAvailability googleApiAvailability, int i, zzg zzg, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, zzm, googleApiAvailability, i, m6115a(connectionCallbacks), m6116a(onConnectionFailedListener), zzg.zzasn());
        this.f4585a = zzg;
        this.f4587e = zzg.getAccount();
        this.f4586d = m6117b(zzg.zzask());
    }

    /* renamed from: a */
    private static zzd.zzb m6115a(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        if (connectionCallbacks == null) {
            return null;
        }
        return new C1381t(connectionCallbacks);
    }

    /* renamed from: a */
    private static zzd.zzc m6116a(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (onConnectionFailedListener == null) {
            return null;
        }
        return new C1382u(onConnectionFailedListener);
    }

    /* renamed from: b */
    private Set m6117b(Set set) {
        Set<Scope> a = mo6720a(set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Set mo6720a(Set set) {
        return set;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final Set mo6675f() {
        return this.f4586d;
    }

    public final Account getAccount() {
        return this.f4587e;
    }
}
