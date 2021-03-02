package org.apache.commons.lang3.concurrent;

import org.apache.commons.lang3.ObjectUtils;

public class ConstantInitializer<T> implements ConcurrentInitializer<T> {

    /* renamed from: a */
    private final T f7109a;

    public ConstantInitializer(T t) {
        this.f7109a = t;
    }

    public final T getObject() {
        return this.f7109a;
    }

    public T get() throws ConcurrentException {
        return getObject();
    }

    public int hashCode() {
        if (getObject() != null) {
            return getObject().hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConstantInitializer)) {
            return false;
        }
        return ObjectUtils.equals(getObject(), ((ConstantInitializer) obj).getObject());
    }

    public String toString() {
        return String.format("ConstantInitializer@%d [ object = %s ]", new Object[]{Integer.valueOf(System.identityHashCode(this)), String.valueOf(getObject())});
    }
}
