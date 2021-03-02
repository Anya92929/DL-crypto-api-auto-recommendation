package com.SocketMobile.ScanAPI;

import com.SocketMobile.ScanAPICore.SktScanCore;
import com.SocketMobile.ScanAPICore.TSktScanObject;

public final class SktClassFactory {
    public static ISktScanApi createScanApiInstance() {
        return new SktScanCore();
    }

    public static ISktScanDevice createDeviceInstance(ISktScanApi scanApi) {
        return new SktScanCore(scanApi);
    }

    public static ISktScanObject createScanObject() {
        return new TSktScanObject();
    }
}
