package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FixedOrderComparator<T> implements Serializable, Comparator<T> {
    private static final long serialVersionUID = 82794675842863201L;

    /* renamed from: a */
    private final Map<T, Integer> f6399a = new HashMap();

    /* renamed from: b */
    private int f6400b = 0;

    /* renamed from: c */
    private boolean f6401c = false;

    /* renamed from: d */
    private UnknownObjectBehavior f6402d = UnknownObjectBehavior.EXCEPTION;

    public enum UnknownObjectBehavior {
        BEFORE,
        AFTER,
        EXCEPTION
    }

    public FixedOrderComparator() {
    }

    public FixedOrderComparator(T... tArr) {
        if (tArr == null) {
            throw new IllegalArgumentException("The list of items must not be null");
        }
        for (T add : tArr) {
            add(add);
        }
    }

    public FixedOrderComparator(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("The list of items must not be null");
        }
        for (T add : list) {
            add(add);
        }
    }

    public boolean isLocked() {
        return this.f6401c;
    }

    /* access modifiers changed from: protected */
    public void checkLocked() {
        if (isLocked()) {
            throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
        }
    }

    public UnknownObjectBehavior getUnknownObjectBehavior() {
        return this.f6402d;
    }

    public void setUnknownObjectBehavior(UnknownObjectBehavior unknownObjectBehavior) {
        checkLocked();
        if (unknownObjectBehavior == null) {
            throw new IllegalArgumentException("Unknown object behavior must not be null");
        }
        this.f6402d = unknownObjectBehavior;
    }

    public boolean add(T t) {
        checkLocked();
        Map<T, Integer> map = this.f6399a;
        int i = this.f6400b;
        this.f6400b = i + 1;
        return map.put(t, Integer.valueOf(i)) == null;
    }

    public boolean addAsEqual(T t, T t2) {
        checkLocked();
        Integer num = this.f6399a.get(t);
        if (num != null) {
            return this.f6399a.put(t2, num) == null;
        }
        throw new IllegalArgumentException(t + " not known to " + this);
    }

    public int compare(T t, T t2) {
        int i = 0;
        this.f6401c = true;
        Integer num = this.f6399a.get(t);
        Integer num2 = this.f6399a.get(t2);
        if (num != null && num2 != null) {
            return num.compareTo(num2);
        }
        switch (this.f6402d) {
            case BEFORE:
                if (num != null) {
                    return 1;
                }
                if (num2 == null) {
                    return 0;
                }
                return -1;
            case AFTER:
                if (num != null) {
                    i = -1;
                } else if (num2 != null) {
                    i = 1;
                }
                return i;
            case EXCEPTION:
                if (num != null) {
                    t = t2;
                }
                throw new IllegalArgumentException("Attempting to compare unknown object " + t);
            default:
                throw new UnsupportedOperationException("Unknown unknownObjectBehavior: " + this.f6402d);
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.f6402d == null ? 0 : this.f6402d.hashCode()) + (((this.f6399a == null ? 0 : this.f6399a.hashCode()) + 629) * 37)) * 37) + this.f6400b) * 37;
        if (!this.f6401c) {
            i = 1;
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        FixedOrderComparator fixedOrderComparator = (FixedOrderComparator) obj;
        if (this.f6399a == null) {
            if (fixedOrderComparator.f6399a != null) {
                return false;
            }
            return true;
        } else if (!this.f6399a.equals(fixedOrderComparator.f6399a) || this.f6402d != null) {
            if (this.f6402d == fixedOrderComparator.f6402d && this.f6400b == fixedOrderComparator.f6400b && this.f6401c == fixedOrderComparator.f6401c && this.f6402d == fixedOrderComparator.f6402d) {
                return true;
            }
            return false;
        } else if (fixedOrderComparator.f6402d != null) {
            return false;
        } else {
            return true;
        }
    }
}
