package com.google.gson;

import java.lang.reflect.Type;
import java.util.Collection;

class TypeInfo {
    protected final Type actualType;
    protected final Class<?> rawClass;

    TypeInfo(Type actualType2) {
        this.actualType = actualType2;
        this.rawClass = TypeUtils.toRawClass(actualType2);
    }

    public final Type getActualType() {
        return this.actualType;
    }

    public final Class<?> getWrappedClass() {
        return Primitives.wrap(this.rawClass);
    }

    public final Class<?> getRawClass() {
        return this.rawClass;
    }

    public final boolean isCollectionOrArray() {
        return Collection.class.isAssignableFrom(this.rawClass) || isArray();
    }

    public final boolean isArray() {
        return TypeUtils.isArray(this.rawClass);
    }

    public final boolean isEnum() {
        return this.rawClass.isEnum();
    }

    public final boolean isPrimitive() {
        return Primitives.isWrapperType(Primitives.wrap(this.rawClass));
    }
}
