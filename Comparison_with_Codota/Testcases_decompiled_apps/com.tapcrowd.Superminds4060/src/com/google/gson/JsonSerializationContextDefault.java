package com.google.gson;

import java.lang.reflect.Type;

final class JsonSerializationContextDefault implements JsonSerializationContext {
    private final MemoryRefStack ancestors = new MemoryRefStack();
    private final ObjectNavigatorFactory factory;
    private final boolean serializeNulls;
    private final ParameterizedTypeHandlerMap<JsonSerializer<?>> serializers;

    JsonSerializationContextDefault(ObjectNavigatorFactory factory2, boolean serializeNulls2, ParameterizedTypeHandlerMap<JsonSerializer<?>> serializers2) {
        this.factory = factory2;
        this.serializeNulls = serializeNulls2;
        this.serializers = serializers2;
    }

    public JsonElement serialize(Object src) {
        if (src == null) {
            return JsonNull.createJsonNull();
        }
        return serialize(src, src.getClass(), true);
    }

    public JsonElement serialize(Object src, Type typeOfSrc) {
        return serialize(src, typeOfSrc, true);
    }

    public JsonElement serialize(Object src, Type typeOfSrc, boolean preserveType) {
        ObjectNavigator on = this.factory.create(new ObjectTypePair(src, typeOfSrc, preserveType));
        JsonSerializationVisitor visitor = new JsonSerializationVisitor(this.factory, this.serializeNulls, this.serializers, this, this.ancestors);
        on.accept(visitor);
        return visitor.getJsonElement();
    }
}
