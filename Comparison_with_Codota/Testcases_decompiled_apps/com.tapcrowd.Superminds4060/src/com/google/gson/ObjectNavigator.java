package com.google.gson;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

final class ObjectNavigator {
    private final ExclusionStrategy exclusionStrategy;
    private final ObjectTypePair objTypePair;

    public interface Visitor {
        void end(ObjectTypePair objectTypePair);

        Object getTarget();

        void start(ObjectTypePair objectTypePair);

        void startVisitingObject(Object obj);

        void visitArray(Object obj, Type type);

        void visitArrayField(FieldAttributes fieldAttributes, Type type, Object obj);

        boolean visitFieldUsingCustomHandler(FieldAttributes fieldAttributes, Type type, Object obj);

        void visitObjectField(FieldAttributes fieldAttributes, Type type, Object obj);

        void visitPrimitive(Object obj);

        boolean visitUsingCustomHandler(ObjectTypePair objectTypePair);
    }

    ObjectNavigator(ObjectTypePair objTypePair2, ExclusionStrategy exclusionStrategy2) {
        Preconditions.checkNotNull(exclusionStrategy2);
        this.objTypePair = objTypePair2;
        this.exclusionStrategy = exclusionStrategy2;
    }

    public void accept(Visitor visitor) {
        Object objectToVisit;
        TypeInfo objTypeInfo = new TypeInfo(this.objTypePair.type);
        if (!this.exclusionStrategy.shouldSkipClass(objTypeInfo.getRawClass()) && !visitor.visitUsingCustomHandler(this.objTypePair)) {
            Object obj = this.objTypePair.getObject();
            if (obj == null) {
                objectToVisit = visitor.getTarget();
            } else {
                objectToVisit = obj;
            }
            if (objectToVisit != null) {
                this.objTypePair.setObject(objectToVisit);
                visitor.start(this.objTypePair);
                try {
                    if (objTypeInfo.isArray()) {
                        visitor.visitArray(objectToVisit, this.objTypePair.type);
                    } else if (objTypeInfo.getActualType() != Object.class || !isPrimitiveOrString(objectToVisit)) {
                        visitor.startVisitingObject(objectToVisit);
                        Class<?> curr = new TypeInfo(this.objTypePair.toMoreSpecificType().type).getRawClass();
                        while (curr != null && !curr.equals(Object.class)) {
                            if (!curr.isSynthetic()) {
                                navigateClassFields(objectToVisit, curr, visitor);
                            }
                            curr = curr.getSuperclass();
                        }
                    } else {
                        visitor.visitPrimitive(objectToVisit);
                        Object objectToVisit2 = visitor.getTarget();
                    }
                } finally {
                    visitor.end(this.objTypePair);
                }
            }
        }
    }

    private boolean isPrimitiveOrString(Object objectToVisit) {
        Class<?> realClazz = objectToVisit.getClass();
        return realClazz == Object.class || realClazz == String.class || Primitives.unwrap(realClazz).isPrimitive();
    }

    private void navigateClassFields(Object obj, Class<?> clazz, Visitor visitor) {
        Field[] fields = clazz.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        for (Field f : fields) {
            FieldAttributes fieldAttributes = new FieldAttributes(clazz, f);
            if (!this.exclusionStrategy.shouldSkipField(fieldAttributes) && !this.exclusionStrategy.shouldSkipClass(fieldAttributes.getDeclaredClass())) {
                TypeInfo fieldTypeInfo = TypeInfoFactory.getTypeInfoForField(f, this.objTypePair.type);
                Type declaredTypeOfField = fieldTypeInfo.getActualType();
                if (!visitor.visitFieldUsingCustomHandler(fieldAttributes, declaredTypeOfField, obj)) {
                    if (fieldTypeInfo.isArray()) {
                        visitor.visitArrayField(fieldAttributes, declaredTypeOfField, obj);
                    } else {
                        visitor.visitObjectField(fieldAttributes, declaredTypeOfField, obj);
                    }
                }
            }
        }
    }
}
