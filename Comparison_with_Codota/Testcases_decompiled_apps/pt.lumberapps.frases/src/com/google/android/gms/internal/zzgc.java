package com.google.android.gms.internal;

import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzgl;

@zzin
public final class zzgc extends zzgl.zza {

    /* renamed from: a */
    private final Object f6216a = new Object();

    /* renamed from: b */
    private zzge.zza f6217b;

    /* renamed from: c */
    private zzgb f6218c;

    public void onAdClicked() {
        synchronized (this.f6216a) {
            if (this.f6218c != null) {
                this.f6218c.zzdz();
            }
        }
    }

    public void onAdClosed() {
        synchronized (this.f6216a) {
            if (this.f6218c != null) {
                this.f6218c.zzea();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.f6216a) {
            if (this.f6217b != null) {
                this.f6217b.zzy(i == 3 ? 1 : 2);
                this.f6217b = null;
            }
        }
    }

    public void onAdImpression() {
        synchronized (this.f6216a) {
            if (this.f6218c != null) {
                this.f6218c.zzee();
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.f6216a) {
            if (this.f6218c != null) {
                this.f6218c.zzeb();
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
            java.lang.Object r1 = r3.f6216a
            monitor-enter(r1)
            com.google.android.gms.internal.zzge$zza r0 = r3.f6217b     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0012
            com.google.android.gms.internal.zzge$zza r0 = r3.f6217b     // Catch:{ all -> 0x001d }
            r2 = 0
            r0.zzy(r2)     // Catch:{ all -> 0x001d }
            r0 = 0
            r3.f6217b = r0     // Catch:{ all -> 0x001d }
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
        L_0x0011:
            return
        L_0x0012:
            com.google.android.gms.internal.zzgb r0 = r3.f6218c     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.internal.zzgb r0 = r3.f6218c     // Catch:{ all -> 0x001d }
            r0.zzed()     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            goto L_0x0011
        L_0x001d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgc.onAdLoaded():void");
    }

    public void onAdOpened() {
        synchronized (this.f6216a) {
            if (this.f6218c != null) {
                this.f6218c.zzec();
            }
        }
    }

    public void zza(zzgb zzgb) {
        synchronized (this.f6216a) {
            this.f6218c = zzgb;
        }
    }

    public void zza(zzge.zza zza) {
        synchronized (this.f6216a) {
            this.f6217b = zza;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(com.google.android.gms.internal.zzgm r4) {
        /*
            r3 = this;
            java.lang.Object r1 = r3.f6216a
            monitor-enter(r1)
            com.google.android.gms.internal.zzge$zza r0 = r3.f6217b     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0012
            com.google.android.gms.internal.zzge$zza r0 = r3.f6217b     // Catch:{ all -> 0x001d }
            r2 = 0
            r0.zza(r2, r4)     // Catch:{ all -> 0x001d }
            r0 = 0
            r3.f6217b = r0     // Catch:{ all -> 0x001d }
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
        L_0x0011:
            return
        L_0x0012:
            com.google.android.gms.internal.zzgb r0 = r3.f6218c     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.internal.zzgb r0 = r3.f6218c     // Catch:{ all -> 0x001d }
            r0.zzed()     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            goto L_0x0011
        L_0x001d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgc.zza(com.google.android.gms.internal.zzgm):void");
    }
}
