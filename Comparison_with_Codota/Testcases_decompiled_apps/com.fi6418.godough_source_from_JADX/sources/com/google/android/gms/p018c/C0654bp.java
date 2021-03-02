package com.google.android.gms.p018c;

/* renamed from: com.google.android.gms.c.bp */
class C0654bp implements Cloneable {

    /* renamed from: a */
    private static final C0655bq f4326a = new C0655bq();

    /* renamed from: b */
    private boolean f4327b;

    /* renamed from: c */
    private int[] f4328c;

    /* renamed from: d */
    private C0655bq[] f4329d;

    /* renamed from: e */
    private int f4330e;

    public C0654bp() {
        this(10);
    }

    public C0654bp(int i) {
        this.f4327b = false;
        int b = m3809b(i);
        this.f4328c = new int[b];
        this.f4329d = new C0655bq[b];
        this.f4330e = 0;
    }

    /* renamed from: a */
    private boolean m3807a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m3808a(C0655bq[] bqVarArr, C0655bq[] bqVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!bqVarArr[i2].equals(bqVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private int m3809b(int i) {
        return m3810c(i * 4) / 4;
    }

    /* renamed from: c */
    private int m3810c(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    /* renamed from: d */
    private void m3811d() {
        int i = this.f4330e;
        int[] iArr = this.f4328c;
        C0655bq[] bqVarArr = this.f4329d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            C0655bq bqVar = bqVarArr[i3];
            if (bqVar != f4326a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    bqVarArr[i2] = bqVar;
                    bqVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.f4327b = false;
        this.f4330e = i2;
    }

    /* renamed from: a */
    public int mo7176a() {
        if (this.f4327b) {
            m3811d();
        }
        return this.f4330e;
    }

    /* renamed from: a */
    public C0655bq mo7177a(int i) {
        if (this.f4327b) {
            m3811d();
        }
        return this.f4329d[i];
    }

    /* renamed from: b */
    public boolean mo7178b() {
        return mo7176a() == 0;
    }

    /* renamed from: c */
    public final C0654bp clone() {
        int a = mo7176a();
        C0654bp bpVar = new C0654bp(a);
        System.arraycopy(this.f4328c, 0, bpVar.f4328c, 0, a);
        for (int i = 0; i < a; i++) {
            if (this.f4329d[i] != null) {
                bpVar.f4329d[i] = this.f4329d[i].clone();
            }
        }
        bpVar.f4330e = a;
        return bpVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0654bp)) {
            return false;
        }
        C0654bp bpVar = (C0654bp) obj;
        if (mo7176a() != bpVar.mo7176a()) {
            return false;
        }
        return m3807a(this.f4328c, bpVar.f4328c, this.f4330e) && m3808a(this.f4329d, bpVar.f4329d, this.f4330e);
    }

    public int hashCode() {
        if (this.f4327b) {
            m3811d();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.f4330e; i2++) {
            i = (((i * 31) + this.f4328c[i2]) * 31) + this.f4329d[i2].hashCode();
        }
        return i;
    }
}
