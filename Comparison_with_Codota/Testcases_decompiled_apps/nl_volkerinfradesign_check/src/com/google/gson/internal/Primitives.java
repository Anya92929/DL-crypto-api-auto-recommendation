package com.google.gson.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Primitives {

    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f3751a;

    /* renamed from: b */
    private static final Map<Class<?>, Class<?>> f3752b;

    private Primitives() {
    }

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        m4333a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        m4333a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        m4333a(hashMap, hashMap2, Character.TYPE, Character.class);
        m4333a(hashMap, hashMap2, Double.TYPE, Double.class);
        m4333a(hashMap, hashMap2, Float.TYPE, Float.class);
        m4333a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        m4333a(hashMap, hashMap2, Long.TYPE, Long.class);
        m4333a(hashMap, hashMap2, Short.TYPE, Short.class);
        m4333a(hashMap, hashMap2, Void.TYPE, Void.class);
        f3751a = Collections.unmodifiableMap(hashMap);
        f3752b = Collections.unmodifiableMap(hashMap2);
    }

    /* renamed from: a */
    private static void m4333a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean isPrimitive(Type type) {
        return f3751a.containsKey(type);
    }

    public static boolean isWrapperType(Type type) {
        return f3752b.containsKey(C$Gson$Preconditions.checkNotNull(type));
    }

    public static <T> Class<T> wrap(Class<T> cls) {
        Class<T> cls2 = f3751a.get(C$Gson$Preconditions.checkNotNull(cls));
        return cls2 == null ? cls : cls2;
    }

    public static <T> Class<T> unwrap(Class<T> cls) {
        Class<T> cls2 = f3752b.get(C$Gson$Preconditions.checkNotNull(cls));
        return cls2 == null ? cls : cls2;
    }
}
