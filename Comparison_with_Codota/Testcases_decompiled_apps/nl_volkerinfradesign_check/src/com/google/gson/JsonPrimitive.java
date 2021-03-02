package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {

    /* renamed from: a */
    private static final Class<?>[] f3646a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: b */
    private Object f3647b;

    public JsonPrimitive(Boolean bool) {
        mo7457a((Object) bool);
    }

    public JsonPrimitive(Number number) {
        mo7457a((Object) number);
    }

    public JsonPrimitive(String str) {
        mo7457a((Object) str);
    }

    public JsonPrimitive(Character ch) {
        mo7457a((Object) ch);
    }

    JsonPrimitive(Object obj) {
        mo7457a(obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7457a(Object obj) {
        if (obj instanceof Character) {
            this.f3647b = String.valueOf(((Character) obj).charValue());
            return;
        }
        C$Gson$Preconditions.checkArgument((obj instanceof Number) || m4272b(obj));
        this.f3647b = obj;
    }

    public boolean isBoolean() {
        return this.f3647b instanceof Boolean;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Boolean mo7428a() {
        return (Boolean) this.f3647b;
    }

    public boolean getAsBoolean() {
        if (isBoolean()) {
            return mo7428a().booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    public boolean isNumber() {
        return this.f3647b instanceof Number;
    }

    public Number getAsNumber() {
        return this.f3647b instanceof String ? new LazilyParsedNumber((String) this.f3647b) : (Number) this.f3647b;
    }

    public boolean isString() {
        return this.f3647b instanceof String;
    }

    public String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return mo7428a().toString();
        }
        return (String) this.f3647b;
    }

    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    public BigDecimal getAsBigDecimal() {
        return this.f3647b instanceof BigDecimal ? (BigDecimal) this.f3647b : new BigDecimal(this.f3647b.toString());
    }

    public BigInteger getAsBigInteger() {
        if (this.f3647b instanceof BigInteger) {
            return (BigInteger) this.f3647b;
        }
        return new BigInteger(this.f3647b.toString());
    }

    public float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    public short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    public byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    public char getAsCharacter() {
        return getAsString().charAt(0);
    }

    /* renamed from: b */
    private static boolean m4272b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> isAssignableFrom : f3646a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f3647b == null) {
            return 31;
        }
        if (m4271a(this)) {
            long longValue = getAsNumber().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.f3647b instanceof Number)) {
            return this.f3647b.hashCode();
        } else {
            long doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.f3647b == null) {
            if (jsonPrimitive.f3647b != null) {
                return false;
            }
            return true;
        } else if (!m4271a(this) || !m4271a(jsonPrimitive)) {
            if (!(this.f3647b instanceof Number) || !(jsonPrimitive.f3647b instanceof Number)) {
                return this.f3647b.equals(jsonPrimitive.f3647b);
            }
            double doubleValue = getAsNumber().doubleValue();
            double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
            if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                z = true;
            }
            return z;
        } else if (getAsNumber().longValue() != jsonPrimitive.getAsNumber().longValue()) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m4271a(JsonPrimitive jsonPrimitive) {
        if (!(jsonPrimitive.f3647b instanceof Number)) {
            return false;
        }
        Number number = (Number) jsonPrimitive.f3647b;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }
}
