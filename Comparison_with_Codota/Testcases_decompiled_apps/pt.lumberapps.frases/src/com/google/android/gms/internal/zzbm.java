package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.util.List;

public class zzbm extends zzbp {

    /* renamed from: i */
    private List f5970i = null;

    public zzbm(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        this.f5985e.zzdq = -1L;
        this.f5985e.zzdr = -1L;
        if (this.f5970i == null) {
            this.f5970i = (List) this.f5986f.invoke((Object) null, new Object[]{this.f5982b.getContext()});
        }
        if (this.f5970i != null && this.f5970i.size() == 2) {
            synchronized (this.f5985e) {
                this.f5985e.zzdq = Long.valueOf(((Long) this.f5970i.get(0)).longValue());
                this.f5985e.zzdr = Long.valueOf(((Long) this.f5970i.get(1)).longValue());
            }
        }
    }
}
