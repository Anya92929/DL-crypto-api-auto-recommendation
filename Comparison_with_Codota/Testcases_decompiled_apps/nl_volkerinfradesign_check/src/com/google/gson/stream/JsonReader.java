package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.lang3.CharUtils;

public class JsonReader implements Closeable {

    /* renamed from: a */
    private static final char[] f3822a = ")]}'\n".toCharArray();

    /* renamed from: b */
    private final Reader f3823b;

    /* renamed from: c */
    private boolean f3824c = false;

    /* renamed from: d */
    private final char[] f3825d = new char[1024];

    /* renamed from: e */
    private int f3826e = 0;

    /* renamed from: f */
    private int f3827f = 0;

    /* renamed from: g */
    private int f3828g = 0;

    /* renamed from: h */
    private int f3829h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f3830i = 0;

    /* renamed from: j */
    private long f3831j;

    /* renamed from: k */
    private int f3832k;

    /* renamed from: l */
    private String f3833l;

    /* renamed from: m */
    private int[] f3834m = new int[32];

    /* renamed from: n */
    private int f3835n = 0;

    /* renamed from: o */
    private String[] f3836o;

    /* renamed from: p */
    private int[] f3837p;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int a = jsonReader.f3830i;
                if (a == 0) {
                    a = jsonReader.m4416a();
                }
                if (a == 13) {
                    int unused = jsonReader.f3830i = 9;
                } else if (a == 12) {
                    int unused2 = jsonReader.f3830i = 8;
                } else if (a == 14) {
                    int unused3 = jsonReader.f3830i = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + " " + " at line " + jsonReader.m4434f() + " column " + jsonReader.m4435g() + " path " + jsonReader.getPath());
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = this.f3834m;
        int i = this.f3835n;
        this.f3835n = i + 1;
        iArr[i] = 6;
        this.f3836o = new String[32];
        this.f3837p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f3823b = reader;
    }

    public final void setLenient(boolean z) {
        this.f3824c = z;
    }

    public final boolean isLenient() {
        return this.f3824c;
    }

    public void beginArray() throws IOException {
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        if (i == 3) {
            m4420a(1);
            this.f3837p[this.f3835n - 1] = 0;
            this.f3830i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
    }

    public void endArray() throws IOException {
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        if (i == 4) {
            this.f3835n--;
            this.f3830i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
    }

    public void beginObject() throws IOException {
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        if (i == 1) {
            m4420a(3);
            this.f3830i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
    }

    public void endObject() throws IOException {
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        if (i == 2) {
            this.f3835n--;
            this.f3836o[this.f3835n] = null;
            this.f3830i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
    }

    public boolean hasNext() throws IOException {
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken peek() throws IOException {
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m4416a() throws IOException {
        int i = this.f3834m[this.f3835n - 1];
        if (i == 1) {
            this.f3834m[this.f3835n - 1] = 2;
        } else if (i == 2) {
            switch (m4419a(true)) {
                case 44:
                    break;
                case 59:
                    m4436h();
                    break;
                case 93:
                    this.f3830i = 4;
                    return 4;
                default:
                    throw m4425b("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.f3834m[this.f3835n - 1] = 4;
            if (i == 5) {
                switch (m4419a(true)) {
                    case 44:
                        break;
                    case 59:
                        m4436h();
                        break;
                    case 125:
                        this.f3830i = 2;
                        return 2;
                    default:
                        throw m4425b("Unterminated object");
                }
            }
            int a = m4419a(true);
            switch (a) {
                case 34:
                    this.f3830i = 13;
                    return 13;
                case 39:
                    m4436h();
                    this.f3830i = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.f3830i = 2;
                        return 2;
                    }
                    throw m4425b("Expected name");
                default:
                    m4436h();
                    this.f3826e--;
                    if (m4421a((char) a)) {
                        this.f3830i = 14;
                        return 14;
                    }
                    throw m4425b("Expected name");
            }
        } else if (i == 4) {
            this.f3834m[this.f3835n - 1] = 5;
            switch (m4419a(true)) {
                case 58:
                    break;
                case 61:
                    m4436h();
                    if ((this.f3826e < this.f3827f || m4427b(1)) && this.f3825d[this.f3826e] == '>') {
                        this.f3826e++;
                        break;
                    }
                default:
                    throw m4425b("Expected ':'");
            }
        } else if (i == 6) {
            if (this.f3824c) {
                m4439k();
            }
            this.f3834m[this.f3835n - 1] = 7;
        } else if (i == 7) {
            if (m4419a(false) == -1) {
                this.f3830i = 17;
                return 17;
            }
            m4436h();
            this.f3826e--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (m4419a(true)) {
            case 34:
                if (this.f3835n == 1) {
                    m4436h();
                }
                this.f3830i = 9;
                return 9;
            case 39:
                m4436h();
                this.f3830i = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.f3830i = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.f3830i = 4;
                    return 4;
                }
                break;
            case 123:
                this.f3830i = 1;
                return 1;
            default:
                this.f3826e--;
                if (this.f3835n == 1) {
                    m4436h();
                }
                int b = m4423b();
                if (b != 0) {
                    return b;
                }
                int c = m4428c();
                if (c != 0) {
                    return c;
                }
                if (!m4421a(this.f3825d[this.f3826e])) {
                    throw m4425b("Expected value");
                }
                m4436h();
                this.f3830i = 10;
                return 10;
        }
        if (i == 1 || i == 2) {
            m4436h();
            this.f3826e--;
            this.f3830i = 7;
            return 7;
        }
        throw m4425b("Unexpected value");
    }

    /* renamed from: b */
    private int m4423b() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.f3825d[this.f3826e];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.f3826e + i2 >= this.f3827f && !m4427b(i2 + 1)) {
                return 0;
            }
            char c2 = this.f3825d[this.f3826e + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f3826e + length < this.f3827f || m4427b(length + 1)) && m4421a(this.f3825d[this.f3826e + length])) {
            return 0;
        }
        this.f3826e += length;
        this.f3830i = i;
        return i;
    }

    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m4428c() throws java.io.IOException {
        /*
            r15 = this;
            char[] r11 = r15.f3825d
            int r2 = r15.f3826e
            int r1 = r15.f3827f
            r6 = 0
            r5 = 0
            r4 = 1
            r3 = 0
            r0 = 0
            r10 = r0
            r0 = r1
            r1 = r2
        L_0x000f:
            int r2 = r1 + r10
            if (r2 != r0) goto L_0x003f
            int r0 = r11.length
            if (r10 != r0) goto L_0x0018
            r0 = 0
        L_0x0017:
            return r0
        L_0x0018:
            int r0 = r10 + 1
            boolean r0 = r15.m4427b((int) r0)
            if (r0 != 0) goto L_0x003b
        L_0x0020:
            r0 = 2
            if (r3 != r0) goto L_0x00df
            if (r4 == 0) goto L_0x00df
            r0 = -9223372036854775808
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x002d
            if (r5 == 0) goto L_0x00df
        L_0x002d:
            if (r5 == 0) goto L_0x00dc
        L_0x002f:
            r15.f3831j = r6
            int r0 = r15.f3826e
            int r0 = r0 + r10
            r15.f3826e = r0
            r0 = 15
            r15.f3830i = r0
            goto L_0x0017
        L_0x003b:
            int r1 = r15.f3826e
            int r0 = r15.f3827f
        L_0x003f:
            int r2 = r1 + r10
            char r2 = r11[r2]
            switch(r2) {
                case 43: goto L_0x006d;
                case 45: goto L_0x0056;
                case 46: goto L_0x0082;
                case 69: goto L_0x0076;
                case 101: goto L_0x0076;
                default: goto L_0x0046;
            }
        L_0x0046:
            r8 = 48
            if (r2 < r8) goto L_0x004e
            r8 = 57
            if (r2 <= r8) goto L_0x008b
        L_0x004e:
            boolean r0 = r15.m4421a((char) r2)
            if (r0 == 0) goto L_0x0020
            r0 = 0
            goto L_0x0017
        L_0x0056:
            if (r3 != 0) goto L_0x0064
            r3 = 1
            r2 = 1
            r14 = r4
            r4 = r3
            r3 = r14
        L_0x005d:
            int r5 = r10 + 1
            r10 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            goto L_0x000f
        L_0x0064:
            r2 = 5
            if (r3 != r2) goto L_0x006b
            r2 = 6
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x006b:
            r0 = 0
            goto L_0x0017
        L_0x006d:
            r2 = 5
            if (r3 != r2) goto L_0x0074
            r2 = 6
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0074:
            r0 = 0
            goto L_0x0017
        L_0x0076:
            r2 = 2
            if (r3 == r2) goto L_0x007c
            r2 = 4
            if (r3 != r2) goto L_0x0080
        L_0x007c:
            r2 = 5
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0080:
            r0 = 0
            goto L_0x0017
        L_0x0082:
            r2 = 2
            if (r3 != r2) goto L_0x0089
            r2 = 3
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0089:
            r0 = 0
            goto L_0x0017
        L_0x008b:
            r8 = 1
            if (r3 == r8) goto L_0x0090
            if (r3 != 0) goto L_0x0098
        L_0x0090:
            int r2 = r2 + -48
            int r2 = -r2
            long r6 = (long) r2
            r2 = 2
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0098:
            r8 = 2
            if (r3 != r8) goto L_0x00cb
            r8 = 0
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x00a4
            r0 = 0
            goto L_0x0017
        L_0x00a4:
            r8 = 10
            long r8 = r8 * r6
            int r2 = r2 + -48
            long r12 = (long) r2
            long r8 = r8 - r12
            r12 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x00c1
            r12 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x00c9
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x00c9
        L_0x00c1:
            r2 = 1
        L_0x00c2:
            r2 = r2 & r4
            r4 = r5
            r6 = r8
            r14 = r3
            r3 = r2
            r2 = r14
            goto L_0x005d
        L_0x00c9:
            r2 = 0
            goto L_0x00c2
        L_0x00cb:
            r2 = 3
            if (r3 != r2) goto L_0x00d2
            r2 = 4
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x00d2:
            r2 = 5
            if (r3 == r2) goto L_0x00d8
            r2 = 6
            if (r3 != r2) goto L_0x00f3
        L_0x00d8:
            r2 = 7
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x00dc:
            long r6 = -r6
            goto L_0x002f
        L_0x00df:
            r0 = 2
            if (r3 == r0) goto L_0x00e8
            r0 = 4
            if (r3 == r0) goto L_0x00e8
            r0 = 7
            if (r3 != r0) goto L_0x00f0
        L_0x00e8:
            r15.f3832k = r10
            r0 = 16
            r15.f3830i = r0
            goto L_0x0017
        L_0x00f0:
            r0 = 0
            goto L_0x0017
        L_0x00f3:
            r2 = r3
            r3 = r4
            r4 = r5
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.m4428c():int");
    }

    /* renamed from: a */
    private boolean m4421a(char c) throws IOException {
        switch (c) {
            case 9:
            case 10:
            case 12:
            case 13:
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                m4436h();
                break;
            default:
                return true;
        }
        return false;
    }

    public String nextName() throws IOException {
        String b;
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        if (i == 14) {
            b = m4432d();
        } else if (i == 12) {
            b = m4426b('\'');
        } else if (i == 13) {
            b = m4426b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + peek() + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
        }
        this.f3830i = 0;
        this.f3836o[this.f3835n - 1] = b;
        return b;
    }

    public String nextString() throws IOException {
        String str;
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        if (i == 10) {
            str = m4432d();
        } else if (i == 8) {
            str = m4426b('\'');
        } else if (i == 9) {
            str = m4426b('\"');
        } else if (i == 11) {
            str = this.f3833l;
            this.f3833l = null;
        } else if (i == 15) {
            str = Long.toString(this.f3831j);
        } else if (i == 16) {
            str = new String(this.f3825d, this.f3826e, this.f3832k);
            this.f3826e += this.f3832k;
        } else {
            throw new IllegalStateException("Expected a string but was " + peek() + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
        }
        this.f3830i = 0;
        int[] iArr = this.f3837p;
        int i2 = this.f3835n - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        if (i == 5) {
            this.f3830i = 0;
            int[] iArr = this.f3837p;
            int i2 = this.f3835n - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f3830i = 0;
            int[] iArr2 = this.f3837p;
            int i3 = this.f3835n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + peek() + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
        }
    }

    public void nextNull() throws IOException {
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        if (i == 7) {
            this.f3830i = 0;
            int[] iArr = this.f3837p;
            int i2 = this.f3835n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
    }

    public double nextDouble() throws IOException {
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        if (i == 15) {
            this.f3830i = 0;
            int[] iArr = this.f3837p;
            int i2 = this.f3835n - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f3831j;
        }
        if (i == 16) {
            this.f3833l = new String(this.f3825d, this.f3826e, this.f3832k);
            this.f3826e += this.f3832k;
        } else if (i == 8 || i == 9) {
            this.f3833l = m4426b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f3833l = m4432d();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
        }
        this.f3830i = 11;
        double parseDouble = Double.parseDouble(this.f3833l);
        if (this.f3824c || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.f3833l = null;
            this.f3830i = 0;
            int[] iArr2 = this.f3837p;
            int i3 = this.f3835n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
    }

    public long nextLong() throws IOException {
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        if (i == 15) {
            this.f3830i = 0;
            int[] iArr = this.f3837p;
            int i2 = this.f3835n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f3831j;
        }
        if (i == 16) {
            this.f3833l = new String(this.f3825d, this.f3826e, this.f3832k);
            this.f3826e += this.f3832k;
        } else if (i == 8 || i == 9) {
            this.f3833l = m4426b(i == 8 ? '\'' : '\"');
            try {
                long parseLong = Long.parseLong(this.f3833l);
                this.f3830i = 0;
                int[] iArr2 = this.f3837p;
                int i3 = this.f3835n - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + peek() + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
        }
        this.f3830i = 11;
        double parseDouble = Double.parseDouble(this.f3833l);
        long j = (long) parseDouble;
        if (((double) j) != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f3833l + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
        }
        this.f3833l = null;
        this.f3830i = 0;
        int[] iArr3 = this.f3837p;
        int i4 = this.f3835n - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    /* renamed from: b */
    private String m4426b(char c) throws IOException {
        char[] cArr = this.f3825d;
        StringBuilder sb = new StringBuilder();
        do {
            int i = this.f3826e;
            int i2 = this.f3827f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f3826e = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.f3826e = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    sb.append(m4438j());
                    i = this.f3826e;
                    i2 = this.f3827f;
                    i4 = i;
                } else if (c2 == 10) {
                    this.f3828g++;
                    this.f3829h = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.f3826e = i3;
        } while (m4427b(1));
        throw m4425b("Unterminated string");
    }

    /* renamed from: d */
    private String m4432d() throws IOException {
        String sb;
        StringBuilder sb2 = null;
        int i = 0;
        while (true) {
            if (this.f3826e + i < this.f3827f) {
                switch (this.f3825d[this.f3826e + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m4436h();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.f3825d.length) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.f3825d, this.f3826e, i);
                this.f3826e = i + this.f3826e;
                if (!m4427b(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (m4427b(i + 1)) {
            }
        }
        if (sb2 == null) {
            sb = new String(this.f3825d, this.f3826e, i);
        } else {
            sb2.append(this.f3825d, this.f3826e, i);
            sb = sb2.toString();
        }
        this.f3826e = i + this.f3826e;
        return sb;
    }

    /* renamed from: c */
    private void m4430c(char c) throws IOException {
        char[] cArr = this.f3825d;
        do {
            int i = this.f3826e;
            int i2 = this.f3827f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f3826e = i4;
                    return;
                }
                if (c2 == '\\') {
                    this.f3826e = i4;
                    m4438j();
                    i4 = this.f3826e;
                    i2 = this.f3827f;
                } else if (c2 == 10) {
                    this.f3828g++;
                    this.f3829h = i4;
                }
                i3 = i4;
            }
            this.f3826e = i3;
        } while (m4427b(1));
        throw m4425b("Unterminated string");
    }

    /* renamed from: e */
    private void m4433e() throws IOException {
        do {
            int i = 0;
            while (this.f3826e + i < this.f3827f) {
                switch (this.f3825d[this.f3826e + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m4436h();
                        break;
                    default:
                        i++;
                }
                this.f3826e = i + this.f3826e;
                return;
            }
            this.f3826e = i + this.f3826e;
        } while (m4427b(1));
    }

    public int nextInt() throws IOException {
        int i = this.f3830i;
        if (i == 0) {
            i = m4416a();
        }
        if (i == 15) {
            int i2 = (int) this.f3831j;
            if (this.f3831j != ((long) i2)) {
                throw new NumberFormatException("Expected an int but was " + this.f3831j + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
            }
            this.f3830i = 0;
            int[] iArr = this.f3837p;
            int i3 = this.f3835n - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.f3833l = new String(this.f3825d, this.f3826e, this.f3832k);
            this.f3826e += this.f3832k;
        } else if (i == 8 || i == 9) {
            this.f3833l = m4426b(i == 8 ? '\'' : '\"');
            try {
                int parseInt = Integer.parseInt(this.f3833l);
                this.f3830i = 0;
                int[] iArr2 = this.f3837p;
                int i4 = this.f3835n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + peek() + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
        }
        this.f3830i = 11;
        double parseDouble = Double.parseDouble(this.f3833l);
        int i5 = (int) parseDouble;
        if (((double) i5) != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.f3833l + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
        }
        this.f3833l = null;
        this.f3830i = 0;
        int[] iArr3 = this.f3837p;
        int i6 = this.f3835n - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public void close() throws IOException {
        this.f3830i = 0;
        this.f3834m[0] = 8;
        this.f3835n = 1;
        this.f3823b.close();
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.f3830i;
            if (i2 == 0) {
                i2 = m4416a();
            }
            if (i2 == 3) {
                m4420a(1);
                i++;
            } else if (i2 == 1) {
                m4420a(3);
                i++;
            } else if (i2 == 4) {
                this.f3835n--;
                i--;
            } else if (i2 == 2) {
                this.f3835n--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                m4433e();
            } else if (i2 == 8 || i2 == 12) {
                m4430c('\'');
            } else if (i2 == 9 || i2 == 13) {
                m4430c('\"');
            } else if (i2 == 16) {
                this.f3826e += this.f3832k;
            }
            this.f3830i = 0;
        } while (i != 0);
        int[] iArr = this.f3837p;
        int i3 = this.f3835n - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f3836o[this.f3835n - 1] = "null";
    }

    /* renamed from: a */
    private void m4420a(int i) {
        if (this.f3835n == this.f3834m.length) {
            int[] iArr = new int[(this.f3835n * 2)];
            int[] iArr2 = new int[(this.f3835n * 2)];
            String[] strArr = new String[(this.f3835n * 2)];
            System.arraycopy(this.f3834m, 0, iArr, 0, this.f3835n);
            System.arraycopy(this.f3837p, 0, iArr2, 0, this.f3835n);
            System.arraycopy(this.f3836o, 0, strArr, 0, this.f3835n);
            this.f3834m = iArr;
            this.f3837p = iArr2;
            this.f3836o = strArr;
        }
        int[] iArr3 = this.f3834m;
        int i2 = this.f3835n;
        this.f3835n = i2 + 1;
        iArr3[i2] = i;
    }

    /* renamed from: b */
    private boolean m4427b(int i) throws IOException {
        char[] cArr = this.f3825d;
        this.f3829h -= this.f3826e;
        if (this.f3827f != this.f3826e) {
            this.f3827f -= this.f3826e;
            System.arraycopy(cArr, this.f3826e, cArr, 0, this.f3827f);
        } else {
            this.f3827f = 0;
        }
        this.f3826e = 0;
        do {
            int read = this.f3823b.read(cArr, this.f3827f, cArr.length - this.f3827f);
            if (read == -1) {
                return false;
            }
            this.f3827f = read + this.f3827f;
            if (this.f3828g == 0 && this.f3829h == 0 && this.f3827f > 0 && cArr[0] == 65279) {
                this.f3826e++;
                this.f3829h++;
                i++;
            }
        } while (this.f3827f < i);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public int m4434f() {
        return this.f3828g + 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public int m4435g() {
        return (this.f3826e - this.f3829h) + 1;
    }

    /* renamed from: a */
    private int m4419a(boolean z) throws IOException {
        char[] cArr = this.f3825d;
        int i = this.f3826e;
        int i2 = this.f3827f;
        while (true) {
            if (i == i2) {
                this.f3826e = i;
                if (m4427b(1)) {
                    i = this.f3826e;
                    i2 = this.f3827f;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input at line " + m4434f() + " column " + m4435g());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 10) {
                this.f3828g++;
                this.f3829h = i3;
                i = i3;
            } else if (c == ' ' || c == 13) {
                i = i3;
            } else if (c == 9) {
                i = i3;
            } else if (c == '/') {
                this.f3826e = i3;
                if (i3 == i2) {
                    this.f3826e--;
                    boolean b = m4427b(2);
                    this.f3826e++;
                    if (!b) {
                        return c;
                    }
                }
                m4436h();
                switch (cArr[this.f3826e]) {
                    case '*':
                        this.f3826e++;
                        if (m4422a("*/")) {
                            i = this.f3826e + 2;
                            i2 = this.f3827f;
                            break;
                        } else {
                            throw m4425b("Unterminated comment");
                        }
                    case '/':
                        this.f3826e++;
                        m4437i();
                        i = this.f3826e;
                        i2 = this.f3827f;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.f3826e = i3;
                m4436h();
                m4437i();
                i = this.f3826e;
                i2 = this.f3827f;
            } else {
                this.f3826e = i3;
                return c;
            }
        }
    }

    /* renamed from: h */
    private void m4436h() throws IOException {
        if (!this.f3824c) {
            throw m4425b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: i */
    private void m4437i() throws IOException {
        char c;
        do {
            if (this.f3826e < this.f3827f || m4427b(1)) {
                char[] cArr = this.f3825d;
                int i = this.f3826e;
                this.f3826e = i + 1;
                c = cArr[i];
                if (c == 10) {
                    this.f3828g++;
                    this.f3829h = this.f3826e;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    /* renamed from: a */
    private boolean m4422a(String str) throws IOException {
        while (true) {
            if (this.f3826e + str.length() > this.f3827f && !m4427b(str.length())) {
                return false;
            }
            if (this.f3825d[this.f3826e] == 10) {
                this.f3828g++;
                this.f3829h = this.f3826e + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.f3825d[this.f3826e + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.f3826e++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + m4434f() + " column " + m4435g();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.f3835n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f3834m[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.f3837p[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.f3836o[i2] == null) {
                        break;
                    } else {
                        append.append(this.f3836o[i2]);
                        break;
                    }
            }
        }
        return append.toString();
    }

    /* renamed from: j */
    private char m4438j() throws IOException {
        int i;
        if (this.f3826e != this.f3827f || m4427b(1)) {
            char[] cArr = this.f3825d;
            int i2 = this.f3826e;
            this.f3826e = i2 + 1;
            char c = cArr[i2];
            switch (c) {
                case 10:
                    this.f3828g++;
                    this.f3829h = this.f3826e;
                    return c;
                case 'b':
                    return 8;
                case 'f':
                    return 12;
                case 'n':
                    return 10;
                case 'r':
                    return CharUtils.f7018CR;
                case 't':
                    return 9;
                case 'u':
                    if (this.f3826e + 4 <= this.f3827f || m4427b(4)) {
                        int i3 = this.f3826e;
                        int i4 = i3 + 4;
                        int i5 = i3;
                        char c2 = 0;
                        for (int i6 = i5; i6 < i4; i6++) {
                            char c3 = this.f3825d[i6];
                            char c4 = (char) (c2 << 4);
                            if (c3 >= '0' && c3 <= '9') {
                                i = c3 - '0';
                            } else if (c3 >= 'a' && c3 <= 'f') {
                                i = (c3 - 'a') + 10;
                            } else if (c3 < 'A' || c3 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.f3825d, this.f3826e, 4));
                            } else {
                                i = (c3 - 'A') + 10;
                            }
                            c2 = (char) (c4 + i);
                        }
                        this.f3826e += 4;
                        return c2;
                    }
                    throw m4425b("Unterminated escape sequence");
                default:
                    return c;
            }
        } else {
            throw m4425b("Unterminated escape sequence");
        }
    }

    /* renamed from: b */
    private IOException m4425b(String str) throws IOException {
        throw new MalformedJsonException(str + " at line " + m4434f() + " column " + m4435g() + " path " + getPath());
    }

    /* renamed from: k */
    private void m4439k() throws IOException {
        m4419a(true);
        this.f3826e--;
        if (this.f3826e + f3822a.length <= this.f3827f || m4427b(f3822a.length)) {
            int i = 0;
            while (i < f3822a.length) {
                if (this.f3825d[this.f3826e + i] == f3822a[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.f3826e += f3822a.length;
        }
    }
}
