package android.support.p000v4.util;

/* renamed from: android.support.v4.util.CircularArray */
public final class CircularArray<E> {

    /* renamed from: a */
    private E[] f1086a;

    /* renamed from: b */
    private int f1087b;

    /* renamed from: c */
    private int f1088c;

    /* renamed from: d */
    private int f1089d;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        i = Integer.bitCount(i) != 1 ? 1 << (Integer.highestOneBit(i) + 1) : i;
        this.f1089d = i - 1;
        this.f1086a = (Object[]) new Object[i];
    }

    /* renamed from: a */
    private void m816a() {
        int length = this.f1086a.length;
        int i = length - this.f1087b;
        int i2 = length << 1;
        if (i2 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        E[] eArr = new Object[i2];
        System.arraycopy(this.f1086a, this.f1087b, eArr, 0, i);
        System.arraycopy(this.f1086a, 0, eArr, i, this.f1087b);
        this.f1086a = (Object[]) eArr;
        this.f1087b = 0;
        this.f1088c = length;
        this.f1089d = i2 - 1;
    }

    public void addFirst(E e) {
        this.f1087b = (this.f1087b - 1) & this.f1089d;
        this.f1086a[this.f1087b] = e;
        if (this.f1087b == this.f1088c) {
            m816a();
        }
    }

    public void addLast(E e) {
        this.f1086a[this.f1088c] = e;
        this.f1088c = (this.f1088c + 1) & this.f1089d;
        if (this.f1088c == this.f1087b) {
            m816a();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i) {
        if (i >= 0 && i < size()) {
            return this.f1086a[(this.f1087b + i) & this.f1089d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getFirst() {
        if (this.f1087b != this.f1088c) {
            return this.f1086a[this.f1087b];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        if (this.f1087b != this.f1088c) {
            return this.f1086a[(this.f1088c - 1) & this.f1089d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.f1087b == this.f1088c;
    }

    public E popFirst() {
        if (this.f1087b == this.f1088c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.f1086a[this.f1087b];
        this.f1086a[this.f1087b] = null;
        this.f1087b = (this.f1087b + 1) & this.f1089d;
        return e;
    }

    public E popLast() {
        if (this.f1087b == this.f1088c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = (this.f1088c - 1) & this.f1089d;
        E e = this.f1086a[i];
        this.f1086a[i] = null;
        this.f1088c = i;
        return e;
    }

    public void removeFromEnd(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i2 = 0;
            if (i < this.f1088c) {
                i2 = this.f1088c - i;
            }
            for (int i3 = i2; i3 < this.f1088c; i3++) {
                this.f1086a[i3] = null;
            }
            int i4 = this.f1088c - i2;
            int i5 = i - i4;
            this.f1088c -= i4;
            if (i5 > 0) {
                this.f1088c = this.f1086a.length;
                int i6 = this.f1088c - i5;
                for (int i7 = i6; i7 < this.f1088c; i7++) {
                    this.f1086a[i7] = null;
                }
                this.f1088c = i6;
            }
        }
    }

    public void removeFromStart(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int length = this.f1086a.length;
            if (i < length - this.f1087b) {
                length = this.f1087b + i;
            }
            for (int i2 = this.f1087b; i2 < length; i2++) {
                this.f1086a[i2] = null;
            }
            int i3 = length - this.f1087b;
            int i4 = i - i3;
            this.f1087b = (i3 + this.f1087b) & this.f1089d;
            if (i4 > 0) {
                for (int i5 = 0; i5 < i4; i5++) {
                    this.f1086a[i5] = null;
                }
                this.f1087b = i4;
            }
        }
    }

    public int size() {
        return (this.f1088c - this.f1087b) & this.f1089d;
    }
}
