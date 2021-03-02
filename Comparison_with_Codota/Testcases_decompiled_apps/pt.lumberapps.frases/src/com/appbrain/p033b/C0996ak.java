package com.appbrain.p033b;

/* renamed from: com.appbrain.b.ak */
final class C0996ak {
    /* renamed from: a */
    private static int m4138a(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return (i2 << 8) ^ i;
    }

    /* renamed from: a */
    private static int m4139a(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return ((i2 << 8) ^ i) ^ (i3 << 16);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
        if (r8[r2] > -65) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007d, code lost:
        if (r8[r2] > -65) goto L_0x007f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m4140a(int r7, byte[] r8, int r9, int r10) {
        /*
            r3 = -32
            r4 = -96
            r1 = -1
            r6 = -65
            if (r7 == 0) goto L_0x0082
            if (r9 < r10) goto L_0x000c
        L_0x000b:
            return r7
        L_0x000c:
            byte r5 = (byte) r7
            if (r5 >= r3) goto L_0x001b
            r0 = -62
            if (r5 < r0) goto L_0x0019
            int r0 = r9 + 1
            byte r2 = r8[r9]
            if (r2 <= r6) goto L_0x0081
        L_0x0019:
            r7 = r1
            goto L_0x000b
        L_0x001b:
            r0 = -16
            if (r5 >= r0) goto L_0x0046
            int r0 = r7 >> 8
            r0 = r0 ^ -1
            byte r0 = (byte) r0
            if (r0 != 0) goto L_0x0031
            int r2 = r9 + 1
            byte r0 = r8[r9]
            if (r2 < r10) goto L_0x0032
            int r7 = m4138a(r5, r0)
            goto L_0x000b
        L_0x0031:
            r2 = r9
        L_0x0032:
            if (r0 > r6) goto L_0x0044
            if (r5 != r3) goto L_0x0038
            if (r0 < r4) goto L_0x0044
        L_0x0038:
            r3 = -19
            if (r5 != r3) goto L_0x003e
            if (r0 >= r4) goto L_0x0044
        L_0x003e:
            int r9 = r2 + 1
            byte r0 = r8[r2]
            if (r0 <= r6) goto L_0x0082
        L_0x0044:
            r7 = r1
            goto L_0x000b
        L_0x0046:
            int r0 = r7 >> 8
            r0 = r0 ^ -1
            byte r2 = (byte) r0
            r0 = 0
            if (r2 != 0) goto L_0x0059
            int r3 = r9 + 1
            byte r2 = r8[r9]
            if (r3 < r10) goto L_0x0087
            int r7 = m4138a(r5, r2)
            goto L_0x000b
        L_0x0059:
            int r0 = r7 >> 16
            byte r0 = (byte) r0
            r4 = r2
            r3 = r9
        L_0x005e:
            if (r0 != 0) goto L_0x006b
            int r2 = r3 + 1
            byte r0 = r8[r3]
            if (r2 < r10) goto L_0x006c
            int r7 = m4139a((int) r5, (int) r4, (int) r0)
            goto L_0x000b
        L_0x006b:
            r2 = r3
        L_0x006c:
            if (r4 > r6) goto L_0x007f
            int r3 = r5 << 28
            int r4 = r4 + 112
            int r3 = r3 + r4
            int r3 = r3 >> 30
            if (r3 != 0) goto L_0x007f
            if (r0 > r6) goto L_0x007f
            int r9 = r2 + 1
            byte r0 = r8[r2]
            if (r0 <= r6) goto L_0x0082
        L_0x007f:
            r7 = r1
            goto L_0x000b
        L_0x0081:
            r9 = r0
        L_0x0082:
            int r7 = m4142b(r8, r9, r10)
            goto L_0x000b
        L_0x0087:
            r4 = r2
            goto L_0x005e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p033b.C0996ak.m4140a(int, byte[], int, int):int");
    }

    /* renamed from: a */
    public static boolean m4141a(byte[] bArr, int i, int i2) {
        return m4142b(bArr, i, i2) == 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: byte} */
    /* JADX WARNING: CFG modification limit reached, blocks count: 151 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r0 >= -32) goto L_0x0031;
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        if (r3 >= r11) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
        if (r0 < -62) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        r0 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        if (r9[r3] <= -65) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        r0 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        if (r0 >= -16) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        if (r3 < (r11 - 1)) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0039, code lost:
        r0 = m4143c(r9, r3, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r4 = r3 + 1;
        r3 = r9[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        if (r3 > -65) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
        if (r0 != -32) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        if (r3 < -96) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
        if (r0 != -19) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
        if (r3 >= -96) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004e, code lost:
        r0 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0052, code lost:
        if (r9[r4] <= -65) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0054, code lost:
        r0 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0058, code lost:
        if (r3 < (r11 - 2)) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005a, code lost:
        r0 = m4143c(r9, r3, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005f, code lost:
        r4 = r3 + 1;
        r3 = r9[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0063, code lost:
        if (r3 > -65) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006c, code lost:
        if ((((r0 << 28) + (r3 + android.support.p021v7.p023b.C0515k.AppCompatTheme_spinnerStyle)) >> 30) != 0) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006e, code lost:
        r3 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0072, code lost:
        if (r9[r4] > -65) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0074, code lost:
        r0 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0078, code lost:
        if (r9[r3] <= -65) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007a, code lost:
        r0 = -1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m4142b(byte[] r9, int r10, int r11) {
        /*
            r1 = 0
            r8 = -32
            r7 = -96
            r2 = -1
            r6 = -65
            r0 = r10
        L_0x0009:
            if (r0 >= r11) goto L_0x0012
            byte r3 = r9[r0]
            if (r3 < 0) goto L_0x0012
            int r0 = r0 + 1
            goto L_0x0009
        L_0x0012:
            if (r0 < r11) goto L_0x0017
            r0 = r1
        L_0x0015:
            return r0
        L_0x0016:
            r0 = r3
        L_0x0017:
            if (r0 < r11) goto L_0x001b
            r0 = r1
            goto L_0x0015
        L_0x001b:
            int r3 = r0 + 1
            byte r0 = r9[r0]
            if (r0 >= 0) goto L_0x0016
            if (r0 >= r8) goto L_0x0031
            if (r3 >= r11) goto L_0x0015
            r4 = -62
            if (r0 < r4) goto L_0x002f
            int r0 = r3 + 1
            byte r3 = r9[r3]
            if (r3 <= r6) goto L_0x0017
        L_0x002f:
            r0 = r2
            goto L_0x0015
        L_0x0031:
            r4 = -16
            if (r0 >= r4) goto L_0x0056
            int r4 = r11 + -1
            if (r3 < r4) goto L_0x003e
            int r0 = m4143c(r9, r3, r11)
            goto L_0x0015
        L_0x003e:
            int r4 = r3 + 1
            byte r3 = r9[r3]
            if (r3 > r6) goto L_0x0054
            if (r0 != r8) goto L_0x0048
            if (r3 < r7) goto L_0x0054
        L_0x0048:
            r5 = -19
            if (r0 != r5) goto L_0x004e
            if (r3 >= r7) goto L_0x0054
        L_0x004e:
            int r0 = r4 + 1
            byte r3 = r9[r4]
            if (r3 <= r6) goto L_0x0017
        L_0x0054:
            r0 = r2
            goto L_0x0015
        L_0x0056:
            int r4 = r11 + -2
            if (r3 < r4) goto L_0x005f
            int r0 = m4143c(r9, r3, r11)
            goto L_0x0015
        L_0x005f:
            int r4 = r3 + 1
            byte r3 = r9[r3]
            if (r3 > r6) goto L_0x007a
            int r0 = r0 << 28
            int r3 = r3 + 112
            int r0 = r0 + r3
            int r0 = r0 >> 30
            if (r0 != 0) goto L_0x007a
            int r3 = r4 + 1
            byte r0 = r9[r4]
            if (r0 > r6) goto L_0x007a
            int r0 = r3 + 1
            byte r3 = r9[r3]
            if (r3 <= r6) goto L_0x0017
        L_0x007a:
            r0 = r2
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p033b.C0996ak.m4142b(byte[], int, int):int");
    }

    /* renamed from: c */
    private static int m4143c(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                if (b > -12) {
                    return -1;
                }
                return b;
            case 1:
                return m4138a(b, bArr[i]);
            case 2:
                return m4139a((int) b, (int) bArr[i], (int) bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }
}
