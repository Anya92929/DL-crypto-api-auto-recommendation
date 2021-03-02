package com.google.zxing.pdf417.encoder;

import android.support.p000v4.view.MotionEventCompat;
import com.flurry.android.Constants;
import com.google.zxing.WriterException;
import java.math.BigInteger;
import java.util.Arrays;

final class PDF417HighLevelEncoder {
    private static final int BYTE_COMPACTION = 1;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final byte[] MIXED = new byte[128];
    private static final int NUMERIC_COMPACTION = 2;
    private static final byte[] PUNCTUATION = new byte[128];
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] TEXT_PUNCTUATION_RAW = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    static {
        Arrays.fill(MIXED, (byte) -1);
        for (byte i = 0; i < TEXT_MIXED_RAW.length; i = (byte) (i + 1)) {
            byte b = TEXT_MIXED_RAW[i];
            if (b > 0) {
                MIXED[b] = i;
            }
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        for (byte i2 = 0; i2 < TEXT_PUNCTUATION_RAW.length; i2 = (byte) (i2 + 1)) {
            byte b2 = TEXT_PUNCTUATION_RAW[i2];
            if (b2 > 0) {
                PUNCTUATION[b2] = i2;
            }
        }
    }

    private PDF417HighLevelEncoder() {
    }

    private static byte[] getBytesForMessage(String msg) {
        return msg.getBytes();
    }

    static String encodeHighLevel(String msg, Compaction compaction) throws WriterException {
        byte[] bytes = null;
        StringBuilder sb = new StringBuilder(msg.length());
        int len = msg.length();
        int p = 0;
        int textSubMode = 0;
        if (compaction == Compaction.TEXT) {
            encodeText(msg, 0, len, sb, 0);
        } else if (compaction == Compaction.BYTE) {
            byte[] bytes2 = getBytesForMessage(msg);
            encodeBinary(bytes2, 0, bytes2.length, 1, sb);
        } else if (compaction == Compaction.NUMERIC) {
            sb.append(902);
            encodeNumeric(msg, 0, len, sb);
        } else {
            int encodingMode = 0;
            while (p < len) {
                int n = determineConsecutiveDigitCount(msg, p);
                if (n >= 13) {
                    sb.append(902);
                    encodingMode = 2;
                    textSubMode = 0;
                    encodeNumeric(msg, p, n, sb);
                    p += n;
                } else {
                    int t = determineConsecutiveTextCount(msg, p);
                    if (t >= 5 || n == len) {
                        if (encodingMode != 0) {
                            sb.append(900);
                            encodingMode = 0;
                            textSubMode = 0;
                        }
                        textSubMode = encodeText(msg, p, t, sb, textSubMode);
                        p += t;
                    } else {
                        if (bytes == null) {
                            bytes = getBytesForMessage(msg);
                        }
                        int b = determineConsecutiveBinaryCount(msg, bytes, p);
                        if (b == 0) {
                            b = 1;
                        }
                        if (b == 1 && encodingMode == 0) {
                            encodeBinary(bytes, p, 1, 0, sb);
                        } else {
                            encodeBinary(bytes, p, b, encodingMode, sb);
                            encodingMode = 1;
                            textSubMode = 0;
                        }
                        p += b;
                    }
                }
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int encodeText(java.lang.CharSequence r11, int r12, int r13, java.lang.StringBuilder r14, int r15) {
        /*
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r13)
            r7 = r15
            r3 = 0
        L_0x0007:
            int r9 = r12 + r3
            char r0 = r11.charAt(r9)
            switch(r7) {
                case 0: goto L_0x003f;
                case 1: goto L_0x007e;
                case 2: goto L_0x00c5;
                default: goto L_0x0010;
            }
        L_0x0010:
            boolean r9 = isPunctuation(r0)
            if (r9 == 0) goto L_0x011c
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r0]
            char r9 = (char) r9
            r8.append(r9)
        L_0x001e:
            int r3 = r3 + 1
            if (r3 < r13) goto L_0x0007
            r1 = 0
            int r4 = r8.length()
            r2 = 0
        L_0x0028:
            if (r2 >= r4) goto L_0x012d
            int r9 = r2 % 2
            if (r9 == 0) goto L_0x0124
            r6 = 1
        L_0x002f:
            if (r6 == 0) goto L_0x0127
            int r9 = r1 * 30
            char r10 = r8.charAt(r2)
            int r9 = r9 + r10
            char r1 = (char) r9
            r14.append(r1)
        L_0x003c:
            int r2 = r2 + 1
            goto L_0x0028
        L_0x003f:
            boolean r9 = isAlphaUpper(r0)
            if (r9 == 0) goto L_0x0056
            r9 = 32
            if (r0 != r9) goto L_0x004f
            r9 = 26
            r8.append(r9)
            goto L_0x001e
        L_0x004f:
            int r9 = r0 + -65
            char r9 = (char) r9
            r8.append(r9)
            goto L_0x001e
        L_0x0056:
            boolean r9 = isAlphaLower(r0)
            if (r9 == 0) goto L_0x0063
            r7 = 1
            r9 = 27
            r8.append(r9)
            goto L_0x0007
        L_0x0063:
            boolean r9 = isMixed(r0)
            if (r9 == 0) goto L_0x0070
            r7 = 2
            r9 = 28
            r8.append(r9)
            goto L_0x0007
        L_0x0070:
            r9 = 29
            r8.append(r9)
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r0]
            char r9 = (char) r9
            r8.append(r9)
            goto L_0x001e
        L_0x007e:
            boolean r9 = isAlphaLower(r0)
            if (r9 == 0) goto L_0x0095
            r9 = 32
            if (r0 != r9) goto L_0x008e
            r9 = 26
            r8.append(r9)
            goto L_0x001e
        L_0x008e:
            int r9 = r0 + -97
            char r9 = (char) r9
            r8.append(r9)
            goto L_0x001e
        L_0x0095:
            boolean r9 = isAlphaUpper(r0)
            if (r9 == 0) goto L_0x00a8
            r9 = 27
            r8.append(r9)
            int r9 = r0 + -65
            char r9 = (char) r9
            r8.append(r9)
            goto L_0x001e
        L_0x00a8:
            boolean r9 = isMixed(r0)
            if (r9 == 0) goto L_0x00b6
            r7 = 2
            r9 = 28
            r8.append(r9)
            goto L_0x0007
        L_0x00b6:
            r9 = 29
            r8.append(r9)
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r0]
            char r9 = (char) r9
            r8.append(r9)
            goto L_0x001e
        L_0x00c5:
            boolean r9 = isMixed(r0)
            if (r9 == 0) goto L_0x00d5
            byte[] r9 = MIXED
            byte r9 = r9[r0]
            char r9 = (char) r9
            r8.append(r9)
            goto L_0x001e
        L_0x00d5:
            boolean r9 = isAlphaUpper(r0)
            if (r9 == 0) goto L_0x00e3
            r7 = 0
            r9 = 28
            r8.append(r9)
            goto L_0x0007
        L_0x00e3:
            boolean r9 = isAlphaLower(r0)
            if (r9 == 0) goto L_0x00f1
            r7 = 1
            r9 = 27
            r8.append(r9)
            goto L_0x0007
        L_0x00f1:
            int r9 = r12 + r3
            int r9 = r9 + 1
            if (r9 >= r13) goto L_0x010d
            int r9 = r12 + r3
            int r9 = r9 + 1
            char r5 = r11.charAt(r9)
            boolean r9 = isPunctuation(r5)
            if (r9 == 0) goto L_0x010d
            r7 = 3
            r9 = 25
            r8.append(r9)
            goto L_0x0007
        L_0x010d:
            r9 = 29
            r8.append(r9)
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r0]
            char r9 = (char) r9
            r8.append(r9)
            goto L_0x001e
        L_0x011c:
            r7 = 0
            r9 = 29
            r8.append(r9)
            goto L_0x0007
        L_0x0124:
            r6 = 0
            goto L_0x002f
        L_0x0127:
            char r1 = r8.charAt(r2)
            goto L_0x003c
        L_0x012d:
            int r9 = r4 % 2
            if (r9 == 0) goto L_0x0139
            int r9 = r1 * 30
            int r9 = r9 + 29
            char r9 = (char) r9
            r14.append(r9)
        L_0x0139:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeText(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void encodeBinary(byte[] bytes, int startpos, int count, int startmode, StringBuilder sb) {
        if (count == 1 && startmode == 0) {
            sb.append(913);
        }
        int idx = startpos;
        if (count >= 6) {
            sb.append(924);
            char[] chars = new char[5];
            while ((startpos + count) - idx >= 6) {
                long t = 0;
                for (int i = 0; i < 6; i++) {
                    t = (t << 8) + ((long) (bytes[idx + i] & Constants.UNKNOWN));
                }
                for (int i2 = 0; i2 < 5; i2++) {
                    chars[i2] = (char) ((int) (t % 900));
                    t /= 900;
                }
                for (int i3 = chars.length - 1; i3 >= 0; i3--) {
                    sb.append(chars[i3]);
                }
                idx += 6;
            }
        }
        if (idx < startpos + count) {
            sb.append(901);
        }
        for (int i4 = idx; i4 < startpos + count; i4++) {
            sb.append((char) (bytes[i4] & MotionEventCompat.ACTION_MASK));
        }
    }

    private static void encodeNumeric(String msg, int startpos, int count, StringBuilder sb) {
        int idx = 0;
        StringBuilder tmp = new StringBuilder((count / 3) + 1);
        BigInteger num900 = BigInteger.valueOf(900);
        BigInteger num0 = BigInteger.valueOf(0);
        while (idx < count - 1) {
            tmp.setLength(0);
            int len = Math.min(44, count - idx);
            BigInteger bigint = new BigInteger('1' + msg.substring(startpos + idx, startpos + idx + len));
            do {
                tmp.append((char) bigint.mod(num900).intValue());
                bigint = bigint.divide(num900);
            } while (!bigint.equals(num0));
            for (int i = tmp.length() - 1; i >= 0; i--) {
                sb.append(tmp.charAt(i));
            }
            idx += len;
        }
    }

    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static boolean isAlphaUpper(char ch) {
        return ch == ' ' || (ch >= 'A' && ch <= 'Z');
    }

    private static boolean isAlphaLower(char ch) {
        return ch == ' ' || (ch >= 'a' && ch <= 'z');
    }

    private static boolean isMixed(char ch) {
        return MIXED[ch] != -1;
    }

    private static boolean isPunctuation(char ch) {
        return PUNCTUATION[ch] != -1;
    }

    private static boolean isText(char ch) {
        return ch == 9 || ch == 10 || ch == 13 || (ch >= ' ' && ch <= '~');
    }

    private static int determineConsecutiveDigitCount(CharSequence msg, int startpos) {
        int count = 0;
        int len = msg.length();
        int idx = startpos;
        if (idx < len) {
            char ch = msg.charAt(idx);
            while (isDigit(ch) && idx < len) {
                count++;
                idx++;
                if (idx < len) {
                    ch = msg.charAt(idx);
                }
            }
        }
        return count;
    }

    private static int determineConsecutiveTextCount(CharSequence msg, int startpos) {
        int len = msg.length();
        int idx = startpos;
        while (idx < len) {
            char ch = msg.charAt(idx);
            int numericCount = 0;
            while (numericCount < 13 && isDigit(ch) && idx < len) {
                numericCount++;
                idx++;
                if (idx < len) {
                    ch = msg.charAt(idx);
                }
            }
            if (numericCount >= 13) {
                return (idx - startpos) - numericCount;
            }
            if (numericCount <= 0) {
                if (!isText(msg.charAt(idx))) {
                    break;
                }
                idx++;
            }
        }
        return idx - startpos;
    }

    private static int determineConsecutiveBinaryCount(CharSequence msg, byte[] bytes, int startpos) throws WriterException {
        int len = msg.length();
        int idx = startpos;
        while (idx < len) {
            char ch = msg.charAt(idx);
            int numericCount = 0;
            while (numericCount < 13 && isDigit(ch)) {
                numericCount++;
                int i = idx + numericCount;
                if (i >= len) {
                    break;
                }
                ch = msg.charAt(i);
            }
            if (numericCount >= 13) {
                return idx - startpos;
            }
            int textCount = 0;
            while (textCount < 5 && isText(ch)) {
                textCount++;
                int i2 = idx + textCount;
                if (i2 >= len) {
                    break;
                }
                ch = msg.charAt(i2);
            }
            if (textCount >= 5) {
                return idx - startpos;
            }
            char ch2 = msg.charAt(idx);
            if (bytes[idx] != 63 || ch2 == '?') {
                idx++;
            } else {
                throw new WriterException("Non-encodable character detected: " + ch2 + " (Unicode: " + ch2 + ')');
            }
        }
        return idx - startpos;
    }
}
