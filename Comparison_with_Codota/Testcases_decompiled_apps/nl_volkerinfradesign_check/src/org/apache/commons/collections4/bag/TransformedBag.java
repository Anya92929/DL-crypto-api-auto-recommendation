package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.set.TransformedSet;

public class TransformedBag<E> extends TransformedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = 5421170911299074185L;

    public static <E> Bag<E> transformingBag(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        return new TransformedBag(bag, transformer);
    }

    public static <E> Bag<E> transformedBag(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        TransformedBag transformedBag = new TransformedBag(bag, transformer);
        if (!(transformer == null || bag == null || bag.size() <= 0)) {
            Object[] array = bag.toArray();
            bag.clear();
            for (Object transform : array) {
                transformedBag.decorated().add(transformer.transform(transform));
            }
        }
        return transformedBag;
    }

    protected TransformedBag(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        super(bag, transformer);
    }

    /* access modifiers changed from: protected */
    public Bag<E> getBag() {
        return (Bag) decorated();
    }

    public int getCount(Object obj) {
        return getBag().getCount(obj);
    }

    public boolean remove(Object obj, int i) {
        return getBag().remove(obj, i);
    }

    public boolean add(E e, int i) {
        return getBag().add(transform(e), i);
    }

    public Set<E> uniqueSet() {
        return TransformedSet.transformingSet(getBag().uniqueSet(), this.transformer);
    }
}
