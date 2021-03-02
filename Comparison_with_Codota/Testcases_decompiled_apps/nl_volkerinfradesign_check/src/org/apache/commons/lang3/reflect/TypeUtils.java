package org.apache.commons.lang3.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;

public class TypeUtils {
    public static boolean isAssignable(Type type, Type type2) {
        return m7434a(type, type2, (Map<TypeVariable<?>, Type>) null);
    }

    /* renamed from: a */
    private static boolean m7434a(Type type, Type type2, Map<TypeVariable<?>, Type> map) {
        if (type2 == null || (type2 instanceof Class)) {
            return m7431a(type, (Class<?>) (Class) type2);
        }
        if (type2 instanceof ParameterizedType) {
            return m7433a(type, (ParameterizedType) type2, map);
        }
        if (type2 instanceof GenericArrayType) {
            return m7432a(type, (GenericArrayType) type2, map);
        }
        if (type2 instanceof WildcardType) {
            return m7436a(type, (WildcardType) type2, map);
        }
        if (type2 instanceof TypeVariable) {
            return m7435a(type, (TypeVariable<?>) (TypeVariable) type2, map);
        }
        throw new IllegalStateException("found an unhandled type: " + type2);
    }

    /* renamed from: a */
    private static boolean m7431a(Type type, Class<?> cls) {
        if (type == null) {
            if (cls == null || !cls.isPrimitive()) {
                return true;
            }
            return false;
        } else if (cls == null) {
            return false;
        } else {
            if (cls.equals(type)) {
                return true;
            }
            if (type instanceof Class) {
                return ClassUtils.isAssignable((Class<?>) (Class) type, cls);
            }
            if (type instanceof ParameterizedType) {
                return m7431a((Type) m7424a((ParameterizedType) type), cls);
            }
            if (type instanceof TypeVariable) {
                for (Type a : ((TypeVariable) type).getBounds()) {
                    if (m7431a(a, cls)) {
                        return true;
                    }
                }
                return false;
            } else if (type instanceof GenericArrayType) {
                if (cls.equals(Object.class) || (cls.isArray() && m7431a(((GenericArrayType) type).getGenericComponentType(), cls.getComponentType()))) {
                    return true;
                }
                return false;
            } else if (type instanceof WildcardType) {
                return false;
            } else {
                throw new IllegalStateException("found an unhandled type: " + type);
            }
        }
    }

    /* renamed from: a */
    private static boolean m7433a(Type type, ParameterizedType parameterizedType, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (parameterizedType == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class<?> a = m7424a(parameterizedType);
        Map<TypeVariable<?>, Type> a2 = m7429a(type, a, (Map<TypeVariable<?>, Type>) null);
        if (a2 == null) {
            return false;
        }
        if (a2.isEmpty()) {
            return true;
        }
        for (Map.Entry next : m7428a(parameterizedType, a, map).entrySet()) {
            Type type2 = (Type) next.getValue();
            Type type3 = a2.get(next.getKey());
            if (type3 != null && !type2.equals(type3)) {
                if (!(type2 instanceof WildcardType) || !m7434a(type3, type2, map)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m7432a(Type type, GenericArrayType genericArrayType, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (genericArrayType == null) {
            return false;
        }
        if (genericArrayType.equals(type)) {
            return true;
        }
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray() || !m7434a((Type) cls.getComponentType(), genericComponentType, map)) {
                return false;
            }
            return true;
        } else if (type instanceof GenericArrayType) {
            return m7434a(((GenericArrayType) type).getGenericComponentType(), genericComponentType, map);
        } else {
            if (type instanceof WildcardType) {
                for (Type isAssignable : getImplicitUpperBounds((WildcardType) type)) {
                    if (isAssignable(isAssignable, genericArrayType)) {
                        return true;
                    }
                }
                return false;
            } else if (type instanceof TypeVariable) {
                for (Type isAssignable2 : getImplicitBounds((TypeVariable) type)) {
                    if (isAssignable(isAssignable2, genericArrayType)) {
                        return true;
                    }
                }
                return false;
            } else if (type instanceof ParameterizedType) {
                return false;
            } else {
                throw new IllegalStateException("found an unhandled type: " + type);
            }
        }
    }

    /* renamed from: a */
    private static boolean m7436a(Type type, WildcardType wildcardType, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (wildcardType == null) {
            return false;
        }
        if (wildcardType.equals(type)) {
            return true;
        }
        Type[] implicitUpperBounds = getImplicitUpperBounds(wildcardType);
        Type[] implicitLowerBounds = getImplicitLowerBounds(wildcardType);
        if (type instanceof WildcardType) {
            WildcardType wildcardType2 = (WildcardType) type;
            Type[] implicitUpperBounds2 = getImplicitUpperBounds(wildcardType2);
            Type[] implicitLowerBounds2 = getImplicitLowerBounds(wildcardType2);
            for (Type a : implicitUpperBounds) {
                Type a2 = m7426a(a, map);
                for (Type a3 : implicitUpperBounds2) {
                    if (!m7434a(a3, a2, map)) {
                        return false;
                    }
                }
            }
            for (Type a4 : implicitLowerBounds) {
                Type a5 = m7426a(a4, map);
                for (Type a6 : implicitLowerBounds2) {
                    if (!m7434a(a5, a6, map)) {
                        return false;
                    }
                }
            }
            return true;
        }
        for (Type a7 : implicitUpperBounds) {
            if (!m7434a(type, m7426a(a7, map), map)) {
                return false;
            }
        }
        for (Type a8 : implicitLowerBounds) {
            if (!m7434a(m7426a(a8, map), type, map)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m7435a(Type type, TypeVariable<?> typeVariable, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (typeVariable == null) {
            return false;
        }
        if (typeVariable.equals(type)) {
            return true;
        }
        if (type instanceof TypeVariable) {
            for (Type a : getImplicitBounds((TypeVariable) type)) {
                if (m7435a(a, typeVariable, map)) {
                    return true;
                }
            }
        }
        if ((type instanceof Class) || (type instanceof ParameterizedType) || (type instanceof GenericArrayType) || (type instanceof WildcardType)) {
            return false;
        }
        throw new IllegalStateException("found an unhandled type: " + type);
    }

    /* renamed from: a */
    private static Type m7426a(Type type, Map<TypeVariable<?>, Type> map) {
        if (!(type instanceof TypeVariable) || map == null) {
            return type;
        }
        Type type2 = map.get(type);
        if (type2 != null) {
            return type2;
        }
        throw new IllegalArgumentException("missing assignment type for type variable " + type);
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType parameterizedType) {
        return m7428a(parameterizedType, m7424a(parameterizedType), (Map<TypeVariable<?>, Type>) null);
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(Type type, Class<?> cls) {
        return m7429a(type, cls, (Map<TypeVariable<?>, Type>) null);
    }

    /* renamed from: a */
    private static Map<TypeVariable<?>, Type> m7429a(Type type, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        int i = 0;
        if (type instanceof Class) {
            return m7427a((Class<?>) (Class) type, cls, map);
        }
        if (type instanceof ParameterizedType) {
            return m7428a((ParameterizedType) type, cls, map);
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (cls.isArray()) {
                cls = cls.getComponentType();
            }
            return m7429a(genericComponentType, cls, map);
        } else if (type instanceof WildcardType) {
            Type[] implicitUpperBounds = getImplicitUpperBounds((WildcardType) type);
            int length = implicitUpperBounds.length;
            while (i < length) {
                Type type2 = implicitUpperBounds[i];
                if (m7431a(type2, cls)) {
                    return m7429a(type2, cls, map);
                }
                i++;
            }
            return null;
        } else if (type instanceof TypeVariable) {
            Type[] implicitBounds = getImplicitBounds((TypeVariable) type);
            int length2 = implicitBounds.length;
            while (i < length2) {
                Type type3 = implicitBounds[i];
                if (m7431a(type3, cls)) {
                    return m7429a(type3, cls, map);
                }
                i++;
            }
            return null;
        } else {
            throw new IllegalStateException("found an unhandled type: " + type);
        }
    }

    /* renamed from: a */
    private static Map<TypeVariable<?>, Type> m7428a(ParameterizedType parameterizedType, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        HashMap hashMap;
        Class<?> a = m7424a(parameterizedType);
        if (!m7431a((Type) a, cls)) {
            return null;
        }
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            ParameterizedType parameterizedType2 = (ParameterizedType) ownerType;
            hashMap = m7428a(parameterizedType2, m7424a(parameterizedType2), map);
        } else {
            hashMap = map == null ? new HashMap() : new HashMap(map);
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable[] typeParameters = a.getTypeParameters();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= typeParameters.length) {
                break;
            }
            Type type = actualTypeArguments[i2];
            TypeVariable typeVariable = typeParameters[i2];
            if (hashMap.containsKey(type)) {
                type = hashMap.get(type);
            }
            hashMap.put(typeVariable, type);
            i = i2 + 1;
        }
        return !cls.equals(a) ? m7429a(m7425a(a, cls), cls, hashMap) : hashMap;
    }

    /* renamed from: a */
    private static Map<TypeVariable<?>, Type> m7427a(Class<?> cls, Class<?> cls2, Map<TypeVariable<?>, Type> map) {
        if (!m7431a((Type) cls, cls2)) {
            return null;
        }
        if (cls.isPrimitive()) {
            if (cls2.isPrimitive()) {
                return new HashMap();
            }
            cls = ClassUtils.primitiveToWrapper(cls);
        }
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        if (cls.getTypeParameters().length > 0 || cls2.equals(cls)) {
            return hashMap;
        }
        return m7429a(m7425a(cls, cls2), cls2, (Map<TypeVariable<?>, Type>) hashMap);
    }

    public static Map<TypeVariable<?>, Type> determineTypeArguments(Class<?> cls, ParameterizedType parameterizedType) {
        Class<?> a = m7424a(parameterizedType);
        if (!m7431a((Type) cls, a)) {
            return null;
        }
        if (cls.equals(a)) {
            return m7428a(parameterizedType, a, (Map<TypeVariable<?>, Type>) null);
        }
        Type a2 = m7425a(cls, a);
        if (a2 instanceof Class) {
            return determineTypeArguments((Class) a2, parameterizedType);
        }
        ParameterizedType parameterizedType2 = (ParameterizedType) a2;
        Map<TypeVariable<?>, Type> determineTypeArguments = determineTypeArguments(m7424a(parameterizedType2), parameterizedType);
        m7430a(cls, parameterizedType2, determineTypeArguments);
        return determineTypeArguments;
    }

    /* renamed from: a */
    private static <T> void m7430a(Class<T> cls, ParameterizedType parameterizedType, Map<TypeVariable<?>, Type> map) {
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            m7430a(cls, (ParameterizedType) ownerType, map);
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable[] typeParameters = m7424a(parameterizedType).getTypeParameters();
        List asList = Arrays.asList(cls.getTypeParameters());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < actualTypeArguments.length) {
                TypeVariable typeVariable = typeParameters[i2];
                Type type = actualTypeArguments[i2];
                if (asList.contains(type) && map.containsKey(typeVariable)) {
                    map.put((TypeVariable) type, map.get(typeVariable));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static Type m7425a(Class<?> cls, Class<?> cls2) {
        Class<?> cls3;
        if (cls2.isInterface()) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            Type type = null;
            int length = genericInterfaces.length;
            int i = 0;
            while (i < length) {
                Type type2 = genericInterfaces[i];
                if (type2 instanceof ParameterizedType) {
                    cls3 = m7424a((ParameterizedType) type2);
                } else if (type2 instanceof Class) {
                    cls3 = (Class) type2;
                } else {
                    throw new IllegalStateException("Unexpected generic interface type found: " + type2);
                }
                if (!m7431a((Type) cls3, cls2) || !isAssignable(type, cls3)) {
                    type2 = type;
                }
                i++;
                type = type2;
            }
            if (type != null) {
                return type;
            }
        }
        return cls.getGenericSuperclass();
    }

    public static boolean isInstance(Object obj, Type type) {
        if (type == null) {
            return false;
        }
        if (obj != null) {
            return m7434a((Type) obj.getClass(), type, (Map<TypeVariable<?>, Type>) null);
        }
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return true;
        }
        return false;
    }

    public static Type[] normalizeUpperBounds(Type[] typeArr) {
        boolean z;
        if (typeArr.length < 2) {
            return typeArr;
        }
        HashSet hashSet = new HashSet(typeArr.length);
        for (Type type : typeArr) {
            int length = typeArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    Type type2 = typeArr[i];
                    if (type != type2 && m7434a(type2, type, (Map<TypeVariable<?>, Type>) null)) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                hashSet.add(type);
            }
        }
        return (Type[]) hashSet.toArray(new Type[hashSet.size()]);
    }

    public static Type[] getImplicitBounds(TypeVariable<?> typeVariable) {
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length != 0) {
            return normalizeUpperBounds(bounds);
        }
        return new Type[]{Object.class};
    }

    public static Type[] getImplicitUpperBounds(WildcardType wildcardType) {
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length != 0) {
            return normalizeUpperBounds(upperBounds);
        }
        return new Type[]{Object.class};
    }

    public static Type[] getImplicitLowerBounds(WildcardType wildcardType) {
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (lowerBounds.length != 0) {
            return lowerBounds;
        }
        return new Type[]{null};
    }

    public static boolean typesSatisfyVariables(Map<TypeVariable<?>, Type> map) {
        for (Map.Entry next : map.entrySet()) {
            Type type = (Type) next.getValue();
            Type[] implicitBounds = getImplicitBounds((TypeVariable) next.getKey());
            int length = implicitBounds.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (!m7434a(type, m7426a(implicitBounds[i], map), map)) {
                        return false;
                    }
                    i++;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    private static Class<?> m7424a(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        if (rawType instanceof Class) {
            return (Class) rawType;
        }
        throw new IllegalStateException("Wait... What!? Type of rawType: " + rawType);
    }

    public static Class<?> getRawType(Type type, Type type2) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return m7424a((ParameterizedType) type);
        }
        if (type instanceof TypeVariable) {
            if (type2 == null) {
                return null;
            }
            GenericDeclaration genericDeclaration = ((TypeVariable) type).getGenericDeclaration();
            if (!(genericDeclaration instanceof Class)) {
                return null;
            }
            Map<TypeVariable<?>, Type> typeArguments = getTypeArguments(type2, (Class) genericDeclaration);
            if (typeArguments == null) {
                return null;
            }
            Type type3 = typeArguments.get(type);
            if (type3 == null) {
                return null;
            }
            return getRawType(type3, type2);
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType(), type2), 0).getClass();
        } else {
            if (type instanceof WildcardType) {
                return null;
            }
            throw new IllegalArgumentException("unknown type: " + type);
        }
    }

    public static boolean isArrayType(Type type) {
        return (type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray());
    }

    public static Type getArrayComponentType(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return cls.getComponentType();
            }
            return null;
        } else if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        } else {
            return null;
        }
    }
}
