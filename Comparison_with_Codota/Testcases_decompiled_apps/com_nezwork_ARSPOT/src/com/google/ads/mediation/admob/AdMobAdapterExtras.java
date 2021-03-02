package com.google.ads.mediation.admob;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;
import java.util.Map;

public class AdMobAdapterExtras implements NetworkExtras {
    private boolean a;
    private boolean b;
    private Map<String, Object> c;

    public AdMobAdapterExtras() {
        this.a = false;
        this.b = false;
        clearExtras();
    }

    public AdMobAdapterExtras(AdMobAdapterExtras original) {
        this();
        if (original != null) {
            this.a = original.a;
            this.b = original.b;
            this.c.putAll(original.c);
        }
    }

    public AdMobAdapterExtras setPlusOneOptOut(boolean plusOneOptOut) {
        this.a = plusOneOptOut;
        return this;
    }

    public boolean getPlusOneOptOut() {
        return this.a;
    }

    public AdMobAdapterExtras setUseExactAdSize(boolean useExactAdSize) {
        this.b = useExactAdSize;
        return this;
    }

    public boolean getUseExactAdSize() {
        return this.b;
    }

    public Map<String, Object> getExtras() {
        return this.c;
    }

    public AdMobAdapterExtras setExtras(Map<String, Object> extras) {
        if (extras == null) {
            throw new IllegalArgumentException("Argument 'extras' may not be null");
        }
        this.c = extras;
        return this;
    }

    public AdMobAdapterExtras clearExtras() {
        this.c = new HashMap();
        return this;
    }

    public AdMobAdapterExtras addExtra(String key, Object value) {
        this.c.put(key, value);
        return this;
    }
}
