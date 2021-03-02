package com.google.android.gms.internal;

import com.google.android.gms.internal.zzm;
import java.io.UnsupportedEncodingException;

public class zzab extends zzk {

    /* renamed from: a */
    private final zzm.zzb f5548a;

    public zzab(int i, String str, zzm.zzb zzb, zzm.zza zza) {
        super(i, str, zza);
        this.f5548a = zzb;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzm mo7492a(zzi zzi) {
        String str;
        try {
            str = new String(zzi.data, zzx.zza(zzi.zzz));
        } catch (UnsupportedEncodingException e) {
            str = new String(zzi.data);
        }
        return zzm.zza(str, zzx.zzb(zzi));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7494a(String str) {
        this.f5548a.zzb(str);
    }
}
