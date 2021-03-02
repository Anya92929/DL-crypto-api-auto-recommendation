package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.pi */
class C1714pi {
    private static final C1715pj awB = new C1715pj();
    private boolean awC;
    private int[] awD;
    private C1715pj[] awE;
    private int mSize;

    public C1714pi() {
        this(10);
    }

    public C1714pi(int i) {
        this.awC = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.awD = new int[idealIntArraySize];
        this.awE = new C1715pj[idealIntArraySize];
        this.mSize = 0;
    }

    /* renamed from: a */
    private boolean m6071a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m6072a(C1715pj[] pjVarArr, C1715pj[] pjVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!pjVarArr[i2].equals(pjVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: gF */
    private int m6073gF(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.awD[i4];
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

    /* renamed from: gc */
    private void m6074gc() {
        int i = this.mSize;
        int[] iArr = this.awD;
        C1715pj[] pjVarArr = this.awE;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            C1715pj pjVar = pjVarArr[i3];
            if (pjVar != awB) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    pjVarArr[i2] = pjVar;
                    pjVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.awC = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    private int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    /* renamed from: a */
    public void mo10092a(int i, C1715pj pjVar) {
        int gF = m6073gF(i);
        if (gF >= 0) {
            this.awE[gF] = pjVar;
            return;
        }
        int i2 = gF ^ -1;
        if (i2 >= this.mSize || this.awE[i2] != awB) {
            if (this.awC && this.mSize >= this.awD.length) {
                m6074gc();
                i2 = m6073gF(i) ^ -1;
            }
            if (this.mSize >= this.awD.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                C1715pj[] pjVarArr = new C1715pj[idealIntArraySize];
                System.arraycopy(this.awD, 0, iArr, 0, this.awD.length);
                System.arraycopy(this.awE, 0, pjVarArr, 0, this.awE.length);
                this.awD = iArr;
                this.awE = pjVarArr;
            }
            if (this.mSize - i2 != 0) {
                System.arraycopy(this.awD, i2, this.awD, i2 + 1, this.mSize - i2);
                System.arraycopy(this.awE, i2, this.awE, i2 + 1, this.mSize - i2);
            }
            this.awD[i2] = i;
            this.awE[i2] = pjVar;
            this.mSize++;
            return;
        }
        this.awD[i2] = i;
        this.awE[i2] = pjVar;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C1714pi)) {
            return false;
        }
        C1714pi piVar = (C1714pi) o;
        if (size() != piVar.size()) {
            return false;
        }
        return m6071a(this.awD, piVar.awD, this.mSize) && m6072a(this.awE, piVar.awE, this.mSize);
    }

    /* renamed from: gD */
    public C1715pj mo10094gD(int i) {
        int gF = m6073gF(i);
        if (gF < 0 || this.awE[gF] == awB) {
            return null;
        }
        return this.awE[gF];
    }

    /* renamed from: gE */
    public C1715pj mo10095gE(int i) {
        if (this.awC) {
            m6074gc();
        }
        return this.awE[i];
    }

    public int hashCode() {
        if (this.awC) {
            m6074gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.awD[i2]) * 31) + this.awE[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        if (this.awC) {
            m6074gc();
        }
        return this.mSize;
    }
}
