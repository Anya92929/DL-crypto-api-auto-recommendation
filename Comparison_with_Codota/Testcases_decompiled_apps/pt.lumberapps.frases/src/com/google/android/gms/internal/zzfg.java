package com.google.android.gms.internal;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzin
public class zzfg extends zzfd {

    /* renamed from: d */
    private static final Set f6175d = Collections.synchronizedSet(new HashSet());

    /* renamed from: e */
    private static final DecimalFormat f6176e = new DecimalFormat("#,###");

    /* renamed from: f */
    private File f6177f;

    /* renamed from: g */
    private boolean f6178g;

    public zzfg(zzlh zzlh) {
        super(zzlh);
        File cacheDir = this.f6172a.getCacheDir();
        if (cacheDir == null) {
            zzkd.zzcx("Context.getCacheDir() returned null");
            return;
        }
        this.f6177f = new File(cacheDir, "admobVideoStreams");
        if (!this.f6177f.isDirectory() && !this.f6177f.mkdirs()) {
            String valueOf = String.valueOf(this.f6177f.getAbsolutePath());
            zzkd.zzcx(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.f6177f = null;
        } else if (!this.f6177f.setReadable(true, false) || !this.f6177f.setExecutable(true, false)) {
            String valueOf2 = String.valueOf(this.f6177f.getAbsolutePath());
            zzkd.zzcx(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.f6177f = null;
        }
    }

    /* renamed from: a */
    private File m7029a(File file) {
        return new File(this.f6177f, String.valueOf(file.getName()).concat(".done"));
    }

    /* renamed from: b */
    private static void m7030b(File file) {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
    }

    public void abort() {
        this.f6178g = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x030c, code lost:
        r5 = r5 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x030d, code lost:
        if (r5 <= r14) goto L_0x033c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        r3 = java.lang.String.valueOf(java.lang.Integer.toString(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x031f, code lost:
        if (r3.length() == 0) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0321, code lost:
        r3 = "File too big for full file cache. Size: ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x032c, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x032d, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x032e, code lost:
        r5 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        r3 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0337, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0338, code lost:
        r3 = null;
        r5 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        r17.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0343, code lost:
        if (r16.write(r17) > 0) goto L_0x033f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0345, code lost:
        r17.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0354, code lost:
        if ((r18.currentTimeMillis() - r20) <= (1000 * r22)) goto L_0x038f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
        r2 = java.lang.String.valueOf(java.lang.Long.toString(r22));
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r2).length() + 29).append("Timeout exceeded. Limit: ").append(r2).append(" sec").toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x038a, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x038b, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x038c, code lost:
        r5 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0393, code lost:
        if (r26.f6178g == false) goto L_0x03a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x039e, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x039f, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x03a0, code lost:
        r3 = null;
        r5 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x03a8, code lost:
        if (r0.tryAcquire() == false) goto L_0x0304;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x03aa, code lost:
        mo8359a(r27, r12.getAbsolutePath(), r5, r6, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x03b8, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x03b9, code lost:
        r3 = null;
        r4 = "error";
        r5 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x03be, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x03c6, code lost:
        if (com.google.android.gms.internal.zzkd.zzaz(3) == false) goto L_0x0404;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x03c8, code lost:
        r2 = f6176e.format((long) r5);
        com.google.android.gms.internal.zzkd.zzcv(new java.lang.StringBuilder((java.lang.String.valueOf(r2).length() + 22) + java.lang.String.valueOf(r27).length()).append("Preloaded ").append(r2).append(" bytes from ").append(r27).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0404, code lost:
        r12.setReadable(true, false);
        m7030b(r13);
        mo8358a(r27, r12.getAbsolutePath(), r5);
        f6175d.remove(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x041c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x041f, code lost:
        com.google.android.gms.internal.zzkd.zzd(new java.lang.StringBuilder(java.lang.String.valueOf(r27).length() + 25).append("Preload failed for URL \"").append(r27).append("\"").toString(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0449, code lost:
        r2 = new java.lang.String("Could not delete partial cache file at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0456, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0457, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x045d, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x045e, code lost:
        r3 = null;
        r4 = "error";
        r5 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e8, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r3 = new java.net.URL(r27).openConnection();
        r2 = ((java.lang.Integer) com.google.android.gms.internal.zzdc.zzayr.get()).intValue();
        r3.setConnectTimeout(r2);
        r3.setReadTimeout(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x010b, code lost:
        if ((r3 instanceof java.net.HttpURLConnection) == false) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x010d, code lost:
        r2 = ((java.net.HttpURLConnection) r3).getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0117, code lost:
        if (r2 < 400) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0119, code lost:
        r4 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r3 = java.lang.String.valueOf(java.lang.Integer.toString(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0129, code lost:
        if (r3.length() == 0) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012b, code lost:
        r3 = "HTTP request failed. Code: ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x015d, code lost:
        throw new java.io.IOException(new java.lang.StringBuilder(java.lang.String.valueOf(r27).length() + 32).append("HTTP status code ").append(r2).append(" at ").append(r27).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x015e, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0161, code lost:
        if ((r2 instanceof java.lang.RuntimeException) != false) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0163, code lost:
        com.google.android.gms.ads.internal.zzu.zzft().zzb(r2, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0172, code lost:
        if (r26.f6178g != false) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0174, code lost:
        com.google.android.gms.internal.zzkd.zzcw(new java.lang.StringBuilder(java.lang.String.valueOf(r27).length() + 26).append("Preload aborted for URL \"").append(r27).append("\"").toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01a8, code lost:
        r2 = java.lang.String.valueOf(r12.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01b6, code lost:
        if (r2.length() != 0) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01b8, code lost:
        r2 = "Could not delete partial cache file at ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01bc, code lost:
        com.google.android.gms.internal.zzkd.zzcx(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01bf, code lost:
        mo8360a(r27, r12.getAbsolutePath(), r4, r3);
        f6175d.remove(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r3 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01d9, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01da, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r6 = r3.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01e0, code lost:
        if (r6 >= 0) goto L_0x0216;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01e2, code lost:
        r2 = java.lang.String.valueOf(r27);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ec, code lost:
        if (r2.length() == 0) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ee, code lost:
        r2 = "Stream cache aborted, missing content-length header at ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01f2, code lost:
        com.google.android.gms.internal.zzkd.zzcx(r2);
        mo8360a(r27, r12.getAbsolutePath(), "contentLengthMissing", (java.lang.String) null);
        f6175d.remove(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x020b, code lost:
        r2 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0211, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0212, code lost:
        r3 = null;
        r4 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0216, code lost:
        r4 = f6176e.format((long) r6);
        r14 = ((java.lang.Integer) com.google.android.gms.internal.zzdc.zzayn.get()).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0229, code lost:
        if (r6 <= r14) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x022b, code lost:
        com.google.android.gms.internal.zzkd.zzcx(new java.lang.StringBuilder((java.lang.String.valueOf(r4).length() + 33) + java.lang.String.valueOf(r27).length()).append("Content length ").append(r4).append(" exceeds limit at ").append(r27).toString());
        r2 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x026a, code lost:
        if (r2.length() == 0) goto L_0x0285;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x026c, code lost:
        r2 = "File too big for full file cache. Size: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0270, code lost:
        mo8360a(r27, r12.getAbsolutePath(), "sizeExceeded", r2);
        f6175d.remove(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0285, code lost:
        r2 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x028b, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x028c, code lost:
        r3 = null;
        r4 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0290, code lost:
        com.google.android.gms.internal.zzkd.zzcv(new java.lang.StringBuilder((java.lang.String.valueOf(r4).length() + 20) + java.lang.String.valueOf(r27).length()).append("Caching ").append(r4).append(" bytes from ").append(r27).toString());
        r15 = java.nio.channels.Channels.newChannel(r3.getInputStream());
        r11 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r16 = r11.getChannel();
        r17 = java.nio.ByteBuffer.allocate(1048576);
        r18 = com.google.android.gms.ads.internal.zzu.zzfu();
        r5 = 0;
        r20 = r18.currentTimeMillis();
        r0 = new com.google.android.gms.internal.zzkr(((java.lang.Long) com.google.android.gms.internal.zzdc.zzayq.get()).longValue());
        r22 = ((java.lang.Long) com.google.android.gms.internal.zzdc.zzayp.get()).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0304, code lost:
        r2 = r15.read(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x030a, code lost:
        if (r2 < 0) goto L_0x03be;
     */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x041f  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0449  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zzaz(java.lang.String r27) {
        /*
            r26 = this;
            r0 = r26
            java.io.File r2 = r0.f6177f
            if (r2 != 0) goto L_0x0013
            r2 = 0
            java.lang.String r3 = "noCacheDir"
            r4 = 0
            r0 = r26
            r1 = r27
            r0.mo8360a(r1, r2, r3, r4)
            r2 = 0
        L_0x0012:
            return r2
        L_0x0013:
            int r3 = r26.zzll()
            com.google.android.gms.internal.zzcy r2 = com.google.android.gms.internal.zzdc.zzaym
            java.lang.Object r2 = r2.get()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r3 <= r2) goto L_0x003d
            boolean r2 = r26.zzlm()
            if (r2 != 0) goto L_0x0013
            java.lang.String r2 = "Unable to expire stream cache"
            com.google.android.gms.internal.zzkd.zzcx(r2)
            r2 = 0
            java.lang.String r3 = "expireFailed"
            r4 = 0
            r0 = r26
            r1 = r27
            r0.mo8360a(r1, r2, r3, r4)
            r2 = 0
            goto L_0x0012
        L_0x003d:
            java.lang.String r2 = r26.mo8357a(r27)
            java.io.File r12 = new java.io.File
            r0 = r26
            java.io.File r3 = r0.f6177f
            r12.<init>(r3, r2)
            r0 = r26
            java.io.File r13 = r0.m7029a(r12)
            boolean r2 = r12.isFile()
            if (r2 == 0) goto L_0x0087
            boolean r2 = r13.isFile()
            if (r2 == 0) goto L_0x0087
            long r2 = r12.length()
            int r3 = (int) r2
            java.lang.String r4 = "Stream cache hit at "
            java.lang.String r2 = java.lang.String.valueOf(r27)
            int r5 = r2.length()
            if (r5 == 0) goto L_0x0081
            java.lang.String r2 = r4.concat(r2)
        L_0x0071:
            com.google.android.gms.internal.zzkd.zzcv(r2)
            java.lang.String r2 = r12.getAbsolutePath()
            r0 = r26
            r1 = r27
            r0.mo8358a((java.lang.String) r1, (java.lang.String) r2, (int) r3)
            r2 = 1
            goto L_0x0012
        L_0x0081:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r4)
            goto L_0x0071
        L_0x0087:
            r0 = r26
            java.io.File r2 = r0.f6177f
            java.lang.String r2 = r2.getAbsolutePath()
            java.lang.String r3 = java.lang.String.valueOf(r2)
            java.lang.String r2 = java.lang.String.valueOf(r27)
            int r4 = r2.length()
            if (r4 == 0) goto L_0x00d5
            java.lang.String r2 = r3.concat(r2)
            r8 = r2
        L_0x00a2:
            java.util.Set r3 = f6175d
            monitor-enter(r3)
            java.util.Set r2 = f6175d     // Catch:{ all -> 0x00d2 }
            boolean r2 = r2.contains(r8)     // Catch:{ all -> 0x00d2 }
            if (r2 == 0) goto L_0x00e2
            java.lang.String r4 = "Stream cache already in progress at "
            java.lang.String r2 = java.lang.String.valueOf(r27)     // Catch:{ all -> 0x00d2 }
            int r5 = r2.length()     // Catch:{ all -> 0x00d2 }
            if (r5 == 0) goto L_0x00dc
            java.lang.String r2 = r4.concat(r2)     // Catch:{ all -> 0x00d2 }
        L_0x00bd:
            com.google.android.gms.internal.zzkd.zzcx(r2)     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = r12.getAbsolutePath()     // Catch:{ all -> 0x00d2 }
            java.lang.String r4 = "inProgress"
            r5 = 0
            r0 = r26
            r1 = r27
            r0.mo8360a(r1, r2, r4, r5)     // Catch:{ all -> 0x00d2 }
            r2 = 0
            monitor-exit(r3)     // Catch:{ all -> 0x00d2 }
            goto L_0x0012
        L_0x00d2:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00d2 }
            throw r2
        L_0x00d5:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r3)
            r8 = r2
            goto L_0x00a2
        L_0x00dc:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x00d2 }
            r2.<init>(r4)     // Catch:{ all -> 0x00d2 }
            goto L_0x00bd
        L_0x00e2:
            java.util.Set r2 = f6175d     // Catch:{ all -> 0x00d2 }
            r2.add(r8)     // Catch:{ all -> 0x00d2 }
            monitor-exit(r3)     // Catch:{ all -> 0x00d2 }
            r5 = 0
            java.lang.String r10 = "error"
            r9 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r0 = r27
            r2.<init>(r0)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.net.URLConnection r3 = r2.openConnection()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            com.google.android.gms.internal.zzcy r2 = com.google.android.gms.internal.zzdc.zzayr     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r3.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r3.setReadTimeout(r2)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            boolean r2 = r3 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            if (r2 == 0) goto L_0x01dc
            r0 = r3
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r2 = r0
            int r2 = r2.getResponseCode()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r4 = 400(0x190, float:5.6E-43)
            if (r2 < r4) goto L_0x01dc
            java.lang.String r4 = "badUrl"
            java.lang.String r6 = "HTTP request failed. Code: "
            java.lang.String r3 = java.lang.Integer.toString(r2)     // Catch:{ IOException -> 0x01d9, RuntimeException -> 0x0456 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x01d9, RuntimeException -> 0x0456 }
            int r7 = r3.length()     // Catch:{ IOException -> 0x01d9, RuntimeException -> 0x0456 }
            if (r7 == 0) goto L_0x01d2
            java.lang.String r3 = r6.concat(r3)     // Catch:{ IOException -> 0x01d9, RuntimeException -> 0x0456 }
        L_0x012f:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ IOException -> 0x015e, RuntimeException -> 0x045a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x015e, RuntimeException -> 0x045a }
            java.lang.String r9 = java.lang.String.valueOf(r27)     // Catch:{ IOException -> 0x015e, RuntimeException -> 0x045a }
            int r9 = r9.length()     // Catch:{ IOException -> 0x015e, RuntimeException -> 0x045a }
            int r9 = r9 + 32
            r7.<init>(r9)     // Catch:{ IOException -> 0x015e, RuntimeException -> 0x045a }
            java.lang.String r9 = "HTTP status code "
            java.lang.StringBuilder r7 = r7.append(r9)     // Catch:{ IOException -> 0x015e, RuntimeException -> 0x045a }
            java.lang.StringBuilder r2 = r7.append(r2)     // Catch:{ IOException -> 0x015e, RuntimeException -> 0x045a }
            java.lang.String r7 = " at "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ IOException -> 0x015e, RuntimeException -> 0x045a }
            r0 = r27
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x015e, RuntimeException -> 0x045a }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x015e, RuntimeException -> 0x045a }
            r6.<init>(r2)     // Catch:{ IOException -> 0x015e, RuntimeException -> 0x045a }
            throw r6     // Catch:{ IOException -> 0x015e, RuntimeException -> 0x045a }
        L_0x015e:
            r2 = move-exception
        L_0x015f:
            boolean r6 = r2 instanceof java.lang.RuntimeException
            if (r6 == 0) goto L_0x016b
            com.google.android.gms.internal.zzjx r6 = com.google.android.gms.ads.internal.zzu.zzft()
            r7 = 1
            r6.zzb((java.lang.Throwable) r2, (boolean) r7)
        L_0x016b:
            r5.close()     // Catch:{ IOException -> 0x0450, NullPointerException -> 0x0453 }
        L_0x016e:
            r0 = r26
            boolean r5 = r0.f6178g
            if (r5 == 0) goto L_0x041f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = java.lang.String.valueOf(r27)
            int r5 = r5.length()
            int r5 = r5 + 26
            r2.<init>(r5)
            java.lang.String r5 = "Preload aborted for URL \""
            java.lang.StringBuilder r2 = r2.append(r5)
            r0 = r27
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r5 = "\""
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.internal.zzkd.zzcw(r2)
        L_0x019c:
            boolean r2 = r12.exists()
            if (r2 == 0) goto L_0x01bf
            boolean r2 = r12.delete()
            if (r2 != 0) goto L_0x01bf
            java.lang.String r5 = "Could not delete partial cache file at "
            java.lang.String r2 = r12.getAbsolutePath()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r6 = r2.length()
            if (r6 == 0) goto L_0x0449
            java.lang.String r2 = r5.concat(r2)
        L_0x01bc:
            com.google.android.gms.internal.zzkd.zzcx(r2)
        L_0x01bf:
            java.lang.String r2 = r12.getAbsolutePath()
            r0 = r26
            r1 = r27
            r0.mo8360a(r1, r2, r4, r3)
            java.util.Set r2 = f6175d
            r2.remove(r8)
            r2 = 0
            goto L_0x0012
        L_0x01d2:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x01d9, RuntimeException -> 0x0456 }
            r3.<init>(r6)     // Catch:{ IOException -> 0x01d9, RuntimeException -> 0x0456 }
            goto L_0x012f
        L_0x01d9:
            r2 = move-exception
            r3 = r9
            goto L_0x015f
        L_0x01dc:
            int r6 = r3.getContentLength()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            if (r6 >= 0) goto L_0x0216
            java.lang.String r3 = "Stream cache aborted, missing content-length header at "
            java.lang.String r2 = java.lang.String.valueOf(r27)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            int r4 = r2.length()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            if (r4 == 0) goto L_0x020b
            java.lang.String r2 = r3.concat(r2)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
        L_0x01f2:
            com.google.android.gms.internal.zzkd.zzcx(r2)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r2 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r3 = "contentLengthMissing"
            r4 = 0
            r0 = r26
            r1 = r27
            r0.mo8360a(r1, r2, r3, r4)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.util.Set r2 = f6175d     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r2.remove(r8)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r2 = 0
            goto L_0x0012
        L_0x020b:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            goto L_0x01f2
        L_0x0211:
            r2 = move-exception
            r3 = r9
            r4 = r10
            goto L_0x015f
        L_0x0216:
            java.text.DecimalFormat r2 = f6176e     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            long r14 = (long) r6     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r4 = r2.format(r14)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            com.google.android.gms.internal.zzcy r2 = com.google.android.gms.internal.zzdc.zzayn     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            int r14 = r2.intValue()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            if (r6 <= r14) goto L_0x0290
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            int r3 = r3.length()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            int r3 = r3 + 33
            java.lang.String r6 = java.lang.String.valueOf(r27)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            int r6 = r6.length()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            int r3 = r3 + r6
            r2.<init>(r3)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r3 = "Content length "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r3 = " exceeds limit at "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r0 = r27
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            com.google.android.gms.internal.zzkd.zzcx(r2)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r3 = "File too big for full file cache. Size: "
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            int r4 = r2.length()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            if (r4 == 0) goto L_0x0285
            java.lang.String r2 = r3.concat(r2)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
        L_0x0270:
            java.lang.String r3 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r4 = "sizeExceeded"
            r0 = r26
            r1 = r27
            r0.mo8360a(r1, r3, r4, r2)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.util.Set r2 = f6175d     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r2.remove(r8)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r2 = 0
            goto L_0x0012
        L_0x0285:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            goto L_0x0270
        L_0x028b:
            r2 = move-exception
            r3 = r9
            r4 = r10
            goto L_0x015f
        L_0x0290:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            int r7 = r7.length()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            int r7 = r7 + 20
            java.lang.String r11 = java.lang.String.valueOf(r27)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            int r11 = r11.length()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            int r7 = r7 + r11
            r2.<init>(r7)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r7 = "Caching "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r4 = " bytes from "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r0 = r27
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            com.google.android.gms.internal.zzkd.zzcv(r2)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.io.InputStream r2 = r3.getInputStream()     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.nio.channels.ReadableByteChannel r15 = java.nio.channels.Channels.newChannel(r2)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            r11.<init>(r12)     // Catch:{ IOException -> 0x0211, RuntimeException -> 0x028b }
            java.nio.channels.FileChannel r16 = r11.getChannel()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            r2 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r17 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            com.google.android.gms.common.util.zze r18 = com.google.android.gms.ads.internal.zzu.zzfu()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            r5 = 0
            long r20 = r18.currentTimeMillis()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            com.google.android.gms.internal.zzcy r2 = com.google.android.gms.internal.zzdc.zzayq     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            long r2 = r2.longValue()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            com.google.android.gms.internal.zzkr r19 = new com.google.android.gms.internal.zzkr     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            r0 = r19
            r0.<init>(r2)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            com.google.android.gms.internal.zzcy r2 = com.google.android.gms.internal.zzdc.zzayp     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            long r22 = r2.longValue()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
        L_0x0304:
            r0 = r17
            int r2 = r15.read(r0)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            if (r2 < 0) goto L_0x03be
            int r5 = r5 + r2
            if (r5 <= r14) goto L_0x033c
            java.lang.String r4 = "sizeExceeded"
            java.lang.String r2 = "File too big for full file cache. Size: "
            java.lang.String r3 = java.lang.Integer.toString(r5)     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            int r5 = r3.length()     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            if (r5 == 0) goto L_0x0331
            java.lang.String r3 = r2.concat(r3)     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
        L_0x0325:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x032d, RuntimeException -> 0x038b }
            java.lang.String r5 = "stream cache file size limit exceeded"
            r2.<init>(r5)     // Catch:{ IOException -> 0x032d, RuntimeException -> 0x038b }
            throw r2     // Catch:{ IOException -> 0x032d, RuntimeException -> 0x038b }
        L_0x032d:
            r2 = move-exception
            r5 = r11
            goto L_0x015f
        L_0x0331:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            goto L_0x0325
        L_0x0337:
            r2 = move-exception
            r3 = r9
            r5 = r11
            goto L_0x015f
        L_0x033c:
            r17.flip()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
        L_0x033f:
            int r2 = r16.write(r17)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            if (r2 > 0) goto L_0x033f
            r17.clear()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            long r2 = r18.currentTimeMillis()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            long r2 = r2 - r20
            r24 = 1000(0x3e8, double:4.94E-321)
            long r24 = r24 * r22
            int r2 = (r2 > r24 ? 1 : (r2 == r24 ? 0 : -1))
            if (r2 <= 0) goto L_0x038f
            java.lang.String r4 = "downloadTimeout"
            java.lang.String r2 = java.lang.Long.toString(r22)     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            int r5 = r5.length()     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            int r5 = r5 + 29
            r3.<init>(r5)     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            java.lang.String r5 = "Timeout exceeded. Limit: "
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            java.lang.String r3 = " sec"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            java.lang.String r3 = r2.toString()     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x032d, RuntimeException -> 0x038b }
            java.lang.String r5 = "stream cache time limit exceeded"
            r2.<init>(r5)     // Catch:{ IOException -> 0x032d, RuntimeException -> 0x038b }
            throw r2     // Catch:{ IOException -> 0x032d, RuntimeException -> 0x038b }
        L_0x038b:
            r2 = move-exception
            r5 = r11
            goto L_0x015f
        L_0x038f:
            r0 = r26
            boolean r2 = r0.f6178g     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            if (r2 == 0) goto L_0x03a4
            java.lang.String r4 = "externalAbort"
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            java.lang.String r3 = "abort requested"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
            throw r2     // Catch:{ IOException -> 0x0337, RuntimeException -> 0x039f }
        L_0x039f:
            r2 = move-exception
            r3 = r9
            r5 = r11
            goto L_0x015f
        L_0x03a4:
            boolean r2 = r19.tryAcquire()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            if (r2 == 0) goto L_0x0304
            java.lang.String r4 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            r7 = 0
            r2 = r26
            r3 = r27
            r2.mo8359a(r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            goto L_0x0304
        L_0x03b8:
            r2 = move-exception
            r3 = r9
            r4 = r10
            r5 = r11
            goto L_0x015f
        L_0x03be:
            r11.close()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            r2 = 3
            boolean r2 = com.google.android.gms.internal.zzkd.zzaz(r2)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            if (r2 == 0) goto L_0x0404
            java.text.DecimalFormat r2 = f6176e     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            long r6 = (long) r5     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.lang.String r2 = r2.format(r6)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.lang.String r4 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            int r4 = r4.length()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            int r4 = r4 + 22
            java.lang.String r6 = java.lang.String.valueOf(r27)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            int r6 = r6.length()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            int r4 = r4 + r6
            r3.<init>(r4)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.lang.String r4 = "Preloaded "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.lang.String r3 = " bytes from "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            r0 = r27
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            com.google.android.gms.internal.zzkd.zzcv(r2)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
        L_0x0404:
            r2 = 1
            r3 = 0
            r12.setReadable(r2, r3)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            m7030b(r13)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.lang.String r2 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            r0 = r26
            r1 = r27
            r0.mo8358a((java.lang.String) r1, (java.lang.String) r2, (int) r5)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            java.util.Set r2 = f6175d     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            r2.remove(r8)     // Catch:{ IOException -> 0x03b8, RuntimeException -> 0x045d }
            r2 = 1
            goto L_0x0012
        L_0x041f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r27)
            int r6 = r6.length()
            int r6 = r6 + 25
            r5.<init>(r6)
            java.lang.String r6 = "Preload failed for URL \""
            java.lang.StringBuilder r5 = r5.append(r6)
            r0 = r27
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.String r6 = "\""
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.google.android.gms.internal.zzkd.zzd(r5, r2)
            goto L_0x019c
        L_0x0449:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r5)
            goto L_0x01bc
        L_0x0450:
            r5 = move-exception
            goto L_0x016e
        L_0x0453:
            r5 = move-exception
            goto L_0x016e
        L_0x0456:
            r2 = move-exception
            r3 = r9
            goto L_0x015f
        L_0x045a:
            r2 = move-exception
            goto L_0x015f
        L_0x045d:
            r2 = move-exception
            r3 = r9
            r4 = r10
            r5 = r11
            goto L_0x015f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfg.zzaz(java.lang.String):boolean");
    }

    public int zzll() {
        int i = 0;
        if (this.f6177f != null) {
            for (File name : this.f6177f.listFiles()) {
                if (!name.getName().endsWith(".done")) {
                    i++;
                }
            }
        }
        return i;
    }

    public boolean zzlm() {
        boolean z;
        long j;
        File file;
        if (this.f6177f == null) {
            return false;
        }
        File file2 = null;
        long j2 = Long.MAX_VALUE;
        File[] listFiles = this.f6177f.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file3 = listFiles[i];
            if (!file3.getName().endsWith(".done")) {
                j = file3.lastModified();
                if (j < j2) {
                    file = file3;
                    i++;
                    file2 = file;
                    j2 = j;
                }
            }
            j = j2;
            file = file2;
            i++;
            file2 = file;
            j2 = j;
        }
        if (file2 != null) {
            z = file2.delete();
            File a = m7029a(file2);
            if (a.isFile()) {
                z &= a.delete();
            }
        } else {
            z = false;
        }
        return z;
    }
}
