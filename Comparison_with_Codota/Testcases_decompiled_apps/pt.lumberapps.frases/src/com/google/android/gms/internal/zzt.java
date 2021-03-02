package com.google.android.gms.internal;

import android.support.p009v4.app.FragmentTransaction;
import com.google.android.gms.internal.zzb;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class zzt implements zzf {

    /* renamed from: a */
    protected static final boolean f6989a = zzs.DEBUG;

    /* renamed from: d */
    private static int f6990d = 3000;

    /* renamed from: e */
    private static int f6991e = FragmentTransaction.TRANSIT_ENTER_MASK;

    /* renamed from: b */
    protected final zzy f6992b;

    /* renamed from: c */
    protected final zzu f6993c;

    public zzt(zzy zzy) {
        this(zzy, new zzu(f6991e));
    }

    public zzt(zzy zzy, zzu zzu) {
        this.f6992b = zzy;
        this.f6993c = zzu;
    }

    /* renamed from: a */
    protected static Map m7556a(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    /* renamed from: a */
    private void m7557a(long j, zzk zzk, byte[] bArr, StatusLine statusLine) {
        if (f6989a || j > ((long) f6990d)) {
            Object[] objArr = new Object[5];
            objArr[0] = zzk;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(zzk.zzt().zzd());
            zzs.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* renamed from: a */
    private static void m7558a(String str, zzk zzk, zzr zzr) {
        zzo zzt = zzk.zzt();
        int zzs = zzk.zzs();
        try {
            zzt.zza(zzr);
            zzk.zzc(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(zzs)}));
        } catch (zzr e) {
            zzk.zzc(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(zzs)}));
            throw e;
        }
    }

    /* renamed from: a */
    private void m7559a(Map map, zzb.zza zza) {
        if (zza != null) {
            if (zza.zza != null) {
                map.put("If-None-Match", zza.zza);
            }
            if (zza.zzc > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(zza.zzc)));
            }
        }
    }

    /* renamed from: a */
    private byte[] m7560a(HttpEntity httpEntity) {
        zzaa zzaa = new zzaa(this.f6993c, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new zzp();
            }
            bArr = this.f6993c.zzb(1024);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                zzaa.write(bArr, 0, read);
            }
            byte[] byteArray = zzaa.toByteArray();
            try {
            } catch (IOException e) {
                zzs.zza("Error occured when calling consumingContent", new Object[0]);
            }
            return byteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                zzs.zza("Error occured when calling consumingContent", new Object[0]);
            }
            this.f6993c.zza(bArr);
            zzaa.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0091, code lost:
        m7558a("socket", r19, new com.google.android.gms.internal.zzq());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b2, code lost:
        m7558a("connection", r19, new com.google.android.gms.internal.zzq());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c0, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c1, code lost:
        r3 = r2;
        r2 = java.lang.String.valueOf(r19.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d2, code lost:
        if (r2.length() != 0) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d4, code lost:
        r2 = "Bad URL ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00db, code lost:
        throw new java.lang.RuntimeException(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00dc, code lost:
        r2 = new java.lang.String("Bad URL ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e2, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e3, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e6, code lost:
        r4 = r3.getStatusLine().getStatusCode();
        com.google.android.gms.internal.zzs.zzc("Unexpected response code %d for %s", java.lang.Integer.valueOf(r4), r19.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0104, code lost:
        if (r5 != null) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0106, code lost:
        r3 = new com.google.android.gms.internal.zzi(r4, r5, r6, false, android.os.SystemClock.elapsedRealtime() - r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0114, code lost:
        if (r4 == 401) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x011a, code lost:
        m7558a("auth", r19, new com.google.android.gms.internal.zza(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x012d, code lost:
        throw new com.google.android.gms.internal.zzj(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0133, code lost:
        throw new com.google.android.gms.internal.zzp(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013a, code lost:
        throw new com.google.android.gms.internal.zzh((com.google.android.gms.internal.zzi) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x013f, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0140, code lost:
        r5 = r11;
        r3 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b1 A[ExcHandler: ConnectTimeoutException (e org.apache.http.conn.ConnectTimeoutException), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c0 A[ExcHandler: MalformedURLException (r2v9 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0128 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzi zza(com.google.android.gms.internal.zzk r19) {
        /*
            r18 = this;
            long r16 = android.os.SystemClock.elapsedRealtime()
        L_0x0004:
            r3 = 0
            r14 = 0
            java.util.Map r6 = java.util.Collections.emptyMap()
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00e2 }
            r2.<init>()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00e2 }
            com.google.android.gms.internal.zzb$zza r4 = r19.zzh()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00e2 }
            r0 = r18
            r0.m7559a(r2, r4)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00e2 }
            r0 = r18
            com.google.android.gms.internal.zzy r4 = r0.f6992b     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00e2 }
            r0 = r19
            org.apache.http.HttpResponse r15 = r4.zza(r0, r2)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00e2 }
            org.apache.http.StatusLine r12 = r15.getStatusLine()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            int r4 = r12.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            org.apache.http.Header[] r2 = r15.getAllHeaders()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            java.util.Map r6 = m7556a((org.apache.http.Header[]) r2)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            r2 = 304(0x130, float:4.26E-43)
            if (r4 != r2) goto L_0x0065
            com.google.android.gms.internal.zzb$zza r2 = r19.zzh()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            if (r2 != 0) goto L_0x004c
            com.google.android.gms.internal.zzi r3 = new com.google.android.gms.internal.zzi     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            r4 = 304(0x130, float:4.26E-43)
            r5 = 0
            r7 = 1
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            long r8 = r8 - r16
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        L_0x004b:
            return r3
        L_0x004c:
            java.util.Map r3 = r2.zzf     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            r3.putAll(r6)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            com.google.android.gms.internal.zzi r7 = new com.google.android.gms.internal.zzi     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            r8 = 304(0x130, float:4.26E-43)
            byte[] r9 = r2.data     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            java.util.Map r10 = r2.zzf     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            r11 = 1
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            long r12 = r2 - r16
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            r3 = r7
            goto L_0x004b
        L_0x0065:
            org.apache.http.HttpEntity r2 = r15.getEntity()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            if (r2 == 0) goto L_0x009f
            org.apache.http.HttpEntity r2 = r15.getEntity()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            r0 = r18
            byte[] r11 = r0.m7560a((org.apache.http.HttpEntity) r2)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        L_0x0075:
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
            long r8 = r2 - r16
            r7 = r18
            r10 = r19
            r7.m7557a(r8, r10, r11, r12)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
            r2 = 200(0xc8, float:2.8E-43)
            if (r4 < r2) goto L_0x008a
            r2 = 299(0x12b, float:4.19E-43)
            if (r4 <= r2) goto L_0x00a3
        L_0x008a:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
            r2.<init>()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
            throw r2     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
        L_0x0090:
            r2 = move-exception
            java.lang.String r2 = "socket"
            com.google.android.gms.internal.zzq r3 = new com.google.android.gms.internal.zzq
            r3.<init>()
            r0 = r19
            m7558a(r2, r0, r3)
            goto L_0x0004
        L_0x009f:
            r2 = 0
            byte[] r11 = new byte[r2]     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            goto L_0x0075
        L_0x00a3:
            com.google.android.gms.internal.zzi r3 = new com.google.android.gms.internal.zzi     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
            r7 = 0
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
            long r8 = r8 - r16
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
            goto L_0x004b
        L_0x00b1:
            r2 = move-exception
            java.lang.String r2 = "connection"
            com.google.android.gms.internal.zzq r3 = new com.google.android.gms.internal.zzq
            r3.<init>()
            r0 = r19
            m7558a(r2, r0, r3)
            goto L_0x0004
        L_0x00c0:
            r2 = move-exception
            r3 = r2
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "Bad URL "
            java.lang.String r2 = r19.getUrl()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r6 = r2.length()
            if (r6 == 0) goto L_0x00dc
            java.lang.String r2 = r5.concat(r2)
        L_0x00d8:
            r4.<init>(r2, r3)
            throw r4
        L_0x00dc:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r5)
            goto L_0x00d8
        L_0x00e2:
            r2 = move-exception
            r5 = r14
        L_0x00e4:
            if (r3 == 0) goto L_0x0128
            org.apache.http.StatusLine r2 = r3.getStatusLine()
            int r4 = r2.getStatusCode()
            java.lang.String r2 = "Unexpected response code %d for %s"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            r3[r7] = r8
            r7 = 1
            java.lang.String r8 = r19.getUrl()
            r3[r7] = r8
            com.google.android.gms.internal.zzs.zzc(r2, r3)
            if (r5 == 0) goto L_0x0134
            com.google.android.gms.internal.zzi r3 = new com.google.android.gms.internal.zzi
            r7 = 0
            long r8 = android.os.SystemClock.elapsedRealtime()
            long r8 = r8 - r16
            r3.<init>(r4, r5, r6, r7, r8)
            r2 = 401(0x191, float:5.62E-43)
            if (r4 == r2) goto L_0x011a
            r2 = 403(0x193, float:5.65E-43)
            if (r4 != r2) goto L_0x012e
        L_0x011a:
            java.lang.String r2 = "auth"
            com.google.android.gms.internal.zza r4 = new com.google.android.gms.internal.zza
            r4.<init>(r3)
            r0 = r19
            m7558a(r2, r0, r4)
            goto L_0x0004
        L_0x0128:
            com.google.android.gms.internal.zzj r3 = new com.google.android.gms.internal.zzj
            r3.<init>(r2)
            throw r3
        L_0x012e:
            com.google.android.gms.internal.zzp r2 = new com.google.android.gms.internal.zzp
            r2.<init>(r3)
            throw r2
        L_0x0134:
            com.google.android.gms.internal.zzh r2 = new com.google.android.gms.internal.zzh
            r3 = 0
            r2.<init>((com.google.android.gms.internal.zzi) r3)
            throw r2
        L_0x013b:
            r2 = move-exception
            r5 = r14
            r3 = r15
            goto L_0x00e4
        L_0x013f:
            r2 = move-exception
            r5 = r11
            r3 = r15
            goto L_0x00e4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzt.zza(com.google.android.gms.internal.zzk):com.google.android.gms.internal.zzi");
    }
}
