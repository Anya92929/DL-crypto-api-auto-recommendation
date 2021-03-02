package com.google.gson;

import com.google.gson.ObjectNavigator;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

final class JsonSerializationVisitor implements ObjectNavigator.Visitor {
    private final MemoryRefStack ancestors;
    private final JsonSerializationContext context;
    private final ObjectNavigatorFactory factory;
    private JsonElement root;
    private final boolean serializeNulls;
    private final ParameterizedTypeHandlerMap<JsonSerializer<?>> serializers;

    JsonSerializationVisitor(ObjectNavigatorFactory factory2, boolean serializeNulls2, ParameterizedTypeHandlerMap<JsonSerializer<?>> serializers2, JsonSerializationContext context2, MemoryRefStack ancestors2) {
        this.factory = factory2;
        this.serializeNulls = serializeNulls2;
        this.serializers = serializers2;
        this.context = context2;
        this.ancestors = ancestors2;
    }

    public Object getTarget() {
        return null;
    }

    public void start(ObjectTypePair node) {
        if (node != null) {
            if (this.ancestors.contains(node)) {
                throw new CircularReferenceException(node);
            }
            this.ancestors.push(node);
        }
    }

    public void end(ObjectTypePair node) {
        if (node != null) {
            this.ancestors.pop();
        }
    }

    public void startVisitingObject(Object node) {
        assignToRoot(new JsonObject());
    }

    public void visitArray(Object array, Type arrayType) {
        assignToRoot(new JsonArray());
        int length = Array.getLength(array);
        Type componentType = TypeInfoFactory.getTypeInfoForArray(arrayType).getSecondLevelType();
        for (int i = 0; i < length; i++) {
            addAsArrayElement(new ObjectTypePair(Array.get(array, i), componentType, false));
        }
    }

    public void visitArrayField(FieldAttributes f, Type typeOfF, Object obj) {
        try {
            if (!isFieldNull(f, obj)) {
                addAsChildOfObject(f, new ObjectTypePair(getFieldValue(f, obj), typeOfF, false));
            } else if (this.serializeNulls) {
                addChildAsElement(f, JsonNull.createJsonNull());
            }
        } catch (CircularReferenceException e) {
            throw e.createDetailedException(f);
        }
    }

    public void visitObjectField(FieldAttributes f, Type typeOfF, Object obj) {
        try {
            if (!isFieldNull(f, obj)) {
                addAsChildOfObject(f, new ObjectTypePair(getFieldValue(f, obj), typeOfF, false));
            } else if (this.serializeNulls) {
                addChildAsElement(f, JsonNull.createJsonNull());
            }
        } catch (CircularReferenceException e) {
            throw e.createDetailedException(f);
        }
    }

    public void visitPrimitive(Object obj) {
        assignToRoot(obj == null ? JsonNull.createJsonNull() : new JsonPrimitive(obj));
    }

    private void addAsChildOfObject(FieldAttributes f, ObjectTypePair fieldValuePair) {
        addChildAsElement(f, getJsonElementForChild(fieldValuePair));
    }

    private void addChildAsElement(FieldAttributes f, JsonElement childElement) {
        this.root.getAsJsonObject().add(this.factory.getFieldNamingPolicy().translateName(f), childElement);
    }

    private void addAsArrayElement(ObjectTypePair elementTypePair) {
        if (elementTypePair.getObject() == null) {
            this.root.getAsJsonArray().add(JsonNull.createJsonNull());
            return;
        }
        this.root.getAsJsonArray().add(getJsonElementForChild(elementTypePair));
    }

    private JsonElement getJsonElementForChild(ObjectTypePair fieldValueTypePair) {
        ObjectNavigator on = this.factory.create(fieldValueTypePair);
        JsonSerializationVisitor childVisitor = new JsonSerializationVisitor(this.factory, this.serializeNulls, this.serializers, this.context, this.ancestors);
        on.accept(childVisitor);
        return childVisitor.getJsonElement();
    }

    public boolean visitUsingCustomHandler(ObjectTypePair objTypePair) {
        try {
            if (objTypePair.getObject() != null) {
                JsonElement element = findAndInvokeCustomSerializer(objTypePair);
                if (element == null) {
                    return false;
                }
                assignToRoot(element);
                return true;
            } else if (!this.serializeNulls) {
                return true;
            } else {
                assignToRoot(JsonNull.createJsonNull());
                return true;
            }
        } catch (CircularReferenceException e) {
            throw e.createDetailedException((FieldAttributes) null);
        }
    }

    private JsonElement findAndInvokeCustomSerializer(ObjectTypePair objTypePair) {
        Pair<JsonSerializer<?>, ObjectTypePair> pair = objTypePair.getMatchingHandler(this.serializers);
        if (pair == null) {
            return null;
        }
        JsonSerializer serializer = (JsonSerializer) pair.first;
        ObjectTypePair objTypePair2 = pair.second;
        start(objTypePair2);
        try {
            JsonElement element = serializer.serialize(objTypePair2.getObject(), objTypePair2.getType(), this.context);
            if (element == null) {
                element = JsonNull.createJsonNull();
            }
            return element;
        } finally {
            end(objTypePair2);
        }
    }

    public boolean visitFieldUsingCustomHandler(FieldAttributes f, Type declaredTypeOfField, Object parent) {
        try {
            Preconditions.checkState(this.root.isJsonObject());
            Object obj = f.get(parent);
            if (obj != null) {
                JsonElement child = findAndInvokeCustomSerializer(new ObjectTypePair(obj, declaredTypeOfField, false));
                if (child == null) {
                    return false;
                }
                addChildAsElement(f, child);
                return true;
            } else if (!this.serializeNulls) {
                return true;
            } else {
                addChildAsElement(f, JsonNull.createJsonNull());
                return true;
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        } catch (CircularReferenceException e2) {
            throw e2.createDetailedException(f);
        }
    }

    private void assignToRoot(JsonElement newRoot) {
        Preconditions.checkNotNull(newRoot);
        this.root = newRoot;
    }

    private boolean isFieldNull(FieldAttributes f, Object obj) {
        return getFieldValue(f, obj) == null;
    }

    private Object getFieldValue(FieldAttributes f, Object obj) {
        try {
            return f.get(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonElement getJsonElement() {
        return this.root;
    }
}
