package com.google.gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class JsonElement {
    private static final Escaper BASIC_ESCAPER = new Escaper(false);

    /* access modifiers changed from: protected */
    public abstract void toString(Appendable appendable, Escaper escaper) throws IOException;

    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }

    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    public boolean isJsonPrimitive() {
        return this instanceof JsonPrimitive;
    }

    public boolean isJsonNull() {
        return this instanceof JsonNull;
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public JsonObject getAsJsonObject() {
        if (isJsonObject()) {
            return (JsonObject) this;
        }
        throw new IllegalStateException("This is not a JSON Object.");
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public JsonArray getAsJsonArray() {
        if (isJsonArray()) {
            return (JsonArray) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public JsonPrimitive getAsJsonPrimitive() {
        if (isJsonPrimitive()) {
            return (JsonPrimitive) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public JsonNull getAsJsonNull() {
        if (isJsonNull()) {
            return (JsonNull) this;
        }
        throw new IllegalStateException("This is not a JSON Null.");
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public Boolean getAsBooleanWrapper() {
        throw new UnsupportedOperationException();
    }

    public Number getAsNumber() {
        throw new UnsupportedOperationException();
    }

    public String getAsString() {
        throw new UnsupportedOperationException();
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException();
    }

    public float getAsFloat() {
        throw new UnsupportedOperationException();
    }

    public long getAsLong() {
        throw new UnsupportedOperationException();
    }

    public int getAsInt() {
        throw new UnsupportedOperationException();
    }

    public byte getAsByte() {
        throw new UnsupportedOperationException();
    }

    public char getAsCharacter() {
        throw new UnsupportedOperationException();
    }

    public BigDecimal getAsBigDecimal() {
        throw new UnsupportedOperationException();
    }

    public BigInteger getAsBigInteger() {
        throw new UnsupportedOperationException();
    }

    public short getAsShort() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public Object getAsObject() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            toString(sb, BASIC_ESCAPER);
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
