package com.google.android.gms.fitness;

import android.content.Intent;
import com.google.android.gms.common.internal.safeparcel.C0355c;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class FitnessIntents {
    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final String EXTRA_STATUS = "actionStatus";
    public static final String MIME_TYPE_ACTIVITY_PREFIX = "vnd.google.fitness.activity/";
    public static final String MIME_TYPE_DATA_TYPE_PREFIX = "vnd.google.fitness.data_type/";
    public static final String MIME_TYPE_SESSION_PREFIX = "vnd.google.fitness.session/";
    public static final String STATUS_ACTIVE = "ActiveActionStatus";
    public static final String STATUS_COMPLETED = "CompletedActionStatus";

    FitnessIntents() {
    }

    public static String getActivityMimeType(int activity) {
        return MIME_TYPE_ACTIVITY_PREFIX + FitnessActivities.getName(activity);
    }

    public static DataSource getDataSource(Intent intent) {
        return (DataSource) C0355c.m942a(intent, EXTRA_DATA_SOURCE, DataSource.CREATOR);
    }

    public static String getDataTypeMimeType(DataType dataType) {
        return MIME_TYPE_DATA_TYPE_PREFIX + dataType.getName();
    }

    public static long getEndTime(Intent intent) {
        return intent.getLongExtra(EXTRA_END_TIME, -1);
    }

    public static String getSessionMimeType(int activity) {
        return MIME_TYPE_SESSION_PREFIX + FitnessActivities.getName(activity);
    }

    public static long getStartTime(Intent intent) {
        return intent.getLongExtra(EXTRA_START_TIME, -1);
    }
}
