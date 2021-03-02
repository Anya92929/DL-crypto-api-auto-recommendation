package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {

    /* renamed from: a */
    private final HashMap f4144a = new HashMap();

    public Object getExtra(String str) {
        return this.f4144a.get(str);
    }

    public void setExtra(String str, Object obj) {
        this.f4144a.put(str, obj);
    }
}
