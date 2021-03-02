package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.p009v4.p019f.C0150o;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzin;

@zzin
public class zzk extends zzs.zza {

    /* renamed from: a */
    private zzq f4040a;

    /* renamed from: b */
    private zzeb f4041b;

    /* renamed from: c */
    private zzec f4042c;

    /* renamed from: d */
    private C0150o f4043d = new C0150o();

    /* renamed from: e */
    private C0150o f4044e = new C0150o();

    /* renamed from: f */
    private NativeAdOptionsParcel f4045f;

    /* renamed from: g */
    private zzy f4046g;

    /* renamed from: h */
    private final Context f4047h;

    /* renamed from: i */
    private final zzgj f4048i;

    /* renamed from: j */
    private final String f4049j;

    /* renamed from: k */
    private final VersionInfoParcel f4050k;

    /* renamed from: l */
    private final zzd f4051l;

    public zzk(Context context, String str, zzgj zzgj, VersionInfoParcel versionInfoParcel, zzd zzd) {
        this.f4047h = context;
        this.f4049j = str;
        this.f4048i = zzgj;
        this.f4050k = versionInfoParcel;
        this.f4051l = zzd;
    }

    public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.f4045f = nativeAdOptionsParcel;
    }

    public void zza(zzeb zzeb) {
        this.f4041b = zzeb;
    }

    public void zza(zzec zzec) {
        this.f4042c = zzec;
    }

    public void zza(String str, zzee zzee, zzed zzed) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.f4044e.put(str, zzee);
        this.f4043d.put(str, zzed);
    }

    public void zzb(zzq zzq) {
        this.f4040a = zzq;
    }

    public void zzb(zzy zzy) {
        this.f4046g = zzy;
    }

    public zzr zzes() {
        return new zzj(this.f4047h, this.f4049j, this.f4048i, this.f4050k, this.f4040a, this.f4041b, this.f4042c, this.f4044e, this.f4043d, this.f4045f, this.f4046g, this.f4051l);
    }
}
