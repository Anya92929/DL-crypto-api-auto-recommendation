package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType {

    /* renamed from: a */
    private static final Pattern f5833a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b */
    private static final Pattern f5834b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c */
    private final String f5835c;

    /* renamed from: d */
    private final String f5836d;

    /* renamed from: e */
    private final String f5837e;

    /* renamed from: f */
    private final String f5838f;

    private MediaType(String str, String str2, String str3, String str4) {
        this.f5835c = str;
        this.f5836d = str2;
        this.f5837e = str3;
        this.f5838f = str4;
    }

    public static MediaType parse(String str) {
        String group;
        Matcher matcher = f5833a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f5834b.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group2 = matcher2.group(1);
            if (group2 != null && group2.equalsIgnoreCase("charset")) {
                if (matcher2.group(2) != null) {
                    group = matcher2.group(2);
                } else {
                    group = matcher2.group(3);
                }
                if (str2 == null || group.equalsIgnoreCase(str2)) {
                    str2 = group;
                } else {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
        }
        return new MediaType(str, lowerCase, lowerCase2, str2);
    }

    public String type() {
        return this.f5836d;
    }

    public String subtype() {
        return this.f5837e;
    }

    public Charset charset() {
        if (this.f5838f != null) {
            return Charset.forName(this.f5838f);
        }
        return null;
    }

    public Charset charset(Charset charset) {
        return this.f5838f != null ? Charset.forName(this.f5838f) : charset;
    }

    public String toString() {
        return this.f5835c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f5835c.equals(this.f5835c);
    }

    public int hashCode() {
        return this.f5835c.hashCode();
    }
}
