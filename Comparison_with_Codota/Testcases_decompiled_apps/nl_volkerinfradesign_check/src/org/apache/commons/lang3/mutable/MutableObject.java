package org.apache.commons.lang3.mutable;

import java.io.Serializable;

public class MutableObject<T> implements Serializable, Mutable<T> {
    private static final long serialVersionUID = 86241875189L;

    /* renamed from: a */
    private T f7149a;

    public MutableObject() {
    }

    public MutableObject(T t) {
        this.f7149a = t;
    }

    public T getValue() {
        return this.f7149a;
    }

    public void setValue(T t) {
        this.f7149a = t;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() == obj.getClass()) {
            return this.f7149a.equals(((MutableObject) obj).f7149a);
        }
        return false;
    }

    public int hashCode() {
        if (this.f7149a == null) {
            return 0;
        }
        return this.f7149a.hashCode();
    }

    public String toString() {
        return this.f7149a == null ? "null" : this.f7149a.toString();
    }
}
