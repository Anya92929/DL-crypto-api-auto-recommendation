package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.zzab;

public final class zzqn {

    /* renamed from: a */
    private final C1827pn f6913a;

    /* renamed from: b */
    private volatile Object f6914b;

    public interface zzb {
        void zzapj();

        void zzt(Object obj);
    }

    zzqn(Looper looper, Object obj) {
        this.f6913a = new C1827pn(this, looper);
        this.f6914b = zzab.zzb(obj, (Object) "Listener must not be null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8994a(zzb zzb2) {
        Object obj = this.f6914b;
        if (obj == null) {
            zzb2.zzapj();
            return;
        }
        try {
            zzb2.zzt(obj);
        } catch (RuntimeException e) {
            zzb2.zzapj();
            throw e;
        }
    }

    public void clear() {
        this.f6914b = null;
    }

    public void zza(zzb zzb2) {
        zzab.zzb((Object) zzb2, (Object) "Notifier must not be null");
        this.f6913a.sendMessage(this.f6913a.obtainMessage(1, zzb2));
    }
}
