package p000;

import java.io.UnsupportedEncodingException;
import org.apache.commons.lang3.CharEncoding;

/* renamed from: jc */
public final class C1311jc {

    /* renamed from: a */
    private static final byte[] f4560a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b */
    private static final byte[] f4561b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: a */
    public static byte[] m5690a(String str) {
        int i;
        byte b;
        int i2;
        int i3;
        int length = str.length();
        while (length > 0) {
            char charAt = str.charAt(length - 1);
            if (charAt != '=' && charAt != 10 && charAt != 13 && charAt != ' ' && charAt != 9) {
                break;
            }
            length--;
        }
        byte[] bArr = new byte[((int) ((((long) length) * 6) / 8))];
        int i4 = 0;
        byte b2 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            char charAt2 = str.charAt(i4);
            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                i = charAt2 - 'A';
            } else if (charAt2 >= 'a' && charAt2 <= 'z') {
                i = charAt2 - 'G';
            } else if (charAt2 >= '0' && charAt2 <= '9') {
                i = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i = 63;
            } else if (charAt2 == 10 || charAt2 == 13 || charAt2 == ' ') {
                b = b2;
                i2 = i5;
                i3 = i6;
                i4++;
                i6 = i3;
                i5 = i2;
                b2 = b;
            } else if (charAt2 != 9) {
                return null;
            } else {
                b = b2;
                i2 = i5;
                i3 = i6;
                i4++;
                i6 = i3;
                i5 = i2;
                b2 = b;
            }
            b = ((byte) i) | (b2 << 6);
            i2 = i5 + 1;
            if (i2 % 4 == 0) {
                int i7 = i6 + 1;
                bArr[i6] = (byte) (b >> 16);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (b >> 8);
                i3 = i8 + 1;
                bArr[i8] = (byte) b;
            } else {
                i3 = i6;
            }
            i4++;
            i6 = i3;
            i5 = i2;
            b2 = b;
        }
        int i9 = i5 % 4;
        if (i9 == 1) {
            return null;
        }
        if (i9 == 2) {
            bArr[i6] = (byte) ((b2 << 12) >> 16);
            i6++;
        } else if (i9 == 3) {
            int i10 = b2 << 6;
            int i11 = i6 + 1;
            bArr[i6] = (byte) (i10 >> 16);
            i6 = i11 + 1;
            bArr[i11] = (byte) (i10 >> 8);
        }
        if (i6 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, 0, bArr2, 0, i6);
        return bArr2;
    }

    /* renamed from: a */
    public static String m5688a(byte[] bArr) {
        return m5689a(bArr, f4560a);
    }

    /* renamed from: b */
    public static String m5691b(byte[] bArr) {
        return m5689a(bArr, f4561b);
    }

    /* renamed from: a */
    private static String m5689a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        byte[] bArr3 = new byte[(((bArr.length + 2) * 4) / 3)];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            bArr3[i] = bArr2[(bArr[i2] & 255) >> 2];
            int i4 = i3 + 1;
            bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i2 + 1] & 255) >> 4)];
            int i5 = i4 + 1;
            bArr3[i4] = bArr2[((bArr[i2 + 1] & 15) << 2) | ((bArr[i2 + 2] & 255) >> 6)];
            bArr3[i5] = bArr2[bArr[i2 + 2] & 63];
            i2 += 3;
            i = i5 + 1;
        }
        switch (bArr.length % 3) {
            case 1:
                int i6 = i + 1;
                bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
                int i7 = i6 + 1;
                bArr3[i6] = bArr2[(bArr[length] & 3) << 4];
                int i8 = i7 + 1;
                bArr3[i7] = 61;
                i = i8 + 1;
                bArr3[i8] = 61;
                break;
            case 2:
                int i9 = i + 1;
                bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
                int i10 = i9 + 1;
                bArr3[i9] = bArr2[((bArr[length] & 3) << 4) | ((bArr[length + 1] & 255) >> 4)];
                int i11 = i10 + 1;
                bArr3[i10] = bArr2[(bArr[length + 1] & 15) << 2];
                i = i11 + 1;
                bArr3[i11] = 61;
                break;
        }
        try {
            return new String(bArr3, 0, i, CharEncoding.US_ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
