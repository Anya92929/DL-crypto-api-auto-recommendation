package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.internal.zzic;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzli;

@zzin
public class zzia extends zzhy {

    /* renamed from: g */
    private zzhz f6375g;

    zzia(Context context, zzju.zza zza, zzlh zzlh, zzic.zza zza2) {
        super(context, zza, zzlh, zza2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8486a() {
        int i;
        int i2;
        AdSizeParcel zzdn = this.f6357c.zzdn();
        if (zzdn.zzaus) {
            DisplayMetrics displayMetrics = this.f6356b.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        } else {
            i = zzdn.widthPixels;
            i2 = zzdn.heightPixels;
        }
        this.f6375g = new zzhz(this, this.f6357c, i, i2);
        this.f6357c.zzuj().zza((zzli.zza) this);
        this.f6375g.zza(this.f6359e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo8488b() {
        if (!this.f6375g.zzqb()) {
            return !this.f6375g.zzqc() ? 2 : -2;
        }
        zzkd.zzcv("Ad-Network indicated no fill with passback URL.");
        return 3;
    }
}
