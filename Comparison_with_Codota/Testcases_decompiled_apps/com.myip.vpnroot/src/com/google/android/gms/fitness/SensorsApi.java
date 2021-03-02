package com.google.android.gms.fitness;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.DataSourceListener;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

public interface SensorsApi {
    PendingResult<DataSourcesResult> findDataSources(GoogleApiClient googleApiClient, DataSourcesRequest dataSourcesRequest);

    PendingResult<Status> register(GoogleApiClient googleApiClient, SensorRequest sensorRequest, PendingIntent pendingIntent);

    PendingResult<Status> register(GoogleApiClient googleApiClient, SensorRequest sensorRequest, DataSourceListener dataSourceListener);

    PendingResult<Status> unregister(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> unregister(GoogleApiClient googleApiClient, DataSourceListener dataSourceListener);
}
