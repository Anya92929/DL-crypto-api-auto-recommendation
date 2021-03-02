package com.SocketMobile.Bluetooth;

public class BluetoothHelperClassFactory {
    public static BluetoothHelper CreateBluetoothHelper() {
        return new BluetoothHelperCore();
    }

    public static BluetoothData CreateBluetoothData() {
        return new BluetoothDataCore();
    }
}
