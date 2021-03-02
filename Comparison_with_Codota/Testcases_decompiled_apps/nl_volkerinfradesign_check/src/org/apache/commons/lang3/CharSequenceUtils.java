package org.apache.commons.lang3;

public class CharSequenceUtils {
    public static CharSequence subSequence(CharSequence charSequence, int i) {
        if (charSequence == null) {
            return null;
        }
        return charSequence.subSequence(i, charSequence.length());
    }

    /* renamed from: a */
    static int m7342a(CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(i, i2);
        }
        int length = charSequence.length();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < length; i3++) {
            if (charSequence.charAt(i3) == i) {
                return i3;
            }
        }
        return -1;
    }

    /* renamed from: a */
    static int m7343a(CharSequence charSequence, CharSequence charSequence2, int i) {
        return charSequence.toString().indexOf(charSequence2.toString(), i);
    }

    /* renamed from: b */
    static int m7346b(CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(i, i2);
        }
        int length = charSequence.length();
        if (i2 < 0) {
            return -1;
        }
        if (i2 >= length) {
            i2 = length - 1;
        }
        for (int i3 = i2; i3 >= 0; i3--) {
            if (charSequence.charAt(i3) == i) {
                return i3;
            }
        }
        return -1;
    }

    /* renamed from: b */
    static int m7347b(CharSequence charSequence, CharSequence charSequence2, int i) {
        return charSequence.toString().lastIndexOf(charSequence2.toString(), i);
    }

    /* renamed from: a */
    static char[] m7345a(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).toCharArray();
        }
        int length = charSequence.length();
        char[] cArr = new char[charSequence.length()];
        for (int i = 0; i < length; i++) {
            cArr[i] = charSequence.charAt(i);
        }
        return cArr;
    }

    /* renamed from: a */
    static boolean m7344a(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return charSequence.toString().regionMatches(z, i, charSequence2.toString(), i2, i3);
        }
        return ((String) charSequence).regionMatches(z, i, (String) charSequence2, i2, i3);
    }
}
