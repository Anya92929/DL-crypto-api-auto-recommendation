package org.apache.commons.p009io;

import java.io.Serializable;
import org.apache.commons.lang3.CharEncoding;

/* renamed from: org.apache.commons.io.ByteOrderMark */
public class ByteOrderMark implements Serializable {
    public static final ByteOrderMark UTF_16BE = new ByteOrderMark(CharEncoding.UTF_16BE, 254, 255);
    public static final ByteOrderMark UTF_16LE = new ByteOrderMark(CharEncoding.UTF_16LE, 255, 254);
    public static final ByteOrderMark UTF_32BE = new ByteOrderMark("UTF-32BE", 0, 0, 254, 255);
    public static final ByteOrderMark UTF_32LE = new ByteOrderMark("UTF-32LE", 255, 254, 0, 0);
    public static final ByteOrderMark UTF_8 = new ByteOrderMark(CharEncoding.UTF_8, 239, 187, 191);
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final String f6819a;

    /* renamed from: b */
    private final int[] f6820b;

    public ByteOrderMark(String str, int... iArr) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("No charsetName specified");
        } else if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("No bytes specified");
        } else {
            this.f6819a = str;
            this.f6820b = new int[iArr.length];
            System.arraycopy(iArr, 0, this.f6820b, 0, iArr.length);
        }
    }

    public String getCharsetName() {
        return this.f6819a;
    }

    public int length() {
        return this.f6820b.length;
    }

    public int get(int i) {
        return this.f6820b[i];
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[this.f6820b.length];
        for (int i = 0; i < this.f6820b.length; i++) {
            bArr[i] = (byte) this.f6820b[i];
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ByteOrderMark)) {
            return false;
        }
        ByteOrderMark byteOrderMark = (ByteOrderMark) obj;
        if (this.f6820b.length != byteOrderMark.length()) {
            return false;
        }
        for (int i = 0; i < this.f6820b.length; i++) {
            if (this.f6820b[i] != byteOrderMark.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int hashCode = getClass().hashCode();
        for (int i : this.f6820b) {
            hashCode += i;
        }
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append(this.f6819a);
        sb.append(": ");
        for (int i = 0; i < this.f6820b.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append("0x");
            sb.append(Integer.toHexString(this.f6820b[i] & 255).toUpperCase());
        }
        sb.append(']');
        return sb.toString();
    }
}
