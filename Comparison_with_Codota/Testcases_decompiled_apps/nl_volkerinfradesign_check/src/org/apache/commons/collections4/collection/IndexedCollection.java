package org.apache.commons.collections4.collection;

import java.util.Collection;
import java.util.HashMap;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.MultiValueMap;

public class IndexedCollection<K, C> extends AbstractCollectionDecorator<C> {
    private static final long serialVersionUID = -5512610452568370038L;

    /* renamed from: a */
    private final Transformer<C, K> f6389a;

    /* renamed from: b */
    private final MultiMap<K, C> f6390b;

    /* renamed from: c */
    private final boolean f6391c;

    public static <K, C> IndexedCollection<K, C> uniqueIndexedCollection(Collection<C> collection, Transformer<C, K> transformer) {
        return new IndexedCollection<>(collection, transformer, MultiValueMap.multiValueMap(new HashMap()), true);
    }

    public static <K, C> IndexedCollection<K, C> nonUniqueIndexedCollection(Collection<C> collection, Transformer<C, K> transformer) {
        return new IndexedCollection<>(collection, transformer, MultiValueMap.multiValueMap(new HashMap()), false);
    }

    public IndexedCollection(Collection<C> collection, Transformer<C, K> transformer, MultiMap<K, C> multiMap, boolean z) {
        super(collection);
        this.f6389a = transformer;
        this.f6390b = multiMap;
        this.f6391c = z;
        reindex();
    }

    public boolean add(C c) {
        boolean add = super.add(c);
        if (add) {
            m7045a(c);
        }
        return add;
    }

    public boolean addAll(Collection<? extends C> collection) {
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public void clear() {
        super.clear();
        this.f6390b.clear();
    }

    public boolean contains(Object obj) {
        return this.f6390b.containsKey(this.f6389a.transform(obj));
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public C get(K k) {
        Collection collection = (Collection) this.f6390b.get(k);
        if (collection == null) {
            return null;
        }
        return collection.iterator().next();
    }

    public Collection<C> values(K k) {
        return (Collection) this.f6390b.get(k);
    }

    public void reindex() {
        this.f6390b.clear();
        for (Object a : decorated()) {
            m7045a(a);
        }
    }

    public boolean remove(Object obj) {
        boolean remove = super.remove(obj);
        if (remove) {
            m7046b(obj);
        }
        return remove;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = super.retainAll(collection);
        if (retainAll) {
            reindex();
        }
        return retainAll;
    }

    /* renamed from: a */
    private void m7045a(C c) {
        K transform = this.f6389a.transform(c);
        if (!this.f6391c || !this.f6390b.containsKey(transform)) {
            this.f6390b.put(transform, c);
            return;
        }
        throw new IllegalArgumentException("Duplicate key in uniquely indexed collection.");
    }

    /* renamed from: b */
    private void m7046b(C c) {
        this.f6390b.remove(this.f6389a.transform(c));
    }
}
