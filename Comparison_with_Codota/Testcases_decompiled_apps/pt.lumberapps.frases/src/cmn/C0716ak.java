package cmn;

import java.io.IOException;

/* renamed from: cmn.ak */
public class C0716ak {

    /* renamed from: a */
    private static final String f1770a = C0716ak.class.getSimpleName();

    /* renamed from: b */
    private static C0716ak f1771b;

    /* renamed from: c */
    private volatile C0718am f1772c;

    /* renamed from: a */
    public static synchronized C0716ak m3200a() {
        C0716ak akVar;
        synchronized (C0716ak.class) {
            if (f1771b == null) {
                f1771b = new C0716ak();
            }
            akVar = f1771b;
        }
        return akVar;
    }

    /* renamed from: a */
    private C0717al m3201a(String str, byte[] bArr, boolean z) {
        try {
            return m3202b(str, bArr, z);
        } catch (IOException e) {
            new StringBuilder().append(m3203c(str, bArr, z)).append(", error: ").append(e);
            throw e;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00af, code lost:
        r3 = r1.getInputStream();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b3, code lost:
        if (r10 == false) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b5, code lost:
        r3 = new java.util.zip.GZIPInputStream(r3, android.support.p009v4.app.FragmentTransaction.TRANSIT_EXIT_MASK);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bd, code lost:
        r2 = cmn.C0719an.m3212a((java.io.InputStream) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c0, code lost:
        cmn.C0719an.m3210a((java.io.Closeable) r3);
        r1.disconnect();
        r1 = r2;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r3 = new java.io.BufferedInputStream(r3, android.support.p009v4.app.FragmentTransaction.TRANSIT_EXIT_MASK);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        new java.lang.StringBuilder().append(m3203c(r8, r9, r10)).append(", status code: ").append(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0108, code lost:
        cmn.C0719an.m3210a((java.io.Closeable) null);
        r1.disconnect();
        r1 = null;
        r2 = r4;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private cmn.C0717al m3202b(java.lang.String r8, byte[] r9, boolean r10) {
        /*
            r7 = this;
            r1 = 0
            r3 = 0
            if (r8 == 0) goto L_0x001b
            java.lang.String r2 = "//"
            boolean r2 = r8.startsWith(r2)
            if (r2 == 0) goto L_0x001b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "https:"
            r2.<init>(r4)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r8 = r2.toString()
        L_0x001b:
            r5 = r1
        L_0x001c:
            r2 = 5
            if (r5 >= r2) goto L_0x011c
            java.net.URL r1 = new java.net.URL
            r1.<init>(r8)
            java.net.URLConnection r1 = r1.openConnection()
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1
            cmn.am r2 = r7.f1772c     // Catch:{ all -> 0x0111 }
            if (r2 == 0) goto L_0x0048
            boolean r2 = r1 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ all -> 0x0111 }
            if (r2 == 0) goto L_0x0048
            r0 = r1
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ all -> 0x0111 }
            r2 = r0
            cmn.am r4 = r7.f1772c     // Catch:{ all -> 0x0111 }
            javax.net.ssl.SSLSocketFactory r4 = r4.mo3403a()     // Catch:{ all -> 0x0111 }
            r2.setSSLSocketFactory(r4)     // Catch:{ all -> 0x0111 }
            cmn.am r4 = r7.f1772c     // Catch:{ all -> 0x0111 }
            javax.net.ssl.HostnameVerifier r4 = r4.mo3404b()     // Catch:{ all -> 0x0111 }
            r2.setHostnameVerifier(r4)     // Catch:{ all -> 0x0111 }
        L_0x0048:
            r2 = 30000(0x7530, float:4.2039E-41)
            r1.setConnectTimeout(r2)     // Catch:{ all -> 0x0111 }
            r2 = 30000(0x7530, float:4.2039E-41)
            r1.setReadTimeout(r2)     // Catch:{ all -> 0x0111 }
            r2 = 1
            r1.setInstanceFollowRedirects(r2)     // Catch:{ all -> 0x0111 }
            java.lang.String r2 = "User-Agent"
            cmn.n r4 = cmn.C0752n.m3278b()     // Catch:{ all -> 0x0111 }
            java.lang.String r4 = r4.mo3445s()     // Catch:{ all -> 0x0111 }
            r1.setRequestProperty(r2, r4)     // Catch:{ all -> 0x0111 }
            if (r9 == 0) goto L_0x00a7
            if (r10 == 0) goto L_0x0119
            java.lang.String r2 = "Accept-Encoding"
            java.lang.String r4 = "identity"
            r1.setRequestProperty(r2, r4)     // Catch:{ all -> 0x0111 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0111 }
            r2.<init>()     // Catch:{ all -> 0x0111 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0111 }
            r6 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r2, r6)     // Catch:{ all -> 0x0111 }
            r4.write(r9)     // Catch:{ all -> 0x0111 }
            r4.close()     // Catch:{ all -> 0x0111 }
            byte[] r2 = r2.toByteArray()     // Catch:{ all -> 0x0111 }
        L_0x0084:
            r4 = 1
            r1.setDoOutput(r4)     // Catch:{ all -> 0x0111 }
            int r4 = r2.length     // Catch:{ all -> 0x0111 }
            r1.setFixedLengthStreamingMode(r4)     // Catch:{ all -> 0x0111 }
            java.lang.String r4 = "Content-Length"
            int r6 = r2.length     // Catch:{ all -> 0x0111 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0111 }
            r1.setRequestProperty(r4, r6)     // Catch:{ all -> 0x0111 }
            java.lang.String r4 = "Content-Type"
            java.lang.String r6 = "application/octet-stream"
            r1.setRequestProperty(r4, r6)     // Catch:{ all -> 0x0111 }
            java.io.OutputStream r4 = r1.getOutputStream()     // Catch:{ all -> 0x0111 }
            r4.write(r2)     // Catch:{ all -> 0x0111 }
            r4.close()     // Catch:{ all -> 0x0111 }
        L_0x00a7:
            int r4 = r1.getResponseCode()     // Catch:{ all -> 0x0111 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r4 != r2) goto L_0x00d8
            java.io.InputStream r3 = r1.getInputStream()     // Catch:{ all -> 0x0111 }
            if (r10 == 0) goto L_0x00cf
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0111 }
            r5 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r3, r5)     // Catch:{ all -> 0x0111 }
            r3 = r2
        L_0x00bd:
            byte[] r2 = cmn.C0719an.m3212a((java.io.InputStream) r3)     // Catch:{ all -> 0x0111 }
            cmn.C0719an.m3210a((java.io.Closeable) r3)
            r1.disconnect()
            r1 = r2
            r2 = r4
        L_0x00c9:
            cmn.al r3 = new cmn.al
            r3.<init>(r2, r1)
            return r3
        L_0x00cf:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0111 }
            r5 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r3, r5)     // Catch:{ all -> 0x0111 }
            r3 = r2
            goto L_0x00bd
        L_0x00d8:
            r2 = 302(0x12e, float:4.23E-43)
            if (r4 == r2) goto L_0x00e0
            r2 = 301(0x12d, float:4.22E-43)
            if (r4 != r2) goto L_0x00f2
        L_0x00e0:
            java.lang.String r2 = "Location"
            java.lang.String r8 = r1.getHeaderField(r2)     // Catch:{ all -> 0x0111 }
            int r2 = r5 + 1
            cmn.C0719an.m3210a((java.io.Closeable) r3)
            r1.disconnect()
            r5 = r2
            r1 = r4
            goto L_0x001c
        L_0x00f2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0111 }
            r2.<init>()     // Catch:{ all -> 0x0111 }
            java.lang.String r5 = m3203c(r8, r9, r10)     // Catch:{ all -> 0x0111 }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x0111 }
            java.lang.String r5 = ", status code: "
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x0111 }
            r2.append(r4)     // Catch:{ all -> 0x0111 }
            cmn.C0719an.m3210a((java.io.Closeable) r3)
            r1.disconnect()
            r1 = r3
            r2 = r4
            goto L_0x00c9
        L_0x0111:
            r2 = move-exception
            cmn.C0719an.m3210a((java.io.Closeable) r3)
            r1.disconnect()
            throw r2
        L_0x0119:
            r2 = r9
            goto L_0x0084
        L_0x011c:
            r2 = r1
            r1 = r3
            goto L_0x00c9
        */
        throw new UnsupportedOperationException("Method not decompiled: cmn.C0716ak.m3202b(java.lang.String, byte[], boolean):cmn.al");
    }

    /* renamed from: c */
    private static String m3203c(String str, byte[] bArr, boolean z) {
        return "HTTP " + (bArr == null ? "GET" : "POST") + (z ? " (gzipped)" : "") + ": " + str;
    }

    /* renamed from: a */
    public final C0717al mo3399a(String str) {
        return m3201a(str, (byte[]) null, false);
    }

    /* renamed from: a */
    public final C0717al mo3400a(String str, byte[] bArr) {
        if (bArr != null) {
            return m3201a(str, bArr, true);
        }
        throw new IOException("Body can't be null for POST request.");
    }
}
