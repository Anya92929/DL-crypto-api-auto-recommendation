package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.zzab;

@zzin
public class zzko {

    /* renamed from: a */
    private HandlerThread f6634a = null;

    /* renamed from: b */
    private Handler f6635b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f6636c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object f6637d = new Object();

    public Looper zztq() {
        Looper looper;
        synchronized (this.f6637d) {
            if (this.f6636c != 0) {
                zzab.zzb((Object) this.f6634a, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.f6634a == null) {
                zzkd.m7303v("Starting the looper thread.");
                this.f6634a = new HandlerThread("LooperProvider");
                this.f6634a.start();
                this.f6635b = new Handler(this.f6634a.getLooper());
                zzkd.m7303v("Looper thread started.");
            } else {
                zzkd.m7303v("Resuming the looper thread");
                this.f6637d.notifyAll();
            }
            this.f6636c++;
            looper = this.f6634a.getLooper();
        }
        return looper;
    }

    public void zztr() {
        synchronized (this.f6637d) {
            zzab.zzb(this.f6636c > 0, (Object) "Invalid state: release() called more times than expected.");
            int i = this.f6636c - 1;
            this.f6636c = i;
            if (i == 0) {
                this.f6635b.post(new C1751ms(this));
            }
        }
    }
}
