package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzqf;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class zzn extends C1923c {

    /* renamed from: a */
    private static final X500Principal f7289a = new X500Principal("CN=Android Debug,O=Android,C=US");

    /* renamed from: b */
    private String f7290b;

    /* renamed from: c */
    private String f7291c;

    /* renamed from: d */
    private int f7292d;

    /* renamed from: e */
    private String f7293e;

    /* renamed from: f */
    private String f7294f;

    /* renamed from: g */
    private long f7295g;

    /* renamed from: h */
    private String f7296h;

    zzn(zzx zzx) {
        super(zzx);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AppMetadata mo9579a(String str) {
        return new AppMetadata(mo9581e(), mo9582f(), mo9583g(), (long) mo9584h(), mo9585i(), mo9586j(), mo9587k(), str, this.f7189n.isEnabled(), !zzbse().f7325m, zzbse().mo9620f());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9580a(Status status) {
        if (status == null) {
            zzbsd().zzbsv().log("GoogleService failed to initialize (no status)");
        } else {
            zzbsd().zzbsv().zze("GoogleService failed to initialize, status", Integer.valueOf(status.getStatusCode()), status.getStatusMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9226d() {
        boolean z;
        String str = "Unknown";
        int i = Integer.MIN_VALUE;
        String str2 = "Unknown";
        PackageManager packageManager = getContext().getPackageManager();
        String packageName = getContext().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if ("com.android.vending".equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                }
                str = packageInfo.versionName;
                i = packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzbsd().zzbsv().zzj("Error retrieving package info: appName", str2);
        }
        this.f7290b = packageName;
        this.f7293e = installerPackageName;
        this.f7291c = str;
        this.f7292d = i;
        this.f7294f = str2;
        MessageDigest c = zzal.m7805c("MD5");
        if (c == null) {
            zzbsd().zzbsv().log("Could not get MD5 instance");
            this.f7295g = -1;
        } else {
            this.f7295g = 0;
            try {
                if (!mo9588l()) {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(getContext().getPackageName(), 64);
                    if (packageInfo2.signatures != null && packageInfo2.signatures.length > 0) {
                        this.f7295g = zzal.m7791a(c.digest(packageInfo2.signatures[0].toByteArray()));
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                zzbsd().zzbsv().zzj("Package name not found", e2);
            }
        }
        Status zzc = zzbsf().zzabc() ? zzqf.zzc(getContext(), "-", true) : zzqf.zzcb(getContext());
        boolean z2 = zzc != null && zzc.isSuccess();
        if (!z2) {
            mo9580a(zzc);
        }
        if (z2) {
            Boolean zzbre = zzbsf().zzbre();
            if (zzbsf().zzbrd()) {
                zzbsd().zzbta().log("Collection disabled with firebase_analytics_collection_deactivated=1");
                z = false;
            } else if (zzbre != null && !zzbre.booleanValue()) {
                zzbsd().zzbta().log("Collection disabled with firebase_analytics_collection_enabled=0");
                z = false;
            } else if (zzbre != null || !zzbsf().zzaqp()) {
                zzbsd().zzbtc().log("Collection enabled");
                z = true;
            } else {
                zzbsd().zzbta().log("Collection disabled with google_app_measurement_enable=0");
                z = false;
            }
        } else {
            z = false;
        }
        this.f7296h = "";
        if (!zzbsf().zzabc()) {
            try {
                String zzaqo = zzqf.zzaqo();
                if (TextUtils.isEmpty(zzaqo)) {
                    zzaqo = "";
                }
                this.f7296h = zzaqo;
                if (z) {
                    zzbsd().zzbtc().zze("App package, google app id", this.f7290b, this.f7296h);
                }
            } catch (IllegalStateException e3) {
                zzbsd().zzbsv().zzj("getGoogleAppId or isMeasurementEnabled failed with exception", e3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo9581e() {
        mo9339c();
        return this.f7290b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo9582f() {
        mo9339c();
        return this.f7296h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public String mo9583g() {
        mo9339c();
        return this.f7291c;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public int mo9584h() {
        mo9339c();
        return this.f7292d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public String mo9585i() {
        mo9339c();
        return this.f7293e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public long mo9586j() {
        return zzbsf().zzbpz();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public long mo9587k() {
        mo9339c();
        return this.f7295g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo9588l() {
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(f7289a);
            }
        } catch (CertificateException e) {
            zzbsd().zzbsv().zzj("Error obtaining certificate", e);
        } catch (PackageManager.NameNotFoundException e2) {
            zzbsd().zzbsv().zzj("Package name not found", e2);
        }
        return true;
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
