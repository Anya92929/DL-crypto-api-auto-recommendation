package org.apache.commons.lang3;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public class Validate {
    public static void isTrue(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, new Object[]{Long.valueOf(j)}));
        }
    }

    public static void isTrue(boolean z, String str, double d) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, new Object[]{new Double(d)}));
        }
    }

    public static void isTrue(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isTrue(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("The validated expression is false");
        }
    }

    public static <T> T notNull(T t) {
        return notNull(t, "The validated object is null", new Object[0]);
    }

    public static <T> T notNull(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <T> T[] notEmpty(T[] tArr, String str, Object... objArr) {
        if (tArr == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (tArr.length != 0) {
            return tArr;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T[] notEmpty(T[] tArr) {
        return notEmpty(tArr, "The validated array is empty", new Object[0]);
    }

    public static <T extends Collection<?>> T notEmpty(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (t.size() != 0) {
            return t;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends Collection<?>> T notEmpty(T t) {
        return notEmpty(t, "The validated collection is empty", new Object[0]);
    }

    public static <T extends Map<?, ?>> T notEmpty(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (t.size() != 0) {
            return t;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends Map<?, ?>> T notEmpty(T t) {
        return notEmpty(t, "The validated map is empty", new Object[0]);
    }

    public static <T extends CharSequence> T notEmpty(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (t.length() != 0) {
            return t;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends CharSequence> T notEmpty(T t) {
        return notEmpty(t, "The validated character sequence is empty", new Object[0]);
    }

    public static <T extends CharSequence> T notBlank(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (!StringUtils.isBlank(t)) {
            return t;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends CharSequence> T notBlank(T t) {
        return notBlank(t, "The validated character sequence is blank", new Object[0]);
    }

    public static <T> T[] noNullElements(T[] tArr, String str, Object... objArr) {
        notNull(tArr);
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] == null) {
                throw new IllegalArgumentException(String.format(str, ArrayUtils.add((T[]) objArr, Integer.valueOf(i))));
            }
        }
        return tArr;
    }

    public static <T> T[] noNullElements(T[] tArr) {
        return noNullElements(tArr, "The validated array contains null element at index: %d", new Object[0]);
    }

    public static <T extends Iterable<?>> T noNullElements(T t, String str, Object... objArr) {
        notNull(t);
        int i = 0;
        for (Object obj : t) {
            if (obj == null) {
                throw new IllegalArgumentException(String.format(str, ArrayUtils.addAll((T[]) objArr, (T[]) new Object[]{Integer.valueOf(i)})));
            }
            i++;
        }
        return t;
    }

    public static <T extends Iterable<?>> T noNullElements(T t) {
        return noNullElements(t, "The validated collection contains null element at index: %d", new Object[0]);
    }

    public static <T> T[] validIndex(T[] tArr, int i, String str, Object... objArr) {
        notNull(tArr);
        if (i >= 0 && i < tArr.length) {
            return tArr;
        }
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    public static <T> T[] validIndex(T[] tArr, int i) {
        return validIndex(tArr, i, "The validated array index is invalid: %d", Integer.valueOf(i));
    }

    public static <T extends Collection<?>> T validIndex(T t, int i, String str, Object... objArr) {
        notNull(t);
        if (i >= 0 && i < t.size()) {
            return t;
        }
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    public static <T extends Collection<?>> T validIndex(T t, int i) {
        return validIndex(t, i, "The validated collection index is invalid: %d", Integer.valueOf(i));
    }

    public static <T extends CharSequence> T validIndex(T t, int i, String str, Object... objArr) {
        notNull(t);
        if (i >= 0 && i < t.length()) {
            return t;
        }
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    public static <T extends CharSequence> T validIndex(T t, int i) {
        return validIndex(t, i, "The validated character sequence index is invalid: %d", Integer.valueOf(i));
    }

    public static void validState(boolean z) {
        if (!z) {
            throw new IllegalStateException("The validated state is false");
        }
    }

    public static void validState(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format("The string %s does not match the pattern %s", new Object[]{charSequence, str}));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str, String str2, Object... objArr) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(str2, objArr));
        }
    }

    public static <T> void inclusiveBetween(T t, T t2, Comparable<T> comparable) {
        if (comparable.compareTo(t) < 0 || comparable.compareTo(t2) > 0) {
            throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", new Object[]{comparable, t, t2}));
        }
    }

    public static <T> void inclusiveBetween(T t, T t2, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t) < 0 || comparable.compareTo(t2) > 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> void exclusiveBetween(T t, T t2, Comparable<T> comparable) {
        if (comparable.compareTo(t) <= 0 || comparable.compareTo(t2) >= 0) {
            throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", new Object[]{comparable, t, t2}));
        }
    }

    public static <T> void exclusiveBetween(T t, T t2, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t) <= 0 || comparable.compareTo(t2) >= 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj) {
        if (!cls.isInstance(obj)) {
            throw new IllegalArgumentException(String.format("The validated object is not an instance of %s", new Object[]{cls.getName()}));
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj, String str, Object... objArr) {
        if (!cls.isInstance(obj)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format("The validated class can not be converted to the %s class", new Object[]{cls.getName()}));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2, String str, Object... objArr) {
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
