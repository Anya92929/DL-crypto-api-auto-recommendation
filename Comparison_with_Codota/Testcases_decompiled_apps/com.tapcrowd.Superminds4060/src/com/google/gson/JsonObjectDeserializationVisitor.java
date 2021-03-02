package com.google.gson;

import java.lang.reflect.Type;

final class JsonObjectDeserializationVisitor<T> extends JsonDeserializationVisitor<T> {
    JsonObjectDeserializationVisitor(JsonElement json, Type type, ObjectNavigatorFactory factory, ObjectConstructor objectConstructor, ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers, JsonDeserializationContext context) {
        super(json, type, factory, objectConstructor, deserializers, context);
    }

    /* access modifiers changed from: protected */
    public T constructTarget() {
        return this.objectConstructor.construct(this.targetType);
    }

    public void startVisitingObject(Object node) {
    }

    public void visitArray(Object array, Type componentType) {
        throw new JsonParseException("Expecting object but found array: " + array);
    }

    public void visitObjectField(FieldAttributes f, Type typeOfF, Object obj) {
        try {
            if (!this.json.isJsonObject()) {
                throw new JsonParseException("Expecting object found: " + this.json);
            }
            JsonElement jsonChild = this.json.getAsJsonObject().get(getFieldName(f));
            if (jsonChild != null) {
                f.set(obj, visitChildAsObject(typeOfF, jsonChild));
            } else {
                f.set(obj, (Object) null);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void visitArrayField(FieldAttributes f, Type typeOfF, Object obj) {
        try {
            if (!this.json.isJsonObject()) {
                throw new JsonParseException("Expecting object found: " + this.json);
            }
            JsonArray jsonChild = (JsonArray) this.json.getAsJsonObject().get(getFieldName(f));
            if (jsonChild != null) {
                f.set(obj, visitChildAsArray(typeOfF, jsonChild));
            } else {
                f.set(obj, (Object) null);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFieldName(FieldAttributes f) {
        return this.factory.getFieldNamingPolicy().translateName(f);
    }

    public boolean visitFieldUsingCustomHandler(FieldAttributes f, Type declaredTypeOfField, Object parent) {
        try {
            String fName = getFieldName(f);
            if (!this.json.isJsonObject()) {
                throw new JsonParseException("Expecting object found: " + this.json);
            }
            JsonElement child = this.json.getAsJsonObject().get(fName);
            TypeInfo typeInfo = new TypeInfo(declaredTypeOfField);
            if (child == null) {
                return true;
            }
            if (!child.isJsonNull()) {
                Pair<JsonDeserializer<?>, ObjectTypePair> pair = new ObjectTypePair((Object) null, declaredTypeOfField, false).getMatchingHandler(this.deserializers);
                if (pair == null) {
                    return false;
                }
                Object value = invokeCustomDeserializer(child, pair);
                if (value == null && typeInfo.isPrimitive()) {
                    return true;
                }
                f.set(parent, value);
                return true;
            } else if (typeInfo.isPrimitive()) {
                return true;
            } else {
                f.set(parent, (Object) null);
                return true;
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        }
    }

    public void visitPrimitive(Object primitive) {
        if (!this.json.isJsonPrimitive()) {
            throw new JsonParseException("Type information is unavailable, and the target object is not a primitive: " + this.json);
        }
        this.target = this.json.getAsJsonPrimitive().getAsObject();
    }
}
