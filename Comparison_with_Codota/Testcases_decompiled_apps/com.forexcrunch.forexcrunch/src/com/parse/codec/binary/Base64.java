package com.parse.codec.binary;

import android.support.p000v4.view.MotionEventCompat;
import com.parse.ParseException;
import java.math.BigInteger;

public class Base64 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE;
    private static final int MASK_6BITS = 63;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private int bitWorkArea;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    static {
        byte[] bArr = new byte[ParseException.INVALID_ACL];
        bArr[0] = -1;
        bArr[1] = -1;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = -1;
        bArr[5] = -1;
        bArr[6] = -1;
        bArr[7] = -1;
        bArr[8] = -1;
        bArr[9] = -1;
        bArr[10] = -1;
        bArr[11] = -1;
        bArr[12] = -1;
        bArr[13] = -1;
        bArr[14] = -1;
        bArr[15] = -1;
        bArr[16] = -1;
        bArr[17] = -1;
        bArr[18] = -1;
        bArr[19] = -1;
        bArr[20] = -1;
        bArr[21] = -1;
        bArr[22] = -1;
        bArr[23] = -1;
        bArr[24] = -1;
        bArr[25] = -1;
        bArr[26] = -1;
        bArr[27] = -1;
        bArr[28] = -1;
        bArr[29] = -1;
        bArr[30] = -1;
        bArr[31] = -1;
        bArr[32] = -1;
        bArr[33] = -1;
        bArr[34] = -1;
        bArr[35] = -1;
        bArr[36] = -1;
        bArr[37] = -1;
        bArr[38] = -1;
        bArr[39] = -1;
        bArr[40] = -1;
        bArr[41] = -1;
        bArr[42] = -1;
        bArr[43] = 62;
        bArr[44] = -1;
        bArr[45] = 62;
        bArr[46] = -1;
        bArr[47] = 63;
        bArr[48] = 52;
        bArr[49] = 53;
        bArr[50] = 54;
        bArr[51] = 55;
        bArr[52] = 56;
        bArr[53] = 57;
        bArr[54] = 58;
        bArr[55] = 59;
        bArr[56] = 60;
        bArr[57] = 61;
        bArr[58] = -1;
        bArr[59] = -1;
        bArr[60] = -1;
        bArr[61] = -1;
        bArr[62] = -1;
        bArr[63] = -1;
        bArr[64] = -1;
        bArr[66] = 1;
        bArr[67] = 2;
        bArr[68] = 3;
        bArr[69] = 4;
        bArr[70] = 5;
        bArr[71] = 6;
        bArr[72] = 7;
        bArr[73] = 8;
        bArr[74] = 9;
        bArr[75] = 10;
        bArr[76] = 11;
        bArr[77] = 12;
        bArr[78] = 13;
        bArr[79] = 14;
        bArr[80] = 15;
        bArr[81] = 16;
        bArr[82] = 17;
        bArr[83] = 18;
        bArr[84] = 19;
        bArr[85] = 20;
        bArr[86] = 21;
        bArr[87] = 22;
        bArr[88] = 23;
        bArr[89] = 24;
        bArr[90] = 25;
        bArr[91] = -1;
        bArr[92] = -1;
        bArr[93] = -1;
        bArr[94] = -1;
        bArr[95] = 63;
        bArr[96] = -1;
        bArr[97] = 26;
        bArr[98] = 27;
        bArr[99] = 28;
        bArr[100] = 29;
        bArr[101] = 30;
        bArr[102] = 31;
        bArr[103] = 32;
        bArr[104] = 33;
        bArr[105] = 34;
        bArr[106] = 35;
        bArr[107] = 36;
        bArr[108] = 37;
        bArr[109] = 38;
        bArr[110] = 39;
        bArr[111] = 40;
        bArr[112] = 41;
        bArr[113] = 42;
        bArr[114] = 43;
        bArr[115] = 44;
        bArr[116] = 45;
        bArr[117] = 46;
        bArr[118] = 47;
        bArr[119] = 48;
        bArr[120] = 49;
        bArr[121] = 50;
        bArr[122] = 51;
        DECODE_TABLE = bArr;
    }

    public Base64() {
        this(0);
    }

    public Base64(boolean urlSafe) {
        this(76, CHUNK_SEPARATOR, urlSafe);
    }

    public Base64(int lineLength) {
        this(lineLength, CHUNK_SEPARATOR);
    }

    public Base64(int lineLength, byte[] lineSeparator2) {
        this(lineLength, lineSeparator2, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Base64(int r7, byte[] r8, boolean r9) {
        /*
            r6 = this;
            r5 = 0
            r4 = 4
            r2 = 0
            r3 = 3
            if (r8 != 0) goto L_0x0035
            r1 = r2
        L_0x0007:
            r6.<init>(r3, r4, r7, r1)
            byte[] r1 = DECODE_TABLE
            r6.decodeTable = r1
            if (r8 == 0) goto L_0x005b
            boolean r1 = r6.containsAlphabetOrPad(r8)
            if (r1 == 0) goto L_0x0037
            java.lang.String r0 = com.parse.codec.binary.StringUtils.newStringUtf8(r8)
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "lineSeparator must not contain base64 characters: ["
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = "]"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0035:
            int r1 = r8.length
            goto L_0x0007
        L_0x0037:
            if (r7 <= 0) goto L_0x0056
            int r1 = r8.length
            int r1 = r1 + 4
            r6.encodeSize = r1
            int r1 = r8.length
            byte[] r1 = new byte[r1]
            r6.lineSeparator = r1
            byte[] r1 = r6.lineSeparator
            int r3 = r8.length
            java.lang.System.arraycopy(r8, r2, r1, r2, r3)
        L_0x0049:
            int r1 = r6.encodeSize
            int r1 = r1 + -1
            r6.decodeSize = r1
            if (r9 == 0) goto L_0x0060
            byte[] r1 = URL_SAFE_ENCODE_TABLE
        L_0x0053:
            r6.encodeTable = r1
            return
        L_0x0056:
            r6.encodeSize = r4
            r6.lineSeparator = r5
            goto L_0x0049
        L_0x005b:
            r6.encodeSize = r4
            r6.lineSeparator = r5
            goto L_0x0049
        L_0x0060:
            byte[] r1 = STANDARD_ENCODE_TABLE
            goto L_0x0053
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.codec.binary.Base64.<init>(int, byte[], boolean):void");
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r11, int r12, int r13) {
        /*
            r10 = this;
            r9 = 61
            r8 = 0
            boolean r4 = r10.eof
            if (r4 == 0) goto L_0x0008
        L_0x0007:
            return
        L_0x0008:
            if (r13 >= 0) goto L_0x00d7
            r4 = 1
            r10.eof = r4
            int r4 = r10.modulus
            if (r4 != 0) goto L_0x0015
            int r4 = r10.lineLength
            if (r4 == 0) goto L_0x0007
        L_0x0015:
            int r4 = r10.encodeSize
            r10.ensureBufferSize(r4)
            int r3 = r10.pos
            int r4 = r10.modulus
            switch(r4) {
                case 1: goto L_0x0046;
                case 2: goto L_0x0089;
                default: goto L_0x0021;
            }
        L_0x0021:
            int r4 = r10.currentLinePos
            int r5 = r10.pos
            int r5 = r5 - r3
            int r4 = r4 + r5
            r10.currentLinePos = r4
            int r4 = r10.lineLength
            if (r4 <= 0) goto L_0x0007
            int r4 = r10.currentLinePos
            if (r4 <= 0) goto L_0x0007
            byte[] r4 = r10.lineSeparator
            byte[] r5 = r10.buffer
            int r6 = r10.pos
            byte[] r7 = r10.lineSeparator
            int r7 = r7.length
            java.lang.System.arraycopy(r4, r8, r5, r6, r7)
            int r4 = r10.pos
            byte[] r5 = r10.lineSeparator
            int r5 = r5.length
            int r4 = r4 + r5
            r10.pos = r4
            goto L_0x0007
        L_0x0046:
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            int r7 = r10.bitWorkArea
            int r7 = r7 >> 2
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            int r7 = r10.bitWorkArea
            int r7 = r7 << 4
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.encodeTable
            byte[] r5 = STANDARD_ENCODE_TABLE
            if (r4 != r5) goto L_0x0021
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r4[r5] = r9
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r4[r5] = r9
            goto L_0x0021
        L_0x0089:
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            int r7 = r10.bitWorkArea
            int r7 = r7 >> 10
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            int r7 = r10.bitWorkArea
            int r7 = r7 >> 4
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            int r7 = r10.bitWorkArea
            int r7 = r7 << 2
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.encodeTable
            byte[] r5 = STANDARD_ENCODE_TABLE
            if (r4 != r5) goto L_0x0021
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r4[r5] = r9
            goto L_0x0021
        L_0x00d7:
            r1 = 0
            r2 = r12
        L_0x00d9:
            if (r1 < r13) goto L_0x00de
            r12 = r2
            goto L_0x0007
        L_0x00de:
            int r4 = r10.encodeSize
            r10.ensureBufferSize(r4)
            int r4 = r10.modulus
            int r4 = r4 + 1
            int r4 = r4 % 3
            r10.modulus = r4
            int r12 = r2 + 1
            byte r0 = r11[r2]
            if (r0 >= 0) goto L_0x00f3
            int r0 = r0 + 256
        L_0x00f3:
            int r4 = r10.bitWorkArea
            int r4 = r4 << 8
            int r4 = r4 + r0
            r10.bitWorkArea = r4
            int r4 = r10.modulus
            if (r4 != 0) goto L_0x0172
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            int r7 = r10.bitWorkArea
            int r7 = r7 >> 18
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            int r7 = r10.bitWorkArea
            int r7 = r7 >> 12
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            int r7 = r10.bitWorkArea
            int r7 = r7 >> 6
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            int r7 = r10.bitWorkArea
            r7 = r7 & 63
            byte r6 = r6[r7]
            r4[r5] = r6
            int r4 = r10.currentLinePos
            int r4 = r4 + 4
            r10.currentLinePos = r4
            int r4 = r10.lineLength
            if (r4 <= 0) goto L_0x0172
            int r4 = r10.lineLength
            int r5 = r10.currentLinePos
            if (r4 > r5) goto L_0x0172
            byte[] r4 = r10.lineSeparator
            byte[] r5 = r10.buffer
            int r6 = r10.pos
            byte[] r7 = r10.lineSeparator
            int r7 = r7.length
            java.lang.System.arraycopy(r4, r8, r5, r6, r7)
            int r4 = r10.pos
            byte[] r5 = r10.lineSeparator
            int r5 = r5.length
            int r4 = r4 + r5
            r10.pos = r4
            r10.currentLinePos = r8
        L_0x0172:
            int r1 = r1 + 1
            r2 = r12
            goto L_0x00d9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.codec.binary.Base64.encode(byte[], int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void decode(byte[] in, int inPos, int inAvail) {
        byte result;
        if (!this.eof) {
            if (inAvail < 0) {
                this.eof = true;
            }
            int i = 0;
            int inPos2 = inPos;
            while (true) {
                if (i >= inAvail) {
                    int i2 = inPos2;
                    break;
                }
                ensureBufferSize(this.decodeSize);
                int inPos3 = inPos2 + 1;
                byte b = in[inPos2];
                if (b == 61) {
                    this.eof = true;
                    break;
                }
                if (b >= 0 && b < DECODE_TABLE.length && (result = DECODE_TABLE[b]) >= 0) {
                    this.modulus = (this.modulus + 1) % 4;
                    this.bitWorkArea = (this.bitWorkArea << 6) + result;
                    if (this.modulus == 0) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        bArr[i3] = (byte) ((this.bitWorkArea >> 16) & MotionEventCompat.ACTION_MASK);
                        byte[] bArr2 = this.buffer;
                        int i4 = this.pos;
                        this.pos = i4 + 1;
                        bArr2[i4] = (byte) ((this.bitWorkArea >> 8) & MotionEventCompat.ACTION_MASK);
                        byte[] bArr3 = this.buffer;
                        int i5 = this.pos;
                        this.pos = i5 + 1;
                        bArr3[i5] = (byte) (this.bitWorkArea & MotionEventCompat.ACTION_MASK);
                    }
                }
                i++;
                inPos2 = inPos3;
            }
            if (this.eof && this.modulus != 0) {
                ensureBufferSize(this.decodeSize);
                switch (this.modulus) {
                    case 2:
                        this.bitWorkArea >>= 4;
                        byte[] bArr4 = this.buffer;
                        int i6 = this.pos;
                        this.pos = i6 + 1;
                        bArr4[i6] = (byte) (this.bitWorkArea & MotionEventCompat.ACTION_MASK);
                        return;
                    case 3:
                        this.bitWorkArea >>= 2;
                        byte[] bArr5 = this.buffer;
                        int i7 = this.pos;
                        this.pos = i7 + 1;
                        bArr5[i7] = (byte) ((this.bitWorkArea >> 8) & MotionEventCompat.ACTION_MASK);
                        byte[] bArr6 = this.buffer;
                        int i8 = this.pos;
                        this.pos = i8 + 1;
                        bArr6[i8] = (byte) (this.bitWorkArea & MotionEventCompat.ACTION_MASK);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static boolean isBase64(byte octet) {
        return octet == 61 || (octet >= 0 && octet < DECODE_TABLE.length && DECODE_TABLE[octet] != -1);
    }

    public static boolean isBase64(String base64) {
        return isBase64(StringUtils.getBytesUtf8(base64));
    }

    public static boolean isArrayByteBase64(byte[] arrayOctet) {
        return isBase64(arrayOctet);
    }

    public static boolean isBase64(byte[] arrayOctet) {
        for (int i = 0; i < arrayOctet.length; i++) {
            if (!isBase64(arrayOctet[i]) && !isWhiteSpace(arrayOctet[i])) {
                return false;
            }
        }
        return true;
    }

    public static byte[] encodeBase64(byte[] binaryData) {
        return encodeBase64(binaryData, false);
    }

    public static String encodeBase64String(byte[] binaryData) {
        return StringUtils.newStringUtf8(encodeBase64(binaryData, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] binaryData) {
        return encodeBase64(binaryData, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] binaryData) {
        return StringUtils.newStringUtf8(encodeBase64(binaryData, false, true));
    }

    public static byte[] encodeBase64Chunked(byte[] binaryData) {
        return encodeBase64(binaryData, true);
    }

    public static byte[] encodeBase64(byte[] binaryData, boolean isChunked) {
        return encodeBase64(binaryData, isChunked, false);
    }

    public static byte[] encodeBase64(byte[] binaryData, boolean isChunked, boolean urlSafe) {
        return encodeBase64(binaryData, isChunked, urlSafe, Integer.MAX_VALUE);
    }

    public static byte[] encodeBase64(byte[] binaryData, boolean isChunked, boolean urlSafe, int maxResultSize) {
        if (binaryData == null || binaryData.length == 0) {
            return binaryData;
        }
        Base64 b64 = isChunked ? new Base64(urlSafe) : new Base64(0, CHUNK_SEPARATOR, urlSafe);
        long len = b64.getEncodedLength(binaryData);
        if (len <= ((long) maxResultSize)) {
            return b64.encode(binaryData);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + len + ") than the specified maximum size of " + maxResultSize);
    }

    public static byte[] decodeBase64(String base64String) {
        return new Base64().decode(base64String);
    }

    public static byte[] decodeBase64(byte[] base64Data) {
        return new Base64().decode(base64Data);
    }

    public static BigInteger decodeInteger(byte[] pArray) {
        return new BigInteger(1, decodeBase64(pArray));
    }

    public static byte[] encodeInteger(BigInteger bigInt) {
        if (bigInt != null) {
            return encodeBase64(toIntegerBytes(bigInt), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    static byte[] toIntegerBytes(BigInteger bigInt) {
        int bitlen = ((bigInt.bitLength() + 7) >> 3) << 3;
        byte[] bigBytes = bigInt.toByteArray();
        if (bigInt.bitLength() % 8 != 0 && (bigInt.bitLength() / 8) + 1 == bitlen / 8) {
            return bigBytes;
        }
        int startSrc = 0;
        int len = bigBytes.length;
        if (bigInt.bitLength() % 8 == 0) {
            startSrc = 1;
            len--;
        }
        byte[] resizedBytes = new byte[(bitlen / 8)];
        System.arraycopy(bigBytes, startSrc, resizedBytes, (bitlen / 8) - len, len);
        return resizedBytes;
    }

    /* access modifiers changed from: protected */
    public boolean isInAlphabet(byte octet) {
        return octet >= 0 && octet < this.decodeTable.length && this.decodeTable[octet] != -1;
    }
}
