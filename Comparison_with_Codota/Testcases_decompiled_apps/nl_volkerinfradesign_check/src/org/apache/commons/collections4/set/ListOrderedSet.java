package org.apache.commons.collections4.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

public class ListOrderedSet<E> extends AbstractSerializableSetDecorator<E> {
    private static final long serialVersionUID = -228664372470420141L;

    /* renamed from: a */
    private final List<E> f6757a;

    public static <E> ListOrderedSet<E> listOrderedSet(Set<E> set, List<E> list) {
        if (set == null) {
            throw new IllegalArgumentException("Set must not be null");
        } else if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        } else if (set.size() <= 0 && list.size() <= 0) {
            return new ListOrderedSet<>(set, list);
        } else {
            throw new IllegalArgumentException("Set and List must be empty");
        }
    }

    public static <E> ListOrderedSet<E> listOrderedSet(Set<E> set) {
        return new ListOrderedSet<>(set);
    }

    public static <E> ListOrderedSet<E> listOrderedSet(List<E> list) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        }
        HashSet hashSet = new HashSet(list);
        list.retainAll(hashSet);
        return new ListOrderedSet<>(hashSet, list);
    }

    public ListOrderedSet() {
        super(new HashSet());
        this.f6757a = new ArrayList();
    }

    protected ListOrderedSet(Set<E> set) {
        super(set);
        this.f6757a = new ArrayList(set);
    }

    protected ListOrderedSet(Set<E> set, List<E> list) {
        super(set);
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        }
        this.f6757a = list;
    }

    public List<E> asList() {
        return UnmodifiableList.unmodifiableList(this.f6757a);
    }

    public void clear() {
        decorated().clear();
        this.f6757a.clear();
    }

    public OrderedIterator<E> iterator() {
        return new C1923a(this.f6757a.listIterator(), decorated());
    }

    public boolean add(E e) {
        if (!decorated().add(e)) {
            return false;
        }
        this.f6757a.add(e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public boolean remove(Object obj) {
        boolean remove = decorated().remove(obj);
        if (remove) {
            this.f6757a.remove(obj);
        }
        return remove;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove((Object) remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        HashSet hashSet = new HashSet();
        for (Object next : collection) {
            if (decorated().contains(next)) {
                hashSet.add(next);
            }
        }
        if (hashSet.size() == decorated().size()) {
            return false;
        }
        if (hashSet.size() == 0) {
            clear();
        } else {
            OrderedIterator it = iterator();
            while (it.hasNext()) {
                if (!hashSet.contains(it.next())) {
                    it.remove();
                }
            }
        }
        return true;
    }

    public Object[] toArray() {
        return this.f6757a.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f6757a.toArray(tArr);
    }

    public E get(int i) {
        return this.f6757a.get(i);
    }

    public int indexOf(Object obj) {
        return this.f6757a.indexOf(obj);
    }

    public void add(int i, E e) {
        if (!contains(e)) {
            decorated().add(e);
            this.f6757a.add(i, e);
        }
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        for (Object next : collection) {
            if (!contains(next)) {
                decorated().add(next);
                arrayList.add(next);
                z = true;
            }
        }
        if (z) {
            this.f6757a.addAll(i, arrayList);
        }
        return z;
    }

    public Object remove(int i) {
        E remove = this.f6757a.remove(i);
        remove((Object) remove);
        return remove;
    }

    public String toString() {
        return this.f6757a.toString();
    }

    /* renamed from: org.apache.commons.collections4.set.ListOrderedSet$a */
    static class C1923a<E> extends AbstractIteratorDecorator<E> implements OrderedIterator<E> {

        /* renamed from: a */
        private final Collection<E> f6758a;

        /* renamed from: b */
        private E f6759b;

        private C1923a(ListIterator<E> listIterator, Collection<E> collection) {
            super(listIterator);
            this.f6758a = collection;
        }

        public E next() {
            this.f6759b = getIterator().next();
            return this.f6759b;
        }

        public void remove() {
            this.f6758a.remove(this.f6759b);
            getIterator().remove();
            this.f6759b = null;
        }

        public boolean hasPrevious() {
            return ((ListIterator) getIterator()).hasPrevious();
        }

        public E previous() {
            this.f6759b = ((ListIterator) getIterator()).previous();
            return this.f6759b;
        }
    }
}
