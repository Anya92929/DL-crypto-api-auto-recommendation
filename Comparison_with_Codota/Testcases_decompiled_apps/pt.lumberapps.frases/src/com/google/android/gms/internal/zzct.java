package com.google.android.gms.internal;

import java.util.PriorityQueue;

@zzin
public class zzct {

    public class zza {

        /* renamed from: a */
        final long f6082a;

        /* renamed from: b */
        final String f6083b;

        /* renamed from: c */
        final int f6084c;

        zza(long j, String str, int i) {
            this.f6082a = j;
            this.f6083b = str;
            this.f6084c = i;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof zza)) {
                return false;
            }
            return ((zza) obj).f6082a == this.f6082a && ((zza) obj).f6084c == this.f6084c;
        }

        public int hashCode() {
            return (int) this.f6082a;
        }
    }

    /* renamed from: a */
    static long m6974a(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    /* renamed from: a */
    static long m6975a(long j, int i) {
        if (i == 0) {
            return 1;
        }
        return i != 1 ? i % 2 == 0 ? m6975a((j * j) % 1073807359, i / 2) % 1073807359 : ((m6975a((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    /* renamed from: a */
    static String m6976a(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            zzkd.m5769e("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    static void m6977a(int i, long j, String str, int i2, PriorityQueue priorityQueue) {
        zza zza2 = new zza(j, str, i2);
        if ((priorityQueue.size() != i || (((zza) priorityQueue.peek()).f6084c <= zza2.f6084c && ((zza) priorityQueue.peek()).f6082a <= zza2.f6082a)) && !priorityQueue.contains(zza2)) {
            priorityQueue.add(zza2);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    /* renamed from: b */
    private static long m6978b(String[] strArr, int i, int i2) {
        long zzac = (((long) zzcr.zzac(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            zzac = (((zzac * 16785407) % 1073807359) + ((((long) zzcr.zzac(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zzac;
    }

    public static void zza(String[] strArr, int i, int i2, PriorityQueue priorityQueue) {
        if (strArr.length < i2) {
            m6977a(i, m6978b(strArr, 0, strArr.length), m6976a(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long b = m6978b(strArr, 0, i2);
        m6977a(i, b, m6976a(strArr, 0, i2), i2, priorityQueue);
        long a = m6975a(16785407, i2 - 1);
        int i3 = 1;
        while (i3 < (strArr.length - i2) + 1) {
            long a2 = m6974a(zzcr.zzac(strArr[i3 - 1]), zzcr.zzac(strArr[(i3 + i2) - 1]), b, a, 16785407);
            m6977a(i, a2, m6976a(strArr, i3, i2), strArr.length, priorityQueue);
            i3++;
            b = a2;
        }
    }
}
