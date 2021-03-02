package okhttp3.internal.framed;

import java.util.Arrays;

public final class Settings {

    /* renamed from: a */
    private int f6141a;

    /* renamed from: b */
    private int f6142b;

    /* renamed from: c */
    private int f6143c;

    /* renamed from: d */
    private final int[] f6144d = new int[10];

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11069a() {
        this.f6143c = 0;
        this.f6142b = 0;
        this.f6141a = 0;
        Arrays.fill(this.f6144d, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Settings mo11068a(int i, int i2, int i3) {
        if (i < this.f6144d.length) {
            int i4 = 1 << i;
            this.f6141a |= i4;
            if ((i2 & 1) != 0) {
                this.f6142b |= i4;
            } else {
                this.f6142b &= i4 ^ -1;
            }
            if ((i2 & 2) != 0) {
                this.f6143c = i4 | this.f6143c;
            } else {
                this.f6143c = (i4 ^ -1) & this.f6143c;
            }
            this.f6144d[i] = i3;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo11071a(int i) {
        if (((1 << i) & this.f6141a) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo11073b(int i) {
        return this.f6144d[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo11075c(int i) {
        int i2 = 0;
        if (mo11080h(i)) {
            i2 = 2;
        }
        if (mo11079g(i)) {
            return i2 | 1;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo11072b() {
        return Integer.bitCount(this.f6141a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo11074c() {
        if ((2 & this.f6141a) != 0) {
            return this.f6144d[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo11076d(int i) {
        return (16 & this.f6141a) != 0 ? this.f6144d[4] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo11077e(int i) {
        return (32 & this.f6141a) != 0 ? this.f6144d[5] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo11078f(int i) {
        return (128 & this.f6141a) != 0 ? this.f6144d[7] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo11079g(int i) {
        if (((1 << i) & this.f6142b) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo11080h(int i) {
        if (((1 << i) & this.f6143c) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11070a(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.mo11071a(i)) {
                mo11068a(i, settings.mo11075c(i), settings.mo11073b(i));
            }
        }
    }
}
