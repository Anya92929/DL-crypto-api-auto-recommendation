package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;

public class ComparatorChain<E> implements Serializable, Comparator<E> {
    private static final long serialVersionUID = -721644942746081630L;

    /* renamed from: a */
    private final List<Comparator<E>> f6396a;

    /* renamed from: b */
    private BitSet f6397b;

    /* renamed from: c */
    private boolean f6398c;

    public ComparatorChain() {
        this(new ArrayList(), new BitSet());
    }

    public ComparatorChain(Comparator<E> comparator) {
        this(comparator, false);
    }

    public ComparatorChain(Comparator<E> comparator, boolean z) {
        this.f6397b = null;
        this.f6398c = false;
        this.f6396a = new ArrayList(1);
        this.f6396a.add(comparator);
        this.f6397b = new BitSet(1);
        if (z) {
            this.f6397b.set(0);
        }
    }

    public ComparatorChain(List<Comparator<E>> list) {
        this(list, new BitSet(list.size()));
    }

    public ComparatorChain(List<Comparator<E>> list, BitSet bitSet) {
        this.f6397b = null;
        this.f6398c = false;
        this.f6396a = list;
        this.f6397b = bitSet;
    }

    public void addComparator(Comparator<E> comparator) {
        addComparator(comparator, false);
    }

    public void addComparator(Comparator<E> comparator, boolean z) {
        m7047a();
        this.f6396a.add(comparator);
        if (z) {
            this.f6397b.set(this.f6396a.size() - 1);
        }
    }

    public void setComparator(int i, Comparator<E> comparator) throws IndexOutOfBoundsException {
        setComparator(i, comparator, false);
    }

    public void setComparator(int i, Comparator<E> comparator, boolean z) {
        m7047a();
        this.f6396a.set(i, comparator);
        if (z) {
            this.f6397b.set(i);
        } else {
            this.f6397b.clear(i);
        }
    }

    public void setForwardSort(int i) {
        m7047a();
        this.f6397b.clear(i);
    }

    public void setReverseSort(int i) {
        m7047a();
        this.f6397b.set(i);
    }

    public int size() {
        return this.f6396a.size();
    }

    public boolean isLocked() {
        return this.f6398c;
    }

    /* renamed from: a */
    private void m7047a() {
        if (this.f6398c) {
            throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
        }
    }

    /* renamed from: b */
    private void m7048b() {
        if (this.f6396a.size() == 0) {
            throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
        }
    }

    public int compare(E e, E e2) throws UnsupportedOperationException {
        if (!this.f6398c) {
            m7048b();
            this.f6398c = true;
        }
        int i = 0;
        for (Comparator<E> compare : this.f6396a) {
            int compare2 = compare.compare(e, e2);
            if (compare2 == 0) {
                i++;
            } else if (!this.f6397b.get(i)) {
                return compare2;
            } else {
                if (compare2 > 0) {
                    return -1;
                }
                return 1;
            }
        }
        return 0;
    }

    public int hashCode() {
        int i = 0;
        if (this.f6396a != null) {
            i = 0 ^ this.f6396a.hashCode();
        }
        if (this.f6397b != null) {
            return i ^ this.f6397b.hashCode();
        }
        return i;
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
        ComparatorChain comparatorChain = (ComparatorChain) obj;
        if (this.f6397b != null ? this.f6397b.equals(comparatorChain.f6397b) : comparatorChain.f6397b == null) {
            if (this.f6396a == null) {
                if (comparatorChain.f6396a == null) {
                    return true;
                }
            } else if (this.f6396a.equals(comparatorChain.f6396a)) {
                return true;
            }
        }
        return false;
    }
}
