package com.google.gson;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

final class JsonArrayDeserializationVisitor<T> extends JsonDeserializationVisitor<T> {
    JsonArrayDeserializationVisitor(JsonArray jsonArray, Type arrayType, ObjectNavigatorFactory factory, ObjectConstructor objectConstructor, ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers, JsonDeserializationContext context) {
        super(jsonArray, arrayType, factory, objectConstructor, deserializers, context);
    }

    /* access modifiers changed from: protected */
    public T constructTarget() {
        TypeInfo typeInfo = new TypeInfo(this.targetType);
        if (!this.json.isJsonArray()) {
            throw new JsonParseException("Expecting array found: " + this.json);
        }
        JsonArray jsonArray = this.json.getAsJsonArray();
        if (!typeInfo.isArray()) {
            return this.objectConstructor.construct(typeInfo.getRawClass());
        }
        return this.objectConstructor.constructArray(TypeInfoFactory.getTypeInfoForArray(this.targetType).getSecondLevelType(), jsonArray.size());
    }

    public void visitArray(Object array, Type arrayType) {
        Object obj;
        if (!this.json.isJsonArray()) {
            throw new JsonParseException("Expecting array found: " + this.json);
        }
        JsonArray jsonArray = this.json.getAsJsonArray();
        TypeInfoArray arrayTypeInfo = TypeInfoFactory.getTypeInfoForArray(arrayType);
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonElement jsonChild = jsonArray.get(i);
            if (jsonChild == null || jsonChild.isJsonNull()) {
                obj = null;
            } else if (jsonChild instanceof JsonObject) {
                obj = visitChildAsObject(arrayTypeInfo.getComponentRawType(), jsonChild);
            } else if (jsonChild instanceof JsonArray) {
                obj = visitChildAsArray(arrayTypeInfo.getSecondLevelType(), jsonChild.getAsJsonArray());
            } else if (jsonChild instanceof JsonPrimitive) {
                obj = visitChildAsObject(arrayTypeInfo.getComponentRawType(), jsonChild.getAsJsonPrimitive());
            } else {
                throw new IllegalStateException();
            }
            Array.set(array, i, obj);
        }
    }

    public void startVisitingObject(Object node) {
        throw new JsonParseException("Expecting array but found object: " + node);
    }

    public void visitArrayField(FieldAttributes f, Type typeOfF, Object obj) {
        throw new JsonParseException("Expecting array but found array field " + f.getName() + ": " + obj);
    }

    public void visitObjectField(FieldAttributes f, Type typeOfF, Object obj) {
        throw new JsonParseException("Expecting array but found object field " + f.getName() + ": " + obj);
    }

    public boolean visitFieldUsingCustomHandler(FieldAttributes f, Type actualTypeOfField, Object parent) {
        throw new JsonParseException("Expecting array but found field " + f.getName() + ": " + parent);
    }

    public void visitPrimitive(Object primitive) {
        throw new JsonParseException("Type information is unavailable, and the target is not a primitive: " + this.json);
    }
}
