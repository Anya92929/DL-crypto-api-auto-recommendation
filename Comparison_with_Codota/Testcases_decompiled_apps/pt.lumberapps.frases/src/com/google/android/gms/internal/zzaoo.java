package com.google.android.gms.internal;

import android.support.p009v4.app.NotificationCompat;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class zzaoo implements Closeable, Flushable {

    /* renamed from: a */
    private static final String[] f5868a = new String[NotificationCompat.FLAG_HIGH_PRIORITY];

    /* renamed from: b */
    private static final String[] f5869b = ((String[]) f5868a.clone());

    /* renamed from: c */
    private final Writer f5870c;

    /* renamed from: d */
    private int[] f5871d = new int[32];

    /* renamed from: e */
    private int f5872e = 0;

    /* renamed from: f */
    private String f5873f;

    /* renamed from: g */
    private String f5874g;

    /* renamed from: h */
    private boolean f5875h;

    /* renamed from: i */
    private boolean f5876i;

    /* renamed from: j */
    private String f5877j;

    /* renamed from: k */
    private boolean f5878k;

    static {
        for (int i = 0; i <= 31; i++) {
            f5868a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f5868a[34] = "\\\"";
        f5868a[92] = "\\\\";
        f5868a[9] = "\\t";
        f5868a[8] = "\\b";
        f5868a[10] = "\\n";
        f5868a[13] = "\\r";
        f5868a[12] = "\\f";
        f5869b[60] = "\\u003c";
        f5869b[62] = "\\u003e";
        f5869b[38] = "\\u0026";
        f5869b[61] = "\\u003d";
        f5869b[39] = "\\u0027";
    }

    public zzaoo(Writer writer) {
        m6752a(6);
        this.f5874g = ":";
        this.f5878k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f5870c = writer;
    }

    /* renamed from: a */
    private int m6749a() {
        if (this.f5872e != 0) {
            return this.f5871d[this.f5872e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: a */
    private zzaoo m6750a(int i, int i2, String str) {
        int a = m6749a();
        if (a != i2 && a != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f5877j != null) {
            String valueOf = String.valueOf(this.f5877j);
            throw new IllegalStateException(valueOf.length() != 0 ? "Dangling name: ".concat(valueOf) : new String("Dangling name: "));
        } else {
            this.f5872e--;
            if (a == i2) {
                m6757c();
            }
            this.f5870c.write(str);
            return this;
        }
    }

    /* renamed from: a */
    private zzaoo m6751a(int i, String str) {
        m6754a(true);
        m6752a(i);
        this.f5870c.write(str);
        return this;
    }

    /* renamed from: a */
    private void m6752a(int i) {
        if (this.f5872e == this.f5871d.length) {
            int[] iArr = new int[(this.f5872e * 2)];
            System.arraycopy(this.f5871d, 0, iArr, 0, this.f5872e);
            this.f5871d = iArr;
        }
        int[] iArr2 = this.f5871d;
        int i2 = this.f5872e;
        this.f5872e = i2 + 1;
        iArr2[i2] = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6753a(java.lang.String r8) {
        /*
            r7 = this;
            r1 = 0
            boolean r0 = r7.f5876i
            if (r0 == 0) goto L_0x0025
            java.lang.String[] r0 = f5869b
        L_0x0007:
            java.io.Writer r2 = r7.f5870c
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
            java.lang.String[] r0 = f5868a
            goto L_0x0007
        L_0x0028:
            r5 = 8232(0x2028, float:1.1535E-41)
            if (r2 != r5) goto L_0x003f
            java.lang.String r2 = "\\u2028"
        L_0x002e:
            if (r1 >= r3) goto L_0x0037
            java.io.Writer r5 = r7.f5870c
            int r6 = r3 - r1
            r5.write(r8, r1, r6)
        L_0x0037:
            java.io.Writer r1 = r7.f5870c
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
            java.io.Writer r0 = r7.f5870c
            int r2 = r4 - r1
            r0.write(r8, r1, r2)
        L_0x004f:
            java.io.Writer r0 = r7.f5870c
            java.lang.String r1 = "\""
            r0.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaoo.m6753a(java.lang.String):void");
    }

    /* renamed from: a */
    private void m6754a(boolean z) {
        switch (m6749a()) {
            case 1:
                m6756b(2);
                m6757c();
                return;
            case 2:
                this.f5870c.append(',');
                m6757c();
                return;
            case 4:
                this.f5870c.append(this.f5874g);
                m6756b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.f5875h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.f5875h || z) {
            m6756b(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }

    /* renamed from: b */
    private void m6755b() {
        if (this.f5877j != null) {
            m6758d();
            m6753a(this.f5877j);
            this.f5877j = null;
        }
    }

    /* renamed from: b */
    private void m6756b(int i) {
        this.f5871d[this.f5872e - 1] = i;
    }

    /* renamed from: c */
    private void m6757c() {
        if (this.f5873f != null) {
            this.f5870c.write("\n");
            int i = this.f5872e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f5870c.write(this.f5873f);
            }
        }
    }

    /* renamed from: d */
    private void m6758d() {
        int a = m6749a();
        if (a == 5) {
            this.f5870c.write(44);
        } else if (a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m6757c();
        m6756b(4);
    }

    public void close() {
        this.f5870c.close();
        int i = this.f5872e;
        if (i > 1 || (i == 1 && this.f5871d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f5872e = 0;
    }

    public void flush() {
        if (this.f5872e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f5870c.flush();
    }

    /* renamed from: h */
    public zzaoo mo7922h() {
        m6755b();
        return m6751a(1, "[");
    }

    /* renamed from: i */
    public zzaoo mo7923i() {
        return m6750a(1, 2, "]");
    }

    public boolean isLenient() {
        return this.f5875h;
    }

    /* renamed from: j */
    public zzaoo mo7924j() {
        m6755b();
        return m6751a(3, "{");
    }

    /* renamed from: k */
    public zzaoo mo7925k() {
        return m6750a(3, 5, "}");
    }

    /* renamed from: l */
    public zzaoo mo7926l() {
        if (this.f5877j != null) {
            if (this.f5878k) {
                m6755b();
            } else {
                this.f5877j = null;
                return this;
            }
        }
        m6754a(false);
        this.f5870c.write("null");
        return this;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.f5873f = null;
            this.f5874g = ":";
            return;
        }
        this.f5873f = str;
        this.f5874g = ": ";
    }

    public final void setLenient(boolean z) {
        this.f5875h = z;
    }

    /* renamed from: x */
    public final boolean mo7948x() {
        return this.f5876i;
    }

    /* renamed from: y */
    public final boolean mo7949y() {
        return this.f5878k;
    }

    public zzaoo zza(Number number) {
        if (number == null) {
            return mo7926l();
        }
        m6755b();
        String obj = number.toString();
        if (this.f5875h || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            m6754a(false);
            this.f5870c.append(obj);
            return this;
        }
        String valueOf = String.valueOf(number);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 39).append("Numeric values must be finite, but was ").append(valueOf).toString());
    }

    public zzaoo zzcr(long j) {
        m6755b();
        m6754a(false);
        this.f5870c.write(Long.toString(j));
        return this;
    }

    public zzaoo zzda(boolean z) {
        m6755b();
        m6754a(false);
        this.f5870c.write(z ? "true" : "false");
        return this;
    }

    public final void zzdc(boolean z) {
        this.f5876i = z;
    }

    public final void zzdd(boolean z) {
        this.f5878k = z;
    }

    public zzaoo zztr(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f5877j != null) {
            throw new IllegalStateException();
        } else if (this.f5872e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.f5877j = str;
            return this;
        }
    }

    public zzaoo zzts(String str) {
        if (str == null) {
            return mo7926l();
        }
        m6755b();
        m6754a(false);
        m6753a(str);
        return this;
    }
}
