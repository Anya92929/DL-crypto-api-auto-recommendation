package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.List;

@zzin
public class zzgh implements zzfy {

    /* renamed from: a */
    private final AdRequestInfoParcel f6249a;

    /* renamed from: b */
    private final zzgj f6250b;

    /* renamed from: c */
    private final Context f6251c;

    /* renamed from: d */
    private final Object f6252d = new Object();

    /* renamed from: e */
    private final zzga f6253e;

    /* renamed from: f */
    private final boolean f6254f;

    /* renamed from: g */
    private final long f6255g;

    /* renamed from: h */
    private final long f6256h;

    /* renamed from: i */
    private final zzdk f6257i;

    /* renamed from: j */
    private final boolean f6258j;

    /* renamed from: k */
    private boolean f6259k = false;

    /* renamed from: l */
    private zzgd f6260l;

    /* renamed from: m */
    private List f6261m = new ArrayList();

    public zzgh(Context context, AdRequestInfoParcel adRequestInfoParcel, zzgj zzgj, zzga zzga, boolean z, boolean z2, long j, long j2, zzdk zzdk) {
        this.f6251c = context;
        this.f6249a = adRequestInfoParcel;
        this.f6250b = zzgj;
        this.f6253e = zzga;
        this.f6254f = z;
        this.f6258j = z2;
        this.f6255g = j;
        this.f6256h = j2;
        this.f6257i = zzdk;
    }

    public void cancel() {
        synchronized (this.f6252d) {
            this.f6259k = true;
            if (this.f6260l != null) {
                this.f6260l.cancel();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a8, code lost:
        r2 = r21.f6260l.zza(r21.f6255g, r21.f6256h);
        r21.f6261m.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c1, code lost:
        if (r2.zzbom != 0) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c3, code lost:
        com.google.android.gms.internal.zzkd.zzcv("Adapter succeeded.");
        r21.f6257i.zzh("mediation_network_succeed", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d5, code lost:
        if (r15.isEmpty() != false) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d7, code lost:
        r21.f6257i.zzh("mediation_networks_fail", android.text.TextUtils.join(",", r15));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e6, code lost:
        r21.f6257i.zza(r19, "mls");
        r21.f6257i.zza(r16, "ttm");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x010d, code lost:
        r15.add(r4);
        r21.f6257i.zza(r19, "mlf");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0123, code lost:
        if (r2.zzboo == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0125, code lost:
        com.google.android.gms.internal.zzkh.zzclc.post(new com.google.android.gms.internal.C1639io(r21, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzge zzd(java.util.List r22) {
        /*
            r21 = this;
            java.lang.String r2 = "Starting mediation."
            com.google.android.gms.internal.zzkd.zzcv(r2)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r0 = r21
            com.google.android.gms.internal.zzdk r2 = r0.f6257i
            com.google.android.gms.internal.zzdi r16 = r2.zzkg()
            java.util.Iterator r17 = r22.iterator()
        L_0x0016:
            boolean r2 = r17.hasNext()
            if (r2 == 0) goto L_0x0133
            java.lang.Object r7 = r17.next()
            com.google.android.gms.internal.zzfz r7 = (com.google.android.gms.internal.zzfz) r7
            java.lang.String r3 = "Trying mediation network: "
            java.lang.String r2 = r7.zzbmv
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r4 = r2.length()
            if (r4 == 0) goto L_0x0066
            java.lang.String r2 = r3.concat(r2)
        L_0x0034:
            com.google.android.gms.internal.zzkd.zzcw(r2)
            java.util.List r2 = r7.zzbmw
            java.util.Iterator r18 = r2.iterator()
        L_0x003d:
            boolean r2 = r18.hasNext()
            if (r2 == 0) goto L_0x0016
            java.lang.Object r4 = r18.next()
            java.lang.String r4 = (java.lang.String) r4
            r0 = r21
            com.google.android.gms.internal.zzdk r2 = r0.f6257i
            com.google.android.gms.internal.zzdi r19 = r2.zzkg()
            r0 = r21
            java.lang.Object r0 = r0.f6252d
            r20 = r0
            monitor-enter(r20)
            r0 = r21
            boolean r2 = r0.f6259k     // Catch:{ all -> 0x010a }
            if (r2 == 0) goto L_0x006c
            com.google.android.gms.internal.zzge r2 = new com.google.android.gms.internal.zzge     // Catch:{ all -> 0x010a }
            r3 = -1
            r2.<init>(r3)     // Catch:{ all -> 0x010a }
            monitor-exit(r20)     // Catch:{ all -> 0x010a }
        L_0x0065:
            return r2
        L_0x0066:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r3)
            goto L_0x0034
        L_0x006c:
            com.google.android.gms.internal.zzgd r2 = new com.google.android.gms.internal.zzgd     // Catch:{ all -> 0x010a }
            r0 = r21
            android.content.Context r3 = r0.f6251c     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.internal.zzgj r5 = r0.f6250b     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.internal.zzga r6 = r0.f6253e     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r8 = r0.f6249a     // Catch:{ all -> 0x010a }
            com.google.android.gms.ads.internal.client.AdRequestParcel r8 = r8.zzcar     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r9 = r0.f6249a     // Catch:{ all -> 0x010a }
            com.google.android.gms.ads.internal.client.AdSizeParcel r9 = r9.zzapa     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r10 = r0.f6249a     // Catch:{ all -> 0x010a }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r10 = r10.zzaow     // Catch:{ all -> 0x010a }
            r0 = r21
            boolean r11 = r0.f6254f     // Catch:{ all -> 0x010a }
            r0 = r21
            boolean r12 = r0.f6258j     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13 = r0.f6249a     // Catch:{ all -> 0x010a }
            com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel r13 = r13.zzapo     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r14 = r0.f6249a     // Catch:{ all -> 0x010a }
            java.util.List r14 = r14.zzaps     // Catch:{ all -> 0x010a }
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x010a }
            r0 = r21
            r0.f6260l = r2     // Catch:{ all -> 0x010a }
            monitor-exit(r20)     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.internal.zzgd r2 = r0.f6260l
            r0 = r21
            long r8 = r0.f6255g
            r0 = r21
            long r10 = r0.f6256h
            com.google.android.gms.internal.zzge r2 = r2.zza((long) r8, (long) r10)
            r0 = r21
            java.util.List r3 = r0.f6261m
            r3.add(r2)
            int r3 = r2.zzbom
            if (r3 != 0) goto L_0x010d
            java.lang.String r3 = "Adapter succeeded."
            com.google.android.gms.internal.zzkd.zzcv(r3)
            r0 = r21
            com.google.android.gms.internal.zzdk r3 = r0.f6257i
            java.lang.String r5 = "mediation_network_succeed"
            r3.zzh(r5, r4)
            boolean r3 = r15.isEmpty()
            if (r3 != 0) goto L_0x00e6
            r0 = r21
            com.google.android.gms.internal.zzdk r3 = r0.f6257i
            java.lang.String r4 = "mediation_networks_fail"
            java.lang.String r5 = ","
            java.lang.String r5 = android.text.TextUtils.join(r5, r15)
            r3.zzh(r4, r5)
        L_0x00e6:
            r0 = r21
            com.google.android.gms.internal.zzdk r3 = r0.f6257i
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "mls"
            r4[r5] = r6
            r0 = r19
            r3.zza(r0, r4)
            r0 = r21
            com.google.android.gms.internal.zzdk r3 = r0.f6257i
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "ttm"
            r4[r5] = r6
            r0 = r16
            r3.zza(r0, r4)
            goto L_0x0065
        L_0x010a:
            r2 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x010a }
            throw r2
        L_0x010d:
            r15.add(r4)
            r0 = r21
            com.google.android.gms.internal.zzdk r3 = r0.f6257i
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "mlf"
            r4[r5] = r6
            r0 = r19
            r3.zza(r0, r4)
            com.google.android.gms.internal.zzgk r3 = r2.zzboo
            if (r3 == 0) goto L_0x003d
            android.os.Handler r3 = com.google.android.gms.internal.zzkh.zzclc
            com.google.android.gms.internal.io r4 = new com.google.android.gms.internal.io
            r0 = r21
            r4.<init>(r0, r2)
            r3.post(r4)
            goto L_0x003d
        L_0x0133:
            boolean r2 = r15.isEmpty()
            if (r2 != 0) goto L_0x0148
            r0 = r21
            com.google.android.gms.internal.zzdk r2 = r0.f6257i
            java.lang.String r3 = "mediation_networks_fail"
            java.lang.String r4 = ","
            java.lang.String r4 = android.text.TextUtils.join(r4, r15)
            r2.zzh(r3, r4)
        L_0x0148:
            com.google.android.gms.internal.zzge r2 = new com.google.android.gms.internal.zzge
            r3 = 1
            r2.<init>(r3)
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgh.zzd(java.util.List):com.google.android.gms.internal.zzge");
    }

    public List zzmg() {
        return this.f6261m;
    }
}
