package com.google.android.gms.internal;

import java.util.PriorityQueue;

/* renamed from: com.google.android.gms.internal.as */
public class C0920as {

    /* renamed from: com.google.android.gms.internal.as$a */
    public static class C0921a {

        /* renamed from: nQ */
        final String f2607nQ;
        final long value;

        C0921a(long j, String str) {
            this.value = j;
            this.f2607nQ = str;
        }
    }

    /* renamed from: a */
    static long m3898a(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    /* renamed from: a */
    static long m3899a(long j, int i) {
        if (i == 0) {
            return 1;
        }
        return i != 1 ? i % 2 == 0 ? m3899a((j * j) % 1073807359, i / 2) % 1073807359 : ((m3899a((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    /* renamed from: a */
    static String m3900a(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            C1229gs.m4676T("Unable to construct shingle");
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
    private static void m3901a(int i, long j, int i2, String[] strArr, int i3, PriorityQueue<C0921a> priorityQueue) {
        priorityQueue.add(new C0921a(j, m3900a(strArr, i2, i3)));
        if (priorityQueue.size() > i) {
            priorityQueue.poll();
        }
    }

    /* renamed from: a */
    public static void m3902a(String[] strArr, int i, int i2, PriorityQueue<C0921a> priorityQueue) {
        long b = m3903b(strArr, 0, i2);
        m3901a(i, b, 0, strArr, i2, priorityQueue);
        long a = m3899a(16785407, i2 - 1);
        int i3 = 1;
        long j = b;
        while (i3 < (strArr.length - i2) + 1) {
            long a2 = m3898a(C0918aq.m3894o(strArr[i3 - 1]), C0918aq.m3894o(strArr[(i3 + i2) - 1]), j, a, 16785407);
            m3901a(i, a2, i3, strArr, i2, priorityQueue);
            i3++;
            j = a2;
        }
    }

    /* renamed from: b */
    private static long m3903b(String[] strArr, int i, int i2) {
        long o = (((long) C0918aq.m3894o(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            o = (((o * 16785407) % 1073807359) + ((((long) C0918aq.m3894o(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return o;
    }
}
