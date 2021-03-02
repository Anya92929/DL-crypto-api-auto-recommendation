package com.flurry.android;

public final class CallbackEvent {
    public static final int ADS_LOADED_FROM_CACHE = 201;
    public static final int ADS_UPDATED = 202;
    public static final int ERROR_MARKET_LAUNCH = 101;

    /* renamed from: a */
    private int f8a;

    /* renamed from: b */
    private long f9b = System.currentTimeMillis();

    /* renamed from: c */
    private String f10c;

    CallbackEvent(int i) {
        this.f8a = i;
    }

    public final int getType() {
        return this.f8a;
    }

    public final String getMessage() {
        return this.f10c;
    }

    public final void setMessage(String str) {
        this.f10c = str;
    }

    public final long getTimestamp() {
        return this.f9b;
    }

    public final void setTimestamp(long j) {
        this.f9b = j;
    }
}
