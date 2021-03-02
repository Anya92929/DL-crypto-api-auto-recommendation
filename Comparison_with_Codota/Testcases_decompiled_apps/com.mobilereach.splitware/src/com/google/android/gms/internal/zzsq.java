package com.google.android.gms.internal;

public final class zzsq implements Cloneable {
    private static final zzsr zzbum = new zzsr();
    private int mSize;
    private boolean zzbun;
    private int[] zzbuo;
    private zzsr[] zzbup;

    zzsq() {
        this(10);
    }

    zzsq(int i) {
        this.zzbun = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzbuo = new int[idealIntArraySize];
        this.zzbup = new zzsr[idealIntArraySize];
        this.mSize = 0;
    }

    /* renamed from: gc */
    private void m17gc() {
        int i = this.mSize;
        int[] iArr = this.zzbuo;
        zzsr[] zzsrArr = this.zzbup;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzsr zzsr = zzsrArr[i3];
            if (zzsr != zzbum) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    zzsrArr[i2] = zzsr;
                    zzsrArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzbun = false;
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

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzsr[] zzsrArr, zzsr[] zzsrArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzsrArr[i2].equals(zzsrArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzmH(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzbuo[i4];
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

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzsq)) {
            return false;
        }
        zzsq zzsq = (zzsq) o;
        if (size() != zzsq.size()) {
            return false;
        }
        return zza(this.zzbuo, zzsq.zzbuo, this.mSize) && zza(this.zzbup, zzsq.zzbup, this.mSize);
    }

    public int hashCode() {
        if (this.zzbun) {
            m17gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzbuo[i2]) * 31) + this.zzbup[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: package-private */
    public int size() {
        if (this.zzbun) {
            m17gc();
        }
        return this.mSize;
    }

    /* renamed from: zzJq */
    public final zzsq clone() {
        int size = size();
        zzsq zzsq = new zzsq(size);
        System.arraycopy(this.zzbuo, 0, zzsq.zzbuo, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.zzbup[i] != null) {
                zzsq.zzbup[i] = this.zzbup[i].clone();
            }
        }
        zzsq.mSize = size;
        return zzsq;
    }

    /* access modifiers changed from: package-private */
    public void zza(int i, zzsr zzsr) {
        int zzmH = zzmH(i);
        if (zzmH >= 0) {
            this.zzbup[zzmH] = zzsr;
            return;
        }
        int i2 = zzmH ^ -1;
        if (i2 >= this.mSize || this.zzbup[i2] != zzbum) {
            if (this.zzbun && this.mSize >= this.zzbuo.length) {
                m17gc();
                i2 = zzmH(i) ^ -1;
            }
            if (this.mSize >= this.zzbuo.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzsr[] zzsrArr = new zzsr[idealIntArraySize];
                System.arraycopy(this.zzbuo, 0, iArr, 0, this.zzbuo.length);
                System.arraycopy(this.zzbup, 0, zzsrArr, 0, this.zzbup.length);
                this.zzbuo = iArr;
                this.zzbup = zzsrArr;
            }
            if (this.mSize - i2 != 0) {
                System.arraycopy(this.zzbuo, i2, this.zzbuo, i2 + 1, this.mSize - i2);
                System.arraycopy(this.zzbup, i2, this.zzbup, i2 + 1, this.mSize - i2);
            }
            this.zzbuo[i2] = i;
            this.zzbup[i2] = zzsr;
            this.mSize++;
            return;
        }
        this.zzbuo[i2] = i;
        this.zzbup[i2] = zzsr;
    }

    /* access modifiers changed from: package-private */
    public zzsr zzmF(int i) {
        int zzmH = zzmH(i);
        if (zzmH < 0 || this.zzbup[zzmH] == zzbum) {
            return null;
        }
        return this.zzbup[zzmH];
    }

    /* access modifiers changed from: package-private */
    public zzsr zzmG(int i) {
        if (this.zzbun) {
            m17gc();
        }
        return this.zzbup[i];
    }
}
