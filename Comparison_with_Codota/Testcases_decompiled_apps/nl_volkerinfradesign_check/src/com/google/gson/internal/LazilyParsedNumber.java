package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

public final class LazilyParsedNumber extends Number {

    /* renamed from: a */
    private final String f3693a;

    public LazilyParsedNumber(String str) {
        this.f3693a = str;
    }

    public int intValue() {
        try {
            return Integer.parseInt(this.f3693a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f3693a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f3693a).intValue();
            }
        }
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f3693a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f3693a).longValue();
        }
    }

    public float floatValue() {
        return Float.parseFloat(this.f3693a);
    }

    public double doubleValue() {
        return Double.parseDouble(this.f3693a);
    }

    public String toString() {
        return this.f3693a;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.f3693a);
    }
}
