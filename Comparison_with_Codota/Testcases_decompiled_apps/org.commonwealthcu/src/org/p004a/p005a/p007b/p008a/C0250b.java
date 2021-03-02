package org.p004a.p005a.p007b.p008a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Stack;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0297c;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.C0573v;
import org.p004a.p005a.p007b.p012e.C0284d;
import org.p004a.p005a.p014d.p017c.C0315b;
import org.p004a.p005a.p014d.p017c.C0316c;
import org.p004a.p005a.p014d.p017c.C0319f;
import org.p004a.p005a.p014d.p019e.C0327d;
import org.p004a.p005a.p014d.p019e.C0328e;
import org.p004a.p005a.p022f.C0380e;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p036l.C0552d;
import org.p004a.p005a.p037m.C0562a;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.b.a.b */
public class C0250b {

    /* renamed from: a */
    private boolean f66a;

    /* renamed from: b */
    private C0565n f67b;

    /* renamed from: c */
    private InetAddress f68c;

    /* renamed from: d */
    private boolean f69d = true;

    /* renamed from: e */
    private String f70e;

    /* renamed from: f */
    private boolean f71f = true;

    /* renamed from: g */
    private boolean f72g = true;

    /* renamed from: h */
    private boolean f73h;

    /* renamed from: i */
    private int f74i = 50;

    /* renamed from: j */
    private boolean f75j = true;

    /* renamed from: k */
    private Collection f76k;

    /* renamed from: l */
    private Collection f77l;

    /* renamed from: m */
    private int f78m = -1;

    /* renamed from: n */
    private int f79n = -1;

    /* renamed from: o */
    private int f80o = -1;

    C0250b() {
    }

    /* renamed from: a */
    public static int m77a(int i, Object obj) {
        return (obj != null ? obj.hashCode() : 0) + (i * 37);
    }

    /* renamed from: a */
    public static int m78a(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    /* renamed from: a */
    public static int m79a(int i, boolean z) {
        return (z ? 1 : 0) + (i * 37);
    }

    /* renamed from: a */
    public static long m80a(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    /* renamed from: a */
    public static Typeface m81a(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
    }

    /* renamed from: a */
    public static CharSequence m82a(CharSequence charSequence, String str) {
        if (charSequence == null) {
            throw new IllegalArgumentException(str + " may not be null");
        } else if (!m96a(charSequence)) {
            return charSequence;
        } else {
            throw new IllegalArgumentException(str + " may not be empty");
        }
    }

    /* renamed from: a */
    public static Object m83a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Cloneable) {
            try {
                try {
                    return obj.getClass().getMethod("clone", (Class[]) null).invoke(obj, (Object[]) null);
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof CloneNotSupportedException) {
                        throw ((CloneNotSupportedException) cause);
                    }
                    throw new Error("Unexpected exception", cause);
                } catch (IllegalAccessException e2) {
                    throw new IllegalAccessError(e2.getMessage());
                }
            } catch (NoSuchMethodException e3) {
                throw new NoSuchMethodError(e3.getMessage());
            }
        } else {
            throw new CloneNotSupportedException();
        }
    }

    /* renamed from: a */
    public static Object m84a(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    /* renamed from: a */
    public static String m85a(C0546k kVar, Charset charset) {
        boolean z = false;
        String str = null;
        m84a((Object) kVar, "Entity");
        InputStream f = kVar.mo4955f();
        if (f != null) {
            try {
                if (kVar.mo5116c() <= 2147483647L) {
                    z = true;
                }
                m95a(z, "HTTP entity too large to be buffered in memory");
                int c = (int) kVar.mo5116c();
                if (c < 0) {
                    c = 4096;
                }
                C0380e a = C0380e.m469a(kVar);
                Charset b = a != null ? a.mo5122b() : null;
                if (b == null) {
                    b = null;
                }
                if (b == null) {
                    b = C0552d.f622a;
                }
                InputStreamReader inputStreamReader = new InputStreamReader(f, b);
                C0563b bVar = new C0563b(c);
                char[] cArr = new char[1024];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    bVar.mo5431a(cArr, 0, read);
                }
                str = bVar.toString();
                f.close();
            } catch (UnsupportedCharsetException e) {
                throw new UnsupportedEncodingException(e.getMessage());
            } catch (Throwable th) {
                f.close();
                throw th;
            }
        }
        return str;
    }

    /* renamed from: a */
    public static String m86a(byte[] bArr, int i, int i2) {
        m84a((Object) bArr, "Input");
        try {
            return new String(bArr, 0, i2, C0297c.f130b.name());
        } catch (UnsupportedEncodingException e) {
            throw new Error("ASCII not supported");
        }
    }

    /* renamed from: a */
    public static URI m87a(URI uri) {
        m84a((Object) uri, "URI");
        if (uri.isOpaque()) {
            return uri;
        }
        C0284d dVar = new C0284d(uri);
        if (dVar.mo4924b() != null) {
            dVar.mo4925b((String) null);
        }
        if (m96a((CharSequence) dVar.mo4928d())) {
            dVar.mo4929d("/");
        }
        if (dVar.mo4926c() != null) {
            dVar.mo4927c(dVar.mo4926c().toLowerCase(Locale.ENGLISH));
        }
        dVar.mo4930e((String) null);
        return dVar.mo4921a();
    }

    /* renamed from: a */
    public static URI m88a(URI uri, URI uri2) {
        m84a((Object) uri, "Base URI");
        m84a((Object) uri2, "Reference URI");
        String uri3 = uri2.toString();
        if (uri3.startsWith("?")) {
            String uri4 = uri.toString();
            if (uri4.indexOf(63) >= 0) {
                uri4 = uri4.substring(0, uri4.indexOf(63));
            }
            return URI.create(uri4 + uri2.toString());
        }
        boolean z = uri3.length() == 0;
        if (z) {
            uri2 = URI.create("#");
        }
        URI resolve = uri.resolve(uri2);
        if (z) {
            String uri5 = resolve.toString();
            resolve = URI.create(uri5.substring(0, uri5.indexOf(35)));
        }
        return m109c(resolve);
    }

    /* renamed from: a */
    public static URI m89a(URI uri, C0565n nVar, boolean z) {
        m84a((Object) uri, "URI");
        if (uri.isOpaque()) {
            return uri;
        }
        C0284d dVar = new C0284d(uri);
        if (nVar != null) {
            dVar.mo4923a(nVar.mo5443c());
            dVar.mo4927c(nVar.mo5441a());
            dVar.mo4922a(nVar.mo5442b());
        } else {
            dVar.mo4923a((String) null);
            dVar.mo4927c((String) null);
            dVar.mo4922a(-1);
        }
        if (z) {
            dVar.mo4930e((String) null);
        }
        if (m96a((CharSequence) dVar.mo4928d())) {
            dVar.mo4929d("/");
        }
        return dVar.mo4921a();
    }

    /* renamed from: a */
    public static Collection m90a(Collection collection, String str) {
        if (collection == null) {
            throw new IllegalArgumentException(str + " may not be null");
        } else if (!collection.isEmpty()) {
            return collection;
        } else {
            throw new IllegalArgumentException(str + " may not be empty");
        }
    }

    /* renamed from: a */
    public static C0249a m91a(C0544b bVar) {
        C0250b f = C0249a.m71f();
        f.f80o = bVar.mo5389a("http.socket.timeout", 0);
        f.f69d = bVar.mo5390a("http.connection.stalecheck", true);
        f.f79n = bVar.mo5389a("http.connection.timeout", 0);
        f.f66a = bVar.mo5390a("http.protocol.expect-continue", false);
        f.f67b = (C0565n) bVar.mo5196a("http.route.default-proxy");
        f.f68c = (InetAddress) bVar.mo5196a("http.route.local-address");
        f.f77l = (Collection) bVar.mo5196a("http.auth.proxy-scheme-pref");
        f.f76k = (Collection) bVar.mo5196a("http.auth.target-scheme-pref");
        f.f75j = bVar.mo5390a("http.protocol.handle-authentication", true);
        f.f73h = bVar.mo5390a("http.protocol.allow-circular-redirects", false);
        f.f78m = bVar.mo5389a("http.conn-manager.timeout", 0);
        f.f70e = (String) bVar.mo5196a("http.protocol.cookie-policy");
        f.f74i = bVar.mo5389a("http.protocol.max-redirects", 50);
        f.f71f = bVar.mo5390a("http.protocol.handle-redirects", true);
        f.f72g = !bVar.mo5390a("http.protocol.reject-relative-redirect", false);
        return f.mo4882a();
    }

    /* renamed from: a */
    public static void m92a(Context context, View view) {
        try {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    m92a(context, viewGroup.getChildAt(i));
                }
            } else if (view instanceof TextView) {
                ((TextView) view).setTypeface(m81a(context));
            } else if (view instanceof EditText) {
                ((EditText) view).setTypeface(m81a(context));
            } else if (view instanceof Button) {
                ((Button) view).setTypeface(m81a(context));
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static void m93a(C0544b bVar, int i) {
        m84a((Object) bVar, "HTTP parameters");
        bVar.mo5391b("http.socket.timeout", i);
    }

    /* renamed from: a */
    public static void m94a(C0546k kVar) {
        InputStream f;
        if (kVar != null && kVar.mo5117g() && (f = kVar.mo4955f()) != null) {
            f.close();
        }
    }

    /* renamed from: a */
    public static void m95a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static boolean m96a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /* renamed from: a */
    public static boolean m97a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: a */
    public static boolean m98a(Object[] objArr, Object[] objArr2) {
        if (objArr == null) {
            return objArr2 == null;
        }
        if (objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            if (!m97a(objArr[i], objArr2[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static byte[] m99a(String str) {
        m84a((Object) str, "Input");
        try {
            return str.getBytes(C0297c.f130b.name());
        } catch (UnsupportedEncodingException e) {
            throw new Error("ASCII not supported");
        }
    }

    /* renamed from: a */
    public static byte[] m100a(String str, String str2) {
        m84a((Object) str, "Input");
        m82a((CharSequence) str2, "Charset");
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    /* renamed from: b */
    public static CharSequence m101b(CharSequence charSequence, String str) {
        if (charSequence == null) {
            throw new IllegalArgumentException(str + " may not be null");
        } else if (!m105b(charSequence)) {
            return charSequence;
        } else {
            throw new IllegalArgumentException(str + " may not be blank");
        }
    }

    /* renamed from: b */
    public static SSLContext m102b() {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            return instance;
        } catch (NoSuchAlgorithmException e) {
            throw new C0327d(e.getMessage(), e);
        } catch (KeyManagementException e2) {
            throw new C0327d(e2.getMessage(), e2);
        }
    }

    /* renamed from: b */
    public static C0565n m103b(URI uri) {
        C0565n nVar;
        int indexOf;
        int i;
        if (uri == null) {
            return null;
        }
        if (uri.isAbsolute()) {
            int port = uri.getPort();
            String host = uri.getHost();
            if (host == null && (host = uri.getAuthority()) != null) {
                int indexOf2 = host.indexOf(64);
                String substring = indexOf2 >= 0 ? host.length() > indexOf2 + 1 ? host.substring(indexOf2 + 1) : null : host;
                if (substring == null || (indexOf = substring.indexOf(58)) < 0) {
                    host = substring;
                } else {
                    int i2 = indexOf + 1;
                    int i3 = i2;
                    int i4 = 0;
                    while (i3 < substring.length() && Character.isDigit(substring.charAt(i3))) {
                        i4++;
                        i3++;
                    }
                    if (i4 > 0) {
                        try {
                            i = Integer.parseInt(substring.substring(i2, i2 + i4));
                        } catch (NumberFormatException e) {
                        }
                        port = i;
                        host = substring.substring(0, indexOf);
                    }
                    i = port;
                    port = i;
                    host = substring.substring(0, indexOf);
                }
            }
            String scheme = uri.getScheme();
            if (host != null) {
                nVar = new C0565n(host, port, scheme);
                return nVar;
            }
        }
        nVar = null;
        return nVar;
    }

    /* renamed from: b */
    public static void m104b(C0544b bVar, int i) {
        m84a((Object) bVar, "HTTP parameters");
        bVar.mo5391b("http.connection.timeout", i);
    }

    /* renamed from: b */
    public static boolean m105b(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        for (int i = 0; i < charSequence.length(); i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m106b(C0544b bVar) {
        m84a((Object) bVar, "HTTP parameters");
        return bVar.mo5390a("http.protocol.handle-authentication", true);
    }

    /* renamed from: b */
    public static byte[] m107b(C0546k kVar) {
        int i = 4096;
        boolean z = false;
        m84a((Object) kVar, "Entity");
        InputStream f = kVar.mo4955f();
        if (f == null) {
            return null;
        }
        try {
            if (kVar.mo5116c() <= 2147483647L) {
                z = true;
            }
            m95a(z, "HTTP entity too large to be buffered in memory");
            int c = (int) kVar.mo5116c();
            if (c >= 0) {
                i = c;
            }
            C0562a aVar = new C0562a(i);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = f.read(bArr);
                if (read == -1) {
                    return aVar.mo5417b();
                }
                aVar.mo5414a(bArr, 0, read);
            }
        } finally {
            f.close();
        }
    }

    /* renamed from: c */
    public static int m108c(C0544b bVar) {
        m84a((Object) bVar, "HTTP parameters");
        return bVar.mo5389a("http.socket.timeout", 0);
    }

    /* renamed from: c */
    private static URI m109c(URI uri) {
        if (uri.isOpaque()) {
            return uri;
        }
        m95a(uri.isAbsolute(), "Base URI must be absolute");
        String path = uri.getPath() == null ? "" : uri.getPath();
        String[] split = path.split("/");
        Stack stack = new Stack();
        for (String str : split) {
            if (str.length() != 0 && !".".equals(str)) {
                if (!"..".equals(str)) {
                    stack.push(str);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            sb.append('/').append((String) it.next());
        }
        if (path.lastIndexOf(47) == path.length() - 1) {
            sb.append('/');
        }
        try {
            URI uri2 = new URI(uri.getScheme().toLowerCase(), uri.getAuthority().toLowerCase(), sb.toString(), (String) null, (String) null);
            if (uri.getQuery() == null && uri.getFragment() == null) {
                return uri2;
            }
            StringBuilder sb2 = new StringBuilder(uri2.toASCIIString());
            if (uri.getQuery() != null) {
                sb2.append('?').append(uri.getRawQuery());
            }
            if (uri.getFragment() != null) {
                sb2.append('#').append(uri.getRawFragment());
            }
            return URI.create(sb2.toString());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: c */
    public static C0319f m110c() {
        C0319f fVar = new C0319f();
        fVar.mo5005a(new C0316c("http", 80, new C0315b()));
        fVar.mo5005a(new C0316c("https", 443, C0328e.m303a()));
        return fVar;
    }

    /* renamed from: d */
    public static int m111d(C0544b bVar) {
        m84a((Object) bVar, "HTTP parameters");
        return bVar.mo5389a("http.connection.timeout", 0);
    }

    /* renamed from: e */
    public static String m112e(C0544b bVar) {
        m84a((Object) bVar, "HTTP parameters");
        String str = (String) bVar.mo5196a("http.protocol.element-charset");
        return str == null ? C0552d.f623b.name() : str;
    }

    /* renamed from: f */
    public static C0241ac m113f(C0544b bVar) {
        m84a((Object) bVar, "HTTP parameters");
        Object a = bVar.mo5196a("http.protocol.version");
        return a == null ? C0573v.f645b : (C0241ac) a;
    }

    /* renamed from: a */
    public final C0249a mo4882a() {
        return new C0249a(this.f66a, this.f67b, this.f68c, this.f69d, this.f70e, this.f71f, this.f72g, this.f73h, this.f74i, this.f75j, this.f76k, this.f77l, this.f78m, this.f79n, this.f80o);
    }
}
