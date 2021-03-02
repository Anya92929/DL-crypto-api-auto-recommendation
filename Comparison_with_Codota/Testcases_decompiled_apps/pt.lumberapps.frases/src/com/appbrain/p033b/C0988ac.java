package com.appbrain.p033b;

import java.io.OutputStream;
import java.util.ArrayList;

/* renamed from: com.appbrain.b.ac */
final class C0988ac extends C1002f {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final int[] f2598c;

    /* renamed from: d */
    private final int f2599d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C1002f f2600e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C1002f f2601f;

    /* renamed from: g */
    private final int f2602g;

    /* renamed from: h */
    private final int f2603h;

    /* renamed from: i */
    private int f2604i;

    static {
        int i = 1;
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        f2598c = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < f2598c.length) {
                f2598c[i5] = ((Integer) arrayList.get(i5)).intValue();
                i4 = i5 + 1;
            } else {
                return;
            }
        }
    }

    private C0988ac(C1002f fVar, C1002f fVar2) {
        this.f2604i = 0;
        this.f2600e = fVar;
        this.f2601f = fVar2;
        this.f2602g = fVar.mo3919a();
        this.f2599d = this.f2602g + fVar2.mo3919a();
        this.f2603h = Math.max(fVar.mo3928h(), fVar2.mo3928h()) + 1;
    }

    /* synthetic */ C0988ac(C1002f fVar, C1002f fVar2, byte b) {
        this(fVar, fVar2);
    }

    /* renamed from: a */
    static C1002f m4111a(C1002f fVar, C1002f fVar2) {
        C0988ac acVar = fVar instanceof C0988ac ? (C0988ac) fVar : null;
        if (fVar2.mo3919a() == 0) {
            return fVar;
        }
        if (fVar.mo3919a() == 0) {
            return fVar2;
        }
        int a = fVar.mo3919a() + fVar2.mo3919a();
        if (a < 128) {
            return m4113b(fVar, fVar2);
        }
        if (acVar != null && acVar.f2601f.mo3919a() + fVar2.mo3919a() < 128) {
            return new C0988ac(acVar.f2600e, m4113b(acVar.f2601f, fVar2));
        } else if (acVar == null || acVar.f2600e.mo3928h() <= acVar.f2601f.mo3928h() || acVar.f2603h <= fVar2.mo3928h()) {
            return a >= f2598c[Math.max(fVar.mo3928h(), fVar2.mo3928h()) + 1] ? new C0988ac(fVar, fVar2) : C0989ad.m4127a(new C0989ad((byte) 0), fVar, fVar2);
        } else {
            return new C0988ac(acVar.f2600e, new C0988ac(acVar.f2601f, fVar2));
        }
    }

    /* renamed from: b */
    private static C1018v m4113b(C1002f fVar, C1002f fVar2) {
        int a = fVar.mo3919a();
        int a2 = fVar2.mo3919a();
        byte[] bArr = new byte[(a + a2)];
        fVar.mo3968b(bArr, 0, 0, a);
        fVar2.mo3968b(bArr, 0, a, a2);
        return new C1018v(bArr);
    }

    /* renamed from: a */
    public final int mo3919a() {
        return this.f2599d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo3920a(int i, int i2, int i3) {
        if (i2 + i3 <= this.f2602g) {
            return this.f2600e.mo3920a(i, i2, i3);
        }
        if (i2 >= this.f2602g) {
            return this.f2601f.mo3920a(i, i2 - this.f2602g, i3);
        }
        int i4 = this.f2602g - i2;
        return this.f2601f.mo3920a(this.f2600e.mo3920a(i, i2, i4), 0, i3 - i4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3921a(OutputStream outputStream, int i, int i2) {
        if (i + i2 <= this.f2602g) {
            this.f2600e.mo3921a(outputStream, i, i2);
        } else if (i >= this.f2602g) {
            this.f2601f.mo3921a(outputStream, i - this.f2602g, i2);
        } else {
            int i3 = this.f2602g - i;
            this.f2600e.mo3921a(outputStream, i, i3);
            this.f2601f.mo3921a(outputStream, 0, i2 - i3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo3922a(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.f2602g) {
            this.f2600e.mo3922a(bArr, i, i2, i3);
        } else if (i >= this.f2602g) {
            this.f2601f.mo3922a(bArr, i - this.f2602g, i2, i3);
        } else {
            int i4 = this.f2602g - i;
            this.f2600e.mo3922a(bArr, i, i2, i4);
            this.f2601f.mo3922a(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final int mo3923b(int i, int i2, int i3) {
        if (i2 + i3 <= this.f2602g) {
            return this.f2600e.mo3923b(i, i2, i3);
        }
        if (i2 >= this.f2602g) {
            return this.f2601f.mo3923b(i, i2 - this.f2602g, i3);
        }
        int i4 = this.f2602g - i2;
        return this.f2601f.mo3923b(this.f2600e.mo3923b(i, i2, i4), 0, i3 - i4);
    }

    /* renamed from: b */
    public final String mo3924b(String str) {
        return new String(mo3969d(), str);
    }

    /* renamed from: c */
    public final C1003g iterator() {
        return new C0991af(this, (byte) 0);
    }

    public final boolean equals(Object obj) {
        int j;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1002f)) {
            return false;
        }
        C1002f fVar = (C1002f) obj;
        if (this.f2599d != fVar.mo3919a()) {
            return false;
        }
        if (this.f2599d == 0) {
            return true;
        }
        if (this.f2604i != 0 && (j = fVar.mo3932j()) != 0 && this.f2604i != j) {
            return false;
        }
        C0990ae aeVar = new C0990ae(this, (byte) 0);
        C0990ae aeVar2 = new C0990ae(fVar, (byte) 0);
        C1018v vVar = (C1018v) aeVar2.next();
        int i = 0;
        C1018v vVar2 = (C1018v) aeVar.next();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int a = vVar2.mo3919a() - i2;
            int a2 = vVar.mo3919a() - i;
            int min = Math.min(a, a2);
            if (!(i2 == 0 ? vVar2.mo4019a(vVar, i, min) : vVar.mo4019a(vVar2, i2, min))) {
                return false;
            }
            int i4 = i3 + min;
            if (i4 < this.f2599d) {
                if (min == a) {
                    vVar2 = (C1018v) aeVar.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
                if (min == a2) {
                    vVar = (C1018v) aeVar2.next();
                    i = 0;
                    i3 = i4;
                } else {
                    i += min;
                    i3 = i4;
                }
            } else if (i4 == this.f2599d) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* renamed from: f */
    public final boolean mo3927f() {
        return this.f2601f.mo3920a(this.f2600e.mo3920a(0, 0, this.f2602g), 0, this.f2601f.mo3919a()) == 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final int mo3928h() {
        return this.f2603h;
    }

    public final int hashCode() {
        int i = this.f2604i;
        if (i == 0) {
            i = mo3923b(this.f2599d, 0, this.f2599d);
            if (i == 0) {
                i = 1;
            }
            this.f2604i = i;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public final boolean mo3930i() {
        return this.f2599d >= f2598c[this.f2603h];
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final int mo3932j() {
        return this.f2604i;
    }
}
