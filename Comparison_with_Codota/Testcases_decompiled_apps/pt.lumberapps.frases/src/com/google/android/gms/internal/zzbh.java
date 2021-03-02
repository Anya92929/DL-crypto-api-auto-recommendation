package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.zzae;
import java.io.IOException;

public class zzbh extends zzbp {
    public zzbh(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
    }

    /* renamed from: a */
    private void m6906a(String str) {
    }

    /* renamed from: b */
    private void m6907b() {
        synchronized (this.f5985e) {
            this.f5985e.zzeg = (String) this.f5986f.invoke((Object) null, new Object[]{this.f5982b.getContext()});
        }
    }

    /* renamed from: c */
    private void m6908c() {
        AdvertisingIdClient zzcr = this.f5982b.zzcr();
        if (zzcr == null) {
            m6906a("E1");
            return;
        }
        try {
            AdvertisingIdClient.Info info = zzcr.getInfo();
            String zzo = zzay.zzo(info.getId());
            if (zzo != null) {
                synchronized (this.f5985e) {
                    this.f5985e.zzeg = zzo;
                    this.f5985e.zzei = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                    this.f5985e.zzeh = 5;
                }
                return;
            }
            m6906a("E");
        } catch (IOException e) {
            m6906a("E");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        if (this.f5982b.zzci()) {
            m6908c();
        } else {
            m6907b();
        }
    }
}
