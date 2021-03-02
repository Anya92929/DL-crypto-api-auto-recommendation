package com.google.android.gms.internal;

import java.lang.Character;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.aq */
public class C0918aq {
    /* renamed from: a */
    private static boolean m3892a(Character.UnicodeBlock unicodeBlock) {
        return unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || unicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || unicodeBlock == Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT || unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY || unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS || unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || unicodeBlock == Character.UnicodeBlock.BOPOMOFO || unicodeBlock == Character.UnicodeBlock.HIRAGANA || unicodeBlock == Character.UnicodeBlock.KATAKANA || unicodeBlock == Character.UnicodeBlock.HANGUL_SYLLABLES || unicodeBlock == Character.UnicodeBlock.HANGUL_JAMO;
    }

    /* renamed from: d */
    static boolean m3893d(int i) {
        return Character.isLetter(i) && m3892a(Character.UnicodeBlock.of(i));
    }

    /* renamed from: o */
    public static int m3894o(String str) {
        return C1393kb.m5236a(str.getBytes(), 0, str.length(), 0);
    }

    /* renamed from: p */
    public static String[] m3895p(String str) {
        int i;
        boolean z;
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        char[] charArray = str.toCharArray();
        int length = str.length();
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            int codePointAt = Character.codePointAt(charArray, i3);
            int charCount = Character.charCount(codePointAt);
            if (m3893d(codePointAt)) {
                if (z2) {
                    arrayList.add(new String(charArray, i2, i3 - i2));
                }
                arrayList.add(new String(charArray, i3, charCount));
                i = i2;
                z = false;
            } else if (Character.isLetterOrDigit(codePointAt)) {
                if (!z2) {
                    i2 = i3;
                }
                i = i2;
                z = true;
            } else if (z2) {
                arrayList.add(new String(charArray, i2, i3 - i2));
                i = i2;
                z = false;
            } else {
                boolean z3 = z2;
                i = i2;
                z = z3;
            }
            i3 += charCount;
            boolean z4 = z;
            i2 = i;
            z2 = z4;
        }
        if (z2) {
            arrayList.add(new String(charArray, i2, i3 - i2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
