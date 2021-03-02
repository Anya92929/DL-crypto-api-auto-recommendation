package com.google.gson.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import org.apache.cordova.Globalization;

public abstract class TypeToken<T> {
    final Class<? super T> rawType;
    final Type type;

    protected TypeToken() {
        this.type = getSuperclassTypeParameter(getClass());
        this.rawType = getRawType(this.type);
    }

    private TypeToken(Type type2) {
        this.rawType = getRawType((Type) nonNull(type2, Globalization.TYPE));
        this.type = type2;
    }

    private static <T> T nonNull(T o, String message) {
        if (o != null) {
            return o;
        }
        throw new NullPointerException(message);
    }

    static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (!(superclass instanceof Class)) {
            return ((ParameterizedType) superclass).getActualTypeArguments()[0];
        }
        throw new RuntimeException("Missing type parameter.");
    }

    static TypeToken<?> fromSuperclassTypeParameter(Class<?> subclass) {
        return new SimpleTypeToken(subclass);
    }

    private static Class<?> getRawType(Type type2) {
        if (type2 instanceof Class) {
            return (Class) type2;
        }
        if (type2 instanceof ParameterizedType) {
            Type rawType2 = ((ParameterizedType) type2).getRawType();
            if (rawType2 instanceof Class) {
                return (Class) rawType2;
            }
            throw buildUnexpectedTypeError(rawType2, Class.class);
        } else if (type2 instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type2).getGenericComponentType()), 0).getClass();
        } else {
            throw buildUnexpectedTypeError(type2, ParameterizedType.class, GenericArrayType.class);
        }
    }

    public Class<? super T> getRawType() {
        return this.rawType;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    public boolean isAssignableFrom(Type from) {
        if (from == null) {
            return false;
        }
        if (this.type.equals(from)) {
            return true;
        }
        if (this.type instanceof Class) {
            return this.rawType.isAssignableFrom(getRawType(from));
        }
        if (this.type instanceof ParameterizedType) {
            return isAssignableFrom(from, (ParameterizedType) this.type, new HashMap());
        }
        if (this.type instanceof GenericArrayType) {
            return this.rawType.isAssignableFrom(getRawType(from)) && isAssignableFrom(from, (GenericArrayType) this.type);
        }
        throw buildUnexpectedTypeError(this.type, Class.class, ParameterizedType.class, GenericArrayType.class);
    }

    public boolean isAssignableFrom(TypeToken<?> token) {
        return isAssignableFrom(token.getType());
    }

    private static boolean isAssignableFrom(Type from, GenericArrayType to) {
        Type toGenericComponentType = to.getGenericComponentType();
        if (!(toGenericComponentType instanceof ParameterizedType)) {
            return true;
        }
        Type t = from;
        if (from instanceof GenericArrayType) {
            t = ((GenericArrayType) from).getGenericComponentType();
        } else if (from instanceof Class) {
            Class<?> classType = (Class) from;
            while (classType.isArray()) {
                classType = classType.getComponentType();
            }
            t = classType;
        }
        return isAssignableFrom(t, (ParameterizedType) toGenericComponentType, new HashMap());
    }

    private static boolean isAssignableFrom(Type from, ParameterizedType to, Map<String, Type> typeVarMap) {
        if (from == null) {
            return false;
        }
        if (to.equals(from)) {
            return true;
        }
        Class<?> clazz = getRawType(from);
        ParameterizedType ptype = null;
        if (from instanceof ParameterizedType) {
            ptype = (ParameterizedType) from;
        }
        if (ptype != null) {
            Type[] tArgs = ptype.getActualTypeArguments();
            TypeVariable<?>[] tParams = clazz.getTypeParameters();
            for (int i = 0; i < tArgs.length; i++) {
                Type arg = tArgs[i];
                TypeVariable<?> var = tParams[i];
                while (arg instanceof TypeVariable) {
                    arg = typeVarMap.get(((TypeVariable) arg).getName());
                }
                typeVarMap.put(var.getName(), arg);
            }
            if (typeEquals(ptype, to, typeVarMap)) {
                return true;
            }
        }
        for (Type itype : clazz.getGenericInterfaces()) {
            if (isAssignableFrom(itype, to, new HashMap(typeVarMap))) {
                return true;
            }
        }
        if (isAssignableFrom(clazz.getGenericSuperclass(), to, new HashMap(typeVarMap))) {
            return true;
        }
        return false;
    }

    private static boolean typeEquals(ParameterizedType from, ParameterizedType to, Map<String, Type> typeVarMap) {
        if (!from.getRawType().equals(to.getRawType())) {
            return false;
        }
        Type[] fromArgs = from.getActualTypeArguments();
        Type[] toArgs = to.getActualTypeArguments();
        for (int i = 0; i < fromArgs.length; i++) {
            if (!matches(fromArgs[i], toArgs[i], typeVarMap)) {
                return false;
            }
        }
        return true;
    }

    private static boolean matches(Type from, Type to, Map<String, Type> typeMap) {
        if (to.equals(from)) {
            return true;
        }
        if (from instanceof TypeVariable) {
            return to.equals(typeMap.get(((TypeVariable) from).getName()));
        }
        return false;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TypeToken)) {
            return false;
        }
        return this.type.equals(((TypeToken) o).type);
    }

    public String toString() {
        return this.type instanceof Class ? ((Class) this.type).getName() : this.type.toString();
    }

    private static AssertionError buildUnexpectedTypeError(Type token, Class<?>... expected) {
        StringBuilder exceptionMessage = new StringBuilder("Unexpected type. Expected one of: ");
        for (Class<?> clazz : expected) {
            exceptionMessage.append(clazz.getName()).append(", ");
        }
        exceptionMessage.append("but got: ").append(token.getClass().getName()).append(", for type token: ").append(token.toString()).append('.');
        return new AssertionError(exceptionMessage.toString());
    }

    public static TypeToken<?> get(Type type2) {
        return new SimpleTypeToken(type2);
    }

    public static <T> TypeToken<T> get(Class<T> type2) {
        return new SimpleTypeToken(type2);
    }

    private static class SimpleTypeToken<T> extends TypeToken<T> {
        public SimpleTypeToken(Type type) {
            super(type);
        }
    }
}
