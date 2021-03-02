package com.google.ads.util;

import java.io.UnsupportedEncodingException;

public class c {
    static final /* synthetic */ boolean a = (!c.class.desiredAssertionStatus());

    public static abstract class a {
        public byte[] a;
        public int b;
    }

    public static byte[] a(String str) {
        return a(str.getBytes(), 0);
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        b bVar = new b(i3, new byte[((i2 * 3) / 4)]);
        if (!bVar.a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (bVar.b == bVar.a.length) {
            return bVar.a;
        } else {
            byte[] bArr2 = new byte[bVar.b];
            System.arraycopy(bVar.a, 0, bArr2, 0, bVar.b);
            return bArr2;
        }
    }

    public static class b extends a {
        private static final int[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private int e;
        private int f;
        private final int[] g;

        public b(int i, byte[] bArr) {
            this.a = bArr;
            this.g = (i & 8) == 0 ? c : d;
            this.e = 0;
            this.f = 0;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(byte[] r11, int r12, int r13, boolean r14) {
            /*
                r10 = this;
                int r0 = r10.e
                r1 = 6
                if (r0 != r1) goto L_0x0007
                r0 = 0
            L_0x0006:
                return r0
            L_0x0007:
                int r4 = r13 + r12
                int r3 = r10.e
                int r1 = r10.f
                r0 = 0
                byte[] r5 = r10.a
                int[] r6 = r10.g
                r2 = r12
            L_0x0013:
                if (r2 >= r4) goto L_0x0133
                if (r3 != 0) goto L_0x0067
            L_0x0017:
                int r7 = r2 + 4
                if (r7 > r4) goto L_0x005a
                byte r1 = r11[r2]
                r1 = r1 & 255(0xff, float:3.57E-43)
                r1 = r6[r1]
                int r1 = r1 << 18
                int r7 = r2 + 1
                byte r7 = r11[r7]
                r7 = r7 & 255(0xff, float:3.57E-43)
                r7 = r6[r7]
                int r7 = r7 << 12
                r1 = r1 | r7
                int r7 = r2 + 2
                byte r7 = r11[r7]
                r7 = r7 & 255(0xff, float:3.57E-43)
                r7 = r6[r7]
                int r7 = r7 << 6
                r1 = r1 | r7
                int r7 = r2 + 3
                byte r7 = r11[r7]
                r7 = r7 & 255(0xff, float:3.57E-43)
                r7 = r6[r7]
                r1 = r1 | r7
                if (r1 < 0) goto L_0x005a
                int r7 = r0 + 2
                byte r8 = (byte) r1
                r5[r7] = r8
                int r7 = r0 + 1
                int r8 = r1 >> 8
                byte r8 = (byte) r8
                r5[r7] = r8
                int r7 = r1 >> 16
                byte r7 = (byte) r7
                r5[r0] = r7
                int r0 = r0 + 3
                int r2 = r2 + 4
                goto L_0x0017
            L_0x005a:
                if (r2 < r4) goto L_0x0067
                r2 = r1
            L_0x005d:
                if (r14 != 0) goto L_0x0105
                r10.e = r3
                r10.f = r2
                r10.b = r0
                r0 = 1
                goto L_0x0006
            L_0x0067:
                int r12 = r2 + 1
                byte r2 = r11[r2]
                r2 = r2 & 255(0xff, float:3.57E-43)
                r2 = r6[r2]
                switch(r3) {
                    case 0: goto L_0x0076;
                    case 1: goto L_0x0086;
                    case 2: goto L_0x0097;
                    case 3: goto L_0x00b7;
                    case 4: goto L_0x00ed;
                    case 5: goto L_0x00fc;
                    default: goto L_0x0072;
                }
            L_0x0072:
                r2 = r3
            L_0x0073:
                r3 = r2
                r2 = r12
                goto L_0x0013
            L_0x0076:
                if (r2 < 0) goto L_0x007e
                int r1 = r3 + 1
                r9 = r2
                r2 = r1
                r1 = r9
                goto L_0x0073
            L_0x007e:
                r7 = -1
                if (r2 == r7) goto L_0x0072
                r0 = 6
                r10.e = r0
                r0 = 0
                goto L_0x0006
            L_0x0086:
                if (r2 < 0) goto L_0x008e
                int r1 = r1 << 6
                r1 = r1 | r2
                int r2 = r3 + 1
                goto L_0x0073
            L_0x008e:
                r7 = -1
                if (r2 == r7) goto L_0x0072
                r0 = 6
                r10.e = r0
                r0 = 0
                goto L_0x0006
            L_0x0097:
                if (r2 < 0) goto L_0x009f
                int r1 = r1 << 6
                r1 = r1 | r2
                int r2 = r3 + 1
                goto L_0x0073
            L_0x009f:
                r7 = -2
                if (r2 != r7) goto L_0x00ae
                int r2 = r0 + 1
                int r3 = r1 >> 4
                byte r3 = (byte) r3
                r5[r0] = r3
                r0 = 4
                r9 = r2
                r2 = r0
                r0 = r9
                goto L_0x0073
            L_0x00ae:
                r7 = -1
                if (r2 == r7) goto L_0x0072
                r0 = 6
                r10.e = r0
                r0 = 0
                goto L_0x0006
            L_0x00b7:
                if (r2 < 0) goto L_0x00d1
                int r1 = r1 << 6
                r1 = r1 | r2
                int r2 = r0 + 2
                byte r3 = (byte) r1
                r5[r2] = r3
                int r2 = r0 + 1
                int r3 = r1 >> 8
                byte r3 = (byte) r3
                r5[r2] = r3
                int r2 = r1 >> 16
                byte r2 = (byte) r2
                r5[r0] = r2
                int r0 = r0 + 3
                r2 = 0
                goto L_0x0073
            L_0x00d1:
                r7 = -2
                if (r2 != r7) goto L_0x00e4
                int r2 = r0 + 1
                int r3 = r1 >> 2
                byte r3 = (byte) r3
                r5[r2] = r3
                int r2 = r1 >> 10
                byte r2 = (byte) r2
                r5[r0] = r2
                int r0 = r0 + 2
                r2 = 5
                goto L_0x0073
            L_0x00e4:
                r7 = -1
                if (r2 == r7) goto L_0x0072
                r0 = 6
                r10.e = r0
                r0 = 0
                goto L_0x0006
            L_0x00ed:
                r7 = -2
                if (r2 != r7) goto L_0x00f3
                int r2 = r3 + 1
                goto L_0x0073
            L_0x00f3:
                r7 = -1
                if (r2 == r7) goto L_0x0072
                r0 = 6
                r10.e = r0
                r0 = 0
                goto L_0x0006
            L_0x00fc:
                r7 = -1
                if (r2 == r7) goto L_0x0072
                r0 = 6
                r10.e = r0
                r0 = 0
                goto L_0x0006
            L_0x0105:
                switch(r3) {
                    case 0: goto L_0x0108;
                    case 1: goto L_0x010f;
                    case 2: goto L_0x0115;
                    case 3: goto L_0x011e;
                    case 4: goto L_0x012d;
                    default: goto L_0x0108;
                }
            L_0x0108:
                r10.e = r3
                r10.b = r0
                r0 = 1
                goto L_0x0006
            L_0x010f:
                r0 = 6
                r10.e = r0
                r0 = 0
                goto L_0x0006
            L_0x0115:
                int r1 = r0 + 1
                int r2 = r2 >> 4
                byte r2 = (byte) r2
                r5[r0] = r2
                r0 = r1
                goto L_0x0108
            L_0x011e:
                int r1 = r0 + 1
                int r4 = r2 >> 10
                byte r4 = (byte) r4
                r5[r0] = r4
                int r0 = r1 + 1
                int r2 = r2 >> 2
                byte r2 = (byte) r2
                r5[r1] = r2
                goto L_0x0108
            L_0x012d:
                r0 = 6
                r10.e = r0
                r0 = 0
                goto L_0x0006
            L_0x0133:
                r2 = r1
                goto L_0x005d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.ads.util.c.b.a(byte[], int, int, boolean):boolean");
        }
    }

    public static String b(byte[] bArr, int i) {
        try {
            return new String(c(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] c(byte[] bArr, int i) {
        return b(bArr, 0, bArr.length, i);
    }

    public static byte[] b(byte[] bArr, int i, int i2, int i3) {
        int i4;
        C0003c cVar = new C0003c(i3, (byte[]) null);
        int i5 = (i2 / 3) * 4;
        if (!cVar.d) {
            switch (i2 % 3) {
                case 1:
                    i5 += 2;
                    break;
                case 2:
                    i5 += 3;
                    break;
            }
        } else if (i2 % 3 > 0) {
            i5 += 4;
        }
        if (cVar.e && i2 > 0) {
            int i6 = ((i2 - 1) / 57) + 1;
            if (cVar.f) {
                i4 = 2;
            } else {
                i4 = 1;
            }
            i5 += i4 * i6;
        }
        cVar.a = new byte[i5];
        cVar.a(bArr, i, i2, true);
        if (a || cVar.b == i5) {
            return cVar.a;
        }
        throw new AssertionError();
    }

    /* renamed from: com.google.ads.util.c$c  reason: collision with other inner class name */
    public static class C0003c extends a {
        static final /* synthetic */ boolean g;
        private static final byte[] h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public int c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        private final byte[] j;
        private int k;
        private final byte[] l;

        static {
            boolean z;
            if (!c.class.desiredAssertionStatus()) {
                z = true;
            } else {
                z = false;
            }
            g = z;
        }

        public C0003c(int i2, byte[] bArr) {
            boolean z;
            boolean z2 = true;
            this.a = bArr;
            this.d = (i2 & 1) == 0;
            if ((i2 & 2) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.e = z;
            this.f = (i2 & 4) == 0 ? false : z2;
            this.l = (i2 & 8) == 0 ? h : i;
            this.j = new byte[2];
            this.c = 0;
            this.k = this.e ? 19 : -1;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(byte[] r12, int r13, int r14, boolean r15) {
            /*
                r11 = this;
                byte[] r6 = r11.l
                byte[] r7 = r11.a
                r1 = 0
                int r0 = r11.k
                int r8 = r14 + r13
                r2 = -1
                int r3 = r11.c
                switch(r3) {
                    case 0: goto L_0x00a7;
                    case 1: goto L_0x00aa;
                    case 2: goto L_0x00cd;
                    default: goto L_0x000f;
                }
            L_0x000f:
                r3 = r13
            L_0x0010:
                r4 = -1
                if (r2 == r4) goto L_0x023b
                r4 = 1
                int r5 = r2 >> 18
                r5 = r5 & 63
                byte r5 = r6[r5]
                r7[r1] = r5
                r1 = 2
                int r5 = r2 >> 12
                r5 = r5 & 63
                byte r5 = r6[r5]
                r7[r4] = r5
                r4 = 3
                int r5 = r2 >> 6
                r5 = r5 & 63
                byte r5 = r6[r5]
                r7[r1] = r5
                r1 = 4
                r2 = r2 & 63
                byte r2 = r6[r2]
                r7[r4] = r2
                int r0 = r0 + -1
                if (r0 != 0) goto L_0x023b
                boolean r0 = r11.f
                if (r0 == 0) goto L_0x023f
                r0 = 5
                r2 = 13
                r7[r1] = r2
            L_0x0042:
                int r1 = r0 + 1
                r2 = 10
                r7[r0] = r2
                r0 = 19
                r5 = r0
                r4 = r1
            L_0x004c:
                int r0 = r3 + 3
                if (r0 > r8) goto L_0x00f0
                byte r0 = r12[r3]
                r0 = r0 & 255(0xff, float:3.57E-43)
                int r0 = r0 << 16
                int r1 = r3 + 1
                byte r1 = r12[r1]
                r1 = r1 & 255(0xff, float:3.57E-43)
                int r1 = r1 << 8
                r0 = r0 | r1
                int r1 = r3 + 2
                byte r1 = r12[r1]
                r1 = r1 & 255(0xff, float:3.57E-43)
                r0 = r0 | r1
                int r1 = r0 >> 18
                r1 = r1 & 63
                byte r1 = r6[r1]
                r7[r4] = r1
                int r1 = r4 + 1
                int r2 = r0 >> 12
                r2 = r2 & 63
                byte r2 = r6[r2]
                r7[r1] = r2
                int r1 = r4 + 2
                int r2 = r0 >> 6
                r2 = r2 & 63
                byte r2 = r6[r2]
                r7[r1] = r2
                int r1 = r4 + 3
                r0 = r0 & 63
                byte r0 = r6[r0]
                r7[r1] = r0
                int r3 = r3 + 3
                int r1 = r4 + 4
                int r0 = r5 + -1
                if (r0 != 0) goto L_0x023b
                boolean r0 = r11.f
                if (r0 == 0) goto L_0x0238
                int r0 = r1 + 1
                r2 = 13
                r7[r1] = r2
            L_0x009c:
                int r1 = r0 + 1
                r2 = 10
                r7[r0] = r2
                r0 = 19
                r5 = r0
                r4 = r1
                goto L_0x004c
            L_0x00a7:
                r3 = r13
                goto L_0x0010
            L_0x00aa:
                int r3 = r13 + 2
                if (r3 > r8) goto L_0x000f
                byte[] r2 = r11.j
                r3 = 0
                byte r2 = r2[r3]
                r2 = r2 & 255(0xff, float:3.57E-43)
                int r2 = r2 << 16
                int r3 = r13 + 1
                byte r4 = r12[r13]
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << 8
                r2 = r2 | r4
                int r13 = r3 + 1
                byte r3 = r12[r3]
                r3 = r3 & 255(0xff, float:3.57E-43)
                r2 = r2 | r3
                r3 = 0
                r11.c = r3
                r3 = r13
                goto L_0x0010
            L_0x00cd:
                int r3 = r13 + 1
                if (r3 > r8) goto L_0x000f
                byte[] r2 = r11.j
                r3 = 0
                byte r2 = r2[r3]
                r2 = r2 & 255(0xff, float:3.57E-43)
                int r2 = r2 << 16
                byte[] r3 = r11.j
                r4 = 1
                byte r3 = r3[r4]
                r3 = r3 & 255(0xff, float:3.57E-43)
                int r3 = r3 << 8
                r2 = r2 | r3
                int r3 = r13 + 1
                byte r4 = r12[r13]
                r4 = r4 & 255(0xff, float:3.57E-43)
                r2 = r2 | r4
                r4 = 0
                r11.c = r4
                goto L_0x0010
            L_0x00f0:
                if (r15 == 0) goto L_0x01fe
                int r0 = r11.c
                int r0 = r3 - r0
                int r1 = r8 + -1
                if (r0 != r1) goto L_0x015e
                r2 = 0
                int r0 = r11.c
                if (r0 <= 0) goto L_0x0156
                byte[] r0 = r11.j
                r1 = 1
                byte r0 = r0[r2]
                r2 = r3
            L_0x0105:
                r0 = r0 & 255(0xff, float:3.57E-43)
                int r3 = r0 << 4
                int r0 = r11.c
                int r0 = r0 - r1
                r11.c = r0
                int r1 = r4 + 1
                int r0 = r3 >> 6
                r0 = r0 & 63
                byte r0 = r6[r0]
                r7[r4] = r0
                int r0 = r1 + 1
                r3 = r3 & 63
                byte r3 = r6[r3]
                r7[r1] = r3
                boolean r1 = r11.d
                if (r1 == 0) goto L_0x0130
                int r1 = r0 + 1
                r3 = 61
                r7[r0] = r3
                int r0 = r1 + 1
                r3 = 61
                r7[r1] = r3
            L_0x0130:
                boolean r1 = r11.e
                if (r1 == 0) goto L_0x0146
                boolean r1 = r11.f
                if (r1 == 0) goto L_0x013f
                int r1 = r0 + 1
                r3 = 13
                r7[r0] = r3
                r0 = r1
            L_0x013f:
                int r1 = r0 + 1
                r3 = 10
                r7[r0] = r3
                r0 = r1
            L_0x0146:
                r3 = r2
                r4 = r0
            L_0x0148:
                boolean r0 = g
                if (r0 != 0) goto L_0x01f2
                int r0 = r11.c
                if (r0 == 0) goto L_0x01f2
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x0156:
                int r1 = r3 + 1
                byte r0 = r12[r3]
                r10 = r2
                r2 = r1
                r1 = r10
                goto L_0x0105
            L_0x015e:
                int r0 = r11.c
                int r0 = r3 - r0
                int r1 = r8 + -2
                if (r0 != r1) goto L_0x01d6
                r2 = 0
                int r0 = r11.c
                r1 = 1
                if (r0 <= r1) goto L_0x01c9
                byte[] r0 = r11.j
                r1 = 1
                byte r0 = r0[r2]
            L_0x0171:
                r0 = r0 & 255(0xff, float:3.57E-43)
                int r9 = r0 << 10
                int r0 = r11.c
                if (r0 <= 0) goto L_0x01d0
                byte[] r0 = r11.j
                int r2 = r1 + 1
                byte r0 = r0[r1]
                r1 = r2
            L_0x0180:
                r0 = r0 & 255(0xff, float:3.57E-43)
                int r0 = r0 << 2
                r0 = r0 | r9
                int r2 = r11.c
                int r1 = r2 - r1
                r11.c = r1
                int r1 = r4 + 1
                int r2 = r0 >> 12
                r2 = r2 & 63
                byte r2 = r6[r2]
                r7[r4] = r2
                int r2 = r1 + 1
                int r4 = r0 >> 6
                r4 = r4 & 63
                byte r4 = r6[r4]
                r7[r1] = r4
                int r1 = r2 + 1
                r0 = r0 & 63
                byte r0 = r6[r0]
                r7[r2] = r0
                boolean r0 = r11.d
                if (r0 == 0) goto L_0x0235
                int r0 = r1 + 1
                r2 = 61
                r7[r1] = r2
            L_0x01b1:
                boolean r1 = r11.e
                if (r1 == 0) goto L_0x01c7
                boolean r1 = r11.f
                if (r1 == 0) goto L_0x01c0
                int r1 = r0 + 1
                r2 = 13
                r7[r0] = r2
                r0 = r1
            L_0x01c0:
                int r1 = r0 + 1
                r2 = 10
                r7[r0] = r2
                r0 = r1
            L_0x01c7:
                r4 = r0
                goto L_0x0148
            L_0x01c9:
                int r1 = r3 + 1
                byte r0 = r12[r3]
                r3 = r1
                r1 = r2
                goto L_0x0171
            L_0x01d0:
                int r2 = r3 + 1
                byte r0 = r12[r3]
                r3 = r2
                goto L_0x0180
            L_0x01d6:
                boolean r0 = r11.e
                if (r0 == 0) goto L_0x0148
                if (r4 <= 0) goto L_0x0148
                r0 = 19
                if (r5 == r0) goto L_0x0148
                boolean r0 = r11.f
                if (r0 == 0) goto L_0x0233
                int r0 = r4 + 1
                r1 = 13
                r7[r4] = r1
            L_0x01ea:
                int r4 = r0 + 1
                r1 = 10
                r7[r0] = r1
                goto L_0x0148
            L_0x01f2:
                boolean r0 = g
                if (r0 != 0) goto L_0x020e
                if (r3 == r8) goto L_0x020e
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x01fe:
                int r0 = r8 + -1
                if (r3 != r0) goto L_0x0214
                byte[] r0 = r11.j
                int r1 = r11.c
                int r2 = r1 + 1
                r11.c = r2
                byte r2 = r12[r3]
                r0[r1] = r2
            L_0x020e:
                r11.b = r4
                r11.k = r5
                r0 = 1
                return r0
            L_0x0214:
                int r0 = r8 + -2
                if (r3 != r0) goto L_0x020e
                byte[] r0 = r11.j
                int r1 = r11.c
                int r2 = r1 + 1
                r11.c = r2
                byte r2 = r12[r3]
                r0[r1] = r2
                byte[] r0 = r11.j
                int r1 = r11.c
                int r2 = r1 + 1
                r11.c = r2
                int r2 = r3 + 1
                byte r2 = r12[r2]
                r0[r1] = r2
                goto L_0x020e
            L_0x0233:
                r0 = r4
                goto L_0x01ea
            L_0x0235:
                r0 = r1
                goto L_0x01b1
            L_0x0238:
                r0 = r1
                goto L_0x009c
            L_0x023b:
                r5 = r0
                r4 = r1
                goto L_0x004c
            L_0x023f:
                r0 = r1
                goto L_0x0042
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.ads.util.c.C0003c.a(byte[], int, int, boolean):boolean");
        }
    }

    private c() {
    }
}
