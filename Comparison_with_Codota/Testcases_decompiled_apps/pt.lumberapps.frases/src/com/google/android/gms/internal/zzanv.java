package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzanv {

    /* renamed from: a */
    private static final Map f5812a;

    /* renamed from: b */
    private static final Map f5813b;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        m6690a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        m6690a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        m6690a(hashMap, hashMap2, Character.TYPE, Character.class);
        m6690a(hashMap, hashMap2, Double.TYPE, Double.class);
        m6690a(hashMap, hashMap2, Float.TYPE, Float.class);
        m6690a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        m6690a(hashMap, hashMap2, Long.TYPE, Long.class);
        m6690a(hashMap, hashMap2, Short.TYPE, Short.class);
        m6690a(hashMap, hashMap2, Void.TYPE, Void.class);
        f5812a = Collections.unmodifiableMap(hashMap);
        f5813b = Collections.unmodifiableMap(hashMap2);
    }

    /* renamed from: a */
    private static void m6690a(Map map, Map map2, Class cls, Class cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean zzk(Type type) {
        return f5812a.containsKey(type);
    }

    public static Class zzp(Class cls) {
        Class cls2 = (Class) f5812a.get(zzann.zzy(cls));
        return cls2 == null ? cls : cls2;
    }
}
