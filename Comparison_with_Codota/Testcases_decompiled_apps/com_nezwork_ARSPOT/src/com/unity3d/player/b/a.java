package com.unity3d.player.b;

import com.qualcomm.ar.pl.SystemTools;

public class a {
    private static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
    private static /* synthetic */ boolean c = (!a.class.desiredAssertionStatus());

    static {
        byte[] bArr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        byte[] bArr2 = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
    }

    private a() {
    }

    private static int a(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
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

    public static String a(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = a;
        int i = ((length + 2) / 3) * 4;
        byte[] bArr3 = new byte[(i + (i / Integer.MAX_VALUE))];
        int i2 = length - 2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i5 < i2) {
            int i6 = ((bArr[i5 + 0] << 24) >>> 8) | ((bArr[(i5 + 1) + 0] << 24) >>> 16) | ((bArr[(i5 + 2) + 0] << 24) >>> 24);
            bArr3[i4] = bArr2[i6 >>> 18];
            bArr3[i4 + 1] = bArr2[(i6 >>> 12) & 63];
            bArr3[i4 + 2] = bArr2[(i6 >>> 6) & 63];
            bArr3[i4 + 3] = bArr2[i6 & 63];
            int i7 = i3 + 4;
            if (i7 == Integer.MAX_VALUE) {
                bArr3[i4 + 4] = 10;
                i4++;
                i7 = 0;
            }
            i5 += 3;
            i4 += 4;
            i3 = i7;
        }
        if (i5 < length) {
            int i8 = i5 + 0;
            int i9 = length - i5;
            int i10 = (i9 > 2 ? (bArr[i8 + 2] << 24) >>> 24 : 0) | (i9 > 0 ? (bArr[i8] << 24) >>> 8 : 0) | (i9 > 1 ? (bArr[i8 + 1] << 24) >>> 16 : 0);
            switch (i9) {
                case 1:
                    bArr3[i4] = bArr2[i10 >>> 18];
                    bArr3[i4 + 1] = bArr2[(i10 >>> 12) & 63];
                    bArr3[i4 + 2] = 61;
                    bArr3[i4 + 3] = 61;
                    break;
                case 2:
                    bArr3[i4] = bArr2[i10 >>> 18];
                    bArr3[i4 + 1] = bArr2[(i10 >>> 12) & 63];
                    bArr3[i4 + 2] = bArr2[(i10 >>> 6) & 63];
                    bArr3[i4 + 3] = 61;
                    break;
                case SystemTools.AR_ERROR_INVALID_ENUM:
                    bArr3[i4] = bArr2[i10 >>> 18];
                    bArr3[i4 + 1] = bArr2[(i10 >>> 12) & 63];
                    bArr3[i4 + 2] = bArr2[(i10 >>> 6) & 63];
                    bArr3[i4 + 3] = bArr2[i10 & 63];
                    break;
            }
            if (i3 + 4 == Integer.MAX_VALUE) {
                bArr3[i4 + 4] = 10;
                i4++;
            }
            i4 += 4;
        }
        if (c || i4 == bArr3.length) {
            return new String(bArr3, 0, bArr3.length);
        }
        throw new AssertionError();
    }

    public static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        return a(bytes, bytes.length);
    }

    private static byte[] a(byte[] bArr, int i) {
        int i2;
        int i3;
        byte[] bArr2 = b;
        byte[] bArr3 = new byte[(((i * 3) / 4) + 2)];
        byte[] bArr4 = new byte[4];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i4 >= i) {
                break;
            }
            byte b2 = (byte) (bArr[i4 + 0] & Byte.MAX_VALUE);
            byte b3 = bArr2[b2];
            if (b3 >= -5) {
                if (b3 < -1) {
                    i2 = i5;
                    i3 = i6;
                } else if (b2 == 61) {
                    int i7 = i - i4;
                    byte b4 = (byte) (bArr[(i - 1) + 0] & Byte.MAX_VALUE);
                    if (i5 == 0 || i5 == 1) {
                        throw new b("invalid padding byte '=' at byte offset " + i4);
                    } else if ((i5 == 3 && i7 > 2) || (i5 == 4 && i7 > 1)) {
                        throw new b("padding byte '=' falsely signals end of encoded value at offset " + i4);
                    } else if (b4 != 61 && b4 != 10) {
                        throw new b("encoded value has invalid trailing byte");
                    }
                } else {
                    i2 = i5 + 1;
                    bArr4[i5] = b2;
                    if (i2 == 4) {
                        i3 = a(bArr4, bArr3, i6, bArr2) + i6;
                        i2 = 0;
                    } else {
                        i3 = i6;
                    }
                }
                i4++;
                i6 = i3;
                i5 = i2;
            } else {
                throw new b("Bad Base64 input character at " + i4 + ": " + bArr[i4 + 0] + "(decimal)");
            }
        }
        if (i5 != 0) {
            if (i5 == 1) {
                throw new b("single trailing character at offset " + (i - 1));
            }
            bArr4[i5] = 61;
            i6 += a(bArr4, bArr3, i6, bArr2);
        }
        byte[] bArr5 = new byte[i6];
        System.arraycopy(bArr3, 0, bArr5, 0, i6);
        return bArr5;
    }

    public static byte[] b(byte[] bArr) {
        return a(bArr, bArr.length);
    }
}
