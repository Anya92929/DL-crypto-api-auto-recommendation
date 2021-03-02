package com.radiusnetworks.ibeacon.service;

import com.radiusnetworks.ibeacon.IBeacon;
import java.util.HashSet;
import java.util.Set;

public class RangeState {
    private Callback callback;
    private Set<IBeacon> iBeacons = new HashSet();

    public RangeState(Callback c) {
        this.callback = c;
    }

    public Callback getCallback() {
        return this.callback;
    }

    public void clearIBeacons() {
        this.iBeacons.clear();
    }

    public Set<IBeacon> getIBeacons() {
        return this.iBeacons;
    }

    public void addIBeacon(IBeacon iBeacon) {
        this.iBeacons.add(iBeacon);
    }
}
