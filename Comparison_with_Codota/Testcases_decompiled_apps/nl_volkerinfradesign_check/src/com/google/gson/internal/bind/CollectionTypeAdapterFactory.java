package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    private final ConstructorConstructor f3763a;

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f3763a = constructorConstructor;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type collectionElementType = C$Gson$Types.getCollectionElementType(type, rawType);
        return new C0948a(gson, collectionElementType, gson.getAdapter(TypeToken.get(collectionElementType)), this.f3763a.get(typeToken));
    }

    /* renamed from: com.google.gson.internal.bind.CollectionTypeAdapterFactory$a */
    static final class C0948a<E> extends TypeAdapter<Collection<E>> {

        /* renamed from: a */
        private final TypeAdapter<E> f3764a;

        /* renamed from: b */
        private final ObjectConstructor<? extends Collection<E>> f3765b;

        public C0948a(Gson gson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            this.f3764a = new C1209hl(gson, typeAdapter, type);
            this.f3765b = objectConstructor;
        }

        /* renamed from: a */
        public Collection<E> read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection<E> collection = (Collection) this.f3765b.construct();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                collection.add(this.f3764a.read(jsonReader));
            }
            jsonReader.endArray();
            return collection;
        }

        /* renamed from: a */
        public void write(JsonWriter jsonWriter, Collection<E> collection) throws IOException {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (E write : collection) {
                this.f3764a.write(jsonWriter, write);
            }
            jsonWriter.endArray();
        }
    }
}
