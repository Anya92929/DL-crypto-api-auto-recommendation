package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zza;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {

    /* renamed from: a */
    zza f2443a;

    /* renamed from: b */
    zzat f2444b;

    /* renamed from: c */
    boolean f2445c;

    /* renamed from: d */
    Object f2446d;

    /* renamed from: e */
    C0669a f2447e;

    /* renamed from: f */
    final long f2448f;

    /* renamed from: g */
    private final Context f2449g;

    public static final class Info {

        /* renamed from: a */
        private final String f2450a;

        /* renamed from: b */
        private final boolean f2451b;

        public Info(String str, boolean z) {
            this.f2450a = str;
            this.f2451b = z;
        }

        public String getId() {
            return this.f2450a;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f2451b;
        }

        public String toString() {
            return "{" + this.f2450a + "}" + this.f2451b;
        }
    }

    /* renamed from: com.google.android.gms.ads.identifier.AdvertisingIdClient$a */
    static class C0669a extends Thread {

        /* renamed from: a */
        CountDownLatch f2452a = new CountDownLatch(1);

        /* renamed from: b */
        boolean f2453b = false;

        /* renamed from: c */
        private WeakReference<AdvertisingIdClient> f2454c;

        /* renamed from: d */
        private long f2455d;

        public C0669a(AdvertisingIdClient advertisingIdClient, long j) {
            this.f2454c = new WeakReference<>(advertisingIdClient);
            this.f2455d = j;
            start();
        }

        /* renamed from: c */
        private void m3613c() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.f2454c.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.f2453b = true;
            }
        }

        /* renamed from: a */
        public void mo4748a() {
            this.f2452a.countDown();
        }

        /* renamed from: b */
        public boolean mo4749b() {
            return this.f2453b;
        }

        public void run() {
            try {
                if (!this.f2452a.await(this.f2455d, TimeUnit.MILLISECONDS)) {
                    m3613c();
                }
            } catch (InterruptedException e) {
                m3613c();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.f2446d = new Object();
        zzx.zzz(context);
        this.f2449g = context;
        this.f2445c = false;
        this.f2448f = j;
    }

    /* renamed from: a */
    static zza m3610a(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (zzc.zzoK().isGooglePlayServicesAvailable(context)) {
                case 0:
                case 2:
                    zza zza = new zza();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (zzb.zzrP().zza(context, intent, (ServiceConnection) zza, 1)) {
                            return zza;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        throw new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    /* renamed from: a */
    static zzat m3611a(Context context, zza zza) throws IOException {
        try {
            return zzat.zza.zzb(zza.zzoJ());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    /* renamed from: a */
    private void m3612a() {
        synchronized (this.f2446d) {
            if (this.f2447e != null) {
                this.f2447e.mo4748a();
                try {
                    this.f2447e.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.f2448f > 0) {
                this.f2447e = new C0669a(this, this.f2448f);
            }
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.zzb(false);
            return advertisingIdClient.getInfo();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.zzx.zzcE(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.f2449g     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x000e
            com.google.android.gms.common.zza r0 = r3.f2443a     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
        L_0x000f:
            return
        L_0x0010:
            boolean r0 = r3.f2445c     // Catch:{ IllegalArgumentException -> 0x002d }
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.common.stats.zzb r0 = com.google.android.gms.common.stats.zzb.zzrP()     // Catch:{ IllegalArgumentException -> 0x002d }
            android.content.Context r1 = r3.f2449g     // Catch:{ IllegalArgumentException -> 0x002d }
            com.google.android.gms.common.zza r2 = r3.f2443a     // Catch:{ IllegalArgumentException -> 0x002d }
            r0.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x002d }
        L_0x001f:
            r0 = 0
            r3.f2445c = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.f2444b = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.f2443a = r0     // Catch:{ all -> 0x002a }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() throws IOException {
        Info info;
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f2445c) {
                synchronized (this.f2446d) {
                    if (this.f2447e == null || !this.f2447e.mo4749b()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzb(false);
                    if (!this.f2445c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzx.zzz(this.f2443a);
            zzx.zzz(this.f2444b);
            info = new Info(this.f2444b.getId(), this.f2444b.zzc(true));
        }
        m3612a();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb(true);
    }

    /* access modifiers changed from: protected */
    public void zzb(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f2445c) {
                finish();
            }
            this.f2443a = m3610a(this.f2449g);
            this.f2444b = m3611a(this.f2449g, this.f2443a);
            this.f2445c = true;
            if (z) {
                m3612a();
            }
        }
    }
}
