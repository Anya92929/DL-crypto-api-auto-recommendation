package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.p009v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.measurement.internal.zzl;

public class zzd extends C1922bm {

    /* renamed from: a */
    static final String f7268a = String.valueOf(zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");

    /* renamed from: b */
    private Boolean f7269b;

    zzd(zzx zzx) {
        super(zzx);
    }

    /* renamed from: c */
    private Boolean m7814c(String str) {
        zzab.zzhr(str);
        try {
            PackageManager packageManager = getContext().getPackageManager();
            if (packageManager == null) {
                zzbsd().zzbsv().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getContext().getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo == null) {
                zzbsd().zzbsv().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData == null) {
                zzbsd().zzbsv().log("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (applicationInfo.metaData.containsKey(str)) {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            } else {
                return null;
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzbsd().zzbsv().zzj("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo9464a(String str) {
        return zza(str, zzl.aiO);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo9465a() {
        return (String) zzl.aiN.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo9466b() {
        return 24;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo9467b(String str) {
        return zzb(str, zzl.ajk);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo9468c() {
        return 36;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo9469d() {
        return NotificationCompat.FLAG_LOCAL_ONLY;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo9470e() {
        return 500;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo9471f() {
        return 25;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo9472g() {
        return 50;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public long mo9473h() {
        return 3600000;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public long mo9474i() {
        return 60000;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public long mo9475j() {
        return 61000;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public long mo9476k() {
        return ((Long) zzl.ajl.get()).longValue();
    }

    public long zza(String str, zzl.zza zza) {
        if (str == null) {
            return ((Long) zza.get()).longValue();
        }
        String a = zzbsa().mo9635a(str, zza.getKey());
        if (TextUtils.isEmpty(a)) {
            return ((Long) zza.get()).longValue();
        }
        try {
            return ((Long) zza.get(Long.valueOf(Long.valueOf(a).longValue()))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) zza.get()).longValue();
        }
    }

    public boolean zzabc() {
        return false;
    }

    public boolean zzabd() {
        if (this.f7269b == null) {
            synchronized (this) {
                if (this.f7269b == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String zzawa = zzt.zzawa();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f7269b = Boolean.valueOf(str != null && str.equals(zzawa));
                    }
                    if (this.f7269b == null) {
                        this.f7269b = Boolean.TRUE;
                        zzbsd().zzbsv().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f7269b.booleanValue();
    }

    public String zzacc() {
        return "google_app_measurement.db";
    }

    public String zzacd() {
        return "google_app_measurement2.db";
    }

    public long zzaci() {
        return Math.max(0, ((Long) zzl.aiP.get()).longValue());
    }

    public String zzap(String str, String str2) {
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder encodedAuthority = builder.scheme((String) zzl.aiR.get()).encodedAuthority((String) zzl.aiS.get());
        String valueOf = String.valueOf(str);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", str2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzbpz()));
        return builder.build().toString();
    }

    public boolean zzaqp() {
        return zzqf.zzaqp();
    }

    public int zzb(String str, zzl.zza zza) {
        if (str == null) {
            return ((Integer) zza.get()).intValue();
        }
        String a = zzbsa().mo9635a(str, zza.getKey());
        if (TextUtils.isEmpty(a)) {
            return ((Integer) zza.get()).intValue();
        }
        try {
            return ((Integer) zza.get(Integer.valueOf(Integer.valueOf(a).intValue()))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) zza.get()).intValue();
        }
    }

    public long zzbpz() {
        return 9452;
    }

    public int zzbqm() {
        return 25;
    }

    public int zzbqn() {
        return 32;
    }

    public int zzbqo() {
        return 24;
    }

    public int zzbqs() {
        return 36;
    }

    public int zzbqt() {
        return 2048;
    }

    public long zzbqv() {
        return (long) ((Integer) zzl.aiX.get()).intValue();
    }

    public long zzbqw() {
        return (long) ((Integer) zzl.aiY.get()).intValue();
    }

    public long zzbqx() {
        return 1000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = m7814c("firebase_analytics_collection_deactivated");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zzbrd() {
        /*
            r2 = this;
            r0 = 0
            boolean r1 = r2.zzabc()
            if (r1 == 0) goto L_0x0008
        L_0x0007:
            return r0
        L_0x0008:
            java.lang.String r1 = "firebase_analytics_collection_deactivated"
            java.lang.Boolean r1 = r2.m7814c(r1)
            if (r1 == 0) goto L_0x0007
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0007
            r0 = 1
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzd.zzbrd():boolean");
    }

    public Boolean zzbre() {
        if (zzabc()) {
            return null;
        }
        return m7814c("firebase_analytics_collection_enabled");
    }

    public long zzbrf() {
        return ((Long) zzl.ajj.get()).longValue();
    }

    public long zzbrg() {
        return ((Long) zzl.ajf.get()).longValue();
    }

    public long zzbrh() {
        return 1000;
    }

    public int zzbri() {
        return Math.max(0, ((Integer) zzl.aiV.get()).intValue());
    }

    public int zzbrj() {
        return Math.max(1, ((Integer) zzl.aiW.get()).intValue());
    }

    public String zzbrk() {
        return (String) zzl.ajb.get();
    }

    public long zzbrl() {
        return ((Long) zzl.aiQ.get()).longValue();
    }

    public long zzbrm() {
        return Math.max(0, ((Long) zzl.ajc.get()).longValue());
    }

    public long zzbrn() {
        return Math.max(0, ((Long) zzl.aje.get()).longValue());
    }

    public long zzbro() {
        return ((Long) zzl.ajd.get()).longValue();
    }

    public long zzbrp() {
        return Math.max(0, ((Long) zzl.ajg.get()).longValue());
    }

    public long zzbrq() {
        return Math.max(0, ((Long) zzl.ajh.get()).longValue());
    }

    public int zzbrr() {
        return Math.min(20, Math.max(0, ((Integer) zzl.aji.get()).intValue()));
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

    public int zzlf(String str) {
        return zzb(str, zzl.aiZ);
    }

    public int zzlj(String str) {
        return zzb(str, zzl.aiT);
    }

    public int zzlk(String str) {
        return Math.max(0, zzb(str, zzl.aiU));
    }

    public int zzll(String str) {
        return Math.max(0, Math.min(1000000, zzb(str, zzl.aja)));
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
