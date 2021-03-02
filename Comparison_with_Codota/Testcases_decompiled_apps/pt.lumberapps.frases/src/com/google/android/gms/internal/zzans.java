package com.google.android.gms.internal;

import java.math.BigDecimal;

public final class zzans extends Number {

    /* renamed from: a */
    private final String f5802a;

    public zzans(String str) {
        this.f5802a = str;
    }

    public double doubleValue() {
        return Double.parseDouble(this.f5802a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzans)) {
            return false;
        }
        zzans zzans = (zzans) obj;
        return this.f5802a == zzans.f5802a || this.f5802a.equals(zzans.f5802a);
    }

    public float floatValue() {
        return Float.parseFloat(this.f5802a);
    }

    public int hashCode() {
        return this.f5802a.hashCode();
    }

    public int intValue() {
        try {
            return Integer.parseInt(this.f5802a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f5802a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f5802a).intValue();
            }
        }
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f5802a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f5802a).longValue();
        }
    }

    public String toString() {
        return this.f5802a;
    }
}
