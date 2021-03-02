package com.google.gson;

import java.lang.reflect.Type;

final class JsonDeserializationContextDefault implements JsonDeserializationContext {
    private final ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers;
    private final ObjectNavigatorFactory navigatorFactory;
    private final MappedObjectConstructor objectConstructor;

    JsonDeserializationContextDefault(ObjectNavigatorFactory navigatorFactory2, ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers2, MappedObjectConstructor objectConstructor2) {
        this.navigatorFactory = navigatorFactory2;
        this.deserializers = deserializers2;
        this.objectConstructor = objectConstructor2;
    }

    /* access modifiers changed from: package-private */
    public ObjectConstructor getObjectConstructor() {
        return this.objectConstructor;
    }

    public <T> T deserialize(JsonElement json, Type typeOfT) throws JsonParseException {
        if (json == null || json.isJsonNull()) {
            return null;
        }
        if (json.isJsonArray()) {
            return fromJsonArray(typeOfT, json.getAsJsonArray(), this);
        }
        if (json.isJsonObject()) {
            return fromJsonObject(typeOfT, json.getAsJsonObject(), this);
        }
        if (json.isJsonPrimitive()) {
            return fromJsonPrimitive(typeOfT, json.getAsJsonPrimitive(), this);
        }
        throw new JsonParseException("Failed parsing JSON source: " + json + " to Json");
    }

    private <T> T fromJsonArray(Type arrayType, JsonArray jsonArray, JsonDeserializationContext context) throws JsonParseException {
        JsonArrayDeserializationVisitor<T> visitor = new JsonArrayDeserializationVisitor<>(jsonArray, arrayType, this.navigatorFactory, this.objectConstructor, this.deserializers, context);
        this.navigatorFactory.create(new ObjectTypePair((Object) null, arrayType, true)).accept(visitor);
        return visitor.getTarget();
    }

    private <T> T fromJsonObject(Type typeOfT, JsonObject jsonObject, JsonDeserializationContext context) throws JsonParseException {
        JsonObjectDeserializationVisitor<T> visitor = new JsonObjectDeserializationVisitor<>(jsonObject, typeOfT, this.navigatorFactory, this.objectConstructor, this.deserializers, context);
        this.navigatorFactory.create(new ObjectTypePair((Object) null, typeOfT, true)).accept(visitor);
        return visitor.getTarget();
    }

    private <T> T fromJsonPrimitive(Type typeOfT, JsonPrimitive json, JsonDeserializationContext context) throws JsonParseException {
        JsonObjectDeserializationVisitor<T> visitor = new JsonObjectDeserializationVisitor<>(json, typeOfT, this.navigatorFactory, this.objectConstructor, this.deserializers, context);
        this.navigatorFactory.create(new ObjectTypePair(json.getAsObject(), typeOfT, true)).accept(visitor);
        return visitor.getTarget();
    }
}
