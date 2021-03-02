package com.parse;

public abstract class LocationCallback extends ParseCallback<ParseGeoPoint> {
    public abstract void done(ParseGeoPoint parseGeoPoint, ParseException parseException);

    /* access modifiers changed from: package-private */
    public final void internalDone(ParseGeoPoint geoPoint, ParseException e) {
        done(geoPoint, e);
    }
}
