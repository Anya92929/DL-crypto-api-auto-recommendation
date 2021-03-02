package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.C0430o;
import com.google.android.gms.drive.internal.C0450p;
import java.util.ArrayList;
import java.util.Set;

/* renamed from: com.google.android.gms.drive.internal.w */
public class C0479w implements DriveResource {

    /* renamed from: MO */
    protected final DriveId f1074MO;

    /* renamed from: com.google.android.gms.drive.internal.w$a */
    private static class C0484a extends C0418c {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DriveApi.MetadataBufferResult> f1081De;

        public C0484a(BaseImplementation.C0270b<DriveApi.MetadataBufferResult> bVar) {
            this.f1081De = bVar;
        }

        /* renamed from: a */
        public void mo4897a(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.f1081De.mo4196b(new C0430o.C0444h(Status.f591Jo, new MetadataBuffer(onListParentsResponse.mo4820ik(), (String) null), false));
        }

        /* renamed from: o */
        public void mo4903o(Status status) throws RemoteException {
            this.f1081De.mo4196b(new C0430o.C0444h(status, (MetadataBuffer) null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.w$b */
    private static class C0485b extends C0418c {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DriveResource.MetadataResult> f1082De;

        public C0485b(BaseImplementation.C0270b<DriveResource.MetadataResult> bVar) {
            this.f1082De = bVar;
        }

        /* renamed from: a */
        public void mo4899a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.f1082De.mo4196b(new C0486c(Status.f591Jo, new C0427l(onMetadataResponse.mo4824il())));
        }

        /* renamed from: o */
        public void mo4903o(Status status) throws RemoteException {
            this.f1082De.mo4196b(new C0486c(status, (Metadata) null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.w$c */
    private static class C0486c implements DriveResource.MetadataResult {

        /* renamed from: CM */
        private final Status f1083CM;

        /* renamed from: OV */
        private final Metadata f1084OV;

        public C0486c(Status status, Metadata metadata) {
            this.f1083CM = status;
            this.f1084OV = metadata;
        }

        public Metadata getMetadata() {
            return this.f1084OV;
        }

        public Status getStatus() {
            return this.f1083CM;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.w$d */
    private abstract class C0487d extends C0450p<DriveResource.MetadataResult> {
        private C0487d() {
        }

        /* renamed from: v */
        public DriveResource.MetadataResult mo3773c(Status status) {
            return new C0486c(status, (Metadata) null);
        }
    }

    protected C0479w(DriveId driveId) {
        this.f1074MO = driveId;
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((C0452q) apiClient.mo4218a(Drive.f807CU)).mo5071a(apiClient, this.f1074MO, 1, listener);
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, DriveEvent.Listener<ChangeEvent> listener) {
        return ((C0452q) apiClient.mo4218a(Drive.f807CU)).mo5071a(apiClient, this.f1074MO, 1, listener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient apiClient) {
        return ((C0452q) apiClient.mo4218a(Drive.f807CU)).mo5070a(apiClient, this.f1074MO, 1);
    }

    public DriveId getDriveId() {
        return this.f1074MO;
    }

    public PendingResult<DriveResource.MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return apiClient.mo4219a(new C0487d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C0452q qVar) throws RemoteException {
                qVar.mo5074hY().mo4872a(new GetMetadataRequest(C0479w.this.f1074MO), (C0383ac) new C0485b(this));
            }
        });
    }

    public PendingResult<DriveApi.MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.mo4219a(new C0430o.C0445i() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C0452q qVar) throws RemoteException {
                qVar.mo5074hY().mo4873a(new ListParentsRequest(C0479w.this.f1074MO), (C0383ac) new C0484a(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((C0452q) apiClient.mo4218a(Drive.f807CU)).mo5073b(apiClient, this.f1074MO, 1, listener);
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, DriveEvent.Listener<ChangeEvent> listener) {
        return ((C0452q) apiClient.mo4218a(Drive.f807CU)).mo5073b(apiClient, this.f1074MO, 1, listener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient apiClient) {
        return ((C0452q) apiClient.mo4218a(Drive.f807CU)).mo5072b(apiClient, this.f1074MO, 1);
    }

    public PendingResult<Status> setParents(GoogleApiClient apiClient, Set<DriveId> parentIds) {
        if (parentIds == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        } else if (parentIds.isEmpty()) {
            throw new IllegalArgumentException("ParentIds must contain at least one parent.");
        } else {
            final ArrayList arrayList = new ArrayList(parentIds);
            return apiClient.mo4221b(new C0450p.C0451a() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3769a(C0452q qVar) throws RemoteException {
                    qVar.mo5074hY().mo4879a(new SetResourceParentsRequest(C0479w.this.f1074MO, arrayList), (C0383ac) new C0415bb(this));
                }
            });
        }
    }

    public PendingResult<DriveResource.MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.mo4221b(new C0487d() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3769a(C0452q qVar) throws RemoteException {
                    changeSet.mo4681hS().setContext(qVar.getContext());
                    qVar.mo5074hY().mo4881a(new UpdateMetadataRequest(C0479w.this.f1074MO, changeSet.mo4681hS()), (C0383ac) new C0485b(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
