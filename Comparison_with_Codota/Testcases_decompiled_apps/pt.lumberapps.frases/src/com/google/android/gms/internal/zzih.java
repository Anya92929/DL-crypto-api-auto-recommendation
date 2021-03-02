package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzju;
import java.util.concurrent.TimeUnit;

@zzin
public class zzih {

    /* renamed from: a */
    private static final long f6399a = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: b */
    private static final Object f6400b = new Object();

    /* renamed from: c */
    private static boolean f6401c = false;

    /* renamed from: d */
    private static zzfs f6402d = null;

    /* renamed from: e */
    private final Context f6403e;

    /* renamed from: f */
    private final zzju.zza f6404f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzq f6405g;

    /* renamed from: h */
    private final zzas f6406h;

    /* renamed from: i */
    private zzfq f6407i;

    /* renamed from: j */
    private zzfs.zze f6408j;

    /* renamed from: k */
    private zzfp f6409k;

    /* renamed from: l */
    private boolean f6410l = false;

    public abstract class zza {
        public abstract void zze(zzft zzft);

        public void zzqq() {
        }
    }

    public zzih(Context context, zzju.zza zza2, zzq zzq, zzas zzas) {
        this.f6403e = context;
        this.f6404f = zza2;
        this.f6405g = zzq;
        this.f6406h = zzas;
        this.f6410l = ((Boolean) zzdc.zzbcf.get()).booleanValue();
    }

    /* renamed from: a */
    private String m7179a(zzju.zza zza2) {
        String str = (String) zzdc.zzbac.get();
        String valueOf = String.valueOf(zza2.zzciq.zzbto.indexOf("https") == 0 ? "https:" : "http:");
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: e */
    private void m7180e() {
        synchronized (f6400b) {
            if (!f6401c) {
                f6402d = new zzfs(this.f6403e.getApplicationContext() != null ? this.f6403e.getApplicationContext() : this.f6403e, this.f6404f.zzcip.zzaow, m7179a(this.f6404f), new C1686kh(this), new zzfs.zzb());
                f6401c = true;
            }
        }
    }

    /* renamed from: f */
    private void m7181f() {
        this.f6408j = new zzfs.zze(mo8512c().zzc(this.f6406h));
    }

    /* renamed from: g */
    private void m7182g() {
        this.f6407i = new zzfq();
    }

    /* renamed from: h */
    private void m7183h() {
        this.f6409k = (zzfp) mo8510a().zza(this.f6403e, this.f6404f.zzcip.zzaow, m7179a(this.f6404f), this.f6406h).get(f6399a, TimeUnit.MILLISECONDS);
        this.f6409k.zza(this.f6405g, this.f6405g, this.f6405g, this.f6405g, false, (zzer) null, (zzet) null, (zze) null, (zzhg) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzfq mo8510a() {
        return this.f6407i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public zzfp mo8511b() {
        return this.f6409k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public zzfs mo8512c() {
        return f6402d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public zzfs.zze mo8513d() {
        return this.f6408j;
    }

    public void zza(zza zza2) {
        if (this.f6410l) {
            zzfs.zze d = mo8513d();
            if (d == null) {
                zzkd.zzcx("SharedJavascriptEngine not initialized");
            } else {
                d.zza(new C1684kf(this, zza2), new C1685kg(this, zza2));
            }
        } else {
            zzfp b = mo8511b();
            if (b == null) {
                zzkd.zzcx("JavascriptEngine not initialized");
            } else {
                zza2.zze(b);
            }
        }
    }

    public void zzqg() {
        if (this.f6410l) {
            m7180e();
        } else {
            m7182g();
        }
    }

    public void zzqh() {
        if (this.f6410l) {
            m7181f();
        } else {
            m7183h();
        }
    }
}
