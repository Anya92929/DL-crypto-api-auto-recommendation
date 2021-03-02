package com.SocketMobile.ScanAPI;

public class SktScanDeviceType {
    public static final int kSktScanDeviceTypeBtUnknown = (SKTINTERFACETYPE(3) | SKTPRODUCTID(7));
    public static final int kSktScanDeviceTypeNone = (SKTINTERFACETYPE(0) | SKTPRODUCTID(0));
    public static final int kSktScanDeviceTypeScanner7 = (SKTINTERFACETYPE(3) | SKTPRODUCTID(1));
    public static final int kSktScanDeviceTypeScanner7x = (SKTINTERFACETYPE(3) | SKTPRODUCTID(2));
    public static final int kSktScanDeviceTypeScanner7xi = (SKTINTERFACETYPE(3) | SKTPRODUCTID(4));
    public static final int kSktScanDeviceTypeScanner8ci = (SKTINTERFACETYPE(3) | SKTPRODUCTID(6));
    public static final int kSktScanDeviceTypeScanner9 = (SKTINTERFACETYPE(3) | SKTPRODUCTID(3));
    public static final int kSktScanDeviceTypeSoftScan = (SKTINTERFACETYPE(0) | SKTPRODUCTID(5));

    public interface DeviceInterfaceType {
        public static final int kSktScanDeviceTypeInterfaceBluetooth = 3;
        public static final int kSktScanDeviceTypeInterfaceCF = 2;
        public static final int kSktScanDeviceTypeInterfaceNone = 0;
        public static final int kSktScanDeviceTypeInterfaceSD = 1;
        public static final int kSktScanDeviceTypeInterfaceSerial = 4;
    }

    interface DeviceProductID {
        public static final int kSktScanDeviceTypeProductId7 = 1;
        public static final int kSktScanDeviceTypeProductId7x = 2;
        public static final int kSktScanDeviceTypeProductId7xi = 4;
        public static final int kSktScanDeviceTypeProductId8ci = 6;
        public static final int kSktScanDeviceTypeProductId9 = 3;
        public static final int kSktScanDeviceTypeProductIdNone = 0;
        public static final int kSktScanDeviceTypeProductIdSoftScan = 5;
        public static final int kSktScanDeviceTypeUnknown = 7;
    }

    public static final int SKTINTERFACETYPE(int interfaceType) {
        return interfaceType << 16;
    }

    public static final int SKTRETRIEVE_INTERFACETYPE(int deviceType) {
        return (deviceType >> 16) & 255;
    }

    public static final int SKTPRODUCTID(int productId) {
        return productId;
    }

    public static final int SKTRETRIEVE_PRODUCTID(int deviceType) {
        return deviceType & 255;
    }
}
