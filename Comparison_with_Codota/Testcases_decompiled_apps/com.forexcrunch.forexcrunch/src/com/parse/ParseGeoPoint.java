package com.parse;

import android.location.Criteria;

public class ParseGeoPoint {
    static double EARTH_MEAN_RADIUS_KM = 6371.0d;
    static double EARTH_MEAN_RADIUS_MILE = 3958.8d;
    private double latitude = 0.0d;
    private double longitude = 0.0d;

    public ParseGeoPoint() {
    }

    public ParseGeoPoint(double latitude2, double longitude2) {
        setLatitude(latitude2);
        setLongitude(longitude2);
    }

    public void setLatitude(double latitude2) {
        if (latitude2 > 90.0d || latitude2 < -90.0d) {
            throw new IllegalArgumentException("Latitude must be within the range (-90.0, 90.0).");
        }
        this.latitude = latitude2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLongitude(double longitude2) {
        if (longitude2 > 180.0d || longitude2 < -180.0d) {
            throw new IllegalArgumentException("Longitude must be within the range (-180.0, 180.0).");
        }
        this.longitude = longitude2;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double distanceInRadiansTo(ParseGeoPoint point) {
        double lat1rad = this.latitude * 0.017453292519943295d;
        double long1rad = this.longitude * 0.017453292519943295d;
        double lat2rad = point.getLatitude() * 0.017453292519943295d;
        double sinDeltaLatDiv2 = Math.sin((lat1rad - lat2rad) / 2.0d);
        double sinDeltaLongDiv2 = Math.sin((long1rad - (point.getLongitude() * 0.017453292519943295d)) / 2.0d);
        return 2.0d * Math.asin(Math.sqrt(Math.min(1.0d, (sinDeltaLatDiv2 * sinDeltaLatDiv2) + (Math.cos(lat1rad) * Math.cos(lat2rad) * sinDeltaLongDiv2 * sinDeltaLongDiv2))));
    }

    public double distanceInKilometersTo(ParseGeoPoint point) {
        return distanceInRadiansTo(point) * EARTH_MEAN_RADIUS_KM;
    }

    public double distanceInMilesTo(ParseGeoPoint point) {
        return distanceInRadiansTo(point) * EARTH_MEAN_RADIUS_MILE;
    }

    public static void getCurrentLocationInBackground(long timeout, LocationCallback callback) {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(0);
        criteria.setPowerRequirement(0);
        getCurrentLocationInBackground(timeout, criteria, callback);
    }

    public static void getCurrentLocationInBackground(long timeout, Criteria criteria, LocationCallback callback) {
        Parse.callbackOnMainThreadAsync(LocationNotifier.getCurrentLocationAsync(timeout, criteria), callback);
    }
}
