package com.google.gson;

import com.google.gson.ObjectNavigator;
import java.lang.reflect.Type;

abstract class JsonDeserializationVisitor<T> implements ObjectNavigator.Visitor {
    protected boolean constructed = false;
    protected final JsonDeserializationContext context;
    protected final ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers;
    protected final ObjectNavigatorFactory factory;
    protected final JsonElement json;
    protected final ObjectConstructor objectConstructor;
    protected T target;
    protected final Type targetType;

    /* access modifiers changed from: protected */
    public abstract T constructTarget();

    public JsonDeserializationVisitor(JsonElement json2, Type targetType2, ObjectNavigatorFactory factory2, ObjectConstructor objectConstructor2, ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers2, JsonDeserializationContext context2) {
        Preconditions.checkNotNull(json2);
        this.targetType = targetType2;
        this.factory = factory2;
        this.objectConstructor = objectConstructor2;
        this.deserializers = deserializers2;
        this.json = json2;
        this.context = context2;
    }

    public T getTarget() {
        if (!this.constructed) {
            this.target = constructTarget();
            this.constructed = true;
        }
        return this.target;
    }

    public void start(ObjectTypePair node) {
    }

    public void end(ObjectTypePair node) {
    }

    public final boolean visitUsingCustomHandler(ObjectTypePair objTypePair) {
        Pair<JsonDeserializer<?>, ObjectTypePair> pair = objTypePair.getMatchingHandler(this.deserializers);
        if (pair == null) {
            return false;
        }
        this.target = invokeCustomDeserializer(this.json, pair);
        this.constructed = true;
        return true;
    }

    /* access modifiers changed from: protected */
    public Object invokeCustomDeserializer(JsonElement element, Pair<JsonDeserializer<?>, ObjectTypePair> pair) {
        if (element == null || element.isJsonNull()) {
            return null;
        }
        return ((JsonDeserializer) pair.first).deserialize(element, ((ObjectTypePair) pair.second).type, this.context);
    }

    /* access modifiers changed from: package-private */
    public final Object visitChildAsObject(Type childType, JsonElement jsonChild) {
        return visitChild(childType, new JsonObjectDeserializationVisitor<>(jsonChild, childType, this.factory, this.objectConstructor, this.deserializers, this.context));
    }

    /* access modifiers changed from: package-private */
    public final Object visitChildAsArray(Type childType, JsonArray jsonChild) {
        return visitChild(childType, new JsonArrayDeserializationVisitor<>(jsonChild.getAsJsonArray(), childType, this.factory, this.objectConstructor, this.deserializers, this.context));
    }

    private Object visitChild(Type type, JsonDeserializationVisitor<?> childVisitor) {
        this.factory.create(new ObjectTypePair((Object) null, type, false)).accept(childVisitor);
        return childVisitor.getTarget();
    }
}
