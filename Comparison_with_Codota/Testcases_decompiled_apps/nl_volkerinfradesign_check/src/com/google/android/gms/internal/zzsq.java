package com.google.android.gms.internal;

public final class zzsq implements Cloneable {

    /* renamed from: a */
    private static final C1203hh f3282a = new C1203hh();

    /* renamed from: b */
    private boolean f3283b;

    /* renamed from: c */
    private int[] f3284c;

    /* renamed from: d */
    private C1203hh[] f3285d;

    /* renamed from: e */
    private int f3286e;

    zzsq() {
        this(10);
    }

    zzsq(int i) {
        this.f3283b = false;
        int c = m4094c(i);
        this.f3284c = new int[c];
        this.f3285d = new C1203hh[c];
        this.f3286e = 0;
    }

    /* renamed from: a */
    private boolean m4091a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m4092a(C1203hh[] hhVarArr, C1203hh[] hhVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!hhVarArr[i2].equals(hhVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private void m4093b() {
        int i = this.f3286e;
        int[] iArr = this.f3284c;
        C1203hh[] hhVarArr = this.f3285d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            C1203hh hhVar = hhVarArr[i3];
            if (hhVar != f3282a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    hhVarArr[i2] = hhVar;
                    hhVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.f3283b = false;
        this.f3286e = i2;
    }

    /* renamed from: c */
    private int m4094c(int i) {
        return m4095d(i * 4) / 4;
    }

    /* renamed from: d */
    private int m4095d(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    /* renamed from: e */
    private int m4096e(int i) {
        int i2 = 0;
        int i3 = this.f3286e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.f3284c[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6060a() {
        if (this.f3283b) {
            m4093b();
        }
        return this.f3286e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1203hh mo6061a(int i) {
        int e = m4096e(i);
        if (e < 0 || this.f3285d[e] == f3282a) {
            return null;
        }
        return this.f3285d[e];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6062a(int i, C1203hh hhVar) {
        int e = m4096e(i);
        if (e >= 0) {
            this.f3285d[e] = hhVar;
            return;
        }
        int i2 = e ^ -1;
        if (i2 >= this.f3286e || this.f3285d[i2] != f3282a) {
            if (this.f3283b && this.f3286e >= this.f3284c.length) {
                m4093b();
                i2 = m4096e(i) ^ -1;
            }
            if (this.f3286e >= this.f3284c.length) {
                int c = m4094c(this.f3286e + 1);
                int[] iArr = new int[c];
                C1203hh[] hhVarArr = new C1203hh[c];
                System.arraycopy(this.f3284c, 0, iArr, 0, this.f3284c.length);
                System.arraycopy(this.f3285d, 0, hhVarArr, 0, this.f3285d.length);
                this.f3284c = iArr;
                this.f3285d = hhVarArr;
            }
            if (this.f3286e - i2 != 0) {
                System.arraycopy(this.f3284c, i2, this.f3284c, i2 + 1, this.f3286e - i2);
                System.arraycopy(this.f3285d, i2, this.f3285d, i2 + 1, this.f3286e - i2);
            }
            this.f3284c[i2] = i;
            this.f3285d[i2] = hhVar;
            this.f3286e++;
            return;
        }
        this.f3284c[i2] = i;
        this.f3285d[i2] = hhVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C1203hh mo6063b(int i) {
        if (this.f3283b) {
            m4093b();
        }
        return this.f3285d[i];
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsq)) {
            return false;
        }
        zzsq zzsq = (zzsq) obj;
        if (mo6060a() != zzsq.mo6060a()) {
            return false;
        }
        return m4091a(this.f3284c, zzsq.f3284c, this.f3286e) && m4092a(this.f3285d, zzsq.f3285d, this.f3286e);
    }

    public int hashCode() {
        if (this.f3283b) {
            m4093b();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.f3286e; i2++) {
            i = (((i * 31) + this.f3284c[i2]) * 31) + this.f3285d[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return mo6060a() == 0;
    }

    /* renamed from: zzJq */
    public final zzsq clone() {
        int a = mo6060a();
        zzsq zzsq = new zzsq(a);
        System.arraycopy(this.f3284c, 0, zzsq.f3284c, 0, a);
        for (int i = 0; i < a; i++) {
            if (this.f3285d[i] != null) {
                zzsq.f3285d[i] = this.f3285d[i].clone();
            }
        }
        zzsq.f3286e = a;
        return zzsq;
    }
}
