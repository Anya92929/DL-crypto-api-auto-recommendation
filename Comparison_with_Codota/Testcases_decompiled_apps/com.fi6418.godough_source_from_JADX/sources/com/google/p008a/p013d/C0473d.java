package com.google.p008a.p013d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* renamed from: com.google.a.d.d */
public class C0473d implements Closeable, Flushable {

    /* renamed from: a */
    private static final String[] f3607a = new String[128];

    /* renamed from: b */
    private static final String[] f3608b = ((String[]) f3607a.clone());

    /* renamed from: c */
    private final Writer f3609c;

    /* renamed from: d */
    private int[] f3610d = new int[32];

    /* renamed from: e */
    private int f3611e = 0;

    /* renamed from: f */
    private String f3612f;

    /* renamed from: g */
    private String f3613g;

    /* renamed from: h */
    private boolean f3614h;

    /* renamed from: i */
    private boolean f3615i;

    /* renamed from: j */
    private String f3616j;

    /* renamed from: k */
    private boolean f3617k;

    static {
        for (int i = 0; i <= 31; i++) {
            f3607a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f3607a[34] = "\\\"";
        f3607a[92] = "\\\\";
        f3607a[9] = "\\t";
        f3607a[8] = "\\b";
        f3607a[10] = "\\n";
        f3607a[13] = "\\r";
        f3607a[12] = "\\f";
        f3608b[60] = "\\u003c";
        f3608b[62] = "\\u003e";
        f3608b[38] = "\\u0026";
        f3608b[61] = "\\u003d";
        f3608b[39] = "\\u0027";
    }

    public C0473d(Writer writer) {
        m2849a(6);
        this.f3613g = ":";
        this.f3617k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f3609c = writer;
    }

    /* renamed from: a */
    private int mo6398a() {
        if (this.f3611e != 0) {
            return this.f3610d[this.f3611e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: a */
    private C0473d m2847a(int i, int i2, String str) {
        int a = mo6398a();
        if (a != i2 && a != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f3616j != null) {
            throw new IllegalStateException("Dangling name: " + this.f3616j);
        } else {
            this.f3611e--;
            if (a == i2) {
                m2854k();
            }
            this.f3609c.write(str);
            return this;
        }
    }

    /* renamed from: a */
    private C0473d m2848a(int i, String str) {
        m2852e(true);
        m2849a(i);
        this.f3609c.write(str);
        return this;
    }

    /* renamed from: a */
    private void m2849a(int i) {
        if (this.f3611e == this.f3610d.length) {
            int[] iArr = new int[(this.f3611e * 2)];
            System.arraycopy(this.f3610d, 0, iArr, 0, this.f3611e);
            this.f3610d = iArr;
        }
        int[] iArr2 = this.f3610d;
        int i2 = this.f3611e;
        this.f3611e = i2 + 1;
        iArr2[i2] = i;
    }

    /* renamed from: b */
    private void m2850b(int i) {
        this.f3610d[this.f3611e - 1] = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2851d(java.lang.String r8) {
        /*
            r7 = this;
            r1 = 0
            boolean r0 = r7.f3615i
            if (r0 == 0) goto L_0x0025
            java.lang.String[] r0 = f3608b
        L_0x0007:
            java.io.Writer r2 = r7.f3609c
            java.lang.String r3 = "\""
            r2.write(r3)
            int r4 = r8.length()
            r3 = r1
        L_0x0013:
            if (r3 >= r4) goto L_0x0046
            char r2 = r8.charAt(r3)
            r5 = 128(0x80, float:1.794E-43)
            if (r2 >= r5) goto L_0x0028
            r2 = r0[r2]
            if (r2 != 0) goto L_0x002e
        L_0x0021:
            int r2 = r3 + 1
            r3 = r2
            goto L_0x0013
        L_0x0025:
            java.lang.String[] r0 = f3607a
            goto L_0x0007
        L_0x0028:
            r5 = 8232(0x2028, float:1.1535E-41)
            if (r2 != r5) goto L_0x003f
            java.lang.String r2 = "\\u2028"
        L_0x002e:
            if (r1 >= r3) goto L_0x0037
            java.io.Writer r5 = r7.f3609c
            int r6 = r3 - r1
            r5.write(r8, r1, r6)
        L_0x0037:
            java.io.Writer r1 = r7.f3609c
            r1.write(r2)
            int r1 = r3 + 1
            goto L_0x0021
        L_0x003f:
            r5 = 8233(0x2029, float:1.1537E-41)
            if (r2 != r5) goto L_0x0021
            java.lang.String r2 = "\\u2029"
            goto L_0x002e
        L_0x0046:
            if (r1 >= r4) goto L_0x004f
            java.io.Writer r0 = r7.f3609c
            int r2 = r4 - r1
            r0.write(r8, r1, r2)
        L_0x004f:
            java.io.Writer r0 = r7.f3609c
            java.lang.String r1 = "\""
            r0.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p008a.p013d.C0473d.m2851d(java.lang.String):void");
    }

    /* renamed from: e */
    private void m2852e(boolean z) {
        switch (mo6398a()) {
            case 1:
                m2850b(2);
                m2854k();
                return;
            case 2:
                this.f3609c.append(',');
                m2854k();
                return;
            case 4:
                this.f3609c.append(this.f3613g);
                m2850b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.f3614h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.f3614h || z) {
            m2850b(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }

    /* renamed from: j */
    private void m2853j() {
        if (this.f3616j != null) {
            m2855l();
            m2851d(this.f3616j);
            this.f3616j = null;
        }
    }

    /* renamed from: k */
    private void m2854k() {
        if (this.f3612f != null) {
            this.f3609c.write("\n");
            int i = this.f3611e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f3609c.write(this.f3612f);
            }
        }
    }

    /* renamed from: l */
    private void m2855l() {
        int a = mo6398a();
        if (a == 5) {
            this.f3609c.write(44);
        } else if (a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m2854k();
        m2850b(4);
    }

    /* renamed from: a */
    public C0473d mo6394a(long j) {
        m2853j();
        m2852e(false);
        this.f3609c.write(Long.toString(j));
        return this;
    }

    /* renamed from: a */
    public C0473d mo6395a(Number number) {
        if (number == null) {
            return mo6405f();
        }
        m2853j();
        String obj = number.toString();
        if (this.f3614h || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            m2852e(false);
            this.f3609c.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    /* renamed from: a */
    public C0473d mo6396a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f3616j != null) {
            throw new IllegalStateException();
        } else if (this.f3611e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.f3616j = str;
            return this;
        }
    }

    /* renamed from: a */
    public C0473d mo6397a(boolean z) {
        m2853j();
        m2852e(false);
        this.f3609c.write(z ? "true" : "false");
        return this;
    }

    /* renamed from: b */
    public C0473d mo6399b() {
        m2853j();
        return m2848a(1, "[");
    }

    /* renamed from: b */
    public C0473d mo6400b(String str) {
        if (str == null) {
            return mo6405f();
        }
        m2853j();
        m2852e(false);
        m2851d(str);
        return this;
    }

    /* renamed from: b */
    public final void mo6502b(boolean z) {
        this.f3614h = z;
    }

    /* renamed from: c */
    public C0473d mo6401c() {
        return m2847a(1, 2, "]");
    }

    /* renamed from: c */
    public final void mo6503c(String str) {
        if (str.length() == 0) {
            this.f3612f = null;
            this.f3613g = ":";
            return;
        }
        this.f3612f = str;
        this.f3613g = ": ";
    }

    /* renamed from: c */
    public final void mo6504c(boolean z) {
        this.f3615i = z;
    }

    public void close() {
        this.f3609c.close();
        int i = this.f3611e;
        if (i > 1 || (i == 1 && this.f3610d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f3611e = 0;
    }

    /* renamed from: d */
    public C0473d mo6403d() {
        m2853j();
        return m2848a(3, "{");
    }

    /* renamed from: d */
    public final void mo6505d(boolean z) {
        this.f3617k = z;
    }

    /* renamed from: e */
    public C0473d mo6404e() {
        return m2847a(3, 5, "}");
    }

    /* renamed from: f */
    public C0473d mo6405f() {
        if (this.f3616j != null) {
            if (this.f3617k) {
                m2853j();
            } else {
                this.f3616j = null;
                return this;
            }
        }
        m2852e(false);
        this.f3609c.write("null");
        return this;
    }

    public void flush() {
        if (this.f3611e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f3609c.flush();
    }

    /* renamed from: g */
    public boolean mo6506g() {
        return this.f3614h;
    }

    /* renamed from: h */
    public final boolean mo6507h() {
        return this.f3615i;
    }

    /* renamed from: i */
    public final boolean mo6508i() {
        return this.f3617k;
    }
}
