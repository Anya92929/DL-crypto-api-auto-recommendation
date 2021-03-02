package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

public class PredicatedList<E> extends PredicatedCollection<E> implements List<E> {
    private static final long serialVersionUID = -5722039223898659102L;

    public static <T> PredicatedList<T> predicatedList(List<T> list, Predicate<? super T> predicate) {
        return new PredicatedList<>(list, predicate);
    }

    protected PredicatedList(List<E> list, Predicate<? super E> predicate) {
        super(list, predicate);
    }

    /* access modifiers changed from: protected */
    public List<E> decorated() {
        return (List) super.decorated();
    }

    public E get(int i) {
        return decorated().get(i);
    }

    public int indexOf(Object obj) {
        return decorated().indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return decorated().lastIndexOf(obj);
    }

    public E remove(int i) {
        return decorated().remove(i);
    }

    public void add(int i, E e) {
        validate(e);
        decorated().add(i, e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        for (Object validate : collection) {
            validate(validate);
        }
        return decorated().addAll(i, collection);
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(int i) {
        return new PredicatedListIterator(decorated().listIterator(i));
    }

    public E set(int i, E e) {
        validate(e);
        return decorated().set(i, e);
    }

    public List<E> subList(int i, int i2) {
        return new PredicatedList(decorated().subList(i, i2), this.predicate);
    }

    public class PredicatedListIterator extends AbstractListIteratorDecorator<E> {
        protected PredicatedListIterator(ListIterator<E> listIterator) {
            super(listIterator);
        }

        public void add(E e) {
            PredicatedList.this.validate(e);
            getListIterator().add(e);
        }

        public void set(E e) {
            PredicatedList.this.validate(e);
            getListIterator().set(e);
        }
    }
}
