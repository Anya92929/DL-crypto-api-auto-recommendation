package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections4.Bag;

public final class CollectionBag<E> extends AbstractBagDecorator<E> {
    private static final long serialVersionUID = -2560033712679053143L;

    public static <E> Bag<E> collectionBag(Bag<E> bag) {
        return new CollectionBag(bag);
    }

    public CollectionBag(Bag<E> bag) {
        super(bag);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setCollection((Collection) objectInputStream.readObject());
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean add(E e) {
        return add(e, 1);
    }

    public boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        for (Object add : collection) {
            z = z || add(add, 1);
        }
        return z;
    }

    public boolean remove(Object obj) {
        return remove(obj, 1);
    }

    public boolean removeAll(Collection<?> collection) {
        if (collection == null) {
            return decorated().removeAll((Collection<?>) null);
        }
        boolean z = false;
        for (Object next : collection) {
            z = z || remove(next, getCount(next));
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        if (collection == null) {
            return decorated().retainAll((Collection<?>) null);
        }
        boolean z = false;
        Iterator it = iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean add(E e, int i) {
        decorated().add(e, i);
        return true;
    }
}
