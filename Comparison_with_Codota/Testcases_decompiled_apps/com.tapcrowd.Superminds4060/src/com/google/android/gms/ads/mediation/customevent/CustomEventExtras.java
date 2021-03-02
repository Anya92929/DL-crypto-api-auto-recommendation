package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

public final class CustomEventExtras implements NetworkExtras {

    /* renamed from: in */
    private final HashMap<String, Object> f327in = new HashMap<>();

    public Object getExtra(String label) {
        return this.f327in.get(label);
    }

    public void setExtra(String label, Object value) {
        this.f327in.put(label, value);
    }
}
