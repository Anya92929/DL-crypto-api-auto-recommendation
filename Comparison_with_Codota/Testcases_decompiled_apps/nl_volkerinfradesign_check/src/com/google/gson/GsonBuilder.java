package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GsonBuilder {

    /* renamed from: a */
    private Excluder f3629a = Excluder.DEFAULT;

    /* renamed from: b */
    private LongSerializationPolicy f3630b = LongSerializationPolicy.DEFAULT;

    /* renamed from: c */
    private FieldNamingStrategy f3631c = FieldNamingPolicy.IDENTITY;

    /* renamed from: d */
    private final Map<Type, InstanceCreator<?>> f3632d = new HashMap();

    /* renamed from: e */
    private final List<TypeAdapterFactory> f3633e = new ArrayList();

    /* renamed from: f */
    private final List<TypeAdapterFactory> f3634f = new ArrayList();

    /* renamed from: g */
    private boolean f3635g;

    /* renamed from: h */
    private String f3636h;

    /* renamed from: i */
    private int f3637i = 2;

    /* renamed from: j */
    private int f3638j = 2;

    /* renamed from: k */
    private boolean f3639k;

    /* renamed from: l */
    private boolean f3640l;

    /* renamed from: m */
    private boolean f3641m = true;

    /* renamed from: n */
    private boolean f3642n;

    /* renamed from: o */
    private boolean f3643o;

    public GsonBuilder setVersion(double d) {
        this.f3629a = this.f3629a.withVersion(d);
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... iArr) {
        this.f3629a = this.f3629a.withModifiers(iArr);
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.f3643o = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.f3629a = this.f3629a.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.f3635g = true;
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.f3639k = true;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.f3629a = this.f3629a.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        this.f3630b = longSerializationPolicy;
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        this.f3631c = fieldNamingPolicy;
        return this;
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.f3631c = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... exclusionStrategyArr) {
        for (ExclusionStrategy withExclusionStrategy : exclusionStrategyArr) {
            this.f3629a = this.f3629a.withExclusionStrategy(withExclusionStrategy, true, true);
        }
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.f3629a = this.f3629a.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.f3629a = this.f3629a.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.f3642n = true;
        return this;
    }

    public GsonBuilder disableHtmlEscaping() {
        this.f3641m = false;
        return this;
    }

    public GsonBuilder setDateFormat(String str) {
        this.f3636h = str;
        return this;
    }

    public GsonBuilder setDateFormat(int i) {
        this.f3637i = i;
        this.f3636h = null;
        return this;
    }

    public GsonBuilder setDateFormat(int i, int i2) {
        this.f3637i = i;
        this.f3638j = i2;
        this.f3636h = null;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object obj) {
        C$Gson$Preconditions.checkArgument((obj instanceof JsonSerializer) || (obj instanceof JsonDeserializer) || (obj instanceof InstanceCreator) || (obj instanceof TypeAdapter));
        if (obj instanceof InstanceCreator) {
            this.f3632d.put(type, (InstanceCreator) obj);
        }
        if ((obj instanceof JsonSerializer) || (obj instanceof JsonDeserializer)) {
            this.f3633e.add(C1206hk.m5286b(TypeToken.get(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f3633e.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory typeAdapterFactory) {
        this.f3633e.add(typeAdapterFactory);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        C$Gson$Preconditions.checkArgument((obj instanceof JsonSerializer) || (obj instanceof JsonDeserializer) || (obj instanceof TypeAdapter));
        if ((obj instanceof JsonDeserializer) || (obj instanceof JsonSerializer)) {
            this.f3634f.add(0, C1206hk.m5285a(cls, obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f3633e.add(TypeAdapters.newTypeHierarchyFactory(cls, (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.f3640l = true;
        return this;
    }

    public Gson create() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f3633e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f3634f);
        m4268a(this.f3636h, this.f3637i, this.f3638j, arrayList);
        return new Gson(this.f3629a, this.f3631c, this.f3632d, this.f3635g, this.f3639k, this.f3643o, this.f3641m, this.f3642n, this.f3640l, this.f3630b, arrayList);
    }

    /* renamed from: a */
    private void m4268a(String str, int i, int i2, List<TypeAdapterFactory> list) {
        C1205hj hjVar;
        if (str != null && !"".equals(str.trim())) {
            hjVar = new C1205hj(str);
        } else if (i != 2 && i2 != 2) {
            hjVar = new C1205hj(i, i2);
        } else {
            return;
        }
        list.add(C1206hk.m5284a((TypeToken<?>) TypeToken.get(Date.class), (Object) hjVar));
        list.add(C1206hk.m5284a((TypeToken<?>) TypeToken.get(Timestamp.class), (Object) hjVar));
        list.add(C1206hk.m5284a((TypeToken<?>) TypeToken.get(java.sql.Date.class), (Object) hjVar));
    }
}
