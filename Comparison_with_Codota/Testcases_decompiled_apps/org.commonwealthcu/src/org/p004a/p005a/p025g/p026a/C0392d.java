package org.p004a.p005a.p025g.p026a;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import org.p004a.p005a.C0297c;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0548l;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0576y;
import org.p004a.p005a.p006a.C0229j;
import org.p004a.p005a.p006a.C0233n;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p033i.C0525d;
import org.p004a.p005a.p033i.C0532k;
import org.p004a.p005a.p033i.C0536o;
import org.p004a.p005a.p036l.C0549a;
import org.p004a.p005a.p036l.C0553e;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.a.d */
public final class C0392d extends C0386aa {

    /* renamed from: a */
    private static final char[] f255a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private boolean f256b;

    /* renamed from: c */
    private String f257c;

    /* renamed from: d */
    private long f258d;

    /* renamed from: e */
    private String f259e;

    /* renamed from: f */
    private String f260f;

    /* renamed from: g */
    private String f261g;

    public C0392d() {
        this(C0297c.f130b);
    }

    public C0392d(Charset charset) {
        super(charset);
        this.f256b = false;
    }

    /* renamed from: a */
    private static String m523a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        for (int i = 0; i < length; i++) {
            cArr[i << 1] = f255a[(bArr[i] & 240) >> 4];
            cArr[(i << 1) + 1] = f255a[bArr[i] & 15];
        }
        return new String(cArr);
    }

    /* renamed from: b */
    private static MessageDigest m524b(String str) {
        try {
            return MessageDigest.getInstance(str); // CRYPTOGRAPHIC API CALLSITE 13
        } catch (Exception e) {
            throw new C0389ad("Unsupported algorithm in HTTP Digest authentication: " + str);
        }
    }

    /* renamed from: b */
    private C0344e m525b(C0233n nVar, C0568q qVar) {
        char c;
        String sb;
        String a = mo5143a("uri");
        String a2 = mo5143a("realm");
        String a3 = mo5143a("nonce");
        String a4 = mo5143a("opaque");
        String a5 = mo5143a("methodname");
        String a6 = mo5143a("algorithm");
        if (a6 == null) {
            a6 = "MD5";
        }
        HashSet hashSet = new HashSet(8);
        char c2 = 65535;
        String a7 = mo5143a("qop");
        if (a7 != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(a7, ",");
            while (stringTokenizer.hasMoreTokens()) {
                hashSet.add(stringTokenizer.nextToken().trim().toLowerCase(Locale.US));
            }
            if (!(qVar instanceof C0548l) || !hashSet.contains("auth-int")) {
                if (hashSet.contains("auth")) {
                    c2 = 2;
                }
                c = c2;
            } else {
                c = 1;
            }
        } else {
            c = 0;
        }
        if (c == 65535) {
            throw new C0229j("None of the qop methods is supported: " + a7);
        }
        String a8 = mo5143a("charset");
        if (a8 == null) {
            a8 = "ISO-8859-1";
        }
        String str = a6.equalsIgnoreCase("MD5-sess") ? "MD5" : a6;
        try {
            MessageDigest b = m524b(str);
            String name = nVar.mo4837a().getName();
            String b2 = nVar.mo4838b();
            if (a3.equals(this.f257c)) {
                this.f258d++;
            } else {
                this.f258d = 1;
                this.f259e = null;
                this.f257c = a3;
            }
            StringBuilder sb2 = new StringBuilder(256);
            Formatter formatter = new Formatter(sb2, Locale.US);
            formatter.format("%08x", new Object[]{Long.valueOf(this.f258d)});
            formatter.close();
            String sb3 = sb2.toString();
            if (this.f259e == null) {
                byte[] bArr = new byte[8];
                new SecureRandom().nextBytes(bArr); // CRYPTOGRAPHIC API CALLSITE 26
                this.f259e = m523a(bArr);
            }
            this.f260f = null;
            this.f261g = null;
            if (a6.equalsIgnoreCase("MD5-sess")) {
                sb2.setLength(0);
                sb2.append(name).append(':').append(a2).append(':').append(b2);
                String a9 = m523a(b.digest(C0250b.m100a(sb2.toString(), a8)));
                sb2.setLength(0);
                sb2.append(a9).append(':').append(a3).append(':').append(this.f259e);
                this.f260f = sb2.toString();
            } else {
                sb2.setLength(0);
                sb2.append(name).append(':').append(a2).append(':').append(b2);
                this.f260f = sb2.toString();
            }
            String a10 = m523a(b.digest(C0250b.m100a(this.f260f, a8))); // CRYPTOGRAPHIC API CALLSITE 25
            if (c == 2) {
                this.f261g = a5 + ':' + a;
            } else if (c == 1) {
                C0546k kVar = null;
                if (qVar instanceof C0548l) {
                    kVar = ((C0548l) qVar).mo4896b();
                }
                if (kVar == null || kVar.mo4952a()) {
                    C0399k kVar2 = new C0399k(b);
                    if (kVar != null) {
                        try {
                            kVar.mo4951a(kVar2);
                        } catch (IOException e) {
                            throw new C0229j("I/O error reading entity content", e);
                        }
                    }
                    kVar2.close();
                    this.f261g = a5 + ':' + a + ':' + m523a(kVar2.mo5150a());
                } else if (hashSet.contains("auth")) {
                    c = 2;
                    this.f261g = a5 + ':' + a;
                } else {
                    throw new C0229j("Qop auth-int cannot be used with a non-repeatable entity");
                }
            } else {
                this.f261g = a5 + ':' + a;
            }
            String a11 = m523a(b.digest(C0250b.m100a(this.f261g, a8)));
            if (c == 0) {
                sb2.setLength(0);
                sb2.append(a10).append(':').append(a3).append(':').append(a11);
                sb = sb2.toString();
            } else {
                sb2.setLength(0);
                sb2.append(a10).append(':').append(a3).append(':').append(sb3).append(':').append(this.f259e).append(':').append(c == 1 ? "auth-int" : "auth").append(':').append(a11);
                sb = sb2.toString();
            }
            String a12 = m523a(b.digest(C0250b.m99a(sb)));
            C0563b bVar = new C0563b(128);
            if (mo5141e()) {
                bVar.mo5428a("Proxy-Authorization");
            } else {
                bVar.mo5428a("Authorization");
            }
            bVar.mo5428a(": Digest ");
            ArrayList arrayList = new ArrayList(20);
            arrayList.add(new C0532k("username", name));
            arrayList.add(new C0532k("realm", a2));
            arrayList.add(new C0532k("nonce", a3));
            arrayList.add(new C0532k("uri", a));
            arrayList.add(new C0532k("response", a12));
            if (c != 0) {
                arrayList.add(new C0532k("qop", c == 1 ? "auth-int" : "auth"));
                arrayList.add(new C0532k("nc", sb3));
                arrayList.add(new C0532k("cnonce", this.f259e));
            }
            arrayList.add(new C0532k("algorithm", a6));
            if (a4 != null) {
                arrayList.add(new C0532k("opaque", a4));
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    return new C0536o(bVar);
                }
                C0532k kVar3 = (C0532k) arrayList.get(i2);
                if (i2 > 0) {
                    bVar.mo5428a(", ");
                }
                String a13 = kVar3.mo5357a();
                C0525d.f570a.mo5339a(bVar, (C0576y) kVar3, !("nc".equals(a13) || "qop".equals(a13) || "algorithm".equals(a13)));
                i = i2 + 1;
            }
        } catch (C0389ad e2) {
            throw new C0229j("Unsuppported digest algorithm: " + str);
        }
    }

    /* renamed from: a */
    public final String mo4808a() {
        return "digest";
    }

    /* renamed from: a */
    public final C0344e mo4809a(C0233n nVar, C0568q qVar) {
        return mo4836a(nVar, qVar, new C0549a());
    }

    /* renamed from: a */
    public final C0344e mo4836a(C0233n nVar, C0568q qVar, C0553e eVar) {
        C0250b.m84a((Object) nVar, "Credentials");
        C0250b.m84a((Object) qVar, "HTTP request");
        if (mo5143a("realm") == null) {
            throw new C0229j("missing realm in challenge");
        } else if (mo5143a("nonce") == null) {
            throw new C0229j("missing nonce in challenge");
        } else {
            mo5145f().put("methodname", qVar.mo4902g().mo4863a());
            mo5145f().put("uri", qVar.mo4902g().mo4865c());
            if (mo5143a("charset") == null) {
                mo5145f().put("charset", mo5144a(qVar));
            }
            return m525b(nVar, qVar);
        }
    }

    /* renamed from: a */
    public final void mo4810a(C0344e eVar) {
        super.mo4810a(eVar);
        this.f256b = true;
    }

    /* renamed from: c */
    public final boolean mo4812c() {
        return false;
    }

    /* renamed from: d */
    public final boolean mo4813d() {
        if ("true".equalsIgnoreCase(mo5143a("stale"))) {
            return false;
        }
        return this.f256b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DIGEST [complete=").append(this.f256b).append(", nonce=").append(this.f257c).append(", nc=").append(this.f258d).append("]");
        return sb.toString();
    }
}
