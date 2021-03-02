package org.apache.commons.collections4.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections4.list.AbstractLinkedList;

public class NodeCachingLinkedList<E> extends AbstractLinkedList<E> implements Serializable {
    private static final long serialVersionUID = 6897789178562232073L;

    /* renamed from: d */
    private transient AbstractLinkedList.Node<E> f6582d;

    /* renamed from: e */
    private transient int f6583e;

    /* renamed from: f */
    private int f6584f;

    public NodeCachingLinkedList() {
        this(20);
    }

    public NodeCachingLinkedList(Collection<? extends E> collection) {
        super(collection);
        this.f6584f = 20;
    }

    public NodeCachingLinkedList(int i) {
        this.f6584f = i;
        init();
    }

    /* access modifiers changed from: protected */
    public int getMaximumCacheSize() {
        return this.f6584f;
    }

    /* access modifiers changed from: protected */
    public void setMaximumCacheSize(int i) {
        this.f6584f = i;
        shrinkCacheToMaximumSize();
    }

    /* access modifiers changed from: protected */
    public void shrinkCacheToMaximumSize() {
        while (this.f6583e > this.f6584f) {
            getNodeFromCache();
        }
    }

    /* access modifiers changed from: protected */
    public AbstractLinkedList.Node<E> getNodeFromCache() {
        if (this.f6583e == 0) {
            return null;
        }
        AbstractLinkedList.Node<E> node = this.f6582d;
        this.f6582d = node.next;
        node.next = null;
        this.f6583e--;
        return node;
    }

    /* access modifiers changed from: protected */
    public boolean isCacheFull() {
        return this.f6583e >= this.f6584f;
    }

    /* access modifiers changed from: protected */
    public void addNodeToCache(AbstractLinkedList.Node<E> node) {
        if (!isCacheFull()) {
            AbstractLinkedList.Node<E> node2 = this.f6582d;
            node.previous = null;
            node.next = node2;
            node.setValue(null);
            this.f6582d = node;
            this.f6583e++;
        }
    }

    /* access modifiers changed from: protected */
    public AbstractLinkedList.Node<E> createNode(E e) {
        AbstractLinkedList.Node<E> nodeFromCache = getNodeFromCache();
        if (nodeFromCache == null) {
            return super.createNode(e);
        }
        nodeFromCache.setValue(e);
        return nodeFromCache;
    }

    /* access modifiers changed from: protected */
    public void removeNode(AbstractLinkedList.Node<E> node) {
        super.removeNode(node);
        addNodeToCache(node);
    }

    /* access modifiers changed from: protected */
    public void removeAllNodes() {
        int min = Math.min(this.f6570b, this.f6584f - this.f6583e);
        AbstractLinkedList.Node<E> node = this.f6569a.next;
        int i = 0;
        while (i < min) {
            AbstractLinkedList.Node<E> node2 = node.next;
            addNodeToCache(node);
            i++;
            node = node2;
        }
        super.removeAllNodes();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }
}
