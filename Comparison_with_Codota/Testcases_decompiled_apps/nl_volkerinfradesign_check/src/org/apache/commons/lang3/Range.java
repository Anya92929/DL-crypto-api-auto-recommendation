package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Comparator;

public final class Range<T> implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final Comparator<T> f7034a;

    /* renamed from: b */
    private final T f7035b;

    /* renamed from: c */
    private final T f7036c;

    /* renamed from: d */
    private transient int f7037d;

    /* renamed from: e */
    private transient String f7038e;

    /* renamed from: is */
    public static <T extends Comparable<T>> Range<T> m7357is(T t) {
        return between(t, t, (Comparator) null);
    }

    /* renamed from: is */
    public static <T> Range<T> m7358is(T t, Comparator<T> comparator) {
        return between(t, t, comparator);
    }

    public static <T extends Comparable<T>> Range<T> between(T t, T t2) {
        return between(t, t2, (Comparator) null);
    }

    public static <T> Range<T> between(T t, T t2, Comparator<T> comparator) {
        return new Range<>(t, t2, comparator);
    }

    private Range(T t, T t2, Comparator<T> comparator) {
        if (t == null || t2 == null) {
            throw new IllegalArgumentException("Elements in a range must not be null: element1=" + t + ", element2=" + t2);
        }
        comparator = comparator == null ? C1951a.INSTANCE : comparator;
        if (comparator.compare(t, t2) < 1) {
            this.f7035b = t;
            this.f7036c = t2;
        } else {
            this.f7035b = t2;
            this.f7036c = t;
        }
        this.f7034a = comparator;
    }

    public T getMinimum() {
        return this.f7035b;
    }

    public T getMaximum() {
        return this.f7036c;
    }

    public Comparator<T> getComparator() {
        return this.f7034a;
    }

    public boolean isNaturalOrdering() {
        return this.f7034a == C1951a.INSTANCE;
    }

    public boolean contains(T t) {
        boolean z = true;
        if (t == null) {
            return false;
        }
        if (this.f7034a.compare(t, this.f7035b) <= -1 || this.f7034a.compare(t, this.f7036c) >= 1) {
            z = false;
        }
        return z;
    }

    public boolean isAfter(T t) {
        if (t != null && this.f7034a.compare(t, this.f7035b) < 0) {
            return true;
        }
        return false;
    }

    public boolean isStartedBy(T t) {
        if (t != null && this.f7034a.compare(t, this.f7035b) == 0) {
            return true;
        }
        return false;
    }

    public boolean isEndedBy(T t) {
        if (t != null && this.f7034a.compare(t, this.f7036c) == 0) {
            return true;
        }
        return false;
    }

    public boolean isBefore(T t) {
        if (t != null && this.f7034a.compare(t, this.f7036c) > 0) {
            return true;
        }
        return false;
    }

    public int elementCompareTo(T t) {
        if (t == null) {
            throw new NullPointerException("Element is null");
        } else if (isAfter(t)) {
            return -1;
        } else {
            if (isBefore(t)) {
                return 1;
            }
            return 0;
        }
    }

    public boolean containsRange(Range<T> range) {
        if (range != null && contains(range.f7035b) && contains(range.f7036c)) {
            return true;
        }
        return false;
    }

    public boolean isAfterRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isAfter(range.f7036c);
    }

    public boolean isOverlappedBy(Range<T> range) {
        if (range == null) {
            return false;
        }
        if (range.contains(this.f7035b) || range.contains(this.f7036c) || contains(range.f7035b)) {
            return true;
        }
        return false;
    }

    public boolean isBeforeRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isBefore(range.f7035b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Range range = (Range) obj;
        if (!this.f7035b.equals(range.f7035b) || !this.f7036c.equals(range.f7036c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.f7037d;
        if (this.f7037d != 0) {
            return i;
        }
        int hashCode = ((((getClass().hashCode() + 629) * 37) + this.f7035b.hashCode()) * 37) + this.f7036c.hashCode();
        this.f7037d = hashCode;
        return hashCode;
    }

    public String toString() {
        String str = this.f7038e;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        sb.append(this.f7035b);
        sb.append("..");
        sb.append(this.f7036c);
        sb.append(']');
        String sb2 = sb.toString();
        this.f7038e = sb2;
        return sb2;
    }

    public String toString(String str) {
        return String.format(str, new Object[]{this.f7035b, this.f7036c, this.f7034a});
    }

    /* renamed from: org.apache.commons.lang3.Range$a */
    enum C1951a implements Comparator {
        INSTANCE;

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }
}
