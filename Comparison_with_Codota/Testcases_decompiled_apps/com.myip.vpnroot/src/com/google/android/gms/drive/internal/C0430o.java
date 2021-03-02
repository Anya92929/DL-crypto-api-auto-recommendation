package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.internal.C0450p;
import com.google.android.gms.drive.query.Query;

/* renamed from: com.google.android.gms.drive.internal.o */
public class C0430o implements DriveApi {

    /* renamed from: com.google.android.gms.drive.internal.o$a */
    static class C0437a implements DriveApi.ContentsResult {

        /* renamed from: CM */
        private final Status f1006CM;

        /* renamed from: Op */
        private final Contents f1007Op;

        public C0437a(Status status, Contents contents) {
            this.f1006CM = status;
            this.f1007Op = contents;
        }

        public Contents getContents() {
            return this.f1007Op;
        }

        public Status getStatus() {
            return this.f1006CM;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$b */
    static abstract class C0438b extends C0450p<DriveApi.ContentsResult> {
        C0438b() {
        }

        /* renamed from: p */
        public DriveApi.ContentsResult mo3773c(Status status) {
            return new C0437a(status, (Contents) null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$c */
    static class C0439c implements DriveApi.DriveContentsResult {

        /* renamed from: CM */
        private final Status f1008CM;

        /* renamed from: MT */
        private final DriveContents f1009MT;

        public C0439c(Status status, DriveContents driveContents) {
            this.f1008CM = status;
            this.f1009MT = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.f1009MT;
        }

        public Status getStatus() {
            return this.f1008CM;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$d */
    static abstract class C0440d extends C0450p<DriveApi.DriveContentsResult> {
        C0440d() {
        }

        /* renamed from: q */
        public DriveApi.DriveContentsResult mo3773c(Status status) {
            return new C0439c(status, (DriveContents) null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$e */
    static class C0441e extends C0418c {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DriveApi.DriveIdResult> f1010De;

        public C0441e(BaseImplementation.C0270b<DriveApi.DriveIdResult> bVar) {
            this.f1010De = bVar;
        }

        /* renamed from: a */
        public void mo4894a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.f1010De.mo4196b(new C0442f(Status.f591Jo, onDriveIdResponse.getDriveId()));
        }

        /* renamed from: a */
        public void mo4899a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.f1010De.mo4196b(new C0442f(Status.f591Jo, new C0427l(onMetadataResponse.mo4824il()).getDriveId()));
        }

        /* renamed from: o */
        public void mo4903o(Status status) throws RemoteException {
            this.f1010De.mo4196b(new C0442f(status, (DriveId) null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$f */
    private static class C0442f implements DriveApi.DriveIdResult {

        /* renamed from: CM */
        private final Status f1011CM;

        /* renamed from: MO */
        private final DriveId f1012MO;

        public C0442f(Status status, DriveId driveId) {
            this.f1011CM = status;
            this.f1012MO = driveId;
        }

        public DriveId getDriveId() {
            return this.f1012MO;
        }

        public Status getStatus() {
            return this.f1011CM;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$g */
    static abstract class C0443g extends C0450p<DriveApi.DriveIdResult> {
        C0443g() {
        }

        /* renamed from: r */
        public DriveApi.DriveIdResult mo3773c(Status status) {
            return new C0442f(status, (DriveId) null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$h */
    static class C0444h implements DriveApi.MetadataBufferResult {

        /* renamed from: CM */
        private final Status f1013CM;

        /* renamed from: Oq */
        private final MetadataBuffer f1014Oq;

        /* renamed from: Or */
        private final boolean f1015Or;

        public C0444h(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.f1013CM = status;
            this.f1014Oq = metadataBuffer;
            this.f1015Or = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.f1014Oq;
        }

        public Status getStatus() {
            return this.f1013CM;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$i */
    static abstract class C0445i extends C0450p<DriveApi.MetadataBufferResult> {
        C0445i() {
        }

        /* renamed from: s */
        public DriveApi.MetadataBufferResult mo3773c(Status status) {
            return new C0444h(status, (MetadataBuffer) null, false);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$j */
    private static class C0446j extends C0418c {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DriveApi.ContentsResult> f1016De;

        public C0446j(BaseImplementation.C0270b<DriveApi.ContentsResult> bVar) {
            this.f1016De = bVar;
        }

        /* renamed from: a */
        public void mo4892a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.f1016De.mo4196b(new C0437a(Status.f591Jo, onContentsResponse.mo4801id()));
        }

        /* renamed from: o */
        public void mo4903o(Status status) throws RemoteException {
            this.f1016De.mo4196b(new C0437a(status, (Contents) null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$k */
    private static class C0447k extends C0418c {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DriveApi.DriveContentsResult> f1017De;

        public C0447k(BaseImplementation.C0270b<DriveApi.DriveContentsResult> bVar) {
            this.f1017De = bVar;
        }

        /* renamed from: a */
        public void mo4892a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.f1017De.mo4196b(new C0439c(Status.f591Jo, new C0457r(onContentsResponse.mo4801id())));
        }

        /* renamed from: o */
        public void mo4903o(Status status) throws RemoteException {
            this.f1017De.mo4196b(new C0439c(status, (DriveContents) null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$l */
    private static class C0448l extends C0418c {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DriveApi.MetadataBufferResult> f1018De;

        public C0448l(BaseImplementation.C0270b<DriveApi.MetadataBufferResult> bVar) {
            this.f1018De = bVar;
        }

        /* renamed from: a */
        public void mo4896a(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.f1018De.mo4196b(new C0444h(Status.f591Jo, new MetadataBuffer(onListEntriesResponse.mo4817ii(), (String) null), onListEntriesResponse.mo4818ij()));
        }

        /* renamed from: o */
        public void mo4903o(Status status) throws RemoteException {
            this.f1018De.mo4196b(new C0444h(status, (MetadataBuffer) null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$m */
    static class C0449m extends C0450p.C0451a {
        C0449m(GoogleApiClient googleApiClient, Status status) {
            mo4190a(new BaseImplementation.CallbackHandler(((C0452q) googleApiClient.mo4218a(Drive.f807CU)).getLooper()));
            mo4196b(status);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3769a(C0452q qVar) {
        }
    }

    /* renamed from: a */
    public PendingResult<DriveApi.DriveContentsResult> mo5056a(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.mo4219a(new C0440d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C0452q qVar) throws RemoteException {
                qVar.mo5074hY().mo4866a(new CreateContentsRequest(i), (C0383ac) new C0447k(this));
            }
        });
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, final Contents contents) {
        if (contents.mo4562hK()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        contents.mo4561hJ();
        return apiClient.mo4221b(new C0450p.C0451a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C0452q qVar) throws RemoteException {
                qVar.mo5074hY().mo4865a(new CloseContentsRequest(contents, false), (C0383ac) new C0415bb(this));
            }
        });
    }

    public PendingResult<DriveApi.DriveIdResult> fetchDriveId(GoogleApiClient apiClient, final String resourceId) {
        return apiClient.mo4219a(new C0443g() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C0452q qVar) throws RemoteException {
                qVar.mo5074hY().mo4872a(new GetMetadataRequest(DriveId.m957bg(resourceId)), (C0383ac) new C0441e(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (!apiClient.isConnected()) {
            throw new IllegalStateException("Client must be connected");
        }
        DriveId ia = ((C0452q) apiClient.mo4218a(Drive.f807CU)).mo5076ia();
        if (ia != null) {
            return new C0469u(ia);
        }
        return null;
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C0462s(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C0469u(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new C0469u(((C0452q) apiClient.mo4218a(Drive.f807CU)).mo5075hZ());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public PendingResult<DriveApi.ContentsResult> newContents(GoogleApiClient apiClient) {
        return apiClient.mo4219a(new C0438b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C0452q qVar) throws RemoteException {
                qVar.mo5074hY().mo4866a(new CreateContentsRequest(DriveFile.MODE_WRITE_ONLY), (C0383ac) new C0446j(this));
            }
        });
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveApi.DriveContentsResult> newDriveContents(GoogleApiClient apiClient) {
        return mo5056a(apiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<DriveApi.MetadataBufferResult> query(GoogleApiClient apiClient, final Query query) {
        if (query != null) {
            return apiClient.mo4219a(new C0445i() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3769a(C0452q qVar) throws RemoteException {
                    qVar.mo5074hY().mo4876a(new QueryRequest(query), (C0383ac) new C0448l(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient apiClient) {
        return apiClient.mo4221b(new C0450p.C0451a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C0452q qVar) throws RemoteException {
                qVar.mo5074hY().mo4882a((C0383ac) new C0415bb(this));
            }
        });
    }
}
