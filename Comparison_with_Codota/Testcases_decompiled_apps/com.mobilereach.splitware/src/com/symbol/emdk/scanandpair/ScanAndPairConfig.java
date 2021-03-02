package com.symbol.emdk.scanandpair;

public class ScanAndPairConfig {
    public Boolean alwaysScan;
    public BluetoothInfo bluetoothInfo;
    public NotificationType notificationType;
    public ScanInfo scanInfo;

    public static class BluetoothInfo {
        public String deviceName;
        public String macAddress;
        public String pairingPin;

        public BluetoothInfo() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class DeviceIdentifier extends Enum<DeviceIdentifier> {
        public static final DeviceIdentifier BLUETOOTH_IMAGER1 = null;
        public static final DeviceIdentifier DEFAULT = null;
        public static final DeviceIdentifier INTERNAL_CAMERA1 = null;
        public static final DeviceIdentifier INTERNAL_IMAGER1 = null;
        public static final DeviceIdentifier INTERNAL_LASER1 = null;

        public static DeviceIdentifier valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static DeviceIdentifier[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class NotificationType extends Enum<NotificationType> {
        public static final NotificationType BEEPER = null;
        public static final NotificationType NONE = null;

        public static NotificationType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static NotificationType[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class ScanDataType extends Enum<ScanDataType> {
        public static final ScanDataType DEVICE_NAME = null;
        public static final ScanDataType MAC_ADDRESS = null;
        public static final ScanDataType UNSPECIFIED = null;

        public static ScanDataType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static ScanDataType[] values() {
            throw new RuntimeException("stub");
        }
    }

    public static class ScanInfo {
        public DeviceIdentifier deviceIdentifier;
        public ScanDataType scanDataType;
        public int scanTimeout;
        public TriggerType triggerType;

        public ScanInfo() {
            throw new RuntimeException("stub");
        }

        public String getScannedData() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class TriggerType extends Enum<TriggerType> {
        public static final TriggerType HARD = null;
        public static final TriggerType SOFT = null;

        public static TriggerType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static TriggerType[] values() {
            throw new RuntimeException("stub");
        }
    }

    public void resetToDefaults() {
        throw new RuntimeException("stub");
    }
}
