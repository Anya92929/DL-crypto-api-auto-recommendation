package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections4.set.UnmodifiableSet;

public class SetUniqueList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = 7196982186153478694L;

    /* renamed from: a */
    private final Set<E> f6586a;

    public static <E> SetUniqueList<E> setUniqueList(List<E> list) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        } else if (list.isEmpty()) {
            return new SetUniqueList<>(list, new HashSet());
        } else {
            ArrayList arrayList = new ArrayList(list);
            list.clear();
            SetUniqueList<E> setUniqueList = new SetUniqueList<>(list, new HashSet());
            setUniqueList.addAll(arrayList);
            return setUniqueList;
        }
    }

    protected SetUniqueList(List<E> list, Set<E> set) {
        super(list);
        if (set == null) {
            throw new IllegalArgumentException("Set must not be null");
        }
        this.f6586a = set;
    }

    public Set<E> asSet() {
        return UnmodifiableSet.unmodifiableSet(this.f6586a);
    }

    public boolean add(E e) {
        int size = size();
        add(size(), e);
        return size != size();
    }

    public void add(int i, E e) {
        if (!this.f6586a.contains(e)) {
            super.add(i, e);
            this.f6586a.add(e);
        }
    }

    public boolean addAll(Collection<? extends E> collection) {
        return addAll(size(), collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        ArrayList arrayList = new ArrayList();
        for (Object next : collection) {
            if (this.f6586a.add(next)) {
                arrayList.add(next);
            }
        }
        return super.addAll(i, arrayList);
    }

    public E set(int i, E e) {
        int indexOf = indexOf(e);
        E e2 = super.set(i, e);
        if (!(indexOf == -1 || indexOf == i)) {
            super.remove(indexOf);
        }
        this.f6586a.remove(e2);
        this.f6586a.add(e);
        return e2;
    }

    public boolean remove(Object obj) {
        boolean remove = this.f6586a.remove(obj);
        if (remove) {
            super.remove(obj);
        }
        return remove;
    }

    public E remove(int i) {
        E remove = super.remove(i);
        this.f6586a.remove(remove);
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
            if (this.f6586a.contains(next)) {
                hashSet.add(next);
            }
        }
        if (hashSet.size() == this.f6586a.size()) {
            return false;
        }
        if (hashSet.size() == 0) {
            clear();
        } else {
            Iterator it = iterator();
            while (it.hasNext()) {
                if (!hashSet.contains(it.next())) {
                    it.remove();
                }
            }
        }
        return true;
    }

    public void clear() {
        super.clear();
        this.f6586a.clear();
    }

    public boolean contains(Object obj) {
        return this.f6586a.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f6586a.containsAll(collection);
    }

    public Iterator<E> iterator() {
        return new C1867a(super.iterator(), this.f6586a);
    }

    public ListIterator<E> listIterator() {
        return new C1868b(super.listIterator(), this.f6586a);
    }

    public ListIterator<E> listIterator(int i) {
        return new C1868b(super.listIterator(i), this.f6586a);
    }

    public List<E> subList(int i, int i2) {
        List subList = super.subList(i, i2);
        return ListUtils.unmodifiableList(new SetUniqueList(subList, createSetBasedOnList(this.f6586a, subList)));
    }

    /* access modifiers changed from: protected */
    public Set<E> createSetBasedOnList(Set<E> set, List<E> list) {
        Set<E> hashSet;
        if (set.getClass().equals(HashSet.class)) {
            hashSet = new HashSet<>(list.size());
        } else {
            try {
                hashSet = (Set) set.getClass().newInstance();
            } catch (InstantiationException e) {
                hashSet = new HashSet<>();
            } catch (IllegalAccessException e2) {
                hashSet = new HashSet<>();
            }
        }
        hashSet.addAll(list);
        return hashSet;
    }

    /* renamed from: org.apache.commons.collections4.list.SetUniqueList$a */
    static class C1867a<E> extends AbstractIteratorDecorator<E> {

        /* renamed from: a */
        private final Set<E> f6587a;

        /* renamed from: b */
        private E f6588b = null;

        protected C1867a(Iterator<E> it, Set<E> set) {
            super(it);
            this.f6587a = set;
        }

        public E next() {
            this.f6588b = super.next();
            return this.f6588b;
        }

        public void remove() {
            super.remove();
            this.f6587a.remove(this.f6588b);
            this.f6588b = null;
        }
    }

    /* renamed from: org.apache.commons.collections4.list.SetUniqueList$b */
    static class C1868b<E> extends AbstractListIteratorDecorator<E> {

        /* renamed from: a */
        private final Set<E> f6589a;

        /* renamed from: b */
        private E f6590b = null;

        protected C1868b(ListIterator<E> listIterator, Set<E> set) {
            super(listIterator);
            this.f6589a = set;
        }

        public E next() {
            this.f6590b = super.next();
            return this.f6590b;
        }

        public E previous() {
            this.f6590b = super.previous();
            return this.f6590b;
        }

        public void remove() {
            super.remove();
            this.f6589a.remove(this.f6590b);
            this.f6590b = null;
        }

        public void add(E e) {
            if (!this.f6589a.contains(e)) {
                super.add(e);
                this.f6589a.add(e);
            }
        }

        public void set(E e) {
            throw new UnsupportedOperationException("ListIterator does not support set");
        }
    }
}
