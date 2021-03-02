package org.apache.commons.lang3.mutable;

public class MutableInt extends Number implements Comparable<MutableInt>, Mutable<Number> {
    private static final long serialVersionUID = 512176391864L;

    /* renamed from: a */
    private int f7147a;

    public MutableInt() {
    }

    public MutableInt(int i) {
        this.f7147a = i;
    }

    public MutableInt(Number number) {
        this.f7147a = number.intValue();
    }

    public MutableInt(String str) throws NumberFormatException {
        this.f7147a = Integer.parseInt(str);
    }

    public Integer getValue() {
        return new Integer(this.f7147a);
    }

    public void setValue(int i) {
        this.f7147a = i;
    }

    public void setValue(Number number) {
        this.f7147a = number.intValue();
    }

    public void increment() {
        this.f7147a++;
    }

    public void decrement() {
        this.f7147a--;
    }

    public void add(int i) {
        this.f7147a += i;
    }

    public void add(Number number) {
        this.f7147a += number.intValue();
    }

    public void subtract(int i) {
        this.f7147a -= i;
    }

    public void subtract(Number number) {
        this.f7147a -= number.intValue();
    }

    public int intValue() {
        return this.f7147a;
    }

    public long longValue() {
        return (long) this.f7147a;
    }

    public float floatValue() {
        return (float) this.f7147a;
    }

    public double doubleValue() {
        return (double) this.f7147a;
    }

    public Integer toInteger() {
        return Integer.valueOf(intValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableInt) || this.f7147a != ((MutableInt) obj).intValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f7147a;
    }

    public int compareTo(MutableInt mutableInt) {
        int i = mutableInt.f7147a;
        if (this.f7147a < i) {
            return -1;
        }
        return this.f7147a == i ? 0 : 1;
    }

    public String toString() {
        return String.valueOf(this.f7147a);
    }
}
