package com.google.android.gms.internal;

public final class zzapr implements Cloneable {

    /* renamed from: a */
    private static final C1500dk f5899a = new C1500dk();

    /* renamed from: b */
    private boolean f5900b;

    /* renamed from: c */
    private int[] f5901c;

    /* renamed from: d */
    private C1500dk[] f5902d;

    /* renamed from: e */
    private int f5903e;

    zzapr() {
        this(10);
    }

    zzapr(int i) {
        this.f5900b = false;
        int c = m6810c(i);
        this.f5901c = new int[c];
        this.f5902d = new C1500dk[c];
        this.f5903e = 0;
    }

    /* renamed from: a */
    private boolean m6808a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m6809a(C1500dk[] dkVarArr, C1500dk[] dkVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!dkVarArr[i2].equals(dkVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    private int m6810c(int i) {
        return m6811d(i * 4) / 4;
    }

    /* renamed from: d */
    private int m6811d(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    /* renamed from: e */
    private int m6812e(int i) {
        int i2 = 0;
        int i3 = this.f5903e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.f5901c[i4];
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
    public int mo8039a() {
        return this.f5903e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1500dk mo8040a(int i) {
        int e = m6812e(i);
        if (e < 0 || this.f5902d[e] == f5899a) {
            return null;
        }
        return this.f5902d[e];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8041a(int i, C1500dk dkVar) {
        int e = m6812e(i);
        if (e >= 0) {
            this.f5902d[e] = dkVar;
            return;
        }
        int i2 = e ^ -1;
        if (i2 >= this.f5903e || this.f5902d[i2] != f5899a) {
            if (this.f5903e >= this.f5901c.length) {
                int c = m6810c(this.f5903e + 1);
                int[] iArr = new int[c];
                C1500dk[] dkVarArr = new C1500dk[c];
                System.arraycopy(this.f5901c, 0, iArr, 0, this.f5901c.length);
                System.arraycopy(this.f5902d, 0, dkVarArr, 0, this.f5902d.length);
                this.f5901c = iArr;
                this.f5902d = dkVarArr;
            }
            if (this.f5903e - i2 != 0) {
                System.arraycopy(this.f5901c, i2, this.f5901c, i2 + 1, this.f5903e - i2);
                System.arraycopy(this.f5902d, i2, this.f5902d, i2 + 1, this.f5903e - i2);
            }
            this.f5901c[i2] = i;
            this.f5902d[i2] = dkVar;
            this.f5903e++;
            return;
        }
        this.f5901c[i2] = i;
        this.f5902d[i2] = dkVar;
    }

    /* renamed from: aC */
    public final zzapr clone() {
        int a = mo8039a();
        zzapr zzapr = new zzapr(a);
        System.arraycopy(this.f5901c, 0, zzapr.f5901c, 0, a);
        for (int i = 0; i < a; i++) {
            if (this.f5902d[i] != null) {
                zzapr.f5902d[i] = (C1500dk) this.f5902d[i].clone();
            }
        }
        zzapr.f5903e = a;
        return zzapr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C1500dk mo8043b(int i) {
        return this.f5902d[i];
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzapr)) {
            return false;
        }
        zzapr zzapr = (zzapr) obj;
        if (mo8039a() != zzapr.mo8039a()) {
            return false;
        }
        return m6808a(this.f5901c, zzapr.f5901c, this.f5903e) && m6809a(this.f5902d, zzapr.f5902d, this.f5903e);
    }

    public int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f5903e; i2++) {
            i = (((i * 31) + this.f5901c[i2]) * 31) + this.f5902d[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return mo8039a() == 0;
    }
}
