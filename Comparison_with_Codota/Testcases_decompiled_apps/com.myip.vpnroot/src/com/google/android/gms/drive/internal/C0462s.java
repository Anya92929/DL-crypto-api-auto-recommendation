package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.C0282c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C0430o;

/* renamed from: com.google.android.gms.drive.internal.s */
public class C0462s extends C0479w implements DriveFile {

    /* renamed from: com.google.android.gms.drive.internal.s$a */
    private static class C0465a implements DriveFile.DownloadProgressListener {

        /* renamed from: OI */
        private final C0282c<DriveFile.DownloadProgressListener> f1054OI;

        public C0465a(C0282c<DriveFile.DownloadProgressListener> cVar) {
            this.f1054OI = cVar;
        }

        public void onProgress(long bytesDownloaded, long bytesExpected) {
            final long j = bytesDownloaded;
            final long j2 = bytesExpected;
            this.f1054OI.mo4278a(new C0282c.C0284b<DriveFile.DownloadProgressListener>() {
                /* renamed from: a */
                public void mo4282d(DriveFile.DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j, j2);
                }

                /* renamed from: gs */
                public void mo4283gs() {
                }
            });
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.s$b */
    private static class C0467b extends C0418c {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DriveApi.ContentsResult> f1058De;

        /* renamed from: OM */
        private final DriveFile.DownloadProgressListener f1059OM;

        public C0467b(BaseImplementation.C0270b<DriveApi.ContentsResult> bVar, DriveFile.DownloadProgressListener downloadProgressListener) {
            this.f1058De = bVar;
            this.f1059OM = downloadProgressListener;
        }

        /* renamed from: a */
        public void mo4892a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.f1058De.mo4196b(new C0430o.C0437a(onContentsResponse.mo4802ie() ? new Status(-1) : Status.f591Jo, onContentsResponse.mo4801id()));
        }

        /* renamed from: a */
        public void mo4893a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
            if (this.f1059OM != null) {
                this.f1059OM.onProgress(onDownloadProgressResponse.mo4805if(), onDownloadProgressResponse.mo4806ig());
            }
        }

        /* renamed from: o */
        public void mo4903o(Status status) throws RemoteException {
            this.f1058De.mo4196b(new C0430o.C0437a(status, (Contents) null));
        }
    }

    public C0462s(DriveId driveId) {
        super(driveId);
    }

    /* renamed from: a */
    private static DriveFile.DownloadProgressListener m1315a(GoogleApiClient googleApiClient, DriveFile.DownloadProgressListener downloadProgressListener) {
        if (downloadProgressListener == null) {
            return null;
        }
        return new C0465a(googleApiClient.mo4224c(downloadProgressListener));
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient client, Contents contents) {
        return new C0457r(contents).commit(client, (MetadataChangeSet) null);
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient client, Contents contents, MetadataChangeSet changeSet) {
        return new C0457r(contents).commit(client, changeSet);
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, Contents contents) {
        return Drive.DriveApi.discardContents(apiClient, contents);
    }

    public PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient apiClient, final int mode, DriveFile.DownloadProgressListener listener) {
        if (mode == 268435456 || mode == 536870912 || mode == 805306368) {
            final DriveFile.DownloadProgressListener a = m1315a(apiClient, listener);
            return apiClient.mo4219a(new C0430o.C0440d() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3769a(C0452q qVar) throws RemoteException {
                    qVar.mo5074hY().mo4875a(new OpenContentsRequest(C0462s.this.getDriveId(), mode, 0), (C0383ac) new C0408av(this, a));
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }

    public PendingResult<DriveApi.ContentsResult> openContents(GoogleApiClient apiClient, final int mode, DriveFile.DownloadProgressListener listener) {
        if (mode == 268435456 || mode == 536870912 || mode == 805306368) {
            final DriveFile.DownloadProgressListener a = m1315a(apiClient, listener);
            return apiClient.mo4219a(new C0430o.C0438b() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3769a(C0452q qVar) throws RemoteException {
                    qVar.mo5074hY().mo4875a(new OpenContentsRequest(C0462s.this.getDriveId(), mode, 0), (C0383ac) new C0467b(this, a));
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
