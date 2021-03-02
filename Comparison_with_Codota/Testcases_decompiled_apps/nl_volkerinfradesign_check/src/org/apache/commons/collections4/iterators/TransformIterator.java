package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.Transformer;

public class TransformIterator<I, O> implements Iterator<O> {

    /* renamed from: a */
    private Iterator<? extends I> f6556a;

    /* renamed from: b */
    private Transformer<? super I, ? extends O> f6557b;

    public TransformIterator() {
    }

    public TransformIterator(Iterator<? extends I> it) {
        this.f6556a = it;
    }

    public TransformIterator(Iterator<? extends I> it, Transformer<? super I, ? extends O> transformer) {
        this.f6556a = it;
        this.f6557b = transformer;
    }

    public boolean hasNext() {
        return this.f6556a.hasNext();
    }

    public O next() {
        return transform(this.f6556a.next());
    }

    public void remove() {
        this.f6556a.remove();
    }

    public Iterator<? extends I> getIterator() {
        return this.f6556a;
    }

    public void setIterator(Iterator<? extends I> it) {
        this.f6556a = it;
    }

    public Transformer<? super I, ? extends O> getTransformer() {
        return this.f6557b;
    }

    public void setTransformer(Transformer<? super I, ? extends O> transformer) {
        this.f6557b = transformer;
    }

    /* access modifiers changed from: protected */
    public O transform(I i) {
        return this.f6557b.transform(i);
    }
}
