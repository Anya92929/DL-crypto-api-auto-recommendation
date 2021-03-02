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
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static String zzbhl = "*gcore*:";
    private final Context mContext;
    private final String zzanQ;
    private final PowerManager.WakeLock zzbhm;
    private WorkSource zzbhn;
    private final int zzbho;
    private final String zzbhp;
    private boolean zzbhq;
    private int zzbhr;
    private int zzbhs;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzrp(Context context, int i, String str) {
        this(context, i, str, (String) null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzrp(Context context, int i, String str, String str2, String str3) {
        this.zzbhq = true;
        zzx.zzh(str, "Wake lock name can NOT be empty");
        this.zzbho = i;
        this.zzbhp = str2;
        this.mContext = context.getApplicationContext();
        if (zzni.zzcV(str3) || "com.google.android.gms" == str3) {
            this.zzanQ = str;
        } else {
            this.zzanQ = zzbhl + str;
        }
        this.zzbhm = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zznj.zzaA(this.mContext)) {
            if (zzni.zzcV(str3)) {
                if (!zzd.zzakE || !zzlz.isInitialized()) {
                    str3 = context.getPackageName();
                } else {
                    Log.e(TAG, "callingPackage is not supposed to be empty for wakelock " + this.zzanQ + "!", new IllegalArgumentException());
                    str3 = "com.google.android.gms";
                }
            }
            this.zzbhn = zznj.zzl(context, str3);
            zzc(this.zzbhn);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007e, code lost:
        if (r8.zzbhs == 1) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0075, code lost:
        if (r0 == false) goto L_0x0077;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzfJ(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.zzfK(r9)
            java.lang.String r5 = r8.zzn(r9, r0)
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x0068
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Release:\n mWakeLockName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r8.zzanQ
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\n mSecondaryName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r8.zzbhp
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nmReferenceCounted: "
            java.lang.StringBuilder r2 = r2.append(r3)
            boolean r3 = r8.zzbhq
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nreason: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r3 = "\n mOpenEventCount"
            java.lang.StringBuilder r2 = r2.append(r3)
            int r3 = r8.zzbhs
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
            boolean r1 = r8.zzbhq     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x0077
            int r1 = r8.zzbhr     // Catch:{ all -> 0x00a3 }
            int r1 = r1 + -1
            r8.zzbhr = r1     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x0080
            if (r0 != 0) goto L_0x0080
        L_0x0077:
            boolean r0 = r8.zzbhq     // Catch:{ all -> 0x00a3 }
            if (r0 != 0) goto L_0x00a1
            int r0 = r8.zzbhs     // Catch:{ all -> 0x00a3 }
            r1 = 1
            if (r0 != r1) goto L_0x00a1
        L_0x0080:
            com.google.android.gms.common.stats.zzi r0 = com.google.android.gms.common.stats.zzi.zzrZ()     // Catch:{ all -> 0x00a3 }
            android.content.Context r1 = r8.mContext     // Catch:{ all -> 0x00a3 }
            android.os.PowerManager$WakeLock r2 = r8.zzbhm     // Catch:{ all -> 0x00a3 }
            java.lang.String r2 = com.google.android.gms.common.stats.zzg.zza(r2, r5)     // Catch:{ all -> 0x00a3 }
            r3 = 8
            java.lang.String r4 = r8.zzanQ     // Catch:{ all -> 0x00a3 }
            int r6 = r8.zzbho     // Catch:{ all -> 0x00a3 }
            android.os.WorkSource r7 = r8.zzbhn     // Catch:{ all -> 0x00a3 }
            java.util.List r7 = com.google.android.gms.internal.zznj.zzb(r7)     // Catch:{ all -> 0x00a3 }
            r0.zza(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00a3 }
            int r0 = r8.zzbhs     // Catch:{ all -> 0x00a3 }
            int r0 = r0 + -1
            r8.zzbhs = r0     // Catch:{ all -> 0x00a3 }
        L_0x00a1:
            monitor-exit(r8)     // Catch:{ all -> 0x00a3 }
            return
        L_0x00a3:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00a3 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzrp.zzfJ(java.lang.String):void");
    }

    private boolean zzfK(String str) {
        return !TextUtils.isEmpty(str) && !str.equals(this.zzbhp);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0087, code lost:
        if (r10.zzbhs == 0) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x007f, code lost:
        if (r0 == false) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzj(java.lang.String r11, long r12) {
        /*
            r10 = this;
            boolean r0 = r10.zzfK(r11)
            java.lang.String r5 = r10.zzn(r11, r0)
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x0072
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Acquire:\n mWakeLockName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r10.zzanQ
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\n mSecondaryName: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r10.zzbhp
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nmReferenceCounted: "
            java.lang.StringBuilder r2 = r2.append(r3)
            boolean r3 = r10.zzbhq
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "\nreason: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r11)
            java.lang.String r3 = "\nmOpenEventCount"
            java.lang.StringBuilder r2 = r2.append(r3)
            int r3 = r10.zzbhs
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
            boolean r1 = r10.zzbhq     // Catch:{ all -> 0x00ac }
            if (r1 == 0) goto L_0x0081
            int r1 = r10.zzbhr     // Catch:{ all -> 0x00ac }
            int r2 = r1 + 1
            r10.zzbhr = r2     // Catch:{ all -> 0x00ac }
            if (r1 == 0) goto L_0x0089
            if (r0 != 0) goto L_0x0089
        L_0x0081:
            boolean r0 = r10.zzbhq     // Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x00aa
            int r0 = r10.zzbhs     // Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x00aa
        L_0x0089:
            com.google.android.gms.common.stats.zzi r0 = com.google.android.gms.common.stats.zzi.zzrZ()     // Catch:{ all -> 0x00ac }
            android.content.Context r1 = r10.mContext     // Catch:{ all -> 0x00ac }
            android.os.PowerManager$WakeLock r2 = r10.zzbhm     // Catch:{ all -> 0x00ac }
            java.lang.String r2 = com.google.android.gms.common.stats.zzg.zza(r2, r5)     // Catch:{ all -> 0x00ac }
            r3 = 7
            java.lang.String r4 = r10.zzanQ     // Catch:{ all -> 0x00ac }
            int r6 = r10.zzbho     // Catch:{ all -> 0x00ac }
            android.os.WorkSource r7 = r10.zzbhn     // Catch:{ all -> 0x00ac }
            java.util.List r7 = com.google.android.gms.internal.zznj.zzb(r7)     // Catch:{ all -> 0x00ac }
            r8 = r12
            r0.zza(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00ac }
            int r0 = r10.zzbhs     // Catch:{ all -> 0x00ac }
            int r0 = r0 + 1
            r10.zzbhs = r0     // Catch:{ all -> 0x00ac }
        L_0x00aa:
            monitor-exit(r10)     // Catch:{ all -> 0x00ac }
            return
        L_0x00ac:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00ac }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzrp.zzj(java.lang.String, long):void");
    }

    private String zzn(String str, boolean z) {
        return this.zzbhq ? z ? str : this.zzbhp : this.zzbhp;
    }

    public void acquire(long timeout) {
        if (!zzne.zzsg() && this.zzbhq) {
            Log.wtf(TAG, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.zzanQ);
        }
        zzj((String) null, timeout);
        this.zzbhm.acquire(timeout);
    }

    public boolean isHeld() {
        return this.zzbhm.isHeld();
    }

    public void release() {
        zzfJ((String) null);
        this.zzbhm.release();
    }

    public void setReferenceCounted(boolean value) {
        this.zzbhm.setReferenceCounted(value);
        this.zzbhq = value;
    }

    public void zzc(WorkSource workSource) {
        if (zznj.zzaA(this.mContext) && workSource != null) {
            if (this.zzbhn != null) {
                this.zzbhn.add(workSource);
            } else {
                this.zzbhn = workSource;
            }
            this.zzbhm.setWorkSource(this.zzbhn);
        }
    }
}
