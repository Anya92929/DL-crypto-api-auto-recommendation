package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzdc;

/* renamed from: com.google.android.gms.ads.internal.request.e */
final class C1304e implements C1305f {

    /* renamed from: a */
    final /* synthetic */ Context f3918a;

    C1304e(Context context) {
        this.f3918a = context;
    }

    /* renamed from: a */
    public boolean mo5641a(VersionInfoParcel versionInfoParcel) {
        return versionInfoParcel.zzcnm || (zzi.zzcl(this.f3918a) && !((Boolean) zzdc.zzayz.get()).booleanValue());
    }
}
