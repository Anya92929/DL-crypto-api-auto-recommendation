package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

public final class FieldAttributes {

    /* renamed from: a */
    private final Field f3611a;

    public FieldAttributes(Field field) {
        C$Gson$Preconditions.checkNotNull(field);
        this.f3611a = field;
    }

    public Class<?> getDeclaringClass() {
        return this.f3611a.getDeclaringClass();
    }

    public String getName() {
        return this.f3611a.getName();
    }

    public Type getDeclaredType() {
        return this.f3611a.getGenericType();
    }

    public Class<?> getDeclaredClass() {
        return this.f3611a.getType();
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return this.f3611a.getAnnotation(cls);
    }

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.f3611a.getAnnotations());
    }

    public boolean hasModifier(int i) {
        return (this.f3611a.getModifiers() & i) != 0;
    }
}
