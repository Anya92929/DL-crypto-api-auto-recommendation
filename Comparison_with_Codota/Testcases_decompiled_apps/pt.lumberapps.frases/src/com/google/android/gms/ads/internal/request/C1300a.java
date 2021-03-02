package com.google.android.gms.ads.internal.request;

import java.io.OutputStream;

/* renamed from: com.google.android.gms.ads.internal.request.a */
class C1300a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ OutputStream f3911a;

    /* renamed from: b */
    final /* synthetic */ byte[] f3912b;

    /* renamed from: c */
    final /* synthetic */ LargeParcelTeleporter f3913c;

    C1300a(LargeParcelTeleporter largeParcelTeleporter, OutputStream outputStream, byte[] bArr) {
        this.f3913c = largeParcelTeleporter;
        this.f3911a = outputStream;
        this.f3912b = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            r2 = 0
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0017, all -> 0x0032 }
            java.io.OutputStream r0 = r4.f3911a     // Catch:{ IOException -> 0x0017, all -> 0x0032 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0017, all -> 0x0032 }
            byte[] r0 = r4.f3912b     // Catch:{ IOException -> 0x0042 }
            int r0 = r0.length     // Catch:{ IOException -> 0x0042 }
            r1.writeInt(r0)     // Catch:{ IOException -> 0x0042 }
            byte[] r0 = r4.f3912b     // Catch:{ IOException -> 0x0042 }
            r1.write(r0)     // Catch:{ IOException -> 0x0042 }
            com.google.android.gms.common.util.zzo.zzb(r1)
        L_0x0016:
            return
        L_0x0017:
            r0 = move-exception
            r1 = r2
        L_0x0019:
            java.lang.String r2 = "Error transporting the ad response"
            com.google.android.gms.internal.zzkd.zzb(r2, r0)     // Catch:{ all -> 0x0040 }
            com.google.android.gms.internal.zzjx r2 = com.google.android.gms.ads.internal.zzu.zzft()     // Catch:{ all -> 0x0040 }
            r3 = 1
            r2.zzb((java.lang.Throwable) r0, (boolean) r3)     // Catch:{ all -> 0x0040 }
            if (r1 != 0) goto L_0x002e
            java.io.OutputStream r0 = r4.f3911a
            com.google.android.gms.common.util.zzo.zzb(r0)
            goto L_0x0016
        L_0x002e:
            com.google.android.gms.common.util.zzo.zzb(r1)
            goto L_0x0016
        L_0x0032:
            r0 = move-exception
            r1 = r2
        L_0x0034:
            if (r1 != 0) goto L_0x003c
            java.io.OutputStream r1 = r4.f3911a
            com.google.android.gms.common.util.zzo.zzb(r1)
        L_0x003b:
            throw r0
        L_0x003c:
            com.google.android.gms.common.util.zzo.zzb(r1)
            goto L_0x003b
        L_0x0040:
            r0 = move-exception
            goto L_0x0034
        L_0x0042:
            r0 = move-exception
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.C1300a.run():void");
    }
}
