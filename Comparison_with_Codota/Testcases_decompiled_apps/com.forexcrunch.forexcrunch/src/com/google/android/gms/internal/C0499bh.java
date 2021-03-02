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
import com.google.android.gms.internal.C0490be;
import com.google.android.gms.internal.C0493bf;
import com.google.android.gms.internal.C0597k;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

/* renamed from: com.google.android.gms.internal.bh */
public class C0499bh extends C0597k<C0493bf> {

    /* renamed from: fG */
    private final C0507bk<C0493bf> f1116fG = new C0503c();

    /* renamed from: fM */
    private final C0496bg f1117fM;

    /* renamed from: fN */
    private final String f1118fN;

    /* renamed from: com.google.android.gms.internal.bh$a */
    private final class C0501a extends C0597k<C0493bf>.b<LocationClient.OnAddGeofencesResultListener> {

        /* renamed from: fO */
        private final String[] f1119fO;

        /* renamed from: p */
        private final int f1121p;

        public C0501a(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener, int i, String[] strArr) {
            super(onAddGeofencesResultListener);
            this.f1121p = LocationStatusCodes.m1927O(i);
            this.f1119fO = strArr;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4646a(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener) {
            if (onAddGeofencesResultListener != null) {
                onAddGeofencesResultListener.onAddGeofencesResult(this.f1121p, this.f1119fO);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    /* renamed from: com.google.android.gms.internal.bh$b */
    private static final class C0502b extends C0490be.C0491a {

        /* renamed from: fQ */
        private LocationClient.OnAddGeofencesResultListener f1122fQ;

        /* renamed from: fR */
        private LocationClient.OnRemoveGeofencesResultListener f1123fR;

        /* renamed from: fS */
        private C0499bh f1124fS;

        public C0502b(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener, C0499bh bhVar) {
            this.f1122fQ = onAddGeofencesResultListener;
            this.f1123fR = null;
            this.f1124fS = bhVar;
        }

        public C0502b(LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, C0499bh bhVar) {
            this.f1123fR = onRemoveGeofencesResultListener;
            this.f1122fQ = null;
            this.f1124fS = bhVar;
        }

        public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) throws RemoteException {
            if (this.f1124fS == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            C0499bh bhVar = this.f1124fS;
            C0499bh bhVar2 = this.f1124fS;
            bhVar2.getClass();
            bhVar.mo5431a((C0597k<T>.b<?>) new C0501a(this.f1122fQ, statusCode, geofenceRequestIds));
            this.f1124fS = null;
            this.f1122fQ = null;
            this.f1123fR = null;
        }

        public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
            if (this.f1124fS == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            C0499bh bhVar = this.f1124fS;
            C0499bh bhVar2 = this.f1124fS;
            bhVar2.getClass();
            bhVar.mo5431a((C0597k<T>.b<?>) new C0504d(bhVar2, 1, this.f1123fR, statusCode, pendingIntent));
            this.f1124fS = null;
            this.f1122fQ = null;
            this.f1123fR = null;
        }

        public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
            if (this.f1124fS == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            C0499bh bhVar = this.f1124fS;
            C0499bh bhVar2 = this.f1124fS;
            bhVar2.getClass();
            bhVar.mo5431a((C0597k<T>.b<?>) new C0504d(2, this.f1123fR, statusCode, geofenceRequestIds));
            this.f1124fS = null;
            this.f1122fQ = null;
            this.f1123fR = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.bh$c */
    private final class C0503c implements C0507bk<C0493bf> {
        private C0503c() {
        }

        /* renamed from: B */
        public void mo4813B() {
            C0499bh.this.mo5429B();
        }

        /* renamed from: aS */
        public C0493bf mo4814C() {
            return (C0493bf) C0499bh.this.mo5430C();
        }
    }

    /* renamed from: com.google.android.gms.internal.bh$d */
    private final class C0504d extends C0597k<C0493bf>.b<LocationClient.OnRemoveGeofencesResultListener> {

        /* renamed from: fO */
        private final String[] f1126fO;

        /* renamed from: fT */
        private final int f1128fT;
        private final PendingIntent mPendingIntent;

        /* renamed from: p */
        private final int f1129p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0504d(C0499bh bhVar, int i, LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, PendingIntent pendingIntent) {
            super(onRemoveGeofencesResultListener);
            boolean z = true;
            C0499bh.this = bhVar;
            C0594h.m1777a(i != 1 ? false : z);
            this.f1128fT = i;
            this.f1129p = LocationStatusCodes.m1927O(i2);
            this.mPendingIntent = pendingIntent;
            this.f1126fO = null;
        }

        public C0504d(int i, LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, String[] strArr) {
            super(onRemoveGeofencesResultListener);
            C0594h.m1777a(i == 2);
            this.f1128fT = i;
            this.f1129p = LocationStatusCodes.m1927O(i2);
            this.f1126fO = strArr;
            this.mPendingIntent = null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4646a(LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener) {
            if (onRemoveGeofencesResultListener != null) {
                switch (this.f1128fT) {
                    case 1:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.f1129p, this.mPendingIntent);
                        return;
                    case 2:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.f1129p, this.f1126fO);
                        return;
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.f1128fT);
                        return;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    public C0499bh(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f1117fM = new C0496bg(context, this.f1116fG);
        this.f1118fN = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4595a(C0612p pVar, C0597k.C0601d dVar) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f1118fN);
        pVar.mo5477e(dVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), bundle);
    }

    public void addGeofences(List<C0505bi> geofences, PendingIntent pendingIntent, LocationClient.OnAddGeofencesResultListener listener) {
        mo5429B();
        C0621s.m1888b(geofences != null && geofences.size() > 0, (Object) "At least one geofence must be specified.");
        C0621s.m1887b(pendingIntent, (Object) "PendingIntent must be specified.");
        C0621s.m1887b(listener, (Object) "OnAddGeofencesResultListener not provided.");
        try {
            ((C0493bf) mo5430C()).mo4778a(geofences, pendingIntent, listener == null ? null : new C0502b(listener, this), getContext().getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo4598b() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo4601c() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public void disconnect() {
        synchronized (this.f1117fM) {
            if (isConnected()) {
                this.f1117fM.removeAllListeners();
                this.f1117fM.mo4786aR();
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.f1117fM.getLastLocation();
    }

    public void removeActivityUpdates(PendingIntent callbackIntent) {
        mo5429B();
        C0621s.m1890d(callbackIntent);
        try {
            ((C0493bf) mo5430C()).removeActivityUpdates(callbackIntent);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGeofences(PendingIntent pendingIntent, LocationClient.OnRemoveGeofencesResultListener listener) {
        mo5429B();
        C0621s.m1887b(pendingIntent, (Object) "PendingIntent must be specified.");
        C0621s.m1887b(listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        try {
            ((C0493bf) mo5430C()).mo4773a(pendingIntent, (C0490be) listener == null ? null : new C0502b(listener, this), getContext().getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGeofences(List<String> geofenceRequestIds, LocationClient.OnRemoveGeofencesResultListener listener) {
        mo5429B();
        C0621s.m1888b(geofenceRequestIds != null && geofenceRequestIds.size() > 0, (Object) "geofenceRequestIds can't be null nor empty.");
        C0621s.m1887b(listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        try {
            ((C0493bf) mo5430C()).mo4779a((String[]) geofenceRequestIds.toArray(new String[0]), (C0490be) listener == null ? null : new C0502b(listener, this), getContext().getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.f1117fM.removeLocationUpdates(callbackIntent);
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.f1117fM.removeLocationUpdates(listener);
    }

    public void requestActivityUpdates(long detectionIntervalMillis, PendingIntent callbackIntent) {
        boolean z = true;
        mo5429B();
        C0621s.m1890d(callbackIntent);
        if (detectionIntervalMillis < 0) {
            z = false;
        }
        C0621s.m1888b(z, (Object) "detectionIntervalMillis must be >= 0");
        try {
            ((C0493bf) mo5430C()).mo4771a(detectionIntervalMillis, true, callbackIntent);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.f1117fM.requestLocationUpdates(request, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener) {
        requestLocationUpdates(request, listener, (Looper) null);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        synchronized (this.f1117fM) {
            this.f1117fM.requestLocationUpdates(request, listener, looper);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public C0493bf mo4600c(IBinder iBinder) {
        return C0493bf.C0494a.m1320r(iBinder);
    }

    public void setMockLocation(Location mockLocation) {
        this.f1117fM.setMockLocation(mockLocation);
    }

    public void setMockMode(boolean isMockMode) {
        this.f1117fM.setMockMode(isMockMode);
    }
}
