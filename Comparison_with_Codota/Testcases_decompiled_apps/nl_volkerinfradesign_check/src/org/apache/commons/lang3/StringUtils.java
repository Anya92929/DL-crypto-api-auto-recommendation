package org.apache.commons.lang3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;

public class StringUtils {
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;

    /* renamed from: a */
    private static final Pattern f7045a = Pattern.compile("\\s+");

    /* renamed from: b */
    private static boolean f7046b;

    /* renamed from: c */
    private static Method f7047c;

    /* renamed from: d */
    private static final Pattern f7048d = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    /* renamed from: e */
    private static boolean f7049e;

    /* renamed from: f */
    private static Method f7050f;

    /* renamed from: g */
    private static Object f7051g;

    /* renamed from: h */
    private static final Pattern f7052h = f7048d;

    static {
        f7046b = false;
        f7047c = null;
        f7049e = false;
        f7050f = null;
        f7051g = null;
        try {
            Class<?> loadClass = Thread.currentThread().getContextClassLoader().loadClass("java.text.Normalizer$Form");
            f7051g = loadClass.getField("NFD").get((Object) null);
            f7050f = Thread.currentThread().getContextClassLoader().loadClass("java.text.Normalizer").getMethod("normalize", new Class[]{CharSequence.class, loadClass});
            f7049e = true;
        } catch (ClassNotFoundException e) {
            f7049e = false;
        } catch (NoSuchFieldException e2) {
            f7049e = false;
        } catch (IllegalAccessException e3) {
            f7049e = false;
        } catch (NoSuchMethodException e4) {
            f7049e = false;
        }
        try {
            f7047c = Thread.currentThread().getContextClassLoader().loadClass("sun.text.Normalizer").getMethod("decompose", new Class[]{String.class, Boolean.TYPE, Integer.TYPE});
            f7046b = true;
        } catch (ClassNotFoundException e5) {
            f7046b = false;
        } catch (NoSuchMethodException e6) {
            f7046b = false;
        }
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length;
        if (charSequence == null || (length = charSequence.length()) == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String trimToNull(String str) {
        String trim = trim(str);
        if (isEmpty(trim)) {
            return null;
        }
        return trim;
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static String strip(String str) {
        return strip(str, (String) null);
    }

    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        String strip = strip(str, (String) null);
        if (strip.length() != 0) {
            return strip;
        }
        return null;
    }

    public static String stripToEmpty(String str) {
        return str == null ? "" : strip(str, (String) null);
    }

    public static String strip(String str, String str2) {
        return isEmpty(str) ? str : stripEnd(stripStart(str, str2), str2);
    }

    public static String stripStart(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        int i = 0;
        if (str2 == null) {
            while (i != length && Character.isWhitespace(str.charAt(i))) {
                i++;
            }
        } else if (str2.length() == 0) {
            return str;
        } else {
            while (i != length && str2.indexOf(str.charAt(i)) != -1) {
                i++;
            }
        }
        return str.substring(i);
    }

    public static String stripEnd(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        if (str2 == null) {
            while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        } else if (str2.length() == 0) {
            return str;
        } else {
            while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                length--;
            }
        }
        return str.substring(0, length);
    }

    public static String[] stripAll(String... strArr) {
        return stripAll(strArr, (String) null);
    }

    public static String[] stripAll(String[] strArr, String str) {
        int length;
        if (strArr == null || (length = strArr.length) == 0) {
            return strArr;
        }
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            strArr2[i] = strip(strArr[i], str);
        }
        return strArr2;
    }

    public static String stripAccents(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (f7049e) {
                return m7360a(str);
            }
            if (f7046b) {
                return m7366b(str);
            }
            throw new UnsupportedOperationException("The stripAccents(CharSequence) method requires at least Java 1.6 or a Sun JVM");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("IllegalArgumentException occurred", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("IllegalAccessException occurred", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("InvocationTargetException occurred", e3);
        } catch (SecurityException e4) {
            throw new RuntimeException("SecurityException occurred", e4);
        }
    }

    /* renamed from: a */
    private static String m7360a(CharSequence charSequence) throws IllegalAccessException, InvocationTargetException {
        if (!f7049e || f7051g == null) {
            throw new IllegalStateException("java.text.Normalizer is not available");
        }
        Method method = f7050f;
        Object[] objArr = {charSequence, f7051g};
        return f7052h.matcher((String) method.invoke((Object) null, objArr)).replaceAll("");
    }

    /* renamed from: b */
    private static String m7366b(CharSequence charSequence) throws IllegalAccessException, InvocationTargetException {
        if (!f7046b) {
            throw new IllegalStateException("sun.text.Normalizer is not available");
        }
        Method method = f7047c;
        Object[] objArr = {charSequence, Boolean.FALSE, 0};
        return f7048d.matcher((String) method.invoke((Object) null, objArr)).replaceAll("");
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null) {
            return charSequence2 == null;
        }
        return charSequence.equals(charSequence2);
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            return CharSequenceUtils.m7344a(charSequence, true, 0, charSequence2, 0, Math.max(charSequence.length(), charSequence2.length()));
        } else if (charSequence == charSequence2) {
            return true;
        } else {
            return false;
        }
    }

    public static int indexOf(CharSequence charSequence, int i) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.m7342a(charSequence, i, 0);
    }

    public static int indexOf(CharSequence charSequence, int i, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.m7342a(charSequence, i, i2);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.m7343a(charSequence, charSequence2, 0);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.m7343a(charSequence, charSequence2, i);
    }

    public static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return m7359a(charSequence, charSequence2, i, false);
    }

    /* renamed from: a */
    private static int m7359a(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        int a;
        int i2;
        int i3 = -1;
        if (charSequence == null || charSequence2 == null || i <= 0) {
            return -1;
        }
        if (charSequence2.length() != 0) {
            if (z) {
                i3 = charSequence.length();
            }
            int i4 = 0;
            while (true) {
                if (z) {
                    a = CharSequenceUtils.m7347b(charSequence, charSequence2, i3 - 1);
                } else {
                    a = CharSequenceUtils.m7343a(charSequence, charSequence2, i3 + 1);
                }
                if (a < 0 || (i2 = i4 + 1) >= i) {
                    return a;
                }
                i4 = i2;
                i3 = a;
            }
        } else if (z) {
            return charSequence.length();
        } else {
            return 0;
        }
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return indexOfIgnoreCase(charSequence, charSequence2, 0);
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        int length = (charSequence.length() - charSequence2.length()) + 1;
        if (i > length) {
            return -1;
        }
        if (charSequence2.length() == 0) {
            return i;
        }
        for (int i2 = i; i2 < length; i2++) {
            if (CharSequenceUtils.m7344a(charSequence, true, i2, charSequence2, 0, charSequence2.length())) {
                return i2;
            }
        }
        return -1;
    }

    public static int lastIndexOf(CharSequence charSequence, int i) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.m7346b(charSequence, i, charSequence.length());
    }

    public static int lastIndexOf(CharSequence charSequence, int i, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.m7346b(charSequence, i, i2);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.m7347b(charSequence, charSequence2, charSequence.length());
    }

    public static int lastOrdinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return m7359a(charSequence, charSequence2, i, true);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.m7347b(charSequence, charSequence2, i);
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return lastIndexOfIgnoreCase(charSequence, charSequence2, charSequence.length());
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i) {
        int i2;
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        if (i > charSequence.length() - charSequence2.length()) {
            i2 = charSequence.length() - charSequence2.length();
        } else {
            i2 = i;
        }
        if (i2 < 0) {
            return -1;
        }
        if (charSequence2.length() == 0) {
            return i2;
        }
        while (i2 >= 0) {
            if (CharSequenceUtils.m7344a(charSequence, true, i2, charSequence2, 0, charSequence2.length())) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static boolean contains(CharSequence charSequence, int i) {
        if (!isEmpty(charSequence) && CharSequenceUtils.m7342a(charSequence, i, 0) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null || CharSequenceUtils.m7343a(charSequence, charSequence2, 0) < 0) {
            return false;
        }
        return true;
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        int length = charSequence2.length();
        int length2 = charSequence.length() - length;
        for (int i = 0; i <= length2; i++) {
            if (CharSequenceUtils.m7344a(charSequence, true, i, charSequence2, 0, length)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static int indexOfAny(CharSequence charSequence, char... cArr) {
        if (isEmpty(charSequence) || ArrayUtils.isEmpty(cArr)) {
            return -1;
        }
        int length = charSequence.length();
        int i = length - 1;
        int length2 = cArr.length;
        int i2 = length2 - 1;
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            for (int i4 = 0; i4 < length2; i4++) {
                if (cArr[i4] == charAt && (i3 >= i || i4 >= i2 || !Character.isHighSurrogate(charAt) || cArr[i4 + 1] == charSequence.charAt(i3 + 1))) {
                    return i3;
                }
            }
            i3++;
        }
        return -1;
    }

    public static int indexOfAny(CharSequence charSequence, String str) {
        if (isEmpty(charSequence) || isEmpty(str)) {
            return -1;
        }
        return indexOfAny(charSequence, str.toCharArray());
    }

    public static boolean containsAny(CharSequence charSequence, char... cArr) {
        if (isEmpty(charSequence) || ArrayUtils.isEmpty(cArr)) {
            return false;
        }
        int length = charSequence.length();
        int length2 = cArr.length;
        int i = length - 1;
        int i2 = length2 - 1;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = charSequence.charAt(i3);
            for (int i4 = 0; i4 < length2; i4++) {
                if (cArr[i4] == charAt) {
                    if (!Character.isHighSurrogate(charAt) || i4 == i2) {
                        return true;
                    }
                    if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return containsAny(charSequence, CharSequenceUtils.m7345a(charSequence2));
    }

    public static int indexOfAnyBut(CharSequence charSequence, char... cArr) {
        if (isEmpty(charSequence) || ArrayUtils.isEmpty(cArr)) {
            return -1;
        }
        int length = charSequence.length();
        int i = length - 1;
        int length2 = cArr.length;
        int i2 = length2 - 1;
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            int i4 = 0;
            while (i4 < length2) {
                if (cArr[i4] != charAt || (i3 < i && i4 < i2 && Character.isHighSurrogate(charAt) && cArr[i4 + 1] != charSequence.charAt(i3 + 1))) {
                    i4++;
                } else {
                    i3++;
                }
            }
            return i3;
        }
        return -1;
    }

    public static int indexOfAnyBut(CharSequence charSequence, CharSequence charSequence2) {
        boolean z;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            return -1;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (CharSequenceUtils.m7342a(charSequence2, (int) charAt, 0) >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (i + 1 < length && Character.isHighSurrogate(charAt)) {
                char charAt2 = charSequence.charAt(i + 1);
                if (z && CharSequenceUtils.m7342a(charSequence2, (int) charAt2, 0) < 0) {
                    return i;
                }
            } else if (!z) {
                return i;
            }
        }
        return -1;
    }

    public static boolean containsOnly(CharSequence charSequence, char... cArr) {
        if (cArr == null || charSequence == null) {
            return false;
        }
        if (charSequence.length() == 0) {
            return true;
        }
        if (cArr.length == 0) {
            return false;
        }
        if (indexOfAnyBut(charSequence, cArr) != -1) {
            return false;
        }
        return true;
    }

    public static boolean containsOnly(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return false;
        }
        return containsOnly(charSequence, str.toCharArray());
    }

    public static boolean containsNone(CharSequence charSequence, char... cArr) {
        if (charSequence == null || cArr == null) {
            return true;
        }
        int length = charSequence.length();
        int i = length - 1;
        int length2 = cArr.length;
        int i2 = length2 - 1;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = charSequence.charAt(i3);
            for (int i4 = 0; i4 < length2; i4++) {
                if (cArr[i4] == charAt) {
                    if (!Character.isHighSurrogate(charAt) || i4 == i2) {
                        return false;
                    }
                    if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean containsNone(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return true;
        }
        return containsNone(charSequence, str.toCharArray());
    }

    public static int indexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int a;
        if (charSequence == null || charSequenceArr == null) {
            return -1;
        }
        int i = Integer.MAX_VALUE;
        for (CharSequence charSequence2 : charSequenceArr) {
            if (!(charSequence2 == null || (a = CharSequenceUtils.m7343a(charSequence, charSequence2, 0)) == -1 || a >= i)) {
                i = a;
            }
        }
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    public static int lastIndexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int b;
        int i = -1;
        if (!(charSequence == null || charSequenceArr == null)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (charSequence2 != null && (b = CharSequenceUtils.m7347b(charSequence, charSequence2, charSequence.length())) > i) {
                    i = b;
                }
            }
        }
        return i;
    }

    public static String substring(String str, int i) {
        int i2;
        if (str == null) {
            return null;
        }
        if (i < 0) {
            i2 = str.length() + i;
        } else {
            i2 = i;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > str.length()) {
            return "";
        }
        return str.substring(i2);
    }

    public static String substring(String str, int i, int i2) {
        int i3;
        int i4 = 0;
        if (str == null) {
            return null;
        }
        if (i2 < 0) {
            i3 = str.length() + i2;
        } else {
            i3 = i2;
        }
        if (i < 0) {
            i += str.length();
        }
        if (i3 > str.length()) {
            i3 = str.length();
        }
        if (i > i3) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (i3 >= 0) {
            i4 = i3;
        }
        return str.substring(i, i4);
    }

    public static String left(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        return str.length() > i ? str.substring(0, i) : str;
    }

    public static String right(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        return str.length() > i ? str.substring(str.length() - i) : str;
    }

    public static String mid(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0 || i > str.length()) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (str.length() <= i + i2) {
            return str.substring(i);
        }
        return str.substring(i, i + i2);
    }

    public static String substringBefore(String str, String str2) {
        if (isEmpty(str) || str2 == null) {
            return str;
        }
        if (str2.length() == 0) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        return indexOf != -1 ? str.substring(0, indexOf) : str;
    }

    public static String substringAfter(String str, String str2) {
        int indexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (str2 == null || (indexOf = str.indexOf(str2)) == -1) {
            return "";
        }
        return str.substring(indexOf + str2.length());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r0 = r2.lastIndexOf(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String substringBeforeLast(java.lang.String r2, java.lang.String r3) {
        /*
            boolean r0 = isEmpty(r2)
            if (r0 != 0) goto L_0x000c
            boolean r0 = isEmpty(r3)
            if (r0 == 0) goto L_0x000d
        L_0x000c:
            return r2
        L_0x000d:
            int r0 = r2.lastIndexOf(r3)
            r1 = -1
            if (r0 == r1) goto L_0x000c
            r1 = 0
            java.lang.String r2 = r2.substring(r1, r0)
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.substringBeforeLast(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String substringAfterLast(String str, String str2) {
        int lastIndexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1 || lastIndexOf == str.length() - str2.length()) {
            return "";
        }
        return str.substring(lastIndexOf + str2.length());
    }

    public static String substringBetween(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    public static String substringBetween(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (str == null || str2 == null || str3 == null || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) == -1) {
            return null;
        }
        return str.substring(str2.length() + indexOf, indexOf2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        r1 = r1 + r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] substringsBetween(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x000f
            boolean r1 = isEmpty(r8)
            if (r1 != 0) goto L_0x000f
            boolean r1 = isEmpty(r9)
            if (r1 == 0) goto L_0x0010
        L_0x000f:
            return r0
        L_0x0010:
            int r2 = r7.length()
            if (r2 != 0) goto L_0x0019
            java.lang.String[] r0 = org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY
            goto L_0x000f
        L_0x0019:
            int r3 = r9.length()
            int r4 = r8.length()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r1 = 0
        L_0x0027:
            int r6 = r2 - r3
            if (r1 >= r6) goto L_0x0031
            int r1 = r7.indexOf(r8, r1)
            if (r1 >= 0) goto L_0x0044
        L_0x0031:
            boolean r1 = r5.isEmpty()
            if (r1 != 0) goto L_0x000f
            int r0 = r5.size()
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.Object[] r0 = r5.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            goto L_0x000f
        L_0x0044:
            int r1 = r1 + r4
            int r6 = r7.indexOf(r9, r1)
            if (r6 < 0) goto L_0x0031
            java.lang.String r1 = r7.substring(r1, r6)
            r5.add(r1)
            int r1 = r6 + r3
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.substringsBetween(java.lang.String, java.lang.String, java.lang.String):java.lang.String[]");
    }

    public static String[] split(String str) {
        return split(str, (String) null, -1);
    }

    public static String[] split(String str, char c) {
        return m7363a(str, c, false);
    }

    public static String[] split(String str, String str2) {
        return m7368b(str, str2, -1, false);
    }

    public static String[] split(String str, String str2, int i) {
        return m7368b(str, str2, i, false);
    }

    public static String[] splitByWholeSeparator(String str, String str2) {
        return m7364a(str, str2, -1, false);
    }

    public static String[] splitByWholeSeparator(String str, String str2, int i) {
        return m7364a(str, str2, i, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2) {
        return m7364a(str, str2, -1, true);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2, int i) {
        return m7364a(str, str2, i, true);
    }

    /* renamed from: a */
    private static String[] m7364a(String str, String str2, int i, boolean z) {
        int i2 = 0;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        if (str2 == null || "".equals(str2)) {
            return m7368b(str, (String) null, i, z);
        }
        int length2 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            i3 = str.indexOf(str2, i4);
            if (i3 <= -1) {
                arrayList.add(str.substring(i4));
                i3 = length;
            } else if (i3 > i4) {
                int i5 = i2 + 1;
                if (i5 == i) {
                    arrayList.add(str.substring(i4));
                    i3 = length;
                    i2 = i5;
                } else {
                    arrayList.add(str.substring(i4, i3));
                    i4 = i3 + length2;
                    i2 = i5;
                }
            } else {
                if (z) {
                    i2++;
                    if (i2 == i) {
                        arrayList.add(str.substring(i4));
                        i3 = length;
                    } else {
                        arrayList.add("");
                    }
                }
                i4 = i3 + length2;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitPreserveAllTokens(String str) {
        return m7368b(str, (String) null, -1, true);
    }

    public static String[] splitPreserveAllTokens(String str, char c) {
        return m7363a(str, c, true);
    }

    /* renamed from: a */
    private static String[] m7363a(String str, char c, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            if (str.charAt(i2) == c) {
                if (z3 || z) {
                    arrayList.add(str.substring(i, i2));
                    z2 = true;
                    z3 = false;
                }
                i = i2 + 1;
                i2 = i;
            } else {
                z3 = true;
                i2++;
                z2 = false;
            }
        }
        if (z3 || (z && z2)) {
            arrayList.add(str.substring(i, i2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitPreserveAllTokens(String str, String str2) {
        return m7368b(str, str2, -1, true);
    }

    public static String[] splitPreserveAllTokens(String str, String str2, int i) {
        return m7368b(str, str2, i, true);
    }

    /* renamed from: b */
    private static String[] m7368b(String str, String str2, int i, boolean z) {
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z4;
        boolean z5;
        int i7;
        int i8;
        boolean z6;
        boolean z7;
        int i9;
        int i10;
        boolean z8;
        boolean z9;
        int i11;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            z3 = false;
            z2 = false;
            i2 = 0;
            i3 = 0;
            int i12 = 1;
            while (i3 < length) {
                if (Character.isWhitespace(str.charAt(i3))) {
                    if (z2 || z) {
                        int i13 = i12 + 1;
                        if (i12 == i) {
                            z9 = false;
                            i11 = length;
                        } else {
                            i11 = i3;
                            z9 = true;
                        }
                        arrayList.add(str.substring(i2, i11));
                        i12 = i13;
                        i10 = i11;
                        z8 = false;
                    } else {
                        boolean z10 = z3;
                        z8 = z2;
                        i10 = i3;
                        z9 = z10;
                    }
                    i2 = i10 + 1;
                    z2 = z8;
                    z3 = z9;
                    i3 = i2;
                } else {
                    i3++;
                    z3 = false;
                    z2 = true;
                }
            }
            i4 = i3;
            i5 = i2;
        } else if (str2.length() == 1) {
            char charAt = str2.charAt(0);
            boolean z11 = false;
            boolean z12 = false;
            int i14 = 0;
            int i15 = 0;
            int i16 = 1;
            while (i15 < length) {
                if (str.charAt(i15) == charAt) {
                    if (z2 || z) {
                        int i17 = i16 + 1;
                        if (i16 == i) {
                            z7 = false;
                            i9 = length;
                        } else {
                            i9 = i15;
                            z7 = true;
                        }
                        arrayList.add(str.substring(i14, i9));
                        i16 = i17;
                        i8 = i9;
                        z6 = false;
                    } else {
                        boolean z13 = z3;
                        z6 = z2;
                        i8 = i15;
                        z7 = z13;
                    }
                    i14 = i8 + 1;
                    z12 = z6;
                    z11 = z7;
                    i15 = i14;
                } else {
                    i15++;
                    z11 = false;
                    z12 = true;
                }
            }
            i4 = i15;
            i5 = i14;
        } else {
            boolean z14 = false;
            boolean z15 = false;
            i2 = 0;
            int i18 = 0;
            int i19 = 1;
            while (i3 < length) {
                if (str2.indexOf(str.charAt(i3)) >= 0) {
                    if (z2 || z) {
                        int i20 = i19 + 1;
                        if (i19 == i) {
                            z5 = false;
                            i7 = length;
                        } else {
                            i7 = i3;
                            z5 = true;
                        }
                        arrayList.add(str.substring(i2, i7));
                        i19 = i20;
                        i6 = i7;
                        z4 = false;
                    } else {
                        boolean z16 = z3;
                        z4 = z2;
                        i6 = i3;
                        z5 = z16;
                    }
                    i2 = i6 + 1;
                    z15 = z4;
                    z14 = z5;
                    i18 = i2;
                } else {
                    i18 = i3 + 1;
                    z14 = false;
                    z15 = true;
                }
            }
            i4 = i3;
            i5 = i2;
        }
        if (z2 || (z && z3)) {
            arrayList.add(str.substring(i5, i4));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitByCharacterType(String str) {
        return m7365a(str, false);
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        return m7365a(str, true);
    }

    /* renamed from: a */
    private static String[] m7365a(String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int type = Character.getType(charArray[0]);
        for (int i2 = 1; i2 < charArray.length; i2++) {
            int type2 = Character.getType(charArray[i2]);
            if (type2 != type) {
                if (z && type2 == 2 && type == 1) {
                    int i3 = i2 - 1;
                    if (i3 != i) {
                        arrayList.add(new String(charArray, i, i3 - i));
                        i = i3;
                    }
                } else {
                    arrayList.add(new String(charArray, i, i2 - i));
                    i = i2;
                }
                type = type2;
            }
        }
        arrayList.add(new String(charArray, i, charArray.length - i));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static <T> String join(T... tArr) {
        return join((Object[]) tArr, (String) null);
    }

    public static String join(Object[] objArr, char c) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, c, 0, objArr.length);
    }

    public static String join(Object[] objArr, char c, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i3 * 16);
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                sb.append(c);
            }
            if (objArr[i4] != null) {
                sb.append(objArr[i4]);
            }
        }
        return sb.toString();
    }

    public static String join(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, str, 0, objArr.length);
    }

    public static String join(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i3 * 16);
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                sb.append(str);
            }
            if (objArr[i4] != null) {
                sb.append(objArr[i4]);
            }
        }
        return sb.toString();
    }

    public static String join(Iterator<?> it, char c) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ObjectUtils.toString(next);
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            sb.append(c);
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String join(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ObjectUtils.toString(next);
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                sb.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String join(Iterable<?> iterable, char c) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), c);
    }

    public static String join(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), str);
    }

    public static String deleteWhitespace(String str) {
        int i;
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                i = i3 + 1;
                cArr[i3] = str.charAt(i2);
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        return i3 != length ? new String(cArr, 0, i3) : str;
    }

    public static String removeStart(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !str.startsWith(str2)) {
            return str;
        }
        return str.substring(str2.length());
    }

    public static String removeStartIgnoreCase(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !startsWithIgnoreCase(str, str2)) {
            return str;
        }
        return str.substring(str2.length());
    }

    public static String removeEnd(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !str.endsWith(str2)) {
            return str;
        }
        return str.substring(0, str.length() - str2.length());
    }

    public static String removeEndIgnoreCase(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !endsWithIgnoreCase(str, str2)) {
            return str;
        }
        return str.substring(0, str.length() - str2.length());
    }

    public static String remove(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replace(str, str2, "", -1);
    }

    public static String remove(String str, char c) {
        if (isEmpty(str) || str.indexOf(c) == -1) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] != c) {
                charArray[i] = charArray[i2];
                i++;
            }
        }
        return new String(charArray, 0, i);
    }

    public static String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public static String replace(String str, String str2, String str3) {
        return replace(str, str2, str3, -1);
    }

    public static String replace(String str, String str2, String str3, int i) {
        int indexOf;
        int i2 = 64;
        if (isEmpty(str) || isEmpty(str2) || str3 == null || i == 0 || (indexOf = str.indexOf(str2, 0)) == -1) {
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        if (i < 0) {
            i2 = 16;
        } else if (i <= 64) {
            i2 = i;
        }
        StringBuilder sb = new StringBuilder((i2 * length2) + str.length());
        int i3 = 0;
        while (indexOf != -1) {
            sb.append(str.substring(i3, indexOf)).append(str3);
            i3 = indexOf + length;
            i--;
            if (i == 0) {
                break;
            }
            indexOf = str.indexOf(str2, i3);
        }
        sb.append(str.substring(i3));
        return sb.toString();
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        return m7361a(str, strArr, strArr2, false, 0);
    }

    public static String replaceEachRepeatedly(String str, String[] strArr, String[] strArr2) {
        return m7361a(str, strArr, strArr2, true, strArr == null ? 0 : strArr.length);
    }

    /* renamed from: a */
    private static String m7361a(String str, String[] strArr, String[] strArr2, boolean z, int i) {
        int length;
        if (str == null || str.length() == 0 || strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return str;
        }
        if (i < 0) {
            throw new IllegalStateException("TimeToLive of " + i + " is less than 0: " + str);
        }
        int length2 = strArr.length;
        int length3 = strArr2.length;
        if (length2 != length3) {
            throw new IllegalArgumentException("Search and Replace array lengths don't match: " + length2 + " vs " + length3);
        }
        boolean[] zArr = new boolean[length2];
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < length2; i4++) {
            if (!(zArr[i4] || strArr[i4] == null || strArr[i4].length() == 0 || strArr2[i4] == null)) {
                int indexOf = str.indexOf(strArr[i4]);
                if (indexOf == -1) {
                    zArr[i4] = true;
                } else if (i3 == -1 || indexOf < i3) {
                    i2 = i4;
                    i3 = indexOf;
                }
            }
        }
        if (i3 == -1) {
            return str;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (!(strArr[i6] == null || strArr2[i6] == null || (length = strArr2[i6].length() - strArr[i6].length()) <= 0)) {
                i5 += length * 3;
            }
        }
        StringBuilder sb = new StringBuilder(Math.min(i5, str.length() / 5) + str.length());
        int i7 = i2;
        int i8 = 0;
        while (i3 != -1) {
            while (i8 < i3) {
                sb.append(str.charAt(i8));
                i8++;
            }
            sb.append(strArr2[i7]);
            int length4 = i3 + strArr[i7].length();
            int i9 = -1;
            i3 = -1;
            for (int i10 = 0; i10 < length2; i10++) {
                if (!(zArr[i10] || strArr[i10] == null || strArr[i10].length() == 0 || strArr2[i10] == null)) {
                    int indexOf2 = str.indexOf(strArr[i10], length4);
                    if (indexOf2 == -1) {
                        zArr[i10] = true;
                    } else if (i3 == -1 || indexOf2 < i3) {
                        i9 = i10;
                        i3 = indexOf2;
                    }
                }
            }
            i7 = i9;
            i8 = length4;
        }
        int length5 = str.length();
        while (i8 < length5) {
            sb.append(str.charAt(i8));
            i8++;
        }
        String sb2 = sb.toString();
        return z ? m7361a(sb2, strArr, strArr2, z, i - 1) : sb2;
    }

    public static String replaceChars(String str, char c, char c2) {
        if (str == null) {
            return null;
        }
        return str.replace(c, c2);
    }

    public static String replaceChars(String str, String str2, String str3) {
        boolean z = false;
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        if (str3 == null) {
            str3 = "";
        }
        int length = str3.length();
        int length2 = str.length();
        StringBuilder sb = new StringBuilder(length2);
        for (int i = 0; i < length2; i++) {
            char charAt = str.charAt(i);
            int indexOf = str2.indexOf(charAt);
            if (indexOf >= 0) {
                z = true;
                if (indexOf < length) {
                    sb.append(str3.charAt(indexOf));
                }
            } else {
                sb.append(charAt);
            }
        }
        if (z) {
            return sb.toString();
        }
        return str;
    }

    public static String overlay(String str, String str2, int i, int i2) {
        int i3;
        int i4;
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length();
        if (i < 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        if (i3 > length) {
            i3 = length;
        }
        if (i2 < 0) {
            i4 = 0;
        } else {
            i4 = i2;
        }
        if (i4 > length) {
            i4 = length;
        }
        if (i3 <= i4) {
            int i5 = i4;
            i4 = i3;
            i3 = i5;
        }
        return new StringBuilder(((length + i4) - i3) + str2.length() + 1).append(str.substring(0, i4)).append(str2).append(str.substring(i3)).toString();
    }

    public static String chomp(String str) {
        if (isEmpty(str)) {
            return str;
        }
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            if (charAt == 13 || charAt == 10) {
                return "";
            }
            return str;
        }
        int length = str.length() - 1;
        char charAt2 = str.charAt(length);
        if (charAt2 == 10) {
            if (str.charAt(length - 1) == 13) {
                length--;
            }
        } else if (charAt2 != 13) {
            length++;
        }
        return str.substring(0, length);
    }

    public static String chomp(String str, String str2) {
        if (isEmpty(str) || str2 == null || !str.endsWith(str2)) {
            return str;
        }
        return str.substring(0, str.length() - str2.length());
    }

    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length < 2) {
            return "";
        }
        int i = length - 1;
        String substring = str.substring(0, i);
        if (str.charAt(i) == 10 && substring.charAt(i - 1) == 13) {
            return substring.substring(0, i - 1);
        }
        return substring;
    }

    public static String repeat(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (i == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i <= 8192) {
            return repeat(str.charAt(0), i);
        }
        int i2 = length * i;
        switch (length) {
            case 1:
                return repeat(str.charAt(0), i);
            case 2:
                char charAt = str.charAt(0);
                char charAt2 = str.charAt(1);
                char[] cArr = new char[i2];
                for (int i3 = (i * 2) - 2; i3 >= 0; i3 = (i3 - 1) - 1) {
                    cArr[i3] = charAt;
                    cArr[i3 + 1] = charAt2;
                }
                return new String(cArr);
            default:
                StringBuilder sb = new StringBuilder(i2);
                for (int i4 = 0; i4 < i; i4++) {
                    sb.append(str);
                }
                return sb.toString();
        }
    }

    public static String repeat(String str, String str2, int i) {
        if (str == null || str2 == null) {
            return repeat(str, i);
        }
        return removeEnd(repeat(str + str2, i), str2);
    }

    public static String repeat(char c, int i) {
        char[] cArr = new char[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            cArr[i2] = c;
        }
        return new String(cArr);
    }

    public static String rightPad(String str, int i) {
        return rightPad(str, i, ' ');
    }

    public static String rightPad(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return rightPad(str, i, String.valueOf(c));
        }
        return str.concat(repeat(c, length));
    }

    public static String rightPad(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return rightPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return str.concat(new String(cArr));
    }

    public static String leftPad(String str, int i) {
        return leftPad(str, i, ' ');
    }

    public static String leftPad(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return leftPad(str, i, String.valueOf(c));
        }
        return repeat(c, length).concat(str);
    }

    public static String leftPad(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return new String(cArr).concat(str);
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String center(String str, int i) {
        return center(str, i, ' ');
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r2.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String center(java.lang.String r2, int r3, char r4) {
        /*
            if (r2 == 0) goto L_0x0004
            if (r3 > 0) goto L_0x0005
        L_0x0004:
            return r2
        L_0x0005:
            int r0 = r2.length()
            int r1 = r3 - r0
            if (r1 <= 0) goto L_0x0004
            int r1 = r1 / 2
            int r0 = r0 + r1
            java.lang.String r0 = leftPad((java.lang.String) r2, (int) r0, (char) r4)
            java.lang.String r2 = rightPad((java.lang.String) r0, (int) r3, (char) r4)
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.center(java.lang.String, int, char):java.lang.String");
    }

    public static String center(String str, int i, String str2) {
        if (str == null || i <= 0) {
            return str;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str.length();
        int i2 = i - length;
        if (i2 > 0) {
            return rightPad(leftPad(str, length + (i2 / 2), str2), i, str2);
        }
        return str;
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String upperCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(locale);
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    public static String lowerCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(locale);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String capitalize(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x0008
            int r0 = r2.length()
            if (r0 != 0) goto L_0x0009
        L_0x0008:
            return r2
        L_0x0009:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r0 = 0
            char r0 = r2.charAt(r0)
            char r0 = java.lang.Character.toTitleCase(r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            r1 = 1
            java.lang.String r1 = r2.substring(r1)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r2 = r0.toString()
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.capitalize(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String uncapitalize(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x0008
            int r0 = r2.length()
            if (r0 != 0) goto L_0x0009
        L_0x0008:
            return r2
        L_0x0009:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r0 = 0
            char r0 = r2.charAt(r0)
            char r0 = java.lang.Character.toLowerCase(r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            r1 = 1
            java.lang.String r1 = r2.substring(r1)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r2 = r0.toString()
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.uncapitalize(java.lang.String):java.lang.String");
    }

    public static String swapCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isUpperCase(c)) {
                charArray[i] = Character.toLowerCase(c);
            } else if (Character.isTitleCase(c)) {
                charArray[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                charArray[i] = Character.toUpperCase(c);
            }
        }
        return new String(charArray);
    }

    public static int countMatches(CharSequence charSequence, CharSequence charSequence2) {
        int i = 0;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int a = CharSequenceUtils.m7343a(charSequence, charSequence2, i);
            if (a == -1) {
                return i2;
            }
            i2++;
            i = a + charSequence2.length();
        }
    }

    public static boolean isAlpha(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(charSequence.charAt(i)) && charSequence.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i)) && charSequence.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAsciiPrintable(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharUtils.isAsciiPrintable(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i)) && charSequence.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllLowerCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLowerCase(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllUpperCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isUpperCase(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String defaultString(String str) {
        return str == null ? "" : str;
    }

    public static String defaultString(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static <T extends CharSequence> T defaultIfBlank(T t, T t2) {
        return isBlank(t) ? t2 : t;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T t, T t2) {
        return isEmpty(t) ? t2 : t;
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseDelimited(String str, char c) {
        if (str == null) {
            return null;
        }
        String[] split = split(str, c);
        ArrayUtils.reverse((Object[]) split);
        return join((Object[]) split, c);
    }

    public static String abbreviate(String str, int i) {
        return abbreviate(str, 0, i);
    }

    public static String abbreviate(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 4) {
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        } else if (str.length() <= i2) {
            return str;
        } else {
            if (i > str.length()) {
                i = str.length();
            }
            if (str.length() - i < i2 - 3) {
                i = str.length() - (i2 - 3);
            }
            if (i <= 4) {
                return str.substring(0, i2 - 3) + "...";
            }
            if (i2 < 7) {
                throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
            } else if ((i2 - 3) + i < str.length()) {
                return "..." + abbreviate(str.substring(i), i2 - 3);
            } else {
                return "..." + str.substring(str.length() - (i2 - 3));
            }
        }
    }

    public static String abbreviateMiddle(String str, String str2, int i) {
        if (isEmpty(str) || isEmpty(str2) || i >= str.length() || i < str2.length() + 2) {
            return str;
        }
        int length = i - str2.length();
        int i2 = (length / 2) + (length % 2);
        int length2 = str.length() - (length / 2);
        StringBuilder sb = new StringBuilder(i);
        sb.append(str.substring(0, i2));
        sb.append(str2);
        sb.append(str.substring(length2));
        return sb.toString();
    }

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int indexOfDifference = indexOfDifference(str, str2);
        if (indexOfDifference == -1) {
            return "";
        }
        return str2.substring(indexOfDifference);
    }

    public static int indexOfDifference(CharSequence charSequence, CharSequence charSequence2) {
        int i = 0;
        if (charSequence == charSequence2) {
            return -1;
        }
        if (charSequence == null || charSequence2 == null) {
            return 0;
        }
        while (i < charSequence.length() && i < charSequence2.length() && charSequence.charAt(i) == charSequence2.charAt(i)) {
            i++;
        }
        if (i < charSequence2.length() || i < charSequence.length()) {
            return i;
        }
        return -1;
    }

    public static int indexOfDifference(CharSequence... charSequenceArr) {
        int i;
        int min;
        boolean z;
        boolean z2;
        if (charSequenceArr == null || charSequenceArr.length <= 1) {
            return -1;
        }
        int length = charSequenceArr.length;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = true;
        boolean z4 = false;
        while (i3 < length) {
            if (charSequenceArr[i3] == null) {
                z2 = z3;
                z = true;
                min = 0;
            } else {
                min = Math.min(charSequenceArr[i3].length(), i2);
                i4 = Math.max(charSequenceArr[i3].length(), i4);
                z = z4;
                z2 = false;
            }
            i3++;
            int i5 = min;
            z3 = z2;
            z4 = z;
            i2 = i5;
        }
        if (z3 || (i4 == 0 && !z4)) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        int i6 = 0;
        int i7 = -1;
        while (true) {
            if (i6 >= i2) {
                i = i7;
                break;
            }
            char charAt = charSequenceArr[0].charAt(i6);
            int i8 = 1;
            while (true) {
                if (i8 >= length) {
                    break;
                } else if (charSequenceArr[i8].charAt(i6) != charAt) {
                    i7 = i6;
                    break;
                } else {
                    i8++;
                }
            }
            if (i7 != -1) {
                i = i7;
                break;
            }
            i6++;
        }
        if (i != -1 || i2 == i4) {
            return i;
        }
        return i2;
    }

    public static String getCommonPrefix(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        int indexOfDifference = indexOfDifference(strArr);
        if (indexOfDifference == -1) {
            if (strArr[0] == null) {
                return "";
            }
            return strArr[0];
        } else if (indexOfDifference == 0) {
            return "";
        } else {
            return strArr[0].substring(0, indexOfDifference);
        }
    }

    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2) {
        int i;
        int i2;
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int length = charSequence.length();
        int length2 = charSequence2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        if (length > length2) {
            i = charSequence.length();
        } else {
            int i3 = length2;
            length2 = length;
            i = i3;
            CharSequence charSequence3 = charSequence2;
            charSequence2 = charSequence;
            charSequence = charSequence3;
        }
        int[] iArr = new int[(length2 + 1)];
        int[] iArr2 = new int[(length2 + 1)];
        for (int i4 = 0; i4 <= length2; i4++) {
            iArr[i4] = i4;
        }
        int i5 = 1;
        int[] iArr3 = iArr2;
        while (i5 <= i) {
            char charAt = charSequence.charAt(i5 - 1);
            iArr3[0] = i5;
            for (int i6 = 1; i6 <= length2; i6++) {
                if (charSequence2.charAt(i6 - 1) == charAt) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                iArr3[i6] = Math.min(Math.min(iArr3[i6 - 1] + 1, iArr[i6] + 1), i2 + iArr[i6 - 1]);
            }
            i5++;
            int[] iArr4 = iArr;
            iArr = iArr3;
            iArr3 = iArr4;
        }
        return iArr[length2];
    }

    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        } else if (i < 0) {
            throw new IllegalArgumentException("Threshold must not be negative");
        } else {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            if (length == 0) {
                if (length2 <= i) {
                    return length2;
                }
                return -1;
            } else if (length2 != 0) {
                if (length > length2) {
                    length = length2;
                    length2 = charSequence.length();
                } else {
                    CharSequence charSequence3 = charSequence2;
                    charSequence2 = charSequence;
                    charSequence = charSequence3;
                }
                int[] iArr = new int[(length + 1)];
                int[] iArr2 = new int[(length + 1)];
                int min = Math.min(length, i) + 1;
                for (int i2 = 0; i2 < min; i2++) {
                    iArr[i2] = i2;
                }
                Arrays.fill(iArr, min, iArr.length, Integer.MAX_VALUE);
                Arrays.fill(iArr2, Integer.MAX_VALUE);
                int[] iArr3 = iArr2;
                int i3 = 1;
                while (i3 <= length2) {
                    char charAt = charSequence.charAt(i3 - 1);
                    iArr3[0] = i3;
                    int max = Math.max(1, i3 - i);
                    int min2 = Math.min(length, i3 + i);
                    if (max > min2) {
                        return -1;
                    }
                    if (max > 1) {
                        iArr3[max - 1] = Integer.MAX_VALUE;
                    }
                    while (max <= min2) {
                        if (charSequence2.charAt(max - 1) == charAt) {
                            iArr3[max] = iArr[max - 1];
                        } else {
                            iArr3[max] = Math.min(Math.min(iArr3[max - 1], iArr[max]), iArr[max - 1]) + 1;
                        }
                        max++;
                    }
                    i3++;
                    int[] iArr4 = iArr;
                    iArr = iArr3;
                    iArr3 = iArr4;
                }
                if (iArr[length] <= i) {
                    return iArr[length];
                }
                return -1;
            } else if (length <= i) {
                return length;
            } else {
                return -1;
            }
        }
    }

    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        return m7362a(charSequence, charSequence2, false);
    }

    public static boolean startsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return m7362a(charSequence, charSequence2, true);
    }

    /* renamed from: a */
    private static boolean m7362a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == null && charSequence2 == null) {
                return true;
            }
            return false;
        } else if (charSequence2.length() > charSequence.length()) {
            return false;
        } else {
            return CharSequenceUtils.m7344a(charSequence, z, 0, charSequence2, 0, charSequence2.length());
        }
    }

    public static boolean startsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (isEmpty(charSequence) || ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            return false;
        }
        for (CharSequence startsWith : charSequenceArr) {
            if (startsWith(charSequence, startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        return m7367b(charSequence, charSequence2, false);
    }

    public static boolean endsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return m7367b(charSequence, charSequence2, true);
    }

    /* renamed from: b */
    private static boolean m7367b(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == null && charSequence2 == null) {
                return true;
            }
            return false;
        } else if (charSequence2.length() > charSequence.length()) {
            return false;
        } else {
            return CharSequenceUtils.m7344a(charSequence, z, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length());
        }
    }

    public static String normalizeSpace(String str) {
        if (str == null) {
            return null;
        }
        return f7045a.matcher(trim(str)).replaceAll(" ");
    }

    public static boolean endsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (isEmpty(charSequence) || ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            return false;
        }
        for (CharSequence endsWith : charSequenceArr) {
            if (endsWith(charSequence, endsWith)) {
                return true;
            }
        }
        return false;
    }
}
