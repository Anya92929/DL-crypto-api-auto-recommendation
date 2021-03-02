package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicReference;

public class zza {

    /* renamed from: com.google.android.gms.common.api.internal.zza$zza  reason: collision with other inner class name */
    public static abstract class C2020zza<R extends Result, A extends Api.zzb> extends zzb<R> implements zzb<R>, zzj.C0711e<A> {

        /* renamed from: a */
        private final Api.zzc<A> f2656a;

        /* renamed from: b */
        private AtomicReference<zzj.C0710d> f2657b = new AtomicReference<>();

        public C2020zza(Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) zzx.zzb(googleApiClient, (Object) "GoogleApiClient must not be null"));
            this.f2656a = (Api.zzc) zzx.zzz(zzc);
        }

        /* renamed from: a */
        private void m3714a(RemoteException remoteException) {
            zzw(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        public abstract void zza(A a) throws RemoteException;

        public void zza(zzj.C0710d dVar) {
            this.f2657b.set(dVar);
        }

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza(a);
            } catch (DeadObjectException e) {
                m3714a(e);
                throw e;
            } catch (RemoteException e2) {
                m3714a(e2);
            }
        }

        public final Api.zzc<A> zzoR() {
            return this.f2656a;
        }

        public void zzpe() {
            setResultCallback((ResultCallback) null);
        }

        /* access modifiers changed from: protected */
        public void zzpf() {
            zzj.C0710d andSet = this.f2657b.getAndSet((Object) null);
            if (andSet != null) {
                andSet.mo5197a(this);
            }
        }

        public /* synthetic */ void zzs(Object obj) {
            super.zza((Result) obj);
        }

        public final void zzw(Status status) {
            zzx.zzb(!status.isSuccess(), (Object) "Failed result must not be success");
            zza(zzc(status));
        }
    }

    public interface zzb<R> {
        void zzs(R r);

        void zzw(Status status);
    }
}
