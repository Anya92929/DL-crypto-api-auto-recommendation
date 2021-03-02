package com.SocketMobile.ScanAPICore;

final class SktHardwareNotificationTypes {
    public static final int kSktMaxDeviceName = 256;

    interface ENotification {
        public static final int kSktArrival = 1;
        public static final int kSktNone = 0;
        public static final int kSktRemoval = 2;
    }

    interface ETransportType {
        public static final int kSktTransportTypeHid = 1;
        public static final int kSktTransportTypeSerial = 2;
        public static final int kSktTransportTypeUnknown = 0;
    }

    public static class TSktHardware {
        int Notification;
        int TransportType;
        String pszDeviceName;
    }

    SktHardwareNotificationTypes() {
    }
}
