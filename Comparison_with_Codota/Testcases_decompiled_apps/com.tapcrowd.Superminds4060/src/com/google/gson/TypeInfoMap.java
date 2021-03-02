package com.google.gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Properties;

final class TypeInfoMap {
    private final Type keyType;
    private final Type valueType;

    public TypeInfoMap(Type mapType) {
        if ((mapType instanceof Class) && Properties.class.isAssignableFrom((Class) mapType)) {
            this.keyType = String.class;
            this.valueType = String.class;
        } else if (mapType instanceof ParameterizedType) {
            Preconditions.checkArgument(Map.class.isAssignableFrom(new TypeInfo(mapType).getRawClass()));
            ParameterizedType paramType = (ParameterizedType) mapType;
            this.keyType = paramType.getActualTypeArguments()[0];
            this.valueType = paramType.getActualTypeArguments()[1];
        } else {
            throw new IllegalArgumentException("Map objects need to be parameterized unless you use a custom serializer. Use the com.google.gson.reflect.TypeToken to extract the ParameterizedType.");
        }
    }

    public Type getKeyType() {
        return this.keyType;
    }

    public Type getValueType() {
        return this.valueType;
    }
}
