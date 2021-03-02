package org.apache.commons.collections4.keyvalue;

import java.io.Serializable;
import java.util.Arrays;

public class MultiKey<K> implements Serializable {
    private static final long serialVersionUID = 4465448607415788805L;

    /* renamed from: a */
    private final K[] f6565a;

    /* renamed from: b */
    private transient int f6566b;

    public MultiKey(K k, K k2) {
        this((K[]) new Object[]{k, k2}, false);
    }

    public MultiKey(K k, K k2, K k3) {
        this((K[]) new Object[]{k, k2, k3}, false);
    }

    public MultiKey(K k, K k2, K k3, K k4) {
        this((K[]) new Object[]{k, k2, k3, k4}, false);
    }

    public MultiKey(K k, K k2, K k3, K k4, K k5) {
        this((K[]) new Object[]{k, k2, k3, k4, k5}, false);
    }

    public MultiKey(K[] kArr) {
        this(kArr, true);
    }

    public MultiKey(K[] kArr, boolean z) {
        if (kArr == null) {
            throw new IllegalArgumentException("The array of keys must not be null");
        }
        if (z) {
            this.f6565a = (Object[]) kArr.clone();
        } else {
            this.f6565a = kArr;
        }
        m7070a(kArr);
    }

    public K[] getKeys() {
        return (Object[]) this.f6565a.clone();
    }

    public K getKey(int i) {
        return this.f6565a[i];
    }

    public int size() {
        return this.f6565a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiKey) {
            return Arrays.equals(this.f6565a, ((MultiKey) obj).f6565a);
        }
        return false;
    }

    public int hashCode() {
        return this.f6566b;
    }

    public String toString() {
        return "MultiKey" + Arrays.toString(this.f6565a);
    }

    /* renamed from: a */
    private void m7070a(Object[] objArr) {
        int i = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                i ^= obj.hashCode();
            }
        }
        this.f6566b = i;
    }

    private Object readResolve() {
        m7070a(this.f6565a);
        return this;
    }
}
