package com.google.android.gms.internal;

public class zznd {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x006b, code lost:
        r0 = (r0 | (r6[r2] & 255)) * -862048943;
        r0 = (((r0 >>> 17) | (r0 << 15)) * 461845907) ^ r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0047, code lost:
        r0 = r0 ^ r8;
        r0 = (r0 ^ (r0 >>> 16)) * -2048144789;
        r0 = (r0 ^ (r0 >>> 13)) * -1028477387;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0059, code lost:
        return r0 ^ (r0 >>> 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0062, code lost:
        r0 = r0 | ((r6[r2 + 1] & 255) << 8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(byte[] r6, int r7, int r8, int r9) {
        /*
            r5 = 461845907(0x1b873593, float:2.2368498E-22)
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            r0 = r8 & -4
            int r2 = r7 + r0
            r1 = r9
        L_0x000b:
            if (r7 >= r2) goto L_0x0040
            byte r0 = r6[r7]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r7 + 1
            byte r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 8
            r0 = r0 | r3
            int r3 = r7 + 2
            byte r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 16
            r0 = r0 | r3
            int r3 = r7 + 3
            byte r3 = r6[r3]
            int r3 = r3 << 24
            r0 = r0 | r3
            int r0 = r0 * r4
            int r3 = r0 << 15
            int r0 = r0 >>> 17
            r0 = r0 | r3
            int r0 = r0 * r5
            r0 = r0 ^ r1
            int r1 = r0 << 13
            int r0 = r0 >>> 19
            r0 = r0 | r1
            int r0 = r0 * 5
            r1 = -430675100(0xffffffffe6546b64, float:-2.5078068E23)
            int r1 = r1 + r0
            int r7 = r7 + 4
            goto L_0x000b
        L_0x0040:
            r0 = 0
            r3 = r8 & 3
            switch(r3) {
                case 1: goto L_0x006b;
                case 2: goto L_0x0062;
                case 3: goto L_0x005a;
                default: goto L_0x0046;
            }
        L_0x0046:
            r0 = r1
        L_0x0047:
            r0 = r0 ^ r8
            int r1 = r0 >>> 16
            r0 = r0 ^ r1
            r1 = -2048144789(0xffffffff85ebca6b, float:-2.217365E-35)
            int r0 = r0 * r1
            int r1 = r0 >>> 13
            r0 = r0 ^ r1
            r1 = -1028477387(0xffffffffc2b2ae35, float:-89.34025)
            int r0 = r0 * r1
            int r1 = r0 >>> 16
            r0 = r0 ^ r1
            return r0
        L_0x005a:
            int r0 = r2 + 2
            byte r0 = r6[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << 16
        L_0x0062:
            int r3 = r2 + 1
            byte r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 8
            r0 = r0 | r3
        L_0x006b:
            byte r2 = r6[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r0 = r0 | r2
            int r0 = r0 * r4
            int r2 = r0 << 15
            int r0 = r0 >>> 17
            r0 = r0 | r2
            int r0 = r0 * r5
            r0 = r0 ^ r1
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zznd.zza(byte[], int, int, int):int");
    }
}
