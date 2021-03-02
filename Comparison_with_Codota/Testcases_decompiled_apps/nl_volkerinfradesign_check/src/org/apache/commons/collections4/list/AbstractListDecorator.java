package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

public abstract class AbstractListDecorator<E> extends AbstractCollectionDecorator<E> implements List<E> {
    private static final long serialVersionUID = 4500739654952315623L;

    protected AbstractListDecorator() {
    }

    protected AbstractListDecorator(List<E> list) {
        super(list);
    }

    /* access modifiers changed from: protected */
    public List<E> decorated() {
        return (List) super.decorated();
    }

    public void add(int i, E e) {
        decorated().add(i, e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        return decorated().addAll(i, collection);
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

    public ListIterator<E> listIterator() {
        return decorated().listIterator();
    }

    public ListIterator<E> listIterator(int i) {
        return decorated().listIterator(i);
    }

    public E remove(int i) {
        return decorated().remove(i);
    }

    public E set(int i, E e) {
        return decorated().set(i, e);
    }

    public List<E> subList(int i, int i2) {
        return decorated().subList(i, i2);
    }
}
