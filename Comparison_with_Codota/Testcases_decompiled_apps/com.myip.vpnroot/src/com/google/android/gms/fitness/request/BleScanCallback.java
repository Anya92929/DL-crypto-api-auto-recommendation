package com.google.android.gms.fitness.request;

import com.google.android.gms.fitness.data.BleDevice;

public interface BleScanCallback {
    void onDeviceFound(BleDevice bleDevice);

    void onScanStopped();
}
