package com.google.gson;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class TypeUtils {
    static Type getActualTypeForFirstTypeVariable(Type type) {
        if (type instanceof Class) {
            return Object.class;
        }
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        if (type instanceof GenericArrayType) {
            return getActualTypeForFirstTypeVariable(((GenericArrayType) type).getGenericComponentType());
        }
        throw new IllegalArgumentException("Type '" + type + "' is not a Class, " + "ParameterizedType, or GenericArrayType. Can't extract class.");
    }

    static boolean isArray(Type type) {
        if (type instanceof Class) {
            return ((Class) type).isArray();
        }
        if (type instanceof GenericArrayType) {
            return true;
        }
        return false;
    }

    static Class<?> toRawClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return toRawClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof GenericArrayType) {
            return wrapWithArray(toRawClass(((GenericArrayType) type).getGenericComponentType()));
        }
        if (type instanceof WildcardType) {
            return toRawClass(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Type '" + type + "' is not a Class, " + "ParameterizedType, or GenericArrayType. Can't extract class.");
    }

    static Class<?> wrapWithArray(Class<?> rawClass) {
        return Array.newInstance(rawClass, 0).getClass();
    }

    private TypeUtils() {
    }
}
