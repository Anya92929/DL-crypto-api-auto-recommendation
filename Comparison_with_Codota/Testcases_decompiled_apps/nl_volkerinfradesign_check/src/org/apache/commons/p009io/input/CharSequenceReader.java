package org.apache.commons.p009io.input;

import java.io.Reader;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.input.CharSequenceReader */
public class CharSequenceReader extends Reader implements Serializable {

    /* renamed from: a */
    private final CharSequence f6899a;

    /* renamed from: b */
    private int f6900b;

    /* renamed from: c */
    private int f6901c;

    public CharSequenceReader(String str) {
        this.f6899a = str == null ? "" : str;
    }

    public void close() {
        this.f6900b = 0;
        this.f6901c = 0;
    }

    public void mark(int i) {
        this.f6901c = this.f6900b;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        if (this.f6900b >= this.f6899a.length()) {
            return -1;
        }
        CharSequence charSequence = this.f6899a;
        int i = this.f6900b;
        this.f6900b = i + 1;
        return charSequence.charAt(i);
    }

    public int read(char[] cArr, int i, int i2) {
        int i3 = 0;
        if (this.f6900b >= this.f6899a.length()) {
            return -1;
        }
        if (cArr == null) {
            throw new NullPointerException("Character array is missing");
        } else if (i2 < 0 || i < 0 || i + i2 > cArr.length) {
            throw new IndexOutOfBoundsException("Array Size=" + cArr.length + ", offset=" + i + ", length=" + i2);
        } else {
            int i4 = 0;
            while (i4 < i2) {
                int read = read();
                if (read == -1) {
                    return i3;
                }
                cArr[i + i4] = (char) read;
                i4++;
                i3++;
            }
            return i3;
        }
    }

    public void reset() {
        this.f6900b = this.f6901c;
    }

    public long skip(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Number of characters to skip is less than zero: " + j);
        } else if (this.f6900b >= this.f6899a.length()) {
            return -1;
        } else {
            int min = (int) Math.min((long) this.f6899a.length(), ((long) this.f6900b) + j);
            this.f6900b = min;
            return (long) (min - this.f6900b);
        }
    }

    public String toString() {
        return this.f6899a.toString();
    }
}
