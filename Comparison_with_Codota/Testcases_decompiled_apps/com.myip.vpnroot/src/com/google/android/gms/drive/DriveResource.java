package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.DriveEvent;
import java.util.Set;

public interface DriveResource {

    public interface MetadataResult extends Result {
        Metadata getMetadata();
    }

    PendingResult<Status> addChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener);

    @Deprecated
    PendingResult<Status> addChangeListener(GoogleApiClient googleApiClient, DriveEvent.Listener<ChangeEvent> listener);

    PendingResult<Status> addChangeSubscription(GoogleApiClient googleApiClient);

    DriveId getDriveId();

    PendingResult<MetadataResult> getMetadata(GoogleApiClient googleApiClient);

    PendingResult<DriveApi.MetadataBufferResult> listParents(GoogleApiClient googleApiClient);

    PendingResult<Status> removeChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener);

    @Deprecated
    PendingResult<Status> removeChangeListener(GoogleApiClient googleApiClient, DriveEvent.Listener<ChangeEvent> listener);

    PendingResult<Status> removeChangeSubscription(GoogleApiClient googleApiClient);

    PendingResult<Status> setParents(GoogleApiClient googleApiClient, Set<DriveId> set);

    PendingResult<MetadataResult> updateMetadata(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet);
}
