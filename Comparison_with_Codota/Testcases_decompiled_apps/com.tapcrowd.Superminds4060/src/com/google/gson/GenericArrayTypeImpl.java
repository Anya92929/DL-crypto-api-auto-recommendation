package com.google.gson;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class GenericArrayTypeImpl implements GenericArrayType {
    private final Type genericComponentType;

    public GenericArrayTypeImpl(Type genericComponentType2) {
        this.genericComponentType = genericComponentType2;
    }

    public Type getGenericComponentType() {
        return this.genericComponentType;
    }

    public boolean equals(Object o) {
        if (!(o instanceof GenericArrayType)) {
            return false;
        }
        Type thatComponentType = ((GenericArrayType) o).getGenericComponentType();
        if (this.genericComponentType != null) {
            return this.genericComponentType.equals(thatComponentType);
        }
        if (thatComponentType == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.genericComponentType == null) {
            return 0;
        }
        return this.genericComponentType.hashCode();
    }
}
