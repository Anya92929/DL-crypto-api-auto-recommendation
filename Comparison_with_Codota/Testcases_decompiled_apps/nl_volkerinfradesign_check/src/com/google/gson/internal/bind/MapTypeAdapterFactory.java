package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    private final ConstructorConstructor f3778a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final boolean f3779b;

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z) {
        this.f3778a = constructorConstructor;
        this.f3779b = z;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Type[] mapKeyAndValueTypes = C$Gson$Types.getMapKeyAndValueTypes(type, C$Gson$Types.getRawType(type));
        TypeAdapter<?> a = m4344a(gson, mapKeyAndValueTypes[0]);
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(mapKeyAndValueTypes[1]));
        ObjectConstructor<T> objectConstructor = this.f3778a.get(typeToken);
        return new C0952a(gson, mapKeyAndValueTypes[0], a, mapKeyAndValueTypes[1], adapter, objectConstructor);
    }

    /* renamed from: a */
    private TypeAdapter<?> m4344a(Gson gson, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return TypeAdapters.BOOLEAN_AS_STRING;
        }
        return gson.getAdapter(TypeToken.get(type));
    }

    /* renamed from: com.google.gson.internal.bind.MapTypeAdapterFactory$a */
    final class C0952a<K, V> extends TypeAdapter<Map<K, V>> {

        /* renamed from: b */
        private final TypeAdapter<K> f3781b;

        /* renamed from: c */
        private final TypeAdapter<V> f3782c;

        /* renamed from: d */
        private final ObjectConstructor<? extends Map<K, V>> f3783d;

        public C0952a(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.f3781b = new C1209hl(gson, typeAdapter, type);
            this.f3782c = new C1209hl(gson, typeAdapter2, type2);
            this.f3783d = objectConstructor;
        }

        /* renamed from: a */
        public Map<K, V> read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map<K, V> map = (Map) this.f3783d.construct();
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    K read = this.f3781b.read(jsonReader);
                    if (map.put(read, this.f3782c.read(jsonReader)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                    jsonReader.endArray();
                }
                jsonReader.endArray();
                return map;
            }
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                K read2 = this.f3781b.read(jsonReader);
                if (map.put(read2, this.f3782c.read(jsonReader)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + read2);
                }
            }
            jsonReader.endObject();
            return map;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, Map<K, V> map) throws IOException {
            boolean z;
            int i = 0;
            if (map == null) {
                jsonWriter.nullValue();
            } else if (!MapTypeAdapterFactory.this.f3779b) {
                jsonWriter.beginObject();
                for (Map.Entry next : map.entrySet()) {
                    jsonWriter.name(String.valueOf(next.getKey()));
                    this.f3782c.write(jsonWriter, next.getValue());
                }
                jsonWriter.endObject();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z2 = false;
                for (Map.Entry next2 : map.entrySet()) {
                    JsonElement jsonTree = this.f3781b.toJsonTree(next2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(next2.getValue());
                    if (jsonTree.isJsonArray() || jsonTree.isJsonObject()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = z | z2;
                }
                if (z2) {
                    jsonWriter.beginArray();
                    while (i < arrayList.size()) {
                        jsonWriter.beginArray();
                        Streams.write((JsonElement) arrayList.get(i), jsonWriter);
                        this.f3782c.write(jsonWriter, arrayList2.get(i));
                        jsonWriter.endArray();
                        i++;
                    }
                    jsonWriter.endArray();
                    return;
                }
                jsonWriter.beginObject();
                while (i < arrayList.size()) {
                    jsonWriter.name(m4346a((JsonElement) arrayList.get(i)));
                    this.f3782c.write(jsonWriter, arrayList2.get(i));
                    i++;
                }
                jsonWriter.endObject();
            }
        }

        /* renamed from: a */
        private String m4346a(JsonElement jsonElement) {
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return String.valueOf(asJsonPrimitive.getAsNumber());
                }
                if (asJsonPrimitive.isBoolean()) {
                    return Boolean.toString(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.isString()) {
                    return asJsonPrimitive.getAsString();
                }
                throw new AssertionError();
            } else if (jsonElement.isJsonNull()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
