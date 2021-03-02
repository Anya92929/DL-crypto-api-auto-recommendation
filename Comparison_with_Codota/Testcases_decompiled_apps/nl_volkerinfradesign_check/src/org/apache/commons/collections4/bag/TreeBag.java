package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.SortedBag;
import org.apache.commons.collections4.bag.AbstractMapBag;

public class TreeBag<E> extends AbstractMapBag<E> implements Serializable, SortedBag<E> {
    private static final long serialVersionUID = -7740146511091606676L;

    public TreeBag() {
        super(new TreeMap());
    }

    public TreeBag(Comparator<? super E> comparator) {
        super(new TreeMap(comparator));
    }

    public TreeBag(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    public boolean add(E e) {
        if (comparator() != null || (e instanceof Comparable)) {
            return super.add(e);
        }
        throw new IllegalArgumentException("Objects of type " + e.getClass() + " cannot be added to " + "a naturally ordered TreeBag as it does not implement Comparable");
    }

    public E first() {
        return getMap().firstKey();
    }

    public E last() {
        return getMap().lastKey();
    }

    public Comparator<? super E> comparator() {
        return getMap().comparator();
    }

    /* access modifiers changed from: protected */
    public SortedMap<E, AbstractMapBag.MutableInteger> getMap() {
        return (SortedMap) super.getMap();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(comparator());
        super.doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        super.doReadObject(new TreeMap((Comparator) objectInputStream.readObject()), objectInputStream);
    }
}
