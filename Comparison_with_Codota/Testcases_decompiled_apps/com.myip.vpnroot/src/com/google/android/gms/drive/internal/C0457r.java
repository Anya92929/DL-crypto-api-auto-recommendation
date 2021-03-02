package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C0430o;
import com.google.android.gms.drive.internal.C0450p;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.drive.internal.r */
public class C0457r implements DriveContents {
    /* access modifiers changed from: private */

    /* renamed from: Op */
    public final Contents f1041Op;

    public C0457r(Contents contents) {
        this.f1041Op = (Contents) C0348n.m861i(contents);
    }

    /* renamed from: a */
    private PendingResult<Status> m1306a(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet, final ExecutionOptions executionOptions) {
        if (this.f1041Op.getMode() == 268435456) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.m961aV(executionOptions.mo4640hQ()) || this.f1041Op.mo4563hL()) {
            ExecutionOptions.m960a(googleApiClient, executionOptions);
            if (this.f1041Op.mo4562hK()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if (metadataChangeSet == null) {
                    metadataChangeSet = MetadataChangeSet.f832Nl;
                }
                this.f1041Op.mo4561hJ();
                return googleApiClient.mo4221b(new C0450p.C0451a() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3769a(C0452q qVar) throws RemoteException {
                        metadataChangeSet.mo4681hS().setContext(qVar.getContext());
                        qVar.mo5074hY().mo4864a(new CloseContentsAndUpdateMetadataRequest(C0457r.this.f1041Op.getDriveId(), metadataChangeSet.mo4681hS(), C0457r.this.f1041Op, executionOptions), (C0383ac) new C0415bb(this));
                    }
                });
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        return m1306a(apiClient, changeSet, new ExecutionOptions.Builder().build());
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet, ExecutionOptions executionOptions) {
        return m1306a(apiClient, changeSet, executionOptions);
    }

    public void discard(GoogleApiClient apiClient) {
        if (this.f1041Op.mo4562hK()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        this.f1041Op.mo4561hJ();
        ((C04603) apiClient.mo4221b(new C0450p.C0451a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C0452q qVar) throws RemoteException {
                qVar.mo5074hY().mo4865a(new CloseContentsRequest(C0457r.this.f1041Op, false), (C0383ac) new C0415bb(this));
            }
        })).setResultCallback(new ResultCallback<Status>() {
            /* renamed from: k */
            public void onResult(Status status) {
                if (!status.isSuccess()) {
                    C0478v.m1344q("DriveContentsImpl", "Error discarding contents");
                } else {
                    C0478v.m1342n("DriveContentsImpl", "Contents discarded");
                }
            }
        });
    }

    public Contents getContents() {
        return this.f1041Op;
    }

    public DriveId getDriveId() {
        return this.f1041Op.getDriveId();
    }

    public InputStream getInputStream() {
        return this.f1041Op.getInputStream();
    }

    public int getMode() {
        return this.f1041Op.getMode();
    }

    public OutputStream getOutputStream() {
        return this.f1041Op.getOutputStream();
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.f1041Op.getParcelFileDescriptor();
    }

    public PendingResult<DriveApi.DriveContentsResult> reopenForWrite(GoogleApiClient apiClient) {
        if (this.f1041Op.mo4562hK()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.f1041Op.getMode() != 268435456) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            this.f1041Op.mo4561hJ();
            return apiClient.mo4219a(new C0430o.C0440d() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3769a(C0452q qVar) throws RemoteException {
                    qVar.mo5074hY().mo4875a(new OpenContentsRequest(C0457r.this.getDriveId(), DriveFile.MODE_WRITE_ONLY, C0457r.this.f1041Op.getRequestId()), (C0383ac) new C0408av(this, (DriveFile.DownloadProgressListener) null));
                }
            });
        }
    }
}
