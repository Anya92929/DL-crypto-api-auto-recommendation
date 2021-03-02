package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

public class ListOrderedMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable, OrderedMap<K, V> {
    private static final long serialVersionUID = 2728177751851003750L;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final List<K> f6674b;

    public static <K, V> ListOrderedMap<K, V> listOrderedMap(Map<K, V> map) {
        return new ListOrderedMap<>(map);
    }

    public ListOrderedMap() {
        this(new HashMap());
    }

    protected ListOrderedMap(Map<K, V> map) {
        super(map);
        this.f6674b = new ArrayList();
        this.f6674b.addAll(decorated().keySet());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f6624a);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6624a = (Map) objectInputStream.readObject();
    }

    public OrderedMapIterator<K, V> mapIterator() {
        return new C1897e(this);
    }

    public K firstKey() {
        if (size() != 0) {
            return this.f6674b.get(0);
        }
        throw new NoSuchElementException("Map is empty");
    }

    public K lastKey() {
        if (size() != 0) {
            return this.f6674b.get(size() - 1);
        }
        throw new NoSuchElementException("Map is empty");
    }

    public K nextKey(Object obj) {
        int indexOf = this.f6674b.indexOf(obj);
        if (indexOf < 0 || indexOf >= size() - 1) {
            return null;
        }
        return this.f6674b.get(indexOf + 1);
    }

    public K previousKey(Object obj) {
        int indexOf = this.f6674b.indexOf(obj);
        if (indexOf > 0) {
            return this.f6674b.get(indexOf - 1);
        }
        return null;
    }

    public V put(K k, V v) {
        if (decorated().containsKey(k)) {
            return decorated().put(k, v);
        }
        V put = decorated().put(k, v);
        this.f6674b.add(k);
        return put;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public void putAll(int i, Map<? extends K, ? extends V> map) {
        if (i < 0 || i > this.f6674b.size()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.f6674b.size());
        }
        for (Map.Entry next : map.entrySet()) {
            boolean containsKey = containsKey(next.getKey());
            put(i, next.getKey(), next.getValue());
            if (!containsKey) {
                i++;
            } else {
                i = indexOf(next.getKey()) + 1;
            }
        }
    }

    public V remove(Object obj) {
        if (!decorated().containsKey(obj)) {
            return null;
        }
        V remove = decorated().remove(obj);
        this.f6674b.remove(obj);
        return remove;
    }

    public void clear() {
        decorated().clear();
        this.f6674b.clear();
    }

    public Set<K> keySet() {
        return new C1893b(this);
    }

    public List<K> keyList() {
        return UnmodifiableList.unmodifiableList(this.f6674b);
    }

    public Collection<V> values() {
        return new C1898f(this);
    }

    public List<V> valueList() {
        return new C1898f(this);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return new C1892a(this, this.f6674b);
    }

    public String toString() {
        Object obj;
        Object obj2;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        boolean z = true;
        Iterator it = entrySet().iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (z2) {
                    z = false;
                } else {
                    sb.append(", ");
                    z = z2;
                }
                if (key == this) {
                    obj = "(this Map)";
                } else {
                    obj = key;
                }
                sb.append(obj);
                sb.append('=');
                if (value == this) {
                    obj2 = "(this Map)";
                } else {
                    obj2 = value;
                }
                sb.append(obj2);
            } else {
                sb.append('}');
                return sb.toString();
            }
        }
    }

    public K get(int i) {
        return this.f6674b.get(i);
    }

    public V getValue(int i) {
        return get(this.f6674b.get(i));
    }

    public int indexOf(Object obj) {
        return this.f6674b.indexOf(obj);
    }

    public V setValue(int i, V v) {
        return put(this.f6674b.get(i), v);
    }

    public V put(int i, K k, V v) {
        if (i < 0 || i > this.f6674b.size()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.f6674b.size());
        }
        Map decorated = decorated();
        if (decorated.containsKey(k)) {
            V remove = decorated.remove(k);
            int indexOf = this.f6674b.indexOf(k);
            this.f6674b.remove(indexOf);
            if (indexOf < i) {
                i--;
            }
            this.f6674b.add(i, k);
            decorated.put(k, v);
            return remove;
        }
        this.f6674b.add(i, k);
        decorated.put(k, v);
        return null;
    }

    public V remove(int i) {
        return remove(get(i));
    }

    public List<K> asList() {
        return keyList();
    }

    /* renamed from: org.apache.commons.collections4.map.ListOrderedMap$f */
    static class C1898f<V> extends AbstractList<V> {

        /* renamed from: a */
        private final ListOrderedMap<Object, V> f6687a;

        C1898f(ListOrderedMap<?, V> listOrderedMap) {
            this.f6687a = listOrderedMap;
        }

        public int size() {
            return this.f6687a.size();
        }

        public boolean contains(Object obj) {
            return this.f6687a.containsValue(obj);
        }

        public void clear() {
            this.f6687a.clear();
        }

        public Iterator<V> iterator() {
            return new AbstractUntypedIteratorDecorator<Map.Entry<Object, V>, V>(this.f6687a.entrySet().iterator()) {
                public V next() {
                    return ((Map.Entry) getIterator().next()).getValue();
                }
            };
        }

        public V get(int i) {
            return this.f6687a.getValue(i);
        }

        public V set(int i, V v) {
            return this.f6687a.setValue(i, v);
        }

        public V remove(int i) {
            return this.f6687a.remove(i);
        }
    }

    /* renamed from: org.apache.commons.collections4.map.ListOrderedMap$b */
    static class C1893b<K> extends AbstractSet<K> {

        /* renamed from: a */
        private final ListOrderedMap<K, Object> f6678a;

        C1893b(ListOrderedMap<K, ?> listOrderedMap) {
            this.f6678a = listOrderedMap;
        }

        public int size() {
            return this.f6678a.size();
        }

        public boolean contains(Object obj) {
            return this.f6678a.containsKey(obj);
        }

        public void clear() {
            this.f6678a.clear();
        }

        public Iterator<K> iterator() {
            return new AbstractUntypedIteratorDecorator<Map.Entry<K, Object>, K>(this.f6678a.entrySet().iterator()) {
                public K next() {
                    return ((Map.Entry) getIterator().next()).getKey();
                }
            };
        }
    }

    /* renamed from: org.apache.commons.collections4.map.ListOrderedMap$a */
    static class C1892a<K, V> extends AbstractSet<Map.Entry<K, V>> {

        /* renamed from: a */
        private final ListOrderedMap<K, V> f6675a;

        /* renamed from: b */
        private final List<K> f6676b;

        /* renamed from: c */
        private Set<Map.Entry<K, V>> f6677c;

        public C1892a(ListOrderedMap<K, V> listOrderedMap, List<K> list) {
            this.f6675a = listOrderedMap;
            this.f6676b = list;
        }

        /* renamed from: a */
        private Set<Map.Entry<K, V>> m7139a() {
            if (this.f6677c == null) {
                this.f6677c = this.f6675a.decorated().entrySet();
            }
            return this.f6677c;
        }

        public int size() {
            return this.f6675a.size();
        }

        public boolean isEmpty() {
            return this.f6675a.isEmpty();
        }

        public boolean contains(Object obj) {
            return m7139a().contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return m7139a().containsAll(collection);
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !m7139a().contains(obj)) {
                return false;
            }
            this.f6675a.remove(((Map.Entry) obj).getKey());
            return true;
        }

        public void clear() {
            this.f6675a.clear();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return m7139a().equals(obj);
        }

        public int hashCode() {
            return m7139a().hashCode();
        }

        public String toString() {
            return m7139a().toString();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C1895c(this.f6675a, this.f6676b);
        }
    }

    /* renamed from: org.apache.commons.collections4.map.ListOrderedMap$c */
    static class C1895c<K, V> extends AbstractUntypedIteratorDecorator<K, Map.Entry<K, V>> {

        /* renamed from: a */
        private final ListOrderedMap<K, V> f6680a;

        /* renamed from: b */
        private K f6681b = null;

        C1895c(ListOrderedMap<K, V> listOrderedMap, List<K> list) {
            super(list.iterator());
            this.f6680a = listOrderedMap;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            this.f6681b = getIterator().next();
            return new C1896d(this.f6680a, this.f6681b);
        }

        public void remove() {
            super.remove();
            this.f6680a.decorated().remove(this.f6681b);
        }
    }

    /* renamed from: org.apache.commons.collections4.map.ListOrderedMap$d */
    static class C1896d<K, V> extends AbstractMapEntry<K, V> {

        /* renamed from: a */
        private final ListOrderedMap<K, V> f6682a;

        C1896d(ListOrderedMap<K, V> listOrderedMap, K k) {
            super(k, null);
            this.f6682a = listOrderedMap;
        }

        public V getValue() {
            return this.f6682a.get(getKey());
        }

        public V setValue(V v) {
            return this.f6682a.decorated().put(getKey(), v);
        }
    }

    /* renamed from: org.apache.commons.collections4.map.ListOrderedMap$e */
    static class C1897e<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {

        /* renamed from: a */
        private final ListOrderedMap<K, V> f6683a;

        /* renamed from: b */
        private ListIterator<K> f6684b;

        /* renamed from: c */
        private K f6685c = null;

        /* renamed from: d */
        private boolean f6686d = false;

        C1897e(ListOrderedMap<K, V> listOrderedMap) {
            this.f6683a = listOrderedMap;
            this.f6684b = listOrderedMap.f6674b.listIterator();
        }

        public boolean hasNext() {
            return this.f6684b.hasNext();
        }

        public K next() {
            this.f6685c = this.f6684b.next();
            this.f6686d = true;
            return this.f6685c;
        }

        public boolean hasPrevious() {
            return this.f6684b.hasPrevious();
        }

        public K previous() {
            this.f6685c = this.f6684b.previous();
            this.f6686d = true;
            return this.f6685c;
        }

        public void remove() {
            if (!this.f6686d) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            this.f6684b.remove();
            this.f6683a.f6624a.remove(this.f6685c);
            this.f6686d = false;
        }

        public K getKey() {
            if (this.f6686d) {
                return this.f6685c;
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        public V getValue() {
            if (this.f6686d) {
                return this.f6683a.get(this.f6685c);
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        public V setValue(V v) {
            if (this.f6686d) {
                return this.f6683a.f6624a.put(this.f6685c, v);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }

        public void reset() {
            this.f6684b = this.f6683a.f6674b.listIterator();
            this.f6685c = null;
            this.f6686d = false;
        }

        public String toString() {
            if (this.f6686d) {
                return "Iterator[" + getKey() + "=" + getValue() + "]";
            }
            return "Iterator[]";
        }
    }
}
