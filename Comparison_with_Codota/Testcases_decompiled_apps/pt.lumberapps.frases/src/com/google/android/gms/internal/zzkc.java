package com.google.android.gms.internal;

import java.util.concurrent.Future;

@zzin
public abstract class zzkc implements zzkj {

    /* renamed from: a */
    private final Runnable f6607a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile Thread f6608b;

    /* renamed from: c */
    private boolean f6609c;

    public zzkc() {
        this.f6607a = new C1717ll(this);
        this.f6609c = false;
    }

    public zzkc(boolean z) {
        this.f6607a = new C1717ll(this);
        this.f6609c = z;
    }

    public final void cancel() {
        onStop();
        if (this.f6608b != null) {
            this.f6608b.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzew();

    /* renamed from: zzsz */
    public final Future zzpy() {
        return this.f6609c ? zzkg.zza(1, this.f6607a) : zzkg.zza(this.f6607a);
    }
}
