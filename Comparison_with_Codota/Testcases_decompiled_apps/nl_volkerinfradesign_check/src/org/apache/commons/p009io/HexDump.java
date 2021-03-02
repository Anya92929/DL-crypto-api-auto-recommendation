package org.apache.commons.p009io;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: org.apache.commons.io.HexDump */
public class HexDump {
    public static final String EOL = System.getProperty("line.separator");

    /* renamed from: a */
    private static final char[] f6841a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b */
    private static final int[] f6842b = {28, 24, 20, 16, 12, 8, 4, 0};

    public static void dump(byte[] bArr, long j, OutputStream outputStream, int i) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException("illegal index: " + i + " into array of length " + bArr.length);
        } else if (outputStream == null) {
            throw new IllegalArgumentException("cannot write to nullstream");
        } else {
            long j2 = ((long) i) + j;
            StringBuilder sb = new StringBuilder(74);
            while (i < bArr.length) {
                int length = bArr.length - i;
                if (length > 16) {
                    length = 16;
                }
                m7284a(sb, j2).append(' ');
                for (int i2 = 0; i2 < 16; i2++) {
                    if (i2 < length) {
                        m7283a(sb, bArr[i2 + i]);
                    } else {
                        sb.append("  ");
                    }
                    sb.append(' ');
                }
                for (int i3 = 0; i3 < length; i3++) {
                    if (bArr[i3 + i] < 32 || bArr[i3 + i] >= Byte.MAX_VALUE) {
                        sb.append('.');
                    } else {
                        sb.append((char) bArr[i3 + i]);
                    }
                }
                sb.append(EOL);
                outputStream.write(sb.toString().getBytes());
                outputStream.flush();
                sb.setLength(0);
                j2 += (long) length;
                i += 16;
            }
        }
    }

    /* renamed from: a */
    private static StringBuilder m7284a(StringBuilder sb, long j) {
        for (int i = 0; i < 8; i++) {
            sb.append(f6841a[((int) (j >> f6842b[i])) & 15]);
        }
        return sb;
    }

    /* renamed from: a */
    private static StringBuilder m7283a(StringBuilder sb, byte b) {
        for (int i = 0; i < 2; i++) {
            sb.append(f6841a[(b >> f6842b[i + 6]) & 15]);
        }
        return sb;
    }
}
