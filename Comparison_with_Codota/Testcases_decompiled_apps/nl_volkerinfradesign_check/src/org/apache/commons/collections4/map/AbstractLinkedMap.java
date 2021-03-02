package org.apache.commons.collections4.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.map.AbstractHashedMap;

public abstract class AbstractLinkedMap<K, V> extends AbstractHashedMap<K, V> implements OrderedMap<K, V> {

    /* renamed from: i */
    transient LinkEntry<K, V> f6623i;

    protected AbstractLinkedMap() {
    }

    protected AbstractLinkedMap(int i, float f, int i2) {
        super(i, f, i2);
    }

    protected AbstractLinkedMap(int i) {
        super(i);
    }

    protected AbstractLinkedMap(int i, float f) {
        super(i, f);
    }

    protected AbstractLinkedMap(Map<? extends K, ? extends V> map) {
        super(map);
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.f6623i = createEntry((AbstractHashedMap.HashEntry) null, -1, (Object) null, (Object) null);
        LinkEntry<K, V> linkEntry = this.f6623i;
        LinkEntry<K, V> linkEntry2 = this.f6623i;
        LinkEntry<K, V> linkEntry3 = this.f6623i;
        linkEntry2.after = linkEntry3;
        linkEntry.before = linkEntry3;
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            for (LinkEntry<K, V> linkEntry = this.f6623i.after; linkEntry != this.f6623i; linkEntry = linkEntry.after) {
                if (linkEntry.getValue() == null) {
                    return true;
                }
            }
        } else {
            for (LinkEntry<K, V> linkEntry2 = this.f6623i.after; linkEntry2 != this.f6623i; linkEntry2 = linkEntry2.after) {
                if (isEqualValue(obj, linkEntry2.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clear() {
        super.clear();
        LinkEntry<K, V> linkEntry = this.f6623i;
        LinkEntry<K, V> linkEntry2 = this.f6623i;
        LinkEntry<K, V> linkEntry3 = this.f6623i;
        linkEntry2.after = linkEntry3;
        linkEntry.before = linkEntry3;
    }

    public K firstKey() {
        if (this.f6608b != 0) {
            return this.f6623i.after.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    public K lastKey() {
        if (this.f6608b != 0) {
            return this.f6623i.before.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    public K nextKey(Object obj) {
        LinkEntry entry = getEntry(obj);
        if (entry == null || entry.after == this.f6623i) {
            return null;
        }
        return entry.after.getKey();
    }

    /* access modifiers changed from: protected */
    public LinkEntry<K, V> getEntry(Object obj) {
        return (LinkEntry) super.getEntry(obj);
    }

    public K previousKey(Object obj) {
        LinkEntry entry = getEntry(obj);
        if (entry == null || entry.before == this.f6623i) {
            return null;
        }
        return entry.before.getKey();
    }

    /* access modifiers changed from: protected */
    public LinkEntry<K, V> getEntry(int i) {
        LinkEntry<K, V> linkEntry;
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index " + i + " is less than zero");
        } else if (i >= this.f6608b) {
            throw new IndexOutOfBoundsException("Index " + i + " is invalid for size " + this.f6608b);
        } else {
            if (i < this.f6608b / 2) {
                linkEntry = this.f6623i.after;
                int i2 = 0;
                while (i2 < i) {
                    i2++;
                    linkEntry = linkEntry.after;
                }
            } else {
                LinkEntry<K, V> linkEntry2 = this.f6623i;
                int i3 = this.f6608b;
                while (i3 > i) {
                    i3--;
                    linkEntry2 = linkEntry.before;
                }
            }
            return linkEntry;
        }
    }

    /* access modifiers changed from: protected */
    public void addEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i) {
        LinkEntry<K, V> linkEntry = (LinkEntry) hashEntry;
        linkEntry.after = this.f6623i;
        linkEntry.before = this.f6623i.before;
        this.f6623i.before.after = linkEntry;
        this.f6623i.before = linkEntry;
        this.f6609c[i] = linkEntry;
    }

    /* access modifiers changed from: protected */
    public LinkEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, K k, V v) {
        return new LinkEntry<>(hashEntry, i, convertKey(k), v);
    }

    /* access modifiers changed from: protected */
    public void removeEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, AbstractHashedMap.HashEntry<K, V> hashEntry2) {
        LinkEntry linkEntry = (LinkEntry) hashEntry;
        linkEntry.before.after = linkEntry.after;
        linkEntry.after.before = linkEntry.before;
        linkEntry.after = null;
        linkEntry.before = null;
        super.removeEntry(hashEntry, i, hashEntry2);
    }

    /* access modifiers changed from: protected */
    public LinkEntry<K, V> entryBefore(LinkEntry<K, V> linkEntry) {
        return linkEntry.before;
    }

    /* access modifiers changed from: protected */
    public LinkEntry<K, V> entryAfter(LinkEntry<K, V> linkEntry) {
        return linkEntry.after;
    }

    public OrderedMapIterator<K, V> mapIterator() {
        if (this.f6608b == 0) {
            return EmptyOrderedMapIterator.emptyOrderedMapIterator();
        }
        return new LinkMapIterator(this);
    }

    public static class LinkMapIterator<K, V> extends LinkIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        protected LinkMapIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        public K next() {
            return super.nextEntry().getKey();
        }

        public K previous() {
            return super.previousEntry().getKey();
        }

        public K getKey() {
            LinkEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        public V getValue() {
            LinkEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        public V setValue(V v) {
            LinkEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.setValue(v);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }
    }

    /* access modifiers changed from: protected */
    public Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.emptyOrderedIterator();
        }
        return new EntrySetIterator(this);
    }

    public static class EntrySetIterator<K, V> extends LinkIterator<K, V> implements OrderedIterator<Map.Entry<K, V>>, ResettableIterator<Map.Entry<K, V>> {
        protected EntrySetIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        public Map.Entry<K, V> next() {
            return super.nextEntry();
        }

        public Map.Entry<K, V> previous() {
            return super.previousEntry();
        }
    }

    /* access modifiers changed from: protected */
    public Iterator<K> createKeySetIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.emptyOrderedIterator();
        }
        return new KeySetIterator(this);
    }

    public static class KeySetIterator<K> extends LinkIterator<K, Object> implements OrderedIterator<K>, ResettableIterator<K> {
        protected KeySetIterator(AbstractLinkedMap<K, ?> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        public K next() {
            return super.nextEntry().getKey();
        }

        public K previous() {
            return super.previousEntry().getKey();
        }
    }

    /* access modifiers changed from: protected */
    public Iterator<V> createValuesIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.emptyOrderedIterator();
        }
        return new ValuesIterator(this);
    }

    public static class ValuesIterator<V> extends LinkIterator<Object, V> implements OrderedIterator<V>, ResettableIterator<V> {
        protected ValuesIterator(AbstractLinkedMap<?, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        public V next() {
            return super.nextEntry().getValue();
        }

        public V previous() {
            return super.previousEntry().getValue();
        }
    }

    public static class LinkEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        protected LinkEntry<K, V> after;
        protected LinkEntry<K, V> before;

        protected LinkEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, Object obj, V v) {
            super(hashEntry, i, obj, v);
        }
    }

    public static abstract class LinkIterator<K, V> {
        protected int expectedModCount;
        protected LinkEntry<K, V> last;
        protected LinkEntry<K, V> next;
        protected final AbstractLinkedMap<K, V> parent;

        protected LinkIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            this.parent = abstractLinkedMap;
            this.next = abstractLinkedMap.f6623i.after;
            this.expectedModCount = abstractLinkedMap.f6611e;
        }

        public boolean hasNext() {
            return this.next != this.parent.f6623i;
        }

        public boolean hasPrevious() {
            return this.next.before != this.parent.f6623i;
        }

        /* access modifiers changed from: protected */
        public LinkEntry<K, V> nextEntry() {
            if (this.parent.f6611e != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else if (this.next == this.parent.f6623i) {
                throw new NoSuchElementException("No next() entry in the iteration");
            } else {
                this.last = this.next;
                this.next = this.next.after;
                return this.last;
            }
        }

        /* access modifiers changed from: protected */
        public LinkEntry<K, V> previousEntry() {
            if (this.parent.f6611e != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            LinkEntry<K, V> linkEntry = this.next.before;
            if (linkEntry == this.parent.f6623i) {
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            this.next = linkEntry;
            this.last = linkEntry;
            return this.last;
        }

        /* access modifiers changed from: protected */
        public LinkEntry<K, V> currentEntry() {
            return this.last;
        }

        public void remove() {
            if (this.last == null) {
                throw new IllegalStateException("remove() can only be called once after next()");
            } else if (this.parent.f6611e != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                this.parent.remove(this.last.getKey());
                this.last = null;
                this.expectedModCount = this.parent.f6611e;
            }
        }

        public void reset() {
            this.last = null;
            this.next = this.parent.f6623i.after;
        }

        public String toString() {
            if (this.last != null) {
                return "Iterator[" + this.last.getKey() + "=" + this.last.getValue() + "]";
            }
            return "Iterator[]";
        }
    }
}
