package com.appbrain.p033b;

/* renamed from: com.appbrain.b.d */
final class C1000d extends C1018v {

    /* renamed from: d */
    private final int f2624d;

    /* renamed from: e */
    private final int f2625e;

    C1000d(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i < 0) {
            throw new IllegalArgumentException("Offset too small: " + i);
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Length too small: " + i);
        } else if (((long) i) + ((long) i2) > ((long) bArr.length)) {
            throw new IllegalArgumentException("Offset+Length too large: " + i + "+" + i2);
        } else {
            this.f2624d = i;
            this.f2625e = i2;
        }
    }

    /* renamed from: a */
    public final int mo3919a() {
        return this.f2625e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo3922a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f2667c, this.f2624d + i, bArr, i2, i3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final int mo3963b() {
        return this.f2624d;
    }

    /* renamed from: c */
    public final C1003g iterator() {
        return new C1001e(this, (byte) 0);
    }
}
