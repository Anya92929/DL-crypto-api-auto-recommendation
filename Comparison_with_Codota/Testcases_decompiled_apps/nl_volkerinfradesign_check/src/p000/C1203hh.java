package p000;

import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzsp;
import com.google.android.gms.internal.zzsu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: hh */
public class C1203hh implements Cloneable {

    /* renamed from: a */
    private zzsp<?, ?> f4261a;

    /* renamed from: b */
    private Object f4262b;

    /* renamed from: c */
    private List<C1204hi> f4263c = new ArrayList();

    /* renamed from: c */
    private byte[] m5272c() throws IOException {
        byte[] bArr = new byte[mo8278a()];
        mo8280a(zzsn.zzE(bArr));
        return bArr;
    }

    /* renamed from: a */
    public int mo8278a() {
        int i = 0;
        if (this.f4262b != null) {
            return this.f4261a.mo6051a(this.f4262b);
        }
        Iterator<C1204hi> it = this.f4263c.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().mo8286a() + i2;
        }
    }

    /* renamed from: a */
    public <T> T mo8279a(zzsp<?, T> zzsp) {
        if (this.f4262b == null) {
            this.f4261a = zzsp;
            this.f4262b = zzsp.mo6052a(this.f4263c);
            this.f4263c = null;
        } else if (this.f4261a != zzsp) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return this.f4262b;
    }

    /* renamed from: a */
    public void mo8280a(zzsn zzsn) throws IOException {
        if (this.f4262b != null) {
            this.f4261a.mo6053a(this.f4262b, zzsn);
            return;
        }
        for (C1204hi a : this.f4263c) {
            a.mo8287a(zzsn);
        }
    }

    /* renamed from: a */
    public void mo8281a(C1204hi hiVar) {
        this.f4263c.add(hiVar);
    }

    /* renamed from: b */
    public final C1203hh clone() {
        C1203hh hhVar = new C1203hh();
        try {
            hhVar.f4261a = this.f4261a;
            if (this.f4263c == null) {
                hhVar.f4263c = null;
            } else {
                hhVar.f4263c.addAll(this.f4263c);
            }
            if (this.f4262b != null) {
                if (this.f4262b instanceof zzsu) {
                    hhVar.f4262b = ((zzsu) this.f4262b).clone();
                } else if (this.f4262b instanceof byte[]) {
                    hhVar.f4262b = ((byte[]) this.f4262b).clone();
                } else if (this.f4262b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f4262b;
                    byte[][] bArr2 = new byte[bArr.length][];
                    hhVar.f4262b = bArr2;
                    for (int i = 0; i < bArr.length; i++) {
                        bArr2[i] = (byte[]) bArr[i].clone();
                    }
                } else if (this.f4262b instanceof boolean[]) {
                    hhVar.f4262b = ((boolean[]) this.f4262b).clone();
                } else if (this.f4262b instanceof int[]) {
                    hhVar.f4262b = ((int[]) this.f4262b).clone();
                } else if (this.f4262b instanceof long[]) {
                    hhVar.f4262b = ((long[]) this.f4262b).clone();
                } else if (this.f4262b instanceof float[]) {
                    hhVar.f4262b = ((float[]) this.f4262b).clone();
                } else if (this.f4262b instanceof double[]) {
                    hhVar.f4262b = ((double[]) this.f4262b).clone();
                } else if (this.f4262b instanceof zzsu[]) {
                    zzsu[] zzsuArr = (zzsu[]) this.f4262b;
                    zzsu[] zzsuArr2 = new zzsu[zzsuArr.length];
                    hhVar.f4262b = zzsuArr2;
                    for (int i2 = 0; i2 < zzsuArr.length; i2++) {
                        zzsuArr2[i2] = zzsuArr[i2].clone();
                    }
                }
            }
            return hhVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1203hh)) {
            return false;
        }
        C1203hh hhVar = (C1203hh) obj;
        if (this.f4262b == null || hhVar.f4262b == null) {
            if (this.f4263c != null && hhVar.f4263c != null) {
                return this.f4263c.equals(hhVar.f4263c);
            }
            try {
                return Arrays.equals(m5272c(), hhVar.m5272c());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.f4261a == hhVar.f4261a) {
            return !this.f4261a.zzbuk.isArray() ? this.f4262b.equals(hhVar.f4262b) : this.f4262b instanceof byte[] ? Arrays.equals((byte[]) this.f4262b, (byte[]) hhVar.f4262b) : this.f4262b instanceof int[] ? Arrays.equals((int[]) this.f4262b, (int[]) hhVar.f4262b) : this.f4262b instanceof long[] ? Arrays.equals((long[]) this.f4262b, (long[]) hhVar.f4262b) : this.f4262b instanceof float[] ? Arrays.equals((float[]) this.f4262b, (float[]) hhVar.f4262b) : this.f4262b instanceof double[] ? Arrays.equals((double[]) this.f4262b, (double[]) hhVar.f4262b) : this.f4262b instanceof boolean[] ? Arrays.equals((boolean[]) this.f4262b, (boolean[]) hhVar.f4262b) : Arrays.deepEquals((Object[]) this.f4262b, (Object[]) hhVar.f4262b);
        } else {
            return false;
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(m5272c()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
