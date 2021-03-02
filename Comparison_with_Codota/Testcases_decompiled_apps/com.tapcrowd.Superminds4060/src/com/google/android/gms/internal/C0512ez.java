package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0387de;
import com.google.android.gms.internal.C0503ew;
import com.google.android.gms.internal.C0506ex;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ez */
public class C0512ez extends C0387de<C0506ex> {

    /* renamed from: oO */
    private final C0522fc<C0506ex> f1285oO = new C0516c();

    /* renamed from: oU */
    private final C0509ey f1286oU;

    /* renamed from: oV */
    private final String f1287oV;

    /* renamed from: com.google.android.gms.internal.ez$a */
    private final class C0514a extends C0387de<C0506ex>.b<LocationClient.OnAddGeofencesResultListener> {

        /* renamed from: iC */
        private final int f1288iC;

        /* renamed from: oW */
        private final String[] f1289oW;

        public C0514a(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener, int i, String[] strArr) {
            super(onAddGeofencesResultListener);
            this.f1288iC = LocationStatusCodes.m1973Z(i);
            this.f1289oW = strArr;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4270a(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener) {
            if (onAddGeofencesResultListener != null) {
                onAddGeofencesResultListener.onAddGeofencesResult(this.f1288iC, this.f1289oW);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.ez$b */
    private static final class C0515b extends C0503ew.C0504a {

        /* renamed from: oY */
        private LocationClient.OnAddGeofencesResultListener f1291oY;

        /* renamed from: oZ */
        private LocationClient.OnRemoveGeofencesResultListener f1292oZ;

        /* renamed from: pa */
        private C0512ez f1293pa;

        public C0515b(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener, C0512ez ezVar) {
            this.f1291oY = onAddGeofencesResultListener;
            this.f1292oZ = null;
            this.f1293pa = ezVar;
        }

        public C0515b(LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, C0512ez ezVar) {
            this.f1292oZ = onRemoveGeofencesResultListener;
            this.f1291oY = null;
            this.f1293pa = ezVar;
        }

        public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) throws RemoteException {
            if (this.f1293pa == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            C0512ez ezVar = this.f1293pa;
            C0512ez ezVar2 = this.f1293pa;
            ezVar2.getClass();
            ezVar.mo4326a((C0387de<T>.b<?>) new C0514a(this.f1291oY, statusCode, geofenceRequestIds));
            this.f1293pa = null;
            this.f1291oY = null;
            this.f1292oZ = null;
        }

        public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
            if (this.f1293pa == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            C0512ez ezVar = this.f1293pa;
            C0512ez ezVar2 = this.f1293pa;
            ezVar2.getClass();
            ezVar.mo4326a((C0387de<T>.b<?>) new C0517d(ezVar2, 1, this.f1292oZ, statusCode, pendingIntent));
            this.f1293pa = null;
            this.f1291oY = null;
            this.f1292oZ = null;
        }

        public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
            if (this.f1293pa == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            C0512ez ezVar = this.f1293pa;
            C0512ez ezVar2 = this.f1293pa;
            ezVar2.getClass();
            ezVar.mo4326a((C0387de<T>.b<?>) new C0517d(2, this.f1292oZ, statusCode, geofenceRequestIds));
            this.f1293pa = null;
            this.f1291oY = null;
            this.f1292oZ = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.ez$c */
    private final class C0516c implements C0522fc<C0506ex> {
        private C0516c() {
        }

        /* renamed from: bc */
        public void mo4759bc() {
            C0512ez.this.mo4331bc();
        }

        /* renamed from: cn */
        public C0506ex mo4760bd() {
            return (C0506ex) C0512ez.this.mo4332bd();
        }
    }

    /* renamed from: com.google.android.gms.internal.ez$d */
    private final class C0517d extends C0387de<C0506ex>.b<LocationClient.OnRemoveGeofencesResultListener> {

        /* renamed from: iC */
        private final int f1295iC;
        private final PendingIntent mPendingIntent;

        /* renamed from: oW */
        private final String[] f1296oW;

        /* renamed from: pb */
        private final int f1298pb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0517d(C0512ez ezVar, int i, LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, PendingIntent pendingIntent) {
            super(onRemoveGeofencesResultListener);
            boolean z = true;
            C0512ez.this = ezVar;
            C0384db.m831k(i != 1 ? false : z);
            this.f1298pb = i;
            this.f1295iC = LocationStatusCodes.m1973Z(i2);
            this.mPendingIntent = pendingIntent;
            this.f1296oW = null;
        }

        public C0517d(int i, LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, String[] strArr) {
            super(onRemoveGeofencesResultListener);
            C0384db.m831k(i == 2);
            this.f1298pb = i;
            this.f1295iC = LocationStatusCodes.m1973Z(i2);
            this.f1296oW = strArr;
            this.mPendingIntent = null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4270a(LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener) {
            if (onRemoveGeofencesResultListener != null) {
                switch (this.f1298pb) {
                    case 1:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.f1295iC, this.mPendingIntent);
                        return;
                    case 2:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.f1295iC, this.f1296oW);
                        return;
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.f1298pb);
                        return;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    public C0512ez(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f1286oU = new C0509ey(context, this.f1285oO);
        this.f1287oV = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: G */
    public C0506ex mo4168p(IBinder iBinder) {
        return C0506ex.C0507a.m1501F(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4163a(C0402dj djVar, C0387de.C0391d dVar) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f1287oV);
        djVar.mo4377e(dVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), bundle);
    }

    public void addGeofences(List<C0520fa> geofences, PendingIntent pendingIntent, LocationClient.OnAddGeofencesResultListener listener) {
        mo4331bc();
        C0411dm.m943b(geofences != null && geofences.size() > 0, "At least one geofence must be specified.");
        C0411dm.m940a(pendingIntent, (Object) "PendingIntent must be specified.");
        C0411dm.m940a(listener, (Object) "OnAddGeofencesResultListener not provided.");
        try {
            ((C0506ex) mo4332bd()).mo4724a(geofences, pendingIntent, listener == null ? null : new C0515b(listener, this), getContext().getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ag */
    public String mo4164ag() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ah */
    public String mo4165ah() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public void disconnect() {
        synchronized (this.f1286oU) {
            if (isConnected()) {
                this.f1286oU.removeAllListeners();
                this.f1286oU.mo4732cm();
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.f1286oU.getLastLocation();
    }

    public void removeActivityUpdates(PendingIntent callbackIntent) {
        mo4331bc();
        C0411dm.m944e(callbackIntent);
        try {
            ((C0506ex) mo4332bd()).removeActivityUpdates(callbackIntent);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGeofences(PendingIntent pendingIntent, LocationClient.OnRemoveGeofencesResultListener listener) {
        mo4331bc();
        C0411dm.m940a(pendingIntent, (Object) "PendingIntent must be specified.");
        C0411dm.m940a(listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        try {
            ((C0506ex) mo4332bd()).mo4718a(pendingIntent, (C0503ew) listener == null ? null : new C0515b(listener, this), getContext().getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGeofences(List<String> geofenceRequestIds, LocationClient.OnRemoveGeofencesResultListener listener) {
        mo4331bc();
        C0411dm.m943b(geofenceRequestIds != null && geofenceRequestIds.size() > 0, "geofenceRequestIds can't be null nor empty.");
        C0411dm.m940a(listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        try {
            ((C0506ex) mo4332bd()).mo4725a((String[]) geofenceRequestIds.toArray(new String[0]), (C0503ew) listener == null ? null : new C0515b(listener, this), getContext().getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.f1286oU.removeLocationUpdates(callbackIntent);
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.f1286oU.removeLocationUpdates(listener);
    }

    public void requestActivityUpdates(long detectionIntervalMillis, PendingIntent callbackIntent) {
        boolean z = true;
        mo4331bc();
        C0411dm.m944e(callbackIntent);
        if (detectionIntervalMillis < 0) {
            z = false;
        }
        C0411dm.m943b(z, "detectionIntervalMillis must be >= 0");
        try {
            ((C0506ex) mo4332bd()).mo4716a(detectionIntervalMillis, true, callbackIntent);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.f1286oU.requestLocationUpdates(request, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener) {
        requestLocationUpdates(request, listener, (Looper) null);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        synchronized (this.f1286oU) {
            this.f1286oU.requestLocationUpdates(request, listener, looper);
        }
    }

    public void setMockLocation(Location mockLocation) {
        this.f1286oU.setMockLocation(mockLocation);
    }

    public void setMockMode(boolean isMockMode) {
        this.f1286oU.setMockMode(isMockMode);
    }
}
