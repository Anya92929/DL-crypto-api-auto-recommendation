package android.support.p001v4.util;

/* renamed from: android.support.v4.util.CircularArray */
public final class CircularArray<E> {

    /* renamed from: a */
    private E[] f849a;

    /* renamed from: b */
    private int f850b;

    /* renamed from: c */
    private int f851c;

    /* renamed from: d */
    private int f852d;

    /* renamed from: a */
    private void m983a() {
        int length = this.f849a.length;
        int i = length - this.f850b;
        int i2 = length << 1;
        if (i2 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        E[] eArr = new Object[i2];
        System.arraycopy(this.f849a, this.f850b, eArr, 0, i);
        System.arraycopy(this.f849a, 0, eArr, i, this.f850b);
        this.f849a = (Object[]) eArr;
        this.f850b = 0;
        this.f851c = length;
        this.f852d = i2 - 1;
    }

    public CircularArray() {
        this(8);
    }

    public CircularArray(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        i = Integer.bitCount(i) != 1 ? 1 << (Integer.highestOneBit(i) + 1) : i;
        this.f852d = i - 1;
        this.f849a = (Object[]) new Object[i];
    }

    public void addFirst(E e) {
        this.f850b = (this.f850b - 1) & this.f852d;
        this.f849a[this.f850b] = e;
        if (this.f850b == this.f851c) {
            m983a();
        }
    }

    public void addLast(E e) {
        this.f849a[this.f851c] = e;
        this.f851c = (this.f851c + 1) & this.f852d;
        if (this.f851c == this.f850b) {
            m983a();
        }
    }

    public E popFirst() {
        if (this.f850b == this.f851c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.f849a[this.f850b];
        this.f849a[this.f850b] = null;
        this.f850b = (this.f850b + 1) & this.f852d;
        return e;
    }

    public E popLast() {
        if (this.f850b == this.f851c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = (this.f851c - 1) & this.f852d;
        E e = this.f849a[i];
        this.f849a[i] = null;
        this.f851c = i;
        return e;
    }

    public void clear() {
        removeFromStart(size());
    }

    public void removeFromStart(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int length = this.f849a.length;
            if (i < length - this.f850b) {
                length = this.f850b + i;
            }
            for (int i2 = this.f850b; i2 < length; i2++) {
                this.f849a[i2] = null;
            }
            int i3 = length - this.f850b;
            int i4 = i - i3;
            this.f850b = (i3 + this.f850b) & this.f852d;
            if (i4 > 0) {
                for (int i5 = 0; i5 < i4; i5++) {
                    this.f849a[i5] = null;
                }
                this.f850b = i4;
            }
        }
    }

    public void removeFromEnd(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i2 = 0;
            if (i < this.f851c) {
                i2 = this.f851c - i;
            }
            for (int i3 = i2; i3 < this.f851c; i3++) {
                this.f849a[i3] = null;
            }
            int i4 = this.f851c - i2;
            int i5 = i - i4;
            this.f851c -= i4;
            if (i5 > 0) {
                this.f851c = this.f849a.length;
                int i6 = this.f851c - i5;
                for (int i7 = i6; i7 < this.f851c; i7++) {
                    this.f849a[i7] = null;
                }
                this.f851c = i6;
            }
        }
    }

    public E getFirst() {
        if (this.f850b != this.f851c) {
            return this.f849a[this.f850b];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        if (this.f850b != this.f851c) {
            return this.f849a[(this.f851c - 1) & this.f852d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E get(int i) {
        if (i >= 0 && i < size()) {
            return this.f849a[(this.f850b + i) & this.f852d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return (this.f851c - this.f850b) & this.f852d;
    }

    public boolean isEmpty() {
        return this.f850b == this.f851c;
    }
}
