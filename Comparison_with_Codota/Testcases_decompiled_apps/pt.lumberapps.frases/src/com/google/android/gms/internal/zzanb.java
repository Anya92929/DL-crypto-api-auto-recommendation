package com.google.android.gms.internal;

import java.math.BigInteger;

public final class zzanb extends zzamv {

    /* renamed from: a */
    private static final Class[] f5792a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: b */
    private Object f5793b;

    public zzanb(Boolean bool) {
        mo7858a((Object) bool);
    }

    public zzanb(Number number) {
        mo7858a((Object) number);
    }

    public zzanb(String str) {
        mo7858a((Object) str);
    }

    /* renamed from: a */
    private static boolean m6656a(zzanb zzanb) {
        if (!(zzanb.f5793b instanceof Number)) {
            return false;
        }
        Number number = (Number) zzanb.f5793b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    /* renamed from: b */
    private static boolean m6657b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class isAssignableFrom : f5792a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Boolean mo7838a() {
        return (Boolean) this.f5793b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7858a(Object obj) {
        if (obj instanceof Character) {
            this.f5793b = String.valueOf(((Character) obj).charValue());
            return;
        }
        zzann.zzbo((obj instanceof Number) || m6657b(obj));
        this.f5793b = obj;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzanb zzanb = (zzanb) obj;
        if (this.f5793b == null) {
            return zzanb.f5793b == null;
        }
        if (m6656a(this) && m6656a(zzanb)) {
            return zzcze().longValue() == zzanb.zzcze().longValue();
        }
        if (!(this.f5793b instanceof Number) || !(zzanb.f5793b instanceof Number)) {
            return this.f5793b.equals(zzanb.f5793b);
        }
        double doubleValue = zzcze().doubleValue();
        double doubleValue2 = zzanb.zzcze().doubleValue();
        if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
            z = true;
        }
        return z;
    }

    public boolean getAsBoolean() {
        return zzczo() ? mo7838a().booleanValue() : Boolean.parseBoolean(zzczf());
    }

    public double getAsDouble() {
        return zzczp() ? zzcze().doubleValue() : Double.parseDouble(zzczf());
    }

    public int getAsInt() {
        return zzczp() ? zzcze().intValue() : Integer.parseInt(zzczf());
    }

    public long getAsLong() {
        return zzczp() ? zzcze().longValue() : Long.parseLong(zzczf());
    }

    public int hashCode() {
        if (this.f5793b == null) {
            return 31;
        }
        if (m6656a(this)) {
            long longValue = zzcze().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.f5793b instanceof Number)) {
            return this.f5793b.hashCode();
        } else {
            long doubleToLongBits = Double.doubleToLongBits(zzcze().doubleValue());
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        }
    }

    public Number zzcze() {
        return this.f5793b instanceof String ? new zzans((String) this.f5793b) : (Number) this.f5793b;
    }

    public String zzczf() {
        return zzczp() ? zzcze().toString() : zzczo() ? mo7838a().toString() : (String) this.f5793b;
    }

    public boolean zzczo() {
        return this.f5793b instanceof Boolean;
    }

    public boolean zzczp() {
        return this.f5793b instanceof Number;
    }

    public boolean zzczq() {
        return this.f5793b instanceof String;
    }
}
