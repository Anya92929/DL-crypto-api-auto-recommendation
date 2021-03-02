package p000;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* renamed from: hl */
public final class C1209hl<T> extends TypeAdapter<T> {

    /* renamed from: a */
    private final Gson f4280a;

    /* renamed from: b */
    private final TypeAdapter<T> f4281b;

    /* renamed from: c */
    private final Type f4282c;

    public C1209hl(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f4280a = gson;
        this.f4281b = typeAdapter;
        this.f4282c = type;
    }

    public T read(JsonReader jsonReader) throws IOException {
        return this.f4281b.read(jsonReader);
    }

    public void write(JsonWriter jsonWriter, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.f4281b;
        Type a = m5287a(this.f4282c, t);
        if (a != this.f4282c) {
            typeAdapter = this.f4280a.getAdapter(TypeToken.get(a));
            if ((typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) && !(this.f4281b instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                typeAdapter = this.f4281b;
            }
        }
        typeAdapter.write(jsonWriter, t);
    }

    /* renamed from: a */
    private Type m5287a(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
            return obj.getClass();
        }
        return type;
    }
}
