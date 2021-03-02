package org.apache.commons.collections4.iterators;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator<E> implements Iterator<E> {

    /* renamed from: a */
    private final Collection<? super E> f6486a;

    /* renamed from: b */
    private Enumeration<? extends E> f6487b;

    /* renamed from: c */
    private E f6488c;

    public EnumerationIterator() {
        this((Enumeration) null, (Collection) null);
    }

    public EnumerationIterator(Enumeration<? extends E> enumeration) {
        this(enumeration, (Collection) null);
    }

    public EnumerationIterator(Enumeration<? extends E> enumeration, Collection<? super E> collection) {
        this.f6487b = enumeration;
        this.f6486a = collection;
        this.f6488c = null;
    }

    public boolean hasNext() {
        return this.f6487b.hasMoreElements();
    }

    public E next() {
        this.f6488c = this.f6487b.nextElement();
        return this.f6488c;
    }

    public void remove() {
        if (this.f6486a == null) {
            throw new UnsupportedOperationException("No Collection associated with this Iterator");
        } else if (this.f6488c != null) {
            this.f6486a.remove(this.f6488c);
        } else {
            throw new IllegalStateException("next() must have been called for remove() to function");
        }
    }

    public Enumeration<? extends E> getEnumeration() {
        return this.f6487b;
    }

    public void setEnumeration(Enumeration<? extends E> enumeration) {
        this.f6487b = enumeration;
    }
}
