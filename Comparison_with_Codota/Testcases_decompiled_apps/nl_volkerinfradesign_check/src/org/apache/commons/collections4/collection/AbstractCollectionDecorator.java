package org.apache.commons.collections4.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollectionDecorator<E> implements Serializable, Collection<E> {
    private static final long serialVersionUID = 6249888059822088500L;

    /* renamed from: a */
    private Collection<E> f6386a;

    public AbstractCollectionDecorator() {
    }

    public AbstractCollectionDecorator(Collection<E> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection must not be null");
        }
        this.f6386a = collection;
    }

    public Collection<E> decorated() {
        return this.f6386a;
    }

    public void setCollection(Collection<E> collection) {
        this.f6386a = collection;
    }

    public boolean add(E e) {
        return decorated().add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return decorated().addAll(collection);
    }

    public void clear() {
        decorated().clear();
    }

    public boolean contains(Object obj) {
        return decorated().contains(obj);
    }

    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    public Iterator<E> iterator() {
        return decorated().iterator();
    }

    public boolean remove(Object obj) {
        return decorated().remove(obj);
    }

    public int size() {
        return decorated().size();
    }

    public Object[] toArray() {
        return decorated().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return decorated().toArray(tArr);
    }

    public boolean containsAll(Collection<?> collection) {
        return decorated().containsAll(collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return decorated().removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return decorated().retainAll(collection);
    }

    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    public int hashCode() {
        return decorated().hashCode();
    }

    public String toString() {
        return decorated().toString();
    }
}
