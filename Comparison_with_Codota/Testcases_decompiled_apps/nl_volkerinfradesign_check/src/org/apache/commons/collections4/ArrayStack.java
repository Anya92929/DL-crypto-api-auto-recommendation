package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.EmptyStackException;

@Deprecated
public class ArrayStack<E> extends ArrayList<E> {
    private static final long serialVersionUID = 2130079159931574599L;

    public ArrayStack() {
    }

    public ArrayStack(int i) {
        super(i);
    }

    public boolean empty() {
        return isEmpty();
    }

    public E peek() throws EmptyStackException {
        int size = size();
        if (size > 0) {
            return get(size - 1);
        }
        throw new EmptyStackException();
    }

    public E peek(int i) throws EmptyStackException {
        int size = (size() - i) - 1;
        if (size >= 0) {
            return get(size);
        }
        throw new EmptyStackException();
    }

    public E pop() throws EmptyStackException {
        int size = size();
        if (size > 0) {
            return remove(size - 1);
        }
        throw new EmptyStackException();
    }

    public E push(E e) {
        add(e);
        return e;
    }

    public int search(Object obj) {
        int size = size() - 1;
        int i = 1;
        while (size >= 0) {
            Object obj2 = get(size);
            if (obj == null && obj2 == null) {
                return i;
            }
            if (obj != null && obj.equals(obj2)) {
                return i;
            }
            size--;
            i++;
        }
        return -1;
    }
}
