package com.google.ads;

/* renamed from: com.google.ads.aq */
public final class C0198aq {

    /* renamed from: a */
    private static final char[] f354a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    /* renamed from: b */
    private static final char[] f355b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();

    /* renamed from: c */
    private static final byte[] f356c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};

    /* renamed from: d */
    private static final byte[] f357d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};

    /* renamed from: a */
    private static char[] m110a(byte[] bArr, int i, int i2, char[] cArr, int i3, char[] cArr2) {
        int i4 = 0;
        int i5 = (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0);
        if (i2 > 2) {
            i4 = (bArr[i + 2] << 24) >>> 24;
        }
        int i6 = i4 | i5;
        switch (i2) {
            case 1:
                cArr[i3] = cArr2[i6 >>> 18];
                cArr[i3 + 1] = cArr2[(i6 >>> 12) & 63];
                cArr[i3 + 2] = '=';
                cArr[i3 + 3] = '=';
                break;
            case 2:
                cArr[i3] = cArr2[i6 >>> 18];
                cArr[i3 + 1] = cArr2[(i6 >>> 12) & 63];
                cArr[i3 + 2] = cArr2[(i6 >>> 6) & 63];
                cArr[i3 + 3] = '=';
                break;
            case 3:
                cArr[i3] = cArr2[i6 >>> 18];
                cArr[i3 + 1] = cArr2[(i6 >>> 12) & 63];
                cArr[i3 + 2] = cArr2[(i6 >>> 6) & 63];
                cArr[i3 + 3] = cArr2[i6 & 63];
                break;
        }
        return cArr;
    }

    /* renamed from: a */
    public static String m105a(byte[] bArr, boolean z) {
        return m104a(bArr, 0, bArr.length, f355b, z);
    }

    /* renamed from: a */
    public static String m104a(byte[] bArr, int i, int i2, char[] cArr, boolean z) {
        char[] a = m109a(bArr, i, i2, cArr, Integer.MAX_VALUE);
        int length = a.length;
        while (!z && length > 0 && a[length - 1] == '=') {
            length--;
        }
        return new String(a, 0, length);
    }

    /* renamed from: a */
    public static char[] m109a(byte[] bArr, int i, int i2, char[] cArr, int i3) {
        int i4 = ((i2 + 2) / 3) * 4;
        char[] cArr2 = new char[(i4 + (i4 / i3))];
        int i5 = i2 - 2;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i8 < i5) {
            int i9 = ((bArr[i8 + i] << 24) >>> 8) | ((bArr[(i8 + 1) + i] << 24) >>> 16) | ((bArr[(i8 + 2) + i] << 24) >>> 24);
            cArr2[i7] = cArr[i9 >>> 18];
            cArr2[i7 + 1] = cArr[(i9 >>> 12) & 63];
            cArr2[i7 + 2] = cArr[(i9 >>> 6) & 63];
            cArr2[i7 + 3] = cArr[i9 & 63];
            int i10 = i6 + 4;
            if (i10 == i3) {
                cArr2[i7 + 4] = 10;
                i7++;
                i10 = 0;
            }
            i8 += 3;
            i7 += 4;
            i6 = i10;
        }
        if (i8 < i2) {
            m110a(bArr, i8 + i, i2 - i8, cArr2, i7, cArr);
            if (i6 + 4 == i3) {
                cArr2[i7 + 4] = 10;
                i7++;
            }
            int i11 = i7 + 4;
        }
        return cArr2;
    }

    /* renamed from: a */
    private static int m103a(char[] cArr, int i, byte[] bArr, int i2, byte[] bArr2) {
        if (cArr[i + 2] == '=') {
            bArr[i2] = (byte) ((((bArr2[cArr[i]] << 24) >>> 6) | ((bArr2[cArr[i + 1]] << 24) >>> 12)) >>> 16);
            return 1;
        } else if (cArr[i + 3] == '=') {
            int i3 = ((bArr2[cArr[i]] << 24) >>> 6) | ((bArr2[cArr[i + 1]] << 24) >>> 12) | ((bArr2[cArr[i + 2]] << 24) >>> 18);
            bArr[i2] = (byte) (i3 >>> 16);
            bArr[i2 + 1] = (byte) (i3 >>> 8);
            return 2;
        } else {
            int i4 = ((bArr2[cArr[i]] << 24) >>> 6) | ((bArr2[cArr[i + 1]] << 24) >>> 12) | ((bArr2[cArr[i + 2]] << 24) >>> 18) | ((bArr2[cArr[i + 3]] << 24) >>> 24);
            bArr[i2] = (byte) (i4 >> 16);
            bArr[i2 + 1] = (byte) (i4 >> 8);
            bArr[i2 + 2] = (byte) i4;
            return 3;
        }
    }

    /* renamed from: a */
    public static byte[] m106a(String str) throws C0197ap {
        char[] charArray = str.toCharArray();
        return m107a(charArray, 0, charArray.length);
    }

    /* renamed from: a */
    public static byte[] m107a(char[] cArr, int i, int i2) throws C0197ap {
        return m108a(cArr, i, i2, f356c);
    }

    /* renamed from: a */
    public static byte[] m108a(char[] cArr, int i, int i2, byte[] bArr) throws C0197ap {
        int i3;
        byte[] bArr2 = new byte[(((i2 * 3) / 4) + 2)];
        int i4 = 0;
        char[] cArr2 = new char[4];
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i2) {
            char c = cArr[i5 + i];
            char c2 = (char) (c & 127);
            byte b = bArr[c2];
            if (c2 != c || b >= -5) {
                if (b < -1) {
                    i3 = i4;
                } else if (c2 == '=') {
                    if (z) {
                        i3 = i4;
                    } else if (i5 < 2) {
                        throw new C0197ap("Invalid padding char found in position " + i5);
                    } else {
                        z = true;
                        char c3 = (char) (cArr[(i2 - 1) + i] & 127);
                        if (c3 == '=' || c3 == 10) {
                            i3 = i4;
                        } else {
                            throw new C0197ap("encoded value has invalid trailing char");
                        }
                    }
                } else if (z) {
                    throw new C0197ap("Data found after trailing padding char at index " + i5);
                } else {
                    int i7 = i6 + 1;
                    cArr2[i6] = c2;
                    if (i7 == 4) {
                        i3 = i4 + m103a(cArr2, 0, bArr2, i4, bArr);
                        i6 = 0;
                    } else {
                        i6 = i7;
                        i3 = i4;
                    }
                }
                i5++;
                i4 = i3;
            } else {
                throw new C0197ap("Bad Base64 input character at " + i5 + ": " + cArr[i5 + i] + "(decimal)");
            }
        }
        if (i6 != 0) {
            if (i6 == 1) {
                throw new C0197ap("single trailing character at offset " + (i2 - 1));
            }
            cArr2[i6] = '=';
            i4 += m103a(cArr2, 0, bArr2, i4, bArr);
        }
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 0, i4);
        return bArr3;
    }
}
