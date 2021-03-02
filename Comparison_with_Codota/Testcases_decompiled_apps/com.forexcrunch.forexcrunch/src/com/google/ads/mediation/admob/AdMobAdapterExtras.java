package com.google.ads.mediation.admob;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;
import java.util.Map;

public class AdMobAdapterExtras implements NetworkExtras {

    /* renamed from: a */
    private boolean f642a;

    /* renamed from: b */
    private Map<String, Object> f643b;

    public AdMobAdapterExtras() {
        this.f642a = false;
        clearExtras();
    }

    public AdMobAdapterExtras(AdMobAdapterExtras original) {
        this();
        if (original != null) {
            this.f642a = original.f642a;
            this.f643b.putAll(original.f643b);
        }
    }

    @Deprecated
    public AdMobAdapterExtras setPlusOneOptOut(boolean plusOneOptOut) {
        return this;
    }

    @Deprecated
    public boolean getPlusOneOptOut() {
        return false;
    }

    public AdMobAdapterExtras setUseExactAdSize(boolean useExactAdSize) {
        this.f642a = useExactAdSize;
        return this;
    }

    public boolean getUseExactAdSize() {
        return this.f642a;
    }

    public Map<String, Object> getExtras() {
        return this.f643b;
    }

    public AdMobAdapterExtras setExtras(Map<String, Object> extras) {
        if (extras == null) {
            throw new IllegalArgumentException("Argument 'extras' may not be null");
        }
        this.f643b = extras;
        return this;
    }

    public AdMobAdapterExtras clearExtras() {
        this.f643b = new HashMap();
        return this;
    }

    public AdMobAdapterExtras addExtra(String key, Object value) {
        this.f643b.put(key, value);
        return this;
    }
}
