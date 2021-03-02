package org.commonwealthcu.mobile;

import java.net.URL;

/* renamed from: org.commonwealthcu.mobile.z */
final class C0647z extends Thread {

    /* renamed from: a */
    private URL f873a;

    /* renamed from: b */
    private /* synthetic */ String f874b;

    /* renamed from: c */
    private /* synthetic */ int f875c;

    /* renamed from: d */
    private /* synthetic */ MainActivity f876d;

    C0647z(MainActivity mainActivity, String str, int i) {
        this.f876d = mainActivity;
        this.f874b = str;
        this.f875c = i;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x006c A[Catch:{ IOException -> 0x009e, Exception -> 0x00a7, IOException | MalformedURLException -> 0x00a3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            java.lang.String r1 = r10.f874b     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            r0.<init>(r1)     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            r10.f873a = r0     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            java.lang.String r0 = r10.f874b     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            java.lang.String r1 = r10.f874b     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            r2 = 47
            int r1 = r1.lastIndexOf(r2)     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            int r1 = r1 + 1
            java.lang.String r2 = r0.substring(r1)     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            org.commonwealthcu.mobile.MainActivity r0 = r10.f876d     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            java.io.File r3 = r0.getFileStreamPath(r2)     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            r1 = 0
            boolean r4 = r3.exists()     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            boolean r0 = r3.exists()     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            if (r0 == 0) goto L_0x009c
            java.net.URL r0 = r10.f873a     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            java.lang.String r5 = "HEAD"
            r0.setRequestMethod(r5)     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            long r6 = r0.getLastModified()     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            long r8 = r3.lastModified()     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            java.util.Date r0 = new java.util.Date     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            r0.<init>(r6)     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            java.util.Date r3 = new java.util.Date     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            r3.<init>(r8)     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            boolean r0 = r0.after(r3)     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            if (r0 == 0) goto L_0x0092
            r0 = 1
        L_0x0050:
            if (r4 == 0) goto L_0x0054
            if (r0 == 0) goto L_0x0091
        L_0x0054:
            android.os.Message r3 = android.os.Message.obtain()     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            int r0 = r10.f875c     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            r3.what = r0     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            r3.obj = r2     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            org.commonwealthcu.mobile.MainActivity r0 = r10.f876d     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
            java.lang.String r1 = r10.f874b     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
            java.io.InputStream r1 = org.commonwealthcu.mobile.MainActivity.m1256c(r1)     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
            if (r0 != 0) goto L_0x0078
            org.commonwealthcu.mobile.MainActivity r0 = r10.f876d     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
            java.lang.String r1 = r10.f874b     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
            java.io.InputStream r1 = org.commonwealthcu.mobile.MainActivity.m1256c(r1)     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
        L_0x0078:
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
            r2.<init>()     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
            java.lang.String r4 = "bitmap"
            r2.putParcelable(r4, r0)     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
            r3.setData(r2)     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
            r1.close()     // Catch:{ IOException -> 0x009e, Exception -> 0x00a7, MalformedURLException -> 0x00a3 }
        L_0x0088:
            org.commonwealthcu.mobile.MainActivity r0 = r10.f876d     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            android.os.Handler r0 = r0.f676k     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            r0.sendMessage(r3)     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
        L_0x0091:
            return
        L_0x0092:
            org.commonwealthcu.mobile.MainActivity r0 = r10.f876d     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            android.os.Handler r0 = r0.f676k     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            r3 = 3
            r0.sendEmptyMessage(r3)     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
        L_0x009c:
            r0 = r1
            goto L_0x0050
        L_0x009e:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ MalformedURLException -> 0x00a3, IOException -> 0x00a5 }
            goto L_0x0088
        L_0x00a3:
            r0 = move-exception
            goto L_0x0091
        L_0x00a5:
            r0 = move-exception
            goto L_0x0091
        L_0x00a7:
            r0 = move-exception
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonwealthcu.mobile.C0647z.run():void");
    }
}
