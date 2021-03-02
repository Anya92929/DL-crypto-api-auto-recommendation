package com.google.android.gms.common.images;

public final class Size {

    /* renamed from: a */
    private final int f4417a;

    /* renamed from: b */
    private final int f4418b;

    public Size(int i, int i2) {
        this.f4417a = i;
        this.f4418b = i2;
    }

    /* renamed from: a */
    private static NumberFormatException m6029a(String str) {
        throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 16).append("Invalid Size: \"").append(str).append("\"").toString());
    }

    public static Size parseSize(String str) {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            indexOf = str.indexOf(120);
        }
        if (indexOf < 0) {
            throw m6029a(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (NumberFormatException e) {
            throw m6029a(str);
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
        if (!(this.f4417a == size.f4417a && this.f4418b == size.f4418b)) {
            z = false;
        }
        return z;
    }

    public int getHeight() {
        return this.f4418b;
    }

    public int getWidth() {
        return this.f4417a;
    }

    public int hashCode() {
        return this.f4418b ^ ((this.f4417a << 16) | (this.f4417a >>> 16));
    }

    public String toString() {
        int i = this.f4417a;
        return new StringBuilder(23).append(i).append("x").append(this.f4418b).toString();
    }
}
