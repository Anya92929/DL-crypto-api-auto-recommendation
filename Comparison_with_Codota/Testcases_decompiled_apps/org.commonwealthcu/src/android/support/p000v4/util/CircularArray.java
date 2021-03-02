package android.support.p000v4.util;

/* renamed from: android.support.v4.util.CircularArray */
public final class CircularArray {
    private int mCapacityBitmask;
    private Object[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        i = Integer.bitCount(i) != 1 ? 1 << (Integer.highestOneBit(i) + 1) : i;
        this.mCapacityBitmask = i - 1;
        this.mElements = new Object[i];
    }

    private void doubleCapacity() {
        int length = this.mElements.length;
        int i = length - this.mHead;
        int i2 = length << 1;
        if (i2 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        Object[] objArr = new Object[i2];
        System.arraycopy(this.mElements, this.mHead, objArr, 0, i);
        System.arraycopy(this.mElements, 0, objArr, i, this.mHead);
        this.mElements = objArr;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i2 - 1;
    }

    public final void addFirst(Object obj) {
        this.mHead = (this.mHead - 1) & this.mCapacityBitmask;
        this.mElements[this.mHead] = obj;
        if (this.mHead == this.mTail) {
            doubleCapacity();
        }
    }

    public final void addLast(Object obj) {
        this.mElements[this.mTail] = obj;
        this.mTail = (this.mTail + 1) & this.mCapacityBitmask;
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final Object get(int i) {
        if (i >= 0 && i < size()) {
            return this.mElements[(this.mHead + i) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final Object getFirst() {
        if (this.mHead != this.mTail) {
            return this.mElements[this.mHead];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final Object getLast() {
        if (this.mHead != this.mTail) {
            return this.mElements[(this.mTail - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        return this.mHead == this.mTail;
    }

    public final Object popFirst() {
        if (this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object obj = this.mElements[this.mHead];
        this.mElements[this.mHead] = null;
        this.mHead = (this.mHead + 1) & this.mCapacityBitmask;
        return obj;
    }

    public final Object popLast() {
        if (this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = (this.mTail - 1) & this.mCapacityBitmask;
        Object obj = this.mElements[i];
        this.mElements[i] = null;
        this.mTail = i;
        return obj;
    }

    public final void removeFromEnd(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i2 = 0;
            if (i < this.mTail) {
                i2 = this.mTail - i;
            }
            for (int i3 = i2; i3 < this.mTail; i3++) {
                this.mElements[i3] = null;
            }
            int i4 = this.mTail - i2;
            int i5 = i - i4;
            this.mTail -= i4;
            if (i5 > 0) {
                this.mTail = this.mElements.length;
                int i6 = this.mTail - i5;
                for (int i7 = i6; i7 < this.mTail; i7++) {
                    this.mElements[i7] = null;
                }
                this.mTail = i6;
            }
        }
    }

    public final void removeFromStart(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int length = this.mElements.length;
            if (i < length - this.mHead) {
                length = this.mHead + i;
            }
            for (int i2 = this.mHead; i2 < length; i2++) {
                this.mElements[i2] = null;
            }
            int i3 = length - this.mHead;
            int i4 = i - i3;
            this.mHead = (i3 + this.mHead) & this.mCapacityBitmask;
            if (i4 > 0) {
                for (int i5 = 0; i5 < i4; i5++) {
                    this.mElements[i5] = null;
                }
                this.mHead = i4;
            }
        }
    }

    public final int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }
}
