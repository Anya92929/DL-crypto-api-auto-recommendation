package org.apache.commons.collections4.map;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

public class AbstractHashedMap<K, V> extends AbstractMap<K, V> implements IterableMap<K, V> {
    protected static final int DEFAULT_CAPACITY = 16;
    protected static final float DEFAULT_LOAD_FACTOR = 0.75f;
    protected static final int DEFAULT_THRESHOLD = 12;
    protected static final String GETKEY_INVALID = "getKey() can only be called after next() and before remove()";
    protected static final String GETVALUE_INVALID = "getValue() can only be called after next() and before remove()";
    protected static final int MAXIMUM_CAPACITY = 1073741824;
    protected static final String NO_NEXT_ENTRY = "No next() entry in the iteration";
    protected static final String NO_PREVIOUS_ENTRY = "No previous() entry in the iteration";
    protected static final Object NULL = new Object();
    protected static final String REMOVE_INVALID = "remove() can only be called once after next()";
    protected static final String SETVALUE_INVALID = "setValue() can only be called after next() and before remove()";

    /* renamed from: a */
    transient float f6607a;

    /* renamed from: b */
    transient int f6608b;

    /* renamed from: c */
    transient HashEntry<K, V>[] f6609c;

    /* renamed from: d */
    transient int f6610d;

    /* renamed from: e */
    transient int f6611e;

    /* renamed from: f */
    transient EntrySet<K, V> f6612f;

    /* renamed from: g */
    transient KeySet<K> f6613g;

    /* renamed from: h */
    transient Values<V> f6614h;

    protected AbstractHashedMap() {
    }

    protected AbstractHashedMap(int i, float f, int i2) {
        this.f6607a = f;
        this.f6609c = new HashEntry[i];
        this.f6610d = i2;
        init();
    }

    protected AbstractHashedMap(int i) {
        this(i, DEFAULT_LOAD_FACTOR);
    }

    protected AbstractHashedMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("Initial capacity must be a non negative number");
        } else if (f <= BitmapDescriptorFactory.HUE_RED || Float.isNaN(f)) {
            throw new IllegalArgumentException("Load factor must be greater than 0");
        } else {
            this.f6607a = f;
            int calculateNewCapacity = calculateNewCapacity(i);
            this.f6610d = calculateThreshold(calculateNewCapacity, f);
            this.f6609c = new HashEntry[calculateNewCapacity];
            init();
        }
    }

    protected AbstractHashedMap(Map<? extends K, ? extends V> map) {
        this(Math.max(map.size() * 2, 16), DEFAULT_LOAD_FACTOR);
        m7112a(map);
    }

    /* access modifiers changed from: protected */
    public void init() {
    }

    public V get(Object obj) {
        Object convertKey = convertKey(obj);
        int hash = hash(convertKey);
        for (HashEntry<K, V> hashEntry = this.f6609c[hashIndex(hash, this.f6609c.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(convertKey, hashEntry.key)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public int size() {
        return this.f6608b;
    }

    public boolean isEmpty() {
        return this.f6608b == 0;
    }

    public boolean containsKey(Object obj) {
        Object convertKey = convertKey(obj);
        int hash = hash(convertKey);
        for (HashEntry<K, V> hashEntry = this.f6609c[hashIndex(hash, this.f6609c.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(convertKey, hashEntry.key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            for (HashEntry<K, V> hashEntry : this.f6609c) {
                while (hashEntry != null) {
                    if (hashEntry.getValue() == null) {
                        return true;
                    }
                    hashEntry = hashEntry.next;
                }
            }
        } else {
            for (HashEntry<K, V> hashEntry2 : this.f6609c) {
                while (hashEntry2 != null) {
                    if (isEqualValue(obj, hashEntry2.getValue())) {
                        return true;
                    }
                    hashEntry2 = hashEntry2.next;
                }
            }
        }
        return false;
    }

    public V put(K k, V v) {
        Object convertKey = convertKey(k);
        int hash = hash(convertKey);
        int hashIndex = hashIndex(hash, this.f6609c.length);
        HashEntry<K, V> hashEntry = this.f6609c[hashIndex];
        while (hashEntry != null) {
            if (hashEntry.hashCode != hash || !isEqualKey(convertKey, hashEntry.key)) {
                hashEntry = hashEntry.next;
            } else {
                V value = hashEntry.getValue();
                updateEntry(hashEntry, v);
                return value;
            }
        }
        addMapping(hashIndex, hash, k, v);
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m7112a(map);
    }

    /* renamed from: a */
    private void m7112a(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size != 0) {
            ensureCapacity(calculateNewCapacity((int) ((((float) (size + this.f6608b)) / this.f6607a) + 1.0f)));
            for (Map.Entry next : map.entrySet()) {
                put(next.getKey(), next.getValue());
            }
        }
    }

    public V remove(Object obj) {
        Object convertKey = convertKey(obj);
        int hash = hash(convertKey);
        int hashIndex = hashIndex(hash, this.f6609c.length);
        HashEntry<K, V> hashEntry = this.f6609c[hashIndex];
        HashEntry<K, V> hashEntry2 = null;
        while (hashEntry != null) {
            if (hashEntry.hashCode != hash || !isEqualKey(convertKey, hashEntry.key)) {
                HashEntry<K, V> hashEntry3 = hashEntry;
                hashEntry = hashEntry.next;
                hashEntry2 = hashEntry3;
            } else {
                V value = hashEntry.getValue();
                removeMapping(hashEntry, hashIndex, hashEntry2);
                return value;
            }
        }
        return null;
    }

    public void clear() {
        this.f6611e++;
        HashEntry<K, V>[] hashEntryArr = this.f6609c;
        for (int length = hashEntryArr.length - 1; length >= 0; length--) {
            hashEntryArr[length] = null;
        }
        this.f6608b = 0;
    }

    /* access modifiers changed from: protected */
    public Object convertKey(Object obj) {
        return obj == null ? NULL : obj;
    }

    /* access modifiers changed from: protected */
    public int hash(Object obj) {
        int hashCode = obj.hashCode();
        int i = hashCode + ((hashCode << 9) ^ -1);
        int i2 = i ^ (i >>> 14);
        int i3 = i2 + (i2 << 4);
        return i3 ^ (i3 >>> 10);
    }

    /* access modifiers changed from: protected */
    public boolean isEqualKey(Object obj, Object obj2) {
        return obj == obj2 || obj.equals(obj2);
    }

    /* access modifiers changed from: protected */
    public boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2 || obj.equals(obj2);
    }

    /* access modifiers changed from: protected */
    public int hashIndex(int i, int i2) {
        return (i2 - 1) & i;
    }

    /* access modifiers changed from: protected */
    public HashEntry<K, V> getEntry(Object obj) {
        Object convertKey = convertKey(obj);
        int hash = hash(convertKey);
        for (HashEntry<K, V> hashEntry = this.f6609c[hashIndex(hash, this.f6609c.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(convertKey, hashEntry.key)) {
                return hashEntry;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void updateEntry(HashEntry<K, V> hashEntry, V v) {
        hashEntry.setValue(v);
    }

    /* access modifiers changed from: protected */
    public void reuseEntry(HashEntry<K, V> hashEntry, int i, int i2, K k, V v) {
        hashEntry.next = this.f6609c[i];
        hashEntry.hashCode = i2;
        hashEntry.key = k;
        hashEntry.value = v;
    }

    /* access modifiers changed from: protected */
    public void addMapping(int i, int i2, K k, V v) {
        this.f6611e++;
        addEntry(createEntry(this.f6609c[i], i2, k, v), i);
        this.f6608b++;
        checkCapacity();
    }

    /* access modifiers changed from: protected */
    public HashEntry<K, V> createEntry(HashEntry<K, V> hashEntry, int i, K k, V v) {
        return new HashEntry<>(hashEntry, i, convertKey(k), v);
    }

    /* access modifiers changed from: protected */
    public void addEntry(HashEntry<K, V> hashEntry, int i) {
        this.f6609c[i] = hashEntry;
    }

    /* access modifiers changed from: protected */
    public void removeMapping(HashEntry<K, V> hashEntry, int i, HashEntry<K, V> hashEntry2) {
        this.f6611e++;
        removeEntry(hashEntry, i, hashEntry2);
        this.f6608b--;
        destroyEntry(hashEntry);
    }

    /* access modifiers changed from: protected */
    public void removeEntry(HashEntry<K, V> hashEntry, int i, HashEntry<K, V> hashEntry2) {
        if (hashEntry2 == null) {
            this.f6609c[i] = hashEntry.next;
        } else {
            hashEntry2.next = hashEntry.next;
        }
    }

    /* access modifiers changed from: protected */
    public void destroyEntry(HashEntry<K, V> hashEntry) {
        hashEntry.next = null;
        hashEntry.key = null;
        hashEntry.value = null;
    }

    /* access modifiers changed from: protected */
    public void checkCapacity() {
        int length;
        if (this.f6608b >= this.f6610d && (length = this.f6609c.length * 2) <= MAXIMUM_CAPACITY) {
            ensureCapacity(length);
        }
    }

    /* access modifiers changed from: protected */
    public void ensureCapacity(int i) {
        int length = this.f6609c.length;
        if (i > length) {
            if (this.f6608b == 0) {
                this.f6610d = calculateThreshold(i, this.f6607a);
                this.f6609c = new HashEntry[i];
                return;
            }
            HashEntry<K, V>[] hashEntryArr = this.f6609c;
            HashEntry<K, V>[] hashEntryArr2 = new HashEntry[i];
            this.f6611e++;
            for (int i2 = length - 1; i2 >= 0; i2--) {
                HashEntry<K, V> hashEntry = hashEntryArr[i2];
                if (hashEntry != null) {
                    hashEntryArr[i2] = null;
                    while (true) {
                        HashEntry<K, V> hashEntry2 = hashEntry.next;
                        int hashIndex = hashIndex(hashEntry.hashCode, i);
                        hashEntry.next = hashEntryArr2[hashIndex];
                        hashEntryArr2[hashIndex] = hashEntry;
                        if (hashEntry2 == null) {
                            break;
                        }
                        hashEntry = hashEntry2;
                    }
                }
            }
            this.f6610d = calculateThreshold(i, this.f6607a);
            this.f6609c = hashEntryArr2;
        }
    }

    /* access modifiers changed from: protected */
    public int calculateNewCapacity(int i) {
        int i2 = 1;
        if (i > MAXIMUM_CAPACITY) {
            return MAXIMUM_CAPACITY;
        }
        while (i2 < i) {
            i2 <<= 1;
        }
        if (i2 <= MAXIMUM_CAPACITY) {
            return i2;
        }
        return MAXIMUM_CAPACITY;
    }

    /* access modifiers changed from: protected */
    public int calculateThreshold(int i, float f) {
        return (int) (((float) i) * f);
    }

    /* access modifiers changed from: protected */
    public HashEntry<K, V> entryNext(HashEntry<K, V> hashEntry) {
        return hashEntry.next;
    }

    /* access modifiers changed from: protected */
    public int entryHashCode(HashEntry<K, V> hashEntry) {
        return hashEntry.hashCode;
    }

    /* access modifiers changed from: protected */
    public K entryKey(HashEntry<K, V> hashEntry) {
        return hashEntry.getKey();
    }

    /* access modifiers changed from: protected */
    public V entryValue(HashEntry<K, V> hashEntry) {
        return hashEntry.getValue();
    }

    public MapIterator<K, V> mapIterator() {
        if (this.f6608b == 0) {
            return EmptyMapIterator.emptyMapIterator();
        }
        return new HashMapIterator(this);
    }

    public static class HashMapIterator<K, V> extends HashIterator<K, V> implements MapIterator<K, V> {
        protected HashMapIterator(AbstractHashedMap<K, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        public K next() {
            return super.nextEntry().getKey();
        }

        public K getKey() {
            HashEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.getKey();
            }
            throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
        }

        public V getValue() {
            HashEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.getValue();
            }
            throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
        }

        public V setValue(V v) {
            HashEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.setValue(v);
            }
            throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f6612f == null) {
            this.f6612f = new EntrySet<>(this);
        }
        return this.f6612f;
    }

    /* access modifiers changed from: protected */
    public Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        if (size() == 0) {
            return EmptyIterator.emptyIterator();
        }
        return new EntrySetIterator(this);
    }

    public static class EntrySet<K, V> extends AbstractSet<Map.Entry<K, V>> {

        /* renamed from: a */
        private final AbstractHashedMap<K, V> f6615a;

        protected EntrySet(AbstractHashedMap<K, V> abstractHashedMap) {
            this.f6615a = abstractHashedMap;
        }

        public int size() {
            return this.f6615a.size();
        }

        public void clear() {
            this.f6615a.clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            HashEntry<K, V> entry2 = this.f6615a.getEntry(entry.getKey());
            if (entry2 == null || !entry2.equals(entry)) {
                return false;
            }
            return true;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !contains(obj)) {
                return false;
            }
            this.f6615a.remove(((Map.Entry) obj).getKey());
            return true;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return this.f6615a.createEntrySetIterator();
        }
    }

    public static class EntrySetIterator<K, V> extends HashIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        protected EntrySetIterator(AbstractHashedMap<K, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        public Map.Entry<K, V> next() {
            return super.nextEntry();
        }
    }

    public Set<K> keySet() {
        if (this.f6613g == null) {
            this.f6613g = new KeySet<>(this);
        }
        return this.f6613g;
    }

    /* access modifiers changed from: protected */
    public Iterator<K> createKeySetIterator() {
        if (size() == 0) {
            return EmptyIterator.emptyIterator();
        }
        return new KeySetIterator(this);
    }

    public static class KeySet<K> extends AbstractSet<K> {

        /* renamed from: a */
        private final AbstractHashedMap<K, ?> f6621a;

        protected KeySet(AbstractHashedMap<K, ?> abstractHashedMap) {
            this.f6621a = abstractHashedMap;
        }

        public int size() {
            return this.f6621a.size();
        }

        public void clear() {
            this.f6621a.clear();
        }

        public boolean contains(Object obj) {
            return this.f6621a.containsKey(obj);
        }

        public boolean remove(Object obj) {
            boolean containsKey = this.f6621a.containsKey(obj);
            this.f6621a.remove(obj);
            return containsKey;
        }

        public Iterator<K> iterator() {
            return this.f6621a.createKeySetIterator();
        }
    }

    public static class KeySetIterator<K> extends HashIterator<K, Object> implements Iterator<K> {
        protected KeySetIterator(AbstractHashedMap<K, ?> abstractHashedMap) {
            super(abstractHashedMap);
        }

        public K next() {
            return super.nextEntry().getKey();
        }
    }

    public Collection<V> values() {
        if (this.f6614h == null) {
            this.f6614h = new Values<>(this);
        }
        return this.f6614h;
    }

    /* access modifiers changed from: protected */
    public Iterator<V> createValuesIterator() {
        if (size() == 0) {
            return EmptyIterator.emptyIterator();
        }
        return new ValuesIterator(this);
    }

    public static class Values<V> extends AbstractCollection<V> {

        /* renamed from: a */
        private final AbstractHashedMap<?, V> f6622a;

        protected Values(AbstractHashedMap<?, V> abstractHashedMap) {
            this.f6622a = abstractHashedMap;
        }

        public int size() {
            return this.f6622a.size();
        }

        public void clear() {
            this.f6622a.clear();
        }

        public boolean contains(Object obj) {
            return this.f6622a.containsValue(obj);
        }

        public Iterator<V> iterator() {
            return this.f6622a.createValuesIterator();
        }
    }

    public static class ValuesIterator<V> extends HashIterator<Object, V> implements Iterator<V> {
        protected ValuesIterator(AbstractHashedMap<?, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        public V next() {
            return super.nextEntry().getValue();
        }
    }

    public static class HashEntry<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {
        protected int hashCode;
        protected Object key;
        protected HashEntry<K, V> next;
        protected Object value;

        protected HashEntry(HashEntry<K, V> hashEntry, int i, Object obj, V v) {
            this.next = hashEntry;
            this.hashCode = i;
            this.key = obj;
            this.value = v;
        }

        public K getKey() {
            if (this.key == AbstractHashedMap.NULL) {
                return null;
            }
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

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (getKey() != null ? getKey().equals(entry.getKey()) : entry.getKey() == null) {
                if (getValue() == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (getValue().equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode2 = getKey() == null ? 0 : getKey().hashCode();
            if (getValue() != null) {
                i = getValue().hashCode();
            }
            return hashCode2 ^ i;
        }

        public String toString() {
            return new StringBuilder().append(getKey()).append('=').append(getValue()).toString();
        }
    }

    public static abstract class HashIterator<K, V> {

        /* renamed from: a */
        private final AbstractHashedMap<K, V> f6616a;

        /* renamed from: b */
        private int f6617b;

        /* renamed from: c */
        private HashEntry<K, V> f6618c;

        /* renamed from: d */
        private HashEntry<K, V> f6619d;

        /* renamed from: e */
        private int f6620e;

        protected HashIterator(AbstractHashedMap<K, V> abstractHashedMap) {
            this.f6616a = abstractHashedMap;
            HashEntry<K, V>[] hashEntryArr = abstractHashedMap.f6609c;
            int length = hashEntryArr.length;
            HashEntry<K, V> hashEntry = null;
            while (length > 0 && hashEntry == null) {
                length--;
                hashEntry = hashEntryArr[length];
            }
            this.f6619d = hashEntry;
            this.f6617b = length;
            this.f6620e = abstractHashedMap.f6611e;
        }

        public boolean hasNext() {
            return this.f6619d != null;
        }

        /* access modifiers changed from: protected */
        public HashEntry<K, V> nextEntry() {
            if (this.f6616a.f6611e != this.f6620e) {
                throw new ConcurrentModificationException();
            }
            HashEntry<K, V> hashEntry = this.f6619d;
            if (hashEntry == null) {
                throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
            }
            HashEntry<K, V>[] hashEntryArr = this.f6616a.f6609c;
            int i = this.f6617b;
            HashEntry<K, V> hashEntry2 = hashEntry.next;
            while (hashEntry2 == null && i > 0) {
                i--;
                hashEntry2 = hashEntryArr[i];
            }
            this.f6619d = hashEntry2;
            this.f6617b = i;
            this.f6618c = hashEntry;
            return hashEntry;
        }

        /* access modifiers changed from: protected */
        public HashEntry<K, V> currentEntry() {
            return this.f6618c;
        }

        public void remove() {
            if (this.f6618c == null) {
                throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
            } else if (this.f6616a.f6611e != this.f6620e) {
                throw new ConcurrentModificationException();
            } else {
                this.f6616a.remove(this.f6618c.getKey());
                this.f6618c = null;
                this.f6620e = this.f6616a.f6611e;
            }
        }

        public String toString() {
            if (this.f6618c != null) {
                return "Iterator[" + this.f6618c.getKey() + "=" + this.f6618c.getValue() + "]";
            }
            return "Iterator[]";
        }
    }

    /* access modifiers changed from: protected */
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeFloat(this.f6607a);
        objectOutputStream.writeInt(this.f6609c.length);
        objectOutputStream.writeInt(this.f6608b);
        MapIterator mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
    }

    /* access modifiers changed from: protected */
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f6607a = objectInputStream.readFloat();
        int readInt = objectInputStream.readInt();
        int readInt2 = objectInputStream.readInt();
        init();
        this.f6610d = calculateThreshold(readInt, this.f6607a);
        this.f6609c = new HashEntry[readInt];
        for (int i = 0; i < readInt2; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* access modifiers changed from: protected */
    public AbstractHashedMap<K, V> clone() {
        try {
            AbstractHashedMap<K, V> abstractHashedMap = (AbstractHashedMap) super.clone();
            abstractHashedMap.f6609c = new HashEntry[this.f6609c.length];
            abstractHashedMap.f6612f = null;
            abstractHashedMap.f6613g = null;
            abstractHashedMap.f6614h = null;
            abstractHashedMap.f6611e = 0;
            abstractHashedMap.f6608b = 0;
            abstractHashedMap.init();
            abstractHashedMap.putAll(this);
            return abstractHashedMap;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != size()) {
            return false;
        }
        MapIterator mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            try {
                Object next = mapIterator.next();
                Object value = mapIterator.getValue();
                if (value == null) {
                    if (map.get(next) != null || !map.containsKey(next)) {
                        return false;
                    }
                } else if (!value.equals(map.get(next))) {
                    return false;
                }
            } catch (ClassCastException e) {
                return false;
            } catch (NullPointerException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        Iterator createEntrySetIterator = createEntrySetIterator();
        while (true) {
            int i2 = i;
            if (!createEntrySetIterator.hasNext()) {
                return i2;
            }
            i = ((Map.Entry) createEntrySetIterator.next()).hashCode() + i2;
        }
    }

    public String toString() {
        if (size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(size() * 32);
        sb.append('{');
        MapIterator mapIterator = mapIterator();
        boolean hasNext = mapIterator.hasNext();
        while (hasNext) {
            Object next = mapIterator.next();
            Object value = mapIterator.getValue();
            if (next == this) {
                next = "(this Map)";
            }
            sb.append(next).append('=').append(value == this ? "(this Map)" : value);
            hasNext = mapIterator.hasNext();
            if (hasNext) {
                sb.append(',').append(' ');
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
