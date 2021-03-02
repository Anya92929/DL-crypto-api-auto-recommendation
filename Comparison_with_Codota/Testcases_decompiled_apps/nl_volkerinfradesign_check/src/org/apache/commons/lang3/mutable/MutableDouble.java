package org.apache.commons.lang3.mutable;

public class MutableDouble extends Number implements Comparable<MutableDouble>, Mutable<Number> {
    private static final long serialVersionUID = 1587163916;

    /* renamed from: a */
    private double f7145a;

    public MutableDouble() {
    }

    public MutableDouble(double d) {
        this.f7145a = d;
    }

    public MutableDouble(Number number) {
        this.f7145a = number.doubleValue();
    }

    public MutableDouble(String str) throws NumberFormatException {
        this.f7145a = Double.parseDouble(str);
    }

    public Double getValue() {
        return new Double(this.f7145a);
    }

    public void setValue(double d) {
        this.f7145a = d;
    }

    public void setValue(Number number) {
        this.f7145a = number.doubleValue();
    }

    public boolean isNaN() {
        return Double.isNaN(this.f7145a);
    }

    public boolean isInfinite() {
        return Double.isInfinite(this.f7145a);
    }

    public void increment() {
        this.f7145a += 1.0d;
    }

    public void decrement() {
        this.f7145a -= 1.0d;
    }

    public void add(double d) {
        this.f7145a += d;
    }

    public void add(Number number) {
        this.f7145a += number.doubleValue();
    }

    public void subtract(double d) {
        this.f7145a -= d;
    }

    public void subtract(Number number) {
        this.f7145a -= number.doubleValue();
    }

    public int intValue() {
        return (int) this.f7145a;
    }

    public long longValue() {
        return (long) this.f7145a;
    }

    public float floatValue() {
        return (float) this.f7145a;
    }

    public double doubleValue() {
        return this.f7145a;
    }

    public Double toDouble() {
        return Double.valueOf(doubleValue());
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableDouble) && Double.doubleToLongBits(((MutableDouble) obj).f7145a) == Double.doubleToLongBits(this.f7145a);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f7145a);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public int compareTo(MutableDouble mutableDouble) {
        return Double.compare(this.f7145a, mutableDouble.f7145a);
    }

    public String toString() {
        return String.valueOf(this.f7145a);
    }
}
