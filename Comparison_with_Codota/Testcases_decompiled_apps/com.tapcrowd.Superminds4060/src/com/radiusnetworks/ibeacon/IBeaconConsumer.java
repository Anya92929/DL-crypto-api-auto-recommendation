package com.radiusnetworks.ibeacon;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public interface IBeaconConsumer {
    boolean bindService(Intent intent, ServiceConnection serviceConnection, int i);

    Context getApplicationContext();

    void onIBeaconServiceConnect();

    void unbindService(ServiceConnection serviceConnection);
}
