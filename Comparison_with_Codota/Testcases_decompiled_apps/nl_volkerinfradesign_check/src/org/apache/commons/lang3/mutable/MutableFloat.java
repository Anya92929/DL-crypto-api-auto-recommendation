package org.apache.commons.lang3.mutable;

public class MutableFloat extends Number implements Comparable<MutableFloat>, Mutable<Number> {
    private static final long serialVersionUID = 5787169186L;

    /* renamed from: a */
    private float f7146a;

    public MutableFloat() {
    }

    public MutableFloat(float f) {
        this.f7146a = f;
    }

    public MutableFloat(Number number) {
        this.f7146a = number.floatValue();
    }

    public MutableFloat(String str) throws NumberFormatException {
        this.f7146a = Float.parseFloat(str);
    }

    public Float getValue() {
        return new Float(this.f7146a);
    }

    public void setValue(float f) {
        this.f7146a = f;
    }

    public void setValue(Number number) {
        this.f7146a = number.floatValue();
    }

    public boolean isNaN() {
        return Float.isNaN(this.f7146a);
    }

    public boolean isInfinite() {
        return Float.isInfinite(this.f7146a);
    }

    public void increment() {
        this.f7146a += 1.0f;
    }

    public void decrement() {
        this.f7146a -= 1.0f;
    }

    public void add(float f) {
        this.f7146a += f;
    }

    public void add(Number number) {
        this.f7146a += number.floatValue();
    }

    public void subtract(float f) {
        this.f7146a -= f;
    }

    public void subtract(Number number) {
        this.f7146a -= number.floatValue();
    }

    public int intValue() {
        return (int) this.f7146a;
    }

    public long longValue() {
        return (long) this.f7146a;
    }

    public float floatValue() {
        return this.f7146a;
    }

    public double doubleValue() {
        return (double) this.f7146a;
    }

    public Float toFloat() {
        return Float.valueOf(floatValue());
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableFloat) && Float.floatToIntBits(((MutableFloat) obj).f7146a) == Float.floatToIntBits(this.f7146a);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f7146a);
    }

    public int compareTo(MutableFloat mutableFloat) {
        return Float.compare(this.f7146a, mutableFloat.f7146a);
    }

    public String toString() {
        return String.valueOf(this.f7146a);
    }
}
