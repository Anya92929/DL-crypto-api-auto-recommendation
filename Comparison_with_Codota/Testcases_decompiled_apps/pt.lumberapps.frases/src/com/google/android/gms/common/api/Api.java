package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api {

    /* renamed from: a */
    private final zza f4287a;

    /* renamed from: b */
    private final zzh f4288b = null;

    /* renamed from: c */
    private final zzf f4289c;

    /* renamed from: d */
    private final zzi f4290d;

    /* renamed from: e */
    private final String f4291e;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public abstract class zza extends zzd {
        public abstract zze zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);
    }

    public interface zzb {
    }

    public class zzc {
    }

    public abstract class zzd {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public List zzp(Object obj) {
            return Collections.emptyList();
        }
    }

    public interface zze extends zzb {
        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        boolean isConnecting();

        void zza(zzd.zzf zzf);

        void zza(zzq zzq, Set set);

        boolean zzafk();

        boolean zzafz();

        Intent zzaga();

        boolean zzanu();

        IBinder zzanv();
    }

    public final class zzf extends zzc {
    }

    public interface zzg extends zzb {
        void zza(int i, IInterface iInterface);

        IInterface zzbb(IBinder iBinder);

        String zzqz();

        String zzra();
    }

    public abstract class zzh extends zzd {
        public abstract int zzanw();

        public abstract zzg zzr(Object obj);
    }

    public final class zzi extends zzc {
    }

    public Api(String str, zza zza2, zzf zzf2) {
        zzab.zzb((Object) zza2, (Object) "Cannot construct an Api with a null ClientBuilder");
        zzab.zzb((Object) zzf2, (Object) "Cannot construct an Api with a null ClientKey");
        this.f4291e = str;
        this.f4287a = zza2;
        this.f4289c = zzf2;
        this.f4290d = null;
    }

    public String getName() {
        return this.f4291e;
    }

    public zzd zzanp() {
        if (zzant()) {
            return null;
        }
        return this.f4287a;
    }

    public zza zzanq() {
        zzab.zza(this.f4287a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f4287a;
    }

    public zzh zzanr() {
        zzab.zza(false, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return null;
    }

    public zzc zzans() {
        if (this.f4289c != null) {
            return this.f4289c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public boolean zzant() {
        return false;
    }
}
