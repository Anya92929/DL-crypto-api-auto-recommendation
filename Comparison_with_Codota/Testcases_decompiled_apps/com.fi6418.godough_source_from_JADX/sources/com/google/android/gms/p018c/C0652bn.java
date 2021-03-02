package com.google.android.gms.p018c;

import com.google.android.gms.p018c.C0652bn;

/* renamed from: com.google.android.gms.c.bn */
public abstract class C0652bn<M extends C0652bn<M>> extends C0657bs {

    /* renamed from: m */
    protected C0654bp f4321m;

    /* renamed from: a */
    public void mo7163a(C0650bl blVar) {
        if (this.f4321m != null) {
            for (int i = 0; i < this.f4321m.mo7176a(); i++) {
                this.f4321m.mo7177a(i).mo7184a(blVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo7164a(M m) {
        return (this.f4321m == null || this.f4321m.mo7178b()) ? m.f4321m == null || m.f4321m.mo7178b() : this.f4321m.equals(m.f4321m);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo7165c() {
        if (this.f4321m == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f4321m.mo7176a(); i2++) {
            i += this.f4321m.mo7177a(i2).mo7183a();
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final int mo7167d() {
        if (this.f4321m == null || this.f4321m.mo7178b()) {
            return 0;
        }
        return this.f4321m.hashCode();
    }

    /* renamed from: e */
    public M mo7169f() {
        M m = (C0652bn) super.clone();
        C0656br.m3822a(this, (C0652bn) m);
        return m;
    }
}
