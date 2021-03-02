package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions> {

    /* renamed from: a */
    private final zza<?, O> f2606a;

    /* renamed from: b */
    private final zze<?, O> f2607b = null;

    /* renamed from: c */
    private final zzc<?> f2608c;

    /* renamed from: d */
    private final zzf<?> f2609d;

    /* renamed from: e */
    private final String f2610e;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public static abstract class zza<T extends zzb, O> {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public abstract T zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);

        public List<Scope> zzo(O o) {
            return Collections.emptyList();
        }
    }

    public interface zzb {
        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        void zza(GoogleApiClient.zza zza);

        void zza(zzp zzp, Set<Scope> set);

        boolean zzmE();

        boolean zznb();

        Intent zznc();

        IBinder zzoT();
    }

    public static final class zzc<C extends zzb> {
    }

    public interface zzd<T extends IInterface> {
        T zzW(IBinder iBinder);

        void zza(int i, T t);

        String zzgu();

        String zzgv();
    }

    public interface zze<T extends zzd, O> {
        int getPriority();

        int zzoU();

        T zzq(O o);
    }

    public static final class zzf<C extends zzd> {
    }

    public <C extends zzb> Api(String str, zza<C, O> zza2, zzc<C> zzc2) {
        zzx.zzb(zza2, (Object) "Cannot construct an Api with a null ClientBuilder");
        zzx.zzb(zzc2, (Object) "Cannot construct an Api with a null ClientKey");
        this.f2610e = str;
        this.f2606a = zza2;
        this.f2608c = zzc2;
        this.f2609d = null;
    }

    public String getName() {
        return this.f2610e;
    }

    public zza<?, O> zzoP() {
        zzx.zza(this.f2606a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f2606a;
    }

    public zze<?, O> zzoQ() {
        zzx.zza(this.f2607b != null, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return this.f2607b;
    }

    public zzc<?> zzoR() {
        zzx.zza(this.f2608c != null, (Object) "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.f2608c;
    }

    public boolean zzoS() {
        return this.f2609d != null;
    }
}
