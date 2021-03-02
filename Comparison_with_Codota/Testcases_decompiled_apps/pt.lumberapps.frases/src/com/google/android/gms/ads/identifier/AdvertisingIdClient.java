package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zza;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzcc;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {

    /* renamed from: a */
    zza f3416a;

    /* renamed from: b */
    zzcc f3417b;

    /* renamed from: c */
    boolean f3418c;

    /* renamed from: d */
    Object f3419d;

    /* renamed from: e */
    C1212a f3420e;

    /* renamed from: f */
    final long f3421f;

    /* renamed from: g */
    private final Context f3422g;

    public final class Info {

        /* renamed from: a */
        private final String f3423a;

        /* renamed from: b */
        private final boolean f3424b;

        public Info(String str, boolean z) {
            this.f3423a = str;
            this.f3424b = z;
        }

        public String getId() {
            return this.f3423a;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f3424b;
        }

        public String toString() {
            String str = this.f3423a;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.f3424b).toString();
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.f3419d = new Object();
        zzab.zzy(context);
        this.f3422g = context;
        this.f3418c = false;
        this.f3421f = j;
    }

    /* renamed from: a */
    static zza m5514a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (zzc.zzang().isGooglePlayServicesAvailable(context)) {
                case 0:
                case 2:
                    zza zza = new zza();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (zzb.zzaux().zza(context, intent, (ServiceConnection) zza, 1)) {
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
    static zzcc m5515a(Context context, zza zza) {
        try {
            return zzcc.zza.zzf(zza.zza(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    /* renamed from: a */
    private void m5516a() {
        synchronized (this.f3419d) {
            if (this.f3420e != null) {
                this.f3420e.mo4985a();
                try {
                    this.f3420e.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.f3421f > 0) {
                this.f3420e = new C1212a(this, this.f3421f);
            }
        }
    }

    public static Info getAdvertisingIdInfo(Context context) {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.mo4977a(false);
            return advertisingIdClient.getInfo();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4977a(boolean z) {
        zzab.zzhj("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f3418c) {
                finish();
            }
            this.f3416a = m5514a(this.f3422g);
            this.f3417b = m5515a(this.f3422g, this.f3416a);
            this.f3418c = true;
            if (z) {
                m5516a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
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
            com.google.android.gms.common.internal.zzab.zzhj(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.f3422g     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x000e
            com.google.android.gms.common.zza r0 = r3.f3416a     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
        L_0x000f:
            return
        L_0x0010:
            boolean r0 = r3.f3418c     // Catch:{ IllegalArgumentException -> 0x002d }
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.common.stats.zzb r0 = com.google.android.gms.common.stats.zzb.zzaux()     // Catch:{ IllegalArgumentException -> 0x002d }
            android.content.Context r1 = r3.f3422g     // Catch:{ IllegalArgumentException -> 0x002d }
            com.google.android.gms.common.zza r2 = r3.f3416a     // Catch:{ IllegalArgumentException -> 0x002d }
            r0.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x002d }
        L_0x001f:
            r0 = 0
            r3.f3418c = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.f3417b = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.f3416a = r0     // Catch:{ all -> 0x002a }
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

    public Info getInfo() {
        Info info;
        zzab.zzhj("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f3418c) {
                synchronized (this.f3419d) {
                    if (this.f3420e == null || !this.f3420e.mo4986b()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    mo4977a(false);
                    if (!this.f3418c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzab.zzy(this.f3416a);
            zzab.zzy(this.f3417b);
            info = new Info(this.f3417b.getId(), this.f3417b.zzf(true));
        }
        m5516a();
        return info;
    }

    public void start() {
        mo4977a(true);
    }
}
