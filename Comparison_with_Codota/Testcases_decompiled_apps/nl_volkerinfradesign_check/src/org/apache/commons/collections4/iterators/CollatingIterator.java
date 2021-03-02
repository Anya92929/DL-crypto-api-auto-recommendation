package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CollatingIterator<E> implements Iterator<E> {

    /* renamed from: a */
    private Comparator<? super E> f6477a;

    /* renamed from: b */
    private ArrayList<Iterator<? extends E>> f6478b;

    /* renamed from: c */
    private ArrayList<E> f6479c;

    /* renamed from: d */
    private BitSet f6480d;

    /* renamed from: e */
    private int f6481e;

    public CollatingIterator() {
        this((Comparator) null, 2);
    }

    public CollatingIterator(Comparator<? super E> comparator) {
        this(comparator, 2);
    }

    public CollatingIterator(Comparator<? super E> comparator, int i) {
        this.f6477a = null;
        this.f6478b = null;
        this.f6479c = null;
        this.f6480d = null;
        this.f6481e = -1;
        this.f6478b = new ArrayList<>(i);
        setComparator(comparator);
    }

    public CollatingIterator(Comparator<? super E> comparator, Iterator<? extends E> it, Iterator<? extends E> it2) {
        this(comparator, 2);
        addIterator(it);
        addIterator(it2);
    }

    public CollatingIterator(Comparator<? super E> comparator, Iterator<? extends E>[] itArr) {
        this(comparator, itArr.length);
        for (Iterator<? extends E> addIterator : itArr) {
            addIterator(addIterator);
        }
    }

    public CollatingIterator(Comparator<? super E> comparator, Collection<Iterator<? extends E>> collection) {
        this(comparator, collection.size());
        for (Iterator<? extends E> addIterator : collection) {
            addIterator(addIterator);
        }
    }

    public void addIterator(Iterator<? extends E> it) {
        m7056b();
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.f6478b.add(it);
    }

    public void setIterator(int i, Iterator<? extends E> it) {
        m7056b();
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.f6478b.set(i, it);
    }

    public List<Iterator<? extends E>> getIterators() {
        return UnmodifiableList.unmodifiableList(this.f6478b);
    }

    public Comparator<? super E> getComparator() {
        return this.f6477a;
    }

    public void setComparator(Comparator<? super E> comparator) {
        m7056b();
        this.f6477a = comparator;
    }

    public boolean hasNext() {
        m7052a();
        return m7055a(this.f6480d) || m7054a(this.f6478b);
    }

    public E next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int c = m7058c();
        if (c == -1) {
            throw new NoSuchElementException();
        }
        E e = this.f6479c.get(c);
        m7057b(c);
        this.f6481e = c;
        return e;
    }

    public void remove() {
        if (this.f6481e == -1) {
            throw new IllegalStateException("No value can be removed at present");
        }
        this.f6478b.get(this.f6481e).remove();
    }

    public int getIteratorIndex() {
        if (this.f6481e != -1) {
            return this.f6481e;
        }
        throw new IllegalStateException("No value has been returned yet");
    }

    /* renamed from: a */
    private void m7052a() {
        if (this.f6479c == null) {
            this.f6479c = new ArrayList<>(this.f6478b.size());
            this.f6480d = new BitSet(this.f6478b.size());
            for (int i = 0; i < this.f6478b.size(); i++) {
                this.f6479c.add((Object) null);
                this.f6480d.clear(i);
            }
        }
    }

    /* renamed from: a */
    private boolean m7053a(int i) {
        Iterator it = this.f6478b.get(i);
        if (it.hasNext()) {
            this.f6479c.set(i, it.next());
            this.f6480d.set(i);
            return true;
        }
        this.f6479c.set(i, (Object) null);
        this.f6480d.clear(i);
        return false;
    }

    /* renamed from: b */
    private void m7057b(int i) {
        this.f6479c.set(i, (Object) null);
        this.f6480d.clear(i);
    }

    /* renamed from: b */
    private void m7056b() throws IllegalStateException {
        if (this.f6479c != null) {
            throw new IllegalStateException("Can't do that after next or hasNext has been called.");
        }
    }

    /* renamed from: c */
    private int m7058c() {
        E e;
        int i;
        E e2 = null;
        int i2 = 0;
        int i3 = -1;
        while (i2 < this.f6479c.size()) {
            if (!this.f6480d.get(i2)) {
                m7053a(i2);
            }
            if (this.f6480d.get(i2)) {
                if (i3 == -1) {
                    e = this.f6479c.get(i2);
                    i = i2;
                } else {
                    e = this.f6479c.get(i2);
                    if (this.f6477a == null) {
                        throw new NullPointerException("You must invoke setComparator() to set a comparator first.");
                    } else if (this.f6477a.compare(e, e2) < 0) {
                        i = i2;
                    }
                }
                i2++;
                i3 = i;
                e2 = e;
            }
            e = e2;
            i = i3;
            i2++;
            i3 = i;
            e2 = e;
        }
        return i3;
    }

    /* renamed from: a */
    private boolean m7055a(BitSet bitSet) {
        for (int i = 0; i < bitSet.size(); i++) {
            if (bitSet.get(i)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m7054a(ArrayList<Iterator<? extends E>> arrayList) {
        Iterator<Iterator<? extends E>> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().hasNext()) {
                return true;
            }
        }
        return false;
    }
}
