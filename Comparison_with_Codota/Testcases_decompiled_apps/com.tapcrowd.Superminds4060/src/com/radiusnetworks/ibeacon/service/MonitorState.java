package com.radiusnetworks.ibeacon.service;

import android.util.Log;
import com.radiusnetworks.ibeacon.IBeaconManager;
import java.util.Date;

public class MonitorState {
    public static long INSIDE_EXPIRATION_MILLIS = IBeaconManager.DEFAULT_BACKGROUND_SCAN_PERIOD;
    private static final String TAG = "MonitorState";
    private Callback callback;
    private boolean inside = false;
    private long lastSeenTime = 0;

    public MonitorState(Callback c) {
        this.callback = c;
    }

    public Callback getCallback() {
        return this.callback;
    }

    public boolean markInside() {
        this.lastSeenTime = new Date().getTime();
        if (this.inside) {
            return false;
        }
        this.inside = true;
        return true;
    }

    public boolean isNewlyOutside() {
        if (!this.inside || this.lastSeenTime <= 0 || new Date().getTime() - this.lastSeenTime <= INSIDE_EXPIRATION_MILLIS) {
            return false;
        }
        this.inside = false;
        Log.d(TAG, "We are newly outside the region because the lastSeenTime of " + this.lastSeenTime + " was " + (new Date().getTime() - this.lastSeenTime) + " seconds ago, and that is over the expiration duration of  " + INSIDE_EXPIRATION_MILLIS);
        this.lastSeenTime = 0;
        return true;
    }

    public boolean isInside() {
        if (!this.inside || isNewlyOutside()) {
            return false;
        }
        return true;
    }
}
