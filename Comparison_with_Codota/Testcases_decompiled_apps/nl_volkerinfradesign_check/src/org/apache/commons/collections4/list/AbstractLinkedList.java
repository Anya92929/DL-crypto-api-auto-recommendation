package org.apache.commons.collections4.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.OrderedIterator;

public abstract class AbstractLinkedList<E> implements List<E> {

    /* renamed from: a */
    transient Node<E> f6569a;

    /* renamed from: b */
    transient int f6570b;

    /* renamed from: c */
    transient int f6571c;

    protected AbstractLinkedList() {
    }

    protected AbstractLinkedList(Collection<? extends E> collection) {
        init();
        addAll(collection);
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.f6569a = createHeaderNode();
    }

    public int size() {
        return this.f6570b;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E get(int i) {
        return getNode(i, false).getValue();
    }

    public Iterator<E> iterator() {
        return listIterator();
    }

    public ListIterator<E> listIterator() {
        return new LinkedListIterator(this, 0);
    }

    public ListIterator<E> listIterator(int i) {
        return new LinkedListIterator(this, i);
    }

    public int indexOf(Object obj) {
        int i = 0;
        for (Node<E> node = this.f6569a.next; node != this.f6569a; node = node.next) {
            if (isEqualValue(node.getValue(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        int i = this.f6570b - 1;
        for (Node<E> node = this.f6569a.previous; node != this.f6569a; node = node.previous) {
            if (isEqualValue(node.getValue(), obj)) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public Object[] toArray() {
        return toArray(new Object[this.f6570b]);
    }

    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        if (tArr.length < this.f6570b) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f6570b);
        } else {
            tArr2 = tArr;
        }
        int i = 0;
        Node<E> node = this.f6569a.next;
        while (node != this.f6569a) {
            tArr2[i] = node.getValue();
            node = node.next;
            i++;
        }
        if (tArr2.length > this.f6570b) {
            tArr2[this.f6570b] = null;
        }
        return tArr2;
    }

    public List<E> subList(int i, int i2) {
        return new LinkedSubList(this, i, i2);
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void add(int i, E e) {
        addNodeBefore(getNode(i, true), e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return addAll(this.f6570b, collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        Node node = getNode(i, true);
        for (Object addNodeBefore : collection) {
            addNodeBefore(node, addNodeBefore);
        }
        return true;
    }

    public E remove(int i) {
        Node node = getNode(i, false);
        E value = node.getValue();
        removeNode(node);
        return value;
    }

    public boolean remove(Object obj) {
        for (Node<E> node = this.f6569a.next; node != this.f6569a; node = node.next) {
            if (isEqualValue(node.getValue(), obj)) {
                removeNode(node);
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        Iterator it = iterator();
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        Iterator it = iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public E set(int i, E e) {
        Node node = getNode(i, false);
        E value = node.getValue();
        updateNode(node, e);
        return value;
    }

    public void clear() {
        removeAllNodes();
    }

    public E getFirst() {
        Node<E> node = this.f6569a.next;
        if (node != this.f6569a) {
            return node.getValue();
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        Node<E> node = this.f6569a.previous;
        if (node != this.f6569a) {
            return node.getValue();
        }
        throw new NoSuchElementException();
    }

    public boolean addFirst(E e) {
        addNodeAfter(this.f6569a, e);
        return true;
    }

    public boolean addLast(E e) {
        addNodeBefore(this.f6569a, e);
        return true;
    }

    public E removeFirst() {
        Node<E> node = this.f6569a.next;
        if (node == this.f6569a) {
            throw new NoSuchElementException();
        }
        E value = node.getValue();
        removeNode(node);
        return value;
    }

    public E removeLast() {
        Node<E> node = this.f6569a.previous;
        if (node == this.f6569a) {
            throw new NoSuchElementException();
        }
        E value = node.getValue();
        removeNode(node);
        return value;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() != size()) {
            return false;
        }
        ListIterator listIterator = listIterator();
        ListIterator listIterator2 = list.listIterator();
        while (listIterator.hasNext() && listIterator2.hasNext()) {
            Object next = listIterator.next();
            Object next2 = listIterator2.next();
            if (next == null) {
                if (next2 != null) {
                    return false;
                }
            } else if (!next.equals(next2)) {
                return false;
            }
        }
        if (listIterator.hasNext() || listIterator2.hasNext()) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 1;
        Iterator it = iterator();
        while (it.hasNext()) {
            Object next = it.next();
            i = (next == null ? 0 : next.hashCode()) + (i * 31);
        }
        return i;
    }

    public String toString() {
        if (size() == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(size() * 16);
        sb.append('[');
        Iterator it = iterator();
        boolean hasNext = it.hasNext();
        while (hasNext) {
            Object next = it.next();
            if (next == this) {
                next = "(this Collection)";
            }
            sb.append(next);
            hasNext = it.hasNext();
            if (hasNext) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* access modifiers changed from: protected */
    public void updateNode(Node<E> node, E e) {
        node.setValue(e);
    }

    /* access modifiers changed from: protected */
    public Node<E> createHeaderNode() {
        return new Node<>();
    }

    /* access modifiers changed from: protected */
    public Node<E> createNode(E e) {
        return new Node<>(e);
    }

    /* access modifiers changed from: protected */
    public void addNodeBefore(Node<E> node, E e) {
        addNode(createNode(e), node);
    }

    /* access modifiers changed from: protected */
    public void addNodeAfter(Node<E> node, E e) {
        addNode(createNode(e), node.next);
    }

    /* access modifiers changed from: protected */
    public void addNode(Node<E> node, Node<E> node2) {
        node.next = node2;
        node.previous = node2.previous;
        node2.previous.next = node;
        node2.previous = node;
        this.f6570b++;
        this.f6571c++;
    }

    /* access modifiers changed from: protected */
    public void removeNode(Node<E> node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
        this.f6570b--;
        this.f6571c++;
    }

    /* access modifiers changed from: protected */
    public void removeAllNodes() {
        this.f6569a.next = this.f6569a;
        this.f6569a.previous = this.f6569a;
        this.f6570b = 0;
        this.f6571c++;
    }

    /* access modifiers changed from: protected */
    public Node<E> getNode(int i, boolean z) throws IndexOutOfBoundsException {
        Node<E> node;
        if (i < 0) {
            throw new IndexOutOfBoundsException("Couldn't get the node: index (" + i + ") less than zero.");
        } else if (!z && i == this.f6570b) {
            throw new IndexOutOfBoundsException("Couldn't get the node: index (" + i + ") is the size of the list.");
        } else if (i > this.f6570b) {
            throw new IndexOutOfBoundsException("Couldn't get the node: index (" + i + ") greater than the size of the " + "list (" + this.f6570b + ").");
        } else {
            if (i < this.f6570b / 2) {
                node = this.f6569a.next;
                int i2 = 0;
                while (i2 < i) {
                    i2++;
                    node = node.next;
                }
            } else {
                Node<E> node2 = this.f6569a;
                int i3 = this.f6570b;
                while (i3 > i) {
                    i3--;
                    node2 = node.previous;
                }
            }
            return node;
        }
    }

    /* access modifiers changed from: protected */
    public Iterator<E> createSubListIterator(LinkedSubList<E> linkedSubList) {
        return createSubListListIterator(linkedSubList, 0);
    }

    /* access modifiers changed from: protected */
    public ListIterator<E> createSubListListIterator(LinkedSubList<E> linkedSubList, int i) {
        return new LinkedSubListIterator(linkedSubList, i);
    }

    /* access modifiers changed from: protected */
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    /* access modifiers changed from: protected */
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        init();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            add(objectInputStream.readObject());
        }
    }

    public static class Node<E> {
        protected Node<E> next;
        protected Node<E> previous;
        protected E value;

        protected Node() {
            this.previous = this;
            this.next = this;
        }

        protected Node(E e) {
            this.value = e;
        }

        protected Node(Node<E> node, Node<E> node2, E e) {
            this.previous = node;
            this.next = node2;
            this.value = e;
        }

        /* access modifiers changed from: protected */
        public E getValue() {
            return this.value;
        }

        /* access modifiers changed from: protected */
        public void setValue(E e) {
            this.value = e;
        }

        /* access modifiers changed from: protected */
        public Node<E> getPreviousNode() {
            return this.previous;
        }

        /* access modifiers changed from: protected */
        public void setPreviousNode(Node<E> node) {
            this.previous = node;
        }

        /* access modifiers changed from: protected */
        public Node<E> getNextNode() {
            return this.next;
        }

        /* access modifiers changed from: protected */
        public void setNextNode(Node<E> node) {
            this.next = node;
        }
    }

    public static class LinkedListIterator<E> implements ListIterator<E>, OrderedIterator<E> {
        protected Node<E> current;
        protected int expectedModCount;
        protected Node<E> next;
        protected int nextIndex;
        protected final AbstractLinkedList<E> parent;

        protected LinkedListIterator(AbstractLinkedList<E> abstractLinkedList, int i) throws IndexOutOfBoundsException {
            this.parent = abstractLinkedList;
            this.expectedModCount = abstractLinkedList.f6571c;
            this.next = abstractLinkedList.getNode(i, true);
            this.nextIndex = i;
        }

        /* access modifiers changed from: protected */
        public void checkModCount() {
            if (this.parent.f6571c != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        /* access modifiers changed from: protected */
        public Node<E> getLastNodeReturned() throws IllegalStateException {
            if (this.current != null) {
                return this.current;
            }
            throw new IllegalStateException();
        }

        public boolean hasNext() {
            return this.next != this.parent.f6569a;
        }

        public E next() {
            checkModCount();
            if (!hasNext()) {
                throw new NoSuchElementException("No element at index " + this.nextIndex + ".");
            }
            E value = this.next.getValue();
            this.current = this.next;
            this.next = this.next.next;
            this.nextIndex++;
            return value;
        }

        public boolean hasPrevious() {
            return this.next.previous != this.parent.f6569a;
        }

        public E previous() {
            checkModCount();
            if (!hasPrevious()) {
                throw new NoSuchElementException("Already at start of list.");
            }
            this.next = this.next.previous;
            E value = this.next.getValue();
            this.current = this.next;
            this.nextIndex--;
            return value;
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        public int previousIndex() {
            return nextIndex() - 1;
        }

        public void remove() {
            checkModCount();
            if (this.current == this.next) {
                this.next = this.next.next;
                this.parent.removeNode(getLastNodeReturned());
            } else {
                this.parent.removeNode(getLastNodeReturned());
                this.nextIndex--;
            }
            this.current = null;
            this.expectedModCount++;
        }

        public void set(E e) {
            checkModCount();
            getLastNodeReturned().setValue(e);
        }

        public void add(E e) {
            checkModCount();
            this.parent.addNodeBefore(this.next, e);
            this.current = null;
            this.nextIndex++;
            this.expectedModCount++;
        }
    }

    public static class LinkedSubListIterator<E> extends LinkedListIterator<E> {
        protected final LinkedSubList<E> sub;

        protected LinkedSubListIterator(LinkedSubList<E> linkedSubList, int i) {
            super(linkedSubList.f6572a, linkedSubList.f6573b + i);
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
            LinkedSubList<E> linkedSubList = this.sub;
            linkedSubList.f6574c--;
        }
    }

    public static class LinkedSubList<E> extends AbstractList<E> {

        /* renamed from: a */
        AbstractLinkedList<E> f6572a;

        /* renamed from: b */
        int f6573b;

        /* renamed from: c */
        int f6574c;

        /* renamed from: d */
        int f6575d;

        protected LinkedSubList(AbstractLinkedList<E> abstractLinkedList, int i, int i2) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("fromIndex = " + i);
            } else if (i2 > abstractLinkedList.size()) {
                throw new IndexOutOfBoundsException("toIndex = " + i2);
            } else if (i > i2) {
                throw new IllegalArgumentException("fromIndex(" + i + ") > toIndex(" + i2 + ")");
            } else {
                this.f6572a = abstractLinkedList;
                this.f6573b = i;
                this.f6574c = i2 - i;
                this.f6575d = abstractLinkedList.f6571c;
            }
        }

        public int size() {
            checkModCount();
            return this.f6574c;
        }

        public E get(int i) {
            rangeCheck(i, this.f6574c);
            checkModCount();
            return this.f6572a.get(this.f6573b + i);
        }

        public void add(int i, E e) {
            rangeCheck(i, this.f6574c + 1);
            checkModCount();
            this.f6572a.add(this.f6573b + i, e);
            this.f6575d = this.f6572a.f6571c;
            this.f6574c++;
            this.modCount++;
        }

        public E remove(int i) {
            rangeCheck(i, this.f6574c);
            checkModCount();
            E remove = this.f6572a.remove(this.f6573b + i);
            this.f6575d = this.f6572a.f6571c;
            this.f6574c--;
            this.modCount++;
            return remove;
        }

        public boolean addAll(Collection<? extends E> collection) {
            return addAll(this.f6574c, collection);
        }

        public boolean addAll(int i, Collection<? extends E> collection) {
            rangeCheck(i, this.f6574c + 1);
            int size = collection.size();
            if (size == 0) {
                return false;
            }
            checkModCount();
            this.f6572a.addAll(this.f6573b + i, collection);
            this.f6575d = this.f6572a.f6571c;
            this.f6574c = size + this.f6574c;
            this.modCount++;
            return true;
        }

        public E set(int i, E e) {
            rangeCheck(i, this.f6574c);
            checkModCount();
            return this.f6572a.set(this.f6573b + i, e);
        }

        public void clear() {
            checkModCount();
            Iterator it = iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        public Iterator<E> iterator() {
            checkModCount();
            return this.f6572a.createSubListIterator(this);
        }

        public ListIterator<E> listIterator(int i) {
            rangeCheck(i, this.f6574c + 1);
            checkModCount();
            return this.f6572a.createSubListListIterator(this, i);
        }

        public List<E> subList(int i, int i2) {
            return new LinkedSubList(this.f6572a, this.f6573b + i, this.f6573b + i2);
        }

        /* access modifiers changed from: protected */
        public void rangeCheck(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException("Index '" + i + "' out of bounds for size '" + this.f6574c + "'");
            }
        }

        /* access modifiers changed from: protected */
        public void checkModCount() {
            if (this.f6572a.f6571c != this.f6575d) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
