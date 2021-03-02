package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.internal.zzin;
import java.util.ArrayList;
import java.util.List;

@zzin
public final class zzf {

    /* renamed from: a */
    private long f3578a;

    /* renamed from: b */
    private Bundle f3579b;

    /* renamed from: c */
    private int f3580c;

    /* renamed from: d */
    private List f3581d;

    /* renamed from: e */
    private boolean f3582e;

    /* renamed from: f */
    private int f3583f;

    /* renamed from: g */
    private boolean f3584g;

    /* renamed from: h */
    private String f3585h;

    /* renamed from: i */
    private SearchAdRequestParcel f3586i;

    /* renamed from: j */
    private Location f3587j;

    /* renamed from: k */
    private String f3588k;

    /* renamed from: l */
    private Bundle f3589l;

    /* renamed from: m */
    private Bundle f3590m;

    /* renamed from: n */
    private List f3591n;

    /* renamed from: o */
    private String f3592o;

    /* renamed from: p */
    private String f3593p;

    /* renamed from: q */
    private boolean f3594q;

    public zzf() {
        this.f3578a = -1;
        this.f3579b = new Bundle();
        this.f3580c = -1;
        this.f3581d = new ArrayList();
        this.f3582e = false;
        this.f3583f = -1;
        this.f3584g = false;
        this.f3585h = null;
        this.f3586i = null;
        this.f3587j = null;
        this.f3588k = null;
        this.f3589l = new Bundle();
        this.f3590m = new Bundle();
        this.f3591n = new ArrayList();
        this.f3592o = null;
        this.f3593p = null;
        this.f3594q = false;
    }

    public zzf(AdRequestParcel adRequestParcel) {
        this.f3578a = adRequestParcel.zzatm;
        this.f3579b = adRequestParcel.extras;
        this.f3580c = adRequestParcel.zzatn;
        this.f3581d = adRequestParcel.zzato;
        this.f3582e = adRequestParcel.zzatp;
        this.f3583f = adRequestParcel.zzatq;
        this.f3584g = adRequestParcel.zzatr;
        this.f3585h = adRequestParcel.zzats;
        this.f3586i = adRequestParcel.zzatt;
        this.f3587j = adRequestParcel.zzatu;
        this.f3588k = adRequestParcel.zzatv;
        this.f3589l = adRequestParcel.zzatw;
        this.f3590m = adRequestParcel.zzatx;
        this.f3591n = adRequestParcel.zzaty;
        this.f3592o = adRequestParcel.zzatz;
        this.f3593p = adRequestParcel.zzaua;
    }

    public zzf zza(Location location) {
        this.f3587j = location;
        return this;
    }

    public zzf zzc(Bundle bundle) {
        this.f3589l = bundle;
        return this;
    }

    public AdRequestParcel zzig() {
        return new AdRequestParcel(7, this.f3578a, this.f3579b, this.f3580c, this.f3581d, this.f3582e, this.f3583f, this.f3584g, this.f3585h, this.f3586i, this.f3587j, this.f3588k, this.f3589l, this.f3590m, this.f3591n, this.f3592o, this.f3593p, false);
    }
}
