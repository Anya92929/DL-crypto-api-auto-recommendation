package org.p004a.p005a.p033i;

/* renamed from: org.a.a.i.t */
public final class C0541t {

    /* renamed from: a */
    private final int f604a;

    /* renamed from: b */
    private final int f605b;

    /* renamed from: c */
    private int f606c;

    public C0541t(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        } else if (i > i2) {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        } else {
            this.f604a = i;
            this.f605b = i2;
            this.f606c = i;
        }
    }

    /* renamed from: a */
    public final int mo5383a() {
        return this.f605b;
    }

    /* renamed from: a */
    public final void mo5384a(int i) {
        if (i < this.f604a) {
            throw new IndexOutOfBoundsException("pos: " + i + " < lowerBound: " + this.f604a);
        } else if (i > this.f605b) {
            throw new IndexOutOfBoundsException("pos: " + i + " > upperBound: " + this.f605b);
        } else {
            this.f606c = i;
        }
    }

    /* renamed from: b */
    public final int mo5385b() {
        return this.f606c;
    }

    /* renamed from: c */
    public final boolean mo5386c() {
        return this.f606c >= this.f605b;
    }

    public final String toString() {
        return '[' + Integer.toString(this.f604a) + '>' + Integer.toString(this.f606c) + '>' + Integer.toString(this.f605b) + ']';
    }
}
