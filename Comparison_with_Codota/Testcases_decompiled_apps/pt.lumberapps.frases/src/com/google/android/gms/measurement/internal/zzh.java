package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;

public class zzh {

    /* renamed from: a */
    final String f7280a;

    /* renamed from: b */
    final String f7281b;

    /* renamed from: c */
    final String f7282c;

    /* renamed from: d */
    final long f7283d;

    /* renamed from: e */
    final long f7284e;

    /* renamed from: f */
    final EventParams f7285f;

    zzh(zzx zzx, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzab.zzhr(str2);
        zzab.zzhr(str3);
        this.f7280a = str2;
        this.f7281b = str3;
        this.f7282c = TextUtils.isEmpty(str) ? null : str;
        this.f7283d = j;
        this.f7284e = j2;
        if (this.f7284e != 0 && this.f7284e > this.f7283d) {
            zzx.zzbsd().zzbsx().log("Event created with reverse previous/current timestamps");
        }
        this.f7285f = mo9563a(zzx, bundle);
    }

    private zzh(zzx zzx, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        zzab.zzhr(str2);
        zzab.zzhr(str3);
        zzab.zzy(eventParams);
        this.f7280a = str2;
        this.f7281b = str3;
        this.f7282c = TextUtils.isEmpty(str) ? null : str;
        this.f7283d = j;
        this.f7284e = j2;
        if (this.f7284e != 0 && this.f7284e > this.f7283d) {
            zzx.zzbsd().zzbsx().log("Event created with reverse previous/current timestamps");
        }
        this.f7285f = eventParams;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public EventParams mo9563a(zzx zzx, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                zzx.zzbsd().zzbsv().log("Param name can't be null");
                it.remove();
            } else {
                Object zzl = zzx.zzbrz().zzl(str, bundle2.get(str));
                if (zzl == null) {
                    zzx.zzbsd().zzbsx().zzj("Param value can't be null", str);
                    it.remove();
                } else {
                    zzx.zzbrz().zza(bundle2, str, zzl);
                }
            }
        }
        return new EventParams(bundle2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public zzh mo9564a(zzx zzx, long j) {
        return new zzh(zzx, this.f7282c, this.f7280a, this.f7281b, this.f7283d, j, this.f7285f);
    }

    public String toString() {
        String str = this.f7280a;
        String str2 = this.f7281b;
        String valueOf = String.valueOf(this.f7285f);
        return new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length()).append("Event{appId='").append(str).append("'").append(", name='").append(str2).append("'").append(", params=").append(valueOf).append("}").toString();
    }
}
