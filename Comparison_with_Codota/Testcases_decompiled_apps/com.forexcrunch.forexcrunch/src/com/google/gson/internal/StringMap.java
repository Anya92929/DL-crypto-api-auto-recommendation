package com.google.gson.internal;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public final class StringMap<V> extends AbstractMap<String, V> {
    private static final Map.Entry[] EMPTY_TABLE = new LinkedEntry[2];
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final int MINIMUM_CAPACITY = 4;
    private static final int seed = new Random().nextInt();
    private Set<Map.Entry<String, V>> entrySet;
    /* access modifiers changed from: private */
    public LinkedEntry<V> header = new LinkedEntry<>();
    private Set<String> keySet;
    /* access modifiers changed from: private */
    public int size;
    private LinkedEntry<V>[] table = ((LinkedEntry[]) EMPTY_TABLE);
    private int threshold = -1;
    private Collection<V> values;

    public int size() {
        return this.size;
    }

    public boolean containsKey(Object key) {
        return (key instanceof String) && getEntry((String) key) != null;
    }

    public V get(Object key) {
        LinkedEntry<V> entry;
        if (!(key instanceof String) || (entry = getEntry((String) key)) == null) {
            return null;
        }
        return entry.value;
    }

    private LinkedEntry<V> getEntry(String key) {
        if (key == null) {
            return null;
        }
        int hash = hash(key);
        LinkedEntry<V>[] tab = this.table;
        for (LinkedEntry<V> e = tab[(tab.length - 1) & hash]; e != null; e = e.next) {
            String eKey = e.key;
            if (eKey == key) {
                return e;
            }
            if (e.hash == hash && key.equals(eKey)) {
                return e;
            }
        }
        return null;
    }

    public V put(String key, V value) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        int hash = hash(key);
        LinkedEntry<V>[] tab = this.table;
        int index = hash & (tab.length - 1);
        LinkedEntry<V> e = tab[index];
        while (e != null) {
            if (e.hash != hash || !key.equals(e.key)) {
                e = e.next;
            } else {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        int i = this.size;
        this.size = i + 1;
        if (i > this.threshold) {
            index = hash & (doubleCapacity().length - 1);
        }
        addNewEntry(key, value, hash, index);
        return null;
    }

    private void addNewEntry(String key, V value, int hash, int index) {
        LinkedEntry<V> header2 = this.header;
        LinkedEntry<V> oldTail = header2.prv;
        LinkedEntry<V> newTail = new LinkedEntry<>(key, value, hash, this.table[index], header2, oldTail);
        LinkedEntry<V>[] linkedEntryArr = this.table;
        header2.prv = newTail;
        oldTail.nxt = newTail;
        linkedEntryArr[index] = newTail;
    }

    private LinkedEntry<V>[] makeTable(int newCapacity) {
        LinkedEntry<V>[] newTable = (LinkedEntry[]) new LinkedEntry[newCapacity];
        this.table = newTable;
        this.threshold = (newCapacity >> 1) + (newCapacity >> 2);
        return newTable;
    }

    private LinkedEntry<V>[] doubleCapacity() {
        LinkedEntry<V>[] oldTable = this.table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {
            return oldTable;
        }
        LinkedEntry<V>[] newTable = makeTable(oldCapacity * 2);
        if (this.size == 0) {
            return newTable;
        }
        for (int j = 0; j < oldCapacity; j++) {
            LinkedEntry<V> e = oldTable[j];
            if (e != null) {
                int highBit = e.hash & oldCapacity;
                LinkedEntry<V> broken = null;
                newTable[j | highBit] = e;
                for (LinkedEntry<V> n = e.next; n != null; n = n.next) {
                    int nextHighBit = n.hash & oldCapacity;
                    if (nextHighBit != highBit) {
                        if (broken == null) {
                            newTable[j | nextHighBit] = n;
                        } else {
                            broken.next = n;
                        }
                        broken = e;
                        highBit = nextHighBit;
                    }
                    e = n;
                }
                if (broken != null) {
                    broken.next = null;
                }
            }
        }
        return newTable;
    }

    public V remove(Object key) {
        if (key == null || !(key instanceof String)) {
            return null;
        }
        int hash = hash((String) key);
        LinkedEntry<V>[] tab = this.table;
        int index = hash & (tab.length - 1);
        LinkedEntry<V> e = tab[index];
        LinkedEntry<V> prev = null;
        while (e != null) {
            if (e.hash != hash || !key.equals(e.key)) {
                prev = e;
                e = e.next;
            } else {
                if (prev == null) {
                    tab[index] = e.next;
                } else {
                    prev.next = e.next;
                }
                this.size--;
                unlink(e);
                return e.value;
            }
        }
        return null;
    }

    private void unlink(LinkedEntry<V> e) {
        e.prv.nxt = e.nxt;
        e.nxt.prv = e.prv;
        e.prv = null;
        e.nxt = null;
    }

    public void clear() {
        if (this.size != 0) {
            Arrays.fill(this.table, (Object) null);
            this.size = 0;
        }
        LinkedEntry<V> header2 = this.header;
        LinkedEntry<V> e = header2.nxt;
        while (e != header2) {
            LinkedEntry<V> nxt = e.nxt;
            e.prv = null;
            e.nxt = null;
            e = nxt;
        }
        header2.prv = header2;
        header2.nxt = header2;
    }

    public Set<String> keySet() {
        Set<String> ks = this.keySet;
        if (ks != null) {
            return ks;
        }
        Set<String> ks2 = new KeySet();
        this.keySet = ks2;
        return ks2;
    }

    public Collection<V> values() {
        Collection<V> vs = this.values;
        if (vs != null) {
            return vs;
        }
        Collection<V> vs2 = new Values();
        this.values = vs2;
        return vs2;
    }

    public Set<Map.Entry<String, V>> entrySet() {
        Set<Map.Entry<String, V>> es = this.entrySet;
        if (es != null) {
            return es;
        }
        Set<Map.Entry<String, V>> es2 = new EntrySet();
        this.entrySet = es2;
        return es2;
    }

    static class LinkedEntry<V> implements Map.Entry<String, V> {
        final int hash;
        final String key;
        LinkedEntry<V> next;
        LinkedEntry<V> nxt;
        LinkedEntry<V> prv;
        V value;

        LinkedEntry() {
            this((String) null, (Object) null, 0, (LinkedEntry) null, (LinkedEntry) null, (LinkedEntry) null);
            this.prv = this;
            this.nxt = this;
        }

        LinkedEntry(String key2, V value2, int hash2, LinkedEntry<V> next2, LinkedEntry<V> nxt2, LinkedEntry<V> prv2) {
            this.key = key2;
            this.value = value2;
            this.hash = hash2;
            this.next = next2;
            this.nxt = nxt2;
            this.prv = prv2;
        }

        public final String getKey() {
            return this.key;
        }

        public final V getValue() {
            return this.value;
        }

        public final V setValue(V value2) {
            V oldValue = this.value;
            this.value = value2;
            return oldValue;
        }

        /* JADX WARNING: Removed duplicated region for block: B:7:0x001f A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r2 = 0
                boolean r3 = r6 instanceof java.util.Map.Entry
                if (r3 != 0) goto L_0x0006
            L_0x0005:
                return r2
            L_0x0006:
                r0 = r6
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getValue()
                java.lang.String r3 = r5.key
                java.lang.Object r4 = r0.getKey()
                boolean r3 = r3.equals(r4)
                if (r3 == 0) goto L_0x0005
                V r3 = r5.value
                if (r3 != 0) goto L_0x0021
                if (r1 != 0) goto L_0x0005
            L_0x001f:
                r2 = 1
                goto L_0x0005
            L_0x0021:
                V r3 = r5.value
                boolean r3 = r3.equals(r1)
                if (r3 == 0) goto L_0x0005
                goto L_0x001f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.StringMap.LinkedEntry.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = this.key == null ? 0 : this.key.hashCode();
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode ^ i;
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }
    }

    /* access modifiers changed from: private */
    public boolean removeMapping(Object key, Object value) {
        if (key == null || !(key instanceof String)) {
            return false;
        }
        int hash = hash((String) key);
        LinkedEntry<V>[] tab = this.table;
        int index = hash & (tab.length - 1);
        LinkedEntry<V> e = tab[index];
        LinkedEntry<V> prev = null;
        while (e != null) {
            if (e.hash != hash || !key.equals(e.key)) {
                prev = e;
                e = e.next;
            } else if (value != null ? !value.equals(e.value) : e.value != null) {
                return false;
            } else {
                if (prev == null) {
                    tab[index] = e.next;
                } else {
                    prev.next = e.next;
                }
                this.size--;
                unlink(e);
                return true;
            }
        }
        return false;
    }

    private abstract class LinkedHashIterator<T> implements Iterator<T> {
        LinkedEntry<V> lastReturned;
        LinkedEntry<V> next;

        private LinkedHashIterator() {
            this.next = StringMap.this.header.nxt;
            this.lastReturned = null;
        }

        public final boolean hasNext() {
            return this.next != StringMap.this.header;
        }

        /* access modifiers changed from: package-private */
        public final LinkedEntry<V> nextEntry() {
            LinkedEntry<V> e = this.next;
            if (e == StringMap.this.header) {
                throw new NoSuchElementException();
            }
            this.next = e.nxt;
            this.lastReturned = e;
            return e;
        }

        public final void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            StringMap.this.remove(this.lastReturned.key);
            this.lastReturned = null;
        }
    }

    private final class KeySet extends AbstractSet<String> {
        private KeySet() {
        }

        public Iterator<String> iterator() {
            return new StringMap<V>.LinkedHashIterator<String>() {
                {
                    StringMap stringMap = StringMap.this;
                }

                public final String next() {
                    return nextEntry().key;
                }
            };
        }

        public int size() {
            return StringMap.this.size;
        }

        public boolean contains(Object o) {
            return StringMap.this.containsKey(o);
        }

        public boolean remove(Object o) {
            int oldSize = StringMap.this.size;
            StringMap.this.remove(o);
            return StringMap.this.size != oldSize;
        }

        public void clear() {
            StringMap.this.clear();
        }
    }

    private final class Values extends AbstractCollection<V> {
        private Values() {
        }

        public Iterator<V> iterator() {
            return new StringMap<V>.LinkedHashIterator<V>() {
                {
                    StringMap stringMap = StringMap.this;
                }

                public final V next() {
                    return nextEntry().value;
                }
            };
        }

        public int size() {
            return StringMap.this.size;
        }

        public boolean contains(Object o) {
            return StringMap.this.containsValue(o);
        }

        public void clear() {
            StringMap.this.clear();
        }
    }

    private final class EntrySet extends AbstractSet<Map.Entry<String, V>> {
        private EntrySet() {
        }

        public Iterator<Map.Entry<String, V>> iterator() {
            return new StringMap<V>.LinkedHashIterator<Map.Entry<String, V>>() {
                {
                    StringMap stringMap = StringMap.this;
                }

                public final Map.Entry<String, V> next() {
                    return nextEntry();
                }
            };
        }

        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            V mappedValue = StringMap.this.get(e.getKey());
            if (mappedValue == null || !mappedValue.equals(e.getValue())) {
                return false;
            }
            return true;
        }

        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            return StringMap.this.removeMapping(e.getKey(), e.getValue());
        }

        public int size() {
            return StringMap.this.size;
        }

        public void clear() {
            StringMap.this.clear();
        }
    }

    private static int hash(String key) {
        int h = seed;
        for (int i = 0; i < key.length(); i++) {
            int h2 = h + key.charAt(i);
            int h3 = (h2 + h2) << 10;
            h = h3 ^ (h3 >>> 6);
        }
        int h4 = h ^ ((h >>> 20) ^ (h >>> 12));
        return ((h4 >>> 7) ^ h4) ^ (h4 >>> 4);
    }
}
