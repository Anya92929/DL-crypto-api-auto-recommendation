package com.tapcrowd.tcanalytics.utils.beacon;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.actionbarsherlock.widget.ActivityChooserView;

public class BeaconReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent arg1) {
        boolean isServiceRunning = false;
        Intent intent = new Intent(context, BeaconService.class);
        Log.i("AnalyticsBeaconService", "received something");
        if (BeaconUtils.isBluetoothEnabled(context)) {
            for (ActivityManager.RunningServiceInfo service : ((ActivityManager) context.getSystemService("activity")).getRunningServices(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED)) {
                if (BeaconService.class.getName().equals(service.service.getClassName())) {
                    isServiceRunning = true;
                }
            }
            if (!isServiceRunning) {
                context.startService(intent);
            }
        }
    }
}
