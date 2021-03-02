package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.p009v4.p019f.C0136a;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzapn;
import com.google.android.gms.internal.zzapo;
import com.google.android.gms.internal.zzug;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.IOException;
import java.util.Map;

public class zzv extends C1923c {

    /* renamed from: a */
    private final Map f7349a = new C0136a();

    /* renamed from: b */
    private final Map f7350b = new C0136a();

    /* renamed from: c */
    private final Map f7351c = new C0136a();

    /* renamed from: d */
    private final Map f7352d = new C0136a();

    /* renamed from: e */
    private final Map f7353e = new C0136a();

    zzv(zzx zzx) {
        super(zzx);
    }

    /* renamed from: a */
    private zzug.zzb m7944a(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzug.zzb();
        }
        zzapn zzbd = zzapn.zzbd(bArr);
        zzug.zzb zzb = new zzug.zzb();
        try {
            zzug.zzb zzb2 = (zzug.zzb) zzb.zzb(zzbd);
            zzbsd().zzbtc().zze("Parsed config. version, gmp_app_id", zzb.anc, zzb.aic);
            return zzb;
        } catch (IOException e) {
            zzbsd().zzbsx().zze("Unable to merge remote config", str, e);
            return null;
        }
    }

    /* renamed from: a */
    private Map m7945a(zzug.zzb zzb) {
        C0136a aVar = new C0136a();
        if (!(zzb == null || zzb.ane == null)) {
            for (zzug.zzc zzc : zzb.ane) {
                if (zzc != null) {
                    aVar.put(zzc.zzcb, zzc.value);
                }
            }
        }
        return aVar;
    }

    /* renamed from: a */
    private void m7946a(String str, zzug.zzb zzb) {
        C0136a aVar = new C0136a();
        C0136a aVar2 = new C0136a();
        if (!(zzb == null || zzb.anf == null)) {
            for (zzug.zza zza : zzb.anf) {
                if (zza != null) {
                    String str2 = (String) AppMeasurement.zza.ahE.get(zza.name);
                    if (str2 != null) {
                        zza.name = str2;
                    }
                    aVar.put(zza.name, zza.ana);
                    aVar2.put(zza.name, zza.anb);
                }
            }
        }
        this.f7350b.put(str, aVar);
        this.f7351c.put(str, aVar2);
    }

    /* renamed from: d */
    private void m7947d(String str) {
        mo9339c();
        zzwu();
        zzab.zzhr(str);
        if (!this.f7352d.containsKey(str)) {
            byte[] d = zzbry().mo9540d(str);
            if (d == null) {
                this.f7349a.put(str, (Object) null);
                this.f7350b.put(str, (Object) null);
                this.f7351c.put(str, (Object) null);
                this.f7352d.put(str, (Object) null);
                this.f7353e.put(str, (Object) null);
                return;
            }
            zzug.zzb a = m7944a(str, d);
            this.f7349a.put(str, m7945a(a));
            m7946a(str, a);
            this.f7352d.put(str, a);
            this.f7353e.put(str, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzug.zzb mo9634a(String str) {
        mo9339c();
        zzwu();
        zzab.zzhr(str);
        m7947d(str);
        return (zzug.zzb) this.f7352d.get(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo9635a(String str, String str2) {
        zzwu();
        m7947d(str);
        Map map = (Map) this.f7349a.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo9636a(String str, byte[] bArr, String str2) {
        mo9339c();
        zzwu();
        zzab.zzhr(str);
        zzug.zzb a = m7944a(str, bArr);
        if (a == null) {
            return false;
        }
        m7946a(str, a);
        this.f7352d.put(str, a);
        this.f7353e.put(str, str2);
        this.f7349a.put(str, m7945a(a));
        zzbrt().mo9222a(str, a.ang);
        try {
            a.ang = null;
            byte[] bArr2 = new byte[a.mo8049aM()];
            a.zza(zzapo.zzbe(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            zzbsd().zzbsx().zzj("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        zzbry().mo9527a(str, bArr);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo9637b(String str) {
        zzwu();
        return (String) this.f7353e.get(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo9638b(String str, String str2) {
        zzwu();
        m7947d(str);
        Map map = (Map) this.f7350b.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9639c(String str) {
        zzwu();
        this.f7353e.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo9640c(String str, String str2) {
        zzwu();
        m7947d(str);
        Map map = (Map) this.f7351c.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9226d() {
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzbrs() {
        super.zzbrs();
    }

    public /* bridge */ /* synthetic */ C1889ag zzbrt() {
        return super.zzbrt();
    }

    public /* bridge */ /* synthetic */ zzac zzbru() {
        return super.zzbru();
    }

    public /* bridge */ /* synthetic */ zzn zzbrv() {
        return super.zzbrv();
    }

    public /* bridge */ /* synthetic */ zzg zzbrw() {
        return super.zzbrw();
    }

    public /* bridge */ /* synthetic */ zzad zzbrx() {
        return super.zzbrx();
    }

    public /* bridge */ /* synthetic */ zze zzbry() {
        return super.zzbry();
    }

    public /* bridge */ /* synthetic */ zzal zzbrz() {
        return super.zzbrz();
    }

    public /* bridge */ /* synthetic */ zzv zzbsa() {
        return super.zzbsa();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsb() {
        return super.zzbsb();
    }

    public /* bridge */ /* synthetic */ zzw zzbsc() {
        return super.zzbsc();
    }

    public /* bridge */ /* synthetic */ zzp zzbsd() {
        return super.zzbsd();
    }

    public /* bridge */ /* synthetic */ zzt zzbse() {
        return super.zzbse();
    }

    public /* bridge */ /* synthetic */ zzd zzbsf() {
        return super.zzbsf();
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
