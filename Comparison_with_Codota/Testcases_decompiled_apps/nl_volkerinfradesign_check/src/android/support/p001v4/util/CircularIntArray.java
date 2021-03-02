package android.support.p001v4.util;

/* renamed from: android.support.v4.util.CircularIntArray */
public final class CircularIntArray {

    /* renamed from: a */
    private int[] f853a;

    /* renamed from: b */
    private int f854b;

    /* renamed from: c */
    private int f855c;

    /* renamed from: d */
    private int f856d;

    /* renamed from: a */
    private void m984a() {
        int length = this.f853a.length;
        int i = length - this.f854b;
        int i2 = length << 1;
        if (i2 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr = new int[i2];
        System.arraycopy(this.f853a, this.f854b, iArr, 0, i);
        System.arraycopy(this.f853a, 0, iArr, i, this.f854b);
        this.f853a = iArr;
        this.f854b = 0;
        this.f855c = length;
        this.f856d = i2 - 1;
    }

    public CircularIntArray() {
        this(8);
    }

    public CircularIntArray(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        i = Integer.bitCount(i) != 1 ? 1 << (Integer.highestOneBit(i) + 1) : i;
        this.f856d = i - 1;
        this.f853a = new int[i];
    }

    public void addFirst(int i) {
        this.f854b = (this.f854b - 1) & this.f856d;
        this.f853a[this.f854b] = i;
        if (this.f854b == this.f855c) {
            m984a();
        }
    }

    public void addLast(int i) {
        this.f853a[this.f855c] = i;
        this.f855c = (this.f855c + 1) & this.f856d;
        if (this.f855c == this.f854b) {
            m984a();
        }
    }

    public int popFirst() {
        if (this.f854b == this.f855c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = this.f853a[this.f854b];
        this.f854b = (this.f854b + 1) & this.f856d;
        return i;
    }

    public int popLast() {
        if (this.f854b == this.f855c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = (this.f855c - 1) & this.f856d;
        int i2 = this.f853a[i];
        this.f855c = i;
        return i2;
    }

    public void clear() {
        this.f855c = this.f854b;
    }

    public void removeFromStart(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            this.f854b = (this.f854b + i) & this.f856d;
        }
    }

    public void removeFromEnd(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            this.f855c = (this.f855c - i) & this.f856d;
        }
    }

    public int getFirst() {
        if (this.f854b != this.f855c) {
            return this.f853a[this.f854b];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        if (this.f854b != this.f855c) {
            return this.f853a[(this.f855c - 1) & this.f856d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int get(int i) {
        if (i >= 0 && i < size()) {
            return this.f853a[(this.f854b + i) & this.f856d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return (this.f855c - this.f854b) & this.f856d;
    }

    public boolean isEmpty() {
        return this.f854b == this.f855c;
    }
}
