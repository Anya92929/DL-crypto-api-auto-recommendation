package com.fasterxml.jackson.core.p003io;

import android.support.p000v4.view.MotionEventCompat;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.lang.ref.SoftReference;

/* renamed from: com.fasterxml.jackson.core.io.JsonStringEncoder */
public final class JsonStringEncoder {
    private static final byte[] HEX_BYTES = CharTypes.copyHexBytes();
    private static final char[] HEX_CHARS = CharTypes.copyHexChars();
    private static final int INT_0 = 48;
    private static final int INT_BACKSLASH = 92;
    private static final int INT_U = 117;
    private static final int SURR1_FIRST = 55296;
    private static final int SURR1_LAST = 56319;
    private static final int SURR2_FIRST = 56320;
    private static final int SURR2_LAST = 57343;
    protected static final ThreadLocal<SoftReference<JsonStringEncoder>> _threadEncoder = new ThreadLocal<>();
    protected ByteArrayBuilder _byteBuilder;
    protected final char[] _quoteBuffer = new char[6];
    protected TextBuffer _textBuffer;

    public JsonStringEncoder() {
        this._quoteBuffer[0] = '\\';
        this._quoteBuffer[2] = '0';
        this._quoteBuffer[3] = '0';
    }

    public static JsonStringEncoder getInstance() {
        SoftReference<JsonStringEncoder> ref = _threadEncoder.get();
        JsonStringEncoder enc = ref == null ? null : ref.get();
        if (enc != null) {
            return enc;
        }
        JsonStringEncoder enc2 = new JsonStringEncoder();
        _threadEncoder.set(new SoftReference(enc2));
        return enc2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
        if ((r10 + r9) <= r12.length) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004a, code lost:
        r5 = r12.length - r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004d, code lost:
        if (r5 <= 0) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
        java.lang.System.arraycopy(r17._quoteBuffer, 0, r12, r10, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r12 = r14.finishCurrentSegment();
        r13 = r9 - r5;
        java.lang.System.arraycopy(r17._quoteBuffer, r5, r12, 0, r13);
        r10 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0089, code lost:
        java.lang.System.arraycopy(r17._quoteBuffer, 0, r12, r10, r9);
        r10 = r10 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        r7 = r6 + 1;
        r9 = _appendSingleEscape(r4[r18.charAt(r6)], r17._quoteBuffer);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char[] quoteAsString(java.lang.String r18) {
        /*
            r17 = this;
            r0 = r17
            com.fasterxml.jackson.core.util.TextBuffer r14 = r0._textBuffer
            if (r14 != 0) goto L_0x0010
            com.fasterxml.jackson.core.util.TextBuffer r14 = new com.fasterxml.jackson.core.util.TextBuffer
            r15 = 0
            r14.<init>(r15)
            r0 = r17
            r0._textBuffer = r14
        L_0x0010:
            char[] r12 = r14.emptyAndGetCurrentSegment()
            int[] r4 = com.fasterxml.jackson.core.p003io.CharTypes.get7BitOutputEscapes()
            int r3 = r4.length
            r6 = 0
            int r8 = r18.length()
            r10 = 0
        L_0x001f:
            if (r6 >= r8) goto L_0x007f
        L_0x0021:
            r0 = r18
            char r1 = r0.charAt(r6)
            if (r1 >= r3) goto L_0x006e
            r15 = r4[r1]
            if (r15 == 0) goto L_0x006e
            int r7 = r6 + 1
            r0 = r18
            char r15 = r0.charAt(r6)
            r2 = r4[r15]
            r0 = r17
            char[] r15 = r0._quoteBuffer
            r0 = r17
            int r9 = r0._appendSingleEscape(r2, r15)
            int r15 = r10 + r9
            int r0 = r12.length
            r16 = r0
            r0 = r16
            if (r15 <= r0) goto L_0x0089
            int r15 = r12.length
            int r5 = r15 - r10
            if (r5 <= 0) goto L_0x005a
            r0 = r17
            char[] r15 = r0._quoteBuffer
            r16 = 0
            r0 = r16
            java.lang.System.arraycopy(r15, r0, r12, r10, r5)
        L_0x005a:
            char[] r12 = r14.finishCurrentSegment()
            int r13 = r9 - r5
            r0 = r17
            char[] r15 = r0._quoteBuffer
            r16 = 0
            r0 = r16
            java.lang.System.arraycopy(r15, r5, r12, r0, r13)
            r10 = r13
        L_0x006c:
            r6 = r7
            goto L_0x001f
        L_0x006e:
            int r15 = r12.length
            if (r10 < r15) goto L_0x0076
            char[] r12 = r14.finishCurrentSegment()
            r10 = 0
        L_0x0076:
            int r11 = r10 + 1
            r12[r10] = r1
            int r6 = r6 + 1
            if (r6 < r8) goto L_0x0087
            r10 = r11
        L_0x007f:
            r14.setCurrentLength(r10)
            char[] r15 = r14.contentsAsArray()
            return r15
        L_0x0087:
            r10 = r11
            goto L_0x0021
        L_0x0089:
            r0 = r17
            char[] r15 = r0._quoteBuffer
            r16 = 0
            r0 = r16
            java.lang.System.arraycopy(r15, r0, r12, r10, r9)
            int r10 = r10 + r9
            goto L_0x006c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p003io.JsonStringEncoder.quoteAsString(java.lang.String):char[]");
    }

    public byte[] quoteAsUTF8(String text) {
        int outputPtr;
        int ch;
        int outputPtr2;
        int outputPtr3;
        int outputPtr4;
        ByteArrayBuilder byteBuilder = this._byteBuilder;
        if (byteBuilder == null) {
            byteBuilder = new ByteArrayBuilder((BufferRecycler) null);
            this._byteBuilder = byteBuilder;
        }
        int inputPtr = 0;
        int inputEnd = text.length();
        int outputPtr5 = 0;
        byte[] outputBuffer = byteBuilder.resetAndGetFirstSegment();
        loop0:
        while (true) {
            if (inputPtr >= inputEnd) {
                break;
            }
            int[] escCodes = CharTypes.get7BitOutputEscapes();
            while (true) {
                int ch2 = text.charAt(inputPtr);
                if (ch2 <= 127 && escCodes[ch2] == 0) {
                    if (outputPtr5 >= outputBuffer.length) {
                        outputBuffer = byteBuilder.finishCurrentSegment();
                        outputPtr5 = 0;
                    }
                    int outputPtr6 = outputPtr5 + 1;
                    outputBuffer[outputPtr5] = (byte) ch2;
                    inputPtr++;
                    if (inputPtr >= inputEnd) {
                        outputPtr5 = outputPtr6;
                        break loop0;
                    }
                    outputPtr5 = outputPtr6;
                }
            }
            if (outputPtr5 >= outputBuffer.length) {
                outputBuffer = byteBuilder.finishCurrentSegment();
                outputPtr5 = 0;
            }
            int inputPtr2 = inputPtr + 1;
            int ch3 = text.charAt(inputPtr);
            if (ch3 <= 127) {
                outputPtr5 = _appendByteEscape(ch3, escCodes[ch3], byteBuilder, outputPtr5);
                outputBuffer = byteBuilder.getCurrentSegment();
                inputPtr = inputPtr2;
            } else {
                if (ch3 <= 2047) {
                    outputBuffer[outputPtr5] = (byte) ((ch3 >> 6) | 192);
                    ch = (ch3 & 63) | 128;
                    outputPtr2 = outputPtr5 + 1;
                    inputPtr = inputPtr2;
                } else if (ch3 < SURR1_FIRST || ch3 > SURR2_LAST) {
                    int outputPtr7 = outputPtr5 + 1;
                    outputBuffer[outputPtr5] = (byte) ((ch3 >> 12) | 224);
                    if (outputPtr7 >= outputBuffer.length) {
                        outputBuffer = byteBuilder.finishCurrentSegment();
                        outputPtr = 0;
                    } else {
                        outputPtr = outputPtr7;
                    }
                    outputBuffer[outputPtr] = (byte) (((ch3 >> 6) & 63) | 128);
                    ch = (ch3 & 63) | 128;
                    outputPtr2 = outputPtr + 1;
                    inputPtr = inputPtr2;
                } else {
                    if (ch3 > SURR1_LAST) {
                        _throwIllegalSurrogate(ch3);
                    }
                    if (inputPtr2 >= inputEnd) {
                        _throwIllegalSurrogate(ch3);
                    }
                    inputPtr = inputPtr2 + 1;
                    int ch4 = _convertSurrogate(ch3, text.charAt(inputPtr2));
                    if (ch4 > 1114111) {
                        _throwIllegalSurrogate(ch4);
                    }
                    int outputPtr8 = outputPtr5 + 1;
                    outputBuffer[outputPtr5] = (byte) ((ch4 >> 18) | 240);
                    if (outputPtr8 >= outputBuffer.length) {
                        outputBuffer = byteBuilder.finishCurrentSegment();
                        outputPtr3 = 0;
                    } else {
                        outputPtr3 = outputPtr8;
                    }
                    int outputPtr9 = outputPtr3 + 1;
                    outputBuffer[outputPtr3] = (byte) (((ch4 >> 12) & 63) | 128);
                    if (outputPtr9 >= outputBuffer.length) {
                        outputBuffer = byteBuilder.finishCurrentSegment();
                        outputPtr4 = 0;
                    } else {
                        outputPtr4 = outputPtr9;
                    }
                    outputBuffer[outputPtr4] = (byte) (((ch4 >> 6) & 63) | 128);
                    ch = (ch4 & 63) | 128;
                    outputPtr2 = outputPtr4 + 1;
                }
                if (outputPtr2 >= outputBuffer.length) {
                    outputBuffer = byteBuilder.finishCurrentSegment();
                    outputPtr2 = 0;
                }
                outputBuffer[outputPtr2] = (byte) ch;
                outputPtr5 = outputPtr2 + 1;
            }
        }
        return this._byteBuilder.completeAndCoalesce(outputPtr5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        if (r7 < r6) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        r5 = r0.finishCurrentSegment();
        r6 = r5.length;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (r1 >= 2048) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        r7 = r8 + 1;
        r5[r8] = (byte) ((r1 >> 6) | 192);
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        if (r7 < r6) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005f, code lost:
        r5 = r0.finishCurrentSegment();
        r6 = r5.length;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0074, code lost:
        if (r1 < SURR1_FIRST) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0079, code lost:
        if (r1 <= SURR2_LAST) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007b, code lost:
        r7 = r8 + 1;
        r5[r8] = (byte) ((r1 >> 12) | 224);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        if (r7 < r6) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
        r5 = r0.finishCurrentSegment();
        r6 = r5.length;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008c, code lost:
        r5[r7] = (byte) (((r1 >> 6) & 63) | 128);
        r7 = r7 + 1;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        if (r1 <= SURR1_LAST) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009f, code lost:
        _throwIllegalSurrogate(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a2, code lost:
        if (r4 < r2) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        _throwIllegalSurrogate(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        r3 = r4 + 1;
        r1 = _convertSurrogate(r1, r11.charAt(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b4, code lost:
        if (r1 <= 1114111) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b6, code lost:
        _throwIllegalSurrogate(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b9, code lost:
        r7 = r8 + 1;
        r5[r8] = (byte) ((r1 >> 18) | 240);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c2, code lost:
        if (r7 < r6) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c4, code lost:
        r5 = r0.finishCurrentSegment();
        r6 = r5.length;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ca, code lost:
        r8 = r7 + 1;
        r5[r7] = (byte) (((r1 >> 12) & 63) | 128);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d5, code lost:
        if (r8 < r6) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d7, code lost:
        r5 = r0.finishCurrentSegment();
        r6 = r5.length;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00dd, code lost:
        r5[r7] = (byte) (((r1 >> 6) & 63) | 128);
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00eb, code lost:
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ed, code lost:
        r8 = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] encodeAsUTF8(java.lang.String r11) {
        /*
            r10 = this;
            com.fasterxml.jackson.core.util.ByteArrayBuilder r0 = r10._byteBuilder
            if (r0 != 0) goto L_0x000c
            com.fasterxml.jackson.core.util.ByteArrayBuilder r0 = new com.fasterxml.jackson.core.util.ByteArrayBuilder
            r9 = 0
            r0.<init>((com.fasterxml.jackson.core.util.BufferRecycler) r9)
            r10._byteBuilder = r0
        L_0x000c:
            r3 = 0
            int r2 = r11.length()
            r7 = 0
            byte[] r5 = r0.resetAndGetFirstSegment()
            int r6 = r5.length
            r4 = r3
        L_0x0018:
            if (r4 >= r2) goto L_0x00f0
            int r3 = r4 + 1
            char r1 = r11.charAt(r4)
            r4 = r3
        L_0x0021:
            r9 = 127(0x7f, float:1.78E-43)
            if (r1 > r9) goto L_0x0046
            if (r7 < r6) goto L_0x002d
            byte[] r5 = r0.finishCurrentSegment()
            int r6 = r5.length
            r7 = 0
        L_0x002d:
            int r8 = r7 + 1
            byte r9 = (byte) r1
            r5[r7] = r9
            if (r4 < r2) goto L_0x003d
            r7 = r8
            r3 = r4
        L_0x0036:
            com.fasterxml.jackson.core.util.ByteArrayBuilder r9 = r10._byteBuilder
            byte[] r9 = r9.completeAndCoalesce(r7)
            return r9
        L_0x003d:
            int r3 = r4 + 1
            char r1 = r11.charAt(r4)
            r7 = r8
            r4 = r3
            goto L_0x0021
        L_0x0046:
            if (r7 < r6) goto L_0x00ed
            byte[] r5 = r0.finishCurrentSegment()
            int r6 = r5.length
            r7 = 0
            r8 = r7
        L_0x004f:
            r9 = 2048(0x800, float:2.87E-42)
            if (r1 >= r9) goto L_0x0071
            int r7 = r8 + 1
            int r9 = r1 >> 6
            r9 = r9 | 192(0xc0, float:2.69E-43)
            byte r9 = (byte) r9
            r5[r8] = r9
            r3 = r4
        L_0x005d:
            if (r7 < r6) goto L_0x0065
            byte[] r5 = r0.finishCurrentSegment()
            int r6 = r5.length
            r7 = 0
        L_0x0065:
            int r8 = r7 + 1
            r9 = r1 & 63
            r9 = r9 | 128(0x80, float:1.794E-43)
            byte r9 = (byte) r9
            r5[r7] = r9
            r7 = r8
            r4 = r3
            goto L_0x0018
        L_0x0071:
            r9 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r9) goto L_0x007b
            r9 = 57343(0xdfff, float:8.0355E-41)
            if (r1 <= r9) goto L_0x009a
        L_0x007b:
            int r7 = r8 + 1
            int r9 = r1 >> 12
            r9 = r9 | 224(0xe0, float:3.14E-43)
            byte r9 = (byte) r9
            r5[r8] = r9
            if (r7 < r6) goto L_0x008c
            byte[] r5 = r0.finishCurrentSegment()
            int r6 = r5.length
            r7 = 0
        L_0x008c:
            int r8 = r7 + 1
            int r9 = r1 >> 6
            r9 = r9 & 63
            r9 = r9 | 128(0x80, float:1.794E-43)
            byte r9 = (byte) r9
            r5[r7] = r9
            r7 = r8
            r3 = r4
            goto L_0x005d
        L_0x009a:
            r9 = 56319(0xdbff, float:7.892E-41)
            if (r1 <= r9) goto L_0x00a2
            r10._throwIllegalSurrogate(r1)
        L_0x00a2:
            if (r4 < r2) goto L_0x00a7
            r10._throwIllegalSurrogate(r1)
        L_0x00a7:
            int r3 = r4 + 1
            char r9 = r11.charAt(r4)
            int r1 = r10._convertSurrogate(r1, r9)
            r9 = 1114111(0x10ffff, float:1.561202E-39)
            if (r1 <= r9) goto L_0x00b9
            r10._throwIllegalSurrogate(r1)
        L_0x00b9:
            int r7 = r8 + 1
            int r9 = r1 >> 18
            r9 = r9 | 240(0xf0, float:3.36E-43)
            byte r9 = (byte) r9
            r5[r8] = r9
            if (r7 < r6) goto L_0x00ca
            byte[] r5 = r0.finishCurrentSegment()
            int r6 = r5.length
            r7 = 0
        L_0x00ca:
            int r8 = r7 + 1
            int r9 = r1 >> 12
            r9 = r9 & 63
            r9 = r9 | 128(0x80, float:1.794E-43)
            byte r9 = (byte) r9
            r5[r7] = r9
            if (r8 < r6) goto L_0x00eb
            byte[] r5 = r0.finishCurrentSegment()
            int r6 = r5.length
            r7 = 0
        L_0x00dd:
            int r8 = r7 + 1
            int r9 = r1 >> 6
            r9 = r9 & 63
            r9 = r9 | 128(0x80, float:1.794E-43)
            byte r9 = (byte) r9
            r5[r7] = r9
            r7 = r8
            goto L_0x005d
        L_0x00eb:
            r7 = r8
            goto L_0x00dd
        L_0x00ed:
            r8 = r7
            goto L_0x004f
        L_0x00f0:
            r3 = r4
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p003io.JsonStringEncoder.encodeAsUTF8(java.lang.String):byte[]");
    }

    private int _appendSingleEscape(int escCode, char[] quoteBuffer) {
        if (escCode < 0) {
            int value = -(escCode + 1);
            quoteBuffer[1] = 'u';
            quoteBuffer[4] = HEX_CHARS[value >> 4];
            quoteBuffer[5] = HEX_CHARS[value & 15];
            return 6;
        }
        quoteBuffer[1] = (char) escCode;
        return 2;
    }

    private int _appendByteEscape(int ch, int escCode, ByteArrayBuilder byteBuilder, int ptr) {
        byteBuilder.setCurrentSegmentLength(ptr);
        byteBuilder.append(INT_BACKSLASH);
        if (escCode < 0) {
            byteBuilder.append(INT_U);
            if (ch > 255) {
                int hi = ch >> 8;
                byteBuilder.append(HEX_BYTES[hi >> 4]);
                byteBuilder.append(HEX_BYTES[hi & 15]);
                ch &= MotionEventCompat.ACTION_MASK;
            } else {
                byteBuilder.append(48);
                byteBuilder.append(48);
            }
            byteBuilder.append(HEX_BYTES[ch >> 4]);
            byteBuilder.append(HEX_BYTES[ch & 15]);
        } else {
            byteBuilder.append((byte) escCode);
        }
        return byteBuilder.getCurrentSegmentLength();
    }

    private int _convertSurrogate(int firstPart, int secondPart) {
        if (secondPart >= SURR2_FIRST && secondPart <= SURR2_LAST) {
            return 65536 + ((firstPart - SURR1_FIRST) << 10) + (secondPart - SURR2_FIRST);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(firstPart) + ", second 0x" + Integer.toHexString(secondPart) + "; illegal combination");
    }

    private void _throwIllegalSurrogate(int code) {
        if (code > 1114111) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(code) + ") to output; max is 0x10FFFF as per RFC 4627");
        } else if (code < SURR1_FIRST) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(code) + ") to output");
        } else if (code <= SURR1_LAST) {
            throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(code) + ")");
        } else {
            throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(code) + ")");
        }
    }
}
