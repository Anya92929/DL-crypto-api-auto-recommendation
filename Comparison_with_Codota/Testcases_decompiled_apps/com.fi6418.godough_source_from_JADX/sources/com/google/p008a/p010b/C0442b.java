package com.google.p008a.p010b;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* renamed from: com.google.a.b.b */
public final class C0442b {

    /* renamed from: a */
    static final Type[] f3515a = new Type[0];

    /* renamed from: a */
    private static int m2731a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    private static Class<?> m2732a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* renamed from: a */
    public static GenericArrayType m2733a(Type type) {
        return new C0443c(type);
    }

    /* renamed from: a */
    public static ParameterizedType m2734a(Type type, Type type2, Type... typeArr) {
        return new C0444d(type, type2, typeArr);
    }

    /* renamed from: a */
    public static Type m2735a(Type type, Class<?> cls) {
        Type b = m2742b(type, cls, Collection.class);
        if (b instanceof WildcardType) {
            b = ((WildcardType) b).getUpperBounds()[0];
        }
        return b instanceof ParameterizedType ? ((ParameterizedType) b).getActualTypeArguments()[0] : Object.class;
    }

    /* renamed from: a */
    static Type m2736a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return m2736a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return m2736a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* renamed from: a */
    public static Type m2737a(Type type, Class<?> cls, Type type2) {
        Type a;
        while (true) {
            Type type3 = type2;
            if (type3 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type3;
                type2 = m2738a(type, cls, (TypeVariable<?>) typeVariable);
                if (type2 == typeVariable) {
                    return type2;
                }
            } else if ((type3 instanceof Class) && ((Class) type3).isArray()) {
                Class cls2 = (Class) type3;
                Class<?> componentType = cls2.getComponentType();
                Type a2 = m2737a(type, cls, (Type) componentType);
                return componentType != a2 ? m2733a(a2) : cls2;
            } else if (type3 instanceof GenericArrayType) {
                GenericArrayType genericArrayType = (GenericArrayType) type3;
                Type genericComponentType = genericArrayType.getGenericComponentType();
                Type a3 = m2737a(type, cls, genericComponentType);
                return genericComponentType != a3 ? m2733a(a3) : genericArrayType;
            } else if (type3 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type3;
                Type ownerType = parameterizedType.getOwnerType();
                Type a4 = m2737a(type, cls, ownerType);
                boolean z = a4 != ownerType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments.length;
                boolean z2 = z;
                Type[] typeArr = actualTypeArguments;
                for (int i = 0; i < length; i++) {
                    Type a5 = m2737a(type, cls, typeArr[i]);
                    if (a5 != typeArr[i]) {
                        if (!z2) {
                            typeArr = (Type[]) typeArr.clone();
                            z2 = true;
                        }
                        typeArr[i] = a5;
                    }
                }
                return z2 ? m2734a(a4, parameterizedType.getRawType(), typeArr) : parameterizedType;
            } else if (!(type3 instanceof WildcardType)) {
                return type3;
            } else {
                WildcardType wildcardType = (WildcardType) type3;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] upperBounds = wildcardType.getUpperBounds();
                if (lowerBounds.length != 1) {
                    return (upperBounds.length != 1 || (a = m2737a(type, cls, upperBounds[0])) == upperBounds[0]) ? wildcardType : m2743b(a);
                }
                Type a6 = m2737a(type, cls, lowerBounds[0]);
                return a6 != lowerBounds[0] ? m2745c(a6) : wildcardType;
            }
        }
    }

    /* renamed from: a */
    static Type m2738a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> a = m2732a(typeVariable);
        if (a == null) {
            return typeVariable;
        }
        Type a2 = m2736a(type, cls, a);
        if (!(a2 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) a2).getActualTypeArguments()[m2731a((Object[]) a.getTypeParameters(), (Object) typeVariable)];
    }

    /* renamed from: a */
    static boolean m2739a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static boolean m2740a(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!m2739a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return m2740a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                z = false;
            }
            return z;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                z = false;
            }
            return z;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m2741b(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: b */
    static Type m2742b(Type type, Class<?> cls, Class<?> cls2) {
        C0366a.m2512a(cls2.isAssignableFrom(cls));
        return m2737a(type, cls, m2736a(type, cls, cls2));
    }

    /* renamed from: b */
    public static WildcardType m2743b(Type type) {
        return new C0445e(new Type[]{type}, f3515a);
    }

    /* renamed from: b */
    public static Type[] m2744b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b = m2742b(type, cls, Map.class);
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    /* renamed from: c */
    public static WildcardType m2745c(Type type) {
        return new C0445e(new Type[]{Object.class}, new Type[]{type});
    }

    /* renamed from: d */
    public static Type m2746d(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new C0443c(m2746d(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0444d(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new C0443c(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new C0445e(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    /* renamed from: e */
    public static Class<?> m2747e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C0366a.m2512a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(m2747e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return m2747e(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    /* renamed from: f */
    public static String m2748f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* renamed from: g */
    public static Type m2749g(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static void m2751i(Type type) {
        C0366a.m2512a(!(type instanceof Class) || !((Class) type).isPrimitive());
    }
}
