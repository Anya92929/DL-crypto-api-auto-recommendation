package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeToken<T> {

    /* renamed from: a */
    final Class<? super T> f3819a;

    /* renamed from: b */
    final Type f3820b;

    /* renamed from: c */
    final int f3821c;

    public TypeToken() {
        this.f3820b = m4411a(getClass());
        this.f3819a = C$Gson$Types.getRawType(this.f3820b);
        this.f3821c = this.f3820b.hashCode();
    }

    TypeToken(Type type) {
        this.f3820b = C$Gson$Types.canonicalize((Type) C$Gson$Preconditions.checkNotNull(type));
        this.f3819a = C$Gson$Types.getRawType(this.f3820b);
        this.f3821c = this.f3820b.hashCode();
    }

    /* renamed from: a */
    static Type m4411a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return C$Gson$Types.canonicalize(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> getRawType() {
        return this.f3819a;
    }

    public final Type getType() {
        return this.f3820b;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        if (type == null) {
            return false;
        }
        if (this.f3820b.equals(type)) {
            return true;
        }
        if (this.f3820b instanceof Class) {
            return this.f3819a.isAssignableFrom(C$Gson$Types.getRawType(type));
        }
        if (this.f3820b instanceof ParameterizedType) {
            return m4414a(type, (ParameterizedType) this.f3820b, (Map<String, Type>) new HashMap());
        }
        if (this.f3820b instanceof GenericArrayType) {
            return this.f3819a.isAssignableFrom(C$Gson$Types.getRawType(type)) && m4413a(type, (GenericArrayType) this.f3820b);
        }
        throw m4410a(this.f3820b, (Class<?>[]) new Class[]{Class.class, ParameterizedType.class, GenericArrayType.class});
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }

    /* renamed from: a */
    private static boolean m4413a(Type type, GenericArrayType genericArrayType) {
        Class<?> cls;
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof ParameterizedType)) {
            return true;
        }
        if (type instanceof GenericArrayType) {
            cls = ((GenericArrayType) type).getGenericComponentType();
        } else {
            boolean z = type instanceof Class;
            cls = type;
            if (z) {
                Class<?> cls2 = (Class) type;
                while (cls2.isArray()) {
                    cls2 = cls2.getComponentType();
                }
                cls = cls2;
            }
        }
        return m4414a(cls, (ParameterizedType) genericComponentType, (Map<String, Type>) new HashMap());
    }

    /* renamed from: a */
    private static boolean m4414a(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        ParameterizedType parameterizedType2;
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class<?> rawType = C$Gson$Types.getRawType(type);
        if (type instanceof ParameterizedType) {
            parameterizedType2 = (ParameterizedType) type;
        } else {
            parameterizedType2 = null;
        }
        if (parameterizedType2 != null) {
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            TypeVariable[] typeParameters = rawType.getTypeParameters();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type type2 = actualTypeArguments[i];
                TypeVariable typeVariable = typeParameters[i];
                while (type2 instanceof TypeVariable) {
                    type2 = map.get(((TypeVariable) type2).getName());
                }
                map.put(typeVariable.getName(), type2);
            }
            if (m4412a(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        for (Type a : rawType.getGenericInterfaces()) {
            if (m4414a(a, parameterizedType, (Map<String, Type>) new HashMap(map))) {
                return true;
            }
        }
        return m4414a(rawType.getGenericSuperclass(), parameterizedType, (Map<String, Type>) new HashMap(map));
    }

    /* renamed from: a */
    private static boolean m4412a(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            if (!m4415a(actualTypeArguments[i], actualTypeArguments2[i], map)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static AssertionError m4410a(Type type, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("Unexpected type. Expected one of: ");
        for (Class<?> name : clsArr) {
            sb.append(name.getName()).append(", ");
        }
        sb.append("but got: ").append(type.getClass().getName()).append(", for type token: ").append(type.toString()).append('.');
        return new AssertionError(sb.toString());
    }

    /* renamed from: a */
    private static boolean m4415a(Type type, Type type2, Map<String, Type> map) {
        return type2.equals(type) || ((type instanceof TypeVariable) && type2.equals(map.get(((TypeVariable) type).getName())));
    }

    public final int hashCode() {
        return this.f3821c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeToken) && C$Gson$Types.equals(this.f3820b, ((TypeToken) obj).f3820b);
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.f3820b);
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken<>(type);
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        return new TypeToken<>(cls);
    }
}
