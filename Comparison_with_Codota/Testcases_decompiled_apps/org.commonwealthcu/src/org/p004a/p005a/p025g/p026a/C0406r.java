package org.p004a.p005a.p025g.p026a;

import java.security.MessageDigest;

/* renamed from: org.a.a.g.a.r */
final class C0406r {

    /* renamed from: a */
    private byte[] f307a;

    /* renamed from: b */
    private byte[] f308b;

    /* renamed from: c */
    private MessageDigest f309c;

    C0406r(byte[] bArr) {
        try {
            this.f309c = MessageDigest.getInstance("MD5"); // CRYPTOGRAPHIC API CALLSITE 10
            this.f307a = new byte[64];
            this.f308b = new byte[64];
            int length = bArr.length;
            if (length > 64) {
                this.f309c.update(bArr); // CRYPTOGRAPHIC API CALLSITE 11
                bArr = this.f309c.digest(); // CRYPTOGRAPHIC API CALLSITE 12
                length = bArr.length;
            }
            int i = 0;
            while (i < length) {
                this.f307a[i] = (byte) (bArr[i] ^ 54);
                this.f308b[i] = (byte) (bArr[i] ^ 92);
                i++;
            }
            for (int i2 = i; i2 < 64; i2++) {
                this.f307a[i2] = 54;
                this.f308b[i2] = 92;
            }
            this.f309c.reset(); // CRYPTOGRAPHIC API CALLSITE 1
            this.f309c.update(this.f307a);
        } catch (Exception e) {
            throw new C0403o("Error getting md5 message digest implementation: " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo5168a(byte[] bArr) {
        this.f309c.update(bArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final byte[] mo5169a() {
        byte[] digest = this.f309c.digest();
        this.f309c.update(this.f308b);
        return this.f309c.digest(digest); // CRYPTOGRAPHIC API CALLSITE 9
    }
}
