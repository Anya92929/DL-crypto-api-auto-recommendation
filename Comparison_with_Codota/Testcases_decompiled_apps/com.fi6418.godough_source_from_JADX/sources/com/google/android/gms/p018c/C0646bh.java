package com.google.android.gms.p018c;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.internal.C1015f;

/* renamed from: com.google.android.gms.c.bh */
public class C0646bh {

    /* renamed from: a */
    private static String f4299a = "WakeLock";

    /* renamed from: b */
    private static boolean f4300b = false;

    /* renamed from: c */
    private final PowerManager.WakeLock f4301c;

    /* renamed from: d */
    private WorkSource f4302d;

    /* renamed from: e */
    private final int f4303e;

    /* renamed from: f */
    private final String f4304f;

    /* renamed from: g */
    private final String f4305g;

    /* renamed from: h */
    private final Context f4306h;

    /* renamed from: i */
    private boolean f4307i;

    /* renamed from: j */
    private int f4308j;

    /* renamed from: k */
    private int f4309k;

    public C0646bh(Context context, int i, String str) {
        this(context, i, str, (String) null, (String) null);
    }

    public C0646bh(Context context, int i, String str, String str2, String str3) {
        this.f4307i = true;
        C1009bf.m4531a(str, (Object) "Wake lock name can NOT be empty");
        this.f4303e = i;
        this.f4304f = str;
        this.f4305g = str2;
        this.f4306h = context.getApplicationContext();
        this.f4301c = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (C0621aj.m3581a(this.f4306h)) {
            if (C0620ai.m3574a(str3)) {
                if (!C1015f.f4727a || !C0669k.m3888b()) {
                    str3 = context.getPackageName();
                } else {
                    Log.e(f4299a, "callingPackage is not supposed to be empty for wakelock " + this.f4304f + "!");
                    str3 = "com.google.android.gms";
                }
            }
            this.f4302d = C0621aj.m3577a(context, str3);
            mo7129a(this.f4302d);
        }
    }

    /* renamed from: a */
    private String m3734a(String str, boolean z) {
        return this.f4307i ? z ? str : this.f4305g : this.f4305g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007d, code lost:
        if (r8.f4309k == 0) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0075, code lost:
        if (r0 == false) goto L_0x0077;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3735a(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.m3737c(r9)
            java.lang.String r5 = r8.m3734a(r9, r0)
            boolean r1 = f4300b
            if (r1 == 0) goto L_0x0068
            java.lang.String r1 = f4299a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Acquire:\n mWakeLockName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r8.f4304f
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\n mSecondaryName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r8.f4305g
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nmReferenceCounted: "
            java.lang.StringBuilder r2 = r2.append(r3)
            boolean r3 = r8.f4307i
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nreason: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r3 = "\nmOpenEventCount"
            java.lang.StringBuilder r2 = r2.append(r3)
            int r3 = r8.f4309k
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
            boolean r1 = r8.f4307i     // Catch:{ all -> 0x00a1 }
            if (r1 == 0) goto L_0x0077
            int r1 = r8.f4308j     // Catch:{ all -> 0x00a1 }
            int r2 = r1 + 1
            r8.f4308j = r2     // Catch:{ all -> 0x00a1 }
            if (r1 == 0) goto L_0x007f
            if (r0 != 0) goto L_0x007f
        L_0x0077:
            boolean r0 = r8.f4307i     // Catch:{ all -> 0x00a1 }
            if (r0 != 0) goto L_0x009f
            int r0 = r8.f4309k     // Catch:{ all -> 0x00a1 }
            if (r0 != 0) goto L_0x009f
        L_0x007f:
            com.google.android.gms.common.stats.j r0 = com.google.android.gms.common.stats.C1101j.m4781a()     // Catch:{ all -> 0x00a1 }
            android.content.Context r1 = r8.f4306h     // Catch:{ all -> 0x00a1 }
            android.os.PowerManager$WakeLock r2 = r8.f4301c     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = com.google.android.gms.common.stats.C1099h.m4776a(r2, r5)     // Catch:{ all -> 0x00a1 }
            r3 = 7
            java.lang.String r4 = r8.f4304f     // Catch:{ all -> 0x00a1 }
            int r6 = r8.f4303e     // Catch:{ all -> 0x00a1 }
            android.os.WorkSource r7 = r8.f4302d     // Catch:{ all -> 0x00a1 }
            java.util.List r7 = com.google.android.gms.p018c.C0621aj.m3583b(r7)     // Catch:{ all -> 0x00a1 }
            r0.mo7712a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00a1 }
            int r0 = r8.f4309k     // Catch:{ all -> 0x00a1 }
            int r0 = r0 + 1
            r8.f4309k = r0     // Catch:{ all -> 0x00a1 }
        L_0x009f:
            monitor-exit(r8)     // Catch:{ all -> 0x00a1 }
            return
        L_0x00a1:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00a1 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.p018c.C0646bh.m3735a(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007e, code lost:
        if (r8.f4309k == 1) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0075, code lost:
        if (r0 == false) goto L_0x0077;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3736b(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.m3737c(r9)
            java.lang.String r5 = r8.m3734a(r9, r0)
            boolean r1 = f4300b
            if (r1 == 0) goto L_0x0068
            java.lang.String r1 = f4299a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Release:\n mWakeLockName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r8.f4304f
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\n mSecondaryName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r8.f4305g
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nmReferenceCounted: "
            java.lang.StringBuilder r2 = r2.append(r3)
            boolean r3 = r8.f4307i
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nreason: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r3 = "\n mOpenEventCount"
            java.lang.StringBuilder r2 = r2.append(r3)
            int r3 = r8.f4309k
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
            boolean r1 = r8.f4307i     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x0077
            int r1 = r8.f4308j     // Catch:{ all -> 0x00a3 }
            int r1 = r1 + -1
            r8.f4308j = r1     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x0080
            if (r0 != 0) goto L_0x0080
        L_0x0077:
            boolean r0 = r8.f4307i     // Catch:{ all -> 0x00a3 }
            if (r0 != 0) goto L_0x00a1
            int r0 = r8.f4309k     // Catch:{ all -> 0x00a3 }
            r1 = 1
            if (r0 != r1) goto L_0x00a1
        L_0x0080:
            com.google.android.gms.common.stats.j r0 = com.google.android.gms.common.stats.C1101j.m4781a()     // Catch:{ all -> 0x00a3 }
            android.content.Context r1 = r8.f4306h     // Catch:{ all -> 0x00a3 }
            android.os.PowerManager$WakeLock r2 = r8.f4301c     // Catch:{ all -> 0x00a3 }
            java.lang.String r2 = com.google.android.gms.common.stats.C1099h.m4776a(r2, r5)     // Catch:{ all -> 0x00a3 }
            r3 = 8
            java.lang.String r4 = r8.f4304f     // Catch:{ all -> 0x00a3 }
            int r6 = r8.f4303e     // Catch:{ all -> 0x00a3 }
            android.os.WorkSource r7 = r8.f4302d     // Catch:{ all -> 0x00a3 }
            java.util.List r7 = com.google.android.gms.p018c.C0621aj.m3583b(r7)     // Catch:{ all -> 0x00a3 }
            r0.mo7712a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00a3 }
            int r0 = r8.f4309k     // Catch:{ all -> 0x00a3 }
            int r0 = r0 + -1
            r8.f4309k = r0     // Catch:{ all -> 0x00a3 }
        L_0x00a1:
            monitor-exit(r8)     // Catch:{ all -> 0x00a3 }
            return
        L_0x00a3:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00a3 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.p018c.C0646bh.m3736b(java.lang.String):void");
    }

    /* renamed from: c */
    private boolean m3737c(String str) {
        return !TextUtils.isEmpty(str) && !str.equals(this.f4305g);
    }

    /* renamed from: a */
    public void mo7127a() {
        m3736b((String) null);
        this.f4301c.release();
    }

    /* renamed from: a */
    public void mo7128a(long j) {
        if (!C0618ag.m3565c() && this.f4307i) {
            Log.wtf(f4299a, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.f4304f);
        }
        m3735a((String) null);
        this.f4301c.acquire(j);
    }

    /* renamed from: a */
    public void mo7129a(WorkSource workSource) {
        if (C0621aj.m3581a(this.f4306h) && workSource != null) {
            if (this.f4302d != null) {
                this.f4302d.add(workSource);
            } else {
                this.f4302d = workSource;
            }
            this.f4301c.setWorkSource(this.f4302d);
        }
    }

    /* renamed from: a */
    public void mo7130a(boolean z) {
        this.f4301c.setReferenceCounted(z);
        this.f4307i = z;
    }

    /* renamed from: b */
    public boolean mo7131b() {
        return this.f4301c.isHeld();
    }
}
