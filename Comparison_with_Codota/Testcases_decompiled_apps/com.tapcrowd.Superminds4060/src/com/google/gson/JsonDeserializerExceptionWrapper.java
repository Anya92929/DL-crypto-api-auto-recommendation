package com.google.gson;

import java.lang.reflect.Type;

class JsonDeserializerExceptionWrapper<T> implements JsonDeserializer<T> {
    private final JsonDeserializer<T> delegate;

    JsonDeserializerExceptionWrapper(JsonDeserializer<T> delegate2) {
        Preconditions.checkNotNull(delegate2);
        this.delegate = delegate2;
    }

    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            return this.delegate.deserialize(json, typeOfT, context);
        } catch (JsonParseException e) {
            throw e;
        } catch (Exception e2) {
            throw new JsonParseException("The JsonDeserializer " + this.delegate + " failed to deserialized json object " + json + " given the type " + typeOfT, e2);
        }
    }

    public String toString() {
        return this.delegate.toString();
    }
}
