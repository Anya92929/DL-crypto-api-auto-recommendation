package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C0265a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.internal.C1731s;
import java.io.IOException;

public final class AdvertisingIdClient {

    /* renamed from: lk */
    C0265a f42lk;

    /* renamed from: ll */
    C1731s f43ll;

    /* renamed from: lm */
    boolean f44lm = false;
    final Context mContext;

    public static final class Info {

        /* renamed from: ln */
        private final String f45ln;

        /* renamed from: lo */
        private final boolean f46lo;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.f45ln = advertisingId;
            this.f46lo = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.f45ln;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f46lo;
        }

        public String toString() {
            return "{" + this.f45ln + "}" + this.f46lo;
        }
    }

    public AdvertisingIdClient(Context context) {
        C0348n.m861i(context);
        this.mContext = context;
    }

    /* renamed from: a */
    static C1731s m27a(Context context, C0265a aVar) throws IOException {
        try {
            return C1731s.C1732a.m6160b(aVar.mo4180fX());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context);
        try {
            advertisingIdClient.start();
            return advertisingIdClient.mo3367W();
        } finally {
            advertisingIdClient.finish();
        }
    }

    /* renamed from: i */
    static C0265a m28i(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.m460D(context);
                C0265a aVar = new C0265a();
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

    /* renamed from: W */
    public Info mo3367W() throws IOException {
        C0348n.m855aU("Calling this from your main thread can lead to deadlock");
        C0348n.m861i(this.f42lk);
        C0348n.m861i(this.f43ll);
        if (!this.f44lm) {
            throw new IOException("AdvertisingIdService is not connected.");
        }
        try {
            return new Info(this.f43ll.getId(), this.f43ll.mo10133a(true));
        } catch (RemoteException e) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", e);
            throw new IOException("Remote exception");
        }
    }

    public void finish() {
        C0348n.m855aU("Calling this from your main thread can lead to deadlock");
        if (this.mContext != null && this.f42lk != null) {
            try {
                if (this.f44lm) {
                    this.mContext.unbindService(this.f42lk);
                }
            } catch (IllegalArgumentException e) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", e);
            }
            this.f44lm = false;
            this.f43ll = null;
            this.f42lk = null;
        }
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        C0348n.m855aU("Calling this from your main thread can lead to deadlock");
        if (this.f44lm) {
            finish();
        }
        this.f42lk = m28i(this.mContext);
        this.f43ll = m27a(this.mContext, this.f42lk);
        this.f44lm = true;
    }
}
