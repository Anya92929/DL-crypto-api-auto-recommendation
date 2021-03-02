package com.SocketMobile.ScanAPI;

public interface ISktScanApi extends ISktScanDevice {
    public static final String SKTSCANAPI_CONFIGURATOR_GUID = "{11D47F36-BE62-4d28-9177-89F1BF3DDD4B}";

    long ReleaseScanObject(ISktScanObject iSktScanObject);

    long WaitForScanObject(ISktScanObject[] iSktScanObjectArr, long j);
}
