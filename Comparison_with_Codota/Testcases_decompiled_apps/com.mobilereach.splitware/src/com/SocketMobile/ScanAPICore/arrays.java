package com.SocketMobile.ScanAPICore;

public class arrays {
    public static char[] copy(char[] array) {
        if (array == null) {
            return null;
        }
        char[] dest = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            dest[i] = array[i];
        }
        return dest;
    }

    public static char[] copy(char[] array, int offset, int length) {
        if (array == null) {
            throw new IndexOutOfBoundsException();
        }
        char[] dest = new char[length];
        if (array.length < length + offset || offset < 0 || length < 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < length; i++) {
            dest[i] = array[i + offset];
        }
        return dest;
    }

    public static boolean equals(char[] a, int aOffset, char[] a2, int a2Offset, int length) {
        boolean result = true;
        if (a == null || a2 == null || a.length < length + aOffset || a2.length < length + a2Offset || aOffset < 0 || length < 0) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (a[i + aOffset] != a2[i + a2Offset]) {
                result = false;
                break;
            } else {
                i++;
            }
        }
        return result;
    }

    public static boolean equals(char[] a1, char[] a2) {
        boolean result = true;
        if (a1 == null || a2 == null) {
            return false;
        }
        if (a1.length == a2.length) {
            int i = 0;
            while (true) {
                if (i >= a1.length) {
                    break;
                } else if (a1[i] != a2[i]) {
                    result = false;
                    break;
                } else {
                    i++;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    public static void fill(char[] array, char element) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                array[i] = element;
            }
        }
    }

    public static void fill(char[] array, char element, int offset, int length) {
        if (array != null && array.length >= length + offset && offset >= 0 && length >= 0) {
            for (int i = 0; i < length; i++) {
                array[i + offset] = element;
            }
        }
    }
}
