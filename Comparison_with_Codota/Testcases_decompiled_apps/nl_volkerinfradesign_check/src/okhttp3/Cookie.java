package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Cookie {

    /* renamed from: a */
    private static final Pattern f5769a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: b */
    private static final Pattern f5770b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: c */
    private static final Pattern f5771c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: d */
    private static final Pattern f5772d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: e */
    private final String f5773e;

    /* renamed from: f */
    private final String f5774f;

    /* renamed from: g */
    private final long f5775g;

    /* renamed from: h */
    private final String f5776h;

    /* renamed from: i */
    private final String f5777i;

    /* renamed from: j */
    private final boolean f5778j;

    /* renamed from: k */
    private final boolean f5779k;

    /* renamed from: l */
    private final boolean f5780l;

    /* renamed from: m */
    private final boolean f5781m;

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f5773e = str;
        this.f5774f = str2;
        this.f5775g = j;
        this.f5776h = str3;
        this.f5777i = str4;
        this.f5778j = z;
        this.f5779k = z2;
        this.f5781m = z3;
        this.f5780l = z4;
    }

    private Cookie(Builder builder) {
        if (builder.f5782a == null) {
            throw new IllegalArgumentException("builder.name == null");
        } else if (builder.f5783b == null) {
            throw new IllegalArgumentException("builder.value == null");
        } else if (builder.f5785d == null) {
            throw new IllegalArgumentException("builder.domain == null");
        } else {
            this.f5773e = builder.f5782a;
            this.f5774f = builder.f5783b;
            this.f5775g = builder.f5784c;
            this.f5776h = builder.f5785d;
            this.f5777i = builder.f5786e;
            this.f5778j = builder.f5787f;
            this.f5779k = builder.f5788g;
            this.f5780l = builder.f5789h;
            this.f5781m = builder.f5790i;
        }
    }

    public String name() {
        return this.f5773e;
    }

    public String value() {
        return this.f5774f;
    }

    public boolean persistent() {
        return this.f5780l;
    }

    public long expiresAt() {
        return this.f5775g;
    }

    public boolean hostOnly() {
        return this.f5781m;
    }

    public String domain() {
        return this.f5776h;
    }

    public String path() {
        return this.f5777i;
    }

    public boolean httpOnly() {
        return this.f5779k;
    }

    public boolean secure() {
        return this.f5778j;
    }

    public boolean matches(HttpUrl httpUrl) {
        boolean a;
        if (this.f5781m) {
            a = httpUrl.host().equals(this.f5776h);
        } else {
            a = m6534a(httpUrl, this.f5776h);
        }
        if (!a || !m6536b(httpUrl, this.f5777i)) {
            return false;
        }
        if (!this.f5778j || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m6534a(HttpUrl httpUrl, String str) {
        String host = httpUrl.host();
        if (host.equals(str)) {
            return true;
        }
        if (!host.endsWith(str) || host.charAt((host.length() - str.length()) - 1) != '.' || Util.verifyAsIpAddress(host)) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m6536b(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (!encodedPath.startsWith(str) || (!str.endsWith("/") && encodedPath.charAt(str.length()) != '/')) {
            return false;
        }
        return true;
    }

    public static Cookie parse(HttpUrl httpUrl, String str) {
        return m6533a(System.currentTimeMillis(), httpUrl, str);
    }

    /* renamed from: a */
    static Cookie m6533a(long j, HttpUrl httpUrl, String str) {
        long j2;
        String str2;
        String str3;
        int length = str.length();
        int delimiterOffset = Util.delimiterOffset(str, 0, length, ';');
        int delimiterOffset2 = Util.delimiterOffset(str, 0, delimiterOffset, '=');
        if (delimiterOffset2 == delimiterOffset) {
            return null;
        }
        String trimSubstring = Util.trimSubstring(str, 0, delimiterOffset2);
        if (trimSubstring.isEmpty()) {
            return null;
        }
        String trimSubstring2 = Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
        long j3 = HttpDate.MAX_DATE;
        long j4 = -1;
        String str4 = null;
        String str5 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        int i = delimiterOffset + 1;
        while (i < length) {
            int delimiterOffset3 = Util.delimiterOffset(str, i, length, ';');
            int delimiterOffset4 = Util.delimiterOffset(str, i, delimiterOffset3, '=');
            String trimSubstring3 = Util.trimSubstring(str, i, delimiterOffset4);
            String trimSubstring4 = delimiterOffset4 < delimiterOffset3 ? Util.trimSubstring(str, delimiterOffset4 + 1, delimiterOffset3) : "";
            if (trimSubstring3.equalsIgnoreCase("expires")) {
                try {
                    j3 = m6532a(trimSubstring4, 0, trimSubstring4.length());
                    z4 = true;
                    str3 = str4;
                } catch (IllegalArgumentException e) {
                    str3 = str4;
                }
            } else if (trimSubstring3.equalsIgnoreCase("max-age")) {
                try {
                    j4 = m6531a(trimSubstring4);
                    z4 = true;
                    str3 = str4;
                } catch (NumberFormatException e2) {
                    str3 = str4;
                }
            } else if (trimSubstring3.equalsIgnoreCase("domain")) {
                try {
                    str3 = m6535b(trimSubstring4);
                    z3 = false;
                } catch (IllegalArgumentException e3) {
                    str3 = str4;
                }
            } else if (trimSubstring3.equalsIgnoreCase("path")) {
                str5 = trimSubstring4;
                str3 = str4;
            } else if (trimSubstring3.equalsIgnoreCase("secure")) {
                z = true;
                str3 = str4;
            } else if (trimSubstring3.equalsIgnoreCase("httponly")) {
                z2 = true;
                str3 = str4;
            } else {
                str3 = str4;
            }
            String str6 = str3;
            i = delimiterOffset3 + 1;
            j3 = j3;
            str4 = str6;
        }
        if (j4 == Long.MIN_VALUE) {
            j2 = Long.MIN_VALUE;
        } else if (j4 != -1) {
            j2 = (j4 <= 9223372036854775L ? j4 * 1000 : Long.MAX_VALUE) + j;
            if (j2 < j || j2 > HttpDate.MAX_DATE) {
                j2 = HttpDate.MAX_DATE;
            }
        } else {
            j2 = j3;
        }
        if (str4 == null) {
            str4 = httpUrl.host();
        } else if (!m6534a(httpUrl, str4)) {
            return null;
        }
        if (str5 == null || !str5.startsWith("/")) {
            String encodedPath = httpUrl.encodedPath();
            int lastIndexOf = encodedPath.lastIndexOf(47);
            str2 = lastIndexOf != 0 ? encodedPath.substring(0, lastIndexOf) : "/";
        } else {
            str2 = str5;
        }
        return new Cookie(trimSubstring, trimSubstring2, j2, str4, str2, z, z2, z3, z4);
    }

    /* renamed from: a */
    private static long m6532a(String str, int i, int i2) {
        int a = m6530a(str, i, i2, false);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        Matcher matcher = f5772d.matcher(str);
        while (a < i2) {
            int a2 = m6530a(str, a + 1, i2, true);
            matcher.region(a, a2);
            if (i3 == -1 && matcher.usePattern(f5772d).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
                i4 = Integer.parseInt(matcher.group(2));
                i5 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(f5771c).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(f5770b).matches()) {
                i7 = f5770b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i8 == -1 && matcher.usePattern(f5769a).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
            }
            a = m6530a(str, a2 + 1, i2, false);
        }
        if (i8 >= 70 && i8 <= 99) {
            i8 += 1900;
        }
        if (i8 >= 0 && i8 <= 69) {
            i8 += 2000;
        }
        if (i8 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        } else if (i4 < 0 || i4 > 59) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i8);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i3);
            gregorianCalendar.set(12, i4);
            gregorianCalendar.set(13, i5);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    /* renamed from: a */
    private static int m6530a(String str, int i, int i2, boolean z) {
        boolean z2;
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            boolean z3 = (charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'));
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3 == z2) {
                return i3;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private static long m6531a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            } else if (!str.startsWith("-")) {
                return Long.MAX_VALUE;
            } else {
                return Long.MIN_VALUE;
            }
        }
    }

    /* renamed from: b */
    private static String m6535b(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String domainToAscii = Util.domainToAscii(str);
        if (domainToAscii != null) {
            return domainToAscii;
        }
        throw new IllegalArgumentException();
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        ArrayList arrayList;
        List<String> values = headers.values("Set-Cookie");
        ArrayList arrayList2 = null;
        int size = values.size();
        for (int i = 0; i < size; i++) {
            Cookie parse = parse(httpUrl, values.get(i));
            if (parse != null) {
                if (arrayList2 == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = arrayList2;
                }
                arrayList.add(parse);
                arrayList2 = arrayList;
            }
        }
        if (arrayList2 != null) {
            return Collections.unmodifiableList(arrayList2);
        }
        return Collections.emptyList();
    }

    public static final class Builder {

        /* renamed from: a */
        String f5782a;

        /* renamed from: b */
        String f5783b;

        /* renamed from: c */
        long f5784c = HttpDate.MAX_DATE;

        /* renamed from: d */
        String f5785d;

        /* renamed from: e */
        String f5786e = "/";

        /* renamed from: f */
        boolean f5787f;

        /* renamed from: g */
        boolean f5788g;

        /* renamed from: h */
        boolean f5789h;

        /* renamed from: i */
        boolean f5790i;

        public Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("name is not trimmed");
            } else {
                this.f5782a = str;
                return this;
            }
        }

        public Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("value is not trimmed");
            } else {
                this.f5783b = str;
                return this;
            }
        }

        public Builder expiresAt(long j) {
            long j2;
            long j3 = HttpDate.MAX_DATE;
            if (j <= 0) {
                j2 = Long.MIN_VALUE;
            } else {
                j2 = j;
            }
            if (j2 <= HttpDate.MAX_DATE) {
                j3 = j2;
            }
            this.f5784c = j3;
            this.f5789h = true;
            return this;
        }

        public Builder domain(String str) {
            return m6537a(str, false);
        }

        public Builder hostOnlyDomain(String str) {
            return m6537a(str, true);
        }

        /* renamed from: a */
        private Builder m6537a(String str, boolean z) {
            if (str == null) {
                throw new IllegalArgumentException("domain == null");
            }
            String domainToAscii = Util.domainToAscii(str);
            if (domainToAscii == null) {
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            this.f5785d = domainToAscii;
            this.f5790i = z;
            return this;
        }

        public Builder path(String str) {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.f5786e = str;
            return this;
        }

        public Builder secure() {
            this.f5787f = true;
            return this;
        }

        public Builder httpOnly() {
            this.f5788g = true;
            return this;
        }

        public Cookie build() {
            return new Cookie(this);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5773e);
        sb.append('=');
        sb.append(this.f5774f);
        if (this.f5780l) {
            if (this.f5775g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(HttpDate.format(new Date(this.f5775g)));
            }
        }
        if (!this.f5781m) {
            sb.append("; domain=").append(this.f5776h);
        }
        sb.append("; path=").append(this.f5777i);
        if (this.f5778j) {
            sb.append("; secure");
        }
        if (this.f5779k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
