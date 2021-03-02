package com.google.gson;

import com.google.gson.annotations.SerializedName;

final class SerializedNameAnnotationInterceptingNamingPolicy implements FieldNamingStrategy2 {
    private static final JsonFieldNameValidator fieldNameValidator = new JsonFieldNameValidator();
    private final FieldNamingStrategy2 delegate;

    public SerializedNameAnnotationInterceptingNamingPolicy(FieldNamingStrategy2 delegate2) {
        this.delegate = delegate2;
    }

    public String translateName(FieldAttributes f) {
        Preconditions.checkNotNull(f);
        SerializedName serializedName = (SerializedName) f.getAnnotation(SerializedName.class);
        return serializedName == null ? this.delegate.translateName(f) : fieldNameValidator.validate(serializedName.value());
    }
}
