package com.google.p008a.p010b;

import java.math.BigDecimal;

/* renamed from: com.google.a.b.v */
public final class C0462v extends Number {

    /* renamed from: a */
    private final String f3558a;

    public C0462v(String str) {
        this.f3558a = str;
    }

    public double doubleValue() {
        return Double.parseDouble(this.f3558a);
    }

    public float floatValue() {
        return Float.parseFloat(this.f3558a);
    }

    public int intValue() {
        try {
            return Integer.parseInt(this.f3558a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f3558a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f3558a).intValue();
            }
        }
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f3558a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f3558a).longValue();
        }
    }

    public String toString() {
        return this.f3558a;
    }
}
