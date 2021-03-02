package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.C0594d;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.internal.C0955bq;
import com.google.android.gms.internal.C0959bs;

@C1130ez
/* renamed from: com.google.android.gms.internal.bp */
public class C0954bp extends C0959bs.C0960a implements C0955bq.C0956a {

    /* renamed from: mw */
    private final Object f2930mw = new Object();

    /* renamed from: pl */
    private final String f2931pl;

    /* renamed from: pm */
    private final Drawable f2932pm;

    /* renamed from: pn */
    private final String f2933pn;

    /* renamed from: pp */
    private final String f2934pp;

    /* renamed from: pt */
    private C0955bq f2935pt;

    /* renamed from: pu */
    private final Drawable f2936pu;

    /* renamed from: pv */
    private final String f2937pv;

    public C0954bp(String str, Drawable drawable, String str2, Drawable drawable2, String str3, String str4) {
        this.f2931pl = str;
        this.f2932pm = drawable;
        this.f2933pn = str2;
        this.f2936pu = drawable2;
        this.f2934pp = str3;
        this.f2937pv = str4;
    }

    /* renamed from: a */
    public void mo8137a(C0955bq bqVar) {
        synchronized (this.f2930mw) {
            this.f2935pt = bqVar;
        }
    }

    /* renamed from: as */
    public void mo8148as() {
        synchronized (this.f2930mw) {
            if (this.f2935pt == null) {
                C1229gs.m4676T("Attempt to record impression before content ad initialized.");
            } else {
                this.f2935pt.mo8156as();
            }
        }
    }

    /* renamed from: bA */
    public C0594d mo8149bA() {
        return C0597e.m1743k(this.f2936pu);
    }

    /* renamed from: bB */
    public String mo8150bB() {
        return this.f2937pv;
    }

    /* renamed from: bt */
    public String mo8151bt() {
        return this.f2931pl;
    }

    /* renamed from: bu */
    public C0594d mo8152bu() {
        return C0597e.m1743k(this.f2932pm);
    }

    /* renamed from: bw */
    public String mo8153bw() {
        return this.f2934pp;
    }

    public String getBody() {
        return this.f2933pn;
    }

    /* renamed from: i */
    public void mo8155i(int i) {
        synchronized (this.f2930mw) {
            if (this.f2935pt == null) {
                C1229gs.m4676T("Attempt to perform click before content ad initialized.");
            } else {
                this.f2935pt.mo8157b("1", i);
            }
        }
    }
}
