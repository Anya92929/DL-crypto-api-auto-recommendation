package com.google.android.gms.p018c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.c.bq */
class C0655bq implements Cloneable {

    /* renamed from: a */
    private C0653bo<?, ?> f4331a;

    /* renamed from: b */
    private Object f4332b;

    /* renamed from: c */
    private List<C0659bu> f4333c = new ArrayList();

    C0655bq() {
    }

    /* renamed from: c */
    private byte[] m3816c() {
        byte[] bArr = new byte[mo7183a()];
        mo7184a(C0650bl.m3758a(bArr));
        return bArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7183a() {
        int i = 0;
        if (this.f4332b != null) {
            return this.f4331a.mo7170a(this.f4332b);
        }
        Iterator<C0659bu> it = this.f4333c.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().mo7192a() + i2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7184a(C0650bl blVar) {
        if (this.f4332b != null) {
            this.f4331a.mo7171a(this.f4332b, blVar);
            return;
        }
        for (C0659bu a : this.f4333c) {
            a.mo7193a(blVar);
        }
    }

    /* renamed from: b */
    public final C0655bq clone() {
        C0655bq bqVar = new C0655bq();
        try {
            bqVar.f4331a = this.f4331a;
            if (this.f4333c == null) {
                bqVar.f4333c = null;
            } else {
                bqVar.f4333c.addAll(this.f4333c);
            }
            if (this.f4332b != null) {
                if (this.f4332b instanceof C0657bs) {
                    bqVar.f4332b = ((C0657bs) this.f4332b).clone();
                } else if (this.f4332b instanceof byte[]) {
                    bqVar.f4332b = ((byte[]) this.f4332b).clone();
                } else if (this.f4332b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f4332b;
                    byte[][] bArr2 = new byte[bArr.length][];
                    bqVar.f4332b = bArr2;
                    for (int i = 0; i < bArr.length; i++) {
                        bArr2[i] = (byte[]) bArr[i].clone();
                    }
                } else if (this.f4332b instanceof boolean[]) {
                    bqVar.f4332b = ((boolean[]) this.f4332b).clone();
                } else if (this.f4332b instanceof int[]) {
                    bqVar.f4332b = ((int[]) this.f4332b).clone();
                } else if (this.f4332b instanceof long[]) {
                    bqVar.f4332b = ((long[]) this.f4332b).clone();
                } else if (this.f4332b instanceof float[]) {
                    bqVar.f4332b = ((float[]) this.f4332b).clone();
                } else if (this.f4332b instanceof double[]) {
                    bqVar.f4332b = ((double[]) this.f4332b).clone();
                } else if (this.f4332b instanceof C0657bs[]) {
                    C0657bs[] bsVarArr = (C0657bs[]) this.f4332b;
                    C0657bs[] bsVarArr2 = new C0657bs[bsVarArr.length];
                    bqVar.f4332b = bsVarArr2;
                    for (int i2 = 0; i2 < bsVarArr.length; i2++) {
                        bsVarArr2[i2] = bsVarArr[i2].clone();
                    }
                }
            }
            return bqVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0655bq)) {
            return false;
        }
        C0655bq bqVar = (C0655bq) obj;
        if (this.f4332b == null || bqVar.f4332b == null) {
            if (this.f4333c != null && bqVar.f4333c != null) {
                return this.f4333c.equals(bqVar.f4333c);
            }
            try {
                return Arrays.equals(m3816c(), bqVar.m3816c());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.f4331a == bqVar.f4331a) {
            return !this.f4331a.f4323b.isArray() ? this.f4332b.equals(bqVar.f4332b) : this.f4332b instanceof byte[] ? Arrays.equals((byte[]) this.f4332b, (byte[]) bqVar.f4332b) : this.f4332b instanceof int[] ? Arrays.equals((int[]) this.f4332b, (int[]) bqVar.f4332b) : this.f4332b instanceof long[] ? Arrays.equals((long[]) this.f4332b, (long[]) bqVar.f4332b) : this.f4332b instanceof float[] ? Arrays.equals((float[]) this.f4332b, (float[]) bqVar.f4332b) : this.f4332b instanceof double[] ? Arrays.equals((double[]) this.f4332b, (double[]) bqVar.f4332b) : this.f4332b instanceof boolean[] ? Arrays.equals((boolean[]) this.f4332b, (boolean[]) bqVar.f4332b) : Arrays.deepEquals((Object[]) this.f4332b, (Object[]) bqVar.f4332b);
        } else {
            return false;
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(m3816c()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
