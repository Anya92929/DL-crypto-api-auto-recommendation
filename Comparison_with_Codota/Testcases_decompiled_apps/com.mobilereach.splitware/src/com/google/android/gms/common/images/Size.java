package com.google.android.gms.common.images;

public final class Size {
    private final int zzoG;
    private final int zzoH;

    public Size(int width, int height) {
        this.zzoG = width;
        this.zzoH = height;
    }

    public static Size parseSize(String string) throws NumberFormatException {
        if (string == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int indexOf = string.indexOf(42);
        if (indexOf < 0) {
            indexOf = string.indexOf(120);
        }
        if (indexOf < 0) {
            throw zzcC(string);
        }
        try {
            return new Size(Integer.parseInt(string.substring(0, indexOf)), Integer.parseInt(string.substring(indexOf + 1)));
        } catch (NumberFormatException e) {
            throw zzcC(string);
        }
    }

    private static NumberFormatException zzcC(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
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
        if (!(this.zzoG == size.zzoG && this.zzoH == size.zzoH)) {
            z = false;
        }
        return z;
    }

    public int getHeight() {
        return this.zzoH;
    }

    public int getWidth() {
        return this.zzoG;
    }

    public int hashCode() {
        return this.zzoH ^ ((this.zzoG << 16) | (this.zzoG >>> 16));
    }

    public String toString() {
        return this.zzoG + "x" + this.zzoH;
    }
}
