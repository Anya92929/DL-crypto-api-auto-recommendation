package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.drive.internal.C0423h;
import com.google.android.gms.drive.internal.C0457r;
import com.google.android.gms.internal.C1389jy;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";

    /* renamed from: MS */
    private final C0423h f805MS = new C0423h(0);

    /* renamed from: MT */
    private DriveContents f806MT;

    public IntentSender build(GoogleApiClient apiClient) {
        C0348n.m857b(this.f806MT, (Object) "Must provide initial contents to CreateFileActivityBuilder.");
        C0348n.m859b(apiClient.mo4220a(Drive.SCOPE_FILE) || apiClient.mo4220a(Drive.f808MU), (Object) "The apiClient must have suitable scope to create files");
        C1389jy.m5221a(this.f806MT.getParcelFileDescriptor());
        this.f806MT.getContents().mo4561hJ();
        return this.f805MS.build(apiClient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.f805MS.mo5029a(folder);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String title) {
        this.f805MS.mo5031bi(title);
        return this;
    }

    @Deprecated
    public CreateFileActivityBuilder setInitialContents(Contents contents) {
        return setInitialDriveContents(new C0457r(contents));
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents driveContents) {
        if (driveContents == null) {
            throw new IllegalArgumentException("DriveContents must be provided.");
        } else if (!(driveContents instanceof C0457r)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.getContents().mo4562hK()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            this.f805MS.mo5032bk(driveContents.getContents().getRequestId());
            this.f806MT = driveContents;
            return this;
        }
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.f805MS.mo5030a(metadataChangeSet);
        return this;
    }
}
