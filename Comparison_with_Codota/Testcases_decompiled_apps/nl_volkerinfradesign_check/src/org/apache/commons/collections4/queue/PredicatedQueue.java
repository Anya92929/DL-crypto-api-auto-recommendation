package org.apache.commons.collections4.queue;

import java.util.Queue;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

public class PredicatedQueue<E> extends PredicatedCollection<E> implements Queue<E> {
    private static final long serialVersionUID = 2307609000539943581L;

    public static <E> PredicatedQueue<E> predicatedQueue(Queue<E> queue, Predicate<? super E> predicate) {
        return new PredicatedQueue<>(queue, predicate);
    }

    protected PredicatedQueue(Queue<E> queue, Predicate<? super E> predicate) {
        super(queue, predicate);
    }

    /* access modifiers changed from: protected */
    public Queue<E> decorated() {
        return (Queue) super.decorated();
    }

    public boolean offer(E e) {
        validate(e);
        return decorated().offer(e);
    }

    public E poll() {
        return decorated().poll();
    }

    public E peek() {
        return decorated().peek();
    }

    public E element() {
        return decorated().element();
    }

    public E remove() {
        return decorated().remove();
    }
}
