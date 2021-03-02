package android.support.p000v4.util;

/* renamed from: android.support.v4.util.SparseArrayCompat */
public class SparseArrayCompat<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f1137a = new Object();

    /* renamed from: b */
    private boolean f1138b;

    /* renamed from: c */
    private int[] f1139c;

    /* renamed from: d */
    private Object[] f1140d;

    /* renamed from: e */
    private int f1141e;

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int i) {
        this.f1138b = false;
        if (i == 0) {
            this.f1139c = ContainerHelpers.f1094a;
            this.f1140d = ContainerHelpers.f1096c;
        } else {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i);
            this.f1139c = new int[idealIntArraySize];
            this.f1140d = new Object[idealIntArraySize];
        }
        this.f1141e = 0;
    }

    /* renamed from: a */
    private void m842a() {
        int i = this.f1141e;
        int[] iArr = this.f1139c;
        Object[] objArr = this.f1140d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1137a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1138b = false;
        this.f1141e = i2;
    }

    public void append(int i, E e) {
        if (this.f1141e == 0 || i > this.f1139c[this.f1141e - 1]) {
            if (this.f1138b && this.f1141e >= this.f1139c.length) {
                m842a();
            }
            int i2 = this.f1141e;
            if (i2 >= this.f1139c.length) {
                int idealIntArraySize = ContainerHelpers.idealIntArraySize(i2 + 1);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr = new Object[idealIntArraySize];
                System.arraycopy(this.f1139c, 0, iArr, 0, this.f1139c.length);
                System.arraycopy(this.f1140d, 0, objArr, 0, this.f1140d.length);
                this.f1139c = iArr;
                this.f1140d = objArr;
            }
            this.f1139c[i2] = i;
            this.f1140d[i2] = e;
            this.f1141e = i2 + 1;
            return;
        }
        put(i, e);
    }

    public void clear() {
        int i = this.f1141e;
        Object[] objArr = this.f1140d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1141e = 0;
        this.f1138b = false;
    }

    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            try {
                sparseArrayCompat.f1139c = (int[]) this.f1139c.clone();
                sparseArrayCompat.f1140d = (Object[]) this.f1140d.clone();
                return sparseArrayCompat;
            } catch (CloneNotSupportedException e) {
                return sparseArrayCompat;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public void delete(int i) {
        int a = ContainerHelpers.m818a(this.f1139c, this.f1141e, i);
        if (a >= 0 && this.f1140d[a] != f1137a) {
            this.f1140d[a] = f1137a;
            this.f1138b = true;
        }
    }

    public E get(int i) {
        return get(i, (Object) null);
    }

    public E get(int i, E e) {
        int a = ContainerHelpers.m818a(this.f1139c, this.f1141e, i);
        return (a < 0 || this.f1140d[a] == f1137a) ? e : this.f1140d[a];
    }

    public int indexOfKey(int i) {
        if (this.f1138b) {
            m842a();
        }
        return ContainerHelpers.m818a(this.f1139c, this.f1141e, i);
    }

    public int indexOfValue(E e) {
        if (this.f1138b) {
            m842a();
        }
        for (int i = 0; i < this.f1141e; i++) {
            if (this.f1140d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int keyAt(int i) {
        if (this.f1138b) {
            m842a();
        }
        return this.f1139c[i];
    }

    public void put(int i, E e) {
        int a = ContainerHelpers.m818a(this.f1139c, this.f1141e, i);
        if (a >= 0) {
            this.f1140d[a] = e;
            return;
        }
        int i2 = a ^ -1;
        if (i2 >= this.f1141e || this.f1140d[i2] != f1137a) {
            if (this.f1138b && this.f1141e >= this.f1139c.length) {
                m842a();
                i2 = ContainerHelpers.m818a(this.f1139c, this.f1141e, i) ^ -1;
            }
            if (this.f1141e >= this.f1139c.length) {
                int idealIntArraySize = ContainerHelpers.idealIntArraySize(this.f1141e + 1);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr = new Object[idealIntArraySize];
                System.arraycopy(this.f1139c, 0, iArr, 0, this.f1139c.length);
                System.arraycopy(this.f1140d, 0, objArr, 0, this.f1140d.length);
                this.f1139c = iArr;
                this.f1140d = objArr;
            }
            if (this.f1141e - i2 != 0) {
                System.arraycopy(this.f1139c, i2, this.f1139c, i2 + 1, this.f1141e - i2);
                System.arraycopy(this.f1140d, i2, this.f1140d, i2 + 1, this.f1141e - i2);
            }
            this.f1139c[i2] = i;
            this.f1140d[i2] = e;
            this.f1141e++;
            return;
        }
        this.f1139c[i2] = i;
        this.f1140d[i2] = e;
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        if (this.f1140d[i] != f1137a) {
            this.f1140d[i] = f1137a;
            this.f1138b = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        int min = Math.min(this.f1141e, i + i2);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    public void setValueAt(int i, E e) {
        if (this.f1138b) {
            m842a();
        }
        this.f1140d[i] = e;
    }

    public int size() {
        if (this.f1138b) {
            m842a();
        }
        return this.f1141e;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1141e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1141e; i++) {
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
        if (this.f1138b) {
            m842a();
        }
        return this.f1140d[i];
    }
}
