package android.support.p001v4.util;

/* renamed from: android.support.v4.util.LongSparseArray */
public class LongSparseArray<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f859a = new Object();

    /* renamed from: b */
    private boolean f860b;

    /* renamed from: c */
    private long[] f861c;

    /* renamed from: d */
    private Object[] f862d;

    /* renamed from: e */
    private int f863e;

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i) {
        this.f860b = false;
        if (i == 0) {
            this.f861c = C1018cq.f4034b;
            this.f862d = C1018cq.f4035c;
        } else {
            int b = C1018cq.m4572b(i);
            this.f861c = new long[b];
            this.f862d = new Object[b];
        }
        this.f863e = 0;
    }

    public LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            try {
                longSparseArray.f861c = (long[]) this.f861c.clone();
                longSparseArray.f862d = (Object[]) this.f862d.clone();
                return longSparseArray;
            } catch (CloneNotSupportedException e) {
                return longSparseArray;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E get(long j) {
        return get(j, (Object) null);
    }

    public E get(long j, E e) {
        int a = C1018cq.m4570a(this.f861c, this.f863e, j);
        return (a < 0 || this.f862d[a] == f859a) ? e : this.f862d[a];
    }

    public void delete(long j) {
        int a = C1018cq.m4570a(this.f861c, this.f863e, j);
        if (a >= 0 && this.f862d[a] != f859a) {
            this.f862d[a] = f859a;
            this.f860b = true;
        }
    }

    public void remove(long j) {
        delete(j);
    }

    public void removeAt(int i) {
        if (this.f862d[i] != f859a) {
            this.f862d[i] = f859a;
            this.f860b = true;
        }
    }

    /* renamed from: a */
    private void m986a() {
        int i = this.f863e;
        long[] jArr = this.f861c;
        Object[] objArr = this.f862d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f859a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f860b = false;
        this.f863e = i2;
    }

    public void put(long j, E e) {
        int a = C1018cq.m4570a(this.f861c, this.f863e, j);
        if (a >= 0) {
            this.f862d[a] = e;
            return;
        }
        int i = a ^ -1;
        if (i >= this.f863e || this.f862d[i] != f859a) {
            if (this.f860b && this.f863e >= this.f861c.length) {
                m986a();
                i = C1018cq.m4570a(this.f861c, this.f863e, j) ^ -1;
            }
            if (this.f863e >= this.f861c.length) {
                int b = C1018cq.m4572b(this.f863e + 1);
                long[] jArr = new long[b];
                Object[] objArr = new Object[b];
                System.arraycopy(this.f861c, 0, jArr, 0, this.f861c.length);
                System.arraycopy(this.f862d, 0, objArr, 0, this.f862d.length);
                this.f861c = jArr;
                this.f862d = objArr;
            }
            if (this.f863e - i != 0) {
                System.arraycopy(this.f861c, i, this.f861c, i + 1, this.f863e - i);
                System.arraycopy(this.f862d, i, this.f862d, i + 1, this.f863e - i);
            }
            this.f861c[i] = j;
            this.f862d[i] = e;
            this.f863e++;
            return;
        }
        this.f861c[i] = j;
        this.f862d[i] = e;
    }

    public int size() {
        if (this.f860b) {
            m986a();
        }
        return this.f863e;
    }

    public long keyAt(int i) {
        if (this.f860b) {
            m986a();
        }
        return this.f861c[i];
    }

    public E valueAt(int i) {
        if (this.f860b) {
            m986a();
        }
        return this.f862d[i];
    }

    public void setValueAt(int i, E e) {
        if (this.f860b) {
            m986a();
        }
        this.f862d[i] = e;
    }

    public int indexOfKey(long j) {
        if (this.f860b) {
            m986a();
        }
        return C1018cq.m4570a(this.f861c, this.f863e, j);
    }

    public int indexOfValue(E e) {
        if (this.f860b) {
            m986a();
        }
        for (int i = 0; i < this.f863e; i++) {
            if (this.f862d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        int i = this.f863e;
        Object[] objArr = this.f862d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f863e = 0;
        this.f860b = false;
    }

    public void append(long j, E e) {
        if (this.f863e == 0 || j > this.f861c[this.f863e - 1]) {
            if (this.f860b && this.f863e >= this.f861c.length) {
                m986a();
            }
            int i = this.f863e;
            if (i >= this.f861c.length) {
                int b = C1018cq.m4572b(i + 1);
                long[] jArr = new long[b];
                Object[] objArr = new Object[b];
                System.arraycopy(this.f861c, 0, jArr, 0, this.f861c.length);
                System.arraycopy(this.f862d, 0, objArr, 0, this.f862d.length);
                this.f861c = jArr;
                this.f862d = objArr;
            }
            this.f861c[i] = j;
            this.f862d[i] = e;
            this.f863e = i + 1;
            return;
        }
        put(j, e);
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f863e * 28);
        sb.append('{');
        for (int i = 0; i < this.f863e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i));
            sb.append('=');
            Object valueAt = valueAt(i);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
