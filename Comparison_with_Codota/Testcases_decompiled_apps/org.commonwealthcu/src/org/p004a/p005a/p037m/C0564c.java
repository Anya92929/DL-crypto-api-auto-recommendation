package org.p004a.p005a.p037m;

import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.m.c */
public final class C0564c {

    /* renamed from: a */
    private final String f635a;

    /* renamed from: b */
    private final String f636b;

    /* renamed from: c */
    private final String f637c;

    /* renamed from: d */
    private final String f638d;

    /* renamed from: e */
    private final String f639e;

    private C0564c(String str, String str2, String str3, String str4, String str5) {
        C0250b.m84a((Object) str, "Package identifier");
        this.f635a = str;
        this.f636b = str2 == null ? "UNAVAILABLE" : str2;
        this.f637c = str3 == null ? "UNAVAILABLE" : str3;
        this.f638d = str4 == null ? "UNAVAILABLE" : str4;
        this.f639e = str5 == null ? "UNAVAILABLE" : str5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b3  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.p004a.p005a.p037m.C0564c m1199a(java.lang.String r6, java.lang.ClassLoader r7) {
        /*
            r5 = 0
            java.lang.String r0 = "Package identifier"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r6, (java.lang.String) r0)
            if (r7 == 0) goto L_0x0090
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009f }
            r0.<init>()     // Catch:{ IOException -> 0x009f }
            r1 = 46
            r2 = 47
            java.lang.String r1 = r6.replace(r1, r2)     // Catch:{ IOException -> 0x009f }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ IOException -> 0x009f }
            java.lang.String r1 = "/version.properties"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ IOException -> 0x009f }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x009f }
            java.io.InputStream r1 = r7.getResourceAsStream(r0)     // Catch:{ IOException -> 0x009f }
            if (r1 == 0) goto L_0x00a3
            java.util.Properties r0 = new java.util.Properties     // Catch:{ all -> 0x009a }
            r0.<init>()     // Catch:{ all -> 0x009a }
            r0.load(r1)     // Catch:{ all -> 0x009a }
            r1.close()     // Catch:{ IOException -> 0x00a5 }
            r3 = r0
        L_0x0035:
            if (r3 == 0) goto L_0x00b3
            java.lang.String r0 = "Package identifier"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r6, (java.lang.String) r0)
            if (r3 == 0) goto L_0x00af
            java.lang.String r0 = "info.module"
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x00ad
            int r1 = r0.length()
            if (r1 > 0) goto L_0x00ad
            r1 = r5
        L_0x004f:
            java.lang.String r0 = "info.release"
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x00ab
            int r2 = r0.length()
            if (r2 <= 0) goto L_0x0067
            java.lang.String r2 = "${pom.version}"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00ab
        L_0x0067:
            r2 = r5
        L_0x0068:
            java.lang.String r0 = "info.timestamp"
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x00a7
            int r3 = r0.length()
            if (r3 <= 0) goto L_0x0080
            java.lang.String r3 = "${mvn.timestamp}"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00a7
        L_0x0080:
            r4 = r5
            r3 = r2
            r2 = r1
        L_0x0083:
            if (r7 == 0) goto L_0x0089
            java.lang.String r5 = r7.toString()
        L_0x0089:
            org.a.a.m.c r0 = new org.a.a.m.c
            r1 = r6
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x008f:
            return r0
        L_0x0090:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r7 = r0.getContextClassLoader()
            goto L_0x0008
        L_0x009a:
            r0 = move-exception
            r1.close()     // Catch:{ IOException -> 0x009f }
            throw r0     // Catch:{ IOException -> 0x009f }
        L_0x009f:
            r0 = move-exception
            r0 = r5
        L_0x00a1:
            r3 = r0
            goto L_0x0035
        L_0x00a3:
            r3 = r5
            goto L_0x0035
        L_0x00a5:
            r1 = move-exception
            goto L_0x00a1
        L_0x00a7:
            r4 = r0
            r3 = r2
            r2 = r1
            goto L_0x0083
        L_0x00ab:
            r2 = r0
            goto L_0x0068
        L_0x00ad:
            r1 = r0
            goto L_0x004f
        L_0x00af:
            r4 = r5
            r3 = r5
            r2 = r5
            goto L_0x0083
        L_0x00b3:
            r0 = r5
            goto L_0x008f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p004a.p005a.p037m.C0564c.m1199a(java.lang.String, java.lang.ClassLoader):org.a.a.m.c");
    }

    /* renamed from: a */
    public final String mo5439a() {
        return this.f637c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.f635a.length() + 20 + this.f636b.length() + this.f637c.length() + this.f638d.length() + this.f639e.length());
        sb.append("VersionInfo(").append(this.f635a).append(':').append(this.f636b);
        if (!"UNAVAILABLE".equals(this.f637c)) {
            sb.append(':').append(this.f637c);
        }
        if (!"UNAVAILABLE".equals(this.f638d)) {
            sb.append(':').append(this.f638d);
        }
        sb.append(')');
        if (!"UNAVAILABLE".equals(this.f639e)) {
            sb.append('@').append(this.f639e);
        }
        return sb.toString();
    }
}
