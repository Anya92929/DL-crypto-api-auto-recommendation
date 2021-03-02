package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;

public class zzrp {

    /* renamed from: a */
    private static String f3259a = "WakeLock";

    /* renamed from: b */
    private static String f3260b = "*gcore*:";

    /* renamed from: c */
    private static boolean f3261c = false;

    /* renamed from: d */
    private final PowerManager.WakeLock f3262d;

    /* renamed from: e */
    private WorkSource f3263e;

    /* renamed from: f */
    private final int f3264f;

    /* renamed from: g */
    private final String f3265g;

    /* renamed from: h */
    private final String f3266h;

    /* renamed from: i */
    private final Context f3267i;

    /* renamed from: j */
    private boolean f3268j;

    /* renamed from: k */
    private int f3269k;

    /* renamed from: l */
    private int f3270l;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzrp(Context context, int i, String str) {
        this(context, i, str, (String) null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzrp(Context context, int i, String str, String str2, String str3) {
        this.f3268j = true;
        zzx.zzh(str, "Wake lock name can NOT be empty");
        this.f3264f = i;
        this.f3266h = str2;
        this.f3267i = context.getApplicationContext();
        if (zzni.zzcV(str3) || "com.google.android.gms" == str3) {
            this.f3265g = str;
        } else {
            this.f3265g = f3260b + str;
        }
        this.f3262d = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zznj.zzaA(this.f3267i)) {
            if (zzni.zzcV(str3)) {
                if (!zzd.zzakE || !zzlz.isInitialized()) {
                    str3 = context.getPackageName();
                } else {
                    Log.e(f3259a, "callingPackage is not supposed to be empty for wakelock " + this.f3265g + "!", new IllegalArgumentException());
                    str3 = "com.google.android.gms";
                }
            }
            this.f3263e = zznj.zzl(context, str3);
            zzc(this.f3263e);
        }
    }

    /* renamed from: a */
    private String m4076a(String str, boolean z) {
        return this.f3268j ? z ? str : this.f3266h : this.f3266h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007e, code lost:
        if (r8.f3270l == 1) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0075, code lost:
        if (r0 == false) goto L_0x0077;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4077a(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.m4079b(r9)
            java.lang.String r5 = r8.m4076a((java.lang.String) r9, (boolean) r0)
            boolean r1 = f3261c
            if (r1 == 0) goto L_0x0068
            java.lang.String r1 = f3259a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Release:\n mWakeLockName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r8.f3265g
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\n mSecondaryName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r8.f3266h
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nmReferenceCounted: "
            java.lang.StringBuilder r2 = r2.append(r3)
            boolean r3 = r8.f3268j
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nreason: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r3 = "\n mOpenEventCount"
            java.lang.StringBuilder r2 = r2.append(r3)
            int r3 = r8.f3270l
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nuseWithReason: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = "\ntrackingName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
        L_0x0068:
            monitor-enter(r8)
            boolean r1 = r8.f3268j     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x0077
            int r1 = r8.f3269k     // Catch:{ all -> 0x00a3 }
            int r1 = r1 + -1
            r8.f3269k = r1     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x0080
            if (r0 != 0) goto L_0x0080
        L_0x0077:
            boolean r0 = r8.f3268j     // Catch:{ all -> 0x00a3 }
            if (r0 != 0) goto L_0x00a1
            int r0 = r8.f3270l     // Catch:{ all -> 0x00a3 }
            r1 = 1
            if (r0 != r1) goto L_0x00a1
        L_0x0080:
            com.google.android.gms.common.stats.zzi r0 = com.google.android.gms.common.stats.zzi.zzrZ()     // Catch:{ all -> 0x00a3 }
            android.content.Context r1 = r8.f3267i     // Catch:{ all -> 0x00a3 }
            android.os.PowerManager$WakeLock r2 = r8.f3262d     // Catch:{ all -> 0x00a3 }
            java.lang.String r2 = com.google.android.gms.common.stats.zzg.zza(r2, r5)     // Catch:{ all -> 0x00a3 }
            r3 = 8
            java.lang.String r4 = r8.f3265g     // Catch:{ all -> 0x00a3 }
            int r6 = r8.f3264f     // Catch:{ all -> 0x00a3 }
            android.os.WorkSource r7 = r8.f3263e     // Catch:{ all -> 0x00a3 }
            java.util.List r7 = com.google.android.gms.internal.zznj.zzb(r7)     // Catch:{ all -> 0x00a3 }
            r0.zza(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00a3 }
            int r0 = r8.f3270l     // Catch:{ all -> 0x00a3 }
            int r0 = r0 + -1
            r8.f3270l = r0     // Catch:{ all -> 0x00a3 }
        L_0x00a1:
            monitor-exit(r8)     // Catch:{ all -> 0x00a3 }
            return
        L_0x00a3:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00a3 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzrp.m4077a(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0087, code lost:
        if (r10.f3270l == 0) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x007f, code lost:
        if (r0 == false) goto L_0x0081;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4078a(java.lang.String r11, long r12) {
        /*
            r10 = this;
            boolean r0 = r10.m4079b(r11)
            java.lang.String r5 = r10.m4076a((java.lang.String) r11, (boolean) r0)
            boolean r1 = f3261c
            if (r1 == 0) goto L_0x0072
            java.lang.String r1 = f3259a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Acquire:\n mWakeLockName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r10.f3265g
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\n mSecondaryName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r10.f3266h
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nmReferenceCounted: "
            java.lang.StringBuilder r2 = r2.append(r3)
            boolean r3 = r10.f3268j
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nreason: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r11)
            java.lang.String r3 = "\nmOpenEventCount"
            java.lang.StringBuilder r2 = r2.append(r3)
            int r3 = r10.f3270l
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nuseWithReason: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = "\ntrackingName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r3 = "\ntimeout: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r12)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
        L_0x0072:
            monitor-enter(r10)
            boolean r1 = r10.f3268j     // Catch:{ all -> 0x00ac }
            if (r1 == 0) goto L_0x0081
            int r1 = r10.f3269k     // Catch:{ all -> 0x00ac }
            int r2 = r1 + 1
            r10.f3269k = r2     // Catch:{ all -> 0x00ac }
            if (r1 == 0) goto L_0x0089
            if (r0 != 0) goto L_0x0089
        L_0x0081:
            boolean r0 = r10.f3268j     // Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x00aa
            int r0 = r10.f3270l     // Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x00aa
        L_0x0089:
            com.google.android.gms.common.stats.zzi r0 = com.google.android.gms.common.stats.zzi.zzrZ()     // Catch:{ all -> 0x00ac }
            android.content.Context r1 = r10.f3267i     // Catch:{ all -> 0x00ac }
            android.os.PowerManager$WakeLock r2 = r10.f3262d     // Catch:{ all -> 0x00ac }
            java.lang.String r2 = com.google.android.gms.common.stats.zzg.zza(r2, r5)     // Catch:{ all -> 0x00ac }
            r3 = 7
            java.lang.String r4 = r10.f3265g     // Catch:{ all -> 0x00ac }
            int r6 = r10.f3264f     // Catch:{ all -> 0x00ac }
            android.os.WorkSource r7 = r10.f3263e     // Catch:{ all -> 0x00ac }
            java.util.List r7 = com.google.android.gms.internal.zznj.zzb(r7)     // Catch:{ all -> 0x00ac }
            r8 = r12
            r0.zza(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00ac }
            int r0 = r10.f3270l     // Catch:{ all -> 0x00ac }
            int r0 = r0 + 1
            r10.f3270l = r0     // Catch:{ all -> 0x00ac }
        L_0x00aa:
            monitor-exit(r10)     // Catch:{ all -> 0x00ac }
            return
        L_0x00ac:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00ac }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzrp.m4078a(java.lang.String, long):void");
    }

    /* renamed from: b */
    private boolean m4079b(String str) {
        return !TextUtils.isEmpty(str) && !str.equals(this.f3266h);
    }

    public void acquire(long j) {
        if (!zzne.zzsg() && this.f3268j) {
            Log.wtf(f3259a, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.f3265g);
        }
        m4078a((String) null, j);
        this.f3262d.acquire(j);
    }

    public boolean isHeld() {
        return this.f3262d.isHeld();
    }

    public void release() {
        m4077a((String) null);
        this.f3262d.release();
    }

    public void setReferenceCounted(boolean z) {
        this.f3262d.setReferenceCounted(z);
        this.f3268j = z;
    }

    public void zzc(WorkSource workSource) {
        if (zznj.zzaA(this.f3267i) && workSource != null) {
            if (this.f3263e != null) {
                this.f3263e.add(workSource);
            } else {
                this.f3263e = workSource;
            }
            this.f3262d.setWorkSource(this.f3263e);
        }
    }
}
