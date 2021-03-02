package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {

    /* renamed from: xj */
    private final HashMap<String, Object> f55xj = new HashMap<>();

    public Object getExtra(String label) {
        return this.f55xj.get(label);
    }

    public void setExtra(String label, Object value) {
        this.f55xj.put(label, value);
    }
}
