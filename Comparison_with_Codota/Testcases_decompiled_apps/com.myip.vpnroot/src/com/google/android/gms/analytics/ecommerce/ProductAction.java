package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.common.internal.C0348n;
import java.util.HashMap;
import java.util.Map;

public class ProductAction {
    public static final String ACTION_ADD = "add";
    public static final String ACTION_CHECKOUT = "checkout";
    public static final String ACTION_CHECKOUT_OPTION = "checkout_option";
    @Deprecated
    public static final String ACTION_CHECKOUT_OPTIONS = "checkout_options";
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_DETAIL = "detail";
    public static final String ACTION_PURCHASE = "purchase";
    public static final String ACTION_REFUND = "refund";
    public static final String ACTION_REMOVE = "remove";

    /* renamed from: BK */
    Map<String, String> f170BK = new HashMap();

    public ProductAction(String action) {
        put("&pa", action);
    }

    public Map<String, String> build() {
        return new HashMap(this.f170BK);
    }

    /* access modifiers changed from: package-private */
    public void put(String name, String value) {
        C0348n.m857b(name, (Object) "Name should be non-null");
        this.f170BK.put(name, value);
    }

    public ProductAction setCheckoutOptions(String value) {
        put("&col", value);
        return this;
    }

    public ProductAction setCheckoutStep(int value) {
        put("&cos", Integer.toString(value));
        return this;
    }

    public ProductAction setProductActionList(String value) {
        put("&pal", value);
        return this;
    }

    public ProductAction setProductListSource(String value) {
        put("&pls", value);
        return this;
    }

    public ProductAction setTransactionAffiliation(String value) {
        put("&ta", value);
        return this;
    }

    public ProductAction setTransactionCouponCode(String value) {
        put("&tcc", value);
        return this;
    }

    public ProductAction setTransactionId(String value) {
        put("&ti", value);
        return this;
    }

    public ProductAction setTransactionRevenue(double value) {
        put("&tr", Double.toString(value));
        return this;
    }

    public ProductAction setTransactionShipping(double value) {
        put("&ts", Double.toString(value));
        return this;
    }

    public ProductAction setTransactionTax(double value) {
        put("&tt", Double.toString(value));
        return this;
    }
}
