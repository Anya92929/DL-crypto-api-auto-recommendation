package cmn;

import java.text.ParseException;

/* renamed from: cmn.r */
public class C0756r {

    /* renamed from: a */
    public static final byte[] f1865a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b */
    public static final byte[] f1866b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: c */
    static final /* synthetic */ boolean f1867c = (!C0756r.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final byte[] f1868d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};

    /* renamed from: e */
    private static final byte[] f1869e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};

    private C0756r() {
    }

    /* renamed from: a */
    private static int m3307a(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        if (bArr[2] == 61) {
            bArr2[i] = (byte) ((((bArr3[bArr[0]] << 24) >>> 6) | ((bArr3[bArr[1]] << 24) >>> 12)) >>> 16);
            return 1;
        } else if (bArr[3] == 61) {
            int i2 = ((bArr3[bArr[1]] << 24) >>> 12) | ((bArr3[bArr[0]] << 24) >>> 6) | ((bArr3[bArr[2]] << 24) >>> 18);
            bArr2[i] = (byte) (i2 >>> 16);
            bArr2[i + 1] = (byte) (i2 >>> 8);
            return 2;
        } else {
            int i3 = ((bArr3[bArr[1]] << 24) >>> 12) | ((bArr3[bArr[0]] << 24) >>> 6) | ((bArr3[bArr[2]] << 24) >>> 18) | ((bArr3[bArr[3]] << 24) >>> 24);
            bArr2[i] = (byte) (i3 >> 16);
            bArr2[i + 1] = (byte) (i3 >> 8);
            bArr2[i + 2] = (byte) i3;
            return 3;
        }
    }

    /* renamed from: a */
    public static String m3308a(byte[] bArr) {
        return m3309a(bArr, bArr.length, f1865a, true);
    }

    /* renamed from: a */
    private static String m3309a(byte[] bArr, int i, byte[] bArr2, boolean z) {
        int i2 = ((i + 2) / 3) * 4;
        byte[] bArr3 = new byte[(i2 + (i2 / Integer.MAX_VALUE))];
        int i3 = i - 2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i6 < i3) {
            int i7 = ((bArr[i6] << 24) >>> 8) | ((bArr[i6 + 1] << 24) >>> 16) | ((bArr[i6 + 2] << 24) >>> 24);
            bArr3[i5] = bArr2[i7 >>> 18];
            bArr3[i5 + 1] = bArr2[(i7 >>> 12) & 63];
            bArr3[i5 + 2] = bArr2[(i7 >>> 6) & 63];
            bArr3[i5 + 3] = bArr2[i7 & 63];
            int i8 = i4 + 4;
            if (i8 == Integer.MAX_VALUE) {
                bArr3[i5 + 4] = 10;
                i5++;
                i8 = 0;
            }
            i5 += 4;
            i4 = i8;
            i6 += 3;
        }
        if (i6 < i) {
            int i9 = i - i6;
            int i10 = (i9 > 2 ? (bArr[i6 + 2] << 24) >>> 24 : 0) | (i9 > 0 ? (bArr[i6] << 24) >>> 8 : 0) | (i9 > 1 ? (bArr[i6 + 1] << 24) >>> 16 : 0);
            switch (i9) {
                case 1:
                    bArr3[i5] = bArr2[i10 >>> 18];
                    bArr3[i5 + 1] = bArr2[(i10 >>> 12) & 63];
                    bArr3[i5 + 2] = 61;
                    bArr3[i5 + 3] = 61;
                    break;
                case 2:
                    bArr3[i5] = bArr2[i10 >>> 18];
                    bArr3[i5 + 1] = bArr2[(i10 >>> 12) & 63];
                    bArr3[i5 + 2] = bArr2[(i10 >>> 6) & 63];
                    bArr3[i5 + 3] = 61;
                    break;
                case 3:
                    bArr3[i5] = bArr2[i10 >>> 18];
                    bArr3[i5 + 1] = bArr2[(i10 >>> 12) & 63];
                    bArr3[i5 + 2] = bArr2[(i10 >>> 6) & 63];
                    bArr3[i5 + 3] = bArr2[i10 & 63];
                    break;
            }
            if (i4 + 4 == Integer.MAX_VALUE) {
                bArr3[i5 + 4] = 10;
                i5++;
            }
            i5 += 4;
        }
        if (f1867c || i5 == bArr3.length) {
            int length = bArr3.length;
            while (!z && length > 0 && bArr3[length - 1] == 61) {
                length--;
            }
            return new String(bArr3, 0, length);
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static byte[] m3310a(String str) {
        byte[] bytes = str.getBytes();
        return m3311a(bytes, bytes.length, f1868d);
    }

    /* renamed from: a */
    private static byte[] m3311a(byte[] bArr, int i, byte[] bArr2) {
        int i2;
        int i3;
        byte[] bArr3 = new byte[(((i * 3) / 4) + 2)];
        byte[] bArr4 = new byte[4];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i4 >= i) {
                break;
            }
            byte b = (byte) (bArr[i4] & Byte.MAX_VALUE);
            byte b2 = bArr2[b];
            if (b2 >= -5) {
                if (b2 < -1) {
                    i2 = i5;
                    i3 = i6;
                } else if (b == 61) {
                    int i7 = i - i4;
                    byte b3 = (byte) (bArr[i - 1] & Byte.MAX_VALUE);
                    if (i5 == 0 || i5 == 1) {
                        throw new ParseException("invalid padding byte '=' at byte offset " + i4, i4);
                    } else if ((i5 == 3 && i7 > 2) || (i5 == 4 && i7 > 1)) {
                        throw new ParseException("padding byte '=' falsely signals end of encoded value at offset " + i4, i4);
                    } else if (b3 != 61 && b3 != 10) {
                        throw new ParseException("encoded value has invalid trailing byte", -1);
                    }
                } else {
                    i2 = i5 + 1;
                    bArr4[i5] = b;
                    if (i2 == 4) {
                        i3 = m3307a(bArr4, bArr3, i6, bArr2) + i6;
                        i2 = 0;
                    } else {
                        i3 = i6;
                    }
                }
                i4++;
                i6 = i3;
                i5 = i2;
            } else {
                throw new ParseException("Bad Base64 input character at " + i4 + ": " + bArr[i4] + "(decimal)", i4);
            }
        }
        if (i5 != 0) {
            if (i5 == 1) {
                throw new ParseException("single trailing character at offset " + (i - 1), i - 1);
            }
            bArr4[i5] = 61;
            i6 += m3307a(bArr4, bArr3, i6, bArr2);
        }
        byte[] bArr5 = new byte[i6];
        System.arraycopy(bArr3, 0, bArr5, 0, i6);
        return bArr5;
    }

    /* renamed from: b */
    public static String m3312b(byte[] bArr) {
        return m3309a(bArr, bArr.length, f1866b, false);
    }

    /* renamed from: b */
    public static byte[] m3313b(String str) {
        byte[] bytes = str.getBytes();
        return m3311a(bytes, bytes.length, f1869e);
    }
}
