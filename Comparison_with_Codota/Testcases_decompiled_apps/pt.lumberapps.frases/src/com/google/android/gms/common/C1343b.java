package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.internal.zzsb;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.common.b */
class C1343b {

    /* renamed from: a */
    private static zzv f4358a;

    /* renamed from: b */
    private static Context f4359b;

    /* renamed from: c */
    private static Set f4360c;

    /* renamed from: d */
    private static Set f4361d;

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        android.util.Log.e("GoogleCertificates", "Failed to retrieve google certificates");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized java.util.Set m5981a() {
        /*
            java.lang.Class<com.google.android.gms.common.b> r1 = com.google.android.gms.common.C1343b.class
            monitor-enter(r1)
            java.util.Set r0 = f4360c     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x000b
            java.util.Set r0 = f4360c     // Catch:{ all -> 0x005c }
        L_0x0009:
            monitor-exit(r1)
            return r0
        L_0x000b:
            com.google.android.gms.common.internal.zzv r0 = f4358a     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x0018
            boolean r0 = m5985c()     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x0018
            java.util.Set r0 = java.util.Collections.EMPTY_SET     // Catch:{ all -> 0x005c }
            goto L_0x0009
        L_0x0018:
            com.google.android.gms.common.internal.zzv r0 = f4358a     // Catch:{ RemoteException -> 0x0053 }
            com.google.android.gms.dynamic.zzd r0 = r0.zzatc()     // Catch:{ RemoteException -> 0x0053 }
            if (r0 != 0) goto L_0x002a
            java.lang.String r0 = "GoogleCertificates"
            java.lang.String r2 = "Failed to get google certificates from remote"
            android.util.Log.e(r0, r2)     // Catch:{ RemoteException -> 0x0053 }
            java.util.Set r0 = java.util.Collections.EMPTY_SET     // Catch:{ RemoteException -> 0x0053 }
            goto L_0x0009
        L_0x002a:
            java.lang.Object r0 = com.google.android.gms.dynamic.zze.zzad(r0)     // Catch:{ RemoteException -> 0x0053 }
            android.os.IBinder[] r0 = (android.os.IBinder[]) r0     // Catch:{ RemoteException -> 0x0053 }
            java.util.Set r0 = m5982a((android.os.IBinder[]) r0)     // Catch:{ RemoteException -> 0x0053 }
            f4360c = r0     // Catch:{ RemoteException -> 0x0053 }
            r0 = 0
        L_0x0037:
            com.google.android.gms.common.c[] r2 = com.google.android.gms.common.C1348f.f4401a     // Catch:{ RemoteException -> 0x0053 }
            int r2 = r2.length     // Catch:{ RemoteException -> 0x0053 }
            if (r0 >= r2) goto L_0x0048
            java.util.Set r2 = f4360c     // Catch:{ RemoteException -> 0x0053 }
            com.google.android.gms.common.c[] r3 = com.google.android.gms.common.C1348f.f4401a     // Catch:{ RemoteException -> 0x0053 }
            r3 = r3[r0]     // Catch:{ RemoteException -> 0x0053 }
            r2.add(r3)     // Catch:{ RemoteException -> 0x0053 }
            int r0 = r0 + 1
            goto L_0x0037
        L_0x0048:
            java.util.Set r0 = f4360c     // Catch:{ RemoteException -> 0x0053 }
            java.util.Set r0 = java.util.Collections.unmodifiableSet(r0)     // Catch:{ RemoteException -> 0x0053 }
            f4360c = r0     // Catch:{ RemoteException -> 0x0053 }
        L_0x0050:
            java.util.Set r0 = f4360c     // Catch:{ all -> 0x005c }
            goto L_0x0009
        L_0x0053:
            r0 = move-exception
            java.lang.String r0 = "GoogleCertificates"
            java.lang.String r2 = "Failed to retrieve google certificates"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x005c }
            goto L_0x0050
        L_0x005c:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.C1343b.m5981a():java.util.Set");
    }

    /* renamed from: a */
    private static Set m5982a(IBinder[] iBinderArr) {
        HashSet hashSet = new HashSet(r1);
        for (IBinder zzdr : iBinderArr) {
            zzs zzdr2 = zzs.zza.zzdr(zzdr);
            if (zzdr2 == null) {
                Log.e("GoogleCertificates", "iCertData is null, skipping");
            } else {
                hashSet.add(zzdr2);
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    static synchronized void m5983a(Context context) {
        synchronized (C1343b.class) {
            if (f4359b != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f4359b = context.getApplicationContext();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        android.util.Log.e("GoogleCertificates", "Failed to retrieve google release certificates");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized java.util.Set m5984b() {
        /*
            java.lang.Class<com.google.android.gms.common.b> r1 = com.google.android.gms.common.C1343b.class
            monitor-enter(r1)
            java.util.Set r0 = f4361d     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x000b
            java.util.Set r0 = f4361d     // Catch:{ all -> 0x0054 }
        L_0x0009:
            monitor-exit(r1)
            return r0
        L_0x000b:
            com.google.android.gms.common.internal.zzv r0 = f4358a     // Catch:{ all -> 0x0054 }
            if (r0 != 0) goto L_0x0018
            boolean r0 = m5985c()     // Catch:{ all -> 0x0054 }
            if (r0 != 0) goto L_0x0018
            java.util.Set r0 = java.util.Collections.EMPTY_SET     // Catch:{ all -> 0x0054 }
            goto L_0x0009
        L_0x0018:
            com.google.android.gms.common.internal.zzv r0 = f4358a     // Catch:{ RemoteException -> 0x004b }
            com.google.android.gms.dynamic.zzd r0 = r0.zzatd()     // Catch:{ RemoteException -> 0x004b }
            if (r0 != 0) goto L_0x002a
            java.lang.String r0 = "GoogleCertificates"
            java.lang.String r2 = "Failed to get google release certificates from remote"
            android.util.Log.d(r0, r2)     // Catch:{ RemoteException -> 0x004b }
            java.util.Set r0 = java.util.Collections.EMPTY_SET     // Catch:{ RemoteException -> 0x004b }
            goto L_0x0009
        L_0x002a:
            java.lang.Object r0 = com.google.android.gms.dynamic.zze.zzad(r0)     // Catch:{ RemoteException -> 0x004b }
            android.os.IBinder[] r0 = (android.os.IBinder[]) r0     // Catch:{ RemoteException -> 0x004b }
            java.util.Set r0 = m5982a((android.os.IBinder[]) r0)     // Catch:{ RemoteException -> 0x004b }
            f4361d = r0     // Catch:{ RemoteException -> 0x004b }
            java.util.Set r0 = f4361d     // Catch:{ RemoteException -> 0x004b }
            com.google.android.gms.common.c[] r2 = com.google.android.gms.common.C1348f.f4401a     // Catch:{ RemoteException -> 0x004b }
            r3 = 0
            r2 = r2[r3]     // Catch:{ RemoteException -> 0x004b }
            r0.add(r2)     // Catch:{ RemoteException -> 0x004b }
            java.util.Set r0 = f4361d     // Catch:{ RemoteException -> 0x004b }
            java.util.Set r0 = java.util.Collections.unmodifiableSet(r0)     // Catch:{ RemoteException -> 0x004b }
            f4361d = r0     // Catch:{ RemoteException -> 0x004b }
        L_0x0048:
            java.util.Set r0 = f4361d     // Catch:{ all -> 0x0054 }
            goto L_0x0009
        L_0x004b:
            r0 = move-exception
            java.lang.String r0 = "GoogleCertificates"
            java.lang.String r2 = "Failed to retrieve google release certificates"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0054 }
            goto L_0x0048
        L_0x0054:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.C1343b.m5984b():java.util.Set");
    }

    /* renamed from: c */
    private static boolean m5985c() {
        zzab.zzy(f4359b);
        if (f4358a == null) {
            try {
                zzsb zza = zzsb.zza(f4359b, zzsb.f6982KM, "com.google.android.gms.googlecertificates");
                Log.d("GoogleCertificates", "com.google.android.gms.googlecertificates module is loaded");
                f4358a = zzv.zza.zzdu(zza.zziu("com.google.android.gms.common.GoogleCertificatesImpl"));
            } catch (zzsb.zza e) {
                String valueOf = String.valueOf("Failed to load com.google.android.gms.googlecertificates: ");
                String valueOf2 = String.valueOf(e.getMessage());
                Log.e("GoogleCertificates", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                return false;
            }
        }
        return true;
    }
}
