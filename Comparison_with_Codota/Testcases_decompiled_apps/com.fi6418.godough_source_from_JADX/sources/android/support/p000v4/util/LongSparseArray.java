package android.support.p000v4.util;

/* renamed from: android.support.v4.util.LongSparseArray */
public class LongSparseArray<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f1099a = new Object();

    /* renamed from: b */
    private boolean f1100b;

    /* renamed from: c */
    private long[] f1101c;

    /* renamed from: d */
    private Object[] f1102d;

    /* renamed from: e */
    private int f1103e;

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i) {
        this.f1100b = false;
        if (i == 0) {
            this.f1101c = ContainerHelpers.f1095b;
            this.f1102d = ContainerHelpers.f1096c;
        } else {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i);
            this.f1101c = new long[idealLongArraySize];
            this.f1102d = new Object[idealLongArraySize];
        }
        this.f1103e = 0;
    }

    /* renamed from: a */
    private void m821a() {
        int i = this.f1103e;
        long[] jArr = this.f1101c;
        Object[] objArr = this.f1102d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1099a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1100b = false;
        this.f1103e = i2;
    }

    public void append(long j, E e) {
        if (this.f1103e == 0 || j > this.f1101c[this.f1103e - 1]) {
            if (this.f1100b && this.f1103e >= this.f1101c.length) {
                m821a();
            }
            int i = this.f1103e;
            if (i >= this.f1101c.length) {
                int idealLongArraySize = ContainerHelpers.idealLongArraySize(i + 1);
                long[] jArr = new long[idealLongArraySize];
                Object[] objArr = new Object[idealLongArraySize];
                System.arraycopy(this.f1101c, 0, jArr, 0, this.f1101c.length);
                System.arraycopy(this.f1102d, 0, objArr, 0, this.f1102d.length);
                this.f1101c = jArr;
                this.f1102d = objArr;
            }
            this.f1101c[i] = j;
            this.f1102d[i] = e;
            this.f1103e = i + 1;
            return;
        }
        put(j, e);
    }

    public void clear() {
        int i = this.f1103e;
        Object[] objArr = this.f1102d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1103e = 0;
        this.f1100b = false;
    }

    public LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            try {
                longSparseArray.f1101c = (long[]) this.f1101c.clone();
                longSparseArray.f1102d = (Object[]) this.f1102d.clone();
                return longSparseArray;
            } catch (CloneNotSupportedException e) {
                return longSparseArray;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public void delete(long j) {
        int a = ContainerHelpers.m819a(this.f1101c, this.f1103e, j);
        if (a >= 0 && this.f1102d[a] != f1099a) {
            this.f1102d[a] = f1099a;
            this.f1100b = true;
        }
    }

    public E get(long j) {
        return get(j, (Object) null);
    }

    public E get(long j, E e) {
        int a = ContainerHelpers.m819a(this.f1101c, this.f1103e, j);
        return (a < 0 || this.f1102d[a] == f1099a) ? e : this.f1102d[a];
    }

    public int indexOfKey(long j) {
        if (this.f1100b) {
            m821a();
        }
        return ContainerHelpers.m819a(this.f1101c, this.f1103e, j);
    }

    public int indexOfValue(E e) {
        if (this.f1100b) {
            m821a();
        }
        for (int i = 0; i < this.f1103e; i++) {
            if (this.f1102d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public long keyAt(int i) {
        if (this.f1100b) {
            m821a();
        }
        return this.f1101c[i];
    }

    public void put(long j, E e) {
        int a = ContainerHelpers.m819a(this.f1101c, this.f1103e, j);
        if (a >= 0) {
            this.f1102d[a] = e;
            return;
        }
        int i = a ^ -1;
        if (i >= this.f1103e || this.f1102d[i] != f1099a) {
            if (this.f1100b && this.f1103e >= this.f1101c.length) {
                m821a();
                i = ContainerHelpers.m819a(this.f1101c, this.f1103e, j) ^ -1;
            }
            if (this.f1103e >= this.f1101c.length) {
                int idealLongArraySize = ContainerHelpers.idealLongArraySize(this.f1103e + 1);
                long[] jArr = new long[idealLongArraySize];
                Object[] objArr = new Object[idealLongArraySize];
                System.arraycopy(this.f1101c, 0, jArr, 0, this.f1101c.length);
                System.arraycopy(this.f1102d, 0, objArr, 0, this.f1102d.length);
                this.f1101c = jArr;
                this.f1102d = objArr;
            }
            if (this.f1103e - i != 0) {
                System.arraycopy(this.f1101c, i, this.f1101c, i + 1, this.f1103e - i);
                System.arraycopy(this.f1102d, i, this.f1102d, i + 1, this.f1103e - i);
            }
            this.f1101c[i] = j;
            this.f1102d[i] = e;
            this.f1103e++;
            return;
        }
        this.f1101c[i] = j;
        this.f1102d[i] = e;
    }

    public void remove(long j) {
        delete(j);
    }

    public void removeAt(int i) {
        if (this.f1102d[i] != f1099a) {
            this.f1102d[i] = f1099a;
            this.f1100b = true;
        }
    }

    public void setValueAt(int i, E e) {
        if (this.f1100b) {
            m821a();
        }
        this.f1102d[i] = e;
    }

    public int size() {
        if (this.f1100b) {
            m821a();
        }
        return this.f1103e;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1103e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1103e; i++) {
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

    public E valueAt(int i) {
        if (this.f1100b) {
            m821a();
        }
        return this.f1102d[i];
    }
}
