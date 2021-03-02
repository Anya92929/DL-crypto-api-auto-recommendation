package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.query.Query;

public interface DriveApi {

    @Deprecated
    public interface ContentsResult extends Result {
        Contents getContents();
    }

    public interface DriveContentsResult extends Result {
        DriveContents getDriveContents();
    }

    public interface DriveIdResult extends Result {
        DriveId getDriveId();
    }

    public interface MetadataBufferResult extends Result {
        MetadataBuffer getMetadataBuffer();
    }

    @Deprecated
    PendingResult<Status> discardContents(GoogleApiClient googleApiClient, Contents contents);

    PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient googleApiClient, String str);

    DriveFolder getAppFolder(GoogleApiClient googleApiClient);

    DriveFile getFile(GoogleApiClient googleApiClient, DriveId driveId);

    DriveFolder getFolder(GoogleApiClient googleApiClient, DriveId driveId);

    DriveFolder getRootFolder(GoogleApiClient googleApiClient);

    @Deprecated
    PendingResult<ContentsResult> newContents(GoogleApiClient googleApiClient);

    CreateFileActivityBuilder newCreateFileActivityBuilder();

    PendingResult<DriveContentsResult> newDriveContents(GoogleApiClient googleApiClient);

    OpenFileActivityBuilder newOpenFileActivityBuilder();

    PendingResult<MetadataBufferResult> query(GoogleApiClient googleApiClient, Query query);

    PendingResult<Status> requestSync(GoogleApiClient googleApiClient);
}
