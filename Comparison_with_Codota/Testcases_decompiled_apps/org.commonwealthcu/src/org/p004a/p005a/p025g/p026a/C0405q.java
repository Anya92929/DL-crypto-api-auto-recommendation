package org.p004a.p005a.p025g.p026a;

import java.security.Key;
import java.util.Arrays;
import javax.crypto.Cipher;

/* renamed from: org.a.a.g.a.q */
public final class C0405q {

    /* renamed from: a */
    private String f282a;

    /* renamed from: b */
    private String f283b;

    /* renamed from: c */
    private String f284c;

    /* renamed from: d */
    private byte[] f285d;

    /* renamed from: e */
    private byte[] f286e;

    /* renamed from: f */
    private byte[] f287f;

    /* renamed from: g */
    private byte[] f288g;

    /* renamed from: h */
    private byte[] f289h;

    /* renamed from: i */
    private byte[] f290i;

    /* renamed from: j */
    private byte[] f291j;

    /* renamed from: k */
    private byte[] f292k;

    /* renamed from: l */
    private byte[] f293l;

    /* renamed from: m */
    private byte[] f294m;

    /* renamed from: n */
    private byte[] f295n;

    /* renamed from: o */
    private byte[] f296o;

    /* renamed from: p */
    private byte[] f297p;

    /* renamed from: q */
    private byte[] f298q;

    /* renamed from: r */
    private byte[] f299r;

    /* renamed from: s */
    private byte[] f300s;

    /* renamed from: t */
    private byte[] f301t;

    /* renamed from: u */
    private byte[] f302u;

    /* renamed from: v */
    private byte[] f303v;

    /* renamed from: w */
    private byte[] f304w;

    /* renamed from: x */
    private byte[] f305x;

    /* renamed from: y */
    private byte[] f306y;

    public C0405q(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2) {
        this(str, str2, str3, bArr, str4, bArr2, (byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
    }

    private C0405q(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        this.f291j = null;
        this.f292k = null;
        this.f293l = null;
        this.f294m = null;
        this.f295n = null;
        this.f296o = null;
        this.f297p = null;
        this.f298q = null;
        this.f299r = null;
        this.f300s = null;
        this.f301t = null;
        this.f302u = null;
        this.f303v = null;
        this.f304w = null;
        this.f305x = null;
        this.f306y = null;
        this.f282a = str;
        this.f283b = str2;
        this.f284c = str3;
        this.f285d = bArr;
        this.f286e = bArr2;
        this.f287f = null;
        this.f288g = null;
        this.f289h = null;
        this.f290i = null;
    }

    /* renamed from: m */
    private byte[] m588m() {
        if (this.f287f == null) {
            this.f287f = C0404p.m578d();
        }
        return this.f287f;
    }

    /* renamed from: n */
    private byte[] m589n() {
        if (this.f291j == null) {
            this.f291j = C0404p.m584f(this.f284c);
        }
        return this.f291j;
    }

    /* renamed from: o */
    private byte[] m590o() {
        if (this.f293l == null) {
            this.f293l = C0404p.m585g(this.f284c);
        }
        return this.f293l;
    }

    /* renamed from: p */
    private byte[] m591p() {
        if (this.f295n == null) {
            this.f295n = C0404p.m579d(this.f282a, this.f283b, m590o());
        }
        return this.f295n;
    }

    /* renamed from: a */
    public final byte[] mo5156a() {
        if (this.f289h == null) {
            this.f289h = C0404p.m583e();
        }
        return this.f289h;
    }

    /* renamed from: b */
    public final byte[] mo5157b() {
        if (this.f292k == null) {
            this.f292k = C0404p.m580d(m589n(), this.f285d);
        }
        return this.f292k;
    }

    /* renamed from: c */
    public final byte[] mo5158c() {
        if (this.f294m == null) {
            this.f294m = C0404p.m580d(m590o(), this.f285d);
        }
        return this.f294m;
    }

    /* renamed from: d */
    public final byte[] mo5159d() {
        if (this.f299r == null) {
            byte[] p = m591p();
            byte[] bArr = this.f285d;
            if (this.f298q == null) {
                if (this.f288g == null) {
                    this.f288g = C0404p.m578d();
                }
                byte[] bArr2 = this.f288g;
                byte[] bArr3 = this.f286e;
                if (this.f290i == null) {
                    long currentTimeMillis = (System.currentTimeMillis() + 11644473600000L) * 10000;
                    this.f290i = new byte[8];
                    for (int i = 0; i < 8; i++) {
                        this.f290i[i] = (byte) ((int) currentTimeMillis);
                        currentTimeMillis >>>= 8;
                    }
                }
                this.f298q = C0404p.m568b(bArr2, bArr3, this.f290i);
            }
            this.f299r = C0404p.m575c(p, bArr, this.f298q);
        }
        return this.f299r;
    }

    /* renamed from: e */
    public final byte[] mo5160e() {
        if (this.f297p == null) {
            if (this.f296o == null) {
                this.f296o = C0404p.m572c(this.f282a, this.f283b, m590o());
            }
            this.f297p = C0404p.m575c(this.f296o, this.f285d, m588m());
        }
        return this.f297p;
    }

    /* renamed from: f */
    public final byte[] mo5161f() {
        if (this.f300s == null) {
            this.f300s = C0404p.m561a(m590o(), this.f285d, m588m());
        }
        return this.f300s;
    }

    /* renamed from: g */
    public final byte[] mo5162g() {
        if (this.f301t == null) {
            byte[] m = m588m();
            this.f301t = new byte[24];
            System.arraycopy(m, 0, this.f301t, 0, m.length);
            Arrays.fill(this.f301t, m.length, this.f301t.length, (byte) 0);
        }
        return this.f301t;
    }

    /* renamed from: h */
    public final byte[] mo5163h() {
        if (this.f302u == null) {
            byte[] n = m589n();
            this.f302u = new byte[16];
            System.arraycopy(n, 0, this.f302u, 0, 8);
            Arrays.fill(this.f302u, 8, 16, (byte) 0);
        }
        return this.f302u;
    }

    /* renamed from: i */
    public final byte[] mo5164i() {
        if (this.f303v == null) {
            byte[] o = m590o();
            C0407s sVar = new C0407s();
            sVar.mo5170a(o);
            this.f303v = sVar.mo5171a();
        }
        return this.f303v;
    }

    /* renamed from: j */
    public final byte[] mo5165j() {
        if (this.f304w == null) {
            byte[] p = m591p();
            byte[] bArr = new byte[16];
            System.arraycopy(mo5159d(), 0, bArr, 0, 16);
            this.f304w = C0404p.m560a(bArr, p);
        }
        return this.f304w;
    }

    /* renamed from: k */
    public final byte[] mo5166k() {
        if (this.f305x == null) {
            byte[] i = mo5164i();
            byte[] g = mo5162g();
            byte[] bArr = new byte[(this.f285d.length + g.length)];
            System.arraycopy(this.f285d, 0, bArr, 0, this.f285d.length);
            System.arraycopy(g, 0, bArr, this.f285d.length, g.length);
            this.f305x = C0404p.m560a(bArr, i);
        }
        return this.f305x;
    }

    /* renamed from: l */
    public final byte[] mo5167l() {
        if (this.f306y == null) {
            byte[] n = m589n();
            byte[] b = mo5157b();
            try {
                byte[] bArr = new byte[14];
                System.arraycopy(n, 0, bArr, 0, 8);
                Arrays.fill(bArr, 8, 14, (byte) -67);
                Key a = C0404p.m582e(bArr, 0);
                Key a2 = C0404p.m582e(bArr, 7);
                byte[] bArr2 = new byte[8];
                System.arraycopy(b, 0, bArr2, 0, 8);
                Cipher instance = Cipher.getInstance("DES/ECB/NoPadding"); // CRYPTOGRAPHIC API CALLSITE 19
                instance.init(1, a); // CRYPTOGRAPHIC API CALLSITE 18
                byte[] doFinal = instance.doFinal(bArr2); // CRYPTOGRAPHIC API CALLSITE 17
                Cipher instance2 = Cipher.getInstance("DES/ECB/NoPadding");
                instance2.init(1, a2);
                byte[] doFinal2 = instance2.doFinal(bArr2);
                this.f306y = new byte[16];
                System.arraycopy(doFinal, 0, this.f306y, 0, doFinal.length);
                System.arraycopy(doFinal2, 0, this.f306y, doFinal.length, doFinal2.length);
            } catch (Exception e) {
                throw new C0403o(e.getMessage(), e);
            }
        }
        return this.f306y;
    }
}
