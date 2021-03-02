package android.support.p000v4.util;

/* renamed from: android.support.v4.util.CircularIntArray */
public final class CircularIntArray {

    /* renamed from: a */
    private int[] f1090a;

    /* renamed from: b */
    private int f1091b;

    /* renamed from: c */
    private int f1092c;

    /* renamed from: d */
    private int f1093d;

    public CircularIntArray() {
        this(8);
    }

    public CircularIntArray(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        i = Integer.bitCount(i) != 1 ? 1 << (Integer.highestOneBit(i) + 1) : i;
        this.f1093d = i - 1;
        this.f1090a = new int[i];
    }

    /* renamed from: a */
    private void m817a() {
        int length = this.f1090a.length;
        int i = length - this.f1091b;
        int i2 = length << 1;
        if (i2 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr = new int[i2];
        System.arraycopy(this.f1090a, this.f1091b, iArr, 0, i);
        System.arraycopy(this.f1090a, 0, iArr, i, this.f1091b);
        this.f1090a = iArr;
        this.f1091b = 0;
        this.f1092c = length;
        this.f1093d = i2 - 1;
    }

    public void addFirst(int i) {
        this.f1091b = (this.f1091b - 1) & this.f1093d;
        this.f1090a[this.f1091b] = i;
        if (this.f1091b == this.f1092c) {
            m817a();
        }
    }

    public void addLast(int i) {
        this.f1090a[this.f1092c] = i;
        this.f1092c = (this.f1092c + 1) & this.f1093d;
        if (this.f1092c == this.f1091b) {
            m817a();
        }
    }

    public void clear() {
        this.f1092c = this.f1091b;
    }

    public int get(int i) {
        if (i >= 0 && i < size()) {
            return this.f1090a[(this.f1091b + i) & this.f1093d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getFirst() {
        if (this.f1091b != this.f1092c) {
            return this.f1090a[this.f1091b];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        if (this.f1091b != this.f1092c) {
            return this.f1090a[(this.f1092c - 1) & this.f1093d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.f1091b == this.f1092c;
    }

    public int popFirst() {
        if (this.f1091b == this.f1092c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = this.f1090a[this.f1091b];
        this.f1091b = (this.f1091b + 1) & this.f1093d;
        return i;
    }

    public int popLast() {
        if (this.f1091b == this.f1092c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = (this.f1092c - 1) & this.f1093d;
        int i2 = this.f1090a[i];
        this.f1092c = i;
        return i2;
    }

    public void removeFromEnd(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            this.f1092c = (this.f1092c - i) & this.f1093d;
        }
    }

    public void removeFromStart(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            this.f1091b = (this.f1091b + i) & this.f1093d;
        }
    }

    public int size() {
        return (this.f1092c - this.f1091b) & this.f1093d;
    }
}
