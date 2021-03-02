package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.iterators.UnmodifiableListIterator;

public final class UnmodifiableList<E> extends AbstractSerializableListDecorator<E> implements Unmodifiable {
    private static final long serialVersionUID = 6595182819922443652L;

    public static <E> List<E> unmodifiableList(List<? extends E> list) {
        return list instanceof Unmodifiable ? list : new UnmodifiableList(list);
    }

    public UnmodifiableList(List<? extends E> list) {
        super(list);
    }

    public Iterator<E> iterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<E> listIterator() {
        return UnmodifiableListIterator.umodifiableListIterator(decorated().listIterator());
    }

    public ListIterator<E> listIterator(int i) {
        return UnmodifiableListIterator.umodifiableListIterator(decorated().listIterator(i));
    }

    public void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public List<E> subList(int i, int i2) {
        return new UnmodifiableList(decorated().subList(i, i2));
    }
}
