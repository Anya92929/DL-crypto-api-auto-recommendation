package com.google.gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class ParameterizedTypeImpl implements ParameterizedType {
    private final Type[] actualTypeArguments;
    private final Type owner;
    private final Type rawType;

    public ParameterizedTypeImpl(Type rawType2, Type[] actualTypeArguments2, Type owner2) {
        this.rawType = rawType2;
        this.actualTypeArguments = actualTypeArguments2;
        this.owner = owner2;
    }

    public Type getRawType() {
        return this.rawType;
    }

    public Type[] getActualTypeArguments() {
        return this.actualTypeArguments;
    }

    public Type getOwnerType() {
        return this.owner;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType that = (ParameterizedType) o;
        if (this == that) {
            return true;
        }
        Type thatOwner = that.getOwnerType();
        Type thatRawType = that.getRawType();
        if (this.owner != null ? this.owner.equals(thatOwner) : thatOwner == null) {
            if (this.rawType != null ? this.rawType.equals(thatRawType) : thatRawType == null) {
                if (Arrays.equals(this.actualTypeArguments, that.getActualTypeArguments())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.owner == null ? 0 : this.owner.hashCode()) ^ Arrays.hashCode(this.actualTypeArguments);
        if (this.rawType != null) {
            i = this.rawType.hashCode();
        }
        return hashCode ^ i;
    }
}
