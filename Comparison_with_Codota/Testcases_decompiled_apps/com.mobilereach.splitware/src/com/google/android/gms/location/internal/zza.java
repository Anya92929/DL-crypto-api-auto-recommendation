package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionApi;

public class zza implements ActivityRecognitionApi {

    /* renamed from: com.google.android.gms.location.internal.zza$zza  reason: collision with other inner class name */
    private static abstract class C0449zza extends ActivityRecognition.zza<Status> {
        public C0449zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.zzb(new C0449zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzl zzl) throws RemoteException {
                zzl.zza(callbackIntent);
                zza(Status.zzagC);
            }
        });
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient client, long detectionIntervalMillis, PendingIntent callbackIntent) {
        final long j = detectionIntervalMillis;
        final PendingIntent pendingIntent = callbackIntent;
        return client.zzb(new C0449zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzl zzl) throws RemoteException {
                zzl.zza(j, pendingIntent);
                zza(Status.zzagC);
            }
        });
    }
}
