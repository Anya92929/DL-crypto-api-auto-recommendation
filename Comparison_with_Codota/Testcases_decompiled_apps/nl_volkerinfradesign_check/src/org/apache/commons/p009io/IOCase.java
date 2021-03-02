package org.apache.commons.p009io;

import java.io.Serializable;

/* renamed from: org.apache.commons.io.IOCase */
public final class IOCase implements Serializable {
    public static final IOCase INSENSITIVE = new IOCase("Insensitive", false);
    public static final IOCase SENSITIVE = new IOCase("Sensitive", true);
    public static final IOCase SYSTEM;
    private static final long serialVersionUID = -6343169151696340687L;

    /* renamed from: a */
    private final String f6843a;

    /* renamed from: b */
    private final transient boolean f6844b;

    static {
        boolean z = true;
        if (FilenameUtils.m7280a()) {
            z = false;
        }
        SYSTEM = new IOCase("System", z);
    }

    public static IOCase forName(String str) {
        if (SENSITIVE.f6843a.equals(str)) {
            return SENSITIVE;
        }
        if (INSENSITIVE.f6843a.equals(str)) {
            return INSENSITIVE;
        }
        if (SYSTEM.f6843a.equals(str)) {
            return SYSTEM;
        }
        throw new IllegalArgumentException("Invalid IOCase name: " + str);
    }

    private IOCase(String str, boolean z) {
        this.f6843a = str;
        this.f6844b = z;
    }

    private Object readResolve() {
        return forName(this.f6843a);
    }

    public String getName() {
        return this.f6843a;
    }

    public boolean isCaseSensitive() {
        return this.f6844b;
    }

    public int checkCompareTo(String str, String str2) {
        if (str != null && str2 != null) {
            return this.f6844b ? str.compareTo(str2) : str.compareToIgnoreCase(str2);
        }
        throw new NullPointerException("The strings must not be null");
    }

    public boolean checkEquals(String str, String str2) {
        if (str != null && str2 != null) {
            return this.f6844b ? str.equals(str2) : str.equalsIgnoreCase(str2);
        }
        throw new NullPointerException("The strings must not be null");
    }

    public boolean checkStartsWith(String str, String str2) {
        return str.regionMatches(!this.f6844b, 0, str2, 0, str2.length());
    }

    public boolean checkEndsWith(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(!this.f6844b, str.length() - length, str2, 0, length);
    }

    public int checkIndexOf(String str, int i, String str2) {
        int length = str.length() - str2.length();
        if (length >= i) {
            for (int i2 = i; i2 <= length; i2++) {
                if (checkRegionMatches(str, i2, str2)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public boolean checkRegionMatches(String str, int i, String str2) {
        return str.regionMatches(!this.f6844b, i, str2, 0, str2.length());
    }

    public String toString() {
        return this.f6843a;
    }
}
