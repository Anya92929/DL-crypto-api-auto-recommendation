package org.apache.commons.collections4.trie.analyzer;

import org.apache.commons.collections4.trie.KeyAnalyzer;

public class StringKeyAnalyzer extends KeyAnalyzer<String> {
    public static final StringKeyAnalyzer INSTANCE = new StringKeyAnalyzer();
    public static final int LENGTH = 16;
    private static final long serialVersionUID = -7032449491269434877L;

    /* renamed from: e */
    private static int m7253e(int i) {
        return 32768 >>> i;
    }

    public int bitsPerElement() {
        return 16;
    }

    public int lengthInBits(String str) {
        if (str != null) {
            return str.length() * 16;
        }
        return 0;
    }

    public int bitIndex(String str, int i, int i2, String str2, int i3, int i4) {
        char charAt;
        char c;
        if (i % 16 == 0 && i3 % 16 == 0 && i2 % 16 == 0 && i4 % 16 == 0) {
            int i5 = i / 16;
            int i6 = i3 / 16;
            int i7 = i5 + (i2 / 16);
            int i8 = i6 + (i4 / 16);
            int max = Math.max(i7, i8);
            boolean z = true;
            for (int i9 = 0; i9 < max; i9++) {
                int i10 = i5 + i9;
                int i11 = i6 + i9;
                if (i10 >= i7) {
                    charAt = 0;
                } else {
                    charAt = str.charAt(i10);
                }
                if (str2 == null || i11 >= i8) {
                    c = 0;
                } else {
                    c = str2.charAt(i11);
                }
                if (charAt != c) {
                    return (Integer.numberOfLeadingZeros(charAt ^ c) + (i9 * 16)) - 16;
                }
                if (charAt != 0) {
                    z = false;
                }
            }
            if (z) {
                return -1;
            }
            return -2;
        }
        throw new IllegalArgumentException("The offsets and lengths must be at Character boundaries");
    }

    public boolean isBitSet(String str, int i, int i2) {
        if (str == null || i >= i2 || (str.charAt(i / 16) & m7253e(i % 16)) == 0) {
            return false;
        }
        return true;
    }

    public boolean isPrefix(String str, int i, int i2, String str2) {
        if (i % 16 == 0 && i2 % 16 == 0) {
            return str2.startsWith(str.substring(i / 16, i2 / 16));
        }
        throw new IllegalArgumentException("Cannot determine prefix outside of Character boundaries");
    }
}
