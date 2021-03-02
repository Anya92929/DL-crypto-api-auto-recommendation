package com.tapcrowd.tcanalytics.utils.beacon;

public class Beacon {
    private String mId;
    private String mMajor;
    private String mMinor;
    private String mUuid;
    private int proximity;

    public Beacon(String id, String uuid, String major, String minor, String proximity2) {
        this.mId = id;
        this.mUuid = uuid;
        this.mMajor = major;
        this.mMinor = minor;
        if (proximity2.equals("far")) {
            this.proximity = 3;
        } else if (proximity2.equals("immediate")) {
            this.proximity = 1;
        } else {
            this.proximity = 2;
        }
    }

    public String getUuid() {
        return this.mUuid;
    }

    public void setUuid(String mUuid2) {
        this.mUuid = mUuid2;
    }

    public String getMajor() {
        return this.mMajor;
    }

    public void setMajor(String mMajor2) {
        this.mMajor = mMajor2;
    }

    public String getMinor() {
        return this.mMinor;
    }

    public void setMinor(String mMinor2) {
        this.mMinor = mMinor2;
    }

    public String getId() {
        return this.mId;
    }

    public void setsId(String mId2) {
        this.mId = mId2;
    }
}
