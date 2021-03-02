package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;

@zzin
public class zzfb extends zzkc {

    /* renamed from: a */
    final zzlh f6168a;

    /* renamed from: b */
    final zzfd f6169b;

    /* renamed from: c */
    private final String f6170c;

    zzfb(zzlh zzlh, zzfd zzfd, String str) {
        this.f6168a = zzlh;
        this.f6169b = zzfd;
        this.f6170c = str;
        zzu.zzgj().zza(this);
    }

    public void onStop() {
        this.f6169b.abort();
    }

    public void zzew() {
        try {
            this.f6169b.zzaz(this.f6170c);
        } finally {
            zzkh.zzclc.post(new C1571ga(this));
        }
    }
}
