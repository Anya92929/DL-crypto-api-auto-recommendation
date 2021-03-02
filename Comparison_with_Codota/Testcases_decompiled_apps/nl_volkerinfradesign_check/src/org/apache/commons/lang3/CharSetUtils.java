package org.apache.commons.lang3;

public class CharSetUtils {
    public static String squeeze(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || m7349a(strArr)) {
            return str;
        }
        CharSet instance = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c = ' ';
        for (int i = 0; i < length; i++) {
            char c2 = charArray[i];
            if (c2 != c || i == 0 || !instance.contains(c2)) {
                sb.append(c2);
                c = c2;
            }
        }
        return sb.toString();
    }

    public static int count(String str, String... strArr) {
        int i = 0;
        if (!StringUtils.isEmpty(str) && !m7349a(strArr)) {
            CharSet instance = CharSet.getInstance(strArr);
            for (char contains : str.toCharArray()) {
                if (instance.contains(contains)) {
                    i++;
                }
            }
        }
        return i;
    }

    public static String keep(String str, String... strArr) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0 || m7349a(strArr)) {
            return "";
        }
        return m7348a(str, strArr, true);
    }

    public static String delete(String str, String... strArr) {
        return (StringUtils.isEmpty(str) || m7349a(strArr)) ? str : m7348a(str, strArr, false);
    }

    /* renamed from: a */
    private static String m7348a(String str, String[] strArr, boolean z) {
        CharSet instance = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (instance.contains(charArray[i]) == z) {
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static boolean m7349a(String[] strArr) {
        if (strArr != null) {
            for (String isNotEmpty : strArr) {
                if (StringUtils.isNotEmpty(isNotEmpty)) {
                    return false;
                }
            }
        }
        return true;
    }
}
