package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class PermutationIterator<E> implements Iterator<List<E>> {

    /* renamed from: a */
    private int[] f6539a;

    /* renamed from: b */
    private Map<Integer, E> f6540b;

    /* renamed from: c */
    private boolean[] f6541c;

    /* renamed from: d */
    private List<E> f6542d;

    public PermutationIterator(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        }
        this.f6539a = new int[collection.size()];
        this.f6541c = new boolean[collection.size()];
        Arrays.fill(this.f6541c, false);
        int i = 1;
        this.f6540b = new HashMap();
        for (Object put : collection) {
            this.f6540b.put(Integer.valueOf(i), put);
            this.f6539a[i - 1] = i;
            i++;
        }
        this.f6542d = new ArrayList(collection);
    }

    public boolean hasNext() {
        return this.f6542d != null;
    }

    public List<E> next() {
        boolean z;
        int i = -1;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < this.f6539a.length; i4++) {
            if (((this.f6541c[i4] && i4 < this.f6539a.length - 1 && this.f6539a[i4] > this.f6539a[i4 + 1]) || (!this.f6541c[i4] && i4 > 0 && this.f6539a[i4] > this.f6539a[i4 - 1])) && this.f6539a[i4] > i2) {
                i2 = this.f6539a[i4];
                i3 = i4;
            }
        }
        if (i2 == -1) {
            List<E> list = this.f6542d;
            this.f6542d = null;
            return list;
        }
        if (this.f6541c[i3]) {
            i = 1;
        }
        int i5 = this.f6539a[i3];
        this.f6539a[i3] = this.f6539a[i3 + i];
        this.f6539a[i3 + i] = i5;
        boolean z2 = this.f6541c[i3];
        this.f6541c[i3] = this.f6541c[i3 + i];
        this.f6541c[i + i3] = z2;
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.f6539a.length; i6++) {
            if (this.f6539a[i6] > i2) {
                boolean[] zArr = this.f6541c;
                if (!this.f6541c[i6]) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[i6] = z;
            }
            arrayList.add(this.f6540b.get(Integer.valueOf(this.f6539a[i6])));
        }
        List<E> list2 = this.f6542d;
        this.f6542d = arrayList;
        return list2;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
