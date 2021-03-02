package org.apache.commons.collections4.iterators;

import java.util.Iterator;

public abstract class LazyIteratorChain<E> implements Iterator<E> {

    /* renamed from: a */
    private int f6508a = 0;

    /* renamed from: b */
    private boolean f6509b = false;

    /* renamed from: c */
    private Iterator<? extends E> f6510c = null;

    /* renamed from: d */
    private Iterator<? extends E> f6511d = null;

    public abstract Iterator<? extends E> nextIterator(int i);

    /* renamed from: a */
    private void m7067a() {
        if (this.f6508a == 0) {
            int i = this.f6508a + 1;
            this.f6508a = i;
            this.f6510c = nextIterator(i);
            if (this.f6510c == null) {
                this.f6510c = EmptyIterator.emptyIterator();
                this.f6509b = true;
            }
            this.f6511d = this.f6510c;
        }
        while (!this.f6510c.hasNext() && !this.f6509b) {
            int i2 = this.f6508a + 1;
            this.f6508a = i2;
            Iterator<? extends E> nextIterator = nextIterator(i2);
            if (nextIterator != null) {
                this.f6510c = nextIterator;
            } else {
                this.f6509b = true;
            }
        }
    }

    public boolean hasNext() {
        m7067a();
        this.f6511d = this.f6510c;
        return this.f6510c.hasNext();
    }

    public E next() {
        m7067a();
        this.f6511d = this.f6510c;
        return this.f6510c.next();
    }

    public void remove() {
        if (this.f6510c == null) {
            m7067a();
        }
        this.f6511d.remove();
    }
}
