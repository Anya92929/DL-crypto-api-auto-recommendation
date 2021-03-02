package org.apache.commons.collections4.collection;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

public class PredicatedCollection<E> extends AbstractCollectionDecorator<E> {
    private static final long serialVersionUID = -5259182142076705162L;
    public final Predicate<? super E> predicate;

    public static <T> PredicatedCollection<T> predicatedCollection(Collection<T> collection, Predicate<? super T> predicate2) {
        return new PredicatedCollection<>(collection, predicate2);
    }

    public PredicatedCollection(Collection<E> collection, Predicate<? super E> predicate2) {
        super(collection);
        if (predicate2 == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        }
        this.predicate = predicate2;
        for (E validate : collection) {
            validate(validate);
        }
    }

    public void validate(E e) {
        if (!this.predicate.evaluate(e)) {
            throw new IllegalArgumentException("Cannot add Object '" + e + "' - Predicate '" + this.predicate + "' rejected it");
        }
    }

    public boolean add(E e) {
        validate(e);
        return decorated().add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        for (Object validate : collection) {
            validate(validate);
        }
        return decorated().addAll(collection);
    }
}
