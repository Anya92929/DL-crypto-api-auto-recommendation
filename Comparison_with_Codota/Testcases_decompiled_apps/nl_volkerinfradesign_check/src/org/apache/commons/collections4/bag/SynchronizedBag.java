package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.collection.SynchronizedCollection;

public class SynchronizedBag<E> extends SynchronizedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = 8084674570753837109L;

    public static <E> SynchronizedBag<E> synchronizedBag(Bag<E> bag) {
        return new SynchronizedBag<>(bag);
    }

    protected SynchronizedBag(Bag<E> bag) {
        super(bag);
    }

    protected SynchronizedBag(Bag<E> bag, Object obj) {
        super(bag, obj);
    }

    /* access modifiers changed from: protected */
    public Bag<E> getBag() {
        return (Bag) decorated();
    }

    public boolean add(E e, int i) {
        boolean add;
        synchronized (this.lock) {
            add = getBag().add(e, i);
        }
        return add;
    }

    public boolean remove(Object obj, int i) {
        boolean remove;
        synchronized (this.lock) {
            remove = getBag().remove(obj, i);
        }
        return remove;
    }

    public Set<E> uniqueSet() {
        C1845a aVar;
        synchronized (this.lock) {
            aVar = new C1845a(getBag().uniqueSet(), this.lock);
        }
        return aVar;
    }

    public int getCount(Object obj) {
        int count;
        synchronized (this.lock) {
            count = getBag().getCount(obj);
        }
        return count;
    }

    /* renamed from: org.apache.commons.collections4.bag.SynchronizedBag$a */
    class C1845a extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 2990565892366827855L;

        C1845a(Set<E> set, Object obj) {
            super(set, obj);
        }
    }
}
