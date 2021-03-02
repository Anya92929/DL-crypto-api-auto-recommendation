package com.google.android.gms.fitness.request;

import com.google.android.gms.fitness.data.DataPoint;

public interface DataSourceListener {
    void onEvent(DataPoint dataPoint);
}
