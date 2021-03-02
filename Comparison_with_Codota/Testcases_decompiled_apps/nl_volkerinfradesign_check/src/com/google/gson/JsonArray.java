package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray extends JsonElement implements Iterable<JsonElement> {

    /* renamed from: a */
    private final List<JsonElement> f3644a = new ArrayList();

    public void add(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.f3644a.add(jsonElement);
    }

    public void addAll(JsonArray jsonArray) {
        this.f3644a.addAll(jsonArray.f3644a);
    }

    public JsonElement set(int i, JsonElement jsonElement) {
        return this.f3644a.set(i, jsonElement);
    }

    public boolean remove(JsonElement jsonElement) {
        return this.f3644a.remove(jsonElement);
    }

    public JsonElement remove(int i) {
        return this.f3644a.remove(i);
    }

    public boolean contains(JsonElement jsonElement) {
        return this.f3644a.contains(jsonElement);
    }

    public int size() {
        return this.f3644a.size();
    }

    public Iterator<JsonElement> iterator() {
        return this.f3644a.iterator();
    }

    public JsonElement get(int i) {
        return this.f3644a.get(i);
    }

    public Number getAsNumber() {
        if (this.f3644a.size() == 1) {
            return this.f3644a.get(0).getAsNumber();
        }
        throw new IllegalStateException();
    }

    public String getAsString() {
        if (this.f3644a.size() == 1) {
            return this.f3644a.get(0).getAsString();
        }
        throw new IllegalStateException();
    }

    public double getAsDouble() {
        if (this.f3644a.size() == 1) {
            return this.f3644a.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    public BigDecimal getAsBigDecimal() {
        if (this.f3644a.size() == 1) {
            return this.f3644a.get(0).getAsBigDecimal();
        }
        throw new IllegalStateException();
    }

    public BigInteger getAsBigInteger() {
        if (this.f3644a.size() == 1) {
            return this.f3644a.get(0).getAsBigInteger();
        }
        throw new IllegalStateException();
    }

    public float getAsFloat() {
        if (this.f3644a.size() == 1) {
            return this.f3644a.get(0).getAsFloat();
        }
        throw new IllegalStateException();
    }

    public long getAsLong() {
        if (this.f3644a.size() == 1) {
            return this.f3644a.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    public int getAsInt() {
        if (this.f3644a.size() == 1) {
            return this.f3644a.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    public byte getAsByte() {
        if (this.f3644a.size() == 1) {
            return this.f3644a.get(0).getAsByte();
        }
        throw new IllegalStateException();
    }

    public char getAsCharacter() {
        if (this.f3644a.size() == 1) {
            return this.f3644a.get(0).getAsCharacter();
        }
        throw new IllegalStateException();
    }

    public short getAsShort() {
        if (this.f3644a.size() == 1) {
            return this.f3644a.get(0).getAsShort();
        }
        throw new IllegalStateException();
    }

    public boolean getAsBoolean() {
        if (this.f3644a.size() == 1) {
            return this.f3644a.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).f3644a.equals(this.f3644a));
    }

    public int hashCode() {
        return this.f3644a.hashCode();
    }
}
