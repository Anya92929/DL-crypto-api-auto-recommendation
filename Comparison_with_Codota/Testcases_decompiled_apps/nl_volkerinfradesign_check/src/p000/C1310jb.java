package p000;

import javax.security.auth.x500.X500Principal;

/* renamed from: jb */
public final class C1310jb {

    /* renamed from: a */
    private final String f4553a;

    /* renamed from: b */
    private final int f4554b = this.f4553a.length();

    /* renamed from: c */
    private int f4555c;

    /* renamed from: d */
    private int f4556d;

    /* renamed from: e */
    private int f4557e;

    /* renamed from: f */
    private int f4558f;

    /* renamed from: g */
    private char[] f4559g;

    public C1310jb(X500Principal x500Principal) {
        this.f4553a = x500Principal.getName("RFC2253");
    }

    /* renamed from: a */
    private String m5681a() {
        while (this.f4555c < this.f4554b && this.f4559g[this.f4555c] == ' ') {
            this.f4555c++;
        }
        if (this.f4555c == this.f4554b) {
            return null;
        }
        this.f4556d = this.f4555c;
        this.f4555c++;
        while (this.f4555c < this.f4554b && this.f4559g[this.f4555c] != '=' && this.f4559g[this.f4555c] != ' ') {
            this.f4555c++;
        }
        if (this.f4555c >= this.f4554b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f4553a);
        }
        this.f4557e = this.f4555c;
        if (this.f4559g[this.f4555c] == ' ') {
            while (this.f4555c < this.f4554b && this.f4559g[this.f4555c] != '=' && this.f4559g[this.f4555c] == ' ') {
                this.f4555c++;
            }
            if (this.f4559g[this.f4555c] != '=' || this.f4555c == this.f4554b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f4553a);
            }
        }
        this.f4555c++;
        while (this.f4555c < this.f4554b && this.f4559g[this.f4555c] == ' ') {
            this.f4555c++;
        }
        if (this.f4557e - this.f4556d > 4 && this.f4559g[this.f4556d + 3] == '.' && ((this.f4559g[this.f4556d] == 'O' || this.f4559g[this.f4556d] == 'o') && ((this.f4559g[this.f4556d + 1] == 'I' || this.f4559g[this.f4556d + 1] == 'i') && (this.f4559g[this.f4556d + 2] == 'D' || this.f4559g[this.f4556d + 2] == 'd')))) {
            this.f4556d += 4;
        }
        return new String(this.f4559g, this.f4556d, this.f4557e - this.f4556d);
    }

    /* renamed from: b */
    private String m5682b() {
        this.f4555c++;
        this.f4556d = this.f4555c;
        this.f4557e = this.f4556d;
        while (this.f4555c != this.f4554b) {
            if (this.f4559g[this.f4555c] == '\"') {
                this.f4555c++;
                while (this.f4555c < this.f4554b && this.f4559g[this.f4555c] == ' ') {
                    this.f4555c++;
                }
                return new String(this.f4559g, this.f4556d, this.f4557e - this.f4556d);
            }
            if (this.f4559g[this.f4555c] == '\\') {
                this.f4559g[this.f4557e] = m5685e();
            } else {
                this.f4559g[this.f4557e] = this.f4559g[this.f4555c];
            }
            this.f4555c++;
            this.f4557e++;
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f4553a);
    }

    /* renamed from: c */
    private String m5683c() {
        if (this.f4555c + 4 >= this.f4554b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f4553a);
        }
        this.f4556d = this.f4555c;
        this.f4555c++;
        while (true) {
            if (this.f4555c == this.f4554b || this.f4559g[this.f4555c] == '+' || this.f4559g[this.f4555c] == ',' || this.f4559g[this.f4555c] == ';') {
                this.f4557e = this.f4555c;
            } else if (this.f4559g[this.f4555c] == ' ') {
                this.f4557e = this.f4555c;
                this.f4555c++;
                while (this.f4555c < this.f4554b && this.f4559g[this.f4555c] == ' ') {
                    this.f4555c++;
                }
            } else {
                if (this.f4559g[this.f4555c] >= 'A' && this.f4559g[this.f4555c] <= 'F') {
                    char[] cArr = this.f4559g;
                    int i = this.f4555c;
                    cArr[i] = (char) (cArr[i] + ' ');
                }
                this.f4555c++;
            }
        }
        this.f4557e = this.f4555c;
        int i2 = this.f4557e - this.f4556d;
        if (i2 < 5 || (i2 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f4553a);
        }
        byte[] bArr = new byte[(i2 / 2)];
        int i3 = this.f4556d + 1;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            bArr[i4] = (byte) m5680a(i3);
            i3 += 2;
        }
        return new String(this.f4559g, this.f4556d, i2);
    }

    /* renamed from: d */
    private String m5684d() {
        this.f4556d = this.f4555c;
        this.f4557e = this.f4555c;
        while (this.f4555c < this.f4554b) {
            switch (this.f4559g[this.f4555c]) {
                case ' ':
                    this.f4558f = this.f4557e;
                    this.f4555c++;
                    char[] cArr = this.f4559g;
                    int i = this.f4557e;
                    this.f4557e = i + 1;
                    cArr[i] = ' ';
                    while (this.f4555c < this.f4554b && this.f4559g[this.f4555c] == ' ') {
                        char[] cArr2 = this.f4559g;
                        int i2 = this.f4557e;
                        this.f4557e = i2 + 1;
                        cArr2[i2] = ' ';
                        this.f4555c++;
                    }
                    if (this.f4555c != this.f4554b && this.f4559g[this.f4555c] != ',' && this.f4559g[this.f4555c] != '+' && this.f4559g[this.f4555c] != ';') {
                        break;
                    } else {
                        return new String(this.f4559g, this.f4556d, this.f4558f - this.f4556d);
                    }
                    break;
                case '+':
                case ',':
                case ';':
                    return new String(this.f4559g, this.f4556d, this.f4557e - this.f4556d);
                case '\\':
                    char[] cArr3 = this.f4559g;
                    int i3 = this.f4557e;
                    this.f4557e = i3 + 1;
                    cArr3[i3] = m5685e();
                    this.f4555c++;
                    break;
                default:
                    char[] cArr4 = this.f4559g;
                    int i4 = this.f4557e;
                    this.f4557e = i4 + 1;
                    cArr4[i4] = this.f4559g[this.f4555c];
                    this.f4555c++;
                    break;
            }
        }
        return new String(this.f4559g, this.f4556d, this.f4557e - this.f4556d);
    }

    /* renamed from: e */
    private char m5685e() {
        this.f4555c++;
        if (this.f4555c == this.f4554b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f4553a);
        }
        switch (this.f4559g[this.f4555c]) {
            case ' ':
            case '\"':
            case '#':
            case '%':
            case '*':
            case '+':
            case ',':
            case ';':
            case '<':
            case '=':
            case '>':
            case '\\':
            case '_':
                return this.f4559g[this.f4555c];
            default:
                return m5686f();
        }
    }

    /* renamed from: f */
    private char m5686f() {
        int i;
        int i2;
        int a = m5680a(this.f4555c);
        this.f4555c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        if (a <= 223) {
            i = 1;
            i2 = a & 31;
        } else if (a <= 239) {
            i = 2;
            i2 = a & 15;
        } else {
            i = 3;
            i2 = a & 7;
        }
        int i3 = i2;
        for (int i4 = 0; i4 < i; i4++) {
            this.f4555c++;
            if (this.f4555c == this.f4554b || this.f4559g[this.f4555c] != '\\') {
                return '?';
            }
            this.f4555c++;
            int a2 = m5680a(this.f4555c);
            this.f4555c++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (a2 & 63);
        }
        return (char) i3;
    }

    /* renamed from: a */
    private int m5680a(int i) {
        int i2;
        int i3;
        if (i + 1 >= this.f4554b) {
            throw new IllegalStateException("Malformed DN: " + this.f4553a);
        }
        char c = this.f4559g[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else if (c < 'A' || c > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f4553a);
        } else {
            i2 = c - '7';
        }
        char c2 = this.f4559g[i + 1];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f4553a);
        } else {
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    /* renamed from: a */
    public String mo8724a(String str) {
        this.f4555c = 0;
        this.f4556d = 0;
        this.f4557e = 0;
        this.f4558f = 0;
        this.f4559g = this.f4553a.toCharArray();
        String a = m5681a();
        if (a == null) {
            return null;
        }
        do {
            String str2 = "";
            if (this.f4555c == this.f4554b) {
                return null;
            }
            switch (this.f4559g[this.f4555c]) {
                case '\"':
                    str2 = m5682b();
                    break;
                case '#':
                    str2 = m5683c();
                    break;
                case '+':
                case ',':
                case ';':
                    break;
                default:
                    str2 = m5684d();
                    break;
            }
            if (str.equalsIgnoreCase(a)) {
                return str2;
            }
            if (this.f4555c >= this.f4554b) {
                return null;
            }
            if (this.f4559g[this.f4555c] == ',' || this.f4559g[this.f4555c] == ';' || this.f4559g[this.f4555c] == '+') {
                this.f4555c++;
                a = m5681a();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f4553a);
            }
        } while (a != null);
        throw new IllegalStateException("Malformed DN: " + this.f4553a);
    }
}
