package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.common.internal.C1009bf;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* renamed from: com.google.android.gms.analytics.internal.av */
public class C0535av extends C0514aa {

    /* renamed from: a */
    private volatile String f3771a;

    /* renamed from: b */
    private Future<String> f3772b;

    protected C0535av(C0516ac acVar) {
        super(acVar);
    }

    /* renamed from: a */
    private boolean m3120a(Context context, String str) {
        boolean z = false;
        C1009bf.m4530a(str);
        C1009bf.m4538c("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            mo6866a("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            z = true;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    mo6880e("Failed to close clientId writing stream", e);
                }
            }
        } catch (FileNotFoundException e2) {
            mo6880e("Error creating clientId file", e2);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    mo6880e("Failed to close clientId writing stream", e3);
                }
            }
        } catch (IOException e4) {
            mo6880e("Error writing to clientId file", e4);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    mo6880e("Failed to close clientId writing stream", e5);
                }
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    mo6880e("Failed to close clientId writing stream", e6);
                }
            }
            throw th;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public String m3121f() {
        String e = mo6709e();
        try {
            return !m3120a(mo6889r().mo7021c(), e) ? "0" : e;
        } catch (Exception e2) {
            mo6880e("Error saving clientId file", e2);
            return "0";
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0074 A[SYNTHETIC, Splitter:B:34:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008d A[SYNTHETIC, Splitter:B:44:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009d A[SYNTHETIC, Splitter:B:51:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo6705a(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = "ClientId should be loaded from worker thread"
            com.google.android.gms.common.internal.C1009bf.m4538c(r1)
            java.lang.String r1 = "gaClientId"
            java.io.FileInputStream r2 = r7.openFileInput(r1)     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x007f, all -> 0x0098 }
            r1 = 36
            byte[] r3 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            r1 = 0
            int r4 = r3.length     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            int r4 = r2.read(r3, r1, r4)     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            int r1 = r2.available()     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            if (r1 <= 0) goto L_0x0036
            java.lang.String r1 = "clientId file seems corrupted, deleting it."
            r6.mo6879e(r1)     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            r2.close()     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            java.lang.String r1 = "gaClientId"
            r7.deleteFile(r1)     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            if (r2 == 0) goto L_0x002e
            r2.close()     // Catch:{ IOException -> 0x002f }
        L_0x002e:
            return r0
        L_0x002f:
            r1 = move-exception
            java.lang.String r2 = "Failed to close client id reading stream"
            r6.mo6880e(r2, r1)
            goto L_0x002e
        L_0x0036:
            r1 = 14
            if (r4 >= r1) goto L_0x0054
            java.lang.String r1 = "clientId file is empty, deleting it."
            r6.mo6879e(r1)     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            r2.close()     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            java.lang.String r1 = "gaClientId"
            r7.deleteFile(r1)     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            if (r2 == 0) goto L_0x002e
            r2.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x002e
        L_0x004d:
            r1 = move-exception
            java.lang.String r2 = "Failed to close client id reading stream"
            r6.mo6880e(r2, r1)
            goto L_0x002e
        L_0x0054:
            r2.close()     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            java.lang.String r1 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            r5 = 0
            r1.<init>(r3, r5, r4)     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            java.lang.String r3 = "Read client id from disk"
            r6.mo6866a(r3, r1)     // Catch:{ FileNotFoundException -> 0x00ac, IOException -> 0x00aa }
            if (r2 == 0) goto L_0x0067
            r2.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0067:
            r0 = r1
            goto L_0x002e
        L_0x0069:
            r0 = move-exception
            java.lang.String r2 = "Failed to close client id reading stream"
            r6.mo6880e(r2, r0)
            goto L_0x0067
        L_0x0070:
            r1 = move-exception
            r1 = r0
        L_0x0072:
            if (r1 == 0) goto L_0x002e
            r1.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x002e
        L_0x0078:
            r1 = move-exception
            java.lang.String r2 = "Failed to close client id reading stream"
            r6.mo6880e(r2, r1)
            goto L_0x002e
        L_0x007f:
            r1 = move-exception
            r2 = r0
        L_0x0081:
            java.lang.String r3 = "Error reading client id file, deleting it"
            r6.mo6880e(r3, r1)     // Catch:{ all -> 0x00a8 }
            java.lang.String r1 = "gaClientId"
            r7.deleteFile(r1)     // Catch:{ all -> 0x00a8 }
            if (r2 == 0) goto L_0x002e
            r2.close()     // Catch:{ IOException -> 0x0091 }
            goto L_0x002e
        L_0x0091:
            r1 = move-exception
            java.lang.String r2 = "Failed to close client id reading stream"
            r6.mo6880e(r2, r1)
            goto L_0x002e
        L_0x0098:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x009b:
            if (r2 == 0) goto L_0x00a0
            r2.close()     // Catch:{ IOException -> 0x00a1 }
        L_0x00a0:
            throw r0
        L_0x00a1:
            r1 = move-exception
            java.lang.String r2 = "Failed to close client id reading stream"
            r6.mo6880e(r2, r1)
            goto L_0x00a0
        L_0x00a8:
            r0 = move-exception
            goto L_0x009b
        L_0x00aa:
            r1 = move-exception
            goto L_0x0081
        L_0x00ac:
            r1 = move-exception
            r1 = r2
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.C0535av.mo6705a(android.content.Context):java.lang.String");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
    }

    /* renamed from: b */
    public String mo6706b() {
        String str;
        mo6596D();
        synchronized (this) {
            if (this.f3771a == null) {
                this.f3772b = mo6889r().mo7016a(new C0536aw(this));
            }
            if (this.f3772b != null) {
                try {
                    this.f3771a = this.f3772b.get();
                } catch (InterruptedException e) {
                    mo6877d("ClientId loading or generation was interrupted", e);
                    this.f3771a = "0";
                } catch (ExecutionException e2) {
                    mo6880e("Failed to load or generate client id", e2);
                    this.f3771a = "0";
                }
                if (this.f3771a == null) {
                    this.f3771a = "0";
                }
                mo6866a("Loaded clientId", this.f3771a);
                this.f3772b = null;
            }
            str = this.f3771a;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo6707c() {
        synchronized (this) {
            this.f3771a = null;
            this.f3772b = mo6889r().mo7016a(new C0537ax(this));
        }
        return mo6706b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo6708d() {
        String a = mo6705a(mo6889r().mo7021c());
        return a == null ? m3121f() : a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo6709e() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
