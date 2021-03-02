package com.google.android.gms.internal;

import com.google.android.gms.internal.C1009cq;
import com.google.android.gms.internal.C1019cv;

@C1130ez
/* renamed from: com.google.android.gms.internal.co */
public final class C1006co extends C1019cv.C1020a {

    /* renamed from: mw */
    private final Object f3043mw = new Object();

    /* renamed from: qm */
    private C1009cq.C1010a f3044qm;

    /* renamed from: qn */
    private C1005cn f3045qn;

    /* renamed from: a */
    public void mo8224a(C1005cn cnVar) {
        synchronized (this.f3043mw) {
            this.f3045qn = cnVar;
        }
    }

    /* renamed from: a */
    public void mo8225a(C1009cq.C1010a aVar) {
        synchronized (this.f3043mw) {
            this.f3044qm = aVar;
        }
    }

    public void onAdClicked() {
        synchronized (this.f3043mw) {
            if (this.f3045qn != null) {
                this.f3045qn.mo8219ae();
            }
        }
    }

    public void onAdClosed() {
        synchronized (this.f3043mw) {
            if (this.f3045qn != null) {
                this.f3045qn.mo8220af();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.f3043mw) {
            if (this.f3044qm != null) {
                this.f3044qm.mo8234j(error == 3 ? 1 : 2);
                this.f3044qm = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.f3043mw) {
            if (this.f3045qn != null) {
                this.f3045qn.mo8221ag();
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
            java.lang.Object r1 = r3.f3043mw
            monitor-enter(r1)
            com.google.android.gms.internal.cq$a r0 = r3.f3044qm     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0012
            com.google.android.gms.internal.cq$a r0 = r3.f3044qm     // Catch:{ all -> 0x001d }
            r2 = 0
            r0.mo8234j(r2)     // Catch:{ all -> 0x001d }
            r0 = 0
            r3.f3044qm = r0     // Catch:{ all -> 0x001d }
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
        L_0x0011:
            return
        L_0x0012:
            com.google.android.gms.internal.cn r0 = r3.f3045qn     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.internal.cn r0 = r3.f3045qn     // Catch:{ all -> 0x001d }
            r0.mo8223ai()     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            goto L_0x0011
        L_0x001d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1006co.onAdLoaded():void");
    }

    public void onAdOpened() {
        synchronized (this.f3043mw) {
            if (this.f3045qn != null) {
                this.f3045qn.mo8222ah();
            }
        }
    }
}
