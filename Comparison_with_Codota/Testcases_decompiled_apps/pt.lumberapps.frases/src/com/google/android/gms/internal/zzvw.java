package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzw;
import com.google.android.gms.common.util.zzz;

public class zzvw {

    /* renamed from: a */
    private static String f7041a = "WakeLock";

    /* renamed from: b */
    private static String f7042b = "*gcore*:";

    /* renamed from: c */
    private static boolean f7043c = false;

    /* renamed from: d */
    private final PowerManager.WakeLock f7044d;

    /* renamed from: e */
    private WorkSource f7045e;

    /* renamed from: f */
    private final int f7046f;

    /* renamed from: g */
    private final String f7047g;

    /* renamed from: h */
    private final String f7048h;

    /* renamed from: i */
    private final String f7049i;

    /* renamed from: j */
    private final Context f7050j;

    /* renamed from: k */
    private boolean f7051k;

    /* renamed from: l */
    private int f7052l;

    /* renamed from: m */
    private int f7053m;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzvw(Context context, int i, String str) {
        this(context, i, str, (String) null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzvw(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, str2, str3, (String) null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzvw(Context context, int i, String str, String str2, String str3, String str4) {
        this.f7051k = true;
        zzab.zzh(str, "Wake lock name can NOT be empty");
        this.f7046f = i;
        this.f7048h = str2;
        this.f7049i = str4;
        this.f7050j = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(f7042b);
            String valueOf2 = String.valueOf(str);
            this.f7047g = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            this.f7047g = str;
        }
        this.f7044d = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zzz.zzco(this.f7050j)) {
            this.f7045e = zzz.zzr(context, zzw.zzib(str3) ? context.getPackageName() : str3);
            zzc(this.f7045e);
        }
    }

    /* renamed from: a */
    private String m7594a(String str, boolean z) {
        return this.f7051k ? z ? str : this.f7048h : this.f7048h;
    }

    /* renamed from: a */
    private void m7595a(WorkSource workSource) {
        try {
            this.f7044d.setWorkSource(workSource);
        } catch (IllegalArgumentException e) {
            Log.wtf(f7041a, e.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r9.f7053m == 1) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0 == false) goto L_0x0017;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7596a(java.lang.String r10) {
        /*
            r9 = this;
            boolean r0 = r9.m7598b(r10)
            java.lang.String r5 = r9.m7594a((java.lang.String) r10, (boolean) r0)
            monitor-enter(r9)
            boolean r1 = r9.f7051k     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0017
            int r1 = r9.f7052l     // Catch:{ all -> 0x0045 }
            int r1 = r1 + -1
            r9.f7052l = r1     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0020
            if (r0 != 0) goto L_0x0020
        L_0x0017:
            boolean r0 = r9.f7051k     // Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0043
            int r0 = r9.f7053m     // Catch:{ all -> 0x0045 }
            r1 = 1
            if (r0 != r1) goto L_0x0043
        L_0x0020:
            com.google.android.gms.common.stats.zzh r0 = com.google.android.gms.common.stats.zzh.zzavi()     // Catch:{ all -> 0x0045 }
            android.content.Context r1 = r9.f7050j     // Catch:{ all -> 0x0045 }
            android.os.PowerManager$WakeLock r2 = r9.f7044d     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = com.google.android.gms.common.stats.zzf.zza(r2, r5)     // Catch:{ all -> 0x0045 }
            r3 = 8
            java.lang.String r4 = r9.f7047g     // Catch:{ all -> 0x0045 }
            java.lang.String r6 = r9.f7049i     // Catch:{ all -> 0x0045 }
            int r7 = r9.f7046f     // Catch:{ all -> 0x0045 }
            android.os.WorkSource r8 = r9.f7045e     // Catch:{ all -> 0x0045 }
            java.util.List r8 = com.google.android.gms.common.util.zzz.zzb(r8)     // Catch:{ all -> 0x0045 }
            r0.zza(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0045 }
            int r0 = r9.f7053m     // Catch:{ all -> 0x0045 }
            int r0 = r0 + -1
            r9.f7053m = r0     // Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r9)     // Catch:{ all -> 0x0045 }
            return
        L_0x0045:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0045 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzvw.m7596a(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r12.f7053m == 0) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0 == false) goto L_0x0017;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7597a(java.lang.String r13, long r14) {
        /*
            r12 = this;
            boolean r0 = r12.m7598b(r13)
            java.lang.String r6 = r12.m7594a((java.lang.String) r13, (boolean) r0)
            monitor-enter(r12)
            boolean r1 = r12.f7051k     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x0017
            int r1 = r12.f7052l     // Catch:{ all -> 0x0044 }
            int r2 = r1 + 1
            r12.f7052l = r2     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x001f
            if (r0 != 0) goto L_0x001f
        L_0x0017:
            boolean r0 = r12.f7051k     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0042
            int r0 = r12.f7053m     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0042
        L_0x001f:
            com.google.android.gms.common.stats.zzh r1 = com.google.android.gms.common.stats.zzh.zzavi()     // Catch:{ all -> 0x0044 }
            android.content.Context r2 = r12.f7050j     // Catch:{ all -> 0x0044 }
            android.os.PowerManager$WakeLock r0 = r12.f7044d     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = com.google.android.gms.common.stats.zzf.zza(r0, r6)     // Catch:{ all -> 0x0044 }
            r4 = 7
            java.lang.String r5 = r12.f7047g     // Catch:{ all -> 0x0044 }
            java.lang.String r7 = r12.f7049i     // Catch:{ all -> 0x0044 }
            int r8 = r12.f7046f     // Catch:{ all -> 0x0044 }
            android.os.WorkSource r0 = r12.f7045e     // Catch:{ all -> 0x0044 }
            java.util.List r9 = com.google.android.gms.common.util.zzz.zzb(r0)     // Catch:{ all -> 0x0044 }
            r10 = r14
            r1.zza(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0044 }
            int r0 = r12.f7053m     // Catch:{ all -> 0x0044 }
            int r0 = r0 + 1
            r12.f7053m = r0     // Catch:{ all -> 0x0044 }
        L_0x0042:
            monitor-exit(r12)     // Catch:{ all -> 0x0044 }
            return
        L_0x0044:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0044 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzvw.m7597a(java.lang.String, long):void");
    }

    /* renamed from: b */
    private boolean m7598b(String str) {
        return !TextUtils.isEmpty(str) && !str.equals(this.f7048h);
    }

    public void acquire(long j) {
        if (!zzs.zzavq() && this.f7051k) {
            String str = f7041a;
            String valueOf = String.valueOf(this.f7047g);
            Log.wtf(str, valueOf.length() != 0 ? "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ".concat(valueOf) : new String("Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: "));
        }
        m7597a((String) null, j);
        this.f7044d.acquire(j);
    }

    public boolean isHeld() {
        return this.f7044d.isHeld();
    }

    public void release() {
        m7596a((String) null);
        this.f7044d.release();
    }

    public void setReferenceCounted(boolean z) {
        this.f7044d.setReferenceCounted(z);
        this.f7051k = z;
    }

    public void zzc(WorkSource workSource) {
        if (workSource != null && zzz.zzco(this.f7050j)) {
            if (this.f7045e != null) {
                this.f7045e.add(workSource);
            } else {
                this.f7045e = workSource;
            }
            m7595a(this.f7045e);
        }
    }
}
