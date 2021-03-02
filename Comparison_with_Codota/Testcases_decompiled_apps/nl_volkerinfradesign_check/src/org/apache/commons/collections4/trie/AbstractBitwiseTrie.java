package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import org.apache.commons.collections4.Trie;
import org.apache.commons.p009io.IOUtils;

public abstract class AbstractBitwiseTrie<K, V> extends AbstractMap<K, V> implements Serializable, Trie<K, V> {
    private static final long serialVersionUID = 5826987063535505652L;

    /* renamed from: a */
    private final KeyAnalyzer<? super K> f6765a;

    protected AbstractBitwiseTrie(KeyAnalyzer<? super K> keyAnalyzer) {
        if (keyAnalyzer == null) {
            throw new NullPointerException("keyAnalyzer");
        }
        this.f6765a = keyAnalyzer;
    }

    /* access modifiers changed from: protected */
    public KeyAnalyzer<? super K> getKeyAnalyzer() {
        return this.f6765a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trie[").append(size()).append("]={\n");
        for (Map.Entry append : entrySet()) {
            sb.append("  ").append(append).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final K mo12343a(Object obj) {
        return obj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final int mo12345b(K k) {
        if (k == null) {
            return 0;
        }
        return this.f6765a.lengthInBits(k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo12344a(K k, int i, int i2) {
        if (k == null) {
            return false;
        }
        return this.f6765a.isBitSet(k, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo12342a(K k, K k2) {
        return this.f6765a.bitIndex(k, 0, mo12345b(k), k2, 0, mo12345b(k2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo12346b(K k, K k2) {
        if (k == null) {
            if (k2 == null) {
                return true;
            }
            return false;
        } else if (k2 == null) {
            return false;
        } else {
            if (this.f6765a.compare(k, k2) != 0) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: c */
    static boolean m7176c(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: org.apache.commons.collections4.trie.AbstractBitwiseTrie$a */
    static abstract class C1924a<K, V> implements Serializable, Map.Entry<K, V> {
        private static final long serialVersionUID = -944364551314110330L;
        protected K key;
        protected V value;

        public C1924a(K k) {
            this.key = k;
        }

        public C1924a(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public V setKeyValue(K k, V v) {
            this.key = k;
            return setValue(v);
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getKey() == null ? 0 : getKey().hashCode();
            if (getValue() != null) {
                i = getValue().hashCode();
            }
            return hashCode ^ i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!AbstractBitwiseTrie.m7176c(this.key, entry.getKey()) || !AbstractBitwiseTrie.m7176c(this.value, entry.getValue())) {
                return false;
            }
            return true;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}
