package android.support.p000v4.text;

import java.util.Locale;

/* renamed from: android.support.v4.text.BidiFormatter */
public final class BidiFormatter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static TextDirectionHeuristicCompat f1055a = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;

    /* renamed from: b */
    private static final String f1056b = Character.toString(8206);

    /* renamed from: c */
    private static final String f1057c = Character.toString(8207);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final BidiFormatter f1058d = new BidiFormatter(false, 2, f1055a);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final BidiFormatter f1059e = new BidiFormatter(true, 2, f1055a);

    /* renamed from: f */
    private final boolean f1060f;

    /* renamed from: g */
    private final int f1061g;

    /* renamed from: h */
    private final TextDirectionHeuristicCompat f1062h;

    /* renamed from: android.support.v4.text.BidiFormatter$Builder */
    public final class Builder {

        /* renamed from: a */
        private boolean f1063a;

        /* renamed from: b */
        private int f1064b;

        /* renamed from: c */
        private TextDirectionHeuristicCompat f1065c;

        public Builder() {
            m781a(BidiFormatter.m779b(Locale.getDefault()));
        }

        public Builder(Locale locale) {
            m781a(BidiFormatter.m779b(locale));
        }

        public Builder(boolean z) {
            m781a(z);
        }

        /* renamed from: a */
        private void m781a(boolean z) {
            this.f1063a = z;
            this.f1065c = BidiFormatter.f1055a;
            this.f1064b = 2;
        }

        /* renamed from: b */
        private static BidiFormatter m782b(boolean z) {
            return z ? BidiFormatter.f1059e : BidiFormatter.f1058d;
        }

        public BidiFormatter build() {
            return (this.f1064b == 2 && this.f1065c == BidiFormatter.f1055a) ? m782b(this.f1063a) : new BidiFormatter(this.f1063a, this.f1064b, this.f1065c);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.f1065c = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.f1064b |= 2;
            } else {
                this.f1064b &= -3;
            }
            return this;
        }
    }

    /* renamed from: android.support.v4.text.BidiFormatter$DirectionalityEstimator */
    class DirectionalityEstimator {

        /* renamed from: a */
        private static final byte[] f1066a = new byte[1792];

        /* renamed from: b */
        private final String f1067b;

        /* renamed from: c */
        private final boolean f1068c;

        /* renamed from: d */
        private final int f1069d;

        /* renamed from: e */
        private int f1070e;

        /* renamed from: f */
        private char f1071f;

        static {
            for (int i = 0; i < 1792; i++) {
                f1066a[i] = Character.getDirectionality(i);
            }
        }

        DirectionalityEstimator(String str, boolean z) {
            this.f1067b = str;
            this.f1068c = z;
            this.f1069d = str.length();
        }

        /* renamed from: a */
        private static byte m783a(char c) {
            return c < 1792 ? f1066a[c] : Character.getDirectionality(c);
        }

        /* renamed from: e */
        private byte m784e() {
            int i = this.f1070e;
            while (this.f1070e < this.f1069d) {
                String str = this.f1067b;
                int i2 = this.f1070e;
                this.f1070e = i2 + 1;
                this.f1071f = str.charAt(i2);
                if (this.f1071f == '>') {
                    return 12;
                }
                if (this.f1071f == '\"' || this.f1071f == '\'') {
                    char c = this.f1071f;
                    while (this.f1070e < this.f1069d) {
                        String str2 = this.f1067b;
                        int i3 = this.f1070e;
                        this.f1070e = i3 + 1;
                        char charAt = str2.charAt(i3);
                        this.f1071f = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.f1070e = i;
            this.f1071f = '<';
            return 13;
        }

        /* renamed from: f */
        private byte m785f() {
            int i = this.f1070e;
            while (this.f1070e > 0) {
                String str = this.f1067b;
                int i2 = this.f1070e - 1;
                this.f1070e = i2;
                this.f1071f = str.charAt(i2);
                if (this.f1071f == '<') {
                    return 12;
                }
                if (this.f1071f == '>') {
                    break;
                } else if (this.f1071f == '\"' || this.f1071f == '\'') {
                    char c = this.f1071f;
                    while (this.f1070e > 0) {
                        String str2 = this.f1067b;
                        int i3 = this.f1070e - 1;
                        this.f1070e = i3;
                        char charAt = str2.charAt(i3);
                        this.f1071f = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.f1070e = i;
            this.f1071f = '>';
            return 13;
        }

        /* renamed from: g */
        private byte m786g() {
            while (this.f1070e < this.f1069d) {
                String str = this.f1067b;
                int i = this.f1070e;
                this.f1070e = i + 1;
                char charAt = str.charAt(i);
                this.f1071f = charAt;
                if (charAt == ';') {
                    return 12;
                }
            }
            return 12;
        }

        /* renamed from: h */
        private byte m787h() {
            int i = this.f1070e;
            while (this.f1070e > 0) {
                String str = this.f1067b;
                int i2 = this.f1070e - 1;
                this.f1070e = i2;
                this.f1071f = str.charAt(i2);
                if (this.f1071f != '&') {
                    if (this.f1071f == ';') {
                        break;
                    }
                } else {
                    return 12;
                }
            }
            this.f1070e = i;
            this.f1071f = ';';
            return 13;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo1899a() {
            this.f1070e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f1070e < this.f1069d && i == 0) {
                switch (mo1901c()) {
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
            while (this.f1070e > 0) {
                switch (mo1902d()) {
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
        public int mo1900b() {
            this.f1070e = this.f1069d;
            int i = 0;
            int i2 = 0;
            while (this.f1070e > 0) {
                switch (mo1902d()) {
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

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public byte mo1901c() {
            this.f1071f = this.f1067b.charAt(this.f1070e);
            if (Character.isHighSurrogate(this.f1071f)) {
                int codePointAt = Character.codePointAt(this.f1067b, this.f1070e);
                this.f1070e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f1070e++;
            byte a = m783a(this.f1071f);
            return this.f1068c ? this.f1071f == '<' ? m784e() : this.f1071f == '&' ? m786g() : a : a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public byte mo1902d() {
            this.f1071f = this.f1067b.charAt(this.f1070e - 1);
            if (Character.isLowSurrogate(this.f1071f)) {
                int codePointBefore = Character.codePointBefore(this.f1067b, this.f1070e);
                this.f1070e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f1070e--;
            byte a = m783a(this.f1071f);
            return this.f1068c ? this.f1071f == '>' ? m785f() : this.f1071f == ';' ? m787h() : a : a;
        }
    }

    private BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.f1060f = z;
        this.f1061g = i;
        this.f1062h = textDirectionHeuristicCompat;
    }

    /* renamed from: a */
    private static int m772a(String str) {
        return new DirectionalityEstimator(str, false).mo1900b();
    }

    /* renamed from: a */
    private String m774a(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str, 0, str.length());
        return (this.f1060f || (!isRtl && m772a(str) != 1)) ? (!this.f1060f || (isRtl && m772a(str) != -1)) ? "" : f1057c : f1056b;
    }

    /* renamed from: b */
    private static int m776b(String str) {
        return new DirectionalityEstimator(str, false).mo1899a();
    }

    /* renamed from: b */
    private String m778b(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str, 0, str.length());
        return (this.f1060f || (!isRtl && m776b(str) != 1)) ? (!this.f1060f || (isRtl && m776b(str) != -1)) ? "" : f1057c : f1056b;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m779b(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public boolean getStereoReset() {
        return (this.f1061g & 2) != 0;
    }

    public boolean isRtl(String str) {
        return this.f1062h.isRtl((CharSequence) str, 0, str.length());
    }

    public boolean isRtlContext() {
        return this.f1060f;
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.f1062h, true);
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        if (getStereoReset() && z) {
            sb.append(m778b(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.f1060f) {
            sb.append(isRtl ? (char) 8235 : 8234);
            sb.append(str);
            sb.append(8236);
        } else {
            sb.append(str);
        }
        if (z) {
            sb.append(m774a(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return sb.toString();
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.f1062h, z);
    }
}
