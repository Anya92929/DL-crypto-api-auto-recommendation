package com.google.p008a.p013d;

import com.google.p008a.p010b.C0461u;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* renamed from: com.google.a.d.a */
public class C0470a implements Closeable {

    /* renamed from: a */
    private static final char[] f3580a = ")]}'\n".toCharArray();

    /* renamed from: b */
    private final Reader f3581b;

    /* renamed from: c */
    private boolean f3582c = false;

    /* renamed from: d */
    private final char[] f3583d = new char[1024];

    /* renamed from: e */
    private int f3584e = 0;

    /* renamed from: f */
    private int f3585f = 0;

    /* renamed from: g */
    private int f3586g = 0;

    /* renamed from: h */
    private int f3587h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f3588i = 0;

    /* renamed from: j */
    private long f3589j;

    /* renamed from: k */
    private int f3590k;

    /* renamed from: l */
    private String f3591l;

    /* renamed from: m */
    private int[] f3592m = new int[32];

    /* renamed from: n */
    private int f3593n = 0;

    /* renamed from: o */
    private String[] f3594o;

    /* renamed from: p */
    private int[] f3595p;

    static {
        C0461u.f3557a = new C0471b();
    }

    public C0470a(Reader reader) {
        int[] iArr = this.f3592m;
        int i = this.f3593n;
        this.f3593n = i + 1;
        iArr[i] = 6;
        this.f3594o = new String[32];
        this.f3595p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f3581b = reader;
    }

    /* renamed from: A */
    private void m2804A() {
        m2811b(true);
        this.f3584e--;
        if (this.f3584e + f3580a.length <= this.f3585f || m2814b(f3580a.length)) {
            int i = 0;
            while (i < f3580a.length) {
                if (this.f3583d[this.f3584e + i] == f3580a[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.f3584e += f3580a.length;
        }
    }

    /* renamed from: a */
    private void m2807a(int i) {
        if (this.f3593n == this.f3592m.length) {
            int[] iArr = new int[(this.f3593n * 2)];
            int[] iArr2 = new int[(this.f3593n * 2)];
            String[] strArr = new String[(this.f3593n * 2)];
            System.arraycopy(this.f3592m, 0, iArr, 0, this.f3593n);
            System.arraycopy(this.f3595p, 0, iArr2, 0, this.f3593n);
            System.arraycopy(this.f3594o, 0, strArr, 0, this.f3593n);
            this.f3592m = iArr;
            this.f3595p = iArr2;
            this.f3594o = strArr;
        }
        int[] iArr3 = this.f3592m;
        int i2 = this.f3593n;
        this.f3593n = i2 + 1;
        iArr3[i2] = i;
    }

    /* renamed from: a */
    private boolean m2808a(char c) {
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
                m2825x();
                break;
            default:
                return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m2809a(String str) {
        while (true) {
            if (this.f3584e + str.length() > this.f3585f && !m2814b(str.length())) {
                return false;
            }
            if (this.f3583d[this.f3584e] == 10) {
                this.f3586g++;
                this.f3587h = this.f3584e + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.f3583d[this.f3584e + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.f3584e++;
        }
    }

    /* renamed from: b */
    private int m2811b(boolean z) {
        char[] cArr = this.f3583d;
        int i = this.f3584e;
        int i2 = this.f3585f;
        while (true) {
            if (i == i2) {
                this.f3584e = i;
                if (m2814b(1)) {
                    i = this.f3584e;
                    i2 = this.f3585f;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input at line " + m2823v() + " column " + m2824w());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 10) {
                this.f3586g++;
                this.f3587h = i3;
                i = i3;
            } else if (c == ' ' || c == 13) {
                i = i3;
            } else if (c == 9) {
                i = i3;
            } else if (c == '/') {
                this.f3584e = i3;
                if (i3 == i2) {
                    this.f3584e--;
                    boolean b = m2814b(2);
                    this.f3584e++;
                    if (!b) {
                        return c;
                    }
                }
                m2825x();
                switch (cArr[this.f3584e]) {
                    case '*':
                        this.f3584e++;
                        if (m2809a("*/")) {
                            i = this.f3584e + 2;
                            i2 = this.f3585f;
                            break;
                        } else {
                            throw m2812b("Unterminated comment");
                        }
                    case '/':
                        this.f3584e++;
                        m2826y();
                        i = this.f3584e;
                        i2 = this.f3585f;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.f3584e = i3;
                m2825x();
                m2826y();
                i = this.f3584e;
                i2 = this.f3585f;
            } else {
                this.f3584e = i3;
                return c;
            }
        }
    }

    /* renamed from: b */
    private IOException m2812b(String str) {
        throw new C0474e(str + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
    }

    /* renamed from: b */
    private String m2813b(char c) {
        char[] cArr = this.f3583d;
        StringBuilder sb = new StringBuilder();
        do {
            int i = this.f3584e;
            int i2 = this.f3585f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f3584e = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.f3584e = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    sb.append(m2827z());
                    i = this.f3584e;
                    i2 = this.f3585f;
                    i4 = i;
                } else if (c2 == 10) {
                    this.f3586g++;
                    this.f3587h = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.f3584e = i3;
        } while (m2814b(1));
        throw m2812b("Unterminated string");
    }

    /* renamed from: b */
    private boolean m2814b(int i) {
        char[] cArr = this.f3583d;
        this.f3587h -= this.f3584e;
        if (this.f3585f != this.f3584e) {
            this.f3585f -= this.f3584e;
            System.arraycopy(cArr, this.f3584e, cArr, 0, this.f3585f);
        } else {
            this.f3585f = 0;
        }
        this.f3584e = 0;
        do {
            int read = this.f3581b.read(cArr, this.f3585f, cArr.length - this.f3585f);
            if (read == -1) {
                return false;
            }
            this.f3585f = read + this.f3585f;
            if (this.f3586g == 0 && this.f3587h == 0 && this.f3585f > 0 && cArr[0] == 65279) {
                this.f3584e++;
                this.f3587h++;
                i++;
            }
        } while (this.f3585f < i);
        return true;
    }

    /* renamed from: c */
    private void m2816c(char c) {
        char[] cArr = this.f3583d;
        do {
            int i = this.f3584e;
            int i2 = this.f3585f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f3584e = i4;
                    return;
                }
                if (c2 == '\\') {
                    this.f3584e = i4;
                    m2827z();
                    i4 = this.f3584e;
                    i2 = this.f3585f;
                } else if (c2 == 10) {
                    this.f3586g++;
                    this.f3587h = i4;
                }
                i3 = i4;
            }
            this.f3584e = i3;
        } while (m2814b(1));
        throw m2812b("Unterminated string");
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public int mo6390o() {
        int i = this.f3592m[this.f3593n - 1];
        if (i == 1) {
            this.f3592m[this.f3593n - 1] = 2;
        } else if (i == 2) {
            switch (m2811b(true)) {
                case 44:
                    break;
                case 59:
                    m2825x();
                    break;
                case 93:
                    this.f3588i = 4;
                    return 4;
                default:
                    throw m2812b("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.f3592m[this.f3593n - 1] = 4;
            if (i == 5) {
                switch (m2811b(true)) {
                    case 44:
                        break;
                    case 59:
                        m2825x();
                        break;
                    case 125:
                        this.f3588i = 2;
                        return 2;
                    default:
                        throw m2812b("Unterminated object");
                }
            }
            int b = m2811b(true);
            switch (b) {
                case 34:
                    this.f3588i = 13;
                    return 13;
                case 39:
                    m2825x();
                    this.f3588i = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.f3588i = 2;
                        return 2;
                    }
                    throw m2812b("Expected name");
                default:
                    m2825x();
                    this.f3584e--;
                    if (m2808a((char) b)) {
                        this.f3588i = 14;
                        return 14;
                    }
                    throw m2812b("Expected name");
            }
        } else if (i == 4) {
            this.f3592m[this.f3593n - 1] = 5;
            switch (m2811b(true)) {
                case 58:
                    break;
                case 61:
                    m2825x();
                    if ((this.f3584e < this.f3585f || m2814b(1)) && this.f3583d[this.f3584e] == '>') {
                        this.f3584e++;
                        break;
                    }
                default:
                    throw m2812b("Expected ':'");
            }
        } else if (i == 6) {
            if (this.f3582c) {
                m2804A();
            }
            this.f3592m[this.f3593n - 1] = 7;
        } else if (i == 7) {
            if (m2811b(false) == -1) {
                this.f3588i = 17;
                return 17;
            }
            m2825x();
            this.f3584e--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (m2811b(true)) {
            case 34:
                if (this.f3593n == 1) {
                    m2825x();
                }
                this.f3588i = 9;
                return 9;
            case 39:
                m2825x();
                this.f3588i = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.f3588i = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.f3588i = 4;
                    return 4;
                }
                break;
            case 123:
                this.f3588i = 1;
                return 1;
            default:
                this.f3584e--;
                if (this.f3593n == 1) {
                    m2825x();
                }
                int r = m2819r();
                if (r != 0) {
                    return r;
                }
                int s = m2820s();
                if (s != 0) {
                    return s;
                }
                if (!m2808a(this.f3583d[this.f3584e])) {
                    throw m2812b("Expected value");
                }
                m2825x();
                this.f3588i = 10;
                return 10;
        }
        if (i == 1 || i == 2) {
            m2825x();
            this.f3584e--;
            this.f3588i = 7;
            return 7;
        }
        throw m2812b("Unexpected value");
    }

    /* renamed from: r */
    private int m2819r() {
        String str;
        String str2;
        int i;
        char c = this.f3583d[this.f3584e];
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
            if (this.f3584e + i2 >= this.f3585f && !m2814b(i2 + 1)) {
                return 0;
            }
            char c2 = this.f3583d[this.f3584e + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f3584e + length < this.f3585f || m2814b(length + 1)) && m2808a(this.f3583d[this.f3584e + length])) {
            return 0;
        }
        this.f3584e += length;
        this.f3588i = i;
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
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m2820s() {
        /*
            r15 = this;
            char[] r11 = r15.f3583d
            int r2 = r15.f3584e
            int r1 = r15.f3585f
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
            boolean r0 = r15.m2814b((int) r0)
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
            r15.f3589j = r6
            int r0 = r15.f3584e
            int r0 = r0 + r10
            r15.f3584e = r0
            r0 = 15
            r15.f3588i = r0
            goto L_0x0017
        L_0x003b:
            int r1 = r15.f3584e
            int r0 = r15.f3585f
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
            boolean r0 = r15.m2808a((char) r2)
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
            r15.f3590k = r10
            r0 = 16
            r15.f3588i = r0
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.p008a.p013d.C0470a.m2820s():int");
    }

    /* renamed from: t */
    private String m2821t() {
        String sb;
        StringBuilder sb2 = null;
        int i = 0;
        while (true) {
            if (this.f3584e + i < this.f3585f) {
                switch (this.f3583d[this.f3584e + i]) {
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
                        m2825x();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.f3583d.length) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.f3583d, this.f3584e, i);
                this.f3584e = i + this.f3584e;
                if (!m2814b(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (m2814b(i + 1)) {
            }
        }
        if (sb2 == null) {
            sb = new String(this.f3583d, this.f3584e, i);
        } else {
            sb2.append(this.f3583d, this.f3584e, i);
            sb = sb2.toString();
        }
        this.f3584e = i + this.f3584e;
        return sb;
    }

    /* renamed from: u */
    private void m2822u() {
        do {
            int i = 0;
            while (this.f3584e + i < this.f3585f) {
                switch (this.f3583d[this.f3584e + i]) {
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
                        m2825x();
                        break;
                    default:
                        i++;
                }
                this.f3584e = i + this.f3584e;
                return;
            }
            this.f3584e = i + this.f3584e;
        } while (m2814b(1));
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public int m2823v() {
        return this.f3586g + 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public int m2824w() {
        return (this.f3584e - this.f3587h) + 1;
    }

    /* renamed from: x */
    private void m2825x() {
        if (!this.f3582c) {
            throw m2812b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: y */
    private void m2826y() {
        char c;
        do {
            if (this.f3584e < this.f3585f || m2814b(1)) {
                char[] cArr = this.f3583d;
                int i = this.f3584e;
                this.f3584e = i + 1;
                c = cArr[i];
                if (c == 10) {
                    this.f3586g++;
                    this.f3587h = this.f3584e;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    /* renamed from: z */
    private char m2827z() {
        int i;
        if (this.f3584e != this.f3585f || m2814b(1)) {
            char[] cArr = this.f3583d;
            int i2 = this.f3584e;
            this.f3584e = i2 + 1;
            char c = cArr[i2];
            switch (c) {
                case 10:
                    this.f3586g++;
                    this.f3587h = this.f3584e;
                    return c;
                case 'b':
                    return 8;
                case 'f':
                    return 12;
                case 'n':
                    return 10;
                case 'r':
                    return 13;
                case 't':
                    return 9;
                case 'u':
                    if (this.f3584e + 4 <= this.f3585f || m2814b(4)) {
                        int i3 = this.f3584e;
                        int i4 = i3 + 4;
                        int i5 = i3;
                        char c2 = 0;
                        for (int i6 = i5; i6 < i4; i6++) {
                            char c3 = this.f3583d[i6];
                            char c4 = (char) (c2 << 4);
                            if (c3 >= '0' && c3 <= '9') {
                                i = c3 - '0';
                            } else if (c3 >= 'a' && c3 <= 'f') {
                                i = (c3 - 'a') + 10;
                            } else if (c3 < 'A' || c3 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.f3583d, this.f3584e, 4));
                            } else {
                                i = (c3 - 'A') + 10;
                            }
                            c2 = (char) (c4 + i);
                        }
                        this.f3584e += 4;
                        return c2;
                    }
                    throw m2812b("Unterminated escape sequence");
                default:
                    return c;
            }
        } else {
            throw m2812b("Unterminated escape sequence");
        }
    }

    /* renamed from: a */
    public void mo6375a() {
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        if (i == 3) {
            m2807a(1);
            this.f3595p[this.f3593n - 1] = 0;
            this.f3588i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + mo6381f() + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
    }

    /* renamed from: a */
    public final void mo6499a(boolean z) {
        this.f3582c = z;
    }

    /* renamed from: b */
    public void mo6376b() {
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        if (i == 4) {
            this.f3593n--;
            this.f3588i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + mo6381f() + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
    }

    /* renamed from: c */
    public void mo6377c() {
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        if (i == 1) {
            m2807a(3);
            this.f3588i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + mo6381f() + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
    }

    public void close() {
        this.f3588i = 0;
        this.f3592m[0] = 8;
        this.f3593n = 1;
        this.f3581b.close();
    }

    /* renamed from: d */
    public void mo6379d() {
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        if (i == 2) {
            this.f3593n--;
            this.f3594o[this.f3593n] = null;
            this.f3588i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + mo6381f() + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
    }

    /* renamed from: e */
    public boolean mo6380e() {
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    /* renamed from: f */
    public C0472c mo6381f() {
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        switch (i) {
            case 1:
                return C0472c.BEGIN_OBJECT;
            case 2:
                return C0472c.END_OBJECT;
            case 3:
                return C0472c.BEGIN_ARRAY;
            case 4:
                return C0472c.END_ARRAY;
            case 5:
            case 6:
                return C0472c.BOOLEAN;
            case 7:
                return C0472c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return C0472c.STRING;
            case 12:
            case 13:
            case 14:
                return C0472c.NAME;
            case 15:
            case 16:
                return C0472c.NUMBER;
            case 17:
                return C0472c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: g */
    public String mo6382g() {
        String b;
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        if (i == 14) {
            b = m2821t();
        } else if (i == 12) {
            b = m2813b('\'');
        } else if (i == 13) {
            b = m2813b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + mo6381f() + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
        }
        this.f3588i = 0;
        this.f3594o[this.f3593n - 1] = b;
        return b;
    }

    /* renamed from: h */
    public String mo6383h() {
        String str;
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        if (i == 10) {
            str = m2821t();
        } else if (i == 8) {
            str = m2813b('\'');
        } else if (i == 9) {
            str = m2813b('\"');
        } else if (i == 11) {
            str = this.f3591l;
            this.f3591l = null;
        } else if (i == 15) {
            str = Long.toString(this.f3589j);
        } else if (i == 16) {
            str = new String(this.f3583d, this.f3584e, this.f3590k);
            this.f3584e += this.f3590k;
        } else {
            throw new IllegalStateException("Expected a string but was " + mo6381f() + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
        }
        this.f3588i = 0;
        int[] iArr = this.f3595p;
        int i2 = this.f3593n - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* renamed from: i */
    public boolean mo6384i() {
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        if (i == 5) {
            this.f3588i = 0;
            int[] iArr = this.f3595p;
            int i2 = this.f3593n - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f3588i = 0;
            int[] iArr2 = this.f3595p;
            int i3 = this.f3593n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + mo6381f() + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
        }
    }

    /* renamed from: j */
    public void mo6385j() {
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        if (i == 7) {
            this.f3588i = 0;
            int[] iArr = this.f3595p;
            int i2 = this.f3593n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + mo6381f() + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
    }

    /* renamed from: k */
    public double mo6386k() {
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        if (i == 15) {
            this.f3588i = 0;
            int[] iArr = this.f3595p;
            int i2 = this.f3593n - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f3589j;
        }
        if (i == 16) {
            this.f3591l = new String(this.f3583d, this.f3584e, this.f3590k);
            this.f3584e += this.f3590k;
        } else if (i == 8 || i == 9) {
            this.f3591l = m2813b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f3591l = m2821t();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + mo6381f() + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
        }
        this.f3588i = 11;
        double parseDouble = Double.parseDouble(this.f3591l);
        if (this.f3582c || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.f3591l = null;
            this.f3588i = 0;
            int[] iArr2 = this.f3595p;
            int i3 = this.f3593n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        throw new C0474e("JSON forbids NaN and infinities: " + parseDouble + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
    }

    /* renamed from: l */
    public long mo6387l() {
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        if (i == 15) {
            this.f3588i = 0;
            int[] iArr = this.f3595p;
            int i2 = this.f3593n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f3589j;
        }
        if (i == 16) {
            this.f3591l = new String(this.f3583d, this.f3584e, this.f3590k);
            this.f3584e += this.f3590k;
        } else if (i == 8 || i == 9) {
            this.f3591l = m2813b(i == 8 ? '\'' : '\"');
            try {
                long parseLong = Long.parseLong(this.f3591l);
                this.f3588i = 0;
                int[] iArr2 = this.f3595p;
                int i3 = this.f3593n - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + mo6381f() + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
        }
        this.f3588i = 11;
        double parseDouble = Double.parseDouble(this.f3591l);
        long j = (long) parseDouble;
        if (((double) j) != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f3591l + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
        }
        this.f3591l = null;
        this.f3588i = 0;
        int[] iArr3 = this.f3595p;
        int i4 = this.f3593n - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    /* renamed from: m */
    public int mo6388m() {
        int i = this.f3588i;
        if (i == 0) {
            i = mo6390o();
        }
        if (i == 15) {
            int i2 = (int) this.f3589j;
            if (this.f3589j != ((long) i2)) {
                throw new NumberFormatException("Expected an int but was " + this.f3589j + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
            }
            this.f3588i = 0;
            int[] iArr = this.f3595p;
            int i3 = this.f3593n - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.f3591l = new String(this.f3583d, this.f3584e, this.f3590k);
            this.f3584e += this.f3590k;
        } else if (i == 8 || i == 9) {
            this.f3591l = m2813b(i == 8 ? '\'' : '\"');
            try {
                int parseInt = Integer.parseInt(this.f3591l);
                this.f3588i = 0;
                int[] iArr2 = this.f3595p;
                int i4 = this.f3593n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + mo6381f() + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
        }
        this.f3588i = 11;
        double parseDouble = Double.parseDouble(this.f3591l);
        int i5 = (int) parseDouble;
        if (((double) i5) != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.f3591l + " at line " + m2823v() + " column " + m2824w() + " path " + mo6501q());
        }
        this.f3591l = null;
        this.f3588i = 0;
        int[] iArr3 = this.f3595p;
        int i6 = this.f3593n - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    /* renamed from: n */
    public void mo6389n() {
        int i = 0;
        do {
            int i2 = this.f3588i;
            if (i2 == 0) {
                i2 = mo6390o();
            }
            if (i2 == 3) {
                m2807a(1);
                i++;
            } else if (i2 == 1) {
                m2807a(3);
                i++;
            } else if (i2 == 4) {
                this.f3593n--;
                i--;
            } else if (i2 == 2) {
                this.f3593n--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                m2822u();
            } else if (i2 == 8 || i2 == 12) {
                m2816c('\'');
            } else if (i2 == 9 || i2 == 13) {
                m2816c('\"');
            } else if (i2 == 16) {
                this.f3584e += this.f3590k;
            }
            this.f3588i = 0;
        } while (i != 0);
        int[] iArr = this.f3595p;
        int i3 = this.f3593n - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f3594o[this.f3593n - 1] = "null";
    }

    /* renamed from: p */
    public final boolean mo6500p() {
        return this.f3582c;
    }

    /* renamed from: q */
    public String mo6501q() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.f3593n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f3592m[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.f3595p[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.f3594o[i2] == null) {
                        break;
                    } else {
                        append.append(this.f3594o[i2]);
                        break;
                    }
            }
        }
        return append.toString();
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + m2823v() + " column " + m2824w();
    }
}
