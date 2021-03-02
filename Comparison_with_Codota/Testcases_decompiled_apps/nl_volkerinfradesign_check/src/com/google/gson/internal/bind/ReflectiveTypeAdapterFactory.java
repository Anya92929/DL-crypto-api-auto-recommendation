package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    private final ConstructorConstructor f3786a;

    /* renamed from: b */
    private final FieldNamingStrategy f3787b;

    /* renamed from: c */
    private final Excluder f3788c;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder) {
        this.f3786a = constructorConstructor;
        this.f3787b = fieldNamingStrategy;
        this.f3788c = excluder;
    }

    public boolean excludeField(Field field, boolean z) {
        return !this.f3788c.excludeClass(field.getType(), z) && !this.f3788c.excludeField(field, z);
    }

    /* renamed from: a */
    private String m4352a(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        return serializedName == null ? this.f3787b.translateName(field) : serializedName.value();
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new Adapter(this.f3786a.get(typeToken), m4353a(gson, (TypeToken<?>) typeToken, (Class<?>) rawType));
    }

    /* renamed from: a */
    private C0956a m4351a(Gson gson, Field field, String str, TypeToken<?> typeToken, boolean z, boolean z2) {
        final boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        final Gson gson2 = gson;
        final Field field2 = field;
        final TypeToken<?> typeToken2 = typeToken;
        return new C0956a(str, z, z2) {

            /* renamed from: a */
            final TypeAdapter<?> f3789a = ReflectiveTypeAdapterFactory.this.m4349a(gson2, field2, (TypeToken<?>) typeToken2);

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo7648a(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                new C1209hl(gson2, this.f3789a, typeToken2.getType()).write(jsonWriter, field2.get(obj));
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo7647a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read = this.f3789a.read(jsonReader);
                if (read != null || !isPrimitive) {
                    field2.set(obj, read);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.m4338a(r2.f3786a, r3, r5, r0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.TypeAdapter<?> m4349a(com.google.gson.Gson r3, java.lang.reflect.Field r4, com.google.gson.reflect.TypeToken<?> r5) {
        /*
            r2 = this;
            java.lang.Class<com.google.gson.annotations.JsonAdapter> r0 = com.google.gson.annotations.JsonAdapter.class
            java.lang.annotation.Annotation r0 = r4.getAnnotation(r0)
            com.google.gson.annotations.JsonAdapter r0 = (com.google.gson.annotations.JsonAdapter) r0
            if (r0 == 0) goto L_0x0013
            com.google.gson.internal.ConstructorConstructor r1 = r2.f3786a
            com.google.gson.TypeAdapter r0 = com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.m4338a(r1, r3, r5, r0)
            if (r0 == 0) goto L_0x0013
        L_0x0012:
            return r0
        L_0x0013:
            com.google.gson.TypeAdapter r0 = r3.getAdapter(r5)
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.m4349a(com.google.gson.Gson, java.lang.reflect.Field, com.google.gson.reflect.TypeToken):com.google.gson.TypeAdapter");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: com.google.gson.reflect.TypeToken<?>} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r15v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.C0956a> m4353a(com.google.gson.Gson r13, com.google.gson.reflect.TypeToken<?> r14, java.lang.Class r15) {
        /*
            r12 = this;
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            boolean r0 = r15.isInterface()
            if (r0 == 0) goto L_0x000d
            r0 = r7
        L_0x000c:
            return r0
        L_0x000d:
            java.lang.reflect.Type r9 = r14.getType()
        L_0x0011:
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            if (r15 == r0) goto L_0x008e
            java.lang.reflect.Field[] r10 = r15.getDeclaredFields()
            int r11 = r10.length
            r0 = 0
            r8 = r0
        L_0x001c:
            if (r8 >= r11) goto L_0x0079
            r2 = r10[r8]
            r0 = 1
            boolean r5 = r12.excludeField(r2, r0)
            r0 = 0
            boolean r6 = r12.excludeField(r2, r0)
            if (r5 != 0) goto L_0x0032
            if (r6 != 0) goto L_0x0032
        L_0x002e:
            int r0 = r8 + 1
            r8 = r0
            goto L_0x001c
        L_0x0032:
            r0 = 1
            r2.setAccessible(r0)
            java.lang.reflect.Type r0 = r14.getType()
            java.lang.reflect.Type r1 = r2.getGenericType()
            java.lang.reflect.Type r0 = com.google.gson.internal.C$Gson$Types.resolve(r0, r15, r1)
            java.lang.String r3 = r12.m4352a(r2)
            com.google.gson.reflect.TypeToken r4 = com.google.gson.reflect.TypeToken.get((java.lang.reflect.Type) r0)
            r0 = r12
            r1 = r13
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$a r0 = r0.m4351a(r1, r2, r3, r4, r5, r6)
            java.lang.String r1 = r0.f3797g
            java.lang.Object r0 = r7.put(r1, r0)
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$a r0 = (com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.C0956a) r0
            if (r0 == 0) goto L_0x002e
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r3 = " declares multiple JSON fields named "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r0 = r0.f3797g
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0079:
            java.lang.reflect.Type r0 = r14.getType()
            java.lang.reflect.Type r1 = r15.getGenericSuperclass()
            java.lang.reflect.Type r0 = com.google.gson.internal.C$Gson$Types.resolve(r0, r15, r1)
            com.google.gson.reflect.TypeToken r14 = com.google.gson.reflect.TypeToken.get((java.lang.reflect.Type) r0)
            java.lang.Class r15 = r14.getRawType()
            goto L_0x0011
        L_0x008e:
            r0 = r7
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.m4353a(com.google.gson.Gson, com.google.gson.reflect.TypeToken, java.lang.Class):java.util.Map");
    }

    /* renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$a */
    static abstract class C0956a {

        /* renamed from: g */
        final String f3797g;

        /* renamed from: h */
        final boolean f3798h;

        /* renamed from: i */
        final boolean f3799i;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo7647a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo7648a(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        protected C0956a(String str, boolean z, boolean z2) {
            this.f3797g = str;
            this.f3798h = z;
            this.f3799i = z2;
        }
    }

    public static final class Adapter<T> extends TypeAdapter<T> {

        /* renamed from: a */
        private final ObjectConstructor<T> f3795a;

        /* renamed from: b */
        private final Map<String, C0956a> f3796b;

        private Adapter(ObjectConstructor<T> objectConstructor, Map<String, C0956a> map) {
            this.f3795a = objectConstructor;
            this.f3796b = map;
        }

        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.f3795a.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    C0956a aVar = this.f3796b.get(jsonReader.nextName());
                    if (aVar == null || !aVar.f3799i) {
                        jsonReader.skipValue();
                    } else {
                        aVar.mo7647a(jsonReader, (Object) construct);
                    }
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalStateException e) {
                throw new JsonSyntaxException((Throwable) e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (C0956a next : this.f3796b.values()) {
                    if (next.f3798h) {
                        jsonWriter.name(next.f3797g);
                        next.mo7648a(jsonWriter, (Object) t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }
    }
}
