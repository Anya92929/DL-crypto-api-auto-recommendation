package com.tapcrowd.tcanalytics.utils.beacon;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;

public class BeaconUtils {
    public static boolean checkAPILevel() {
        if (Build.VERSION.SDK_INT >= 18) {
            return true;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static boolean isBLEAvailable(Context context) {
        if (!context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return false;
        }
        return true;
    }

    public static boolean isBluetoothEnabled(Context context) {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return mBluetoothAdapter != null && mBluetoothAdapter.isEnabled();
    }
}
