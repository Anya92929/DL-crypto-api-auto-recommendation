package com.radiusnetworks.ibeacon.client;

import android.util.Log;
import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RangingTracker {
    private static String TAG = "RangingTracker";
    private Map<IBeacon, RangedIBeacon> rangedIBeacons = new HashMap();

    public void addIBeacon(IBeacon iBeacon) {
        if (this.rangedIBeacons.containsKey(iBeacon)) {
            RangedIBeacon rangedIBeacon = this.rangedIBeacons.get(iBeacon);
            if (IBeaconManager.LOG_DEBUG) {
                Log.d(TAG, "adding " + iBeacon.getProximityUuid() + " to existing range for: " + rangedIBeacon.getProximityUuid());
            }
            rangedIBeacon.addRangeMeasurement(Integer.valueOf(iBeacon.getRssi()));
            return;
        }
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "adding " + iBeacon.getProximityUuid() + " to new rangedIBeacon");
        }
        this.rangedIBeacons.put(iBeacon, new RangedIBeacon(iBeacon));
    }

    public synchronized Collection<IBeacon> getIBeacons() {
        ArrayList<IBeacon> iBeacons;
        iBeacons = new ArrayList<>();
        for (RangedIBeacon rangedIBeacon : this.rangedIBeacons.values()) {
            if (!rangedIBeacon.allMeasurementsExpired()) {
                iBeacons.add(rangedIBeacon);
            }
        }
        return iBeacons;
    }
}
