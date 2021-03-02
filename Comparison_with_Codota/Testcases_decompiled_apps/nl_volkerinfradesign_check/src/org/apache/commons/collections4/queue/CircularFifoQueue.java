package org.apache.commons.collections4.queue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.apache.commons.collections4.BoundedCollection;

public class CircularFifoQueue<E> extends AbstractCollection<E> implements Serializable, Queue<E>, BoundedCollection<E> {
    private static final long serialVersionUID = -8423413834657610406L;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public transient E[] f6730a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public transient int f6731b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public transient int f6732c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public transient boolean f6733d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final int f6734e;

    public CircularFifoQueue() {
        this(32);
    }

    public CircularFifoQueue(int i) {
        this.f6731b = 0;
        this.f6732c = 0;
        this.f6733d = false;
        if (i <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        this.f6730a = (Object[]) new Object[i];
        this.f6734e = this.f6730a.length;
    }

    public CircularFifoQueue(Collection<? extends E> collection) {
        this(collection.size());
        addAll(collection);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6730a = (Object[]) new Object[this.f6734e];
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f6730a[i] = objectInputStream.readObject();
        }
        this.f6731b = 0;
        this.f6733d = readInt == this.f6734e;
        if (this.f6733d) {
            this.f6732c = 0;
        } else {
            this.f6732c = readInt;
        }
    }

    public int size() {
        if (this.f6732c < this.f6731b) {
            return (this.f6734e - this.f6731b) + this.f6732c;
        }
        if (this.f6732c != this.f6731b) {
            return this.f6732c - this.f6731b;
        }
        if (this.f6733d) {
            return this.f6734e;
        }
        return 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return false;
    }

    /* renamed from: a */
    private boolean m7161a() {
        return size() == this.f6734e;
    }

    public int maxSize() {
        return this.f6734e;
    }

    public void clear() {
        this.f6733d = false;
        this.f6731b = 0;
        this.f6732c = 0;
        Arrays.fill(this.f6730a, (Object) null);
    }

    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("Attempted to add null object to queue");
        }
        if (m7161a()) {
            remove();
        }
        E[] eArr = this.f6730a;
        int i = this.f6732c;
        this.f6732c = i + 1;
        eArr[i] = e;
        if (this.f6732c >= this.f6734e) {
            this.f6732c = 0;
        }
        if (this.f6732c == this.f6731b) {
            this.f6733d = true;
        }
        return true;
    }

    public E get(int i) {
        int size = size();
        if (i < 0 || i >= size) {
            throw new NoSuchElementException(String.format("The specified index (%1$d) is outside the available range [0, %2$d)", new Object[]{Integer.valueOf(i), Integer.valueOf(size)}));
        }
        return this.f6730a[(this.f6731b + i) % this.f6734e];
    }

    public boolean offer(E e) {
        return add(e);
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    public E element() {
        if (!isEmpty()) {
            return peek();
        }
        throw new NoSuchElementException("queue is empty");
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.f6730a[this.f6731b];
    }

    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        E e = this.f6730a[this.f6731b];
        if (e != null) {
            E[] eArr = this.f6730a;
            int i = this.f6731b;
            this.f6731b = i + 1;
            eArr[i] = null;
            if (this.f6731b >= this.f6734e) {
                this.f6731b = 0;
            }
            this.f6733d = false;
        }
        return e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m7158a(int i) {
        int i2 = i + 1;
        if (i2 >= this.f6734e) {
            return 0;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m7163b(int i) {
        int i2 = i - 1;
        if (i2 < 0) {
            return this.f6734e - 1;
        }
        return i2;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {

            /* renamed from: b */
            private int f6736b = CircularFifoQueue.this.f6731b;

            /* renamed from: c */
            private int f6737c = -1;

            /* renamed from: d */
            private boolean f6738d = CircularFifoQueue.this.f6733d;

            public boolean hasNext() {
                return this.f6738d || this.f6736b != CircularFifoQueue.this.f6732c;
            }

            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f6738d = false;
                this.f6737c = this.f6736b;
                this.f6736b = CircularFifoQueue.this.m7158a(this.f6736b);
                return CircularFifoQueue.this.f6730a[this.f6737c];
            }

            public void remove() {
                if (this.f6737c == -1) {
                    throw new IllegalStateException();
                } else if (this.f6737c == CircularFifoQueue.this.f6731b) {
                    CircularFifoQueue.this.remove();
                    this.f6737c = -1;
                } else {
                    int i = this.f6737c + 1;
                    if (CircularFifoQueue.this.f6731b >= this.f6737c || i >= CircularFifoQueue.this.f6732c) {
                        while (i != CircularFifoQueue.this.f6732c) {
                            if (i >= CircularFifoQueue.this.f6734e) {
                                CircularFifoQueue.this.f6730a[i - 1] = CircularFifoQueue.this.f6730a[0];
                                i = 0;
                            } else {
                                CircularFifoQueue.this.f6730a[CircularFifoQueue.this.m7163b(i)] = CircularFifoQueue.this.f6730a[i];
                                i = CircularFifoQueue.this.m7158a(i);
                            }
                        }
                    } else {
                        System.arraycopy(CircularFifoQueue.this.f6730a, i, CircularFifoQueue.this.f6730a, this.f6737c, CircularFifoQueue.this.f6732c - i);
                    }
                    this.f6737c = -1;
                    int unused = CircularFifoQueue.this.f6732c = CircularFifoQueue.this.m7163b(CircularFifoQueue.this.f6732c);
                    CircularFifoQueue.this.f6730a[CircularFifoQueue.this.f6732c] = null;
                    boolean unused2 = CircularFifoQueue.this.f6733d = false;
                    this.f6736b = CircularFifoQueue.this.m7163b(this.f6736b);
                }
            }
        };
    }
}
