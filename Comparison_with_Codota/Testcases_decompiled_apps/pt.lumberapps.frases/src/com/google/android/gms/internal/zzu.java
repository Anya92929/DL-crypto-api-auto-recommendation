package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class zzu {

    /* renamed from: a */
    protected static final Comparator f7005a = new C1866qz();

    /* renamed from: b */
    private List f7006b = new LinkedList();

    /* renamed from: c */
    private List f7007c = new ArrayList(64);

    /* renamed from: d */
    private int f7008d = 0;

    /* renamed from: e */
    private final int f7009e;

    public zzu(int i) {
        this.f7009e = i;
    }

    /* renamed from: a */
    private synchronized void m7563a() {
        while (this.f7008d > this.f7009e) {
            byte[] bArr = (byte[]) this.f7006b.remove(0);
            this.f7007c.remove(bArr);
            this.f7008d -= bArr.length;
        }
    }

    public synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f7009e) {
                this.f7006b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f7007c, bArr, f7005a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f7007c.add(binarySearch, bArr);
                this.f7008d += bArr.length;
                m7563a();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0 = new byte[r5];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] zzb(int r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r1 = r0
        L_0x0003:
            java.util.List r0 = r4.f7007c     // Catch:{ all -> 0x002f }
            int r0 = r0.size()     // Catch:{ all -> 0x002f }
            if (r1 >= r0) goto L_0x002c
            java.util.List r0 = r4.f7007c     // Catch:{ all -> 0x002f }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x002f }
            byte[] r0 = (byte[]) r0     // Catch:{ all -> 0x002f }
            int r2 = r0.length     // Catch:{ all -> 0x002f }
            if (r2 < r5) goto L_0x0028
            int r2 = r4.f7008d     // Catch:{ all -> 0x002f }
            int r3 = r0.length     // Catch:{ all -> 0x002f }
            int r2 = r2 - r3
            r4.f7008d = r2     // Catch:{ all -> 0x002f }
            java.util.List r2 = r4.f7007c     // Catch:{ all -> 0x002f }
            r2.remove(r1)     // Catch:{ all -> 0x002f }
            java.util.List r1 = r4.f7006b     // Catch:{ all -> 0x002f }
            r1.remove(r0)     // Catch:{ all -> 0x002f }
        L_0x0026:
            monitor-exit(r4)
            return r0
        L_0x0028:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x0003
        L_0x002c:
            byte[] r0 = new byte[r5]     // Catch:{ all -> 0x002f }
            goto L_0x0026
        L_0x002f:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzu.zzb(int):byte[]");
    }
}
