package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class zzpd {
    /* renamed from: a */
    private static long m7396a(long j) {
        return (j >>> 47) ^ j;
    }

    /* renamed from: a */
    private static long m7397a(long j, long j2) {
        long j3 = (j2 ^ j) * -4132994306676758123L;
        long j4 = ((j3 ^ (j3 >>> 47)) ^ j) * -4132994306676758123L;
        return (j4 ^ (j4 >>> 47)) * -4132994306676758123L;
    }

    /* renamed from: a */
    private static long m7398a(byte[] bArr) {
        int length = bArr.length;
        long a = m7399a(bArr, 24);
        long a2 = m7399a(bArr, 0) + ((((long) length) + m7399a(bArr, length - 16)) * -6505348102511208375L);
        long rotateRight = Long.rotateRight(a2 + a, 52);
        long rotateRight2 = Long.rotateRight(a2, 37);
        long a3 = a2 + m7399a(bArr, 8);
        long rotateRight3 = rotateRight2 + Long.rotateRight(a3, 7);
        long a4 = a3 + m7399a(bArr, 16);
        long j = a + a4;
        long rotateRight4 = Long.rotateRight(a4, 31) + rotateRight + rotateRight3;
        long a5 = m7399a(bArr, 16) + m7399a(bArr, length - 32);
        long a6 = m7399a(bArr, length - 8);
        long rotateRight5 = Long.rotateRight(a5 + a6, 52);
        long rotateRight6 = Long.rotateRight(a5, 37);
        long a7 = a5 + m7399a(bArr, length - 24);
        long a8 = m7399a(bArr, length - 16) + a7;
        long j2 = a8 + a6;
        return m7396a((m7396a(((Long.rotateRight(a8, 31) + rotateRight5 + rotateRight6 + Long.rotateRight(a7, 7) + j) * -4288712594273399085L) + ((j2 + rotateRight4) * -6505348102511208375L)) * -6505348102511208375L) + rotateRight4) * -4288712594273399085L;
    }

    /* renamed from: a */
    private static long m7399a(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 8);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getLong();
    }

    /* renamed from: a */
    private static long m7400a(byte[] bArr, int i, int i2) {
        long j = 0;
        int min = Math.min(i2, 8);
        for (int i3 = 0; i3 < min; i3++) {
            j |= (((long) bArr[i + i3]) & 255) << (i3 * 8);
        }
        return j;
    }

    /* renamed from: a */
    private static long m7401a(byte[] bArr, long j) {
        int length = bArr.length & -8;
        int length2 = bArr.length & 7;
        long length3 = j ^ (((long) bArr.length) * -4132994306676758123L);
        int i = 0;
        while (i < length) {
            long a = (length3 ^ (m7396a(m7399a(bArr, i) * -4132994306676758123L) * -4132994306676758123L)) * -4132994306676758123L;
            i += 8;
            length3 = a;
        }
        if (length2 != 0) {
            length3 = (length3 ^ m7400a(bArr, length, length2)) * -4132994306676758123L;
        }
        return m7396a(m7396a(length3) * -4132994306676758123L);
    }

    /* renamed from: a */
    private static void m7402a(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long a = m7399a(bArr, i);
        long a2 = m7399a(bArr, i + 8);
        long a3 = m7399a(bArr, i + 16);
        long a4 = m7399a(bArr, i + 24);
        long j3 = a + j;
        long rotateRight = Long.rotateRight(j2 + j3 + a4, 51);
        long j4 = a2 + j3 + a3;
        jArr[0] = j4 + a4;
        jArr[1] = j3 + Long.rotateRight(j4, 23) + rotateRight;
    }

    /* renamed from: b */
    private static long m7403b(byte[] bArr) {
        int length = bArr.length;
        long a = m7399a(bArr, 0);
        long a2 = m7399a(bArr, length - 16) ^ -8261664234251669945L;
        long a3 = m7399a(bArr, length - 56) ^ -6505348102511208375L;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        m7402a(bArr, length - 64, (long) length, a2, jArr);
        m7402a(bArr, length - 32, ((long) length) * -8261664234251669945L, -6505348102511208375L, jArr2);
        long a4 = a3 + (m7396a(jArr[1]) * -8261664234251669945L);
        long rotateRight = -8261664234251669945L * Long.rotateRight(a4 + a, 39);
        long rotateRight2 = Long.rotateRight(a2, 33) * -8261664234251669945L;
        int i = (length - 1) & -64;
        int i2 = 0;
        long j = rotateRight;
        while (true) {
            long rotateRight3 = (Long.rotateRight(((j + rotateRight2) + jArr[0]) + m7399a(bArr, i2 + 16), 37) * -8261664234251669945L) ^ jArr2[1];
            rotateRight2 = (Long.rotateRight((jArr[1] + rotateRight2) + m7399a(bArr, i2 + 48), 42) * -8261664234251669945L) ^ jArr[0];
            long rotateRight4 = Long.rotateRight(a4 ^ jArr2[0], 33);
            m7402a(bArr, i2, jArr[1] * -8261664234251669945L, jArr2[0] + rotateRight3, jArr);
            m7402a(bArr, i2 + 32, rotateRight4 + jArr2[1], rotateRight2, jArr2);
            i2 += 64;
            i -= 64;
            if (i == 0) {
                return m7397a(m7397a(jArr[0], jArr2[0]) + (m7396a(rotateRight2) * -8261664234251669945L) + rotateRight3, m7397a(jArr[1], jArr2[1]) + rotateRight4);
            }
            a4 = rotateRight3;
            j = rotateRight4;
        }
    }

    public static long zzm(byte[] bArr) {
        long j = -6505348102511208375L;
        long a = bArr.length <= 32 ? m7401a(bArr, -1397348546323613475L) : bArr.length <= 64 ? m7398a(bArr) : m7403b(bArr);
        long a2 = bArr.length >= 8 ? m7399a(bArr, 0) : -6505348102511208375L;
        if (bArr.length >= 9) {
            j = m7399a(bArr, bArr.length - 8);
        }
        long a3 = m7397a(a + j, a2);
        return (a3 == 0 || a3 == 1) ? a3 - 2 : a3;
    }
}
