package com.google.analytics.tracking.android;

class Hit {
    private final long mHitId;
    private String mHitString;
    private final long mHitTime;
    private String mHitUrl;

    /* access modifiers changed from: package-private */
    public String getHitParams() {
        return this.mHitString;
    }

    /* access modifiers changed from: package-private */
    public void setHitString(String hitString) {
        this.mHitString = hitString;
    }

    /* access modifiers changed from: package-private */
    public long getHitId() {
        return this.mHitId;
    }

    /* access modifiers changed from: package-private */
    public long getHitTime() {
        return this.mHitTime;
    }

    Hit(String hitString, long hitId, long hitTime) {
        this.mHitString = hitString;
        this.mHitId = hitId;
        this.mHitTime = hitTime;
    }

    /* access modifiers changed from: package-private */
    public String getHitUrl() {
        return this.mHitUrl;
    }

    /* access modifiers changed from: package-private */
    public void setHitUrl(String hitUrl) {
        this.mHitUrl = hitUrl;
    }
}
