package org.apache.commons.collections4.set;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CompositeSet<E> implements Serializable, Set<E> {
    private static final long serialVersionUID = 5185069727540378940L;

    /* renamed from: a */
    private SetMutator<E> f6755a;

    /* renamed from: b */
    private final List<Set<E>> f6756b = new ArrayList();

    public interface SetMutator<E> extends Serializable {
        boolean add(CompositeSet<E> compositeSet, List<Set<E>> list, E e);

        boolean addAll(CompositeSet<E> compositeSet, List<Set<E>> list, Collection<? extends E> collection);

        void resolveCollision(CompositeSet<E> compositeSet, Set<E> set, Set<E> set2, Collection<E> collection);
    }

    public CompositeSet() {
    }

    public CompositeSet(Set<E> set) {
        addComposited(set);
    }

    public CompositeSet(Set<E>... setArr) {
        addComposited(setArr);
    }

    public int size() {
        int i = 0;
        Iterator<Set<E>> it = this.f6756b.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().size() + i2;
        }
    }

    public boolean isEmpty() {
        for (Set<E> isEmpty : this.f6756b) {
            if (!isEmpty.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(Object obj) {
        for (Set<E> contains : this.f6756b) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<E> iterator() {
        if (this.f6756b.isEmpty()) {
            return EmptyIterator.emptyIterator();
        }
        IteratorChain iteratorChain = new IteratorChain();
        for (Set<E> it : this.f6756b) {
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
        Iterator<Set<E>> it = this.f6756b.iterator();
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
        if (this.f6755a != null) {
            return this.f6755a.add(this, this.f6756b, e);
        }
        throw new UnsupportedOperationException("add() is not supported on CompositeSet without a SetMutator strategy");
    }

    public boolean remove(Object obj) {
        for (Set set : getSets()) {
            if (set.contains(obj)) {
                return set.remove(obj);
            }
        }
        return false;
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
        if (this.f6755a != null) {
            return this.f6755a.addAll(this, this.f6756b, collection);
        }
        throw new UnsupportedOperationException("addAll() is not supported on CompositeSet without a SetMutator strategy");
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        if (collection.size() == 0) {
            return false;
        }
        Iterator<Set<E>> it = this.f6756b.iterator();
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
        Iterator<Set<E>> it = this.f6756b.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = it.next().retainAll(collection) | z2;
        }
    }

    public void clear() {
        for (Set<E> clear : this.f6756b) {
            clear.clear();
        }
    }

    public void setMutator(SetMutator<E> setMutator) {
        this.f6755a = setMutator;
    }

    public synchronized void addComposited(Set<E> set) {
        for (Set set2 : getSets()) {
            Collection<O> intersection = CollectionUtils.intersection(set2, set);
            if (intersection.size() > 0) {
                if (this.f6755a == null) {
                    throw new UnsupportedOperationException("Collision adding composited set with no SetMutator set");
                }
                getMutator().resolveCollision(this, set2, set, intersection);
                if (CollectionUtils.intersection(set2, set).size() > 0) {
                    throw new IllegalArgumentException("Attempt to add illegal entry unresolved by SetMutator.resolveCollision()");
                }
            }
        }
        this.f6756b.add(set);
    }

    public void addComposited(Set<E> set, Set<E> set2) {
        addComposited(set);
        addComposited(set2);
    }

    public void addComposited(Set<E>... setArr) {
        for (Set<E> addComposited : setArr) {
            addComposited(addComposited);
        }
    }

    public void removeComposited(Set<E> set) {
        this.f6756b.remove(set);
    }

    public Set<E> toSet() {
        return new HashSet(this);
    }

    public List<Set<E>> getSets() {
        return UnmodifiableList.unmodifiableList(this.f6756b);
    }

    /* access modifiers changed from: protected */
    public SetMutator<E> getMutator() {
        return this.f6755a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.size() != size() || !set.containsAll(this)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next == null ? 0 : next.hashCode();
        }
        return i;
    }
}
