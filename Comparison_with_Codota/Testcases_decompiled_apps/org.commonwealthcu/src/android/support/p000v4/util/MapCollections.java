package android.support.p000v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.util.MapCollections */
abstract class MapCollections {
    EntrySet mEntrySet;
    KeySet mKeySet;
    ValuesCollection mValues;

    /* renamed from: android.support.v4.util.MapCollections$ArrayIterator */
    final class ArrayIterator implements Iterator {
        boolean mCanRemove = false;
        int mIndex;
        final int mOffset;
        int mSize;

        ArrayIterator(int i) {
            this.mOffset = i;
            this.mSize = MapCollections.this.colGetSize();
        }

        public final boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        public final Object next() {
            Object colGetEntry = MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
            this.mIndex++;
            this.mCanRemove = true;
            return colGetEntry;
        }

        public final void remove() {
            if (!this.mCanRemove) {
                throw new IllegalStateException();
            }
            this.mIndex--;
            this.mSize--;
            this.mCanRemove = false;
            MapCollections.this.colRemoveAt(this.mIndex);
        }
    }

    /* renamed from: android.support.v4.util.MapCollections$EntrySet */
    final class EntrySet implements Set {
        EntrySet() {
        }

        public final boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection collection) {
            int colGetSize = MapCollections.this.colGetSize();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                MapCollections.this.colPut(entry.getKey(), entry.getValue());
            }
            return colGetSize != MapCollections.this.colGetSize();
        }

        public final void clear() {
            MapCollections.this.colClear();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int colIndexOfKey = MapCollections.this.colIndexOfKey(entry.getKey());
            if (colIndexOfKey >= 0) {
                return ContainerHelpers.equal(MapCollections.this.colGetEntry(colIndexOfKey, 1), entry.getValue());
            }
            return false;
        }

        public final boolean containsAll(Collection collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        public final int hashCode() {
            int colGetSize = MapCollections.this.colGetSize() - 1;
            int i = 0;
            while (colGetSize >= 0) {
                Object colGetEntry = MapCollections.this.colGetEntry(colGetSize, 0);
                Object colGetEntry2 = MapCollections.this.colGetEntry(colGetSize, 1);
                colGetSize--;
                i += (colGetEntry2 == null ? 0 : colGetEntry2.hashCode()) ^ (colGetEntry == null ? 0 : colGetEntry.hashCode());
            }
            return i;
        }

        public final boolean isEmpty() {
            return MapCollections.this.colGetSize() == 0;
        }

        public final Iterator iterator() {
            return new MapIterator();
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return MapCollections.this.colGetSize();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: android.support.v4.util.MapCollections$KeySet */
    final class KeySet implements Set {
        KeySet() {
        }

        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            MapCollections.this.colClear();
        }

        public final boolean contains(Object obj) {
            return MapCollections.this.colIndexOfKey(obj) >= 0;
        }

        public final boolean containsAll(Collection collection) {
            return MapCollections.containsAllHelper(MapCollections.this.colGetMap(), collection);
        }

        public final boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int colGetSize = MapCollections.this.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                Object colGetEntry = MapCollections.this.colGetEntry(colGetSize, 0);
                i += colGetEntry == null ? 0 : colGetEntry.hashCode();
            }
            return i;
        }

        public final boolean isEmpty() {
            return MapCollections.this.colGetSize() == 0;
        }

        public final Iterator iterator() {
            return new ArrayIterator(0);
        }

        public final boolean remove(Object obj) {
            int colIndexOfKey = MapCollections.this.colIndexOfKey(obj);
            if (colIndexOfKey < 0) {
                return false;
            }
            MapCollections.this.colRemoveAt(colIndexOfKey);
            return true;
        }

        public final boolean removeAll(Collection collection) {
            return MapCollections.removeAllHelper(MapCollections.this.colGetMap(), collection);
        }

        public final boolean retainAll(Collection collection) {
            return MapCollections.retainAllHelper(MapCollections.this.colGetMap(), collection);
        }

        public final int size() {
            return MapCollections.this.colGetSize();
        }

        public final Object[] toArray() {
            return MapCollections.this.toArrayHelper(0);
        }

        public final Object[] toArray(Object[] objArr) {
            return MapCollections.this.toArrayHelper(objArr, 0);
        }
    }

    /* renamed from: android.support.v4.util.MapCollections$MapIterator */
    final class MapIterator implements Iterator, Map.Entry {
        int mEnd;
        boolean mEntryValid = false;
        int mIndex;

        MapIterator() {
            this.mEnd = MapCollections.this.colGetSize() - 1;
            this.mIndex = -1;
        }

        public final boolean equals(Object obj) {
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                return ContainerHelpers.equal(entry.getKey(), MapCollections.this.colGetEntry(this.mIndex, 0)) && ContainerHelpers.equal(entry.getValue(), MapCollections.this.colGetEntry(this.mIndex, 1));
            }
        }

        public final Object getKey() {
            if (this.mEntryValid) {
                return MapCollections.this.colGetEntry(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final Object getValue() {
            if (this.mEntryValid) {
                return MapCollections.this.colGetEntry(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean hasNext() {
            return this.mIndex < this.mEnd;
        }

        public final int hashCode() {
            int i = 0;
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object colGetEntry = MapCollections.this.colGetEntry(this.mIndex, 0);
            Object colGetEntry2 = MapCollections.this.colGetEntry(this.mIndex, 1);
            int hashCode = colGetEntry == null ? 0 : colGetEntry.hashCode();
            if (colGetEntry2 != null) {
                i = colGetEntry2.hashCode();
            }
            return i ^ hashCode;
        }

        public final Map.Entry next() {
            this.mIndex++;
            this.mEntryValid = true;
            return this;
        }

        public final void remove() {
            if (!this.mEntryValid) {
                throw new IllegalStateException();
            }
            MapCollections.this.colRemoveAt(this.mIndex);
            this.mIndex--;
            this.mEnd--;
            this.mEntryValid = false;
        }

        public final Object setValue(Object obj) {
            if (this.mEntryValid) {
                return MapCollections.this.colSetValue(this.mIndex, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: android.support.v4.util.MapCollections$ValuesCollection */
    final class ValuesCollection implements Collection {
        ValuesCollection() {
        }

        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            MapCollections.this.colClear();
        }

        public final boolean contains(Object obj) {
            return MapCollections.this.colIndexOfValue(obj) >= 0;
        }

        public final boolean containsAll(Collection collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return MapCollections.this.colGetSize() == 0;
        }

        public final Iterator iterator() {
            return new ArrayIterator(1);
        }

        public final boolean remove(Object obj) {
            int colIndexOfValue = MapCollections.this.colIndexOfValue(obj);
            if (colIndexOfValue < 0) {
                return false;
            }
            MapCollections.this.colRemoveAt(colIndexOfValue);
            return true;
        }

        public final boolean removeAll(Collection collection) {
            int i = 0;
            int colGetSize = MapCollections.this.colGetSize();
            boolean z = false;
            while (i < colGetSize) {
                if (collection.contains(MapCollections.this.colGetEntry(i, 1))) {
                    MapCollections.this.colRemoveAt(i);
                    i--;
                    colGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection collection) {
            int i = 0;
            int colGetSize = MapCollections.this.colGetSize();
            boolean z = false;
            while (i < colGetSize) {
                if (!collection.contains(MapCollections.this.colGetEntry(i, 1))) {
                    MapCollections.this.colRemoveAt(i);
                    i--;
                    colGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return MapCollections.this.colGetSize();
        }

        public final Object[] toArray() {
            return MapCollections.this.toArrayHelper(1);
        }

        public final Object[] toArray(Object[] objArr) {
            return MapCollections.this.toArrayHelper(objArr, 1);
        }
    }

    MapCollections() {
    }

    public static boolean containsAllHelper(Map map, Collection collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsSetHelper(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static boolean removeAllHelper(Map map, Collection collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static boolean retainAllHelper(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* access modifiers changed from: protected */
    public abstract void colClear();

    /* access modifiers changed from: protected */
    public abstract Object colGetEntry(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract Map colGetMap();

    /* access modifiers changed from: protected */
    public abstract int colGetSize();

    /* access modifiers changed from: protected */
    public abstract int colIndexOfKey(Object obj);

    /* access modifiers changed from: protected */
    public abstract int colIndexOfValue(Object obj);

    /* access modifiers changed from: protected */
    public abstract void colPut(Object obj, Object obj2);

    /* access modifiers changed from: protected */
    public abstract void colRemoveAt(int i);

    /* access modifiers changed from: protected */
    public abstract Object colSetValue(int i, Object obj);

    public Set getEntrySet() {
        if (this.mEntrySet == null) {
            this.mEntrySet = new EntrySet();
        }
        return this.mEntrySet;
    }

    public Set getKeySet() {
        if (this.mKeySet == null) {
            this.mKeySet = new KeySet();
        }
        return this.mKeySet;
    }

    public Collection getValues() {
        if (this.mValues == null) {
            this.mValues = new ValuesCollection();
        }
        return this.mValues;
    }

    public Object[] toArrayHelper(int i) {
        int colGetSize = colGetSize();
        Object[] objArr = new Object[colGetSize];
        for (int i2 = 0; i2 < colGetSize; i2++) {
            objArr[i2] = colGetEntry(i2, i);
        }
        return objArr;
    }

    public Object[] toArrayHelper(Object[] objArr, int i) {
        int colGetSize = colGetSize();
        Object[] objArr2 = objArr.length < colGetSize ? (Object[]) Array.newInstance(objArr.getClass().getComponentType(), colGetSize) : objArr;
        for (int i2 = 0; i2 < colGetSize; i2++) {
            objArr2[i2] = colGetEntry(i2, i);
        }
        if (objArr2.length > colGetSize) {
            objArr2[colGetSize] = null;
        }
        return objArr2;
    }
}
