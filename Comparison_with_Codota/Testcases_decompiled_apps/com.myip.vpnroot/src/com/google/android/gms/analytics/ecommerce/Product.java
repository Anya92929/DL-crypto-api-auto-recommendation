package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.C0180n;
import com.google.android.gms.common.internal.C0348n;
import java.util.HashMap;
import java.util.Map;

public class Product {

    /* renamed from: BK */
    Map<String, String> f169BK = new HashMap();

    /* renamed from: aq */
    public Map<String, String> mo3663aq(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f169BK.entrySet()) {
            hashMap.put(str + ((String) next.getKey()), next.getValue());
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public void put(String name, String value) {
        C0348n.m857b(name, (Object) "Name should be non-null");
        this.f169BK.put(name, value);
    }

    public Product setBrand(String value) {
        put("br", value);
        return this;
    }

    public Product setCategory(String value) {
        put("ca", value);
        return this;
    }

    public Product setCouponCode(String value) {
        put("cc", value);
        return this;
    }

    public Product setCustomDimension(int index, String value) {
        put(C0180n.m204D(index), value);
        return this;
    }

    public Product setCustomMetric(int index, int value) {
        put(C0180n.m205E(index), Integer.toString(value));
        return this;
    }

    public Product setId(String value) {
        put("id", value);
        return this;
    }

    public Product setName(String value) {
        put("nm", value);
        return this;
    }

    public Product setPosition(int value) {
        put("ps", Integer.toString(value));
        return this;
    }

    public Product setPrice(double value) {
        put("pr", Double.toString(value));
        return this;
    }

    public Product setQuantity(int value) {
        put("qt", Integer.toString(value));
        return this;
    }

    public Product setVariant(String value) {
        put("va", value);
        return this;
    }
}
