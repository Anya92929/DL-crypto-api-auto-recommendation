package cmn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: cmn.bg */
public final class C0739bg {

    /* renamed from: a */
    private static final List f1820a = Collections.unmodifiableList(Arrays.asList(new String[]{"ggpht.com", "googleusercontent.com"}));

    /* renamed from: a */
    public static String m3252a(String str, int i, C0740bh bhVar) {
        URI a = m3253a(str);
        if (a == null) {
            return str;
        }
        if (i > 1600) {
            i = 1600;
        }
        String b = m3255b(a);
        if (i > 0) {
            b = b + bhVar.mo3420a(i);
        }
        return b;
    }

    /* renamed from: a */
    private static URI m3253a(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            URI uri = new URI(str);
            if (m3254a(uri)) {
                return uri;
            }
            return null;
        } catch (URISyntaxException e) {
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m3254a(URI uri) {
        if (uri.getPath().matches(".*=(s|w|h)[0-9]+(-c)?$")) {
            return true;
        }
        if (uri.getHost() == null) {
            return false;
        }
        if (uri.getHost().endsWith("jokes-app.com") && uri.getPath().startsWith("/identicons/")) {
            return true;
        }
        for (String endsWith : f1820a) {
            if (uri.getHost().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static String m3255b(URI uri) {
        try {
            return new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), uri.getPath().replaceFirst("=(s|w|h)[0-9]+(-c)?$", ""), uri.getQuery(), uri.getFragment()).toString();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
