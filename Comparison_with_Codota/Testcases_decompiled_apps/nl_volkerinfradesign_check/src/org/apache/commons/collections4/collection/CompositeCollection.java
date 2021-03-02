package org.apache.commons.collections4.collection;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CompositeCollection<E> implements Serializable, Collection<E> {
    private static final long serialVersionUID = 8417515734108306801L;

    /* renamed from: a */
    private CollectionMutator<E> f6387a;

    /* renamed from: b */
    private final List<Collection<E>> f6388b = new ArrayList();

    public interface CollectionMutator<E> extends Serializable {
        boolean add(CompositeCollection<E> compositeCollection, List<Collection<E>> list, E e);

        boolean addAll(CompositeCollection<E> compositeCollection, List<Collection<E>> list, Collection<? extends E> collection);

        boolean remove(CompositeCollection<E> compositeCollection, List<Collection<E>> list, Object obj);
    }

    public CompositeCollection() {
    }

    public CompositeCollection(Collection<E> collection) {
        addComposited(collection);
    }

    public CompositeCollection(Collection<E> collection, Collection<E> collection2) {
        addComposited(collection, collection2);
    }

    public CompositeCollection(Collection<E>... collectionArr) {
        addComposited(collectionArr);
    }

    public int size() {
        int i = 0;
        Iterator<Collection<E>> it = this.f6388b.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().size() + i2;
        }
    }

    public boolean isEmpty() {
        for (Collection<E> isEmpty : this.f6388b) {
            if (!isEmpty.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(Object obj) {
        for (Collection<E> contains : this.f6388b) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<E> iterator() {
        if (this.f6388b.isEmpty()) {
            return EmptyIterator.emptyIterator();
        }
        IteratorChain iteratorChain = new IteratorChain();
        for (Collection<E> it : this.f6388b) {
            iteratorChain.addIterator(it.iterator());
        }
        return iteratorChain;
    }

    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        int i = 0;
        Iterator it = iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        int size = size();
        if (tArr.length >= size) {
            tArr2 = tArr;
        } else {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        }
        int i = 0;
        Iterator<Collection<E>> it = this.f6388b.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            Iterator it2 = it.next().iterator();
            while (true) {
                i = i2;
                if (!it2.hasNext()) {
                    break;
                }
                i2 = i + 1;
                tArr2[i] = it2.next();
            }
        }
        if (tArr2.length > size) {
            tArr2[size] = null;
        }
        return (Object[]) tArr2;
    }

    public boolean add(E e) {
        if (this.f6387a != null) {
            return this.f6387a.add(this, this.f6388b, e);
        }
        throw new UnsupportedOperationException("add() is not supported on CompositeCollection without a CollectionMutator strategy");
    }

    public boolean remove(Object obj) {
        if (this.f6387a != null) {
            return this.f6387a.remove(this, this.f6388b, obj);
        }
        throw new UnsupportedOperationException("remove() is not supported on CompositeCollection without a CollectionMutator strategy");
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (this.f6387a != null) {
            return this.f6387a.addAll(this, this.f6388b, collection);
        }
        throw new UnsupportedOperationException("addAll() is not supported on CompositeCollection without a CollectionMutator strategy");
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        if (collection.size() == 0) {
            return false;
        }
        Iterator<Collection<E>> it = this.f6388b.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = it.next().removeAll(collection) | z2;
        }
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        Iterator<Collection<E>> it = this.f6388b.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = it.next().retainAll(collection) | z2;
        }
    }

    public void clear() {
        for (Collection<E> clear : this.f6388b) {
            clear.clear();
        }
    }

    public void setMutator(CollectionMutator<E> collectionMutator) {
        this.f6387a = collectionMutator;
    }

    public void addComposited(Collection<E> collection) {
        this.f6388b.add(collection);
    }

    public void addComposited(Collection<E> collection, Collection<E> collection2) {
        this.f6388b.add(collection);
        this.f6388b.add(collection2);
    }

    public void addComposited(Collection<E>... collectionArr) {
        this.f6388b.addAll(Arrays.asList(collectionArr));
    }

    public void removeComposited(Collection<E> collection) {
        this.f6388b.remove(collection);
    }

    public Collection<E> toCollection() {
        return new ArrayList(this);
    }

    public List<Collection<E>> getCollections() {
        return UnmodifiableList.unmodifiableList(this.f6388b);
    }

    /* access modifiers changed from: protected */
    public CollectionMutator<E> getMutator() {
        return this.f6387a;
    }
}
