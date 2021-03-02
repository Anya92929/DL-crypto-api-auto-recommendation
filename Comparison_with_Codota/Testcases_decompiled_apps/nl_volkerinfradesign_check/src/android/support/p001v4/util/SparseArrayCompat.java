package android.support.p001v4.util;

/* renamed from: android.support.v4.util.SparseArrayCompat */
public class SparseArrayCompat<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f882a = new Object();

    /* renamed from: b */
    private boolean f883b;

    /* renamed from: c */
    private int[] f884c;

    /* renamed from: d */
    private Object[] f885d;

    /* renamed from: e */
    private int f886e;

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int i) {
        this.f883b = false;
        if (i == 0) {
            this.f884c = C1018cq.f4033a;
            this.f885d = C1018cq.f4035c;
        } else {
            int a = C1018cq.m4568a(i);
            this.f884c = new int[a];
            this.f885d = new Object[a];
        }
        this.f886e = 0;
    }

    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            try {
                sparseArrayCompat.f884c = (int[]) this.f884c.clone();
                sparseArrayCompat.f885d = (Object[]) this.f885d.clone();
                return sparseArrayCompat;
            } catch (CloneNotSupportedException e) {
                return sparseArrayCompat;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E get(int i) {
        return get(i, (Object) null);
    }

    public E get(int i, E e) {
        int a = C1018cq.m4569a(this.f884c, this.f886e, i);
        return (a < 0 || this.f885d[a] == f882a) ? e : this.f885d[a];
    }

    public void delete(int i) {
        int a = C1018cq.m4569a(this.f884c, this.f886e, i);
        if (a >= 0 && this.f885d[a] != f882a) {
            this.f885d[a] = f882a;
            this.f883b = true;
        }
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        if (this.f885d[i] != f882a) {
            this.f885d[i] = f882a;
            this.f883b = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        int min = Math.min(this.f886e, i + i2);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    /* renamed from: a */
    private void m995a() {
        int i = this.f886e;
        int[] iArr = this.f884c;
        Object[] objArr = this.f885d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f882a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f883b = false;
        this.f886e = i2;
    }

    public void put(int i, E e) {
        int a = C1018cq.m4569a(this.f884c, this.f886e, i);
        if (a >= 0) {
            this.f885d[a] = e;
            return;
        }
        int i2 = a ^ -1;
        if (i2 >= this.f886e || this.f885d[i2] != f882a) {
            if (this.f883b && this.f886e >= this.f884c.length) {
                m995a();
                i2 = C1018cq.m4569a(this.f884c, this.f886e, i) ^ -1;
            }
            if (this.f886e >= this.f884c.length) {
                int a2 = C1018cq.m4568a(this.f886e + 1);
                int[] iArr = new int[a2];
                Object[] objArr = new Object[a2];
                System.arraycopy(this.f884c, 0, iArr, 0, this.f884c.length);
                System.arraycopy(this.f885d, 0, objArr, 0, this.f885d.length);
                this.f884c = iArr;
                this.f885d = objArr;
            }
            if (this.f886e - i2 != 0) {
                System.arraycopy(this.f884c, i2, this.f884c, i2 + 1, this.f886e - i2);
                System.arraycopy(this.f885d, i2, this.f885d, i2 + 1, this.f886e - i2);
            }
            this.f884c[i2] = i;
            this.f885d[i2] = e;
            this.f886e++;
            return;
        }
        this.f884c[i2] = i;
        this.f885d[i2] = e;
    }

    public int size() {
        if (this.f883b) {
            m995a();
        }
        return this.f886e;
    }

    public int keyAt(int i) {
        if (this.f883b) {
            m995a();
        }
        return this.f884c[i];
    }

    public E valueAt(int i) {
        if (this.f883b) {
            m995a();
        }
        return this.f885d[i];
    }

    public void setValueAt(int i, E e) {
        if (this.f883b) {
            m995a();
        }
        this.f885d[i] = e;
    }

    public int indexOfKey(int i) {
        if (this.f883b) {
            m995a();
        }
        return C1018cq.m4569a(this.f884c, this.f886e, i);
    }

    public int indexOfValue(E e) {
        if (this.f883b) {
            m995a();
        }
        for (int i = 0; i < this.f886e; i++) {
            if (this.f885d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        int i = this.f886e;
        Object[] objArr = this.f885d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f886e = 0;
        this.f883b = false;
    }

    public void append(int i, E e) {
        if (this.f886e == 0 || i > this.f884c[this.f886e - 1]) {
            if (this.f883b && this.f886e >= this.f884c.length) {
                m995a();
            }
            int i2 = this.f886e;
            if (i2 >= this.f884c.length) {
                int a = C1018cq.m4568a(i2 + 1);
                int[] iArr = new int[a];
                Object[] objArr = new Object[a];
                System.arraycopy(this.f884c, 0, iArr, 0, this.f884c.length);
                System.arraycopy(this.f885d, 0, objArr, 0, this.f885d.length);
                this.f884c = iArr;
                this.f885d = objArr;
            }
            this.f884c[i2] = i;
            this.f885d[i2] = e;
            this.f886e = i2 + 1;
            return;
        }
        put(i, e);
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f886e * 28);
        sb.append('{');
        for (int i = 0; i < this.f886e; i++) {
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
