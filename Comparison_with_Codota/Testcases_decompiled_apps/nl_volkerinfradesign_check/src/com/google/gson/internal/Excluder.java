package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();

    /* renamed from: a */
    private double f3681a = -1.0d;

    /* renamed from: b */
    private int f3682b = 136;

    /* renamed from: c */
    private boolean f3683c = true;

    /* renamed from: d */
    private boolean f3684d;

    /* renamed from: e */
    private List<ExclusionStrategy> f3685e = Collections.emptyList();

    /* renamed from: f */
    private List<ExclusionStrategy> f3686f = Collections.emptyList();

    /* access modifiers changed from: protected */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Excluder withVersion(double d) {
        Excluder clone = clone();
        clone.f3681a = d;
        return clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder clone = clone();
        clone.f3682b = 0;
        for (int i : iArr) {
            clone.f3682b = i | clone.f3682b;
        }
        return clone;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder clone = clone();
        clone.f3683c = false;
        return clone;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder clone = clone();
        clone.f3684d = true;
        return clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            clone.f3685e = new ArrayList(this.f3685e);
            clone.f3685e.add(exclusionStrategy);
        }
        if (z2) {
            clone.f3686f = new ArrayList(this.f3686f);
            clone.f3686f.add(exclusionStrategy);
        }
        return clone;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        final boolean excludeClass = excludeClass(rawType, true);
        final boolean excludeClass2 = excludeClass(rawType, false);
        if (!excludeClass && !excludeClass2) {
            return null;
        }
        final Gson gson2 = gson;
        final TypeToken<T> typeToken2 = typeToken;
        return new TypeAdapter<T>() {

            /* renamed from: f */
            private TypeAdapter<T> f3692f;

            public T read(JsonReader jsonReader) throws IOException {
                if (!excludeClass2) {
                    return m4294a().read(jsonReader);
                }
                jsonReader.skipValue();
                return null;
            }

            public void write(JsonWriter jsonWriter, T t) throws IOException {
                if (excludeClass) {
                    jsonWriter.nullValue();
                } else {
                    m4294a().write(jsonWriter, t);
                }
            }

            /* renamed from: a */
            private TypeAdapter<T> m4294a() {
                TypeAdapter<T> typeAdapter = this.f3692f;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                TypeAdapter<T> delegateAdapter = gson2.getDelegateAdapter(Excluder.this, typeToken2);
                this.f3692f = delegateAdapter;
                return delegateAdapter;
            }
        };
    }

    public boolean excludeField(Field field, boolean z) {
        Expose expose;
        if ((this.f3682b & field.getModifiers()) != 0) {
            return true;
        }
        if (this.f3681a != -1.0d && !m4289a((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.f3684d && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z ? !expose.deserialize() : !expose.serialize()))) {
            return true;
        }
        if (!this.f3683c && m4292b(field.getType())) {
            return true;
        }
        if (m4291a(field.getType())) {
            return true;
        }
        List<ExclusionStrategy> list = z ? this.f3685e : this.f3686f;
        if (!list.isEmpty()) {
            FieldAttributes fieldAttributes = new FieldAttributes(field);
            for (ExclusionStrategy shouldSkipField : list) {
                if (shouldSkipField.shouldSkipField(fieldAttributes)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        if (this.f3681a != -1.0d && !m4289a((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if (!this.f3683c && m4292b(cls)) {
            return true;
        }
        if (m4291a(cls)) {
            return true;
        }
        for (ExclusionStrategy shouldSkipClass : z ? this.f3685e : this.f3686f) {
            if (shouldSkipClass.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m4291a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    /* renamed from: b */
    private boolean m4292b(Class<?> cls) {
        return cls.isMemberClass() && !m4293c(cls);
    }

    /* renamed from: c */
    private boolean m4293c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* renamed from: a */
    private boolean m4289a(Since since, Until until) {
        return m4288a(since) && m4290a(until);
    }

    /* renamed from: a */
    private boolean m4288a(Since since) {
        if (since == null || since.value() <= this.f3681a) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m4290a(Until until) {
        if (until == null || until.value() > this.f3681a) {
            return true;
        }
        return false;
    }
}
