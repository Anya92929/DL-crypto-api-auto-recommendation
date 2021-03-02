package com.google.gson;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class Primitives {
    public static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;
    public static final Map<Class<?>, Class<?>> WRAPPER_TO_PRIMITIVE_TYPE;

    private Primitives() {
    }

    static {
        Map<Class<?>, Class<?>> primToWrap = new HashMap<>(16);
        Map<Class<?>, Class<?>> wrapToPrim = new HashMap<>(16);
        add(primToWrap, wrapToPrim, Boolean.TYPE, Boolean.class);
        add(primToWrap, wrapToPrim, Byte.TYPE, Byte.class);
        add(primToWrap, wrapToPrim, Character.TYPE, Character.class);
        add(primToWrap, wrapToPrim, Double.TYPE, Double.class);
        add(primToWrap, wrapToPrim, Float.TYPE, Float.class);
        add(primToWrap, wrapToPrim, Integer.TYPE, Integer.class);
        add(primToWrap, wrapToPrim, Long.TYPE, Long.class);
        add(primToWrap, wrapToPrim, Short.TYPE, Short.class);
        add(primToWrap, wrapToPrim, Void.TYPE, Void.class);
        PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(primToWrap);
        WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap(wrapToPrim);
    }

    private static void add(Map<Class<?>, Class<?>> forward, Map<Class<?>, Class<?>> backward, Class<?> key, Class<?> value) {
        forward.put(key, value);
        backward.put(value, key);
    }

    public static boolean isWrapperType(Class<?> type) {
        return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(checkNotNull(type));
    }

    private static Class<?> checkNotNull(Class<?> type) {
        Preconditions.checkNotNull(type);
        return type;
    }

    public static <T> Class<T> wrap(Class<T> type) {
        checkNotNull(type);
        Class<T> wrapped = PRIMITIVE_TO_WRAPPER_TYPE.get(type);
        return wrapped == null ? type : wrapped;
    }

    public static <T> Class<T> unwrap(Class<T> type) {
        checkNotNull(type);
        Class<T> unwrapped = WRAPPER_TO_PRIMITIVE_TYPE.get(type);
        return unwrapped == null ? type : unwrapped;
    }
}
