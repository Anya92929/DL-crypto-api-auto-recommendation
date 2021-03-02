package org.apache.commons.collections4.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class SynchronizedCollection<E> implements Serializable, Collection<E> {
    private static final long serialVersionUID = 2412805092710877986L;

    /* renamed from: a */
    private final Collection<E> f6392a;
    public final Object lock;

    public static <T> SynchronizedCollection<T> synchronizedCollection(Collection<T> collection) {
        return new SynchronizedCollection<>(collection);
    }

    public SynchronizedCollection(Collection<E> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection must not be null");
        }
        this.f6392a = collection;
        this.lock = this;
    }

    public SynchronizedCollection(Collection<E> collection, Object obj) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection must not be null");
        }
        this.f6392a = collection;
        this.lock = obj;
    }

    public Collection<E> decorated() {
        return this.f6392a;
    }

    public boolean add(E e) {
        boolean add;
        synchronized (this.lock) {
            add = decorated().add(e);
        }
        return add;
    }

    public boolean addAll(Collection<? extends E> collection) {
        boolean addAll;
        synchronized (this.lock) {
            addAll = decorated().addAll(collection);
        }
        return addAll;
    }

    public void clear() {
        synchronized (this.lock) {
            decorated().clear();
        }
    }

    public boolean contains(Object obj) {
        boolean contains;
        synchronized (this.lock) {
            contains = decorated().contains(obj);
        }
        return contains;
    }

    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.lock) {
            containsAll = decorated().containsAll(collection);
        }
        return containsAll;
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.lock) {
            isEmpty = decorated().isEmpty();
        }
        return isEmpty;
    }

    public Iterator<E> iterator() {
        return decorated().iterator();
    }

    public Object[] toArray() {
        Object[] array;
        synchronized (this.lock) {
            array = decorated().toArray();
        }
        return array;
    }

    public <T> T[] toArray(T[] tArr) {
        T[] array;
        synchronized (this.lock) {
            array = decorated().toArray(tArr);
        }
        return array;
    }

    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.lock) {
            remove = decorated().remove(obj);
        }
        return remove;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.lock) {
            removeAll = decorated().removeAll(collection);
        }
        return removeAll;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.lock) {
            retainAll = decorated().retainAll(collection);
        }
        return retainAll;
    }

    public int size() {
        int size;
        synchronized (this.lock) {
            size = decorated().size();
        }
        return size;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        synchronized (this.lock) {
            if (obj != this) {
                if (obj != this && !decorated().equals(obj)) {
                    z = false;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.lock) {
            hashCode = decorated().hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.lock) {
            obj = decorated().toString();
        }
        return obj;
    }
}
