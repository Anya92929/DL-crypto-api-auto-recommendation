package com.symbol.emdk.payment;

import com.symbol.emdk.EMDKBase;
import com.symbol.emdk.payment.DeviceInfo;
import java.util.ArrayList;

public class PaymentManager extends EMDKBase {

    public interface PaymentConnectionListener {
        void onConnectionChange(DeviceInfo deviceInfo, ConnectionState connectionState);
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
        public static final DeviceIdentifier DEFAULT = null;
        public static final DeviceIdentifier PD40 = null;

        public static DeviceIdentifier valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static DeviceIdentifier[] values() {
            throw new RuntimeException("stub");
        }
    }

    public void addConnectionListener(PaymentConnectionListener paymentConnectionListener, DeviceIdentifier deviceIdentifier) {
        throw new RuntimeException("stub");
    }

    public PaymentDevice getDevice(DeviceInfo deviceInfo) {
        throw new RuntimeException("stub");
    }

    public PaymentDevice getDevice(DeviceIdentifier deviceIdentifier) {
        throw new RuntimeException("stub");
    }

    public PaymentDevice getDevice(String str, boolean z) {
        throw new RuntimeException("stub");
    }

    public ArrayList<DeviceInfo> getPairedDevicesInfo(DeviceInfo.DeviceType deviceType) throws PaymentException {
        throw new RuntimeException("stub");
    }

    public ArrayList<DeviceInfo> getSupportedDevicesInfo() {
        throw new RuntimeException("stub");
    }

    public void removeConnectionListener(PaymentConnectionListener paymentConnectionListener) {
        throw new RuntimeException("stub");
    }
}
