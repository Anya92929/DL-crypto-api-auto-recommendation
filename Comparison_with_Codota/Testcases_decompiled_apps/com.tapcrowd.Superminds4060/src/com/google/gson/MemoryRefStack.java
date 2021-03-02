package com.google.gson;

import java.util.Iterator;
import java.util.Stack;

final class MemoryRefStack {
    private final Stack<ObjectTypePair> stack = new Stack<>();

    MemoryRefStack() {
    }

    public ObjectTypePair push(ObjectTypePair obj) {
        Preconditions.checkNotNull(obj);
        return this.stack.push(obj);
    }

    public ObjectTypePair pop() {
        return this.stack.pop();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public ObjectTypePair peek() {
        return this.stack.peek();
    }

    public boolean contains(ObjectTypePair obj) {
        if (obj == null) {
            return false;
        }
        Iterator i$ = this.stack.iterator();
        while (i$.hasNext()) {
            ObjectTypePair stackObject = (ObjectTypePair) i$.next();
            if (stackObject.getObject() == obj.getObject() && stackObject.type.equals(obj.type)) {
                return true;
            }
        }
        return false;
    }
}
