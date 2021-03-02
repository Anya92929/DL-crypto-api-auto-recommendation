package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;

/* renamed from: com.google.android.gms.wearable.internal.ag */
public final class C2243ag implements MessageApi {

    /* renamed from: com.google.android.gms.wearable.internal.ag$a */
    public static class C2247a implements MessageApi.SendMessageResult {

        /* renamed from: CM */
        private final Status f4669CM;

        /* renamed from: uQ */
        private final int f4670uQ;

        public C2247a(Status status, int i) {
            this.f4669CM = status;
            this.f4670uQ = i;
        }

        public int getRequestId() {
            return this.f4670uQ;
        }

        public Status getStatus() {
            return this.f4669CM;
        }
    }

    /* renamed from: a */
    private PendingResult<Status> m7588a(GoogleApiClient googleApiClient, final MessageApi.MessageListener messageListener, final IntentFilter[] intentFilterArr) {
        return googleApiClient.mo4219a(new C2288d<Status>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12445a((BaseImplementation.C0270b<Status>) this, messageListener, intentFilterArr);
            }

            /* renamed from: d */
            public Status mo3773c(Status status) {
                return new Status(13);
            }
        });
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageApi.MessageListener listener) {
        return m7588a(client, listener, (IntentFilter[]) null);
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final MessageApi.MessageListener listener) {
        return client.mo4219a(new C2288d<Status>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12444a((BaseImplementation.C0270b<Status>) this, listener);
            }

            /* renamed from: d */
            public Status mo3773c(Status status) {
                return new Status(13);
            }
        });
    }

    public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient client, final String nodeId, final String action, final byte[] data) {
        return client.mo4219a(new C2288d<MessageApi.SendMessageResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12449a(this, nodeId, action, data);
            }

            /* access modifiers changed from: protected */
            /* renamed from: aJ */
            public MessageApi.SendMessageResult mo3773c(Status status) {
                return new C2247a(status, -1);
            }
        });
    }
}
