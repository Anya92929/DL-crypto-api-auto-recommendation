package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzin;
import java.util.Collections;
import java.util.List;

@zzin
public final class AdResponseParcel extends AbstractSafeParcelable {
    public static final zzh CREATOR = new zzh();

    /* renamed from: a */
    private AdRequestInfoParcel f3904a;
    public String body;
    public final int errorCode;
    public final int orientation;
    public final int versionCode;
    public final boolean zzauu;
    public final boolean zzauv;
    public final boolean zzauw;
    public final List zzbnm;
    public final List zzbnn;
    public final List zzbnp;
    public final boolean zzbnq;
    public final long zzbns;
    public final String zzbto;
    public final boolean zzcaz;
    public final boolean zzcbq;
    public String zzcbr;
    public final long zzcbx;
    public final boolean zzcby;
    public final long zzcbz;
    public final List zzcca;
    public final String zzccb;
    public final long zzccc;
    public final String zzccd;
    public final boolean zzcce;
    public final String zzccf;
    public final String zzccg;
    public final boolean zzcch;
    public final boolean zzcci;
    public final boolean zzccj;
    public LargeParcelTeleporter zzcck;
    public String zzccl;
    public final String zzccm;
    public final RewardItemParcel zzccn;
    public final List zzcco;
    public final List zzccp;
    public final boolean zzccq;
    public final AutoClickProtectionConfigurationParcel zzccr;
    public final String zzccs;
    public final String zzcct;

    public AdResponseParcel(int i) {
        this(18, (String) null, (String) null, (List) null, i, (List) null, -1, false, -1, (List) null, -1, -1, (String) null, -1, (String) null, false, (String) null, (String) null, false, false, false, true, false, (LargeParcelTeleporter) null, (String) null, (String) null, false, false, (RewardItemParcel) null, (List) null, (List) null, false, (AutoClickProtectionConfigurationParcel) null, false, (String) null, (List) null, (String) null, false, (String) null);
    }

    public AdResponseParcel(int i, long j) {
        this(18, (String) null, (String) null, (List) null, i, (List) null, -1, false, -1, (List) null, j, -1, (String) null, -1, (String) null, false, (String) null, (String) null, false, false, false, true, false, (LargeParcelTeleporter) null, (String) null, (String) null, false, false, (RewardItemParcel) null, (List) null, (List) null, false, (AutoClickProtectionConfigurationParcel) null, false, (String) null, (List) null, (String) null, false, (String) null);
    }

    AdResponseParcel(int i, String str, String str2, List list, int i2, List list2, long j, boolean z, long j2, List list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LargeParcelTeleporter largeParcelTeleporter, String str7, String str8, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List list4, List list5, boolean z10, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z11, String str9, List list6, String str10, boolean z12, String str11) {
        StringParcel stringParcel;
        this.versionCode = i;
        this.zzbto = str;
        this.body = str2;
        this.zzbnm = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzbnn = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzcbx = j;
        this.zzcby = z;
        this.zzcbz = j2;
        this.zzcca = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzbns = j3;
        this.orientation = i3;
        this.zzccb = str3;
        this.zzccc = j4;
        this.zzccd = str4;
        this.zzcce = z2;
        this.zzccf = str5;
        this.zzccg = str6;
        this.zzcch = z3;
        this.zzauu = z4;
        this.zzcaz = z5;
        this.zzcci = z6;
        this.zzccj = z7;
        this.zzcck = largeParcelTeleporter;
        this.zzccl = str7;
        this.zzccm = str8;
        if (this.body == null && this.zzcck != null && (stringParcel = (StringParcel) this.zzcck.zza(StringParcel.CREATOR)) != null && !TextUtils.isEmpty(stringParcel.zzre())) {
            this.body = stringParcel.zzre();
        }
        this.zzauv = z8;
        this.zzauw = z9;
        this.zzccn = rewardItemParcel;
        this.zzcco = list4;
        this.zzccp = list5;
        this.zzccq = z10;
        this.zzccr = autoClickProtectionConfigurationParcel;
        this.zzcbq = z11;
        this.zzcbr = str9;
        this.zzbnp = list6;
        this.zzccs = str10;
        this.zzbnq = z12;
        this.zzcct = str11;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List list, List list2, long j, boolean z, long j2, List list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, RewardItemParcel rewardItemParcel, List list4, List list5, boolean z9, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z10, String str7, List list6, String str8, boolean z11, String str9) {
        this(18, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, (String) null, str5, z2, z3, z4, z5, z6, (LargeParcelTeleporter) null, (String) null, str6, z7, z8, rewardItemParcel, list4, list5, z9, autoClickProtectionConfigurationParcel, z10, str7, list6, str8, z11, str9);
        this.f3904a = adRequestInfoParcel;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List list, List list2, long j, boolean z, long j2, List list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List list4, List list5, boolean z10, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z11, String str8, List list6, String str9, boolean z12, String str10) {
        this(18, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, (LargeParcelTeleporter) null, (String) null, str7, z8, z9, rewardItemParcel, list4, list5, z10, autoClickProtectionConfigurationParcel, z11, str8, list6, str9, z12, str10);
        this.f3904a = adRequestInfoParcel;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f3904a != null && this.f3904a.versionCode >= 9 && !TextUtils.isEmpty(this.body)) {
            this.zzcck = new LargeParcelTeleporter(new StringParcel(this.body));
            this.body = null;
        }
        zzh.m5750a(this, parcel, i);
    }
}
