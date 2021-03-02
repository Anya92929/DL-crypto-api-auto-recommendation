package com.appbrain.p033b;

import java.io.OutputStream;

/* renamed from: com.appbrain.b.v */
class C1018v extends C1002f {

    /* renamed from: c */
    protected final byte[] f2667c;

    /* renamed from: d */
    private int f2668d = 0;

    C1018v(byte[] bArr) {
        this.f2667c = bArr;
    }

    /* renamed from: a */
    public int mo3919a() {
        return this.f2667c.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo3920a(int i, int i2, int i3) {
        int b = mo3963b() + i2;
        return C0996ak.m4140a(i, this.f2667c, b, b + i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3921a(OutputStream outputStream, int i, int i2) {
        outputStream.write(this.f2667c, mo3963b() + i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3922a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f2667c, i, bArr, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo4019a(C1018v vVar, int i, int i2) {
        if (i2 > vVar.mo3919a()) {
            throw new IllegalArgumentException("Length too large: " + i2 + mo3919a());
        } else if (i + i2 > vVar.mo3919a()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + vVar.mo3919a());
        } else {
            byte[] bArr = this.f2667c;
            byte[] bArr2 = vVar.f2667c;
            int b = mo3963b() + i2;
            int b2 = mo3963b();
            int b3 = vVar.mo3963b() + i;
            while (b2 < b) {
                if (bArr[b2] != bArr2[b3]) {
                    return false;
                }
                b2++;
                b3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo3963b() {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final int mo3923b(int i, int i2, int i3) {
        byte[] bArr = this.f2667c;
        int b = mo3963b() + i2;
        for (int i4 = b; i4 < b + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* renamed from: b */
    public final String mo3924b(String str) {
        return new String(this.f2667c, mo3963b(), mo3919a(), str);
    }

    /* renamed from: c */
    public C1003g iterator() {
        return new C1019w(this, (byte) 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1002f)) {
            return false;
        }
        if (mo3919a() != ((C1002f) obj).mo3919a()) {
            return false;
        }
        if (mo3919a() == 0) {
            return true;
        }
        if (obj instanceof C1018v) {
            return mo4019a((C1018v) obj, 0, mo3919a());
        }
        if (obj instanceof C0988ac) {
            return obj.equals(this);
        }
        throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + obj.getClass());
    }

    /* renamed from: f */
    public final boolean mo3927f() {
        int b = mo3963b();
        return C0996ak.m4141a(this.f2667c, b, mo3919a() + b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final int mo3928h() {
        return 0;
    }

    public int hashCode() {
        int i = this.f2668d;
        if (i == 0) {
            int a = mo3919a();
            i = mo3923b(a, 0, a);
            if (i == 0) {
                i = 1;
            }
            this.f2668d = i;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public final boolean mo3930i() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final int mo3932j() {
        return this.f2668d;
    }
}
