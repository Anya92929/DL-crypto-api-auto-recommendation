package org.p004a.p005a.p037m;

import java.io.Serializable;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p036l.C0552d;

/* renamed from: org.a.a.m.b */
public final class C0563b implements Serializable {

    /* renamed from: a */
    private char[] f633a;

    /* renamed from: b */
    private int f634b;

    public C0563b(int i) {
        C0250b.m78a(i, "Buffer capacity");
        this.f633a = new char[i];
    }

    /* renamed from: d */
    private void m1183d(int i) {
        char[] cArr = new char[Math.max(this.f633a.length << 1, i)];
        System.arraycopy(this.f633a, 0, cArr, 0, this.f634b);
        this.f633a = cArr;
    }

    /* renamed from: a */
    public final char mo5423a(int i) {
        return this.f633a[i];
    }

    /* renamed from: a */
    public final int mo5424a(int i, int i2, int i3) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 > this.f634b) {
            i3 = this.f634b;
        }
        if (i2 > i3) {
            return -1;
        }
        for (int i4 = i2; i4 < i3; i4++) {
            if (this.f633a[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public final String mo5425a(int i, int i2) {
        return new String(this.f633a, i, i2 - i);
    }

    /* renamed from: a */
    public final void mo5426a() {
        this.f634b = 0;
    }

    /* renamed from: a */
    public final void mo5427a(char c) {
        int i = this.f634b + 1;
        if (i > this.f633a.length) {
            m1183d(i);
        }
        this.f633a[this.f634b] = c;
        this.f634b = i;
    }

    /* renamed from: a */
    public final void mo5428a(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i = this.f634b + length;
        if (i > this.f633a.length) {
            m1183d(i);
        }
        str.getChars(0, length, this.f633a, this.f634b);
        this.f634b = i;
    }

    /* renamed from: a */
    public final void mo5429a(C0563b bVar, int i, int i2) {
        if (bVar != null) {
            mo5431a(bVar.f633a, i, i2);
        }
    }

    /* renamed from: a */
    public final void mo5430a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i < 0 || i > bArr.length || i2 < 0 || i + i2 < 0 || i + i2 > bArr.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + bArr.length);
            } else if (i2 != 0) {
                int i3 = this.f634b;
                int i4 = i3 + i2;
                if (i4 > this.f633a.length) {
                    m1183d(i4);
                }
                while (i3 < i4) {
                    this.f633a[i3] = (char) (bArr[i] & 255);
                    i++;
                    i3++;
                }
                this.f634b = i4;
            }
        }
    }

    /* renamed from: a */
    public final void mo5431a(char[] cArr, int i, int i2) {
        if (cArr != null) {
            if (i < 0 || i > cArr.length || i2 < 0 || i + i2 < 0 || i + i2 > cArr.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + cArr.length);
            } else if (i2 != 0) {
                int i3 = this.f634b + i2;
                if (i3 > this.f633a.length) {
                    m1183d(i3);
                }
                System.arraycopy(cArr, i, this.f633a, this.f634b, i2);
                this.f634b = i3;
            }
        }
    }

    /* renamed from: b */
    public final String mo5432b(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Negative beginIndex: " + i);
        } else if (i2 > this.f634b) {
            throw new IndexOutOfBoundsException("endIndex: " + i2 + " > length: " + this.f634b);
        } else if (i > i2) {
            throw new IndexOutOfBoundsException("beginIndex: " + i + " > endIndex: " + i2);
        } else {
            while (i < i2 && C0552d.m1151a(this.f633a[i])) {
                i++;
            }
            while (i2 > i && C0552d.m1151a(this.f633a[i2 - 1])) {
                i2--;
            }
            return new String(this.f633a, i, i2 - i);
        }
    }

    /* renamed from: b */
    public final void mo5433b(int i) {
        if (i > 0 && i > this.f633a.length - this.f634b) {
            m1183d(this.f634b + i);
        }
    }

    /* renamed from: b */
    public final char[] mo5434b() {
        return this.f633a;
    }

    /* renamed from: c */
    public final int mo5435c() {
        return this.f634b;
    }

    /* renamed from: c */
    public final int mo5436c(int i) {
        return mo5424a(i, 0, this.f634b);
    }

    /* renamed from: d */
    public final boolean mo5437d() {
        return this.f634b == 0;
    }

    public final String toString() {
        return new String(this.f633a, 0, this.f634b);
    }
}
