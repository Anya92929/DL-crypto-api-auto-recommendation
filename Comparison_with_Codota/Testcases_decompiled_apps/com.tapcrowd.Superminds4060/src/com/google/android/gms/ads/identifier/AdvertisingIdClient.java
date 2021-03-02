package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C0136a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.internal.C0610p;
import java.io.IOException;

public final class AdvertisingIdClient {

    public static final class Info {

        /* renamed from: dX */
        private final String f324dX;

        /* renamed from: dY */
        private final boolean f325dY;

        Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.f324dX = advertisingId;
            this.f325dY = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.f324dX;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f325dY;
        }
    }

    /* renamed from: g */
    private static C0136a m205g(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.m229m(context);
                C0136a aVar = new C0136a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                if (context.bindService(intent, aVar, 1)) {
                    return aVar;
                }
                throw new IOException("Connection failure");
            } catch (GooglePlayServicesNotAvailableException e) {
                throw new IOException(e);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        C0411dm.m948x("Calling this from your main thread can lead to deadlock");
        C0136a g = m205g(context);
        try {
            C0610p b = C0610p.C0611a.m1914b(g.mo3573aG());
            Info info = new Info(b.getId(), b.mo5314a(true));
            context.unbindService(g);
            return info;
        } catch (RemoteException e) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", e);
            throw new IOException("Remote exception");
        } catch (InterruptedException e2) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            context.unbindService(g);
            throw th;
        }
    }
}
