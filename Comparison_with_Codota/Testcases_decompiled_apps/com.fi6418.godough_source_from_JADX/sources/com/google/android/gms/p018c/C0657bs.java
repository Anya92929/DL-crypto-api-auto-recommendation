package com.google.android.gms.p018c;

/* renamed from: com.google.android.gms.c.bs */
public abstract class C0657bs {

    /* renamed from: n */
    protected volatile int f4335n = -1;

    /* renamed from: a */
    public void mo7163a(C0650bl blVar) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo7165c() {
        return 0;
    }

    /* renamed from: f */
    public C0657bs clone() {
        return (C0657bs) super.clone();
    }

    /* renamed from: g */
    public int mo7189g() {
        if (this.f4335n < 0) {
            mo7190h();
        }
        return this.f4335n;
    }

    /* renamed from: h */
    public int mo7190h() {
        int c = mo7165c();
        this.f4335n = c;
        return c;
    }

    public String toString() {
        return C0658bt.m3830a(this);
    }
}
