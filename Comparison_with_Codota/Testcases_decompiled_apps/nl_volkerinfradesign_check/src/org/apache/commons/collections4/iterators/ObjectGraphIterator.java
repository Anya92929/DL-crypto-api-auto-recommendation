package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ArrayStack;
import org.apache.commons.collections4.Transformer;

public class ObjectGraphIterator<E> implements Iterator<E> {

    /* renamed from: a */
    private final ArrayStack<Iterator<? extends E>> f6528a = new ArrayStack<>(8);

    /* renamed from: b */
    private E f6529b;

    /* renamed from: c */
    private final Transformer<? super E, ? extends E> f6530c;

    /* renamed from: d */
    private boolean f6531d = false;

    /* renamed from: e */
    private Iterator<? extends E> f6532e;

    /* renamed from: f */
    private E f6533f;

    /* renamed from: g */
    private Iterator<? extends E> f6534g;

    public ObjectGraphIterator(E e, Transformer<? super E, ? extends E> transformer) {
        if (e instanceof Iterator) {
            this.f6532e = (Iterator) e;
        } else {
            this.f6529b = e;
        }
        this.f6530c = transformer;
    }

    public ObjectGraphIterator(Iterator<? extends E> it) {
        this.f6532e = it;
        this.f6530c = null;
    }

    /* access modifiers changed from: protected */
    public void updateCurrentIterator() {
        if (!this.f6531d) {
            if (this.f6532e != null) {
                findNextByIterator(this.f6532e);
            } else if (this.f6529b != null) {
                if (this.f6530c == null) {
                    findNext(this.f6529b);
                } else {
                    findNext(this.f6530c.transform(this.f6529b));
                }
                this.f6529b = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void findNext(E e) {
        if (e instanceof Iterator) {
            findNextByIterator((Iterator) e);
            return;
        }
        this.f6533f = e;
        this.f6531d = true;
    }

    /* access modifiers changed from: protected */
    public void findNextByIterator(Iterator<? extends E> it) {
        if (it != this.f6532e) {
            if (this.f6532e != null) {
                this.f6528a.push(this.f6532e);
            }
            this.f6532e = it;
        }
        while (this.f6532e.hasNext() && !this.f6531d) {
            Object next = this.f6532e.next();
            if (this.f6530c != null) {
                next = this.f6530c.transform(next);
            }
            findNext(next);
        }
        if (!this.f6531d && !this.f6528a.isEmpty()) {
            this.f6532e = this.f6528a.pop();
            findNextByIterator(this.f6532e);
        }
    }

    public boolean hasNext() {
        updateCurrentIterator();
        return this.f6531d;
    }

    public E next() {
        updateCurrentIterator();
        if (!this.f6531d) {
            throw new NoSuchElementException("No more elements in the iteration");
        }
        this.f6534g = this.f6532e;
        E e = this.f6533f;
        this.f6533f = null;
        this.f6531d = false;
        return e;
    }

    public void remove() {
        if (this.f6534g == null) {
            throw new IllegalStateException("Iterator remove() cannot be called at this time");
        }
        this.f6534g.remove();
        this.f6534g = null;
    }
}
