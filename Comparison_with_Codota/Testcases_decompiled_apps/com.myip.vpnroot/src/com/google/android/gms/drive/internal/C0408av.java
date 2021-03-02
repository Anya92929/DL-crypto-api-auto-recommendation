package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.internal.C0430o;

/* renamed from: com.google.android.gms.drive.internal.av */
class C0408av extends C0418c {

    /* renamed from: De */
    private final BaseImplementation.C0270b<DriveApi.DriveContentsResult> f987De;

    /* renamed from: OM */
    private final DriveFile.DownloadProgressListener f988OM;

    C0408av(BaseImplementation.C0270b<DriveApi.DriveContentsResult> bVar, DriveFile.DownloadProgressListener downloadProgressListener) {
        this.f987De = bVar;
        this.f988OM = downloadProgressListener;
    }

    /* renamed from: a */
    public void mo4892a(OnContentsResponse onContentsResponse) throws RemoteException {
        this.f987De.mo4196b(new C0430o.C0439c(onContentsResponse.mo4802ie() ? new Status(-1) : Status.f591Jo, new C0457r(onContentsResponse.mo4801id())));
    }

    /* renamed from: a */
    public void mo4893a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
        if (this.f988OM != null) {
            this.f988OM.onProgress(onDownloadProgressResponse.mo4805if(), onDownloadProgressResponse.mo4806ig());
        }
    }

    /* renamed from: o */
    public void mo4903o(Status status) throws RemoteException {
        this.f987De.mo4196b(new C0430o.C0439c(status, (DriveContents) null));
    }
}
