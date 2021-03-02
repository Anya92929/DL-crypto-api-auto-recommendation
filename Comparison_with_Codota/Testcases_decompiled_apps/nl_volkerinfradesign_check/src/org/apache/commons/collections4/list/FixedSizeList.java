package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

public class FixedSizeList<E> extends AbstractSerializableListDecorator<E> implements BoundedCollection<E> {
    private static final long serialVersionUID = -2218010673611160319L;

    public static <E> FixedSizeList<E> fixedSizeList(List<E> list) {
        return new FixedSizeList<>(list);
    }

    protected FixedSizeList(List<E> list) {
        super(list);
    }

    public boolean add(E e) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public void add(int i, E e) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public void clear() {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public E get(int i) {
        return decorated().get(i);
    }

    public int indexOf(Object obj) {
        return decorated().indexOf(obj);
    }

    public Iterator<E> iterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
    }

    public int lastIndexOf(Object obj) {
        return decorated().lastIndexOf(obj);
    }

    public ListIterator<E> listIterator() {
        return new C1866a(decorated().listIterator(0));
    }

    public ListIterator<E> listIterator(int i) {
        return new C1866a(decorated().listIterator(i));
    }

    public E remove(int i) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    public E set(int i, E e) {
        return decorated().set(i, e);
    }

    public List<E> subList(int i, int i2) {
        return new FixedSizeList(decorated().subList(i, i2));
    }

    /* renamed from: org.apache.commons.collections4.list.FixedSizeList$a */
    class C1866a extends AbstractListIteratorDecorator<E> {
        protected C1866a(ListIterator<E> listIterator) {
            super(listIterator);
        }

        public void remove() {
            throw new UnsupportedOperationException("List is fixed size");
        }

        public void add(Object obj) {
            throw new UnsupportedOperationException("List is fixed size");
        }
    }

    public boolean isFull() {
        return true;
    }

    public int maxSize() {
        return size();
    }
}
