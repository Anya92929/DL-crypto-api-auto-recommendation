package org.apache.commons.collections4.iterators;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.Predicate;

public class FilterListIterator<E> implements ListIterator<E> {

    /* renamed from: a */
    private ListIterator<? extends E> f6493a;

    /* renamed from: b */
    private Predicate<? super E> f6494b;

    /* renamed from: c */
    private E f6495c;

    /* renamed from: d */
    private boolean f6496d = false;

    /* renamed from: e */
    private E f6497e;

    /* renamed from: f */
    private boolean f6498f = false;

    /* renamed from: g */
    private int f6499g = 0;

    public FilterListIterator() {
    }

    public FilterListIterator(ListIterator<? extends E> listIterator) {
        this.f6493a = listIterator;
    }

    public FilterListIterator(ListIterator<? extends E> listIterator, Predicate<? super E> predicate) {
        this.f6493a = listIterator;
        this.f6494b = predicate;
    }

    public FilterListIterator(Predicate<? super E> predicate) {
        this.f6494b = predicate;
    }

    public void add(E e) {
        throw new UnsupportedOperationException("FilterListIterator.add(Object) is not supported.");
    }

    public boolean hasNext() {
        return this.f6496d || m7061b();
    }

    public boolean hasPrevious() {
        return this.f6498f || m7063d();
    }

    public E next() {
        if (this.f6496d || m7061b()) {
            this.f6499g++;
            E e = this.f6495c;
            m7060a();
            return e;
        }
        throw new NoSuchElementException();
    }

    public int nextIndex() {
        return this.f6499g;
    }

    public E previous() {
        if (this.f6498f || m7063d()) {
            this.f6499g--;
            E e = this.f6497e;
            m7062c();
            return e;
        }
        throw new NoSuchElementException();
    }

    public int previousIndex() {
        return this.f6499g - 1;
    }

    public void remove() {
        throw new UnsupportedOperationException("FilterListIterator.remove() is not supported.");
    }

    public void set(E e) {
        throw new UnsupportedOperationException("FilterListIterator.set(Object) is not supported.");
    }

    public ListIterator<? extends E> getListIterator() {
        return this.f6493a;
    }

    public void setListIterator(ListIterator<? extends E> listIterator) {
        this.f6493a = listIterator;
    }

    public Predicate<? super E> getPredicate() {
        return this.f6494b;
    }

    public void setPredicate(Predicate<? super E> predicate) {
        this.f6494b = predicate;
    }

    /* renamed from: a */
    private void m7060a() {
        this.f6495c = null;
        this.f6496d = false;
    }

    /* renamed from: b */
    private boolean m7061b() {
        if (this.f6498f) {
            m7062c();
            if (!m7061b()) {
                return false;
            }
            m7060a();
        }
        if (this.f6493a == null) {
            return false;
        }
        while (this.f6493a.hasNext()) {
            E next = this.f6493a.next();
            if (this.f6494b.evaluate(next)) {
                this.f6495c = next;
                this.f6496d = true;
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m7062c() {
        this.f6497e = null;
        this.f6498f = false;
    }

    /* renamed from: d */
    private boolean m7063d() {
        if (this.f6496d) {
            m7060a();
            if (!m7063d()) {
                return false;
            }
            m7062c();
        }
        if (this.f6493a == null) {
            return false;
        }
        while (this.f6493a.hasPrevious()) {
            E previous = this.f6493a.previous();
            if (this.f6494b.evaluate(previous)) {
                this.f6497e = previous;
                this.f6498f = true;
                return true;
            }
        }
        return false;
    }
}
