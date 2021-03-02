package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.lu */
public class C1527lu implements GeofencingApi {

    /* renamed from: com.google.android.gms.internal.lu$a */
    private static abstract class C1534a extends LocationServices.C1752a<Status> {
        private C1534a() {
        }

        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    public PendingResult<Status> addGeofences(GoogleApiClient client, List<Geofence> geofences, final PendingIntent pendingIntent) {
        final ArrayList arrayList;
        if (geofences != null) {
            ArrayList arrayList2 = new ArrayList(geofences.size());
            for (Geofence next : geofences) {
                C0348n.m859b(next instanceof C1553mb, (Object) "Geofence must be created using Geofence.Builder.");
                arrayList2.add((C1553mb) next);
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return client.mo4221b(new C1534a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1544ly lyVar) throws RemoteException {
                lyVar.addGeofences(arrayList, pendingIntent, new LocationClient.OnAddGeofencesResultListener() {
                    public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) {
                        C15281.this.mo4196b(LocationStatusCodes.m6248ef(statusCode));
                    }
                });
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final PendingIntent pendingIntent) {
        return client.mo4221b(new C1534a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1544ly lyVar) throws RemoteException {
                lyVar.removeGeofences(pendingIntent, (LocationClient.OnRemoveGeofencesResultListener) new LocationClient.OnRemoveGeofencesResultListener() {
                    public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
                        C15302.this.mo4196b(LocationStatusCodes.m6248ef(statusCode));
                    }

                    public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
                        Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
                    }
                });
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final List<String> geofenceRequestIds) {
        return client.mo4221b(new C1534a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1544ly lyVar) throws RemoteException {
                lyVar.removeGeofences((List<String>) geofenceRequestIds, (LocationClient.OnRemoveGeofencesResultListener) new LocationClient.OnRemoveGeofencesResultListener() {
                    public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
                        Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
                    }

                    public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
                        C15323.this.mo4196b(LocationStatusCodes.m6248ef(statusCode));
                    }
                });
            }
        });
    }
}
