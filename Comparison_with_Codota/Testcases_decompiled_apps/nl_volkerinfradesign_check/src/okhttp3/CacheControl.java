package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.http.HeaderParser;

public final class CacheControl {
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();

    /* renamed from: a */
    String f5726a;

    /* renamed from: b */
    private final boolean f5727b;

    /* renamed from: c */
    private final boolean f5728c;

    /* renamed from: d */
    private final int f5729d;

    /* renamed from: e */
    private final int f5730e;

    /* renamed from: f */
    private final boolean f5731f;

    /* renamed from: g */
    private final boolean f5732g;

    /* renamed from: h */
    private final boolean f5733h;

    /* renamed from: i */
    private final int f5734i;

    /* renamed from: j */
    private final int f5735j;

    /* renamed from: k */
    private final boolean f5736k;

    /* renamed from: l */
    private final boolean f5737l;

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.f5727b = z;
        this.f5728c = z2;
        this.f5729d = i;
        this.f5730e = i2;
        this.f5731f = z3;
        this.f5732g = z4;
        this.f5733h = z5;
        this.f5734i = i3;
        this.f5735j = i4;
        this.f5736k = z6;
        this.f5737l = z7;
        this.f5726a = str;
    }

    private CacheControl(Builder builder) {
        this.f5727b = builder.f5738a;
        this.f5728c = builder.f5739b;
        this.f5729d = builder.f5740c;
        this.f5730e = -1;
        this.f5731f = false;
        this.f5732g = false;
        this.f5733h = false;
        this.f5734i = builder.f5741d;
        this.f5735j = builder.f5742e;
        this.f5736k = builder.f5743f;
        this.f5737l = builder.f5744g;
    }

    public boolean noCache() {
        return this.f5727b;
    }

    public boolean noStore() {
        return this.f5728c;
    }

    public int maxAgeSeconds() {
        return this.f5729d;
    }

    public int sMaxAgeSeconds() {
        return this.f5730e;
    }

    public boolean isPrivate() {
        return this.f5731f;
    }

    public boolean isPublic() {
        return this.f5732g;
    }

    public boolean mustRevalidate() {
        return this.f5733h;
    }

    public int maxStaleSeconds() {
        return this.f5734i;
    }

    public int minFreshSeconds() {
        return this.f5735j;
    }

    public boolean onlyIfCached() {
        return this.f5736k;
    }

    public boolean noTransform() {
        return this.f5737l;
    }

    public static CacheControl parse(Headers headers) {
        boolean z;
        String str;
        String str2;
        boolean z2 = false;
        boolean z3 = false;
        int i = -1;
        int i2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = true;
        int size = headers.size();
        int i5 = 0;
        String str3 = null;
        while (true) {
            z = z2;
            if (i5 >= size) {
                break;
            }
            String name = headers.name(i5);
            String value = headers.value(i5);
            if (name.equalsIgnoreCase("Cache-Control")) {
                if (str3 != null) {
                    z9 = false;
                } else {
                    str3 = value;
                }
            } else if (name.equalsIgnoreCase("Pragma")) {
                z9 = false;
            } else {
                z2 = z;
                i5++;
            }
            z2 = z;
            int i6 = 0;
            while (i6 < value.length()) {
                int skipUntil = HeaderParser.skipUntil(value, i6, "=,;");
                String trim = value.substring(i6, skipUntil).trim();
                if (skipUntil == value.length() || value.charAt(skipUntil) == ',' || value.charAt(skipUntil) == ';') {
                    i6 = skipUntil + 1;
                    str2 = null;
                } else {
                    int skipWhitespace = HeaderParser.skipWhitespace(value, skipUntil + 1);
                    if (skipWhitespace >= value.length() || value.charAt(skipWhitespace) != '\"') {
                        int skipUntil2 = HeaderParser.skipUntil(value, skipWhitespace, ",;");
                        String trim2 = value.substring(skipWhitespace, skipUntil2).trim();
                        i6 = skipUntil2;
                        str2 = trim2;
                    } else {
                        int i7 = skipWhitespace + 1;
                        int skipUntil3 = HeaderParser.skipUntil(value, i7, "\"");
                        String substring = value.substring(i7, skipUntil3);
                        i6 = skipUntil3 + 1;
                        str2 = substring;
                    }
                }
                if ("no-cache".equalsIgnoreCase(trim)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(trim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(trim)) {
                    i = HeaderParser.parseSeconds(str2, -1);
                } else if ("s-maxage".equalsIgnoreCase(trim)) {
                    i2 = HeaderParser.parseSeconds(str2, -1);
                } else if ("private".equalsIgnoreCase(trim)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(trim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(trim)) {
                    i3 = HeaderParser.parseSeconds(str2, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(trim)) {
                    i4 = HeaderParser.parseSeconds(str2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(trim)) {
                    z8 = true;
                }
            }
            i5++;
        }
        if (!z9) {
            str = null;
        } else {
            str = str3;
        }
        return new CacheControl(z, z3, i, i2, z4, z5, z6, i3, i4, z7, z8, str);
    }

    public String toString() {
        String str = this.f5726a;
        if (str != null) {
            return str;
        }
        String a = m6510a();
        this.f5726a = a;
        return a;
    }

    /* renamed from: a */
    private String m6510a() {
        StringBuilder sb = new StringBuilder();
        if (this.f5727b) {
            sb.append("no-cache, ");
        }
        if (this.f5728c) {
            sb.append("no-store, ");
        }
        if (this.f5729d != -1) {
            sb.append("max-age=").append(this.f5729d).append(", ");
        }
        if (this.f5730e != -1) {
            sb.append("s-maxage=").append(this.f5730e).append(", ");
        }
        if (this.f5731f) {
            sb.append("private, ");
        }
        if (this.f5732g) {
            sb.append("public, ");
        }
        if (this.f5733h) {
            sb.append("must-revalidate, ");
        }
        if (this.f5734i != -1) {
            sb.append("max-stale=").append(this.f5734i).append(", ");
        }
        if (this.f5735j != -1) {
            sb.append("min-fresh=").append(this.f5735j).append(", ");
        }
        if (this.f5736k) {
            sb.append("only-if-cached, ");
        }
        if (this.f5737l) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static final class Builder {

        /* renamed from: a */
        boolean f5738a;

        /* renamed from: b */
        boolean f5739b;

        /* renamed from: c */
        int f5740c = -1;

        /* renamed from: d */
        int f5741d = -1;

        /* renamed from: e */
        int f5742e = -1;

        /* renamed from: f */
        boolean f5743f;

        /* renamed from: g */
        boolean f5744g;

        public Builder noCache() {
            this.f5738a = true;
            return this;
        }

        public Builder noStore() {
            this.f5739b = true;
            return this;
        }

        public Builder maxAge(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxAge < 0: " + i);
            }
            long seconds = timeUnit.toSeconds((long) i);
            this.f5740c = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public Builder maxStale(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long seconds = timeUnit.toSeconds((long) i);
            this.f5741d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public Builder minFresh(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("minFresh < 0: " + i);
            }
            long seconds = timeUnit.toSeconds((long) i);
            this.f5742e = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public Builder onlyIfCached() {
            this.f5743f = true;
            return this;
        }

        public Builder noTransform() {
            this.f5744g = true;
            return this;
        }

        public CacheControl build() {
            return new CacheControl(this);
        }
    }
}
