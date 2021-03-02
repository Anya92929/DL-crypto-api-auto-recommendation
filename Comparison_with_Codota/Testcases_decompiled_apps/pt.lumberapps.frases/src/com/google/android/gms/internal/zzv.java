package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.zzb;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class zzv implements zzb {

    /* renamed from: a */
    private final Map f7023a;

    /* renamed from: b */
    private long f7024b;

    /* renamed from: c */
    private final File f7025c;

    /* renamed from: d */
    private final int f7026d;

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.f7023a = new LinkedHashMap(16, 0.75f, true);
        this.f7024b = 0;
        this.f7025c = file;
        this.f7026d = i;
    }

    /* renamed from: a */
    static int m7580a(InputStream inputStream) {
        return (m7593e(inputStream) << 0) | 0 | (m7593e(inputStream) << 8) | (m7593e(inputStream) << 16) | (m7593e(inputStream) << 24);
    }

    /* renamed from: a */
    private String m7581a(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: a */
    private void m7582a(int i) {
        int i2;
        if (this.f7024b + ((long) i) >= ((long) this.f7026d)) {
            if (zzs.DEBUG) {
                zzs.zza("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f7024b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f7023a.entrySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = i3;
                    break;
                }
                C1869rb rbVar = (C1869rb) ((Map.Entry) it.next()).getValue();
                if (zzf(rbVar.f5534b).delete()) {
                    this.f7024b -= rbVar.f5533a;
                } else {
                    zzs.zzb("Could not delete cache entry for key=%s, filename=%s", rbVar.f5534b, m7581a(rbVar.f5534b));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.f7024b + ((long) i))) < ((float) this.f7026d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            if (zzs.DEBUG) {
                zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f7024b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    /* renamed from: a */
    static void m7583a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    /* renamed from: a */
    static void m7584a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    /* renamed from: a */
    static void m7585a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m7584a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* renamed from: a */
    private void m7586a(String str, C1869rb rbVar) {
        if (!this.f7023a.containsKey(str)) {
            this.f7024b += rbVar.f5533a;
        } else {
            this.f7024b = (rbVar.f5533a - ((C1869rb) this.f7023a.get(str)).f5533a) + this.f7024b;
        }
        this.f7023a.put(str, rbVar);
    }

    /* renamed from: a */
    static void m7587a(Map map, OutputStream outputStream) {
        if (map != null) {
            m7583a(outputStream, map.size());
            for (Map.Entry entry : map.entrySet()) {
                m7585a(outputStream, (String) entry.getKey());
                m7585a(outputStream, (String) entry.getValue());
            }
            return;
        }
        m7583a(outputStream, 0);
    }

    /* renamed from: a */
    private static byte[] m7588a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException(new StringBuilder(50).append("Expected ").append(i).append(" bytes, read ").append(i2).append(" bytes").toString());
    }

    /* renamed from: b */
    static long m7589b(InputStream inputStream) {
        return 0 | ((((long) m7593e(inputStream)) & 255) << 0) | ((((long) m7593e(inputStream)) & 255) << 8) | ((((long) m7593e(inputStream)) & 255) << 16) | ((((long) m7593e(inputStream)) & 255) << 24) | ((((long) m7593e(inputStream)) & 255) << 32) | ((((long) m7593e(inputStream)) & 255) << 40) | ((((long) m7593e(inputStream)) & 255) << 48) | ((((long) m7593e(inputStream)) & 255) << 56);
    }

    /* renamed from: b */
    private void m7590b(String str) {
        C1869rb rbVar = (C1869rb) this.f7023a.get(str);
        if (rbVar != null) {
            this.f7024b -= rbVar.f5533a;
            this.f7023a.remove(str);
        }
    }

    /* renamed from: c */
    static String m7591c(InputStream inputStream) {
        return new String(m7588a(inputStream, (int) m7589b(inputStream)), "UTF-8");
    }

    /* renamed from: d */
    static Map m7592d(InputStream inputStream) {
        int a = m7580a(inputStream);
        Map emptyMap = a == 0 ? Collections.emptyMap() : new HashMap(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(m7591c(inputStream).intern(), m7591c(inputStream).intern());
        }
        return emptyMap;
    }

    /* renamed from: e */
    private static int m7593e(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a A[SYNTHETIC, Splitter:B:28:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005f A[SYNTHETIC, Splitter:B:31:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068 A[SYNTHETIC, Splitter:B:36:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0052 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initialize() {
        /*
            r9 = this;
            r0 = 0
            monitor-enter(r9)
            java.io.File r1 = r9.f7025c     // Catch:{ all -> 0x006c }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x0025
            java.io.File r0 = r9.f7025c     // Catch:{ all -> 0x006c }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x006c }
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = "Unable to create cache dir %s"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x006c }
            r2 = 0
            java.io.File r3 = r9.f7025c     // Catch:{ all -> 0x006c }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x006c }
            r1[r2] = r3     // Catch:{ all -> 0x006c }
            com.google.android.gms.internal.zzs.zzc(r0, r1)     // Catch:{ all -> 0x006c }
        L_0x0023:
            monitor-exit(r9)
            return
        L_0x0025:
            java.io.File r1 = r9.f7025c     // Catch:{ all -> 0x006c }
            java.io.File[] r3 = r1.listFiles()     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x0023
            int r4 = r3.length     // Catch:{ all -> 0x006c }
            r2 = r0
        L_0x002f:
            if (r2 >= r4) goto L_0x0023
            r5 = r3[r2]     // Catch:{ all -> 0x006c }
            r1 = 0
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0056, all -> 0x0065 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0056, all -> 0x0065 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x0056, all -> 0x0065 }
            r0.<init>(r6)     // Catch:{ IOException -> 0x0056, all -> 0x0065 }
            com.google.android.gms.internal.rb r1 = com.google.android.gms.internal.C1869rb.m6605a((java.io.InputStream) r0)     // Catch:{ IOException -> 0x0078 }
            long r6 = r5.length()     // Catch:{ IOException -> 0x0078 }
            r1.f5533a = r6     // Catch:{ IOException -> 0x0078 }
            java.lang.String r6 = r1.f5534b     // Catch:{ IOException -> 0x0078 }
            r9.m7586a((java.lang.String) r6, (com.google.android.gms.internal.C1869rb) r1)     // Catch:{ IOException -> 0x0078 }
            if (r0 == 0) goto L_0x0052
            r0.close()     // Catch:{ IOException -> 0x006f }
        L_0x0052:
            int r0 = r2 + 1
            r2 = r0
            goto L_0x002f
        L_0x0056:
            r0 = move-exception
            r0 = r1
        L_0x0058:
            if (r5 == 0) goto L_0x005d
            r5.delete()     // Catch:{ all -> 0x0073 }
        L_0x005d:
            if (r0 == 0) goto L_0x0052
            r0.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0052
        L_0x0063:
            r0 = move-exception
            goto L_0x0052
        L_0x0065:
            r0 = move-exception
        L_0x0066:
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ IOException -> 0x0071 }
        L_0x006b:
            throw r0     // Catch:{ all -> 0x006c }
        L_0x006c:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        L_0x006f:
            r0 = move-exception
            goto L_0x0052
        L_0x0071:
            r1 = move-exception
            goto L_0x006b
        L_0x0073:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L_0x0066
        L_0x0078:
            r1 = move-exception
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.initialize():void");
    }

    public synchronized void remove(String str) {
        boolean delete = zzf(str).delete();
        m7590b(str);
        if (!delete) {
            zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str, m7581a(str));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066 A[SYNTHETIC, Splitter:B:33:0x0066] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.android.gms.internal.zzb.zza zza(java.lang.String r9) {
        /*
            r8 = this;
            r1 = 0
            monitor-enter(r8)
            java.util.Map r0 = r8.f7023a     // Catch:{ all -> 0x006a }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.rb r0 = (com.google.android.gms.internal.C1869rb) r0     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x000f
            r0 = r1
        L_0x000d:
            monitor-exit(r8)
            return r0
        L_0x000f:
            java.io.File r3 = r8.zzf(r9)     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.rc r2 = new com.google.android.gms.internal.rc     // Catch:{ IOException -> 0x003d, all -> 0x0062 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003d, all -> 0x0062 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x003d, all -> 0x0062 }
            r5 = 0
            r2.<init>(r4)     // Catch:{ IOException -> 0x003d, all -> 0x0062 }
            com.google.android.gms.internal.C1869rb.m6605a((java.io.InputStream) r2)     // Catch:{ IOException -> 0x0072 }
            long r4 = r3.length()     // Catch:{ IOException -> 0x0072 }
            int r6 = r2.f5541a     // Catch:{ IOException -> 0x0072 }
            long r6 = (long) r6     // Catch:{ IOException -> 0x0072 }
            long r4 = r4 - r6
            int r4 = (int) r4     // Catch:{ IOException -> 0x0072 }
            byte[] r4 = m7588a((java.io.InputStream) r2, (int) r4)     // Catch:{ IOException -> 0x0072 }
            com.google.android.gms.internal.zzb$zza r0 = r0.mo7696a((byte[]) r4)     // Catch:{ IOException -> 0x0072 }
            if (r2 == 0) goto L_0x000d
            r2.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x000d
        L_0x003a:
            r0 = move-exception
            r0 = r1
            goto L_0x000d
        L_0x003d:
            r0 = move-exception
            r2 = r1
        L_0x003f:
            java.lang.String r4 = "%s: %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0070 }
            r6 = 0
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0070 }
            r5[r6] = r3     // Catch:{ all -> 0x0070 }
            r3 = 1
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0070 }
            r5[r3] = r0     // Catch:{ all -> 0x0070 }
            com.google.android.gms.internal.zzs.zzb(r4, r5)     // Catch:{ all -> 0x0070 }
            r8.remove(r9)     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x005d
            r2.close()     // Catch:{ IOException -> 0x005f }
        L_0x005d:
            r0 = r1
            goto L_0x000d
        L_0x005f:
            r0 = move-exception
            r0 = r1
            goto L_0x000d
        L_0x0062:
            r0 = move-exception
            r2 = r1
        L_0x0064:
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x006d }
        L_0x0069:
            throw r0     // Catch:{ all -> 0x006a }
        L_0x006a:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        L_0x006d:
            r0 = move-exception
            r0 = r1
            goto L_0x000d
        L_0x0070:
            r0 = move-exception
            goto L_0x0064
        L_0x0072:
            r0 = move-exception
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza(java.lang.String):com.google.android.gms.internal.zzb$zza");
    }

    public synchronized void zza(String str, zzb.zza zza) {
        m7582a(zza.data.length);
        File zzf = zzf(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzf);
            C1869rb rbVar = new C1869rb(str, zza);
            if (!rbVar.mo7697a((OutputStream) fileOutputStream)) {
                fileOutputStream.close();
                zzs.zzb("Failed to write header for %s", zzf.getAbsolutePath());
                throw new IOException();
            }
            fileOutputStream.write(zza.data);
            fileOutputStream.close();
            m7586a(str, rbVar);
        } catch (IOException e) {
            if (!zzf.delete()) {
                zzs.zzb("Could not clean up file %s", zzf.getAbsolutePath());
            }
        }
    }

    public File zzf(String str) {
        return new File(this.f7025c, m7581a(str));
    }
}
