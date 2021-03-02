package com.SocketMobile.ScanAPI;

public interface ISktScanMsg {
    public static final byte kSktScanMsgEvent = 6;
    public static final byte kSktScanMsgGetComplete = 5;
    public static final byte kSktScanMsgIdDeviceArrival = 1;
    public static final byte kSktScanMsgIdDeviceRemoval = 2;
    public static final byte kSktScanMsgIdNotInitialized = 0;
    public static final byte kSktScanMsgIdTerminate = 3;
    public static final byte kSktScanMsgLastID = 7;
    public static final byte kSktScanMsgSetComplete = 4;

    String getDeviceGuid();

    ISktScanDevice getDeviceInterface();

    String getDeviceName();

    long getDeviceType();

    ISktScanEvent getEvent();

    int getID();

    long getResult();
}
