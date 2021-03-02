package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzae;
import java.util.ArrayList;
import java.util.List;

public class zzar extends zzaq {

    /* renamed from: p */
    private static final String f5920p = zzar.class.getSimpleName();

    protected zzar(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzar zza(String str, Context context, boolean z) {
        m6867a(context, z);
        return new zzar(context, str, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List mo7954b(zzax zzax, zzae.zza zza) {
        if (zzax.zzcd() == null || !this.f5914i) {
            return super.mo7954b(zzax, zza);
        }
        int zzat = zzax.zzat();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.mo7954b(zzax, zza));
        arrayList.add(new zzbh(zzax, zzav.zzbl(), zzav.zzbm(), zza, zzat, 24));
        return arrayList;
    }
}
