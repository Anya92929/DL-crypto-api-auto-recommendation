package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

public final class zzq<L> {

    /* renamed from: a */
    private final zzq<L>.C0000a f2796a;

    /* renamed from: b */
    private volatile L f2797b;

    /* renamed from: com.google.android.gms.common.api.internal.zzq$a */
    final class C0715a extends Handler {
        public C0715a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            zzx.zzac(z);
            zzq.this.mo5224a((zzb) message.obj);
        }
    }

    public interface zzb<L> {
        void zzpr();

        void zzt(L l);
    }

    zzq(Looper looper, L l) {
        this.f2796a = new C0715a(looper);
        this.f2797b = zzx.zzb(l, (Object) "Listener must not be null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5224a(zzb<? super L> zzb2) {
        L l = this.f2797b;
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

    public void clear() {
        this.f2797b = null;
    }

    public void zza(zzb<? super L> zzb2) {
        zzx.zzb(zzb2, (Object) "Notifier must not be null");
        this.f2796a.sendMessage(this.f2796a.obtainMessage(1, zzb2));
    }
}
