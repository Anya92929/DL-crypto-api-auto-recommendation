package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.atomic.AtomicReference;

public class zzpm {

    public abstract class zza extends zzpo implements zzb {

        /* renamed from: d */
        private final Api.zzc f6782d;

        /* renamed from: e */
        private final Api f6783e;

        /* renamed from: f */
        private AtomicReference f6784f = new AtomicReference();

        protected zza(Api api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) zzab.zzb((Object) googleApiClient, (Object) "GoogleApiClient must not be null"));
            this.f6782d = api.zzans();
            this.f6783e = api;
        }

        /* renamed from: a */
        private void m7412a(RemoteException remoteException) {
            zzz(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo8910a() {
            C1833pt ptVar = (C1833pt) this.f6784f.getAndSet((Object) null);
            if (ptVar != null) {
                ptVar.mo7653a(this);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo7586a(Api.zzb zzb);

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo8911a(Result result) {
        }

        public /* synthetic */ void setResult(Object obj) {
            super.zzc((Result) obj);
        }

        public void zza(C1833pt ptVar) {
            this.f6784f.set(ptVar);
        }

        public final Api.zzc zzans() {
            return this.f6782d;
        }

        public final Api zzanz() {
            return this.f6783e;
        }

        public void zzaor() {
            setResultCallback((ResultCallback) null);
        }

        public final void zzb(Api.zzb zzb) {
            try {
                mo7586a(zzb);
            } catch (DeadObjectException e) {
                m7412a((RemoteException) e);
                throw e;
            } catch (RemoteException e2) {
                m7412a(e2);
            }
        }

        public final void zzz(Status status) {
            zzab.zzb(!status.isSuccess(), (Object) "Failed result must not be success");
            Result zzc = zzc(status);
            zzc(zzc);
            mo8911a(zzc);
        }
    }

    public interface zzb {
        void setResult(Object obj);

        void zzz(Status status);
    }
}
