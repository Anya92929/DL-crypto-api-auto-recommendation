package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

public abstract class AbstractBagDecorator<E> extends AbstractCollectionDecorator<E> implements Bag<E> {
    private static final long serialVersionUID = -3768146017343785417L;

    protected AbstractBagDecorator() {
    }

    protected AbstractBagDecorator(Bag<E> bag) {
        super(bag);
    }

    /* access modifiers changed from: protected */
    public Bag<E> decorated() {
        return (Bag) super.decorated();
    }

    public int getCount(Object obj) {
        return decorated().getCount(obj);
    }

    public boolean add(E e, int i) {
        return decorated().add(e, i);
    }

    public boolean remove(Object obj, int i) {
        return decorated().remove(obj, i);
    }

    public Set<E> uniqueSet() {
        return decorated().uniqueSet();
    }
}
