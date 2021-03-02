package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import java.util.List;

/* renamed from: com.google.android.gms.wearable.internal.aj */
public final class C2250aj implements NodeApi {

    /* renamed from: com.google.android.gms.wearable.internal.aj$a */
    public static class C2255a implements NodeApi.GetConnectedNodesResult {

        /* renamed from: CM */
        private final Status f4673CM;
        private final List<Node> avA;

        public C2255a(Status status, List<Node> list) {
            this.f4673CM = status;
            this.avA = list;
        }

        public List<Node> getNodes() {
            return this.avA;
        }

        public Status getStatus() {
            return this.f4673CM;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.aj$b */
    public static class C2256b implements NodeApi.GetLocalNodeResult {

        /* renamed from: CM */
        private final Status f4674CM;
        private final Node avB;

        public C2256b(Status status, Node node) {
            this.f4674CM = status;
            this.avB = node;
        }

        public Node getNode() {
            return this.avB;
        }

        public Status getStatus() {
            return this.f4674CM;
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, final NodeApi.NodeListener listener) {
        return client.mo4219a(new C2288d<Status>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12446a((BaseImplementation.C0270b<Status>) this, listener);
            }

            /* renamed from: d */
            public Status mo3773c(Status status) {
                return new Status(13);
            }
        });
    }

    public PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.mo4219a(new C2288d<NodeApi.GetConnectedNodesResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12456q(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: aL */
            public NodeApi.GetConnectedNodesResult mo3773c(Status status) {
                return new C2255a(status, (List<Node>) null);
            }
        });
    }

    public PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.mo4219a(new C2288d<NodeApi.GetLocalNodeResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12455p(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: aK */
            public NodeApi.GetLocalNodeResult mo3773c(Status status) {
                return new C2256b(status, (Node) null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final NodeApi.NodeListener listener) {
        return client.mo4219a(new C2288d<Status>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12451b((BaseImplementation.C0270b<Status>) this, listener);
            }

            /* renamed from: d */
            public Status mo3773c(Status status) {
                return new Status(13);
            }
        });
    }
}
