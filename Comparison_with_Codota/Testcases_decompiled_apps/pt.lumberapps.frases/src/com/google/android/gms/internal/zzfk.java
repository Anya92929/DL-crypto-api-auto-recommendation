package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zziv;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

@zzin
public class zzfk {

    /* renamed from: a */
    private final Map f6183a = new HashMap();

    /* renamed from: b */
    private final LinkedList f6184b = new LinkedList();

    /* renamed from: c */
    private zzfh f6185c;

    /* renamed from: a */
    static Bundle m7031a(AdRequestParcel adRequestParcel) {
        Bundle bundle = adRequestParcel.zzatw;
        if (bundle == null) {
            return null;
        }
        return bundle.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
    }

    /* renamed from: a */
    private static void m7032a(Bundle bundle, String str) {
        String[] split = str.split("/", 2);
        if (split.length != 0) {
            String str2 = split[0];
            if (split.length == 1) {
                bundle.remove(str2);
                return;
            }
            Bundle bundle2 = bundle.getBundle(str2);
            if (bundle2 != null) {
                m7032a(bundle2, split[1]);
            }
        }
    }

    /* renamed from: a */
    private static void m7033a(String str, C1603hf hfVar) {
        if (zzkd.zzaz(2)) {
            zzkd.m7303v(String.format(str, new Object[]{hfVar}));
        }
    }

    /* renamed from: a */
    private String[] m7034a(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    /* renamed from: b */
    static AdRequestParcel m7035b(AdRequestParcel adRequestParcel) {
        Parcel obtain = Parcel.obtain();
        adRequestParcel.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        AdRequestParcel adRequestParcel2 = (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        Bundle a = m7031a(adRequestParcel2);
        if (a == null) {
            a = new Bundle();
            adRequestParcel2.zzatw.putBundle("com.google.ads.mediation.admob.AdMobAdapter", a);
        }
        a.putBoolean("_skipMediation", true);
        return adRequestParcel2;
    }

    /* renamed from: b */
    private boolean m7036b(String str) {
        try {
            return Pattern.matches((String) zzdc.zzbal.get(), str);
        } catch (RuntimeException e) {
            zzu.zzft().zzb((Throwable) e, true);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r1.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean m7037c(com.google.android.gms.ads.internal.client.AdRequestParcel r3) {
        /*
            r0 = 0
            android.os.Bundle r1 = r3.zzatw
            if (r1 != 0) goto L_0x0006
        L_0x0005:
            return r0
        L_0x0006:
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobAdapter"
            android.os.Bundle r1 = r1.getBundle(r2)
            if (r1 == 0) goto L_0x0005
            java.lang.String r2 = "_skipMediation"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L_0x0005
            r0 = 1
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfk.m7037c(com.google.android.gms.ads.internal.client.AdRequestParcel):boolean");
    }

    /* renamed from: d */
    private static AdRequestParcel m7038d(AdRequestParcel adRequestParcel) {
        Parcel obtain = Parcel.obtain();
        adRequestParcel.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        AdRequestParcel adRequestParcel2 = (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        for (String a : ((String) zzdc.zzbah.get()).split(",")) {
            m7032a(adRequestParcel2.zzatw, a);
        }
        return adRequestParcel2;
    }

    /* renamed from: e */
    private String m7039e() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator it = this.f6184b.iterator();
            while (it.hasNext()) {
                sb.append(Base64.encodeToString(((C1603hf) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    sb.append("\u0000");
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1605hh mo8369a(AdRequestParcel adRequestParcel, String str) {
        C1604hg hgVar;
        if (m7036b(str)) {
            return null;
        }
        int i = new zziv.zza(this.f6185c.getApplicationContext()).zzrn().zzcgp;
        AdRequestParcel d = m7038d(adRequestParcel);
        C1603hf hfVar = new C1603hf(d, str, i);
        C1604hg hgVar2 = (C1604hg) this.f6183a.get(hfVar);
        if (hgVar2 == null) {
            m7033a("Interstitial pool created at %s.", hfVar);
            C1604hg hgVar3 = new C1604hg(d, str, i);
            this.f6183a.put(hfVar, hgVar3);
            hgVar = hgVar3;
        } else {
            hgVar = hgVar2;
        }
        this.f6184b.remove(hfVar);
        this.f6184b.add(hfVar);
        hgVar.mo7303g();
        while (this.f6184b.size() > ((Integer) zzdc.zzbai.get()).intValue()) {
            C1603hf hfVar2 = (C1603hf) this.f6184b.remove();
            C1604hg hgVar4 = (C1604hg) this.f6183a.get(hfVar2);
            m7033a("Evicting interstitial queue for %s.", hfVar2);
            while (hgVar4.mo7300d() > 0) {
                hgVar4.mo7295a((AdRequestParcel) null).f5076a.zzeu();
            }
            this.f6183a.remove(hfVar2);
        }
        while (hgVar.mo7300d() > 0) {
            C1605hh a = hgVar.mo7295a(d);
            if (!a.f5080e || zzu.zzfu().currentTimeMillis() - a.f5079d <= 1000 * ((long) ((Integer) zzdc.zzbak.get()).intValue())) {
                String str2 = a.f5077b != null ? " (inline) " : " ";
                m7033a(new StringBuilder(String.valueOf(str2).length() + 34).append("Pooled interstitial").append(str2).append("returned at %s.").toString(), hfVar);
                return a;
            }
            m7033a("Expired interstitial at %s.", hfVar);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
        r2 = r0.mo7300d();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8370a() {
        /*
            r9 = this;
            r8 = 2
            com.google.android.gms.internal.zzfh r0 = r9.f6185c
            if (r0 != 0) goto L_0x0006
        L_0x0005:
            return
        L_0x0006:
            java.util.Map r0 = r9.f6183a
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r3 = r0.iterator()
        L_0x0010:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0076
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            com.google.android.gms.internal.hf r1 = (com.google.android.gms.internal.C1603hf) r1
            java.lang.Object r0 = r0.getValue()
            com.google.android.gms.internal.hg r0 = (com.google.android.gms.internal.C1604hg) r0
            boolean r2 = com.google.android.gms.internal.zzkd.zzaz(r8)
            if (r2 == 0) goto L_0x0056
            int r2 = r0.mo7300d()
            int r4 = r0.mo7301e()
            if (r4 >= r2) goto L_0x0056
            java.lang.String r5 = "Loading %s/%s pooled interstitials for %s."
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r7 = 0
            int r4 = r2 - r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6[r7] = r4
            r4 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6[r4] = r2
            r6[r8] = r1
            java.lang.String r2 = java.lang.String.format(r5, r6)
            com.google.android.gms.internal.zzkd.m7303v(r2)
        L_0x0056:
            r0.mo7302f()
        L_0x0059:
            int r4 = r0.mo7300d()
            com.google.android.gms.internal.zzcy r2 = com.google.android.gms.internal.zzdc.zzbaj
            java.lang.Object r2 = r2.get()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r4 >= r2) goto L_0x0010
            java.lang.String r2 = "Pooling and loading one new interstitial for %s."
            m7033a((java.lang.String) r2, (com.google.android.gms.internal.C1603hf) r1)
            com.google.android.gms.internal.zzfh r2 = r9.f6185c
            r0.mo7296a((com.google.android.gms.internal.zzfh) r2)
            goto L_0x0059
        L_0x0076:
            r9.mo8372b()
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfk.mo8370a():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8371a(zzfh zzfh) {
        if (this.f6185c == null) {
            this.f6185c = zzfh.zzln();
            mo8374c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8372b() {
        if (this.f6185c != null) {
            SharedPreferences.Editor edit = this.f6185c.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Map.Entry entry : this.f6183a.entrySet()) {
                C1603hf hfVar = (C1603hf) entry.getKey();
                C1604hg hgVar = (C1604hg) entry.getValue();
                if (hgVar.mo7304h()) {
                    edit.putString(hfVar.toString(), new C1606hi(hgVar).mo7306a());
                    m7033a("Saved interstitial queue for %s.", hfVar);
                }
            }
            edit.putString("PoolKeys", m7039e());
            edit.apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8373b(AdRequestParcel adRequestParcel, String str) {
        if (this.f6185c != null) {
            int i = new zziv.zza(this.f6185c.getApplicationContext()).zzrn().zzcgp;
            AdRequestParcel d = m7038d(adRequestParcel);
            C1603hf hfVar = new C1603hf(d, str, i);
            C1604hg hgVar = (C1604hg) this.f6183a.get(hfVar);
            if (hgVar == null) {
                m7033a("Interstitial pool created at %s.", hfVar);
                hgVar = new C1604hg(d, str, i);
                this.f6183a.put(hfVar, hgVar);
            }
            hgVar.mo7297a(this.f6185c, adRequestParcel);
            hgVar.mo7303g();
            m7033a("Inline entry added to the queue at %s.", hfVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo8374c() {
        if (this.f6185c != null) {
            SharedPreferences sharedPreferences = this.f6185c.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
            mo8375d();
            HashMap hashMap = new HashMap();
            for (Map.Entry next : sharedPreferences.getAll().entrySet()) {
                try {
                    if (!((String) next.getKey()).equals("PoolKeys")) {
                        C1606hi hiVar = new C1606hi((String) next.getValue());
                        C1603hf hfVar = new C1603hf(hiVar.f5083a, hiVar.f5084b, hiVar.f5085c);
                        if (!this.f6183a.containsKey(hfVar)) {
                            this.f6183a.put(hfVar, new C1604hg(hiVar.f5083a, hiVar.f5084b, hiVar.f5085c));
                            hashMap.put(hfVar.toString(), hfVar);
                            m7033a("Restored interstitial queue for %s.", hfVar);
                        }
                    }
                } catch (IOException | ClassCastException e) {
                    zzkd.zzd("Malformed preferences value for InterstitialAdPool.", e);
                }
            }
            for (String str : m7034a(sharedPreferences.getString("PoolKeys", ""))) {
                C1603hf hfVar2 = (C1603hf) hashMap.get(str);
                if (this.f6183a.containsKey(hfVar2)) {
                    this.f6184b.add(hfVar2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo8375d() {
        while (this.f6184b.size() > 0) {
            C1603hf hfVar = (C1603hf) this.f6184b.remove();
            C1604hg hgVar = (C1604hg) this.f6183a.get(hfVar);
            m7033a("Flushing interstitial queue for %s.", hfVar);
            while (hgVar.mo7300d() > 0) {
                hgVar.mo7295a((AdRequestParcel) null).f5076a.zzeu();
            }
            this.f6183a.remove(hfVar);
        }
    }
}
