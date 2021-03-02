package com.parse.codec.binary;

public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE;
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] HEX_DECODE_TABLE;
    private static final byte[] HEX_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final int MASK_5BITS = 31;
    private long bitWorkArea;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    static {
        byte[] bArr = new byte[91];
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
        bArr[43] = -1;
        bArr[44] = -1;
        bArr[45] = -1;
        bArr[46] = -1;
        bArr[47] = 63;
        bArr[48] = -1;
        bArr[49] = -1;
        bArr[50] = 26;
        bArr[51] = 27;
        bArr[52] = 28;
        bArr[53] = 29;
        bArr[54] = 30;
        bArr[55] = 31;
        bArr[56] = -1;
        bArr[57] = -1;
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
        DECODE_TABLE = bArr;
        byte[] bArr2 = new byte[88];
        bArr2[0] = -1;
        bArr2[1] = -1;
        bArr2[2] = -1;
        bArr2[3] = -1;
        bArr2[4] = -1;
        bArr2[5] = -1;
        bArr2[6] = -1;
        bArr2[7] = -1;
        bArr2[8] = -1;
        bArr2[9] = -1;
        bArr2[10] = -1;
        bArr2[11] = -1;
        bArr2[12] = -1;
        bArr2[13] = -1;
        bArr2[14] = -1;
        bArr2[15] = -1;
        bArr2[16] = -1;
        bArr2[17] = -1;
        bArr2[18] = -1;
        bArr2[19] = -1;
        bArr2[20] = -1;
        bArr2[21] = -1;
        bArr2[22] = -1;
        bArr2[23] = -1;
        bArr2[24] = -1;
        bArr2[25] = -1;
        bArr2[26] = -1;
        bArr2[27] = -1;
        bArr2[28] = -1;
        bArr2[29] = -1;
        bArr2[30] = -1;
        bArr2[31] = -1;
        bArr2[32] = -1;
        bArr2[33] = -1;
        bArr2[34] = -1;
        bArr2[35] = -1;
        bArr2[36] = -1;
        bArr2[37] = -1;
        bArr2[38] = -1;
        bArr2[39] = -1;
        bArr2[40] = -1;
        bArr2[41] = -1;
        bArr2[42] = -1;
        bArr2[43] = -1;
        bArr2[44] = -1;
        bArr2[45] = -1;
        bArr2[46] = -1;
        bArr2[47] = 63;
        bArr2[49] = 1;
        bArr2[50] = 2;
        bArr2[51] = 3;
        bArr2[52] = 4;
        bArr2[53] = 5;
        bArr2[54] = 6;
        bArr2[55] = 7;
        bArr2[56] = 8;
        bArr2[57] = 9;
        bArr2[58] = -1;
        bArr2[59] = -1;
        bArr2[60] = -1;
        bArr2[61] = -1;
        bArr2[62] = -1;
        bArr2[63] = -1;
        bArr2[64] = -1;
        bArr2[65] = 10;
        bArr2[66] = 11;
        bArr2[67] = 12;
        bArr2[68] = 13;
        bArr2[69] = 14;
        bArr2[70] = 15;
        bArr2[71] = 16;
        bArr2[72] = 17;
        bArr2[73] = 18;
        bArr2[74] = 19;
        bArr2[75] = 20;
        bArr2[76] = 21;
        bArr2[77] = 22;
        bArr2[78] = 23;
        bArr2[79] = 24;
        bArr2[80] = 25;
        bArr2[81] = 26;
        bArr2[82] = 27;
        bArr2[83] = 28;
        bArr2[84] = 29;
        bArr2[85] = 30;
        bArr2[86] = 31;
        bArr2[87] = 32;
        HEX_DECODE_TABLE = bArr2;
    }

    public Base32() {
        this(false);
    }

    public Base32(boolean useHex) {
        this(0, (byte[]) null, useHex);
    }

    public Base32(int lineLength) {
        this(lineLength, CHUNK_SEPARATOR);
    }

    public Base32(int lineLength, byte[] lineSeparator2) {
        this(lineLength, lineSeparator2, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Base32(int lineLength, byte[] lineSeparator2, boolean useHex) {
        super(5, 8, lineLength, lineSeparator2 == null ? 0 : lineSeparator2.length);
        if (useHex) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (lineLength <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else if (lineSeparator2 == null) {
            throw new IllegalArgumentException("lineLength " + lineLength + " > 0, but lineSeparator is null");
        } else if (containsAlphabetOrPad(lineSeparator2)) {
            throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + StringUtils.newStringUtf8(lineSeparator2) + "]");
        } else {
            this.encodeSize = lineSeparator2.length + 8;
            this.lineSeparator = new byte[lineSeparator2.length];
            System.arraycopy(lineSeparator2, 0, this.lineSeparator, 0, lineSeparator2.length);
        }
        this.decodeSize = this.encodeSize - 1;
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
                int inPos3 = inPos2 + 1;
                byte b = in[inPos2];
                if (b == 61) {
                    this.eof = true;
                    break;
                }
                ensureBufferSize(this.decodeSize);
                if (b >= 0 && b < this.decodeTable.length && (result = this.decodeTable[b]) >= 0) {
                    this.modulus = (this.modulus + 1) % 8;
                    this.bitWorkArea = (this.bitWorkArea << 5) + ((long) result);
                    if (this.modulus == 0) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        bArr[i3] = (byte) ((int) ((this.bitWorkArea >> 32) & 255));
                        byte[] bArr2 = this.buffer;
                        int i4 = this.pos;
                        this.pos = i4 + 1;
                        bArr2[i4] = (byte) ((int) ((this.bitWorkArea >> 24) & 255));
                        byte[] bArr3 = this.buffer;
                        int i5 = this.pos;
                        this.pos = i5 + 1;
                        bArr3[i5] = (byte) ((int) ((this.bitWorkArea >> 16) & 255));
                        byte[] bArr4 = this.buffer;
                        int i6 = this.pos;
                        this.pos = i6 + 1;
                        bArr4[i6] = (byte) ((int) ((this.bitWorkArea >> 8) & 255));
                        byte[] bArr5 = this.buffer;
                        int i7 = this.pos;
                        this.pos = i7 + 1;
                        bArr5[i7] = (byte) ((int) (this.bitWorkArea & 255));
                    }
                }
                i++;
                inPos2 = inPos3;
            }
            if (this.eof && this.modulus >= 2) {
                ensureBufferSize(this.decodeSize);
                switch (this.modulus) {
                    case 2:
                        byte[] bArr6 = this.buffer;
                        int i8 = this.pos;
                        this.pos = i8 + 1;
                        bArr6[i8] = (byte) ((int) ((this.bitWorkArea >> 2) & 255));
                        return;
                    case 3:
                        byte[] bArr7 = this.buffer;
                        int i9 = this.pos;
                        this.pos = i9 + 1;
                        bArr7[i9] = (byte) ((int) ((this.bitWorkArea >> 7) & 255));
                        return;
                    case 4:
                        this.bitWorkArea >>= 4;
                        byte[] bArr8 = this.buffer;
                        int i10 = this.pos;
                        this.pos = i10 + 1;
                        bArr8[i10] = (byte) ((int) ((this.bitWorkArea >> 8) & 255));
                        byte[] bArr9 = this.buffer;
                        int i11 = this.pos;
                        this.pos = i11 + 1;
                        bArr9[i11] = (byte) ((int) (this.bitWorkArea & 255));
                        return;
                    case 5:
                        this.bitWorkArea >>= 1;
                        byte[] bArr10 = this.buffer;
                        int i12 = this.pos;
                        this.pos = i12 + 1;
                        bArr10[i12] = (byte) ((int) ((this.bitWorkArea >> 16) & 255));
                        byte[] bArr11 = this.buffer;
                        int i13 = this.pos;
                        this.pos = i13 + 1;
                        bArr11[i13] = (byte) ((int) ((this.bitWorkArea >> 8) & 255));
                        byte[] bArr12 = this.buffer;
                        int i14 = this.pos;
                        this.pos = i14 + 1;
                        bArr12[i14] = (byte) ((int) (this.bitWorkArea & 255));
                        return;
                    case 6:
                        this.bitWorkArea >>= 6;
                        byte[] bArr13 = this.buffer;
                        int i15 = this.pos;
                        this.pos = i15 + 1;
                        bArr13[i15] = (byte) ((int) ((this.bitWorkArea >> 16) & 255));
                        byte[] bArr14 = this.buffer;
                        int i16 = this.pos;
                        this.pos = i16 + 1;
                        bArr14[i16] = (byte) ((int) ((this.bitWorkArea >> 8) & 255));
                        byte[] bArr15 = this.buffer;
                        int i17 = this.pos;
                        this.pos = i17 + 1;
                        bArr15[i17] = (byte) ((int) (this.bitWorkArea & 255));
                        return;
                    case 7:
                        this.bitWorkArea >>= 3;
                        byte[] bArr16 = this.buffer;
                        int i18 = this.pos;
                        this.pos = i18 + 1;
                        bArr16[i18] = (byte) ((int) ((this.bitWorkArea >> 24) & 255));
                        byte[] bArr17 = this.buffer;
                        int i19 = this.pos;
                        this.pos = i19 + 1;
                        bArr17[i19] = (byte) ((int) ((this.bitWorkArea >> 16) & 255));
                        byte[] bArr18 = this.buffer;
                        int i20 = this.pos;
                        this.pos = i20 + 1;
                        bArr18[i20] = (byte) ((int) ((this.bitWorkArea >> 8) & 255));
                        byte[] bArr19 = this.buffer;
                        int i21 = this.pos;
                        this.pos = i21 + 1;
                        bArr19[i21] = (byte) ((int) (this.bitWorkArea & 255));
                        return;
                    default:
                        return;
                }
            }
        }
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
            boolean r4 = r10.eof
            if (r4 == 0) goto L_0x0005
        L_0x0004:
            return
        L_0x0005:
            if (r13 >= 0) goto L_0x0276
            r4 = 1
            r10.eof = r4
            int r4 = r10.modulus
            if (r4 != 0) goto L_0x0012
            int r4 = r10.lineLength
            if (r4 == 0) goto L_0x0004
        L_0x0012:
            int r4 = r10.encodeSize
            r10.ensureBufferSize(r4)
            int r3 = r10.pos
            int r4 = r10.modulus
            switch(r4) {
                case 1: goto L_0x0044;
                case 2: goto L_0x00b8;
                case 3: goto L_0x013f;
                case 4: goto L_0x01d1;
                default: goto L_0x001e;
            }
        L_0x001e:
            int r4 = r10.currentLinePos
            int r5 = r10.pos
            int r5 = r5 - r3
            int r4 = r4 + r5
            r10.currentLinePos = r4
            int r4 = r10.lineLength
            if (r4 <= 0) goto L_0x0004
            int r4 = r10.currentLinePos
            if (r4 <= 0) goto L_0x0004
            byte[] r4 = r10.lineSeparator
            r5 = 0
            byte[] r6 = r10.buffer
            int r7 = r10.pos
            byte[] r8 = r10.lineSeparator
            int r8 = r8.length
            java.lang.System.arraycopy(r4, r5, r6, r7, r8)
            int r4 = r10.pos
            byte[] r5 = r10.lineSeparator
            int r5 = r5.length
            int r4 = r4 + r5
            r10.pos = r4
            goto L_0x0004
        L_0x0044:
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 3
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 2
            long r7 = r7 << r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            goto L_0x001e
        L_0x00b8:
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 11
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 6
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 1
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 4
            long r7 = r7 << r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            goto L_0x001e
        L_0x013f:
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 19
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 14
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 9
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 4
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 1
            long r7 = r7 << r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            goto L_0x001e
        L_0x01d1:
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 27
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 22
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 17
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 12
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 7
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 2
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 3
            long r7 = r7 << r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            r6 = 61
            r4[r5] = r6
            goto L_0x001e
        L_0x0276:
            r1 = 0
            r2 = r12
        L_0x0278:
            if (r1 < r13) goto L_0x027d
            r12 = r2
            goto L_0x0004
        L_0x027d:
            int r4 = r10.encodeSize
            r10.ensureBufferSize(r4)
            int r4 = r10.modulus
            int r4 = r4 + 1
            int r4 = r4 % 5
            r10.modulus = r4
            int r12 = r2 + 1
            byte r0 = r11[r2]
            if (r0 >= 0) goto L_0x0292
            int r0 = r0 + 256
        L_0x0292:
            long r4 = r10.bitWorkArea
            r6 = 8
            long r4 = r4 << r6
            long r6 = (long) r0
            long r4 = r4 + r6
            r10.bitWorkArea = r4
            int r4 = r10.modulus
            if (r4 != 0) goto L_0x0373
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 35
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 30
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 25
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 20
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 15
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 10
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            r9 = 5
            long r7 = r7 >> r9
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            byte[] r4 = r10.buffer
            int r5 = r10.pos
            int r6 = r5 + 1
            r10.pos = r6
            byte[] r6 = r10.encodeTable
            long r7 = r10.bitWorkArea
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r4[r5] = r6
            int r4 = r10.currentLinePos
            int r4 = r4 + 8
            r10.currentLinePos = r4
            int r4 = r10.lineLength
            if (r4 <= 0) goto L_0x0373
            int r4 = r10.lineLength
            int r5 = r10.currentLinePos
            if (r4 > r5) goto L_0x0373
            byte[] r4 = r10.lineSeparator
            r5 = 0
            byte[] r6 = r10.buffer
            int r7 = r10.pos
            byte[] r8 = r10.lineSeparator
            int r8 = r8.length
            java.lang.System.arraycopy(r4, r5, r6, r7, r8)
            int r4 = r10.pos
            byte[] r5 = r10.lineSeparator
            int r5 = r5.length
            int r4 = r4 + r5
            r10.pos = r4
            r4 = 0
            r10.currentLinePos = r4
        L_0x0373:
            int r1 = r1 + 1
            r2 = r12
            goto L_0x0278
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.codec.binary.Base32.encode(byte[], int, int):void");
    }

    public boolean isInAlphabet(byte octet) {
        return octet >= 0 && octet < this.decodeTable.length && this.decodeTable[octet] != -1;
    }
}
