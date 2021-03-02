package android.support.p001v4.text;

import java.util.Locale;

/* renamed from: android.support.v4.text.BidiFormatter */
public final class BidiFormatter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static TextDirectionHeuristicCompat f816a = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;

    /* renamed from: b */
    private static final String f817b = Character.toString(8206);

    /* renamed from: c */
    private static final String f818c = Character.toString(8207);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final BidiFormatter f819d = new BidiFormatter(false, 2, f816a);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final BidiFormatter f820e = new BidiFormatter(true, 2, f816a);

    /* renamed from: f */
    private final boolean f821f;

    /* renamed from: g */
    private final int f822g;

    /* renamed from: h */
    private final TextDirectionHeuristicCompat f823h;

    /* renamed from: android.support.v4.text.BidiFormatter$Builder */
    public static final class Builder {

        /* renamed from: a */
        private boolean f824a;

        /* renamed from: b */
        private int f825b;

        /* renamed from: c */
        private TextDirectionHeuristicCompat f826c;

        public Builder() {
            m939a(BidiFormatter.m937b(Locale.getDefault()));
        }

        public Builder(boolean z) {
            m939a(z);
        }

        public Builder(Locale locale) {
            m939a(BidiFormatter.m937b(locale));
        }

        /* renamed from: a */
        private void m939a(boolean z) {
            this.f824a = z;
            this.f826c = BidiFormatter.f816a;
            this.f825b = 2;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.f825b |= 2;
            } else {
                this.f825b &= -3;
            }
            return this;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.f826c = textDirectionHeuristicCompat;
            return this;
        }

        /* renamed from: b */
        private static BidiFormatter m940b(boolean z) {
            return z ? BidiFormatter.f820e : BidiFormatter.f819d;
        }

        public BidiFormatter build() {
            if (this.f825b == 2 && this.f826c == BidiFormatter.f816a) {
                return m940b(this.f824a);
            }
            return new BidiFormatter(this.f824a, this.f825b, this.f826c);
        }
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    private BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.f821f = z;
        this.f822g = i;
        this.f823h = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.f821f;
    }

    public boolean getStereoReset() {
        return (this.f822g & 2) != 0;
    }

    /* renamed from: a */
    private String m932a(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str, 0, str.length());
        if (!this.f821f && (isRtl || m930a(str) == 1)) {
            return f817b;
        }
        if (!this.f821f || (isRtl && m930a(str) != -1)) {
            return "";
        }
        return f818c;
    }

    /* renamed from: b */
    private String m936b(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str, 0, str.length());
        if (!this.f821f && (isRtl || m934b(str) == 1)) {
            return f817b;
        }
        if (!this.f821f || (isRtl && m934b(str) != -1)) {
            return "";
        }
        return f818c;
    }

    public boolean isRtl(String str) {
        return this.f823h.isRtl((CharSequence) str, 0, str.length());
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        if (getStereoReset() && z) {
            sb.append(m936b(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.f821f) {
            sb.append(isRtl ? (char) 8235 : 8234);
            sb.append(str);
            sb.append(8236);
        } else {
            sb.append(str);
        }
        if (z) {
            sb.append(m932a(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return sb.toString();
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.f823h, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.f823h, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m937b(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    /* renamed from: a */
    private static int m930a(String str) {
        return new C0241a(str, false).mo1544b();
    }

    /* renamed from: b */
    private static int m934b(String str) {
        return new C0241a(str, false).mo1543a();
    }

    /* renamed from: android.support.v4.text.BidiFormatter$a */
    static class C0241a {

        /* renamed from: a */
        private static final byte[] f827a = new byte[1792];

        /* renamed from: b */
        private final String f828b;

        /* renamed from: c */
        private final boolean f829c;

        /* renamed from: d */
        private final int f830d;

        /* renamed from: e */
        private int f831e;

        /* renamed from: f */
        private char f832f;

        static {
            for (int i = 0; i < 1792; i++) {
                f827a[i] = Character.getDirectionality(i);
            }
        }

        C0241a(String str, boolean z) {
            this.f828b = str;
            this.f829c = z;
            this.f830d = str.length();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo1543a() {
            this.f831e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f831e < this.f830d && i == 0) {
                switch (mo1545c()) {
                    case 0:
                        if (i3 != 0) {
                            i = i3;
                            break;
                        } else {
                            return -1;
                        }
                    case 1:
                    case 2:
                        if (i3 != 0) {
                            i = i3;
                            break;
                        } else {
                            return 1;
                        }
                    case 9:
                        break;
                    case 14:
                    case 15:
                        i3++;
                        i2 = -1;
                        break;
                    case 16:
                    case 17:
                        i3++;
                        i2 = 1;
                        break;
                    case 18:
                        i3--;
                        i2 = 0;
                        break;
                    default:
                        i = i3;
                        break;
                }
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f831e > 0) {
                switch (mo1546d()) {
                    case 14:
                    case 15:
                        if (i != i3) {
                            i3--;
                            break;
                        } else {
                            return -1;
                        }
                    case 16:
                    case 17:
                        if (i != i3) {
                            i3--;
                            break;
                        } else {
                            return 1;
                        }
                    case 18:
                        i3++;
                        break;
                }
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo1544b() {
            this.f831e = this.f830d;
            int i = 0;
            int i2 = 0;
            while (this.f831e > 0) {
                switch (mo1546d()) {
                    case 0:
                        if (i2 != 0) {
                            if (i != 0) {
                                break;
                            } else {
                                i = i2;
                                break;
                            }
                        } else {
                            return -1;
                        }
                    case 1:
                    case 2:
                        if (i2 != 0) {
                            if (i != 0) {
                                break;
                            } else {
                                i = i2;
                                break;
                            }
                        } else {
                            return 1;
                        }
                    case 9:
                        break;
                    case 14:
                    case 15:
                        if (i != i2) {
                            i2--;
                            break;
                        } else {
                            return -1;
                        }
                    case 16:
                    case 17:
                        if (i != i2) {
                            i2--;
                            break;
                        } else {
                            return 1;
                        }
                    case 18:
                        i2++;
                        break;
                    default:
                        if (i != 0) {
                            break;
                        } else {
                            i = i2;
                            break;
                        }
                }
            }
            return 0;
        }

        /* renamed from: a */
        private static byte m941a(char c) {
            return c < 1792 ? f827a[c] : Character.getDirectionality(c);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public byte mo1545c() {
            this.f832f = this.f828b.charAt(this.f831e);
            if (Character.isHighSurrogate(this.f832f)) {
                int codePointAt = Character.codePointAt(this.f828b, this.f831e);
                this.f831e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f831e++;
            byte a = m941a(this.f832f);
            if (!this.f829c) {
                return a;
            }
            if (this.f832f == '<') {
                return m942e();
            }
            if (this.f832f == '&') {
                return m944g();
            }
            return a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public byte mo1546d() {
            this.f832f = this.f828b.charAt(this.f831e - 1);
            if (Character.isLowSurrogate(this.f832f)) {
                int codePointBefore = Character.codePointBefore(this.f828b, this.f831e);
                this.f831e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f831e--;
            byte a = m941a(this.f832f);
            if (!this.f829c) {
                return a;
            }
            if (this.f832f == '>') {
                return m943f();
            }
            if (this.f832f == ';') {
                return m945h();
            }
            return a;
        }

        /* renamed from: e */
        private byte m942e() {
            int i = this.f831e;
            while (this.f831e < this.f830d) {
                String str = this.f828b;
                int i2 = this.f831e;
                this.f831e = i2 + 1;
                this.f832f = str.charAt(i2);
                if (this.f832f == '>') {
                    return 12;
                }
                if (this.f832f == '\"' || this.f832f == '\'') {
                    char c = this.f832f;
                    while (this.f831e < this.f830d) {
                        String str2 = this.f828b;
                        int i3 = this.f831e;
                        this.f831e = i3 + 1;
                        char charAt = str2.charAt(i3);
                        this.f832f = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.f831e = i;
            this.f832f = '<';
            return 13;
        }

        /* renamed from: f */
        private byte m943f() {
            int i = this.f831e;
            while (this.f831e > 0) {
                String str = this.f828b;
                int i2 = this.f831e - 1;
                this.f831e = i2;
                this.f832f = str.charAt(i2);
                if (this.f832f == '<') {
                    return 12;
                }
                if (this.f832f == '>') {
                    break;
                } else if (this.f832f == '\"' || this.f832f == '\'') {
                    char c = this.f832f;
                    while (this.f831e > 0) {
                        String str2 = this.f828b;
                        int i3 = this.f831e - 1;
                        this.f831e = i3;
                        char charAt = str2.charAt(i3);
                        this.f832f = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.f831e = i;
            this.f832f = '>';
            return 13;
        }

        /* renamed from: g */
        private byte m944g() {
            while (this.f831e < this.f830d) {
                String str = this.f828b;
                int i = this.f831e;
                this.f831e = i + 1;
                char charAt = str.charAt(i);
                this.f832f = charAt;
                if (charAt == ';') {
                    return 12;
                }
            }
            return 12;
        }

        /* renamed from: h */
        private byte m945h() {
            int i = this.f831e;
            while (this.f831e > 0) {
                String str = this.f828b;
                int i2 = this.f831e - 1;
                this.f831e = i2;
                this.f832f = str.charAt(i2);
                if (this.f832f != '&') {
                    if (this.f832f == ';') {
                        break;
                    }
                } else {
                    return 12;
                }
            }
            this.f831e = i;
            this.f832f = ';';
            return 13;
        }
    }
}
