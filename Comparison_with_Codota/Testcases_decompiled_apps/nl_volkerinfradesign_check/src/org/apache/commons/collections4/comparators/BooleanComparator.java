package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;

public final class BooleanComparator implements Serializable, Comparator<Boolean> {

    /* renamed from: a */
    private static final BooleanComparator f6393a = new BooleanComparator(true);

    /* renamed from: b */
    private static final BooleanComparator f6394b = new BooleanComparator(false);
    private static final long serialVersionUID = 1830042991606340609L;

    /* renamed from: c */
    private boolean f6395c;

    public static BooleanComparator getTrueFirstComparator() {
        return f6393a;
    }

    public static BooleanComparator getFalseFirstComparator() {
        return f6394b;
    }

    public static BooleanComparator booleanComparator(boolean z) {
        return z ? f6393a : f6394b;
    }

    public BooleanComparator() {
        this(false);
    }

    public BooleanComparator(boolean z) {
        this.f6395c = false;
        this.f6395c = z;
    }

    public int compare(Boolean bool, Boolean bool2) {
        boolean booleanValue = bool.booleanValue();
        if (bool2.booleanValue() ^ booleanValue) {
            return booleanValue ^ this.f6395c ? 1 : -1;
        }
        return 0;
    }

    public int hashCode() {
        int hashCode = "BooleanComparator".hashCode();
        return this.f6395c ? hashCode * -1 : hashCode;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BooleanComparator) && this.f6395c == ((BooleanComparator) obj).f6395c);
    }

    public boolean sortsTrueFirst() {
        return this.f6395c;
    }
}
