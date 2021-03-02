package com.google.p008a.p010b;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.a.b.af */
public final class C0432af {

    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f3505a;

    /* renamed from: b */
    private static final Map<Class<?>, Class<?>> f3506b;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        m2719a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        m2719a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        m2719a(hashMap, hashMap2, Character.TYPE, Character.class);
        m2719a(hashMap, hashMap2, Double.TYPE, Double.class);
        m2719a(hashMap, hashMap2, Float.TYPE, Float.class);
        m2719a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        m2719a(hashMap, hashMap2, Long.TYPE, Long.class);
        m2719a(hashMap, hashMap2, Short.TYPE, Short.class);
        m2719a(hashMap, hashMap2, Void.TYPE, Void.class);
        f3505a = Collections.unmodifiableMap(hashMap);
        f3506b = Collections.unmodifiableMap(hashMap2);
    }

    /* renamed from: a */
    private static void m2719a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    /* renamed from: a */
    public static boolean m2720a(Type type) {
        return f3505a.containsKey(type);
    }
}
