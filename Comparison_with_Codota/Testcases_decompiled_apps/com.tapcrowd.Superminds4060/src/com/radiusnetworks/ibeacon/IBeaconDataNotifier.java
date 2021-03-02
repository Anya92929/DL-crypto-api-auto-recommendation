package com.radiusnetworks.ibeacon;

import com.radiusnetworks.ibeacon.client.DataProviderException;

public interface IBeaconDataNotifier {
    void iBeaconDataUpdate(IBeacon iBeacon, IBeaconData iBeaconData, DataProviderException dataProviderException);
}
