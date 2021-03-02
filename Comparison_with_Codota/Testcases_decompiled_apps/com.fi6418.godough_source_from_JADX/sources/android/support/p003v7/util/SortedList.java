package android.support.p003v7.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* renamed from: android.support.v7.util.SortedList */
public class SortedList<T> {
    public static final int INVALID_POSITION = -1;

    /* renamed from: a */
    T[] f2573a;

    /* renamed from: b */
    private T[] f2574b;

    /* renamed from: c */
    private int f2575c;

    /* renamed from: d */
    private int f2576d;

    /* renamed from: e */
    private int f2577e;

    /* renamed from: f */
    private Callback f2578f;

    /* renamed from: g */
    private BatchedCallback f2579g;

    /* renamed from: h */
    private int f2580h;

    /* renamed from: i */
    private final Class<T> f2581i;

    /* renamed from: android.support.v7.util.SortedList$BatchedCallback */
    public class BatchedCallback<T2> extends Callback<T2> {

        /* renamed from: a */
        int f2582a = 0;

        /* renamed from: b */
        int f2583b = -1;

        /* renamed from: c */
        int f2584c = -1;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Callback<T2> f2585d;

        public BatchedCallback(Callback<T2> callback) {
            this.f2585d = callback;
        }

        public boolean areContentsTheSame(T2 t2, T2 t22) {
            return this.f2585d.areContentsTheSame(t2, t22);
        }

        public boolean areItemsTheSame(T2 t2, T2 t22) {
            return this.f2585d.areItemsTheSame(t2, t22);
        }

        public int compare(T2 t2, T2 t22) {
            return this.f2585d.compare(t2, t22);
        }

        public void dispatchLastEvent() {
            if (this.f2582a != 0) {
                switch (this.f2582a) {
                    case 1:
                        this.f2585d.onInserted(this.f2583b, this.f2584c);
                        break;
                    case 2:
                        this.f2585d.onRemoved(this.f2583b, this.f2584c);
                        break;
                    case 3:
                        this.f2585d.onChanged(this.f2583b, this.f2584c);
                        break;
                }
                this.f2582a = 0;
            }
        }

        public void onChanged(int i, int i2) {
            if (this.f2582a != 3 || i > this.f2583b + this.f2584c || i + i2 < this.f2583b) {
                dispatchLastEvent();
                this.f2583b = i;
                this.f2584c = i2;
                this.f2582a = 3;
                return;
            }
            int i3 = this.f2583b + this.f2584c;
            this.f2583b = Math.min(i, this.f2583b);
            this.f2584c = Math.max(i3, i + i2) - this.f2583b;
        }

        public void onInserted(int i, int i2) {
            if (this.f2582a != 1 || i < this.f2583b || i > this.f2583b + this.f2584c) {
                dispatchLastEvent();
                this.f2583b = i;
                this.f2584c = i2;
                this.f2582a = 1;
                return;
            }
            this.f2584c += i2;
            this.f2583b = Math.min(i, this.f2583b);
        }

        public void onMoved(int i, int i2) {
            dispatchLastEvent();
            this.f2585d.onMoved(i, i2);
        }

        public void onRemoved(int i, int i2) {
            if (this.f2582a == 2 && this.f2583b == i) {
                this.f2584c += i2;
                return;
            }
            dispatchLastEvent();
            this.f2583b = i;
            this.f2584c = i2;
            this.f2582a = 2;
        }
    }

    /* renamed from: android.support.v7.util.SortedList$Callback */
    public abstract class Callback<T2> implements Comparator<T2> {
        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        public abstract int compare(T2 t2, T2 t22);

        public abstract void onChanged(int i, int i2);

        public abstract void onInserted(int i, int i2);

        public abstract void onMoved(int i, int i2);

        public abstract void onRemoved(int i, int i2);
    }

    public SortedList(Class<T> cls, Callback<T> callback) {
        this(cls, callback, 10);
    }

    public SortedList(Class<T> cls, Callback<T> callback, int i) {
        this.f2581i = cls;
        this.f2573a = (Object[]) Array.newInstance(cls, i);
        this.f2578f = callback;
        this.f2580h = 0;
    }

    /* renamed from: a */
    private int m1678a(T t, int i, int i2, int i3) {
        int i4 = i - 1;
        while (i4 >= i2) {
            T t2 = this.f2573a[i4];
            if (this.f2578f.compare(t2, t) != 0) {
                break;
            } else if (this.f2578f.areItemsTheSame(t2, t)) {
                return i4;
            } else {
                i4--;
            }
        }
        int i5 = i + 1;
        while (i5 < i3) {
            T t3 = this.f2573a[i5];
            if (this.f2578f.compare(t3, t) != 0) {
                break;
            } else if (this.f2578f.areItemsTheSame(t3, t)) {
                return i5;
            } else {
                i5++;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private int m1679a(T t, boolean z) {
        int i = 0;
        int a = m1681a(t, this.f2573a, 0, this.f2580h, 1);
        if (a != -1) {
            if (a < this.f2580h) {
                T t2 = this.f2573a[a];
                if (this.f2578f.areItemsTheSame(t2, t)) {
                    if (this.f2578f.areContentsTheSame(t2, t)) {
                        this.f2573a[a] = t;
                        return a;
                    }
                    this.f2573a[a] = t;
                    this.f2578f.onChanged(a, 1);
                    return a;
                }
            }
            i = a;
        }
        m1683a(i, t);
        if (z) {
            this.f2578f.onInserted(i, 1);
        }
        return i;
    }

    /* renamed from: a */
    private int m1680a(T t, T[] tArr, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (this.f2578f.areItemsTheSame(tArr[i3], t)) {
                return i3;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private int m1681a(T t, T[] tArr, int i, int i2, int i3) {
        int i4;
        int i5 = i2;
        int i6 = i;
        while (i6 < i5) {
            int i7 = (i6 + i5) / 2;
            T t2 = tArr[i7];
            int compare = this.f2578f.compare(t2, t);
            if (compare < 0) {
                int i8 = i5;
                i4 = i7 + 1;
                i7 = i8;
            } else if (compare != 0) {
                i4 = i6;
            } else if (this.f2578f.areItemsTheSame(t2, t)) {
                return i7;
            } else {
                int a = m1678a(t, i7, i6, i5);
                return i3 == 1 ? a != -1 ? a : i7 : a;
            }
            i6 = i4;
            i5 = i7;
        }
        if (i3 != 1) {
            i6 = -1;
        }
        return i6;
    }

    /* renamed from: a */
    private void m1682a() {
        if (this.f2574b != null) {
            throw new IllegalStateException("Cannot call this method from within addAll");
        }
    }

    /* renamed from: a */
    private void m1683a(int i, T t) {
        if (i > this.f2580h) {
            throw new IndexOutOfBoundsException("cannot add item to " + i + " because size is " + this.f2580h);
        }
        if (this.f2580h == this.f2573a.length) {
            T[] tArr = (Object[]) Array.newInstance(this.f2581i, this.f2573a.length + 10);
            System.arraycopy(this.f2573a, 0, tArr, 0, i);
            tArr[i] = t;
            System.arraycopy(this.f2573a, i, tArr, i + 1, this.f2580h - i);
            this.f2573a = tArr;
        } else {
            System.arraycopy(this.f2573a, i, this.f2573a, i + 1, this.f2580h - i);
            this.f2573a[i] = t;
        }
        this.f2580h++;
    }

    /* renamed from: a */
    private void m1684a(int i, boolean z) {
        System.arraycopy(this.f2573a, i + 1, this.f2573a, i, (this.f2580h - i) - 1);
        this.f2580h--;
        this.f2573a[this.f2580h] = null;
        if (z) {
            this.f2578f.onRemoved(i, 1);
        }
    }

    /* renamed from: a */
    private void m1685a(T[] tArr) {
        boolean z = !(this.f2578f instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.f2574b = this.f2573a;
        this.f2575c = 0;
        this.f2576d = this.f2580h;
        Arrays.sort(tArr, this.f2578f);
        int b = m1687b(tArr);
        if (this.f2580h == 0) {
            this.f2573a = tArr;
            this.f2580h = b;
            this.f2577e = b;
            this.f2578f.onInserted(0, b);
        } else {
            m1686a(tArr, b);
        }
        this.f2574b = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    /* renamed from: a */
    private void m1686a(T[] tArr, int i) {
        this.f2573a = (Object[]) Array.newInstance(this.f2581i, this.f2580h + i + 10);
        this.f2577e = 0;
        int i2 = 0;
        while (true) {
            if (this.f2575c >= this.f2576d && i2 >= i) {
                return;
            }
            if (this.f2575c == this.f2576d) {
                int i3 = i - i2;
                System.arraycopy(tArr, i2, this.f2573a, this.f2577e, i3);
                this.f2577e += i3;
                this.f2580h += i3;
                this.f2578f.onInserted(this.f2577e - i3, i3);
                return;
            } else if (i2 == i) {
                int i4 = this.f2576d - this.f2575c;
                System.arraycopy(this.f2574b, this.f2575c, this.f2573a, this.f2577e, i4);
                this.f2577e = i4 + this.f2577e;
                return;
            } else {
                T t = this.f2574b[this.f2575c];
                T t2 = tArr[i2];
                int compare = this.f2578f.compare(t, t2);
                if (compare > 0) {
                    T[] tArr2 = this.f2573a;
                    int i5 = this.f2577e;
                    this.f2577e = i5 + 1;
                    tArr2[i5] = t2;
                    this.f2580h++;
                    i2++;
                    this.f2578f.onInserted(this.f2577e - 1, 1);
                } else if (compare != 0 || !this.f2578f.areItemsTheSame(t, t2)) {
                    T[] tArr3 = this.f2573a;
                    int i6 = this.f2577e;
                    this.f2577e = i6 + 1;
                    tArr3[i6] = t;
                    this.f2575c++;
                } else {
                    T[] tArr4 = this.f2573a;
                    int i7 = this.f2577e;
                    this.f2577e = i7 + 1;
                    tArr4[i7] = t2;
                    i2++;
                    this.f2575c++;
                    if (!this.f2578f.areContentsTheSame(t, t2)) {
                        this.f2578f.onChanged(this.f2577e - 1, 1);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private int m1687b(T[] tArr) {
        if (tArr.length == 0) {
            throw new IllegalArgumentException("Input array must be non-empty");
        }
        int i = 0;
        int i2 = 1;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T t = tArr[i3];
            int compare = this.f2578f.compare(tArr[i], t);
            if (compare > 0) {
                throw new IllegalArgumentException("Input must be sorted in ascending order.");
            }
            if (compare == 0) {
                int a = m1680a(t, tArr, i, i2);
                if (a != -1) {
                    tArr[a] = t;
                } else {
                    if (i2 != i3) {
                        tArr[i2] = t;
                    }
                    i2++;
                }
            } else {
                if (i2 != i3) {
                    tArr[i2] = t;
                }
                i = i2;
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: b */
    private boolean m1688b(T t, boolean z) {
        int a = m1681a(t, this.f2573a, 0, this.f2580h, 2);
        if (a == -1) {
            return false;
        }
        m1684a(a, z);
        return true;
    }

    public int add(T t) {
        m1682a();
        return m1679a(t, true);
    }

    public void addAll(Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance(this.f2581i, collection.size())), true);
    }

    public void addAll(T... tArr) {
        addAll(tArr, false);
    }

    public void addAll(T[] tArr, boolean z) {
        m1682a();
        if (tArr.length != 0) {
            if (z) {
                m1685a(tArr);
                return;
            }
            Object[] objArr = (Object[]) Array.newInstance(this.f2581i, tArr.length);
            System.arraycopy(tArr, 0, objArr, 0, tArr.length);
            m1685a(objArr);
        }
    }

    public void beginBatchedUpdates() {
        m1682a();
        if (!(this.f2578f instanceof BatchedCallback)) {
            if (this.f2579g == null) {
                this.f2579g = new BatchedCallback(this.f2578f);
            }
            this.f2578f = this.f2579g;
        }
    }

    public void clear() {
        m1682a();
        if (this.f2580h != 0) {
            int i = this.f2580h;
            Arrays.fill(this.f2573a, 0, i, (Object) null);
            this.f2580h = 0;
            this.f2578f.onRemoved(0, i);
        }
    }

    public void endBatchedUpdates() {
        m1682a();
        if (this.f2578f instanceof BatchedCallback) {
            ((BatchedCallback) this.f2578f).dispatchLastEvent();
        }
        if (this.f2578f == this.f2579g) {
            this.f2578f = this.f2579g.f2585d;
        }
    }

    public T get(int i) {
        if (i < this.f2580h && i >= 0) {
            return (this.f2574b == null || i < this.f2577e) ? this.f2573a[i] : this.f2574b[(i - this.f2577e) + this.f2575c];
        }
        throw new IndexOutOfBoundsException("Asked to get item at " + i + " but size is " + this.f2580h);
    }

    public int indexOf(T t) {
        if (this.f2574b != null) {
            int a = m1681a(t, this.f2573a, 0, this.f2577e, 4);
            if (a != -1) {
                return a;
            }
            int a2 = m1681a(t, this.f2574b, this.f2575c, this.f2576d, 4);
            if (a2 != -1) {
                return (a2 - this.f2575c) + this.f2577e;
            }
            return -1;
        }
        return m1681a(t, this.f2573a, 0, this.f2580h, 4);
    }

    public void recalculatePositionOfItemAt(int i) {
        m1682a();
        Object obj = get(i);
        m1684a(i, false);
        int a = m1679a(obj, false);
        if (i != a) {
            this.f2578f.onMoved(i, a);
        }
    }

    public boolean remove(T t) {
        m1682a();
        return m1688b(t, true);
    }

    public T removeItemAt(int i) {
        m1682a();
        T t = get(i);
        m1684a(i, true);
        return t;
    }

    public int size() {
        return this.f2580h;
    }

    public void updateItemAt(int i, T t) {
        m1682a();
        T t2 = get(i);
        boolean z = t2 == t || !this.f2578f.areContentsTheSame(t2, t);
        if (t2 == t || this.f2578f.compare(t2, t) != 0) {
            if (z) {
                this.f2578f.onChanged(i, 1);
            }
            m1684a(i, false);
            int a = m1679a(t, false);
            if (i != a) {
                this.f2578f.onMoved(i, a);
                return;
            }
            return;
        }
        this.f2573a[i] = t;
        if (z) {
            this.f2578f.onChanged(i, 1);
        }
    }
}
