package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.zzae;
import java.util.ArrayList;
import java.util.List;

public class zzap extends zzaq {

    /* renamed from: p */
    private static final String f5882p = zzap.class.getSimpleName();

    /* renamed from: q */
    private AdvertisingIdClient.Info f5883q;

    protected zzap(Context context) {
        super(context, "");
    }

    public static zzap zze(Context context) {
        m6867a(context, true);
        return new zzap(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7953a(zzax zzax, zzae.zza zza) {
        if (!zzax.zzci()) {
            mo8081a(mo7954b(zzax, zza));
        } else if (this.f5883q != null) {
            String id = this.f5883q.getId();
            if (!TextUtils.isEmpty(id)) {
                zza.zzeg = zzay.zzo(id);
                zza.zzeh = 5;
                zza.zzei = Boolean.valueOf(this.f5883q.isLimitAdTrackingEnabled());
            }
            this.f5883q = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public zzae.zza mo7899b(Context context) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List mo7954b(zzax zzax, zzae.zza zza) {
        ArrayList arrayList = new ArrayList();
        if (zzax.zzcd() == null) {
            return arrayList;
        }
        zzax zzax2 = zzax;
        arrayList.add(new zzbh(zzax2, zzav.zzbl(), zzav.zzbm(), zza, zzax.zzat(), 24));
        return arrayList;
    }

    public String zza(String str, String str2) {
        return C1462c.m6292a(str, str2, true);
    }

    public void zza(AdvertisingIdClient.Info info) {
        this.f5883q = info;
    }
}
