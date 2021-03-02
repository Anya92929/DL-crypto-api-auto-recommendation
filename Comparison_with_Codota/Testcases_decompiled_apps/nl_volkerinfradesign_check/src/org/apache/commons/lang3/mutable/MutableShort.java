package org.apache.commons.lang3.mutable;

public class MutableShort extends Number implements Comparable<MutableShort>, Mutable<Number> {
    private static final long serialVersionUID = -2135791679;

    /* renamed from: a */
    private short f7150a;

    public MutableShort() {
    }

    public MutableShort(short s) {
        this.f7150a = s;
    }

    public MutableShort(Number number) {
        this.f7150a = number.shortValue();
    }

    public MutableShort(String str) throws NumberFormatException {
        this.f7150a = Short.parseShort(str);
    }

    public Short getValue() {
        return new Short(this.f7150a);
    }

    public void setValue(short s) {
        this.f7150a = s;
    }

    public void setValue(Number number) {
        this.f7150a = number.shortValue();
    }

    public void increment() {
        this.f7150a = (short) (this.f7150a + 1);
    }

    public void decrement() {
        this.f7150a = (short) (this.f7150a - 1);
    }

    public void add(short s) {
        this.f7150a = (short) (this.f7150a + s);
    }

    public void add(Number number) {
        this.f7150a = (short) (this.f7150a + number.shortValue());
    }

    public void subtract(short s) {
        this.f7150a = (short) (this.f7150a - s);
    }

    public void subtract(Number number) {
        this.f7150a = (short) (this.f7150a - number.shortValue());
    }

    public short shortValue() {
        return this.f7150a;
    }

    public int intValue() {
        return this.f7150a;
    }

    public long longValue() {
        return (long) this.f7150a;
    }

    public float floatValue() {
        return (float) this.f7150a;
    }

    public double doubleValue() {
        return (double) this.f7150a;
    }

    public Short toShort() {
        return Short.valueOf(shortValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableShort) || this.f7150a != ((MutableShort) obj).shortValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f7150a;
    }

    public int compareTo(MutableShort mutableShort) {
        short s = mutableShort.f7150a;
        if (this.f7150a < s) {
            return -1;
        }
        return this.f7150a == s ? 0 : 1;
    }

    public String toString() {
        return String.valueOf(this.f7150a);
    }
}
