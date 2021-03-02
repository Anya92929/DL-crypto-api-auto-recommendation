package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* renamed from: com.google.gson.internal.$Gson$Types  reason: invalid class name */
public final class C$Gson$Types {

    /* renamed from: a */
    static final Type[] f3652a = new Type[0];

    private C$Gson$Types() {
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        return new C0909b(type, type2, typeArr);
    }

    public static GenericArrayType arrayOf(Type type) {
        return new C0908a(type);
    }

    public static WildcardType subtypeOf(Type type) {
        return new C0910c(new Type[]{type}, f3652a);
    }

    public static WildcardType supertypeOf(Type type) {
        return new C0910c(new Type[]{Object.class}, new Type[]{type});
    }

    public static Type canonicalize(Type type) {
        Type type2;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                type2 = new C0908a(canonicalize(cls.getComponentType()));
            } else {
                type2 = cls;
            }
            return type2;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0909b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new C0908a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new C0910c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static Class<?> getRawType(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C$Gson$Preconditions.checkArgument(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return getRawType(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    /* renamed from: a */
    static boolean m4281a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean equals(Type type, Type type2) {
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
            if (!m4281a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
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
    public static int m4282b(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* renamed from: a */
    static Type m4278a(Type type, Class<?> cls, Class<?> cls2) {
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
                    return m4278a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
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
                    return m4278a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* renamed from: b */
    static Type m4283b(Type type, Class<?> cls, Class<?> cls2) {
        C$Gson$Preconditions.checkArgument(cls2.isAssignableFrom(cls));
        return resolve(type, cls, m4278a(type, cls, cls2));
    }

    public static Type getArrayComponentType(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type getCollectionElementType(Type type, Class<?> cls) {
        Type b = m4283b(type, cls, Collection.class);
        if (b instanceof WildcardType) {
            b = ((WildcardType) b).getUpperBounds()[0];
        }
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type[] getMapKeyAndValueTypes(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b = m4283b(type, cls, Map.class);
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        Type resolve;
        boolean z;
        while (true) {
            Type type3 = type2;
            if (type3 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type3;
                type2 = m4279a(type, cls, (TypeVariable<?>) typeVariable);
                if (type2 == typeVariable) {
                    return type2;
                }
            } else if ((type3 instanceof Class) && ((Class) type3).isArray()) {
                Class cls2 = (Class) type3;
                Class<?> componentType = cls2.getComponentType();
                Type resolve2 = resolve(type, cls, componentType);
                if (componentType != resolve2) {
                    return arrayOf(resolve2);
                }
                return cls2;
            } else if (type3 instanceof GenericArrayType) {
                GenericArrayType genericArrayType = (GenericArrayType) type3;
                Type genericComponentType = genericArrayType.getGenericComponentType();
                Type resolve3 = resolve(type, cls, genericComponentType);
                if (genericComponentType != resolve3) {
                    return arrayOf(resolve3);
                }
                return genericArrayType;
            } else if (type3 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type3;
                Type ownerType = parameterizedType.getOwnerType();
                Type resolve4 = resolve(type, cls, ownerType);
                if (resolve4 != ownerType) {
                    z = true;
                } else {
                    z = false;
                }
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments.length;
                boolean z2 = z;
                Type[] typeArr = actualTypeArguments;
                for (int i = 0; i < length; i++) {
                    Type resolve5 = resolve(type, cls, typeArr[i]);
                    if (resolve5 != typeArr[i]) {
                        if (!z2) {
                            typeArr = (Type[]) typeArr.clone();
                            z2 = true;
                        }
                        typeArr[i] = resolve5;
                    }
                }
                if (z2) {
                    return newParameterizedTypeWithOwner(resolve4, parameterizedType.getRawType(), typeArr);
                }
                return parameterizedType;
            } else if (!(type3 instanceof WildcardType)) {
                return type3;
            } else {
                WildcardType wildcardType = (WildcardType) type3;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] upperBounds = wildcardType.getUpperBounds();
                if (lowerBounds.length == 1) {
                    Type resolve6 = resolve(type, cls, lowerBounds[0]);
                    if (resolve6 != lowerBounds[0]) {
                        return supertypeOf(resolve6);
                    }
                    return wildcardType;
                } else if (upperBounds.length != 1 || (resolve = resolve(type, cls, upperBounds[0])) == upperBounds[0]) {
                    return wildcardType;
                } else {
                    return subtypeOf(resolve);
                }
            }
        }
    }

    /* renamed from: a */
    static Type m4279a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> a = m4277a(typeVariable);
        if (a == null) {
            return typeVariable;
        }
        Type a2 = m4278a(type, cls, a);
        if (!(a2 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) a2).getActualTypeArguments()[m4276a((Object[]) a.getTypeParameters(), (Object) typeVariable)];
    }

    /* renamed from: a */
    private static int m4276a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    private static Class<?> m4277a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m4284b(Type type) {
        C$Gson$Preconditions.checkArgument(!(type instanceof Class) || !((Class) type).isPrimitive());
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$b */
    static final class C0909b implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;

        /* renamed from: a */
        private final Type f3654a;

        /* renamed from: b */
        private final Type f3655b;

        /* renamed from: c */
        private final Type[] f3656c;

        public C0909b(Type type, Type type2, Type... typeArr) {
            boolean z;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type != null || z2) {
                    z = true;
                } else {
                    z = false;
                }
                C$Gson$Preconditions.checkArgument(z);
            }
            this.f3654a = type == null ? null : C$Gson$Types.canonicalize(type);
            this.f3655b = C$Gson$Types.canonicalize(type2);
            this.f3656c = (Type[]) typeArr.clone();
            for (int i = 0; i < this.f3656c.length; i++) {
                C$Gson$Preconditions.checkNotNull(this.f3656c[i]);
                C$Gson$Types.m4284b(this.f3656c[i]);
                this.f3656c[i] = C$Gson$Types.canonicalize(this.f3656c[i]);
            }
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.f3656c.clone();
        }

        public Type getRawType() {
            return this.f3655b;
        }

        public Type getOwnerType() {
            return this.f3654a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C$Gson$Types.equals(this, (ParameterizedType) obj);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f3656c) ^ this.f3655b.hashCode()) ^ C$Gson$Types.m4282b((Object) this.f3654a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.f3656c.length + 1) * 30);
            sb.append(C$Gson$Types.typeToString(this.f3655b));
            if (this.f3656c.length == 0) {
                return sb.toString();
            }
            sb.append("<").append(C$Gson$Types.typeToString(this.f3656c[0]));
            for (int i = 1; i < this.f3656c.length; i++) {
                sb.append(", ").append(C$Gson$Types.typeToString(this.f3656c[i]));
            }
            return sb.append(">").toString();
        }
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$a */
    static final class C0908a implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;

        /* renamed from: a */
        private final Type f3653a;

        public C0908a(Type type) {
            this.f3653a = C$Gson$Types.canonicalize(type);
        }

        public Type getGenericComponentType() {
            return this.f3653a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C$Gson$Types.equals(this, (GenericArrayType) obj);
        }

        public int hashCode() {
            return this.f3653a.hashCode();
        }

        public String toString() {
            return C$Gson$Types.typeToString(this.f3653a) + "[]";
        }
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$c */
    static final class C0910c implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;

        /* renamed from: a */
        private final Type f3657a;

        /* renamed from: b */
        private final Type f3658b;

        public C0910c(Type[] typeArr, Type[] typeArr2) {
            boolean z;
            boolean z2 = true;
            C$Gson$Preconditions.checkArgument(typeArr2.length <= 1);
            if (typeArr.length == 1) {
                z = true;
            } else {
                z = false;
            }
            C$Gson$Preconditions.checkArgument(z);
            if (typeArr2.length == 1) {
                C$Gson$Preconditions.checkNotNull(typeArr2[0]);
                C$Gson$Types.m4284b(typeArr2[0]);
                C$Gson$Preconditions.checkArgument(typeArr[0] != Object.class ? false : z2);
                this.f3658b = C$Gson$Types.canonicalize(typeArr2[0]);
                this.f3657a = Object.class;
                return;
            }
            C$Gson$Preconditions.checkNotNull(typeArr[0]);
            C$Gson$Types.m4284b(typeArr[0]);
            this.f3658b = null;
            this.f3657a = C$Gson$Types.canonicalize(typeArr[0]);
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.f3657a};
        }

        public Type[] getLowerBounds() {
            if (this.f3658b == null) {
                return C$Gson$Types.f3652a;
            }
            return new Type[]{this.f3658b};
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C$Gson$Types.equals(this, (WildcardType) obj);
        }

        public int hashCode() {
            return (this.f3658b != null ? this.f3658b.hashCode() + 31 : 1) ^ (this.f3657a.hashCode() + 31);
        }

        public String toString() {
            if (this.f3658b != null) {
                return "? super " + C$Gson$Types.typeToString(this.f3658b);
            }
            if (this.f3657a == Object.class) {
                return "?";
            }
            return "? extends " + C$Gson$Types.typeToString(this.f3657a);
        }
    }
}
