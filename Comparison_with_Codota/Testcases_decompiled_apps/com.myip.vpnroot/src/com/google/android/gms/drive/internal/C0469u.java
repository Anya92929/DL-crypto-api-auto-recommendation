package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

/* renamed from: com.google.android.gms.drive.internal.u */
public class C0469u extends C0479w implements DriveFolder {

    /* renamed from: com.google.android.gms.drive.internal.u$a */
    private static class C0472a extends C0418c {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DriveFolder.DriveFileResult> f1067De;

        public C0472a(BaseImplementation.C0270b<DriveFolder.DriveFileResult> bVar) {
            this.f1067De = bVar;
        }

        /* renamed from: a */
        public void mo4894a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.f1067De.mo4196b(new C0474c(Status.f591Jo, new C0462s(onDriveIdResponse.getDriveId())));
        }

        /* renamed from: o */
        public void mo4903o(Status status) throws RemoteException {
            this.f1067De.mo4196b(new C0474c(status, (DriveFile) null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.u$b */
    private static class C0473b extends C0418c {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DriveFolder.DriveFolderResult> f1068De;

        public C0473b(BaseImplementation.C0270b<DriveFolder.DriveFolderResult> bVar) {
            this.f1068De = bVar;
        }

        /* renamed from: a */
        public void mo4894a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.f1068De.mo4196b(new C0476e(Status.f591Jo, new C0469u(onDriveIdResponse.getDriveId())));
        }

        /* renamed from: o */
        public void mo4903o(Status status) throws RemoteException {
            this.f1068De.mo4196b(new C0476e(status, (DriveFolder) null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.u$c */
    private static class C0474c implements DriveFolder.DriveFileResult {

        /* renamed from: CM */
        private final Status f1069CM;

        /* renamed from: OQ */
        private final DriveFile f1070OQ;

        public C0474c(Status status, DriveFile driveFile) {
            this.f1069CM = status;
            this.f1070OQ = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.f1070OQ;
        }

        public Status getStatus() {
            return this.f1069CM;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.u$d */
    static abstract class C0475d extends C0450p<DriveFolder.DriveFileResult> {
        C0475d() {
        }

        /* renamed from: t */
        public DriveFolder.DriveFileResult mo3773c(Status status) {
            return new C0474c(status, (DriveFile) null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.u$e */
    private static class C0476e implements DriveFolder.DriveFolderResult {

        /* renamed from: CM */
        private final Status f1071CM;

        /* renamed from: OR */
        private final DriveFolder f1072OR;

        public C0476e(Status status, DriveFolder driveFolder) {
            this.f1071CM = status;
            this.f1072OR = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.f1072OR;
        }

        public Status getStatus() {
            return this.f1071CM;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.u$f */
    static abstract class C0477f extends C0450p<DriveFolder.DriveFolderResult> {
        C0477f() {
        }

        /* renamed from: u */
        public DriveFolder.DriveFolderResult mo3773c(Status status) {
            return new C0476e(status, (DriveFolder) null);
        }
    }

    public C0469u(DriveId driveId) {
        super(driveId);
    }

    /* renamed from: a */
    private PendingResult<DriveFolder.DriveFileResult> m1326a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, Contents contents, int i, ExecutionOptions executionOptions) {
        ExecutionOptions.m960a(googleApiClient, executionOptions);
        if (contents != null) {
            contents.mo4561hJ();
        }
        final MetadataChangeSet metadataChangeSet2 = metadataChangeSet;
        final Contents contents2 = contents;
        final int i2 = i;
        final ExecutionOptions executionOptions2 = executionOptions;
        return googleApiClient.mo4221b(new C0475d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C0452q qVar) throws RemoteException {
                metadataChangeSet2.mo4681hS().setContext(qVar.getContext());
                qVar.mo5074hY().mo4867a(new CreateFileRequest(C0469u.this.getDriveId(), metadataChangeSet2.mo4681hS(), contents2 == null ? 0 : contents2.getRequestId(), i2, executionOptions2), (C0383ac) new C0472a(this));
            }
        });
    }

    /* renamed from: a */
    private PendingResult<DriveFolder.DriveFileResult> m1327a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (driveContents == null) {
            throw new IllegalArgumentException("DriveContents must be provided.");
        } else if (!(driveContents instanceof C0457r)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.getContents().mo4562hK()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        } else {
            return m1326a(googleApiClient, metadataChangeSet, driveContents.getContents(), 0, executionOptions);
        }
    }

    public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, Contents contents) {
        return createFile(apiClient, changeSet, (DriveContents) new C0457r(contents));
    }

    public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents) {
        return createFile(apiClient, changeSet, driveContents, (ExecutionOptions) null);
    }

    public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new ExecutionOptions.Builder().build();
        }
        if (executionOptions.mo4640hQ() == 0) {
            return m1327a(apiClient, changeSet, driveContents, executionOptions);
        }
        throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }

    public PendingResult<DriveFolder.DriveFolderResult> createFolder(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.mo4221b(new C0477f() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3769a(C0452q qVar) throws RemoteException {
                    changeSet.mo4681hS().setContext(qVar.getContext());
                    qVar.mo5074hY().mo4868a(new CreateFolderRequest(C0469u.this.getDriveId(), changeSet.mo4681hS()), (C0383ac) new C0473b(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<DriveApi.MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, (Query) null);
    }

    public PendingResult<DriveApi.MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        Query.Builder addFilter = new Query.Builder().addFilter(Filters.m1455in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return new C0430o().query(apiClient, addFilter.build());
    }
}
