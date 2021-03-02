package com.google.gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

final class TypeInfoCollection {
    private final ParameterizedType collectionType;

    public TypeInfoCollection(Type collectionType2) {
        if (!(collectionType2 instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Collection objects need to be parameterized unless you use a custom serializer. Use the com.google.gson.reflect.TypeToken to extract the ParameterizedType.");
        }
        Preconditions.checkArgument(Collection.class.isAssignableFrom(new TypeInfo(collectionType2).getRawClass()));
        this.collectionType = (ParameterizedType) collectionType2;
    }

    public Type getElementType() {
        return this.collectionType.getActualTypeArguments()[0];
    }
}
