package com.google.gson;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class TypeInfoArray extends TypeInfo {
    private final Class<?> componentRawType;
    private final Type secondLevel;

    TypeInfoArray(Type type) {
        super(type);
        Class<?> rootComponentType = this.rawClass;
        while (rootComponentType.isArray()) {
            rootComponentType = rootComponentType.getComponentType();
        }
        this.componentRawType = rootComponentType;
        this.secondLevel = extractSecondLevelType(this.actualType, this.rawClass);
    }

    private static Type extractSecondLevelType(Type actualType, Class<?> rawClass) {
        return actualType instanceof GenericArrayType ? ((GenericArrayType) actualType).getGenericComponentType() : rawClass.getComponentType();
    }

    public Type getSecondLevelType() {
        return this.secondLevel;
    }

    public Class<?> getComponentRawType() {
        return this.componentRawType;
    }
}
