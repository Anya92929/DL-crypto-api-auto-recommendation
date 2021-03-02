package com.google.android.gms.internal;

import com.google.android.gms.internal.C0234at;
import com.google.android.gms.internal.C0244ay;

/* renamed from: com.google.android.gms.internal.ar */
public final class C0231ar extends C0244ay.C0245a {

    /* renamed from: eJ */
    private final Object f592eJ = new Object();

    /* renamed from: fb */
    private C0234at.C0235a f593fb;

    /* renamed from: fc */
    private C0230aq f594fc;

    /* renamed from: a */
    public void mo4049a(C0230aq aqVar) {
        synchronized (this.f592eJ) {
            this.f594fc = aqVar;
        }
    }

    /* renamed from: a */
    public void mo4050a(C0234at.C0235a aVar) {
        synchronized (this.f592eJ) {
            this.f593fb = aVar;
        }
    }

    public void onAdClosed() {
        synchronized (this.f592eJ) {
            if (this.f594fc != null) {
                this.f594fc.mo4045E();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.f592eJ) {
            if (this.f593fb != null) {
                this.f593fb.mo4059d(error == 3 ? 1 : 2);
                this.f593fb = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.f592eJ) {
            if (this.f594fc != null) {
                this.f594fc.mo4046F();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdLoaded() {
        /*
            r3 = this;
            java.lang.Object r1 = r3.f592eJ
            monitor-enter(r1)
            com.google.android.gms.internal.at$a r0 = r3.f593fb     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0012
            com.google.android.gms.internal.at$a r0 = r3.f593fb     // Catch:{ all -> 0x001d }
            r2 = 0
            r0.mo4059d(r2)     // Catch:{ all -> 0x001d }
            r0 = 0
            r3.f593fb = r0     // Catch:{ all -> 0x001d }
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
        L_0x0011:
            return
        L_0x0012:
            com.google.android.gms.internal.aq r0 = r3.f594fc     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.internal.aq r0 = r3.f594fc     // Catch:{ all -> 0x001d }
            r0.mo4048H()     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            goto L_0x0011
        L_0x001d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0231ar.onAdLoaded():void");
    }

    public void onAdOpened() {
        synchronized (this.f592eJ) {
            if (this.f594fc != null) {
                this.f594fc.mo4047G();
            }
        }
    }

    /* renamed from: y */
    public void mo4056y() {
        synchronized (this.f592eJ) {
            if (this.f594fc != null) {
                this.f594fc.mo4044D();
            }
        }
    }
}
