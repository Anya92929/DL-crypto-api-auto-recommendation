package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkm;
import java.util.concurrent.TimeUnit;

@zzin
public class zzx {

    /* renamed from: a */
    private final Context f3837a;

    /* renamed from: b */
    private final String f3838b;

    /* renamed from: c */
    private final VersionInfoParcel f3839c;

    /* renamed from: d */
    private final zzdi f3840d;

    /* renamed from: e */
    private final zzdk f3841e;

    /* renamed from: f */
    private final zzkm f3842f = new zzkm.zzb().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzto();

    /* renamed from: g */
    private final long[] f3843g;

    /* renamed from: h */
    private final String[] f3844h;

    /* renamed from: i */
    private zzdi f3845i;

    /* renamed from: j */
    private zzdi f3846j;

    /* renamed from: k */
    private zzdi f3847k;

    /* renamed from: l */
    private zzdi f3848l;

    /* renamed from: m */
    private boolean f3849m;

    /* renamed from: n */
    private zzi f3850n;

    /* renamed from: o */
    private boolean f3851o;

    /* renamed from: p */
    private boolean f3852p;

    /* renamed from: q */
    private long f3853q = -1;

    public zzx(Context context, VersionInfoParcel versionInfoParcel, String str, zzdk zzdk, zzdi zzdi) {
        this.f3837a = context;
        this.f3839c = versionInfoParcel;
        this.f3838b = str;
        this.f3841e = zzdk;
        this.f3840d = zzdi;
        String str2 = (String) zzdc.zzayt.get();
        if (str2 == null) {
            this.f3844h = new String[0];
            this.f3843g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.f3844h = new String[split.length];
        this.f3843g = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.f3843g[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzkd.zzd("Unable to parse frame hash target time number.", e);
                this.f3843g[i] = -1;
            }
        }
    }

    /* renamed from: a */
    private void m5702a() {
        if (this.f3847k != null && this.f3848l == null) {
            zzdg.zza(this.f3841e, this.f3847k, "vff");
            zzdg.zza(this.f3841e, this.f3840d, "vtt");
            this.f3848l = zzdg.zzb(this.f3841e);
        }
        long nanoTime = zzu.zzfu().nanoTime();
        if (this.f3849m && this.f3852p && this.f3853q != -1) {
            this.f3842f.zza(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.f3853q)));
        }
        this.f3852p = this.f3849m;
        this.f3853q = nanoTime;
    }

    /* renamed from: a */
    private void m5703a(zzi zzi) {
        long longValue = ((Long) zzdc.zzayu.get()).longValue();
        long currentPosition = (long) zzi.getCurrentPosition();
        for (int i = 0; i < this.f3844h.length; i++) {
            if (this.f3844h[i] == null && longValue > Math.abs(currentPosition - this.f3843g[i])) {
                this.f3844h[i] = mo5550a((TextureView) zzi);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo5550a(TextureView textureView) {
        long j;
        Bitmap bitmap = textureView.getBitmap(8, 8);
        long j2 = 0;
        long j3 = 63;
        int i = 0;
        while (i < 8) {
            int i2 = 0;
            long j4 = j2;
            while (true) {
                j = j3;
                int i3 = i2;
                if (i3 >= 8) {
                    break;
                }
                int pixel = bitmap.getPixel(i3, i);
                j4 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > 128 ? 1 : 0) << ((int) j);
                i2 = i3 + 1;
                j3 = j - 1;
            }
            i++;
            j3 = j;
            j2 = j4;
        }
        return String.format("%016X", new Object[]{Long.valueOf(j2)});
    }

    public void onStop() {
        if (((Boolean) zzdc.zzays.get()).booleanValue() && !this.f3851o) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.f3838b);
            bundle.putString("player", this.f3850n.zzni());
            for (zzkm.zza zza : this.f3842f.getBuckets()) {
                String valueOf = String.valueOf("fps_c_");
                String valueOf2 = String.valueOf(zza.name);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(zza.count));
                String valueOf3 = String.valueOf("fps_p_");
                String valueOf4 = String.valueOf(zza.name);
                bundle.putString(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), Double.toString(zza.zzcly));
            }
            for (int i = 0; i < this.f3843g.length; i++) {
                String str = this.f3844h[i];
                if (str != null) {
                    String valueOf5 = String.valueOf("fh_");
                    String valueOf6 = String.valueOf(Long.valueOf(this.f3843g[i]));
                    bundle.putString(new StringBuilder(String.valueOf(valueOf5).length() + 0 + String.valueOf(valueOf6).length()).append(valueOf5).append(valueOf6).toString(), str);
                }
            }
            zzu.zzfq().zza(this.f3837a, this.f3839c.zzcs, "gmob-apps", bundle, true);
            this.f3851o = true;
        }
    }

    public void zza(zzi zzi) {
        zzdg.zza(this.f3841e, this.f3840d, "vpc");
        this.f3845i = zzdg.zzb(this.f3841e);
        if (this.f3841e != null) {
            this.f3841e.zzh("vpn", zzi.zzni());
        }
        this.f3850n = zzi;
    }

    public void zzb(zzi zzi) {
        m5702a();
        m5703a(zzi);
    }

    public void zzoj() {
        if (this.f3845i != null && this.f3846j == null) {
            zzdg.zza(this.f3841e, this.f3845i, "vfr");
            this.f3846j = zzdg.zzb(this.f3841e);
        }
    }

    public void zzpi() {
        this.f3849m = true;
        if (this.f3846j != null && this.f3847k == null) {
            zzdg.zza(this.f3841e, this.f3846j, "vfp");
            this.f3847k = zzdg.zzb(this.f3841e);
        }
    }

    public void zzpj() {
        this.f3849m = false;
    }
}
