package com.radiusnetworks.ibeacon.client;

import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconDataNotifier;

public interface IBeaconDataFactory {
    void requestIBeaconData(IBeacon iBeacon, IBeaconDataNotifier iBeaconDataNotifier);
}
