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
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.C0313a;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.internal.C1535lv;
import com.google.android.gms.internal.C1538lw;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ly */
public class C1544ly extends C0316d<C1538lw> {

    /* renamed from: Dh */
    private final C1555md<C1538lw> f4275Dh;
    private final C1541lx aeL;
    private final C1575mv aeM;
    private final C1510lo aeN;
    private final C1312ie aeO;
    private final String aeP;

    /* renamed from: com.google.android.gms.internal.ly$a */
    private final class C1546a extends C0316d<C1538lw>.b<LocationClient.OnAddGeofencesResultListener> {

        /* renamed from: HF */
        private final int f4276HF;
        private final String[] aeQ;

        public C1546a(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener, int i, String[] strArr) {
            super(onAddGeofencesResultListener);
            this.f4276HF = LocationStatusCodes.m6247ee(i);
            this.aeQ = strArr;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4449g(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener) {
            if (onAddGeofencesResultListener != null) {
                onAddGeofencesResultListener.onAddGeofencesResult(this.f4276HF, this.aeQ);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    /* renamed from: com.google.android.gms.internal.ly$b */
    private static final class C1547b extends C1535lv.C1536a {
        private LocationClient.OnAddGeofencesResultListener aeS;
        private LocationClient.OnRemoveGeofencesResultListener aeT;
        private C1544ly aeU;

        public C1547b(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener, C1544ly lyVar) {
            this.aeS = onAddGeofencesResultListener;
            this.aeT = null;
            this.aeU = lyVar;
        }

        public C1547b(LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, C1544ly lyVar) {
            this.aeT = onRemoveGeofencesResultListener;
            this.aeS = null;
            this.aeU = lyVar;
        }

        public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) throws RemoteException {
            if (this.aeU == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            C1544ly lyVar = this.aeU;
            C1544ly lyVar2 = this.aeU;
            lyVar2.getClass();
            lyVar.mo4430a((C0316d<T>.b<?>) new C1546a(this.aeS, statusCode, geofenceRequestIds));
            this.aeU = null;
            this.aeS = null;
            this.aeT = null;
        }

        public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
            if (this.aeU == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            C1544ly lyVar = this.aeU;
            C1544ly lyVar2 = this.aeU;
            lyVar2.getClass();
            lyVar.mo4430a((C0316d<T>.b<?>) new C1549d(lyVar2, 1, this.aeT, statusCode, pendingIntent));
            this.aeU = null;
            this.aeS = null;
            this.aeT = null;
        }

        public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
            if (this.aeU == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            C1544ly lyVar = this.aeU;
            C1544ly lyVar2 = this.aeU;
            lyVar2.getClass();
            lyVar.mo4430a((C0316d<T>.b<?>) new C1549d(2, this.aeT, statusCode, geofenceRequestIds));
            this.aeU = null;
            this.aeS = null;
            this.aeT = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.ly$c */
    private final class C1548c implements C1555md<C1538lw> {
        private C1548c() {
        }

        /* renamed from: dK */
        public void mo9349dK() {
            C1544ly.this.mo4433dK();
        }

        /* renamed from: lX */
        public C1538lw mo9350gS() {
            return (C1538lw) C1544ly.this.mo4435gS();
        }
    }

    /* renamed from: com.google.android.gms.internal.ly$d */
    private final class C1549d extends C0316d<C1538lw>.b<LocationClient.OnRemoveGeofencesResultListener> {

        /* renamed from: HF */
        private final int f4277HF;
        private final String[] aeQ;
        private final int aeV;
        private final PendingIntent mPendingIntent;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1549d(C1544ly lyVar, int i, LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, PendingIntent pendingIntent) {
            super(onRemoveGeofencesResultListener);
            boolean z = true;
            C1544ly.this = lyVar;
            C0313a.m678I(i != 1 ? false : z);
            this.aeV = i;
            this.f4277HF = LocationStatusCodes.m6247ee(i2);
            this.mPendingIntent = pendingIntent;
            this.aeQ = null;
        }

        public C1549d(int i, LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, String[] strArr) {
            super(onRemoveGeofencesResultListener);
            C0313a.m678I(i == 2);
            this.aeV = i;
            this.f4277HF = LocationStatusCodes.m6247ee(i2);
            this.aeQ = strArr;
            this.mPendingIntent = null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4449g(LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener) {
            if (onRemoveGeofencesResultListener != null) {
                switch (this.aeV) {
                    case 1:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.f4277HF, this.mPendingIntent);
                        return;
                    case 2:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.f4277HF, this.aeQ);
                        return;
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.aeV);
                        return;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    public C1544ly(Context context, Looper looper, String str, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str2) {
        this(context, looper, str, connectionCallbacks, onConnectionFailedListener, str2, (String) null);
    }

    public C1544ly(Context context, Looper looper, String str, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str2, String str3) {
        this(context, looper, str, connectionCallbacks, onConnectionFailedListener, str2, str3, (String) null);
    }

    public C1544ly(Context context, Looper looper, String str, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str2, String str3, String str4) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f4275Dh = new C1548c();
        this.aeL = new C1541lx(context, this.f4275Dh);
        this.aeP = str2;
        this.aeM = new C1575mv(str, this.f4275Dh, str3);
        this.aeN = C1510lo.m5456a(context, str3, str4, this.f4275Dh);
        this.aeO = C1312ie.m4913a(context, this.f4275Dh);
    }

    public C1544ly(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f4275Dh = new C1548c();
        this.aeL = new C1541lx(context, this.f4275Dh);
        this.aeP = str;
        this.aeM = new C1575mv(context.getPackageName(), this.f4275Dh, (String) null);
        this.aeN = C1510lo.m5456a(context, (String) null, (String) null, this.f4275Dh);
        this.aeO = C1312ie.m4913a(context, this.f4275Dh);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.aeP);
        kVar.mo4522e(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), bundle);
    }

    /* renamed from: a */
    public void mo9332a(C1550lz lzVar, LocationListener locationListener) throws RemoteException {
        mo9333a(lzVar, locationListener, (Looper) null);
    }

    /* renamed from: a */
    public void mo9333a(C1550lz lzVar, LocationListener locationListener, Looper looper) throws RemoteException {
        synchronized (this.aeL) {
            this.aeL.mo9318a(lzVar, locationListener, looper);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: aL */
    public C1538lw mo3832j(IBinder iBinder) {
        return C1538lw.C1539a.m5523aK(iBinder);
    }

    public void addGeofences(List<C1553mb> geofences, PendingIntent pendingIntent, LocationClient.OnAddGeofencesResultListener listener) throws RemoteException {
        mo4433dK();
        C0348n.m859b(geofences != null && geofences.size() > 0, (Object) "At least one geofence must be specified.");
        C0348n.m857b(pendingIntent, (Object) "PendingIntent must be specified.");
        C0348n.m857b(listener, (Object) "OnAddGeofencesResultListener not provided.");
        ((C1538lw) mo4435gS()).mo9304a(geofences, pendingIntent, (C1535lv) listener == null ? null : new C1547b(listener, this), getContext().getPackageName());
    }

    /* renamed from: b */
    public void mo9336b(C1550lz lzVar, PendingIntent pendingIntent) throws RemoteException {
        this.aeL.mo9319b(lzVar, pendingIntent);
    }

    public void disconnect() {
        synchronized (this.aeL) {
            if (isConnected()) {
                this.aeL.removeAllListeners();
                this.aeL.mo9321lW();
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.aeL.getLastLocation();
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    public void removeActivityUpdates(PendingIntent callbackIntent) throws RemoteException {
        mo4433dK();
        C0348n.m861i(callbackIntent);
        ((C1538lw) mo4435gS()).removeActivityUpdates(callbackIntent);
    }

    public void removeGeofences(PendingIntent pendingIntent, LocationClient.OnRemoveGeofencesResultListener listener) throws RemoteException {
        mo4433dK();
        C0348n.m857b(pendingIntent, (Object) "PendingIntent must be specified.");
        C0348n.m857b(listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        ((C1538lw) mo4435gS()).mo9283a(pendingIntent, (C1535lv) listener == null ? null : new C1547b(listener, this), getContext().getPackageName());
    }

    public void removeGeofences(List<String> geofenceRequestIds, LocationClient.OnRemoveGeofencesResultListener listener) throws RemoteException {
        mo4433dK();
        C0348n.m859b(geofenceRequestIds != null && geofenceRequestIds.size() > 0, (Object) "geofenceRequestIds can't be null nor empty.");
        C0348n.m857b(listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        ((C1538lw) mo4435gS()).mo9305a((String[]) geofenceRequestIds.toArray(new String[0]), (C1535lv) listener == null ? null : new C1547b(listener, this), getContext().getPackageName());
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) throws RemoteException {
        this.aeL.removeLocationUpdates(callbackIntent);
    }

    public void removeLocationUpdates(LocationListener listener) throws RemoteException {
        this.aeL.removeLocationUpdates(listener);
    }

    public void requestActivityUpdates(long detectionIntervalMillis, PendingIntent callbackIntent) throws RemoteException {
        mo4433dK();
        C0348n.m861i(callbackIntent);
        C0348n.m859b(detectionIntervalMillis >= 0, (Object) "detectionIntervalMillis must be >= 0");
        ((C1538lw) mo4435gS()).mo9281a(detectionIntervalMillis, true, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) throws RemoteException {
        this.aeL.requestLocationUpdates(request, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) throws RemoteException {
        synchronized (this.aeL) {
            this.aeL.requestLocationUpdates(request, listener, looper);
        }
    }

    public void setMockLocation(Location mockLocation) throws RemoteException {
        this.aeL.setMockLocation(mockLocation);
    }

    public void setMockMode(boolean isMockMode) throws RemoteException {
        this.aeL.setMockMode(isMockMode);
    }
}
