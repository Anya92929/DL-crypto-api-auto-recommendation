package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.p009v4.app.NotificationCompat;
import com.google.android.gms.common.util.zze;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class zzg extends C1923c {

    /* renamed from: a */
    private long f7277a;

    /* renamed from: b */
    private String f7278b;

    /* renamed from: c */
    private Boolean f7279c;

    zzg(zzx zzx) {
        super(zzx);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9226d() {
        Calendar instance = Calendar.getInstance();
        this.f7277a = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String valueOf = String.valueOf(locale.getLanguage().toLowerCase(Locale.ENGLISH));
        String valueOf2 = String.valueOf(locale.getCountry().toLowerCase(Locale.ENGLISH));
        this.f7278b = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("-").append(valueOf2).toString();
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

    public String zzbso() {
        mo9339c();
        return Build.VERSION.RELEASE;
    }

    public long zzbsp() {
        mo9339c();
        return this.f7277a;
    }

    public String zzbsq() {
        mo9339c();
        return this.f7278b;
    }

    public boolean zzdn(Context context) {
        if (this.f7279c == null) {
            if (zzbsf().zzabc()) {
                this.f7279c = true;
            } else {
                this.f7279c = false;
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null) {
                        packageManager.getPackageInfo("com.google.android.gms", NotificationCompat.FLAG_HIGH_PRIORITY);
                        this.f7279c = true;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                }
            }
        }
        return this.f7279c.booleanValue();
    }

    public String zztg() {
        mo9339c();
        return Build.MODEL;
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
