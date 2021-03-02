package com.SocketMobile.ScanAPI;

public interface ISktScanEvent {

    /* renamed from: com.SocketMobile.ScanAPI.ISktScanEvent$id */
    public interface C0163id {
        public static final byte kSktScanEventBatteryLevel = 4;
        public static final byte kSktScanEventButtons = 3;
        public static final byte kSktScanEventDecodedData = 1;
        public static final byte kSktScanEventError = 0;
        public static final byte kSktScanEventLastID = 6;
        public static final byte kSktScanEventListenerStarted = 5;
        public static final byte kSktScanEventPower = 2;
    }

    public interface types {
        public static final byte kSktScanEventDataTypeArray = 3;
        public static final byte kSktScanEventDataTypeByte = 1;
        public static final byte kSktScanEventDataTypeDecodedData = 5;
        public static final byte kSktScanEventDataTypeLastID = 6;
        public static final byte kSktScanEventDataTypeNone = 0;
        public static final byte kSktScanEventDataTypeString = 4;
        public static final byte kSktScanEventDataTypeUlong = 2;
    }

    char getDataByte();

    ISktScanDecodedData getDataDecodedData();

    long getDataLong();

    String getDataString();

    int getDataType();

    int getID();
}
