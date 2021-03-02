package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzin
public class zzgg implements zzfy {

    /* renamed from: a */
    private final AdRequestInfoParcel f6236a;

    /* renamed from: b */
    private final zzgj f6237b;

    /* renamed from: c */
    private final Context f6238c;

    /* renamed from: d */
    private final zzga f6239d;

    /* renamed from: e */
    private final boolean f6240e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final long f6241f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final long f6242g;

    /* renamed from: h */
    private final int f6243h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Object f6244i = new Object();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f6245j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Map f6246k = new HashMap();

    /* renamed from: l */
    private final boolean f6247l;

    /* renamed from: m */
    private List f6248m = new ArrayList();

    public zzgg(Context context, AdRequestInfoParcel adRequestInfoParcel, zzgj zzgj, zzga zzga, boolean z, boolean z2, long j, long j2, int i) {
        this.f6238c = context;
        this.f6236a = adRequestInfoParcel;
        this.f6237b = zzgj;
        this.f6239d = zzga;
        this.f6240e = z;
        this.f6247l = z2;
        this.f6241f = j;
        this.f6242g = j2;
        this.f6243h = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r2.hasNext() == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        r0 = (com.google.android.gms.internal.zzky) r2.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1 = (com.google.android.gms.internal.zzge) r0.get();
        r4.f6248m.add(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        if (r1 == null) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r1.zzbom != 0) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        m7099a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        com.google.android.gms.internal.zzkd.zzd("Exception while processing an adapter; continuing with other adapters", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        m7099a((com.google.android.gms.internal.zzky) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return new com.google.android.gms.internal.zzge(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r2 = r5.iterator();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.internal.zzge m7097a(java.util.List r5) {
        /*
            r4 = this;
            java.lang.Object r2 = r4.f6244i
            monitor-enter(r2)
            boolean r0 = r4.f6245j     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.zzge r1 = new com.google.android.gms.internal.zzge     // Catch:{ all -> 0x003c }
            r0 = -1
            r1.<init>(r0)     // Catch:{ all -> 0x003c }
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
        L_0x000e:
            return r1
        L_0x000f:
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            java.util.Iterator r2 = r5.iterator()
        L_0x0014:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x003f
            java.lang.Object r0 = r2.next()
            com.google.android.gms.internal.zzky r0 = (com.google.android.gms.internal.zzky) r0
            java.lang.Object r1 = r0.get()     // Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
            com.google.android.gms.internal.zzge r1 = (com.google.android.gms.internal.zzge) r1     // Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
            java.util.List r3 = r4.f6248m     // Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
            r3.add(r1)     // Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
            if (r1 == 0) goto L_0x0014
            int r3 = r1.zzbom     // Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
            if (r3 != 0) goto L_0x0014
            r4.m7099a((com.google.android.gms.internal.zzky) r0)     // Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
            goto L_0x000e
        L_0x0035:
            r0 = move-exception
        L_0x0036:
            java.lang.String r1 = "Exception while processing an adapter; continuing with other adapters"
            com.google.android.gms.internal.zzkd.zzd(r1, r0)
            goto L_0x0014
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            throw r0
        L_0x003f:
            r0 = 0
            r4.m7099a((com.google.android.gms.internal.zzky) r0)
            com.google.android.gms.internal.zzge r1 = new com.google.android.gms.internal.zzge
            r0 = 1
            r1.<init>(r0)
            goto L_0x000e
        L_0x004a:
            r0 = move-exception
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgg.m7097a(java.util.List):com.google.android.gms.internal.zzge");
    }

    /* renamed from: a */
    private void m7099a(zzky zzky) {
        zzkh.zzclc.post(new C1638in(this, zzky));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        r0 = r15.f6239d.zzbnw;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        r8 = r16.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r8.hasNext() == false) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        r0 = (com.google.android.gms.internal.zzky) r8.next();
        r10 = com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        if (r6 != 0) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        if (r0.isDone() == false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        r1 = (com.google.android.gms.internal.zzge) r0.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        r15.f6248m.add(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (r1 == null) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r1.zzbom != 0) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        r5 = r1.zzbor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        if (r5 == null) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005f, code lost:
        if (r5.zzmm() <= r4) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
        r2 = r5.zzmm();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        r14 = r1;
        r1 = r0;
        r0 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        r3 = r1;
        r14 = r0;
        r0 = java.lang.Math.max(r6 - (com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis() - r10), 0);
        r4 = r2;
        r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0083, code lost:
        r0 = 10000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r1 = (com.google.android.gms.internal.zzge) r0.get(r6, java.util.concurrent.TimeUnit.MILLISECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        com.google.android.gms.internal.zzkd.zzd("Exception while processing an adapter; continuing with other adapters", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0095, code lost:
        r0 = java.lang.Math.max(r6 - (com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis() - r10), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a8, code lost:
        java.lang.Math.max(r6 - (com.google.android.gms.ads.internal.zzu.zzfu().currentTimeMillis() - r10), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b8, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b9, code lost:
        m7099a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bc, code lost:
        if (r2 != null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00cc, code lost:
        r0 = r2;
        r1 = r3;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return new com.google.android.gms.internal.zzge(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r4 = -1;
        r3 = null;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r15.f6239d.zzbnw == -1) goto L_0x0083;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.internal.zzge m7100b(java.util.List r16) {
        /*
            r15 = this;
            java.lang.Object r1 = r15.f6244i
            monitor-enter(r1)
            boolean r0 = r15.f6245j     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.zzge r2 = new com.google.android.gms.internal.zzge     // Catch:{ all -> 0x0080 }
            r0 = -1
            r2.<init>(r0)     // Catch:{ all -> 0x0080 }
            monitor-exit(r1)     // Catch:{ all -> 0x0080 }
        L_0x000e:
            return r2
        L_0x000f:
            monitor-exit(r1)     // Catch:{ all -> 0x0080 }
            r4 = -1
            r3 = 0
            r2 = 0
            com.google.android.gms.internal.zzga r0 = r15.f6239d
            long r0 = r0.zzbnw
            r6 = -1
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0083
            com.google.android.gms.internal.zzga r0 = r15.f6239d
            long r0 = r0.zzbnw
        L_0x0021:
            java.util.Iterator r8 = r16.iterator()
            r6 = r0
        L_0x0026:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00b9
            java.lang.Object r0 = r8.next()
            com.google.android.gms.internal.zzky r0 = (com.google.android.gms.internal.zzky) r0
            com.google.android.gms.common.util.zze r1 = com.google.android.gms.ads.internal.zzu.zzfu()
            long r10 = r1.currentTimeMillis()
            r12 = 0
            int r1 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x0086
            boolean r1 = r0.isDone()     // Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
            if (r1 == 0) goto L_0x0086
            java.lang.Object r1 = r0.get()     // Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
            com.google.android.gms.internal.zzge r1 = (com.google.android.gms.internal.zzge) r1     // Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        L_0x004c:
            java.util.List r5 = r15.f6248m     // Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
            r5.add(r1)     // Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
            if (r1 == 0) goto L_0x00cc
            int r5 = r1.zzbom     // Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
            if (r5 != 0) goto L_0x00cc
            com.google.android.gms.internal.zzgm r5 = r1.zzbor     // Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
            if (r5 == 0) goto L_0x00cc
            int r9 = r5.zzmm()     // Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
            if (r9 <= r4) goto L_0x00cc
            int r2 = r5.zzmm()     // Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
            r14 = r1
            r1 = r0
            r0 = r14
        L_0x0068:
            com.google.android.gms.common.util.zze r3 = com.google.android.gms.ads.internal.zzu.zzfu()
            long r4 = r3.currentTimeMillis()
            long r4 = r4 - r10
            long r4 = r6 - r4
            r6 = 0
            long r4 = java.lang.Math.max(r4, r6)
            r3 = r1
            r14 = r0
            r0 = r4
            r4 = r2
            r2 = r14
        L_0x007e:
            r6 = r0
            goto L_0x0026
        L_0x0080:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0080 }
            throw r0
        L_0x0083:
            r0 = 10000(0x2710, double:4.9407E-320)
            goto L_0x0021
        L_0x0086:
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
            java.lang.Object r1 = r0.get(r6, r1)     // Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
            com.google.android.gms.internal.zzge r1 = (com.google.android.gms.internal.zzge) r1     // Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
            goto L_0x004c
        L_0x008f:
            r0 = move-exception
        L_0x0090:
            java.lang.String r1 = "Exception while processing an adapter; continuing with other adapters"
            com.google.android.gms.internal.zzkd.zzd(r1, r0)     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.common.util.zze r0 = com.google.android.gms.ads.internal.zzu.zzfu()
            long r0 = r0.currentTimeMillis()
            long r0 = r0 - r10
            long r0 = r6 - r0
            r6 = 0
            long r0 = java.lang.Math.max(r0, r6)
            goto L_0x007e
        L_0x00a7:
            r0 = move-exception
            com.google.android.gms.common.util.zze r1 = com.google.android.gms.ads.internal.zzu.zzfu()
            long r2 = r1.currentTimeMillis()
            long r2 = r2 - r10
            long r2 = r6 - r2
            r4 = 0
            java.lang.Math.max(r2, r4)
            throw r0
        L_0x00b9:
            r15.m7099a((com.google.android.gms.internal.zzky) r3)
            if (r2 != 0) goto L_0x000e
            com.google.android.gms.internal.zzge r2 = new com.google.android.gms.internal.zzge
            r0 = 1
            r2.<init>(r0)
            goto L_0x000e
        L_0x00c6:
            r0 = move-exception
            goto L_0x0090
        L_0x00c8:
            r0 = move-exception
            goto L_0x0090
        L_0x00ca:
            r0 = move-exception
            goto L_0x0090
        L_0x00cc:
            r0 = r2
            r1 = r3
            r2 = r4
            goto L_0x0068
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgg.m7100b(java.util.List):com.google.android.gms.internal.zzge");
    }

    public void cancel() {
        synchronized (this.f6244i) {
            this.f6245j = true;
            for (zzgd cancel : this.f6246k.values()) {
                cancel.cancel();
            }
        }
    }

    public zzge zzd(List list) {
        zzkd.zzcv("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfz zzfz = (zzfz) it.next();
            String valueOf = String.valueOf(zzfz.zzbmv);
            zzkd.zzcw(valueOf.length() != 0 ? "Trying mediation network: ".concat(valueOf) : new String("Trying mediation network: "));
            for (String zzgd : zzfz.zzbmw) {
                zzgd zzgd2 = new zzgd(this.f6238c, zzgd, this.f6237b, this.f6239d, zzfz, this.f6236a.zzcar, this.f6236a.zzapa, this.f6236a.zzaow, this.f6240e, this.f6247l, this.f6236a.zzapo, this.f6236a.zzaps);
                zzky zza = zzkg.zza(newCachedThreadPool, (Callable) new C1637im(this, zzgd2));
                this.f6246k.put(zza, zzgd2);
                arrayList.add(zza);
            }
        }
        switch (this.f6243h) {
            case 2:
                return m7100b((List) arrayList);
            default:
                return m7097a((List) arrayList);
        }
    }

    public List zzmg() {
        return this.f6248m;
    }
}
