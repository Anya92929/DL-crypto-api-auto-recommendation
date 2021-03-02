package com.jackhenry.godough.p028c.p029a.p030a;

import android.graphics.BitmapFactory;

/* renamed from: com.jackhenry.godough.c.a.a.a */
public class C1397a implements C1401c {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037 A[SYNTHETIC, Splitter:B:17:0x0037] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object mo9444a(java.lang.Object r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.graphics.Bitmap
            if (r0 == 0) goto L_0x003b
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ UnsupportedEncodingException -> 0x002a, all -> 0x0065 }
            r3.<init>()     // Catch:{ UnsupportedEncodingException -> 0x002a, all -> 0x0065 }
            android.util.Base64OutputStream r1 = new android.util.Base64OutputStream     // Catch:{ UnsupportedEncodingException -> 0x002a, all -> 0x0065 }
            r0 = 0
            r1.<init>(r3, r0)     // Catch:{ UnsupportedEncodingException -> 0x002a, all -> 0x0065 }
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5     // Catch:{ UnsupportedEncodingException -> 0x0068 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ UnsupportedEncodingException -> 0x0068 }
            r2 = 90
            r5.compress(r0, r2, r1)     // Catch:{ UnsupportedEncodingException -> 0x0068 }
            java.lang.String r0 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0068 }
            byte[] r2 = r3.toByteArray()     // Catch:{ UnsupportedEncodingException -> 0x0068 }
            java.lang.String r3 = "UTF-8"
            r0.<init>(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x0068 }
            if (r1 == 0) goto L_0x0029
            r1.close()     // Catch:{ IOException -> 0x0061 }
        L_0x0029:
            return r0
        L_0x002a:
            r0 = move-exception
            r1 = r2
        L_0x002c:
            com.jackhenry.godough.b.f r2 = new com.jackhenry.godough.b.f     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "Problem serializing the Bitmap"
            r2.<init>((java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0034 }
            throw r2     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r0 = move-exception
        L_0x0035:
            if (r1 == 0) goto L_0x003a
            r1.close()     // Catch:{ IOException -> 0x0063 }
        L_0x003a:
            throw r0
        L_0x003b:
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0050 }
            byte[] r5 = (byte[]) r5     // Catch:{ UnsupportedEncodingException -> 0x0050 }
            byte[] r5 = (byte[]) r5     // Catch:{ UnsupportedEncodingException -> 0x0050 }
            r1 = 0
            byte[] r1 = android.util.Base64.encode(r5, r1)     // Catch:{ UnsupportedEncodingException -> 0x0050 }
            java.lang.String r2 = "UTF-8"
            r0.<init>(r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x0050 }
            goto L_0x0029
        L_0x0050:
            r0 = move-exception
            com.jackhenry.godough.b.f r1 = new com.jackhenry.godough.b.f
            java.lang.String r2 = "Problem serializing the Bitmap byte[]"
            r1.<init>((java.lang.String) r2, (java.lang.Throwable) r0)
            throw r1
        L_0x0059:
            com.jackhenry.godough.b.f r0 = new com.jackhenry.godough.b.f
            java.lang.String r1 = "The domainObject is not a Bitmap"
            r0.<init>(r1)
            throw r0
        L_0x0061:
            r1 = move-exception
            goto L_0x0029
        L_0x0063:
            r1 = move-exception
            goto L_0x003a
        L_0x0065:
            r0 = move-exception
            r1 = r2
            goto L_0x0035
        L_0x0068:
            r0 = move-exception
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jackhenry.godough.p028c.p029a.p030a.C1397a.mo9444a(java.lang.Object):java.lang.Object");
    }

    /* renamed from: a */
    public Object mo9445a(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }
}
