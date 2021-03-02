package com.tapcrowd.tcanalytics.utils.geofence;

public final class GeofenceUtils {
    public static final String ACTION_CONNECTION_ERROR = "com.example.android.geofence.ACTION_CONNECTION_ERROR";
    public static final String ACTION_CONNECTION_SUCCESS = "com.example.android.geofence.ACTION_CONNECTION_SUCCESS";
    public static final String ACTION_GEOFENCES_ADDED = "com.example.android.geofence.ACTION_GEOFENCES_ADDED";
    public static final String ACTION_GEOFENCES_REMOVED = "com.example.android.geofence.ACTION_GEOFENCES_DELETED";
    public static final String ACTION_GEOFENCE_ERROR = "com.example.android.geofence.ACTION_GEOFENCES_ERROR";
    public static final String ACTION_GEOFENCE_TRANSITION = "com.example.android.geofence.ACTION_GEOFENCE_TRANSITION";
    public static final String ACTION_GEOFENCE_TRANSITION_ERROR = "com.example.android.geofence.ACTION_GEOFENCE_TRANSITION_ERROR";
    public static final String APPTAG = "Geofence Detection";
    public static final String CATEGORY_LOCATION_SERVICES = "com.example.android.geofence.CATEGORY_LOCATION_SERVICES";
    public static final int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    public static final String EMPTY_STRING = new String();
    public static final String EXTRA_CONNECTION_CODE = "com.example.android.EXTRA_CONNECTION_CODE";
    public static final String EXTRA_CONNECTION_ERROR_CODE = "com.example.android.geofence.EXTRA_CONNECTION_ERROR_CODE";
    public static final String EXTRA_CONNECTION_ERROR_MESSAGE = "com.example.android.geofence.EXTRA_CONNECTION_ERROR_MESSAGE";
    public static final String EXTRA_GEOFENCE_STATUS = "com.example.android.geofence.EXTRA_GEOFENCE_STATUS";
    public static final CharSequence GEOFENCE_ID_DELIMITER = ",";
    public static final double MAX_LATITUDE = 90.0d;
    public static final double MAX_LONGITUDE = 180.0d;
    public static final double MIN_LATITUDE = -90.0d;
    public static final double MIN_LONGITUDE = -180.0d;
    public static final float MIN_RADIUS = 1.0f;

    public enum REMOVE_TYPE {
        INTENT,
        LIST
    }

    public enum REQUEST_TYPE {
        ADD,
        REMOVE
    }
}
