package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzge;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzgd implements zzge.zza {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f6219a;

    /* renamed from: b */
    private final zzgj f6220b;

    /* renamed from: c */
    private final long f6221c;

    /* renamed from: d */
    private final zzga f6222d;

    /* renamed from: e */
    private final zzfz f6223e;

    /* renamed from: f */
    private AdRequestParcel f6224f;

    /* renamed from: g */
    private final AdSizeParcel f6225g;

    /* renamed from: h */
    private final Context f6226h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Object f6227i = new Object();

    /* renamed from: j */
    private final VersionInfoParcel f6228j;

    /* renamed from: k */
    private final boolean f6229k;

    /* renamed from: l */
    private final NativeAdOptionsParcel f6230l;

    /* renamed from: m */
    private final List f6231m;

    /* renamed from: n */
    private final boolean f6232n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public zzgk f6233o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f6234p = -2;

    /* renamed from: q */
    private zzgm f6235q;

    public zzgd(Context context, String str, zzgj zzgj, zzga zzga, zzfz zzfz, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, VersionInfoParcel versionInfoParcel, boolean z, boolean z2, NativeAdOptionsParcel nativeAdOptionsParcel, List list) {
        this.f6226h = context;
        this.f6220b = zzgj;
        this.f6223e = zzfz;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.f6219a = m7077a();
        } else {
            this.f6219a = str;
        }
        this.f6222d = zzga;
        this.f6221c = zzga.zzbnl != -1 ? zzga.zzbnl : 10000;
        this.f6224f = adRequestParcel;
        this.f6225g = adSizeParcel;
        this.f6228j = versionInfoParcel;
        this.f6229k = z;
        this.f6232n = z2;
        this.f6230l = nativeAdOptionsParcel;
        this.f6231m = list;
    }

    /* renamed from: a */
    private long m7074a(long j, long j2, long j3, long j4) {
        while (this.f6234p == -2) {
            m7087b(j, j2, j3, j4);
        }
        return zzu.zzfu().elapsedRealtime() - j;
    }

    /* renamed from: a */
    private String m7077a() {
        try {
            return (TextUtils.isEmpty(this.f6223e.zzbmy) || !this.f6220b.zzbn(this.f6223e.zzbmy)) ? "com.google.ads.mediation.customevent.CustomEventAdapter" : "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        } catch (RemoteException e) {
            zzkd.zzcx("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    /* renamed from: a */
    private String m7078a(String str) {
        if (str == null || !m7092d() || m7081a(2)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.remove("cpm_floor_cents");
            return jSONObject.toString();
        } catch (JSONException e) {
            zzkd.zzcx("Could not remove field. Returning the original value");
            return str;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7079a(zzgc zzgc) {
        if ("com.google.ads.mediation.AdUrlAdapter".equals(this.f6219a)) {
            if (this.f6224f.zzatw == null) {
                this.f6224f = new zzf(this.f6224f).zzc(new Bundle()).zzig();
            }
            Bundle bundle = this.f6224f.zzatw.getBundle(this.f6219a);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("sdk_less_network_id", this.f6223e.zzbmv);
            this.f6224f.zzatw.putBundle(this.f6219a, bundle);
        }
        String a = m7078a(this.f6223e.zzbnc);
        try {
            if (this.f6228j.zzcnl < 4100000) {
                if (this.f6225g.zzaus) {
                    this.f6233o.zza(zze.zzac(this.f6226h), this.f6224f, a, zzgc);
                } else {
                    this.f6233o.zza(zze.zzac(this.f6226h), this.f6225g, this.f6224f, a, (zzgl) zzgc);
                }
            } else if (this.f6229k) {
                this.f6233o.zza(zze.zzac(this.f6226h), this.f6224f, a, this.f6223e.zzbmu, zzgc, this.f6230l, this.f6231m);
            } else if (this.f6225g.zzaus) {
                this.f6233o.zza(zze.zzac(this.f6226h), this.f6224f, a, this.f6223e.zzbmu, (zzgl) zzgc);
            } else if (!this.f6232n) {
                this.f6233o.zza(zze.zzac(this.f6226h), this.f6225g, this.f6224f, a, this.f6223e.zzbmu, zzgc);
            } else if (this.f6223e.zzbnf != null) {
                this.f6233o.zza(zze.zzac(this.f6226h), this.f6224f, a, this.f6223e.zzbmu, zzgc, new NativeAdOptionsParcel(m7084b(this.f6223e.zzbnj)), this.f6223e.zzbni);
            } else {
                this.f6233o.zza(zze.zzac(this.f6226h), this.f6225g, this.f6224f, a, this.f6223e.zzbmu, zzgc);
            }
        } catch (RemoteException e) {
            zzkd.zzd("Could not request ad from mediation adapter.", e);
            zzy(5);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m7081a(int i) {
        try {
            Bundle zzmr = this.f6229k ? this.f6233o.zzmr() : this.f6225g.zzaus ? this.f6233o.getInterstitialAdapterInfo() : this.f6233o.zzmq();
            if (zzmr == null) {
                return false;
            }
            return (zzmr.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException e) {
            zzkd.zzcx("Could not get adapter info. Returning false");
            return false;
        }
    }

    /* renamed from: b */
    private static NativeAdOptions m7084b(String str) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (str == null) {
            return builder.build();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.setRequestMultipleImages(jSONObject.optBoolean("multiple_images", false));
            builder.setReturnUrlsForImageAssets(jSONObject.optBoolean("only_urls", false));
            builder.setImageOrientation(m7088c(jSONObject.optString("native_image_orientation", "any")));
        } catch (JSONException e) {
            zzkd.zzd("Exception occurred when creating native ad options", e);
        }
        return builder.build();
    }

    /* renamed from: b */
    private zzgm m7085b() {
        if (this.f6234p != 0 || !m7092d()) {
            return null;
        }
        try {
            if (!(!m7081a(4) || this.f6235q == null || this.f6235q.zzmm() == 0)) {
                return this.f6235q;
            }
        } catch (RemoteException e) {
            zzkd.zzcx("Could not get cpm value from MediationResponseMetadata");
        }
        return m7086b(m7093e());
    }

    /* renamed from: b */
    private static zzgm m7086b(int i) {
        return new C1636il(i);
    }

    /* renamed from: b */
    private void m7087b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        long j6 = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || j6 <= 0) {
            zzkd.zzcw("Timed out waiting for adapter.");
            this.f6234p = 3;
            return;
        }
        try {
            this.f6227i.wait(Math.min(j5, j6));
        } catch (InterruptedException e) {
            this.f6234p = -1;
        }
    }

    /* renamed from: c */
    private static int m7088c(String str) {
        if ("landscape".equals(str)) {
            return 2;
        }
        return "portrait".equals(str) ? 1 : 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public zzgk m7089c() {
        String valueOf = String.valueOf(this.f6219a);
        zzkd.zzcw(valueOf.length() != 0 ? "Instantiating mediation adapter: ".concat(valueOf) : new String("Instantiating mediation adapter: "));
        if (!this.f6229k) {
            if (((Boolean) zzdc.zzbbe.get()).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.f6219a)) {
                return mo8409a((MediationAdapter) new AdMobAdapter());
            }
            if (((Boolean) zzdc.zzbbf.get()).booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.f6219a)) {
                return mo8409a((MediationAdapter) new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.f6219a)) {
                return new zzgq(new zzgy());
            }
        }
        try {
            return this.f6220b.zzbm(this.f6219a);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            String valueOf2 = String.valueOf(this.f6219a);
            zzkd.zza(valueOf2.length() != 0 ? "Could not instantiate mediation adapter: ".concat(valueOf2) : new String("Could not instantiate mediation adapter: "), remoteException);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m7092d() {
        return this.f6222d.zzbnv != -1;
    }

    /* renamed from: e */
    private int m7093e() {
        if (this.f6223e.zzbnc == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f6223e.zzbnc);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f6219a)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = m7081a(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException e) {
            zzkd.zzcx("Could not convert to json. Returning 0");
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzgk mo8409a(MediationAdapter mediationAdapter) {
        return new zzgq(mediationAdapter);
    }

    public void cancel() {
        synchronized (this.f6227i) {
            try {
                if (this.f6233o != null) {
                    this.f6233o.destroy();
                }
            } catch (RemoteException e) {
                zzkd.zzd("Could not destroy mediation adapter.", e);
            }
            this.f6234p = -1;
            this.f6227i.notify();
        }
    }

    public zzge zza(long j, long j2) {
        zzge zzge;
        synchronized (this.f6227i) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzgc zzgc = new zzgc();
            zzkh.zzclc.post(new C1635ik(this, zzgc));
            zzgc zzgc2 = zzgc;
            zzge = new zzge(this.f6223e, this.f6233o, this.f6219a, zzgc2, this.f6234p, m7085b(), m7074a(elapsedRealtime, this.f6221c, j, j2));
        }
        return zzge;
    }

    public void zza(int i, zzgm zzgm) {
        synchronized (this.f6227i) {
            this.f6234p = i;
            this.f6235q = zzgm;
            this.f6227i.notify();
        }
    }

    public void zzy(int i) {
        synchronized (this.f6227i) {
            this.f6234p = i;
            this.f6227i.notify();
        }
    }
}
