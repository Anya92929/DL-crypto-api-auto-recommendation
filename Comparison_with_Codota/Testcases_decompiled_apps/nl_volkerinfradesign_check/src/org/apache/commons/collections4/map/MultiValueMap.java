package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

public class MultiValueMap<K, V> extends AbstractMapDecorator<K, Object> implements Serializable, MultiMap<K, V> {
    private static final long serialVersionUID = -2214159910087182007L;

    /* renamed from: b */
    private final Factory<? extends Collection<V>> f6689b;

    /* renamed from: c */
    private transient Collection<V> f6690c;

    public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> map) {
        return multiValueMap(map, ArrayList.class);
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> map, Class<C> cls) {
        return new MultiValueMap<>(map, new C1903a(cls));
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> map, Factory<C> factory) {
        return new MultiValueMap<>(map, factory);
    }

    public MultiValueMap() {
        this(new HashMap(), new C1903a(ArrayList.class));
    }

    protected <C extends Collection<V>> MultiValueMap(Map<K, ? super C> map, Factory<C> factory) {
        super(map);
        if (factory == null) {
            throw new IllegalArgumentException("The factory must not be null");
        }
        this.f6689b = factory;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f6624a);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6624a = (Map) objectInputStream.readObject();
    }

    public void clear() {
        decorated().clear();
    }

    public boolean removeMapping(Object obj, Object obj2) {
        Collection collection = getCollection(obj);
        if (collection == null || !collection.remove(obj2)) {
            return false;
        }
        if (collection.isEmpty()) {
            remove(obj);
        }
        return true;
    }

    public boolean containsValue(Object obj) {
        Set<Map.Entry> entrySet = decorated().entrySet();
        if (entrySet != null) {
            for (Map.Entry value : entrySet) {
                if (((Collection) value.getValue()).contains(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object put(K k, Object obj) {
        boolean z = true;
        Collection collection = getCollection(k);
        if (collection == null) {
            Collection createCollection = createCollection(1);
            createCollection.add(obj);
            if (createCollection.size() > 0) {
                decorated().put(k, createCollection);
            } else {
                z = false;
            }
        } else {
            z = collection.add(obj);
        }
        if (z) {
            return obj;
        }
        return null;
    }

    public void putAll(Map<? extends K, ?> map) {
        if (map instanceof MultiMap) {
            for (Map.Entry entry : ((MultiMap) map).entrySet()) {
                putAll(entry.getKey(), (Collection) entry.getValue());
            }
            return;
        }
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public Set<Map.Entry<K, Object>> entrySet() {
        return super.entrySet();
    }

    public Collection<Object> values() {
        Collection<V> collection = this.f6690c;
        if (collection != null) {
            return collection;
        }
        C1904b bVar = new C1904b();
        this.f6690c = bVar;
        return bVar;
    }

    public boolean containsValue(Object obj, Object obj2) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            return false;
        }
        return collection.contains(obj2);
    }

    public Collection<V> getCollection(Object obj) {
        return (Collection) decorated().get(obj);
    }

    public int size(Object obj) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public boolean putAll(K k, Collection<V> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        Collection collection2 = getCollection(k);
        if (collection2 != null) {
            return collection2.addAll(collection);
        }
        Collection createCollection = createCollection(collection.size());
        createCollection.addAll(collection);
        if (createCollection.size() <= 0) {
            return false;
        }
        decorated().put(k, createCollection);
        return true;
    }

    public Iterator<V> iterator(Object obj) {
        if (!containsKey(obj)) {
            return EmptyIterator.emptyIterator();
        }
        return new C1905c(obj);
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        final Iterator it = new ArrayList(keySet()).iterator();
        return new LazyIteratorChain<Map.Entry<K, V>>() {
            /* access modifiers changed from: protected */
            public Iterator<? extends Map.Entry<K, V>> nextIterator(int i) {
                if (!it.hasNext()) {
                    return null;
                }
                final Object next = it.next();
                return new TransformIterator(new C1905c(next), new Transformer<V, Map.Entry<K, V>>() {
                    /* renamed from: a */
                    public Map.Entry<K, V> transform(final V v) {
                        return new Map.Entry<K, V>() {
                            public K getKey() {
                                return next;
                            }

                            public V getValue() {
                                return v;
                            }

                            public V setValue(V v) {
                                throw new UnsupportedOperationException();
                            }
                        };
                    }
                });
            }
        };
    }

    public int totalSize() {
        int i = 0;
        for (Object size : decorated().values()) {
            i += CollectionUtils.size(size);
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public Collection<V> createCollection(int i) {
        return (Collection) this.f6689b.create();
    }

    /* renamed from: org.apache.commons.collections4.map.MultiValueMap$b */
    class C1904b extends AbstractCollection<V> {
        private C1904b() {
        }

        public Iterator<V> iterator() {
            IteratorChain iteratorChain = new IteratorChain();
            for (Object cVar : MultiValueMap.this.keySet()) {
                iteratorChain.addIterator(new C1905c(cVar));
            }
            return iteratorChain;
        }

        public int size() {
            return MultiValueMap.this.totalSize();
        }

        public void clear() {
            MultiValueMap.this.clear();
        }
    }

    /* renamed from: org.apache.commons.collections4.map.MultiValueMap$c */
    class C1905c implements Iterator<V> {

        /* renamed from: b */
        private final Object f6700b;

        /* renamed from: c */
        private final Collection<V> f6701c;

        /* renamed from: d */
        private final Iterator<V> f6702d = this.f6701c.iterator();

        public C1905c(Object obj) {
            this.f6700b = obj;
            this.f6701c = MultiValueMap.this.getCollection(obj);
        }

        public void remove() {
            this.f6702d.remove();
            if (this.f6701c.isEmpty()) {
                MultiValueMap.this.remove(this.f6700b);
            }
        }

        public boolean hasNext() {
            return this.f6702d.hasNext();
        }

        public V next() {
            return this.f6702d.next();
        }
    }

    /* renamed from: org.apache.commons.collections4.map.MultiValueMap$a */
    static class C1903a<T extends Collection<?>> implements Serializable, Factory<T> {
        private static final long serialVersionUID = 2986114157496788874L;

        /* renamed from: a */
        private final Class<T> f6697a;

        public C1903a(Class<T> cls) {
            this.f6697a = cls;
        }

        /* renamed from: a */
        public T create() {
            try {
                return (Collection) this.f6697a.newInstance();
            } catch (Exception e) {
                throw new FunctorException("Cannot instantiate class: " + this.f6697a, e);
            }
        }
    }
}
