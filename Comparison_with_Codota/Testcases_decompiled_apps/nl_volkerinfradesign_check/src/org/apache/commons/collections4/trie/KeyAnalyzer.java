package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.Comparator;

public abstract class KeyAnalyzer<K> implements Serializable, Comparator<K> {
    public static final int EQUAL_BIT_KEY = -2;
    public static final int NULL_BIT_KEY = -1;
    public static final int OUT_OF_BOUNDS_BIT_KEY = -3;
    private static final long serialVersionUID = -20497563720380683L;

    public abstract int bitIndex(K k, int i, int i2, K k2, int i3, int i4);

    public abstract int bitsPerElement();

    public abstract boolean isBitSet(K k, int i, int i2);

    public abstract boolean isPrefix(K k, int i, int i2, K k2);

    public abstract int lengthInBits(K k);

    /* renamed from: a */
    static boolean m7249a(int i) {
        return i == -3;
    }

    /* renamed from: b */
    static boolean m7250b(int i) {
        return i == -2;
    }

    /* renamed from: c */
    static boolean m7251c(int i) {
        return i == -1;
    }

    /* renamed from: d */
    static boolean m7252d(int i) {
        return i >= 0;
    }

    public int compare(K k, K k2) {
        if (k == null) {
            return k2 == null ? 0 : -1;
        }
        if (k2 == null) {
            return 1;
        }
        return ((Comparable) k).compareTo(k2);
    }
}
