package com.google.gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {
    private static final BigInteger INTEGER_MAX = BigInteger.valueOf(2147483647L);
    private static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
    private static final Class<?>[] PRIMITIVE_TYPES = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object value;

    public JsonPrimitive(Boolean bool) {
        setValue(bool);
    }

    public JsonPrimitive(Number number) {
        setValue(number);
    }

    public JsonPrimitive(String string) {
        setValue(string);
    }

    public JsonPrimitive(Character c) {
        setValue(c);
    }

    JsonPrimitive(Object primitive) {
        setValue(primitive);
    }

    /* access modifiers changed from: package-private */
    public void setValue(Object primitive) {
        if (primitive instanceof Character) {
            this.value = String.valueOf(((Character) primitive).charValue());
            return;
        }
        Preconditions.checkArgument((primitive instanceof Number) || isPrimitiveOrString(primitive));
        this.value = primitive;
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    /* access modifiers changed from: package-private */
    public Boolean getAsBooleanWrapper() {
        return (Boolean) this.value;
    }

    public boolean getAsBoolean() {
        return isBoolean() ? getAsBooleanWrapper().booleanValue() : Boolean.parseBoolean(getAsString());
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public Number getAsNumber() {
        return this.value instanceof String ? stringToNumber((String) this.value) : (Number) this.value;
    }

    static Number stringToNumber(String value2) {
        try {
            long longValue = Long.parseLong(value2);
            if (longValue < -2147483648L || longValue > 2147483647L) {
                return Long.valueOf(longValue);
            }
            return Integer.valueOf((int) longValue);
        } catch (NumberFormatException e) {
            try {
                return new BigDecimal(value2);
            } catch (NumberFormatException e2) {
                return Double.valueOf(Double.parseDouble(value2));
            }
        }
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    public String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return getAsBooleanWrapper().toString();
        }
        return (String) this.value;
    }

    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    public BigDecimal getAsBigDecimal() {
        return this.value instanceof BigDecimal ? (BigDecimal) this.value : new BigDecimal(this.value.toString());
    }

    public BigInteger getAsBigInteger() {
        return this.value instanceof BigInteger ? (BigInteger) this.value : new BigInteger(this.value.toString());
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

    /* access modifiers changed from: package-private */
    public Object getAsObject() {
        if (this.value instanceof BigInteger) {
            BigInteger big = (BigInteger) this.value;
            if (big.compareTo(INTEGER_MAX) < 0) {
                return Integer.valueOf(big.intValue());
            }
            if (big.compareTo(LONG_MAX) < 0) {
                return Long.valueOf(big.longValue());
            }
        }
        return this.value;
    }

    /* access modifiers changed from: protected */
    public void toString(Appendable sb, Escaper escaper) throws IOException {
        if (isString()) {
            sb.append('\"');
            sb.append(escaper.escapeJsonString(this.value.toString()));
            sb.append('\"');
            return;
        }
        sb.append(this.value.toString());
    }

    private static boolean isPrimitiveOrString(Object target) {
        if (target instanceof String) {
            return true;
        }
        Class<?> classOfPrimitive = target.getClass();
        for (Class<?> standardPrimitive : PRIMITIVE_TYPES) {
            if (standardPrimitive.isAssignableFrom(classOfPrimitive)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            long value2 = getAsNumber().longValue();
            return (int) ((value2 >>> 32) ^ value2);
        } else if (!isFloatingPoint(this)) {
            return this.value.hashCode();
        } else {
            long value3 = Double.doubleToLongBits(getAsNumber().doubleValue());
            return (int) ((value3 >>> 32) ^ value3);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JsonPrimitive other = (JsonPrimitive) obj;
        if (this.value == null) {
            if (other.value != null) {
                return false;
            }
            return true;
        } else if (!isIntegral(this) || !isIntegral(other)) {
            if (!isFloatingPoint(this) || !isFloatingPoint(other)) {
                return this.value.equals(other.value);
            }
            if (getAsNumber().doubleValue() != other.getAsNumber().doubleValue()) {
                return false;
            }
            return true;
        } else if (getAsNumber().longValue() != other.getAsNumber().longValue()) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isIntegral(JsonPrimitive primitive) {
        if (!(primitive.value instanceof Number)) {
            return false;
        }
        Number number = (Number) primitive.value;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }

    private static boolean isFloatingPoint(JsonPrimitive primitive) {
        if (!(primitive.value instanceof Number)) {
            return false;
        }
        Number number = (Number) primitive.value;
        if ((number instanceof BigDecimal) || (number instanceof Double) || (number instanceof Float)) {
            return true;
        }
        return false;
    }
}
