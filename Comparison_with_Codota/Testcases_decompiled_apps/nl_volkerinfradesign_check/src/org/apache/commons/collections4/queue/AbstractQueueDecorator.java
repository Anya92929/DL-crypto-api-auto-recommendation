package org.apache.commons.collections4.queue;

import java.util.Queue;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

public abstract class AbstractQueueDecorator<E> extends AbstractCollectionDecorator<E> implements Queue<E> {
    private static final long serialVersionUID = -2629815475789577029L;

    protected AbstractQueueDecorator() {
    }

    protected AbstractQueueDecorator(Queue<E> queue) {
        super(queue);
    }

    /* access modifiers changed from: protected */
    public Queue<E> decorated() {
        return (Queue) super.decorated();
    }

    public boolean offer(E e) {
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
