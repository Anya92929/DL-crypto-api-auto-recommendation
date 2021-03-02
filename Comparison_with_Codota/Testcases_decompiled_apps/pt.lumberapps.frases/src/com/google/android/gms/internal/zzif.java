package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzib;
import com.google.android.gms.internal.zzic;
import com.google.android.gms.internal.zzju;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@zzin
public class zzif extends zzib {

    /* renamed from: g */
    zzfy f6386g;

    /* renamed from: h */
    protected zzge f6387h;

    /* renamed from: i */
    private zzgj f6388i;

    /* renamed from: j */
    private zzga f6389j;

    /* renamed from: k */
    private final zzdk f6390k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final zzlh f6391l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f6392m;

    zzif(Context context, zzju.zza zza, zzgj zzgj, zzic.zza zza2, zzdk zzdk, zzlh zzlh) {
        super(context, zza, zza2);
        this.f6388i = zzgj;
        this.f6389j = zza.zzcig;
        this.f6390k = zzdk;
        this.f6391l = zzlh;
    }

    /* renamed from: a */
    private static String m7168a(zzge zzge) {
        String str = zzge.zzbon.zzbmx;
        int b = m7172b(zzge.zzbom);
        return new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(b).append(".").append(zzge.zzbos).toString();
    }

    /* renamed from: a */
    private static String m7169a(List list) {
        if (list == null) {
            return "".toString();
        }
        Iterator it = list.iterator();
        String str = "";
        while (it.hasNext()) {
            zzge zzge = (zzge) it.next();
            if (!(zzge == null || zzge.zzbon == null || TextUtils.isEmpty(zzge.zzbon.zzbmx))) {
                String valueOf = String.valueOf(str);
                String valueOf2 = String.valueOf(m7168a(zzge));
                str = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append(valueOf2).append("_").toString();
            }
        }
        return str.substring(0, Math.max(0, str.length() - 1));
    }

    /* renamed from: a */
    private void m7170a() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zzkh.zzclc.post(new C1682kd(this, countDownLatch));
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
            synchronized (this.f6379d) {
                if (!this.f6392m) {
                    throw new zzib.zza("View could not be prepared", 0);
                } else if (this.f6391l.isDestroyed()) {
                    throw new zzib.zza("Assets not loaded, web view is destroyed", 0);
                }
            }
        } catch (InterruptedException e) {
            String valueOf = String.valueOf(e);
            throw new zzib.zza(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Interrupted while waiting for latch : ").append(valueOf).toString(), 0);
        }
    }

    /* renamed from: b */
    private static int m7172b(int i) {
        switch (i) {
            case -1:
                return 4;
            case 0:
                return 0;
            case 1:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            default:
                return 6;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzju mo8502a(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.f6380e.zzcip;
        return new zzju(adRequestInfoParcel.zzcar, this.f6391l, this.f6381f.zzbnm, i, this.f6381f.zzbnn, this.f6381f.zzcca, this.f6381f.orientation, this.f6381f.zzbns, adRequestInfoParcel.zzcau, this.f6381f.zzcby, this.f6387h != null ? this.f6387h.zzbon : null, this.f6387h != null ? this.f6387h.zzboo : null, this.f6387h != null ? this.f6387h.zzbop : AdMobAdapter.class.getName(), this.f6389j, this.f6387h != null ? this.f6387h.zzboq : null, this.f6381f.zzcbz, this.f6380e.zzapa, this.f6381f.zzcbx, this.f6380e.zzcik, this.f6381f.zzccc, this.f6381f.zzccd, this.f6380e.zzcie, (zzh.zza) null, this.f6381f.zzccn, this.f6381f.zzcco, this.f6381f.zzccp, this.f6389j != null ? this.f6389j.zzbnx : false, this.f6381f.zzccr, this.f6386g != null ? m7169a(this.f6386g.zzmg()) : null, this.f6381f.zzbnp);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        r0 = r0.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8503a(long r6) {
        /*
            r5 = this;
            r1 = 0
            java.lang.Object r2 = r5.f6379d
            monitor-enter(r2)
            com.google.android.gms.internal.zzfy r0 = r5.mo8509b((long) r6)     // Catch:{ all -> 0x004a }
            r5.f6386g = r0     // Catch:{ all -> 0x004a }
            monitor-exit(r2)     // Catch:{ all -> 0x004a }
            java.util.ArrayList r2 = new java.util.ArrayList
            com.google.android.gms.internal.zzga r0 = r5.f6389j
            java.util.List r0 = r0.zzbnk
            r2.<init>(r0)
            com.google.android.gms.internal.zzju$zza r0 = r5.f6380e
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r0 = r0.zzcip
            com.google.android.gms.ads.internal.client.AdRequestParcel r0 = r0.zzcar
            android.os.Bundle r0 = r0.zzatw
            java.lang.String r3 = "com.google.ads.mediation.admob.AdMobAdapter"
            if (r0 == 0) goto L_0x0096
            android.os.Bundle r0 = r0.getBundle(r3)
            if (r0 == 0) goto L_0x0096
            java.lang.String r4 = "_skipMediation"
            boolean r0 = r0.getBoolean(r4)
        L_0x002c:
            if (r0 == 0) goto L_0x004d
            java.util.ListIterator r4 = r2.listIterator()
        L_0x0032:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x004d
            java.lang.Object r0 = r4.next()
            com.google.android.gms.internal.zzfz r0 = (com.google.android.gms.internal.zzfz) r0
            java.util.List r0 = r0.zzbmw
            boolean r0 = r0.contains(r3)
            if (r0 != 0) goto L_0x0032
            r4.remove()
            goto L_0x0032
        L_0x004a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004a }
            throw r0
        L_0x004d:
            com.google.android.gms.internal.zzfy r0 = r5.f6386g
            com.google.android.gms.internal.zzge r0 = r0.zzd(r2)
            r5.f6387h = r0
            com.google.android.gms.internal.zzge r0 = r5.f6387h
            int r0 = r0.zzbom
            switch(r0) {
                case 0: goto L_0x0084;
                case 1: goto L_0x007b;
                default: goto L_0x005c;
            }
        L_0x005c:
            com.google.android.gms.internal.zzib$zza r0 = new com.google.android.gms.internal.zzib$zza
            com.google.android.gms.internal.zzge r2 = r5.f6387h
            int r2 = r2.zzbom
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 40
            r3.<init>(r4)
            java.lang.String r4 = "Unexpected mediation result: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2, r1)
            throw r0
        L_0x007b:
            com.google.android.gms.internal.zzib$zza r0 = new com.google.android.gms.internal.zzib$zza
            java.lang.String r1 = "No fill from any mediation ad networks."
            r2 = 3
            r0.<init>(r1, r2)
            throw r0
        L_0x0084:
            com.google.android.gms.internal.zzge r0 = r5.f6387h
            com.google.android.gms.internal.zzfz r0 = r0.zzbon
            if (r0 == 0) goto L_0x0095
            com.google.android.gms.internal.zzge r0 = r5.f6387h
            com.google.android.gms.internal.zzfz r0 = r0.zzbon
            java.lang.String r0 = r0.zzbnf
            if (r0 == 0) goto L_0x0095
            r5.m7170a()
        L_0x0095:
            return
        L_0x0096:
            r0 = r1
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzif.mo8503a(long):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public zzfy mo8509b(long j) {
        if (this.f6389j.zzbnv != -1) {
            return new zzgg(this.f6377b, this.f6380e.zzcip, this.f6388i, this.f6389j, this.f6381f.zzauu, this.f6381f.zzauw, j, ((Long) zzdc.zzbbh.get()).longValue(), 2);
        }
        return new zzgh(this.f6377b, this.f6380e.zzcip, this.f6388i, this.f6389j, this.f6381f.zzauu, this.f6381f.zzauw, j, ((Long) zzdc.zzbbh.get()).longValue(), this.f6390k);
    }

    public void onStop() {
        synchronized (this.f6379d) {
            super.onStop();
            if (this.f6386g != null) {
                this.f6386g.cancel();
            }
        }
    }
}
