package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

/* renamed from: com.google.android.gms.internal.lt */
public class C1518lt implements FusedLocationProviderApi {

    /* renamed from: com.google.android.gms.internal.lt$a */
    private static abstract class C1526a extends LocationServices.C1752a<Status> {
        private C1526a() {
        }

        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.m6243e(client).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.mo4221b(new C1526a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1544ly lyVar) throws RemoteException {
                lyVar.removeLocationUpdates(callbackIntent);
                mo4196b(Status.f591Jo);
            }
        });
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationListener listener) {
        return client.mo4221b(new C1526a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1544ly lyVar) throws RemoteException {
                lyVar.removeLocationUpdates(listener);
                mo4196b(Status.f591Jo);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final PendingIntent callbackIntent) {
        return client.mo4221b(new C1526a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1544ly lyVar) throws RemoteException {
                lyVar.requestLocationUpdates(request, callbackIntent);
                mo4196b(Status.f591Jo);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener) {
        return client.mo4221b(new C1526a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1544ly lyVar) throws RemoteException {
                lyVar.requestLocationUpdates(request, listener, (Looper) null);
                mo4196b(Status.f591Jo);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener, final Looper looper) {
        return client.mo4221b(new C1526a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1544ly lyVar) throws RemoteException {
                lyVar.requestLocationUpdates(request, listener, looper);
                mo4196b(Status.f591Jo);
            }
        });
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient client, final Location mockLocation) {
        return client.mo4221b(new C1526a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1544ly lyVar) throws RemoteException {
                lyVar.setMockLocation(mockLocation);
                mo4196b(Status.f591Jo);
            }
        });
    }

    public PendingResult<Status> setMockMode(GoogleApiClient client, final boolean isMockMode) {
        return client.mo4221b(new C1526a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1544ly lyVar) throws RemoteException {
                lyVar.setMockMode(isMockMode);
                mo4196b(Status.f591Jo);
            }
        });
    }
}
