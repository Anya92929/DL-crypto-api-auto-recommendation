package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.iterators.UnmodifiableListIterator;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.apache.commons.collections4.map.AbstractLinkedMap;

public class LinkedMap<K, V> extends AbstractLinkedMap<K, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = 9077234323521161066L;

    public LinkedMap() {
        super(16, 0.75f, 12);
    }

    public LinkedMap(int i) {
        super(i);
    }

    public LinkedMap(int i, float f) {
        super(i, f);
    }

    public LinkedMap(Map<? extends K, ? extends V> map) {
        super(map);
    }

    public LinkedMap<K, V> clone() {
        return (LinkedMap) super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    public K get(int i) {
        return getEntry(i).getKey();
    }

    public V getValue(int i) {
        return getEntry(i).getValue();
    }

    public int indexOf(Object obj) {
        Object convertKey = convertKey(obj);
        int i = 0;
        AbstractLinkedMap.LinkEntry<K, V> linkEntry = this.f6623i.after;
        while (linkEntry != this.f6623i) {
            if (isEqualKey(convertKey, linkEntry.key)) {
                return i;
            }
            linkEntry = linkEntry.after;
            i++;
        }
        return -1;
    }

    public V remove(int i) {
        return remove(get(i));
    }

    public List<K> asList() {
        return new C1891a(this);
    }

    /* renamed from: org.apache.commons.collections4.map.LinkedMap$a */
    static class C1891a<K> extends AbstractList<K> {

        /* renamed from: a */
        private final LinkedMap<K, ?> f6673a;

        C1891a(LinkedMap<K, ?> linkedMap) {
            this.f6673a = linkedMap;
        }

        public int size() {
            return this.f6673a.size();
        }

        public K get(int i) {
            return this.f6673a.get(i);
        }

        public boolean contains(Object obj) {
            return this.f6673a.containsKey(obj);
        }

        public int indexOf(Object obj) {
            return this.f6673a.indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            return this.f6673a.indexOf(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return this.f6673a.keySet().containsAll(collection);
        }

        public K remove(int i) {
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

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Object[] toArray() {
            return this.f6673a.keySet().toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f6673a.keySet().toArray(tArr);
        }

        public Iterator<K> iterator() {
            return UnmodifiableIterator.unmodifiableIterator(this.f6673a.keySet().iterator());
        }

        public ListIterator<K> listIterator() {
            return UnmodifiableListIterator.umodifiableListIterator(super.listIterator());
        }

        public ListIterator<K> listIterator(int i) {
            return UnmodifiableListIterator.umodifiableListIterator(super.listIterator(i));
        }

        public List<K> subList(int i, int i2) {
            return UnmodifiableList.unmodifiableList(super.subList(i, i2));
        }
    }
}
