package com.symbol.emdk.barcode;

import com.symbol.emdk.EMDKBase;
import java.util.List;

public class BarcodeManager extends EMDKBase {

    public interface ScannerConnectionListener {
        void onConnectionChange(ScannerInfo scannerInfo, ConnectionState connectionState);
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class ConnectionState extends Enum<ConnectionState> {
        public static final ConnectionState CONNECTED = null;
        public static final ConnectionState DISCONNECTED = null;

        public static ConnectionState valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static ConnectionState[] values() {
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

    public void addConnectionListener(ScannerConnectionListener scannerConnectionListener) {
        throw new RuntimeException("stub");
    }

    public Scanner getDevice(DeviceIdentifier deviceIdentifier) {
        throw new RuntimeException("stub");
    }

    public Scanner getDevice(ScannerInfo scannerInfo) {
        throw new RuntimeException("stub");
    }

    public List<ScannerInfo> getSupportedDevicesInfo() {
        throw new RuntimeException("stub");
    }

    public void removeConnectionListener(ScannerConnectionListener scannerConnectionListener) {
        throw new RuntimeException("stub");
    }
}
