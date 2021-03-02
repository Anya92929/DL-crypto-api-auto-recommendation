package org.p004a.p005a.p025g.p026a;

import java.io.UnsupportedEncodingException;

/* renamed from: org.a.a.g.a.v */
final class C0410v extends C0408t {

    /* renamed from: a */
    private byte[] f318a = new byte[8];

    /* renamed from: b */
    private String f319b;

    /* renamed from: c */
    private byte[] f320c;

    /* renamed from: d */
    private int f321d;

    C0410v(String str) {
        super(str, 2);
        mo5176a(this.f318a, 24);
        this.f321d = mo5173a(20);
        if ((this.f321d & 1) == 0) {
            throw new C0403o("NTLM type 2 message has flags that make no sense: " + Integer.toString(this.f321d));
        }
        this.f319b = null;
        if (mo5172a() >= 20) {
            byte[] b = mo5178b(12);
            if (b.length != 0) {
                try {
                    this.f319b = new String(b, "UnicodeLittleUnmarked");
                } catch (UnsupportedEncodingException e) {
                    throw new C0403o(e.getMessage(), e);
                }
            }
        }
        this.f320c = null;
        if (mo5172a() >= 48) {
            byte[] b2 = mo5178b(40);
            if (b2.length != 0) {
                this.f320c = b2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final byte[] mo5181c() {
        return this.f318a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final String mo5182d() {
        return this.f319b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final byte[] mo5183e() {
        return this.f320c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final int mo5184f() {
        return this.f321d;
    }
}
