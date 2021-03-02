package android.support.p003v7.widget;

import java.util.ArrayList;

/* renamed from: android.support.v7.widget.PositionMap */
class PositionMap<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f2890a = new Object();

    /* renamed from: b */
    private boolean f2891b;

    /* renamed from: c */
    private int[] f2892c;

    /* renamed from: d */
    private Object[] f2893d;

    /* renamed from: e */
    private int f2894e;

    /* renamed from: android.support.v7.widget.PositionMap$ContainerHelpers */
    class ContainerHelpers {

        /* renamed from: a */
        static final boolean[] f2895a = new boolean[0];

        /* renamed from: b */
        static final int[] f2896b = new int[0];

        /* renamed from: c */
        static final long[] f2897c = new long[0];

        /* renamed from: d */
        static final Object[] f2898d = new Object[0];

        ContainerHelpers() {
        }

        /* renamed from: a */
        static int m1950a(int[] iArr, int i, int i2) {
            int i3 = 0;
            int i4 = i - 1;
            while (i3 <= i4) {
                int i5 = (i3 + i4) >>> 1;
                int i6 = iArr[i5];
                if (i6 < i2) {
                    i3 = i5 + 1;
                } else if (i6 <= i2) {
                    return i5;
                } else {
                    i4 = i5 - 1;
                }
            }
            return i3 ^ -1;
        }
    }

    public PositionMap() {
        this(10);
    }

    public PositionMap(int i) {
        this.f2891b = false;
        if (i == 0) {
            this.f2892c = ContainerHelpers.f2896b;
            this.f2893d = ContainerHelpers.f2898d;
        } else {
            int b = m1949b(i);
            this.f2892c = new int[b];
            this.f2893d = new Object[b];
        }
        this.f2894e = 0;
    }

    /* renamed from: a */
    static int m1947a(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    /* renamed from: a */
    private void m1948a() {
        int i = this.f2894e;
        int[] iArr = this.f2892c;
        Object[] objArr = this.f2893d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f2890a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f2891b = false;
        this.f2894e = i2;
    }

    /* renamed from: b */
    static int m1949b(int i) {
        return m1947a(i * 4) / 4;
    }

    public void append(int i, E e) {
        if (this.f2894e == 0 || i > this.f2892c[this.f2894e - 1]) {
            if (this.f2891b && this.f2894e >= this.f2892c.length) {
                m1948a();
            }
            int i2 = this.f2894e;
            if (i2 >= this.f2892c.length) {
                int b = m1949b(i2 + 1);
                int[] iArr = new int[b];
                Object[] objArr = new Object[b];
                System.arraycopy(this.f2892c, 0, iArr, 0, this.f2892c.length);
                System.arraycopy(this.f2893d, 0, objArr, 0, this.f2893d.length);
                this.f2892c = iArr;
                this.f2893d = objArr;
            }
            this.f2892c[i2] = i;
            this.f2893d[i2] = e;
            this.f2894e = i2 + 1;
            return;
        }
        put(i, e);
    }

    public void clear() {
        int i = this.f2894e;
        Object[] objArr = this.f2893d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f2894e = 0;
        this.f2891b = false;
    }

    public PositionMap<E> clone() {
        try {
            PositionMap<E> positionMap = (PositionMap) super.clone();
            try {
                positionMap.f2892c = (int[]) this.f2892c.clone();
                positionMap.f2893d = (Object[]) this.f2893d.clone();
                return positionMap;
            } catch (CloneNotSupportedException e) {
                return positionMap;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public void delete(int i) {
        int a = ContainerHelpers.m1950a(this.f2892c, this.f2894e, i);
        if (a >= 0 && this.f2893d[a] != f2890a) {
            this.f2893d[a] = f2890a;
            this.f2891b = true;
        }
    }

    public E get(int i) {
        return get(i, (Object) null);
    }

    public E get(int i, E e) {
        int a = ContainerHelpers.m1950a(this.f2892c, this.f2894e, i);
        return (a < 0 || this.f2893d[a] == f2890a) ? e : this.f2893d[a];
    }

    public int indexOfKey(int i) {
        if (this.f2891b) {
            m1948a();
        }
        return ContainerHelpers.m1950a(this.f2892c, this.f2894e, i);
    }

    public int indexOfValue(E e) {
        if (this.f2891b) {
            m1948a();
        }
        for (int i = 0; i < this.f2894e; i++) {
            if (this.f2893d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void insertKeyRange(int i, int i2) {
    }

    public int keyAt(int i) {
        if (this.f2891b) {
            m1948a();
        }
        return this.f2892c[i];
    }

    public void put(int i, E e) {
        int a = ContainerHelpers.m1950a(this.f2892c, this.f2894e, i);
        if (a >= 0) {
            this.f2893d[a] = e;
            return;
        }
        int i2 = a ^ -1;
        if (i2 >= this.f2894e || this.f2893d[i2] != f2890a) {
            if (this.f2891b && this.f2894e >= this.f2892c.length) {
                m1948a();
                i2 = ContainerHelpers.m1950a(this.f2892c, this.f2894e, i) ^ -1;
            }
            if (this.f2894e >= this.f2892c.length) {
                int b = m1949b(this.f2894e + 1);
                int[] iArr = new int[b];
                Object[] objArr = new Object[b];
                System.arraycopy(this.f2892c, 0, iArr, 0, this.f2892c.length);
                System.arraycopy(this.f2893d, 0, objArr, 0, this.f2893d.length);
                this.f2892c = iArr;
                this.f2893d = objArr;
            }
            if (this.f2894e - i2 != 0) {
                System.arraycopy(this.f2892c, i2, this.f2892c, i2 + 1, this.f2894e - i2);
                System.arraycopy(this.f2893d, i2, this.f2893d, i2 + 1, this.f2894e - i2);
            }
            this.f2892c[i2] = i;
            this.f2893d[i2] = e;
            this.f2894e++;
            return;
        }
        this.f2892c[i2] = i;
        this.f2893d[i2] = e;
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        if (this.f2893d[i] != f2890a) {
            this.f2893d[i] = f2890a;
            this.f2891b = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        int min = Math.min(this.f2894e, i + i2);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    public void removeKeyRange(ArrayList<E> arrayList, int i, int i2) {
    }

    public void setValueAt(int i, E e) {
        if (this.f2891b) {
            m1948a();
        }
        this.f2893d[i] = e;
    }

    public int size() {
        if (this.f2891b) {
            m1948a();
        }
        return this.f2894e;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2894e * 28);
        sb.append('{');
        for (int i = 0; i < this.f2894e; i++) {
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
        if (this.f2891b) {
            m1948a();
        }
        return this.f2893d[i];
    }
}
