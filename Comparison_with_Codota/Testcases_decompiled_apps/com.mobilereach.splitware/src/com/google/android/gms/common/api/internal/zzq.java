package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

public final class zzq<L> {
    private volatile L mListener;
    private final zzq<L>.zza zzaiw;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            if (msg.what != 1) {
                z = false;
            }
            zzx.zzac(z);
            zzq.this.zzb((zzb) msg.obj);
        }
    }

    public interface zzb<L> {
        void zzpr();

        void zzt(L l);
    }

    zzq(Looper looper, L l) {
        this.zzaiw = new zza(looper);
        this.mListener = zzx.zzb(l, (Object) "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> zzb2) {
        zzx.zzb(zzb2, (Object) "Notifier must not be null");
        this.zzaiw.sendMessage(this.zzaiw.obtainMessage(1, zzb2));
    }

    /* access modifiers changed from: package-private */
    public void zzb(zzb<? super L> zzb2) {
        L l = this.mListener;
        if (l == null) {
            zzb2.zzpr();
            return;
        }
        try {
            zzb2.zzt(l);
        } catch (RuntimeException e) {
            zzb2.zzpr();
            throw e;
        }
    }
}
