package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzin
public class zzju {
    public final int errorCode;
    public final int orientation;
    public final List zzbnm;
    public final List zzbnn;
    public final List zzbnp;
    public final long zzbns;
    public final zzfz zzbon;
    public final zzgk zzboo;
    public final String zzbop;
    public final zzgc zzboq;
    public final zzlh zzbtm;
    public final AdRequestParcel zzcar;
    public final String zzcau;
    public final long zzcbx;
    public final boolean zzcby;
    public final long zzcbz;
    public final List zzcca;
    public final String zzccd;
    public final RewardItemParcel zzccn;
    public final List zzccp;
    public final boolean zzccq;
    public final AutoClickProtectionConfigurationParcel zzccr;
    public final JSONObject zzcie;
    public boolean zzcif;
    public final zzga zzcig;
    public final String zzcih;
    public final AdSizeParcel zzcii;
    public final List zzcij;
    public final long zzcik;
    public final long zzcil;
    public final zzh.zza zzcim;
    public boolean zzcin;
    public boolean zzcio;

    @zzin
    public final class zza {
        public final int errorCode;
        public final AdSizeParcel zzapa;
        public final JSONObject zzcie;
        public final zzga zzcig;
        public final long zzcik;
        public final long zzcil;
        public final AdRequestInfoParcel zzcip;
        public final AdResponseParcel zzciq;

        public zza(AdRequestInfoParcel adRequestInfoParcel, AdResponseParcel adResponseParcel, zzga zzga, AdSizeParcel adSizeParcel, int i, long j, long j2, JSONObject jSONObject) {
            this.zzcip = adRequestInfoParcel;
            this.zzciq = adResponseParcel;
            this.zzcig = zzga;
            this.zzapa = adSizeParcel;
            this.errorCode = i;
            this.zzcik = j;
            this.zzcil = j2;
            this.zzcie = jSONObject;
        }
    }

    public zzju(AdRequestParcel adRequestParcel, zzlh zzlh, List list, int i, List list2, List list3, int i2, long j, String str, boolean z, zzfz zzfz, zzgk zzgk, String str2, zzga zzga, zzgc zzgc, long j2, AdSizeParcel adSizeParcel, long j3, long j4, long j5, String str3, JSONObject jSONObject, zzh.zza zza2, RewardItemParcel rewardItemParcel, List list4, List list5, boolean z2, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, String str4, List list6) {
        this.zzcin = false;
        this.zzcio = false;
        this.zzcar = adRequestParcel;
        this.zzbtm = zzlh;
        this.zzbnm = m7285a(list);
        this.errorCode = i;
        this.zzbnn = m7285a(list2);
        this.zzcca = m7285a(list3);
        this.orientation = i2;
        this.zzbns = j;
        this.zzcau = str;
        this.zzcby = z;
        this.zzbon = zzfz;
        this.zzboo = zzgk;
        this.zzbop = str2;
        this.zzcig = zzga;
        this.zzboq = zzgc;
        this.zzcbz = j2;
        this.zzcii = adSizeParcel;
        this.zzcbx = j3;
        this.zzcik = j4;
        this.zzcil = j5;
        this.zzccd = str3;
        this.zzcie = jSONObject;
        this.zzcim = zza2;
        this.zzccn = rewardItemParcel;
        this.zzcij = m7285a(list4);
        this.zzccp = m7285a(list5);
        this.zzccq = z2;
        this.zzccr = autoClickProtectionConfigurationParcel;
        this.zzcih = str4;
        this.zzbnp = m7285a(list6);
    }

    public zzju(zza zza2, zzlh zzlh, zzfz zzfz, zzgk zzgk, String str, zzgc zzgc, zzh.zza zza3, String str2) {
        this(zza2.zzcip.zzcar, zzlh, zza2.zzciq.zzbnm, zza2.errorCode, zza2.zzciq.zzbnn, zza2.zzciq.zzcca, zza2.zzciq.orientation, zza2.zzciq.zzbns, zza2.zzcip.zzcau, zza2.zzciq.zzcby, zzfz, zzgk, str, zza2.zzcig, zzgc, zza2.zzciq.zzcbz, zza2.zzapa, zza2.zzciq.zzcbx, zza2.zzcik, zza2.zzcil, zza2.zzciq.zzccd, zza2.zzcie, zza3, zza2.zzciq.zzccn, zza2.zzciq.zzcco, zza2.zzciq.zzcco, zza2.zzciq.zzccq, zza2.zzciq.zzccr, str2, zza2.zzciq.zzbnp);
    }

    /* renamed from: a */
    private static List m7285a(List list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public boolean zzho() {
        if (this.zzbtm == null || this.zzbtm.zzuj() == null) {
            return false;
        }
        return this.zzbtm.zzuj().zzho();
    }
}
