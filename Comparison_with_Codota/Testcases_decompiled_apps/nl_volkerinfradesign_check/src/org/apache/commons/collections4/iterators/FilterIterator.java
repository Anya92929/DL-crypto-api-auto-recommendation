package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.Predicate;

public class FilterIterator<E> implements Iterator<E> {

    /* renamed from: a */
    private Iterator<? extends E> f6489a;

    /* renamed from: b */
    private Predicate<? super E> f6490b;

    /* renamed from: c */
    private E f6491c;

    /* renamed from: d */
    private boolean f6492d = false;

    public FilterIterator() {
    }

    public FilterIterator(Iterator<? extends E> it) {
        this.f6489a = it;
    }

    public FilterIterator(Iterator<? extends E> it, Predicate<? super E> predicate) {
        this.f6489a = it;
        this.f6490b = predicate;
    }

    public boolean hasNext() {
        return this.f6492d || m7059a();
    }

    public E next() {
        if (this.f6492d || m7059a()) {
            this.f6492d = false;
            return this.f6491c;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (this.f6492d) {
            throw new IllegalStateException("remove() cannot be called");
        }
        this.f6489a.remove();
    }

    public Iterator<? extends E> getIterator() {
        return this.f6489a;
    }

    public void setIterator(Iterator<? extends E> it) {
        this.f6489a = it;
        this.f6491c = null;
        this.f6492d = false;
    }

    public Predicate<? super E> getPredicate() {
        return this.f6490b;
    }

    public void setPredicate(Predicate<? super E> predicate) {
        this.f6490b = predicate;
        this.f6491c = null;
        this.f6492d = false;
    }

    /* renamed from: a */
    private boolean m7059a() {
        while (this.f6489a.hasNext()) {
            E next = this.f6489a.next();
            if (this.f6490b.evaluate(next)) {
                this.f6491c = next;
                this.f6492d = true;
                return true;
            }
        }
        return false;
    }
}
