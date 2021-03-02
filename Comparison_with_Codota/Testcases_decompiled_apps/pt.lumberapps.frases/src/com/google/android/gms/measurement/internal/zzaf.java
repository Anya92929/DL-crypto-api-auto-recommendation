package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.zze;

public class zzaf extends C1923c {

    /* renamed from: a */
    private Handler f7261a;

    /* renamed from: b */
    private long f7262b;

    /* renamed from: c */
    private final Runnable f7263c = new C1944x(this);

    /* renamed from: d */
    private final C1892aj f7264d = new C1946z(this, this.f7189n);

    /* renamed from: e */
    private final C1892aj f7265e = new C1883aa(this, this.f7189n);

    zzaf(zzx zzx) {
        super(zzx);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7776a(long j) {
        zzwu();
        m7782g();
        this.f7264d.mo9235c();
        this.f7265e.mo9235c();
        zzbsd().zzbtc().zzj("Activity resumed, time", Long.valueOf(j));
        this.f7262b = j;
        if (zzyw().currentTimeMillis() - zzbse().f7321i.get() > zzbse().f7323k.get()) {
            zzbse().f7322j.set(true);
            zzbse().f7324l.set(0);
        }
        if (zzbse().f7322j.get()) {
            this.f7264d.mo9233a(Math.max(0, zzbse().f7320h.get() - zzbse().f7324l.get()));
        } else {
            this.f7265e.mo9233a(Math.max(0, 3600000 - zzbse().f7324l.get()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7779b(long j) {
        zzwu();
        m7782g();
        this.f7264d.mo9235c();
        this.f7265e.mo9235c();
        zzbsd().zzbtc().zzj("Activity paused, time", Long.valueOf(j));
        if (this.f7262b != 0) {
            zzbse().f7324l.set(zzbse().f7324l.get() + (j - this.f7262b));
        }
        zzbse().f7323k.set(zzyw().currentTimeMillis());
        synchronized (this) {
            if (!zzbse().f7322j.get()) {
                this.f7261a.postDelayed(this.f7263c, 1000);
            }
        }
    }

    /* renamed from: g */
    private void m7782g() {
        synchronized (this) {
            if (this.f7261a == null) {
                this.f7261a = new Handler(Looper.getMainLooper());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m7783h() {
        zzwu();
        zzbsd().zzbtc().zzj("Session started, time", Long.valueOf(zzyw().elapsedRealtime()));
        zzbse().f7322j.set(false);
        zzbru().zze("auto", "_s", new Bundle());
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m7784i() {
        zzwu();
        long elapsedRealtime = zzyw().elapsedRealtime();
        if (this.f7262b == 0) {
            this.f7262b = elapsedRealtime - 3600000;
        }
        long j = zzbse().f7324l.get() + (elapsedRealtime - this.f7262b);
        zzbse().f7324l.set(j);
        zzbsd().zzbtc().zzj("Recording user engagement, ms", Long.valueOf(j));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j);
        zzbru().zze("auto", "_e", bundle);
        zzbse().f7324l.set(0);
        this.f7262b = elapsedRealtime;
        this.f7265e.mo9233a(Math.max(0, 3600000 - zzbse().f7324l.get()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9226d() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo9421e() {
        synchronized (this) {
            m7782g();
            this.f7261a.removeCallbacks(this.f7263c);
        }
        zzbsc().zzm(new C1884ab(this, zzyw().elapsedRealtime()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo9422f() {
        zzbsc().zzm(new C1885ac(this, zzyw().elapsedRealtime()));
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

    public void zzbva() {
        zzwu();
        zzbsd().zzbtb().log("Application backgrounded. Logging engagement");
        long j = zzbse().f7324l.get();
        if (j > 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzbru().zze("auto", "_e", bundle);
            zzbse().f7324l.set(0);
            return;
        }
        zzbsd().zzbsx().zzj("Not logging non-positive engagement time", Long.valueOf(j));
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
