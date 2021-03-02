package org.apache.commons.lang3.text;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public abstract class StrMatcher {

    /* renamed from: a */
    private static final StrMatcher f7165a = new C1969a(',');

    /* renamed from: b */
    private static final StrMatcher f7166b = new C1969a(9);

    /* renamed from: c */
    private static final StrMatcher f7167c = new C1969a(' ');

    /* renamed from: d */
    private static final StrMatcher f7168d = new C1970b(" \t\n\r\f".toCharArray());

    /* renamed from: e */
    private static final StrMatcher f7169e = new C1973e();

    /* renamed from: f */
    private static final StrMatcher f7170f = new C1969a('\'');

    /* renamed from: g */
    private static final StrMatcher f7171g = new C1969a('\"');

    /* renamed from: h */
    private static final StrMatcher f7172h = new C1970b("'\"".toCharArray());

    /* renamed from: i */
    private static final StrMatcher f7173i = new C1971c();

    public abstract int isMatch(char[] cArr, int i, int i2, int i3);

    public static StrMatcher commaMatcher() {
        return f7165a;
    }

    public static StrMatcher tabMatcher() {
        return f7166b;
    }

    public static StrMatcher spaceMatcher() {
        return f7167c;
    }

    public static StrMatcher splitMatcher() {
        return f7168d;
    }

    public static StrMatcher trimMatcher() {
        return f7169e;
    }

    public static StrMatcher singleQuoteMatcher() {
        return f7170f;
    }

    public static StrMatcher doubleQuoteMatcher() {
        return f7171g;
    }

    public static StrMatcher quoteMatcher() {
        return f7172h;
    }

    public static StrMatcher noneMatcher() {
        return f7173i;
    }

    public static StrMatcher charMatcher(char c) {
        return new C1969a(c);
    }

    public static StrMatcher charSetMatcher(char... cArr) {
        if (cArr == null || cArr.length == 0) {
            return f7173i;
        }
        if (cArr.length == 1) {
            return new C1969a(cArr[0]);
        }
        return new C1970b(cArr);
    }

    public static StrMatcher charSetMatcher(String str) {
        if (str == null || str.length() == 0) {
            return f7173i;
        }
        if (str.length() == 1) {
            return new C1969a(str.charAt(0));
        }
        return new C1970b(str.toCharArray());
    }

    public static StrMatcher stringMatcher(String str) {
        if (StringUtils.isEmpty(str)) {
            return f7173i;
        }
        return new C1972d(str);
    }

    protected StrMatcher() {
    }

    public int isMatch(char[] cArr, int i) {
        return isMatch(cArr, i, 0, cArr.length);
    }

    /* renamed from: org.apache.commons.lang3.text.StrMatcher$b */
    static final class C1970b extends StrMatcher {

        /* renamed from: a */
        private final char[] f7175a;

        C1970b(char[] cArr) {
            this.f7175a = (char[]) cArr.clone();
            Arrays.sort(this.f7175a);
        }

        public int isMatch(char[] cArr, int i, int i2, int i3) {
            return Arrays.binarySearch(this.f7175a, cArr[i]) >= 0 ? 1 : 0;
        }
    }

    /* renamed from: org.apache.commons.lang3.text.StrMatcher$a */
    static final class C1969a extends StrMatcher {

        /* renamed from: a */
        private final char f7174a;

        C1969a(char c) {
            this.f7174a = c;
        }

        public int isMatch(char[] cArr, int i, int i2, int i3) {
            return this.f7174a == cArr[i] ? 1 : 0;
        }
    }

    /* renamed from: org.apache.commons.lang3.text.StrMatcher$d */
    static final class C1972d extends StrMatcher {

        /* renamed from: a */
        private final char[] f7176a;

        C1972d(String str) {
            this.f7176a = str.toCharArray();
        }

        public int isMatch(char[] cArr, int i, int i2, int i3) {
            int length = this.f7176a.length;
            if (i + length > i3) {
                return 0;
            }
            int i4 = 0;
            while (i4 < this.f7176a.length) {
                if (this.f7176a[i4] != cArr[i]) {
                    return 0;
                }
                i4++;
                i++;
            }
            return length;
        }
    }

    /* renamed from: org.apache.commons.lang3.text.StrMatcher$c */
    static final class C1971c extends StrMatcher {
        C1971c() {
        }

        public int isMatch(char[] cArr, int i, int i2, int i3) {
            return 0;
        }
    }

    /* renamed from: org.apache.commons.lang3.text.StrMatcher$e */
    static final class C1973e extends StrMatcher {
        C1973e() {
        }

        public int isMatch(char[] cArr, int i, int i2, int i3) {
            return cArr[i] <= ' ' ? 1 : 0;
        }
    }
}
