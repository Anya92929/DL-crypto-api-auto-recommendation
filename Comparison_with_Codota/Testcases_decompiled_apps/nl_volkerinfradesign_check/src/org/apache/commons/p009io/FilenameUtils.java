package org.apache.commons.p009io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

/* renamed from: org.apache.commons.io.FilenameUtils */
public class FilenameUtils {
    public static final char EXTENSION_SEPARATOR = '.';
    public static final String EXTENSION_SEPARATOR_STR = Character.toString('.');

    /* renamed from: a */
    private static final char f6839a = File.separatorChar;

    /* renamed from: b */
    private static final char f6840b;

    static {
        if (m7280a()) {
            f6840b = IOUtils.DIR_SEPARATOR_UNIX;
        } else {
            f6840b = IOUtils.DIR_SEPARATOR_WINDOWS;
        }
    }

    /* renamed from: a */
    static boolean m7280a() {
        return f6839a == '\\';
    }

    /* renamed from: a */
    private static boolean m7281a(char c) {
        return c == '/' || c == '\\';
    }

    public static String normalize(String str) {
        return m7277a(str, f6839a, true);
    }

    public static String normalize(String str, boolean z) {
        return m7277a(str, z ? IOUtils.DIR_SEPARATOR_UNIX : IOUtils.DIR_SEPARATOR_WINDOWS, true);
    }

    public static String normalizeNoEndSeparator(String str) {
        return m7277a(str, f6839a, false);
    }

    public static String normalizeNoEndSeparator(String str, boolean z) {
        return m7277a(str, z ? IOUtils.DIR_SEPARATOR_UNIX : IOUtils.DIR_SEPARATOR_WINDOWS, false);
    }

    /* renamed from: a */
    private static String m7277a(String str, char c, boolean z) {
        int i;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int prefixLength = getPrefixLength(str);
        if (prefixLength < 0) {
            return null;
        }
        char[] cArr = new char[(length + 2)];
        str.getChars(0, str.length(), cArr, 0);
        char c2 = c == f6839a ? f6840b : f6839a;
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (cArr[i2] == c2) {
                cArr[i2] = c;
            }
        }
        boolean z2 = true;
        if (cArr[length - 1] != c) {
            i = length + 1;
            cArr[length] = c;
            z2 = false;
        } else {
            i = length;
        }
        int i3 = i;
        int i4 = prefixLength + 1;
        while (i4 < i3) {
            if (cArr[i4] == c && cArr[i4 - 1] == c) {
                System.arraycopy(cArr, i4, cArr, i4 - 1, i3 - i4);
                i3--;
                i4--;
            }
            i4++;
        }
        int i5 = prefixLength + 1;
        while (i5 < i3) {
            if (cArr[i5] == c && cArr[i5 - 1] == '.' && (i5 == prefixLength + 1 || cArr[i5 - 2] == c)) {
                if (i5 == i3 - 1) {
                    z2 = true;
                }
                System.arraycopy(cArr, i5 + 1, cArr, i5 - 1, i3 - i5);
                i3 -= 2;
                i5--;
            }
            z2 = z2;
            i5++;
        }
        int i6 = prefixLength + 2;
        while (i6 < i3) {
            if (cArr[i6] == c && cArr[i6 - 1] == '.' && cArr[i6 - 2] == '.' && (i6 == prefixLength + 2 || cArr[i6 - 3] == c)) {
                if (i6 != prefixLength + 2) {
                    if (i6 == i3 - 1) {
                        z2 = true;
                    }
                    int i7 = i6 - 4;
                    while (true) {
                        if (i7 < prefixLength) {
                            System.arraycopy(cArr, i6 + 1, cArr, prefixLength, i3 - i6);
                            i3 -= (i6 + 1) - prefixLength;
                            i6 = prefixLength + 1;
                            break;
                        } else if (cArr[i7] == c) {
                            System.arraycopy(cArr, i6 + 1, cArr, i7 + 1, i3 - i6);
                            i3 -= i6 - i7;
                            i6 = i7 + 1;
                            break;
                        } else {
                            i7--;
                        }
                    }
                } else {
                    return null;
                }
            }
            z2 = z2;
            i6++;
        }
        if (i3 <= 0) {
            return "";
        }
        if (i3 <= prefixLength) {
            return new String(cArr, 0, i3);
        }
        if (!z2 || !z) {
            return new String(cArr, 0, i3 - 1);
        }
        return new String(cArr, 0, i3);
    }

    public static String concat(String str, String str2) {
        int prefixLength = getPrefixLength(str2);
        if (prefixLength < 0) {
            return null;
        }
        if (prefixLength > 0) {
            return normalize(str2);
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return normalize(str2);
        }
        if (m7281a(str.charAt(length - 1))) {
            return normalize(str + str2);
        }
        return normalize(str + IOUtils.DIR_SEPARATOR_UNIX + str2);
    }

    public static boolean directoryContains(String str, String str2) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Directory must not be null");
        } else if (str2 != null && !IOCase.SYSTEM.checkEquals(str, str2)) {
            return IOCase.SYSTEM.checkStartsWith(str2, str);
        } else {
            return false;
        }
    }

    public static String separatorsToUnix(String str) {
        return (str == null || str.indexOf(92) == -1) ? str : str.replace(IOUtils.DIR_SEPARATOR_WINDOWS, IOUtils.DIR_SEPARATOR_UNIX);
    }

    public static String separatorsToWindows(String str) {
        return (str == null || str.indexOf(47) == -1) ? str : str.replace(IOUtils.DIR_SEPARATOR_UNIX, IOUtils.DIR_SEPARATOR_WINDOWS);
    }

    public static String separatorsToSystem(String str) {
        if (str == null) {
            return null;
        }
        if (m7280a()) {
            return separatorsToWindows(str);
        }
        return separatorsToUnix(str);
    }

    public static int getPrefixLength(String str) {
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char charAt = str.charAt(0);
        if (charAt == ':') {
            return -1;
        }
        if (length == 1) {
            if (charAt == '~') {
                return 2;
            }
            if (!m7281a(charAt)) {
                return 0;
            }
            return 1;
        } else if (charAt == '~') {
            int indexOf = str.indexOf(47, 1);
            int indexOf2 = str.indexOf(92, 1);
            if (indexOf == -1 && indexOf2 == -1) {
                return length + 1;
            }
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            return Math.min(indexOf, indexOf2) + 1;
        } else {
            char charAt2 = str.charAt(1);
            if (charAt2 == ':') {
                char upperCase = Character.toUpperCase(charAt);
                if (upperCase < 'A' || upperCase > 'Z') {
                    return -1;
                }
                if (length == 2 || !m7281a(str.charAt(2))) {
                    return 2;
                }
                return 3;
            } else if (m7281a(charAt) && m7281a(charAt2)) {
                int indexOf3 = str.indexOf(47, 2);
                int indexOf4 = str.indexOf(92, 2);
                if ((indexOf3 == -1 && indexOf4 == -1) || indexOf3 == 2 || indexOf4 == 2) {
                    return -1;
                }
                if (indexOf3 == -1) {
                    indexOf3 = indexOf4;
                }
                if (indexOf4 == -1) {
                    indexOf4 = indexOf3;
                }
                return Math.min(indexOf3, indexOf4) + 1;
            } else if (!m7281a(charAt)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static int indexOfExtension(String str) {
        int lastIndexOf;
        if (str != null && indexOfLastSeparator(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static String getPrefix(String str) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength > str.length()) {
            return str + IOUtils.DIR_SEPARATOR_UNIX;
        }
        return str.substring(0, prefixLength);
    }

    public static String getPath(String str) {
        return m7278a(str, 1);
    }

    public static String getPathNoEndSeparator(String str) {
        return m7278a(str, 0);
    }

    /* renamed from: a */
    private static String m7278a(String str, int i) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        int indexOfLastSeparator = indexOfLastSeparator(str);
        int i2 = indexOfLastSeparator + i;
        if (prefixLength >= str.length() || indexOfLastSeparator < 0 || prefixLength >= i2) {
            return "";
        }
        return str.substring(prefixLength, i2);
    }

    public static String getFullPath(String str) {
        return m7279a(str, true);
    }

    public static String getFullPathNoEndSeparator(String str) {
        return m7279a(str, false);
    }

    /* renamed from: a */
    private static String m7279a(String str, boolean z) {
        int i;
        if (str == null) {
            return null;
        }
        int prefixLength = getPrefixLength(str);
        if (prefixLength < 0) {
            return null;
        }
        if (prefixLength < str.length()) {
            int indexOfLastSeparator = indexOfLastSeparator(str);
            if (indexOfLastSeparator < 0) {
                return str.substring(0, prefixLength);
            }
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            int i2 = i + indexOfLastSeparator;
            if (i2 == 0) {
                i2++;
            }
            return str.substring(0, i2);
        } else if (z) {
            return getPrefix(str);
        } else {
            return str;
        }
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    public static String getBaseName(String str) {
        return removeExtension(getName(str));
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int indexOfExtension = indexOfExtension(str);
        if (indexOfExtension == -1) {
            return "";
        }
        return str.substring(indexOfExtension + 1);
    }

    public static String removeExtension(String str) {
        if (str == null) {
            return null;
        }
        int indexOfExtension = indexOfExtension(str);
        return indexOfExtension != -1 ? str.substring(0, indexOfExtension) : str;
    }

    public static boolean equals(String str, String str2) {
        return equals(str, str2, false, IOCase.SENSITIVE);
    }

    public static boolean equalsOnSystem(String str, String str2) {
        return equals(str, str2, false, IOCase.SYSTEM);
    }

    public static boolean equalsNormalized(String str, String str2) {
        return equals(str, str2, true, IOCase.SENSITIVE);
    }

    public static boolean equalsNormalizedOnSystem(String str, String str2) {
        return equals(str, str2, true, IOCase.SYSTEM);
    }

    public static boolean equals(String str, String str2, boolean z, IOCase iOCase) {
        if (str != null && str2 != null) {
            if (z) {
                str = normalize(str);
                str2 = normalize(str2);
                if (str == null || str2 == null) {
                    throw new NullPointerException("Error normalizing one or both of the file names");
                }
            }
            if (iOCase == null) {
                iOCase = IOCase.SENSITIVE;
            }
            return iOCase.checkEquals(str, str2);
        } else if (str == null && str2 == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isExtension(String str, String str2) {
        if (str == null) {
            return false;
        }
        if (str2 != null && str2.length() != 0) {
            return getExtension(str).equals(str2);
        }
        if (indexOfExtension(str) == -1) {
            return true;
        }
        return false;
    }

    public static boolean isExtension(String str, String[] strArr) {
        boolean z = true;
        if (str == null) {
            return false;
        }
        if (strArr == null || strArr.length == 0) {
            if (indexOfExtension(str) != -1) {
                z = false;
            }
            return z;
        }
        String extension = getExtension(str);
        for (String equals : strArr) {
            if (extension.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExtension(String str, Collection<String> collection) {
        if (str == null) {
            return false;
        }
        if (collection == null || collection.isEmpty()) {
            return indexOfExtension(str) == -1;
        }
        String extension = getExtension(str);
        for (String equals : collection) {
            if (extension.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean wildcardMatch(String str, String str2) {
        return wildcardMatch(str, str2, IOCase.SENSITIVE);
    }

    public static boolean wildcardMatchOnSystem(String str, String str2) {
        return wildcardMatch(str, str2, IOCase.SYSTEM);
    }

    public static boolean wildcardMatch(String str, String str2, IOCase iOCase) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        if (iOCase == null) {
            iOCase = IOCase.SENSITIVE;
        }
        String[] a = m7282a(str2);
        Stack stack = new Stack();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        do {
            if (stack.size() > 0) {
                int[] iArr = (int[]) stack.pop();
                int i3 = iArr[0];
                z = true;
                int i4 = iArr[1];
                i = i3;
                i2 = i4;
            }
            while (i < a.length) {
                if (a[i].equals("?")) {
                    i2++;
                    if (i2 > str.length()) {
                        break;
                    }
                    z = false;
                } else if (!a[i].equals("*")) {
                    if (!z) {
                        if (!iOCase.checkRegionMatches(str, i2, a[i])) {
                            break;
                        }
                    } else {
                        i2 = iOCase.checkIndexOf(str, i2, a[i]);
                        if (i2 == -1) {
                            break;
                        }
                        int checkIndexOf = iOCase.checkIndexOf(str, i2 + 1, a[i]);
                        if (checkIndexOf >= 0) {
                            stack.push(new int[]{i, checkIndexOf});
                        }
                    }
                    i2 += a[i].length();
                    z = false;
                } else if (i == a.length - 1) {
                    i2 = str.length();
                    z = true;
                } else {
                    z = true;
                }
                i++;
            }
            if (i == a.length && i2 == str.length()) {
                return true;
            }
        } while (stack.size() > 0);
        return false;
    }

    /* renamed from: a */
    static String[] m7282a(String str) {
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '?' || charArray[i] == '*') {
                if (sb.length() != 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                if (charArray[i] == '?') {
                    arrayList.add("?");
                } else if (arrayList.isEmpty() || (i > 0 && !((String) arrayList.get(arrayList.size() - 1)).equals("*"))) {
                    arrayList.add("*");
                }
            } else {
                sb.append(charArray[i]);
            }
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
