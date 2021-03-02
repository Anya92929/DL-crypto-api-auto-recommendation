package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
import org.apache.commons.collections4.map.AbstractHashedMap;

public abstract class AbstractReferenceMap<K, V> extends AbstractHashedMap<K, V> {
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ReferenceStrength f6625i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ReferenceStrength f6626j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f6627k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public transient ReferenceQueue<Object> f6628l;

    public enum ReferenceStrength {
        HARD(0),
        SOFT(1),
        WEAK(2);
        
        public final int value;

        public static ReferenceStrength resolve(int i) {
            switch (i) {
                case 0:
                    return HARD;
                case 1:
                    return SOFT;
                case 2:
                    return WEAK;
                default:
                    throw new IllegalArgumentException();
            }
        }

        private ReferenceStrength(int i) {
            this.value = i;
        }
    }

    protected AbstractReferenceMap() {
    }

    protected AbstractReferenceMap(ReferenceStrength referenceStrength, ReferenceStrength referenceStrength2, int i, float f, boolean z) {
        super(i, f);
        this.f6625i = referenceStrength;
        this.f6626j = referenceStrength2;
        this.f6627k = z;
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.f6628l = new ReferenceQueue<>();
    }

    public int size() {
        purgeBeforeRead();
        return super.size();
    }

    public boolean isEmpty() {
        purgeBeforeRead();
        return super.isEmpty();
    }

    public boolean containsKey(Object obj) {
        purgeBeforeRead();
        AbstractHashedMap.HashEntry entry = getEntry(obj);
        if (entry == null || entry.getValue() == null) {
            return false;
        }
        return true;
    }

    public boolean containsValue(Object obj) {
        purgeBeforeRead();
        if (obj == null) {
            return false;
        }
        return super.containsValue(obj);
    }

    public V get(Object obj) {
        purgeBeforeRead();
        AbstractHashedMap.HashEntry entry = getEntry(obj);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("null keys not allowed");
        } else if (v == null) {
            throw new NullPointerException("null values not allowed");
        } else {
            purgeBeforeWrite();
            return super.put(k, v);
        }
    }

    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        purgeBeforeWrite();
        return super.remove(obj);
    }

    public void clear() {
        super.clear();
        do {
        } while (this.f6628l.poll() != null);
    }

    public MapIterator<K, V> mapIterator() {
        return new C1877f(this);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f6612f == null) {
            this.f6612f = new C1873b(this);
        }
        return this.f6612f;
    }

    public Set<K> keySet() {
        if (this.f6613g == null) {
            this.f6613g = new C1875d(this);
        }
        return this.f6613g;
    }

    public Collection<V> values() {
        if (this.f6614h == null) {
            this.f6614h = new C1878g(this);
        }
        return this.f6614h;
    }

    /* access modifiers changed from: protected */
    public void purgeBeforeRead() {
        purge();
    }

    /* access modifiers changed from: protected */
    public void purgeBeforeWrite() {
        purge();
    }

    /* access modifiers changed from: protected */
    public void purge() {
        Reference<? extends Object> poll = this.f6628l.poll();
        while (poll != null) {
            purge(poll);
            poll = this.f6628l.poll();
        }
    }

    /* access modifiers changed from: protected */
    public void purge(Reference<?> reference) {
        int hashIndex = hashIndex(reference.hashCode(), this.f6609c.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = this.f6609c[hashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (((ReferenceEntry) hashEntry2).mo11983a(reference)) {
                if (hashEntry == null) {
                    this.f6609c[hashIndex] = hashEntry2.next;
                } else {
                    hashEntry.next = hashEntry2.next;
                }
                this.f6608b--;
                return;
            }
            hashEntry = hashEntry2;
        }
    }

    /* access modifiers changed from: protected */
    public AbstractHashedMap.HashEntry<K, V> getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        return super.getEntry(obj);
    }

    /* access modifiers changed from: protected */
    public int hashEntry(Object obj, Object obj2) {
        int i = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return i ^ hashCode;
    }

    /* access modifiers changed from: protected */
    public boolean isEqualKey(Object obj, Object obj2) {
        if (this.f6625i != ReferenceStrength.HARD) {
            obj2 = ((Reference) obj2).get();
        }
        return obj == obj2 || obj.equals(obj2);
    }

    /* access modifiers changed from: protected */
    public ReferenceEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, K k, V v) {
        return new ReferenceEntry<>(this, hashEntry, i, k, v);
    }

    /* access modifiers changed from: protected */
    public Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        return new C1874c(this);
    }

    /* access modifiers changed from: protected */
    public Iterator<K> createKeySetIterator() {
        return new C1876e(this);
    }

    /* access modifiers changed from: protected */
    public Iterator<V> createValuesIterator() {
        return new C1879h(this);
    }

    /* renamed from: org.apache.commons.collections4.map.AbstractReferenceMap$b */
    static class C1873b<K, V> extends AbstractHashedMap.EntrySet<K, V> {
        protected C1873b(AbstractHashedMap<K, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        public <T> T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(new DefaultMapEntry((Map.Entry) it.next()));
            }
            return arrayList.toArray(tArr);
        }
    }

    /* renamed from: org.apache.commons.collections4.map.AbstractReferenceMap$d */
    static class C1875d<K> extends AbstractHashedMap.KeySet<K> {
        protected C1875d(AbstractHashedMap<K, ?> abstractHashedMap) {
            super(abstractHashedMap);
        }

        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        public <T> T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return arrayList.toArray(tArr);
        }
    }

    /* renamed from: org.apache.commons.collections4.map.AbstractReferenceMap$g */
    static class C1878g<V> extends AbstractHashedMap.Values<V> {
        protected C1878g(AbstractHashedMap<?, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        public <T> T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return arrayList.toArray(tArr);
        }
    }

    public static class ReferenceEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {

        /* renamed from: a */
        private final AbstractReferenceMap<K, V> f6629a;

        public ReferenceEntry(AbstractReferenceMap<K, V> abstractReferenceMap, AbstractHashedMap.HashEntry<K, V> hashEntry, int i, K k, V v) {
            super(hashEntry, i, (Object) null, null);
            this.f6629a = abstractReferenceMap;
            this.key = toReference(abstractReferenceMap.f6625i, k, i);
            this.value = toReference(abstractReferenceMap.f6626j, v, i);
        }

        public K getKey() {
            return this.f6629a.f6625i == ReferenceStrength.HARD ? this.key : ((Reference) this.key).get();
        }

        public V getValue() {
            return this.f6629a.f6626j == ReferenceStrength.HARD ? this.value : ((Reference) this.value).get();
        }

        public V setValue(V v) {
            V value = getValue();
            if (this.f6629a.f6626j != ReferenceStrength.HARD) {
                ((Reference) this.value).clear();
            }
            this.value = toReference(this.f6629a.f6626j, v, this.hashCode);
            return value;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null || value == null) {
                return false;
            }
            if (!this.f6629a.isEqualKey(key, this.key) || !this.f6629a.isEqualValue(value, getValue())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f6629a.hashEntry(getKey(), getValue());
        }

        /* access modifiers changed from: protected */
        public <T> Object toReference(ReferenceStrength referenceStrength, T t, int i) {
            if (referenceStrength == ReferenceStrength.HARD) {
                return t;
            }
            if (referenceStrength == ReferenceStrength.SOFT) {
                return new C1880i(i, t, this.f6629a.f6628l);
            }
            if (referenceStrength == ReferenceStrength.WEAK) {
                return new C1881j(i, t, this.f6629a.f6628l);
            }
            throw new Error();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo11983a(Reference<?> reference) {
            boolean z = true;
            if (!(this.f6629a.f6625i != ReferenceStrength.HARD && this.key == reference) && (this.f6629a.f6626j == ReferenceStrength.HARD || this.value != reference)) {
                z = false;
            }
            if (z) {
                if (this.f6629a.f6625i != ReferenceStrength.HARD) {
                    ((Reference) this.key).clear();
                }
                if (this.f6629a.f6626j != ReferenceStrength.HARD) {
                    ((Reference) this.value).clear();
                } else if (this.f6629a.f6627k) {
                    this.value = null;
                }
            }
            return z;
        }

        /* access modifiers changed from: protected */
        public ReferenceEntry<K, V> next() {
            return (ReferenceEntry) this.next;
        }
    }

    /* renamed from: org.apache.commons.collections4.map.AbstractReferenceMap$a */
    static class C1872a<K, V> {

        /* renamed from: a */
        final AbstractReferenceMap<K, V> f6631a;

        /* renamed from: b */
        int f6632b;

        /* renamed from: c */
        ReferenceEntry<K, V> f6633c;

        /* renamed from: d */
        ReferenceEntry<K, V> f6634d;

        /* renamed from: e */
        K f6635e;

        /* renamed from: f */
        K f6636f;

        /* renamed from: g */
        V f6637g;

        /* renamed from: h */
        V f6638h;

        /* renamed from: i */
        int f6639i;

        public C1872a(AbstractReferenceMap<K, V> abstractReferenceMap) {
            this.f6631a = abstractReferenceMap;
            this.f6632b = abstractReferenceMap.size() != 0 ? abstractReferenceMap.f6609c.length : 0;
            this.f6639i = abstractReferenceMap.f6611e;
        }

        public boolean hasNext() {
            mo11992c();
            while (m7119d()) {
                ReferenceEntry<K, V> referenceEntry = this.f6633c;
                int i = this.f6632b;
                while (referenceEntry == null && i > 0) {
                    int i2 = i - 1;
                    int i3 = i2;
                    referenceEntry = (ReferenceEntry) this.f6631a.f6609c[i2];
                    i = i3;
                }
                this.f6633c = referenceEntry;
                this.f6632b = i;
                if (referenceEntry == null) {
                    this.f6635e = null;
                    this.f6637g = null;
                    return false;
                }
                this.f6636f = referenceEntry.getKey();
                this.f6638h = referenceEntry.getValue();
                if (m7119d()) {
                    this.f6633c = this.f6633c.next();
                }
            }
            return true;
        }

        /* renamed from: c */
        private void mo11992c() {
            if (this.f6631a.f6611e != this.f6639i) {
                throw new ConcurrentModificationException();
            }
        }

        /* renamed from: d */
        private boolean m7119d() {
            return this.f6636f == null || this.f6638h == null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ReferenceEntry<K, V> mo11986a() {
            mo11992c();
            if (!m7119d() || hasNext()) {
                this.f6634d = this.f6633c;
                this.f6633c = this.f6633c.next();
                this.f6635e = this.f6636f;
                this.f6637g = this.f6638h;
                this.f6636f = null;
                this.f6638h = null;
                return this.f6634d;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public ReferenceEntry<K, V> mo11987b() {
            mo11992c();
            return this.f6634d;
        }

        public void remove() {
            mo11992c();
            if (this.f6634d == null) {
                throw new IllegalStateException();
            }
            this.f6631a.remove(this.f6635e);
            this.f6634d = null;
            this.f6635e = null;
            this.f6637g = null;
            this.f6639i = this.f6631a.f6611e;
        }
    }

    /* renamed from: org.apache.commons.collections4.map.AbstractReferenceMap$c */
    static class C1874c<K, V> extends C1872a<K, V> implements Iterator<Map.Entry<K, V>> {
        public C1874c(AbstractReferenceMap<K, V> abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        /* renamed from: c */
        public Map.Entry<K, V> next() {
            return mo11986a();
        }
    }

    /* renamed from: org.apache.commons.collections4.map.AbstractReferenceMap$e */
    static class C1876e<K> extends C1872a<K, Object> implements Iterator<K> {
        C1876e(AbstractReferenceMap<K, ?> abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        public K next() {
            return mo11986a().getKey();
        }
    }

    /* renamed from: org.apache.commons.collections4.map.AbstractReferenceMap$h */
    static class C1879h<V> extends C1872a<Object, V> implements Iterator<V> {
        C1879h(AbstractReferenceMap<?, V> abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        public V next() {
            return mo11986a().getValue();
        }
    }

    /* renamed from: org.apache.commons.collections4.map.AbstractReferenceMap$f */
    static class C1877f<K, V> extends C1872a<K, V> implements MapIterator<K, V> {
        protected C1877f(AbstractReferenceMap<K, V> abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        public K next() {
            return mo11986a().getKey();
        }

        public K getKey() {
            ReferenceEntry b = mo11987b();
            if (b != null) {
                return b.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        public V getValue() {
            ReferenceEntry b = mo11987b();
            if (b != null) {
                return b.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        public V setValue(V v) {
            ReferenceEntry b = mo11987b();
            if (b != null) {
                return b.setValue(v);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }
    }

    /* renamed from: org.apache.commons.collections4.map.AbstractReferenceMap$i */
    static class C1880i<T> extends SoftReference<T> {

        /* renamed from: a */
        private final int f6640a;

        public C1880i(int i, T t, ReferenceQueue<? super T> referenceQueue) {
            super(t, referenceQueue);
            this.f6640a = i;
        }

        public int hashCode() {
            return this.f6640a;
        }
    }

    /* renamed from: org.apache.commons.collections4.map.AbstractReferenceMap$j */
    static class C1881j<T> extends WeakReference<T> {

        /* renamed from: a */
        private final int f6641a;

        public C1881j(int i, T t, ReferenceQueue<? super T> referenceQueue) {
            super(t, referenceQueue);
            this.f6641a = i;
        }

        public int hashCode() {
            return this.f6641a;
        }
    }

    /* access modifiers changed from: protected */
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f6625i.value);
        objectOutputStream.writeInt(this.f6626j.value);
        objectOutputStream.writeBoolean(this.f6627k);
        objectOutputStream.writeFloat(this.f6607a);
        objectOutputStream.writeInt(this.f6609c.length);
        MapIterator mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
        objectOutputStream.writeObject((Object) null);
    }

    /* access modifiers changed from: protected */
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f6625i = ReferenceStrength.resolve(objectInputStream.readInt());
        this.f6626j = ReferenceStrength.resolve(objectInputStream.readInt());
        this.f6627k = objectInputStream.readBoolean();
        this.f6607a = objectInputStream.readFloat();
        int readInt = objectInputStream.readInt();
        init();
        this.f6609c = new AbstractHashedMap.HashEntry[readInt];
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                this.f6610d = calculateThreshold(this.f6609c.length, this.f6607a);
                return;
            }
            put(readObject, objectInputStream.readObject());
        }
    }

    /* access modifiers changed from: protected */
    public boolean isKeyType(ReferenceStrength referenceStrength) {
        return this.f6625i == referenceStrength;
    }
}
