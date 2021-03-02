package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.internal.zzkx;
import java.util.List;

/* renamed from: com.google.android.gms.internal.kn */
class C1692kn implements zzkx.zza {

    /* renamed from: a */
    final /* synthetic */ String f5223a;

    /* renamed from: b */
    final /* synthetic */ Integer f5224b;

    /* renamed from: c */
    final /* synthetic */ Integer f5225c;

    /* renamed from: d */
    final /* synthetic */ int f5226d;

    /* renamed from: e */
    final /* synthetic */ int f5227e;

    /* renamed from: f */
    final /* synthetic */ int f5228f;

    /* renamed from: g */
    final /* synthetic */ int f5229g;

    /* renamed from: h */
    final /* synthetic */ zzii f5230h;

    C1692kn(zzii zzii, String str, Integer num, Integer num2, int i, int i2, int i3, int i4) {
        this.f5230h = zzii;
        this.f5223a = str;
        this.f5224b = num;
        this.f5225c = num2;
        this.f5226d = i;
        this.f5227e = i2;
        this.f5228f = i3;
        this.f5229g = i4;
    }

    /* renamed from: a */
    public zza apply(List list) {
        zza zza;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    zza = new zza(this.f5223a, zzii.m7199b(list), this.f5224b, this.f5225c, this.f5226d > 0 ? Integer.valueOf(this.f5226d) : null, this.f5227e + this.f5228f, this.f5229g);
                    return zza;
                }
            } catch (RemoteException e) {
                zzkd.zzb("Could not get attribution icon", e);
                return null;
            }
        }
        zza = null;
        return zza;
    }
}
