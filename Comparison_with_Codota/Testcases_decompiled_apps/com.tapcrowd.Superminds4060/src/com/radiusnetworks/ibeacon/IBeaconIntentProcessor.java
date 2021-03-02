package com.radiusnetworks.ibeacon;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.radiusnetworks.ibeacon.service.IBeaconData;
import com.radiusnetworks.ibeacon.service.MonitoringData;
import com.radiusnetworks.ibeacon.service.RangingData;
import java.util.Collection;

public class IBeaconIntentProcessor extends IntentService {
    private static final String TAG = "IBeaconIntentProcessor";
    private boolean initialized = false;

    public IBeaconIntentProcessor() {
        super(TAG);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "got an intent to process");
        }
        MonitoringData monitoringData = null;
        RangingData rangingData = null;
        if (!(intent == null || intent.getExtras() == null)) {
            monitoringData = (MonitoringData) intent.getExtras().get("monitoringData");
            rangingData = (RangingData) intent.getExtras().get("rangingData");
        }
        if (rangingData != null) {
            if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "got ranging data");
            }
            if (rangingData.getIBeacons() == null) {
                Log.w(TAG, "Ranging data has a null iBeacons collection");
            }
            RangeNotifier notifier = IBeaconManager.getInstanceForApplication(this).getRangingNotifier();
            Collection<IBeacon> iBeacons = IBeaconData.fromIBeaconDatas(rangingData.getIBeacons());
            if (notifier != null) {
                notifier.didRangeBeaconsInRegion(iBeacons, rangingData.getRegion());
            } else if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "but ranging notifier is null, so we're dropping it.");
            }
            RangeNotifier dataNotifier = IBeaconManager.getInstanceForApplication(this).getDataRequestNotifier();
            if (dataNotifier != null) {
                dataNotifier.didRangeBeaconsInRegion(iBeacons, rangingData.getRegion());
            }
        }
        if (monitoringData != null) {
            if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "got monitoring data");
            }
            MonitorNotifier notifier2 = IBeaconManager.getInstanceForApplication(this).getMonitoringNotifier();
            if (notifier2 != null) {
                if (IBeaconManager.LOG_DEBUG) {
                    Log.d(TAG, "Calling monitoring notifier:" + notifier2);
                }
                notifier2.didDetermineStateForRegion(monitoringData.isInside() ? 1 : 0, monitoringData.getRegion());
                if (monitoringData.isInside()) {
                    notifier2.didEnterRegion(monitoringData.getRegion());
                } else {
                    notifier2.didExitRegion(monitoringData.getRegion());
                }
            }
        }
    }
}
