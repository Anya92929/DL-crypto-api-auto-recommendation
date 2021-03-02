package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzfk;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzic;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzjx;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzki;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzkp;
import com.google.android.gms.internal.zzlc;
import com.google.android.gms.internal.zzlj;

@zzin
public class zzu {

    /* renamed from: a */
    private static final Object f4080a = new Object();

    /* renamed from: b */
    private static zzu f4081b;

    /* renamed from: A */
    private final zzlc f4082A = new zzlc();

    /* renamed from: c */
    private final zza f4083c = new zza();

    /* renamed from: d */
    private final com.google.android.gms.ads.internal.overlay.zza f4084d = new com.google.android.gms.ads.internal.overlay.zza();

    /* renamed from: e */
    private final zze f4085e = new zze();

    /* renamed from: f */
    private final zzic f4086f = new zzic();

    /* renamed from: g */
    private final zzkh f4087g = new zzkh();

    /* renamed from: h */
    private final zzlj f4088h = new zzlj();

    /* renamed from: i */
    private final zzki f4089i = zzki.zzay(Build.VERSION.SDK_INT);

    /* renamed from: j */
    private final zzjx f4090j = new zzjx(this.f4087g);

    /* renamed from: k */
    private final com.google.android.gms.common.util.zze f4091k = new zzh();

    /* renamed from: l */
    private final zzdf f4092l = new zzdf();

    /* renamed from: m */
    private final zziw f4093m = new zziw();

    /* renamed from: n */
    private final zzda f4094n = new zzda();

    /* renamed from: o */
    private final zzcz f4095o = new zzcz();

    /* renamed from: p */
    private final zzdb f4096p = new zzdb();

    /* renamed from: q */
    private final zzi f4097q = new zzi();

    /* renamed from: r */
    private final zzfk f4098r = new zzfk();

    /* renamed from: s */
    private final zzko f4099s = new zzko();

    /* renamed from: t */
    private final zzq f4100t = new zzq();

    /* renamed from: u */
    private final zzr f4101u = new zzr();

    /* renamed from: v */
    private final zzgf f4102v = new zzgf();

    /* renamed from: w */
    private final zzkp f4103w = new zzkp();

    /* renamed from: x */
    private final zzg f4104x = new zzg();

    /* renamed from: y */
    private final zzp f4105y = new zzp();

    /* renamed from: z */
    private final zzfc f4106z = new zzfc();

    static {
        m5873a(new zzu());
    }

    protected zzu() {
    }

    /* renamed from: a */
    private static zzu m5872a() {
        zzu zzu;
        synchronized (f4080a) {
            zzu = f4081b;
        }
        return zzu;
    }

    /* renamed from: a */
    protected static void m5873a(zzu zzu) {
        synchronized (f4080a) {
            f4081b = zzu;
        }
    }

    public static zza zzfm() {
        return m5872a().f4083c;
    }

    public static com.google.android.gms.ads.internal.overlay.zza zzfn() {
        return m5872a().f4084d;
    }

    public static zze zzfo() {
        return m5872a().f4085e;
    }

    public static zzic zzfp() {
        return m5872a().f4086f;
    }

    public static zzkh zzfq() {
        return m5872a().f4087g;
    }

    public static zzlj zzfr() {
        return m5872a().f4088h;
    }

    public static zzki zzfs() {
        return m5872a().f4089i;
    }

    public static zzjx zzft() {
        return m5872a().f4090j;
    }

    public static com.google.android.gms.common.util.zze zzfu() {
        return m5872a().f4091k;
    }

    public static zzdf zzfv() {
        return m5872a().f4092l;
    }

    public static zziw zzfw() {
        return m5872a().f4093m;
    }

    public static zzda zzfx() {
        return m5872a().f4094n;
    }

    public static zzcz zzfy() {
        return m5872a().f4095o;
    }

    public static zzdb zzfz() {
        return m5872a().f4096p;
    }

    public static zzi zzga() {
        return m5872a().f4097q;
    }

    public static zzfk zzgb() {
        return m5872a().f4098r;
    }

    public static zzko zzgc() {
        return m5872a().f4099s;
    }

    public static zzq zzgd() {
        return m5872a().f4100t;
    }

    public static zzr zzge() {
        return m5872a().f4101u;
    }

    public static zzgf zzgf() {
        return m5872a().f4102v;
    }

    public static zzp zzgg() {
        return m5872a().f4105y;
    }

    public static zzkp zzgh() {
        return m5872a().f4103w;
    }

    public static zzg zzgi() {
        return m5872a().f4104x;
    }

    public static zzfc zzgj() {
        return m5872a().f4106z;
    }

    public static zzlc zzgk() {
        return m5872a().f4082A;
    }
}
