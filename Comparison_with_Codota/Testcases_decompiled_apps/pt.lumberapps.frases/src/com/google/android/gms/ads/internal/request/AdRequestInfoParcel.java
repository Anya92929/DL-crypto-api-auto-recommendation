package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzin;
import java.util.Collections;
import java.util.List;

@zzin
public final class AdRequestInfoParcel extends AbstractSafeParcelable {
    public static final zzf CREATOR = new zzf();
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final String zzaot;
    public final String zzaou;
    public final VersionInfoParcel zzaow;
    public final AdSizeParcel zzapa;
    public final NativeAdOptionsParcel zzapo;
    public final List zzaps;
    public final boolean zzbnq;
    public final Bundle zzcaq;
    public final AdRequestParcel zzcar;
    public final PackageInfo zzcas;
    public final String zzcat;
    public final String zzcau;
    public final String zzcav;
    public final Bundle zzcaw;
    public final int zzcax;
    public final Bundle zzcay;
    public final boolean zzcaz;
    public final Messenger zzcba;
    public final int zzcbb;
    public final int zzcbc;
    public final float zzcbd;
    public final String zzcbe;
    public final long zzcbf;
    public final String zzcbg;
    public final List zzcbh;
    public final List zzcbi;
    public final long zzcbj;
    public final CapabilityParcel zzcbk;
    public final String zzcbl;
    public final float zzcbm;
    public final int zzcbn;
    public final int zzcbo;
    public final boolean zzcbp;
    public final boolean zzcbq;
    public final String zzcbr;
    public final boolean zzcbs;
    public final String zzcbt;
    public final int zzcbu;
    public final Bundle zzcbv;

    @zzin
    public final class zza {
        public final ApplicationInfo applicationInfo;
        public final String zzaot;
        public final String zzaou;
        public final VersionInfoParcel zzaow;
        public final AdSizeParcel zzapa;
        public final NativeAdOptionsParcel zzapo;
        public final List zzaps;
        public final boolean zzbnq;
        public final Bundle zzcaq;
        public final AdRequestParcel zzcar;
        public final PackageInfo zzcas;
        public final String zzcau;
        public final String zzcav;
        public final Bundle zzcaw;
        public final int zzcax;
        public final Bundle zzcay;
        public final boolean zzcaz;
        public final Messenger zzcba;
        public final int zzcbb;
        public final int zzcbc;
        public final float zzcbd;
        public final String zzcbe;
        public final long zzcbf;
        public final String zzcbg;
        public final List zzcbh;
        public final List zzcbi;
        public final CapabilityParcel zzcbk;
        public final String zzcbl;
        public final float zzcbm;
        public final int zzcbn;
        public final int zzcbo;
        public final boolean zzcbp;
        public final boolean zzcbq;
        public final String zzcbr;
        public final boolean zzcbs;
        public final String zzcbt;
        public final int zzcbu;
        public final Bundle zzcbv;

        public zza(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, VersionInfoParcel versionInfoParcel, Bundle bundle2, List list, List list2, Bundle bundle3, boolean z, Messenger messenger, int i, int i2, float f, String str4, long j, String str5, List list3, String str6, NativeAdOptionsParcel nativeAdOptionsParcel, CapabilityParcel capabilityParcel, String str7, float f2, boolean z2, int i3, int i4, boolean z3, boolean z4, String str8, String str9, boolean z5, int i5, Bundle bundle4) {
            this.zzcaq = bundle;
            this.zzcar = adRequestParcel;
            this.zzapa = adSizeParcel;
            this.zzaou = str;
            this.applicationInfo = applicationInfo2;
            this.zzcas = packageInfo;
            this.zzcau = str2;
            this.zzcav = str3;
            this.zzaow = versionInfoParcel;
            this.zzcaw = bundle2;
            this.zzcaz = z;
            this.zzcba = messenger;
            this.zzcbb = i;
            this.zzcbc = i2;
            this.zzcbd = f;
            if (list == null || list.size() <= 0) {
                if (adSizeParcel.zzauw) {
                    this.zzcax = 4;
                } else {
                    this.zzcax = 0;
                }
                this.zzaps = null;
                this.zzcbi = null;
            } else {
                this.zzcax = 3;
                this.zzaps = list;
                this.zzcbi = list2;
            }
            this.zzcay = bundle3;
            this.zzcbe = str4;
            this.zzcbf = j;
            this.zzcbg = str5;
            this.zzcbh = list3;
            this.zzaot = str6;
            this.zzapo = nativeAdOptionsParcel;
            this.zzcbk = capabilityParcel;
            this.zzcbl = str7;
            this.zzcbm = f2;
            this.zzcbs = z2;
            this.zzcbn = i3;
            this.zzcbo = i4;
            this.zzcbp = z3;
            this.zzcbq = z4;
            this.zzcbr = str8;
            this.zzcbt = str9;
            this.zzbnq = z5;
            this.zzcbu = i5;
            this.zzcbv = bundle4;
        }
    }

    AdRequestInfoParcel(int i, Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i2, List list, Bundle bundle3, boolean z, Messenger messenger, int i3, int i4, float f, String str5, long j, String str6, List list2, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, List list3, long j2, CapabilityParcel capabilityParcel, String str8, float f2, boolean z2, int i5, int i6, boolean z3, boolean z4, String str9, String str10, boolean z5, int i7, Bundle bundle4) {
        this.versionCode = i;
        this.zzcaq = bundle;
        this.zzcar = adRequestParcel;
        this.zzapa = adSizeParcel;
        this.zzaou = str;
        this.applicationInfo = applicationInfo2;
        this.zzcas = packageInfo;
        this.zzcat = str2;
        this.zzcau = str3;
        this.zzcav = str4;
        this.zzaow = versionInfoParcel;
        this.zzcaw = bundle2;
        this.zzcax = i2;
        this.zzaps = list;
        this.zzcbi = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzcay = bundle3;
        this.zzcaz = z;
        this.zzcba = messenger;
        this.zzcbb = i3;
        this.zzcbc = i4;
        this.zzcbd = f;
        this.zzcbe = str5;
        this.zzcbf = j;
        this.zzcbg = str6;
        this.zzcbh = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzaot = str7;
        this.zzapo = nativeAdOptionsParcel;
        this.zzcbj = j2;
        this.zzcbk = capabilityParcel;
        this.zzcbl = str8;
        this.zzcbm = f2;
        this.zzcbs = z2;
        this.zzcbn = i5;
        this.zzcbo = i6;
        this.zzcbp = z3;
        this.zzcbq = z4;
        this.zzcbr = str9;
        this.zzcbt = str10;
        this.zzbnq = z5;
        this.zzcbu = i7;
        this.zzcbv = bundle4;
    }

    public AdRequestInfoParcel(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i, List list, List list2, Bundle bundle3, boolean z, Messenger messenger, int i2, int i3, float f, String str5, long j, String str6, List list3, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, long j2, CapabilityParcel capabilityParcel, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4) {
        this(18, bundle, adRequestParcel, adSizeParcel, str, applicationInfo2, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i, list, bundle3, z, messenger, i2, i3, f, str5, j, str6, list3, str7, nativeAdOptionsParcel, list2, j2, capabilityParcel, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4);
    }

    public AdRequestInfoParcel(zza zza2, String str, long j) {
        this(zza2.zzcaq, zza2.zzcar, zza2.zzapa, zza2.zzaou, zza2.applicationInfo, zza2.zzcas, str, zza2.zzcau, zza2.zzcav, zza2.zzaow, zza2.zzcaw, zza2.zzcax, zza2.zzaps, zza2.zzcbi, zza2.zzcay, zza2.zzcaz, zza2.zzcba, zza2.zzcbb, zza2.zzcbc, zza2.zzcbd, zza2.zzcbe, zza2.zzcbf, zza2.zzcbg, zza2.zzcbh, zza2.zzaot, zza2.zzapo, j, zza2.zzcbk, zza2.zzcbl, zza2.zzcbm, zza2.zzcbs, zza2.zzcbn, zza2.zzcbo, zza2.zzcbp, zza2.zzcbq, zza2.zzcbr, zza2.zzcbt, zza2.zzbnq, zza2.zzcbu, zza2.zzcbv);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.m5749a(this, parcel, i);
    }
}
