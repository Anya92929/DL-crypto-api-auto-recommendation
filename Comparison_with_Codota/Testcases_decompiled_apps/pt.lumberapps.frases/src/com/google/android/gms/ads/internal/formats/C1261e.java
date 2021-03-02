package com.google.android.gms.ads.internal.formats;

import android.text.TextUtils;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzli;
import java.util.Map;

/* renamed from: com.google.android.gms.ads.internal.formats.e */
class C1261e implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzft f3628a;

    /* renamed from: b */
    final /* synthetic */ C1260d f3629b;

    C1261e(C1260d dVar, zzft zzft) {
        this.f3629b = dVar;
        this.f3628a = zzft;
    }

    public void zza(zzlh zzlh, Map map) {
        this.f3629b.f3627a.f3696j.zzuj().zza((zzli.zza) new C1262f(this, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            this.f3629b.f3627a.f3696j.loadData(str, "text/html", "UTF-8");
        } else {
            this.f3629b.f3627a.f3696j.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        }
    }
}
