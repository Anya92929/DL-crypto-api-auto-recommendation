package org.apache.commons.lang3.mutable;

public class MutableByte extends Number implements Comparable<MutableByte>, Mutable<Number> {
    private static final long serialVersionUID = -1585823265;

    /* renamed from: a */
    private byte f7144a;

    public MutableByte() {
    }

    public MutableByte(byte b) {
        this.f7144a = b;
    }

    public MutableByte(Number number) {
        this.f7144a = number.byteValue();
    }

    public MutableByte(String str) throws NumberFormatException {
        this.f7144a = Byte.parseByte(str);
    }

    public Byte getValue() {
        return Byte.valueOf(this.f7144a);
    }

    public void setValue(byte b) {
        this.f7144a = b;
    }

    public void setValue(Number number) {
        this.f7144a = number.byteValue();
    }

    public void increment() {
        this.f7144a = (byte) (this.f7144a + 1);
    }

    public void decrement() {
        this.f7144a = (byte) (this.f7144a - 1);
    }

    public void add(byte b) {
        this.f7144a = (byte) (this.f7144a + b);
    }

    public void add(Number number) {
        this.f7144a = (byte) (this.f7144a + number.byteValue());
    }

    public void subtract(byte b) {
        this.f7144a = (byte) (this.f7144a - b);
    }

    public void subtract(Number number) {
        this.f7144a = (byte) (this.f7144a - number.byteValue());
    }

    public byte byteValue() {
        return this.f7144a;
    }

    public int intValue() {
        return this.f7144a;
    }

    public long longValue() {
        return (long) this.f7144a;
    }

    public float floatValue() {
        return (float) this.f7144a;
    }

    public double doubleValue() {
        return (double) this.f7144a;
    }

    public Byte toByte() {
        return Byte.valueOf(byteValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableByte) || this.f7144a != ((MutableByte) obj).byteValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f7144a;
    }

    public int compareTo(MutableByte mutableByte) {
        byte b = mutableByte.f7144a;
        if (this.f7144a < b) {
            return -1;
        }
        return this.f7144a == b ? 0 : 1;
    }

    public String toString() {
        return String.valueOf(this.f7144a);
    }
}
