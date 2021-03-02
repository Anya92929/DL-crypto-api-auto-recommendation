package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import java.net.URL;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.ar */
class C1900ar implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzq f7106a;

    /* renamed from: b */
    private final URL f7107b;

    /* renamed from: c */
    private final byte[] f7108c;

    /* renamed from: d */
    private final C1898ap f7109d;

    /* renamed from: e */
    private final String f7110e;

    /* renamed from: f */
    private final Map f7111f;

    public C1900ar(zzq zzq, String str, URL url, byte[] bArr, Map map, C1898ap apVar) {
        this.f7106a = zzq;
        zzab.zzhr(str);
        zzab.zzy(url);
        zzab.zzy(apVar);
        this.f7107b = url;
        this.f7108c = bArr;
        this.f7109d = apVar;
        this.f7110e = str;
        this.f7111f = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ee A[SYNTHETIC, Splitter:B:36:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r13 = this;
            r4 = 0
            com.google.android.gms.measurement.internal.zzq r0 = r13.f7106a
            r0.zzbrs()
            r3 = 0
            com.google.android.gms.measurement.internal.zzq r0 = r13.f7106a     // Catch:{ IOException -> 0x012e, all -> 0x00e7 }
            java.lang.String r1 = r13.f7110e     // Catch:{ IOException -> 0x012e, all -> 0x00e7 }
            r0.mo9608a((java.lang.String) r1)     // Catch:{ IOException -> 0x012e, all -> 0x00e7 }
            com.google.android.gms.measurement.internal.zzq r0 = r13.f7106a     // Catch:{ IOException -> 0x012e, all -> 0x00e7 }
            java.net.URL r1 = r13.f7107b     // Catch:{ IOException -> 0x012e, all -> 0x00e7 }
            java.net.HttpURLConnection r2 = r0.mo9607a((java.net.URL) r1)     // Catch:{ IOException -> 0x012e, all -> 0x00e7 }
            java.util.Map r0 = r13.f7111f     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            if (r0 == 0) goto L_0x0069
            java.util.Map r0 = r13.f7111f     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            java.util.Iterator r5 = r0.iterator()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
        L_0x0024:
            boolean r0 = r5.hasNext()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            if (r0 == 0) goto L_0x0069
            java.lang.Object r0 = r5.next()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            java.lang.Object r1 = r0.getKey()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            r2.addRequestProperty(r1, r0)     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            goto L_0x0024
        L_0x0040:
            r9 = move-exception
            r11 = r4
            r8 = r3
            r0 = r4
            r1 = r2
        L_0x0045:
            if (r0 == 0) goto L_0x004a
            r0.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x004a:
            if (r1 == 0) goto L_0x004f
            r1.disconnect()
        L_0x004f:
            com.google.android.gms.measurement.internal.zzq r0 = r13.f7106a
            r0.mo9609e()
            com.google.android.gms.measurement.internal.zzq r0 = r13.f7106a
            com.google.android.gms.measurement.internal.zzw r0 = r0.zzbsc()
            com.google.android.gms.measurement.internal.aq r5 = new com.google.android.gms.measurement.internal.aq
            java.lang.String r6 = r13.f7110e
            com.google.android.gms.measurement.internal.ap r7 = r13.f7109d
            r10 = r4
            r12 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.zzm(r5)
        L_0x0068:
            return
        L_0x0069:
            byte[] r0 = r13.f7108c     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            if (r0 == 0) goto L_0x00a9
            com.google.android.gms.measurement.internal.zzq r0 = r13.f7106a     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            com.google.android.gms.measurement.internal.zzal r0 = r0.zzbrz()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            byte[] r1 = r13.f7108c     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            byte[] r1 = r0.zzj(r1)     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            com.google.android.gms.measurement.internal.zzq r0 = r13.f7106a     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            com.google.android.gms.measurement.internal.zzp r0 = r0.zzbsd()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbtc()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            java.lang.String r5 = "Uploading data. size"
            int r6 = r1.length     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            r0.zzj(r5, r6)     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            r0 = 1
            r2.setDoOutput(r0)     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            java.lang.String r0 = "Content-Encoding"
            java.lang.String r5 = "gzip"
            r2.addRequestProperty(r0, r5)     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            int r0 = r1.length     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            r2.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            r2.connect()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            java.io.OutputStream r0 = r2.getOutputStream()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            r0.write(r1)     // Catch:{ IOException -> 0x0135, all -> 0x0126 }
            r0.close()     // Catch:{ IOException -> 0x0135, all -> 0x0126 }
        L_0x00a9:
            int r3 = r2.getResponseCode()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            java.util.Map r6 = r2.getHeaderFields()     // Catch:{ IOException -> 0x0040, all -> 0x0121 }
            com.google.android.gms.measurement.internal.zzq r0 = r13.f7106a     // Catch:{ IOException -> 0x013b, all -> 0x012a }
            byte[] r5 = r0.m7915a((java.net.HttpURLConnection) r2)     // Catch:{ IOException -> 0x013b, all -> 0x012a }
            if (r2 == 0) goto L_0x00bc
            r2.disconnect()
        L_0x00bc:
            com.google.android.gms.measurement.internal.zzq r0 = r13.f7106a
            r0.mo9609e()
            com.google.android.gms.measurement.internal.zzq r0 = r13.f7106a
            com.google.android.gms.measurement.internal.zzw r8 = r0.zzbsc()
            com.google.android.gms.measurement.internal.aq r0 = new com.google.android.gms.measurement.internal.aq
            java.lang.String r1 = r13.f7110e
            com.google.android.gms.measurement.internal.ap r2 = r13.f7109d
            r7 = r4
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r8.zzm(r0)
            goto L_0x0068
        L_0x00d5:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzq r2 = r13.f7106a
            com.google.android.gms.measurement.internal.zzp r2 = r2.zzbsd()
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()
            java.lang.String r3 = "Error closing HTTP compressed POST connection output stream"
            r2.zzj(r3, r0)
            goto L_0x004a
        L_0x00e7:
            r0 = move-exception
            r8 = r0
            r6 = r4
            r2 = r4
            r0 = r4
        L_0x00ec:
            if (r0 == 0) goto L_0x00f1
            r0.close()     // Catch:{ IOException -> 0x0110 }
        L_0x00f1:
            if (r2 == 0) goto L_0x00f6
            r2.disconnect()
        L_0x00f6:
            com.google.android.gms.measurement.internal.zzq r0 = r13.f7106a
            r0.mo9609e()
            com.google.android.gms.measurement.internal.zzq r0 = r13.f7106a
            com.google.android.gms.measurement.internal.zzw r9 = r0.zzbsc()
            com.google.android.gms.measurement.internal.aq r0 = new com.google.android.gms.measurement.internal.aq
            java.lang.String r1 = r13.f7110e
            com.google.android.gms.measurement.internal.ap r2 = r13.f7109d
            r5 = r4
            r7 = r4
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r9.zzm(r0)
            throw r8
        L_0x0110:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzq r1 = r13.f7106a
            com.google.android.gms.measurement.internal.zzp r1 = r1.zzbsd()
            com.google.android.gms.measurement.internal.zzp$zza r1 = r1.zzbsv()
            java.lang.String r5 = "Error closing HTTP compressed POST connection output stream"
            r1.zzj(r5, r0)
            goto L_0x00f1
        L_0x0121:
            r0 = move-exception
            r8 = r0
            r6 = r4
            r0 = r4
            goto L_0x00ec
        L_0x0126:
            r1 = move-exception
            r8 = r1
            r6 = r4
            goto L_0x00ec
        L_0x012a:
            r0 = move-exception
            r8 = r0
            r0 = r4
            goto L_0x00ec
        L_0x012e:
            r9 = move-exception
            r11 = r4
            r8 = r3
            r0 = r4
            r1 = r4
            goto L_0x0045
        L_0x0135:
            r9 = move-exception
            r11 = r4
            r8 = r3
            r1 = r2
            goto L_0x0045
        L_0x013b:
            r9 = move-exception
            r11 = r6
            r8 = r3
            r0 = r4
            r1 = r2
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1900ar.run():void");
    }
}
