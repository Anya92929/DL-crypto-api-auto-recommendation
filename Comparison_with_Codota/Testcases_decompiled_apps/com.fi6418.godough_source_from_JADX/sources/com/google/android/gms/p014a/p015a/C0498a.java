package com.google.android.gms.p014a.p015a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C0772b;
import com.google.android.gms.common.C0799c;
import com.google.android.gms.common.C0853e;
import com.google.android.gms.common.C0934h;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.stats.C1093b;
import com.google.android.gms.p018c.C0662d;
import com.google.android.gms.p018c.C0663e;
import java.io.IOException;

/* renamed from: com.google.android.gms.a.a.a */
public class C0498a {

    /* renamed from: h */
    private static boolean f3652h = false;

    /* renamed from: a */
    C0934h f3653a;

    /* renamed from: b */
    C0662d f3654b;

    /* renamed from: c */
    boolean f3655c;

    /* renamed from: d */
    Object f3656d = new Object();

    /* renamed from: e */
    C0500c f3657e;

    /* renamed from: f */
    final long f3658f;

    /* renamed from: g */
    private final Context f3659g;

    public C0498a(Context context, long j) {
        C1009bf.m4528a(context);
        this.f3659g = context;
        this.f3655c = false;
        this.f3658f = j;
    }

    /* renamed from: a */
    static C0662d m2940a(Context context, C0934h hVar) {
        try {
            return C0663e.m3848a(hVar.mo7462a());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    /* renamed from: a */
    static C0934h m2941a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            if (f3652h) {
                Log.d("Ads", "Skipping gmscore version check");
                switch (C0772b.m4180a().mo7457a(context)) {
                    case 0:
                    case 2:
                        break;
                    default:
                        throw new IOException("Google Play services not available");
                }
            } else {
                try {
                    C0853e.m4249b(context);
                } catch (C0799c e) {
                    throw new IOException(e);
                }
            }
            C0934h hVar = new C0934h();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (C1093b.m4761a().mo7703a(context, intent, (ServiceConnection) hVar, 1)) {
                    return hVar;
                }
                throw new IOException("Connection failure");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new C0799c(9);
        }
    }

    /* renamed from: b */
    public static C0499b m2942b(Context context) {
        C0498a aVar = new C0498a(context, -1);
        try {
            aVar.mo6551a(false);
            return aVar.mo6550a();
        } finally {
            aVar.mo6552b();
        }
    }

    /* renamed from: c */
    private void m2943c() {
        synchronized (this.f3656d) {
            if (this.f3657e != null) {
                this.f3657e.mo6557a();
                try {
                    this.f3657e.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.f3658f > 0) {
                this.f3657e = new C0500c(this, this.f3658f);
            }
        }
    }

    /* renamed from: a */
    public C0499b mo6550a() {
        C0499b bVar;
        C1009bf.m4538c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f3655c) {
                synchronized (this.f3656d) {
                    if (this.f3657e == null || !this.f3657e.mo6558b()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    mo6551a(false);
                    if (!this.f3655c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            C1009bf.m4528a(this.f3653a);
            C1009bf.m4528a(this.f3654b);
            bVar = new C0499b(this.f3654b.mo7199a(), this.f3654b.mo7202a(true));
        }
        m2943c();
        return bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6551a(boolean z) {
        C1009bf.m4538c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f3655c) {
                mo6552b();
            }
            this.f3653a = m2941a(this.f3659g);
            this.f3654b = m2940a(this.f3659g, this.f3653a);
            this.f3655c = true;
            if (z) {
                m2943c();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6552b() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.C1009bf.m4538c(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.f3659g     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x000e
            com.google.android.gms.common.h r0 = r3.f3653a     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
        L_0x000f:
            return
        L_0x0010:
            boolean r0 = r3.f3655c     // Catch:{ IllegalArgumentException -> 0x002d }
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.common.stats.b r0 = com.google.android.gms.common.stats.C1093b.m4761a()     // Catch:{ IllegalArgumentException -> 0x002d }
            android.content.Context r1 = r3.f3659g     // Catch:{ IllegalArgumentException -> 0x002d }
            com.google.android.gms.common.h r2 = r3.f3653a     // Catch:{ IllegalArgumentException -> 0x002d }
            r0.mo7701a((android.content.Context) r1, (android.content.ServiceConnection) r2)     // Catch:{ IllegalArgumentException -> 0x002d }
        L_0x001f:
            r0 = 0
            r3.f3655c = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.f3654b = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.f3653a = r0     // Catch:{ all -> 0x002a }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            goto L_0x000f
        L_0x002a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r0
        L_0x002d:
            r0 = move-exception
            java.lang.String r1 = "AdvertisingIdClient"
            java.lang.String r2 = "AdvertisingIdClient unbindService failed."
            android.util.Log.i(r1, r2, r0)     // Catch:{ all -> 0x002a }
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.p014a.p015a.C0498a.mo6552b():void");
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        mo6552b();
        super.finalize();
    }
}
