package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.apache.commons.collections4.map.AbstractLinkedMap;

public class LRUMap<K, V> extends AbstractLinkedMap<K, V> implements Serializable, Cloneable, BoundedMap<K, V> {
    protected static final int DEFAULT_MAX_SIZE = 100;
    private static final long serialVersionUID = -612114643488955218L;

    /* renamed from: j */
    private transient int f6671j;

    /* renamed from: k */
    private boolean f6672k;

    public LRUMap() {
        this(100, 0.75f, false);
    }

    public LRUMap(int i) {
        this(i, 0.75f);
    }

    public LRUMap(int i, boolean z) {
        this(i, 0.75f, z);
    }

    public LRUMap(int i, float f) {
        this(i, f, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LRUMap(int r3, float r4, boolean r5) {
        /*
            r2 = this;
            r1 = 1
            if (r3 >= r1) goto L_0x0012
            r0 = 16
        L_0x0005:
            r2.<init>(r0, r4)
            if (r3 >= r1) goto L_0x0014
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "LRUMap max size must be greater than 0"
            r0.<init>(r1)
            throw r0
        L_0x0012:
            r0 = r3
            goto L_0x0005
        L_0x0014:
            r2.f6671j = r3
            r2.f6672k = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.map.LRUMap.<init>(int, float, boolean):void");
    }

    public LRUMap(Map<? extends K, ? extends V> map) {
        this(map, false);
    }

    public LRUMap(Map<? extends K, ? extends V> map, boolean z) {
        this(map.size(), 0.75f, z);
        putAll(map);
    }

    public V get(Object obj) {
        AbstractLinkedMap.LinkEntry entry = getEntry(obj);
        if (entry == null) {
            return null;
        }
        moveToMRU(entry);
        return entry.getValue();
    }

    /* access modifiers changed from: protected */
    public void moveToMRU(AbstractLinkedMap.LinkEntry<K, V> linkEntry) {
        if (linkEntry.after != this.f6623i) {
            this.f6611e++;
            if (linkEntry.before == null) {
                throw new IllegalStateException("Entry.before is null. Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to dev@commons.apache.org as a bug.");
            }
            linkEntry.before.after = linkEntry.after;
            linkEntry.after.before = linkEntry.before;
            linkEntry.after = this.f6623i;
            linkEntry.before = this.f6623i.before;
            this.f6623i.before.after = linkEntry;
            this.f6623i.before = linkEntry;
        } else if (linkEntry == this.f6623i) {
            throw new IllegalStateException("Can't move header to MRU (please report this to dev@commons.apache.org)");
        }
    }

    /* access modifiers changed from: protected */
    public void updateEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, V v) {
        moveToMRU((AbstractLinkedMap.LinkEntry) hashEntry);
        hashEntry.setValue(v);
    }

    /* access modifiers changed from: protected */
    public void addMapping(int i, int i2, K k, V v) {
        AbstractLinkedMap.LinkEntry<K, V> linkEntry;
        boolean z;
        if (isFull()) {
            AbstractLinkedMap.LinkEntry<K, V> linkEntry2 = this.f6623i.after;
            boolean z2 = false;
            if (this.f6672k) {
                while (true) {
                    if (linkEntry2 == this.f6623i || linkEntry2 == null) {
                        break;
                    } else if (removeLRU(linkEntry2)) {
                        z2 = true;
                        break;
                    } else {
                        linkEntry2 = linkEntry2.after;
                    }
                }
                if (linkEntry2 == null) {
                    throw new IllegalStateException("Entry.after=null, header.after" + this.f6623i.after + " header.before" + this.f6623i.before + " key=" + k + " value=" + v + " size=" + this.f6608b + " maxSize=" + this.f6671j + " Please check that your keys are immutable, and that you have used synchronization properly." + " If so, then please report this to dev@commons.apache.org as a bug.");
                }
                boolean z3 = z2;
                linkEntry = linkEntry2;
                z = z3;
            } else {
                linkEntry = linkEntry2;
                z = removeLRU(linkEntry2);
            }
            if (!z) {
                super.addMapping(i, i2, k, v);
            } else if (linkEntry == null) {
                throw new IllegalStateException("reuse=null, header.after=" + this.f6623i.after + " header.before" + this.f6623i.before + " key=" + k + " value=" + v + " size=" + this.f6608b + " maxSize=" + this.f6671j + " Please check that your keys are immutable, and that you have used synchronization properly." + " If so, then please report this to dev@commons.apache.org as a bug.");
            } else {
                reuseMapping(linkEntry, i, i2, k, v);
            }
        } else {
            super.addMapping(i, i2, k, v);
        }
    }

    /* access modifiers changed from: protected */
    public void reuseMapping(AbstractLinkedMap.LinkEntry<K, V> linkEntry, int i, int i2, K k, V v) {
        boolean z;
        try {
            int hashIndex = hashIndex(linkEntry.hashCode, this.f6609c.length);
            AbstractHashedMap.HashEntry<K, V> hashEntry = this.f6609c[hashIndex];
            AbstractHashedMap.HashEntry<K, V> hashEntry2 = null;
            while (hashEntry != linkEntry && hashEntry != null) {
                AbstractHashedMap.HashEntry<K, V> hashEntry3 = hashEntry;
                hashEntry = hashEntry.next;
                hashEntry2 = hashEntry3;
            }
            if (hashEntry == null) {
                throw new IllegalStateException("Entry.next=null, data[removeIndex]=" + this.f6609c[hashIndex] + " previous=" + hashEntry2 + " key=" + k + " value=" + v + " size=" + this.f6608b + " maxSize=" + this.f6671j + " Please check that your keys are immutable, and that you have used synchronization properly." + " If so, then please report this to dev@commons.apache.org as a bug.");
            }
            this.f6611e++;
            removeEntry(linkEntry, hashIndex, hashEntry2);
            reuseEntry(linkEntry, i, i2, k, v);
            addEntry(linkEntry, i);
        } catch (NullPointerException e) {
            StringBuilder append = new StringBuilder().append("NPE, entry=").append(linkEntry).append(" entryIsHeader=");
            if (linkEntry == this.f6623i) {
                z = true;
            } else {
                z = false;
            }
            throw new IllegalStateException(append.append(z).append(" key=").append(k).append(" value=").append(v).append(" size=").append(this.f6608b).append(" maxSize=").append(this.f6671j).append(" Please check that your keys are immutable, and that you have used synchronization properly.").append(" If so, then please report this to dev@commons.apache.org as a bug.").toString());
        }
    }

    /* access modifiers changed from: protected */
    public boolean removeLRU(AbstractLinkedMap.LinkEntry<K, V> linkEntry) {
        return true;
    }

    public boolean isFull() {
        return this.f6608b >= this.f6671j;
    }

    public int maxSize() {
        return this.f6671j;
    }

    public boolean isScanUntilRemovable() {
        return this.f6672k;
    }

    public LRUMap<K, V> clone() {
        return (LRUMap) super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    /* access modifiers changed from: protected */
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f6671j);
        super.doWriteObject(objectOutputStream);
    }

    /* access modifiers changed from: protected */
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f6671j = objectInputStream.readInt();
        super.doReadObject(objectInputStream);
    }
}
