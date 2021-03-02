package com.tapcrowd.tcanalytics.model;

import com.google.android.gms.location.Geofence;

public class SimpleGeofence {
    private long mExpirationDuration;
    private final String mId;
    private final double mLatitude;
    private final double mLongitude;
    private final float mRadius;
    private int mTransitionType;

    public SimpleGeofence(String geofenceId, double latitude, double longitude, float radius, long expiration, int transition) {
        this.mId = geofenceId;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mRadius = radius;
        this.mExpirationDuration = expiration;
        this.mTransitionType = transition;
    }

    public String getId() {
        return this.mId;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public float getRadius() {
        return this.mRadius;
    }

    public long getExpirationDuration() {
        return this.mExpirationDuration;
    }

    public int getTransitionType() {
        return this.mTransitionType;
    }

    public Geofence toGeofence() {
        return new Geofence.Builder().setRequestId(getId()).setTransitionTypes(this.mTransitionType).setCircularRegion(getLatitude(), getLongitude(), getRadius()).setExpirationDuration(this.mExpirationDuration).build();
    }
}
