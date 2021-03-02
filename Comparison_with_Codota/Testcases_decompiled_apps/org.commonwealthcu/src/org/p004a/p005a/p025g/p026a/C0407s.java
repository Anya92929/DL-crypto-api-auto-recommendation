package org.p004a.p005a.p025g.p026a;

/* renamed from: org.a.a.g.a.s */
final class C0407s {

    /* renamed from: a */
    private int f310a = 1732584193;

    /* renamed from: b */
    private int f311b = -271733879;

    /* renamed from: c */
    private int f312c = -1732584194;

    /* renamed from: d */
    private int f313d = 271733878;

    /* renamed from: e */
    private long f314e = 0;

    /* renamed from: f */
    private byte[] f315f = new byte[64];

    C0407s() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo5170a(byte[] bArr) {
        int i = (int) (this.f314e & 63);
        int i2 = 0;
        while ((bArr.length - i2) + i >= this.f315f.length) {
            int length = this.f315f.length - i;
            System.arraycopy(bArr, i2, this.f315f, i, length);
            this.f314e += (long) length;
            i = 0;
            i2 += length;
            int[] iArr = new int[16];
            for (int i3 = 0; i3 < 16; i3++) {
                iArr[i3] = (this.f315f[i3 << 2] & 255) + ((this.f315f[(i3 << 2) + 1] & 255) << 8) + ((this.f315f[(i3 << 2) + 2] & 255) << 16) + ((this.f315f[(i3 << 2) + 3] & 255) << 24);
            }
            int i4 = this.f310a;
            int i5 = this.f311b;
            int i6 = this.f312c;
            int i7 = this.f313d;
            this.f310a = C0404p.m553a(this.f310a + C0404p.m554a(this.f311b, this.f312c, this.f313d) + iArr[0], 3);
            this.f313d = C0404p.m553a(this.f313d + C0404p.m554a(this.f310a, this.f311b, this.f312c) + iArr[1], 7);
            this.f312c = C0404p.m553a(this.f312c + C0404p.m554a(this.f313d, this.f310a, this.f311b) + iArr[2], 11);
            this.f311b = C0404p.m553a(this.f311b + C0404p.m554a(this.f312c, this.f313d, this.f310a) + iArr[3], 19);
            this.f310a = C0404p.m553a(this.f310a + C0404p.m554a(this.f311b, this.f312c, this.f313d) + iArr[4], 3);
            this.f313d = C0404p.m553a(this.f313d + C0404p.m554a(this.f310a, this.f311b, this.f312c) + iArr[5], 7);
            this.f312c = C0404p.m553a(this.f312c + C0404p.m554a(this.f313d, this.f310a, this.f311b) + iArr[6], 11);
            this.f311b = C0404p.m553a(this.f311b + C0404p.m554a(this.f312c, this.f313d, this.f310a) + iArr[7], 19);
            this.f310a = C0404p.m553a(this.f310a + C0404p.m554a(this.f311b, this.f312c, this.f313d) + iArr[8], 3);
            this.f313d = C0404p.m553a(this.f313d + C0404p.m554a(this.f310a, this.f311b, this.f312c) + iArr[9], 7);
            this.f312c = C0404p.m553a(this.f312c + C0404p.m554a(this.f313d, this.f310a, this.f311b) + iArr[10], 11);
            this.f311b = C0404p.m553a(this.f311b + C0404p.m554a(this.f312c, this.f313d, this.f310a) + iArr[11], 19);
            this.f310a = C0404p.m553a(this.f310a + C0404p.m554a(this.f311b, this.f312c, this.f313d) + iArr[12], 3);
            this.f313d = C0404p.m553a(this.f313d + C0404p.m554a(this.f310a, this.f311b, this.f312c) + iArr[13], 7);
            this.f312c = C0404p.m553a(this.f312c + C0404p.m554a(this.f313d, this.f310a, this.f311b) + iArr[14], 11);
            this.f311b = C0404p.m553a(this.f311b + C0404p.m554a(this.f312c, this.f313d, this.f310a) + iArr[15], 19);
            this.f310a = C0404p.m553a(this.f310a + C0404p.m562b(this.f311b, this.f312c, this.f313d) + iArr[0] + 1518500249, 3);
            this.f313d = C0404p.m553a(this.f313d + C0404p.m562b(this.f310a, this.f311b, this.f312c) + iArr[4] + 1518500249, 5);
            this.f312c = C0404p.m553a(this.f312c + C0404p.m562b(this.f313d, this.f310a, this.f311b) + iArr[8] + 1518500249, 9);
            this.f311b = C0404p.m553a(this.f311b + C0404p.m562b(this.f312c, this.f313d, this.f310a) + iArr[12] + 1518500249, 13);
            this.f310a = C0404p.m553a(this.f310a + C0404p.m562b(this.f311b, this.f312c, this.f313d) + iArr[1] + 1518500249, 3);
            this.f313d = C0404p.m553a(this.f313d + C0404p.m562b(this.f310a, this.f311b, this.f312c) + iArr[5] + 1518500249, 5);
            this.f312c = C0404p.m553a(this.f312c + C0404p.m562b(this.f313d, this.f310a, this.f311b) + iArr[9] + 1518500249, 9);
            this.f311b = C0404p.m553a(this.f311b + C0404p.m562b(this.f312c, this.f313d, this.f310a) + iArr[13] + 1518500249, 13);
            this.f310a = C0404p.m553a(this.f310a + C0404p.m562b(this.f311b, this.f312c, this.f313d) + iArr[2] + 1518500249, 3);
            this.f313d = C0404p.m553a(this.f313d + C0404p.m562b(this.f310a, this.f311b, this.f312c) + iArr[6] + 1518500249, 5);
            this.f312c = C0404p.m553a(this.f312c + C0404p.m562b(this.f313d, this.f310a, this.f311b) + iArr[10] + 1518500249, 9);
            this.f311b = C0404p.m553a(this.f311b + C0404p.m562b(this.f312c, this.f313d, this.f310a) + iArr[14] + 1518500249, 13);
            this.f310a = C0404p.m553a(this.f310a + C0404p.m562b(this.f311b, this.f312c, this.f313d) + iArr[3] + 1518500249, 3);
            this.f313d = C0404p.m553a(this.f313d + C0404p.m562b(this.f310a, this.f311b, this.f312c) + iArr[7] + 1518500249, 5);
            this.f312c = C0404p.m553a(this.f312c + C0404p.m562b(this.f313d, this.f310a, this.f311b) + iArr[11] + 1518500249, 9);
            this.f311b = C0404p.m553a(this.f311b + C0404p.m562b(this.f312c, this.f313d, this.f310a) + iArr[15] + 1518500249, 13);
            this.f310a = C0404p.m553a(this.f310a + C0404p.m569c(this.f311b, this.f312c, this.f313d) + iArr[0] + 1859775393, 3);
            this.f313d = C0404p.m553a(this.f313d + C0404p.m569c(this.f310a, this.f311b, this.f312c) + iArr[8] + 1859775393, 9);
            this.f312c = C0404p.m553a(this.f312c + C0404p.m569c(this.f313d, this.f310a, this.f311b) + iArr[4] + 1859775393, 11);
            this.f311b = C0404p.m553a(this.f311b + C0404p.m569c(this.f312c, this.f313d, this.f310a) + iArr[12] + 1859775393, 15);
            this.f310a = C0404p.m553a(this.f310a + C0404p.m569c(this.f311b, this.f312c, this.f313d) + iArr[2] + 1859775393, 3);
            this.f313d = C0404p.m553a(this.f313d + C0404p.m569c(this.f310a, this.f311b, this.f312c) + iArr[10] + 1859775393, 9);
            this.f312c = C0404p.m553a(this.f312c + C0404p.m569c(this.f313d, this.f310a, this.f311b) + iArr[6] + 1859775393, 11);
            this.f311b = C0404p.m553a(this.f311b + C0404p.m569c(this.f312c, this.f313d, this.f310a) + iArr[14] + 1859775393, 15);
            this.f310a = C0404p.m553a(this.f310a + C0404p.m569c(this.f311b, this.f312c, this.f313d) + iArr[1] + 1859775393, 3);
            this.f313d = C0404p.m553a(this.f313d + C0404p.m569c(this.f310a, this.f311b, this.f312c) + iArr[9] + 1859775393, 9);
            this.f312c = C0404p.m553a(this.f312c + C0404p.m569c(this.f313d, this.f310a, this.f311b) + iArr[5] + 1859775393, 11);
            this.f311b = C0404p.m553a(this.f311b + C0404p.m569c(this.f312c, this.f313d, this.f310a) + iArr[13] + 1859775393, 15);
            this.f310a = C0404p.m553a(this.f310a + C0404p.m569c(this.f311b, this.f312c, this.f313d) + iArr[3] + 1859775393, 3);
            this.f313d = C0404p.m553a(this.f313d + C0404p.m569c(this.f310a, this.f311b, this.f312c) + iArr[11] + 1859775393, 9);
            this.f312c = C0404p.m553a(this.f312c + C0404p.m569c(this.f313d, this.f310a, this.f311b) + iArr[7] + 1859775393, 11);
            this.f311b = C0404p.m553a(iArr[15] + this.f311b + C0404p.m569c(this.f312c, this.f313d, this.f310a) + 1859775393, 15);
            this.f310a = i4 + this.f310a;
            this.f311b += i5;
            this.f312c += i6;
            this.f313d += i7;
        }
        if (i2 < bArr.length) {
            int length2 = bArr.length - i2;
            System.arraycopy(bArr, i2, this.f315f, i, length2);
            this.f314e += (long) length2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final byte[] mo5171a() {
        int i = (int) (this.f314e & 63);
        int i2 = i < 56 ? 56 - i : 120 - i;
        byte[] bArr = new byte[(i2 + 8)];
        bArr[0] = Byte.MIN_VALUE;
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i2 + i3] = (byte) ((int) ((this.f314e << 3) >>> (i3 * 8)));
        }
        mo5170a(bArr);
        byte[] bArr2 = new byte[16];
        C0404p.m556a(bArr2, this.f310a, 0);
        C0404p.m556a(bArr2, this.f311b, 4);
        C0404p.m556a(bArr2, this.f312c, 8);
        C0404p.m556a(bArr2, this.f313d, 12);
        return bArr2;
    }
}
