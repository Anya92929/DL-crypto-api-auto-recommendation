package org.apache.commons.collections4.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.list.AbstractLinkedList;

public class CursorableLinkedList<E> extends AbstractLinkedList<E> implements Serializable {
    private static final long serialVersionUID = 8836393098519411393L;

    /* renamed from: d */
    private transient List<WeakReference<Cursor<E>>> f6576d;

    public CursorableLinkedList() {
        init();
    }

    public CursorableLinkedList(Collection<? extends E> collection) {
        super(collection);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.f6576d = new ArrayList();
    }

    public Iterator<E> iterator() {
        return super.listIterator(0);
    }

    public ListIterator<E> listIterator() {
        return cursor(0);
    }

    public ListIterator<E> listIterator(int i) {
        return cursor(i);
    }

    public Cursor<E> cursor() {
        return cursor(0);
    }

    public Cursor<E> cursor(int i) {
        Cursor<E> cursor = new Cursor<>(this, i);
        registerCursor(cursor);
        return cursor;
    }

    /* access modifiers changed from: protected */
    public void updateNode(AbstractLinkedList.Node<E> node, E e) {
        super.updateNode(node, e);
        broadcastNodeChanged(node);
    }

    /* access modifiers changed from: protected */
    public void addNode(AbstractLinkedList.Node<E> node, AbstractLinkedList.Node<E> node2) {
        super.addNode(node, node2);
        broadcastNodeInserted(node);
    }

    /* access modifiers changed from: protected */
    public void removeNode(AbstractLinkedList.Node<E> node) {
        super.removeNode(node);
        broadcastNodeRemoved(node);
    }

    /* access modifiers changed from: protected */
    public void removeAllNodes() {
        if (size() > 0) {
            Iterator it = iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void registerCursor(Cursor<E> cursor) {
        Iterator<WeakReference<Cursor<E>>> it = this.f6576d.iterator();
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            }
        }
        this.f6576d.add(new WeakReference(cursor));
    }

    /* access modifiers changed from: protected */
    public void unregisterCursor(Cursor<E> cursor) {
        Iterator<WeakReference<Cursor<E>>> it = this.f6576d.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            Cursor<E> cursor2 = (Cursor) next.get();
            if (cursor2 == null) {
                it.remove();
            } else if (cursor2 == cursor) {
                next.clear();
                it.remove();
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void broadcastNodeChanged(AbstractLinkedList.Node<E> node) {
        Iterator<WeakReference<Cursor<E>>> it = this.f6576d.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) it.next().get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeChanged(node);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void broadcastNodeRemoved(AbstractLinkedList.Node<E> node) {
        Iterator<WeakReference<Cursor<E>>> it = this.f6576d.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) it.next().get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeRemoved(node);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void broadcastNodeInserted(AbstractLinkedList.Node<E> node) {
        Iterator<WeakReference<Cursor<E>>> it = this.f6576d.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) it.next().get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeInserted(node);
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    /* access modifiers changed from: protected */
    public ListIterator<E> createSubListListIterator(AbstractLinkedList.LinkedSubList<E> linkedSubList, int i) {
        SubCursor subCursor = new SubCursor(linkedSubList, i);
        registerCursor(subCursor);
        return subCursor;
    }

    public static class Cursor<E> extends AbstractLinkedList.LinkedListIterator<E> {

        /* renamed from: a */
        boolean f6577a;

        /* renamed from: b */
        boolean f6578b;

        /* renamed from: c */
        boolean f6579c;

        public /* bridge */ /* synthetic */ boolean hasNext() {
            return super.hasNext();
        }

        public /* bridge */ /* synthetic */ boolean hasPrevious() {
            return super.hasPrevious();
        }

        public /* bridge */ /* synthetic */ Object next() {
            return super.next();
        }

        public /* bridge */ /* synthetic */ Object previous() {
            return super.previous();
        }

        public /* bridge */ /* synthetic */ int previousIndex() {
            return super.previousIndex();
        }

        public /* bridge */ /* synthetic */ void set(Object obj) {
            super.set(obj);
        }

        protected Cursor(CursorableLinkedList<E> cursorableLinkedList, int i) {
            super(cursorableLinkedList, i);
            this.f6577a = true;
            this.f6578b = true;
            this.f6579c = false;
            this.f6577a = true;
        }

        public void remove() {
            if (this.current != null || !this.f6579c) {
                checkModCount();
                this.parent.removeNode(getLastNodeReturned());
            }
            this.f6579c = false;
        }

        public void add(E e) {
            super.add(e);
            this.next = this.next.next;
        }

        public int nextIndex() {
            if (!this.f6578b) {
                if (this.next == this.parent.f6569a) {
                    this.nextIndex = this.parent.size();
                } else {
                    int i = 0;
                    for (AbstractLinkedList.Node<E> node = this.parent.f6569a.next; node != this.next; node = node.next) {
                        i++;
                    }
                    this.nextIndex = i;
                }
                this.f6578b = true;
            }
            return this.nextIndex;
        }

        /* access modifiers changed from: protected */
        public void nodeChanged(AbstractLinkedList.Node<E> node) {
        }

        /* access modifiers changed from: protected */
        public void nodeRemoved(AbstractLinkedList.Node<E> node) {
            if (node == this.next && node == this.current) {
                this.next = node.next;
                this.current = null;
                this.f6579c = true;
            } else if (node == this.next) {
                this.next = node.next;
                this.f6579c = false;
            } else if (node == this.current) {
                this.current = null;
                this.f6579c = true;
                this.nextIndex--;
            } else {
                this.f6578b = false;
                this.f6579c = false;
            }
        }

        /* access modifiers changed from: protected */
        public void nodeInserted(AbstractLinkedList.Node<E> node) {
            if (node.previous == this.current) {
                this.next = node;
            } else if (this.next.previous == node) {
                this.next = node;
            } else {
                this.f6578b = false;
            }
        }

        /* access modifiers changed from: protected */
        public void checkModCount() {
            if (!this.f6577a) {
                throw new ConcurrentModificationException("Cursor closed");
            }
        }

        public void close() {
            if (this.f6577a) {
                ((CursorableLinkedList) this.parent).unregisterCursor(this);
                this.f6577a = false;
            }
        }
    }

    public static class SubCursor<E> extends Cursor<E> {
        protected final AbstractLinkedList.LinkedSubList<E> sub;

        protected SubCursor(AbstractLinkedList.LinkedSubList<E> linkedSubList, int i) {
            super((CursorableLinkedList) linkedSubList.f6572a, linkedSubList.f6573b + i);
            this.sub = linkedSubList;
        }

        public boolean hasNext() {
            return nextIndex() < this.sub.f6574c;
        }

        public boolean hasPrevious() {
            return previousIndex() >= 0;
        }

        public int nextIndex() {
            return super.nextIndex() - this.sub.f6573b;
        }

        public void add(E e) {
            super.add(e);
            this.sub.f6575d = this.parent.f6571c;
            this.sub.f6574c++;
        }

        public void remove() {
            super.remove();
            this.sub.f6575d = this.parent.f6571c;
            AbstractLinkedList.LinkedSubList<E> linkedSubList = this.sub;
            linkedSubList.f6574c--;
        }
    }
}
