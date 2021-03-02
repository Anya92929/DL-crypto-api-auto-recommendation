package org.apache.commons.lang3.mutable;

public class MutableLong extends Number implements Comparable<MutableLong>, Mutable<Number> {
    private static final long serialVersionUID = 62986528375L;

    /* renamed from: a */
    private long f7148a;

    public MutableLong() {
    }

    public MutableLong(long j) {
        this.f7148a = j;
    }

    public MutableLong(Number number) {
        this.f7148a = number.longValue();
    }

    public MutableLong(String str) throws NumberFormatException {
        this.f7148a = Long.parseLong(str);
    }

    public Long getValue() {
        return new Long(this.f7148a);
    }

    public void setValue(long j) {
        this.f7148a = j;
    }

    public void setValue(Number number) {
        this.f7148a = number.longValue();
    }

    public void increment() {
        this.f7148a++;
    }

    public void decrement() {
        this.f7148a--;
    }

    public void add(long j) {
        this.f7148a += j;
    }

    public void add(Number number) {
        this.f7148a += number.longValue();
    }

    public void subtract(long j) {
        this.f7148a -= j;
    }

    public void subtract(Number number) {
        this.f7148a -= number.longValue();
    }

    public int intValue() {
        return (int) this.f7148a;
    }

    public long longValue() {
        return this.f7148a;
    }

    public float floatValue() {
        return (float) this.f7148a;
    }

    public double doubleValue() {
        return (double) this.f7148a;
    }

    public Long toLong() {
        return Long.valueOf(longValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableLong) || this.f7148a != ((MutableLong) obj).longValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) (this.f7148a ^ (this.f7148a >>> 32));
    }

    public int compareTo(MutableLong mutableLong) {
        long j = mutableLong.f7148a;
        if (this.f7148a < j) {
            return -1;
        }
        return this.f7148a == j ? 0 : 1;
    }

    public String toString() {
        return String.valueOf(this.f7148a);
    }
}
