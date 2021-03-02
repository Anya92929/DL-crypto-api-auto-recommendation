package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.dk */
class C1500dk implements Cloneable {

    /* renamed from: a */
    private zzapq f4932a;

    /* renamed from: b */
    private Object f4933b;

    /* renamed from: c */
    private List f4934c = new ArrayList();

    C1500dk() {
    }

    /* renamed from: c */
    private byte[] m6357c() {
        byte[] bArr = new byte[mo7180a()];
        mo7183a(zzapo.zzbe(bArr));
        return bArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7180a() {
        int i = 0;
        if (this.f4933b != null) {
            return this.f4932a.mo8028a(this.f4933b);
        }
        Iterator it = this.f4934c.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((C1501dl) it.next()).mo7188a() + i2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo7181a(zzapq zzapq) {
        if (this.f4933b == null) {
            this.f4932a = zzapq;
            this.f4933b = zzapq.mo8030a(this.f4934c);
            this.f4934c = null;
        } else if (!this.f4932a.equals(zzapq)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.f4933b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7182a(C1501dl dlVar) {
        this.f4934c.add(dlVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7183a(zzapo zzapo) {
        if (this.f4933b != null) {
            this.f4932a.mo8032a(this.f4933b, zzapo);
            return;
        }
        for (C1501dl a : this.f4934c) {
            a.mo7189a(zzapo);
        }
    }

    /* renamed from: b */
    public final C1500dk clone() {
        int i = 0;
        C1500dk dkVar = new C1500dk();
        try {
            dkVar.f4932a = this.f4932a;
            if (this.f4934c == null) {
                dkVar.f4934c = null;
            } else {
                dkVar.f4934c.addAll(this.f4934c);
            }
            if (this.f4933b != null) {
                if (this.f4933b instanceof zzapv) {
                    dkVar.f4933b = (zzapv) ((zzapv) this.f4933b).clone();
                } else if (this.f4933b instanceof byte[]) {
                    dkVar.f4933b = ((byte[]) this.f4933b).clone();
                } else if (this.f4933b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f4933b;
                    byte[][] bArr2 = new byte[bArr.length][];
                    dkVar.f4933b = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.f4933b instanceof boolean[]) {
                    dkVar.f4933b = ((boolean[]) this.f4933b).clone();
                } else if (this.f4933b instanceof int[]) {
                    dkVar.f4933b = ((int[]) this.f4933b).clone();
                } else if (this.f4933b instanceof long[]) {
                    dkVar.f4933b = ((long[]) this.f4933b).clone();
                } else if (this.f4933b instanceof float[]) {
                    dkVar.f4933b = ((float[]) this.f4933b).clone();
                } else if (this.f4933b instanceof double[]) {
                    dkVar.f4933b = ((double[]) this.f4933b).clone();
                } else if (this.f4933b instanceof zzapv[]) {
                    zzapv[] zzapvArr = (zzapv[]) this.f4933b;
                    zzapv[] zzapvArr2 = new zzapv[zzapvArr.length];
                    dkVar.f4933b = zzapvArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzapvArr.length) {
                            break;
                        }
                        zzapvArr2[i3] = (zzapv) zzapvArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return dkVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1500dk)) {
            return false;
        }
        C1500dk dkVar = (C1500dk) obj;
        if (this.f4933b == null || dkVar.f4933b == null) {
            if (this.f4934c != null && dkVar.f4934c != null) {
                return this.f4934c.equals(dkVar.f4934c);
            }
            try {
                return Arrays.equals(m6357c(), dkVar.m6357c());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.f4932a == dkVar.f4932a) {
            return !this.f4932a.f5897b.isArray() ? this.f4933b.equals(dkVar.f4933b) : this.f4933b instanceof byte[] ? Arrays.equals((byte[]) this.f4933b, (byte[]) dkVar.f4933b) : this.f4933b instanceof int[] ? Arrays.equals((int[]) this.f4933b, (int[]) dkVar.f4933b) : this.f4933b instanceof long[] ? Arrays.equals((long[]) this.f4933b, (long[]) dkVar.f4933b) : this.f4933b instanceof float[] ? Arrays.equals((float[]) this.f4933b, (float[]) dkVar.f4933b) : this.f4933b instanceof double[] ? Arrays.equals((double[]) this.f4933b, (double[]) dkVar.f4933b) : this.f4933b instanceof boolean[] ? Arrays.equals((boolean[]) this.f4933b, (boolean[]) dkVar.f4933b) : Arrays.deepEquals((Object[]) this.f4933b, (Object[]) dkVar.f4933b);
        } else {
            return false;
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(m6357c()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
