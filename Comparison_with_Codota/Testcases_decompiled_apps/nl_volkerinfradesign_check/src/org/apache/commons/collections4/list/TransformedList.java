package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

public class TransformedList<E> extends TransformedCollection<E> implements List<E> {
    private static final long serialVersionUID = 1077193035000013141L;

    public static <E> TransformedList<E> transformingList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        return new TransformedList<>(list, transformer);
    }

    public static <E> TransformedList<E> transformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        TransformedList<E> transformedList = new TransformedList<>(list, transformer);
        if (!(transformer == null || list == null || list.size() <= 0)) {
            Object[] array = list.toArray();
            list.clear();
            for (Object transform : array) {
                transformedList.decorated().add(transformer.transform(transform));
            }
        }
        return transformedList;
    }

    protected TransformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        super(list, transformer);
    }

    /* access modifiers changed from: protected */
    public List<E> getList() {
        return (List) decorated();
    }

    public E get(int i) {
        return getList().get(i);
    }

    public int indexOf(Object obj) {
        return getList().indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return getList().lastIndexOf(obj);
    }

    public E remove(int i) {
        return getList().remove(i);
    }

    public void add(int i, E e) {
        getList().add(i, transform(e));
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        return getList().addAll(i, transform(collection));
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(int i) {
        return new TransformedListIterator(getList().listIterator(i));
    }

    public E set(int i, E e) {
        return getList().set(i, transform(e));
    }

    public List<E> subList(int i, int i2) {
        return new TransformedList(getList().subList(i, i2), this.transformer);
    }

    public class TransformedListIterator extends AbstractListIteratorDecorator<E> {
        protected TransformedListIterator(ListIterator<E> listIterator) {
            super(listIterator);
        }

        public void add(E e) {
            getListIterator().add(TransformedList.this.transform(e));
        }

        public void set(E e) {
            getListIterator().set(TransformedList.this.transform(e));
        }
    }
}
