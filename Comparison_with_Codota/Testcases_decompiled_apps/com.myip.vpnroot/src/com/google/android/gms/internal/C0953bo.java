package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.C0594d;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.internal.C0955bq;
import com.google.android.gms.internal.C0957br;

@C1130ez
/* renamed from: com.google.android.gms.internal.bo */
public class C0953bo extends C0957br.C0958a implements C0955bq.C0956a {

    /* renamed from: mw */
    private final Object f2920mw = new Object();

    /* renamed from: pl */
    private final String f2921pl;

    /* renamed from: pm */
    private final Drawable f2922pm;

    /* renamed from: pn */
    private final String f2923pn;

    /* renamed from: po */
    private final Drawable f2924po;

    /* renamed from: pp */
    private final String f2925pp;

    /* renamed from: pq */
    private final double f2926pq;

    /* renamed from: pr */
    private final String f2927pr;

    /* renamed from: ps */
    private final String f2928ps;

    /* renamed from: pt */
    private C0955bq f2929pt;

    public C0953bo(String str, Drawable drawable, String str2, Drawable drawable2, String str3, double d, String str4, String str5) {
        this.f2921pl = str;
        this.f2922pm = drawable;
        this.f2923pn = str2;
        this.f2924po = drawable2;
        this.f2925pp = str3;
        this.f2926pq = d;
        this.f2927pr = str4;
        this.f2928ps = str5;
    }

    /* renamed from: a */
    public void mo8137a(C0955bq bqVar) {
        synchronized (this.f2920mw) {
            this.f2929pt = bqVar;
        }
    }

    /* renamed from: as */
    public void mo8138as() {
        synchronized (this.f2920mw) {
            if (this.f2929pt == null) {
                C1229gs.m4676T("Attempt to record impression before app install ad initialized.");
            } else {
                this.f2929pt.mo8156as();
            }
        }
    }

    /* renamed from: bt */
    public String mo8139bt() {
        return this.f2921pl;
    }

    /* renamed from: bu */
    public C0594d mo8140bu() {
        return C0597e.m1743k(this.f2922pm);
    }

    /* renamed from: bv */
    public C0594d mo8141bv() {
        return C0597e.m1743k(this.f2924po);
    }

    /* renamed from: bw */
    public String mo8142bw() {
        return this.f2925pp;
    }

    /* renamed from: bx */
    public double mo8143bx() {
        return this.f2926pq;
    }

    /* renamed from: by */
    public String mo8144by() {
        return this.f2927pr;
    }

    /* renamed from: bz */
    public String mo8145bz() {
        return this.f2928ps;
    }

    public String getBody() {
        return this.f2923pn;
    }

    /* renamed from: i */
    public void mo8147i(int i) {
        synchronized (this.f2920mw) {
            if (this.f2929pt == null) {
                C1229gs.m4676T("Attempt to perform click before app install ad initialized.");
            } else {
                this.f2929pt.mo8157b("2", i);
            }
        }
    }
}
