package p000;

import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

/* renamed from: ji */
public final class C1319ji {

    /* renamed from: a */
    public static final Charset f4581a = Charset.forName(CharEncoding.UTF_8);

    /* renamed from: a */
    public static void m5708a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    /* renamed from: a */
    public static short m5707a(short s) {
        short s2 = 65535 & s;
        return (short) (((s2 & 255) << 8) | ((65280 & s2) >>> 8));
    }

    /* renamed from: a */
    public static int m5705a(int i) {
        return ((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8) | ((i & 255) << 24);
    }

    /* renamed from: a */
    public static long m5706a(long j) {
        return ((-72057594037927936L & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40) | ((255 & j) << 56);
    }

    /* renamed from: a */
    public static void m5709a(Throwable th) {
        m5711b(th);
    }

    /* renamed from: b */
    private static <T extends Throwable> void m5711b(Throwable th) throws Throwable {
        throw th;
    }

    /* renamed from: a */
    public static boolean m5710a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}