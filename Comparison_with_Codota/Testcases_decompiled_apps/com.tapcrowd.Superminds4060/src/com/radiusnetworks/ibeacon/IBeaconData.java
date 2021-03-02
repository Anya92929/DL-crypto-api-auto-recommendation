package com.radiusnetworks.ibeacon;

public interface IBeaconData {
    String get(String str);

    Double getLatitude();

    Double getLongitude();

    boolean isDirty();

    void set(String str, String str2);

    void setLatitude(Double d);

    void setLongitude(Double d);

    void sync(IBeaconDataNotifier iBeaconDataNotifier);
}
