package com.radiusnetworks.ibeacon;

import android.util.Log;

public class Region {
    private static final String TAG = "Region";
    protected Integer major;
    protected Integer minor;
    protected String proximityUuid;
    protected String uniqueId;

    public Region(String uniqueId2, String proximityUuid2, Integer major2, Integer minor2) {
        this.major = major2;
        this.minor = minor2;
        this.proximityUuid = normalizeProximityUuid(proximityUuid2);
        this.uniqueId = uniqueId2;
        if (uniqueId2 == null) {
            throw new NullPointerException("uniqueId may not be null");
        }
    }

    public Integer getMajor() {
        return this.major;
    }

    public Integer getMinor() {
        return this.minor;
    }

    public String getProximityUuid() {
        return this.proximityUuid;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public boolean matchesIBeacon(IBeacon iBeacon) {
        if (this.proximityUuid == null || iBeacon.getProximityUuid().equals(this.proximityUuid)) {
            if (this.major == null || iBeacon.getMajor() == this.major.intValue()) {
                if (this.minor == null || iBeacon.getMinor() == this.minor.intValue()) {
                    return true;
                }
                if (!IBeaconManager.LOG_DEBUG) {
                    return false;
                }
                Log.d(TAG, "unmatching minor: " + iBeacon.getMajor() + " != " + this.minor);
                return false;
            } else if (!IBeaconManager.LOG_DEBUG) {
                return false;
            } else {
                Log.d(TAG, "unmatching major: " + iBeacon.getMajor() + " != " + this.major);
                return false;
            }
        } else if (!IBeaconManager.LOG_DEBUG) {
            return false;
        } else {
            Log.d(TAG, "unmatching proxmityUuids: " + iBeacon.getProximityUuid() + " != " + this.proximityUuid);
            return false;
        }
    }

    protected Region(Region otherRegion) {
        this.major = otherRegion.major;
        this.minor = otherRegion.minor;
        this.proximityUuid = otherRegion.proximityUuid;
        this.uniqueId = otherRegion.uniqueId;
    }

    protected Region() {
    }

    public int hashCode() {
        return this.uniqueId.hashCode();
    }

    public boolean equals(Object other) {
        if (other instanceof Region) {
            return ((Region) other).uniqueId.equals(this.uniqueId);
        }
        return false;
    }

    public String toString() {
        return "proximityUuid: " + this.proximityUuid + " major: " + this.major + " minor:" + this.minor;
    }

    public static String normalizeProximityUuid(String proximityUuid2) {
        if (proximityUuid2 == null) {
            return null;
        }
        String dashlessUuid = proximityUuid2.toLowerCase().replaceAll("[\\-\\s]", "");
        if (dashlessUuid.length() != 32) {
            throw new RuntimeException("UUID: " + proximityUuid2 + " is too short.  Must contain exactly 32 hex digits, and there are this value has " + dashlessUuid.length() + " digits.");
        } else if (!dashlessUuid.matches("^[a-fA-F0-9]*$")) {
            throw new RuntimeException("UUID: " + proximityUuid2 + " contains invalid characters.  Must be dashes, a-f and 0-9 characters only.");
        } else {
            return dashlessUuid.substring(0, 8) + '-' + dashlessUuid.substring(8, 12) + '-' + dashlessUuid.substring(12, 16) + '-' + dashlessUuid.substring(16, 20) + '-' + dashlessUuid.substring(20, 32);
        }
    }

    public Object clone() {
        return new Region(this);
    }
}
