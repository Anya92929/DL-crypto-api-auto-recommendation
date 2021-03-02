package com.tapcrowd.app.utils;

public class TCListSeparator {
    private boolean isPremium;

    /* renamed from: s */
    private String f2135s;

    public TCListSeparator(String s) {
        this(s, false);
    }

    public TCListSeparator(String s, boolean isPremium2) {
        this.f2135s = s;
        this.isPremium = isPremium2;
    }

    public String getS() {
        return this.f2135s;
    }

    public boolean isPremium() {
        return this.isPremium;
    }

    public String toString() {
        return this.f2135s;
    }
}
