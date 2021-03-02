package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.Transformer;

public class TransformingComparator<I, O> implements Serializable, Comparator<I> {
    private static final long serialVersionUID = 3456940356043606220L;

    /* renamed from: a */
    private final Comparator<O> f6408a;

    /* renamed from: b */
    private final Transformer<? super I, ? extends O> f6409b;

    public TransformingComparator(Transformer<? super I, ? extends O> transformer) {
        this(transformer, ComparatorUtils.NATURAL_COMPARATOR);
    }

    public TransformingComparator(Transformer<? super I, ? extends O> transformer, Comparator<O> comparator) {
        this.f6408a = comparator;
        this.f6409b = transformer;
    }

    public int compare(I i, I i2) {
        return this.f6408a.compare(this.f6409b.transform(i), this.f6409b.transform(i2));
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f6408a == null ? 0 : this.f6408a.hashCode()) + 629) * 37;
        if (this.f6409b != null) {
            i = this.f6409b.hashCode();
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
        TransformingComparator transformingComparator = (TransformingComparator) obj;
        if (this.f6408a == null) {
            if (transformingComparator.f6408a != null) {
                return false;
            }
            return true;
        } else if (!this.f6408a.equals(transformingComparator.f6408a) || this.f6409b != null) {
            return this.f6409b.equals(transformingComparator.f6409b);
        } else {
            if (transformingComparator.f6409b != null) {
                return false;
            }
            return true;
        }
    }
}
