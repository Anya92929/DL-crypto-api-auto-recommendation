package p000;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: hk */
public final class C1206hk<T> extends TypeAdapter<T> {

    /* renamed from: a */
    private final JsonSerializer<T> f4269a;

    /* renamed from: b */
    private final JsonDeserializer<T> f4270b;

    /* renamed from: c */
    private final Gson f4271c;

    /* renamed from: d */
    private final TypeToken<T> f4272d;

    /* renamed from: e */
    private final TypeAdapterFactory f4273e;

    /* renamed from: f */
    private TypeAdapter<T> f4274f;

    private C1206hk(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this.f4269a = jsonSerializer;
        this.f4270b = jsonDeserializer;
        this.f4271c = gson;
        this.f4272d = typeToken;
        this.f4273e = typeAdapterFactory;
    }

    public T read(JsonReader jsonReader) throws IOException {
        if (this.f4270b == null) {
            return m5283a().read(jsonReader);
        }
        JsonElement parse = Streams.parse(jsonReader);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.f4270b.deserialize(parse, this.f4272d.getType(), this.f4271c.f3613a);
    }

    public void write(JsonWriter jsonWriter, T t) throws IOException {
        if (this.f4269a == null) {
            m5283a().write(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            Streams.write(this.f4269a.serialize(t, this.f4272d.getType(), this.f4271c.f3614b), jsonWriter);
        }
    }

    /* renamed from: a */
    private TypeAdapter<T> m5283a() {
        TypeAdapter<T> typeAdapter = this.f4274f;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.f4271c.getDelegateAdapter(this.f4273e, this.f4272d);
        this.f4274f = delegateAdapter;
        return delegateAdapter;
    }

    /* renamed from: a */
    public static TypeAdapterFactory m5284a(TypeToken<?> typeToken, Object obj) {
        return new C1208a(obj, typeToken, false, (Class) null);
    }

    /* renamed from: b */
    public static TypeAdapterFactory m5286b(TypeToken<?> typeToken, Object obj) {
        return new C1208a(obj, typeToken, typeToken.getType() == typeToken.getRawType(), (Class) null);
    }

    /* renamed from: a */
    public static TypeAdapterFactory m5285a(Class<?> cls, Object obj) {
        return new C1208a(obj, (TypeToken) null, false, cls);
    }

    /* renamed from: hk$a */
    static class C1208a implements TypeAdapterFactory {

        /* renamed from: a */
        private final TypeToken<?> f4275a;

        /* renamed from: b */
        private final boolean f4276b;

        /* renamed from: c */
        private final Class<?> f4277c;

        /* renamed from: d */
        private final JsonSerializer<?> f4278d;

        /* renamed from: e */
        private final JsonDeserializer<?> f4279e;

        private C1208a(Object obj, TypeToken<?> typeToken, boolean z, Class<?> cls) {
            JsonDeserializer<?> jsonDeserializer;
            this.f4278d = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            if (obj instanceof JsonDeserializer) {
                jsonDeserializer = (JsonDeserializer) obj;
            } else {
                jsonDeserializer = null;
            }
            this.f4279e = jsonDeserializer;
            C$Gson$Preconditions.checkArgument((this.f4278d == null && this.f4279e == null) ? false : true);
            this.f4275a = typeToken;
            this.f4276b = z;
            this.f4277c = cls;
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean isAssignableFrom;
            if (this.f4275a != null) {
                isAssignableFrom = this.f4275a.equals(typeToken) || (this.f4276b && this.f4275a.getType() == typeToken.getRawType());
            } else {
                isAssignableFrom = this.f4277c.isAssignableFrom(typeToken.getRawType());
            }
            if (isAssignableFrom) {
                return new C1206hk(this.f4278d, this.f4279e, gson, typeToken, this);
            }
            return null;
        }
    }
}
