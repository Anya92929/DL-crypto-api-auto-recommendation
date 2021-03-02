package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

public class PredicatedBag<E> extends PredicatedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = -2575833140344736876L;

    public static <E> PredicatedBag<E> predicatedBag(Bag<E> bag, Predicate<? super E> predicate) {
        return new PredicatedBag<>(bag, predicate);
    }

    protected PredicatedBag(Bag<E> bag, Predicate<? super E> predicate) {
        super(bag, predicate);
    }

    /* access modifiers changed from: protected */
    public Bag<E> decorated() {
        return (Bag) super.decorated();
    }

    public boolean add(E e, int i) {
        validate(e);
        return decorated().add(e, i);
    }

    public boolean remove(Object obj, int i) {
        return decorated().remove(obj, i);
    }

    public Set<E> uniqueSet() {
        return decorated().uniqueSet();
    }

    public int getCount(Object obj) {
        return decorated().getCount(obj);
    }
}
