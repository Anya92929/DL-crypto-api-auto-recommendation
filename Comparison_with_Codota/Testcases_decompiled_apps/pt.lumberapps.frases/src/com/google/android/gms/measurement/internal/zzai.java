package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;

public class zzai extends C1923c {

    /* renamed from: a */
    private boolean f7266a;

    /* renamed from: b */
    private final AlarmManager f7267b = ((AlarmManager) getContext().getSystemService("alarm"));

    protected zzai(zzx zzx) {
        super(zzx);
    }

    /* renamed from: e */
    private PendingIntent m7788e() {
        Intent className = new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(getContext(), 0, className, 0);
    }

    public void cancel() {
        mo9339c();
        this.f7266a = false;
        this.f7267b.cancel(m7788e());
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9226d() {
        this.f7267b.cancel(m7788e());
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

    public void zzv(long j) {
        mo9339c();
        zzab.zzbo(j > 0);
        zzab.zza(zzu.zzav(getContext()), (Object) "Receiver not registered/enabled");
        zzab.zza(zzae.zzaw(getContext()), (Object) "Service not registered/enabled");
        cancel();
        this.f7266a = true;
        this.f7267b.setInexactRepeating(2, zzyw().elapsedRealtime() + j, Math.max(zzbsf().zzbro(), j), m7788e());
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
