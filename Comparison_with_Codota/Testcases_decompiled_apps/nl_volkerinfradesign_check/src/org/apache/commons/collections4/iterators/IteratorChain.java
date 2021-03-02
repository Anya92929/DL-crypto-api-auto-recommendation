package org.apache.commons.collections4.iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class IteratorChain<E> implements Iterator<E> {

    /* renamed from: a */
    private final Queue<Iterator<? extends E>> f6500a = new LinkedList();

    /* renamed from: b */
    private Iterator<? extends E> f6501b = null;

    /* renamed from: c */
    private Iterator<? extends E> f6502c = null;

    /* renamed from: d */
    private boolean f6503d = false;

    public IteratorChain() {
    }

    public IteratorChain(Iterator<? extends E> it) {
        addIterator(it);
    }

    public IteratorChain(Iterator<? extends E> it, Iterator<? extends E> it2) {
        addIterator(it);
        addIterator(it2);
    }

    public IteratorChain(Iterator<? extends E>... itArr) {
        for (Iterator<? extends E> addIterator : itArr) {
            addIterator(addIterator);
        }
    }

    public IteratorChain(Collection<Iterator<? extends E>> collection) {
        for (Iterator<? extends E> addIterator : collection) {
            addIterator(addIterator);
        }
    }

    public void addIterator(Iterator<? extends E> it) {
        m7064a();
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.f6500a.add(it);
    }

    public int size() {
        return this.f6500a.size();
    }

    public boolean isLocked() {
        return this.f6503d;
    }

    /* renamed from: a */
    private void m7064a() {
        if (this.f6503d) {
            throw new UnsupportedOperationException("IteratorChain cannot be changed after the first use of a method from the Iterator interface");
        }
    }

    /* renamed from: b */
    private void m7065b() {
        if (!this.f6503d) {
            this.f6503d = true;
        }
    }

    /* access modifiers changed from: protected */
    public void updateCurrentIterator() {
        if (this.f6501b == null) {
            if (this.f6500a.isEmpty()) {
                this.f6501b = EmptyIterator.emptyIterator();
            } else {
                this.f6501b = this.f6500a.remove();
            }
            this.f6502c = this.f6501b;
        }
        while (!this.f6501b.hasNext() && !this.f6500a.isEmpty()) {
            this.f6501b = this.f6500a.remove();
        }
    }

    public boolean hasNext() {
        m7065b();
        updateCurrentIterator();
        this.f6502c = this.f6501b;
        return this.f6501b.hasNext();
    }

    public E next() {
        m7065b();
        updateCurrentIterator();
        this.f6502c = this.f6501b;
        return this.f6501b.next();
    }

    public void remove() {
        m7065b();
        if (this.f6501b == null) {
            updateCurrentIterator();
        }
        this.f6502c.remove();
    }
}
