package org.apache.commons.collections4.trie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.trie.AbstractBitwiseTrie;

abstract class AbstractPatriciaTrie<K, V> extends AbstractBitwiseTrie<K, V> {
    private static final long serialVersionUID = 5155253417231339498L;

    /* renamed from: a */
    private transient TrieEntry<K, V> f6766a = new TrieEntry<>(null, null, -1);

    /* renamed from: b */
    private volatile transient Set<K> f6767b;

    /* renamed from: c */
    private volatile transient Collection<V> f6768c;

    /* renamed from: d */
    private volatile transient Set<Map.Entry<K, V>> f6769d;

    /* renamed from: e */
    private transient int f6770e = 0;
    protected transient int modCount = 0;

    protected AbstractPatriciaTrie(KeyAnalyzer<? super K> keyAnalyzer) {
        super(keyAnalyzer);
    }

    protected AbstractPatriciaTrie(KeyAnalyzer<? super K> keyAnalyzer, Map<? extends K, ? extends V> map) {
        super(keyAnalyzer);
        putAll(map);
    }

    public void clear() {
        this.f6766a.key = null;
        this.f6766a.bitIndex = -1;
        this.f6766a.value = null;
        this.f6766a.parent = null;
        this.f6766a.left = this.f6766a;
        this.f6766a.right = null;
        this.f6766a.predecessor = this.f6766a;
        this.f6770e = 0;
        m7185e();
    }

    public int size() {
        return this.f6770e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo12361a() {
        this.f6770e++;
        m7185e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo12364b() {
        this.f6770e--;
        m7185e();
    }

    /* renamed from: e */
    private void m7185e() {
        this.modCount++;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("Key cannot be null");
        }
        int b = mo12345b(k);
        if (b == 0) {
            if (this.f6766a.isEmpty()) {
                mo12361a();
            } else {
                m7185e();
            }
            return this.f6766a.setKeyValue(k, v);
        }
        TrieEntry<K, V> a = mo12357a(k, b);
        if (mo12346b(k, a.key)) {
            if (a.isEmpty()) {
                mo12361a();
            } else {
                m7185e();
            }
            return a.setKeyValue(k, v);
        }
        int a2 = mo12342a(k, a.key);
        if (!KeyAnalyzer.m7249a(a2)) {
            if (KeyAnalyzer.m7252d(a2)) {
                mo12358a(new TrieEntry(k, v, a2), b);
                mo12361a();
                return null;
            } else if (KeyAnalyzer.m7251c(a2)) {
                if (this.f6766a.isEmpty()) {
                    mo12361a();
                } else {
                    m7185e();
                }
                return this.f6766a.setKeyValue(k, v);
            } else if (KeyAnalyzer.m7250b(a2) && a != this.f6766a) {
                m7185e();
                return a.setKeyValue(k, v);
            }
        }
        throw new IllegalArgumentException("Failed to put: " + k + " -> " + v + ", " + a2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public TrieEntry<K, V> mo12358a(TrieEntry<K, V> trieEntry, int i) {
        TrieEntry<K, V> trieEntry2 = this.f6766a.left;
        TrieEntry<K, V> trieEntry3 = this.f6766a;
        while (trieEntry2.bitIndex < trieEntry.bitIndex && trieEntry2.bitIndex > trieEntry3.bitIndex) {
            if (!mo12344a(trieEntry.key, trieEntry2.bitIndex, i)) {
                TrieEntry<K, V> trieEntry4 = trieEntry2;
                trieEntry2 = trieEntry2.left;
                trieEntry3 = trieEntry4;
            } else {
                TrieEntry<K, V> trieEntry5 = trieEntry2;
                trieEntry2 = trieEntry2.right;
                trieEntry3 = trieEntry5;
            }
        }
        trieEntry.predecessor = trieEntry;
        if (!mo12344a(trieEntry.key, trieEntry.bitIndex, i)) {
            trieEntry.left = trieEntry;
            trieEntry.right = trieEntry2;
        } else {
            trieEntry.left = trieEntry2;
            trieEntry.right = trieEntry;
        }
        trieEntry.parent = trieEntry3;
        if (trieEntry2.bitIndex >= trieEntry.bitIndex) {
            trieEntry2.parent = trieEntry;
        }
        if (trieEntry2.bitIndex <= trieEntry3.bitIndex) {
            trieEntry2.predecessor = trieEntry;
        }
        if (trieEntry3 == this.f6766a || !mo12344a(trieEntry.key, trieEntry3.bitIndex, i)) {
            trieEntry3.left = trieEntry;
        } else {
            trieEntry3.right = trieEntry;
        }
        return trieEntry;
    }

    public V get(Object obj) {
        TrieEntry c = mo12366c(obj);
        if (c != null) {
            return c.getValue();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public TrieEntry<K, V> mo12366c(Object obj) {
        Object a = mo12343a(obj);
        if (a == null) {
            return null;
        }
        TrieEntry<K, V> a2 = mo12357a(a, mo12345b(a));
        if (a2.isEmpty() || !mo12346b(a, a2.key)) {
            a2 = null;
        }
        return a2;
    }

    public Map.Entry<K, V> select(K k) {
        int b = mo12345b(k);
        C1938h hVar = new C1938h();
        if (!m7182a(this.f6766a.left, -1, k, b, hVar)) {
            return (Map.Entry) hVar.mo12437a();
        }
        return null;
    }

    public K selectKey(K k) {
        Map.Entry select = select(k);
        if (select == null) {
            return null;
        }
        return select.getKey();
    }

    public V selectValue(K k) {
        Map.Entry select = select(k);
        if (select == null) {
            return null;
        }
        return select.getValue();
    }

    /* renamed from: a */
    private boolean m7182a(TrieEntry<K, V> trieEntry, int i, K k, int i2, C1938h<Map.Entry<K, V>> hVar) {
        if (trieEntry.bitIndex > i) {
            if (!mo12344a(k, trieEntry.bitIndex, i2)) {
                if (m7182a(trieEntry.left, trieEntry.bitIndex, k, i2, hVar)) {
                    return m7182a(trieEntry.right, trieEntry.bitIndex, k, i2, hVar);
                }
            } else {
                if (m7182a(trieEntry.right, trieEntry.bitIndex, k, i2, hVar)) {
                    return m7182a(trieEntry.left, trieEntry.bitIndex, k, i2, hVar);
                }
            }
            return false;
        } else if (trieEntry.isEmpty()) {
            return true;
        } else {
            hVar.mo12438a(trieEntry);
            return false;
        }
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        Object a = mo12343a(obj);
        TrieEntry a2 = mo12357a(a, mo12345b(a));
        if (a2.isEmpty() || !mo12346b(a, a2.key)) {
            return false;
        }
        return true;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f6769d == null) {
            this.f6769d = new C1926a();
        }
        return this.f6769d;
    }

    public Set<K> keySet() {
        if (this.f6767b == null) {
            this.f6767b = new C1928b();
        }
        return this.f6767b;
    }

    public Collection<V> values() {
        if (this.f6768c == null) {
            this.f6768c = new C1941k();
        }
        return this.f6768c;
    }

    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        Object a = mo12343a(obj);
        int b = mo12345b(a);
        TrieEntry<K, V> trieEntry = this.f6766a.left;
        TrieEntry<K, V> trieEntry2 = this.f6766a;
        while (trieEntry.bitIndex > trieEntry2.bitIndex) {
            if (!mo12344a(a, trieEntry.bitIndex, b)) {
                TrieEntry<K, V> trieEntry3 = trieEntry;
                trieEntry = trieEntry.left;
                trieEntry2 = trieEntry3;
            } else {
                TrieEntry<K, V> trieEntry4 = trieEntry;
                trieEntry = trieEntry.right;
                trieEntry2 = trieEntry4;
            }
        }
        if (trieEntry.isEmpty() || !mo12346b(a, trieEntry.key)) {
            return null;
        }
        return mo12356a(trieEntry);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public TrieEntry<K, V> mo12357a(K k, int i) {
        TrieEntry<K, V> trieEntry = this.f6766a.left;
        TrieEntry<K, V> trieEntry2 = this.f6766a;
        while (trieEntry.bitIndex > trieEntry2.bitIndex) {
            if (!mo12344a(k, trieEntry.bitIndex, i)) {
                TrieEntry<K, V> trieEntry3 = trieEntry;
                trieEntry = trieEntry.left;
                trieEntry2 = trieEntry3;
            } else {
                TrieEntry<K, V> trieEntry4 = trieEntry;
                trieEntry = trieEntry.right;
                trieEntry2 = trieEntry4;
            }
        }
        return trieEntry;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public V mo12356a(TrieEntry<K, V> trieEntry) {
        if (trieEntry != this.f6766a) {
            if (trieEntry.isInternalNode()) {
                m7187g(trieEntry);
            } else {
                m7186f(trieEntry);
            }
        }
        mo12364b();
        return trieEntry.setKeyValue(null, null);
    }

    /* renamed from: f */
    private void m7186f(TrieEntry<K, V> trieEntry) {
        if (trieEntry == this.f6766a) {
            throw new IllegalArgumentException("Cannot delete root Entry!");
        } else if (!trieEntry.isExternalNode()) {
            throw new IllegalArgumentException(trieEntry + " is not an external Entry!");
        } else {
            TrieEntry<K, V> trieEntry2 = trieEntry.parent;
            TrieEntry<K, V> trieEntry3 = trieEntry.left == trieEntry ? trieEntry.right : trieEntry.left;
            if (trieEntry2.left == trieEntry) {
                trieEntry2.left = trieEntry3;
            } else {
                trieEntry2.right = trieEntry3;
            }
            if (trieEntry3.bitIndex > trieEntry2.bitIndex) {
                trieEntry3.parent = trieEntry2;
            } else {
                trieEntry3.predecessor = trieEntry2;
            }
        }
    }

    /* renamed from: g */
    private void m7187g(TrieEntry<K, V> trieEntry) {
        if (trieEntry == this.f6766a) {
            throw new IllegalArgumentException("Cannot delete root Entry!");
        } else if (!trieEntry.isInternalNode()) {
            throw new IllegalArgumentException(trieEntry + " is not an internal Entry!");
        } else {
            TrieEntry<K, V> trieEntry2 = trieEntry.predecessor;
            trieEntry2.bitIndex = trieEntry.bitIndex;
            TrieEntry<K, V> trieEntry3 = trieEntry2.parent;
            TrieEntry<K, V> trieEntry4 = trieEntry2.left == trieEntry ? trieEntry2.right : trieEntry2.left;
            if (trieEntry2.predecessor == trieEntry2 && trieEntry2.parent != trieEntry) {
                trieEntry2.predecessor = trieEntry2.parent;
            }
            if (trieEntry3.left == trieEntry2) {
                trieEntry3.left = trieEntry4;
            } else {
                trieEntry3.right = trieEntry4;
            }
            if (trieEntry4.bitIndex > trieEntry3.bitIndex) {
                trieEntry4.parent = trieEntry3;
            }
            if (trieEntry.left.parent == trieEntry) {
                trieEntry.left.parent = trieEntry2;
            }
            if (trieEntry.right.parent == trieEntry) {
                trieEntry.right.parent = trieEntry2;
            }
            if (trieEntry.parent.left == trieEntry) {
                trieEntry.parent.left = trieEntry2;
            } else {
                trieEntry.parent.right = trieEntry2;
            }
            trieEntry2.parent = trieEntry.parent;
            trieEntry2.left = trieEntry.left;
            trieEntry2.right = trieEntry.right;
            if (m7183b(trieEntry2.left, trieEntry2)) {
                trieEntry2.left.predecessor = trieEntry2;
            }
            if (m7183b(trieEntry2.right, trieEntry2)) {
                trieEntry2.right.predecessor = trieEntry2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public TrieEntry<K, V> mo12363b(TrieEntry<K, V> trieEntry) {
        if (trieEntry == null) {
            return mo12365c();
        }
        return mo12360a(trieEntry.predecessor, trieEntry, (TrieEntry<K, V>) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public TrieEntry<K, V> mo12360a(TrieEntry<K, V> trieEntry, TrieEntry<K, V> trieEntry2, TrieEntry<K, V> trieEntry3) {
        if (trieEntry2 == null || trieEntry != trieEntry2.predecessor) {
            while (!trieEntry.left.isEmpty() && trieEntry2 != trieEntry.left) {
                if (m7183b(trieEntry.left, trieEntry)) {
                    return trieEntry.left;
                }
                trieEntry = trieEntry.left;
            }
        }
        if (trieEntry.isEmpty() || trieEntry.right == null) {
            return null;
        }
        if (trieEntry2 == trieEntry.right) {
            while (trieEntry == trieEntry.parent.right) {
                if (trieEntry == trieEntry3) {
                    return null;
                }
                trieEntry = trieEntry.parent;
            }
            if (trieEntry == trieEntry3 || trieEntry.parent.right == null) {
                return null;
            }
            if (trieEntry2 != trieEntry.parent.right && m7183b(trieEntry.parent.right, trieEntry.parent)) {
                return trieEntry.parent.right;
            }
            if (trieEntry.parent.right != trieEntry.parent) {
                return mo12360a(trieEntry.parent.right, trieEntry2, trieEntry3);
            }
            return null;
        } else if (m7183b(trieEntry.right, trieEntry)) {
            return trieEntry.right;
        } else {
            return mo12360a(trieEntry.right, trieEntry2, trieEntry3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public TrieEntry<K, V> mo12365c() {
        if (isEmpty()) {
            return null;
        }
        return mo12367c(this.f6766a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public TrieEntry<K, V> mo12367c(TrieEntry<K, V> trieEntry) {
        while (true) {
            TrieEntry<K, V> trieEntry2 = trieEntry.left;
            if (trieEntry2.isEmpty()) {
                trieEntry2 = trieEntry.right;
            }
            if (trieEntry2.bitIndex <= trieEntry.bitIndex) {
                return trieEntry2;
            }
            trieEntry = trieEntry2;
        }
    }

    public Comparator<? super K> comparator() {
        return getKeyAnalyzer();
    }

    public K firstKey() {
        if (size() != 0) {
            return mo12365c().getKey();
        }
        throw new NoSuchElementException();
    }

    public K lastKey() {
        TrieEntry d = mo12369d();
        if (d != null) {
            return d.getKey();
        }
        throw new NoSuchElementException();
    }

    public K nextKey(K k) {
        TrieEntry b;
        if (k == null) {
            throw new NullPointerException();
        }
        TrieEntry c = mo12366c((Object) k);
        if (c == null || (b = mo12363b(c)) == null) {
            return null;
        }
        return b.getKey();
    }

    public K previousKey(K k) {
        TrieEntry e;
        if (k == null) {
            throw new NullPointerException();
        }
        TrieEntry c = mo12366c((Object) k);
        if (c == null || (e = mo12373e(c)) == null) {
            return null;
        }
        return e.getKey();
    }

    public OrderedMapIterator<K, V> mapIterator() {
        return new C1940j();
    }

    public SortedMap<K, V> prefixMap(K k) {
        return m7184c(k, 0, mo12345b(k));
    }

    /* renamed from: c */
    private SortedMap<K, V> m7184c(K k, int i, int i2) {
        int i3 = i + i2;
        if (i3 <= mo12345b(k)) {
            return i3 == 0 ? this : new C1933d(k, i, i2);
        }
        throw new IllegalArgumentException(i + " + " + i2 + " > " + mo12345b(k));
    }

    public SortedMap<K, V> headMap(K k) {
        return new C1934e(this, null, k);
    }

    public SortedMap<K, V> subMap(K k, K k2) {
        return new C1934e(this, k, k2);
    }

    public SortedMap<K, V> tailMap(K k) {
        return new C1934e(this, k, null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public TrieEntry<K, V> mo12370d(K k) {
        int b = mo12345b(k);
        if (b != 0) {
            TrieEntry a = mo12357a(k, b);
            if (mo12346b(k, a.key)) {
                return mo12363b(a);
            }
            int a2 = mo12342a(k, a.key);
            if (KeyAnalyzer.m7252d(a2)) {
                TrieEntry trieEntry = new TrieEntry(k, null, a2);
                mo12358a(trieEntry, b);
                mo12361a();
                TrieEntry<K, V> b2 = mo12363b(trieEntry);
                mo12356a(trieEntry);
                this.modCount -= 2;
                return b2;
            } else if (KeyAnalyzer.m7251c(a2)) {
                if (!this.f6766a.isEmpty()) {
                    return mo12365c();
                }
                if (size() > 1) {
                    return mo12363b(mo12365c());
                }
                return null;
            } else if (KeyAnalyzer.m7250b(a2)) {
                return mo12363b(a);
            } else {
                throw new IllegalStateException("invalid lookup: " + k);
            }
        } else if (this.f6766a.isEmpty()) {
            return mo12365c();
        } else {
            if (size() > 1) {
                return mo12363b(this.f6766a);
            }
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public TrieEntry<K, V> mo12372e(K k) {
        int b = mo12345b(k);
        if (b != 0) {
            TrieEntry<K, V> a = mo12357a(k, b);
            if (mo12346b(k, a.key)) {
                return a;
            }
            int a2 = mo12342a(k, a.key);
            if (KeyAnalyzer.m7252d(a2)) {
                TrieEntry trieEntry = new TrieEntry(k, null, a2);
                mo12358a(trieEntry, b);
                mo12361a();
                TrieEntry<K, V> b2 = mo12363b(trieEntry);
                mo12356a(trieEntry);
                this.modCount -= 2;
                return b2;
            } else if (KeyAnalyzer.m7251c(a2)) {
                if (!this.f6766a.isEmpty()) {
                    return this.f6766a;
                }
                return mo12365c();
            } else if (KeyAnalyzer.m7250b(a2)) {
                return a;
            } else {
                throw new IllegalStateException("invalid lookup: " + k);
            }
        } else if (!this.f6766a.isEmpty()) {
            return this.f6766a;
        } else {
            return mo12365c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public TrieEntry<K, V> mo12374f(K k) {
        int b = mo12345b(k);
        if (b == 0) {
            return null;
        }
        TrieEntry a = mo12357a(k, b);
        if (mo12346b(k, a.key)) {
            return mo12373e(a);
        }
        int a2 = mo12342a(k, a.key);
        if (KeyAnalyzer.m7252d(a2)) {
            TrieEntry trieEntry = new TrieEntry(k, null, a2);
            mo12358a(trieEntry, b);
            mo12361a();
            TrieEntry<K, V> e = mo12373e(trieEntry);
            mo12356a(trieEntry);
            this.modCount -= 2;
            return e;
        } else if (KeyAnalyzer.m7251c(a2)) {
            return null;
        } else {
            if (KeyAnalyzer.m7250b(a2)) {
                return mo12373e(a);
            }
            throw new IllegalStateException("invalid lookup: " + k);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public TrieEntry<K, V> mo12375g(K k) {
        int b = mo12345b(k);
        if (b != 0) {
            TrieEntry<K, V> a = mo12357a(k, b);
            if (mo12346b(k, a.key)) {
                return a;
            }
            int a2 = mo12342a(k, a.key);
            if (KeyAnalyzer.m7252d(a2)) {
                TrieEntry trieEntry = new TrieEntry(k, null, a2);
                mo12358a(trieEntry, b);
                mo12361a();
                TrieEntry<K, V> e = mo12373e(trieEntry);
                mo12356a(trieEntry);
                this.modCount -= 2;
                return e;
            } else if (KeyAnalyzer.m7251c(a2)) {
                if (!this.f6766a.isEmpty()) {
                    return this.f6766a;
                }
                return null;
            } else if (KeyAnalyzer.m7250b(a2)) {
                return a;
            } else {
                throw new IllegalStateException("invalid lookup: " + k);
            }
        } else if (!this.f6766a.isEmpty()) {
            return this.f6766a;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public TrieEntry<K, V> mo12362b(K k, int i, int i2) {
        TrieEntry<K, V> trieEntry;
        TrieEntry<K, V> trieEntry2 = this.f6766a.left;
        TrieEntry<K, V> trieEntry3 = this.f6766a;
        while (trieEntry2.bitIndex > trieEntry3.bitIndex && i2 >= trieEntry2.bitIndex) {
            if (!mo12344a(k, trieEntry2.bitIndex + i, i + i2)) {
                TrieEntry<K, V> trieEntry4 = trieEntry2;
                trieEntry2 = trieEntry2.left;
                trieEntry3 = trieEntry4;
            } else {
                TrieEntry<K, V> trieEntry5 = trieEntry2;
                trieEntry2 = trieEntry2.right;
                trieEntry3 = trieEntry5;
            }
        }
        if (trieEntry2.isEmpty()) {
            trieEntry = trieEntry3;
        } else {
            trieEntry = trieEntry2;
        }
        if (trieEntry.isEmpty()) {
            return null;
        }
        int i3 = i + i2;
        if (trieEntry == this.f6766a && mo12345b(trieEntry.getKey()) < i3) {
            return null;
        }
        if (mo12344a(k, i3, i3) != mo12344a(trieEntry.key, i2, mo12345b(trieEntry.key))) {
            return null;
        }
        int bitIndex = getKeyAnalyzer().bitIndex(k, i, i2, trieEntry.key, 0, mo12345b(trieEntry.getKey()));
        if (bitIndex < 0 || bitIndex >= i2) {
            return trieEntry;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public TrieEntry<K, V> mo12369d() {
        return mo12371d(this.f6766a.left);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public TrieEntry<K, V> mo12371d(TrieEntry<K, V> trieEntry) {
        if (trieEntry.right == null) {
            return null;
        }
        while (trieEntry.right.bitIndex > trieEntry.bitIndex) {
            trieEntry = trieEntry.right;
        }
        return trieEntry.right;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public TrieEntry<K, V> mo12373e(TrieEntry<K, V> trieEntry) {
        if (trieEntry.predecessor == null) {
            throw new IllegalArgumentException("must have come from somewhere!");
        } else if (trieEntry.predecessor.right != trieEntry) {
            TrieEntry<K, V> trieEntry2 = trieEntry.predecessor;
            while (trieEntry2.parent != null && trieEntry2 == trieEntry2.parent.left) {
                trieEntry2 = trieEntry2.parent;
            }
            if (trieEntry2.parent == null) {
                return null;
            }
            if (!m7183b(trieEntry2.parent.left, trieEntry2.parent)) {
                return mo12371d(trieEntry2.parent.left);
            }
            if (trieEntry2.parent.left != this.f6766a) {
                return trieEntry2.parent.left;
            }
            if (this.f6766a.isEmpty()) {
                return null;
            }
            return this.f6766a;
        } else if (m7183b(trieEntry.predecessor.left, trieEntry.predecessor)) {
            return trieEntry.predecessor.left;
        } else {
            return mo12371d(trieEntry.predecessor.left);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public TrieEntry<K, V> mo12359a(TrieEntry<K, V> trieEntry, TrieEntry<K, V> trieEntry2) {
        if (trieEntry == null) {
            return mo12365c();
        }
        return mo12360a(trieEntry.predecessor, trieEntry, trieEntry2);
    }

    /* renamed from: b */
    static boolean m7183b(TrieEntry<?, ?> trieEntry, TrieEntry<?, ?> trieEntry2) {
        return trieEntry != null && trieEntry.bitIndex <= trieEntry2.bitIndex && !trieEntry.isEmpty();
    }

    /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$h */
    static class C1938h<E> {

        /* renamed from: a */
        private E f6809a;

        private C1938h() {
        }

        /* renamed from: a */
        public void mo12438a(E e) {
            this.f6809a = e;
        }

        /* renamed from: a */
        public E mo12437a() {
            return this.f6809a;
        }
    }

    public static class TrieEntry<K, V> extends AbstractBitwiseTrie.C1924a<K, V> {
        private static final long serialVersionUID = 4596023148184140013L;
        protected int bitIndex;
        protected TrieEntry<K, V> left = this;
        protected TrieEntry<K, V> parent = null;
        protected TrieEntry<K, V> predecessor = this;
        protected TrieEntry<K, V> right = null;

        public TrieEntry(K k, V v, int i) {
            super(k, v);
            this.bitIndex = i;
        }

        public boolean isEmpty() {
            return this.key == null;
        }

        public boolean isInternalNode() {
            return (this.left == this || this.right == this) ? false : true;
        }

        public boolean isExternalNode() {
            return !isInternalNode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.bitIndex == -1) {
                sb.append("RootEntry(");
            } else {
                sb.append("Entry(");
            }
            sb.append("key=").append(getKey()).append(" [").append(this.bitIndex).append("], ");
            sb.append("value=").append(getValue()).append(", ");
            if (this.parent == null) {
                sb.append("parent=").append("null");
            } else if (this.parent.bitIndex == -1) {
                sb.append("parent=").append("ROOT");
            } else {
                sb.append("parent=").append(this.parent.getKey()).append(" [").append(this.parent.bitIndex).append("]");
            }
            sb.append(", ");
            if (this.left == null) {
                sb.append("left=").append("null");
            } else if (this.left.bitIndex == -1) {
                sb.append("left=").append("ROOT");
            } else {
                sb.append("left=").append(this.left.getKey()).append(" [").append(this.left.bitIndex).append("]");
            }
            sb.append(", ");
            if (this.right == null) {
                sb.append("right=").append("null");
            } else if (this.right.bitIndex == -1) {
                sb.append("right=").append("ROOT");
            } else {
                sb.append("right=").append(this.right.getKey()).append(" [").append(this.right.bitIndex).append("]");
            }
            sb.append(", ");
            if (this.predecessor != null) {
                if (this.predecessor.bitIndex == -1) {
                    sb.append("predecessor=").append("ROOT");
                } else {
                    sb.append("predecessor=").append(this.predecessor.getKey()).append(" [").append(this.predecessor.bitIndex).append("]");
                }
            }
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$a */
    class C1926a extends AbstractSet<Map.Entry<K, V>> {
        private C1926a() {
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C1927a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            TrieEntry c = AbstractPatriciaTrie.this.mo12366c(((Map.Entry) obj).getKey());
            return c != null && c.equals(obj);
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !contains(obj)) {
                return false;
            }
            AbstractPatriciaTrie.this.remove(((Map.Entry) obj).getKey());
            return true;
        }

        public int size() {
            return AbstractPatriciaTrie.this.size();
        }

        public void clear() {
            AbstractPatriciaTrie.this.clear();
        }

        /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$a$a */
        class C1927a extends AbstractPatriciaTrie<K, V>.C1235i<Map.Entry<K, V>> {
            private C1927a() {
                super();
            }

            /* renamed from: a */
            public Map.Entry<K, V> next() {
                return mo12439b();
            }
        }
    }

    /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$b */
    class C1928b extends AbstractSet<K> {
        private C1928b() {
        }

        public Iterator<K> iterator() {
            return new C1929a();
        }

        public int size() {
            return AbstractPatriciaTrie.this.size();
        }

        public boolean contains(Object obj) {
            return AbstractPatriciaTrie.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            int size = size();
            AbstractPatriciaTrie.this.remove(obj);
            return size != size();
        }

        public void clear() {
            AbstractPatriciaTrie.this.clear();
        }

        /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$b$a */
        class C1929a extends AbstractPatriciaTrie<K, V>.C1235i<K> {
            private C1929a() {
                super();
            }

            public K next() {
                return mo12439b().getKey();
            }
        }
    }

    /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$k */
    class C1941k extends AbstractCollection<V> {
        private C1941k() {
        }

        public Iterator<V> iterator() {
            return new C1942a();
        }

        public int size() {
            return AbstractPatriciaTrie.this.size();
        }

        public boolean contains(Object obj) {
            return AbstractPatriciaTrie.this.containsValue(obj);
        }

        public void clear() {
            AbstractPatriciaTrie.this.clear();
        }

        public boolean remove(Object obj) {
            Iterator it = iterator();
            while (it.hasNext()) {
                if (AbstractBitwiseTrie.m7176c(it.next(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$k$a */
        class C1942a extends AbstractPatriciaTrie<K, V>.C1235i<V> {
            private C1942a() {
                super();
            }

            public V next() {
                return mo12439b().getValue();
            }
        }
    }

    /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$i */
    abstract class C1939i<E> implements Iterator<E> {

        /* renamed from: b */
        protected int f6810b = AbstractPatriciaTrie.this.modCount;

        /* renamed from: c */
        protected TrieEntry<K, V> f6811c;

        /* renamed from: d */
        protected TrieEntry<K, V> f6812d;

        protected C1939i() {
            this.f6811c = AbstractPatriciaTrie.this.mo12363b((TrieEntry) null);
        }

        protected C1939i(TrieEntry<K, V> trieEntry) {
            this.f6811c = trieEntry;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public TrieEntry<K, V> mo12439b() {
            if (this.f6810b != AbstractPatriciaTrie.this.modCount) {
                throw new ConcurrentModificationException();
            }
            TrieEntry<K, V> trieEntry = this.f6811c;
            if (trieEntry == null) {
                throw new NoSuchElementException();
            }
            this.f6811c = mo12401a(trieEntry);
            this.f6812d = trieEntry;
            return trieEntry;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public TrieEntry<K, V> mo12401a(TrieEntry<K, V> trieEntry) {
            return AbstractPatriciaTrie.this.mo12363b(trieEntry);
        }

        public boolean hasNext() {
            return this.f6811c != null;
        }

        public void remove() {
            if (this.f6812d == null) {
                throw new IllegalStateException();
            } else if (this.f6810b != AbstractPatriciaTrie.this.modCount) {
                throw new ConcurrentModificationException();
            } else {
                TrieEntry<K, V> trieEntry = this.f6812d;
                this.f6812d = null;
                AbstractPatriciaTrie.this.mo12356a(trieEntry);
                this.f6810b = AbstractPatriciaTrie.this.modCount;
            }
        }
    }

    /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$j */
    class C1940j extends AbstractPatriciaTrie<K, V>.C1235i<K> implements OrderedMapIterator<K, V> {

        /* renamed from: a */
        protected TrieEntry<K, V> f6814a;

        private C1940j() {
            super();
        }

        public K next() {
            return mo12439b().getKey();
        }

        public K getKey() {
            if (this.f6812d != null) {
                return this.f6812d.getKey();
            }
            throw new IllegalStateException();
        }

        public V getValue() {
            if (this.f6812d != null) {
                return this.f6812d.getValue();
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.f6812d != null) {
                return this.f6812d.setValue(v);
            }
            throw new IllegalStateException();
        }

        public boolean hasPrevious() {
            return this.f6814a != null;
        }

        public K previous() {
            return mo12440a().getKey();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public TrieEntry<K, V> mo12439b() {
            TrieEntry<K, V> b = super.mo12439b();
            this.f6814a = b;
            return b;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public TrieEntry<K, V> mo12440a() {
            if (this.f6810b != AbstractPatriciaTrie.this.modCount) {
                throw new ConcurrentModificationException();
            }
            TrieEntry<K, V> trieEntry = this.f6814a;
            if (trieEntry == null) {
                throw new NoSuchElementException();
            }
            this.f6814a = AbstractPatriciaTrie.this.mo12373e(trieEntry);
            this.f6811c = this.f6812d;
            this.f6812d = trieEntry;
            return this.f6812d;
        }
    }

    /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$g */
    abstract class C1937g extends AbstractMap<K, V> implements SortedMap<K, V> {

        /* renamed from: a */
        private volatile transient Set<Map.Entry<K, V>> f6807a;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract Set<Map.Entry<K, V>> mo12408a();

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract SortedMap<K, V> mo12409a(K k, boolean z, K k2, boolean z2);

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract K mo12412b();

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public abstract K mo12415c();

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public abstract boolean mo12416d();

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public abstract boolean mo12417e();

        private C1937g() {
        }

        public Comparator<? super K> comparator() {
            return AbstractPatriciaTrie.this.comparator();
        }

        public boolean containsKey(Object obj) {
            if (!mo12410a(AbstractPatriciaTrie.this.mo12343a(obj))) {
                return false;
            }
            return AbstractPatriciaTrie.this.containsKey(obj);
        }

        public V remove(Object obj) {
            if (!mo12410a(AbstractPatriciaTrie.this.mo12343a(obj))) {
                return null;
            }
            return AbstractPatriciaTrie.this.remove(obj);
        }

        public V get(Object obj) {
            if (!mo12410a(AbstractPatriciaTrie.this.mo12343a(obj))) {
                return null;
            }
            return AbstractPatriciaTrie.this.get(obj);
        }

        public V put(K k, V v) {
            if (mo12410a(k)) {
                return AbstractPatriciaTrie.this.put(k, v);
            }
            throw new IllegalArgumentException("Key is out of range: " + k);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            if (this.f6807a == null) {
                this.f6807a = mo12408a();
            }
            return this.f6807a;
        }

        public SortedMap<K, V> subMap(K k, K k2) {
            if (!mo12413b(k)) {
                throw new IllegalArgumentException("FromKey is out of range: " + k);
            } else if (mo12413b(k2)) {
                return mo12409a(k, mo12416d(), k2, mo12417e());
            } else {
                throw new IllegalArgumentException("ToKey is out of range: " + k2);
            }
        }

        public SortedMap<K, V> headMap(K k) {
            if (mo12413b(k)) {
                return mo12409a(mo12412b(), mo12416d(), k, mo12417e());
            }
            throw new IllegalArgumentException("ToKey is out of range: " + k);
        }

        public SortedMap<K, V> tailMap(K k) {
            if (mo12413b(k)) {
                return mo12409a(k, mo12416d(), mo12415c(), mo12417e());
            }
            throw new IllegalArgumentException("FromKey is out of range: " + k);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo12410a(K k) {
            Object b = mo12412b();
            Object c = mo12415c();
            if (b != null && !mo12411a(k, false)) {
                return false;
            }
            if (c == null || mo12414b(k, false)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public boolean mo12413b(K k) {
            Object b = mo12412b();
            Object c = mo12415c();
            if (b != null && !mo12411a(k, false)) {
                return false;
            }
            if (c == null || mo12414b(k, true)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo12411a(K k, boolean z) {
            Object b = mo12412b();
            boolean d = mo12416d();
            int compare = AbstractPatriciaTrie.this.getKeyAnalyzer().compare(k, b);
            if (d || z) {
                if (compare >= 0) {
                    return true;
                }
                return false;
            } else if (compare <= 0) {
                return false;
            } else {
                return true;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public boolean mo12414b(K k, boolean z) {
            Object c = mo12415c();
            boolean e = mo12417e();
            int compare = AbstractPatriciaTrie.this.getKeyAnalyzer().compare(k, c);
            if (e || z) {
                if (compare <= 0) {
                    return true;
                }
                return false;
            } else if (compare >= 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$e */
    class C1934e extends AbstractPatriciaTrie<K, V>.C1144g {

        /* renamed from: c */
        private final K f6797c;

        /* renamed from: d */
        private final K f6798d;

        /* renamed from: e */
        private final boolean f6799e;

        /* renamed from: f */
        private final boolean f6800f;

        protected C1934e(AbstractPatriciaTrie abstractPatriciaTrie, K k, K k2) {
            this(k, true, k2, false);
        }

        protected C1934e(K k, boolean z, K k2, boolean z2) {
            super();
            if (k == null && k2 == null) {
                throw new IllegalArgumentException("must have a from or to!");
            } else if (k == null || k2 == null || AbstractPatriciaTrie.this.getKeyAnalyzer().compare(k, k2) <= 0) {
                this.f6797c = k;
                this.f6799e = z;
                this.f6798d = k2;
                this.f6800f = z2;
            } else {
                throw new IllegalArgumentException("fromKey > toKey");
            }
        }

        public K firstKey() {
            TrieEntry d;
            if (this.f6797c == null) {
                d = AbstractPatriciaTrie.this.mo12365c();
            } else if (this.f6799e) {
                d = AbstractPatriciaTrie.this.mo12372e(this.f6797c);
            } else {
                d = AbstractPatriciaTrie.this.mo12370d(this.f6797c);
            }
            K key = d != null ? d.getKey() : null;
            if (d != null && (this.f6798d == null || mo12414b(key, false))) {
                return key;
            }
            throw new NoSuchElementException();
        }

        public K lastKey() {
            TrieEntry f;
            if (this.f6798d == null) {
                f = AbstractPatriciaTrie.this.mo12369d();
            } else if (this.f6800f) {
                f = AbstractPatriciaTrie.this.mo12375g(this.f6798d);
            } else {
                f = AbstractPatriciaTrie.this.mo12374f(this.f6798d);
            }
            K key = f != null ? f.getKey() : null;
            if (f != null && (this.f6797c == null || mo12411a(key, false))) {
                return key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Set<Map.Entry<K, V>> mo12408a() {
            return new C1935f(this);
        }

        /* renamed from: b */
        public K mo12412b() {
            return this.f6797c;
        }

        /* renamed from: c */
        public K mo12415c() {
            return this.f6798d;
        }

        /* renamed from: d */
        public boolean mo12416d() {
            return this.f6799e;
        }

        /* renamed from: e */
        public boolean mo12417e() {
            return this.f6800f;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public SortedMap<K, V> mo12409a(K k, boolean z, K k2, boolean z2) {
            return new C1934e(k, z, k2, z2);
        }
    }

    /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$f */
    class C1935f extends AbstractSet<Map.Entry<K, V>> {

        /* renamed from: a */
        private final AbstractPatriciaTrie<K, V>.C1144g f6801a;

        /* renamed from: c */
        private transient int f6803c = -1;

        /* renamed from: d */
        private transient int f6804d;

        public C1935f(AbstractPatriciaTrie<K, V>.C1144g gVar) {
            if (gVar == null) {
                throw new NullPointerException("delegate");
            }
            this.f6801a = gVar;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            TrieEntry e;
            TrieEntry trieEntry;
            Object b = this.f6801a.mo12412b();
            Object c = this.f6801a.mo12415c();
            if (b == null) {
                e = AbstractPatriciaTrie.this.mo12365c();
            } else {
                e = AbstractPatriciaTrie.this.mo12372e(b);
            }
            if (c != null) {
                trieEntry = AbstractPatriciaTrie.this.mo12372e(c);
            } else {
                trieEntry = null;
            }
            return new C1936a(e, trieEntry);
        }

        public int size() {
            if (this.f6803c == -1 || this.f6804d != AbstractPatriciaTrie.this.modCount) {
                this.f6803c = 0;
                Iterator it = iterator();
                while (it.hasNext()) {
                    this.f6803c++;
                    it.next();
                }
                this.f6804d = AbstractPatriciaTrie.this.modCount;
            }
            return this.f6803c;
        }

        public boolean isEmpty() {
            return !iterator().hasNext();
        }

        public boolean contains(Object obj) {
            TrieEntry c;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            if (!this.f6801a.mo12410a(key) || (c = AbstractPatriciaTrie.this.mo12366c(key)) == null || !AbstractBitwiseTrie.m7176c(c.getValue(), entry.getValue())) {
                return false;
            }
            return true;
        }

        public boolean remove(Object obj) {
            TrieEntry c;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            if (!this.f6801a.mo12410a(key) || (c = AbstractPatriciaTrie.this.mo12366c(key)) == null || !AbstractBitwiseTrie.m7176c(c.getValue(), entry.getValue())) {
                return false;
            }
            AbstractPatriciaTrie.this.mo12356a(c);
            return true;
        }

        /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$f$a */
        final class C1936a extends AbstractPatriciaTrie<K, V>.C1235i<Map.Entry<K, V>> {

            /* renamed from: f */
            private final K f6806f;

            private C1936a(TrieEntry<K, V> trieEntry, TrieEntry<K, V> trieEntry2) {
                super(trieEntry);
                this.f6806f = trieEntry2 != null ? trieEntry2.getKey() : null;
            }

            public boolean hasNext() {
                return this.f6811c != null && !AbstractBitwiseTrie.m7176c(this.f6811c.key, this.f6806f);
            }

            /* renamed from: a */
            public Map.Entry<K, V> next() {
                if (this.f6811c != null && !AbstractBitwiseTrie.m7176c(this.f6811c.key, this.f6806f)) {
                    return mo12439b();
                }
                throw new NoSuchElementException();
            }
        }
    }

    /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$d */
    class C1933d extends AbstractPatriciaTrie<K, V>.C1144g {
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final K f6789c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final int f6790d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final int f6791e;

        /* renamed from: f */
        private K f6792f;

        /* renamed from: g */
        private K f6793g;

        /* renamed from: h */
        private transient int f6794h;

        /* renamed from: i */
        private int f6795i;

        private C1933d(K k, int i, int i2) {
            super();
            this.f6792f = null;
            this.f6793g = null;
            this.f6794h = 0;
            this.f6795i = -1;
            this.f6789c = k;
            this.f6790d = i;
            this.f6791e = i2;
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public int m7215f() {
            TrieEntry trieEntry;
            K k = null;
            if (this.f6795i == -1 || AbstractPatriciaTrie.this.modCount != this.f6794h) {
                Iterator it = super.entrySet().iterator();
                this.f6795i = 0;
                if (it.hasNext()) {
                    this.f6795i = 1;
                    trieEntry = (Map.Entry) it.next();
                } else {
                    trieEntry = null;
                }
                this.f6792f = trieEntry == null ? null : trieEntry.getKey();
                if (this.f6792f != null) {
                    TrieEntry e = AbstractPatriciaTrie.this.mo12373e(trieEntry);
                    this.f6792f = e == null ? null : e.getKey();
                }
                this.f6793g = this.f6792f;
                Map.Entry entry = trieEntry;
                while (it.hasNext()) {
                    this.f6795i++;
                    entry = (Map.Entry) it.next();
                }
                this.f6793g = entry == null ? null : entry.getKey();
                if (this.f6793g != null) {
                    TrieEntry b = AbstractPatriciaTrie.this.mo12363b((TrieEntry) entry);
                    if (b != null) {
                        k = b.getKey();
                    }
                    this.f6793g = k;
                }
                this.f6794h = AbstractPatriciaTrie.this.modCount;
            }
            return this.f6795i;
        }

        public K firstKey() {
            TrieEntry d;
            m7215f();
            if (this.f6792f == null) {
                d = AbstractPatriciaTrie.this.mo12365c();
            } else {
                d = AbstractPatriciaTrie.this.mo12370d(this.f6792f);
            }
            K key = d != null ? d.getKey() : null;
            if (d != null && AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.f6789c, this.f6790d, this.f6791e, key)) {
                return key;
            }
            throw new NoSuchElementException();
        }

        public K lastKey() {
            TrieEntry f;
            m7215f();
            if (this.f6793g == null) {
                f = AbstractPatriciaTrie.this.mo12369d();
            } else {
                f = AbstractPatriciaTrie.this.mo12374f(this.f6793g);
            }
            K key = f != null ? f.getKey() : null;
            if (f != null && AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.f6789c, this.f6790d, this.f6791e, key)) {
                return key;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo12410a(K k) {
            return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.f6789c, this.f6790d, this.f6791e, k);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public boolean mo12413b(K k) {
            return mo12410a(k);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo12411a(K k, boolean z) {
            return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.f6789c, this.f6790d, this.f6791e, k);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public boolean mo12414b(K k, boolean z) {
            return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.f6789c, this.f6790d, this.f6791e, k);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Set<Map.Entry<K, V>> mo12408a() {
            return new C1930c(this);
        }

        /* renamed from: b */
        public K mo12412b() {
            return this.f6792f;
        }

        /* renamed from: c */
        public K mo12415c() {
            return this.f6793g;
        }

        /* renamed from: d */
        public boolean mo12416d() {
            return false;
        }

        /* renamed from: e */
        public boolean mo12417e() {
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public SortedMap<K, V> mo12409a(K k, boolean z, K k2, boolean z2) {
            return new C1934e(k, z, k2, z2);
        }
    }

    /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$c */
    final class C1930c extends AbstractPatriciaTrie<K, V>.C1106f {

        /* renamed from: c */
        private final AbstractPatriciaTrie<K, V>.C1035d f6776c;

        /* renamed from: d */
        private TrieEntry<K, V> f6777d;

        /* renamed from: e */
        private int f6778e = 0;

        public C1930c(AbstractPatriciaTrie<K, V>.C1035d dVar) {
            super(dVar);
            this.f6776c = dVar;
        }

        public int size() {
            return this.f6776c.m7215f();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            if (AbstractPatriciaTrie.this.modCount != this.f6778e) {
                this.f6777d = AbstractPatriciaTrie.this.mo12362b(this.f6776c.f6789c, this.f6776c.f6790d, this.f6776c.f6791e);
                this.f6778e = AbstractPatriciaTrie.this.modCount;
            }
            if (this.f6777d == null) {
                return Collections.emptySet().iterator();
            }
            if (this.f6776c.f6791e >= this.f6777d.bitIndex) {
                return new C1932b(this.f6777d);
            }
            return new C1931a(this.f6777d, this.f6776c.f6789c, this.f6776c.f6790d, this.f6776c.f6791e);
        }

        /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$c$b */
        final class C1932b implements Iterator<Map.Entry<K, V>> {

            /* renamed from: b */
            private final TrieEntry<K, V> f6786b;

            /* renamed from: c */
            private int f6787c = 0;

            public C1932b(TrieEntry<K, V> trieEntry) {
                this.f6786b = trieEntry;
            }

            public boolean hasNext() {
                return this.f6787c == 0;
            }

            /* renamed from: a */
            public Map.Entry<K, V> next() {
                if (this.f6787c != 0) {
                    throw new NoSuchElementException();
                }
                this.f6787c++;
                return this.f6786b;
            }

            public void remove() {
                if (this.f6787c != 1) {
                    throw new IllegalStateException();
                }
                this.f6787c++;
                AbstractPatriciaTrie.this.mo12356a(this.f6786b);
            }
        }

        /* renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$c$a */
        final class C1931a extends AbstractPatriciaTrie<K, V>.C1235i<Map.Entry<K, V>> {

            /* renamed from: f */
            private final K f6780f;

            /* renamed from: g */
            private final int f6781g;

            /* renamed from: h */
            private final int f6782h;

            /* renamed from: i */
            private boolean f6783i;

            /* renamed from: j */
            private TrieEntry<K, V> f6784j;

            C1931a(TrieEntry<K, V> trieEntry, K k, int i, int i2) {
                super();
                this.f6784j = trieEntry;
                this.f6811c = AbstractPatriciaTrie.this.mo12367c(trieEntry);
                this.f6780f = k;
                this.f6781g = i;
                this.f6782h = i2;
            }

            /* renamed from: a */
            public Map.Entry<K, V> next() {
                TrieEntry b = mo12439b();
                if (this.f6783i) {
                    this.f6811c = null;
                }
                return b;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public TrieEntry<K, V> mo12401a(TrieEntry<K, V> trieEntry) {
                return AbstractPatriciaTrie.this.mo12359a(trieEntry, this.f6784j);
            }

            public void remove() {
                boolean z = false;
                int i = this.f6784j.bitIndex;
                if (this.f6812d == this.f6784j) {
                    z = true;
                }
                super.remove();
                if (i != this.f6784j.bitIndex || z) {
                    this.f6784j = AbstractPatriciaTrie.this.mo12362b(this.f6780f, this.f6781g, this.f6782h);
                }
                if (this.f6782h >= this.f6784j.bitIndex) {
                    this.f6783i = true;
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6766a = new TrieEntry<>(null, null, -1);
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }
}
