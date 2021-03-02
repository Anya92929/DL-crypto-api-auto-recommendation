package com.SocketMobile.Bluetooth;

public interface BluetoothData {
    long allocate(int i);

    int getAvailableSize();

    int getSize();

    int getTotalSize();

    long read(byte[] bArr);

    long read(char[] cArr, int i, int i2);

    long write(byte[] bArr);

    long write(byte[] bArr, int i, int i2);

    long write(char[] cArr);
}
