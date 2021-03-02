package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.util.SparseArray;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.C1970a;
import com.google.firebase.C1977d;

public abstract class zzpi {

    /* renamed from: iq */
    public final int f6771iq;

    /* renamed from: sx */
    public final int f6772sx;

    public final class zza extends zzpi {

        /* renamed from: sy */
        public final zzpm.zza f6773sy;

        public zza(int i, int i2, zzpm.zza zza) {
            super(i, i2);
            this.f6773sy = zza;
        }

        public boolean cancel() {
            return this.f6773sy.zzaov();
        }

        public void zza(SparseArray sparseArray) {
            zzqy zzqy = (zzqy) sparseArray.get(this.f6772sx);
            if (zzqy != null) {
                zzqy.mo9008a(this.f6773sy);
            }
        }

        public void zzb(Api.zzb zzb) {
            this.f6773sy.zzb(zzb);
        }

        public void zzx(Status status) {
            this.f6773sy.zzz(status);
        }
    }

    public final class zzb extends zzpi {

        /* renamed from: c */
        private static final Status f6774c = new Status(8, "Connection to Google Play services was lost while executing the API call.");

        /* renamed from: a */
        private final zzqw f6775a;

        /* renamed from: b */
        private final TaskCompletionSource f6776b;

        public zzb(int i, int i2, zzqw zzqw, TaskCompletionSource taskCompletionSource) {
            super(i, i2);
            this.f6776b = taskCompletionSource;
            this.f6775a = zzqw;
        }

        public void zzb(Api.zzb zzb) {
            try {
                this.f6775a.mo9005a(zzb, this.f6776b);
            } catch (DeadObjectException e) {
                zzx(f6774c);
                throw e;
            } catch (RemoteException e2) {
                zzx(f6774c);
            }
        }

        public void zzx(Status status) {
            if (status.getStatusCode() == 8) {
                this.f6776b.setException(new C1977d(status.getStatusMessage()));
            } else {
                this.f6776b.setException(new C1970a(status.getStatusMessage()));
            }
        }
    }

    public zzpi(int i, int i2) {
        this.f6772sx = i;
        this.f6771iq = i2;
    }

    public boolean cancel() {
        return true;
    }

    public void zza(SparseArray sparseArray) {
    }

    public abstract void zzb(Api.zzb zzb2);

    public abstract void zzx(Status status);
}
