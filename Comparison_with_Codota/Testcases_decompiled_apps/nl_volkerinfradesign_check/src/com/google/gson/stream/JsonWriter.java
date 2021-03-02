package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import org.apache.commons.p009io.IOUtils;

public class JsonWriter implements Closeable, Flushable {

    /* renamed from: a */
    private static final String[] f3839a = new String[128];

    /* renamed from: b */
    private static final String[] f3840b = ((String[]) f3839a.clone());

    /* renamed from: c */
    private final Writer f3841c;

    /* renamed from: d */
    private int[] f3842d = new int[32];

    /* renamed from: e */
    private int f3843e = 0;

    /* renamed from: f */
    private String f3844f;

    /* renamed from: g */
    private String f3845g;

    /* renamed from: h */
    private boolean f3846h;

    /* renamed from: i */
    private boolean f3847i;

    /* renamed from: j */
    private String f3848j;

    /* renamed from: k */
    private boolean f3849k;

    static {
        for (int i = 0; i <= 31; i++) {
            f3839a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f3839a[34] = "\\\"";
        f3839a[92] = "\\\\";
        f3839a[9] = "\\t";
        f3839a[8] = "\\b";
        f3839a[10] = "\\n";
        f3839a[13] = "\\r";
        f3839a[12] = "\\f";
        f3840b[60] = "\\u003c";
        f3840b[62] = "\\u003e";
        f3840b[38] = "\\u0026";
        f3840b[61] = "\\u003d";
        f3840b[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        m4443a(6);
        this.f3845g = ":";
        this.f3849k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f3841c = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.f3844f = null;
            this.f3845g = ":";
            return;
        }
        this.f3844f = str;
        this.f3845g = ": ";
    }

    public final void setLenient(boolean z) {
        this.f3846h = z;
    }

    public boolean isLenient() {
        return this.f3846h;
    }

    public final void setHtmlSafe(boolean z) {
        this.f3847i = z;
    }

    public final boolean isHtmlSafe() {
        return this.f3847i;
    }

    public final void setSerializeNulls(boolean z) {
        this.f3849k = z;
    }

    public final boolean getSerializeNulls() {
        return this.f3849k;
    }

    public JsonWriter beginArray() throws IOException {
        m4446b();
        return m4442a(1, "[");
    }

    public JsonWriter endArray() throws IOException {
        return m4441a(1, 2, "]");
    }

    public JsonWriter beginObject() throws IOException {
        m4446b();
        return m4442a(3, "{");
    }

    public JsonWriter endObject() throws IOException {
        return m4441a(3, 5, "}");
    }

    /* renamed from: a */
    private JsonWriter m4442a(int i, String str) throws IOException {
        m4445a(true);
        m4443a(i);
        this.f3841c.write(str);
        return this;
    }

    /* renamed from: a */
    private JsonWriter m4441a(int i, int i2, String str) throws IOException {
        int a = m4440a();
        if (a != i2 && a != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f3848j != null) {
            throw new IllegalStateException("Dangling name: " + this.f3848j);
        } else {
            this.f3843e--;
            if (a == i2) {
                m4448c();
            }
            this.f3841c.write(str);
            return this;
        }
    }

    /* renamed from: a */
    private void m4443a(int i) {
        if (this.f3843e == this.f3842d.length) {
            int[] iArr = new int[(this.f3843e * 2)];
            System.arraycopy(this.f3842d, 0, iArr, 0, this.f3843e);
            this.f3842d = iArr;
        }
        int[] iArr2 = this.f3842d;
        int i2 = this.f3843e;
        this.f3843e = i2 + 1;
        iArr2[i2] = i;
    }

    /* renamed from: a */
    private int m4440a() {
        if (this.f3843e != 0) {
            return this.f3842d[this.f3843e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: b */
    private void m4447b(int i) {
        this.f3842d[this.f3843e - 1] = i;
    }

    public JsonWriter name(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f3848j != null) {
            throw new IllegalStateException();
        } else if (this.f3843e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.f3848j = str;
            return this;
        }
    }

    /* renamed from: b */
    private void m4446b() throws IOException {
        if (this.f3848j != null) {
            m4449d();
            m4444a(this.f3848j);
            this.f3848j = null;
        }
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        m4446b();
        m4445a(false);
        m4444a(str);
        return this;
    }

    public JsonWriter nullValue() throws IOException {
        if (this.f3848j != null) {
            if (this.f3849k) {
                m4446b();
            } else {
                this.f3848j = null;
                return this;
            }
        }
        m4445a(false);
        this.f3841c.write("null");
        return this;
    }

    public JsonWriter value(boolean z) throws IOException {
        m4446b();
        m4445a(false);
        this.f3841c.write(z ? "true" : "false");
        return this;
    }

    public JsonWriter value(double d) throws IOException {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        m4446b();
        m4445a(false);
        this.f3841c.append(Double.toString(d));
        return this;
    }

    public JsonWriter value(long j) throws IOException {
        m4446b();
        m4445a(false);
        this.f3841c.write(Long.toString(j));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        m4446b();
        String obj = number.toString();
        if (this.f3846h || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            m4445a(false);
            this.f3841c.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public void flush() throws IOException {
        if (this.f3843e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f3841c.flush();
    }

    public void close() throws IOException {
        this.f3841c.close();
        int i = this.f3843e;
        if (i > 1 || (i == 1 && this.f3842d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f3843e = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4444a(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            r1 = 0
            boolean r0 = r7.f3847i
            if (r0 == 0) goto L_0x0025
            java.lang.String[] r0 = f3840b
        L_0x0007:
            java.io.Writer r2 = r7.f3841c
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
            java.lang.String[] r0 = f3839a
            goto L_0x0007
        L_0x0028:
            r5 = 8232(0x2028, float:1.1535E-41)
            if (r2 != r5) goto L_0x003f
            java.lang.String r2 = "\\u2028"
        L_0x002e:
            if (r1 >= r3) goto L_0x0037
            java.io.Writer r5 = r7.f3841c
            int r6 = r3 - r1
            r5.write(r8, r1, r6)
        L_0x0037:
            java.io.Writer r1 = r7.f3841c
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
            java.io.Writer r0 = r7.f3841c
            int r2 = r4 - r1
            r0.write(r8, r1, r2)
        L_0x004f:
            java.io.Writer r0 = r7.f3841c
            java.lang.String r1 = "\""
            r0.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonWriter.m4444a(java.lang.String):void");
    }

    /* renamed from: c */
    private void m4448c() throws IOException {
        if (this.f3844f != null) {
            this.f3841c.write(IOUtils.LINE_SEPARATOR_UNIX);
            int i = this.f3843e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f3841c.write(this.f3844f);
            }
        }
    }

    /* renamed from: d */
    private void m4449d() throws IOException {
        int a = m4440a();
        if (a == 5) {
            this.f3841c.write(44);
        } else if (a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m4448c();
        m4447b(4);
    }

    /* renamed from: a */
    private void m4445a(boolean z) throws IOException {
        switch (m4440a()) {
            case 1:
                m4447b(2);
                m4448c();
                return;
            case 2:
                this.f3841c.append(',');
                m4448c();
                return;
            case 4:
                this.f3841c.append(this.f3845g);
                m4447b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.f3846h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.f3846h || z) {
            m4447b(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }
}
