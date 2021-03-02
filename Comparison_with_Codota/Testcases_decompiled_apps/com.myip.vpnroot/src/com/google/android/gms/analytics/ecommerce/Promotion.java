package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.common.internal.C0348n;
import java.util.HashMap;
import java.util.Map;

public class Promotion {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";

    /* renamed from: BK */
    Map<String, String> f171BK = new HashMap();

    /* renamed from: aq */
    public Map<String, String> mo3688aq(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f171BK.entrySet()) {
            hashMap.put(str + ((String) next.getKey()), next.getValue());
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public void put(String name, String value) {
        C0348n.m857b(name, (Object) "Name should be non-null");
        this.f171BK.put(name, value);
    }

    public Promotion setCreative(String value) {
        put("cr", value);
        return this;
    }

    public Promotion setId(String value) {
        put("id", value);
        return this;
    }

    public Promotion setName(String value) {
        put("nm", value);
        return this;
    }

    public Promotion setPosition(String value) {
        put("ps", value);
        return this;
    }
}
