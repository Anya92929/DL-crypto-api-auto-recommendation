package okhttp3;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import okhttp3.internal.Util;
import okio.Buffer;
import org.apache.commons.p009io.IOUtils;

public final class HttpUrl {

    /* renamed from: a */
    private static final char[] f5808a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f5809b;

    /* renamed from: c */
    private final String f5810c;

    /* renamed from: d */
    private final String f5811d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final String f5812e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final int f5813f;

    /* renamed from: g */
    private final List<String> f5814g;

    /* renamed from: h */
    private final List<String> f5815h;

    /* renamed from: i */
    private final String f5816i;

    /* renamed from: j */
    private final String f5817j;

    private HttpUrl(Builder builder) {
        String str = null;
        this.f5809b = builder.f5819a;
        this.f5810c = m6556a(builder.f5820b, false);
        this.f5811d = m6556a(builder.f5821c, false);
        this.f5812e = builder.f5822d;
        this.f5813f = builder.mo10728a();
        this.f5814g = m6559a(builder.f5824f, false);
        this.f5815h = builder.f5825g != null ? m6559a(builder.f5825g, true) : null;
        this.f5816i = builder.f5826h != null ? m6556a(builder.f5826h, false) : str;
        this.f5817j = builder.toString();
    }

    public URL url() {
        try {
            return new URL(this.f5817j);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public URI uri() {
        String builder = newBuilder().mo10734b().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e) {
            try {
                return URI.create(builder.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    public String scheme() {
        return this.f5809b;
    }

    public boolean isHttps() {
        return this.f5809b.equals("https");
    }

    public String encodedUsername() {
        if (this.f5810c.isEmpty()) {
            return "";
        }
        int length = this.f5809b.length() + 3;
        return this.f5817j.substring(length, Util.delimiterOffset(this.f5817j, length, this.f5817j.length(), ":@"));
    }

    public String username() {
        return this.f5810c;
    }

    public String encodedPassword() {
        if (this.f5811d.isEmpty()) {
            return "";
        }
        int indexOf = this.f5817j.indexOf(64);
        return this.f5817j.substring(this.f5817j.indexOf(58, this.f5809b.length() + 3) + 1, indexOf);
    }

    public String password() {
        return this.f5811d;
    }

    public String host() {
        return this.f5812e;
    }

    public int port() {
        return this.f5813f;
    }

    public static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return 443;
        }
        return -1;
    }

    public int pathSize() {
        return this.f5814g.size();
    }

    public String encodedPath() {
        int indexOf = this.f5817j.indexOf(47, this.f5809b.length() + 3);
        return this.f5817j.substring(indexOf, Util.delimiterOffset(this.f5817j, indexOf, this.f5817j.length(), "?#"));
    }

    /* renamed from: a */
    static void m6560a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(list.get(i));
        }
    }

    public List<String> encodedPathSegments() {
        int indexOf = this.f5817j.indexOf(47, this.f5809b.length() + 3);
        int delimiterOffset = Util.delimiterOffset(this.f5817j, indexOf, this.f5817j.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            int i = indexOf + 1;
            indexOf = Util.delimiterOffset(this.f5817j, i, delimiterOffset, (char) IOUtils.DIR_SEPARATOR_UNIX);
            arrayList.add(this.f5817j.substring(i, indexOf));
        }
        return arrayList;
    }

    public List<String> pathSegments() {
        return this.f5814g;
    }

    public String encodedQuery() {
        if (this.f5815h == null) {
            return null;
        }
        int indexOf = this.f5817j.indexOf(63) + 1;
        return this.f5817j.substring(indexOf, Util.delimiterOffset(this.f5817j, indexOf + 1, this.f5817j.length(), '#'));
    }

    /* renamed from: b */
    static void m6566b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* renamed from: a */
    static List<String> m6558a(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public String query() {
        if (this.f5815h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m6566b(sb, this.f5815h);
        return sb.toString();
    }

    public int querySize() {
        if (this.f5815h != null) {
            return this.f5815h.size() / 2;
        }
        return 0;
    }

    public String queryParameter(String str) {
        if (this.f5815h == null) {
            return null;
        }
        int size = this.f5815h.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.f5815h.get(i))) {
                return this.f5815h.get(i + 1);
            }
        }
        return null;
    }

    public Set<String> queryParameterNames() {
        if (this.f5815h == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.f5815h.size();
        for (int i = 0; i < size; i += 2) {
            linkedHashSet.add(this.f5815h.get(i));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public List<String> queryParameterValues(String str) {
        if (this.f5815h == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f5815h.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.f5815h.get(i))) {
                arrayList.add(this.f5815h.get(i + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String queryParameterName(int i) {
        return this.f5815h.get(i * 2);
    }

    public String queryParameterValue(int i) {
        return this.f5815h.get((i * 2) + 1);
    }

    public String encodedFragment() {
        if (this.f5816i == null) {
            return null;
        }
        return this.f5817j.substring(this.f5817j.indexOf(35) + 1);
    }

    public String fragment() {
        return this.f5816i;
    }

    public HttpUrl resolve(String str) {
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f5819a = this.f5809b;
        builder.f5820b = encodedUsername();
        builder.f5821c = encodedPassword();
        builder.f5822d = this.f5812e;
        builder.f5823e = this.f5813f != defaultPort(this.f5809b) ? this.f5813f : -1;
        builder.f5824f.clear();
        builder.f5824f.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.f5826h = encodedFragment();
        return builder;
    }

    public Builder newBuilder(String str) {
        Builder builder = new Builder();
        if (builder.mo10729a(this, str) == Builder.C1767a.SUCCESS) {
            return builder;
        }
        return null;
    }

    public static HttpUrl parse(String str) {
        Builder builder = new Builder();
        if (builder.mo10729a((HttpUrl) null, str) == Builder.C1767a.SUCCESS) {
            return builder.build();
        }
        return null;
    }

    public static HttpUrl get(URL url) {
        return parse(url.toString());
    }

    /* renamed from: b */
    static HttpUrl m6565b(String str) throws MalformedURLException, UnknownHostException {
        Builder builder = new Builder();
        Builder.C1767a a = builder.mo10729a((HttpUrl) null, str);
        switch (a) {
            case SUCCESS:
                return builder.build();
            case INVALID_HOST:
                throw new UnknownHostException("Invalid host: " + str);
            default:
                throw new MalformedURLException("Invalid URL: " + a + " for " + str);
        }
    }

    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f5817j.equals(this.f5817j);
    }

    public int hashCode() {
        return this.f5817j.hashCode();
    }

    public String toString() {
        return this.f5817j;
    }

    public static final class Builder {

        /* renamed from: a */
        String f5819a;

        /* renamed from: b */
        String f5820b = "";

        /* renamed from: c */
        String f5821c = "";

        /* renamed from: d */
        String f5822d;

        /* renamed from: e */
        int f5823e = -1;

        /* renamed from: f */
        final List<String> f5824f = new ArrayList();

        /* renamed from: g */
        List<String> f5825g;

        /* renamed from: h */
        String f5826h;

        /* renamed from: okhttp3.HttpUrl$Builder$a */
        enum C1767a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public Builder() {
            this.f5824f.add("");
        }

        public Builder scheme(String str) {
            if (str == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f5819a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.f5819a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public Builder username(String str) {
            if (str == null) {
                throw new IllegalArgumentException("username == null");
            }
            this.f5820b = HttpUrl.m6555a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public Builder encodedUsername(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedUsername == null");
            }
            this.f5820b = HttpUrl.m6555a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public Builder password(String str) {
            if (str == null) {
                throw new IllegalArgumentException("password == null");
            }
            this.f5821c = HttpUrl.m6555a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public Builder encodedPassword(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPassword == null");
            }
            this.f5821c = HttpUrl.m6555a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public Builder host(String str) {
            if (str == null) {
                throw new IllegalArgumentException("host == null");
            }
            String e = m6579e(str, 0, str.length());
            if (e == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.f5822d = e;
            return this;
        }

        public Builder port(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f5823e = i;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo10728a() {
            return this.f5823e != -1 ? this.f5823e : HttpUrl.defaultPort(this.f5819a);
        }

        public Builder addPathSegment(String str) {
            if (str == null) {
                throw new IllegalArgumentException("pathSegment == null");
            }
            m6571a(str, 0, str.length(), false, false);
            return this;
        }

        public Builder addEncodedPathSegment(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPathSegment == null");
            }
            m6571a(str, 0, str.length(), false, true);
            return this;
        }

        public Builder setPathSegment(int i, String str) {
            if (str == null) {
                throw new IllegalArgumentException("pathSegment == null");
            }
            String a = HttpUrl.m6553a(str, 0, str.length(), " \"<>^`{}|/\\?#", false, false, false, true);
            if (m6574b(a) || m6577c(a)) {
                throw new IllegalArgumentException("unexpected path segment: " + str);
            }
            this.f5824f.set(i, a);
            return this;
        }

        public Builder setEncodedPathSegment(int i, String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPathSegment == null");
            }
            String a = HttpUrl.m6553a(str, 0, str.length(), " \"<>^`{}|/\\?#", true, false, false, true);
            this.f5824f.set(i, a);
            if (!m6574b(a) && !m6577c(a)) {
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        public Builder removePathSegment(int i) {
            this.f5824f.remove(i);
            if (this.f5824f.isEmpty()) {
                this.f5824f.add("");
            }
            return this;
        }

        public Builder encodedPath(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPath == null");
            } else if (!str.startsWith("/")) {
                throw new IllegalArgumentException("unexpected encodedPath: " + str);
            } else {
                m6570a(str, 0, str.length());
                return this;
            }
        }

        public Builder query(String str) {
            this.f5825g = str != null ? HttpUrl.m6558a(HttpUrl.m6555a(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public Builder encodedQuery(String str) {
            this.f5825g = str != null ? HttpUrl.m6558a(HttpUrl.m6555a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public Builder addQueryParameter(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (this.f5825g == null) {
                this.f5825g = new ArrayList();
            }
            this.f5825g.add(HttpUrl.m6555a(str, " \"'<>#&=", false, false, true, true));
            this.f5825g.add(str2 != null ? HttpUrl.m6555a(str2, " \"'<>#&=", false, false, true, true) : null);
            return this;
        }

        public Builder addEncodedQueryParameter(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("encodedName == null");
            }
            if (this.f5825g == null) {
                this.f5825g = new ArrayList();
            }
            this.f5825g.add(HttpUrl.m6555a(str, " \"'<>#&=", true, false, true, true));
            this.f5825g.add(str2 != null ? HttpUrl.m6555a(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public Builder setQueryParameter(String str, String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public Builder setEncodedQueryParameter(String str, String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public Builder removeAllQueryParameters(String str) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (this.f5825g != null) {
                m6569a(HttpUrl.m6555a(str, " \"'<>#&=", false, false, true, true));
            }
            return this;
        }

        public Builder removeAllEncodedQueryParameters(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedName == null");
            }
            if (this.f5825g != null) {
                m6569a(HttpUrl.m6555a(str, " \"'<>#&=", true, false, true, true));
            }
            return this;
        }

        /* renamed from: a */
        private void m6569a(String str) {
            for (int size = this.f5825g.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.f5825g.get(size))) {
                    this.f5825g.remove(size + 1);
                    this.f5825g.remove(size);
                    if (this.f5825g.isEmpty()) {
                        this.f5825g = null;
                        return;
                    }
                }
            }
        }

        public Builder fragment(String str) {
            this.f5826h = str != null ? HttpUrl.m6555a(str, "", false, false, false, false) : null;
            return this;
        }

        public Builder encodedFragment(String str) {
            this.f5826h = str != null ? HttpUrl.m6555a(str, "", true, false, false, false) : null;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public Builder mo10734b() {
            int size = this.f5824f.size();
            for (int i = 0; i < size; i++) {
                this.f5824f.set(i, HttpUrl.m6555a(this.f5824f.get(i), "[]", true, true, false, true));
            }
            if (this.f5825g != null) {
                int size2 = this.f5825g.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f5825g.get(i2);
                    if (str != null) {
                        this.f5825g.set(i2, HttpUrl.m6555a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            if (this.f5826h != null) {
                this.f5826h = HttpUrl.m6555a(this.f5826h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public HttpUrl build() {
            if (this.f5819a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f5822d != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5819a);
            sb.append("://");
            if (!this.f5820b.isEmpty() || !this.f5821c.isEmpty()) {
                sb.append(this.f5820b);
                if (!this.f5821c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f5821c);
                }
                sb.append('@');
            }
            if (this.f5822d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f5822d);
                sb.append(']');
            } else {
                sb.append(this.f5822d);
            }
            int a = mo10728a();
            if (a != HttpUrl.defaultPort(this.f5819a)) {
                sb.append(':');
                sb.append(a);
            }
            HttpUrl.m6560a(sb, this.f5824f);
            if (this.f5825g != null) {
                sb.append('?');
                HttpUrl.m6566b(sb, this.f5825g);
            }
            if (this.f5826h != null) {
                sb.append('#');
                sb.append(this.f5826h);
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1767a mo10729a(HttpUrl httpUrl, String str) {
            int i;
            int skipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(str, 0, str.length());
            int skipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, str.length());
            if (m6573b(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace) != -1) {
                if (str.regionMatches(true, skipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.f5819a = "https";
                    skipLeadingAsciiWhitespace += "https:".length();
                } else if (!str.regionMatches(true, skipLeadingAsciiWhitespace, "http:", 0, 5)) {
                    return C1767a.UNSUPPORTED_SCHEME;
                } else {
                    this.f5819a = "http";
                    skipLeadingAsciiWhitespace += "http:".length();
                }
            } else if (httpUrl == null) {
                return C1767a.MISSING_SCHEME;
            } else {
                this.f5819a = httpUrl.f5809b;
            }
            boolean z = false;
            boolean z2 = false;
            int c = m6575c(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            if (c >= 2 || httpUrl == null || !httpUrl.f5809b.equals(this.f5819a)) {
                int i2 = skipLeadingAsciiWhitespace + c;
                while (true) {
                    boolean z3 = z2;
                    boolean z4 = z;
                    int i3 = i2;
                    int delimiterOffset = Util.delimiterOffset(str, i3, skipTrailingAsciiWhitespace, "@/\\?#");
                    switch (delimiterOffset != skipTrailingAsciiWhitespace ? str.charAt(delimiterOffset) : 65535) {
                        case 65535:
                        case '#':
                        case '/':
                        case '?':
                        case '\\':
                            int d = m6578d(str, i3, delimiterOffset);
                            if (d + 1 < delimiterOffset) {
                                this.f5822d = m6579e(str, i3, d);
                                this.f5823e = m6581g(str, d + 1, delimiterOffset);
                                if (this.f5823e == -1) {
                                    return C1767a.INVALID_PORT;
                                }
                            } else {
                                this.f5822d = m6579e(str, i3, d);
                                this.f5823e = HttpUrl.defaultPort(this.f5819a);
                            }
                            if (this.f5822d != null) {
                                skipLeadingAsciiWhitespace = delimiterOffset;
                                break;
                            } else {
                                return C1767a.INVALID_HOST;
                            }
                        case '@':
                            if (!z3) {
                                int delimiterOffset2 = Util.delimiterOffset(str, i3, delimiterOffset, ':');
                                String a = HttpUrl.m6553a(str, i3, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (z4) {
                                    a = this.f5820b + "%40" + a;
                                }
                                this.f5820b = a;
                                if (delimiterOffset2 != delimiterOffset) {
                                    z3 = true;
                                    this.f5821c = HttpUrl.m6553a(str, delimiterOffset2 + 1, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                }
                                z4 = true;
                            } else {
                                this.f5821c += "%40" + HttpUrl.m6553a(str, i3, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            }
                            i2 = delimiterOffset + 1;
                            z2 = z3;
                            continue;
                        default:
                            z2 = z3;
                            i2 = i3;
                            continue;
                    }
                    z = z4;
                }
            } else {
                this.f5820b = httpUrl.encodedUsername();
                this.f5821c = httpUrl.encodedPassword();
                this.f5822d = httpUrl.f5812e;
                this.f5823e = httpUrl.f5813f;
                this.f5824f.clear();
                this.f5824f.addAll(httpUrl.encodedPathSegments());
                if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str.charAt(skipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int delimiterOffset3 = Util.delimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace, "?#");
            m6570a(str, skipLeadingAsciiWhitespace, delimiterOffset3);
            if (delimiterOffset3 >= skipTrailingAsciiWhitespace || str.charAt(delimiterOffset3) != '?') {
                i = delimiterOffset3;
            } else {
                i = Util.delimiterOffset(str, delimiterOffset3, skipTrailingAsciiWhitespace, '#');
                this.f5825g = HttpUrl.m6558a(HttpUrl.m6553a(str, delimiterOffset3 + 1, i, " \"'<>#", true, false, true, true));
            }
            if (i < skipTrailingAsciiWhitespace && str.charAt(i) == '#') {
                this.f5826h = HttpUrl.m6553a(str, i + 1, skipTrailingAsciiWhitespace, "", true, false, false, false);
            }
            return C1767a.SUCCESS;
        }

        /* renamed from: a */
        private void m6570a(String str, int i, int i2) {
            if (i != i2) {
                char charAt = str.charAt(i);
                if (charAt == '/' || charAt == '\\') {
                    this.f5824f.clear();
                    this.f5824f.add("");
                    i++;
                } else {
                    this.f5824f.set(this.f5824f.size() - 1, "");
                }
                int i3 = i;
                while (i3 < i2) {
                    int delimiterOffset = Util.delimiterOffset(str, i3, i2, "/\\");
                    boolean z = delimiterOffset < i2;
                    m6571a(str, i3, delimiterOffset, z, true);
                    if (z) {
                        delimiterOffset++;
                    }
                    i3 = delimiterOffset;
                }
            }
        }

        /* renamed from: a */
        private void m6571a(String str, int i, int i2, boolean z, boolean z2) {
            String a = HttpUrl.m6553a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (!m6574b(a)) {
                if (m6577c(a)) {
                    m6576c();
                    return;
                }
                if (this.f5824f.get(this.f5824f.size() - 1).isEmpty()) {
                    this.f5824f.set(this.f5824f.size() - 1, a);
                } else {
                    this.f5824f.add(a);
                }
                if (z) {
                    this.f5824f.add("");
                }
            }
        }

        /* renamed from: b */
        private boolean m6574b(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: c */
        private boolean m6577c(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: c */
        private void m6576c() {
            if (!this.f5824f.remove(this.f5824f.size() - 1).isEmpty() || this.f5824f.isEmpty()) {
                this.f5824f.add("");
            } else {
                this.f5824f.set(this.f5824f.size() - 1, "");
            }
        }

        /* renamed from: b */
        private static int m6573b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return -1;
            }
            int i3 = i + 1;
            while (i3 < i2) {
                char charAt2 = str.charAt(i3);
                if ((charAt2 >= 'a' && charAt2 <= 'z') || ((charAt2 >= 'A' && charAt2 <= 'Z') || ((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                    i3++;
                } else if (charAt2 == ':') {
                    return i3;
                } else {
                    return -1;
                }
            }
            return -1;
        }

        /* renamed from: c */
        private static int m6575c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
            if (r0 >= r5) goto L_0x000a;
         */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int m6578d(java.lang.String r3, int r4, int r5) {
            /*
                r0 = r4
            L_0x0001:
                if (r0 >= r5) goto L_0x001a
                char r1 = r3.charAt(r0)
                switch(r1) {
                    case 58: goto L_0x001b;
                    case 91: goto L_0x000d;
                    default: goto L_0x000a;
                }
            L_0x000a:
                int r0 = r0 + 1
                goto L_0x0001
            L_0x000d:
                int r0 = r0 + 1
                if (r0 >= r5) goto L_0x000a
                char r1 = r3.charAt(r0)
                r2 = 93
                if (r1 != r2) goto L_0x000d
                goto L_0x000a
            L_0x001a:
                r0 = r5
            L_0x001b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.m6578d(java.lang.String, int, int):int");
        }

        /* renamed from: e */
        private static String m6579e(String str, int i, int i2) {
            String a = HttpUrl.m6554a(str, i, i2, false);
            if (!a.startsWith("[") || !a.endsWith("]")) {
                return Util.domainToAscii(a);
            }
            InetAddress f = m6580f(a, 1, a.length() - 1);
            if (f == null) {
                return null;
            }
            byte[] address = f.getAddress();
            if (address.length == 16) {
                return m6568a(address);
            }
            throw new AssertionError();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            return null;
         */
        /* renamed from: f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.net.InetAddress m6580f(java.lang.String r12, int r13, int r14) {
            /*
                r11 = 1
                r7 = -1
                r3 = 0
                r5 = 0
                r0 = 16
                byte[] r8 = new byte[r0]
                r0 = r13
                r4 = r7
                r1 = r7
                r2 = r5
            L_0x000c:
                if (r0 >= r14) goto L_0x002b
                int r6 = r8.length
                if (r2 != r6) goto L_0x0013
                r0 = r3
            L_0x0012:
                return r0
            L_0x0013:
                int r6 = r0 + 2
                if (r6 > r14) goto L_0x0032
                java.lang.String r6 = "::"
                r9 = 2
                boolean r6 = r12.regionMatches(r0, r6, r5, r9)
                if (r6 == 0) goto L_0x0032
                if (r1 == r7) goto L_0x0024
                r0 = r3
                goto L_0x0012
            L_0x0024:
                int r0 = r0 + 2
                int r1 = r2 + 2
                if (r0 != r14) goto L_0x00a1
                r2 = r1
            L_0x002b:
                int r0 = r8.length
                if (r2 == r0) goto L_0x0094
                if (r1 != r7) goto L_0x0085
                r0 = r3
                goto L_0x0012
            L_0x0032:
                if (r2 == 0) goto L_0x003e
                java.lang.String r6 = ":"
                boolean r6 = r12.regionMatches(r0, r6, r5, r11)
                if (r6 == 0) goto L_0x0055
                int r0 = r0 + 1
            L_0x003e:
                r4 = r5
                r6 = r0
            L_0x0040:
                if (r6 >= r14) goto L_0x004c
                char r9 = r12.charAt(r6)
                int r9 = okhttp3.HttpUrl.m6552a((char) r9)
                if (r9 != r7) goto L_0x006c
            L_0x004c:
                int r9 = r6 - r0
                if (r9 == 0) goto L_0x0053
                r10 = 4
                if (r9 <= r10) goto L_0x0072
            L_0x0053:
                r0 = r3
                goto L_0x0012
            L_0x0055:
                java.lang.String r6 = "."
                boolean r0 = r12.regionMatches(r0, r6, r5, r11)
                if (r0 == 0) goto L_0x006a
                int r0 = r2 + -2
                boolean r0 = m6572a((java.lang.String) r12, (int) r4, (int) r14, (byte[]) r8, (int) r0)
                if (r0 != 0) goto L_0x0067
                r0 = r3
                goto L_0x0012
            L_0x0067:
                int r2 = r2 + 2
                goto L_0x002b
            L_0x006a:
                r0 = r3
                goto L_0x0012
            L_0x006c:
                int r4 = r4 << 4
                int r4 = r4 + r9
                int r6 = r6 + 1
                goto L_0x0040
            L_0x0072:
                int r9 = r2 + 1
                int r10 = r4 >>> 8
                r10 = r10 & 255(0xff, float:3.57E-43)
                byte r10 = (byte) r10
                r8[r2] = r10
                int r2 = r9 + 1
                r4 = r4 & 255(0xff, float:3.57E-43)
                byte r4 = (byte) r4
                r8[r9] = r4
                r4 = r0
                r0 = r6
                goto L_0x000c
            L_0x0085:
                int r0 = r8.length
                int r3 = r2 - r1
                int r0 = r0 - r3
                int r3 = r2 - r1
                java.lang.System.arraycopy(r8, r1, r8, r0, r3)
                int r0 = r8.length
                int r0 = r0 - r2
                int r0 = r0 + r1
                java.util.Arrays.fill(r8, r1, r0, r5)
            L_0x0094:
                java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r8)     // Catch:{ UnknownHostException -> 0x009a }
                goto L_0x0012
            L_0x009a:
                r0 = move-exception
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x00a1:
                r2 = r1
                goto L_0x003e
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.m6580f(java.lang.String, int, int):java.net.InetAddress");
        }

        /* renamed from: a */
        private static boolean m6572a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i;
            int i5 = i3;
            while (i4 < i2) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i3) {
                    if (str.charAt(i4) != '.') {
                        return false;
                    }
                    i4++;
                }
                int i6 = 0;
                int i7 = i4;
                while (i7 < i2) {
                    char charAt = str.charAt(i7);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if (i6 == 0 && i4 != i7) {
                        return false;
                    } else {
                        i6 = ((i6 * 10) + charAt) - 48;
                        if (i6 > 255) {
                            return false;
                        }
                        i7++;
                    }
                }
                if (i7 - i4 == 0) {
                    return false;
                }
                bArr[i5] = (byte) i6;
                i5++;
                i4 = i7;
            }
            if (i5 != i3 + 4) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        private static String m6568a(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i4 < bArr.length) {
                int i5 = i4;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i4;
                if (i6 > i2) {
                    i2 = i6;
                    i3 = i4;
                }
                i4 = i5 + 2;
            }
            Buffer buffer = new Buffer();
            while (i < bArr.length) {
                if (i == i3) {
                    buffer.writeByte(58);
                    i += i2;
                    if (i == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.writeHexadecimalUnsignedLong((long) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                    i += 2;
                }
            }
            return buffer.readUtf8();
        }

        /* renamed from: g */
        private static int m6581g(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(HttpUrl.m6553a(str, i, i2, "", false, false, false, true));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    /* renamed from: a */
    static String m6556a(String str, boolean z) {
        return m6554a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    private List<String> m6559a(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? m6556a(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static String m6554a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                m6562a(buffer, str, i3, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m6562a(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt != 37 || i3 + 2 >= i2) {
                if (codePointAt == 43 && z) {
                    buffer.writeByte(32);
                }
                buffer.writeUtf8CodePoint(codePointAt);
            } else {
                int a = m6552a(str.charAt(i3 + 1));
                int a2 = m6552a(str.charAt(i3 + 2));
                if (!(a == -1 || a2 == -1)) {
                    buffer.writeByte((a << 4) + a2);
                    i3 += 2;
                }
                buffer.writeUtf8CodePoint(codePointAt);
            }
            i3 += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static boolean m6563a(String str, int i, int i2) {
        return i + 2 < i2 && str.charAt(i) == '%' && m6552a(str.charAt(i + 1)) != -1 && m6552a(str.charAt(i + 2)) != -1;
    }

    /* renamed from: a */
    static int m6552a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return (c - 'A') + 10;
    }

    /* renamed from: a */
    static String m6553a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !m6563a(str, i3, i2)))) || (codePointAt == 43 && z3)))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                m6561a(buffer, str, i3, i2, str2, z, z2, z3, z4);
                return buffer.readUtf8();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m6561a(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    buffer.writeUtf8(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !m6563a(str, i, i2)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(codePointAt);
                    while (!buffer2.exhausted()) {
                        byte readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        buffer.writeByte((int) f5808a[(readByte >> 4) & 15]);
                        buffer.writeByte((int) f5808a[readByte & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static String m6555a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m6553a(str, 0, str.length(), str2, z, z2, z3, z4);
    }
}
