package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.p009v4.p019f.C0150o;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkh;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzin
public class zzj extends zzr.zza {

    /* renamed from: a */
    private final Context f4025a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzq f4026b;

    /* renamed from: c */
    private final zzgj f4027c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzeb f4028d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzec f4029e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C0150o f4030f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C0150o f4031g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final NativeAdOptionsParcel f4032h;

    /* renamed from: i */
    private final List f4033i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final zzy f4034j;

    /* renamed from: k */
    private final String f4035k;

    /* renamed from: l */
    private final VersionInfoParcel f4036l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public WeakReference f4037m;

    /* renamed from: n */
    private final zzd f4038n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final Object f4039o = new Object();

    zzj(Context context, String str, zzgj zzgj, VersionInfoParcel versionInfoParcel, zzq zzq, zzeb zzeb, zzec zzec, C0150o oVar, C0150o oVar2, NativeAdOptionsParcel nativeAdOptionsParcel, zzy zzy, zzd zzd) {
        this.f4025a = context;
        this.f4035k = str;
        this.f4027c = zzgj;
        this.f4036l = versionInfoParcel;
        this.f4026b = zzq;
        this.f4029e = zzec;
        this.f4028d = zzeb;
        this.f4030f = oVar;
        this.f4031g = oVar2;
        this.f4032h = nativeAdOptionsParcel;
        this.f4033i = m5809b();
        this.f4034j = zzy;
        this.f4038n = zzd;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List m5809b() {
        ArrayList arrayList = new ArrayList();
        if (this.f4029e != null) {
            arrayList.add("1");
        }
        if (this.f4028d != null) {
            arrayList.add("2");
        }
        if (this.f4030f.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzq mo5859a() {
        return new zzq(this.f4025a, this.f4038n, AdSizeParcel.zzk(this.f4025a), this.f4035k, this.f4027c, this.f4036l);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5860a(Runnable runnable) {
        zzkh.zzclc.post(runnable);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMediationAdapterClassName() {
        /*
            r3 = this;
            r1 = 0
            java.lang.Object r2 = r3.f4039o
            monitor-enter(r2)
            java.lang.ref.WeakReference r0 = r3.f4037m     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001a
            java.lang.ref.WeakReference r0 = r3.f4037m     // Catch:{ all -> 0x001d }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x001d }
            com.google.android.gms.ads.internal.zzq r0 = (com.google.android.gms.ads.internal.zzq) r0     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r0.getMediationAdapterClassName()     // Catch:{ all -> 0x001d }
        L_0x0016:
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
        L_0x0017:
            return r0
        L_0x0018:
            r0 = r1
            goto L_0x0016
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            r0 = r1
            goto L_0x0017
        L_0x001d:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzj.getMediationAdapterClassName():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isLoading() {
        /*
            r3 = this;
            r1 = 0
            java.lang.Object r2 = r3.f4039o
            monitor-enter(r2)
            java.lang.ref.WeakReference r0 = r3.f4037m     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001a
            java.lang.ref.WeakReference r0 = r3.f4037m     // Catch:{ all -> 0x001d }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x001d }
            com.google.android.gms.ads.internal.zzq r0 = (com.google.android.gms.ads.internal.zzq) r0     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.isLoading()     // Catch:{ all -> 0x001d }
        L_0x0016:
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
        L_0x0017:
            return r0
        L_0x0018:
            r0 = r1
            goto L_0x0016
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            r0 = r1
            goto L_0x0017
        L_0x001d:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzj.isLoading():boolean");
    }

    public void zzf(AdRequestParcel adRequestParcel) {
        mo5860a((Runnable) new C1298q(this, adRequestParcel));
    }
}
