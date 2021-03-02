package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzju;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzjl extends zzkc implements zzjk {

    /* renamed from: a */
    private final zzju.zza f6525a;

    /* renamed from: b */
    private final Context f6526b;

    /* renamed from: c */
    private final ArrayList f6527c = new ArrayList();

    /* renamed from: d */
    private final ArrayList f6528d = new ArrayList();

    /* renamed from: e */
    private final HashSet f6529e = new HashSet();

    /* renamed from: f */
    private final Object f6530f = new Object();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzjf f6531g;

    public zzjl(Context context, zzju.zza zza, zzjf zzjf) {
        this.f6526b = context;
        this.f6525a = zza;
        this.f6531g = zzjf;
    }

    /* renamed from: a */
    private zzju m7280a() {
        return m7281a(3, (String) null, (zzfz) null);
    }

    /* renamed from: a */
    private zzju m7281a(int i, String str, zzfz zzfz) {
        return new zzju(this.f6525a.zzcip.zzcar, (zzlh) null, this.f6525a.zzciq.zzbnm, i, this.f6525a.zzciq.zzbnn, this.f6525a.zzciq.zzcca, this.f6525a.zzciq.orientation, this.f6525a.zzciq.zzbns, this.f6525a.zzcip.zzcau, this.f6525a.zzciq.zzcby, zzfz, (zzgk) null, str, this.f6525a.zzcig, (zzgc) null, this.f6525a.zzciq.zzcbz, this.f6525a.zzapa, this.f6525a.zzciq.zzcbx, this.f6525a.zzcik, this.f6525a.zzciq.zzccc, this.f6525a.zzciq.zzccd, this.f6525a.zzcie, (zzh.zza) null, this.f6525a.zzciq.zzccn, this.f6525a.zzciq.zzcco, this.f6525a.zzciq.zzccp, this.f6525a.zzciq.zzccq, this.f6525a.zzciq.zzccr, (String) null, this.f6525a.zzciq.zzbnp);
    }

    /* renamed from: a */
    private zzju m7282a(String str, zzfz zzfz) {
        return m7281a(-2, str, zzfz);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7283a(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            java.lang.Object r1 = r3.f6530f
            monitor-enter(r1)
            com.google.android.gms.internal.zzjf r0 = r3.f6531g     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.zzjm r0 = r0.zzcf(r4)     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.zzjj r2 = r0.zzrv()     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x0017
            com.google.android.gms.internal.zzgk r2 = r0.zzru()     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0019
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
        L_0x0018:
            return
        L_0x0019:
            com.google.android.gms.internal.zzjg r0 = r3.mo8571a(r4, r5, r6, r0)     // Catch:{ all -> 0x002f }
            java.util.ArrayList r2 = r3.f6527c     // Catch:{ all -> 0x002f }
            java.lang.Object r0 = r0.zzpy()     // Catch:{ all -> 0x002f }
            java.util.concurrent.Future r0 = (java.util.concurrent.Future) r0     // Catch:{ all -> 0x002f }
            r2.add(r0)     // Catch:{ all -> 0x002f }
            java.util.ArrayList r0 = r3.f6528d     // Catch:{ all -> 0x002f }
            r0.add(r4)     // Catch:{ all -> 0x002f }
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
            goto L_0x0018
        L_0x002f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjl.m7283a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzjg mo8571a(String str, String str2, String str3, zzjm zzjm) {
        return new zzjg(this.f6526b, str, str2, str3, this.f6525a, zzjm, this);
    }

    public void onStop() {
    }

    public void zza(String str, int i) {
    }

    public void zzcg(String str) {
        synchronized (this.f6530f) {
            this.f6529e.add(str);
        }
    }

    public void zzew() {
        for (zzfz zzfz : this.f6525a.zzcig.zzbnk) {
            String str = zzfz.zzbnc;
            for (String str2 : zzfz.zzbmw) {
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str2)) {
                    try {
                        str2 = new JSONObject(str).getString("class_name");
                    } catch (JSONException e) {
                        zzkd.zzb("Unable to determine custom event class name, skipping...", e);
                    }
                }
                m7283a(str2, str, zzfz.zzbmu);
            }
        }
        int i = 0;
        while (i < this.f6527c.size()) {
            try {
                ((Future) this.f6527c.get(i)).get();
                synchronized (this.f6530f) {
                    if (this.f6529e.contains(this.f6528d.get(i))) {
                        zza.zzcnb.post(new C1711lf(this, m7282a((String) this.f6528d.get(i), (zzfz) this.f6525a.zzcig.zzbnk.get(i))));
                        return;
                    }
                }
            } catch (InterruptedException e2) {
            } catch (Exception e3) {
            }
        }
        zza.zzcnb.post(new C1712lg(this, m7280a()));
        return;
        i++;
    }
}
