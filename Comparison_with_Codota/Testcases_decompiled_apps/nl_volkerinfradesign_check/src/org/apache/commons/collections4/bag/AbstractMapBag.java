package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.set.UnmodifiableSet;

public abstract class AbstractMapBag<E> implements Bag<E> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public transient Map<E, MutableInteger> f6321a;

    /* renamed from: b */
    private int f6322b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public transient int f6323c;

    /* renamed from: d */
    private transient Set<E> f6324d;

    /* renamed from: c */
    static /* synthetic */ int m6926c(AbstractMapBag abstractMapBag) {
        int i = abstractMapBag.f6322b;
        abstractMapBag.f6322b = i - 1;
        return i;
    }

    protected AbstractMapBag() {
    }

    protected AbstractMapBag(Map<E, MutableInteger> map) {
        this.f6321a = map;
    }

    /* access modifiers changed from: protected */
    public Map<E, MutableInteger> getMap() {
        return this.f6321a;
    }

    public int size() {
        return this.f6322b;
    }

    public boolean isEmpty() {
        return this.f6321a.isEmpty();
    }

    public int getCount(Object obj) {
        MutableInteger mutableInteger = this.f6321a.get(obj);
        if (mutableInteger != null) {
            return mutableInteger.value;
        }
        return 0;
    }

    public boolean contains(Object obj) {
        return this.f6321a.containsKey(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof Bag) {
            return mo11319a((Bag<?>) (Bag) collection);
        }
        return mo11319a((Bag<?>) new HashBag(collection));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo11319a(Bag<?> bag) {
        for (Object next : bag.uniqueSet()) {
            if (getCount(next) < bag.getCount(next)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<E> iterator() {
        return new C1844a(this);
    }

    /* renamed from: org.apache.commons.collections4.bag.AbstractMapBag$a */
    static class C1844a<E> implements Iterator<E> {

        /* renamed from: a */
        private final AbstractMapBag<E> f6325a;

        /* renamed from: b */
        private final Iterator<Map.Entry<E, MutableInteger>> f6326b;

        /* renamed from: c */
        private Map.Entry<E, MutableInteger> f6327c = null;

        /* renamed from: d */
        private int f6328d;

        /* renamed from: e */
        private final int f6329e;

        /* renamed from: f */
        private boolean f6330f;

        public C1844a(AbstractMapBag<E> abstractMapBag) {
            this.f6325a = abstractMapBag;
            this.f6326b = abstractMapBag.f6321a.entrySet().iterator();
            this.f6329e = abstractMapBag.f6323c;
            this.f6330f = false;
        }

        public boolean hasNext() {
            return this.f6328d > 0 || this.f6326b.hasNext();
        }

        public E next() {
            if (this.f6325a.f6323c != this.f6329e) {
                throw new ConcurrentModificationException();
            }
            if (this.f6328d == 0) {
                this.f6327c = this.f6326b.next();
                this.f6328d = this.f6327c.getValue().value;
            }
            this.f6330f = true;
            this.f6328d--;
            return this.f6327c.getKey();
        }

        public void remove() {
            if (this.f6325a.f6323c != this.f6329e) {
                throw new ConcurrentModificationException();
            } else if (!this.f6330f) {
                throw new IllegalStateException();
            } else {
                MutableInteger value = this.f6327c.getValue();
                if (value.value > 1) {
                    value.value--;
                } else {
                    this.f6326b.remove();
                }
                AbstractMapBag.m6926c(this.f6325a);
                this.f6330f = false;
            }
        }
    }

    public boolean add(E e) {
        return add(e, 1);
    }

    public boolean add(E e, int i) {
        this.f6323c++;
        if (i <= 0) {
            return false;
        }
        MutableInteger mutableInteger = this.f6321a.get(e);
        this.f6322b += i;
        if (mutableInteger == null) {
            this.f6321a.put(e, new MutableInteger(i));
            return true;
        }
        mutableInteger.value += i;
        return false;
    }

    public boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        for (Object add : collection) {
            z = z || add(add);
        }
        return z;
    }

    public void clear() {
        this.f6323c++;
        this.f6321a.clear();
        this.f6322b = 0;
    }

    public boolean remove(Object obj) {
        MutableInteger mutableInteger = this.f6321a.get(obj);
        if (mutableInteger == null) {
            return false;
        }
        this.f6323c++;
        this.f6321a.remove(obj);
        this.f6322b -= mutableInteger.value;
        return true;
    }

    public boolean remove(Object obj, int i) {
        MutableInteger mutableInteger = this.f6321a.get(obj);
        if (mutableInteger == null) {
            return false;
        }
        if (i <= 0) {
            return false;
        }
        this.f6323c++;
        if (i < mutableInteger.value) {
            mutableInteger.value -= i;
            this.f6322b -= i;
        } else {
            this.f6321a.remove(obj);
            this.f6322b -= mutableInteger.value;
        }
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        if (collection == null) {
            return false;
        }
        boolean z = false;
        for (Object remove : collection) {
            z = z || remove(remove, 1);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        if (collection instanceof Bag) {
            return mo11321b((Bag<?>) (Bag) collection);
        }
        return mo11321b((Bag<?>) new HashBag(collection));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo11321b(Bag<?> bag) {
        HashBag hashBag = new HashBag();
        for (Object next : uniqueSet()) {
            int count = getCount(next);
            int count2 = bag.getCount(next);
            if (1 > count2 || count2 > count) {
                hashBag.add(next, count);
            } else {
                hashBag.add(next, count - count2);
            }
        }
        if (!hashBag.isEmpty()) {
            return removeAll(hashBag);
        }
        return false;
    }

    public static class MutableInteger {
        protected int value;

        MutableInteger(int i) {
            this.value = i;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof MutableInteger) && ((MutableInteger) obj).value == this.value) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.value;
        }
    }

    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        int i = 0;
        for (E next : this.f6321a.keySet()) {
            int count = getCount(next);
            while (count > 0) {
                objArr[i] = next;
                count--;
                i++;
            }
        }
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        int size = size();
        if (tArr.length < size) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else {
            tArr2 = tArr;
        }
        int i = 0;
        for (E next : this.f6321a.keySet()) {
            int count = getCount(next);
            while (count > 0) {
                tArr2[i] = next;
                count--;
                i++;
            }
        }
        while (i < tArr2.length) {
            tArr2[i] = null;
            i++;
        }
        return tArr2;
    }

    public Set<E> uniqueSet() {
        if (this.f6324d == null) {
            this.f6324d = UnmodifiableSet.unmodifiableSet(this.f6321a.keySet());
        }
        return this.f6324d;
    }

    /* access modifiers changed from: protected */
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f6321a.size());
        for (Map.Entry next : this.f6321a.entrySet()) {
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeInt(((MutableInteger) next.getValue()).value);
        }
    }

    /* access modifiers changed from: protected */
    public void doReadObject(Map<E, MutableInteger> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f6321a = map;
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            map.put(readObject, new MutableInteger(readInt2));
            this.f6322b += readInt2;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bag)) {
            return false;
        }
        Bag bag = (Bag) obj;
        if (bag.size() != size()) {
            return false;
        }
        for (E next : this.f6321a.keySet()) {
            if (bag.getCount(next) != getCount(next)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (Map.Entry next : this.f6321a.entrySet()) {
            Object key = next.getKey();
            i = (((MutableInteger) next.getValue()).value ^ (key == null ? 0 : key.hashCode())) + i;
        }
        return i;
    }

    public String toString() {
        if (size() == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = uniqueSet().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            sb.append(getCount(next));
            sb.append(':');
            sb.append(next);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
