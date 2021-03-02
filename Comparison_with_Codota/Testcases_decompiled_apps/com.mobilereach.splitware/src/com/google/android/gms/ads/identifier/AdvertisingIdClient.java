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
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private final Context mContext;
    com.google.android.gms.common.zza zzoS;
    zzat zzoT;
    boolean zzoU;
    Object zzoV;
    zza zzoW;
    final long zzoX;

    public static final class Info {
        private final String zzpc;
        private final boolean zzpd;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.zzpc = advertisingId;
            this.zzpd = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.zzpc;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzpd;
        }

        public String toString() {
            return "{" + this.zzpc + "}" + this.zzpd;
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzoY;
        private long zzoZ;
        CountDownLatch zzpa = new CountDownLatch(1);
        boolean zzpb = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzoY = new WeakReference<>(advertisingIdClient);
            this.zzoZ = j;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzoY.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzpb = true;
            }
        }

        public void cancel() {
            this.zzpa.countDown();
        }

        public void run() {
            try {
                if (!this.zzpa.await(this.zzoZ, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }

        public boolean zzaK() {
            return this.zzpb;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long timeoutInMillis) {
        this.zzoV = new Object();
        zzx.zzz(context);
        this.mContext = context;
        this.zzoU = false;
        this.zzoX = timeoutInMillis;
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

    public static void setShouldSkipGmsCoreVersionCheck(boolean shouldSkipGmsCoreVersionCheck) {
    }

    static zzat zza(Context context, com.google.android.gms.common.zza zza2) throws IOException {
        try {
            return zzat.zza.zzb(zza2.zzoJ());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private void zzaJ() {
        synchronized (this.zzoV) {
            if (this.zzoW != null) {
                this.zzoW.cancel();
                try {
                    this.zzoW.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzoX > 0) {
                this.zzoW = new zza(this, this.zzoX);
            }
        }
    }

    static com.google.android.gms.common.zza zzp(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (zzc.zzoK().isGooglePlayServicesAvailable(context)) {
                case 0:
                case 2:
                    com.google.android.gms.common.zza zza2 = new com.google.android.gms.common.zza();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (zzb.zzrP().zza(context, intent, (ServiceConnection) zza2, 1)) {
                            return zza2;
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
            android.content.Context r0 = r3.mContext     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x000e
            com.google.android.gms.common.zza r0 = r3.zzoS     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
        L_0x000f:
            return
        L_0x0010:
            boolean r0 = r3.zzoU     // Catch:{ IllegalArgumentException -> 0x002d }
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.common.stats.zzb r0 = com.google.android.gms.common.stats.zzb.zzrP()     // Catch:{ IllegalArgumentException -> 0x002d }
            android.content.Context r1 = r3.mContext     // Catch:{ IllegalArgumentException -> 0x002d }
            com.google.android.gms.common.zza r2 = r3.zzoS     // Catch:{ IllegalArgumentException -> 0x002d }
            r0.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x002d }
        L_0x001f:
            r0 = 0
            r3.zzoU = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.zzoT = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.zzoS = r0     // Catch:{ all -> 0x002a }
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
            if (!this.zzoU) {
                synchronized (this.zzoV) {
                    if (this.zzoW == null || !this.zzoW.zzaK()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzb(false);
                    if (!this.zzoU) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzx.zzz(this.zzoS);
            zzx.zzz(this.zzoT);
            info = new Info(this.zzoT.getId(), this.zzoT.zzc(true));
        }
        zzaJ();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb(true);
    }

    /* access modifiers changed from: protected */
    public void zzb(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzoU) {
                finish();
            }
            this.zzoS = zzp(this.mContext);
            this.zzoT = zza(this.mContext, this.zzoS);
            this.zzoU = true;
            if (z) {
                zzaJ();
            }
        }
    }
}
