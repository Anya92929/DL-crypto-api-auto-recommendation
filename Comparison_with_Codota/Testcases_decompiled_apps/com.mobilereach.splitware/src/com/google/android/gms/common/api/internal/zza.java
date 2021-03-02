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
    public static abstract class C0426zza<R extends Result, A extends Api.zzb> extends zzb<R> implements zzb<R>, zzj.zze<A> {
        private final Api.zzc<A> zzaeE;
        private AtomicReference<zzj.zzd> zzagH = new AtomicReference<>();

        protected C0426zza(Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) zzx.zzb(googleApiClient, (Object) "GoogleApiClient must not be null"));
            this.zzaeE = (Api.zzc) zzx.zzz(zzc);
        }

        private void zza(RemoteException remoteException) {
            zzw(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        /* access modifiers changed from: protected */
        public abstract void zza(A a) throws RemoteException;

        public void zza(zzj.zzd zzd) {
            this.zzagH.set(zzd);
        }

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza(a);
            } catch (DeadObjectException e) {
                zza((RemoteException) e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        public final Api.zzc<A> zzoR() {
            return this.zzaeE;
        }

        public void zzpe() {
            setResultCallback((ResultCallback) null);
        }

        /* access modifiers changed from: protected */
        public void zzpf() {
            zzj.zzd andSet = this.zzagH.getAndSet((Object) null);
            if (andSet != null) {
                andSet.zzc(this);
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
