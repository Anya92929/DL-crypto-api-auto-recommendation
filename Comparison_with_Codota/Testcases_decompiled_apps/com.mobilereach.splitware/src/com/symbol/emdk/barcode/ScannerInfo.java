package com.symbol.emdk.barcode;

public class ScannerInfo {

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class ConnectionType extends Enum<ConnectionType> {
        public static final ConnectionType BLUETOOTH_SSI = null;
        public static final ConnectionType INTERNAL = null;
        public static final ConnectionType SERIAL_SSI = null;
        public static final ConnectionType UNDEFINED = null;
        public static final ConnectionType USB = null;

        public static ConnectionType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static ConnectionType[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class DecoderType extends Enum<DecoderType> {
        public static final DecoderType ONE_DIMENSIONAL = null;
        public static final DecoderType TWO_DIMENSIONAL = null;
        public static final DecoderType UNDEFINED = null;

        public static DecoderType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static DecoderType[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class DeviceType extends Enum<DeviceType> {
        public static final DeviceType CAMERA = null;
        public static final DeviceType IMAGER = null;
        public static final DeviceType LASER = null;
        public static final DeviceType UNDEFINED = null;

        public static DeviceType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static DeviceType[] values() {
            throw new RuntimeException("stub");
        }
    }

    public ConnectionType getConnectionType() {
        throw new RuntimeException("stub");
    }

    public DecoderType getDecoderType() {
        throw new RuntimeException("stub");
    }

    public DeviceType getDeviceType() {
        throw new RuntimeException("stub");
    }

    public String getFriendlyName() {
        throw new RuntimeException("stub");
    }

    public String getModelNumber() {
        throw new RuntimeException("stub");
    }

    public boolean isConnected() {
        throw new RuntimeException("stub");
    }

    public boolean isDefaultScanner() {
        throw new RuntimeException("stub");
    }
}
