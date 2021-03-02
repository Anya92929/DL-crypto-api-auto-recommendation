package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionApi;

/* renamed from: com.google.android.gms.internal.lq */
public class C1512lq implements ActivityRecognitionApi {

    /* renamed from: com.google.android.gms.internal.lq$a */
    private static abstract class C1515a extends ActivityRecognition.C1749a<Status> {
        private C1515a() {
        }

        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.mo4221b(new C1515a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1544ly lyVar) throws RemoteException {
                lyVar.removeActivityUpdates(callbackIntent);
                mo4196b(Status.f591Jo);
            }
        });
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient client, final long detectionIntervalMillis, final PendingIntent callbackIntent) {
        return client.mo4221b(new C1515a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1544ly lyVar) throws RemoteException {
                lyVar.requestActivityUpdates(detectionIntervalMillis, callbackIntent);
                mo4196b(Status.f591Jo);
            }
        });
    }
}
