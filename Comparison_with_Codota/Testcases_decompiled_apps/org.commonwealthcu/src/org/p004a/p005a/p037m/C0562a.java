package org.p004a.p005a.p037m;

import java.io.Serializable;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.m.a */
public final class C0562a implements Serializable {

    /* renamed from: a */
    private byte[] f631a;

    /* renamed from: b */
    private int f632b;

    public C0562a(int i) {
        C0250b.m78a(i, "Buffer capacity");
        this.f631a = new byte[i];
    }

    /* renamed from: c */
    private void m1171c(int i) {
        byte[] bArr = new byte[Math.max(this.f631a.length << 1, i)];
        System.arraycopy(this.f631a, 0, bArr, 0, this.f632b);
        this.f631a = bArr;
    }

    /* renamed from: a */
    public final void mo5412a() {
        this.f632b = 0;
    }

    /* renamed from: a */
    public final void mo5413a(int i) {
        int i2 = this.f632b + 1;
        if (i2 > this.f631a.length) {
            m1171c(i2);
        }
        this.f631a[this.f632b] = (byte) i;
        this.f632b = i2;
    }

    /* renamed from: a */
    public final void mo5414a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i < 0 || i > bArr.length || i2 < 0 || i + i2 < 0 || i + i2 > bArr.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + bArr.length);
            } else if (i2 != 0) {
                int i3 = this.f632b + i2;
                if (i3 > this.f631a.length) {
                    m1171c(i3);
                }
                System.arraycopy(bArr, i, this.f631a, this.f632b, i2);
                this.f632b = i3;
            }
        }
    }

    /* renamed from: a */
    public final void mo5415a(char[] cArr, int i, int i2) {
        if (cArr != null) {
            if (i < 0 || i > cArr.length || i2 < 0 || i + i2 < 0 || i + i2 > cArr.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + cArr.length);
            } else if (i2 != 0) {
                int i3 = this.f632b;
                int i4 = i3 + i2;
                if (i4 > this.f631a.length) {
                    m1171c(i4);
                }
                while (i3 < i4) {
                    this.f631a[i3] = (byte) cArr[i];
                    i++;
                    i3++;
                }
                this.f632b = i4;
            }
        }
    }

    /* renamed from: b */
    public final int mo5416b(int i) {
        return this.f631a[i];
    }

    /* renamed from: b */
    public final byte[] mo5417b() {
        byte[] bArr = new byte[this.f632b];
        if (this.f632b > 0) {
            System.arraycopy(this.f631a, 0, bArr, 0, this.f632b);
        }
        return bArr;
    }

    /* renamed from: c */
    public final int mo5418c() {
        return this.f631a.length;
    }

    /* renamed from: d */
    public final int mo5419d() {
        return this.f632b;
    }

    /* renamed from: e */
    public final byte[] mo5420e() {
        return this.f631a;
    }

    /* renamed from: f */
    public final boolean mo5421f() {
        return this.f632b == 0;
    }

    /* renamed from: g */
    public final boolean mo5422g() {
        return this.f632b == this.f631a.length;
    }
}
