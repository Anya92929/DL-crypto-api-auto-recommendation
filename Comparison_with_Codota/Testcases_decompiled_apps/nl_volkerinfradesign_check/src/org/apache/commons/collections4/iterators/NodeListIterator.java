package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeListIterator implements Iterator<Node> {

    /* renamed from: a */
    private final NodeList f6521a;

    /* renamed from: b */
    private int f6522b = 0;

    public NodeListIterator(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("node must not be null!");
        }
        this.f6521a = node.getChildNodes();
    }

    public NodeListIterator(NodeList nodeList) {
        if (nodeList == null) {
            throw new IllegalArgumentException("nodeList must not be null!");
        }
        this.f6521a = nodeList;
    }

    public boolean hasNext() {
        return this.f6521a != null && this.f6522b < this.f6521a.getLength();
    }

    public Node next() {
        if (this.f6521a == null || this.f6522b >= this.f6521a.getLength()) {
            throw new NoSuchElementException("underlying nodeList has no more elements");
        }
        NodeList nodeList = this.f6521a;
        int i = this.f6522b;
        this.f6522b = i + 1;
        return nodeList.item(i);
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() method not supported for a NodeListIterator.");
    }
}
