package com.appbrain.p032a;

import android.content.Context;
import cmn.C0719an;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.appbrain.a.bo */
public class C0826bo {

    /* renamed from: a */
    private static final String f2175a = C0826bo.class.getSimpleName();

    /* renamed from: b */
    private final Context f2176b;

    /* renamed from: c */
    private final String f2177c;

    /* renamed from: d */
    private final String f2178d;

    /* renamed from: e */
    private final String f2179e;

    /* renamed from: f */
    private final AtomicBoolean f2180f = new AtomicBoolean(false);

    public C0826bo(Context context, String str, String str2, String str3) {
        this.f2176b = context.getApplicationContext();
        this.f2177c = str;
        this.f2178d = str2;
        this.f2179e = str3;
    }

    /* renamed from: a */
    private String m3667a(C0932fm fmVar) {
        return fmVar.mo3841a(this.f2178d, (String) null);
    }

    /* renamed from: a */
    private synchronized void m3668a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (bArr != null) {
            if (bArr.length <= 10485760) {
                File parentFile = file.getParentFile();
                if (parentFile.isDirectory() || parentFile.mkdirs()) {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(bArr);
                        } catch (IOException e) {
                        }
                    } catch (IOException e2) {
                        fileOutputStream = null;
                    }
                    C0719an.m3210a((Closeable) fileOutputStream);
                } else {
                    new IllegalStateException("Couldn't create directory");
                }
            }
        }
        if (file.exists() && !file.delete()) {
            new IllegalStateException("Couldn't delete file");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c6 A[LOOP:0: B:1:0x0002->B:35:0x00c6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a5 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo3687a() {
        /*
            r8 = this;
            r1 = 0
            r7 = 0
        L_0x0002:
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f2180f
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r2)
            if (r0 != 0) goto L_0x000c
        L_0x000b:
            return
        L_0x000c:
            com.appbrain.a.fm r2 = com.appbrain.p032a.C0932fm.m3968a()
            java.lang.String r3 = r8.m3667a(r2)
            android.content.SharedPreferences r0 = r2.mo3843b()
            java.lang.String r4 = r8.f2178d
            java.lang.String r0 = r0.getString(r4, r1)
            java.io.File r4 = new java.io.File
            android.content.Context r5 = r8.f2176b
            java.io.File r5 = r5.getFilesDir()
            java.lang.String r6 = r8.f2177c
            r4.<init>(r5, r6)
            if (r3 != 0) goto L_0x0059
            if (r0 == 0) goto L_0x0040
            android.content.SharedPreferences r0 = r2.mo3843b()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r1 = r8.f2178d
            android.content.SharedPreferences$Editor r0 = r0.remove(r1)
            r0.apply()
        L_0x0040:
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x0053
            boolean r0 = r4.delete()
            if (r0 != 0) goto L_0x0053
            java.lang.String r0 = "Couldn't delete file"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
        L_0x0053:
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f2180f
            r0.set(r7)
            goto L_0x000b
        L_0x0059:
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x006b
            boolean r0 = r4.isFile()
            if (r0 == 0) goto L_0x006b
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f2180f
            r0.set(r7)
            goto L_0x000b
        L_0x006b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r0 = r8.f2179e
            if (r0 == 0) goto L_0x0089
            java.lang.String r0 = "?"
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L_0x00c0
            r0 = 38
        L_0x0081:
            r5.append(r0)
            java.lang.String r0 = r8.f2179e
            r5.append(r0)
        L_0x0089:
            java.lang.String r0 = r5.toString()
            cmn.ak r5 = cmn.C0716ak.m3200a()     // Catch:{ IOException -> 0x00c3 }
            cmn.al r0 = r5.mo3399a(r0)     // Catch:{ IOException -> 0x00c3 }
            if (r0 == 0) goto L_0x00c4
            byte[] r0 = r0.mo3402b()     // Catch:{ IOException -> 0x00c3 }
        L_0x009b:
            java.lang.String r5 = r8.m3667a(r2)
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x00c6
            r8.m3668a(r4, r0)
            android.content.SharedPreferences r0 = r2.mo3843b()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r1 = r8.f2178d
            android.content.SharedPreferences$Editor r0 = r0.putString(r1, r3)
            r0.apply()
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f2180f
            r0.set(r7)
            goto L_0x000b
        L_0x00c0:
            r0 = 63
            goto L_0x0081
        L_0x00c3:
            r0 = move-exception
        L_0x00c4:
            r0 = r1
            goto L_0x009b
        L_0x00c6:
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f2180f
            r0.set(r7)
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p032a.C0826bo.mo3687a():void");
    }

    /* renamed from: b */
    public final synchronized byte[] mo3688b() {
        FileInputStream fileInputStream;
        byte[] bArr = null;
        synchronized (this) {
            File file = new File(this.f2176b.getFilesDir(), this.f2177c);
            if (file.isFile()) {
                byte[] bArr2 = new byte[((int) file.length())];
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        if (fileInputStream.read(bArr2) != bArr2.length) {
                            throw new IOException();
                        }
                        bArr = bArr2;
                        C0719an.m3210a((Closeable) fileInputStream);
                    } catch (IOException e) {
                    }
                } catch (IOException e2) {
                    fileInputStream = null;
                }
            }
        }
        return bArr;
    }

    /* renamed from: c */
    public final String mo3689c() {
        return C0932fm.m3968a().mo3843b().getString(this.f2178d, (String) null);
    }
}
