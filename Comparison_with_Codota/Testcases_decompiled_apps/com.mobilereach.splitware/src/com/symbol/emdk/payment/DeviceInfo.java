package com.symbol.emdk.payment;

public class DeviceInfo {

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class ConnectionType extends Enum<ConnectionType> {
        public static final ConnectionType BLUETOOTH = null;
        public static final ConnectionType UNDEFINED = null;

        public static ConnectionType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static ConnectionType[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class DeviceType extends Enum<DeviceType> {
        public static final DeviceType PD40 = null;
        public static final DeviceType UNDEFINED = null;

        public static DeviceType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static DeviceType[] values() {
            throw new RuntimeException("stub");
        }
    }

    public String getApplicationVersion() {
        throw new RuntimeException("stub");
    }

    public ConnectionType getConnectionType() {
        throw new RuntimeException("stub");
    }

    public DeviceType getDeviceType() {
        throw new RuntimeException("stub");
    }

    public String getFirmwareVersion() {
        throw new RuntimeException("stub");
    }

    public String getFriendlyName() {
        throw new RuntimeException("stub");
    }

    public String getMacAddress() {
        throw new RuntimeException("stub");
    }

    public boolean isDefaultDevice() {
        throw new RuntimeException("stub");
    }
}
