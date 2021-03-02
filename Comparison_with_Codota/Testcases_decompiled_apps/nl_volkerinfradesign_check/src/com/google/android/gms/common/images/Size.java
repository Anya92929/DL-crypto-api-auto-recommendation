package com.google.android.gms.common.images;

public final class Size {

    /* renamed from: a */
    private final int f2885a;

    /* renamed from: b */
    private final int f2886b;

    public Size(int i, int i2) {
        this.f2885a = i;
        this.f2886b = i2;
    }

    /* renamed from: a */
    private static NumberFormatException m3882a(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            indexOf = str.indexOf(120);
        }
        if (indexOf < 0) {
            throw m3882a(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (NumberFormatException e) {
            throw m3882a(str);
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (!(this.f2885a == size.f2885a && this.f2886b == size.f2886b)) {
            z = false;
        }
        return z;
    }

    public int getHeight() {
        return this.f2886b;
    }

    public int getWidth() {
        return this.f2885a;
    }

    public int hashCode() {
        return this.f2886b ^ ((this.f2885a << 16) | (this.f2885a >>> 16));
    }

    public String toString() {
        return this.f2885a + "x" + this.f2886b;
    }
}
